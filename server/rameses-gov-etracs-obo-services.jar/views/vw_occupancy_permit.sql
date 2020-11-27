DROP VIEW IF EXISTS vw_occupancy_permit;
CREATE VIEW vw_occupancy_permit AS 
SELECT 
   app.*,
   p.controlno,
   p.dtissued,
   p.template,
   p.approverid,
   p.endorserid,   
   p.issuedby_objid,
   ba.title,
   ba.controlno AS bldgpermitno,
   ba.dtissued AS bldgpermitdtissued,
   ba.location_text
FROM vw_occupancy_application app 
INNER JOIN vw_building_permit ba ON app.bldgpermitid=ba.objid
INNER JOIN occupancy_permit p ON app.issuanceid = p.objid



