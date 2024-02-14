(
    select u.name results
    from MovieRating as mr
        left join Users as u on mr.user_id = u.user_id
    group by
        mr.user_id
    order by COUNT(*) desc, u.name
    limit 1
)
union all
(
    select m.title results
    from MovieRating as mr
        left join Movies as m on m.movie_id = mr.movie_id
    where
        year(created_at) = 2020
        and month(created_at) = 2
    group by
        mr.movie_id
    order by AVG(rating) desc, m.title
    limit 1
);