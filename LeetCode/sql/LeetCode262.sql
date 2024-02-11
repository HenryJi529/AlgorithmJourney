select request_at 'Day', ROUND(
        SUM(
            CASE
                when status = 'completed' then 0
                else 1
            end
        ) / COUNT(*), 2
    ) 'Cancellation Rate'
from (
        select request_at, status
        from Trips
        where
            client_id in (
                select users_id
                from Users
                where
                    role = 'client'
                    and banned = 'No'
            )
            and driver_id in (
                select users_id
                from Users
                where
                    role = 'driver'
                    and banned = 'No'
            )
            and request_at between '2013-10-01' and '2013-10-03'
    ) t
group by
    request_at;