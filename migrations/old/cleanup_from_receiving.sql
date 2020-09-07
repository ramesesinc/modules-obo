 
FIND THE objid first

SELECT objid FROM building_application WHERE trackingno = ?;
@appid

UPDATE building_application SET taskid=NULL, applicantid=NULL where objid= @appid;
DELETE FROM building_application_info WHERE appid = @appid;
DELETE FROM building_application_task WHERE refid = @appid;
DELETE FROM building_application_professional WHERE appid = @appid;
DELETE FROM building_application_requirement WHERE appid = @appid;
DELETE FROM building_application_rpu WHERE appid = @appid;
DELETE FROM building_application_subdoc WHERE appid = @appid;
DELETE FROM building_application_entity WHERE appid = @appid;
DELETE FROM building_application where objid= @appid;

