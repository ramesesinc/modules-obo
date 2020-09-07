
#UPDATE building_doc_type SET haschecklist = 0;
#UPDATE building_doc_type SET haschecklist = 1 WHERE objid IN ('HOT_WORKS','FSEC_CHECKLIST');

ALTER TABLE building_doc_type ADD COLUMN subtypeof varchar(50);
UPDATE building_doc_type SET subtypeof = 'FSEC' WHERE objiod='FSEC_CHECKLIST';

ALTER TABLE `obo_work_type` ADD COLUMN `typeid` varchar(50) NULL AFTER `idx`;
ALTER TABLE `obo_work_type` ADD CONSTRAINT `fk_obo_work_type_typeid` FOREIGN KEY (`typeid`) REFERENCES `building_doc_type` (`objid`);

INSERT INTO obo_checklist_master 
(objid,doctypeid,indexno,title,category)
VALUES 
('hw01', 'HOT_WORKS', 1, 'Available sprinklers, hose streams and extinguishers in service/operable', 'GENERAL'), 
('hw02', 'HOT_WORKS', 2, 'Hot work equipment in good repair', 'GENERAL'), 
('hw03', 'HOT_WORKS', 3, 'Flammable liquids, dust, lint and all deposits removed', 'REQUIREMENT WITHIN 35FT (10M) OF WORK'), 
('hw04', 'HOT_WORKS', 4, 'Explosive atmosphere in area eliminated', 'REQUIREMENT WITHIN 35FT (10M) OF WORK'), 
('hw05', 'HOT_WORKS', 5, 'Floors swept clean', 'REQUIREMENT WITHIN 35FT (10M) OF WORK'), 
('hw06', 'HOT_WORKS', 6, 'Combustible floors wet down, covered with damp sand or fire resistant sheets', 'REQUIREMENT WITHIN 35FT (10M) OF WORK'), 
('hw07', 'HOT_WORKS', 7, 'Remove other combustibles where possible, otherwise protect with fire resistant tarpaulins or metal shields', 'REQUIREMENT WITHIN 35FT (10M) OF WORK'), 
('hw08', 'HOT_WORKS', 8, 'All wall and floor openings covered', 'REQUIREMENT WITHIN 35FT (10M) OF WORK'), 
('hw09', 'HOT_WORKS', 9, 'Fire resistant tarpaulins suspended beneath work', 'REQUIREMENT WITHIN 35FT (10M) OF WORK'), 
('hw10', 'HOT_WORKS', 10, 'Construction is non-combustible and without combustible covering insulation', 'WORK ON WALLS OR CEILINGS/ENCLOSED EQUIPMENT'), 
('hw11', 'HOT_WORKS', 11, 'Combustible on other side walls moved away', 'WORK ON WALLS OR CEILINGS/ENCLOSED EQUIPMENT'), 
('hw12', 'HOT_WORKS', 12, 'Danger exist by conduction of heat into another area', 'WORK ON WALLS OR CEILINGS/ENCLOSED EQUIPMENT'), 
('hw13', 'HOT_WORKS', 13, 'Enclosed equipment cleaned of all combustibles', 'WORK ON WALLS OR CEILINGS/ENCLOSED EQUIPMENT'), 
('hw14', 'HOT_WORKS', 14, 'Containers purged of flammable liquids/vapors', 'WORK ON WALLS OR CEILINGS/ENCLOSED EQUIPMENT'), 
('hw15', 'HOT_WORKS', 15, 'Fire watch will be provided during and for 30 minutes after work, including any coffee or lunch breaks', 'FIRE WATCH/HOT WORK AREA MONITORING'), 
('hw16', 'HOT_WORKS', 16, 'Fire watch is supplied with suitable extinguishers', 'FIRE WATCH/HOT WORK AREA MONITORING'), 
('hw17', 'HOT_WORKS', 17, 'Fire watch is trained in use of this equipment and in sounding alarm', 'FIRE WATCH/HOT WORK AREA MONITORING'), 
('hw18', 'HOT_WORKS', 18, 'Fire watch may be required for adjoining area, above and below', 'FIRE WATCH/HOT WORK AREA MONITORING'), 
('hw19', 'HOT_WORKS', 19, 'Monitor hot work area for 30 minutes after job is completed. Conduct numbers of nearest fire station conspicuously displayed in the area', 'FIRE WATCH/HOT WORK AREA MONITORING'), 
('hw20', 'HOT_WORKS', 20, 'Is area protected with smoke or heat detection', 'FIRE WATCH/HOT WORK AREA MONITORING'), 
('hw21', 'HOT_WORKS', 21, 'Ample ventilation to remove smoke/vapor from work area', 'FIRE WATCH/HOT WORK AREA MONITORING')



