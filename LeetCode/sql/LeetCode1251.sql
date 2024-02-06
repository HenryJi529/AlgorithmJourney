select Prices.product_id, IFNULL(
        ROUND(
            SUM(
                UnitsSold.units * Prices.price
            ) / SUM(UnitsSold.units), 2
        ), 0
    ) average_price
from UnitsSold
    right join Prices on (
        UnitsSold.product_id = Prices.product_id
    )
    and (
        purchase_date between Prices.start_date and Prices.end_date
    )
group by
    product_id;