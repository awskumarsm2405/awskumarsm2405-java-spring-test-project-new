#!/bin/bash
ls -ltr
pwd
echo 'run application_start.sh: ';
nohup java -jar /var/www/target/account-0.0.1-SNAPSHOT.jar --spring.config.location=/home/application.properties >output.log &
exit 0
