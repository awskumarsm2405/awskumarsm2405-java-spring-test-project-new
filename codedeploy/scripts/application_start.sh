#!/bin/bash

echo 'run application_start.sh: ' 
nohup java -jar account-0.0.1-SNAPSHOT.jar --spring.config.location=/home/application.properties > /dev/null 2>&1 &

exit 0