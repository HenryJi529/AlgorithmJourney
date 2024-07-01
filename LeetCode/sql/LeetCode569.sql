with
    cte as (
        select e.id, e.company, e.salary, ROW_NUMBER() over (
                partition by
                    e.company
                order by e.salary
            ) "rankNum", c.counts, c.odd_even
        from Employee e
            left join (
                select company, count(*) counts, (
                        CASE
                            when count(*) % 2 = 0 then "even"
                            else "odd"
                        END
                    ) odd_even
                from Employee
                group by
                    company
            ) c on e.company = c.company
    )

select id, company, salary
from cte
    -- 这里也可以使用逻辑运算符实现相同效果
where (
        CASE
            when odd_even = "odd" then rankNum = (counts + 1) / 2
            else rankNum in (counts / 2, counts / 2 + 1)
        END
    );