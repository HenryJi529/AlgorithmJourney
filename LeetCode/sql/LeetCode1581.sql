select Visits.customer_id, (
        COUNT(*) - COUNT(Transactions.transaction_id)
    ) count_no_trans
from Visits
    left join Transactions on Visits.visit_id = Transactions.visit_id
group by
    Visits.customer_id
having
    count_no_trans > 0;