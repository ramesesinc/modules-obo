DROP VIEW IF EXISTS vw_obo_building_application_finding;
CREATE VIEW vw_obo_building_application_finding AS 
SELECT 
  sa.typeid,
	of.*	
FROM obo_building_application_finding of
INNER JOIN obo_building_application_section sa ON of.subappid = sa.objid ;