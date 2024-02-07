-- 两次查询
select a.Score as Score, (
        select count(distinct b.Score)
        from Scores b
        where
            b.Score >= a.Score
    ) as 'Rank'
from Scores a
order by a.Score DESC;
-- 使用窗口函数
SELECT score, DENSE_RANK() OVER (
        ORDER BY score DESC
    ) AS 'rank'
FROM Scores;