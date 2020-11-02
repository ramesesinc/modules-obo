[getAllowedTypes]
SELECT DISTINCT y.objid, y.title, y.sortindex
FROM 
(SELECT z.* FROM 
(SELECT bet.objid, bet.sortindex, bet.title, swf.name, 
	IFNULL( betr.role, swf.role) AS role, 
	IFNULL(os.org_objid, 'root') AS orgid     
FROM occupancy_inspection_type bet
LEFT JOIN obo_section os ON bet.sectionid = os.objid
INNER JOIN sys_wf_node swf ON swf.processname = 'occupancy_inspection' 	
LEFT JOIN occupancy_inspection_type_role betr ON betr.typeid = bet.objid AND betr.state = swf.name
WHERE swf.name NOT IN ( 'start', 'end' )
AND swf.tracktime = 1) z
WHERE z.role IN ( ${roles} ) 
AND z.orgid = $P{orgid}
) y
ORDER BY y.sortindex

[getAllTaskCount]
SELECT COUNT(*) AS count   
FROM  
(SELECT bt.state, typ.objid AS section, 
	IFNULL(os.org_objid, 'root') AS orgid, 
IFNULL( oitr.role, sn.role )  AS role
FROM occupancy_inspection_task bt
INNER JOIN occupancy_inspection be ON bt.taskid = be.taskid 
INNER JOIN occupancy_inspection_type typ ON be.typeid = typ.objid
LEFT JOIN obo_section os ON  typ.sectionid = os.objid
INNER JOIN sys_wf_node sn ON sn.processname = 'occupancy_inspection' AND sn.name = bt.state 
LEFT JOIN occupancy_inspection_type_role oitr ON oitr.typeid = typ.objid AND oitr.state = bt.state
WHERE bt.assignee_objid IS NULL 
AND bt.enddate IS NULL
AND sn.tracktime = 1) z
WHERE z.role IN ( ${roles} )
AND z.orgid = $P{orgid}


[getNodeListTaskCountBySection]
SELECT z.state, COUNT(*) AS count   
FROM  
(SELECT bt.state, typ.objid AS section, 
IFNULL( oitr.role, sn.role )  AS role
FROM occupancy_inspection_task bt
INNER JOIN occupancy_inspection be ON bt.taskid = be.taskid 
INNER JOIN occupancy_inspection_type typ ON be.typeid = typ.objid
INNER JOIN sys_wf_node sn ON sn.processname = 'occupancy_inspection' AND sn.name = bt.state 
LEFT JOIN occupancy_inspection_type_role oitr ON oitr.typeid = typ.objid AND oitr.state = bt.state
WHERE bt.assignee_objid IS NULL 
AND bt.enddate IS NULL
AND sn.tracktime = 1) z
WHERE z.section = $P{sectionid} 
AND z.role IN ( ${roles} )
GROUP BY z.state 
