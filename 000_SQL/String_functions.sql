use pavan;
CREATE TABLE employees (
    emp_id INT,
    first_name VARCHAR(30),
    last_name VARCHAR(30),
    email VARCHAR(50),
    department VARCHAR(30),
    city VARCHAR(30),
    salary DECIMAL(10,2)
);

INSERT INTO employees VALUES
(101,'John','Smith','john@gmail.com','IT','Hyderabad',50000),
(102,'Alice','Brown','alice@yahoo.com','HR','Chennai',45000),
(103,'David','Wilson','david@gmail.com','Sales','Bangalore',55000),
(104,'Emily','Johnson','emily@hotmail.com','IT','Mumbai',60000),
(105,'Michael','Lee','michael@gmail.com','Finance','Delhi',70000);

select * from employees;

select length("Hello");

select first_name, length(first_name) from employees;


SELECT CHAR_LENGTH('Hello');

select upper("hello");

select lower("HELLO");

select concat("hello"," ","world") as text;

select concat_ws("-","hello","world","hi");

select substring("hello world",start, length);

select reverse("pavan");












