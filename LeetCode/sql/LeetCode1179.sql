select
    id,
    SUM(
        CASE
            WHEN MONTH = 'JAN' THEN revenue
        END
    ) AS JAN_REVENUE,
    SUM(
        CASE
            WHEN MONTH = 'FEB' THEN revenue
        END
    ) AS FEB_REVENUE,
    SUM(
        CASE
            WHEN MONTH = 'MAR' THEN revenue
        END
    ) AS MAR_REVENUE,
    SUM(
        CASE
            WHEN MONTH = 'APR' THEN revenue
        END
    ) AS APR_REVENUE,
    SUM(
        CASE
            WHEN MONTH = 'MAY' THEN revenue
        END
    ) AS MAY_REVENUE,
    SUM(
        CASE
            WHEN MONTH = 'JUN' THEN revenue
        END
    ) AS JUN_REVENUE,
    SUM(
        CASE
            WHEN MONTH = 'JUL' THEN revenue
        END
    ) AS JUL_REVENUE,
    SUM(
        CASE
            WHEN MONTH = 'AUG' THEN revenue
        END
    ) AS AUG_REVENUE,
    SUM(
        CASE
            WHEN MONTH = 'SEP' THEN revenue
        END
    ) AS SEP_REVENUE,
    SUM(
        CASE
            WHEN MONTH = 'OCT' THEN revenue
        END
    ) AS OCT_REVENUE,
    SUM(
        CASE
            WHEN MONTH = 'NOV' THEN revenue
        END
    ) AS NOV_REVENUE,
    SUM(
        CASE
            WHEN MONTH = 'DEC' THEN revenue
        END
    ) AS DEC_REVENUE
from Department
group by
    id;