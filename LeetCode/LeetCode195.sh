lines=$(awk 'END {print NR}' file.txt)
if [ $lines -ge 10 ]; then
    head -n 10 file.txt | tail -n 1
fi
