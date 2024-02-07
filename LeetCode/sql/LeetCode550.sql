select IFNULL(
        ROUND(
            COUNT(DISTINCT (r.player_id)) / COUNT(DISTINCT (Activity.player_id)), 2
        ), 0
    ) fraction
from (
        select DISTINCT (player_id)
        from Activity a
        where
            a.event_date = (
                select t.expect_date
                from (
                        select player_id, DATE_ADD(
                                MIN(event_date), INTERVAL 1 DAY
                            ) expect_date
                        from Activity
                        group by
                            player_id
                    ) t
                where
                    a.player_id = t.player_id
            )
    ) r, Activity;