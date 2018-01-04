#/bin/bash

NEXT_VER=$( grep '^    <version>.*</version>$' pom.xml | awk -F'[><]' '{print $3}' )
git tag -a $NEXT_VER -m "[skip ci] Tagging build as $NEXT_VER"
git push origin --tags

