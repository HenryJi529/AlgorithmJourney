-- 通过子查询
select name as Customers
from Customers
where
    Customers.id not in(
        select DISTINCT
            customerid
        from Orders
    );

-- 通过连接
select name Customers
from customers
    left join orders on customers.id = orders.customerId
where
    customerId is null;