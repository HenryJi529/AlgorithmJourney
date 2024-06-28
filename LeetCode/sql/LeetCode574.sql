select c.name
from Candidate c
    right join Vote v on c.id = v.candidateId
group by
    c.id
order by count(*) desc
limit 1;