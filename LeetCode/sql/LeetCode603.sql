-- 连接
select distinct
    a.seat_id
from Cinema a
    join Cinema b on a.free = 1
    and b.free = 1
    and abs(a.seat_id - b.seat_id) = 1
order by a.seat_id;

-- 窗口函数
select seat_id
from (
        select seat_id, lead(free, 1, 0) over (
                order by seat_id
            ) 'pre_free', free 'curr_free', lag(free, 1, 0) over (
                order by seat_id
            ) 'next_free'
        from Cinema
    ) t
where
    curr_free
    and (
        pre_free
        or next_free
    );