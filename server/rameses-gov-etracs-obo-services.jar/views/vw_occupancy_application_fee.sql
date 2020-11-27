DROP VIEW IF EXISTS vw_occupancy_application_fee;
CREATE VIEW vw_occupancy_application_fee AS 
SELECT 
   a.*,
   sd.doctypeid 
FROM occupancy_application_fee a 
LEFT JOIN occupancy_application_subdoc sd ON a.parentid = sd.objid
