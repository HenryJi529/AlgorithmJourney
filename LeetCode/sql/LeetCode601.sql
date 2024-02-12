with
    t as (
        select a.id
        from Stadium a, Stadium b, Stadium c
        where
            a.id = b.id -1
            and b.id = c.id -1
            and a.people >= 100
            and b.people >= 100
            and c.people >= 100
    )

select *
from Stadium
where
    id in (
        select id
        from t
        union
        select id + 1
        from t
        union
        select id + 2
        from t
    );