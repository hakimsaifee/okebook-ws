-- Drop CONSTRAINTS
alter table case_detail drop constraint FK6uq5waep9s6dkptvydjki5skk;

-- Drop Tables 
drop table if exists case_detail cascade
drop table if exists company cascade
drop table if exists image_detail cascade;

-- Drop Sequence
drop sequence case_detail_seq;
drop sequence company_seq;
drop sequence image_detail_seq;

-- Create Sequence
create sequence case_detail_seq start 1 increment 1;
create sequence company_seq start 1 increment 1;
create sequence image_detail_seq start 1 increment 1;

--Create Table

create table case_detail (id int8 not null, case_detail varchar(1024), case_document_description varchar(1024), case_document_path varchar(1024), case_id varchar(100), created_ts timestamp not null, company_id int8, primary key (id));

create table company (id int8 not null, company_detail varchar(1024), company_id varchar(100), company_name varchar(1024) not null, primary key (id));

create table image_detail (id int8 not null, description varchar(512), image_name varchar(1024) not null, updated_ts timestamp not null, primary key (id));

--Alter Tables
alter table case_detail add constraint FK6uq5waep9s6dkptvydjki5skk foreign key (company_id) references company;

--drop not null constraint.
alter table case_detail alter column created_ts drop not null;
