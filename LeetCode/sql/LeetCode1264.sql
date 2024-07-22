-- 用UNION拼接好友列表
select DISTINCT
    page_id as "recommended_page"
from Likes
where
    user_id in (
        select user1_id as "friend"
        from Friendship
        where
            user2_id = 1
        union
        select user2_id as "friend"
        from Friendship
        where
            user1_id = 1
    )
    and page_id not in(
        select page_id
        from Likes
        where
            user_id = 1
    );

-- 在select中选择好友列名
select DISTINCT
    page_id as "recommended_page"
from Likes
where
    user_id in (
        SELECT (
                CASE
                    WHEN user1_id = 1 then user2_id
                    WHEN user2_id = 1 then user1_id
                END
            ) AS user_id
        FROM Friendship
        WHERE
            user1_id = 1
            OR user2_id = 1
    )
    and page_id not in(
        select page_id
        from Likes
        where
            user_id = 1
    );