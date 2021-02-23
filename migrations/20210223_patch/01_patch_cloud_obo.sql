alter table obo_professional add orgcode varchar(5)
;

create index ix_orgcode on obo_professional(orgcode)
;

