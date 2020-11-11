[cleanUpEntity]
DELETE FROM building_application_entity 
WHERE appid = $P{appid} 
AND objid NOT IN ( SELECT bi.applicantid 
		FROM building_info bi  
		INNER JOIN building_application ba ON ba.infoid=bi.objid
		WHERE ba.objid=$P{appid} )
AND objid NOT IN ( SELECT ownerid FROM building_application_rpu WHERE appid=$P{appid} )

[findOrphan]
SELECT COUNT(*) AS counter 
FROM building_application_entity 
WHERE appid = $P{appid} 
AND objid NOT IN ( 
		SELECT bi.applicantid 
		FROM building_info bi  
		INNER JOIN building_application ba ON ba.infoid=bi.objid
		WHERE ba.objid=$P{appid} )
AND objid NOT IN ( SELECT ownerid FROM building_application_rpu WHERE appid=$P{appid} )