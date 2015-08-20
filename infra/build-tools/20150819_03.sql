create table roles (role varchar(50), role_desc varchar(100), primary key (role));
create table person_roles (role_id serial,person_id int references person(id), role varchar(50) references roles(role), primary key (role_id));
