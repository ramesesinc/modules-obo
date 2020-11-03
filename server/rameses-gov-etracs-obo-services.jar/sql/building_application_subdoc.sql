[getSubdocsToAutoCreate]
SELECT * FROM obo_doctype 
WHERE apptype = $P{apptype} 
AND autocreate = 1
AND objid NOT IN ( SELECT doctypeid FROM building_application_subdoc WHERE appid = $P{appid} )

[getSubdocsToIssue]
SELECT sd.*, dt.template, dt.controlnopattern
FROM building_application_subdoc sd 
INNER JOIN obo_doctype dt ON sd.doctypeid=dt.objid
WHERE sd.appid = $P{appid}
AND sd.issuanceid IS NULL
AND dt.issuetype = 3

[findDocsToReleaseCount]
SELECT COUNT(*) AS count    
FROM building_application_subdoc bs 
INNER JOIN obo_doctype od ON bs.doctypeid = od.objid
LEFT JOIN obo_section os ON od.sectionid=os.objid
WHERE od.objid = $P{doctypeid} 
AND bs.state = 1
AND bs.issuanceid IS NULL
AND od.role IN ( ${roles} )  