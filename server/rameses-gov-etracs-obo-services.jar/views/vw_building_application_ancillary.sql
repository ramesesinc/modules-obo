DROP VIEW IF EXISTS vw_building_application_ancillary;
CREATE VIEW vw_building_application_ancillary AS 
SELECT 
   a.*,
    pt.title,
    pt.sectionid,
    pt.sortorder    
FROM building_application_ancillary a 
INNER JOIN obo_permit_type pt ON a.permittypeid = pt.objid 

