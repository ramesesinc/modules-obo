SET FOREIGN_KEY_CHECKS = 0;

INSERT INTO obo_legazpi.building_application
(objid,appno,orgcode,trackingno,apptype,permittype,contact_name,contact_detail,contact_email,contact_mobileno,dtfiled,applicantid,description,title,occupancytypeid,numunits,fixedcost,projectcost,dtproposedconstruction,dtexpectedcompletion,totalfloorarea,height,numfloors,worktypes,taskid,zoneclassid,zone,amount,txnmode,location_lotno,location_blockno,location_street,location_barangay_name,location_barangay_objid,accessoryid,contractorid,location_unitno,location_bldgno,location_bldgname,location_subdivision)

SELECT 
objid,appno,orgcode,trackingno,apptype,permittype,contact_name,contact_detail,contact_email,contact_mobileno,dtfiled,applicantid,description,title,occupancytypeid,numunits,fixedcost,projectcost,dtproposedconstruction,dtexpectedcompletion,totalfloorarea,height,numfloors,worktypes,taskid,zoneclassid,zone,amount,txnmode,location_lotno,location_blockno,location_street,location_barangay_name,location_barangay_objid,accessoryid,contractorid,location_unitno,location_bldgno,location_bldgname,location_subdivision 
FROM tmp_obo_legazpi.building_permit;

INSERT INTO obo_legazpi.building_application_task SELECT * FROM  tmp_obo_legazpi.building_permit_task;


INSERT INTO obo_legazpi.building_application_entity SELECT * FROM  tmp_obo_legazpi.building_permit_entity;
INSERT INTO obo_legazpi.building_application_professional SELECT * FROM  tmp_obo_legazpi.building_permit_professional;
INSERT INTO obo_legazpi.building_application_ancillary SELECT * FROM  tmp_obo_legazpi.building_permit_ancillary;
INSERT INTO obo_legazpi.building_application_rpu SELECT * FROM  tmp_obo_legazpi.building_permit_rpu;
INSERT INTO obo_legazpi.building_application_requirement SELECT * FROM  tmp_obo_legazpi.building_permit_requirement;
INSERT INTO obo_legazpi.building_application_info SELECT * FROM  tmp_obo_legazpi.building_permit_info;

INSERT INTO obo_legazpi.building_application_accessory SELECT * FROM  tmp_obo_legazpi.building_permit_accessory;
INSERT INTO obo_legazpi.building_application_fee SELECT * FROM  tmp_obo_legazpi.building_permit_fee;

INSERT INTO obo_legazpi.building_application_finding SELECT * FROM  tmp_obo_legazpi.building_permit_finding;

INSERT INTO obo_legazpi.building_application_section SELECT * FROM  tmp_obo_legazpi.building_permit_section;
INSERT INTO obo_legazpi.building_application_section_task SELECT * FROM  tmp_obo_legazpi.building_permit_section_task;

INSERT INTO obo_legazpi.building_application_transmittal SELECT * FROM  tmp_obo_legazpi.building_permit_transmittal;

INSERT INTO obo_legazpi.fire_safety_checklist
(objid,appid,controlno,dtissued,issuedby_objid,issuedby_name,state,remarks)
SELECT objid,appid,controlno,dtcreated,createdby_objid,createdby_name,state,remarks 
FROM tmp_obo_legazpi.fire_safety_checklist;

INSERT INTO obo_legazpi.fire_safety_checklist_item SELECT * FROM tmp_obo_legazpi.fire_safety_checklist_item;

INSERT INTO obo_legazpi.fire_safety_evaluation_clearance 
(objid,appid,controlno,dtissued,issuedby_objid,issuedby_name,state,remarks)
SELECT objid,appid,controlno,dtcreated,createdby_objid,createdby_name,state,remarks FROM tmp_obo_legazpi.fire_safety_evaluation_clearance; 

INSERT INTO obo_legazpi.locational_clearance 
(objid,appid,controlno,dtissued,issuedby_objid,issuedby_name,state,expirydate,remarks)
SELECT objid,appid,controlno,dtcreated,createdby_objid,createdby_name,state,dtvalidity,remarks FROM tmp_obo_legazpi.locational_clearance;

UPDATE building_application_task SET state = 'releasing' WHERE state='issuance-process';
UPDATE building_application_section_task SET state = 'end' WHERE state = 'releasing';
UPDATE building_application_section_task SET state = 'end' WHERE state = 'final-approval';


SET FOREIGN_KEY_CHECKS = 1;


## FIX building_application_section_task
CREATE TABLE `zz_section_task_for_revision` (
  `taskid` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`taskid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `zz_section_task_for_end` (
  `taskid` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`taskid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DELETE FROM zz_section_task_for_revision;
DELETE FROM zz_section_task_for_end;

INSERT INTO zz_section_task_for_revision (taskid)
select bt.taskid from building_application_section_task bt 
inner join building_application_section bs ON bs.taskid = bt.taskid 
inner join building_application ba ON ba.objid = bs.appid 
inner join building_application_task bat ON ba.taskid = bat.taskid 
where bat.state in ('zoning-evaluation-revision') 
AND bs.typeid = 'zoning'
and bt.state = 'obo-processing'; 

INSERT INTO zz_section_task_for_end (taskid)
select bt.taskid from building_application_section_task bt 
inner join building_application_section bs ON bs.taskid = bt.taskid 
inner join building_application ba ON ba.objid = bs.appid 
inner join building_application_task bat ON ba.taskid = bat.taskid 
where bat.state not in ('zoning-evaluation-revision') 
AND bs.typeid = 'zoning'
AND bt.state = 'obo-processing'; 


INSERT INTO zz_section_task_for_revision (taskid)
select bt.taskid from building_application_section_task bt 
inner join building_application_section bs ON bs.taskid = bt.taskid 
inner join building_application ba ON ba.objid = bs.appid 
inner join building_application_task bat ON ba.taskid = bat.taskid 
where bat.state in ('trade-evaluation', 'trade-evaluation-revision') 
and bt.state = 'obo-processing' 
AND bs.typeid <> 'zoning'
and bs.objid in (SELECT parentid from building_application_finding where supersederid is null);

INSERT INTO zz_section_task_for_end (taskid)
select bt.taskid from building_application_section_task bt 
inner join building_application_section bs ON bs.taskid = bt.taskid 
inner join building_application ba ON ba.objid = bs.appid 
inner join building_application_task bat ON ba.taskid = bat.taskid 
where bat.state in ('trade-evaluation', 'trade-evaluation-revision') 
and bt.state = 'obo-processing' 
AND bs.typeid <> 'zoning'
and bs.objid not in (SELECT parentid from building_application_finding where supersederid is null);

UPDATE building_application_section_task 
set state = 'end' where taskid in (select taskid FROM zz_section_task_for_end);
UPDATE building_application_section_task 
set state = 'for-revision' where taskid in (select taskid FROM zz_section_task_for_revision);


DROP TABLE zz_section_task_for_revision;
DROP TABLE zz_section_task_for_end;

