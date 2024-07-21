select s.seller_name
from Seller s
    left join Orders o on s.seller_id = o.seller_id
group by
    s.seller_id
having
    sum(
        o.sale_date is not null
        and year(o.sale_date) = '2020'
    ) = 0
order by s.seller_name;