DROP VIEW IF EXISTS vw_obo_building_subapplication;
CREATE VIEW vw_obo_building_subapplication AS 
SELECT 
   sa.objid,
   sa.appid,
   rt.title,
   wt.state AS task_state,
   wt.startdate AS task_startdate,
   wt.enddate AS task_enddate,
   wt.assignee_objid AS task_assignee_objid,
   wt.assignee_name AS task_assignee_name,
   wt.actor_objid AS task_actor_objid,
   wt.actor_name AS task_actor_name
FROM obo_building_subapplication sa
INNER JOIN obo_requirement_type rt ON sa.typeid = rt.objid
LEFT JOIN obo_building_application_workitem wi ON sa.workitemid = wi.objid  
LEFT JOIN obo_building_application_workitem_task wt ON wi.taskid = wt.taskid


