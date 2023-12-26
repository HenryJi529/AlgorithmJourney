columns=$(cat file.txt | head -n 1 | wc -w) # 统计列数

for i in $(seq 1 $columns); do
    columnData=$(cut -d' ' -f $i file.txt)
    echo $columnData
done
