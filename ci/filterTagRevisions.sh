#!/bin/bash

if git log -1 --pretty=format:\\\'%an | grep -q "Jenkins"; then
   echo "Build triggered by version update.  Aborting..."
   exit 1
fi

