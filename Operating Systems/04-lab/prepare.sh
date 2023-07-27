#!/usr/bin bash

[[ -f edit1.txt ]] && rm edit1.txt
[[ -f edit2.txt ]] && rm edit2.txt
[[ -d test ]] && rm -r test

# Create file 
[[ -f edit1.txt ]] || { echo "Creating file edit1.txt"; touch edit1.txt; }
[[ -f edit2.txt ]] || { echo "Creating file edit2.txt"; ls -l > edit2.txt; }

# Check
ls -l