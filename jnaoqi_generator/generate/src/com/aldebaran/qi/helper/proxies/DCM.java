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
/**
* Manage link with devices (sensors and actuators). See specific documentation.
* @see <a href="http://doc.aldebaran.com/2-1/naoqi/sensors/dcm.html#dcm">NAOqi APIs for DCM </a>
*
*/
public class DCM extends ALProxy {

    public DCM(Session session) throws Exception{
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
    * Call this function to send a timed-command list to an actuator
    * 
    * @param commands  AL::ALValue with all data
    */
    public void set(Object commands) throws CallError, InterruptedException{
        call("set", commands).get();
    }

    /**
    * Call this function to send timed-command list to an alias (list of actuators)
    * 
    * @param commands  AL::ALValue with all data
    */
    public void setAlias(Object commands) throws CallError, InterruptedException{
        call("setAlias", commands).get();
    }

    /**
    * Call this function to send timed-command list to an alias (list of actuators) with "ClearAll" merge startegy
    * 
    * @param name  alias name
    * @param time  time for the timed command
    * @param commands  std::vector<float> with all commands
    */
    public void setAlias(String name, Integer time, List<Float> commands) throws CallError, InterruptedException{
        call("setAlias", name, time, commands).get();
    }

    /**
    * Return the DCM time
    * 
    * @param offset  optional time in ms (signed) to add/remove
    * @return An integer (could be signed) with the DCM time
    */
    public Integer getTime(Integer offset) throws CallError, InterruptedException {
        return (Integer)call("getTime", offset).get();
    }

    /**
    * Create or change an alias (list of actuators)
    * 
    * @param alias  Alias name and description
    * @return Same as pParams, but with the name removed if the actuator is not found
    */
    public Object createAlias(Object alias) throws CallError, InterruptedException {
        return (Object)call("createAlias", alias).get();
    }

    /**
    * Return the STM base name
    * 
    * @return the STM base name for all device/sensors (1st string in the array) and all devices (2nd string in the array)
    */
    public Object getPrefix() throws CallError, InterruptedException {
        return (Object)call("getPrefix").get();
    }

    /**
    * Special DCM commands
    * 
    * @param result  one string and could be Reset, Version, Chain, Diagnostic, Config
    */
    public void special(String result) throws CallError, InterruptedException{
        call("special", result).get();
    }

    /**
    * Calibration of a joint
    * 
    * @param calibrationInput  A complex ALValue. See red documentation
    */
    public void calibration(Object calibrationInput) throws CallError, InterruptedException{
        call("calibration", calibrationInput).get();
    }

    /**
    * Save updated value from DCM in XML pref file
    * 
    * @param action  string : 'Save' 'Load' 'Add'
    * @param target  string : 'Chest' 'Head' 'Main' 'All' 
    * @param keyName  The name of the key if action = 'Add'.
    * @param keyValue  The ALVAlue of the key to add
    * @return Nothing
    */
    public Integer preferences(String action, String target, String keyName, Object keyValue) throws CallError, InterruptedException {
        return (Integer)call("preferences", action, target, keyName, keyValue).get();
    }

}
    