select c.name 'country'
from (
        select caller_id 'person_id', duration
        from Calls
        union all
        select callee_id 'person_id', duration
        from Calls
    ) t
    join Person p on p.id = t.person_id
    join Country c on left(p.phone_number, 3) = c.country_code
group by
    c.name
having
    AVG(t.duration) > (
        select AVG(duration)
        from Calls
    )