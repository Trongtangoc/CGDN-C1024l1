create database demo;

use demo;
drop table Student;
create table Student(
	id int primary key,
    name varchar(200),
    age int,
    country varchar(50) default 'Viet Nam'
);
create table Class(
	id int,
    name varchar(100)
);
drop table Teacher;
create table Teacher(
	id int,
    name varchar(200),
    age int,
    country varchar(50) default 'Viet Nam'
);
insert into Student(id, name, age) values (1, 'Trong', 20);
insert into Student(id, name, age) values (2, 'Minh', 25);
select * from Student
 