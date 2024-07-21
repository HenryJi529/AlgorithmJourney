-- if语句做单一判断，CASE WHEN做多判断
select
    left_operand,
    operator,
    right_operand,
    if(
        CASE
            when operator = '>' then v1.value > v2.value
            when operator = '<' then v1.value < v2.value
            else v1.value = v2.value
        end,
        'true',
        'false'
    ) value
from
    Expressions
    join Variables v1 on left_operand = v1.name
    join Variables v2 on right_operand = v2.name