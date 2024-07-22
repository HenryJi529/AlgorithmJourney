-- 先分别求缺失数据的id再拼接
select employee_id
from (
        select e.employee_id
        from Employees as e
            left join Salaries as s on e.employee_id = s.employee_id
        where
            salary is null
        union
        select s.employee_id
        from Employees as e
            right join Salaries as s on e.employee_id = s.employee_id
        where
            name is null
    ) t
order by employee_id;

-- 先拼接再求缺失数据的id
select DISTINCT
    employee_id
from (
        select e.employee_id, e.name, s.salary
        from Employees e
            left join Salaries s on e.employee_id = s.employee_id
        union all
        select s.employee_id, e.name, s.salary
        from Employees e
            right join Salaries s on e.employee_id = s.employee_id
    ) t
where
    t.name is null
    or t.salary is null
order by employee_id;