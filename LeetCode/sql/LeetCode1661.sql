select machine_id, ROUND(
        (
            SUM(
                CASE
                    WHEN activity_type = 'start' then - timestamp
                    else timestamp
                end
            )
        ) / (count(*) / 2), 3
    ) processing_time
from Activity
group by
    machine_id;