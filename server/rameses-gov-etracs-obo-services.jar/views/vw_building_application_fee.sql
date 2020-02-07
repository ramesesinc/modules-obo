DROP VIEW IF EXISTS vw_building_application_fee;
CREATE VIEW vw_building_application_fee AS 
SELECT 
   a.*,
   bi.sectionid
FROM building_application_fee a 
LEFT JOIN building_evaluation_type_itemaccount bi ON bi.itemid = a.objid
