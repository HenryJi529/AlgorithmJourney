-- diff相同的log_id属于一个区间
select min(log_id) start_id, max(log_id) end_id
from (
        select log_id, log_id - row_number() over () diff
        from logs
    ) temp
group by
    diff;

-- start_id就是log_id - 1不在表中的log_id，end_id同理
with
    l1 as (
        select log_id start_id, row_number() over (
                order by log_id
            ) as rank_id
        from logs
        where
            log_id - 1 not in(
                select log_id
                from logs
            )
    ),
    l2 as (
        select log_id end_id, row_number() over (
                order by log_id
            ) as rank_id
        from logs
        where
            log_id + 1 not in(
                select log_id
                from logs
            )
    )
select start_id, end_id
from l1
    join l2 using (rank_id);