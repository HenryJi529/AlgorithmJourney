select
    product_id,
    year as first_year,
    quantity,
    price
from Sales
where (Sales.product_id, Sales.year) in (
        select product_id, MIN(year) as 'first_year'
        from Sales
        group by
            product_id
    );