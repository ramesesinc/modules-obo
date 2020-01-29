[cleanup-all]
UPDATE building_application SET taskid = NULL, accessoryid = NULL;
UPDATE building_application_section SET taskid = NULL;
UPDATE building_application_requirement SET supersederid = NULL;
UPDATE building_application_finding SET supersederid = NULL;

DELETE FROM locational_clearance;
DELETE FROM fire_safety_checklist_item;
DELETE FROM fire_safety_checklist;
DELETE FROM fire_safety_evaluation_clearance;

DELETE FROM building_application_section_task;
DELETE FROM building_application_task;
DELETE FROM building_application_fee;
DELETE FROM building_application_finding;
DELETE FROM building_application_section;
DELETE FROM building_application_info;
DELETE FROM building_application_requirement;
DELETE FROM building_application_ancillary;
DELETE FROM building_application_accessory;
DELETE FROM building_application_rpu;
DELETE FROM building_application_professional;
DELETE FROM building_application_entity;
DELETE FROM building_application_payment;
DELETE FROm building_application_transmittal;
DELETE FROM building_application;
DELETE FROM sys_sequence;

[cleanup-building-transactions]
UPDATE building_application_requirement SET state = 0, transmittalid = NULL;
DELETE FROM building_application_finding;
DELETE FROM building_payment;
DELETE FROM building_application_transmittal;


[cleanup-occupancy-permit]
UPDATE occupancy_application SET taskid = NULL;
UPDATE occupancy_application_section SET taskid = NULL;
UPDATE occupancy_application_requirement SET supersederid = NULL;
UPDATE occupancy_application_finding SET supersederid = NULL;
DELETE FROM occupancy_application_section_task;
DELETE FROM occupancy_application_task;
DELETE FROM occupancy_application_fee;
DELETE FROM occupancy_application_finding;
DELETE FROM occupancy_application_section;
DELETE FROM occupancy_application_requirement;
DELETE FROM occupancy_application_professional;
DELETE FROM occupancy_application_entity;
DELETE FROM occupancy_application_payment;
DELETE FROm occupancy_application_transmittal;
DELETE FROM occupancy_application;


[cleanup-for-online]
UPDATE building_application SET taskid = NULL,appno=NULL;
UPDATE building_application_requirement SET checked = 0, remarks=null; 
UPDATE building_application_section SET taskid = NULL;
DELETE FROM building_application_section_task;
DELETE FROM building_application_task;
DELETE FROM building_application_fee;
DELETE FROM building_application_finding;
DELETE FROM building_application_section;

[clean-captured-building-permit]
UPDATE building_application SET applicantid = null, taskid = NULL, accessoryid = NULL;
DELETE FROM building_application_task;
delete from building_application_entity;
DELETE FROM building_application;