# Write your MySQL query statement below

-- 按照buyer_id求差集
select t1.buyer_id
from (
        select DISTINCT
            s.buyer_id
        from Sales s
            left join Product p on s.product_id = p.product_id
        where
            p.product_name = "S8"
    ) t1
    left join (
        select DISTINCT
            s.buyer_id
        from Sales s
            left join Product p on s.product_id = p.product_id
        where
            p.product_name = "iPhone"
    ) t2 on t1.buyer_id = t2.buyer_id
where
    t2.buyer_id is null;

--直接按buyer_id分组后按照次数筛选
SELECT s.buyer_id
FROM Sales AS s
    INNER JOIN Product AS p ON s.product_id = p.product_id
GROUP BY
    s.buyer_id
HAVING
    SUM(
        CASE
            WHEN p.product_name = 'S8' THEN 1
            ELSE 0
        END
    ) > 0
    AND SUM(
        CASE
            WHEN p.product_name = 'iPhone' THEN 1
            ELSE 0
        END
    ) = 0;