select 'Low Salary' as category, SUM(
        CASE
            when income < 20000 then 1
            else 0
        end
    ) accounts_count
from Accounts
union
select 'Average Salary' as category, SUM(
        CASE
            when income >= 20000
            and income <= 50000 then 1
            else 0
        end
    ) accounts_count
from Accounts
union
select 'High Salary' as category, SUM(
        CASE
            when income > 50000 then 1
            else 0
        end
    ) accounts_count
from Accounts;