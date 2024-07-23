-- 自连接
select a.player_id, a.event_date, SUM(b.games_played) games_played_so_far
from Activity a
    inner join Activity b on a.player_id = b.player_id
    and a.event_date >= b.event_date
group by
    a.player_id,
    a.event_date;

-- select中做查询
select a1.player_id, a1.event_date, (
        select SUM(a2.games_played)
        from Activity a2
        where
            a1.player_id = a2.player_id
            and a1.event_date >= a2.event_date
    ) games_played_so_far
from Activity a1
group by
    a1.player_id,
    a1.event_date;