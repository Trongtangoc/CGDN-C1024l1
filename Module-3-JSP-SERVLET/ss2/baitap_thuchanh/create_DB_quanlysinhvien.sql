create database QuanLySinhVien;
use quanlysinhvien;
drop table Class;
create table Class(
	ClassID int primary key auto_increment,
    ClassName varchar(60) NOT NULL,
    StartDate date NOT NULL,
    Status bit
);


drop table Student;
create table Student(
	StudentID int primary key auto_increment,
    StudentName varchar(30) NOT NULL,
    Address varchar(50),
    Phone varchar(20),
    Status bit,
    ClassID int NOT NULL,
    FOREIGN KEY (ClassID) references Class(ClassID)
    );
drop table Subject;
create table Subject(
	SubID int primary key auto_increment,
    SubName varchar(30),
    Credit tinyint,
    Status bit default 1
);
drop table Mark;
create table Mark(
	MarkID int primary key auto_increment,
    SubID int NOT NULL,
    FOREIGN KEY (SubID) references Subject(SubID),
    StudentID int NOT NULL,
    FOREIGN KEY (StudentID) references Student(StudentID),
    Mark float default 0 check (Mark between 0 and 100),
    ExamTimes tinyint default 1
);
SELECT * FROM Class;
SELECT * FROM Student;
INSERT INTO Class VALUES (1, 'c124m1', '2024-01-01', 1);
INSERT INTO Class VALUES (2, 'c224m2', '2024-02-01', 1);
INSERT INTO Class VALUES (3, 'c324m3', '2024-03-01', 1);
INSERT INTO Class VALUES (4, 'c424m4', '2024-04-01', 1);
INSERT INTO Class VALUES (5, 'c524m5', '2024-05-01', 1);
INSERT INTO Student VALUES (1, 'Ha Anh', 'Da Nang', 0973728910, 1, 1);
INSERT INTO Student VALUES (2, 'Van Ha', 'Vinh', 0973728912, 1, 2);
INSERT INTO Student VALUES (3, 'Vu Bang', 'Ha Noi', 0973728913, 1, 3);
INSERT INTO Student VALUES (4, 'Thu Minh', 'Da Nang', 0973728914, 1, 4);
INSERT INTO Student VALUES (5, 'Hai An', 'Ha Noi', 0973728915, 1, 5);


 