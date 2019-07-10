DROP VIEW IF EXISTS vw_online_building_permit_professional;
CREATE VIEW vw_online_building_permit_professional AS 
SELECT 
   a.*,
   e.name AS entity_name   
FROM online_building_permit_professional a 
INNER JOIN online_building_permit_entity e ON a.entityid = e.objid
