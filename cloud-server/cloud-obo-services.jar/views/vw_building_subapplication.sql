<!--
  -- req.type AS workitem_type,
    -- req.objid AS workitem_objid,
    -- req.title AS workitem_title,
    
    -- (SELECT wt.dtcreated FROM obo_building_application_workitem_task wt WHERE  wt.refid = wi.objid AND wt.state = 'start') AS task_fromdate,
    -- (SELECT  SEC_TO_TIME( SUM( TO_SECONDS(IFNULL( wt.enddate, NOW() )) -  TO_SECONDS(wt.dtcreated) ))
    -- FROM obo_building_application_workitem_task wt
    -- INNER JOIN sys_wf_node wn ON wn.name=wt.state AND wn.processname = 'obo_building_application_workitem'
    -- WHERE wt.refid = wi.objid  AND wt.state NOT IN ('start', 'end' ) AND wn.tracktime = 1) AS task_timediff
-->
DROP VIEW IF EXISTS vw_obo_building_subapplication;
CREATE VIEW vw_obo_building_subapplication AS 
SELECT 
    sa.objid,
    sa.appid, 
    sa.taskid,
    oa.appno,
    oa.appdate,
    oa.apptype,
    oa.owner_objid,
    oa.owner_name,
    oa.owner_address_text,
    oa.owner_ctcid,
    oa.title,
    oa.description,
    oa.occupancytypeid AS occupancytype_division,
    ot.parentid AS occupancytype_group,
    oa.numunits,
    oa.floorarea,
        oa.totalfloorarea,
        oa.height,
    oa.estimatedcost,
    oa.dtproposedconstruction,
    oa.dtexpectedcompletion,
    oa.projectcost,
    oa.supervisorid,
    sat.state AS task_state,
    
    sat.assignee_name AS task_assignee_name,
    sat.assignee_name AS task_assignee_objid,
    sat.actor_name AS task_actor_name,
    sat.actor_objid AS task_actor_objid,

    sat.startdate AS task_startdate,
    sat.enddate AS task_enddate,
    wt.title AS typetitle,
    wt.objid AS typeid,
    wt.activationstate,

        CASE WHEN sa.taskid IS NULL THEN NULL ELSE
    (SELECT wt.dtcreated FROM obo_building_subapplication_task wt WHERE  wt.refid = sa.objid AND wt.state = 'start') 
        END AS task_fromdate,
        
        CASE WHEN sa.taskid IS NULL THEN NULL ELSE
        (SELECT  SEC_TO_TIME( SUM( TO_SECONDS(IFNULL( wt.enddate, NOW() )) -  TO_SECONDS(wt.dtcreated) ))
    FROM obo_building_subapplication_task wt
    INNER JOIN sys_wf_node wn ON wn.name=wt.state AND wn.processname = 'obo_building_subapplication'
    WHERE wt.refid = sa.objid  AND wt.state NOT IN ('start', 'end' ) AND wn.tracktime = 1) 
        END AS task_timediff 

FROM obo_building_subapplication sa
INNER JOIN obo_building_application oa ON sa.appid = oa.objid
LEFT JOIN obo_building_subapplication_task sat ON sat.taskid = sa.taskid
INNER JOIN obo_subapplication_type wt ON sa.typeid = wt.objid
LEFT JOIN obo_occupancy_type ot ON oa.occupancytypeid = ot.objid


