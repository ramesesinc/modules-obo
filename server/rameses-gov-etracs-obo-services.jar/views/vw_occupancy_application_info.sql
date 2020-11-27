DROP VIEW IF EXISTS vw_occupancy_application_info;
CREATE VIEW vw_occupancy_application_info AS 
SELECT ai.*,
   ov.datatype,
   ov.doctypeid,
   ov.unit,
   ov.caption, 
   ov.category, 
   ov.sortorder, 
   bp.objid AS bldgpermitid 
FROM occupancy_application_info ai 
INNER JOIN obo_variable ov ON ov.objid = ai.name 
LEFT JOIN occupancy_permit bp ON bp.appid = ai.objid 