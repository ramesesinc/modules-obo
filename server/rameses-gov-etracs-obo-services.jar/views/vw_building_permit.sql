DROP VIEW IF EXISTS vw_building_permit;
CREATE VIEW vw_building_permit AS 
SELECT 
   pmt.*,

   a.appno,
   a.txnmode,
   a.apptype,
   a.appdate,   
   a.contact_name,  
   a.contact_detail,
   a.contact_email,
   a.contact_mobileno,
   a.txntype,

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
   a.contractorid,
   a.location_unitno,
   a.location_bldgno,
   a.location_bldgname,
   a.location_subdivision,
   a.createdby_objid,
   a.createdby_name,
   a.dtcreated,
   

   ae.name AS applicant_name,

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
   )) AS location_text,

   at.taskid AS taskid,
   at.state AS task_state

FROM building_permit pmt 
INNER JOIN building_application a ON pmt.appid = a.objid
INNER JOIN building_application_entity ae ON a.applicantid = ae.objid
INNER JOIN building_application_task at ON a.taskid=at.taskid

INNER JOIN obo_occupancy_type bt ON a.occupancytypeid = bt.objid
INNER JOIN obo_occupancy_type_division od ON bt.divisionid = od.objid
INNER JOIN obo_occupancy_type_group og ON od.groupid = og.objid
LEFT JOIN obo_zoneclass zc ON a.zoneclassid = zc.objid

WHERE at.state = 'end'



