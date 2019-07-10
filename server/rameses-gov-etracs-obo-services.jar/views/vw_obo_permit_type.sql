DROP VIEW IF EXISTS vw_obo_permit_type;
CREATE VIEW vw_obo_permit_type AS 
SELECT 
 ot.*,
 et.objid AS evaluationtypeid,
 et.org_objid,
 et.org_name,
 et.activationstate,
 et.validationstate 
FROM obo_permit_type ot 
LEFT JOIN obo_evaluation_type et ON ot.objid = et.ancillarypermitid 