UPDATE building_permit SET locationid = null, applicantid = null, taskid = NULL;
UPDATE building_permit_evaluation SET taskid = NULL;
DELETE FROM building_permit_evaluation_task;
DELETE FROM building_permit_task;
DELETE FROM building_permit_fee;

DELETE FROM building_permit_finding;
DELETE FROM building_permit_evaluation;

DELETE FROM building_permit_info;
DELETE FROM building_permit_requirement;
DELETE FROM building_permit_ancillary;
DELETE FROM building_permit_rpu;
DELETE FROM building_permit_professional;
DELETE FROM building_permit_entity;
DELETE FROM building_permit;