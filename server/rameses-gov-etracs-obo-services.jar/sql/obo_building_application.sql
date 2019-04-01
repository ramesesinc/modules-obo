[getUnvalidateRequirements]
SELECT 
   ort.title, ort.type 
FROM obo_building_application_requirement oar 
INNER JOIN obo_requirement_type ort ON oar.typeid = ort.objid 
WHERE oar.appid = $P{appid} 
AND ort.processname = $P{processname} 
AND ort.validationstate = $P{validationstate} 
AND oar.status = 0
UNION ALL
SELECT 
   ort.title, ort.type 
FROM obo_building_application_workitem wi 
INNER JOIN obo_building_application_workitem_task wit ON wi.taskid=wit.taskid
INNER JOIN obo_requirement_type ort ON wi.typeid = ort.objid 
WHERE wi.appid = $P{appid} 
AND ort.processname = $P{processname} 
AND ort.validationstate = $P{validationstate} 
AND wit.state != 'end' 
