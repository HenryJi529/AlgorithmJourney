-- 先分别求连续成功和连续失败的起止日期，再拼接起来
select
    period_state,
    start_date,
    end_date
from (
        select 'failed' as `period_state`, min(fail_date) "start_date", max(fail_date) "end_date"
        from (
                select fail_date, DATE_SUB(
                        fail_date, interval rank() over (
                            order by fail_date
                        ) day
                    ) diff
                from Failed
                where
                    fail_date between '2019-01-01' and '2019-12-31'
            ) t1
        group by
            diff
        union
        select 'succeeded' as `period_state`, min(success_date) "start_date", max(success_date) "end_date"
        from (
                select success_date, DATE_SUB(
                        success_date, interval rank() over (
                            order by success_date
                        ) day
                    ) diff
                from Succeeded
                where
                    success_date between '2019-01-01' and '2019-12-31'
            ) t2
        group by
            diff
    ) t
order by start_date;

-- 先合并再求连续区间
select
    type as period_state,
    min(date) as start_date,
    max(date) as end_date
from (
        select type, date, subdate(
                date, row_number() over (
                    partition by
                        type
                    order by date
                )
            ) as diff
        from (
                select 'failed' as type, fail_date as date
                from Failed
                union all
                select 'succeeded' as type, success_date as date
                from Succeeded
            ) a
    ) a
where
    date between '2019-01-01' and '2019-12-31'
group by
    type,
    diff
order by start_date;