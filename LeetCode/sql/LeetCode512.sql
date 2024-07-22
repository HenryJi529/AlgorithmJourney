-- 分组聚合 + 嵌套查询
SELECT player_id, device_id
FROM Activity
where (player_id, event_date) in (
        SELECT player_id, MIN(event_date)
        FROM Activity
        GROUP BY
            player_id
    );

-- 连接 + 分组聚合
select a.player_id, a.device_id
from Activity a
    inner join Activity b on a.player_id = b.player_id
    and a.event_date >= b.event_date
group by
    a.player_id,
    a.event_date
having
    count(*) = 1;

-- 窗口函数 + 嵌套查询
select player_id, device_id
from (
        select player_id, device_id, row_number() over (
                partition by
                    player_id
                order by event_date
            ) ranking
        from Activity
    ) t
where
    ranking = 1