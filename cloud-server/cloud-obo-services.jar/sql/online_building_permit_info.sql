[removeAccessoryInfos]
DELETE FROM online_building_permit_info
WHERE parentid IN 
(SELECT objid FROM online_building_permit_accessory WHERE appid = $P{appid} )