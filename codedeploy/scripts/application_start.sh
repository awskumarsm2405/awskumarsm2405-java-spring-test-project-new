#!/bin/bash

echo 'run application_start.sh: '; 
java -jar target/account-0.0.1-SNAPSHOT.jar --spring.config.location=/home/application.properties
echo 'application started running with id' 
isExistApp=$(pgrep java)
echo $isExistApp;
exit 0