-- 得出包含排名的完整数据
with ranked_data as (
    SELECT *,
    ROW_NUMBER() OVER (PARTITION BY student_id, subject ORDER BY exam_date ASC) AS oldest_rank,
    ROW_NUMBER() OVER (PARTITION BY student_id, subject ORDER BY exam_date DESC) AS newest_rank
    FROM Scores
), full_data as (
    SELECT * FROM ranked_data
    WHERE oldest_rank = 1 OR newest_rank = 1
)

-- 连接筛选
select A.student_id, A.subject, A.score as "first_score", B.score as "latest_score" 
from full_data as A
inner join full_data as B
on A.student_id = B.student_id and A.subject = B.subject and A.oldest_rank = 1 and B.newest_rank = 1 and A.exam_date != B.exam_date and A.score < B.score
order by student_id, subject