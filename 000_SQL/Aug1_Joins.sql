CREATE 
TABLE dept (
    dept_id INT PRIMARY KEY,
    dept_name VARCHAR(30) NOT NULL,
    hod_id INT
);
CREATE TABLE faculty (
    faculty_id INT PRIMARY KEY,
    faculty_name VARCHAR(30) NOT NULL,
    qualification VARCHAR(30),
    experience INT
);

CREATE TABLE student (
    ht_number INT PRIMARY KEY,
    name VARCHAR(30) NOT NULL,
    gender CHAR(1),
    dob DATE,
    dept_id INT,
    attendance INT,

    FOREIGN KEY (dept_id)
        REFERENCES department(dept_id)
);

CREATE TABLE fee_paid (
    fee_receipt INT PRIMARY KEY,
    ht_number INT,
    amount INT,
    payment_date DATE,

    FOREIGN KEY (ht_number)
        REFERENCES student(ht_number)
);


INSERT INTO faculty VALUES
(101,'Dr. Rajesh Kumar','PhD',18),
(102,'Dr. Priya Sharma','PhD',15),
(103,'Dr. Naveen Reddy','PhD',20),
(104,'Dr. Sneha Iyer','M.Tech',12),
(105,'Dr. Arun Singh','PhD',17),
(106,'Dr. Lakshmi Devi','M.Tech',10);

INSERT INTO dept VALUES
(301,'Mechanical',101),
(302,'Civil',102),
(303,'CSE',103),
(304,'ECE',104),
(305,'EEE',105),
(306,'AI&ML',106);

ALTER TABLE department
ADD CONSTRAINT fk_hod
FOREIGN KEY (hod_id)
REFERENCES faculty(faculty_id);


INSERT INTO student VALUES
(22001,'Rahul','M','2004-01-10',303,91),
(22002,'Priya','F','2004-03-15',303,88),
(22003,'Arjun','M','2003-07-20',304,79),
(22004,'Sneha','F','2004-02-11',301,95),
(22005,'Kiran','M','2003-09-19',302,72),
(22006,'Ananya','F','2004-06-08',305,84),
(22007,'Vikram','M','2003-12-01',306,89),
(22008,'Harsha','M','2004-08-30',303,92),
(22009,'Divya','F','2004-05-21',304,76),
(22010,'Ajay','M','2003-11-16',301,80),
(22011,'Meena','F','2004-09-14',302,67),
(22012,'Sai','M','2003-04-18',306,98);


INSERT INTO fee_paid VALUES
(5001,22001,35000,'2025-01-10'),
(5002,22002,30000,'2025-01-12'),
(5003,22001,25000,'2025-03-10'),
(5004,22003,40000,'2025-01-15'),
(5005,22005,20000,'2025-02-01'),
(5006,22006,50000,'2025-01-20'),
(5007,22007,45000,'2025-01-25'),
(5008,22009,35000,'2025-02-14'),
(5009,22010,50000,'2025-03-02'),
(5010,22012,60000,'2025-01-05'),
(5011,22012,10000,'2025-04-15');


select * from faculty;
select * from department;
select * from student;
select * from fee_paid;

select s.ht_number, s.name, s.gender, d.dept_name, f.faculty_name
	from student s join department d
    on d.dept_id = s.dept_id
    join faculty f 
    on f.faculty_id = d.hod_id