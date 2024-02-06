select teacher_id, count(DISTINCT subject_id) cnt
from Teacher
group by
    teacher_id;