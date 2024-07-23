-- UNION ALL各个赛事的player_id
select t.player_id, p.player_name, COUNT(*) as "grand_slams_count"
from (
        select Wimbledon as "player_id"
        from Championships
        union all
        select Fr_open as "player_id"
        from Championships
        union all
        select US_open as "player_id"
        from Championships
        union all
        select Au_open as "player_id"
        from Championships
    ) t
    left join Players p on t.player_id = p.player_id
group by
    t.player_id;

-- 分组后在Select中直接统计
SELECT p.player_id, p.player_name, SUM(p.player_id = c.Wimbledon) + SUM(p.player_id = c.Fr_open) + SUM(p.player_id = c.US_open) + SUM(p.player_id = c.Au_open) grand_slams_count
FROM Championships c, Players p
GROUP BY
    p.player_id
HAVING
    grand_slams_count > 0;