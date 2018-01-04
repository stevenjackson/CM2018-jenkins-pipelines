#!/bin/bash
DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
target=$1
port=$2

$DIR/shutdown.sh $port || true
$DIR/startup.sh $target $port
while $DIR/isDown.sh $port
do
  echo "Waiting on http://localhost:$port"
  sleep 5
done
