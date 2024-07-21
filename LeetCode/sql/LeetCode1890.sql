-- 直接了当选择time_stamp最大值
select user_id, MAX(time_stamp) last_stamp
from Logins
where
    year(time_stamp) = 2020
group by
    user_id;

-- 通过row_number()排序
select user_id, time_stamp last_stamp
from (
        select user_id, time_stamp, row_number() over (
                partition by
                    user_id
                order by time_stamp desc
            ) ranking
        from Logins
        where
            year(time_stamp) = 2020
    ) t
where
    ranking = 1;