select ad_id, ROUND(
        (
            CASE
                when clicked = 0
                and viewed = 0 then 0
                else 100 * clicked / (clicked + viewed)
            end
        ), 2
    ) ctr
from (
        select ad_id, sum(
                CASE
                    when action = "Clicked" then 1
                    else 0
                end
            ) clicked, sum(
                CASE
                    when action = "Viewed" then 1
                    else 0
                end
            ) viewed
        from Ads
        group by
            ad_id
    ) t
order by ctr desc, ad_id;