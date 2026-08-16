-- Complete Syntax of SQL QUERY

-- SELECT [DISTINCT] column1, column2, expression, aggregate_function(...)
-- FROM table_name

-- JOIN table2
-- ON table1.column = table2.column

-- WHERE condition

-- GROUP BY column1, column2

-- HAVING condition

-- ORDER BY column1 [ASC|DESC], column2 [ASC|DESC]

-- LIMIT number

-- OFFSET number;

-- ! EXAMPLE

-- SELECT
--     column1,
--     column2,
--     aggregate_function(column3)
-- FROM
--     table_name
-- WHERE
--     condition
-- GROUP BY
--     column1,
--     column2
-- HAVING
--     aggregate_condition
-- ORDER BY
--     column1 ASC,
--     column2 DESC
-- LIMIT
--     number
-- OFFSET
--     number;

-- ! EXECUTION ORDER 
-- SELECT
-- FROM
-- WHERE
-- GROUP BY
-- HAVING
-- ORDER BY
-- LIMIT

-- ! GROUP BY Syntax
-- 	SELECT
-- 	group_column,
-- 	aggregate_function(column)
-- 	FROM table
-- 	GROUP BY group_column;

select department, first_name, count(*) 
	from employees
    group by department;
    
select * from employees;
drop table employees;

CREATE TABLE departments (
    dept_id INT PRIMARY KEY,
    dept_name VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE employees (
    employee_id INT PRIMARY KEY,
    employee_name VARCHAR(100) NOT NULL,
    gender VARCHAR(10),
    dept_id INT,
    salary DECIMAL(10, 2),
    email VARCHAR(100) UNIQUE,
    phone_number VARCHAR(15),
    job_title VARCHAR(50),
    hire_date DATE,
    city VARCHAR(50),

    CONSTRAINT fk_employee_department
        FOREIGN KEY (dept_id)
        REFERENCES departments(dept_id)
);

INSERT INTO departments (dept_id, dept_name) VALUES
(101, 'Human Resources'),
(102, 'Development'),
(103, 'Testing'),
(104, 'Finance'),
(105, 'Marketing'),
(106, 'Sales'),
(107, 'Operations'),
(108, 'Customer Support'),
(109, 'Research and Development'),
(110, 'Administration');



INSERT INTO employees
(employee_id, employee_name, gender, dept_id, salary, email, phone_number, job_title, hire_date, city)
VALUES
(1, 'Arjun Kumar', 'Male', 101, 36700.00, 'arjun.kumar1@company.com', '9000000001', 'HR Executive', '2022-04-08', 'Hyderabad'),
(2, 'Priya Sharma', 'Female', 102, 38400.00, 'priya.sharma2@company.com', '9000000002', 'Software Developer', '2023-07-15', 'Chennai'),
(3, 'Rahul Reddy', 'Male', 103, 40100.00, 'rahul.reddy3@company.com', '9000000003', 'Test Engineer', '2024-10-22', 'Bengaluru'),
(4, 'Sneha Patel', 'Female', 104, 41800.00, 'sneha.patel4@company.com', '9000000004', 'Accountant', '2025-01-01', 'Mumbai'),
(5, 'Vikram Rao', 'Male', 105, 43500.00, 'vikram.rao5@company.com', '9000000005', 'Marketing Executive', '2021-04-08', 'Pune'),
(6, 'Anjali Gupta', 'Female', 106, 45200.00, 'anjali.gupta6@company.com', '9000000006', 'Sales Executive', '2022-07-15', 'Delhi'),
(7, 'Kiran Singh', 'Male', 107, 46900.00, 'kiran.singh7@company.com', '9000000007', 'Operations Executive', '2023-10-22', 'Kolkata'),
(8, 'Meera Iyer', 'Female', 108, 48600.00, 'meera.iyer8@company.com', '9000000008', 'Support Executive', '2024-01-01', 'Vijayawada'),
(9, 'Rohit Naidu', 'Male', 109, 50300.00, 'rohit.naidu9@company.com', '9000000009', 'Research Associate', '2025-04-08', 'Visakhapatnam'),
(10, 'Divya Verma', 'Female', 110, 52000.00, 'divya.verma10@company.com', '9000000010', 'Office Executive', '2021-07-15', 'Coimbatore'),
(11, 'Amit Kumar', 'Male', 101, 53700.00, 'amit.kumar11@company.com', '9000000011', 'HR Manager', '2022-10-22', 'Hyderabad'),
(12, 'Pooja Sharma', 'Female', 102, 55400.00, 'pooja.sharma12@company.com', '9000000012', 'Senior Developer', '2023-01-01', 'Chennai'),
(13, 'Suresh Reddy', 'Male', 103, 57100.00, 'suresh.reddy13@company.com', '9000000013', 'QA Analyst', '2024-04-08', 'Bengaluru'),
(14, 'Neha Patel', 'Female', 104, 58800.00, 'neha.patel14@company.com', '9000000014', 'Financial Analyst', '2025-07-15', 'Mumbai'),
(15, 'Manoj Rao', 'Male', 105, 60500.00, 'manoj.rao15@company.com', '9000000015', 'Marketing Analyst', '2021-10-22', 'Pune'),
(16, 'Kavya Gupta', 'Female', 106, 62200.00, 'kavya.gupta16@company.com', '9000000016', 'Sales Manager', '2022-01-01', 'Delhi'),
(17, 'Ravi Singh', 'Male', 107, 63900.00, 'ravi.singh17@company.com', '9000000017', 'Operations Analyst', '2023-04-08', 'Kolkata'),
(18, 'Swathi Iyer', 'Female', 108, 65600.00, 'swathi.iyer18@company.com', '9000000018', 'Customer Support Analyst', '2024-07-15', 'Vijayawada'),
(19, 'Naveen Naidu', 'Male', 109, 67300.00, 'naveen.naidu19@company.com', '9000000019', 'R&D Engineer', '2025-10-22', 'Visakhapatnam'),
(20, 'Asha Verma', 'Female', 110, 69000.00, 'asha.verma20@company.com', '9000000020', 'Administrator', '2021-01-01', 'Coimbatore'),
(21, 'Varun Kumar', 'Male', 101, 70700.00, 'varun.kumar21@company.com', '9000000021', 'HR Executive', '2022-04-08', 'Hyderabad'),
(22, 'Nisha Sharma', 'Female', 102, 72400.00, 'nisha.sharma22@company.com', '9000000022', 'Software Developer', '2023-07-15', 'Chennai'),
(23, 'Deepak Reddy', 'Male', 103, 74100.00, 'deepak.reddy23@company.com', '9000000023', 'Test Engineer', '2024-10-22', 'Bengaluru'),
(24, 'Lakshmi Patel', 'Female', 104, 75800.00, 'lakshmi.patel24@company.com', '9000000024', 'Accountant', '2025-01-01', 'Mumbai'),
(25, 'Ajay Rao', 'Male', 105, 77500.00, 'ajay.rao25@company.com', '9000000025', 'Marketing Executive', '2021-04-08', 'Pune'),
(26, 'Keerthana Gupta', 'Female', 106, 79200.00, 'keerthana.gupta26@company.com', '9000000026', 'Sales Executive', '2022-07-15', 'Delhi'),
(27, 'Harish Singh', 'Male', 107, 80900.00, 'harish.singh27@company.com', '9000000027', 'Operations Executive', '2023-10-22', 'Kolkata'),
(28, 'Bhavana Iyer', 'Female', 108, 82600.00, 'bhavana.iyer28@company.com', '9000000028', 'Support Executive', '2024-01-01', 'Vijayawada'),
(29, 'Sanjay Naidu', 'Male', 109, 84300.00, 'sanjay.naidu29@company.com', '9000000029', 'Research Associate', '2025-04-08', 'Visakhapatnam'),
(30, 'Madhavi Verma', 'Female', 110, 36000.00, 'madhavi.verma30@company.com', '9000000030', 'Office Executive', '2021-07-15', 'Coimbatore'),
(31, 'Rajesh Kumar', 'Male', 101, 37700.00, 'rajesh.kumar31@company.com', '9000000031', 'HR Manager', '2022-10-22', 'Hyderabad'),
(32, 'Shreya Sharma', 'Female', 102, 39400.00, 'shreya.sharma32@company.com', '9000000032', 'Senior Developer', '2023-01-01', 'Chennai'),
(33, 'Prakash Reddy', 'Male', 103, 41100.00, 'prakash.reddy33@company.com', '9000000033', 'QA Analyst', '2024-04-08', 'Bengaluru'),
(34, 'Sindhu Patel', 'Female', 104, 42800.00, 'sindhu.patel34@company.com', '9000000034', 'Financial Analyst', '2025-07-15', 'Mumbai'),
(35, 'Mahesh Rao', 'Male', 105, 44500.00, 'mahesh.rao35@company.com', '9000000035', 'Marketing Analyst', '2021-10-22', 'Pune'),
(36, 'Ramya Gupta', 'Female', 106, 46200.00, 'ramya.gupta36@company.com', '9000000036', 'Sales Manager', '2022-01-01', 'Delhi'),
(37, 'Vinay Singh', 'Male', 107, 47900.00, 'vinay.singh37@company.com', '9000000037', 'Operations Analyst', '2023-04-08', 'Kolkata'),
(38, 'Anusha Iyer', 'Female', 108, 49600.00, 'anusha.iyer38@company.com', '9000000038', 'Customer Support Analyst', '2024-07-15', 'Vijayawada'),
(39, 'Tarun Naidu', 'Male', 109, 51300.00, 'tarun.naidu39@company.com', '9000000039', 'R&D Engineer', '2025-10-22', 'Visakhapatnam'),
(40, 'Geetha Verma', 'Female', 110, 53000.00, 'geetha.verma40@company.com', '9000000040', 'Administrator', '2021-01-01', 'Coimbatore'),
(41, 'Akash Kumar', 'Male', 101, 54700.00, 'akash.kumar41@company.com', '9000000041', 'HR Executive', '2022-04-08', 'Hyderabad'),
(42, 'Monica Sharma', 'Female', 102, 56400.00, 'monica.sharma42@company.com', '9000000042', 'Software Developer', '2023-07-15', 'Chennai'),
(43, 'Gopal Reddy', 'Male', 103, 58100.00, 'gopal.reddy43@company.com', '9000000043', 'Test Engineer', '2024-10-22', 'Bengaluru'),
(44, 'Rekha Patel', 'Female', 104, 59800.00, 'rekha.patel44@company.com', '9000000044', 'Accountant', '2025-01-01', 'Mumbai'),
(45, 'Ashwin Rao', 'Male', 105, 61500.00, 'ashwin.rao45@company.com', '9000000045', 'Marketing Executive', '2021-04-08', 'Pune'),
(46, 'Tejaswini Gupta', 'Female', 106, 63200.00, 'tejaswini.gupta46@company.com', '9000000046', 'Sales Executive', '2022-07-15', 'Delhi'),
(47, 'Dinesh Singh', 'Male', 107, 64900.00, 'dinesh.singh47@company.com', '9000000047', 'Operations Executive', '2023-10-22', 'Kolkata'),
(48, 'Sowmya Iyer', 'Female', 108, 66600.00, 'sowmya.iyer48@company.com', '9000000048', 'Support Executive', '2024-01-01', 'Vijayawada'),
(49, 'Karthik Naidu', 'Male', 109, 68300.00, 'karthik.naidu49@company.com', '9000000049', 'Research Associate', '2025-04-08', 'Visakhapatnam'),
(50, 'Lalitha Verma', 'Female', 110, 70000.00, 'lalitha.verma50@company.com', '9000000050', 'Office Executive', '2021-07-15', 'Coimbatore'),
(51, 'Yash Kumar', 'Male', 101, 71700.00, 'yash.kumar51@company.com', '9000000051', 'HR Manager', '2022-10-22', 'Hyderabad'),
(52, 'Ritika Sharma', 'Female', 102, 73400.00, 'ritika.sharma52@company.com', '9000000052', 'Senior Developer', '2023-01-01', 'Chennai'),
(53, 'Mohan Reddy', 'Male', 103, 75100.00, 'mohan.reddy53@company.com', '9000000053', 'QA Analyst', '2024-04-08', 'Bengaluru'),
(54, 'Sravani Patel', 'Female', 104, 76800.00, 'sravani.patel54@company.com', '9000000054', 'Financial Analyst', '2025-07-15', 'Mumbai'),
(55, 'Surya Rao', 'Male', 105, 78500.00, 'surya.rao55@company.com', '9000000055', 'Marketing Analyst', '2021-10-22', 'Pune'),
(56, 'Nandini Gupta', 'Female', 106, 80200.00, 'nandini.gupta56@company.com', '9000000056', 'Sales Manager', '2022-01-01', 'Delhi'),
(57, 'Pavan Singh', 'Male', 107, 81900.00, 'pavan.singh57@company.com', '9000000057', 'Operations Analyst', '2023-04-08', 'Kolkata'),
(58, 'Harini Iyer', 'Female', 108, 83600.00, 'harini.iyer58@company.com', '9000000058', 'Customer Support Analyst', '2024-07-15', 'Vijayawada'),
(59, 'Krishna Naidu', 'Male', 109, 35300.00, 'krishna.naidu59@company.com', '9000000059', 'R&D Engineer', '2025-10-22', 'Visakhapatnam'),
(60, 'Manasa Verma', 'Female', 110, 37000.00, 'manasa.verma60@company.com', '9000000060', 'Administrator', '2021-01-01', 'Coimbatore'),
(61, 'Abhishek Kumar', 'Male', 101, 38700.00, 'abhishek.kumar61@company.com', '9000000061', 'HR Executive', '2022-04-08', 'Hyderabad'),
(62, 'Isha Sharma', 'Female', 102, 40400.00, 'isha.sharma62@company.com', '9000000062', 'Software Developer', '2023-07-15', 'Chennai'),
(63, 'Ramesh Reddy', 'Male', 103, 42100.00, 'ramesh.reddy63@company.com', '9000000063', 'Test Engineer', '2024-10-22', 'Bengaluru'),
(64, 'Jyothi Patel', 'Female', 104, 43800.00, 'jyothi.patel64@company.com', '9000000064', 'Accountant', '2025-01-01', 'Mumbai'),
(65, 'Siddharth Rao', 'Male', 105, 45500.00, 'siddharth.rao65@company.com', '9000000065', 'Marketing Executive', '2021-04-08', 'Pune'),
(66, 'Lavanya Gupta', 'Female', 106, 47200.00, 'lavanya.gupta66@company.com', '9000000066', 'Sales Executive', '2022-07-15', 'Delhi'),
(67, 'Naresh Singh', 'Male', 107, 48900.00, 'naresh.singh67@company.com', '9000000067', 'Operations Executive', '2023-10-22', 'Kolkata'),
(68, 'Gayathri Iyer', 'Female', 108, 50600.00, 'gayathri.iyer68@company.com', '9000000068', 'Support Executive', '2024-01-01', 'Vijayawada'),
(69, 'Aditya Naidu', 'Male', 109, 52300.00, 'aditya.naidu69@company.com', '9000000069', 'Research Associate', '2025-04-08', 'Visakhapatnam'),
(70, 'Preethi Verma', 'Female', 110, 54000.00, 'preethi.verma70@company.com', '9000000070', 'Office Executive', '2021-07-15', 'Coimbatore'),
(71, 'Sandeep Kumar', 'Male', 101, 55700.00, 'sandeep.kumar71@company.com', '9000000071', 'HR Manager', '2022-10-22', 'Hyderabad'),
(72, 'Reshma Sharma', 'Female', 102, 57400.00, 'reshma.sharma72@company.com', '9000000072', 'Senior Developer', '2023-01-01', 'Chennai'),
(73, 'Vijay Reddy', 'Male', 103, 59100.00, 'vijay.reddy73@company.com', '9000000073', 'QA Analyst', '2024-04-08', 'Bengaluru'),
(74, 'Padma Patel', 'Female', 104, 60800.00, 'padma.patel74@company.com', '9000000074', 'Financial Analyst', '2025-07-15', 'Mumbai'),
(75, 'Nikhil Rao', 'Male', 105, 62500.00, 'nikhil.rao75@company.com', '9000000075', 'Marketing Analyst', '2021-10-22', 'Pune'),
(76, 'Radhika Gupta', 'Female', 106, 64200.00, 'radhika.gupta76@company.com', '9000000076', 'Sales Manager', '2022-01-01', 'Delhi'),
(77, 'Santosh Singh', 'Male', 107, 65900.00, 'santosh.singh77@company.com', '9000000077', 'Operations Analyst', '2023-04-08', 'Kolkata'),
(78, 'Supriya Iyer', 'Female', 108, 67600.00, 'supriya.iyer78@company.com', '9000000078', 'Customer Support Analyst', '2024-07-15', 'Vijayawada'),
(79, 'Chaitanya Naidu', 'Male', 109, 69300.00, 'chaitanya.naidu79@company.com', '9000000079', 'R&D Engineer', '2025-10-22', 'Visakhapatnam'),
(80, 'Uma Verma', 'Female', 110, 71000.00, 'uma.verma80@company.com', '9000000080', 'Administrator', '2021-01-01', 'Coimbatore'),
(81, 'Ganesh Kumar', 'Male', 101, 72700.00, 'ganesh.kumar81@company.com', '9000000081', 'HR Executive', '2022-04-08', 'Hyderabad'),
(82, 'Shalini Sharma', 'Female', 102, 74400.00, 'shalini.sharma82@company.com', '9000000082', 'Software Developer', '2023-07-15', 'Chennai'),
(83, 'Bharath Reddy', 'Male', 103, 76100.00, 'bharath.reddy83@company.com', '9000000083', 'Test Engineer', '2024-10-22', 'Bengaluru'),
(84, 'Mounika Patel', 'Female', 104, 77800.00, 'mounika.patel84@company.com', '9000000084', 'Accountant', '2025-01-01', 'Mumbai'),
(85, 'Vivek Rao', 'Male', 105, 79500.00, 'vivek.rao85@company.com', '9000000085', 'Marketing Executive', '2021-04-08', 'Pune'),
(86, 'Aishwarya Gupta', 'Female', 106, 81200.00, 'aishwarya.gupta86@company.com', '9000000086', 'Sales Executive', '2022-07-15', 'Delhi'),
(87, 'Lokesh Singh', 'Male', 107, 82900.00, 'lokesh.singh87@company.com', '9000000087', 'Operations Executive', '2023-10-22', 'Kolkata'),
(88, 'Sangeetha Iyer', 'Female', 108, 84600.00, 'sangeetha.iyer88@company.com', '9000000088', 'Support Executive', '2024-01-01', 'Vijayawada'),
(89, 'Kishore Naidu', 'Male', 109, 36300.00, 'kishore.naidu89@company.com', '9000000089', 'Research Associate', '2025-04-08', 'Visakhapatnam'),
(90, 'Vaishnavi Verma', 'Female', 110, 38000.00, 'vaishnavi.verma90@company.com', '9000000090', 'Office Executive', '2021-07-15', 'Coimbatore'),
(91, 'Hemant Kumar', 'Male', 101, 39700.00, 'hemant.kumar91@company.com', '9000000091', 'HR Manager', '2022-10-22', 'Hyderabad'),
(92, 'Anitha Sharma', 'Female', 102, 41400.00, 'anitha.sharma92@company.com', '9000000092', 'Senior Developer', '2023-01-01', 'Chennai'),
(93, 'Srikanth Reddy', 'Male', 103, 43100.00, 'srikanth.reddy93@company.com', '9000000093', 'QA Analyst', '2024-04-08', 'Bengaluru'),
(94, 'Komali Patel', 'Female', 104, 44800.00, 'komali.patel94@company.com', '9000000094', 'Financial Analyst', '2025-07-15', 'Mumbai'),
(95, 'Praveen Rao', 'Male', 105, 46500.00, 'praveen.rao95@company.com', '9000000095', 'Marketing Analyst', '2021-10-22', 'Pune'),
(96, 'Amrutha Gupta', 'Female', 106, 48200.00, 'amrutha.gupta96@company.com', '9000000096', 'Sales Manager', '2022-01-01', 'Delhi'),
(97, 'Shiva Singh', 'Male', 107, 49900.00, 'shiva.singh97@company.com', '9000000097', 'Operations Analyst', '2023-04-08', 'Kolkata'),
(98, 'Rupa Iyer', 'Female', 108, 51600.00, 'rupa.iyer98@company.com', '9000000098', 'Customer Support Analyst', '2024-07-15', 'Vijayawada'),
(99, 'Mastan Naidu', 'Male', 109, 53300.00, 'mastan.naidu99@company.com', '9000000099', 'R&D Engineer', '2025-10-22', 'Visakhapatnam'),
(100, 'Sameera Verma', 'Female', 110, 55000.00, 'sameera.verma100@company.com', '9000000100', 'Administrator', '2021-01-01', 'Coimbatore');


-- AGGREGATION FUNCTIONS --

select * from employees;

select distinct(city) from employees;


select dept_id,city,count(*)
	from employees
	group by dept_id,city;
    
select dept_id, sum(salary)
	from employees
    group by dept_id
    having sum(salary) > 600000;

-- ! GAINT QUERY 
	-- SELECT
	-- department,
	-- COUNT(*) AS total_employees,
	-- AVG(salary) AS average_salary,
	-- SUM(salary) AS total_salary,
	-- MAX(salary) AS highest_salary
	-- FROM employees
	-- WHERE salary > 30000
	-- GROUP BY department
	-- HAVING COUNT(*) >= 2
	-- ORDER BY average_salary DESC
	-- LIMIT 3
	-- OFFSET 0;



-- EXECUTION ORDER

-- 		FROM
-- 		  ↓
-- 		JOIN
-- 		  ↓
-- 		WHERE
-- 		  ↓
-- 		GROUP BY
-- 		  ↓
-- 		HAVING
-- 		  ↓
-- 		SELECT
-- 		  ↓
-- 		DISTINCT
-- 		  ↓
-- 		ORDER BY
-- 		  ↓
-- 		LIMIT
-- 		  ↓
-- 		OFFSET