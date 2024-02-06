select sell_date, COUNT(DISTINCT product) num_sold, GROUP_CONCAT(
        DISTINCT product
        order by product SEPARATOR ','
    ) products
from Activities
group by
    sell_date;