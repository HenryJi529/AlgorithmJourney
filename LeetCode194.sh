# https://leetcode.cn/problems/transpose-file/description/

columns=$(cat file.txt | head -n 1 | wc -w)

for i in $(seq 1 $columns); do
    columnData=$(cut -d' ' -f $i file.txt)
    echo $columnData
done
