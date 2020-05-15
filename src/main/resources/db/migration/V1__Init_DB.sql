create table contact (
    id bigserial not null,
    title varchar(255),
    primary key (id)
);
create table summary (
    id bigserial not null,
    date_born date,
    gender varchar(255),
    name varchar(255),
    patronymic varchar(255),
    surname varchar(255),
    primary key (id)
);

create table summary_contacts (
    summary_id int8 not null,
    contact_id int8 not null,
    contacts_key varchar(255) not null,
    primary key (summary_id, contacts_key)
);

create table summary_technology (
    summary_id int8 not null,
    technology_id int8 not null,
    primary key (summary_id, technology_id)
);

create table technology (
    id bigserial not null,
    name varchar(255),
    primary key (id)
);

alter table summary_contacts add constraint summary_contacts_contact_fk foreign key (contact_id) references contact (id);
alter table summary_contacts add constraint summary_contacts_summary_fk foreign key (summary_id) references summary (id);
alter table summary_technology add constraint summary_technology_technology_fk foreign key (technology_id) references technology (id);
alter table summary_technology add constraint summary_technology_summary_fk foreign key (summary_id) references summary (id);