[getSubdocsToAutoCreate]
SELECT * FROM obo_doctype 
WHERE apptype = $P{apptype} 
AND autocreate = 1
AND objid NOT IN ( SELECT doctypeid FROM occupancy_permit_doc WHERE appid = $P{appid} )

[getSubdocsToIssue]
SELECT sd.*, dt.template, dt.controlnopattern
FROM occupancy_permit_doc sd 
INNER JOIN obo_doctype dt ON sd.doctypeid=dt.objid
WHERE sd.appid = $P{appid}
AND sd.controlid IS NULL
AND dt.issuetype = 3

[findDocsToReleaseCount]
SELECT COUNT(*) AS count    
FROM occupancy_permit_doc bs 
INNER JOIN obo_doctype od ON bs.doctypeid = od.objid
LEFT JOIN obo_section os ON od.sectionid=os.objid
WHERE od.objid = $P{doctypeid} 
AND bs.state = 1
AND bs.controlid IS NULL
AND od.role IN ( ${roles} )  

[findAllDocsToReleaseCount]
SELECT COUNT(*) AS count    
FROM occupancy_permit_doc bs 
INNER JOIN obo_doctype od ON bs.doctypeid=od.objid
LEFT JOIN obo_section os ON od.sectionid=os.objid
WHERE od.issuetype = 2 
AND bs.state = 1
AND bs.controlid IS NULL
AND od.role IN ( ${roles} )  
AND IFNULL(os.org_objid, 'root') = $P{orgid}


[getSubdocsToEmail]
SELECT sd.*, dt.template, dt.controlnopattern
FROM occupancy_permit_doc sd 
INNER JOIN obo_doctype dt ON sd.doctypeid=dt.objid
WHERE sd.appid = $P{appid}
AND NOT(dt.template IS NULL)


[getDocsThatRequireFees]
SELECT dt.title 
FROM occupancy_permit_doc sd 
INNER JOIN obo_doctype dt ON sd.doctypeid = dt.objid 
WHERE sd.appid = $P{appid} 
AND dt.requirefee = 1 
AND (sd.amount IS NULL OR sd.amount <= 0)
