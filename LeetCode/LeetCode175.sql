-- https://leetcode.cn/problems/combine-two-tables/description/

select
    P.FirstName as firstName,
    P.LastName as lastName,
    A.City as city,
    A.State as state
from Person as P
    left join Address as A on P.PersonId = A.PersonId;