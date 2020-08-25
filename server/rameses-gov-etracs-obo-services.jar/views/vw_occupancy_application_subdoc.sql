DROP VIEW IF EXISTS vw_occupancy_application_subdoc; 
CREATE VIEW vw_occupancy_application_subdoc AS 
SELECT 
   bt.state AS appstate,
   bt.assignee_objid AS appuserid,
   a.*,
   iss.controlno,
   iss.dtissued,
   iss.expirydate,
   iss.issuedby_name,
   iss.issuedby_objid,
   iss.remarks AS issue_remarks,
   iss.template,
   iss.transmittalid  
FROM occupancy_application_subdoc a  
LEFT JOIN occupancy_issuance iss ON a.issuanceid = iss.objid 
INNER JOIN occupancy_application ba ON a.appid = ba.objid 
INNER JOIN occupancy_application_task bt ON ba.taskid = bt.taskid 
