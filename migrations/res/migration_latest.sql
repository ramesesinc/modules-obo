SET FOREIGN_KEY_CHECKS = 0;

INSERT INTO obo_legazpi_backup_new.building_application
(objid,appno,orgcode,trackingno,apptype,permittype,contact_name,contact_detail,contact_email,contact_mobileno,dtfiled,applicantid,description,title,occupancytypeid,numunits,fixedcost,projectcost,dtproposedconstruction,dtexpectedcompletion,totalfloorarea,height,numfloors,worktypes,taskid,zoneclassid,zone,amount,txnmode,location_lotno,location_blockno,location_street,location_barangay_name,location_barangay_objid,accessoryid,contractorid,location_unitno,location_bldgno,location_bldgname,location_subdivision)
SELECT 
objid,appno,orgcode,trackingno,apptype,permittype,contact_name,contact_detail,contact_email,contact_mobileno,dtfiled,applicantid,description,title,occupancytypeid,numunits,fixedcost,projectcost,dtproposedconstruction,dtexpectedcompletion,totalfloorarea,height,numfloors,worktypes,taskid,zoneclassid,zone,amount,txnmode,location_lotno,location_blockno,location_street,location_barangay_name,location_barangay_objid,accessoryid,contractorid,location_unitno,location_bldgno,location_bldgname,location_subdivision 
FROM tmp_obo_legazpi.building_permit;

INSERT INTO obo_legazpi_backup_new.building_application_task SELECT * FROM  tmp_obo_legazpi.building_permit_task;

INSERT INTO obo_legazpi_backup_new.building_application_transmittal SELECT * FROM  tmp_obo_legazpi.building_permit_transmittal;

INSERT INTO obo_legazpi_backup_new.building_application_entity SELECT * FROM  tmp_obo_legazpi.building_permit_entity;
INSERT INTO obo_legazpi_backup_new.building_application_professional SELECT * FROM  tmp_obo_legazpi.building_permit_professional;
INSERT INTO obo_legazpi_backup_new.building_application_rpu SELECT * FROM  tmp_obo_legazpi.building_permit_rpu;
INSERT INTO obo_legazpi_backup_new.building_application_requirement SELECT * FROM  tmp_obo_legazpi.building_permit_requirement;


[building_application_subdoc]
INSERT INTO obo_legazpi_backup_new.building_application_subdoc ( objid, appid, doctypeid, 
state, designprofessionalid, supervisorid, worktypes, amount )
SELECT a.*, b.amount 
FROM 
(SELECT objid, appid, UPPER(permittypeid) AS doctypeid, 0 AS state, designprofessionalid, supervisorid, worktypes
FROM tmp_obo_legazpi.building_permit_ancillary) a
LEFT JOIN ( SELECT appid, sectionid, SUM(amount) AS amount 
FROM tmp_obo_legazpi.building_permit_fee GROUP BY appid, sectionid) b ON a.appid =  b.appid AND a.doctypeid = b.sectionid 
UNION ALL 
SELECT a.*, b.amount 
FROM
(SELECT objid, appid, typeid AS doctypeid, 0 AS state, NULL AS designprofessionalid, NULL AS supervisorid, '[]' AS worktypes  
FROM tmp_obo_legazpi.building_permit_section WHERE typeid NOT IN 
(SELECT UPPER(permittypeid) FROM tmp_obo_legazpi.building_permit_ancillary)) a 
LEFT JOIN ( SELECT appid, sectionid, SUM(amount) AS amount 
FROM tmp_obo_legazpi.building_permit_fee GROUP BY appid, sectionid) b ON a.appid =  b.appid AND a.doctypeid = b.sectionid;

[accessories]
INSERT INTO obo_legazpi_backup_new.building_application_subdoc 
( objid, appid, doctypeid, occupancytypeid, state, worktypes, amount )
SELECT objid, appid, 'ACCESSORIES', occupancytypeid, 0, '[]', 0 
FROM  tmp_obo_legazpi.building_permit_accessory



[building_application_fee]
INSERT INTO obo_legazpi_backup_new.building_application_fee (objid,appid,parentid,itemid,amount,amtpaid,remarks)
SELECT bf.objid,bf.appid,ba.objid AS parentid,bf.itemid,bf.amount,bf.amtpaid,bf.remarks 
FROM tmp_obo_legazpi.building_permit_fee bf
INNER JOIN tmp_obo_legazpi.building_permit_ancillary ba ON bf.appid=ba.appid AND bf.sectionid = ba.permittypeid 
UNION
SELECT  bf.objid,bf.appid,bs.objid AS parentid,bf.itemid,bf.amount,bf.amtpaid,bf.remarks 
FROM tmp_obo_legazpi.building_permit_fee bf
INNER JOIN tmp_obo_legazpi.building_permit_section bs ON bf.appid=bs.appid AND bf.sectionid = bs.typeid 
WHERE CONCAT( bs.appid, '-', bs.typeid ) NOT IN ( SELECT CONCAT(appid,'-',UPPER(permittypeid)) 
	FROM tmp_obo_legazpi.building_permit_ancillary ) 
UNION
SELECT  bf.objid,bf.appid,NULL AS parentid,bf.itemid,bf.amount,bf.amtpaid,bf.remarks 
FROM tmp_obo_legazpi.building_permit_fee bf WHERE bf.sectionid IS NULL;

INSERT INTO obo_legazpi_backup_new.building_application_info SELECT * FROM  tmp_obo_legazpi.building_permit_info;

INSERT INTO obo_legazpi_backup_new.building_evaluation (objid,appid,typeid,taskid) 
SELECT objid,appid,typeid,taskid FROM tmp_obo_legazpi.building_permit_section;

INSERT INTO obo_legazpi_backup_new.building_evaluation_task SELECT * FROM  tmp_obo_legazpi.building_permit_section_task;

INSERT INTO obo_legazpi_backup_new.building_evaluation_finding SELECT * FROM  tmp_obo_legazpi.building_permit_finding;

UPDATE obo_legazpi_backup_new.building_application_task SET state = 'releasing' WHERE state='issuance-process';
UPDATE obo_legazpi_backup_new.building_evaluation_task SET state = 'obo-processing' WHERE state = 'final-approval';

UPDATE obo_legazpi_backup_new.building_application_subdoc SET doctypeid = 'LOCATIONAL_CLEARANCE' WHERE doctypeid = 'ZONING'
SET FOREIGN_KEY_CHECKS = 1;

