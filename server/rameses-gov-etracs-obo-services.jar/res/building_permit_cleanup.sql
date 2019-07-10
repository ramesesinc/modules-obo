UPDATE building_permit SET locationid = null, applicantid = null;
DELETE FROM building_permit_requirement;
DELETE FROM building_permit_ancillary;
DELETE FROM building_permit_info;
DELETE FROM building_permit_rpu;
DELETE FROM building_permit_professional;
DELETE FROM building_permit_entity;
DELETE FROM building_permit;