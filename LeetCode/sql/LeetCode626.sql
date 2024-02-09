select ROW_NUMBER() over (
        order by newId
    ) as "id", student
from (
        select (
                CASE
                    WHEN id % 2 = 1 then id + 1
                    WHEN id % 2 = 0 then id -1
                end
            ) newId, student
        from Seat
        order by newId
    ) t;