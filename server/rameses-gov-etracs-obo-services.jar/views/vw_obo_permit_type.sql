DROP VIEW IF EXISTS vw_obo_permit_type;
CREATE VIEW vw_obo_permit_type AS 
SELECT 
 ot.*,
 et.org_objid,
 et.org_name
FROM obo_permit_type ot 
LEFT JOIN building_permit_section_type et ON ot.sectionid = et.objid 