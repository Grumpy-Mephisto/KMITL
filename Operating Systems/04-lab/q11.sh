#!/usr/bin/env bash

RESULT=20
CORRECT_ANSWER=10
WRONG_ANSWER=7
NOT_COMPILED=5

for file in L*.c; do
    if [ -f "$file" ]; then
        program_name=$(echo "$file" | cut -d '.' -f 1)

        if gcc "$file" -o "$program_name" > /dev/null 2>&1; then
            answer=$(./"$program_name")

            if [ "$answer" -eq "$RESULT" ]; then
                printf "%s %s\n" "$program_name" "$CORRECT_ANSWER"
            else
                printf "%s %s\n" "$program_name" "$WRONG_ANSWER"
            fi
        else
            printf "%s %s\n" "$program_name" "$NOT_COMPILED"
        fi
    fi
done
