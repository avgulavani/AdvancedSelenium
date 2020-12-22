FROM openjdk:8u191-jre-alpine3.8

#Workspace
WORKDIR /usr/share/dockerdemo

# ADD .jar under target from host
# Into this image

ADD target/selenium-docker.jar            		  selenium-docker.jar
ADD target/selenium-docker-tests.jar              selenium-docker-tests.jar
ADD target/libs                                   libs 


# ADD suite files

ADD testng.xml                            testng.xml

# in case of any other dependency like .csv / .json / /xls
# please add that as well

# BROWSER
# HUB HOST
# MODULE

ENTRYPOINT  java -cp selenium-docker.jar:selenium-docker-tests.jar:libs/* -DHUB_HOST=$HUB_HOST org.testng.TestNG testng.xml
