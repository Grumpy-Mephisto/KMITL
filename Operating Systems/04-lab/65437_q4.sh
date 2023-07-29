#!/usr/bin/env bash

read -p "Is it morning? Please answer yes or no: " timeOfDay

if [ $timeOfDay = "yes" ]; then
    echo "Good Morning"
elif [ $timeOfDay = "no" ]; then
    echo "Good Afternoon"
else
    echo "Sorry, do not understand $timeOfDay"
    exit 1
fi

exit 0