select event_day day, emp_id, (SUM(out_time) - SUM(in_time)) total_time
from Employees
group by
    event_day,
    emp_id;