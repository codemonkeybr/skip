#!/bin/bash

docker run -it --rm -v "$(pwd)":/opt/maven -w /opt/maven maven:3.5.0-jdk-8 mvn -Dmaven.repo.local=/opt/maven/.m2_docker clean install -DskipTests

if [[ "$uname" == 'Linux' ]]; then
   sudo chown $(whoami) -R just-food-*/target
fi

docker-compose -f docker-compose-local.yml up --build
