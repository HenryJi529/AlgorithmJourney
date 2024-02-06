select employee_id, (
        CASE
            WHEN name not like 'M%'
            and mod(employee_id, 2) = 1 then salary
            else 0
        end
    ) bonus
from Employees
order by employee_id;