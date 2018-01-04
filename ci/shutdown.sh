#!/bin/bash

PID=$(cat ~/.pid_$1)
kill $PID

