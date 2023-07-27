#!/usr/bin bash

[[ -f edit1.txt ]] && rm edit1.txt
[[ -f edit2.txt ]] && rm edit2.txt
[[ -d test ]] && rm -r test

# Create file 
[[ -f edit1.txt ]] || { echo "Creating file edit1.txt"; touch edit1.txt; }
[[ -f edit2.txt ]] || { echo "Creating file edit2.txt"; ls -l > edit2.txt; }

# Loop create file q1-q11.sh
for i in {1..11}; do
    [[ -f q$i.sh ]] || { echo "Creating file q$i.sh"; touch q$i.sh; }
done

# Check
ls -l