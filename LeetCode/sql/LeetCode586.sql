select customer_number
from Orders
group by
    customer_number
order by COUNT(*) desc
limit 1;