-- # NOTE: 这样有些繁琐
-- select project_id, ROUND(Avg(experience_years), 2) as average_years
-- from (
--         select p.project_id, e.experience_years
--         from Project as p
--             left join Employee as e on p.employee_id = e.employee_id
--     ) t
-- group by
--     project_id;

SELECT project_id, ROUND(AVG(experience_years), 2) AS average_years
FROM Project AS p
    LEFT JOIN Employee AS e ON p.employee_id = e.employee_id
GROUP BY
    project_id