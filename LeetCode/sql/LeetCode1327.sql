select Products.product_name, SUM(Orders.unit) unit
from Orders
    left join Products on Orders.product_id = Products.product_id
where
    year(order_date) = '2020'
    and month(order_date) = '02'
group by
    Orders.product_id
having
    unit >= 100;