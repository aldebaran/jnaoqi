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
* ALPreferences allows access to xml preference files. 
A preference is defined as follows : 
pParams[0] Name of the preference; 
pParams[1] Description of the preference; 
pParams[2] The value of the preference (can contain other preferences); 
pParams[3] (optional) The name of the data when inserted into memory.
* @see <a href="http://doc.aldebaran.com/2-1/naoqi/core/alpreferences.html#alpreferences">NAOqi APIs for ALPreferences </a>
*
*/
public class ALPreferences extends ALProxy {

    public ALPreferences(Session session) throws Exception{
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
    * Reads all preferences from an xml files and stores them in an ALValue.
    * 
    * @param fileName  Name of the module associated to the preference.
    * @param autoGenerateMemoryNames  If true a memory name will be generated for each non-array preference.
    * @return array reprenting the whole file.
    */
    public Object readPrefFile(String fileName, Boolean autoGenerateMemoryNames) throws CallError, InterruptedException {
        return (Object)call("readPrefFile", fileName, autoGenerateMemoryNames).get();
    }

    /**
    * Writes all preferences from ALValue to an xml file.
    * 
    * @param fileName  Name of the module associated to the preference.
    * @param prefs  array reprenting the whole file.
    * @param ignoreMemoryNames  If true all memory names will be removed before saving.
    */
    public void writePrefFile(String fileName, Object prefs, Boolean ignoreMemoryNames) throws CallError, InterruptedException{
        call("writePrefFile", fileName, prefs, ignoreMemoryNames).get();
    }

    /**
    * Remove the xml file.
    * 
    * @param fileName  Name of the module associated to the preference.
    */
    public void removePrefFile(String fileName) throws CallError, InterruptedException{
        call("removePrefFile", fileName).get();
    }

    /**
    * Writes all preferences from ALValue to an xml file.
    * 
    * @param prefs  array representing the whole file.
    * @return True upon success.
    */
    public Boolean saveToMemory(Object prefs) throws CallError, InterruptedException {
        return (Boolean)call("saveToMemory", prefs).get();
    }

}
    