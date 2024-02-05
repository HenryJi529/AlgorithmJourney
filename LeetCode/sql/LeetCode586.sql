-- # NOTE: 速度奇慢无比
-- with
--     temp as (
--         select customer_number, COUNT(*) order_amount
--         from Orders
--         group by
--             customer_number
--     )
-- select customer_number
-- from temp
-- where
--     order_amount = (
--         select MAX(order_amount)
--         from temp
--     );

select customer_number
from Orders
group by
    customer_number
order by COUNT(*) desc
limit 1;