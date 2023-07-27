#!/usr/bin/env bash

PROGRAM_NAME=$(echo $1 | cut -d '.' -f 1)

gcc $1 -o $PROGRAM_NAME

if [ -f $PROGRAM_NAME ]; then
    answer=$(./$PROGRAM_NAME)
else
    answer="Compilation Error"
fi

printf "%s %s\n" "$1" "$answer"