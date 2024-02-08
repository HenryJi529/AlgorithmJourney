select ROUND(SUM(tiv_2016), 2) as 'tiv_2016'
from Insurance
where
    pid in (
        select DISTINCT
            a.pid
        from Insurance a, Insurance b
        where
            a.pid != b.pid
            and a.tiv_2015 = b.tiv_2015
    )
    and (lat, lon) not in(
        select lat, lon
        from Insurance
        group by
            lat, lon
        having
            COUNT(*) > 1
    );