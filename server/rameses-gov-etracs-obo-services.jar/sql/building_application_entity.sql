[cleanUpEntity]
DELETE FROM building_application_entity 
WHERE appid = $P{appid} 
AND objid NOT IN ( SELECT bi.applicantid 
		FROM building_application ba 
		WHERE ba.objid=$P{appid} )
AND objid NOT IN ( SELECT ownerid FROM building_application_rpu WHERE appid=$P{appid} )

[findOrphan]
SELECT COUNT(*) AS counter 
FROM building_application_entity 
WHERE appid = $P{appid} 
AND objid NOT IN ( 
		SELECT bi.applicantid 
		FROM building_application ba 
		WHERE ba.objid=$P{appid} )
AND objid NOT IN ( SELECT ownerid FROM building_application_rpu WHERE appid=$P{appid} )