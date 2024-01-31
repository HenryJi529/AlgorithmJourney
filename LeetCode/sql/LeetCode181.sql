select a.Name as Employee
from Employee as a, Employee as b
where
    a.ManagerId = b.id
    AND a.Salary > b.Salary

SELECT a.NAME AS Employee
FROM Employee AS a
    JOIN Employee AS b ON a.ManagerId = b.Id AND a.Salary > b.Salary;