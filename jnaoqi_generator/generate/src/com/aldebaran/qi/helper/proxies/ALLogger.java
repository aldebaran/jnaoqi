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
* This module allows you log errors, warnings, and info stdout or a file. The verbosity level allow you to  customize the output.
* @see <a href="http://doc.aldebaran.lan/doc/release-2.1/aldeb-doc/naoqi/core/allogger.html#allogger">NAOqi APIs for ALLogger </a>
*
*/
public class ALLogger extends ALProxy {

    public ALLogger(Session session) throws Exception{
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
    * DEPRECATED. Use qiLogFatal instead. 
 Log a fatal error.
    * 
    * @param moduleName  Name of the module.
    * @param message  Log Message.
    */
    public void fatal(String moduleName, String message) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("fatal", moduleName, message);
        else
            call("fatal", moduleName, message).get();
    }

    /**
    * DEPRECATED. Use qiLogError instead. 
 Log an error.
    * 
    * @param moduleName  Name of the module.
    * @param message  Log Message.
    */
    public void error(String moduleName, String message) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("error", moduleName, message);
        else
            call("error", moduleName, message).get();
    }

    /**
    * DEPRECATED: use qiLogWarning instead. Log a warning.
    * 
    * @param moduleName  Name of the module.
    * @param message  Log Message.
    */
    public void warn(String moduleName, String message) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("warn", moduleName, message);
        else
            call("warn", moduleName, message).get();
    }

    /**
    * DEPRECATED. Use qiLogInfo instead. 
 Log a info message.
    * 
    * @param moduleName  Name of the module.
    * @param message  Log Message.
    */
    public void info(String moduleName, String message) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("info", moduleName, message);
        else
            call("info", moduleName, message).get();
    }

    /**
    * DEPRECATED. Use qiLogDebug instead. 
 Log a debug message.
    * 
    * @param moduleName  Name of the module.
    * @param message  Log Message.
    */
    public void debug(String moduleName, String message) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("debug", moduleName, message);
        else
            call("debug", moduleName, message).get();
    }

    /**
    * Removed: not implemented anymore.
    * 
    */
    public void setVerbosity(String param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("setVerbosity", param1);
        else
            call("setVerbosity", param1).get();
    }

    /**
    * Removed: not implemented anymore.
    * 
    */
    public Integer verbosity() throws CallError, InterruptedException {
        return (Integer)call("verbosity").get();
    }

    /**
    * Removed: not implemented anymore.
    * 
    */
    public void logInFile(String param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("logInFile", param1);
        else
            call("logInFile", param1).get();
    }

    /**
    * Removed: not implemented anymore.
    * 
    */
    public void logInForwarder(String param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("logInForwarder", param1);
        else
            call("logInForwarder", param1).get();
    }

    /**
    * Removed: not implemented anymore.
    * 
    */
    public void removeHandler(String param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("removeHandler", param1);
        else
            call("removeHandler", param1).get();
    }

}
    