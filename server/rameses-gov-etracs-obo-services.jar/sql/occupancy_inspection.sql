[getSubdocsToActivate]
SELECT bd.objid 
FROM building_doc_type bd 
WHERE bd.autocreate = 1 
AND bd.apptype = 'occupancy'
AND bd.inspectiontypeid = $P{typeid}
AND bd.objid NOT IN ( 
	SELECT doctypeid FROM occupancy_application_subdoc WHERE appid = $P{appid}
)

[getDocsThatRequireFees]
SELECT dt.title
FROM occupancy_application_subdoc sd
INNER JOIN building_doc_type dt ON sd.doctypeid = dt.objid 
INNER JOIN occupancy_inspection be ON be.appid = sd.appid AND dt.inspectiontypeid = be.typeid 
WHERE be.objid = $P{inpsectionid}
AND dt.requirefee = 1 
AND (sd.amount IS NULL OR sd.amount <= 0)
