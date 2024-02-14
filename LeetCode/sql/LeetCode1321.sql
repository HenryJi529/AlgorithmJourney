with
    T as (
        select visited_on, sum(amount) amountSum
        from Customer
        group by
            visited_on
        order by visited_on
    )

select t1.visited_on, (
        t1.amountSum + t2.amountSum + t3.amountSum + t4.amountSum + t5.amountSum + t6.amountSum + t7.amountSum
    ) amount, round(
        (
            t1.amountSum + t2.amountSum + t3.amountSum + t4.amountSum + t5.amountSum + t6.amountSum + t7.amountSum
        ) / 7, 2
    ) average_amount
from
    T as t1
    inner join T as t2 on t2.visited_on = DATE_SUB(t1.visited_on, interval 1 day)
    inner join T as t3 on t3.visited_on = DATE_SUB(t1.visited_on, interval 2 day)
    inner join T as t4 on t4.visited_on = DATE_SUB(t1.visited_on, interval 3 day)
    inner join T as t5 on t5.visited_on = DATE_SUB(t1.visited_on, interval 4 day)
    inner join T as t6 on t6.visited_on = DATE_SUB(t1.visited_on, interval 5 day)
    inner join T as t7 on t7.visited_on = DATE_SUB(t1.visited_on, interval 6 day);