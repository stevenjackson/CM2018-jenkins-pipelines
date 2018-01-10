#!/bin/bash

if [[ ! -d ../acceptance-tests ]]; then
  git clone git://localhost:9418/acceptance-tests ../acceptance-tests
fi
cd ../acceptance-tests
git pull

