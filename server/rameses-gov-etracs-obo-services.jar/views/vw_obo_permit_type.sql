DROP VIEW IF EXISTS vw_obo_permit_type;
CREATE VIEW vw_obo_permit_type AS 
SELECT 
 ot.*
FROM obo_permit_type ot 