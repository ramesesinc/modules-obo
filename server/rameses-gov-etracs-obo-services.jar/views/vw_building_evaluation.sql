DROP VIEW IF EXISTS vw_building_evaluation;
CREATE VIEW vw_building_evaluation AS 
SELECT 
   a.*,
   os.objid AS sectionid,
   os.org_objid AS org_objid,
   et.title AS type_title,
   et.sortindex AS type_sortindex,
   app.task_state AS app_task_state, 
   t.state AS task_state,
   t.dtcreated AS task_dtcreated,
   t.startdate AS task_startdate,
   t.enddate AS task_enddate,
   t.assignee_objid AS task_assignee_objid,
   t.assignee_name AS task_assignee_name,
   t.actor_objid AS task_actor_objid,
   t.actor_name AS task_actor_name,
   sn.title AS task_title,
   sn.tracktime AS task_tracktime

FROM building_evaluation a 
INNER JOIN building_evaluation_task t ON a.taskid = t.taskid 
INNER JOIN building_evaluation_type et ON a.typeid = et.objid 
LEFT JOIN obo_section os ON et.sectionid = os.objid
INNER JOIN sys_wf_node sn ON sn.processname = 'building_evaluation' AND sn.name = t.state 
INNER JOIN vw_building_application app ON a.appid = app.objid 