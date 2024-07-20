-- order by中也可以用case语句或者直接使用
select question_id as survey_log
from SurveyLog
group by
    question_id
order by sum(if(action = 'answer', 1, 0)) / sum(if(action = 'show', 1, 0)) desc, question_id
limit 1;