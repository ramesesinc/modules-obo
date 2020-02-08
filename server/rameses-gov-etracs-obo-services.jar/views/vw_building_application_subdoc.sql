DROP VIEW IF EXISTS vw_building_application_subdoc;
CREATE VIEW vw_building_application_subdoc AS 
SELECT 
   a.*,
   iss.controlno,
   iss.dtissued,
   iss.expirydate,
   iss.issuedby_name,
   iss.issuedby_objid,
    iss.template,
    iss.transmittalid 
FROM building_application_subdoc a 
LEFT JOIN building_issuance iss ON a.issuanceid = iss.objid
