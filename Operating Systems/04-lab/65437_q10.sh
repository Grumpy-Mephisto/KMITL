#!/usr/bin/env bash

for file in $(find '.' -type f -name "L*.c"); do
    trimmedName=$(echo $file | cut -d '/' -f 2 | cut -d '.' -f 1)
    echo $file $trimmedName
done