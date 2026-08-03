use practiece;
CREATE TABLE Student (
    StudentID INT PRIMARY KEY,
    Name VARCHAR(50),
    Age INT,
    Gender VARCHAR(10),
    City VARCHAR(50),
    Course VARCHAR(30),
    Marks INT,
    Fee DECIMAL(10,2),
    AdmissionYear INT
);

INSERT INTO Student VALUES
(1,'Aarav',18,'Male','Delhi','BCA',78,35000,2024),
(2,'Ananya',19,'Female','Mumbai','B.Tech',85,60000,2023),
(3,'Rohan',20,'Male','Chennai','B.Sc',67,30000,2022),
(4,'Priya',18,'Female','Hyderabad','BCA',91,35000,2024),
(5,'Karan',21,'Male','Bangalore','B.Tech',74,60000,2021),
(6,'Sneha',19,'Female','Pune','B.Com',88,25000,2023),
(7,'Rahul',20,'Male','Delhi','B.Sc',59,30000,2022),
(8,'Meera',22,'Female','Kolkata','MBA',81,70000,2021),
(9,'Arjun',18,'Male','Mumbai','BCA',69,35000,2024),
(10,'Divya',19,'Female','Chennai','B.Tech',92,60000,2023),
(11,'Vikram',20,'Male','Hyderabad','B.Sc',75,30000,2022),
(12,'Pooja',18,'Female','Delhi','BCA',84,35000,2024),
(13,'Nikhil',21,'Male','Pune','MBA',73,70000,2021),
(14,'Aisha',20,'Female','Bangalore','B.Tech',89,60000,2022),
(15,'Varun',19,'Male','Mumbai','B.Com',64,25000,2023),
(16,'Neha',18,'Female','Delhi','BCA',79,35000,2024),
(17,'Aditya',22,'Male','Kolkata','MBA',82,70000,2021),
(18,'Kavya',20,'Female','Chennai','B.Sc',95,30000,2022),
(19,'Harsha',21,'Male','Hyderabad','B.Tech',68,60000,2021),
(20,'Sanya',19,'Female','Pune','BCA',87,35000,2023),
(21,'Manoj',18,'Male','Delhi','B.Sc',55,30000,2024),
(22,'Ritika',20,'Female','Mumbai','MBA',90,70000,2022),
(23,'Ajay',19,'Male','Bangalore','B.Tech',71,60000,2023),
(24,'Ishita',18,'Female','Hyderabad','BCA',93,35000,2024),
(25,'Deepak',21,'Male','Chennai','B.Com',66,25000,2021),
(26,'Nisha',20,'Female','Delhi','B.Sc',83,30000,2022),
(27,'Surya',19,'Male','Pune','BCA',77,35000,2023),
(28,'Bhavya',18,'Female','Mumbai','B.Tech',80,60000,2024),
(29,'Akash',22,'Male','Kolkata','MBA',72,70000,2021),
(30,'Sowmya',21,'Female','Bangalore','BCA',94,35000,2021),
(31,'Tarun',18,'Male','Delhi','B.Tech',61,60000,2024),
(32,'Lavanya',19,'Female','Hyderabad','B.Com',86,25000,2023),
(33,'Rakesh',20,'Male','Chennai','B.Sc',74,30000,2022),
(34,'Anjali',18,'Female','Mumbai','BCA',88,35000,2024),
(35,'Sandeep',21,'Male','Pune','MBA',79,70000,2021),
(36,'Keerthi',20,'Female','Delhi','B.Tech',97,60000,2022),
(37,'Girish',19,'Male','Bangalore','B.Sc',63,30000,2023),
(38,'Swathi',18,'Female','Hyderabad','BCA',84,35000,2024),
(39,'Praveen',22,'Male','Kolkata','MBA',76,70000,2021),
(40,'Reshma',20,'Female','Chennai','B.Tech',91,60000,2022),
(41,'Mahesh',18,'Male','Delhi','BCA',70,35000,2024),
(42,'Pallavi',19,'Female','Mumbai','B.Com',82,25000,2023),
(43,'Kishore',20,'Male','Hyderabad','B.Sc',69,30000,2022),
(44,'Bhavana',18,'Female','Pune','BCA',90,35000,2024),
(45,'Ravi',21,'Male','Bangalore','MBA',73,70000,2021),
(46,'Shreya',20,'Female','Delhi','B.Tech',85,60000,2022),
(47,'Naveen',19,'Male','Mumbai','B.Sc',62,30000,2023),
(48,'Madhuri',18,'Female','Chennai','BCA',81,35000,2024),
(49,'Lokesh',22,'Male','Hyderabad','MBA',78,70000,2021),
(50,'Harini',20,'Female','Pune','B.Tech',96,60000,2022),
(51,'Abhishek',18,'Male','Delhi','BCA',72,35000,2024),
(52,'Anu',19,'Female','Mumbai','B.Com',87,25000,2023),
(53,'Sai',20,'Male','Chennai','B.Sc',75,30000,2022),
(54,'Nandini',18,'Female','Hyderabad','BCA',89,35000,2024),
(55,'Yash',21,'Male','Bangalore','MBA',68,70000,2021),
(56,'Deepa',20,'Female','Delhi','B.Tech',92,60000,2022),
(57,'Roshan',19,'Male','Pune','B.Sc',65,30000,2023),
(58,'Chitra',18,'Female','Mumbai','BCA',83,35000,2024),
(59,'Karthik',22,'Male','Kolkata','MBA',80,70000,2021),
(60,'Vaishnavi',20,'Female','Chennai','B.Tech',94,60000,2022),
(61,'Ashwin',18,'Male','Delhi','BCA',71,35000,2024),
(62,'Siri',19,'Female','Hyderabad','B.Com',88,25000,2023),
(63,'Raghu',20,'Male','Bangalore','B.Sc',64,30000,2022),
(64,'Tejaswi',18,'Female','Pune','BCA',90,35000,2024),
(65,'Dinesh',21,'Male','Mumbai','MBA',77,70000,2021),
(66,'Pavithra',20,'Female','Delhi','B.Tech',95,60000,2022),
(67,'Vinay',19,'Male','Chennai','B.Sc',60,30000,2023),
(68,'Shalini',18,'Female','Hyderabad','BCA',82,35000,2024),
(69,'Mohan',22,'Male','Kolkata','MBA',74,70000,2021),
(70,'Apoorva',20,'Female','Pune','B.Tech',91,60000,2022),
(71,'Suresh',18,'Male','Delhi','BCA',67,35000,2024),
(72,'Jyothi',19,'Female','Mumbai','B.Com',86,25000,2023),
(73,'Ganesh',20,'Male','Bangalore','B.Sc',79,30000,2022),
(74,'Monika',18,'Female','Chennai','BCA',93,35000,2024),
(75,'Krishna',21,'Male','Hyderabad','MBA',75,70000,2021),
(76,'Rekha',20,'Female','Delhi','B.Tech',84,60000,2022),
(77,'Naresh',19,'Male','Pune','B.Sc',66,30000,2023),
(78,'Sujatha',18,'Female','Mumbai','BCA',88,35000,2024),
(79,'Ramu',22,'Male','Kolkata','MBA',81,70000,2021),
(80,'Anitha',20,'Female','Bangalore','B.Tech',97,60000,2022),
(81,'Kiran',18,'Male','Delhi','BCA',69,35000,2024),
(82,'Bhargavi',19,'Female','Hyderabad','B.Com',85,25000,2023),
(83,'Charan',20,'Male','Chennai','B.Sc',73,30000,2022),
(84,'Navya',18,'Female','Pune','BCA',92,35000,2024),
(85,'Uday',21,'Male','Mumbai','MBA',70,70000,2021),
(86,'Lakshmi',20,'Female','Delhi','B.Tech',89,60000,2022),
(87,'Prasad',19,'Male','Bangalore','B.Sc',61,30000,2023),
(88,'Anusha',18,'Female','Hyderabad','BCA',86,35000,2024),
(89,'Srinivas',22,'Male','Kolkata','MBA',78,70000,2021),
(90,'Gayathri',20,'Female','Chennai','B.Tech',93,60000,2022),
(91,'Bharath',18,'Male','Delhi','BCA',76,35000,2024),
(92,'Indu',19,'Female','Mumbai','B.Com',90,25000,2023),
(93,'Jagadeesh',20,'Male','Hyderabad','B.Sc',62,30000,2022),
(94,'Mounika',18,'Female','Pune','BCA',87,35000,2024),
(95,'Rohit',21,'Male','Bangalore','MBA',74,70000,2021),
(96,'Snehal',20,'Female','Delhi','B.Tech',96,60000,2022),
(97,'Venu',19,'Male','Chennai','B.Sc',65,30000,2023),
(98,'Anita',18,'Female','Mumbai','BCA',91,35000,2024),
(99,'Suman',22,'Male','Hyderabad','MBA',79,70000,2021),
(100,'Preethi',20,'Female','Pune','B.Tech',98,60000,2022);

select * from student;


select max(marks), min(marks), avg(marks) from student;

-- ! Nested Query Syntax
-- SELECT column_name
-- FROM table_name
-- WHERE column_name OPERATOR (
--     SELECT column_name
--     FROM another_table
-- );

-- Nested Query-- 
-- │
-- ├── Single Row Subquery
-- ├── Multiple Row Subquery
-- ├── Multiple Column Subquery
-- ├── Correlated Subquery
-- └── Nested Subquery in FROM
 
 
 
-- ! 1. Single Row Subquery
-- * Inner will executes first and outer Later

select StudentID,Name,marks from student
	where marks >= (
		select avg(marks) from student
	);
    
-- ! 2. Multiple Row Subquery
-- * Inner query returns multiple values rather single value 

select StudentID,Name,Course from student
	where Course in (
		select Course from student
			where Fee <= 30000
    );
    
    
-- ! 3.Multiple Column Subquery
-- Here we will be Comparing multiple Columns from the Inner Query
select StudentID,Name,Course from student
	where (Course,AdmissionYear) in (
		select Course,AdmissionYear from student
			where fee >= 1000
    );


-- 4. Correlated Subquery
-- Every querey is based on inner Query everytime it will run 
select StudentID,Name,Age 
	from student s1
    where Marks >= (
		select avg(Marks)*1.2
			from student s2
            where s1.Course = s2.Course
    );



select Course,count(*),max(Marks)
	from student
	group by Course;


CREATE DATABASE IF NOT EXISTS company_db;
USE company_db;

DROP TABLE IF EXISTS employees;

CREATE TABLE employees (
    employee_id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    department VARCHAR(50) NOT NULL,
    salary DECIMAL(10, 2) NOT NULL,
    joining_date DATE NOT NULL
);

INSERT INTO employees
    (employee_id, first_name, last_name, email, department, salary, joining_date)
VALUES
(1, 'Aarav', 'Sharma', 'aarav.sharma1@company.com', 'Engineering', 28000.00, '2018-01-01'),
(2, 'Aditi', 'Reddy', 'aditi.reddy2@company.com', 'HR', 30500.00, '2019-02-02'),
(3, 'Akash', 'Kumar', 'akash.kumar3@company.com', 'Finance', 33000.00, '2020-03-03'),
(4, 'Ananya', 'Patel', 'ananya.patel4@company.com', 'Sales', 35500.00, '2021-04-04'),
(5, 'Arjun', 'Rao', 'arjun.rao5@company.com', 'Marketing', 38000.00, '2022-05-05'),
(6, 'Bhavana', 'Singh', 'bhavana.singh6@company.com', 'Operations', 40500.00, '2023-06-06'),
(7, 'Charan', 'Verma', 'charan.verma7@company.com', 'Support', 43000.00, '2024-07-07'),
(8, 'Deepika', 'Nair', 'deepika.nair8@company.com', 'IT', 45500.00, '2025-08-08'),
(9, 'Dev', 'Gupta', 'dev.gupta9@company.com', 'Administration', 48000.00, '2018-09-09'),
(10, 'Divya', 'Iyer', 'divya.iyer10@company.com', 'Research', 50500.00, '2019-10-10'),

(11, 'Farhan', 'Sharma', 'farhan.sharma11@company.com', 'Engineering', 53000.00, '2020-11-11'),
(12, 'Gauri', 'Reddy', 'gauri.reddy12@company.com', 'HR', 55500.00, '2021-12-12'),
(13, 'Harish', 'Kumar', 'harish.kumar13@company.com', 'Finance', 58000.00, '2022-01-13'),
(14, 'Ishita', 'Patel', 'ishita.patel14@company.com', 'Sales', 60500.00, '2023-02-14'),
(15, 'Jatin', 'Rao', 'jatin.rao15@company.com', 'Marketing', 63000.00, '2024-03-15'),
(16, 'Kavya', 'Singh', 'kavya.singh16@company.com', 'Operations', 65500.00, '2025-04-16'),
(17, 'Kiran', 'Verma', 'kiran.verma17@company.com', 'Support', 68000.00, '2018-05-17'),
(18, 'Lakshmi', 'Nair', 'lakshmi.nair18@company.com', 'IT', 70500.00, '2019-06-18'),
(19, 'Manoj', 'Gupta', 'manoj.gupta19@company.com', 'Administration', 73000.00, '2020-07-19'),
(20, 'Meera', 'Iyer', 'meera.iyer20@company.com', 'Research', 75500.00, '2021-08-20'),

(21, 'Naveen', 'Sharma', 'naveen.sharma21@company.com', 'Engineering', 29500.00, '2022-09-21'),
(22, 'Neha', 'Reddy', 'neha.reddy22@company.com', 'HR', 32000.00, '2023-10-22'),
(23, 'Omkar', 'Kumar', 'omkar.kumar23@company.com', 'Finance', 34500.00, '2024-11-23'),
(24, 'Pooja', 'Patel', 'pooja.patel24@company.com', 'Sales', 37000.00, '2025-12-24'),
(25, 'Pranav', 'Rao', 'pranav.rao25@company.com', 'Marketing', 39500.00, '2018-01-25'),
(26, 'Priya', 'Singh', 'priya.singh26@company.com', 'Operations', 42000.00, '2019-02-26'),
(27, 'Rahul', 'Verma', 'rahul.verma27@company.com', 'Support', 44500.00, '2020-03-27'),
(28, 'Riya', 'Nair', 'riya.nair28@company.com', 'IT', 47000.00, '2021-04-28'),
(29, 'Rohit', 'Gupta', 'rohit.gupta29@company.com', 'Administration', 49500.00, '2022-05-01'),
(30, 'Saanvi', 'Iyer', 'saanvi.iyer30@company.com', 'Research', 52000.00, '2023-06-02'),

(31, 'Sachin', 'Sharma', 'sachin.sharma31@company.com', 'Engineering', 54500.00, '2024-07-03'),
(32, 'Sakshi', 'Reddy', 'sakshi.reddy32@company.com', 'HR', 57000.00, '2025-08-04'),
(33, 'Sanjay', 'Kumar', 'sanjay.kumar33@company.com', 'Finance', 59500.00, '2018-09-05'),
(34, 'Shreya', 'Patel', 'shreya.patel34@company.com', 'Sales', 62000.00, '2019-10-06'),
(35, 'Siddharth', 'Rao', 'siddharth.rao35@company.com', 'Marketing', 64500.00, '2020-11-07'),
(36, 'Sneha', 'Singh', 'sneha.singh36@company.com', 'Operations', 67000.00, '2021-12-08'),
(37, 'Suraj', 'Verma', 'suraj.verma37@company.com', 'Support', 69500.00, '2022-01-09'),
(38, 'Swathi', 'Nair', 'swathi.nair38@company.com', 'IT', 72000.00, '2023-02-10'),
(39, 'Tanmay', 'Gupta', 'tanmay.gupta39@company.com', 'Administration', 74500.00, '2024-03-11'),
(40, 'Tanya', 'Iyer', 'tanya.iyer40@company.com', 'Research', 77000.00, '2025-04-12'),

(41, 'Varun', 'Sharma', 'varun.sharma41@company.com', 'Engineering', 31000.00, '2018-05-13'),
(42, 'Vidya', 'Reddy', 'vidya.reddy42@company.com', 'HR', 33500.00, '2019-06-14'),
(43, 'Vijay', 'Kumar', 'vijay.kumar43@company.com', 'Finance', 36000.00, '2020-07-15'),
(44, 'Yash', 'Patel', 'yash.patel44@company.com', 'Sales', 38500.00, '2021-08-16'),
(45, 'Zoya', 'Rao', 'zoya.rao45@company.com', 'Marketing', 41000.00, '2022-09-17'),
(46, 'Abhinav', 'Singh', 'abhinav.singh46@company.com', 'Operations', 43500.00, '2023-10-18'),
(47, 'Amrita', 'Verma', 'amrita.verma47@company.com', 'Support', 46000.00, '2024-11-19'),
(48, 'Bharat', 'Nair', 'bharat.nair48@company.com', 'IT', 48500.00, '2025-12-20'),
(49, 'Chaitra', 'Gupta', 'chaitra.gupta49@company.com', 'Administration', 51000.00, '2018-01-21'),
(50, 'Dinesh', 'Iyer', 'dinesh.iyer50@company.com', 'Research', 53500.00, '2019-02-22'),

(51, 'Aarav', 'Sharma', 'aarav.sharma51@company.com', 'Engineering', 56000.00, '2020-03-23'),
(52, 'Aditi', 'Reddy', 'aditi.reddy52@company.com', 'HR', 58500.00, '2021-04-24'),
(53, 'Akash', 'Kumar', 'akash.kumar53@company.com', 'Finance', 61000.00, '2022-05-25'),
(54, 'Ananya', 'Patel', 'ananya.patel54@company.com', 'Sales', 63500.00, '2023-06-26'),
(55, 'Arjun', 'Rao', 'arjun.rao55@company.com', 'Marketing', 66000.00, '2024-07-27'),
(56, 'Bhavana', 'Singh', 'bhavana.singh56@company.com', 'Operations', 68500.00, '2025-08-28'),
(57, 'Charan', 'Verma', 'charan.verma57@company.com', 'Support', 71000.00, '2018-09-01'),
(58, 'Deepika', 'Nair', 'deepika.nair58@company.com', 'IT', 73500.00, '2019-10-02'),
(59, 'Dev', 'Gupta', 'dev.gupta59@company.com', 'Administration', 76000.00, '2020-11-03'),
(60, 'Divya', 'Iyer', 'divya.iyer60@company.com', 'Research', 78500.00, '2021-12-04'),

(61, 'Farhan', 'Sharma', 'farhan.sharma61@company.com', 'Engineering', 32500.00, '2022-01-05'),
(62, 'Gauri', 'Reddy', 'gauri.reddy62@company.com', 'HR', 35000.00, '2023-02-06'),
(63, 'Harish', 'Kumar', 'harish.kumar63@company.com', 'Finance', 37500.00, '2024-03-07'),
(64, 'Ishita', 'Patel', 'ishita.patel64@company.com', 'Sales', 40000.00, '2025-04-08'),
(65, 'Jatin', 'Rao', 'jatin.rao65@company.com', 'Marketing', 42500.00, '2018-05-09'),
(66, 'Kavya', 'Singh', 'kavya.singh66@company.com', 'Operations', 45000.00, '2019-06-10'),
(67, 'Kiran', 'Verma', 'kiran.verma67@company.com', 'Support', 47500.00, '2020-07-11'),
(68, 'Lakshmi', 'Nair', 'lakshmi.nair68@company.com', 'IT', 50000.00, '2021-08-12'),
(69, 'Manoj', 'Gupta', 'manoj.gupta69@company.com', 'Administration', 52500.00, '2022-09-13'),
(70, 'Meera', 'Iyer', 'meera.iyer70@company.com', 'Research', 55000.00, '2023-10-14'),

(71, 'Naveen', 'Sharma', 'naveen.sharma71@company.com', 'Engineering', 57500.00, '2024-11-15'),
(72, 'Neha', 'Reddy', 'neha.reddy72@company.com', 'HR', 60000.00, '2025-12-16'),
(73, 'Omkar', 'Kumar', 'omkar.kumar73@company.com', 'Finance', 62500.00, '2018-01-17'),
(74, 'Pooja', 'Patel', 'pooja.patel74@company.com', 'Sales', 65000.00, '2019-02-18'),
(75, 'Pranav', 'Rao', 'pranav.rao75@company.com', 'Marketing', 67500.00, '2020-03-19'),
(76, 'Priya', 'Singh', 'priya.singh76@company.com', 'Operations', 70000.00, '2021-04-20'),
(77, 'Rahul', 'Verma', 'rahul.verma77@company.com', 'Support', 72500.00, '2022-05-21'),
(78, 'Riya', 'Nair', 'riya.nair78@company.com', 'IT', 75000.00, '2023-06-22'),
(79, 'Rohit', 'Gupta', 'rohit.gupta79@company.com', 'Administration', 77500.00, '2024-07-23'),
(80, 'Saanvi', 'Iyer', 'saanvi.iyer80@company.com', 'Research', 80000.00, '2025-08-24'),

(81, 'Sachin', 'Sharma', 'sachin.sharma81@company.com', 'Engineering', 34000.00, '2018-09-25'),
(82, 'Sakshi', 'Reddy', 'sakshi.reddy82@company.com', 'HR', 36500.00, '2019-10-26'),
(83, 'Sanjay', 'Kumar', 'sanjay.kumar83@company.com', 'Finance', 39000.00, '2020-11-27'),
(84, 'Shreya', 'Patel', 'shreya.patel84@company.com', 'Sales', 41500.00, '2021-12-28'),
(85, 'Siddharth', 'Rao', 'siddharth.rao85@company.com', 'Marketing', 44000.00, '2022-01-01'),
(86, 'Sneha', 'Singh', 'sneha.singh86@company.com', 'Operations', 46500.00, '2023-02-02'),
(87, 'Suraj', 'Verma', 'suraj.verma87@company.com', 'Support', 49000.00, '2024-03-03'),
(88, 'Swathi', 'Nair', 'swathi.nair88@company.com', 'IT', 51500.00, '2025-04-04'),
(89, 'Tanmay', 'Gupta', 'tanmay.gupta89@company.com', 'Administration', 54000.00, '2018-05-05'),
(90, 'Tanya', 'Iyer', 'tanya.iyer90@company.com', 'Research', 56500.00, '2019-06-06'),

(91, 'Varun', 'Sharma', 'varun.sharma91@company.com', 'Engineering', 59000.00, '2020-07-07'),
(92, 'Vidya', 'Reddy', 'vidya.reddy92@company.com', 'HR', 61500.00, '2021-08-08'),
(93, 'Vijay', 'Kumar', 'vijay.kumar93@company.com', 'Finance', 64000.00, '2022-09-09'),
(94, 'Yash', 'Patel', 'yash.patel94@company.com', 'Sales', 66500.00, '2023-10-10'),
(95, 'Zoya', 'Rao', 'zoya.rao95@company.com', 'Marketing', 69000.00, '2024-11-11'),
(96, 'Abhinav', 'Singh', 'abhinav.singh96@company.com', 'Operations', 71500.00, '2025-12-12'),
(97, 'Amrita', 'Verma', 'amrita.verma97@company.com', 'Support', 74000.00, '2018-01-13'),
(98, 'Bharat', 'Nair', 'bharat.nair98@company.com', 'IT', 76500.00, '2019-02-14'),
(99, 'Chaitra', 'Gupta', 'chaitra.gupta99@company.com', 'Administration', 79000.00, '2020-03-15'),
(100, 'Dinesh', 'Iyer', 'dinesh.iyer100@company.com', 'Research', 81500.00, '2021-04-16');




select * from employees;

select department,sum(salary)
	from employees e1
	where salary > (
		select avg(salary)
        from employees e2
        where e1.department = e2.department
	)
	group by department;