select s.seller_id
from Sales s
    left join Product p on s.product_id = p.product_id
group by
    s.seller_id
having
    sum(s.quantity * p.unit_price) >= all (
        select sum(s.quantity * p.unit_price) total
        from Sales s
            left join Product p on s.product_id = p.product_id
        group by
            s.seller_id
    );