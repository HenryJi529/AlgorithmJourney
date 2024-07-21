select e1.id, e1.month, sum(e2.salary) 'Salary'
from Employee e1
    join Employee e2 on e1.id = e2.id
    and (e1.id, e1.month) not in(
        select id, max(month)
        from Employee
        group by
            id
    )
    and (
        e1.month = e2.month
        or e1.month = e2.month + 1
        or e1.month = e2.month + 2
    )
group by
    e1.id,
    e1.month
order by e1.id, e1.month desc;