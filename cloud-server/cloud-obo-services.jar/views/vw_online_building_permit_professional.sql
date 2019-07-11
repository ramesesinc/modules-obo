DROP VIEW IF EXISTS vw_online_building_permit_professional;
CREATE VIEW vw_online_building_permit_professional AS 
SELECT 
   a.*,
   e.name AS entity_name,  
   e.firstname as entity_firstname, 
   e.lastname as entity_lastname, 
   e.middlename as entity_middlename, 
   e.address_text as entity_address_text, 
   e.tin as entity_tin, 
   e.id as entity_id 
FROM online_building_permit_professional a 
INNER JOIN online_building_permit_entity e ON a.entityid = e.objid
;