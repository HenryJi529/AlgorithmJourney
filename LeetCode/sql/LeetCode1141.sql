select activity_date day, COUNT(DISTINCT user_id) active_users
from Activity
where
    DATEDIFF(activity_date, '2019-07-27') > -30
    AND DATEDIFF(activity_date, '2019-07-27') <= 0
group by
    activity_date;