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