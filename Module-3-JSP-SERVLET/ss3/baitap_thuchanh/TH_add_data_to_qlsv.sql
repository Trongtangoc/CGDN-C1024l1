create database ss3_TH_add_data_to_QLSV;

use ss3_TH_add_data_to_QLSV;
create table Class(
	ClassID int primary key auto_increment,
    ClassName varchar(60) NOT NULL,
    StartDate date NOT NULL,
    Status bit
);
create table Student(
	StudentID int primary key auto_increment,
    StudentName varchar(30) NOT NULL,
    Address varchar(50),
    Phone varchar(20),
    Status bit,
    ClassID int NOT NULL,
    FOREIGN KEY (ClassID) references Class(ClassID)
    );
    create table Subject(
	SubID int primary key auto_increment,
    SubName varchar(30),
    Credit tinyint,
    Status bit default 1
);

create table Mark(
	MarkID int primary key auto_increment,
    SubID int NOT NULL,
    FOREIGN KEY (SubID) references Subject(SubID),
    StudentID int NOT NULL,
    FOREIGN KEY (StudentID) references Student(StudentID),
    Mark float default 0 check (Mark between 0 and 100),
    ExamTimes tinyint default 1
);

INSERT INTO Class
VALUES (1, 'A1', '2008-12-20', 1);
INSERT INTO Class
VALUES (2, 'A2', '2008-12-22', 1);
INSERT INTO Class
VALUES (3, 'B3', current_date, 0);
select * from class;


INSERT INTO Student (StudentName, Address, Phone, Status, ClassId)
VALUES ('Hung', 'Ha Noi', '0912113113', 1, 1);
INSERT INTO Student (StudentName, Address, Status, ClassId)
VALUES ('Hoa', 'Hai phong', 1, 1);
INSERT INTO Student (StudentName, Address, Phone, Status, ClassId)
VALUES ('Manh', 'HCM', '0123123123', 0, 2);
select * from student;
select * from student where status = true;

INSERT INTO Subject
VALUES (1, 'CF', 5, 1),
 (2, 'C', 6, 1),
 (3, 'HDJ', 5, 1),
 (4, 'RDBMS', 10, 1);
 select * from Subject where credit < 10;
 

 
 
 INSERT INTO Mark (SubId, StudentId, Mark, ExamTimes)
VALUES (1, 1, 8, 1),
 (1, 2, 10, 2),
 (2, 1, 12, 1);


 -- join 2 table
 select S.StudentID, S.StudentName, C.ClassName from Student S join Class C on S.ClassID = C.ClassID;
 
 -- Sử dụng câu lệnh Where C.ClassName ='A1' để hiển thị danh sách học viên lớp A1
SELECT S.StudentId, S.StudentName, C.ClassName
FROM Student S join Class C on S.ClassId = C.ClassID
WHERE C.ClassName = 'A1';

-- Hiển thị điểm môn CF của các học viên ; Hiển thị tất cả các điểm đang có của học viên 
SELECT S.StudentId, S.StudentName, Sub.SubName, M.Mark
FROM Student S join Mark M on S.StudentId = M.StudentId join Subject Sub on M.SubId = Sub.SubId;

--  Sử dụng câu lệnh Where để hiển thị điểm môn CF của các học viên
SELECT S.StudentId, S.StudentName, Sub.SubName, M.Mark
FROM Student S join Mark M on S.StudentId = M.StudentId join Subject Sub on M.SubId = Sub.SubId
WHERE Sub.SubName = 'CF';

-- Hiển thị tất cả các sinh viên có tên bắt đầu bảng ký tự ‘h’ 
SELECT * FROM Student 
WHERE StudentName LIKE 'H%';

-- Hiển thị các thông tin lớp học có thời gian bắt đầu vào tháng 12.
SELECT * FROM Class 
WHERE MONTH(StartDate) = 12;

--  Hiển thị tất cả các thông tin môn học có credit trong khoảng từ 3-5.
SELECT * FROM Subject 
WHERE Credit BETWEEN 3 AND 5;

-- Thay đổi mã lớp(ClassID) của sinh viên có tên ‘Hung’ là 2.
UPDATE Student 
SET ClassID = 2 
WHERE StudentName = 'Hung';
 
-- Hiển thị các thông tin: StudentName, SubName, Mark. Dữ liệu sắp xếp theo điểm thi (mark) giảm dần. nếu trùng sắp theo tên tăng dần.
SELECT S.StudentName, Sub.SubName, M.Mark
FROM Student S 
JOIN Mark M ON S.StudentId = M.StudentId 
JOIN Subject Sub ON M.SubId = Sub.SubId
ORDER BY M.Mark DESC, S.StudentName ASC;
 
 