-- Drop CONSTRAINTS
alter table section drop constraint EFK_SECTION
alter table section_regulation drop constraint EFK_SEC_REG_ID
alter table section_regulation drop constraint EFK_SEC_REG_SID
alter table section_rule drop constraint EFK_SEC_RULE_ID
alter table section_rule drop constraint EFK_SEC_RULE_SID
alter table user_role drop constraint EFK_USR_RULE_ID
alter table user_role drop constraint EFK_USR_RULE_UID
-- Drop Tables 	--
drop table if exists notification cascade;
drop table if exists part cascade;
drop table if exists regulation cascade;
drop table if exists role cascade;
drop table if exists rule cascade;
drop table if exists section cascade;
drop table if exists section_regulation cascade;
drop table if exists section_rule cascade;
drop table if exists user_detail cascade;
drop table if exists user_role cascade;

-- Drop Sequence
drop sequence auto;
drop sequence part_seq;
----
-- Create Sequence
create sequence auto start 1 increment 1;
create sequence part_seq start 1 increment 1;

--Create Table

create table notification (id int8 not null, notification_heading TEXT not null, notification_number numeric(10, 2) not null, primary key (id))
create table part (id int8 not null, part_heading TEXT not null, part_number numeric(10, 2) not null, primary key (id))
create table regulation (id int8 not null, regulation_heading TEXT not null, regulation_number numeric(10, 2) not null, primary key (id))
create table role (id int8 not null, role_type varchar(100) not null, primary key (id))
create table rule (id int8 not null, rule_heading TEXT not null, rule_number numeric(10, 2) not null, primary key (id))
create table section (id int8 not null, section_heading TEXT not null, section_number numeric(10, 2) not null, part_id int8, primary key (id))
create table section_regulation (section_id int8 not null, regulation_id int8 not null, primary key (section_id, regulation_id))
create table section_rule (section_id int8 not null, rule_id int8 not null, primary key (section_id, rule_id))
create table user_detail (id int8 not null, eamil_id varchar(100), password varchar(100) not null, username varchar(512) not null, primary key (id))
create table user_role (user_id int8 not null, role_id int8 not null, primary key (user_id, role_id))

--Alter Tables

alter table section add constraint EFK_SECTION foreign key (part_id) references part;
alter table section_regulation add constraint EFK_SEC_REG_ID foreign key (regulation_id) references regulation;
alter table section_regulation add constraint EFK_SEC_REG_SID foreign key (section_id) references section;
alter table section_rule add constraint EFK_SEC_RULE_ID foreign key (rule_id) references rule;
alter table section_rule add constraint EFK_SEC_RULE_SID foreign key (section_id) references section;
alter table user_role add constraint EFK_USR_RULE_ID foreign key (role_id) references role;
alter table user_role add constraint EFK_USR_RULE_UID foreign key (user_id) references user_detail;
