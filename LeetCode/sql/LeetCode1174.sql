select Round(
        SUM(
            CASE
                when order_date = customer_pref_delivery_date then 1
                else 0
            end
        ) / COUNT(*) * 100, 2
    ) immediate_percentage
from Delivery
where (customer_id, order_date) in (
        select customer_id, MIN(order_date)
        from Delivery
        group by
            customer_id
    );