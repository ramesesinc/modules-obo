alter table online_occupancy_permit add bldgpermit_dtproposedconstruction date;
alter table online_occupancy_permit add bldgpermit_dtexpectedcompletion date;
alter table online_occupancy_permit add bldgpermit_totalfloorarea decimal(16,2);
alter table online_occupancy_permit add bldgpermit_numfloors int;
alter table online_occupancy_permit add bldgpermit_numunits decimal(16,2);
alter table online_occupancy_permit add profarchitectid varchar(50);
alter table online_occupancy_permit add profcivilid varchar(50);
alter table online_occupancy_permit add profelectricalid varchar(50);
alter table online_occupancy_permit add profmechanicalid varchar(50);
alter table online_occupancy_permit add profsanitaryid varchar(50);
alter table online_occupancy_permit add profplumbingid varchar(50);
alter table online_occupancy_permit add profelectronicid varchar(50);
alter table online_occupancy_permit add profinteriorid varchar(50);
alter table online_occupancy_permit add supervisorelectricalid varchar(50);
alter table online_occupancy_permit add supervisormechanicalid varchar(50);
alter table online_occupancy_permit add supervisorsanitaryid varchar(50);
alter table online_occupancy_permit add supervisorplumbingid varchar(50);
alter table online_occupancy_permit add supervisorelectronicid varchar(50);
alter table online_occupancy_permit add supervisorinteriorid varchar(50);
alter table online_occupancy_permit add dtactualstarted date;
alter table online_occupancy_permit add dtactualcompleted date;

alter table online_occupancy_permit add totalmaterialcost decimal(16,2) default 0;
alter table online_occupancy_permit add totaldirectlaborcost decimal(16,2) default 0;
alter table online_occupancy_permit add totalequipmentcost decimal(16,2) default 0;
alter table online_occupancy_permit add totalothercost decimal(16,2) default 0;

alter table online_occupancy_permit change column bldgpermit_controlno bldgpermit_permitno varchar(25);


CREATE VIEW `vw_online_occupancy_permit_professional` 
AS 
select 
	`a`.`objid` AS `objid`,
	`a`.`appid` AS `appid`,
	`a`.`entityid` AS `entityid`,
	`a`.`profession` AS `profession`,
	`a`.`ptr` AS `ptr`,
	`a`.`prc` AS `prc`,
	`e`.`name` AS `name`,
	`e`.`firstname` AS `firstname`,
	`e`.`lastname` AS `lastname`,
	`e`.`middlename` AS `middlename`,
	`e`.`address_text` AS `address_text`,
	`e`.`tin` AS `tin`,
	`e`.`id` AS `id` 
from (`online_occupancy_permit_professional` `a` 
	join `online_occupancy_permit_entity` `e` on((`a`.`entityid` = `e`.`objid`)))
;


