#!/bin/bash

echo 'run application_start.sh: ' 
java -jar account-0.0.1-SNAPSHOT.jar --spring.config.location=/home/application.properties

exit 0