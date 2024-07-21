select w.name 'warehouse_name', sum(
        w.units * p.Width * p.Length * p.Height
    ) 'volume'
from Warehouse w
    join Products p on w.product_id = p.product_id
group by
    w.name