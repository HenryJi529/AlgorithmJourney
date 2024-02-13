select u.user_id buyer_id, u.join_date, ifnull(cnt, 0) orders_in_2019
from Users as u
    left join (
        select buyer_id, COUNT(*) cnt
        from Orders
        where
            year(order_date) = '2019'
        group by
            buyer_id
    ) t on u.user_id = t.buyer_id;