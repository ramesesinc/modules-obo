[cleanup-building-application]
SET FOREIGN_KEY_CHECKS = 0;

DELETE FROM building_application;
DELETE FROM building_application_checklist_item;
DELETE FROM building_application_entity;
DELETE FROM building_application_fee;
DELETE FROM building_application_info;
DELETE FROM building_application_payment;
DELETE FROM building_application_professional;
DELETE FROM building_application_requirement;
DELETE FROM building_application_rpu;
DELETE FROM building_application_subdoc;
DELETE FROM building_application_task;
DELETE FROM building_application_transmittal;
DELETE FROM building_evaluation;
DELETE FROM building_evaluation_finding;
DELETE FROM building_evaluation_task;
DELETE FROM building_issuance;
DELETE FROM building_permit;
DELETE FROM building_permit_rpu;

SET FOREIGN_KEY_CHECKS = 1;
