CREATE VIEW vw_obo_application_requirement AS 
SELECT 
   sa.*,
   a.appno, a.owner_name, a.owner_address_text,
   os.title
FROM obo_application_requirement sa 
INNER JOIN obo_application a ON sa.appid = a.objid
INNER JOIN obo_section os ON sa.sectionid = sa.sectionid = os.objid