DROP VIEW IF EXISTS vw_occupancy_permit_section;
CREATE VIEW vw_occupancy_permit_section AS 
SELECT 
   a.*,
   et.title AS type_title,
   et.sortindex AS type_sortindex,
   et.requirefee AS type_requirefee,

   app.task_state AS app_task_state, 

   t.state AS task_state,
   t.startdate AS task_startdate,
   t.enddate AS task_enddate,
   t.assignee_objid AS task_assignee_objid,
   t.assignee_name AS task_assignee_name,
   t.actor_objid AS task_actor_objid,
   t.actor_name AS task_actor_name,
   (SELECT title FROM sys_wf_node WHERE processname = 'occupancy_permit_section' AND name=t.state) AS task_title

FROM occupancy_permit_section a 
INNER JOIN occupancy_permit_section_task t ON a.taskid = t.taskid
INNER JOIN obo_section et ON a.typeid = et.objid
INNER JOIN vw_occupancy_permit app ON a.appid = app.objid