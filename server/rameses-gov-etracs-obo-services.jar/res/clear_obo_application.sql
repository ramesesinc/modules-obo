
UPDATE obo_building_application_workitem SEt taskid = NULL;
DELETE FROM obo_building_application_workitem_task;
DELETE FROM obo_building_application_workitem;
UPDATE obo_building_application SEt taskid = NULL;
DELETE FROM obo_building_application_task;
DELETE FROM obo_building_application_requirement;
DELETE FROM obo_building_subapplication_item;
DELETE FROM obo_building_subapplication;
DELETE FROM obo_building_application;