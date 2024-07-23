-- 根据rank查找排名
SELECT
    t.product_name product_name,
    t.product_id product_id,
    t.order_id order_id,
    t.order_date order_date
FROM (
        SELECT p.product_id, p.product_name, o.order_id, o.order_date, rank() OVER (
                PARTITION BY
                    p.product_id
                ORDER BY o.order_date DESC
            ) date_rank
        FROM Orders o
            JOIN Products p ON o.product_id = p.product_id
    ) t
WHERE
    t.date_rank = 1
ORDER BY 1, 2, 3;

-- 求出最新日期后筛选表
select p.product_name, o.product_id, o.order_id, o.order_date
from Orders o
    left join Products p on o.product_id = p.product_id
where (o.product_id, o.order_date) in (
        select product_id, max(order_date) as "latest_order_date"
        from Orders
        group by
            product_id
    )
order by p.product_name, o.product_id, o.order_id;