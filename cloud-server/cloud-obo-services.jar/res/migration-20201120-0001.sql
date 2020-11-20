
alter table online_occupancy_permit
    add contractor_name varchar(150),
    add contractor_address varchar(150),
    add contractor_pcab_idno varchar(25),
    add contractor_pcab_dtvalid date,
    add contractor_tin varchar(25),
    add contractor_manager_name varchar(150),
    add contractor_manager_email varchar(50)
;