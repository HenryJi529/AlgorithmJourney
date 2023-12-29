select name as Customers
from Customers
where Customers.id not in (
        select
            DISTINCT customerid
        from Orders
    );