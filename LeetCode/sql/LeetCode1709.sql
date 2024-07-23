-- 先分组排序，再自连接获取成对的日期，再分组求最大值
with
    cte as (
        select user_id, visit_date, ROW_NUMBER() over (
                partition by
                    user_id
                order by visit_date
            ) ranking
        from UserVisits
    )
select t1.user_id, max(
        DATEDIFF(
            ifnull(t2.visit_date, '2021-1-1'), t1.visit_date
        )
    ) as "biggest_window"
from cte t1
    left join cte t2 on t1.user_id = t2.user_id
    and t1.ranking + 1 = t2.ranking
group by
    t1.user_id
order by user_id;

-- 通过LEAD直接找到成对的日期，分组求最大值
SELECT user_id, MAX(
        DATEDIFF(next_day, visit_date)
    ) AS biggest_window
FROM (
        SELECT
            user_id, visit_date, LEAD(visit_date, 1, '2021-1-1') OVER (
                PARTITION BY
                    user_id
                ORDER BY visit_date
            ) AS next_day
        FROM UserVisits
    ) tmp
GROUP BY
    user_id
ORDER BY user_id;