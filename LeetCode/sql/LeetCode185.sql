select d.name Department, e.name Employee, e.salary Salary
from Employee e
    left join Department d on e.departmentId = d.id
where (
        select COUNT(DISTINCT e2.salary)
        from Employee e2
        where
            e2.departmentId = e.departmentId
            and e2.salary > e.salary
    ) < 3
order by Department, Employee;