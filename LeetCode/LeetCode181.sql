-- https://leetcode.cn/problems/employees-earning-more-than-their-managers/description/

select a.Name as Employee
from Employee as a, Employee as b
where
    a.ManagerId = b.id
    AND a.Salary > b.Salary