-- ============================================================
-- SQL JOINS PRACTICE DATABASE
-- Database: MySQL 8+
-- Tables:
--   1. departments
--   2. employees
--   3. projects
--   4. employee_projects
--
-- The data intentionally contains:
--   * Employees without departments
--   * Departments without employees
--   * Employees without projects
--   * Projects without employees
--   * NULL managers, salaries, bonuses, dates, roles and hours
-- ============================================================

DROP TABLE IF EXISTS employee_projects;
DROP TABLE IF EXISTS projects;-- 
DROP TABLE IF EXISTS employees;
DROP TABLE IF EXISTS departments;

-- ============================================================
-- 1. DEPARTMENTS TABLE
-- ============================================================

CREATE TABLE departments (
    dept_id INT PRIMARY KEY,
    dept_name VARCHAR(50) NOT NULL UNIQUE,
    location VARCHAR(50),
    budget DECIMAL(12, 2)
);

INSERT INTO departments (dept_id, dept_name, location, budget) VALUES
(101, 'Human Resources',       'Hyderabad',  800000.00),
(102, 'Software Development',  'Bengaluru', 3500000.00),
(103, 'Testing',               'Chennai',   1800000.00),
(104, 'Finance',               'Mumbai',    1500000.00),
(105, 'Marketing',             'Delhi',     1200000.00),
(106, 'Customer Support',      'Pune',       900000.00),
(107, 'Research',              NULL,        2200000.00),
(108, 'Legal',                 'Kolkata',          NULL);

-- Department 107 and 108 intentionally have no employees.


-- ============================================================
-- 2. EMPLOYEES TABLE
-- ============================================================

CREATE TABLE employees (
    employee_id INT PRIMARY KEY,
    employee_name VARCHAR(100) NOT NULL,
    gender VARCHAR(10),
    dept_id INT,
    manager_id INT,
    salary DECIMAL(10, 2),
    bonus DECIMAL(10, 2),
    hire_date DATE,
    city VARCHAR(50),
    email VARCHAR(100) UNIQUE,

    CONSTRAINT fk_employee_department
        FOREIGN KEY (dept_id) REFERENCES departments(dept_id),

    CONSTRAINT fk_employee_manager
        FOREIGN KEY (manager_id) REFERENCES employees(employee_id)
);

-- Managers are inserted first because manager_id is a self-referencing key.

INSERT INTO employees
(employee_id, employee_name, gender, dept_id, manager_id, salary, bonus, hire_date, city, email)
VALUES
(1, 'Ananya Sharma',  'Female', 101, NULL, 85000.00, 10000.00, '2018-02-12', 'Hyderabad', 'ananya@company.com'),
(2, 'Rahul Verma',    'Male',   102, NULL, 120000.00, 20000.00, '2016-07-18', 'Bengaluru', 'rahul@company.com'),
(3, 'Meera Iyer',     'Female', 103, NULL, 95000.00, NULL,     '2019-01-23', 'Chennai',   'meera@company.com'),
(4, 'Vikram Singh',   'Male',   104, NULL, 105000.00, 15000.00,'2017-11-03', 'Mumbai',    'vikram@company.com'),
(5, 'Priya Reddy',    'Female', 105, NULL, 90000.00, 8000.00,  '2020-05-16', 'Delhi',     'priya@company.com'),
(6, 'Arjun Patel',    'Male',   106, NULL, 80000.00, NULL,     '2021-03-08', 'Pune',      'arjun@company.com');

INSERT INTO employees
(employee_id, employee_name, gender, dept_id, manager_id, salary, bonus, hire_date, city, email)
VALUES
(7,  'Kiran Kumar',    'Male',   102, 2, 72000.00, 5000.00,  '2022-01-10', 'Hyderabad', 'kiran@company.com'),
(8,  'Sneha Rao',      'Female', 102, 2, 76000.00, NULL,     '2022-06-14', 'Bengaluru', 'sneha@company.com'),
(9,  'Naveen Gupta',   'Male',   103, 3, 62000.00, 3000.00,  '2023-02-20', 'Chennai',   'naveen@company.com'),
(10, 'Divya Nair',     'Female', 103, 3, 64000.00, NULL,      '2023-08-11', 'Kochi',     'divya@company.com'),
(11, 'Rohit Das',      'Male',   104, 4, 68000.00, 4500.00,   '2021-09-01', 'Mumbai',    'rohit@company.com'),
(12, 'Pooja Mehta',    'Female', 105, 5, 58000.00, NULL,      '2024-01-19', 'Delhi',     'pooja@company.com'),
(13, 'Suresh Naidu',   'Male',   106, 6, 52000.00, 2500.00,   '2022-10-07', 'Pune',      'suresh@company.com'),
(14, 'Lakshmi Menon',  'Female', 101, 1, NULL,     NULL,      '2025-03-15', 'Hyderabad', 'lakshmi@company.com'),
(15, 'Aditya Joshi',   'Male',   NULL, 2, 60000.00, 3500.00,  '2024-04-25', 'Jaipur',    'aditya@company.com'),
(16, 'Neha Kapoor',    'Female', NULL, NULL, 55000.00, NULL,   NULL,         'Delhi',     'neha@company.com');

-- Employee 15 and 16 intentionally have no department.
-- Employee 16 has no manager and no hire date.
-- Employee 14 has a NULL salary.
-- Several employees have NULL bonuses.


-- ============================================================
-- 3. PROJECTS TABLE
-- ============================================================

CREATE TABLE projects (
    project_id INT PRIMARY KEY,
    project_name VARCHAR(100) NOT NULL,
    dept_id INT,
    start_date DATE,
    end_date DATE,
    project_budget DECIMAL(12, 2),

    CONSTRAINT fk_project_department
        FOREIGN KEY (dept_id) REFERENCES departments(dept_id)
);

INSERT INTO projects
(project_id, project_name, dept_id, start_date, end_date, project_budget)
VALUES
(201, 'Employee Portal',       102, '2025-01-10', '2025-10-30', 800000.00),
(202, 'Mobile Application',    102, '2025-02-15', NULL,         1200000.00),
(203, 'Automation Testing',    103, '2025-03-01', '2025-12-15', 600000.00),
(204, 'Payroll Audit',         104, '2025-04-05', '2025-07-31', 300000.00),
(205, 'Brand Campaign',        105, '2025-05-10', NULL,          500000.00),
(206, 'Customer Help Desk',    106, '2025-01-20', '2025-09-20', 450000.00),
(207, 'AI Research Platform',  107, NULL,         NULL,         1500000.00),
(208, 'Company Website',       NULL,'2025-06-01', NULL,          350000.00);

-- Project 207 belongs to a department with no employees.
-- Project 208 has no department.
-- Project 207 intentionally has no employee assignments.


-- ============================================================
-- 4. EMPLOYEE_PROJECTS TABLE
-- Many-to-many relationship between employees and projects
-- ============================================================

CREATE TABLE employee_projects (
    assignment_id INT PRIMARY KEY,
    employee_id INT NOT NULL,
    project_id INT NOT NULL,
    assigned_role VARCHAR(60),
    hours_worked DECIMAL(8, 2),
    assigned_date DATE,

    CONSTRAINT fk_assignment_employee
        FOREIGN KEY (employee_id) REFERENCES employees(employee_id),

    CONSTRAINT fk_assignment_project
        FOREIGN KEY (project_id) REFERENCES projects(project_id),

    CONSTRAINT uq_employee_project
        UNIQUE (employee_id, project_id)
);

INSERT INTO employee_projects
(assignment_id, employee_id, project_id, assigned_role, hours_worked, assigned_date)
VALUES
(301, 2,  201, 'Project Manager',      180.00, '2025-01-10'),
(302, 7,  201, 'Backend Developer',    240.00, '2025-01-12'),
(303, 8,  201, 'Frontend Developer',   220.00, '2025-01-15'),
(304, 2,  202, 'Technical Lead',       160.00, '2025-02-15'),
(305, 7,  202, 'API Developer',        190.00, '2025-02-18'),
(306, 8,  202, NULL,                   175.00, '2025-02-20'),
(307, 3,  203, 'QA Manager',           150.00, '2025-03-01'),
(308, 9,  203, 'Automation Engineer',  210.00, '2025-03-03'),
(309, 10, 203, 'Manual Tester',        NULL,   '2025-03-05'),
(310, 4,  204, 'Audit Lead',           120.00, '2025-04-05'),
(311, 11, 204, 'Financial Analyst',    145.00, '2025-04-08'),
(312, 5,  205, 'Campaign Manager',     130.00, '2025-05-10'),
(313, 12, 205, 'Content Executive',    NULL,   '2025-05-12'),
(314, 6,  206, 'Support Manager',      170.00, '2025-01-20'),
(315, 13, 206, 'Support Executive',    230.00, '2025-01-22'),
(316, 7,  208, 'Backend Developer',     90.00, '2025-06-01'),
(317, 12, 208, 'Content Writer',        65.00, '2025-06-03'),
(318, 15, 208, NULL,                    80.00, NULL);

-- Employees 1, 14 and 16 intentionally have no project assignments.
-- Project 207 intentionally has no employee assignments.
-- Some assignments have NULL roles, hours or dates.


-- ============================================================
-- BASIC VERIFICATION
-- ============================================================

SELECT COUNT(*) AS total_departments FROM departments;
SELECT COUNT(*) AS total_employees FROM employees;
SELECT COUNT(*) AS total_projects FROM projects;
SELECT COUNT(*) AS total_assignments FROM employee_projects;


-- ============================================================
-- PRACTICE JOIN QUERIES
-- Try writing each query yourself before viewing the examples.
-- ============================================================

-- 1. INNER JOIN
-- Display employees who belong to a department.

SELECT
    e.employee_id,
    e.employee_name,
    d.dept_name,
    e.salary
FROM employees e
INNER JOIN departments d
    ON e.dept_id = d.dept_id;


-- 2. LEFT JOIN
-- Display all employees, including employees without departments.

SELECT
    e.employee_id,
    e.employee_name,
    d.dept_name
FROM employees e
LEFT JOIN departments d
    ON e.dept_id = d.dept_id
ORDER BY e.employee_id;


-- 3. Find employees without departments.

SELECT
    e.employee_id,
    e.employee_name
FROM employees e
LEFT JOIN departments d
    ON e.dept_id = d.dept_id
WHERE d.dept_id IS NULL;


-- 4. RIGHT JOIN
-- Display all departments, including departments without employees.

SELECT
    d.dept_id,
    d.dept_name,
    e.employee_name
FROM employees e
RIGHT JOIN departments d
    ON e.dept_id = d.dept_id
ORDER BY d.dept_id;


-- 5. Find departments without employees.

SELECT
    d.dept_id,
    d.dept_name
FROM departments d
LEFT JOIN employees e
    ON d.dept_id = e.dept_id
WHERE e.employee_id IS NULL;


-- 6. THREE-TABLE JOIN
-- Display employee names, project names and assigned roles.

SELECT
    e.employee_name,
    p.project_name,
    ep.assigned_role,
    ep.hours_worked
FROM employee_projects ep
INNER JOIN employees e
    ON ep.employee_id = e.employee_id
INNER JOIN projects p
    ON ep.project_id = p.project_id
ORDER BY p.project_id, e.employee_id;


-- 7. FOUR-TABLE JOIN
-- Display employees, departments, projects and assignment details.

SELECT
    e.employee_name,
    d.dept_name AS employee_department,
    p.project_name,
    ep.assigned_role,
    ep.hours_worked
FROM employee_projects ep
INNER JOIN employees e
    ON ep.employee_id = e.employee_id
LEFT JOIN departments d
    ON e.dept_id = d.dept_id
INNER JOIN projects p
    ON ep.project_id = p.project_id
ORDER BY e.employee_id;


-- 8. All employees with their projects.
-- Employees without projects must also appear.

SELECT
    e.employee_id,
    e.employee_name,
    p.project_name,
    ep.assigned_role
FROM employees e
LEFT JOIN employee_projects ep
    ON e.employee_id = ep.employee_id
LEFT JOIN projects p
    ON ep.project_id = p.project_id
ORDER BY e.employee_id;


-- 9. Employees without projects.

SELECT
    e.employee_id,
    e.employee_name
FROM employees e
LEFT JOIN employee_projects ep
    ON e.employee_id = ep.employee_id
WHERE ep.assignment_id IS NULL;


-- 10. All projects with their assigned employees.
-- Projects without employees must also appear.

SELECT
    p.project_id,
    p.project_name,
    e.employee_name,
    ep.assigned_role
FROM projects p
LEFT JOIN employee_projects ep
    ON p.project_id = ep.project_id
LEFT JOIN employees e
    ON ep.employee_id = e.employee_id
ORDER BY p.project_id;


-- 11. Projects without assigned employees.

SELECT
    p.project_id,
    p.project_name
FROM projects p
LEFT JOIN employee_projects ep
    ON p.project_id = ep.project_id
WHERE ep.assignment_id IS NULL;


-- 12. SELF JOIN
-- Display each employee with their manager.

SELECT
    e.employee_name AS employee,
    m.employee_name AS manager
FROM employees e
LEFT JOIN employees m
    ON e.manager_id = m.employee_id
ORDER BY e.employee_id;


-- 13. Count employees in every department.
-- Departments with no employees should show zero.

SELECT
    d.dept_id,
    d.dept_name,
    COUNT(e.employee_id) AS employee_count
FROM departments d
LEFT JOIN employees e
    ON d.dept_id = e.dept_id
GROUP BY d.dept_id, d.dept_name
ORDER BY d.dept_id;


-- 14. Calculate average salary for every department.

SELECT
    d.dept_name,
    ROUND(AVG(e.salary), 2) AS average_salary
FROM departments d
LEFT JOIN employees e
    ON d.dept_id = e.dept_id
GROUP BY d.dept_id, d.dept_name
ORDER BY d.dept_id;


-- 15. Count employees assigned to every project.

SELECT
    p.project_id,
    p.project_name,
    COUNT(ep.employee_id) AS assigned_employee_count
FROM projects p
LEFT JOIN employee_projects ep
    ON p.project_id = ep.project_id
GROUP BY p.project_id, p.project_name
ORDER BY p.project_id;


-- 16. CROSS JOIN
-- Generate every possible employee-project combination.
-- Use LIMIT because the complete result contains many rows.

SELECT
    e.employee_name,
    p.project_name
FROM employees e
CROSS JOIN projects p
ORDER BY e.employee_id, p.project_id
LIMIT 30;


-- 17. FULL OUTER JOIN simulation in MySQL.
-- MySQL does not directly support FULL OUTER JOIN.

SELECT
    e.employee_id,
    e.employee_name,
    d.dept_id,
    d.dept_name
FROM employees e
LEFT JOIN departments d
    ON e.dept_id = d.dept_id

UNION

SELECT
    e.employee_id,
    e.employee_name,
    d.dept_id,
    d.dept_name
FROM employees e
RIGHT JOIN departments d
    ON e.dept_id = d.dept_id;


-- 18. Find employees working on projects outside their own department
-- or on company-wide projects with no department.

SELECT
    e.employee_name,
    d1.dept_name AS employee_department,
    p.project_name,
    d2.dept_name AS project_department
FROM employee_projects ep
INNER JOIN employees e
    ON ep.employee_id = e.employee_id
LEFT JOIN departments d1
    ON e.dept_id = d1.dept_id
INNER JOIN projects p
    ON ep.project_id = p.project_id
LEFT JOIN departments d2
    ON p.dept_id = d2.dept_id
WHERE e.dept_id <> p.dept_id
   OR p.dept_id IS NULL
   OR e.dept_id IS NULL;


-- ============================================================
-- ADDITIONAL PRACTICE QUESTIONS
-- ============================================================

-- 1. Display employees whose salary is greater than their manager's salary.
-- 2. Find the department with the highest number of employees.
-- 3. Find employees assigned to more than one project.
-- 4. Find projects whose total worked hours exceed 300.
-- 5. Display every department and the total project budget for that department.
-- 6. Find employees who work on a project but have no department.
-- 7. Find employees whose department differs from the project's department.
-- 8. Display managers and the number of employees reporting to each manager.
-- 9. Find departments having neither employees nor projects.
-- 10. Display employees with NULL salary, bonus, manager or department.