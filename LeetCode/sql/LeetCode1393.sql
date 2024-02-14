select stock_name, SUM(
        CASE
            when operation = 'Buy' then - price
            else price
        end
    ) capital_gain_loss
from Stocks
group by
    stock_name;