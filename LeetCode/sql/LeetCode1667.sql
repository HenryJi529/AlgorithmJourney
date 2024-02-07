select user_id, CONCAT(
        UPPER(
            SUBSTRING(
                name
                FROM 1 FOR 1
            )
        ), LOWER(
            SUBSTRING(
                name
                FROM 2
            )
        )
    ) as name
from Users
order by user_id;