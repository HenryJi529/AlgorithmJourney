-- 使用聚合
select sale_date, sum(
        case
            when fruit = "oranges" then - sold_num
            else sold_num
        end
    ) as diff
from Sales
group by
    sale_date
order by sale_date;

-- 使用连接(难以解决某日apples或oranges未售卖问题)
select s1.sale_date, (s1.sold_num - s2.sold_num) diff
from Sales s1
    join Sales s2 on s1.sale_date = s2.sale_date
    and s1.fruit = 'apples'
    and s2.fruit = 'oranges'
order by s1.sale_date;