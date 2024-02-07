select user_id, COUNT(DISTINCT follower_id) followers_count
from Followers
group by
    user_id;