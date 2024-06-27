select a.player_id, a.event_date, SUM(b.games_played) games_played_so_far
from Activity a
    inner join Activity b on a.player_id = b.player_id
    and a.event_date >= b.event_date
group by
    a.player_id,
    a.event_date;