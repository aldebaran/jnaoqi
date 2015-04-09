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
* Use ALTracker module to make the robot track an object or a person with head and arms or not.
* @see <a href="http://doc.aldebaran.com/2-1/naoqi/trackers/altracker.html#altracker">NAOqi APIs for ALTracker </a>
*
*/
public class ALTracker extends ALProxy {

    private AsyncALTracker asyncProxy;

    public ALTracker(Session session) throws Exception{
        super(session);
        asyncProxy = new AsyncALTracker();
	    asyncProxy.setService(getService());
    }

    /**
     * Get the async version of this proxy
     *
	 * @return a AsyncALTracker object
	 */
    public AsyncALTracker async() {
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
    * Returns the [x, y, z] position of the target in FRAME_TORSO. This is done assuming an average target size, so it might not be very accurate.
    * 
    * @param pFrame  target frame {FRAME_TORSO = 0, FRAME_WORLD = 1, FRAME_ROBOT = 2}.
    * @return Vector of 3 floats corresponding to the target position 3D. 
    */
    public List<Float> getTargetPosition(Integer pFrame) throws CallError, InterruptedException {
        return (List<Float>)call("getTargetPosition", pFrame).get();
    }

    /**
    * Only work with LandMarks target name. Returns the [x, y, z, wx, wy, wz] position of the robot in coordinate system setted with setMap API. This is done assuming an average target size, so it might not be very accurate.
    * 
    * @return Vector of 6 floats corresponding to the robot position 6D.
    */
    public List<Float> getRobotPosition() throws CallError, InterruptedException {
        return (List<Float>)call("getRobotPosition").get();
    }

    /**
    * Return true if Tracker is running.
    * 
    * @return True if Tracker is running.
    */
    public Boolean isActive() throws CallError, InterruptedException {
        return (Boolean)call("isActive").get();
    }

    /**
    * Return true if a new target was detected.
    * 
    * @return True if a new target was detected since the last getTargetPosition().
    */
    public Boolean isNewTargetDetected() throws CallError, InterruptedException {
        return (Boolean)call("isNewTargetDetected").get();
    }

    /**
    * Set the robot position relative to target in Move mode.
    * 
    * @param target  Set the final goal of the tracking. Could be [distance, thresholdX, thresholdY] or with LandMarks target name [coordX, coordY, coordWz, thresholdX, thresholdY, thresholdWz].
    */
    public void setRelativePosition(Object target) throws CallError, InterruptedException{
        call("setRelativePosition", target).get();
    }

    /**
    * Get the robot position relative to target in Move mode.
    * 
    * @return The final goal of the tracking. Could be [distance, thresholdX, thresholdY] or with LandMarks target name [coordX, coordY, coordWz, thresholdX, thresholdY, thresholdWz].
    */
    public Object getRelativePosition() throws CallError, InterruptedException {
        return (Object)call("getRelativePosition").get();
    }

    /**
    * Only work with LandMarks target name. Set objects coordinates. Could be [[first object coordinate], [second object coordinate]] [[x1, y1, z1], [x2, y2, z2]]
    * 
    * @param pCoord  objects coordinates.
    */
    public void setTargetCoordinates(Object pCoord) throws CallError, InterruptedException{
        call("setTargetCoordinates", pCoord).get();
    }

    /**
    * Only work with LandMarks target name. Get objects coordinates. Could be [[first object coordinate], [second object coordinate]] [[x1, y1, z1], [x2, y2, z2]]
    * 
    * @return objects coordinates.
    */
    public Object getTargetCoordinates() throws CallError, InterruptedException {
        return (Object)call("getTargetCoordinates").get();
    }

    /**
    * Set the tracker in the predefined mode.Could be "Head", "WholeBody" or "Move".
    * 
    * @param pMode  a predefined mode.
    */
    public void setMode(String pMode) throws CallError, InterruptedException{
        call("setMode", pMode).get();
    }

    /**
    * Get the tracker current mode.
    * 
    * @return The current tracker mode.
    */
    public String getMode() throws CallError, InterruptedException {
        return (String)call("getMode").get();
    }

    /**
    * Get the list of predefined mode.
    * 
    * @return List of predefined mode.
    */
    public List<String> getAvailableModes() throws CallError, InterruptedException {
        return (List<String>)call("getAvailableModes").get();
    }

    /**
    * Enables/disables the target search process. Target search process occurs only when the target is lost.
    * 
    * @param pSearch  If true and if the target is lost, the robot moves the head in order to find the target. If false and if the target is lost the robot does not move.
    */
    public void toggleSearch(Boolean pSearch) throws CallError, InterruptedException{
        call("toggleSearch", pSearch).get();
    }

    /**
    * Return true if the target search process is enabled.
    * 
    * @return If true the target search process is enabled.
    */
    public Boolean isSearchEnabled() throws CallError, InterruptedException {
        return (Boolean)call("isSearchEnabled").get();
    }

    /**
    * Stop the tracker.
    * 
    */
    public void stopTracker() throws CallError, InterruptedException{
        call("stopTracker").get();
    }

    /**
    * Return true if the target was lost.
    * 
    * @return True if the target was lost.
    */
    public Boolean isTargetLost() throws CallError, InterruptedException {
        return (Boolean)call("isTargetLost").get();
    }

    /**
    * Set the predefided target to track and start the tracking process if not started.
    * 
    * @param pTarget  a predefined target to track.Could be "RedBall", "Face", "LandMark", "LandMarks", "People" or "Sound".
    */
    public void track(String pTarget) throws CallError, InterruptedException{
        call("track", pTarget).get();
    }

    /**
    * Track event and start the tracking process if not started.
    * 
    * @param pEventName  a event name to track.
    */
    public void trackEvent(String pEventName) throws CallError, InterruptedException{
        call("trackEvent", pEventName).get();
    }

    /**
    * Register a predefined target. Subscribe to corresponding extractor if Tracker is running..
    * 
    * @param pTarget  a predefined target to track.Could be "RedBall", "Face", "LandMark", "LandMarks", "People" or "Sound".
    * @param pParams  a target parameters. (RedBall : set diameter of ball.
    */
    public void registerTarget(String pTarget, Object pParams) throws CallError, InterruptedException{
        call("registerTarget", pTarget, pParams).get();
    }

    /**
    * Set a period for the corresponding target name extractor.
    * 
    * @param pTarget  a predefined target name.Could be "RedBall", "Face", "LandMark", "LandMarks", "People" or "Sound".
    * @param pPeriod  a period in milliseconds
    */
    public void setExtractorPeriod(String pTarget, Integer pPeriod) throws CallError, InterruptedException{
        call("setExtractorPeriod", pTarget, pPeriod).get();
    }

    /**
    * Get the period of corresponding target name extractor.
    * 
    * @param pTarget  a predefined target name.Could be "RedBall", "Face", "LandMark", "LandMarks", "People" or "Sound".
    * @return a period in milliseconds
    */
    public Integer getExtractorPeriod(String pTarget) throws CallError, InterruptedException {
        return (Integer)call("getExtractorPeriod", pTarget).get();
    }

    /**
    * Unregister target name and stop corresponding extractor.
    * 
    * @param pTarget  a predefined target to remove.Could be "RedBall", "Face", "LandMark", "LandMarks", "People" or "Sound".
    */
    public void unregisterTarget(String pTarget) throws CallError, InterruptedException{
        call("unregisterTarget", pTarget).get();
    }

    /**
    * Unregister a list of target names and stop corresponding extractor.
    * 
    * @param pTarget  a predefined target list to remove.Could be "RedBall", "Face", "LandMark", "LandMarks", "People" or "Sound".
    */
    public void unregisterTargets(List<String> pTarget) throws CallError, InterruptedException{
        call("unregisterTargets", pTarget).get();
    }

    /**
    * Unregister all targets except active target and stop corresponding extractor.
    * 
    */
    public void unregisterAllTargets() throws CallError, InterruptedException{
        call("unregisterAllTargets").get();
    }

    /**
    * Return active target name.
    * 
    * @return Tracked target name.
    */
    public String getActiveTarget() throws CallError, InterruptedException {
        return (String)call("getActiveTarget").get();
    }

    /**
    * Return a list of supported targets names.
    * 
    * @return Supported targets names.
    */
    public List<String> getSupportedTargets() throws CallError, InterruptedException {
        return (List<String>)call("getSupportedTargets").get();
    }

    /**
    * Return a list of registered targets names.
    * 
    * @return Registered targets names.
    */
    public List<String> getRegisteredTargets() throws CallError, InterruptedException {
        return (List<String>)call("getRegisteredTargets").get();
    }

    /**
    * Look at the target position with head.

    * 
    * @param pPosition  position 3D [x, y, z] x position must be striclty positif.
    * @param pFrame  target frame {FRAME_TORSO = 0, FRAME_WORLD = 1, FRAME_ROBOT = 2}.
    * @param pFractionMaxSpeed  The fraction of maximum speed to use. Must be between 0 and 1.
    * @param pUseWholeBody  If true, use whole body constraints.
    */
    public void lookAt(List<Float> pPosition, Integer pFrame, Float pFractionMaxSpeed, Boolean pUseWholeBody) throws CallError, InterruptedException{
        call("lookAt", pPosition, pFrame, pFractionMaxSpeed, pUseWholeBody).get();
    }

    /**
    * Point at the target position with arms.

    * 
    * @param pEffector  effector name. Could be "Arms", "LArm", "RArm".
    * @param pPosition  position 3D [x, y, z] to point in FRAME_TORSO. x position must be striclty positif.
    * @param pFrame  target frame {FRAME_TORSO = 0, FRAME_WORLD = 1, FRAME_ROBOT = 2}.
    * @param pFractionMaxSpeed  The fraction of maximum speed to use. Must be between 0 and 1.
    */
    public void pointAt(String pEffector, List<Float> pPosition, Integer pFrame, Float pFractionMaxSpeed) throws CallError, InterruptedException{
        call("pointAt", pEffector, pPosition, pFrame, pFractionMaxSpeed).get();
    }

    /**
    * Get the config for move modes.
    * 
    * @return ALMotion GaitConfig
    */
    public Object getMoveConfig() throws CallError, InterruptedException {
        return (Object)call("getMoveConfig").get();
    }

    /**
    * set a config for move modes.
    * 
    * @param config  ALMotion GaitConfig
    */
    public void setMoveConfig(Object config) throws CallError, InterruptedException{
        call("setMoveConfig", config).get();
    }

    /**
    * get the timeout parameter for target lost.
    * 
    * @return time in milliseconds.
    */
    public Integer getTimeOut() throws CallError, InterruptedException {
        return (Integer)call("getTimeOut").get();
    }

    /**
    * set the timeout parameter for target lost.
    * 
    * @param pTimeMs  time in milliseconds.
    */
    public void setTimeOut(Integer pTimeMs) throws CallError, InterruptedException{
        call("setTimeOut", pTimeMs).get();
    }

    /**
    * get the maximum distance for target detection in meter.
    * 
    * @return The maximum distance for target detection in meter.
    */
    public Float getMaximumDistanceDetection() throws CallError, InterruptedException {
        return (Float)call("getMaximumDistanceDetection").get();
    }

    /**
    * set the maximum target detection distance in meter.
    * 
    * @param pMaxDistance  The maximum distance for target detection in meter.
    */
    public void setMaximumDistanceDetection(Float pMaxDistance) throws CallError, InterruptedException{
        call("setMaximumDistanceDetection", pMaxDistance).get();
    }

    /**
    * Get active effector.
    * 
    * @return Active effector name. Could be: "Arms", "LArm", "RArm" or "None". 
    */
    public String getEffector() throws CallError, InterruptedException {
        return (String)call("getEffector").get();
    }

    /**
    * Set an end-effector to move for tracking.
    * 
    * @param pEffector  Name of effector. Could be: "Arms", "LArm", "RArm" or "None". 
    */
    public void setEffector(String pEffector) throws CallError, InterruptedException{
        call("setEffector", pEffector).get();
    }

    /**
    * DEPRECATED. Use lookAt with frame instead. Look at the target position with head.

    * 
    * @param pPosition  position 3D [x, y, z] to look in FRAME_TORSO. x position must be striclty positif.
    * @param pFractionMaxSpeed  The fraction of maximum speed to use. Must be between 0 and 1.
    * @param pUseWholeBody  If true, use whole body constraints.
    */
    public void lookAt(List<Float> pPosition, Float pFractionMaxSpeed, Boolean pUseWholeBody) throws CallError, InterruptedException{
        call("lookAt", pPosition, pFractionMaxSpeed, pUseWholeBody).get();
    }

    /**
    * DEPRECATED. Use pointAt with frame instead. Point at the target position with arms.

    * 
    * @param pEffector  effector name. Could be "Arms", "LArm", "RArm".
    * @param pPosition  position 3D [x, y, z] to point in FRAME_TORSO. x position must be striclty positif.
    * @param pFractionMaxSpeed  The fraction of maximum speed to use. Must be between 0 and 1.
    */
    public void pointAt(String pEffector, List<Float> pPosition, Float pFractionMaxSpeed) throws CallError, InterruptedException{
        call("pointAt", pEffector, pPosition, pFractionMaxSpeed).get();
    }

    /**
    * DEPRECATED. Use pointAt with frame instead. Returns the [x, y, z] position of the target in FRAME_TORSO. This is done assuming an average target size, so it might not be very accurate.
    * 
    * @return Vector of 3 floats corresponding to the target position 3D. 
    */
    public List<Float> getTargetPosition() throws CallError, InterruptedException {
        return (List<Float>)call("getTargetPosition").get();
    }

    /**
    * DEPRECATED. Use getSupportedTargets() instead. Return a list of targets names.
    * 
    * @return Valid targets names.
    */
    public List<String> getTargetNames() throws CallError, InterruptedException {
        return (List<String>)call("getTargetNames").get();
    }

    /**
    * DEPRECATED. Use getRegisteredTargets() instead. Return a list of managed targets names.
    * 
    * @return Managed targets names.
    */
    public List<String> getManagedTargets() throws CallError, InterruptedException {
        return (List<String>)call("getManagedTargets").get();
    }

    /**
    * DEPRECATED. Use registerTarget() instead. Add a predefined target. Subscribe to corresponding extractor if Tracker is running..
    * 
    * @param pTarget  a predefined target to track.Could be "RedBall", "Face", "LandMark", "LandMarks", "People" or "Sound".
    * @param pParams  a target parameters. (RedBall : set diameter of ball.
    */
    public void addTarget(String pTarget, Object pParams) throws CallError, InterruptedException{
        call("addTarget", pTarget, pParams).get();
    }

    /**
    * DEPRECATED. Use unregisterTarget() instead. Remove target name and stop corresponding extractor.
    * 
    * @param pTarget  a predefined target to remove.Could be "RedBall", "Face", "LandMark", "LandMarks", "People" or "Sound".
    */
    public void removeTarget(String pTarget) throws CallError, InterruptedException{
        call("removeTarget", pTarget).get();
    }

    /**
    * DEPRECATED. Use unregisterTargets() instead. Remove a list of target names and stop corresponding extractor.
    * 
    * @param pTarget  a predefined target list to remove.Could be "RedBall", "Face", "LandMark", "LandMarks", "People" or "Sound".
    */
    public void removeTargets(List<String> pTarget) throws CallError, InterruptedException{
        call("removeTargets", pTarget).get();
    }

    /**
    * DEPRECATED. Use unregisterAllTargets() instead. Remove all managed targets except active target and stop corresponding extractor.
    * 
    */
    public void removeAllTargets() throws CallError, InterruptedException{
        call("removeAllTargets").get();
    }

    /**
    * DEPRECATED. Use setEffector instead. Add an end-effector to move for tracking.
    * 
    * @param pEffector  Name of effector. Could be: "Arms", "LArm" or "RArm". 
    */
    public void addEffector(String pEffector) throws CallError, InterruptedException{
        call("addEffector", pEffector).get();
    }

    /**
    * DEPRECATED. Use setEffector("None") instead. Remove an end-effector from tracking.
    * 
    * @param pEffector  Name of effector. Could be: "Arms", "LArm" or "RArm". 
    */
    public void removeEffector(String pEffector) throws CallError, InterruptedException{
        call("removeEffector", pEffector).get();
    }


    public class AsyncALTracker extends ALProxy {

        protected AsyncALTracker(){
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
    * Returns the [x, y, z] position of the target in FRAME_TORSO. This is done assuming an average target size, so it might not be very accurate.
    * 
    * @param pFrame  target frame {FRAME_TORSO = 0, FRAME_WORLD = 1, FRAME_ROBOT = 2}.
    * @return Vector of 3 floats corresponding to the target position 3D. 
    */
    public Future<List<Float>> getTargetPosition(Integer pFrame) throws CallError, InterruptedException {
        return call("getTargetPosition", pFrame);
    }

    /**
    * Only work with LandMarks target name. Returns the [x, y, z, wx, wy, wz] position of the robot in coordinate system setted with setMap API. This is done assuming an average target size, so it might not be very accurate.
    * 
    * @return Vector of 6 floats corresponding to the robot position 6D.
    */
    public Future<List<Float>> getRobotPosition() throws CallError, InterruptedException {
        return call("getRobotPosition");
    }

    /**
    * Return true if Tracker is running.
    * 
    * @return True if Tracker is running.
    */
    public Future<Boolean> isActive() throws CallError, InterruptedException {
        return call("isActive");
    }

    /**
    * Return true if a new target was detected.
    * 
    * @return True if a new target was detected since the last getTargetPosition().
    */
    public Future<Boolean> isNewTargetDetected() throws CallError, InterruptedException {
        return call("isNewTargetDetected");
    }

    /**
    * Set the robot position relative to target in Move mode.
    * 
    * @param target  Set the final goal of the tracking. Could be [distance, thresholdX, thresholdY] or with LandMarks target name [coordX, coordY, coordWz, thresholdX, thresholdY, thresholdWz].
    * @return The Future
    */
    public Future<Void> setRelativePosition(Object target) throws CallError, InterruptedException{
        return call("setRelativePosition", target);
    }

    /**
    * Get the robot position relative to target in Move mode.
    * 
    * @return The final goal of the tracking. Could be [distance, thresholdX, thresholdY] or with LandMarks target name [coordX, coordY, coordWz, thresholdX, thresholdY, thresholdWz].
    */
    public Future<Object> getRelativePosition() throws CallError, InterruptedException {
        return call("getRelativePosition");
    }

    /**
    * Only work with LandMarks target name. Set objects coordinates. Could be [[first object coordinate], [second object coordinate]] [[x1, y1, z1], [x2, y2, z2]]
    * 
    * @param pCoord  objects coordinates.
    * @return The Future
    */
    public Future<Void> setTargetCoordinates(Object pCoord) throws CallError, InterruptedException{
        return call("setTargetCoordinates", pCoord);
    }

    /**
    * Only work with LandMarks target name. Get objects coordinates. Could be [[first object coordinate], [second object coordinate]] [[x1, y1, z1], [x2, y2, z2]]
    * 
    * @return objects coordinates.
    */
    public Future<Object> getTargetCoordinates() throws CallError, InterruptedException {
        return call("getTargetCoordinates");
    }

    /**
    * Set the tracker in the predefined mode.Could be "Head", "WholeBody" or "Move".
    * 
    * @param pMode  a predefined mode.
    * @return The Future
    */
    public Future<Void> setMode(String pMode) throws CallError, InterruptedException{
        return call("setMode", pMode);
    }

    /**
    * Get the tracker current mode.
    * 
    * @return The current tracker mode.
    */
    public Future<String> getMode() throws CallError, InterruptedException {
        return call("getMode");
    }

    /**
    * Get the list of predefined mode.
    * 
    * @return List of predefined mode.
    */
    public Future<List<String>> getAvailableModes() throws CallError, InterruptedException {
        return call("getAvailableModes");
    }

    /**
    * Enables/disables the target search process. Target search process occurs only when the target is lost.
    * 
    * @param pSearch  If true and if the target is lost, the robot moves the head in order to find the target. If false and if the target is lost the robot does not move.
    * @return The Future
    */
    public Future<Void> toggleSearch(Boolean pSearch) throws CallError, InterruptedException{
        return call("toggleSearch", pSearch);
    }

    /**
    * Return true if the target search process is enabled.
    * 
    * @return If true the target search process is enabled.
    */
    public Future<Boolean> isSearchEnabled() throws CallError, InterruptedException {
        return call("isSearchEnabled");
    }

    /**
    * Stop the tracker.
    * 
    * @return The Future
    */
    public Future<Void> stopTracker() throws CallError, InterruptedException{
        return call("stopTracker");
    }

    /**
    * Return true if the target was lost.
    * 
    * @return True if the target was lost.
    */
    public Future<Boolean> isTargetLost() throws CallError, InterruptedException {
        return call("isTargetLost");
    }

    /**
    * Set the predefided target to track and start the tracking process if not started.
    * 
    * @param pTarget  a predefined target to track.Could be "RedBall", "Face", "LandMark", "LandMarks", "People" or "Sound".
    * @return The Future
    */
    public Future<Void> track(String pTarget) throws CallError, InterruptedException{
        return call("track", pTarget);
    }

    /**
    * Track event and start the tracking process if not started.
    * 
    * @param pEventName  a event name to track.
    * @return The Future
    */
    public Future<Void> trackEvent(String pEventName) throws CallError, InterruptedException{
        return call("trackEvent", pEventName);
    }

    /**
    * Register a predefined target. Subscribe to corresponding extractor if Tracker is running..
    * 
    * @param pTarget  a predefined target to track.Could be "RedBall", "Face", "LandMark", "LandMarks", "People" or "Sound".
    * @param pParams  a target parameters. (RedBall : set diameter of ball.
    * @return The Future
    */
    public Future<Void> registerTarget(String pTarget, Object pParams) throws CallError, InterruptedException{
        return call("registerTarget", pTarget, pParams);
    }

    /**
    * Set a period for the corresponding target name extractor.
    * 
    * @param pTarget  a predefined target name.Could be "RedBall", "Face", "LandMark", "LandMarks", "People" or "Sound".
    * @param pPeriod  a period in milliseconds
    * @return The Future
    */
    public Future<Void> setExtractorPeriod(String pTarget, Integer pPeriod) throws CallError, InterruptedException{
        return call("setExtractorPeriod", pTarget, pPeriod);
    }

    /**
    * Get the period of corresponding target name extractor.
    * 
    * @param pTarget  a predefined target name.Could be "RedBall", "Face", "LandMark", "LandMarks", "People" or "Sound".
    * @return a period in milliseconds
    */
    public Future<Integer> getExtractorPeriod(String pTarget) throws CallError, InterruptedException {
        return call("getExtractorPeriod", pTarget);
    }

    /**
    * Unregister target name and stop corresponding extractor.
    * 
    * @param pTarget  a predefined target to remove.Could be "RedBall", "Face", "LandMark", "LandMarks", "People" or "Sound".
    * @return The Future
    */
    public Future<Void> unregisterTarget(String pTarget) throws CallError, InterruptedException{
        return call("unregisterTarget", pTarget);
    }

    /**
    * Unregister a list of target names and stop corresponding extractor.
    * 
    * @param pTarget  a predefined target list to remove.Could be "RedBall", "Face", "LandMark", "LandMarks", "People" or "Sound".
    * @return The Future
    */
    public Future<Void> unregisterTargets(List<String> pTarget) throws CallError, InterruptedException{
        return call("unregisterTargets", pTarget);
    }

    /**
    * Unregister all targets except active target and stop corresponding extractor.
    * 
    * @return The Future
    */
    public Future<Void> unregisterAllTargets() throws CallError, InterruptedException{
        return call("unregisterAllTargets");
    }

    /**
    * Return active target name.
    * 
    * @return Tracked target name.
    */
    public Future<String> getActiveTarget() throws CallError, InterruptedException {
        return call("getActiveTarget");
    }

    /**
    * Return a list of supported targets names.
    * 
    * @return Supported targets names.
    */
    public Future<List<String>> getSupportedTargets() throws CallError, InterruptedException {
        return call("getSupportedTargets");
    }

    /**
    * Return a list of registered targets names.
    * 
    * @return Registered targets names.
    */
    public Future<List<String>> getRegisteredTargets() throws CallError, InterruptedException {
        return call("getRegisteredTargets");
    }

    /**
    * Look at the target position with head.

    * 
    * @param pPosition  position 3D [x, y, z] x position must be striclty positif.
    * @param pFrame  target frame {FRAME_TORSO = 0, FRAME_WORLD = 1, FRAME_ROBOT = 2}.
    * @param pFractionMaxSpeed  The fraction of maximum speed to use. Must be between 0 and 1.
    * @param pUseWholeBody  If true, use whole body constraints.
    * @return The Future
    */
    public Future<Void> lookAt(List<Float> pPosition, Integer pFrame, Float pFractionMaxSpeed, Boolean pUseWholeBody) throws CallError, InterruptedException{
        return call("lookAt", pPosition, pFrame, pFractionMaxSpeed, pUseWholeBody);
    }

    /**
    * Point at the target position with arms.

    * 
    * @param pEffector  effector name. Could be "Arms", "LArm", "RArm".
    * @param pPosition  position 3D [x, y, z] to point in FRAME_TORSO. x position must be striclty positif.
    * @param pFrame  target frame {FRAME_TORSO = 0, FRAME_WORLD = 1, FRAME_ROBOT = 2}.
    * @param pFractionMaxSpeed  The fraction of maximum speed to use. Must be between 0 and 1.
    * @return The Future
    */
    public Future<Void> pointAt(String pEffector, List<Float> pPosition, Integer pFrame, Float pFractionMaxSpeed) throws CallError, InterruptedException{
        return call("pointAt", pEffector, pPosition, pFrame, pFractionMaxSpeed);
    }

    /**
    * Get the config for move modes.
    * 
    * @return ALMotion GaitConfig
    */
    public Future<Object> getMoveConfig() throws CallError, InterruptedException {
        return call("getMoveConfig");
    }

    /**
    * set a config for move modes.
    * 
    * @param config  ALMotion GaitConfig
    * @return The Future
    */
    public Future<Void> setMoveConfig(Object config) throws CallError, InterruptedException{
        return call("setMoveConfig", config);
    }

    /**
    * get the timeout parameter for target lost.
    * 
    * @return time in milliseconds.
    */
    public Future<Integer> getTimeOut() throws CallError, InterruptedException {
        return call("getTimeOut");
    }

    /**
    * set the timeout parameter for target lost.
    * 
    * @param pTimeMs  time in milliseconds.
    * @return The Future
    */
    public Future<Void> setTimeOut(Integer pTimeMs) throws CallError, InterruptedException{
        return call("setTimeOut", pTimeMs);
    }

    /**
    * get the maximum distance for target detection in meter.
    * 
    * @return The maximum distance for target detection in meter.
    */
    public Future<Float> getMaximumDistanceDetection() throws CallError, InterruptedException {
        return call("getMaximumDistanceDetection");
    }

    /**
    * set the maximum target detection distance in meter.
    * 
    * @param pMaxDistance  The maximum distance for target detection in meter.
    * @return The Future
    */
    public Future<Void> setMaximumDistanceDetection(Float pMaxDistance) throws CallError, InterruptedException{
        return call("setMaximumDistanceDetection", pMaxDistance);
    }

    /**
    * Get active effector.
    * 
    * @return Active effector name. Could be: "Arms", "LArm", "RArm" or "None". 
    */
    public Future<String> getEffector() throws CallError, InterruptedException {
        return call("getEffector");
    }

    /**
    * Set an end-effector to move for tracking.
    * 
    * @param pEffector  Name of effector. Could be: "Arms", "LArm", "RArm" or "None". 
    * @return The Future
    */
    public Future<Void> setEffector(String pEffector) throws CallError, InterruptedException{
        return call("setEffector", pEffector);
    }

    /**
    * DEPRECATED. Use lookAt with frame instead. Look at the target position with head.

    * 
    * @param pPosition  position 3D [x, y, z] to look in FRAME_TORSO. x position must be striclty positif.
    * @param pFractionMaxSpeed  The fraction of maximum speed to use. Must be between 0 and 1.
    * @param pUseWholeBody  If true, use whole body constraints.
    * @return The Future
    */
    public Future<Void> lookAt(List<Float> pPosition, Float pFractionMaxSpeed, Boolean pUseWholeBody) throws CallError, InterruptedException{
        return call("lookAt", pPosition, pFractionMaxSpeed, pUseWholeBody);
    }

    /**
    * DEPRECATED. Use pointAt with frame instead. Point at the target position with arms.

    * 
    * @param pEffector  effector name. Could be "Arms", "LArm", "RArm".
    * @param pPosition  position 3D [x, y, z] to point in FRAME_TORSO. x position must be striclty positif.
    * @param pFractionMaxSpeed  The fraction of maximum speed to use. Must be between 0 and 1.
    * @return The Future
    */
    public Future<Void> pointAt(String pEffector, List<Float> pPosition, Float pFractionMaxSpeed) throws CallError, InterruptedException{
        return call("pointAt", pEffector, pPosition, pFractionMaxSpeed);
    }

    /**
    * DEPRECATED. Use pointAt with frame instead. Returns the [x, y, z] position of the target in FRAME_TORSO. This is done assuming an average target size, so it might not be very accurate.
    * 
    * @return Vector of 3 floats corresponding to the target position 3D. 
    */
    public Future<List<Float>> getTargetPosition() throws CallError, InterruptedException {
        return call("getTargetPosition");
    }

    /**
    * DEPRECATED. Use getSupportedTargets() instead. Return a list of targets names.
    * 
    * @return Valid targets names.
    */
    public Future<List<String>> getTargetNames() throws CallError, InterruptedException {
        return call("getTargetNames");
    }

    /**
    * DEPRECATED. Use getRegisteredTargets() instead. Return a list of managed targets names.
    * 
    * @return Managed targets names.
    */
    public Future<List<String>> getManagedTargets() throws CallError, InterruptedException {
        return call("getManagedTargets");
    }

    /**
    * DEPRECATED. Use registerTarget() instead. Add a predefined target. Subscribe to corresponding extractor if Tracker is running..
    * 
    * @param pTarget  a predefined target to track.Could be "RedBall", "Face", "LandMark", "LandMarks", "People" or "Sound".
    * @param pParams  a target parameters. (RedBall : set diameter of ball.
    * @return The Future
    */
    public Future<Void> addTarget(String pTarget, Object pParams) throws CallError, InterruptedException{
        return call("addTarget", pTarget, pParams);
    }

    /**
    * DEPRECATED. Use unregisterTarget() instead. Remove target name and stop corresponding extractor.
    * 
    * @param pTarget  a predefined target to remove.Could be "RedBall", "Face", "LandMark", "LandMarks", "People" or "Sound".
    * @return The Future
    */
    public Future<Void> removeTarget(String pTarget) throws CallError, InterruptedException{
        return call("removeTarget", pTarget);
    }

    /**
    * DEPRECATED. Use unregisterTargets() instead. Remove a list of target names and stop corresponding extractor.
    * 
    * @param pTarget  a predefined target list to remove.Could be "RedBall", "Face", "LandMark", "LandMarks", "People" or "Sound".
    * @return The Future
    */
    public Future<Void> removeTargets(List<String> pTarget) throws CallError, InterruptedException{
        return call("removeTargets", pTarget);
    }

    /**
    * DEPRECATED. Use unregisterAllTargets() instead. Remove all managed targets except active target and stop corresponding extractor.
    * 
    * @return The Future
    */
    public Future<Void> removeAllTargets() throws CallError, InterruptedException{
        return call("removeAllTargets");
    }

    /**
    * DEPRECATED. Use setEffector instead. Add an end-effector to move for tracking.
    * 
    * @param pEffector  Name of effector. Could be: "Arms", "LArm" or "RArm". 
    * @return The Future
    */
    public Future<Void> addEffector(String pEffector) throws CallError, InterruptedException{
        return call("addEffector", pEffector);
    }

    /**
    * DEPRECATED. Use setEffector("None") instead. Remove an end-effector from tracking.
    * 
    * @param pEffector  Name of effector. Could be: "Arms", "LArm" or "RArm". 
    * @return The Future
    */
    public Future<Void> removeEffector(String pEffector) throws CallError, InterruptedException{
        return call("removeEffector", pEffector);
    }

    }
}
    