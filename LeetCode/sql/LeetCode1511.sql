select c.customer_id, c.name
from
    Orders o
    left join Product p on o.product_id = p.product_id
    left join Customers c on c.customer_id = o.customer_id
group by
    c.customer_id
having
    sum(
        if(
            o.order_date like '2020-06-%',
            p.price * o.quantity,
            0
        )
    ) >= 100
    and sum(
        if(
            o.order_date like '2020-07-%',
            p.price * o.quantity,
            0
        )
    ) >= 100