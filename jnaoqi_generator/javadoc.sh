#!/bin/bash


javadoc -splitindex -bottom "<font size='-1'>Aldebaran SDK for Java <br/> Copyright 2006-2015 Aldebaran Robotics. All Rights Reserved.</font>" -classpath lib/libqi-java-2.1.3-mac64.jar -sourcepath ../../libqi-java/qimessaging/src/main/java:generate/src/ -d javadoc -subpackages com -stylesheetfile stylesheet.css