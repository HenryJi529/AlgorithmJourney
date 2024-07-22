-- 连接结果
select e.employee_id, t.team_size
from Employee e
    left join (
        select team_id, count(*) as "team_size"
        from Employee
        group by
            team_id
    ) t on e.team_id = t.team_id;

-- 窗口函数
SELECT employee_id, COUNT(employee_id) OVER (
        PARTITION BY
            team_id
    ) AS team_size
FROM Employee
ORDER BY employee_id;

-- 自连接
SELECT e1.employee_id, COUNT(*) AS team_size
FROM Employee e1
    JOIN Employee e2 USING (team_id)
GROUP BY
    e1.employee_id
ORDER BY e1.employee_id;