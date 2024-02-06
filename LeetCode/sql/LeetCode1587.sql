select Users.name, SUM(Transactions.amount) balance
from Transactions
    left join Users on Transactions.account = Users.account
group by
    Transactions.account
having
    balance > 10000;