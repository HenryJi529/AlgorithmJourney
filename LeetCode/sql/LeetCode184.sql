select d.name 'Department', e.name 'Employee', e.salary 'Salary'
from Employee e
    left join Department d on d.id = e.departmentId
where
    e.salary = (
        select t.max_salary
        from (
                select departmentId, Max(salary) max_salary
                from Employee
                group by
                    departmentId
            ) t
        where
            e.departmentId = t.departmentId
    );