-- 通过窗口函数
WITH
    cte AS (
        SELECT player_id, device_id, MIN(event_date)
        FROM Activity
        GROUP BY
            player_id
    )

SELECT player_id, device_id FROM cte;

-- 通过分组聚合

select a.player_id, a.device_id
from Activity a
    inner join Activity b on a.player_id = b.player_id
    and a.event_date >= b.event_date
group by
    a.player_id,
    a.event_date
having
    count(*) = 1;