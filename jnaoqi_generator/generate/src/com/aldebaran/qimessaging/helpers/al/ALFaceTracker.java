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
public class ALFaceTracker extends ALModule {

    public ALFaceTracker(Session session) {
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
    * Start the tracker by Subscribing to Event FaceDetected from ALFaceDetection module.
Then Wait Event FaceDetected from ALFaceDetection module.
And finally send information to motion for head tracking.
NOTE: Stiffness of Head must be set to 1.0 to move! 

    * 
    */
    public void startTracker() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("startTracker");
        else
            service.call("startTracker").get();
    }

    /**
    * Stop the tracker by Unsubscribing to Event FaceDetected from ALFaceDetection module.

    * 
    */
    public void stopTracker() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("stopTracker");
        else
            service.call("stopTracker").get();
    }

    /**
    * Return the [x, y, z] position of the face in FRAME_TORSO. This is done assuming an average face size, so it might not be very accurate.
 This invalidates the isNewData field of the tracker. See isNewData()) for more details.
    * 
    * @return An Array containing the face position [x, y, z].
    */
    public List<Float> getPosition() throws CallError, InterruptedException {
        return (List<Float>)service.call("getPosition").get();
    }

    /**
    * Return true if a new face was detected since the last getPosition().

    * 
    * @return true if a new face was detected since the last getPosition().
    */
    public Boolean isNewData() throws CallError, InterruptedException {
        return (Boolean)service.call("isNewData").get();
    }

    /**
    * Return true if the face Tracker is running.

    * 
    * @return true if the face Tracker is running.
    */
    public Boolean isActive() throws CallError, InterruptedException {
        return (Boolean)service.call("isActive").get();
    }

    /**
    * if true, the tracking will be through a Whole Body Process.

    * 
    * @param pWholeBodyOn  The whole Body state
    */
    public void setWholeBodyOn(Boolean pWholeBodyOn) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setWholeBodyOn", pWholeBodyOn);
        else
            service.call("setWholeBodyOn", pWholeBodyOn).get();
    }

    /**
    * Called by Memory when a face is detected
    * 
    */
    public void _onFaceDetected(String param1, java.lang.Object param2, String param3) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_onFaceDetected", param1, param2, param3);
        else
            service.call("_onFaceDetected", param1, param2, param3).get();
    }

}
    