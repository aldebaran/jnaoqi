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
* 
* @see <a href="http://doc.aldebaran.lan/doc/release-2.3/aldeb-doc/naoqi/motion/alrecharge.html#alrecharge">NAOqi APIs for ALRecharge </a>
* NAOqi V2.3.x
*/
public class ALRecharge extends ALProxy {

    private AsyncALRecharge asyncProxy;

    public ALRecharge(Session session) throws Exception{
        super(session);
        asyncProxy = new AsyncALRecharge();
	    asyncProxy.setService(getService());
    }

    /**
     * Get the async version of this proxy
     *
	 * @return a AsyncALRecharge object
	 */
    public AsyncALRecharge async() {
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
    * .
    * 
    */
    public void goToStation() throws CallError, InterruptedException{
        call("goToStation").get();
    }

    /**
    * .
    * 
    */
    public Integer leaveStation() throws CallError, InterruptedException {
        return (Integer)call("leaveStation").get();
    }

    /**
    * .
    * 
    */
    public List<Float> getStationPosition() throws CallError, InterruptedException {
        return (List<Float>)call("getStationPosition").get();
    }

    /**
    * .
    * 
    */
    public void stopAll() throws CallError, InterruptedException{
        call("stopAll").get();
    }

    /**
    * .
    * 
    */
    public void subscribe() throws CallError, InterruptedException{
        call("subscribe").get();
    }

    /**
    * .
    * 
    */
    public void unsubscribe() throws CallError, InterruptedException{
        call("unsubscribe").get();
    }

    /**
    * .
    * 
    */
    public Integer getStatus() throws CallError, InterruptedException {
        return (Integer)call("getStatus").get();
    }

    /**
    * .
    * 
    */
    public Object lookForStation() throws CallError, InterruptedException {
        return (Object)call("lookForStation").get();
    }

    /**
    * .
    * 
    */
    public Integer moveInFrontOfStation() throws CallError, InterruptedException {
        return (Integer)call("moveInFrontOfStation").get();
    }

    /**
    * .
    * 
    */
    public Integer dockOnStation() throws CallError, InterruptedException {
        return (Integer)call("dockOnStation").get();
    }

    /**
    * .
    * 
    */
    public void setUseTrackerSearcher(Boolean param1) throws CallError, InterruptedException{
        call("setUseTrackerSearcher", param1).get();
    }

    /**
    * .
    * 
    */
    public Boolean getUseTrackerSearcher() throws CallError, InterruptedException {
        return (Boolean)call("getUseTrackerSearcher").get();
    }

    /**
    * .
    * 
    */
    public void setMaxNumberOfTries(Integer param1) throws CallError, InterruptedException{
        call("setMaxNumberOfTries", param1).get();
    }

    /**
    * .
    * 
    */
    public Integer getMaxNumberOfTries() throws CallError, InterruptedException {
        return (Integer)call("getMaxNumberOfTries").get();
    }

    /**
    * .
    * 
    */
    public Integer adjustDockingPosition(List<List<Float>> param1) throws CallError, InterruptedException {
        return (Integer)call("adjustDockingPosition", param1).get();
    }


    public class AsyncALRecharge extends ALProxy {

        protected AsyncALRecharge(){
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
    * .
    * 
    * @return The Future
    */
    public Future<Void> goToStation() throws CallError, InterruptedException{
        return call("goToStation");
    }

    /**
    * .
    * 
    */
    public Future<Integer> leaveStation() throws CallError, InterruptedException {
        return call("leaveStation");
    }

    /**
    * .
    * 
    */
    public Future<List<Float>> getStationPosition() throws CallError, InterruptedException {
        return call("getStationPosition");
    }

    /**
    * .
    * 
    * @return The Future
    */
    public Future<Void> stopAll() throws CallError, InterruptedException{
        return call("stopAll");
    }

    /**
    * .
    * 
    * @return The Future
    */
    public Future<Void> subscribe() throws CallError, InterruptedException{
        return call("subscribe");
    }

    /**
    * .
    * 
    * @return The Future
    */
    public Future<Void> unsubscribe() throws CallError, InterruptedException{
        return call("unsubscribe");
    }

    /**
    * .
    * 
    */
    public Future<Integer> getStatus() throws CallError, InterruptedException {
        return call("getStatus");
    }

    /**
    * .
    * 
    */
    public Future<Object> lookForStation() throws CallError, InterruptedException {
        return call("lookForStation");
    }

    /**
    * .
    * 
    */
    public Future<Integer> moveInFrontOfStation() throws CallError, InterruptedException {
        return call("moveInFrontOfStation");
    }

    /**
    * .
    * 
    */
    public Future<Integer> dockOnStation() throws CallError, InterruptedException {
        return call("dockOnStation");
    }

    /**
    * .
    * 
    * @return The Future
    */
    public Future<Void> setUseTrackerSearcher(Boolean param1) throws CallError, InterruptedException{
        return call("setUseTrackerSearcher", param1);
    }

    /**
    * .
    * 
    */
    public Future<Boolean> getUseTrackerSearcher() throws CallError, InterruptedException {
        return call("getUseTrackerSearcher");
    }

    /**
    * .
    * 
    * @return The Future
    */
    public Future<Void> setMaxNumberOfTries(Integer param1) throws CallError, InterruptedException{
        return call("setMaxNumberOfTries", param1);
    }

    /**
    * .
    * 
    */
    public Future<Integer> getMaxNumberOfTries() throws CallError, InterruptedException {
        return call("getMaxNumberOfTries");
    }

    /**
    * .
    * 
    */
    public Future<Integer> adjustDockingPosition(List<List<Float>> param1) throws CallError, InterruptedException {
        return call("adjustDockingPosition", param1);
    }

    }
}
    