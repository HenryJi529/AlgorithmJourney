-- sql
update salary
set
    sex = CASE sex
        WHEN 'm' THEN 'f'
        ELSE 'm'
    END;

-- mysql
update Salary set sex = IF(sex = 'm', 'f', 'm')