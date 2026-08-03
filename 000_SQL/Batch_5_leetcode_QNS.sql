CREATE DATABASE CollegeDB;

USE CollegeDB;


CREATE TABLE Dept
(
    dept_id INT PRIMARY KEY,
    d_name VARCHAR(50) NOT NULL,
    hod_id INT
);


CREATE TABLE Faculty
(
    f_id INT PRIMARY KEY,
    f_name VARCHAR(50) NOT NULL,
    yoe INT
);


CREATE TABLE Student
(
    ht_number VARCHAR(10) PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    gender CHAR(1),
    dept_id INT,

    FOREIGN KEY(dept_id)
        REFERENCES Dept(dept_id)
);


CREATE TABLE Fee
(
    fee_id INT PRIMARY KEY,
    ht_number VARCHAR(10),
    amount DECIMAL(8,2),

    FOREIGN KEY(ht_number)
        REFERENCES Student(ht_number)
);


ALTER TABLE Dept
ADD CONSTRAINT fk_hod
FOREIGN KEY(hod_id)
REFERENCES Faculty(f_id);


INSERT INTO Faculty VALUES
(101,'Ramesh',12),
(102,'Suresh',15),
(103,'Priya',8),
(104,'Kiran',20),
(105,'Anitha',NULL),
(106,'Rahul',5),
(107,'Mahesh',18),
(108,'Swathi',NULL);


INSERT INTO Dept VALUES
(10,'CSE',101),
(20,'ECE',102),
(30,'EEE',103),
(40,'MECH',104),
(50,'CIVIL',NULL),
(60,'AI&ML',106),
(70,'IT',NULL);


INSERT INTO Student VALUES
('S101','Akhil','M',10),
('S102','Bhavana','F',10),
('S103','Charan','M',20),
('S104','Divya','F',30),
('S105','Eshwar','M',20),
('S106','Farah','F',40),
('S107','Ganesh','M',NULL),
('S108','Harika','F',60),
('S109','Indu','F',60),
('S110','John','M',NULL),
('S111','Kiran','M',50),
('S112','Lavanya','F',10),
('S113','Manoj','M',30),
('S114','Nandini','F',40),
('S115','Omkar','M',NULL);


INSERT INTO Fee VALUES
(1,'S101',45000),
(2,'S102',47000),
(3,'S103',50000),
(4,'S104',52000),
(5,'S105',48000),
(6,'S108',60000),
(7,'S109',61000),
(8,'S112',45000),
(9,'S114',55000),
(10,'S115',NULL);



select * from Dept;
select * from Student;
select * from faculty;
select * from fee;

insert into fee (fee_id, ht_number, amount)
		values  (11,"S116",10000),
				(12,"S117",20000),
                (13,"S118",50000),
                (14,"S119",78000),
                (15,"S120",12000),
                (16,"S112",16520);
                


-- 1) get ht_number,name,gender,dept_name for every student in table 

select s.ht_number,s.name,s.gender,s.dept_id,d.dept_name
	from Student s
    join Dept d
    on d.dept_id = s.dept_id;
    
    
-- 2) get fee_id,amount, name, gender of students who paid fee 

select f.fee_id,f.ht_number,s.name 
	from Fee f
	left join Student s
    on s.ht_number = f.ht_number
union
select f.fee_id,f.ht_number,s.name 
	from Fee f
	right join Student s
    on s.ht_number = f.ht_number;

CREATE TABLE Courses (
    student VARCHAR(50),
    class   VARCHAR(10)
);

INSERT INTO Courses (student, class) VALUES
('A', 'Math'),
('B', 'English'),
('C', 'Math'),
('D', 'Biology'),
('E', 'Math'),
('F', 'Math'),
('G', 'Math'),
('H', 'English'),
('I', 'Math'),
('J', 'Biology'),
('K', 'English'),
('L', 'Math'),
('M', 'Physics'),
('N', 'Physics'),
('O', 'Physics'),
('P', 'Physics'),
('Q', 'Physics'),
('R', 'Physics'),
('S', 'Chemistry'),
('T', 'Chemistry');

select * from courses;

select class
	from courses
    group by class
    having count(*) >= 5;
    

CREATE TABLE Views (
    article_id INT,
    author_id INT,
    viewer_id INT,
    view_date DATE
);

INSERT INTO Views (article_id, author_id, viewer_id, view_date) VALUES
(1, 3, 5, '2019-08-01'),
(1, 3, 6, '2019-08-02'),
(2, 7, 7, '2019-08-01'),
(2, 7, 6, '2019-08-02'),
(4, 7, 1, '2019-07-22'),
(3, 4, 4, '2019-07-21'),
(3, 4, 4, '2019-07-21');


select * from Views;
select distinct(author_id) as id from views
	where author_id = viewer_id
    order by id asc;
    
CREATE TABLE World (
    name VARCHAR(50),
    continent VARCHAR(30),
    area INT,
    population INT,
    gdp BIGINT
);

INSERT INTO World (name, continent, area, population, gdp) VALUES
('Afghanistan', 'Asia', 652230, 25500100, 20343000000),
('Albania', 'Europe', 28748, 2831741, 12960000000),
('Algeria', 'Africa', 2381741, 37100000, 188681000000),
('Andorra', 'Europe', 468, 78115, 3712000000),
('Angola', 'Africa', 1246700, 20609294, 100990000000);


select * from world;

select name,population,area 
	from World
    where area >= 3000000 or population >= 25000000;
    

select name,length(name) from world 
	where length(name) >= 7;


