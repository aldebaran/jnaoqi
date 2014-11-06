package com.aldebaran.qimessaging.helpers.al;

import com.aldebaran.qimessaging.CallError;
import com.aldebaran.qimessaging.Session;
import com.aldebaran.qimessaging.helpers.ALModule;
import java.util.List;
import java.util.Map;
import com.aldebaran.qimessaging.*;

import java.util.List;

/**
 * Created by erwan and emile on 01/05/2014.
 */
public class ALMotionRecorder extends ALModule {

    public ALMotionRecorder(Session session) {
        super(session);
    }

    /**
    * 
    * 
    */
    public Boolean isStatsEnabled() throws CallError, InterruptedException {
        return (Boolean)service.call("isStatsEnabled").get();
    }

    /**
    * 
    * 
    */
    public void clearStats() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("clearStats");
        else
            service.call("clearStats").get();
    }

    /**
    * 
    * 
    */
    public Boolean isTraceEnabled() throws CallError, InterruptedException {
        return (Boolean)service.call("isTraceEnabled").get();
    }

    /**
    * Exits and unregisters the module.
    * 
    */
    public void exit() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("exit");
        else
            service.call("exit").get();
    }

    /**
    * Returns the version of the module.
    * 
    * @return A string containing the version of the module.
    */
    public String version() throws CallError, InterruptedException {
        return (String)service.call("version").get();
    }

    /**
    * Just a ping. Always returns true
    * 
    * @return returns true
    */
    public Boolean ping() throws CallError, InterruptedException {
        return (Boolean)service.call("ping").get();
    }

    /**
    * Retrieves the module's method list.
    * 
    * @return An array of method names.
    */
    public List<String> getMethodList() throws CallError, InterruptedException {
        return (List<String>)service.call("getMethodList").get();
    }

    /**
    * Retrieves a method's description.
    * 
    * @param methodName  The name of the method.
    * @return A structure containing the method's description.
    */
    public java.lang.Object getMethodHelp(String methodName) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("getMethodHelp", methodName).get();
    }

    /**
    * Retrieves the module's description.
    * 
    * @return A structure describing the module.
    */
    public java.lang.Object getModuleHelp() throws CallError, InterruptedException {
        return (java.lang.Object)service.call("getModuleHelp").get();
    }

    /**
    * Wait for the end of a long running method that was called using 'post'
    * 
    * @param id  The ID of the method that was returned when calling the method using 'post'
    * @param timeoutPeriod  The timeout period in ms. To wait indefinately, use a timeoutPeriod of zero.
    * @return True if the timeout period terminated. False if the method returned.
    */
    public Boolean wait(Integer id, Integer timeoutPeriod) throws CallError, InterruptedException {
        return (Boolean)service.call("wait", id, timeoutPeriod).get();
    }

    /**
    * Returns true if the method is currently running.
    * 
    * @param id  The ID of the method that was returned when calling the method using 'post'
    * @return True if the method is currently running
    */
    public Boolean isRunning(Integer id) throws CallError, InterruptedException {
        return (Boolean)service.call("isRunning", id).get();
    }

    /**
    * returns true if the method is currently running
    * 
    * @param id  the ID of the method to wait for
    */
    public void stop(Integer id) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("stop", id);
        else
            service.call("stop", id).get();
    }

    /**
    * Gets the name of the parent broker.
    * 
    * @return The name of the parent broker.
    */
    public String getBrokerName() throws CallError, InterruptedException {
        return (String)service.call("getBrokerName").get();
    }

    /**
    * Gets the method usage string. This summarises how to use the method.
    * 
    * @param name  The name of the method.
    * @return A string that summarises the usage of the method.
    */
    public String getUsage(String name) throws CallError, InterruptedException {
        return (String)service.call("getUsage", name).get();
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
        if (isAsynchronous)
            service.call("startInteractiveRecording", jointsToRecord, nbPoses, extensionAllowed, mode);
        else
            service.call("startInteractiveRecording", jointsToRecord, nbPoses, extensionAllowed, mode).get();
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
    public void startPeriodicRecording(List<String> jointsToRecord, Integer nbPoses, Boolean extensionAllowed, Float timeStep, List<String> jointsToReplay, java.lang.Object replayData) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("startPeriodicRecording", jointsToRecord, nbPoses, extensionAllowed, timeStep, jointsToReplay, replayData);
        else
            service.call("startPeriodicRecording", jointsToRecord, nbPoses, extensionAllowed, timeStep, jointsToReplay, replayData).get();
    }

    /**
    * Stop recording the motion and return data
    * 
    * @return Returns the recorded data as an ALValue: [[JointName1,[pos1, pos2, ...]], [JointName2,[pos1, pos2, ...]], ...]
    */
    public java.lang.Object stopAndGetRecording() throws CallError, InterruptedException {
        return (java.lang.Object)service.call("stopAndGetRecording").get();
    }

    /**
    * Called by ALMemory when subcription data is updated. INTERNAL
    * 
    * @param dataName  Name of the subscribed data.
    * @param data  Value of the the subscribed data
    * @param message  The message give when subscribing.
    */
    public void dataChanged(String dataName, java.lang.Object data, String message) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("dataChanged", dataName, data, message);
        else
            service.call("dataChanged", dataName, data, message).get();
    }

}
    