select s.user_id, ifnull(t.confirmation_rate, 0) confirmation_rate
from Signups as s
    left join (
        select c.user_id, round(
                SUM(
                    CASE
                        when action = 'confirmed' then 1
                        else 0
                    end
                ) / COUNT(*), 2
            ) confirmation_rate
        from Confirmations as c
        group by
            user_id
    ) t on s.user_id = t.user_id;