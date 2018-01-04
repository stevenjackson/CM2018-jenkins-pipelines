#!/bin/bash

exit $(curl -s localhost:$1/health | grep -q "UP")
