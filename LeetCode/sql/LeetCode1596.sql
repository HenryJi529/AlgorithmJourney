-- 先统计次数，后对比次数找出次数最大的
with
    cte as (
        select o.customer_id, o.product_id, p.product_name, COUNT(*) counts
        from Orders o
            left join Products p on o.product_id = p.product_id
        group by
            o.customer_id,
            o.product_id
    )

select t1.customer_id, t1.product_id, t1.product_name
from cte t1
    join cte t2 on t1.customer_id = t2.customer_id
group by
    t1.customer_id,
    t1.product_id
having
    sum(t1.counts < t2.counts) = 0;

-- 使用窗口函数对count直接排名

with
    t as (
        select customer_id, product_id, rank() over (
                partition by
                    customer_id
                order by count(product_id) desc
            ) as rk
        from Orders
        group by
            customer_id,
            product_id
    )

select t.customer_id, t.product_id, p.product_name
from t
    left join Products p on t.product_id = p.product_id
where
    rk = 1;