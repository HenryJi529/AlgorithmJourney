-- CROSS JOIN
SELECT DISTINCT
    l1.Num AS ConsecutiveNums
FROM Logs l1, Logs l2, Logs l3
WHERE
    l1.Id = l2.Id - 1
    AND l2.Id = l3.Id - 1
    AND l1.Num = l2.Num
    AND l2.Num = l3.Num;
-- 每行查表
select DISTINCT
    a.num ConsecutiveNums
from Logs a
where
    a.num = (
        select b.num
        from Logs b
        where
            b.id + 1 = a.id
    )
    and a.num = (
        select c.num
        from Logs c
        where
            c.id + 2 = a.id
    );