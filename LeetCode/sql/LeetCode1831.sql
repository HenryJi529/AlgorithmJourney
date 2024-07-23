select transaction_id
from (
        select
            transaction_id, `day`, amount, rank() over (
                partition by
                    DATE_FORMAT(`day`, "%y-%m-%d")
                order by amount desc
            ) ranking
        from Transactions
    ) t
where
    ranking = 1
order by transaction_id;