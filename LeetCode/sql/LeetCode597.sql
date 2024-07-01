with
    count1 as (
        select count(
                distinct sender_id, send_to_id
            ) num
        from FriendRequest
    ),
    count2 as (
        select count(
                distinct requester_id, accepter_id
            ) num
        from RequestAccepted
    )

select round(
        ifnull(
            (
                select num
                from count2
            ) / (
                select num
                from count1
            ), 0
        ), 2
    ) as accept_rate;