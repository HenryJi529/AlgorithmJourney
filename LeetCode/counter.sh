# 只统计有效题目
javaNum=$(ls -l *.java | wc -l)
pythonNum=$(ls -l *.py | wc -l)
shellNum=$(ls -l shell/*.sh | wc -l)
sqlNum=$(ls -l sql/*.sql | wc -l)
echo "javaNum=$javaNum"
echo "pythonNum=$pythonNum"
echo "shellNum=$shellNum"
echo "sqlNum=$sqlNum"
echo $(($javaNum + $pythonNum + $shellNum + $sqlNum))
