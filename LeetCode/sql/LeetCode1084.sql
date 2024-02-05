-- NOTE: 需要整个表遍历两次
select DISTINCT
    Sales.product_id,
    Product.product_name
from Sales
    left join Product on Sales.product_id = Product.product_id
where (
        Sales.product_id in (
            select product_id
            from Sales
            where
                sale_date BETWEEN '2019-01-01' AND '2019-03-31'
        )
    )
    AND (
        Sales.product_id not in(
            select product_id
            from Sales
            where
                DATEDIFF(sale_date, '2019-01-01') < 0
                or DATEDIFF(sale_date, '2019-03-31') > 0
        )
    );
-- 分组在区间内的次数是否等于总次数
select sales.product_id as product_id, product.product_name as product_name
from sales
    left join product on sales.product_id = product.product_id
group by
    product_id
having
    count(
        sale_date between '2019-01-01' and '2019-03-31'
        or null
    ) = count(*);
-- 筛选存在的日期范围
SELECT s.product_id, p.product_name
FROM Sales AS s
    LEFT JOIN Product AS p ON s.product_id = p.product_id
GROUP BY
    s.product_id
HAVING
    MIN(sale_date) >= '2019-01-01'
    AND MAX(sale_date) <= '2019-03-31'