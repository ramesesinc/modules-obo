insert into obo_variable_type (
    objid,
    title,
    sortindex,
    accessory
)
select 
    'BFP_SALES_TAX' as objid,
    'BFP SALES TAX' as title,
    '1' as sortindex,
    null as accessory
;



insert into obo_variable (
    objid,
    state,
    name,
    caption,
    description,
    datatype,
    typeid,
    category,
    sortorder,
    system,
    arrayvalues,
    unit
)
values 
    ('FIRE_ALARM_COST', 'DRAFT', 'FIRE_ALARM_COST', 'FIRE ALARM COST', 'FIRE ALARM COST', 'decimal', 'BFP_SALES_TAX', null, 1, 0, '[]', 'COST'),
    ('FIRE_SUPP_COST', 'DRAFT', 'FIRE_SUPP_COST', 'FIRE SUPP. COST', 'FIRE SUPP. COST', 'decimal', 'BFP_SALES_TAX', null, 4, 0, '[]', 'COST'),
    ('LPG_PIPING_COST', 'DRAFT', 'LPG_PIPING_COST', 'LPG PIPING COST', 'LPG PIPING COST', 'decimal', 'BFP_SALES_TAX', null, 3, 0, '[]', 'COST'),
    ('SPRINKLER_COST', 'DRAFT', 'SPRINKLER_COST', 'SPRINKLER COST', 'SPRINKLER COST', 'decimal', 'BFP_SALES_TAX', null, 2, 0, '[]', 'COST')
 ;


 
CREATE TABLE `online_occupancy_permit_info` (
  `objid` varchar(50) NOT NULL,
  `appid` varchar(50) DEFAULT NULL,
  `parentid` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `stringvalue` varchar(255) DEFAULT NULL,
  `decimalvalue` decimal(18,2) DEFAULT NULL,
  `intvalue` int(11) DEFAULT NULL,
  `datevalue` date DEFAULT NULL,
  `booleanvalue` int(11) DEFAULT NULL,
  PRIMARY KEY (`objid`) USING BTREE,
  UNIQUE KEY `uix_parentid_varname` (`parentid`,`name`),
  KEY `ix_varname` (`name`) USING BTREE,
  KEY `ix_parentid` (`parentid`),
  KEY `fk_occupancy_permit_info_appid` (`appid`),
  CONSTRAINT `fk_occupancy_permit_info_appid` FOREIGN KEY (`appid`) REFERENCES `online_occupancy_permit` (`objid`),
  CONSTRAINT `fk_occupancy_permit_info_name` FOREIGN KEY (`name`) REFERENCES `obo_variable` (`objid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
;


