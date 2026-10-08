-- V3__create_application.sql


create table applications (
                         id bigserial primary key,
                         worker_id bigint not null,
                         application_date date not null,
                         reason varchar,
                         status varchar not null DEFAULT 'SUBMITTED',
                         constraint fk_workers_applications
                             foreign key (worker_id) references workers(id)
);

