DROP VIEW IF EXISTS vw_building_permit_evaluation;
CREATE VIEW vw_building_permit_evaluation AS 
SELECT 
   a.*,
   et.title AS type_title,
   et.permitid,
   et.allowassessment,
   t.state AS task_state,
   t.startdate AS task_startdate,
   t.enddate AS task_enddate,
   t.assignee_objid AS task_assignee_objid,
   t.assignee_name AS task_assignee_name,
   t.actor_objid AS task_actor_objid,
   t.actor_name AS task_actor_name,
   (SELECT title FROM sys_wf_node WHERE processname = 'building_permit_evaluation' AND name=t.state) AS task_title
   
FROM building_permit_evaluation a 
INNER JOIN building_permit_evaluation_task t ON a.taskid = t.taskid
INNER JOIN obo_evaluation_type et ON a.typeid = et.objid