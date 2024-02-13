select
    DATE_FORMAT(trans_date, '%Y-%m') month,
    country,
    COUNT(*) trans_count,
    SUM(
        CASE
            when state = 'approved' then 1
            else 0
        end
    ) approved_count,
    SUM(amount) trans_total_amount,
    SUM(
        CASE
            when state = 'approved' then amount
            else 0
        end
    ) approved_total_amount
from Transactions
group by
    month,
    country;