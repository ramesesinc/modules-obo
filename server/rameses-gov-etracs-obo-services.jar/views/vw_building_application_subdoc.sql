DROP VIEW IF EXISTS vw_building_application_subdoc; 
CREATE VIEW vw_building_application_subdoc AS 
SELECT 
   a.*,
   os.org_objid AS org_objid,
   bt.state AS appstate,
   bt.assignee_objid AS appuserid,
   iss.controlno,
   iss.dtissued,
   iss.expirydate,
   iss.issuedby_name,
   iss.issuedby_objid,
   iss.remarks AS issue_remarks,
   iss.template,
   iss.transmittalid,
   od.sectionid  
FROM building_application_subdoc a  
INNER JOIN obo_doctype od ON a.doctypeid = od.objid 
LEFT JOIN obo_section os ON od.sectionid = os.objid
LEFT JOIN building_issuance iss ON a.issuanceid = iss.objid 
INNER JOIN building_application ba ON a.appid = ba.objid 
LEFT JOIN building_application_task bt ON ba.taskid = bt.taskid 
