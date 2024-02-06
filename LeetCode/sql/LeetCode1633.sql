select contest_id, Round(
        COUNT(*) / (
            select COUNT(*)
            from Users
        ) * 100, 2
    ) percentage
from Register
group by
    contest_id
order by percentage desc, contest_id;