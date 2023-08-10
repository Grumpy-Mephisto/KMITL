#!/usr/bin/env bash

read -rp "Enter your number (i.e. 65437): " number

# Check if the number is a valid positive integer
if ! [[ $number =~ ^[0-9]+$ ]]; then
    echo "Error: Invalid input. Please enter a valid positive integer."
    exit 1
fi

# Change file names from q*.sh to 65437_q*.sh
for file in q*.sh; do
    if [[ -f "$file" ]]; then
        new_filename="${number}_${file}"
        mv "$file" "$new_filename"
        echo "Renamed $file to $new_filename"
    fi
done
