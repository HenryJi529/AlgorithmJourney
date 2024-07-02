with
    t1 as (
        select sum(frequency) sums, (
                CASE
                    when sum(frequency) % 2 = 0 then "even"
                    else "odd"
                end
            ) odd_even
        from Numbers
    ),
    t2 as (
        select num, frequency, sum(frequency) over (
                order by num
            ) after_cum
        from Numbers
    ),
    t3 as (
        select num, after_cum, (
                LAG(after_cum, 1, 0) over (
                    order by num
                )
            ) before_cum
        from t2
    )

select avg(num) median
from t3
where (
        (
            select odd_even
            from t1
        ) = "odd"
        and (
            before_cum < (
                (
                    select sums
                    from t1
                ) + 1
            ) / 2
            and after_cum >= (
                (
                    select sums
                    from t1
                ) + 1
            ) / 2
        )
    )
    or (
        (
            select odd_even
            from t1
        ) = "even"
        and (
            (
                before_cum < (
                    select sums
                    from t1
                ) / 2
                and after_cum >= (
                    select sums
                    from t1
                ) / 2
            )
            or (
                before_cum < (
                    select sums
                    from t1
                ) / 2 + 1
                and after_cum >= (
                    select sums
                    from t1
                ) / 2 + 1
            )
        )
    );