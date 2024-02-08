with
    record as (
        select id1 as 'id', COUNT(*) as 'num'
        from (
                select
                    requester_id as id1, accepter_id as id2
                from RequestAccepted
                union all
                select
                    accepter_id as id1, requester_id as id2
                from RequestAccepted
            ) t
        group by
            id1
    )
-- select * from record where num = (select MAX(num) from record);
select * from record order by num desc limit 1;