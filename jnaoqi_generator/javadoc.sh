#!/bin/bash


javadoc -splitindex -bottom "<font size='-1'>All parts of the products from Aldebaran Robotics, including program and packaging, documentation, web pages and other related items are Copyright <C2><AE> 2006-2015 Aldebaran Robotics, unless specifically noted. All rights reserved.</font>'" -classpath lib/libqi-java-2.1.3-mac64.jar -sourcepath ../../libqi-java/qimessaging/src/main/java:generate/src/ -d javadoc -subpackages com -stylesheetfile stylesheet.css