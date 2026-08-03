create database test;
use test;

create table student(
	ht_number int primary key,
    name varchar(20) not null,
    gender char,
    dob date,
    email varchar(35),
    phone_number varchar(10),
    cgpa float,
    attendance_percentage int,
    dept_id int,
    dept_name varchar(20),
    yop int,
    academic_fee int,
    blood_group char(3),
    college_name varchar(20),
    pin_code int(6),
    nationality varchar(20),
    state varchar(20)
);


INSERT INTO student (ht_number, name, gender, dob, email, phone_number, cgpa, attendance_percentage, dept_id, dept_name, yop, academic_fee, blood_group, college_name, pin_code, nationality, state) 
VALUES 
-- Block 1: CSE Students (Indian - Tamil Nadu)
(1001, 'Aarav Kumar', 'M', '2003-01-15', 'aarav.k@gmail.com', '9876543001', 8.5, 88, 302, 'CSE', 2025, 200000, 'O+', 'SSN', 600119, 'Indian', 'Tamil Nadu'),
(1002, 'Diya Raj', 'F', '2004-02-20', 'diya.r@gmail.com', '9876543002', 9.1, 75, 302, 'CSE', 2026, 210000, 'B+', 'CEG', 600025, 'Indian', 'Tamil Nadu'),
(1003, 'Karthik Natarajan', 'M', '2002-05-10', 'karthik.n@yahoo.com', '9876543003', 7.5, 45, 302, 'CSE', 2024, 200000, 'A+', 'MIT', 600044, 'Indian', 'Tamil Nadu'),
(1004, 'Swathi Mohan', 'F', '2003-08-11', 'swathi.m@gmail.com', '9876543004', 8.5, 88, 302, 'CSE', 2025, 220000, 'O-', 'SRM', 603203, 'Indian', 'Tamil Nadu'),
(1005, 'Arjun Vijay', 'M', '2005-11-22', 'arjun.v@outlook.com', '9876543005', 6.8, 55, 302, 'CSE', 2027, 190000, 'AB+', 'VIT', 632014, 'Indian', 'Tamil Nadu'),
(1006, 'Pooja Iyer', 'F', '2004-12-05', 'pooja.i@gmail.com', '9876543006', 9.4, 90, 302, 'CSE', 2026, 200000, 'B-', 'SSN', 600119, 'Indian', 'Tamil Nadu'),
(1007, 'Sanjay Ram', 'M', '2006-03-14', 'sanjay.r@gmail.com', '9876543007', 7.2, 68, 302, 'CSE', 2028, 180000, 'O+', 'KCG', 600097, 'Indian', 'Tamil Nadu'),
(1008, 'Lakshmi K', 'F', '2003-07-19', 'lakshmi.k@gmail.com', '9876543008', 8.1, 78, 302, 'CSE', 2025, 175000, 'A-', 'PERI', 600126, 'Indian', 'Tamil Nadu'),
(1009, 'Vignesh S', 'M', '2002-09-30', 'vignesh.s@yahoo.com', '9876543009', 5.9, 35, 302, 'CSE', 2024, 160000, 'O+', 'CIT', 600069, 'Indian', 'Tamil Nadu'),
(1010, 'Nithya R', 'F', '2007-04-12', 'nithya.r@gmail.com', '9876543010', 8.5, 88, 302, 'CSE', 2029, 200000, 'AB-', 'GNC', 600042, 'Indian', 'Tamil Nadu'),

-- Block 2: MECH Students (Indian - Maharashtra & Gujarat)
(1011, 'Rohan Sharma', 'M', '2003-01-21', 'rohan.s@gmail.com', '9765432011', 7.2, 68, 301, 'MECH', 2025, 150000, 'O+', 'PDKV', 400001, 'Indian', 'Maharashtra'),
(1012, 'Aditi Joshi', 'F', '2004-05-16', 'aditi.j@yahoo.com', '9765432012', 8.8, 78, 301, 'MECH', 2026, 150000, 'A+', 'PDKV', 400001, 'Indian', 'Maharashtra'),
(1013, 'Vedant Patil', 'M', '2002-10-10', 'vedant.p@gmail.com', '9765432013', 6.5, 45, 301, 'MECH', 2024, 140000, 'B+', 'PDKV', 400001, 'Indian', 'Maharashtra'),
(1014, 'Neha Deshmukh', 'F', '2005-12-08', 'neha.d@gmail.com', '9765432014', 9.0, 85, 301, 'MECH', 2027, 160000, 'O-', 'PDKV', 400001, 'Indian', 'Maharashtra'),
(1015, 'Pranav Kadam', 'M', '2006-02-14', 'pranav.k@outlook.com', '9765432015', 7.2, 55, 301, 'MECH', 2028, 150000, 'A-', 'PDKV', 400001, 'Indian', 'Maharashtra'),
(1016, 'Harsh Patel', 'M', '2003-08-22', 'harsh.p@gmail.com', '9654321016', 8.1, 75, 301, 'MECH', 2025, 155000, 'O+', 'PSVPCE', 380001, 'Indian', 'Gujarat'),
(1017, 'Isha Shah', 'F', '2004-11-30', 'isha.s@gmail.com', '9654321017', 7.5, 62, 301, 'MECH', 2026, 155000, 'B-', 'PSVPCE', 380001, 'Indian', 'Gujarat'),
(1018, 'Dev Mehta', 'M', '2002-04-18', 'dev.m@yahoo.com', '9654321018', 6.5, 40, 301, 'MECH', 2024, 150000, 'AB+', 'PSVPCE', 380001, 'Indian', 'Gujarat'),
(1019, 'Mira Desai', 'F', '2005-07-25', 'mira.d@gmail.com', '9654321019', 8.5, 88, 301, 'MECH', 2027, 160000, 'O+', 'PSVPCE', 380001, 'Indian', 'Gujarat'),
(1020, 'Karan Bhatt', 'M', '2007-09-12', 'karan.b@gmail.com', '9654321020', 7.8, 68, 301, 'MECH', 2029, 155000, 'A+', 'PSVPCE', 380001, 'Indian', 'Gujarat'),

-- Block 3: ECE Students (Foreign - USA & Canada)
(1021, 'Michael Smith', 'M', '2003-03-10', 'michael.s@gmail.com', '1202555021', 9.1, 85, 303, 'ECE', 2025, 350000, 'O+', 'VIT', 902100, 'American', 'California'),
(1022, 'Emily Davis', 'F', '2004-06-15', 'emily.d@yahoo.com', '1202555022', 8.5, 75, 303, 'ECE', 2026, 350000, 'A+', 'SRM', 902100, 'American', 'California'),
(1023, 'James Wilson', 'M', '2002-12-05', 'james.w@gmail.com', '1202555023', 7.5, 55, 303, 'ECE', 2024, 340000, 'B+', 'SSN', 902100, 'American', 'California'),
(1024, 'Olivia Taylor', 'F', '2005-02-28', 'olivia.t@outlook.com', '1202555024', 9.5, 90, 303, 'ECE', 2027, 360000, 'O-', 'MIT', 902100, 'American', 'California'),
(1025, 'William Brown', 'M', '2006-09-19', 'william.b@gmail.com', '1202555025', 7.2, 45, 303, 'ECE', 2028, 350000, 'AB+', 'CEG', 902100, 'American', 'California'),
(1026, 'Sophia Miller', 'F', '2003-11-22', 'sophia.m@gmail.com', '1416555026', 8.8, 88, 303, 'ECE', 2025, 330000, 'A-', 'VIT', 802100, 'Canadian', 'Ontario'),
(1027, 'Benjamin Moore', 'M', '2004-04-14', 'benjamin.m@yahoo.com', '1416555027', 8.1, 68, 303, 'ECE', 2026, 330000, 'O+', 'SRM', 802100, 'Canadian', 'Ontario'),
(1028, 'Isabella White', 'F', '2002-08-30', 'isabella.w@gmail.com', '1416555028', 7.5, 55, 303, 'ECE', 2024, 320000, 'B-', 'SSN', 802100, 'Canadian', 'Ontario'),
(1029, 'Lucas Harris', 'M', '2005-05-11', 'lucas.h@gmail.com', '1416555029', 9.1, 78, 303, 'ECE', 2027, 340000, 'AB-', 'MIT', 802100, 'Canadian', 'Ontario'),
(1030, 'Mia Martin', 'F', '2007-01-25', 'mia.m@outlook.com', '1416555030', 8.5, 75, 303, 'ECE', 2029, 330000, 'O+', 'CEG', 802100, 'Canadian', 'Ontario'),

-- Block 4: CIVIL Students (Indian - Karnataka & Telangana)
(1031, 'Rahul Gowda', 'M', '2003-02-18', 'rahul.g@gmail.com', '9543210031', 7.2, 68, 304, 'CIVIL', 2025, 140000, 'O+', 'CIT', 560001, 'Indian', 'Karnataka'),
(1032, 'Ananya Rao', 'F', '2004-07-22', 'ananya.r@yahoo.com', '9543210032', 8.5, 88, 304, 'CIVIL', 2026, 145000, 'B+', 'PERI', 560001, 'Indian', 'Karnataka'),
(1033, 'Kiran Kumar', 'M', '2002-11-05', 'kiran.k@gmail.com', '9543210033', 6.5, 45, 304, 'CIVIL', 2024, 135000, 'A+', 'GNC', 560001, 'Indian', 'Karnataka'),
(1034, 'Shreya Shetty', 'F', '2005-09-14', 'shreya.s@gmail.com', '9543210034', 9.1, 85, 304, 'CIVIL', 2027, 150000, 'O-', 'CIT', 560001, 'Indian', 'Karnataka'),
(1035, 'Naveen Bhat', 'M', '2006-12-01', 'naveen.b@outlook.com', '9543210035', 7.8, 55, 304, 'CIVIL', 2028, 140000, 'AB+', 'PERI', 560001, 'Indian', 'Karnataka'),
(1036, 'Tarun Reddy', 'M', '2003-04-10', 'tarun.r@gmail.com', '9432100036', 8.1, 75, 304, 'CIVIL', 2025, 140000, 'A-', 'GNC', 500001, 'Indian', 'Telangana'),
(1037, 'Keerthi Das', 'F', '2004-08-25', 'keerthi.d@gmail.com', '9432100037', 7.5, 62, 304, 'CIVIL', 2026, 145000, 'O+', 'CIT', 500001, 'Indian', 'Telangana'),
(1038, 'Akhil Sharma', 'M', '2002-01-30', 'akhil.s@yahoo.com', '9432100038', 6.5, 40, 304, 'CIVIL', 2024, 135000, 'B-', 'PERI', 500001, 'Indian', 'Telangana'),
(1039, 'Sanjana G', 'F', '2005-03-12', 'sanjana.g@gmail.com', '9432100039', 8.5, 88, 304, 'CIVIL', 2027, 150000, 'O+', 'GNC', 500001, 'Indian', 'Telangana'),
(1040, 'Manoj V', 'M', '2007-06-18', 'manoj.v@gmail.com', '9432100040', 7.2, 68, 304, 'CIVIL', 2029, 140000, 'AB-', 'CIT', 500001, 'Indian', 'Telangana'),

-- Block 5: IT Students (Foreign - UK & Australia)
(1041, 'George Evans', 'M', '2003-05-14', 'george.e@gmail.com', '4420712341', 8.5, 88, 305, 'IT', 2025, 360000, 'O+', 'VIT', 100001, 'British', 'London'),
(1042, 'Charlotte King', 'F', '2004-10-21', 'charlotte.k@yahoo.com', '4420712342', 9.1, 85, 305, 'IT', 2026, 370000, 'A+', 'SSN', 100001, 'British', 'London'),
(1043, 'Harry Wright', 'M', '2002-02-08', 'harry.w@gmail.com', '4420712343', 7.5, 55, 305, 'IT', 2024, 350000, 'B+', 'SRM', 100001, 'British', 'London'),
(1044, 'Amelia Scott', 'F', '2005-07-30', 'amelia.s@outlook.com', '4420712344', 9.5, 90, 305, 'IT', 2027, 380000, 'O-', 'MIT', 100001, 'British', 'London'),
(1045, 'Jack Green', 'M', '2006-11-12', 'jack.g@gmail.com', '4420712345', 7.2, 68, 305, 'IT', 2028, 360000, 'AB+', 'CEG', 100001, 'British', 'London'),
(1046, 'Oliver Thomas', 'M', '2003-09-05', 'oliver.t@gmail.com', '6129876046', 8.8, 78, 305, 'IT', 2025, 340000, 'A-', 'VIT', 200000, 'Australian', 'NSW'),
(1047, 'Ava Jackson', 'F', '2004-12-18', 'ava.j@yahoo.com', '6129876047', 8.1, 75, 305, 'IT', 2026, 350000, 'O+', 'SSN', 200000, 'Australian', 'NSW'),
(1048, 'Noah White', 'M', '2002-03-25', 'noah.w@gmail.com', '6129876048', 6.5, 45, 305, 'IT', 2024, 330000, 'B-', 'SRM', 200000, 'Australian', 'NSW'),
(1049, 'Chloe Harris', 'F', '2005-08-09', 'chloe.h@gmail.com', '6129876049', 9.1, 85, 305, 'IT', 2027, 360000, 'O+', 'MIT', 200000, 'Australian', 'NSW'),
(1050, 'Ethan Martin', 'M', '2007-02-14', 'ethan.m@outlook.com', '6129876050', 7.8, 68, 305, 'IT', 2029, 340000, 'AB-', 'CEG', 200000, 'Australian', 'NSW'),

-- Block 6: Mixed Depts (Indian - Delhi & Kerala)
(1051, 'Aryan Singh', 'M', '2003-06-20', 'aryan.s@gmail.com', '9321000051', 8.5, 88, 302, 'CSE', 2025, 210000, 'O+', 'VIT', 110001, 'Indian', 'Delhi'),
(1052, 'Kavya Sharma', 'F', '2004-01-11', 'kavya.s@yahoo.com', '9321000052', 9.1, 75, 303, 'ECE', 2026, 200000, 'B+', 'SRM', 110001, 'Indian', 'Delhi'),
(1053, 'Rishabh Verma', 'M', '2002-09-05', 'rishabh.v@gmail.com', '9321000053', 7.5, 55, 301, 'MECH', 2024, 150000, 'A+', 'MIT', 110001, 'Indian', 'Delhi'),
(1054, 'Sneha Kapoor', 'F', '2005-04-18', 'sneha.k@gmail.com', '9321000054', 8.8, 85, 305, 'IT', 2027, 215000, 'O-', 'SSN', 110001, 'Indian', 'Delhi'),
(1055, 'Rohan Gupta', 'M', '2006-10-22', 'rohan.g@outlook.com', '9321000055', 7.2, 68, 304, 'CIVIL', 2028, 140000, 'AB+', 'CEG', 110001, 'Indian', 'Delhi'),
(1056, 'Abhinav Nair', 'M', '2003-12-15', 'abhinav.n@gmail.com', '9210000056', 8.1, 78, 302, 'CSE', 2025, 205000, 'A-', 'KCG', 682001, 'Indian', 'Kerala'),
(1057, 'Meenakshi Menon', 'F', '2004-05-30', 'meenakshi.m@gmail.com', '9210000057', 9.5, 90, 303, 'ECE', 2026, 195000, 'O+', 'PERI', 682001, 'Indian', 'Kerala'),
(1058, 'Vishnu Prasad', 'M', '2002-08-14', 'vishnu.p@yahoo.com', '9210000058', 6.5, 45, 301, 'MECH', 2024, 145000, 'B-', 'GNC', 682001, 'Indian', 'Kerala'),
(1059, 'Anjali Pillai', 'F', '2005-11-09', 'anjali.p@gmail.com', '9210000059', 8.5, 88, 305, 'IT', 2027, 210000, 'O+', 'CIT', 682001, 'Indian', 'Kerala'),
(1060, 'Gautham K', 'M', '2007-03-25', 'gautham.k@gmail.com', '9210000060', 7.8, 68, 304, 'CIVIL', 2029, 145000, 'AB-', 'PDKV', 682001, 'Indian', 'Kerala'),

-- Block 7: Repeated Names / Different Data (Indian - Tamil Nadu)
(1061, 'Rahul Sharma', 'M', '2003-02-10', 'rahul.s2@gmail.com', '9100000061', 8.5, 88, 303, 'ECE', 2025, 180000, 'O+', 'SSN', 600119, 'Indian', 'Tamil Nadu'),
(1062, 'Priya Singh', 'F', '2004-06-25', 'priya.s2@yahoo.com', '9100000062', 9.1, 85, 302, 'CSE', 2026, 200000, 'A+', 'CEG', 600025, 'Indian', 'Tamil Nadu'),
(1063, 'Karthik Raja', 'M', '2002-11-15', 'karthik.r2@gmail.com', '9100000063', 7.5, 55, 305, 'IT', 2024, 190000, 'B+', 'MIT', 600044, 'Indian', 'Tamil Nadu'),
(1064, 'Swathi Mohan', 'F', '2005-01-30', 'swathi.m2@gmail.com', '9100000064', 8.8, 75, 304, 'CIVIL', 2027, 130000, 'O-', 'SRM', 603203, 'Indian', 'Tamil Nadu'),
(1065, 'Arjun Vijay', 'M', '2006-08-12', 'arjun.v2@outlook.com', '9100000065', 7.2, 68, 301, 'MECH', 2028, 150000, 'AB+', 'VIT', 632014, 'Indian', 'Tamil Nadu'),
(1066, 'Pooja Iyer', 'F', '2003-04-18', 'pooja.i2@gmail.com', '9000000066', 8.1, 78, 302, 'CSE', 2025, 200000, 'A-', 'SSN', 600119, 'Indian', 'Tamil Nadu'),
(1067, 'Sanjay Ram', 'M', '2004-09-05', 'sanjay.r2@gmail.com', '9000000067', 9.5, 90, 303, 'ECE', 2026, 185000, 'O+', 'KCG', 600097, 'Indian', 'Tamil Nadu'),
(1068, 'Lakshmi K', 'F', '2002-12-22', 'lakshmi.k2@yahoo.com', '9000000068', 6.5, 45, 305, 'IT', 2024, 190000, 'B-', 'PERI', 600126, 'Indian', 'Tamil Nadu'),
(1069, 'Vignesh S', 'M', '2005-05-14', 'vignesh.s2@gmail.com', '9000000069', 8.5, 88, 304, 'CIVIL', 2027, 135000, 'O+', 'CIT', 600069, 'Indian', 'Tamil Nadu'),
(1070, 'Nithya R', 'F', '2007-10-30', 'nithya.r2@gmail.com', '9000000070', 7.8, 68, 301, 'MECH', 2029, 155000, 'AB-', 'GNC', 600042, 'Indian', 'Tamil Nadu'),

-- Block 8: Mixed (Foreign - Germany & France)
(1071, 'Lukas Schmidt', 'M', '2003-07-11', 'lukas.s@gmail.com', '4915200071', 8.5, 88, 302, 'CSE', 2025, 380000, 'O+', 'VIT', 101150, 'German', 'Berlin'),
(1072, 'Hannah Becker', 'F', '2004-02-28', 'hannah.b@yahoo.com', '4915200072', 9.1, 85, 303, 'ECE', 2026, 360000, 'B+', 'SRM', 101150, 'German', 'Berlin'),
(1073, 'Felix Wagner', 'M', '2002-11-09', 'felix.w@gmail.com', '4915200073', 7.5, 55, 301, 'MECH', 2024, 340000, 'A+', 'MIT', 101150, 'German', 'Berlin'),
(1074, 'Laura Hoffmann', 'F', '2005-04-16', 'laura.h@outlook.com', '4915200074', 8.8, 75, 305, 'IT', 2027, 390000, 'O-', 'SSN', 101150, 'German', 'Berlin'),
(1075, 'Julian Koch', 'M', '2006-08-25', 'julian.k@gmail.com', '4915200075', 7.2, 68, 304, 'CIVIL', 2028, 330000, 'AB+', 'CEG', 101150, 'German', 'Berlin'),
(1076, 'Hugo Bernard', 'M', '2003-01-18', 'hugo.b@gmail.com', '3361200076', 8.1, 78, 302, 'CSE', 2025, 370000, 'A-', 'VIT', 750010, 'French', 'IDF'),
(1077, 'Alice Dubois', 'F', '2004-06-05', 'alice.d@gmail.com', '3361200077', 9.5, 90, 303, 'ECE', 2026, 350000, 'O+', 'SRM', 750010, 'French', 'IDF'),
(1078, 'Leo Thomas', 'M', '2002-12-14', 'leo.t@yahoo.com', '3361200078', 6.5, 45, 301, 'MECH', 2024, 330000, 'B-', 'MIT', 750010, 'French', 'IDF'),
(1079, 'Emma Robert', 'F', '2005-09-22', 'emma.r@gmail.com', '3361200079', 8.5, 88, 305, 'IT', 2027, 380000, 'O+', 'SSN', 750010, 'French', 'IDF'),
(1080, 'Louis Richard', 'M', '2007-03-30', 'louis.r@gmail.com', '3361200080', 7.8, 68, 304, 'CIVIL', 2029, 320000, 'AB-', 'CEG', 750010, 'French', 'IDF'),

-- Block 9: More CSE & IT (Indian - Tamil Nadu)
(1081, 'Varun Krishnan', 'M', '2003-05-10', 'varun.k@gmail.com', '8900000081', 8.5, 88, 302, 'CSE', 2025, 205000, 'O+', 'SSN', 600119, 'Indian', 'Tamil Nadu'),
(1082, 'Deepa G', 'F', '2004-10-15', 'deepa.g@yahoo.com', '8900000082', 9.1, 85, 305, 'IT', 2026, 215000, 'B+', 'CEG', 600025, 'Indian', 'Tamil Nadu'),
(1083, 'Ravi Teja', 'M', '2002-02-28', 'ravi.t@gmail.com', '8900000083', 7.5, 55, 302, 'CSE', 2024, 200000, 'A+', 'MIT', 600044, 'Indian', 'Tamil Nadu'),
(1084, 'Shalini V', 'F', '2005-07-12', 'shalini.v@gmail.com', '8900000084', 8.8, 75, 305, 'IT', 2027, 220000, 'O-', 'SRM', 603203, 'Indian', 'Tamil Nadu'),
(1085, 'Dinesh Kumar', 'M', '2006-12-05', 'dinesh.k@outlook.com', '8900000085', 7.2, 68, 302, 'CSE', 2028, 195000, 'AB+', 'VIT', 632014, 'Indian', 'Tamil Nadu'),
(1086, 'Kavitha M', 'F', '2003-08-20', 'kavitha.m@gmail.com', '8800000086', 8.1, 78, 305, 'IT', 2025, 210000, 'A-', 'SSN', 600119, 'Indian', 'Tamil Nadu'),
(1087, 'Prashanth S', 'M', '2004-01-25', 'prashanth.s@gmail.com', '8800000087', 9.5, 90, 302, 'CSE', 2026, 205000, 'O+', 'KCG', 600097, 'Indian', 'Tamil Nadu'),
(1088, 'Anusuya R', 'F', '2002-04-14', 'anusuya.r@yahoo.com', '8800000088', 6.5, 45, 305, 'IT', 2024, 200000, 'B-', 'PERI', 600126, 'Indian', 'Tamil Nadu'),
(1089, 'Madhavan C', 'M', '2005-09-30', 'madhavan.c@gmail.com', '8800000089', 8.5, 88, 302, 'CSE', 2027, 190000, 'O+', 'CIT', 600069, 'Indian', 'Tamil Nadu'),
(1090, 'Gayathri P', 'F', '2007-02-18', 'gayathri.p@gmail.com', '8800000090', 7.8, 68, 305, 'IT', 2029, 210000, 'AB-', 'GNC', 600042, 'Indian', 'Tamil Nadu'),

-- Block 10: More CIVIL & MECH (Indian - Andhra Pradesh)
(1091, 'Sai Ram', 'M', '2003-04-22', 'sai.r@gmail.com', '8700000091', 8.5, 88, 304, 'CIVIL', 2025, 140000, 'O+', 'VIT', 520001, 'Indian', 'Andhra Pradesh'),
(1092, 'Bhavya Sri', 'F', '2004-11-05', 'bhavya.s@yahoo.com', '8700000092', 9.1, 85, 301, 'MECH', 2026, 150000, 'B+', 'SRM', 520001, 'Indian', 'Andhra Pradesh'),
(1093, 'Venkatesh K', 'M', '2002-07-16', 'venkatesh.k@gmail.com', '8700000093', 7.5, 55, 304, 'CIVIL', 2024, 135000, 'A+', 'MIT', 520001, 'Indian', 'Andhra Pradesh'),
(1094, 'Harika M', 'F', '2005-02-28', 'harika.m@gmail.com', '8700000094', 8.8, 75, 301, 'MECH', 2027, 155000, 'O-', 'SSN', 520001, 'Indian', 'Andhra Pradesh'),
(1095, 'Kalyan Babu', 'M', '2006-08-10', 'kalyan.b@outlook.com', '8700000095', 7.2, 68, 304, 'CIVIL', 2028, 140000, 'AB+', 'CEG', 520001, 'Indian', 'Andhra Pradesh'),
(1096, 'Mahesh D', 'M', '2003-12-25', 'mahesh.d@gmail.com', '8600000096', 8.1, 78, 301, 'MECH', 2025, 145000, 'A-', 'KCG', 520001, 'Indian', 'Andhra Pradesh'),
(1097, 'Swetha P', 'F', '2004-05-14', 'swetha.p@gmail.com', '8600000097', 9.5, 90, 304, 'CIVIL', 2026, 145000, 'O+', 'PERI', 520001, 'Indian', 'Andhra Pradesh'),
(1098, 'Rakesh G', 'M', '2002-10-30', 'rakesh.g@yahoo.com', '8600000098', 6.5, 45, 301, 'MECH', 2024, 140000, 'B-', 'GNC', 520001, 'Indian', 'Andhra Pradesh'),
(1099, 'Sindhu J', 'F', '2005-03-21', 'sindhu.j@gmail.com', '8600000099', 8.5, 88, 304, 'CIVIL', 2027, 145000, 'O+', 'CIT', 520001, 'Indian', 'Andhra Pradesh'),
(1100, 'Charan N', 'M', '2007-09-08', 'charan.n@gmail.com', '8600000100', 7.8, 68, 301, 'MECH', 2029, 150000, 'AB-', 'PDKV', 520001, 'Indian', 'Andhra Pradesh'),

-- Block 11: ECE Students (Indian - Various States)
(1101, 'Aman Verma', 'M', '2003-02-14', 'aman.v@gmail.com', '8500000101', 8.5, 88, 303, 'ECE', 2025, 180000, 'O+', 'VIT', 226001, 'Indian', 'Uttar Pradesh'),
(1102, 'Riya Sen', 'F', '2004-07-28', 'riya.s@yahoo.com', '8500000102', 9.1, 85, 303, 'ECE', 2026, 185000, 'B+', 'SRM', 700001, 'Indian', 'West Bengal'),
(1103, 'Vikram Das', 'M', '2002-11-19', 'vikram.d@gmail.com', '8500000103', 7.5, 55, 303, 'ECE', 2024, 175000, 'A+', 'MIT', 751001, 'Indian', 'Odisha'),
(1104, 'Sonali K', 'F', '2005-04-10', 'sonali.k@gmail.com', '8500000104', 8.8, 75, 303, 'ECE', 2027, 190000, 'O-', 'SSN', 800001, 'Indian', 'Bihar'),
(1105, 'Kunal Singh', 'M', '2006-09-22', 'kunal.s@outlook.com', '8500000105', 7.2, 68, 303, 'ECE', 2028, 180000, 'AB+', 'CEG', 302001, 'Indian', 'Rajasthan'),
(1106, 'Pawan M', 'M', '2003-12-05', 'pawan.m@gmail.com', '8400000106', 8.1, 78, 303, 'ECE', 2025, 185000, 'A-', 'KCG', 462001, 'Indian', 'Madhya Pradesh'),
(1107, 'Anita R', 'F', '2004-05-18', 'anita.r@gmail.com', '8400000107', 9.5, 90, 303, 'ECE', 2026, 180000, 'O+', 'PERI', 143001, 'Indian', 'Punjab'),
(1108, 'Rajat K', 'M', '2002-08-30', 'rajat.k@yahoo.com', '8400000108', 6.5, 45, 303, 'ECE', 2024, 170000, 'B-', 'GNC', 171001, 'Indian', 'Himachal'),
(1109, 'Nikita S', 'F', '2005-01-14', 'nikita.s@gmail.com', '8400000109', 8.5, 88, 303, 'ECE', 2027, 185000, 'O+', 'CIT', 781001, 'Indian', 'Assam'),
(1110, 'Sameer P', 'M', '2007-06-25', 'sameer.p@gmail.com', '8400000110', 7.8, 68, 303, 'ECE', 2029, 180000, 'AB-', 'PDKV', 492001, 'Indian', 'Chhattisgarh'),

-- Block 12: More Foreigners (Mixed Nationalities)
(1111, 'Kenji Sato', 'M', '2003-03-12', 'kenji.s@gmail.com', '8190000111', 8.5, 88, 302, 'CSE', 2025, 400000, 'O+', 'VIT', 100000, 'Japanese', 'Tokyo'),
(1112, 'Yuki Takahashi', 'F', '2004-08-20', 'yuki.t@yahoo.com', '8190000112', 9.1, 85, 303, 'ECE', 2026, 380000, 'B+', 'SRM', 100000, 'Japanese', 'Tokyo'),
(1113, 'Min-jun Kim', 'M', '2002-12-05', 'minjun.k@gmail.com', '8220000113', 7.5, 55, 305, 'IT', 2024, 390000, 'A+', 'MIT', 060000, 'South Korean', 'Seoul'),
(1114, 'Seo-yeon Lee', 'F', '2005-04-18', 'seoyeon.l@gmail.com', '8220000114', 8.8, 75, 302, 'CSE', 2027, 410000, 'O-', 'SSN', 060000, 'South Korean', 'Seoul'),
(1115, 'Wei Chen', 'M', '2006-09-30', 'wei.c@outlook.com', '8610000115', 7.2, 68, 301, 'MECH', 2028, 350000, 'AB+', 'CEG', 100000, 'Chinese', 'Beijing'),
(1116, 'Jing Wang', 'F', '2003-01-14', 'jing.w@gmail.com', '8610000116', 8.1, 78, 304, 'CIVIL', 2025, 340000, 'A-', 'VIT', 100000, 'Chinese', 'Beijing'),
(1117, 'Mateo Garcia', 'M', '2004-06-25', 'mateo.g@gmail.com', '3490000117', 9.5, 90, 303, 'ECE', 2026, 360000, 'O+', 'SRM', 280010, 'Spanish', 'Madrid'),
(1118, 'Sofia Martinez', 'F', '2002-11-10', 'sofia.m@yahoo.com', '3490000118', 6.5, 45, 305, 'IT', 2024, 370000, 'B-', 'SSN', 280010, 'Spanish', 'Madrid'),
(1119, 'Luca Rossi', 'M', '2005-02-22', 'luca.r@gmail.com', '3960000119', 8.5, 88, 302, 'CSE', 2027, 390000, 'O+', 'MIT', 001000, 'Italian', 'Lazio'),
(1120, 'Giulia Bianchi', 'F', '2007-07-15', 'giulia.b@gmail.com', '3960000120', 7.8, 68, 301, 'MECH', 2029, 350000, 'AB-', 'CEG', 001000, 'Italian', 'Lazio'),

-- Block 13: Final mixed batch 1 (Indian - Tamil Nadu mostly)
(1121, 'Harish K', 'M', '2003-05-18', 'harish.k@gmail.com', '7900000121', 8.5, 88, 301, 'MECH', 2025, 150000, 'O+', 'PSVPCE', 600119, 'Indian', 'Tamil Nadu'),
(1122, 'Nandini P', 'F', '2004-10-22', 'nandini.p@yahoo.com', '7900000122', 9.1, 85, 302, 'CSE', 2026, 200000, 'B+', 'PDKV', 600025, 'Indian', 'Tamil Nadu'),
(1123, 'Pradeep M', 'M', '2002-03-05', 'pradeep.m@gmail.com', '7900000123', 7.5, 55, 303, 'ECE', 2024, 180000, 'A+', 'CIT', 600044, 'Indian', 'Tamil Nadu'),
(1124, 'Roshni S', 'F', '2005-08-14', 'roshni.s@gmail.com', '7900000124', 8.8, 75, 304, 'CIVIL', 2027, 140000, 'O-', 'VIT', 603203, 'Indian', 'Tamil Nadu'),
(1125, 'Kishore V', 'M', '2006-01-30', 'kishore.v@outlook.com', '7900000125', 7.2, 68, 305, 'IT', 2028, 210000, 'AB+', 'SSN', 632014, 'Indian', 'Tamil Nadu'),
(1126, 'Saranya R', 'F', '2003-06-12', 'saranya.r@gmail.com', '7800000126', 8.1, 78, 301, 'MECH', 2025, 155000, 'A-', 'SRM', 600097, 'Indian', 'Tamil Nadu'),
(1127, 'Bala C', 'M', '2004-11-25', 'bala.c@gmail.com', '7800000127', 9.5, 90, 302, 'CSE', 2026, 205000, 'O+', 'MIT', 600126, 'Indian', 'Tamil Nadu'),
(1128, 'Preethi N', 'F', '2002-04-10', 'preethi.n@yahoo.com', '7800000128', 6.5, 45, 303, 'ECE', 2024, 175000, 'B-', 'CEG', 600069, 'Indian', 'Tamil Nadu'),
(1129, 'Gokul D', 'M', '2005-09-21', 'gokul.d@gmail.com', '7800000129', 8.5, 88, 304, 'CIVIL', 2027, 145000, 'O+', 'KCG', 600042, 'Indian', 'Tamil Nadu'),
(1130, 'Malar G', 'F', '2007-02-05', 'malar.g@gmail.com', '7800000130', 7.8, 68, 305, 'IT', 2029, 215000, 'AB-', 'PERI', 600119, 'Indian', 'Tamil Nadu'),

-- Block 14: Final mixed batch 2 (Indian - Tamil Nadu mostly)
(1131, 'Ajay T', 'M', '2003-07-18', 'ajay.t@gmail.com', '7700000131', 8.5, 88, 302, 'CSE', 2025, 200000, 'O+', 'GNC', 600119, 'Indian', 'Tamil Nadu'),
(1132, 'Pavithra B', 'F', '2004-12-22', 'pavithra.b@yahoo.com', '7700000132', 9.1, 85, 303, 'ECE', 2026, 185000, 'B+', 'PSVPCE', 600025, 'Indian', 'Tamil Nadu'),
(1133, 'Surya P', 'M', '2002-05-05', 'surya.p@gmail.com', '7700000133', 7.5, 55, 301, 'MECH', 2024, 150000, 'A+', 'PDKV', 600044, 'Indian', 'Tamil Nadu'),
(1134, 'Indhu M', 'F', '2005-10-14', 'indhu.m@gmail.com', '7700000134', 8.8, 75, 305, 'IT', 2027, 220000, 'O-', 'CIT', 603203, 'Indian', 'Tamil Nadu'),
(1135, 'Loganathan R', 'M', '2006-03-30', 'loganathan.r@outlook.com', '7700000135', 7.2, 68, 304, 'CIVIL', 2028, 140000, 'AB+', 'VIT', 632014, 'Indian', 'Tamil Nadu'),
(1136, 'Keerthana S', 'F', '2003-08-12', 'keerthana.s@gmail.com', '7600000136', 8.1, 78, 302, 'CSE', 2025, 205000, 'A-', 'SSN', 600097, 'Indian', 'Tamil Nadu'),
(1137, 'Vijay K', 'M', '2004-01-25', 'vijay.k@gmail.com', '7600000137', 9.5, 90, 303, 'ECE', 2026, 180000, 'O+', 'SRM', 600126, 'Indian', 'Tamil Nadu'),
(1138, 'Ramya C', 'F', '2002-06-10', 'ramya.c@yahoo.com', '7600000138', 6.5, 45, 301, 'MECH', 2024, 155000, 'B-', 'MIT', 600069, 'Indian', 'Tamil Nadu'),
(1139, 'Hari V', 'M', '2005-11-21', 'hari.v@gmail.com', '7600000139', 8.5, 88, 305, 'IT', 2027, 210000, 'O+', 'CEG', 600042, 'Indian', 'Tamil Nadu'),
(1140, 'Geetha D', 'F', '2007-04-05', 'geetha.d@gmail.com', '7600000140', 7.8, 68, 304, 'CIVIL', 2029, 145000, 'AB-', 'KCG', 600119, 'Indian', 'Tamil Nadu'),

-- Block 15: Final mixed batch 3 (Indian - Tamil Nadu mostly)
(1141, 'Pranav S', 'M', '2003-09-18', 'pranav.s@gmail.com', '7500000141', 8.5, 88, 302, 'CSE', 2025, 200000, 'O+', 'PERI', 600119, 'Indian', 'Tamil Nadu'),
(1142, 'Divya P', 'F', '2004-02-22', 'divya.p@yahoo.com', '7500000142', 9.1, 85, 303, 'ECE', 2026, 185000, 'B+', 'GNC', 600025, 'Indian', 'Tamil Nadu'),
(1143, 'Murali K', 'M', '2002-07-05', 'murali.k@gmail.com', '7500000143', 7.5, 55, 301, 'MECH', 2024, 150000, 'A+', 'PSVPCE', 600044, 'Indian', 'Tamil Nadu'),
(1144, 'Lavanya M', 'F', '2005-12-14', 'lavanya.m@gmail.com', '7500000144', 8.8, 75, 305, 'IT', 2027, 220000, 'O-', 'PDKV', 603203, 'Indian', 'Tamil Nadu'),
(1145, 'Sudhakar R', 'M', '2006-05-30', 'sudhakar.r@outlook.com', '7500000145', 7.2, 68, 304, 'CIVIL', 2028, 140000, 'AB+', 'CIT', 632014, 'Indian', 'Tamil Nadu'),
(1146, 'Yamini S', 'F', '2003-10-12', 'yamini.s@gmail.com', '7400000146', 8.1, 78, 302, 'CSE', 2025, 205000, 'A-', 'VIT', 600097, 'Indian', 'Tamil Nadu'),
(1147, 'Jeeva K', 'M', '2004-03-25', 'jeeva.k@gmail.com', '7400000147', 9.5, 90, 303, 'ECE', 2026, 180000, 'O+', 'SSN', 600126, 'Indian', 'Tamil Nadu'),
(1148, 'Sowmya C', 'F', '2002-08-10', 'sowmya.c@yahoo.com', '7400000148', 6.5, 45, 301, 'MECH', 2024, 155000, 'B-', 'SRM', 600069, 'Indian', 'Tamil Nadu'),
(1149, 'Kavin V', 'M', '2005-01-21', 'kavin.v@gmail.com', '7400000149', 8.5, 88, 305, 'IT', 2027, 210000, 'O+', 'MIT', 600042, 'Indian', 'Tamil Nadu'),
(1150, 'Roopa D', 'F', '2007-06-05', 'roopa.d@gmail.com', '7400000150', 7.8, 68, 304, 'CIVIL', 2029, 145000, 'AB-', 'CEG', 600119, 'Indian', 'Tamil Nadu');

select * from student;

drop table student;


--  ========================== QUERIES =====================

select ht_number,name,blood_group
	from student
    where blood_group = 'o+';

select ht_number,name,cgpa,college_name
	from student
    where gender = 'F' and cgpa >= 9.0;
    
select * from student 
	where state = "Tamil Nadu" and college_name = "PSVPCE";
    
select ht_number,name,college_name,dob 
	from student
    where year(dob) >= 2005;

select ht_number, name ,email
	from student
	where email like("%yahoo.com");

select ht_number,name,college_name, yop-4 as yoj, yop
	from student
    where yop-4 = 2024;

select ht_number,college_name, academic_fee * 4 as total_fee
	from student;

select ht_number,college_name,nationality
	from student
    where nationality != "Indian";

select distinct(pin_code) from student
	where nationality = "Australian";

select distinct(state) from student
	where nationality = "Indian";


	

select state,sum(academic_fee) as fee
	from student
    group by state; 

select count(*) from student where state = "Maharashtra";


select ht_number,name
	from student
    where college_name = "PSVPCE" and 
			cgpa >= (
				select max(cgpa) from student 
                where college_name = "PSVPCE"
                );
                
select count(*) from student
	where cgpa >= 8.5 and 
		  nationality != "Indian";
          

select dept_name, count(*)
	from student
	where college_name = "MIT"
    group by dept_name;

select nationality,max(cgpa)
		from student
        group by nationality;



          
select nationality,count(*) 
	from student where cgpa > 9
	group by nationality;
    
    
    
select college_name,count(*) from student 
	where attendance_percentage <= 65
    group by college_name;
    

select college_name,max(attendance_percentage) 
	from student 
    group by college_name;
    
          
select state,college_name,gender,count(*) 
	from student where cgpa >= 8.5
    group by gender,college_name,state;
    
    
select count(distinct(college_name)) from student;



-- ================ NEW =================


create table employee(
	emp_id int primary key,
    emp_name varchar(20),
    gender char(1),
    email varchar(40),
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


INSERT INTO employee (emp_id, emp_name, gender, email, phone_number, experience, salary, increment, role, rating, dept_id, dept_name, shift_time, project_name, project_deadline, levae_count, is_permenant, company_name, nationality, state) 
VALUES 
-- DEPT 101: Engineering
(1, 'Aarav Patel', 'M', 'aarav1@google.com', '9800000001', 3, 120000, 12.5, 'Software Eng', 4, 101, 'Engineering', 'Day', 'Apollo', '2026-11-15', 2, TRUE, 'Google', 'Indian', 'Maharashtra'),
(2, 'Diya Sharma', 'F', 'diya2@google.com', '9800000002', 5, 150000, 15.0, 'Software Eng', 5, 101, 'Engineering', 'Day', 'Apollo', '2027-01-10', 1, TRUE, 'Google', 'Indian', 'Maharashtra'),
(3, 'John Doe', 'M', 'john3@ms.com', '9800000003', 2, 85000, 8.5, 'Software Eng', 3, 101, 'Engineering', 'Night', 'Titan', '2026-12-01', 4, FALSE, 'Microsoft', 'American', 'California'),
(4, 'Sarah Connor', 'F', 'sarah4@ms.com', '9800000004', 7, 175000, 20.0, 'DevOps Eng', 5, 101, 'Engineering', 'Day', 'Titan', '2027-03-20', 0, TRUE, 'Microsoft', 'American', 'California'),
(5, 'James Smith', 'M', 'james5@apple.com', '9800000005', 4, 110000, 10.0, 'Software Eng', 4, 101, 'Engineering', 'Day', 'Nexus', '2026-11-30', 3, TRUE, 'Apple', 'British', 'England'),
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






