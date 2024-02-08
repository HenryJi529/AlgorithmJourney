select name
from Employee
where
    id in (
        select b.id
        from Employee a
            left join Employee b on a.managerId = b.id
        where
            a.managerId is not null
        group by
            a.managerId
        having
            COUNT(*) >= 5
    );