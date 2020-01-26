create database if not exists sam;
use sam;
create table if not exists user(
id bigint primary key auto_increment,
name varchar(255),
email varchar(255),
mobile_no bigint);
drop table registration;
select * from registration;
