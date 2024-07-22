select u.name, sum(t.amount) balance
from Users u
    left join Transactions as t on t.account = u.account
group by
    t.account
having
    balance > 10000;