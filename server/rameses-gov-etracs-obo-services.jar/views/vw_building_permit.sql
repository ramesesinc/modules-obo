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

   rpu.lotno AS location_lotno,
   rpu.blockno AS location_blockno,
   rpu.street AS location_street,
   rpu.barangay AS location_barangay,

   CONCAT(
      (CASE WHEN rpu.lotno IS NULL THEN '' ELSE CONCAT( 'Lot No. ', rpu.lotno) END),
      (CASE WHEN rpu.blockno IS NULL THEN '' ELSE CONCAT(' Block No', rpu.blockno) END),
      (CASE WHEN rpu.street IS NULL THEN '' ELSE CONCAT(' ', rpu.street) END),
      (CASE WHEN rpu.barangay IS NULL THEN '' ELSE CONCAT(' ', rpu.barangay) END)
   ) AS location_address_text,

   t.state AS task_state,
   t.startdate AS task_startdate,
   t.enddate AS task_enddate,
   t.assignee_objid AS task_assignee_objid,
   t.assignee_name AS task_assignee_name,
   t.actor_objid AS task_actor_objid,
   t.actor_name AS task_actor_name,
   (SELECT title FROM sys_wf_node WHERE processname = 'building_permit' AND name=t.state) AS task_title,

   p.objid AS issuance_objid,
   p.controlno AS issuance_controlno,
   p.dtissued AS issuance_dtissued

FROM building_permit a 
INNER JOIN building_permit_entity e ON a.applicantid = e.objid
INNER JOIN building_permit_task t ON a.taskid = t.taskid
INNER JOIN building_permit_rpu rpu ON a.locationid = rpu.objid
INNER JOIN obo_occupancy_type bt ON a.occupancytypeid = bt.objid
INNER JOIN obo_occupancy_type_division od ON bt.divisionid = od.objid
INNER JOIN obo_occupancy_type_group og ON od.groupid = og.objid
LEFT JOIN obo_zoneclass zc ON a.zoneclassid = zc.objid
LEFT JOIN building_permit_issuance p ON a.issuanceid = p.objid 
