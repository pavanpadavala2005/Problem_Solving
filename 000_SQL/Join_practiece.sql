	-- SELECT [DISTINCT] column1, column2, column3, ...
	-- FROM table1
	--     [INNER JOIN table2
	--         ON table1.column = table2.column]

	--     [LEFT JOIN table3
	--         ON table1.column = table3.column]

	--     [RIGHT JOIN table4
	--         ON table1.column = table4.column]

	--     [FULL OUTER JOIN table5
	--         ON table1.column = table5.column]

	--     [CROSS JOIN table6]

	-- WHERE condition

	-- GROUP BY column1, column2, ...

	-- HAVING aggregate_condition

	-- ORDER BY column1 [ASC|DESC], column2 [ASC|DESC]

	-- LIMIT number

	-- OFFSET number;

select * from employee_projects;
select * from departments;
select * from projects;
select * from employees;

select d.dept_name,count(*)
	from employees e
    join departments d
    where e.dept_id = d.dept_id
    group by d.dept_id
    having count(*) >= 3;

select e.employee_id,count(*)
	from employees e
    join employee_projects ep
    where ep.employee_id = e.employee_id
    group by employee_id;

