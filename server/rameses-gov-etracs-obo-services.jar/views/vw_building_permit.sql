DROP VIEW IF EXISTS vw_building_permit;
CREATE VIEW vw_building_permit AS 
SELECT 
   pmt.*,

   a.appno,
   a.txnmode,
   a.apptype,
   a.dtfiled,   

   bi.contact_name,  
   bi.contact_detail,
   bi.contact_email,
   bi.contact_mobileno,
   bi.applicantid,
   bi.description,
   bi.title,
   bi.occupancytypeid,
   bi.numunits,
   bi.fixedcost,
   bi.projectcost,
   bi.dtproposedconstruction,
   bi.dtexpectedcompletion,
   bi.totalfloorarea,
   bi.height,
   bi.numfloors,
   bi.worktypes,
   bi.zoneclassid,
   bi.zone,
   bi.location_lotno,
   bi.location_blockno,
   bi.location_street,
   bi.location_barangay_name,
   bi.location_barangay_objid,
   bi.contractorid,
   bi.location_unitno,
   bi.location_bldgno,
   bi.location_bldgname,
   bi.location_subdivision,
   bi.createdby_objid,
   bi.createdby_name,
   bi.dtcreated,
   bi.txntype,

   ae.name AS applicant_name,

   bt.objid AS occupancytype_objid,
   bt.title AS occupancytype_title,   
   od.objid AS occupancytype_division_objid,
   od.title AS occupancytype_division_title,   
   og.objid AS occupancytype_group_objid,
   og.title AS occupancytype_group_title,   

   zc.objid AS zoneclass_objid,
   zc.title AS zoneclass_title,

   LTRIM(CONCAT(
      (CASE WHEN bi.location_lotno IS NULL THEN '' ELSE CONCAT( ' ', bi.location_lotno) END),
      (CASE WHEN bi.location_blockno IS NULL THEN '' ELSE CONCAT(' ', bi.location_blockno) END),
      (CASE WHEN bi.location_unitno IS NULL THEN '' ELSE CONCAT(' ', bi.location_unitno) END),
      (CASE WHEN bi.location_bldgno IS NULL THEN '' ELSE CONCAT(' ', bi.location_bldgno) END),
      (CASE WHEN bi.location_bldgname IS NULL THEN '' ELSE CONCAT(' ', bi.location_bldgname) END),
      (CASE WHEN bi.location_street IS NULL THEN '' ELSE CONCAT(' ', bi.location_street) END),
      (CASE WHEN bi.location_subdivision IS NULL THEN '' ELSE CONCAT(' ', bi.location_subdivision) END),      
      (CASE WHEN bi.location_barangay_name IS NULL THEN '' ELSE CONCAT(' ', bi.location_barangay_name ) END)
   )) AS location_text

FROM building_permit pmt 
INNER JOIN building_info bi ON pmt.infoid = bi.objid
INNER JOIN building_application_entity ae ON bi.applicantid = ae.objid
LEFT JOIN building_application a ON pmt.appid = a.objid

INNER JOIN obo_occupancy_type bt ON bi.occupancytypeid = bt.objid
INNER JOIN obo_occupancy_type_division od ON bt.divisionid = od.objid
INNER JOIN obo_occupancy_type_group og ON od.groupid = og.objid
LEFT JOIN obo_zoneclass zc ON bi.zoneclassid = zc.objid



