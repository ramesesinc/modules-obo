DROP VIEW IF EXISTS vw_obo_building_application_requirement;
CREATE VIEW vw_obo_building_application_requirement AS 
SELECT 
   sa.*,
   rt.title
FROM obo_building_application_requirement sa 
INNER JOIN obo_building_application a ON sa.appid = a.objid
INNER JOIN obo_requirement_type rt ON rt.objid = sa.typeid