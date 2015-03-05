/**
 * Copyright (c) 2015 Aldebaran Robotics. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be
 * found in the COPYING file.
 * Created by epinault and tcruz
 */
package com.aldebaran.qi.helper.proxies;

import com.aldebaran.qi.CallError;
import com.aldebaran.qi.Session;
import com.aldebaran.qi.helper.ALProxy;
import java.util.List;
import java.util.Map;
import com.aldebaran.qi.*;

import java.util.List;
/**
* Use ALRobotPosture module to make the robot go tothe asked posture.
* @see <a href="http://doc.aldebaran.lan/doc/release-2.1/aldeb-doc/naoqi/motion/alrobotposture.html#alrobotposture">NAOqi APIs for ALRobotPosture </a>
*
*/
public class ALRobotPosture extends ALProxy {

    public ALRobotPosture(Session session) {
        super(session);
    }

    /**
    * 
    * 
    */
    public Boolean isStatsEnabled() throws CallError, InterruptedException {
        return (Boolean)call("isStatsEnabled").get();
    }

    /**
    * 
    * 
    */
    public void clearStats() throws CallError, InterruptedException{
        if (isAsynchronous)
            call("clearStats");
        else
            call("clearStats").get();
    }

    /**
    * 
    * 
    */
    public Boolean isTraceEnabled() throws CallError, InterruptedException {
        return (Boolean)call("isTraceEnabled").get();
    }

    /**
    * Exits and unregisters the module.
    * 
    */
    public void exit() throws CallError, InterruptedException{
        if (isAsynchronous)
            call("exit");
        else
            call("exit").get();
    }

    /**
    * Returns the version of the module.
    * 
    * @return A string containing the version of the module.
    */
    public String version() throws CallError, InterruptedException {
        return (String)call("version").get();
    }

    /**
    * Just a ping. Always returns true
    * 
    * @return returns true
    */
    public Boolean ping() throws CallError, InterruptedException {
        return (Boolean)call("ping").get();
    }

    /**
    * Retrieves the module's method list.
    * 
    * @return An array of method names.
    */
    public List<String> getMethodList() throws CallError, InterruptedException {
        return (List<String>)call("getMethodList").get();
    }

    /**
    * Retrieves a method's description.
    * 
    * @param methodName  The name of the method.
    * @return A structure containing the method's description.
    */
    public Object getMethodHelp(String methodName) throws CallError, InterruptedException {
        return (Object)call("getMethodHelp", methodName).get();
    }

    /**
    * Retrieves the module's description.
    * 
    * @return A structure describing the module.
    */
    public Object getModuleHelp() throws CallError, InterruptedException {
        return (Object)call("getModuleHelp").get();
    }

    /**
    * Wait for the end of a long running method that was called using 'post'
    * 
    * @param id  The ID of the method that was returned when calling the method using 'post'
    * @param timeoutPeriod  The timeout period in ms. To wait indefinately, use a timeoutPeriod of zero.
    * @return True if the timeout period terminated. False if the method returned.
    */
    public Boolean wait(Integer id, Integer timeoutPeriod) throws CallError, InterruptedException {
        return (Boolean)call("wait", id, timeoutPeriod).get();
    }

    /**
    * Returns true if the method is currently running.
    * 
    * @param id  The ID of the method that was returned when calling the method using 'post'
    * @return True if the method is currently running
    */
    public Boolean isRunning(Integer id) throws CallError, InterruptedException {
        return (Boolean)call("isRunning", id).get();
    }

    /**
    * returns true if the method is currently running
    * 
    * @param id  the ID of the method to wait for
    */
    public void stop(Integer id) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("stop", id);
        else
            call("stop", id).get();
    }

    /**
    * Gets the name of the parent broker.
    * 
    * @return The name of the parent broker.
    */
    public String getBrokerName() throws CallError, InterruptedException {
        return (String)call("getBrokerName").get();
    }

    /**
    * Gets the method usage string. This summarises how to use the method.
    * 
    * @param name  The name of the method.
    * @return A string that summarises the usage of the method.
    */
    public String getUsage(String name) throws CallError, InterruptedException {
        return (String)call("getUsage", name).get();
    }

    /**
    * Returns the posture family for example Standing, LyingBelly,...
    * 
    * @return Returns the posture family, e.g. Standing.
    */
    public String getPostureFamily() throws CallError, InterruptedException {
        return (String)call("getPostureFamily").get();
    }

    /**
    * Make the robot go to the choosenposture.
    * 
    * @param postureName  Name of the desired posture. Use getPostureList to get the list of posture name available.
    * @param maxSpeedFraction  A fraction.
    * @return Returns if the posture was reached or not.
    */
    public Boolean goToPosture(String postureName, Float maxSpeedFraction) throws CallError, InterruptedException {
        return (Boolean)call("goToPosture", postureName, maxSpeedFraction).get();
    }

    /**
    * Set the angle of the joints of the  robot to the choosen posture.
    * 
    * @param postureName  Name of the desired posture. Use getPostureList to get the list of posture name available.
    * @param maxSpeedFraction  A fraction.
    * @return Returns if the posture was reached or not.
    */
    public Boolean applyPosture(String postureName, Float maxSpeedFraction) throws CallError, InterruptedException {
        return (Boolean)call("applyPosture", postureName, maxSpeedFraction).get();
    }

    /**
    * Stop the posture move.
    * 
    */
    public void stopMove() throws CallError, InterruptedException{
        if (isAsynchronous)
            call("stopMove");
        else
            call("stopMove").get();
    }

    /**
    * Get the list of posture names available.
    * 
    */
    public List<String> getPostureList() throws CallError, InterruptedException {
        return (List<String>)call("getPostureList").get();
    }

    /**
    * Get the list of posture family names available.
    * 
    */
    public List<String> getPostureFamilyList() throws CallError, InterruptedException {
        return (List<String>)call("getPostureFamilyList").get();
    }

    /**
    * Set maximum of tries ongoToPosture fail.
    * 
    * @param pMaxTryNumber  Number of retry if goToPosture fail.
    */
    public void setMaxTryNumber(Integer pMaxTryNumber) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("setMaxTryNumber", pMaxTryNumber);
        else
            call("setMaxTryNumber", pMaxTryNumber).get();
    }

    /**
    * Determine posture.
    * 
    */
    public String getPosture() throws CallError, InterruptedException {
        return (String)call("getPosture").get();
    }

}
    