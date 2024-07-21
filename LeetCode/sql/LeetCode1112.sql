-- 利用窗口函数
select t.student_id, course_id, grade
from (
        select
            student_id, course_id, grade, row_number() over (
                partition by
                    student_id
                order by grade desc, course_id
            ) rn
        from Enrollments
    ) t
where
    rn = 1;