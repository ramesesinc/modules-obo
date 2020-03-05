
ALTER TABLE building_doc_type ADD COLUMN subtypeof varchar(50);
UPDATE building_doc_type SET subtypeof = 'FSEC' WHERE objiod='FSEC_CHECKLIST';

DROP VIEW IF EXISTS vw_building_application;
CREATE VIEW vw_building_application AS 
SELECT 
   a.*,
   bt.objid AS occupancytype_objid,
   bt.title AS occupancytype_title,   
   od.objid AS occupancytype_division_objid,
   od.title AS occupancytype_division_title,   
   og.objid AS occupancytype_group_objid,
   og.title AS occupancytype_group_title,   

   zc.objid AS zoneclass_objid,
   zc.title AS zoneclass_title,

   LTRIM(CONCAT(
      (CASE WHEN a.location_lotno IS NULL THEN '' ELSE CONCAT( ' Lot ', a.location_lotno) END),
      (CASE WHEN a.location_blockno IS NULL THEN '' ELSE CONCAT(' Blk ', a.location_blockno) END),
      (CASE WHEN a.location_unitno IS NULL THEN '' ELSE CONCAT(' ', a.location_unitno) END),
      (CASE WHEN a.location_bldgno IS NULL THEN '' ELSE CONCAT(' ', a.location_bldgno) END),
      (CASE WHEN a.location_bldgname IS NULL THEN '' ELSE CONCAT(' ', a.location_bldgname) END),
      (CASE WHEN a.location_street IS NULL THEN '' ELSE CONCAT(' ', a.location_street) END),
      (CASE WHEN a.location_subdivision IS NULL THEN '' ELSE CONCAT(', ', a.location_subdivision) END),      
      (CASE WHEN a.location_barangay_name IS NULL THEN '' ELSE CONCAT(', ', a.location_barangay_name ) END)
   )) AS location_address_text,

   t.state AS task_state,
   t.startdate AS task_startdate,
   t.enddate AS task_enddate,
   t.assignee_objid AS task_assignee_objid,
   t.assignee_name AS task_assignee_name,
   t.actor_objid AS task_actor_objid,
   t.actor_name AS task_actor_name,
   (SELECT title FROM sys_wf_node WHERE processname = 'building_application' AND name=t.state) AS task_title,

   pmt.permitno,
   pmt.expirydate,
   pmt.dtissued,
   pmt.issuedby_name,
   pmt.template 

FROM building_application a 
INNER JOIN building_application_task t ON a.taskid = t.taskid 
INNER JOIN obo_occupancy_type bt ON a.occupancytypeid = bt.objid 
INNER JOIN obo_occupancy_type_division od ON bt.divisionid = od.objid 
INNER JOIN obo_occupancy_type_group og ON od.groupid = og.objid 
LEFT JOIN obo_zoneclass zc ON a.zoneclassid = zc.objid 
LEFT JOIN building_permit pmt ON a.permitid=pmt.objid ;

DROP VIEW IF EXISTS vw_building_application_subdoc; 
CREATE VIEW vw_building_application_subdoc AS 
SELECT 
   bt.state AS appstate,
   a.*,
   iss.controlno,
   iss.dtissued,
   iss.expirydate,
   iss.issuedby_name,
   iss.issuedby_objid,
   iss.remarks AS issue_remarks,
   iss.template,
   iss.transmittalid  
FROM building_application_subdoc a  
LEFT JOIN building_issuance iss ON a.issuanceid = iss.objid 
INNER JOIN building_application ba ON a.appid = ba.objid 
LEFT JOIN building_application_task bt ON ba.taskid = bt.taskid ;

DROP VIEW IF EXISTS vw_building_application_fee_payment;
CREATE VIEW vw_building_application_fee_payment AS 
SELECT bf.*,
oi.objid AS item_objid,
oi.title AS item_title,
oi.sortorder AS item_sortorder,
pt.reftype AS payment_type,
pt.refno AS payment_refno,
pt.refid AS payment_refid,
pt.refdate AS payment_refdate 

FROM building_application_fee bf 
INNER JOIN obo_itemaccount oi ON bf.itemid = oi.objid 
LEFT JOIN building_application_payment pt ON bf.appid = pt.appid 
WHERE (pt.voided IS NULL OR pt.voided = 0);  

DROP VIEW IF EXISTS vw_building_permit;
CREATE VIEW vw_building_permit AS 
SELECT 
   pmt.*,

   a.appno,
   a.txnmode,
   a.apptype,
   a.dtfiled,   
   a.applicantid,
   a.description,
   a.title,
   a.occupancytypeid,
   a.numunits,
   a.fixedcost,
   a.projectcost,
   a.dtproposedconstruction,
   a.dtexpectedcompletion,
   a.totalfloorarea,
   a.height,
   a.numfloors,
   a.worktypes,
   a.zoneclassid,
   a.zone,
   a.location_lotno,
   a.location_blockno,
   a.location_street,
   a.location_barangay_name,
   a.location_barangay_objid,
   a.location_unitno,
   a.location_bldgno,
   a.location_bldgname,
   a.location_subdivision,
   a.contractorid,

   bt.objid AS occupancytype_objid,
   bt.title AS occupancytype_title,   
   od.objid AS occupancytype_division_objid,
   od.title AS occupancytype_division_title,   
   og.objid AS occupancytype_group_objid,
   og.title AS occupancytype_group_title,   

   zc.objid AS zoneclass_objid,
   zc.title AS zoneclass_title,

   LTRIM(CONCAT(
      (CASE WHEN a.location_lotno IS NULL THEN '' ELSE CONCAT( ' ', a.location_lotno) END),
      (CASE WHEN a.location_blockno IS NULL THEN '' ELSE CONCAT(' ', a.location_blockno) END),
      (CASE WHEN a.location_unitno IS NULL THEN '' ELSE CONCAT(' ', a.location_unitno) END),
      (CASE WHEN a.location_bldgno IS NULL THEN '' ELSE CONCAT(' ', a.location_bldgno) END),
      (CASE WHEN a.location_bldgname IS NULL THEN '' ELSE CONCAT(' ', a.location_bldgname) END),
      (CASE WHEN a.location_street IS NULL THEN '' ELSE CONCAT(' ', a.location_street) END),
      (CASE WHEN a.location_subdivision IS NULL THEN '' ELSE CONCAT(' ', a.location_subdivision) END),      
      (CASE WHEN a.location_barangay_name IS NULL THEN '' ELSE CONCAT(' ', a.location_barangay_name ) END)
   )) AS location_address_text 

FROM building_permit pmt 
INNER JOIN building_application a ON pmt.appid = a.objid 
INNER JOIN obo_occupancy_type bt ON a.occupancytypeid = bt.objid 
INNER JOIN obo_occupancy_type_division od ON bt.divisionid = od.objid 
INNER JOIN obo_occupancy_type_group og ON od.groupid = og.objid 
LEFT JOIN obo_zoneclass zc ON a.zoneclassid = zc.objid;

DROP VIEW IF EXISTS vw_building_doc_type;
CREATE VIEW vw_building_doc_type AS 
SELECT 
   a.*,
   bt.org_objid,
   bt.org_name   
FROM building_doc_type a 
LEFT JOIN building_evaluation_type bt ON a.evaltypeid = bt.objid ;

