create database joins;

use joins;

-- ==========================
-- STUDENT TABLE
-- ==========================

CREATE TABLE Student (
    ht_number VARCHAR(10) PRIMARY KEY,
    name VARCHAR(50),
    gender CHAR(1),
    dept_id INT
);

INSERT INTO Student VALUES
('S101','Aarav','M',101),
('S102','Bhavana','F',102),
('S103','Charan','M',103),
('S104','Divya','F',101),
('S105','Eshwar','M',104),
('S106','Farah','F',102),
('S107','Gopal','M',105),
('S108','Harini','F',103),
('S109','Ishaan','M',104),
('S110','Jyothi','F',106);



-- ==========================
-- DEPARTMENT TABLE
-- ==========================

CREATE TABLE Dept (
    dept_id INT PRIMARY KEY,
    dept_name VARCHAR(50),
    hod_id INT
);

INSERT INTO Dept VALUES
(101,'Computer Science',201),
(102,'Information Technology',202),
(103,'Electronics',203),
(104,'Mechanical',204),
(105,'Civil',205),
(106,'Artificial Intelligence',206),
(107,'Electrical',207);



-- ==========================
-- FACULTY TABLE
-- ==========================

CREATE TABLE Faculty (
    f_id INT PRIMARY KEY,
    f_name VARCHAR(50),
    yoe INT
);

INSERT INTO Faculty VALUES
(201,'Dr. Ramesh',18),
(202,'Dr. Sridevi',15),
(203,'Dr. Vinod',20),
(204,'Dr. Mahesh',12),
(205,'Dr. Kavitha',16),
(206,'Dr. Prakash',10),
(207,'Dr. Sunitha',22),
(208,'Dr. Kiran',8),
(209,'Dr. Lakshmi',14),
(210,'Dr. Manoj',11);



-- ==========================
-- FEE TABLE
-- ==========================

CREATE TABLE Fee (
    fee_id INT PRIMARY KEY,
    ht_number VARCHAR(10),
    amount DECIMAL(10,2)
);

INSERT INTO Fee VALUES
(1,'S101',45000),
(2,'S102',50000),
(3,'S103',42000),
(4,'S104',45000),
(5,'S105',48000),
(6,'S106',50000),
(7,'S107',41000),
(8,'S108',47000),
(9,'S109',49000),
(10,'S110',53000),
(11,'S111',45000);


select * from student;
select * from dept;
select * from fee;
select * from faculty;




select s.ht_number,s.name,s.dept_id,d.dept_name
	from student s
    join dept d
    on s.dept_id = d.dept_id;



select d.dept_name,count(*)
	from student s
    join dept d
    on s.dept_id = d.dept_id
    group by d.dept_name;
    
    
select s.ht_number,s.name,fe.amount,d.dept_id,d.dept_name,d.hod_id,f.f_name
	from student s
    join dept d
    on s.dept_id = d.dept_id
    join fee fe
    on fe.ht_number = s.ht_number
    join faculty f
    on f.f_id = d.hod_id;
    
select * from faculty;
select * from fee;
select * from student;

INSERT INTO Fee VALUES
			(12,'S113',45000),
            (13,'S112',45000),
            (14,'S114',45000);
            
select s.ht_number,fe.amount
	from student s
    right join fee fe	
    on fe.ht_number = s.ht_number;