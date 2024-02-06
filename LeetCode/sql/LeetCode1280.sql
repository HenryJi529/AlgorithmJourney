select Students.student_id, Students.student_name, Subjects.subject_name, ifnull(t.attended_exams, 0) attended_exams
from Students
    cross join Subjects
    left join (
        select
            student_id, subject_name, count(*) attended_exams
        from Examinations
        group by
            student_id, subject_name
    ) t on Students.student_id = t.student_id
    and Subjects.subject_name = t.subject_name
order by Students.student_id, Subjects.subject_name;