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
* This module enables to detect if the robot is in a dark environment
* @see <a href="http://doc.aldebaran.lan/doc/release-2.1/aldeb-doc/naoqi/vision/aldarknessdetection.html#aldarknessdetection">NAOqi APIs for ALDarknessDetection </a>
*
*/
public class ALDarknessDetection extends ALProxy {

    public ALDarknessDetection(Session session) throws Exception{
        super(session);
    }

    /**
    * Gets extractor resolution
    * 
    * @return Current value of the resolution of the extractor
    */
    public Integer getResolution() throws CallError, InterruptedException {
        return (Integer)call("getResolution").get();
    }

    /**
    * Sets extractor resolution
    * 
    * @param resolution  New resolution
    * @return True if the update succeeded, False if not
    */
    public Boolean setResolution(Integer resolution) throws CallError, InterruptedException {
        return (Boolean)call("setResolution", resolution).get();
    }

    /**
    * Returns the current DarknessThreshold for isItDark
    * 
    * @return Current darkness threshold value
    */
    public Integer getDarknessThreshold() throws CallError, InterruptedException {
        return (Integer)call("getDarknessThreshold").get();
    }

    /**
    * DEPRECATED: Sets pause and resolution
    * 
    * @param paramName  Name of the parameter to set
    * @param value  New value
    */
    public void setParameter(String paramName, Object value) throws CallError, InterruptedException{
        call("setParameter", paramName, value).get();
    }

    /**
    * Gets extractor framerate
    * 
    * @return Current value of the framerate of the extractor
    */
    public Integer getFrameRate() throws CallError, InterruptedException {
        return (Integer)call("getFrameRate").get();
    }

    /**
    * Gets extractor active camera
    * 
    * @return Id of the current active camera of the extractor
    */
    public Integer getActiveCamera() throws CallError, InterruptedException {
        return (Integer)call("getActiveCamera").get();
    }

    /**
    * Gets extractor pause status
    * 
    * @return True if the extractor is paused, False if not
    */
    public Boolean isPaused() throws CallError, InterruptedException {
        return (Boolean)call("isPaused").get();
    }

    /**
    * Sets extractor active camera
    * 
    * @param cameraId  Id of the camera that will become the active camera
    * @return True if the update succeeded, False if not
    */
    public Boolean setActiveCamera(Integer cameraId) throws CallError, InterruptedException {
        return (Boolean)call("setActiveCamera", cameraId).get();
    }

    /**
    * Gets extractor running status
    * 
    * @return True if the extractor is currently processing images, False if not
    */
    public Boolean isProcessing() throws CallError, InterruptedException {
        return (Boolean)call("isProcessing").get();
    }

    /**
    * Changes the pause status of the extractor
    * 
    * @param paused  New pause satus
    */
    public void pause(Boolean paused) throws CallError, InterruptedException{
        call("pause", paused).get();
    }

    /**
    * Enables to change the DarknessThreshold for isItDark
    * 
    * @param threshold  New darkness threshold (between 0 and 100)
    */
    public void setDarknessThreshold(Integer threshold) throws CallError, InterruptedException{
        call("setDarknessThreshold", threshold).get();
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
    * Subscribes to the extractor. This causes the extractor to start writing information to memory using the keys described by getOutputNames(). These can be accessed in memory using ALMemory.getData("keyName"). In many cases you can avoid calling subscribe on the extractor by just calling ALMemory.subscribeToEvent() supplying a callback method. This will automatically subscribe to the extractor for you.
    * 
    * @param name  Name of the module which subscribes.
    * @param period  Refresh period (in milliseconds) if relevant.
    * @param precision  Precision of the extractor if relevant.
    */
    public void subscribe(String name, Integer period, Float precision) throws CallError, InterruptedException{
        call("subscribe", name, period, precision).get();
    }

    /**
    * Subscribes to the extractor. This causes the extractor to start writing information to memory using the keys described by getOutputNames(). These can be accessed in memory using ALMemory.getData("keyName"). In many cases you can avoid calling subscribe on the extractor by just calling ALMemory.subscribeToEvent() supplying a callback method. This will automatically subscribe to the extractor for you.
    * 
    * @param name  Name of the module which subscribes.
    */
    public void subscribe(String name) throws CallError, InterruptedException{
        call("subscribe", name).get();
    }

    /**
    * Unsubscribes from the extractor.
    * 
    * @param name  Name of the module which had subscribed.
    */
    public void unsubscribe(String name) throws CallError, InterruptedException{
        call("unsubscribe", name).get();
    }

    /**
    * Updates the period if relevant.
    * 
    * @param name  Name of the module which has subscribed.
    * @param period  Refresh period (in milliseconds).
    */
    public void updatePeriod(String name, Integer period) throws CallError, InterruptedException{
        call("updatePeriod", name, period).get();
    }

    /**
    * Updates the precision if relevant.
    * 
    * @param name  Name of the module which has subscribed.
    * @param precision  Precision of the extractor.
    */
    public void updatePrecision(String name, Float precision) throws CallError, InterruptedException{
        call("updatePrecision", name, precision).get();
    }

    /**
    * Gets the current period.
    * 
    * @return Refresh period (in milliseconds).
    */
    public Integer getCurrentPeriod() throws CallError, InterruptedException {
        return (Integer)call("getCurrentPeriod").get();
    }

    /**
    * Gets the current precision.
    * 
    * @return Precision of the extractor.
    */
    public Float getCurrentPrecision() throws CallError, InterruptedException {
        return (Float)call("getCurrentPrecision").get();
    }

    /**
    * Gets the period for a specific subscription.
    * 
    * @param name  Name of the module which has subscribed.
    * @return Refresh period (in milliseconds).
    */
    public Integer getMyPeriod(String name) throws CallError, InterruptedException {
        return (Integer)call("getMyPeriod", name).get();
    }

    /**
    * Gets the precision for a specific subscription.
    * 
    * @param name  name of the module which has subscribed
    * @return precision of the extractor
    */
    public Float getMyPrecision(String name) throws CallError, InterruptedException {
        return (Float)call("getMyPrecision", name).get();
    }

    /**
    * Gets the parameters given by the module.
    * 
    * @return Array of names and parameters of all subscribers.
    */
    public Object getSubscribersInfo() throws CallError, InterruptedException {
        return (Object)call("getSubscribersInfo").get();
    }

    /**
    * Get the list of values updated in ALMemory.
    * 
    * @return Array of values updated by this extractor in ALMemory
    */
    public List<String> getOutputNames() throws CallError, InterruptedException {
        return (List<String>)call("getOutputNames").get();
    }

    /**
    * Get the list of events updated in ALMemory.
    * 
    * @return Array of events updated by this extractor in ALMemory
    */
    public List<String> getEventList() throws CallError, InterruptedException {
        return (List<String>)call("getEventList").get();
    }

    /**
    * Get the list of events updated in ALMemory.
    * 
    * @return Array of events updated by this extractor in ALMemory
    */
    public List<String> getMemoryKeyList() throws CallError, InterruptedException {
        return (List<String>)call("getMemoryKeyList").get();
    }

    /**
    * Sets the extractor framerate for a chosen subscriber
    * 
    * @param subscriberName  Name of the subcriber
    * @param framerate  New framerate
    * @return True if the update succeeded, False if not
    */
    public Boolean setFrameRate(String subscriberName, Integer framerate) throws CallError, InterruptedException {
        return (Boolean)call("setFrameRate", subscriberName, framerate).get();
    }

    /**
    * Sets the extractor framerate for all the subscribers
    * 
    * @param framerate  New framerate
    * @return True if the update succeeded, False if not
    */
    public Boolean setFrameRate(Integer framerate) throws CallError, InterruptedException {
        return (Boolean)call("setFrameRate", framerate).get();
    }

}
    