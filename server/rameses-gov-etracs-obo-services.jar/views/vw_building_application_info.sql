DROP VIEW IF EXISTS vw_building_application_info;
CREATE VIEW vw_building_application_info AS 
SELECT ai.*,
   ov.datatype,
   ov.doctypeid,
   ov.unit,
   ov.caption, 
   ov.category, 
   ov.sortorder, 
   bp.objid AS bldgpermitid 
FROM building_application_info ai 
INNER JOIN obo_variable ov ON ov.objid = ai.name 
LEFT JOIN building_permit bp ON bp.appid = ai.objid 