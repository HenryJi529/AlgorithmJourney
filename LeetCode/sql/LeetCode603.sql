select distinct
    a.seat_id
from Cinema a
    cross join Cinema b on a.free = 1
    and b.free = 1
    and (
        a.seat_id = b.seat_id + 1
        or a.seat_id = b.seat_id - 1
    )
order by a.seat_id;