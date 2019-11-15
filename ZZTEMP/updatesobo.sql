ALTER TABLE obo_section ADD COLUMN requirefee int DEFAULT 0;
ALTER TABLE obo_section ADD COLUMN issuepermit int DEFAULT 0;
ALTER TABLE obo_section ADD COLUMN permit_title varchar(150);
ALTER TABLE obo_section ADD COLUMN permit_controlnopattern varchar(100);
ALTER TABLE obo_section ADD COLUMN permit_template varchar(150);
ALTER TABLE obo_section ADD COLUMN ancillarytypeid varchar(50);
ALTER TABLE obo_section ADD COLUMN `permit_name` varchar(50);

ALTER TABLE building_permit ADD COLUMN contractorid varchar(50);

### building permit ###
ALTER TABLE `dev_obo`.`building_permit` 
ADD COLUMN `permitno` varchar(50) NULL AFTER `contractorid`,
ADD COLUMN `dtissued` date NULL AFTER `permitno`,
ADD COLUMN `remarks` varchar(255) NULL AFTER `dtissued`,
ADD UNIQUE INDEX `uix_building_permit_permitno`(`permitno`) USING BTREE;

CREATE TABLE `fire_safety_checklist` (
  `objid` varchar(50) NOT NULL,
  `appid` varchar(50) DEFAULT NULL,
  `controlno` varchar(50) DEFAULT NULL,
  `dtcreated` datetime DEFAULT NULL,
  `createdby_objid` varchar(50) DEFAULT NULL,
  `createdby_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`objid`),
  UNIQUE KEY `uix_fire_safety_checklist_controlno` (`controlno`),
  KEY `fk_fire_safety_checklist_appid` (`appid`),
  CONSTRAINT `fk_fire_safety_checklist_appid` FOREIGN KEY (`appid`) REFERENCES `building_permit` (`objid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


ALTER TABLE `dev_obo`.`building_permit_issuance` DROP FOREIGN KEY `fk_building_permit_issuance_appid`;
ALTER TABLE `dev_obo`.`building_permit_issuance` DROP FOREIGN KEY `fk_building_permit_issuance_sectionid`;
ALTER TABLE `dev_obo`.`building_permit_issuance` DROP FOREIGN KEY `fk_building_permit_issuance_taskid`;

ALTER TABLE `dev_obo`.`building_permit` DROP FOREIGN KEY `building_permit_issuanceid`;
ALTER TABLE `dev_obo`.`building_permit_section` DROP FOREIGN KEY `fk_building_permit_section_issuanceid`;

DROP TABLE building_permit_issuance_task;
DROP TABLE building_permit_issuance;

UPDATE building_permit_section_task SET state = 'obo-processing' WHERE state = 'end'; 

// vw_building_permit_section.sql
// vw_building_permit.sql

137-D55KC2YR