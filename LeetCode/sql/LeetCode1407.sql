select Users.name, ifnull(SUM(distance), 0) travelled_distance
from Rides
    right join Users on Rides.user_id = Users.id
group by
    Users.id
order by travelled_distance desc, name;