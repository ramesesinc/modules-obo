DROP VIEW IF EXISTS vw_building_permit_section;
CREATE VIEW vw_building_permit_section AS 
SELECT 
   a.*,
   et.title AS type_title,
   t.state AS task_state,
   t.startdate AS task_startdate,
   t.enddate AS task_enddate,
   t.assignee_objid AS task_assignee_objid,
   t.assignee_name AS task_assignee_name,
   t.actor_objid AS task_actor_objid,
   t.actor_name AS task_actor_name,
   (SELECT title FROM sys_wf_node WHERE processname = 'building_permit_section' AND name=t.state) AS task_title,
   p.objid AS issuance_objid,
   p.controlno AS issuance_controlno,
   p.dtissued AS issuance_dtissued,
   p.typeid AS issuance_typeid

   
FROM building_permit_section a 
INNER JOIN building_permit_section_task t ON a.taskid = t.taskid
INNER JOIN obo_section et ON a.typeid = et.objid
LEFT JOIN building_permit_issuance p ON a.issuanceid = p.objid
  
