#!/bin/bash


javadoc -protected -splitindex -bottom "<font size='-1'>Choregraphe: all parts of the products from Aldebaran Robotics, including program and packaging, documentation, web pages and other related items are Copyright ® 2006-2015 Aldebaran Robotics, unless specifically noted. All rights reserved.</font>'" -classpath lib/libqi-java-2.1.3-mac64.jar -sourcepath src/ -d javadoc -subpackages com
