create database testing;
use testing;

drop database testing;

create table employee(
	emp_id int primary key,
    emp_name varchar(20),
    gender char(1),
    email varchar(50),
    phone_number varchar(10),
    experience float,
    salary double,
    increment double,
    role varchar(20),
    rating int,
    dept_id int,
    dept_name varchar(20),
    shift_time varchar(20),
    project_name varchar(20),
    project_deadline date,
    levae_count int,
    is_permenant boolean,
    company_name varchar(20),
    nationality varchar(20),
    state varchar(20)
);


-- ============================================= DATA TO INSERT ============================================





INSERT INTO employee (emp_id, emp_name, gender, email, phone_number, experience, salary, increment, role, rating, dept_id, dept_name, shift_time, project_name, project_deadline, levae_count, is_permenant, company_name, nationality, state) 
VALUES 
-- DEPT 101: Engineering
(1, 'Aarav Patel', 'M', 'aarav1@google.com', '9800000001', 3, 120000, 12.5, 'Software Eng', 4, 101, 'Engineering', 'Day', 'Apollo', '2026-11-15', 2, TRUE, 'Google', 'Indian', 'Maharashtra'),
(2, 'Diya Sharma', 'F', 'diya2@google.com', '9800000002', 5, 150000, 15.0, 'Software Eng', 5, 101, 'Engineering', 'Day', 'Apollo', '2027-01-10', 1, TRUE, 'Google', 'Indian', 'Maharashtra'),
(3, 'John Doe', 'M', 'john3@ms.com', '9800000003', 2, 85000, 8.5, 'Software Eng', 3, 101, 'Engineering', 'Night', 'Titan', '2026-12-01', 4, FALSE, 'Microsoft', 'American', 'California'),
(4, 'Sarah Connor', 'F', 'sarah4@ms.com', '9800000004', 7, 175000, 20.0, 'DevOps Eng', 5, 101, 'Engineering', 'Day', 'Titan', '2027-03-20', 0, TRUE, 'Microsoft', 'American', 'California'),
(5, 'James Smith',bc 'M', 'james5@apple.com', '9800000005', 4, 110000, 10.0, 'Software Eng', 4, 101, 'Engineering', 'Day', 'Nexus', '2026-11-30', 3, TRUE, 'Apple', 'British', 'England'),
(6, 'Emma Watson', 'F', 'emma6@apple.com', '9800000006', 6, 160000, 14.5, 'Tech Lead', 5, 101, 'Engineering', 'Day', 'Nexus', '2027-02-15', 2, TRUE, 'Apple', 'British', 'England'),
(7, 'Liam Tremblay', 'M', 'liam7@amzn.com', '9800000007', 1, 65000, 5.0, 'Junior Eng', 3, 101, 'Engineering', 'Night', 'Quantum', '2027-05-10', 1, FALSE, 'Amazon', 'Canadian', 'Ontario'),
(8, 'Chloe Martin', 'F', 'chloe8@amzn.com', '9800000008', 8, 185000, 22.5, 'Senior Eng', 5, 101, 'Engineering', 'Day', 'Quantum', '2026-12-25', 4, TRUE, 'Amazon', 'Canadian', 'Ontario'),
(9, 'Oliver Brown', 'M', 'oliver9@meta.com', '9800000009', 3, 95000, 9.0, 'Software Eng', 4, 101, 'Engineering', 'Night', 'Genesis', '2027-06-01', 2, TRUE, 'Meta', 'Australian', 'NSW'),
(10, 'Mia Jones', 'F', 'mia10@meta.com', '9800000010', 5, 140000, 16.5, 'Software Eng', 4, 101, 'Engineering', 'Day', 'Genesis', '2026-11-20', 0, TRUE, 'Meta', 'Australian', 'NSW'),
(11, 'Lukas Schmidt', 'M', 'luk11@ibm.com', '9800000011', 10, 195000, 25.0, 'Architect', 5, 101, 'Engineering', 'Day', 'Phoenix', '2027-08-15', 3, TRUE, 'IBM', 'German', 'Bavaria'),
(12, 'Hannah Becker', 'F', 'han12@ibm.com', '9800000012', 2, 75000, 6.0, 'Software Eng', 3, 101, 'Engineering', 'Night', 'Phoenix', '2026-12-10', 2, FALSE, 'IBM', 'German', 'Bavaria'),
(13, 'Hugo Dupont', 'M', 'hugo13@intel.com', '9800000013', 4, 105000, 11.5, 'DevOps Eng', 4, 101, 'Engineering', 'Day', 'Nova', '2027-04-20', 1, TRUE, 'Intel', 'French', 'IDF'),
(14, 'Camille Leroy', 'F', 'cam14@intel.com', '9800000014', 6, 155000, 18.0, 'Software Eng', 5, 101, 'Engineering', 'Day', 'Nova', '2026-11-05', 4, TRUE, 'Intel', 'French', 'IDF'),
(15, 'Kenji Sato', 'M', 'kenji15@orcl.com', '9800000015', 7, 165000, 19.5, 'Software Eng', 4, 101, 'Engineering', 'Night', 'Athena', '2027-01-30', 0, TRUE, 'Oracle', 'Japanese', 'Tokyo'),
(16, 'Yuki Tanaka', 'F', 'yuki16@orcl.com', '9800000016', 1, 55000, 4.5, 'Junior Eng', 2, 101, 'Engineering', 'Day', 'Athena', '2026-12-15', 1, FALSE, 'Oracle', 'Japanese', 'Tokyo'),
(17, 'Mateo Silva', 'M', 'mat17@cisco.com', '9800000017', 5, 135000, 13.0, 'Software Eng', 4, 101, 'Engineering', 'Day', 'Zeus', '2027-07-10', 2, TRUE, 'Cisco', 'Brazilian', 'SP'),
(18, 'Julia Costa', 'F', 'jul18@cisco.com', '9800000018', 3, 90000, 9.5, 'DevOps Eng', 3, 101, 'Engineering', 'Night', 'Zeus', '2026-11-25', 3, TRUE, 'Cisco', 'Brazilian', 'SP'),
(19, 'Wei Chen', 'M', 'wei19@netflix.com', '9800000019', 9, 190000, 23.5, 'Architect', 5, 101, 'Engineering', 'Day', 'Odin', '2027-09-05', 1, TRUE, 'Netflix', 'Chinese', 'Beijing'),
(20, 'Jing Wang', 'F', 'jing20@netflix.com', '9800000020', 4, 115000, 12.0, 'Software Eng', 4, 101, 'Engineering', 'Day', 'Odin', '2026-12-20', 0, TRUE, 'Netflix', 'Chinese', 'Beijing'),

-- DEPT 102: Human Resources
(21, 'Rahul Verma', 'M', 'rahul21@google.com', '9800000021', 6, 95000, 10.5, 'HR Manager', 4, 102, 'HR', 'Day', 'Apollo', '2026-11-15', 2, TRUE, 'Google', 'Indian', 'Maharashtra'),
(22, 'Neha Iyer', 'F', 'neha22@google.com', '9800000022', 3, 60000, 7.0, 'Recruiter', 3, 102, 'HR', 'Day', 'Apollo', '2027-01-10', 4, TRUE, 'Google', 'Indian', 'Maharashtra'),
(23, 'Mike Davis', 'M', 'mike23@ms.com', '9800000023', 8, 125000, 14.5, 'HR Director', 5, 102, 'HR', 'Day', 'Titan', '2026-12-01', 1, TRUE, 'Microsoft', 'American', 'California'),
(24, 'Emily White', 'F', 'emily24@ms.com', '9800000024', 2, 45000, 5.5, 'HR Executive', 3, 102, 'HR', 'Day', 'Titan', '2027-03-20', 2, FALSE, 'Microsoft', 'American', 'California'),
(25, 'Harry Green', 'M', 'harry25@apple.com', '9800000025', 5, 85000, 9.0, 'HR Partner', 4, 102, 'HR', 'Day', 'Nexus', '2026-11-30', 3, TRUE, 'Apple', 'British', 'England'),
(26, 'Olivia Scott', 'F', 'oli26@apple.com', '9800000026', 4, 75000, 8.5, 'Recruiter', 4, 102, 'HR', 'Night', 'Nexus', '2027-02-15', 0, TRUE, 'Apple', 'British', 'England'),
(27, 'Noah Evans', 'M', 'noah27@amzn.com', '9800000027', 7, 110000, 12.0, 'HR Manager', 5, 102, 'HR', 'Day', 'Quantum', '2027-05-10', 1, TRUE, 'Amazon', 'Canadian', 'Ontario'),
(28, 'Ava King', 'F', 'ava28@amzn.com', '9800000028', 1, 35000, 4.0, 'HR Trainee', 2, 102, 'HR', 'Day', 'Quantum', '2026-12-25', 2, FALSE, 'Amazon', 'Canadian', 'Ontario'),
(29, 'Jack Clark', 'M', 'jack29@meta.com', '9800000029', 3, 65000, 7.5, 'HR Executive', 3, 102, 'HR', 'Night', 'Genesis', '2027-06-01', 4, TRUE, 'Meta', 'Australian', 'NSW'),
(30, 'Isla Lewis', 'F', 'isla30@meta.com', '9800000030', 9, 140000, 18.0, 'HR Director', 5, 102, 'HR', 'Day', 'Genesis', '2026-11-20', 0, TRUE, 'Meta', 'Australian', 'NSW'),
(31, 'Felix Meyer', 'M', 'felix31@ibm.com', '9800000031', 4, 80000, 8.5, 'Recruiter', 4, 102, 'HR', 'Day', 'Phoenix', '2027-08-15', 3, TRUE, 'IBM', 'German', 'Bavaria'),
(32, 'Laura Wagner', 'F', 'laura32@ibm.com', '9800000032', 6, 105000, 11.5, 'HR Manager', 5, 102, 'HR', 'Day', 'Phoenix', '2026-12-10', 2, TRUE, 'IBM', 'German', 'Bavaria'),
(33, 'Leo Bernard', 'M', 'leo33@intel.com', '9800000033', 2, 50000, 6.0, 'HR Executive', 3, 102, 'HR', 'Day', 'Nova', '2027-04-20', 1, FALSE, 'Intel', 'French', 'IDF'),
(34, 'Alice Petit', 'F', 'alice34@intel.com', '9800000034', 8, 130000, 15.0, 'HR Partner', 5, 102, 'HR', 'Day', 'Nova', '2026-11-05', 0, TRUE, 'Intel', 'French', 'IDF'),
(35, 'Hiro Suzuki', 'M', 'hiro35@orcl.com', '9800000035', 5, 90000, 10.0, 'HR Manager', 4, 102, 'HR', 'Night', 'Athena', '2027-01-30', 4, TRUE, 'Oracle', 'Japanese', 'Tokyo'),
(36, 'Aoi Watanabe', 'F', 'aoi36@orcl.com', '9800000036', 3, 62000, 7.5, 'Recruiter', 4, 102, 'HR', 'Day', 'Athena', '2026-12-15', 2, TRUE, 'Oracle', 'Japanese', 'Tokyo'),
(37, 'Lucas Lima', 'M', 'lucas37@cisco.com', '9800000037', 7, 115000, 13.5, 'HR Partner', 4, 102, 'HR', 'Day', 'Zeus', '2027-07-10', 1, TRUE, 'Cisco', 'Brazilian', 'SP'),
(38, 'Beatriz Alves', 'F', 'bea38@cisco.com', '9800000038', 1, 32000, 3.5, 'HR Trainee', 2, 102, 'HR', 'Day', 'Zeus', '2026-11-25', 3, FALSE, 'Cisco', 'Brazilian', 'SP'),
(39, 'Chen Li', 'M', 'chen39@netflix.com', '9800000039', 6, 100000, 12.0, 'HR Manager', 5, 102, 'HR', 'Day', 'Odin', '2027-09-05', 0, TRUE, 'Netflix', 'Chinese', 'Beijing'),
(40, 'Xia Wu', 'F', 'xia40@netflix.com', '9800000040', 4, 78000, 9.0, 'Recruiter', 4, 102, 'HR', 'Night', 'Odin', '2026-12-20', 2, TRUE, 'Netflix', 'Chinese', 'Beijing'),

-- DEPT 103: Quality Assurance (QA)
(41, 'Amit Singh', 'M', 'amit41@google.com', '9800000041', 4, 80000, 9.0, 'QA Engineer', 4, 103, 'QA', 'Day', 'Apollo', '2026-11-15', 2, TRUE, 'Google', 'Indian', 'Maharashtra'),
(42, 'Priya Reddy', 'F', 'priya42@google.com', '9800000042', 7, 125000, 14.0, 'QA Lead', 5, 103, 'QA', 'Day', 'Apollo', '2027-01-10', 1, TRUE, 'Google', 'Indian', 'Maharashtra'),
(43, 'Robert Brown', 'M', 'rob43@ms.com', '9800000043', 2, 55000, 6.0, 'QA Engineer', 3, 103, 'QA', 'Night', 'Titan', '2026-12-01', 3, FALSE, 'Microsoft', 'American', 'California'),
(44, 'Jessica Taylor', 'F', 'jess44@ms.com', '9800000044', 5, 95000, 10.5, 'Automation QA', 4, 103, 'QA', 'Day', 'Titan', '2027-03-20', 0, TRUE, 'Microsoft', 'American', 'California'),
(45, 'Thomas Wood', 'M', 'tom45@apple.com', '9800000045', 8, 140000, 16.5, 'QA Manager', 5, 103, 'QA', 'Day', 'Nexus', '2026-11-30', 2, TRUE, 'Apple', 'British', 'England'),
(46, 'Sophie Hughes', 'F', 'soph46@apple.com', '9800000046', 3, 70000, 8.0, 'QA Engineer', 4, 103, 'QA', 'Night', 'Nexus', '2027-02-15', 4, TRUE, 'Apple', 'British', 'England'),
(47, 'William Roy', 'M', 'will47@amzn.com', '9800000047', 6, 110000, 12.0, 'Automation QA', 5, 103, 'QA', 'Day', 'Quantum', '2027-05-10', 1, TRUE, 'Amazon', 'Canadian', 'Ontario'),
(48, 'Grace Lee', 'F', 'grace48@amzn.com', '9800000048', 1, 40000, 4.0, 'QA Trainee', 2, 103, 'QA', 'Day', 'Quantum', '2026-12-25', 2, FALSE, 'Amazon', 'Canadian', 'Ontario'),
(49, 'Lucas White', 'M', 'lucas49@meta.com', '9800000049', 4, 82000, 9.5, 'QA Engineer', 4, 103, 'QA', 'Day', 'Genesis', '2027-06-01', 3, TRUE, 'Meta', 'Australian', 'NSW'),
(50, 'Zoe Harris', 'F', 'zoe50@meta.com', '9800000050', 9, 155000, 19.0, 'QA Director', 5, 103, 'QA', 'Day', 'Genesis', '2026-11-20', 0, TRUE, 'Meta', 'Australian', 'NSW'),
(51, 'Maximilian Koch', 'M', 'max51@ibm.com', '9800000051', 5, 98000, 11.0, 'Automation QA', 4, 103, 'QA', 'Day', 'Phoenix', '2027-08-15', 2, TRUE, 'IBM', 'German', 'Bavaria'),
(52, 'Lena Richter', 'F', 'lena52@ibm.com', '9800000052', 2, 58000, 6.5, 'QA Engineer', 3, 103, 'QA', 'Night', 'Phoenix', '2026-12-10', 4, FALSE, 'IBM', 'German', 'Bavaria'),
(53, 'Arthur Roux', 'M', 'art53@intel.com', '9800000053', 7, 130000, 14.5, 'QA Lead', 5, 103, 'QA', 'Day', 'Nova', '2027-04-20', 1, TRUE, 'Intel', 'French', 'IDF'),
(54, 'Chloé Moreau', 'F', 'chlo54@intel.com', '9800000054', 3, 72000, 8.5, 'QA Engineer', 4, 103, 'QA', 'Day', 'Nova', '2026-11-05', 2, TRUE, 'Intel', 'French', 'IDF'),
(55, 'Taro Yamamoto', 'M', 'taro55@orcl.com', '9800000055', 6, 115000, 13.0, 'Automation QA', 4, 103, 'QA', 'Day', 'Athena', '2027-01-30', 3, TRUE, 'Oracle', 'Japanese', 'Tokyo'),
(56, 'Sakura Ito', 'F', 'saku56@orcl.com', '9800000056', 4, 85000, 10.0, 'QA Engineer', 4, 103, 'QA', 'Night', 'Athena', '2026-12-15', 1, TRUE, 'Oracle', 'Japanese', 'Tokyo'),
(57, 'Gabriel Gomes', 'M', 'gab57@cisco.com', '9800000057', 8, 145000, 17.0, 'QA Manager', 5, 103, 'QA', 'Day', 'Zeus', '2027-07-10', 0, TRUE, 'Cisco', 'Brazilian', 'SP'),
(58, 'Mariana Dias', 'F', 'mari58@cisco.com', '9800000058', 2, 56000, 6.0, 'QA Engineer', 3, 103, 'QA', 'Day', 'Zeus', '2026-11-25', 2, FALSE, 'Cisco', 'Brazilian', 'SP'),
(59, 'Hao Zhang', 'M', 'hao59@netflix.com', '9800000059', 5, 96000, 10.5, 'Automation QA', 4, 103, 'QA', 'Day', 'Odin', '2027-09-05', 1, TRUE, 'Netflix', 'Chinese', 'Beijing'),
(60, 'Lin Yang', 'F', 'lin60@netflix.com', '9800000060', 1, 42000, 4.5, 'QA Trainee', 2, 103, 'QA', 'Day', 'Odin', '2026-12-20', 3, FALSE, 'Netflix', 'Chinese', 'Beijing'),

-- DEPT 104: Data Science
(61, 'Vikram Das', 'M', 'vik61@google.com', '9800000061', 5, 140000, 15.0, 'Data Scientist', 5, 104, 'Data Science', 'Day', 'Apollo', '2026-11-15', 1, TRUE, 'Google', 'Indian', 'Maharashtra'),
(62, 'Anjali Menon', 'F', 'anj62@google.com', '9800000062', 3, 100000, 11.0, 'Data Analyst', 4, 104, 'Data Science', 'Day', 'Apollo', '2027-01-10', 2, TRUE, 'Google', 'Indian', 'Maharashtra'),
(63, 'David Wilson', 'M', 'dav63@ms.com', '9800000063', 8, 180000, 20.0, 'Lead Scientist', 5, 104, 'Data Science', 'Day', 'Titan', '2026-12-01', 0, TRUE, 'Microsoft', 'American', 'California'),
(64, 'Amanda Moore', 'F', 'ama64@ms.com', '9800000064', 2, 75000, 8.0, 'Data Analyst', 3, 104, 'Data Science', 'Night', 'Titan', '2027-03-20', 3, FALSE, 'Microsoft', 'American', 'California'),
(65, 'Charles Taylor', 'M', 'char65@apple.com', '9800000065', 6, 155000, 16.5, 'Data Engineer', 5, 104, 'Data Science', 'Day', 'Nexus', '2026-11-30', 2, TRUE, 'Apple', 'British', 'England'),
(66, 'Lucy Ward', 'F', 'lucy66@apple.com', '9800000066', 4, 115000, 12.5, 'Data Scientist', 4, 104, 'Data Science', 'Day', 'Nexus', '2027-02-15', 1, TRUE, 'Apple', 'British', 'England'),
(67, 'Ethan Hall', 'M', 'eth67@amzn.com', '9800000067', 7, 165000, 17.5, 'Data Engineer', 5, 104, 'Data Science', 'Day', 'Quantum', '2027-05-10', 0, TRUE, 'Amazon', 'Canadian', 'Ontario'),
(68, 'Lily Allen', 'F', 'lily68@amzn.com', '9800000068', 1, 60000, 5.5, 'Junior Analyst', 2, 104, 'Data Science', 'Day', 'Quantum', '2026-12-25', 4, FALSE, 'Amazon', 'Canadian', 'Ontario'),
(69, 'Henry King', 'M', 'hen69@meta.com', '9800000069', 5, 145000, 15.5, 'Data Scientist', 4, 104, 'Data Science', 'Day', 'Genesis', '2027-06-01', 2, TRUE, 'Meta', 'Australian', 'NSW'),
(70, 'Ruby Wright', 'F', 'ruby70@meta.com', '9800000070', 3, 105000, 11.5, 'Data Analyst', 4, 104, 'Data Science', 'Night', 'Genesis', '2026-11-20', 1, TRUE, 'Meta', 'Australian', 'NSW'),
(71, 'Leon Bauer', 'M', 'leon71@ibm.com', '9800000071', 9, 195000, 22.0, 'Chief Scientist', 5, 104, 'Data Science', 'Day', 'Phoenix', '2027-08-15', 3, TRUE, 'IBM', 'German', 'Bavaria'),
(72, 'Mia Hofmann', 'F', 'mia72@ibm.com', '9800000072', 2, 78000, 8.5, 'Data Analyst', 3, 104, 'Data Science', 'Day', 'Phoenix', '2026-12-10', 2, FALSE, 'IBM', 'German', 'Bavaria'),
(73, 'Louis Simon', 'M', 'lou73@intel.com', '9800000073', 6, 150000, 16.0, 'Data Engineer', 5, 104, 'Data Science', 'Day', 'Nova', '2027-04-20', 1, TRUE, 'Intel', 'French', 'IDF'),
(74, 'Juliette Michel', 'F', 'jul74@intel.com', '9800000074', 4, 118000, 13.0, 'Data Scientist', 4, 104, 'Data Science', 'Day', 'Nova', '2026-11-05', 0, TRUE, 'Intel', 'French', 'IDF'),
(75, 'Hiroshi Nakamura', 'M', 'hiro75@orcl.com', '9800000075', 8, 178000, 19.5, 'Lead Scientist', 5, 104, 'Data Science', 'Day', 'Athena', '2027-01-30', 2, TRUE, 'Oracle', 'Japanese', 'Tokyo'),
(76, 'Hana Kobayashi', 'F', 'hana76@orcl.com', '9800000076', 3, 102000, 11.5, 'Data Analyst', 4, 104, 'Data Science', 'Night', 'Athena', '2026-12-15', 3, TRUE, 'Oracle', 'Japanese', 'Tokyo'),
(77, 'Pedro Rocha', 'M', 'ped77@cisco.com', '9800000077', 5, 138000, 14.5, 'Data Scientist', 4, 104, 'Data Science', 'Day', 'Zeus', '2027-07-10', 1, TRUE, 'Cisco', 'Brazilian', 'SP'),
(78, 'Isabella Castro', 'F', 'isa78@cisco.com', '9800000078', 1, 62000, 6.0, 'Junior Analyst', 2, 104, 'Data Science', 'Day', 'Zeus', '2026-11-25', 4, FALSE, 'Cisco', 'Brazilian', 'SP'),
(79, 'Feng Zhao', 'M', 'feng79@netflix.com', '9800000079', 7, 168000, 18.0, 'Data Engineer', 5, 104, 'Data Science', 'Day', 'Odin', '2027-09-05', 0, TRUE, 'Netflix', 'Chinese', 'Beijing'),
(80, 'Mei Liu', 'F', 'mei80@netflix.com', '9800000080', 4, 120000, 13.5, 'Data Scientist', 4, 104, 'Data Science', 'Day', 'Odin', '2026-12-20', 2, TRUE, 'Netflix', 'Chinese', 'Beijing'),

-- DEPT 105: Cloud Ops
(81, 'Rohan Joshi', 'M', 'rohan81@google.com', '9800000081', 6, 135000, 14.5, 'Cloud Architect', 5, 105, 'Cloud Ops', 'Day', 'Apollo', '2026-11-15', 0, TRUE, 'Google', 'Indian', 'Maharashtra'),
(82, 'Sneha Patil', 'F', 'sneha82@google.com', '9800000082', 3, 90000, 9.5, 'SysAdmin', 4, 105, 'Cloud Ops', 'Night', 'Apollo', '2027-01-10', 2, TRUE, 'Google', 'Indian', 'Maharashtra'),
(83, 'Kevin Anderson', 'M', 'kev83@ms.com', '9800000083', 9, 185000, 21.0, 'Cloud Director', 5, 105, 'Cloud Ops', 'Day', 'Titan', '2026-12-01', 1, TRUE, 'Microsoft', 'American', 'California'),
(84, 'Brianne Thomas', 'F', 'bri84@ms.com', '9800000084', 2, 65000, 7.0, 'Cloud Ops Eng', 3, 105, 'Cloud Ops', 'Night', 'Titan', '2027-03-20', 3, FALSE, 'Microsoft', 'American', 'California'),
(85, 'George Jackson', 'M', 'geo85@apple.com', '9800000085', 5, 125000, 13.5, 'Cloud Engineer', 4, 105, 'Cloud Ops', 'Day', 'Nexus', '2026-11-30', 2, TRUE, 'Apple', 'British', 'England'),
(86, 'Charlotte White', 'F', 'char86@apple.com', '9800000086', 4, 105000, 11.0, 'SysAdmin', 4, 105, 'Cloud Ops', 'Day', 'Nexus', '2027-02-15', 1, TRUE, 'Apple', 'British', 'England'),
(87, 'Daniel Harris', 'M', 'dan87@amzn.com', '9800000087', 7, 155000, 17.0, 'Cloud Architect', 5, 105, 'Cloud Ops', 'Day', 'Quantum', '2027-05-10', 0, TRUE, 'Amazon', 'Canadian', 'Ontario'),
(88, 'Sophie Lee', 'F', 'soph88@amzn.com', '9800000088', 1, 55000, 5.0, 'Trainee Eng', 2, 105, 'Cloud Ops', 'Day', 'Quantum', '2026-12-25', 4, FALSE, 'Amazon', 'Canadian', 'Ontario'),
(89, 'Harrison Clark', 'M', 'har89@meta.com', '9800000089', 5, 128000, 14.0, 'Cloud Engineer', 4, 105, 'Cloud Ops', 'Day', 'Genesis', '2027-06-01', 2, TRUE, 'Meta', 'Australian', 'NSW'),
(90, 'Amelia Walker', 'F', 'ame90@meta.com', '9800000090', 3, 95000, 10.0, 'SysAdmin', 4, 105, 'Cloud Ops', 'Night', 'Genesis', '2026-11-20', 1, TRUE, 'Meta', 'Australian', 'NSW'),
(91, 'Paul Schwarz', 'M', 'paul91@ibm.com', '9800000091', 8, 175000, 19.0, 'Cloud Architect', 5, 105, 'Cloud Ops', 'Day', 'Phoenix', '2027-08-15', 3, TRUE, 'IBM', 'German', 'Bavaria'),
(92, 'Anna Weber', 'F', 'anna92@ibm.com', '9800000092', 2, 68000, 7.5, 'Cloud Ops Eng', 3, 105, 'Cloud Ops', 'Night', 'Phoenix', '2026-12-10', 2, FALSE, 'IBM', 'German', 'Bavaria'),
(93, 'Antoine Blanc', 'M', 'ant93@intel.com', '9800000093', 6, 145000, 15.5, 'Cloud Engineer', 5, 105, 'Cloud Ops', 'Day', 'Nova', '2027-04-20', 1, TRUE, 'Intel', 'French', 'IDF'),
(94, 'Manon Lefevre', 'F', 'man94@intel.com', '9800000094', 4, 108000, 12.0, 'SysAdmin', 4, 105, 'Cloud Ops', 'Day', 'Nova', '2026-11-05', 0, TRUE, 'Intel', 'French', 'IDF'),
(95, 'Ryota Saito', 'M', 'ryo95@orcl.com', '9800000095', 7, 160000, 17.5, 'Cloud Architect', 5, 105, 'Cloud Ops', 'Day', 'Athena', '2027-01-30', 2, TRUE, 'Oracle', 'Japanese', 'Tokyo'),
(96, 'Yui Takahashi', 'F', 'yui96@orcl.com', '9800000096', 3, 92000, 9.5, 'Cloud Ops Eng', 4, 105, 'Cloud Ops', 'Night', 'Athena', '2026-12-15', 3, TRUE, 'Oracle', 'Japanese', 'Tokyo'),
(97, 'Thiago Santos', 'M', 'thi97@cisco.com', '9800000097', 5, 122000, 13.0, 'Cloud Engineer', 4, 105, 'Cloud Ops', 'Day', 'Zeus', '2027-07-10', 1, TRUE, 'Cisco', 'Brazilian', 'SP'),
(98, 'Camila Oliveira', 'F', 'cam98@cisco.com', '9800000098', 1, 58000, 6.0, 'Trainee Eng', 2, 105, 'Cloud Ops', 'Day', 'Zeus', '2026-11-25', 4, FALSE, 'Cisco', 'Brazilian', 'SP'),
(99, 'Jian Sun', 'M', 'jian99@netflix.com', '9800000099', 8, 172000, 18.5, 'Cloud Architect', 5, 105, 'Cloud Ops', 'Day', 'Odin', '2027-09-05', 0, TRUE, 'Netflix', 'Chinese', 'Beijing'),
(100, 'Yan Wu', 'F', 'yan100@netflix.com', '9800000100', 4, 110000, 12.0, 'SysAdmin', 4, 105, 'Cloud Ops', 'Day', 'Odin', '2026-12-20', 2, TRUE, 'Netflix', 'Chinese', 'Beijing'),

-- DEPT 106: Security
(101, 'Karan Mehta', 'M', 'kar101@google.com', '9800000101', 5, 130000, 14.0, 'Security Analyst', 4, 106, 'Security', 'Day', 'Apollo', '2026-11-15', 1, TRUE, 'Google', 'Indian', 'Maharashtra'),
(102, 'Tanvi Desai', 'F', 'tan102@google.com', '9800000102', 3, 95000, 10.0, 'Pen Tester', 4, 106, 'Security', 'Night', 'Apollo', '2027-01-10', 2, TRUE, 'Google', 'Indian', 'Maharashtra'),
(103, 'Steven Martinez', 'M', 'ste103@ms.com', '9800000103', 9, 190000, 22.0, 'CISO', 5, 106, 'Security', 'Day', 'Titan', '2026-12-01', 0, TRUE, 'Microsoft', 'American', 'California'),
(104, 'Melissa Clark', 'F', 'mel104@ms.com', '9800000104', 2, 68000, 7.5, 'Sec Ops', 3, 106, 'Security', 'Night', 'Titan', '2027-03-20', 3, FALSE, 'Microsoft', 'American', 'California'),
(105, 'Edward Lewis', 'M', 'edw105@apple.com', '9800000105', 6, 140000, 15.0, 'Security Analyst', 5, 106, 'Security', 'Day', 'Nexus', '2026-11-30', 2, TRUE, 'Apple', 'British', 'England'),
(106, 'Grace Robinson', 'F', 'gra106@apple.com', '9800000106', 4, 110000, 11.5, 'Pen Tester', 4, 106, 'Security', 'Day', 'Nexus', '2027-02-15', 1, TRUE, 'Apple', 'British', 'England'),
(107, 'Matthew Young', 'M', 'mat107@amzn.com', '9800000107', 7, 160000, 17.5, 'Sec Manager', 5, 106, 'Security', 'Day', 'Quantum', '2027-05-10', 0, TRUE, 'Amazon', 'Canadian', 'Ontario'),
(108, 'Zoe Allen', 'F', 'zoe108@amzn.com', '9800000108', 1, 58000, 5.5, 'Trainee Sec', 2, 106, 'Security', 'Day', 'Quantum', '2026-12-25', 4, FALSE, 'Amazon', 'Canadian', 'Ontario'),
(109, 'Alexander King', 'M', 'ale109@meta.com', '9800000109', 5, 132000, 14.5, 'Security Analyst', 4, 106, 'Security', 'Day', 'Genesis', '2027-06-01', 2, TRUE, 'Meta', 'Australian', 'NSW'),
(110, 'Harper Wright', 'F', 'har110@meta.com', '9800000110', 3, 98000, 10.5, 'Sec Ops', 4, 106, 'Security', 'Night', 'Genesis', '2026-11-20', 1, TRUE, 'Meta', 'Australian', 'NSW'),
(111, 'Tim Fischer', 'M', 'tim111@ibm.com', '9800000111', 8, 180000, 19.5, 'Sec Architect', 5, 106, 'Security', 'Day', 'Phoenix', '2027-08-15', 3, TRUE, 'IBM', 'German', 'Bavaria'),
(112, 'Marie Weber', 'F', 'mar112@ibm.com', '9800000112', 2, 70000, 8.0, 'Security Analyst', 3, 106, 'Security', 'Night', 'Phoenix', '2026-12-10', 2, FALSE, 'IBM', 'German', 'Bavaria'),
(113, 'Victor Richard', 'M', 'vic113@intel.com', '9800000113', 6, 150000, 16.0, 'Pen Tester', 5, 106, 'Security', 'Day', 'Nova', '2027-04-20', 1, TRUE, 'Intel', 'French', 'IDF'),
(114, 'Lea Martin', 'F', 'lea114@intel.com', '9800000114', 4, 112000, 12.5, 'Sec Ops', 4, 106, 'Security', 'Day', 'Nova', '2026-11-05', 0, TRUE, 'Intel', 'French', 'IDF'),
(115, 'Daiki Ito', 'M', 'dai115@orcl.com', '9800000115', 7, 165000, 18.0, 'Sec Manager', 5, 106, 'Security', 'Day', 'Athena', '2027-01-30', 2, TRUE, 'Oracle', 'Japanese', 'Tokyo'),
(116, 'Rin Suzuki', 'F', 'rin116@orcl.com', '9800000116', 3, 95000, 10.0, 'Security Analyst', 4, 106, 'Security', 'Night', 'Athena', '2026-12-15', 3, TRUE, 'Oracle', 'Japanese', 'Tokyo'),
(117, 'Felipe Pereira', 'M', 'fel117@cisco.com', '9800000117', 5, 125000, 13.5, 'Pen Tester', 4, 106, 'Security', 'Day', 'Zeus', '2027-07-10', 1, TRUE, 'Cisco', 'Brazilian', 'SP'),
(118, 'Ana Souza', 'F', 'ana118@cisco.com', '9800000118', 1, 60000, 6.5, 'Trainee Sec', 2, 106, 'Security', 'Day', 'Zeus', '2026-11-25', 4, FALSE, 'Cisco', 'Brazilian', 'SP'),
(119, 'Bo Huang', 'M', 'bo119@netflix.com', '9800000119', 8, 175000, 19.0, 'Sec Architect', 5, 106, 'Security', 'Day', 'Odin', '2027-09-05', 0, TRUE, 'Netflix', 'Chinese', 'Beijing'),
(120, 'Ting Zhou', 'F', 'tin120@netflix.com', '9800000120', 4, 115000, 12.5, 'Sec Ops', 4, 106, 'Security', 'Day', 'Odin', '2026-12-20', 2, TRUE, 'Netflix', 'Chinese', 'Beijing'),

-- DEPT 107: Product
(121, 'Arjun Rao', 'M', 'arj121@google.com', '9800000121', 6, 145000, 15.0, 'Product Manager', 5, 107, 'Product', 'Day', 'Apollo', '2026-11-15', 0, TRUE, 'Google', 'Indian', 'Maharashtra'),
(122, 'Meera Nair', 'F', 'mee122@google.com', '9800000122', 3, 105000, 11.0, 'Scrum Master', 4, 107, 'Product', 'Day', 'Apollo', '2027-01-10', 2, TRUE, 'Google', 'Indian', 'Maharashtra'),
(123, 'Christopher Lee', 'M', 'chr123@ms.com', '9800000123', 9, 195000, 23.0, 'Product Director', 5, 107, 'Product', 'Day', 'Titan', '2026-12-01', 1, TRUE, 'Microsoft', 'American', 'California'),
(124, 'Michelle Perez', 'F', 'mic124@ms.com', '9800000124', 2, 72000, 8.0, 'Product Analyst', 3, 107, 'Product', 'Day', 'Titan', '2027-03-20', 3, FALSE, 'Microsoft', 'American', 'California'),
(125, 'Richard Clark', 'M', 'ric125@apple.com', '9800000125', 5, 135000, 14.0, 'Product Manager', 4, 107, 'Product', 'Day', 'Nexus', '2026-11-30', 2, TRUE, 'Apple', 'British', 'England'),
(126, 'Eleanor Hill', 'F', 'ele126@apple.com', '9800000126', 4, 115000, 12.0, 'Scrum Master', 4, 107, 'Product', 'Day', 'Nexus', '2027-02-15', 1, TRUE, 'Apple', 'British', 'England'),
(127, 'Benjamin Baker', 'M', 'ben127@amzn.com', '9800000127', 7, 165000, 18.0, 'Product Manager', 5, 107, 'Product', 'Day', 'Quantum', '2027-05-10', 0, TRUE, 'Amazon', 'Canadian', 'Ontario'),
(128, 'Victoria Adams', 'F', 'vic128@amzn.com', '9800000128', 1, 62000, 6.0, 'Product Trainee', 2, 107, 'Product', 'Day', 'Quantum', '2026-12-25', 4, FALSE, 'Amazon', 'Canadian', 'Ontario'),
(129, 'Samuel Nelson', 'M', 'sam129@meta.com', '9800000129', 5, 138000, 14.5, 'Product Manager', 4, 107, 'Product', 'Day', 'Genesis', '2027-06-01', 2, TRUE, 'Meta', 'Australian', 'NSW'),
(130, 'Evelyn Carter', 'F', 'eve130@meta.com', '9800000130', 3, 102000, 10.5, 'Scrum Master', 4, 107, 'Product', 'Day', 'Genesis', '2026-11-20', 1, TRUE, 'Meta', 'Australian', 'NSW'),
(131, 'Jonas Schulz', 'M', 'jon131@ibm.com', '9800000131', 8, 185000, 20.0, 'Product Director', 5, 107, 'Product', 'Day', 'Phoenix', '2027-08-15', 3, TRUE, 'IBM', 'German', 'Bavaria'),
(132, 'Clara Hoffmann', 'F', 'cla132@ibm.com', '9800000132', 2, 75000, 8.5, 'Product Analyst', 3, 107, 'Product', 'Day', 'Phoenix', '2026-12-10', 2, FALSE, 'IBM', 'German', 'Bavaria'),
(133, 'Louis Garcia', 'M', 'lou133@intel.com', '9800000133', 6, 155000, 16.5, 'Product Manager', 5, 107, 'Product', 'Day', 'Nova', '2027-04-20', 1, TRUE, 'Intel', 'French', 'IDF'),
(134, 'Ines Martinez', 'F', 'ine134@intel.com', '9800000134', 4, 118000, 12.5, 'Scrum Master', 4, 107, 'Product', 'Day', 'Nova', '2026-11-05', 0, TRUE, 'Intel', 'French', 'IDF'),
(135, 'Takashi Watanabe', 'M', 'tak135@orcl.com', '9800000135', 7, 170000, 18.5, 'Product Manager', 5, 107, 'Product', 'Day', 'Athena', '2027-01-30', 2, TRUE, 'Oracle', 'Japanese', 'Tokyo'),
(136, 'Mio Yamamoto', 'F', 'mio136@orcl.com', '9800000136', 3, 98000, 10.5, 'Product Analyst', 4, 107, 'Product', 'Day', 'Athena', '2026-12-15', 3, TRUE, 'Oracle', 'Japanese', 'Tokyo'),
(137, 'Rafael Silva', 'M', 'raf137@cisco.com', '9800000137', 5, 130000, 14.0, 'Product Manager', 4, 107, 'Product', 'Day', 'Zeus', '2027-07-10', 1, TRUE, 'Cisco', 'Brazilian', 'SP'),
(138, 'Larissa Costa', 'F', 'lar138@cisco.com', '9800000138', 1, 64000, 7.0, 'Product Trainee', 2, 107, 'Product', 'Day', 'Zeus', '2026-11-25', 4, FALSE, 'Cisco', 'Brazilian', 'SP'),
(139, 'Kai Lin', 'M', 'kai139@netflix.com', '9800000139', 8, 180000, 19.5, 'Product Director', 5, 107, 'Product', 'Day', 'Odin', '2027-09-05', 0, TRUE, 'Netflix', 'Chinese', 'Beijing'),
(140, 'Min Zhang', 'F', 'min140@netflix.com', '9800000140', 4, 122000, 13.0, 'Scrum Master', 4, 107, 'Product', 'Day', 'Odin', '2026-12-20', 2, TRUE, 'Netflix', 'Chinese', 'Beijing'),

-- DEPT 108: UX Design
(141, 'Vivek Sharma', 'M', 'viv141@google.com', '9800000141', 5, 125000, 13.5, 'UX Designer', 4, 108, 'UX Design', 'Day', 'Apollo', '2026-11-15', 1, TRUE, 'Google', 'Indian', 'Maharashtra'),
(142, 'Shruti Kadam', 'F', 'shr142@google.com', '9800000142', 3, 92000, 9.5, 'UI Developer', 4, 108, 'UX Design', 'Day', 'Apollo', '2027-01-10', 2, TRUE, 'Google', 'Indian', 'Maharashtra'),
(143, 'Daniel Roberts', 'M', 'dan143@ms.com', '9800000143', 8, 170000, 19.0, 'UX Lead', 5, 108, 'UX Design', 'Day', 'Titan', '2026-12-01', 0, TRUE, 'Microsoft', 'American', 'California'),
(144, 'Karen Phillips', 'F', 'kar144@ms.com', '9800000144', 2, 65000, 7.0, 'UI Developer', 3, 108, 'UX Design', 'Day', 'Titan', '2027-03-20', 3, FALSE, 'Microsoft', 'American', 'California'),
(145, 'Joseph Parker', 'M', 'jos145@apple.com', '9800000145', 6, 140000, 15.0, 'UX Designer', 5, 108, 'UX Design', 'Day', 'Nexus', '2026-11-30', 2, TRUE, 'Apple', 'British', 'England'),
(146, 'Hannah Morris', 'F', 'han146@apple.com', '9800000146', 4, 105000, 11.5, 'UI Developer', 4, 108, 'UX Design', 'Day', 'Nexus', '2027-02-15', 1, TRUE, 'Apple', 'British', 'England'),
(147, 'Dylan Mitchell', 'M', 'dyl147@amzn.com', '9800000147', 7, 155000, 17.0, 'UX Lead', 5, 108, 'UX Design', 'Day', 'Quantum', '2027-05-10', 0, TRUE, 'Amazon', 'Canadian', 'Ontario'),
(148, 'Stella Turner', 'F', 'ste148@amzn.com', '9800000148', 1, 58000, 5.5, 'UX Trainee', 2, 108, 'UX Design', 'Day', 'Quantum', '2026-12-25', 4, FALSE, 'Amazon', 'Canadian', 'Ontario'),
(149, 'Aaron Phillips', 'M', 'aar149@meta.com', '9800000149', 5, 130000, 14.0, 'UX Designer', 4, 108, 'UX Design', 'Day', 'Genesis', '2027-06-01', 2, TRUE, 'Meta', 'Australian', 'NSW'),
(150, 'Scarlett Kelly', 'F', 'sca150@meta.com', '9800000150', 3, 95000, 10.0, 'UI Developer', 4, 108, 'UX Design', 'Day', 'Genesis', '2026-11-20', 1, TRUE, 'Meta', 'Australian', 'NSW'),
(151, 'David Krause', 'M', 'dav151@ibm.com', '9800000151', 8, 175000, 19.5, 'UX Lead', 5, 108, 'UX Design', 'Day', 'Phoenix', '2027-08-15', 3, TRUE, 'IBM', 'German', 'Bavaria'),
(152, 'Lisa Wolf', 'F', 'lis152@ibm.com', '9800000152', 2, 68000, 8.0, 'UI Developer', 3, 108, 'UX Design', 'Day', 'Phoenix', '2026-12-10', 2, FALSE, 'IBM', 'German', 'Bavaria'),
(153, 'Paul Francois', 'M', 'pau153@intel.com', '9800000153', 6, 145000, 16.0, 'UX Designer', 5, 108, 'UX Design', 'Day', 'Nova', '2027-04-20', 1, TRUE, 'Intel', 'French', 'IDF'),
(154, 'Lucie David', 'F', 'luc154@intel.com', '9800000154', 4, 110000, 12.0, 'UI Developer', 4, 108, 'UX Design', 'Day', 'Nova', '2026-11-05', 0, TRUE, 'Intel', 'French', 'IDF'),
(155, 'Shota Ito', 'M', 'sho155@orcl.com', '9800000155', 7, 160000, 18.0, 'UX Lead', 5, 108, 'UX Design', 'Day', 'Athena', '2027-01-30', 2, TRUE, 'Oracle', 'Japanese', 'Tokyo'),
(156, 'Akari Saito', 'F', 'aka156@orcl.com', '9800000156', 3, 90000, 9.5, 'UI Developer', 4, 108, 'UX Design', 'Day', 'Athena', '2026-12-15', 3, TRUE, 'Oracle', 'Japanese', 'Tokyo'),
(157, 'Bruno Santos', 'M', 'bru157@cisco.com', '9800000157', 5, 122000, 13.0, 'UX Designer', 4, 108, 'UX Design', 'Day', 'Zeus', '2027-07-10', 1, TRUE, 'Cisco', 'Brazilian', 'SP'),
(158, 'Isis Oliveira', 'F', 'isi158@cisco.com', '9800000158', 1, 60000, 6.5, 'UX Trainee', 2, 108, 'UX Design', 'Day', 'Zeus', '2026-11-25', 4, FALSE, 'Cisco', 'Brazilian', 'SP'),
(159, 'Zhi Huang', 'M', 'zhi159@netflix.com', '9800000159', 8, 165000, 18.5, 'UX Lead', 5, 108, 'UX Design', 'Day', 'Odin', '2027-09-05', 0, TRUE, 'Netflix', 'Chinese', 'Beijing'),
(160, 'Ying Zhou', 'F', 'yin160@netflix.com', '9800000160', 4, 112000, 12.5, 'UI Developer', 4, 108, 'UX Design', 'Day', 'Odin', '2026-12-20', 2, TRUE, 'Netflix', 'Chinese', 'Beijing'),

-- DEPT 109: R & D
(161, 'Aditya Singh', 'M', 'adi161@google.com', '9800000161', 7, 165000, 18.0, 'R&D Engineer', 5, 109, 'R&D', 'Day', 'Apollo', '2026-11-15', 1, TRUE, 'Google', 'Indian', 'Maharashtra'),
(162, 'Pooja Joshi', 'F', 'poo162@google.com', '9800000162', 4, 115000, 12.5, 'Research Scientist', 4, 109, 'R&D', 'Day', 'Apollo', '2027-01-10', 2, TRUE, 'Google', 'Indian', 'Maharashtra'),
(163, 'Anthony Campbell', 'M', 'ant163@ms.com', '9800000163', 10, 200000, 25.0, 'Head of R&D', 5, 109, 'R&D', 'Day', 'Titan', '2026-12-01', 0, TRUE, 'Microsoft', 'American', 'California'),
(164, 'Laura Scott', 'F', 'lau164@ms.com', '9800000164', 3, 90000, 9.5, 'R&D Engineer', 3, 109, 'R&D', 'Day', 'Titan', '2027-03-20', 3, FALSE, 'Microsoft', 'American', 'California'),
(165, 'Mark Phillips', 'M', 'mar165@apple.com', '9800000165', 6, 150000, 16.0, 'Research Scientist', 5, 109, 'R&D', 'Day', 'Nexus', '2026-11-30', 2, TRUE, 'Apple', 'British', 'England'),
(166, 'Megan Evans', 'F', 'meg166@apple.com', '9800000166', 4, 120000, 13.0, 'R&D Engineer', 4, 109, 'R&D', 'Day', 'Nexus', '2027-02-15', 1, TRUE, 'Apple', 'British', 'England'),
(167, 'Nathan Murphy', 'M', 'nat167@amzn.com', '9800000167', 8, 185000, 20.0, 'Head of R&D', 5, 109, 'R&D', 'Day', 'Quantum', '2027-05-10', 0, TRUE, 'Amazon', 'Canadian', 'Ontario'),
(168, 'Aria Cook', 'F', 'ari168@amzn.com', '9800000168', 2, 75000, 8.0, 'R&D Trainee', 2, 109, 'R&D', 'Day', 'Quantum', '2026-12-25', 4, FALSE, 'Amazon', 'Canadian', 'Ontario'),
(169, 'Isaac Bell', 'M', 'isa169@meta.com', '9800000169', 5, 140000, 15.0, 'Research Scientist', 4, 109, 'R&D', 'Day', 'Genesis', '2027-06-01', 2, TRUE, 'Meta', 'Australian', 'NSW'),
(170, 'Sofia Ward', 'F', 'sof170@meta.com', '9800000170', 3, 105000, 11.0, 'R&D Engineer', 4, 109, 'R&D', 'Day', 'Genesis', '2026-11-20', 1, TRUE, 'Meta', 'Australian', 'NSW'),
(171, 'Julian Koch', 'M', 'jul171@ibm.com', '9800000171', 9, 195000, 22.0, 'Head of R&D', 5, 109, 'R&D', 'Day', 'Phoenix', '2027-08-15', 3, TRUE, 'IBM', 'German', 'Bavaria'),
(172, 'Sophie Lehmann', 'F', 'sop172@ibm.com', '9800000172', 2, 78000, 8.5, 'R&D Engineer', 3, 109, 'R&D', 'Day', 'Phoenix', '2026-12-10', 2, FALSE, 'IBM', 'German', 'Bavaria'),
(173, 'Gaston Moreau', 'M', 'gas173@intel.com', '9800000173', 6, 155000, 16.5, 'Research Scientist', 5, 109, 'R&D', 'Day', 'Nova', '2027-04-20', 1, TRUE, 'Intel', 'French', 'IDF'),
(174, 'Amelie Dubois', 'F', 'ame174@intel.com', '9800000174', 4, 118000, 12.5, 'R&D Engineer', 4, 109, 'R&D', 'Day', 'Nova', '2026-11-05', 0, TRUE, 'Intel', 'French', 'IDF'),
(175, 'Ryota Suzuki', 'M', 'ryo175@orcl.com', '9800000175', 8, 178000, 19.5, 'Head of R&D', 5, 109, 'R&D', 'Day', 'Athena', '2027-01-30', 2, TRUE, 'Oracle', 'Japanese', 'Tokyo'),
(176, 'Rina Tanaka', 'F', 'rin176@orcl.com', '9800000176', 3, 102000, 11.5, 'R&D Engineer', 4, 109, 'R&D', 'Day', 'Athena', '2026-12-15', 3, TRUE, 'Oracle', 'Japanese', 'Tokyo'),
(177, 'Diego Pereira', 'M', 'die177@cisco.com', '9800000177', 5, 138000, 14.5, 'Research Scientist', 4, 109, 'R&D', 'Day', 'Zeus', '2027-07-10', 1, TRUE, 'Cisco', 'Brazilian', 'SP'),
(178, 'Luana Silva', 'F', 'lua178@cisco.com', '9800000178', 1, 62000, 6.0, 'R&D Trainee', 2, 109, 'R&D', 'Day', 'Zeus', '2026-11-25', 4, FALSE, 'Cisco', 'Brazilian', 'SP'),
(179, 'Peng Wu', 'M', 'pen179@netflix.com', '9800000179', 7, 168000, 18.5, 'Research Scientist', 5, 109, 'R&D', 'Day', 'Odin', '2027-09-05', 0, TRUE, 'Netflix', 'Chinese', 'Beijing'),
(180, 'Qiang Li', 'F', 'qia180@netflix.com', '9800000180', 4, 120000, 13.5, 'R&D Engineer', 4, 109, 'R&D', 'Day', 'Odin', '2026-12-20', 2, TRUE, 'Netflix', 'Chinese', 'Beijing'),

-- DEPT 110: IT Support
(181, 'Suresh Kumar', 'M', 'sur181@google.com', '9800000181', 4, 75000, 8.0, 'IT Support Exec', 4, 110, 'IT Support', 'Day', 'Apollo', '2026-11-15', 1, TRUE, 'Google', 'Indian', 'Maharashtra'),
(182, 'Kavya Pillai', 'F', 'kav182@google.com', '9800000182', 2, 50000, 5.5, 'Network Eng', 3, 110, 'IT Support', 'Night', 'Apollo', '2027-01-10', 3, FALSE, 'Google', 'Indian', 'Maharashtra'),
(183, 'Paul Wright', 'M', 'pau183@ms.com', '9800000183', 7, 115000, 13.0, 'Support Manager', 5, 110, 'IT Support', 'Day', 'Titan', '2026-12-01', 0, TRUE, 'Microsoft', 'American', 'California'),
(184, 'Betty Green', 'F', 'bet184@ms.com', '9800000184', 3, 65000, 7.0, 'IT Support Exec', 4, 110, 'IT Support', 'Night', 'Titan', '2027-03-20', 2, TRUE, 'Microsoft', 'American', 'California'),
(185, 'Brian Adams', 'M', 'bri185@apple.com', '9800000185', 5, 90000, 10.0, 'Network Eng', 4, 110, 'IT Support', 'Day', 'Nexus', '2026-11-30', 2, TRUE, 'Apple', 'British', 'England'),
(186, 'Rachel Baker', 'F', 'rac186@apple.com', '9800000186', 4, 80000, 9.0, 'IT Support Exec', 4, 110, 'IT Support', 'Night', 'Nexus', '2027-02-15', 1, TRUE, 'Apple', 'British', 'England'),
(187, 'Ryan Gonzalez', 'M', 'rya187@amzn.com', '9800000187', 6, 105000, 12.0, 'Support Manager', 5, 110, 'IT Support', 'Day', 'Quantum', '2027-05-10', 0, TRUE, 'Amazon', 'Canadian', 'Ontario'),
(188, 'Harper Perez', 'F', 'har188@amzn.com', '9800000188', 1, 40000, 4.0, 'Support Trainee', 2, 110, 'IT Support', 'Night', 'Quantum', '2026-12-25', 4, FALSE, 'Amazon', 'Canadian', 'Ontario'),
(189, 'Blake Sanchez', 'M', 'bla189@meta.com', '9800000189', 4, 85000, 9.5, 'Network Eng', 4, 110, 'IT Support', 'Day', 'Genesis', '2027-06-01', 2, TRUE, 'Meta', 'Australian', 'NSW'),
(190, 'Layla Rivera', 'F', 'lay190@meta.com', '9800000190', 5, 95000, 10.5, 'IT Support Exec', 4, 110, 'IT Support', 'Night', 'Genesis', '2026-11-20', 1, TRUE, 'Meta', 'Australian', 'NSW'),
(191, 'Jonas Huber', 'M', 'jon191@ibm.com', '9800000191', 7, 120000, 13.5, 'Support Manager', 5, 110, 'IT Support', 'Day', 'Phoenix', '2027-08-15', 3, TRUE, 'IBM', 'German', 'Bavaria'),
(192, 'Lara Bauer', 'F', 'lar192@ibm.com', '9800000192', 2, 55000, 6.0, 'IT Support Exec', 3, 110, 'IT Support', 'Night', 'Phoenix', '2026-12-10', 2, FALSE, 'IBM', 'German', 'Bavaria'),
(193, 'Clement Roux', 'M', 'cle193@intel.com', '9800000193', 5, 98000, 11.0, 'Network Eng', 4, 110, 'IT Support', 'Day', 'Nova', '2027-04-20', 1, TRUE, 'Intel', 'French', 'IDF'),
(194, 'Margaux Blanc', 'F', 'mar194@intel.com', '9800000194', 3, 72000, 8.0, 'IT Support Exec', 4, 110, 'IT Support', 'Night', 'Nova', '2026-11-05', 0, TRUE, 'Intel', 'French', 'IDF'),
(195, 'Kaito Nakamura', 'M', 'kai195@orcl.com', '9800000195', 6, 110000, 12.5, 'Support Manager', 5, 110, 'IT Support', 'Day', 'Athena', '2027-01-30', 2, TRUE, 'Oracle', 'Japanese', 'Tokyo'),
(196, 'Nana Kobayashi', 'F', 'nan196@orcl.com', '9800000196', 4, 82000, 9.0, 'IT Support Exec', 4, 110, 'IT Support', 'Night', 'Athena', '2026-12-15', 3, TRUE, 'Oracle', 'Japanese', 'Tokyo'),
(197, 'Andre Rocha', 'M', 'and197@cisco.com', '9800000197', 4, 88000, 9.5, 'Network Eng', 4, 110, 'IT Support', 'Day', 'Zeus', '2027-07-10', 1, TRUE, 'Cisco', 'Brazilian', 'SP'),
(198, 'Valentina Castro', 'F', 'val198@cisco.com', '9800000198', 1, 45000, 4.5, 'Support Trainee', 2, 110, 'IT Support', 'Night', 'Zeus', '2026-11-25', 4, FALSE, 'Cisco', 'Brazilian', 'SP'),
(199, 'Liu Yang', 'M', 'liu199@netflix.com', '9800000199', 6, 108000, 12.0, 'Support Manager', 5, 110, 'IT Support', 'Day', 'Odin', '2027-09-05', 0, TRUE, 'Netflix', 'Chinese', 'Beijing'),
(200, 'Xiu Zhao', 'F', 'xiu200@netflix.com', '9800000200', 3, 68000, 7.5, 'IT Support Exec', 4, 110, 'IT Support', 'Night', 'Odin', '2026-12-20', 2, TRUE, 'Netflix', 'Chinese', 'Beijing'),
(201, 'Karthik Raja', 'M', 'karthik201@google.com', '9900000201', 5, 140000, 15.0, 'Software Eng', 5, 101, 'Engineering', 'Day', 'Apollo', '2026-11-20', 2, TRUE, 'Google', 'Indian', 'Tamil Nadu'),
(202, 'Divya N', 'F', 'divya202@ms.com', '9900000202', 3, 90000, 10.5, 'Software Eng', 4, 101, 'Engineering', 'Night', 'Titan', '2027-01-15', 1, TRUE, 'Microsoft', 'Indian', 'Tamil Nadu'),
(203, 'Ashwin Kumar', 'M', 'ashwin203@apple.com', '9900000203', 7, 165000, 18.0, 'DevOps Eng', 5, 101, 'Engineering', 'Day', 'Nexus', '2027-03-10', 0, TRUE, 'Apple', 'Indian', 'Tamil Nadu'),
(204, 'Priya Krishnan', 'F', 'priya204@amzn.com', '9900000204', 2, 75000, 8.0, 'Junior Eng', 3, 101, 'Engineering', 'Day', 'Quantum', '2026-12-05', 3, FALSE, 'Amazon', 'Indian', 'Tamil Nadu'),
(205, 'Balaji S', 'M', 'balaji205@meta.com', '9900000205', 9, 185000, 22.5, 'Architect', 5, 101, 'Engineering', 'Day', 'Genesis', '2027-06-25', 1, TRUE, 'Meta', 'Indian', 'Tamil Nadu'),

-- DEPT 102: Human Resources
(206, 'Swathi R', 'F', 'swathi206@ibm.com', '9900000206', 4, 80000, 9.5, 'Recruiter', 4, 102, 'HR', 'Day', 'Phoenix', '2027-02-20', 2, TRUE, 'IBM', 'Indian', 'Tamil Nadu'),
(207, 'Dinesh K', 'M', 'dinesh207@intel.com', '9900000207', 6, 110000, 12.0, 'HR Manager', 5, 102, 'HR', 'Day', 'Nova', '2026-11-10', 1, TRUE, 'Intel', 'Indian', 'Tamil Nadu'),
(208, 'Anitha Murthy', 'F', 'anitha208@orcl.com', '9900000208', 2, 55000, 6.5, 'HR Executive', 3, 102, 'HR', 'Night', 'Athena', '2027-04-15', 4, FALSE, 'Oracle', 'Indian', 'Tamil Nadu'),
(209, 'Surya Prakash', 'M', 'surya209@cisco.com', '9900000209', 8, 135000, 16.0, 'HR Director', 5, 102, 'HR', 'Day', 'Zeus', '2027-08-01', 0, TRUE, 'Cisco', 'Indian', 'Tamil Nadu'),
(210, 'Meenakshi C', 'F', 'meena210@netflix.com', '9900000210', 5, 95000, 11.5, 'HR Partner', 4, 102, 'HR', 'Day', 'Odin', '2026-12-30', 2, TRUE, 'Netflix', 'Indian', 'Tamil Nadu'),

-- DEPT 103: Quality Assurance (QA)
(211, 'Ramesh Babu', 'M', 'ramesh211@google.com', '9900000211', 5, 98000, 11.0, 'QA Engineer', 4, 103, 'QA', 'Night', 'Apollo', '2026-11-20', 1, TRUE, 'Google', 'Indian', 'Tamil Nadu'),
(212, 'Deepika V', 'F', 'deepika212@ms.com', '9900000212', 3, 75000, 8.5, 'QA Engineer', 4, 103, 'QA', 'Day', 'Titan', '2027-01-15', 3, TRUE, 'Microsoft', 'Indian', 'Tamil Nadu'),
(213, 'Suresh G', 'M', 'suresh213@apple.com', '9900000213', 7, 130000, 14.5, 'QA Lead', 5, 103, 'QA', 'Day', 'Nexus', '2027-03-10', 0, TRUE, 'Apple', 'Indian', 'Tamil Nadu'),
(214, 'Shruti H', 'F', 'shruti214@amzn.com', '9900000214', 1, 45000, 5.0, 'QA Trainee', 2, 103, 'QA', 'Day', 'Quantum', '2026-12-05', 2, FALSE, 'Amazon', 'Indian', 'Tamil Nadu'),
(215, 'Muthu Kumar', 'M', 'muthu215@meta.com', '9900000215', 6, 115000, 13.0, 'Automation QA', 4, 103, 'QA', 'Day', 'Genesis', '2027-06-25', 1, TRUE, 'Meta', 'Indian', 'Tamil Nadu'),

-- DEPT 104: Data Science
(216, 'Vijay Joseph', 'M', 'vijay216@ibm.com', '9900000216', 8, 175000, 19.5, 'Lead Scientist', 5, 104, 'Data Science', 'Day', 'Phoenix', '2027-02-20', 0, TRUE, 'IBM', 'Indian', 'Tamil Nadu'),
(217, 'Bhuvaneshwari K', 'F', 'bhuvi217@intel.com', '9900000217', 4, 112000, 12.0, 'Data Analyst', 4, 104, 'Data Science', 'Night', 'Nova', '2026-11-10', 2, TRUE, 'Intel', 'Indian', 'Tamil Nadu'),
(218, 'Ganesh Ram', 'M', 'ganesh218@orcl.com', '9900000218', 3, 95000, 10.5, 'Data Engineer', 4, 104, 'Data Science', 'Day', 'Athena', '2027-04-15', 3, TRUE, 'Oracle', 'Indian', 'Tamil Nadu'),
(219, 'Nandini S', 'F', 'nandini219@cisco.com', '9900000219', 6, 145000, 15.5, 'Data Scientist', 5, 104, 'Data Science', 'Day', 'Zeus', '2027-08-01', 1, TRUE, 'Cisco', 'Indian', 'Tamil Nadu'),
(220, 'Kamal H', 'M', 'kamal220@netflix.com', '9900000220', 10, 198000, 24.0, 'Chief Scientist', 5, 104, 'Data Science', 'Day', 'Odin', '2026-12-30', 0, TRUE, 'Netflix', 'Indian', 'Tamil Nadu'),

-- DEPT 105: Cloud Ops
(221, 'Arvind Swamy', 'M', 'arvind221@google.com', '9900000221', 7, 160000, 17.5, 'Cloud Architect', 5, 105, 'Cloud Ops', 'Day', 'Apollo', '2026-11-20', 1, TRUE, 'Google', 'Indian', 'Tamil Nadu'),
(222, 'Keerthy S', 'F', 'keerthy222@ms.com', '9900000222', 2, 65000, 7.0, 'Trainee Eng', 3, 105, 'Cloud Ops', 'Night', 'Titan', '2027-01-15', 4, FALSE, 'Microsoft', 'Indian', 'Tamil Nadu'),
(223, 'Vikram K', 'M', 'vikram223@apple.com', '9900000223', 5, 125000, 14.0, 'Cloud Engineer', 4, 105, 'Cloud Ops', 'Day', 'Nexus', '2027-03-10', 2, TRUE, 'Apple', 'Indian', 'Tamil Nadu'),
(224, 'Trisha K', 'F', 'trisha224@amzn.com', '9900000224', 6, 140000, 15.5, 'Cloud Manager', 5, 105, 'Cloud Ops', 'Day', 'Quantum', '2026-12-05', 0, TRUE, 'Amazon', 'Indian', 'Tamil Nadu'),
(225, 'Ajith Kumar', 'M', 'ajith225@meta.com', '9900000225', 9, 180000, 21.0, 'Cloud Director', 5, 105, 'Cloud Ops', 'Day', 'Genesis', '2027-06-25', 1, TRUE, 'Meta', 'Indian', 'Tamil Nadu'),

-- DEPT 106: Security
(226, 'Rajini K', 'M', 'rajini226@ibm.com', '9900000226', 10, 195000, 23.5, 'CISO', 5, 106, 'Security', 'Day', 'Phoenix', '2027-02-20', 0, TRUE, 'IBM', 'Indian', 'Tamil Nadu'),
(227, 'Nayanthara K', 'F', 'nayan227@intel.com', '9900000227', 5, 130000, 14.5, 'Security Analyst', 4, 106, 'Security', 'Night', 'Nova', '2026-11-10', 2, TRUE, 'Intel', 'Indian', 'Tamil Nadu'),
(228, 'Dhanush K', 'M', 'dhanush228@orcl.com', '9900000228', 4, 105000, 11.5, 'Pen Tester', 4, 106, 'Security', 'Day', 'Athena', '2027-04-15', 1, TRUE, 'Oracle', 'Indian', 'Tamil Nadu'),
(229, 'Samantha R', 'F', 'sam229@cisco.com', '9900000229', 2, 70000, 8.0, 'Sec Ops', 3, 106, 'Security', 'Day', 'Zeus', '2027-08-01', 3, FALSE, 'Cisco', 'Indian', 'Tamil Nadu'),
(230, 'Simbu T', 'M', 'simbu230@netflix.com', '9900000230', 6, 145000, 16.0, 'Sec Architect', 5, 106, 'Security', 'Day', 'Odin', '2026-12-30', 2, TRUE, 'Netflix', 'Indian', 'Tamil Nadu'),

-- DEPT 107: Product
(231, 'Siva K', 'M', 'siva231@google.com', '9900000231', 6, 145000, 15.5, 'Product Manager', 5, 107, 'Product', 'Day', 'Apollo', '2026-11-20', 1, TRUE, 'Google', 'Indian', 'Tamil Nadu'),
(232, 'Anjali D', 'F', 'anjali232@ms.com', '9900000232', 3, 98000, 10.0, 'Scrum Master', 4, 107, 'Product', 'Day', 'Titan', '2027-01-15', 2, TRUE, 'Microsoft', 'Indian', 'Tamil Nadu'),
(233, 'Vishal R', 'M', 'vishal233@apple.com', '9900000233', 5, 125000, 14.0, 'Product Analyst', 4, 107, 'Product', 'Day', 'Nexus', '2027-03-10', 1, TRUE, 'Apple', 'Indian', 'Tamil Nadu'),
(234, 'Tamannaah B', 'F', 'tam234@amzn.com', '9900000234', 8, 175000, 19.5, 'Product Director', 5, 107, 'Product', 'Day', 'Quantum', '2026-12-05', 0, TRUE, 'Amazon', 'Indian', 'Tamil Nadu'),
(235, 'Arya J', 'M', 'arya235@meta.com', '9900000235', 2, 68000, 7.5, 'Product Trainee', 3, 107, 'Product', 'Night', 'Genesis', '2027-06-25', 4, FALSE, 'Meta', 'Indian', 'Tamil Nadu'),

-- DEPT 108: UX Design
(236, 'Jiiva C', 'M', 'jiiva236@ibm.com', '9900000236', 5, 115000, 12.5, 'UX Designer', 4, 108, 'UX Design', 'Day', 'Phoenix', '2027-02-20', 2, TRUE, 'IBM', 'Indian', 'Tamil Nadu'),
(237, 'Hansika M', 'F', 'hansika237@intel.com', '9900000237', 3, 85000, 9.5, 'UI Developer', 4, 108, 'UX Design', 'Day', 'Nova', '2026-11-10', 1, TRUE, 'Intel', 'Indian', 'Tamil Nadu'),
(238, 'Karthi S', 'M', 'karthi238@orcl.com', '9900000238', 7, 155000, 17.0, 'UX Lead', 5, 108, 'UX Design', 'Day', 'Athena', '2027-04-15', 0, TRUE, 'Oracle', 'Indian', 'Tamil Nadu'),
(239, 'Kajal A', 'F', 'kajal239@cisco.com', '9900000239', 1, 50000, 5.5, 'UX Trainee', 2, 108, 'UX Design', 'Day', 'Zeus', '2027-08-01', 3, FALSE, 'Cisco', 'Indian', 'Tamil Nadu'),
(240, 'Jayam Ravi', 'M', 'ravi240@netflix.com', '9900000240', 6, 135000, 14.5, 'UX Designer', 5, 108, 'UX Design', 'Night', 'Odin', '2026-12-30', 2, TRUE, 'Netflix', 'Indian', 'Tamil Nadu'),

-- DEPT 109: R & D
(241, 'Madhavan R', 'M', 'madhavan241@google.com', '9900000241', 9, 190000, 21.5, 'Head of R&D', 5, 109, 'R&D', 'Day', 'Apollo', '2026-11-20', 1, TRUE, 'Google', 'Indian', 'Tamil Nadu'),
(242, 'Asin T', 'F', 'asin242@ms.com', '9900000242', 4, 110000, 12.0, 'R&D Engineer', 4, 109, 'R&D', 'Day', 'Titan', '2027-01-15', 2, TRUE, 'Microsoft', 'Indian', 'Tamil Nadu'),
(243, 'Prabhu Deva', 'M', 'prabhu243@apple.com', '9900000243', 6, 145000, 16.0, 'Research Scientist', 5, 109, 'R&D', 'Day', 'Nexus', '2027-03-10', 0, TRUE, 'Apple', 'Indian', 'Tamil Nadu'),
(244, 'Jyothika S', 'F', 'jyothika244@amzn.com', '9900000244', 3, 95000, 10.5, 'R&D Engineer', 4, 109, 'R&D', 'Night', 'Quantum', '2026-12-05', 3, TRUE, 'Amazon', 'Indian', 'Tamil Nadu'),
(245, 'Sathyaraj S', 'M', 'sathya245@meta.com', '9900000245', 2, 72000, 8.0, 'R&D Trainee', 3, 109, 'R&D', 'Day', 'Genesis', '2027-06-25', 4, FALSE, 'Meta', 'Indian', 'Tamil Nadu'),

-- DEPT 110: IT Support
(246, 'Vadivelu B', 'M', 'vadivelu246@ibm.com', '9900000246', 8, 125000, 13.5, 'Support Manager', 5, 110, 'IT Support', 'Day', 'Phoenix', '2027-02-20', 1, TRUE, 'IBM', 'Indian', 'Tamil Nadu'),
(247, 'Sneha R', 'F', 'sneha247@intel.com', '9900000247', 4, 78000, 9.0, 'IT Support Exec', 4, 110, 'IT Support', 'Night', 'Nova', '2026-11-10', 2, TRUE, 'Intel', 'Indian', 'Tamil Nadu'),
(248, 'Santhanam N', 'M', 'santha248@orcl.com', '9900000248', 5, 95000, 10.5, 'Network Eng', 4, 110, 'IT Support', 'Day', 'Athena', '2027-04-15', 1, TRUE, 'Oracle', 'Indian', 'Tamil Nadu'),
(249, 'Oviya H', 'F', 'oviya249@cisco.com', '9900000249', 1, 42000, 4.5, 'Support Trainee', 2, 110, 'IT Support', 'Day', 'Zeus', '2027-08-01', 3, FALSE, 'Cisco', 'Indian', 'Tamil Nadu'),
(250, 'Yogibabu T', 'M', 'yogi250@netflix.com', '9900000250', 3, 68000, 7.5, 'IT Support Exec', 4, 110, 'IT Support', 'Night', 'Odin', '2026-12-30', 2, TRUE, 'Netflix', 'Indian', 'Tamil Nadu');





select count(distinct(company_name)) from employee;

-- 1) Male and  Female count in Every Company ✅

select company_name,gender,count(*)
	from employee
    group by company_name,gender;
    
select company_name,dept_name,count(*)
	from employee
    group by company_name,dept_name
    order by dept_name asc;

-- 2) Salaries spending on each department in every Company
use testing;
select count(distinct(company_name)) from employee;

select company_name,dept_name,sum(salary)
	from employee
    group by company_name,dept_name
    order by company_name ASC ,dept_name DESC;

-- 3) salaries spending on Night/Day shift employees in every company

select shift_time,company_name,dept_name,sum(salary)
	from employee where shift_time = "Night"
    group by company_name,dept_name;



-- 4) Salaries spending on Indian Employees in every company

select company_name,dept_name,sum(salary)
	from employee
	where nationality = "Indian"
    group by company_name,dept_name;
    
    
-- 5) maximum hike in every company males and females 
select company_name,gender, max(increment) 
	from employee
    where is_permenant = False and shift_time = "Night"
    group by company_name,gender;

-- 6) count temporary employees count in every company's department
select company_name,dept_name,count(*) 
	from employee
    where is_permenant = False
    group by company_name,dept_name;




select count(*) from  employee;


select * from employee e1
	where salary > (
			select avg(salary) from employee e2
            where e2.dept_id = e1.dept_id
		);
        
CREATE TABLE employees (
    emp_id INT PRIMARY KEY,
    emp_name VARCHAR(30) NOT NULL,
    department VARCHAR(20),
    salary INT,
    hire_date DATE,
    city VARCHAR(20)
);
INSERT INTO employees VALUES
(101, 'Rahul Sharma', 'HR', 35000, '2022-01-15', 'Hyderabad'),
(102, 'Priya Reddy', 'IT', 60000, '2021-06-20', 'Chennai'),
(103, 'Arjun Kumar', 'Finance', 50000, '2023-03-12', 'Bangalore'),
(104, 'Sneha Patel', 'IT', 70000, '2020-09-18', 'Mumbai'),
(105, 'Vikram Singh', 'Sales', 45000, '2022-11-05', 'Delhi'),
(106, 'Ananya Das', 'HR', 38000, '2024-02-10', 'Kolkata'),
(107, 'Rohit Verma', 'Finance', 55000, '2021-08-30', 'Pune'),
(108, 'Meena Nair', 'Sales', 47000, '2023-07-22', 'Chennai'),
(109, 'Sai Krishna', 'IT', 65000, '2022-05-14', 'Hyderabad'),
(110, 'Divya Iyer', 'Marketing', 52000, '2020-12-01', 'Bangalore');


select * from employees;

select * from employees e1
	where salary > (
		select avg(salary) from employees e2
        where e2.department = e1.department
    );
    
select * from employees
	where salary > (select avg(salary) from employees
						where department = "HR");
          
          
select * from employees
	where department in(
		select department from employees
		group by department
		having count(*) >= 2
    );

          
select department from employees
	group by department
    having count(*) >= 2;