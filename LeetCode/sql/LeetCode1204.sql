-- 嵌套查询
select person_name
from Queue q1
where (
        select SUM(weight)
        from Queue q2
        where
            q1.turn >= q2.turn
    ) <= 1000
order by turn desc
limit 1;
-- 连接两表
SELECT a.person_name
FROM Queue a, Queue b
WHERE
    a.turn >= b.turn
GROUP BY
    a.person_id
HAVING
    SUM(b.weight) <= 1000
ORDER BY a.turn DESC
LIMIT 1