CREATE TABLE `sys_email_queue` (
  `objid` varchar(50) CHARACTER SET latin1 NOT NULL,
  `refid` varchar(50) DEFAULT NULL,
  `state` int(1) DEFAULT NULL,
  `reportid` varchar(50) DEFAULT NULL,
  `dtsent` datetime DEFAULT NULL,
  `to` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  `subject` varchar(255) DEFAULT NULL,
  `message` mediumtext,
  `errmsg` varchar(255) DEFAULT NULL,
  `connection` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`objid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
;

CREATE TABLE `sys_email_template` (
  `objid` varchar(50) NOT NULL,
  `subject` varchar(255) DEFAULT NULL,
  `message` mediumtext,
  PRIMARY KEY (`objid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
;


alter table obo_permit_type add includecost int default 0
;

update obo_permit_type set includecost = 1 
where objid in ('plumbing', 'electrical', 'electronic', 'mechanical')
;


CREATE TABLE `obo_contactinfo` (
  `orgcode` varchar(50) NOT NULL,
  `officename` varchar(255) DEFAULT NULL,
  `address1` varchar(255) DEFAULT NULL,
  `address2` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phoneno` varchar(50) DEFAULT NULL,
  `mobileno` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`orgcode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
;


INSERT INTO `obo_contactinfo` (`orgcode`, `officename`, `address1`, `address2`, `email`, `phoneno`, `mobileno`) 
VALUES ('137', 'One Stop Shop for Constuction Permits (OSCP)', 'Ground Floor, City Enginerring Office', 'Miguel Lopez de Legazpi Boulevard, Dapdap Legazpi City', NULL, NULL, NULL)
;


