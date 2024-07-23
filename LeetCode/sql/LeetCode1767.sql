-- 先用RCTE生成数字序列，从而获取所有的任务对，再进一步找出未执行的任务对
WITH RECURSIVE
    NumberSequence (num) AS (
        SELECT 1
        UNION ALL
        SELECT num + 1
        FROM NumberSequence
        WHERE
            num < (
                SELECT MAX(subtasks_count)
                FROM Tasks
            )
    )
SELECT t.task_id, ns.num AS subtask_id
FROM
    Tasks t
    JOIN NumberSequence ns ON ns.num <= t.subtasks_count
    LEFT JOIN Executed e ON t.task_id = e.task_id
    AND ns.num = e.subtask_id
WHERE
    e.task_id IS NULL