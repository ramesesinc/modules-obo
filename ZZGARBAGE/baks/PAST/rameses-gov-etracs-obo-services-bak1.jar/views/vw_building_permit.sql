DROP VIEW IF EXISTS vw_building_permit;
CREATE VIEW vw_building_permit AS 
SELECT 
   a.*,
   e.name AS applicant_name,
   e.objid AS applicant_objid,
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
   )) AS location_address_text,

   t.state AS task_state,
   t.startdate AS task_startdate,
   t.enddate AS task_enddate,
   t.assignee_objid AS task_assignee_objid,
   t.assignee_name AS task_assignee_name,
   t.actor_objid AS task_actor_objid,
   t.actor_name AS task_actor_name,
   (SELECT title FROM sys_wf_node WHERE processname = 'building_permit' AND name=t.state) AS task_title

FROM building_permit a 
INNER JOIN building_permit_entity e ON a.applicantid = e.objid
INNER JOIN building_permit_task t ON a.taskid = t.taskid
INNER JOIN obo_occupancy_type bt ON a.occupancytypeid = bt.objid
INNER JOIN obo_occupancy_type_division od ON bt.divisionid = od.objid
INNER JOIN obo_occupancy_type_group og ON od.groupid = og.objid
LEFT JOIN obo_zoneclass zc ON a.zoneclassid = zc.objid

