DROP VIEW IF EXISTS vw_obo_building_application;
CREATE VIEW vw_obo_building_application AS 
SELECT 
   a.*,
   ot.objid AS occupancytype_division,
   ot.parentid AS occupancytype_group,
   t.state AS task_state,
   t.startdate AS task_startdate,
   t.enddate AS task_enddate,
   t.assignee_objid AS task_assignee_objid,
   t.assignee_name AS task_assignee_name,
   t.actor_objid AS task_actor_objid,
   t.actor_name AS task_actor_name,
   (SELECT title FROM sys_wf_node WHERE processname = 'obo_application' AND name=t.state) AS task_title,
   bt.objid AS bldgtype_objid,
   bt.title AS bldgtype_title
   
FROM obo_building_application a 
INNER JOIN obo_building_application_task t ON a.taskid = t.taskid
INNER JOIN obo_building_type bt ON a.bldgtypeid = bt.objid
LEFT JOIN obo_occupancy_type ot ON a.occupancytypeid = ot.objid