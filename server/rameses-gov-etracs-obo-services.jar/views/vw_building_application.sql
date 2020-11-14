DROP VIEW IF EXISTS vw_building_application;
CREATE VIEW vw_building_application AS 
SELECT 
   a.*,
   bi.applicantid,
   bi.description,
   bi.title,
   bi.occupancytypeid,
   bi.numunits,
   bi.fixedcost,
   bi.projectcost,
   bi.dtproposedconstruction,
   bi.dtexpectedcompletion,
   bi.totalfloorarea,
   bi.height,
   bi.numfloors,
   bi.worktypes,
   bi.zoneclassid,
   bi.zone,
   bi.location_lotno,
   bi.location_blockno,
   bi.location_street,
   bi.location_barangay_name,
   bi.location_barangay_objid,
   bi.contractorid,
   bi.location_unitno,
   bi.location_bldgno,
   bi.location_bldgname,
   bi.location_subdivision,
   bi.createdby_objid,
   bi.createdby_name,
   bi.dtcreated,

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
      (CASE WHEN bi.location_lotno IS NULL THEN '' ELSE CONCAT( ' Lot ', bi.location_lotno) END),
      (CASE WHEN bi.location_blockno IS NULL THEN '' ELSE CONCAT(' Blk ', bi.location_blockno) END),
      (CASE WHEN bi.location_unitno IS NULL THEN '' ELSE CONCAT(' ', bi.location_unitno) END),
      (CASE WHEN bi.location_bldgno IS NULL THEN '' ELSE CONCAT(' ', bi.location_bldgno) END),
      (CASE WHEN bi.location_bldgname IS NULL THEN '' ELSE CONCAT(' ', bi.location_bldgname) END),
      (CASE WHEN bi.location_street IS NULL THEN '' ELSE CONCAT(' ', bi.location_street) END),
      (CASE WHEN bi.location_subdivision IS NULL THEN '' ELSE CONCAT(', ', bi.location_subdivision) END),      
      (CASE WHEN bi.location_barangay_name IS NULL THEN '' ELSE CONCAT(', ', bi.location_barangay_name ) END)
   )) AS location_text,

   t.state AS task_state,
   t.dtcreated AS task_dtcreated,
   t.startdate AS task_startdate,
   t.enddate AS task_enddate,
   t.assignee_objid AS task_assignee_objid,
   t.assignee_name AS task_assignee_name,
   t.actor_objid AS task_actor_objid,
   t.actor_name AS task_actor_name,
   sn.title AS task_title,
   sn.tracktime AS task_tracktime,
   pmt.controlno,
   pmt.expirydate,
   pmt.dtissued,
   pmt.issuedby_name,
   pmt.approverid,
   pmt.endorserid,
   pmt.template,
   pmt.reportheader 

FROM building_application a 
INNER JOIN building_info bi ON a.infoid = bi.objid
INNER JOIN building_application_entity ae ON bi.applicantid = ae.objid
INNER JOIN building_application_task t ON a.taskid = t.taskid 
INNER JOIN sys_wf_node sn ON sn.processname = 'building_application' AND sn.name = t.state 
INNER JOIN obo_occupancy_type bt ON bi.occupancytypeid = bt.objid 
INNER JOIN obo_occupancy_type_division od ON bt.divisionid = od.objid 
INNER JOIN obo_occupancy_type_group og ON od.groupid = og.objid 
LEFT JOIN obo_zoneclass zc ON bi.zoneclassid = zc.objid 
LEFT JOIN building_permit pmt ON a.issuanceid=pmt.objid 

