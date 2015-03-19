/**
 * Copyright (c) 2015 Aldebaran Robotics. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be
 * found in the COPYING file.
 * Created by epinault and tcruz
 */
package com.aldebaran.qi.helper.proxies;

import com.aldebaran.qi.CallError;
import com.aldebaran.qi.Session;
import com.aldebaran.qi.Tuple3;
import com.aldebaran.qi.Tuple4;
import com.aldebaran.qi.helper.ALProxy;

import java.util.List;
/**
* 
* @see <a href="http://doc.aldebaran.lan/doc/release-2.1/aldeb-doc/naoqi/core/alsystem.html#alsystem">NAOqi APIs for ALSystem </a>
*
*/
public class ALSystem extends ALProxy {

    public ALSystem(Session session) throws Exception{
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
    * Display free disk space
    * 
    * @param all  Show all mount partions.
    * @return A vector with all partions' infos
    */
    public List<Tuple4<String, String, Long, Long>> diskFree(Boolean all) throws CallError, InterruptedException {
        return (List<Tuple4<String, String, Long, Long>>)call("diskFree", all).get();
    }

    /**
    * System hostname
    * 
    * @return name of the robot
    */
    public String robotName() throws CallError, InterruptedException {
        return (String)call("robotName").get();
    }

    /**
    * Set system hostname
    * 
    * @param name  name to use
    * @return whether the operation was successful
    */
    public Boolean setRobotName(String name) throws CallError, InterruptedException {
        return (Boolean)call("setRobotName", name).get();
    }

    /**
    * Robot icon
    * 
    * @return icon of the robot
    */
    public Object robotIcon() throws CallError, InterruptedException {
        return (Object)call("robotIcon").get();
    }

    /**
    * Shutdown robot
    * 
    */
    public void shutdown() throws CallError, InterruptedException{
        call("shutdown").get();
    }

    /**
    * Reboot robot
    * 
    */
    public void reboot() throws CallError, InterruptedException{
        call("reboot").get();
    }

    /**
    * Running system version
    * 
    * @return running system version
    */
    public String systemVersion() throws CallError, InterruptedException {
        return (String)call("systemVersion").get();
    }

    /**
    * Running system version
    * 
    * @return information about the system version
    */
    public Tuple3<String, String, String> systemInfo() throws CallError, InterruptedException {
        return (Tuple3<String, String, String>)call("systemInfo").get();
    }

    /**
    * Amount of available memory in heap
    * 
    * @return amount of available memory in heap
    */
    public Integer freeMemory() throws CallError, InterruptedException {
        return (Integer)call("freeMemory").get();
    }

    /**
    * Amount of total memory in heap
    * 
    * @return amount of total memory in heap
    */
    public Integer totalMemory() throws CallError, InterruptedException {
        return (Integer)call("totalMemory").get();
    }

    /**
    * Current timezone
    * 
    * @return current timezone
    */
    public String timezone() throws CallError, InterruptedException {
        return (String)call("timezone").get();
    }

    /**
    * Set current timezone
    * 
    * @param timezone  timezone to use
    * @return whether the operation was successful
    */
    public Boolean setTimezone(String timezone) throws CallError, InterruptedException {
        return (Boolean)call("setTimezone", timezone).get();
    }

    /**
    * Previous system version before software update (empty if this is not the 1st boot after a software update)
    * 
    * @return Previous system version before software update.
    */
    public String previousSystemVersion() throws CallError, InterruptedException {
        return (String)call("previousSystemVersion").get();
    }

    /**
    * Change the user password.
    * 
    * @param old password  The current password of the user.
    * @param new password  The new user password.
    */
    public void changePassword(String oldPassword, String newPassword) throws CallError, InterruptedException{
        call("changePassword", oldPassword, newPassword).get();
    }

    /**
    * Change the user password.
    * 
    * @param image  Local path to a valid image.
    * @param checksum  Local path to a md5 checksum file, or empty string for no verification
    */
    public void upgrade(String image, String checksum) throws CallError, InterruptedException{
        call("upgrade", image, checksum).get();
    }

}
    