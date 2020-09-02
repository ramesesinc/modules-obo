[getAvailableAncillaryPermitTypes]
SELECT * FROM obo_permit_type 
WHERE type = 'ANCILLARY'
AND objid NOT IN 
(SELECT permittypeid FROM online_building_permit_ancillary where appid=$P{appid})
ORDER BY sortorder
