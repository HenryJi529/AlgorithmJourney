select
    customer_name,
    customer_id,
    order_id,
    order_date
from (
        select c.name as "customer_name", o.customer_id, o.order_id, o.order_date, ROW_NUMBER() over (
                partition by
                    o.customer_id
                order by order_date desc
            ) ranking
        from Orders o
            left join Customers c on o.customer_id = c.customer_id
    ) t
where
    ranking <= 3
order by
    customer_name,
    customer_id,
    order_date desc