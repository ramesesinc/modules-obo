DROP VIEW IF EXISTS vw_obo_building_application_info;
CREATE VIEW vw_obo_building_application_info AS
SELECT ai.*,
   ov.datatype,
   ov.typeid,
   ov.unit,
   ov.caption, 
   ov.category, 
   ov.sortorder
FROM obo_building_application_info ai
INNER JOIN obo_variable ov ON ov.objid = ai.name