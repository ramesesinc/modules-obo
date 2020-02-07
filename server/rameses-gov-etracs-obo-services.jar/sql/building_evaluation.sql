[getDocsThatRequireFees]
SELECT dt.title
FROM building_application_subdoc sd
INNER JOIN building_doc_type dt ON sd.doctypeid = dt.objid 
INNER JOIN building_evaluation be ON be.appid = sd.appid AND dt.evaltypeid = be.typeid 
WHERE be.objid = $P{evaluationid}
AND dt.requirefee = 1 
AND (sd.amount IS NULL OR sd.amount <= 0)
