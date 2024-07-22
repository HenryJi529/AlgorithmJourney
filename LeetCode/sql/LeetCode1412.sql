-- 找到在exam中，且正序逆序dense_rank都不等于1的student_id
select student_id, student_name
from Student
where
    student_id is not null
    and student_id not in(
        select student_id
        from (
                select student_id, (
                        dense_rank() over (
                            partition by
                                exam_id
                            order by score
                        )
                    ) as "nature_rank", (
                        dense_rank() over (
                            partition by
                                exam_id
                            order by score desc
                        )
                    ) as "reverse_rank"
                from Exam
            ) t
        where
            t.nature_rank = 1
            or reverse_rank = 1
    )
    and student_id in (
        select student_id
        from Exam
    );

-- 利用sum进一步化简判断过程(删除了不需要的其他排名信息，转化为01问题)
select t1.student_id, s.student_name
from (
        select *, (
                dense_rank() over (
                    partition by
                        exam_id
                    order by score desc
                ) = 1
            ) d_rank, (
                dense_rank() over (
                    partition by
                        exam_id
                    order by score
                ) = 1
            ) a_rank
        from Exam
    ) t1
    left join Student s on t1.student_id = s.student_id
group by
    t1.student_id
having
    sum(d_rank) = 0
    and sum(a_rank) = 0
order by student_id