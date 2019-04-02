DROP VIEW IF EXISTS vw_obo_building_application_workitem;
CREATE VIEW vw_obo_building_application_workitem AS 
SELECT 
    wi.objid,
    oa.objid AS appid, 
    wi.taskid,
    oa.appno,
    oa.appdate,
    oa.apptype,
    oa.owner_objid,
    oa.owner_name,
    oa.owner_address_text,
    oa.owner_ctcid,
    oa.scope,
    oa.title,
    oa.description,
    oa.occupancytypeid,
    oa.numunits,
    oa.floorarea,
    oa.estimatedcost,
    oa.dtproposedconstruction,
    oa.dtexpectedcompletion,
    oa.projectcost,
    oa.supervisorid,
    wit.state AS task_state,
    wit.startdate AS task_startdate,
    wit.enddate AS task_enddate,
    wit.assignee_name AS task_assignee_name,
    wit.assignee_name AS task_assignee_objid,
    wit.actor_name AS task_actor_name,
    wit.actor_objid AS task_actor_objid,
    req.type AS workitem_type,
    req.objid AS workitem_objid,
    req.title AS workitem_title

FROM obo_building_application_workitem wi
INNER JOIN obo_building_application_workitem_task wit ON wi.taskid = wit.taskid
INNER JOIN obo_building_application oa ON wi.appid = oa.objid
INNER JOIN obo_requirement_type req ON wi.typeid = req.objid

