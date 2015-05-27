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
* ALMotionRecorder is a very specific module for real-time motion recording in Choregraphe. Users can get a simpler interface for motion recording by using the Animation Mode. ALMotionRecorder also supports recording modes using bumpers or torso button, and selective motion replay.
* @see <a href="http://doc.aldebaran.lan/doc/master/aldeb-doc/naoqi/motion/almotionrecorder.html#almotionrecorder">NAOqi APIs for ALMotionRecorder </a>
* NAOqi V2.4.x
*/
public class ALMotionRecorder extends ALProxy {

    private AsyncALMotionRecorder asyncProxy;

    public ALMotionRecorder(Session session) throws Exception{
        super(session);
        asyncProxy = new AsyncALMotionRecorder();
	    asyncProxy.setService(getService());
    }

    /**
     * Get the async version of this proxy
     *
	 * @return a AsyncALMotionRecorder object
	 */
    public AsyncALMotionRecorder async() {
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
    * Wait for the end of a long running method that was called using 'post', returns a cancelable future
    * 
    * @param id  The ID of the method that was returned when calling the method using 'post'
    */
    public void wait(Integer id) throws CallError, InterruptedException{
        call("wait", id).get();
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
    * Start recording the motion in an interactive mode
    * 
    * @param jointsToRecord  Names of joints that must be recorded
    * @param nbPoses  Default number of poses to record
    * @param extensionAllowed  Set to true to ignore nbPoses and keep recording new poses as long as record is not manually stopped
    * @param mode  Indicates which interactive mode must be used. 1 : Use right bumper to enslave and left bumper to store the pose  (deprecated); 2 : Use head tap to store the pose
    */
    public void startInteractiveRecording(List<String> jointsToRecord, Integer nbPoses, Boolean extensionAllowed, Integer mode) throws CallError, InterruptedException{
        call("startInteractiveRecording", jointsToRecord, nbPoses, extensionAllowed, mode).get();
    }

    /**
    * Start recording the motion in a periodic mode
    * 
    * @param jointsToRecord  Names of joints that must be recorded
    * @param nbPoses  Default number of poses to record
    * @param extensionAllowed  set to true to ignore nbPoses and keep recording new poses as long as record is not manually stopped
    * @param timeStep  Time in seconds to wait between two poses
    * @param jointsToReplay  Names of joints that must be replayed
    * @param replayData  An ALValue holding data for replayed joints. It holds two ALValues. The first one is an ALValue where each line corresponds to a joint, and column elements are times of control points The second one is also an ALValue where each line corresponds to a joint, but column elements are arrays containing [float angle, Handle1, Handle2] elements, where Handle is [int InterpolationType, float dAngle, float dTime] describing the handle offsets relative to the angle and time of the point. The first bezier param describes the handle that controls the curve preceding the point, the second describes the curve following the point.
    */
    public void startPeriodicRecording(List<String> jointsToRecord, Integer nbPoses, Boolean extensionAllowed, Float timeStep, List<String> jointsToReplay, Object replayData) throws CallError, InterruptedException{
        call("startPeriodicRecording", jointsToRecord, nbPoses, extensionAllowed, timeStep, jointsToReplay, replayData).get();
    }

    /**
    * Stop recording the motion and return data
    * 
    * @return Returns the recorded data as an ALValue: [[JointName1,[pos1, pos2, ...]], [JointName2,[pos1, pos2, ...]], ...]
    */
    public Object stopAndGetRecording() throws CallError, InterruptedException {
        return (Object)call("stopAndGetRecording").get();
    }

    /**
    * Called by ALMemory when subcription data is updated. INTERNAL
    * 
    * @param dataName  Name of the subscribed data.
    * @param data  Value of the the subscribed data
    * @param message  The message give when subscribing.
    */
    public void dataChanged(String dataName, Object data, String message) throws CallError, InterruptedException{
        call("dataChanged", dataName, data, message).get();
    }


    public class AsyncALMotionRecorder extends ALProxy {

        protected AsyncALMotionRecorder(){
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
    * Wait for the end of a long running method that was called using 'post', returns a cancelable future
    * 
    * @param id  The ID of the method that was returned when calling the method using 'post'
    * @return The Future
    */
    public Future<Void> wait(Integer id) throws CallError, InterruptedException{
        return call("wait", id);
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
    * Start recording the motion in an interactive mode
    * 
    * @param jointsToRecord  Names of joints that must be recorded
    * @param nbPoses  Default number of poses to record
    * @param extensionAllowed  Set to true to ignore nbPoses and keep recording new poses as long as record is not manually stopped
    * @param mode  Indicates which interactive mode must be used. 1 : Use right bumper to enslave and left bumper to store the pose  (deprecated); 2 : Use head tap to store the pose
    * @return The Future
    */
    public Future<Void> startInteractiveRecording(List<String> jointsToRecord, Integer nbPoses, Boolean extensionAllowed, Integer mode) throws CallError, InterruptedException{
        return call("startInteractiveRecording", jointsToRecord, nbPoses, extensionAllowed, mode);
    }

    /**
    * Start recording the motion in a periodic mode
    * 
    * @param jointsToRecord  Names of joints that must be recorded
    * @param nbPoses  Default number of poses to record
    * @param extensionAllowed  set to true to ignore nbPoses and keep recording new poses as long as record is not manually stopped
    * @param timeStep  Time in seconds to wait between two poses
    * @param jointsToReplay  Names of joints that must be replayed
    * @param replayData  An ALValue holding data for replayed joints. It holds two ALValues. The first one is an ALValue where each line corresponds to a joint, and column elements are times of control points The second one is also an ALValue where each line corresponds to a joint, but column elements are arrays containing [float angle, Handle1, Handle2] elements, where Handle is [int InterpolationType, float dAngle, float dTime] describing the handle offsets relative to the angle and time of the point. The first bezier param describes the handle that controls the curve preceding the point, the second describes the curve following the point.
    * @return The Future
    */
    public Future<Void> startPeriodicRecording(List<String> jointsToRecord, Integer nbPoses, Boolean extensionAllowed, Float timeStep, List<String> jointsToReplay, Object replayData) throws CallError, InterruptedException{
        return call("startPeriodicRecording", jointsToRecord, nbPoses, extensionAllowed, timeStep, jointsToReplay, replayData);
    }

    /**
    * Stop recording the motion and return data
    * 
    * @return Returns the recorded data as an ALValue: [[JointName1,[pos1, pos2, ...]], [JointName2,[pos1, pos2, ...]], ...]
    */
    public Future<Object> stopAndGetRecording() throws CallError, InterruptedException {
        return call("stopAndGetRecording");
    }

    /**
    * Called by ALMemory when subcription data is updated. INTERNAL
    * 
    * @param dataName  Name of the subscribed data.
    * @param data  Value of the the subscribed data
    * @param message  The message give when subscribing.
    * @return The Future
    */
    public Future<Void> dataChanged(String dataName, Object data, String message) throws CallError, InterruptedException{
        return call("dataChanged", dataName, data, message);
    }

    }
}
    