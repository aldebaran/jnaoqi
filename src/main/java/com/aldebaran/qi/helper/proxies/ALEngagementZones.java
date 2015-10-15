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
* This module enables to compue the engagement zones of detected people or detected movements
* @see <a href="http://doc.aldebaran.lan/doc/release-2.3/aldeb-doc/naoqi/peopleperception/alengagementzones.html#alengagementzones">NAOqi APIs for ALEngagementZones </a>
* NAOqi V2.3.x
*/
public class ALEngagementZones extends ALProxy {

    private AsyncALEngagementZones asyncProxy;

    public ALEngagementZones(Session session) throws Exception{
        super(session);
        asyncProxy = new AsyncALEngagementZones();
	    asyncProxy.setService(getService());
    }

    /**
     * Get the async version of this proxy
     *
	 * @return a AsyncALEngagementZones object
	 */
    public AsyncALEngagementZones async() {
        return asyncProxy;
    }

    /**
    * Get the first distance used for the delimitation of the engagement zones (nearest limit)
    * 
    * @return Current first distance (in meters) used for delimitation (nearest limit)
    */
    public Float getFirstLimitDistance() throws CallError, InterruptedException {
        return (Float)call("getFirstLimitDistance").get();
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
    * Get the angle used for the delimitation of the engagement zones
    * 
    * @return Current angle used for delimitation
    */
    public Float getLimitAngle() throws CallError, InterruptedException {
        return (Float)call("getLimitAngle").get();
    }

    /**
    * Set the first distance used for the delimitation of the engagement zones (nearest limit)
    * 
    * @param distance  New first distance (in meters) for delimitation (nearest limit), it should be positive and smaller than the second distance
    */
    public void setFirstLimitDistance(Float distance) throws CallError, InterruptedException{
        call("setFirstLimitDistance", distance).get();
    }

    /**
    * Set the second distance used for the delimitation of the engagement zones (furthest limit)
    * 
    * @param distance  New second distance (in meters) for delimitation (furthest limit), it should be positive and bigger than the first distance
    */
    public void setSecondLimitDistance(Float distance) throws CallError, InterruptedException{
        call("setSecondLimitDistance", distance).get();
    }

    /**
    * Get the second distance used for the delimitation of the engagement zones (furthest limit)
    * 
    * @return Current second distance (in meters) used for delimitation (furthest limit)
    */
    public Float getSecondLimitDistance() throws CallError, InterruptedException {
        return (Float)call("getSecondLimitDistance").get();
    }

    /**
    * Set the angle used for the delimitation of the engagement zones
    * 
    * @param angle  New angle (in degrees) for delimitation, it should be below 180
    */
    public void setLimitAngle(Float angle) throws CallError, InterruptedException{
        call("setLimitAngle", angle).get();
    }

    /**
    * Computes the engagement zone in which an object is from its position in FRAME_ROBOT
    * 
    * @param x  X coordinate of the object in FRAME_ROBOT
    * @param y  Y coordinate of the object in FRAME_ROBOT
    * @param z  Z coordinate of the object in FRAME_ROBOT
    * @return Engagement zone of the object
    */
    public Integer computeEngagementZone(Float x, Float y, Float z) throws CallError, InterruptedException {
        return (Integer)call("computeEngagementZone", x, y, z).get();
    }

    /**
    * Computes the engagement zone in which an object is from its anglular position in the camera image, its distance from the robot, and the position of the camera in FRAME_ROBOT
    * 
    * @param xAngle  X angular coordinate of the object in the image
    * @param yAngle  Y angular coordinate of the object in the image
    * @param distance  distance of the object from the robot
    * @param cameraPositionRobot  camera position in FRAME_ROBOT
    * @return Engagement zone of the object
    */
    public Integer computeEngagementZone(Float xAngle, Float yAngle, Float distance, Object cameraPositionRobot) throws CallError, InterruptedException {
        return (Integer)call("computeEngagementZone", xAngle, yAngle, distance, cameraPositionRobot).get();
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
    * Gets extractor pause status
    * 
    * @return True if the extractor is paused, False if not
    */
    public Boolean isPaused() throws CallError, InterruptedException {
        return (Boolean)call("isPaused").get();
    }

    /**
    * Changes the pause status of the extractor
    * 
    * @param status  New pause satus
    */
    public void pause(Boolean status) throws CallError, InterruptedException{
        call("pause", status).get();
    }


    public class AsyncALEngagementZones extends ALProxy {

        protected AsyncALEngagementZones(){
            super();
        }
    
    /**
    * Get the first distance used for the delimitation of the engagement zones (nearest limit)
    * 
    * @return Current first distance (in meters) used for delimitation (nearest limit)
    */
    public Future<Float> getFirstLimitDistance() throws CallError, InterruptedException {
        return call("getFirstLimitDistance");
    }

    /**
    * Gets extractor running status
    * 
    * @return True if the extractor is currently processing images, False if not
    */
    public Future<Boolean> isProcessing() throws CallError, InterruptedException {
        return call("isProcessing");
    }

    /**
    * Get the angle used for the delimitation of the engagement zones
    * 
    * @return Current angle used for delimitation
    */
    public Future<Float> getLimitAngle() throws CallError, InterruptedException {
        return call("getLimitAngle");
    }

    /**
    * Set the first distance used for the delimitation of the engagement zones (nearest limit)
    * 
    * @param distance  New first distance (in meters) for delimitation (nearest limit), it should be positive and smaller than the second distance
    * @return The Future
    */
    public Future<Void> setFirstLimitDistance(Float distance) throws CallError, InterruptedException{
        return call("setFirstLimitDistance", distance);
    }

    /**
    * Set the second distance used for the delimitation of the engagement zones (furthest limit)
    * 
    * @param distance  New second distance (in meters) for delimitation (furthest limit), it should be positive and bigger than the first distance
    * @return The Future
    */
    public Future<Void> setSecondLimitDistance(Float distance) throws CallError, InterruptedException{
        return call("setSecondLimitDistance", distance);
    }

    /**
    * Get the second distance used for the delimitation of the engagement zones (furthest limit)
    * 
    * @return Current second distance (in meters) used for delimitation (furthest limit)
    */
    public Future<Float> getSecondLimitDistance() throws CallError, InterruptedException {
        return call("getSecondLimitDistance");
    }

    /**
    * Set the angle used for the delimitation of the engagement zones
    * 
    * @param angle  New angle (in degrees) for delimitation, it should be below 180
    * @return The Future
    */
    public Future<Void> setLimitAngle(Float angle) throws CallError, InterruptedException{
        return call("setLimitAngle", angle);
    }

    /**
    * Computes the engagement zone in which an object is from its position in FRAME_ROBOT
    * 
    * @param x  X coordinate of the object in FRAME_ROBOT
    * @param y  Y coordinate of the object in FRAME_ROBOT
    * @param z  Z coordinate of the object in FRAME_ROBOT
    * @return Engagement zone of the object
    */
    public Future<Integer> computeEngagementZone(Float x, Float y, Float z) throws CallError, InterruptedException {
        return call("computeEngagementZone", x, y, z);
    }

    /**
    * Computes the engagement zone in which an object is from its anglular position in the camera image, its distance from the robot, and the position of the camera in FRAME_ROBOT
    * 
    * @param xAngle  X angular coordinate of the object in the image
    * @param yAngle  Y angular coordinate of the object in the image
    * @param distance  distance of the object from the robot
    * @param cameraPositionRobot  camera position in FRAME_ROBOT
    * @return Engagement zone of the object
    */
    public Future<Integer> computeEngagementZone(Float xAngle, Float yAngle, Float distance, Object cameraPositionRobot) throws CallError, InterruptedException {
        return call("computeEngagementZone", xAngle, yAngle, distance, cameraPositionRobot);
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
    * Subscribes to the extractor. This causes the extractor to start writing information to memory using the keys described by getOutputNames(). These can be accessed in memory using ALMemory.getData("keyName"). In many cases you can avoid calling subscribe on the extractor by just calling ALMemory.subscribeToEvent() supplying a callback method. This will automatically subscribe to the extractor for you.
    * 
    * @param name  Name of the module which subscribes.
    * @param period  Refresh period (in milliseconds) if relevant.
    * @param precision  Precision of the extractor if relevant.
    * @return The Future
    */
    public Future<Void> subscribe(String name, Integer period, Float precision) throws CallError, InterruptedException{
        return call("subscribe", name, period, precision);
    }

    /**
    * Subscribes to the extractor. This causes the extractor to start writing information to memory using the keys described by getOutputNames(). These can be accessed in memory using ALMemory.getData("keyName"). In many cases you can avoid calling subscribe on the extractor by just calling ALMemory.subscribeToEvent() supplying a callback method. This will automatically subscribe to the extractor for you.
    * 
    * @param name  Name of the module which subscribes.
    * @return The Future
    */
    public Future<Void> subscribe(String name) throws CallError, InterruptedException{
        return call("subscribe", name);
    }

    /**
    * Unsubscribes from the extractor.
    * 
    * @param name  Name of the module which had subscribed.
    * @return The Future
    */
    public Future<Void> unsubscribe(String name) throws CallError, InterruptedException{
        return call("unsubscribe", name);
    }

    /**
    * Updates the period if relevant.
    * 
    * @param name  Name of the module which has subscribed.
    * @param period  Refresh period (in milliseconds).
    * @return The Future
    */
    public Future<Void> updatePeriod(String name, Integer period) throws CallError, InterruptedException{
        return call("updatePeriod", name, period);
    }

    /**
    * Updates the precision if relevant.
    * 
    * @param name  Name of the module which has subscribed.
    * @param precision  Precision of the extractor.
    * @return The Future
    */
    public Future<Void> updatePrecision(String name, Float precision) throws CallError, InterruptedException{
        return call("updatePrecision", name, precision);
    }

    /**
    * Gets the current period.
    * 
    * @return Refresh period (in milliseconds).
    */
    public Future<Integer> getCurrentPeriod() throws CallError, InterruptedException {
        return call("getCurrentPeriod");
    }

    /**
    * Gets the current precision.
    * 
    * @return Precision of the extractor.
    */
    public Future<Float> getCurrentPrecision() throws CallError, InterruptedException {
        return call("getCurrentPrecision");
    }

    /**
    * Gets the period for a specific subscription.
    * 
    * @param name  Name of the module which has subscribed.
    * @return Refresh period (in milliseconds).
    */
    public Future<Integer> getMyPeriod(String name) throws CallError, InterruptedException {
        return call("getMyPeriod", name);
    }

    /**
    * Gets the precision for a specific subscription.
    * 
    * @param name  name of the module which has subscribed
    * @return precision of the extractor
    */
    public Future<Float> getMyPrecision(String name) throws CallError, InterruptedException {
        return call("getMyPrecision", name);
    }

    /**
    * Gets the parameters given by the module.
    * 
    * @return Array of names and parameters of all subscribers.
    */
    public Future<Object> getSubscribersInfo() throws CallError, InterruptedException {
        return call("getSubscribersInfo");
    }

    /**
    * Get the list of values updated in ALMemory.
    * 
    * @return Array of values updated by this extractor in ALMemory
    */
    public Future<List<String>> getOutputNames() throws CallError, InterruptedException {
        return call("getOutputNames");
    }

    /**
    * Get the list of events updated in ALMemory.
    * 
    * @return Array of events updated by this extractor in ALMemory
    */
    public Future<List<String>> getEventList() throws CallError, InterruptedException {
        return call("getEventList");
    }

    /**
    * Get the list of events updated in ALMemory.
    * 
    * @return Array of events updated by this extractor in ALMemory
    */
    public Future<List<String>> getMemoryKeyList() throws CallError, InterruptedException {
        return call("getMemoryKeyList");
    }

    /**
    * Gets extractor pause status
    * 
    * @return True if the extractor is paused, False if not
    */
    public Future<Boolean> isPaused() throws CallError, InterruptedException {
        return call("isPaused");
    }

    /**
    * Changes the pause status of the extractor
    * 
    * @param status  New pause satus
    * @return The Future
    */
    public Future<Void> pause(Boolean status) throws CallError, InterruptedException{
        return call("pause", status);
    }

    }
}
    