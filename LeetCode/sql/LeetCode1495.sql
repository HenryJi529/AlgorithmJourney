select distinct
    c.title "TITLE"
from TVProgram t
    left join Content c on t.content_id = c.content_id
where
    year(t.program_date) = "2020"
    and month(t.program_date) = "6"
    and c.Kids_content = 'Y'
    and c.content_type = "Movies"