[getEvaluationsToActivate]
SELECT a.objid FROM 
( 
	SELECT objid FROM building_evaluation_type WHERE required = 1 AND activationstate = $P{state}
	UNION ALL 
	SELECT objid FROM building_evaluation_type WHERE required = 0 AND activationstate = $P{state}
	AND objid IN ( 
		SELECT dt.evaltypeid FROM building_application_subdoc sd 
		INNER JOIN building_doc_type dt ON sd.doctypeid = dt.objid
		WHERE sd.appid = $P{appid}
	)
) a 
WHERE a.objid NOT IN ( SELECT typeid FROM building_evaluation WHERE appid = $P{appid})	


[getSubdocsToActivate]
SELECT objid FROM building_doc_type bd WHERE bd.autocreate = 1 
AND evaltypeid IN (
	SELECT typeid FROM building_evaluation WHERE appid = $P{appid}
)
AND objid NOT IN ( 
	SELECT doctypeid FROM building_application_subdoc WHERE appid = $P{appid}
)
