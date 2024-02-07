select
    A.reports_to employee_id,
    B.name name,
    COUNT(*) reports_count,
    ROUND(AVG(A.age), 0) average_age
from Employees A
    left join Employees B on A.reports_to = B.employee_id
group by
    A.reports_to
having
    A.reports_to is not null
order by employee_id;