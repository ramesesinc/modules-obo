DROP VIEW IF EXISTS vw_building_application_section;
CREATE VIEW vw_building_application_section AS 
SELECT 
   a.*,
   et.title AS type_title,
   et.sortindex AS type_sortindex,
   et.requirefee AS type_requirefee,
   et.permitid AS type_permitid,

   app.task_state AS app_task_state, 

   t.state AS task_state,
   t.startdate AS task_startdate,
   t.enddate AS task_enddate,
   t.assignee_objid AS task_assignee_objid,
   t.assignee_name AS task_assignee_name,
   t.actor_objid AS task_actor_objid,
   t.actor_name AS task_actor_name,
   (SELECT title FROM sys_wf_node WHERE processname = 'building_application_section' AND name=t.state) AS task_title

   
FROM building_application_section a 
INNER JOIN building_application_section_task t ON a.taskid = t.taskid
INNER JOIN building_permit_section_type et ON a.typeid = et.objid
INNER JOIN vw_building_application app ON a.appid = app.objid