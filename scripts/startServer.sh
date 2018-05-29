#!/bin/bash

mkdir -p /data/$HOSTNAME

sleep 10
echo "**************************connecting to locator*********"
gfsh connect --locator=locator[10334]

#gfsh list members

gfsh start server --name=$HOSTNAME --locators=locator[10334] --dir=/data/$HOSTNAME/ "$@"

while true; do
    sleep 10
  done
done