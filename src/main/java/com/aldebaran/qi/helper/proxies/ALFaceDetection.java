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
* @see <a href="http://doc.aldebaran.lan/doc/release-2.3/aldeb-doc/naoqi/peopleperception/alfacedetection.html#alfacedetection">NAOqi APIs for ALFaceDetection </a>
* NAOqi V2.3.x
*/
public class ALFaceDetection extends ALProxy {

    private AsyncALFaceDetection asyncProxy;

    public ALFaceDetection(Session session) throws Exception{
        super(session);
        asyncProxy = new AsyncALFaceDetection();
	    asyncProxy.setService(getService());
    }

    /**
     * Get the async version of this proxy
     *
	 * @return a AsyncALFaceDetection object
	 */
    public AsyncALFaceDetection async() {
        return asyncProxy;
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
    * enable/disable the recognition stageProcess will be faster when disabled when you don't need to recognize people
    * 
    * @param enable  True/False
    */
    public void setRecognitionEnabled(Boolean enable) throws CallError, InterruptedException{
        call("setRecognitionEnabled", enable).get();
    }

    /**
    * Returns if recognition is enabled.
    * 
    * @return True/False
    */
    public Boolean isRecognitionEnabled() throws CallError, InterruptedException {
        return (Boolean)call("isRecognitionEnabled").get();
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
    * (BETA) Choose to enable or disable tracking. Enabling tracking usually allows you to follow a face for a longer period of time. However, it can lead to more false detections. 
    * 
    * @param enable  True/False
    */
    public void setTrackingEnabled(Boolean enable) throws CallError, InterruptedException{
        call("setTrackingEnabled", enable).get();
    }

    /**
    * (BETA) Returns if tracking is enabled.
    * 
    * @return True/False
    */
    public Boolean isTrackingEnabled() throws CallError, InterruptedException {
        return (Boolean)call("isTrackingEnabled").get();
    }

    /**
    * Add a new face in the database.
    * 
    * @param pId  The name of the person to save
    * @return true if the operation succeeds
    */
    public Boolean learnFace(String pId) throws CallError, InterruptedException {
        return (Boolean)call("learnFace", pId).get();
    }

    /**
    * use in a new learning process the latest images where a face has been wrongly recognized 
    * 
    * @param pId  The name of the person to save
    * @return true if the operation succeeds
    */
    public Boolean reLearnFace(String pId) throws CallError, InterruptedException {
        return (Boolean)call("reLearnFace", pId).get();
    }

    /**
    * Delete from the database all faces instances of a person.
    * 
    * @param pId  The name of the person to forget
    * @return true if the operation succeeds
    */
    public Boolean forgetPerson(String pId) throws CallError, InterruptedException {
        return (Boolean)call("forgetPerson", pId).get();
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
    * Imports the content of an old face reco DB
    * 
    * @param policy  Merging policy if an imported entry has the same name as an existing one.
It can be either:
"overwrite" to replace the existing entry by the imported one,
"merge" to merge data from both entries (if they don't relate to the same person, face recognition may fail),
"keep" to keep the existing entry and skip the imported one.
    * @return True if the import succeeded, false otherwise.
    */
    public Boolean importOldDatabase(String policy) throws CallError, InterruptedException {
        return (Boolean)call("importOldDatabase", policy).get();
    }

    /**
    * Returns the list of learned faces.
    * 
    * @return List of names
    */
    public Object getLearnedFacesList() throws CallError, InterruptedException {
        return (Object)call("getLearnedFacesList").get();
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
    * deprecated
    * 
    * @param enable  True/False
    */
    public void enableRecognition(Boolean enable) throws CallError, InterruptedException{
        call("enableRecognition", enable).get();
    }

    /**
    * Remove all faces from the database.
    * 
    * @return true if the operation succeeds
    */
    public Boolean clearDatabase() throws CallError, InterruptedException {
        return (Boolean)call("clearDatabase").get();
    }

    /**
    * deprecated
    * 
    * @param enable  True/False
    */
    public void enableTracking(Boolean enable) throws CallError, InterruptedException{
        call("enableTracking", enable).get();
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


    public class AsyncALFaceDetection extends ALProxy {

        protected AsyncALFaceDetection(){
            super();
        }
    
    /**
    * Gets extractor resolution
    * 
    * @return Current value of the resolution of the extractor
    */
    public Future<Integer> getResolution() throws CallError, InterruptedException {
        return call("getResolution");
    }

    /**
    * Sets extractor resolution
    * 
    * @param resolution  New resolution
    * @return True if the update succeeded, False if not
    */
    public Future<Boolean> setResolution(Integer resolution) throws CallError, InterruptedException {
        return call("setResolution", resolution);
    }

    /**
    * enable/disable the recognition stageProcess will be faster when disabled when you don't need to recognize people
    * 
    * @param enable  True/False
    * @return The Future
    */
    public Future<Void> setRecognitionEnabled(Boolean enable) throws CallError, InterruptedException{
        return call("setRecognitionEnabled", enable);
    }

    /**
    * Returns if recognition is enabled.
    * 
    * @return True/False
    */
    public Future<Boolean> isRecognitionEnabled() throws CallError, InterruptedException {
        return call("isRecognitionEnabled");
    }

    /**
    * DEPRECATED: Sets pause and resolution
    * 
    * @param paramName  Name of the parameter to set
    * @param value  New value
    * @return The Future
    */
    public Future<Void> setParameter(String paramName, Object value) throws CallError, InterruptedException{
        return call("setParameter", paramName, value);
    }

    /**
    * (BETA) Choose to enable or disable tracking. Enabling tracking usually allows you to follow a face for a longer period of time. However, it can lead to more false detections. 
    * 
    * @param enable  True/False
    * @return The Future
    */
    public Future<Void> setTrackingEnabled(Boolean enable) throws CallError, InterruptedException{
        return call("setTrackingEnabled", enable);
    }

    /**
    * (BETA) Returns if tracking is enabled.
    * 
    * @return True/False
    */
    public Future<Boolean> isTrackingEnabled() throws CallError, InterruptedException {
        return call("isTrackingEnabled");
    }

    /**
    * Add a new face in the database.
    * 
    * @param pId  The name of the person to save
    * @return true if the operation succeeds
    */
    public Future<Boolean> learnFace(String pId) throws CallError, InterruptedException {
        return call("learnFace", pId);
    }

    /**
    * use in a new learning process the latest images where a face has been wrongly recognized 
    * 
    * @param pId  The name of the person to save
    * @return true if the operation succeeds
    */
    public Future<Boolean> reLearnFace(String pId) throws CallError, InterruptedException {
        return call("reLearnFace", pId);
    }

    /**
    * Delete from the database all faces instances of a person.
    * 
    * @param pId  The name of the person to forget
    * @return true if the operation succeeds
    */
    public Future<Boolean> forgetPerson(String pId) throws CallError, InterruptedException {
        return call("forgetPerson", pId);
    }

    /**
    * Gets extractor framerate
    * 
    * @return Current value of the framerate of the extractor
    */
    public Future<Integer> getFrameRate() throws CallError, InterruptedException {
        return call("getFrameRate");
    }

    /**
    * Imports the content of an old face reco DB
    * 
    * @param policy  Merging policy if an imported entry has the same name as an existing one.
It can be either:
"overwrite" to replace the existing entry by the imported one,
"merge" to merge data from both entries (if they don't relate to the same person, face recognition may fail),
"keep" to keep the existing entry and skip the imported one.
    * @return True if the import succeeded, false otherwise.
    */
    public Future<Boolean> importOldDatabase(String policy) throws CallError, InterruptedException {
        return call("importOldDatabase", policy);
    }

    /**
    * Returns the list of learned faces.
    * 
    * @return List of names
    */
    public Future<Object> getLearnedFacesList() throws CallError, InterruptedException {
        return call("getLearnedFacesList");
    }

    /**
    * Gets extractor active camera
    * 
    * @return Id of the current active camera of the extractor
    */
    public Future<Integer> getActiveCamera() throws CallError, InterruptedException {
        return call("getActiveCamera");
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
    * Sets extractor active camera
    * 
    * @param cameraId  Id of the camera that will become the active camera
    * @return True if the update succeeded, False if not
    */
    public Future<Boolean> setActiveCamera(Integer cameraId) throws CallError, InterruptedException {
        return call("setActiveCamera", cameraId);
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
    * Changes the pause status of the extractor
    * 
    * @param paused  New pause satus
    * @return The Future
    */
    public Future<Void> pause(Boolean paused) throws CallError, InterruptedException{
        return call("pause", paused);
    }

    /**
    * deprecated
    * 
    * @param enable  True/False
    * @return The Future
    */
    public Future<Void> enableRecognition(Boolean enable) throws CallError, InterruptedException{
        return call("enableRecognition", enable);
    }

    /**
    * Remove all faces from the database.
    * 
    * @return true if the operation succeeds
    */
    public Future<Boolean> clearDatabase() throws CallError, InterruptedException {
        return call("clearDatabase");
    }

    /**
    * deprecated
    * 
    * @param enable  True/False
    * @return The Future
    */
    public Future<Void> enableTracking(Boolean enable) throws CallError, InterruptedException{
        return call("enableTracking", enable);
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
    * Sets the extractor framerate for a chosen subscriber
    * 
    * @param subscriberName  Name of the subcriber
    * @param framerate  New framerate
    * @return True if the update succeeded, False if not
    */
    public Future<Boolean> setFrameRate(String subscriberName, Integer framerate) throws CallError, InterruptedException {
        return call("setFrameRate", subscriberName, framerate);
    }

    /**
    * Sets the extractor framerate for all the subscribers
    * 
    * @param framerate  New framerate
    * @return True if the update succeeded, False if not
    */
    public Future<Boolean> setFrameRate(Integer framerate) throws CallError, InterruptedException {
        return call("setFrameRate", framerate);
    }

    }
}
    