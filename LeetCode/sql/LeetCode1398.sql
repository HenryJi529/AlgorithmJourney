-- 使用IN与NOT IN判断
select customer_id, customer_name
from Customers
where
    customer_id not in(
        select customer_id
        from Orders
        where
            product_name = 'C'
    )
    and customer_id in (
        select o1.customer_id
        from Orders o1
            inner join Orders o2 on o1.customer_id = o2.customer_id
            and o1.product_name = 'A'
            and o2.product_name = 'B'
    );

-- 简化判断条件
SELECT customer_id, customer_name
FROM Customers
WHERE
    customer_id NOT IN(
        SELECT customer_id
        FROM Orders
        WHERE
            product_name = 'C'
    )
    AND Customer_id IN (
        SELECT customer_id
        FROM Orders
        WHERE
            product_name = 'A'
    )
    AND Customer_id IN (
        SELECT customer_id
        FROM Orders
        WHERE
            product_name = 'B'
    )
ORDER BY customer_id
-- 通过GROUP BY统计次数
SELECT c.customer_id, c.customer_name
FROM Orders o
    LEFT JOIN Customers c ON o.customer_id = c.customer_id
GROUP BY
    c.customer_id
HAVING
    SUM(product_name = 'A') * SUM(product_name = 'B') > 0
    AND SUM(product_name = 'C') = 0
ORDER BY c.customer_id