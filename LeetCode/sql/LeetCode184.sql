-- 先查每个dpeartment中e.salary最大值，后寻找最大值对应的e.name
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

-- 用窗口函数进行分组排序
select Department, Employee, Salary
from (
        select
            d.name Department, e.name Employee, e.salary Salary, dense_rank() over (
                partition by
                    d.id
                order by e.salary desc
            ) ranking
        from Employee e
            join Department d on e.departmentId = d.id
    ) t
where
    ranking = 1;