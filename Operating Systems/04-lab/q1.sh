#!/usr/env bash

# Create directories
[[ -d test ]] || { echo "Creating directory test"; mkdir test; } # mkdir test
[[ -d test/mytest ]] || { echo "Creating directory test/mytest"; mkdir -p test/mytest; } # mkdir -p test/mytest

# Copy files
for i in *.txt; do
    [[ -f $i ]] && cp $i test/mytest # cp *.txt test/mytest
done
[[ -f edit2.txt ]] && cp edit2.txt test # cp edit2.txt test

# Move files
[[ -f test/mytest/edit1.txt ]] && mv test/mytest/edit1.txt test/mytest/edit1.doc # mv test/mytest/edit1.txt test/mytest/edit1.doc

# Checking
ls -Ra
