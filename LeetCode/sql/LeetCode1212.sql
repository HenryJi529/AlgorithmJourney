-- union all连接主客场表，后统一计算作为主场的得分
select t.team_id, t.team_name, SUM(
        case
            when m.match_id is null then 0
            when m.host_goals > m.guest_goals then 3
            when m.host_goals < m.guest_goals then 0
            when m.host_goals = m.guest_goals then 1
        end
    ) num_points
from Teams t
    left join (
        select
            match_id, host_team, guest_team, host_goals, guest_goals
        from Matches
        union all
        select
            match_id, guest_team 'host_team', host_team 'guest_team', guest_goals 'host_goals', host_goals 'guest_goals'
        from Matches
    ) m on t.team_id = m.host_team
group by
    t.team_id
order by num_points desc, t.team_id;