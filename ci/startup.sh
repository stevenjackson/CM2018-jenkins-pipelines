#!/bin/bash

JAR=$(ls target/cdd-workshop-app*.jar)
cp $JAR /workshop/deploy/$1/cdd-workshop-app.jar
JAR=/workshop/deploy/$1/cdd-workshop-app.jar
BUILD_ID=dont_kill java -jar $JAR --server.port=$2 &
echo $! > ~/.pid_$2

