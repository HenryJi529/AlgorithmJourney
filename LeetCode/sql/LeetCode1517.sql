select *
from Users
where
    mail REGEXP "^[a-zA-Z][\\w_\\.-]*@leetcode\\.com$"