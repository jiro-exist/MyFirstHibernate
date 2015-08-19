alter table contact drop constraint contact_pkey;
alter table contact add primary key (id, contact_code, contact_value);
