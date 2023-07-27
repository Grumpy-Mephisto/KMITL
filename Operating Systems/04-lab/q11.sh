#!/usr/bin/env bash

RESULT=20
CORRECT_ANSWER=10
WRONG_ANSWER=7
NOT_COMPILED=5

RED=$(tput setaf 1)
GREEN=$(tput setaf 2)
YELLOW=$(tput setaf 3)
RESET=$(tput sgr0)

for file in L*.c; do
    if [ -f "$file" ]; then
        program_name=$(echo "$file" | cut -d '.' -f 1)

        if gcc "$file" -o "$program_name" > /dev/null 2>&1; then
            answer=$(./"$program_name")

            if [ "$answer" -eq "$RESULT" ]; then
                printf "%s\t%s%d%s\n" "$program_name" "$GREEN" "$CORRECT_ANSWER" "$RESET"
            else
                printf "%s\t%s%d%s\n" "$program_name" "$YELLOW" "$WRONG_ANSWER" "$RESET"
            fi
        else
            printf "%s\t%s%d%s\n" "$program_name" "$RED" "$NOT_COMPILED" "$RESET"
        fi
    fi
done
