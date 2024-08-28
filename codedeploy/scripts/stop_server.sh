#!/bin/bash
isExistApp=$(pgrep java)
if [ -z "$isExistApp" ]; then    
 echo "The application is  not running";
 else
   echo "Stopping the application.";
   sudo kill -9 $isExistApp
   echo "The application is stopped.";     
     
 fi
