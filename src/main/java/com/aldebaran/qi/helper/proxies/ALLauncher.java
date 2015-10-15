/**
 * Copyright (c) 2015 Aldebaran Robotics. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be
 * found in the COPYING file.
 * Created by epinault and tcruz
 */
package com.aldebaran.qi.helper.proxies;

import com.aldebaran.qi.*;
import com.aldebaran.qi.helper.*;
import java.util.List;
import java.util.Map;


import java.util.List;
/**
* ALlauncher allows to link dynamicaly with library, run executable, unload library, check if module is loaded...
* @see <a href="http://doc.aldebaran.lan/doc/release-2.3/aldeb-doc/naoqi/core/allauncher.html#allauncher">NAOqi APIs for ALLauncher </a>
* NAOqi V2.3.x
*/
public class ALLauncher extends ALProxy {

    private AsyncALLauncher asyncProxy;

    public ALLauncher(Session session) throws Exception{
        super(session);
        asyncProxy = new AsyncALLauncher();
	    asyncProxy.setService(getService());
    }

    /**
     * Get the async version of this proxy
     *
	 * @return a AsyncALLauncher object
	 */
    public AsyncALLauncher async() {
        return asyncProxy;
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
    * Loads dynamicaly a module
    * 
    * @param moduleName  the name of the module to launch or the name of the python script to evaluate
    * @return list of modules loaded
    */
    public List<String> launchLocal(String moduleName) throws CallError, InterruptedException {
        return (List<String>)call("launchLocal", moduleName).get();
    }

    /**
    * runs an executable and connect it to current broker (executable)
    * 
    * @param moduleName  the name of the module to launch or the name of the script file to execute
    * @return true if ok
    */
    public Boolean launchExecutable(String moduleName) throws CallError, InterruptedException {
        return (Boolean)call("launchExecutable", moduleName).get();
    }

    /**
    * runs a script connected the current broker
    * 
    * @param moduleName  the name of the script to launch (python)
    * @return true if ok
    */
    public Boolean launchScript(String moduleName) throws CallError, InterruptedException {
        return (Boolean)call("launchScript", moduleName).get();
    }

    /**
    * Import a python module
    * 
    * @param moduleName  the name of the module to launch
    * @return true if ok
    */
    public Boolean launchPythonModule(String moduleName) throws CallError, InterruptedException {
        return (Boolean)call("launchPythonModule", moduleName).get();
    }

    /**
    * Tests the existence of an active module in the global system (in same executable or in another executable of the distributed system)
    * 
    * @param strPartOfModuleName  a part of the name of the module to test existence
    * @return the returned value is true if this module is present
    */
    public Boolean isModulePresent(String strPartOfModuleName) throws CallError, InterruptedException {
        return (Boolean)call("isModulePresent", strPartOfModuleName).get();
    }

    /**
    * get the list of modules loaded on the robot and connected on the robot
    * 
    * @return array of present modules
    */
    public List<String> getGlobalModuleList() throws CallError, InterruptedException {
        return (List<String>)call("getGlobalModuleList").get();
    }


    public class AsyncALLauncher extends ALProxy {

        protected AsyncALLauncher(){
            super();
        }
    
    /**
    * 
    * 
    */
    public Future<Boolean> isStatsEnabled() throws CallError, InterruptedException {
        return call("isStatsEnabled");
    }

    /**
    * 
    * 
    * @return The Future
    */
    public Future<Void> clearStats() throws CallError, InterruptedException{
        return call("clearStats");
    }

    /**
    * 
    * 
    */
    public Future<Boolean> isTraceEnabled() throws CallError, InterruptedException {
        return call("isTraceEnabled");
    }

    /**
    * Exits and unregisters the module.
    * 
    * @return The Future
    */
    public Future<Void> exit() throws CallError, InterruptedException{
        return call("exit");
    }

    /**
    * Returns the version of the module.
    * 
    * @return A string containing the version of the module.
    */
    public Future<String> version() throws CallError, InterruptedException {
        return call("version");
    }

    /**
    * Just a ping. Always returns true
    * 
    * @return returns true
    */
    public Future<Boolean> ping() throws CallError, InterruptedException {
        return call("ping");
    }

    /**
    * Retrieves the module's method list.
    * 
    * @return An array of method names.
    */
    public Future<List<String>> getMethodList() throws CallError, InterruptedException {
        return call("getMethodList");
    }

    /**
    * Retrieves a method's description.
    * 
    * @param methodName  The name of the method.
    * @return A structure containing the method's description.
    */
    public Future<Object> getMethodHelp(String methodName) throws CallError, InterruptedException {
        return call("getMethodHelp", methodName);
    }

    /**
    * Retrieves the module's description.
    * 
    * @return A structure describing the module.
    */
    public Future<Object> getModuleHelp() throws CallError, InterruptedException {
        return call("getModuleHelp");
    }

    /**
    * Wait for the end of a long running method that was called using 'post'
    * 
    * @param id  The ID of the method that was returned when calling the method using 'post'
    * @param timeoutPeriod  The timeout period in ms. To wait indefinately, use a timeoutPeriod of zero.
    * @return True if the timeout period terminated. False if the method returned.
    */
    public Future<Boolean> wait(Integer id, Integer timeoutPeriod) throws CallError, InterruptedException {
        return call("wait", id, timeoutPeriod);
    }

    /**
    * Returns true if the method is currently running.
    * 
    * @param id  The ID of the method that was returned when calling the method using 'post'
    * @return True if the method is currently running
    */
    public Future<Boolean> isRunning(Integer id) throws CallError, InterruptedException {
        return call("isRunning", id);
    }

    /**
    * returns true if the method is currently running
    * 
    * @param id  the ID of the method to wait for
    * @return The Future
    */
    public Future<Void> stop(Integer id) throws CallError, InterruptedException{
        return call("stop", id);
    }

    /**
    * Gets the name of the parent broker.
    * 
    * @return The name of the parent broker.
    */
    public Future<String> getBrokerName() throws CallError, InterruptedException {
        return call("getBrokerName");
    }

    /**
    * Gets the method usage string. This summarises how to use the method.
    * 
    * @param name  The name of the method.
    * @return A string that summarises the usage of the method.
    */
    public Future<String> getUsage(String name) throws CallError, InterruptedException {
        return call("getUsage", name);
    }

    /**
    * Loads dynamicaly a module
    * 
    * @param moduleName  the name of the module to launch or the name of the python script to evaluate
    * @return list of modules loaded
    */
    public Future<List<String>> launchLocal(String moduleName) throws CallError, InterruptedException {
        return call("launchLocal", moduleName);
    }

    /**
    * runs an executable and connect it to current broker (executable)
    * 
    * @param moduleName  the name of the module to launch or the name of the script file to execute
    * @return true if ok
    */
    public Future<Boolean> launchExecutable(String moduleName) throws CallError, InterruptedException {
        return call("launchExecutable", moduleName);
    }

    /**
    * runs a script connected the current broker
    * 
    * @param moduleName  the name of the script to launch (python)
    * @return true if ok
    */
    public Future<Boolean> launchScript(String moduleName) throws CallError, InterruptedException {
        return call("launchScript", moduleName);
    }

    /**
    * Import a python module
    * 
    * @param moduleName  the name of the module to launch
    * @return true if ok
    */
    public Future<Boolean> launchPythonModule(String moduleName) throws CallError, InterruptedException {
        return call("launchPythonModule", moduleName);
    }

    /**
    * Tests the existence of an active module in the global system (in same executable or in another executable of the distributed system)
    * 
    * @param strPartOfModuleName  a part of the name of the module to test existence
    * @return the returned value is true if this module is present
    */
    public Future<Boolean> isModulePresent(String strPartOfModuleName) throws CallError, InterruptedException {
        return call("isModulePresent", strPartOfModuleName);
    }

    /**
    * get the list of modules loaded on the robot and connected on the robot
    * 
    * @return array of present modules
    */
    public Future<List<String>> getGlobalModuleList() throws CallError, InterruptedException {
        return call("getGlobalModuleList");
    }

    }
}
    