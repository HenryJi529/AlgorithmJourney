-- 也可以使用AVG
select ROUND(
        SUM(
            order_date = customer_pref_delivery_date
        ) / COUNT(*) * 100, 2
    ) immediate_percentage
from Delivery