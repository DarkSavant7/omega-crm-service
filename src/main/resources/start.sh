#!/bin/bash
java -jar -Dlogging.config=config/logback-spring.xml -Xmx500M telemed-backend.jar
