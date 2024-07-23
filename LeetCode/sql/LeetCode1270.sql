-- 自连接筛选每一层符合要求的
select e1.employee_id
from
    Employees e1
    join Employees e2 on e1.manager_id = e2.employee_id
    join Employees e3 on e2.manager_id = e3.employee_id
where
    e1.employee_id != 1
    and (
        e1.manager_id = 1
        or e2.manager_id = 1
        or e3.manager_id = 1
    );

-- 利用CEO的经理是自己本人，简化筛选
select e1.employee_id
from
    Employees e1
    join Employees e2 on e1.manager_id = e2.employee_id
    join Employees e3 on e2.manager_id = e3.employee_id
where
    e1.employee_id != 1
    and e3.manager_id = 1