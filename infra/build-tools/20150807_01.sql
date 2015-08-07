drop database if exists hibernate_ex;
create database hibernate_ex;
\connect hibernate_ex
create table gender (gender_code varchar(10) PRIMARY KEY, gender_desc varchar(20));
create table contact_type (contact_code varchar(10) PRIMARY KEY, contact_desc varchar(20));
create table person (id serial PRIMARY KEY, first_name varchar(50), middle_name varchar(50), last_name varchar(50), 
	gender_code varchar(10) references gender(gender_code), birthday date, is_employed boolean, gwa decimal(5,3));
create table address (id int references person(id), house_number varchar(50), street varchar(50), 
	barangay varchar(50), subdivision varchar(50), city varchar(50), zip_code varchar(20));
create table contact (id int references person(id), contact_code varchar(10) references contact_type(contact_code), 
	contact_value varchar(50), PRIMARY KEY (contact_code, contact_value));


insert into gender (gender_code, gender_desc) values ('m','male'), ('f','female');
insert into contact_type (contact_code, contact_desc) values ('mobile','mobile number'), ('landline','landline number'), ('email','email address');