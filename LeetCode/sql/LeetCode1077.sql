select project_id, employee_id
from (
        select p.project_id, p.employee_id, rank() over (
                partition by
                    p.project_id
                order by e.experience_years desc
            ) ranking
        from Employee e
            right join Project p on p.employee_id = e.employee_id
    ) t
where
    ranking = 1;