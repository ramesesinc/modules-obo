DROP VIEW IF EXISTS vw_occupancy_permit;
CREATE VIEW vw_occupancy_permit AS 
SELECT 
   app.*,
   p.controlno,
   p.dtissued,
   p.template,
   p.approverid,
   p.endorserid,   
   p.issuedby_objid
FROM vw_occupancy_application app 
INNER JOIN occupancy_permit p ON app.issuanceid = p.objid



