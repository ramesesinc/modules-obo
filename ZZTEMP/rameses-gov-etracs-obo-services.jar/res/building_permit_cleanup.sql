[cleanup-all]
UPDATE building_permit SET applicantid = null, taskid = NULL, accessoryid = NULL;
UPDATE building_permit_section SET taskid = NULL;
UPDATE building_permit_requirement SET supersederid = NULL;
UPDATE building_permit_issuance SET taskid = NULL;
UPDATE building_permit_finding SET supersederid = NULL;
DELETE FROM building_permit_section_task;
DELETE FROM building_permit_task;
DELETE FROM building_permit_fee;
DELETE FROM building_permit_issuance_task;
DELETE FROM building_permit_issuance;
DELETE FROM building_permit_finding;
DELETE FROM building_permit_section;
DELETE FROM building_permit_info;
DELETE FROM building_permit_requirement;
DELETE FROM building_permit_ancillary;
DELETE FROM building_permit_accessory;
DELETE FROM building_permit_rpu;
DELETE FROM building_permit_professional;
DELETE FROM building_permit_entity;
DELETE FROM building_permit_payment;
DELETE FROm building_permit_transmittal;
DELETE FROM building_permit;
DELETE FROM sys_sequence;

[cleanup-for-online]
UPDATE building_permit SET taskid = NULL,appno=NULL;
UPDATE building_permit_requirement SET checked = 0, remarks=null; 
UPDATE building_permit_section SET taskid = NULL;
DELETE FROM building_permit_section_task;
DELETE FROM building_permit_task;
DELETE FROM building_permit_fee;
DELETE FROM building_permit_finding;
DELETE FROM building_permit_section;