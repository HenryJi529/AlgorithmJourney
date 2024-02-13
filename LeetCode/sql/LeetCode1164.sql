select DISTINCT
    p.product_id,
    ifnull(t.price, 10) 'price'
from Products p
    left join (
        select product_id, new_price as 'price'
        from Products
        where (product_id, change_date) in (
                select product_id, MAX(change_date) last_change_date
                from Products
                where
                    change_date <= '2019-08-16'
                group by
                    product_id
            )
    ) t on p.product_id = t.product_id;