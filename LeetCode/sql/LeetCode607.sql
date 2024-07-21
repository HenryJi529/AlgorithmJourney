-- 嵌套查询
select name
from SalesPerson
where
    sales_id not in(
        select sales_id
        from Orders
        where
            com_id = (
                select com_id
                from Company
                where
                    name = 'RED'
            )
    );

-- group by(需要注意公司名不存在的情况)
select p.name
from SalesPerson p
    left join Orders o on p.sales_id = o.sales_id
group by
    p.sales_id
having
    SUM(
        (o.com_id is not null)
        and o.com_id in (
            select com_id
            from Company
            where
                name = 'RED'
        )
    ) = 0;