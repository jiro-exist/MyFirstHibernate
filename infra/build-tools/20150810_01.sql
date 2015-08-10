alter table person drop column gender_code;
alter table person add column gender varchar(10);
drop table if exists gender;
