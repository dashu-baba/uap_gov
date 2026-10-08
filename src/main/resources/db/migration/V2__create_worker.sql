-- V2__create_workers.sql
create table workers (
                          id bigserial primary key,
                          nid varchar(17) not null unique,
                          name varchar(255) not null,
                          mobile varchar(13) not null
);