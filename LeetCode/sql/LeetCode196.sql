delete from Person
where
    id not in(
        select MIN(id) as id
        from Person
        group by
            Email
    );