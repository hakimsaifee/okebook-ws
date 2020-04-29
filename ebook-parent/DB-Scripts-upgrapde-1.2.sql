--Artcle table related changes

drop table if exists article cascade;
drop sequence article_seq;
create sequence article_seq start 1 increment 1;
create table article (id int8 not null, article_name varchar(1024), article_path varchar(1024), publish_date timestamp, primary key (id));
