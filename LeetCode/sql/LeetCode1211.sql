select
    query_name,
    ROUND(AVG(rating / position), 2) as quality,
    ROUND(
        SUM(
            CASE
                when rating < 3 then 1
                else 0
            END
        ) / COUNT(*) * 100, 2
    ) as poor_query_percentage
from Queries
where
    query_name is not null
group by
    query_name;