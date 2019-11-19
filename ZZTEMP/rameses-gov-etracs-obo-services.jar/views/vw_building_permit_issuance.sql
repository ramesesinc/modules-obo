DROP VIEW  IF EXISTS vw_building_permit_issuance;
CREATE VIEW vw_building_permit_issuance AS 
SELECT 
   bp.appno, 
   bp.title,
   bi.*,
   ot.title AS type_title,
   ot.controlnopattern AS type_controlnopattern,
   ot.template AS type_template,
   t.state AS task_state,
   t.startdate AS task_startdate,
   t.enddate AS task_enddate,
   t.assignee_objid AS task_assignee_objid,
   t.assignee_name AS task_assignee_name,
   t.actor_objid AS task_actor_objid,
   t.actor_name AS task_actor_name,
   (SELECT title FROM sys_wf_node WHERE processname = 'building_permit_issuance' AND name=t.state) AS task_title,
   os.org_objid,
   os.org_name,
   ot.sectionid 
FROM building_permit_issuance bi
INNER JOIN obo_issuance_type ot ON bi.typeid = ot.objid
INNER JOIN building_permit_issuance_task t ON bi.taskid = t.taskid 
INNER JOIN building_permit bp ON bi.appid = bp.objid 
LEFT JOIN obo_section os ON ot.sectionid=os.objid
