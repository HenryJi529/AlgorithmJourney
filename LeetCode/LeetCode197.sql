-- 未考虑时间未必是递增的
# select t.id from (
# select
#     id, Temperature as cur, LAG(Temperature) OVER (ORDER BY id) AS pre
# from Weather
# ) as t where t.id > 1 AND t.cur > t.pre;

-- 未考虑到不是每天都有记录的
select t.id
from (
        select
            id,
            recordDate as curDate,
            Temperature as curValue,
            LAG(recordDate) OVER (
                ORDER BY
                    recordDate
            ) AS preDate,
            LAG(Temperature) OVER (
                ORDER BY
                    recordDate
            ) AS preValue
        from Weather
    ) as t
where
    t.preDate is not null
    AND t.curValue > t.preValue
    AND datediff(t.curDate, t.preDate) = 1;