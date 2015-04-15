/**
 * Copyright (c) 2015 Aldebaran Robotics. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be
 * found in the COPYING file.
 * Created by epinault and tcruz
 */
package com.aldebaran.qi.helper.proxies;

import com.aldebaran.qi.CallError;
import com.aldebaran.qi.Future;
import com.aldebaran.qi.Session;
import com.aldebaran.qi.helper.ALProxy;

import java.util.List;
/**
* Module that manage the background moves automatically started by the robot.
* @see <a href="http://doc.aldebaran.com/2-1/naoqi/motion/autonomousmoves.html#autonomousmoves">NAOqi APIs for ALAutonomousMoves </a>
*
*/
public class ALAutonomousMoves extends ALProxy {

    private AsyncALAutonomousMoves asyncProxy;

    public ALAutonomousMoves(Session session) throws Exception{
        super(session);
        asyncProxy = new AsyncALAutonomousMoves();
	    asyncProxy.setService(getService());
    }

    /**
     * Get the async version of this proxy
     *
	 * @return a AsyncALAutonomousMoves object
	 */
    public AsyncALAutonomousMoves async() {
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
    * DEPRECATED since 2.0: do ALBasicAwareness.setTrackingMode("MoveContextually") instead.Start small base moves.
    * 
    */
    public void startSmallDisplacements() throws CallError, InterruptedException{
        call("startSmallDisplacements").get();
    }

    /**
    * DEPRECATED since 2.0: do ALBasicAwareness.setTrackingMode instead.Stop small base moves.
    * 
    */
    public void stopSmallDisplacements() throws CallError, InterruptedException{
        call("stopSmallDisplacements").get();
    }

    /**
    * Enable or disable expressive listening.
    * 
    * @param enable  The boolean value: true to enable, false to disable.
    */
    public void setExpressiveListeningEnabled(Boolean enable) throws CallError, InterruptedException{
        call("setExpressiveListeningEnabled", enable).get();
    }

    /**
    * If expressive listening is enabled.
    * 
    * @return The boolean value: true means it is enabled, false means it is disabled.
    */
    public Boolean getExpressiveListeningEnabled() throws CallError, InterruptedException {
        return (Boolean)call("getExpressiveListeningEnabled").get();
    }

    /**
    * The background strategy.
    * 
    * @param strategy  The autonomous background posture strategy. ("none" or "backToNeutral")
    */
    public void setBackgroundStrategy(String strategy) throws CallError, InterruptedException{
        call("setBackgroundStrategy", strategy).get();
    }

    /**
    * Gets the background strategy.
    * 
    * @return The autonomous background posture strategy. ("none" or "backToNeutral")
    */
    public String getBackgroundStrategy() throws CallError, InterruptedException {
        return (String)call("getBackgroundStrategy").get();
    }


    public class AsyncALAutonomousMoves extends ALProxy {

        protected AsyncALAutonomousMoves(){
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
    * DEPRECATED since 2.0: do ALBasicAwareness.setTrackingMode("MoveContextually") instead.Start small base moves.
    * 
    * @return The Future
    */
    public Future<Void> startSmallDisplacements() throws CallError, InterruptedException{
        return call("startSmallDisplacements");
    }

    /**
    * DEPRECATED since 2.0: do ALBasicAwareness.setTrackingMode instead.Stop small base moves.
    * 
    * @return The Future
    */
    public Future<Void> stopSmallDisplacements() throws CallError, InterruptedException{
        return call("stopSmallDisplacements");
    }

    /**
    * Enable or disable expressive listening.
    * 
    * @param enable  The boolean value: true to enable, false to disable.
    * @return The Future
    */
    public Future<Void> setExpressiveListeningEnabled(Boolean enable) throws CallError, InterruptedException{
        return call("setExpressiveListeningEnabled", enable);
    }

    /**
    * If expressive listening is enabled.
    * 
    * @return The boolean value: true means it is enabled, false means it is disabled.
    */
    public Future<Boolean> getExpressiveListeningEnabled() throws CallError, InterruptedException {
        return call("getExpressiveListeningEnabled");
    }

    /**
    * The background strategy.
    * 
    * @param strategy  The autonomous background posture strategy. ("none" or "backToNeutral")
    * @return The Future
    */
    public Future<Void> setBackgroundStrategy(String strategy) throws CallError, InterruptedException{
        return call("setBackgroundStrategy", strategy);
    }

    /**
    * Gets the background strategy.
    * 
    * @return The autonomous background posture strategy. ("none" or "backToNeutral")
    */
    public Future<String> getBackgroundStrategy() throws CallError, InterruptedException {
        return call("getBackgroundStrategy");
    }

    }
}
    