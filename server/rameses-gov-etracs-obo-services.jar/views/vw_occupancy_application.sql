DROP VIEW IF EXISTS vw_occupancy_application;
CREATE VIEW vw_occupancy_application AS 
SELECT 
   op.*,
   t.state AS task_state,
   t.startdate AS task_startdate,
   t.enddate AS task_enddate,
   t.assignee_objid AS task_assignee_objid,
   t.assignee_name AS task_assignee_name,
   t.actor_objid AS task_actor_objid,
   t.actor_name AS task_actor_name,
   (SELECT title FROM sys_wf_node WHERE processname = 'occupancy_application' AND name=t.state) AS task_title,
   ot.objid AS occupancytype_objid,
   ot.title AS occupancytype_title,   
   od.objid AS occupancytype_division_objid,
   od.title AS occupancytype_division_title,   
   og.objid AS occupancytype_group_objid,
   og.title AS occupancytype_group_title


FROM occupancy_application op 
INNER JOIN occupancy_application_task t ON op.taskid = t.taskid
INNER JOIN obo_occupancy_type ot ON op.occupancytypeid = ot.objid 
INNER JOIN obo_occupancy_type_division od ON ot.divisionid = od.objid 
INNER JOIN obo_occupancy_type_group og ON od.groupid = og.objid 



