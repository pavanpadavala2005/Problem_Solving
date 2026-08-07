create database princeCollege;
use princeCollege;


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
('S110','Jyothi','F',106),
('S111','Kiran','M',101),
('S112','Lavanya','F',102),
('S113','Manoj','M',103),
('S114','Nandhini','F',105),
('S115','Omkar','M',106),
('S116','Pooja','F',104),
('S117','Rahul','M',101),
('S118','Sneha','F',103),
('S119','Tarun','M',105),
('S120','Vaishnavi','F',102);


CREATE TABLE Department (
    dept_id INT PRIMARY KEY,
    dept_name VARCHAR(50),
    hod_id INT
);

INSERT INTO Department VALUES
(101,'Computer Science',201),
(102,'Information Technology',202),
(103,'Electronics',203),
(104,'Mechanical',204),
(105,'Civil',205),
(106,'Artificial Intelligence',206),
(107,'Electrical',207),
(108,'Data Science',208);


CREATE TABLE Faculty (
    faculty_id INT PRIMARY KEY,
    faculty_name VARCHAR(50),
    qualification VARCHAR(30),
    experience INT,
    dept_id INT
);

INSERT INTO Faculty VALUES
(201,'Dr. Ramesh','PhD',18,101),
(202,'Dr. Sridevi','PhD',15,102),
(203,'Dr. Vinod','PhD',20,103),
(204,'Dr. Mahesh','M.Tech',12,104),
(205,'Dr. Kavitha','PhD',16,105),
(206,'Dr. Prakash','PhD',10,106),
(207,'Dr. Sunitha','PhD',22,107),
(208,'Dr. Kiran','M.Tech',8,108),
(209,'Dr. Lakshmi','PhD',14,101),
(210,'Dr. Manoj','M.Tech',11,102),
(211,'Dr. Raju','PhD',17,103),
(212,'Dr. Swathi','M.Tech',9,104);


CREATE TABLE Fee (
    fee_id INT PRIMARY KEY,
    ht_number VARCHAR(10),
    amount DECIMAL(10,2),
    fee_type VARCHAR(20)
);

INSERT INTO Fee VALUES
(1,'S101',45000,'Tuition'),
(2,'S102',50000,'Tuition'),
(3,'S103',42000,'Hostel'),
(4,'S104',45000,'Transport'),
(5,'S105',48000,'Tuition'),
(6,'S106',50000,'Hostel'),
(7,'S107',41000,'Exam'),
(8,'S108',47000,'Tuition'),
(9,'S109',49000,'Transport'),
(10,'S110',53000,'Tuition'),
(11,'S111',46000,'Exam'),
(12,'S112',47000,'Hostel'),
(13,'S113',51000,'Transport'),
(14,'S114',42000,'Tuition'),
(15,'S115',55000,'Tuition'),
(16,'S121',50000,'Hostel');



CREATE TABLE Library (
    book_id INT PRIMARY KEY,
    book_name VARCHAR(100),
    author VARCHAR(50),
    ht_number VARCHAR(10)
);

INSERT INTO Library VALUES
(1001,'Database Systems','Korth','S101'),
(1002,'Operating Systems','Galvin','S103'),
(1003,'Java Complete Reference','Herbert','S105'),
(1004,'Python Crash Course','Eric','S102'),
(1005,'Computer Networks','Tanenbaum','S108'),
(1006,'Machine Learning','Tom Mitchell','S110'),
(1007,'C Programming','Dennis','S111'),
(1008,'Data Structures','Narasimha Karumanchi','S115'),
(1009,'Artificial Intelligence','Russell','S117'),
(1010,'SQL Cookbook','OReilly','S125');

CREATE TABLE Bus (
    bus_id INT PRIMARY KEY,
    bus_no VARCHAR(20),
    route VARCHAR(50),
    ht_number VARCHAR(10)
);

INSERT INTO Bus VALUES
(1,'TN01AB1234','Chennai','S101'),
(2,'TN02AB1235','Coimbatore','S102'),
(3,'TN03AB1236','Madurai','S104'),
(4,'TN04AB1237','Salem','S105'),
(5,'TN05AB1238','Tiruchirappalli','S106'),
(6,'TN06AB1239','Tirunelveli','S108'),
(7,'TN07AB1240','Erode','S111'),
(8,'TN08AB1241','Vellore','S118'),
(9,'TN09AB1242','Thanjavur','S120'),
(10,'TN10AB1243','Thoothukudi','S130');


CREATE TABLE Attendance (
    attendance_id INT PRIMARY KEY,
    ht_number VARCHAR(10),
    attendance_percent DECIMAL(5,2)
);

INSERT INTO Attendance VALUES
(1,'S101',95.5),
(2,'S102',92.0),
(3,'S103',88.5),
(4,'S104',97.2),
(5,'S105',80.5),
(6,'S106',85.0),
(7,'S107',91.0),
(8,'S108',78.4),
(9,'S109',96.1),
(10,'S110',89.9),
(11,'S111',82.5),
(12,'S112',93.7),
(13,'S113',86.4),
(14,'S114',90.8),
(15,'S121',75.2);


CREATE TABLE Hostel (
    room_no INT,
    block_name CHAR(1),
    ht_number VARCHAR(10),
    fee_paid VARCHAR(5)
);

INSERT INTO Hostel VALUES
(101,'A','S101','YES'),
(102,'A','S102','YES'),
(103,'B','S103','NO'),
(104,'B','S105','YES'),
(105,'C','S106','YES'),
(106,'A','S108','NO'),
(107,'C','S109','YES'),
(108,'A','S112','YES'),
(109,'B','S115','NO'),
(110,'C','S118','YES'),
(111,'A','S122','YES');




INSERT INTO Library VALUES
(1011,'Database Systems','Korth','S102'),
(1012,'Java Complete Reference','Herbert Schildt','S104'),
(1013,'Python Crash Course','Eric Matthes','S106'),
(1014,'Operating Systems','Galvin','S107'),
(1015,'Computer Networks','Tanenbaum','S109'),
(1016,'Artificial Intelligence','Russell & Norvig','S112'),
(1017,'Data Structures','Narasimha Karumanchi','S113'),
(1018,'SQL Cookbook','Anthony Molinaro','S114'),
(1019,'Clean Code','Robert C. Martin','S115'),
(1020,'Design Patterns','Gang of Four','S116'),
(1021,'Database Systems','Korth','S117'),
(1022,'Java Complete Reference','Herbert Schildt','S118'),
(1023,'Python Crash Course','Eric Matthes','S119'),
(1024,'Operating Systems','Galvin','S120'),
(1025,'Clean Code','Robert C. Martin','S101'),
(1026,'Design Patterns','Gang of Four','S103'),
(1027,'Computer Networks','Tanenbaum','S105'),
(1028,'Artificial Intelligence','Russell & Norvig','S108'),
(1029,'Database Systems','Korth','S110'),
(1030,'Machine Learning','Tom Mitchell','S123');




select * from student;
select * from Department;
select * from Faculty;
select * from fee;
select * from Library;
select * from bus;
select * from Attendance;
select * from Hostel;


-- 1) print all student ht_number,name who not paid Hostel fee
	
select ht_number,name 
	from student where 
		ht_number  in (
			select s.ht_number
				from Student s
				left join Fee f
				on f.ht_number = s.ht_number
				where f.fee_type != "Hostel"
    );
    
    
select s.ht_number,s.name,b.bus_no
	from student s
    join bus b
    on s.ht_number = b.ht_number
    join fee fe
    on fe.ht_number = s.ht_number
    where fe.fee_type = "Tuition";
    