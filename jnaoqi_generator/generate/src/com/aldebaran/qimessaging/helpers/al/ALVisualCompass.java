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
public class ALVisualCompass extends ALModule {

    public ALVisualCompass(Session session) {
        super(session);
    }

    /**
    * Gets extractor resolution
    * 
    * @return Current value of the resolution of the extractor
    */
    public Integer getResolution() throws CallError, InterruptedException {
        return (Integer)service.call("getResolution").get();
    }

    /**
    * 
    * 
    */
    public void _run() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_run");
        else
            service.call("_run").get();
    }

    /**
    * Sets extractor resolution
    * 
    * @param resolution  New resolution
    * @return True if the update succeeded, False if not
    */
    public Boolean setResolution(Integer resolution) throws CallError, InterruptedException {
        return (Boolean)service.call("setResolution", resolution).get();
    }

    /**
    * 
    * 
    * @param refresh  True if the reference is automatically refreshed at extractor startup; false to use the manually set reference image.
    */
    public void enableReferenceRefresh(Boolean refresh) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("enableReferenceRefresh", refresh);
        else
            service.call("enableReferenceRefresh", refresh).get();
    }

    /**
    * Returns the reliability of the matching and the compass deviation computations.
    * 
    * @return [0]: Percentage of the matched keypoints that are used to compute the deviation (significant if over 50%) 
 [1]: Number of keypoints matching.
    */
    public java.lang.Object getMatchingQuality() throws CallError, InterruptedException {
        return (java.lang.Object)service.call("getMatchingQuality").get();
    }

    /**
    * DEPRECATED: Sets pause and resolution
    * 
    * @param paramName  Name of the parameter to set
    * @param value  New value
    */
    public void setParameter(String paramName, java.lang.Object value) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setParameter", paramName, value);
        else
            service.call("setParameter", paramName, value).get();
    }

    /**
    * Go to input pose (in robot referential).
    * 
    * @param x  Distance along the X axis in meters.
    * @param y  Distance along the Y axis in meters.
    * @param theta  Rotation around the Z axis in radians [-3.1415 to 3.1415].
    */
    public Boolean moveTo(Float x, Float y, Float theta) throws CallError, InterruptedException {
        return (Boolean)service.call("moveTo", x, y, theta).get();
    }

    /**
    * Move along the robot X axis.
    * 
    * @param x  Algebric distance along the X axis in meters.
    */
    public Boolean moveStraightTo(Float x) throws CallError, InterruptedException {
        return (Boolean)service.call("moveStraightTo", x).get();
    }

    /**
    * 
    * 
    */
    public void _xOnMoveFailed() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_xOnMoveFailed");
        else
            service.call("_xOnMoveFailed").get();
    }

    /**
    * 
    * 
    */
    public void _xOnFootContactChanged(String param1, java.lang.Object param2, String param3) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_xOnFootContactChanged", param1, param2, param3);
        else
            service.call("_xOnFootContactChanged", param1, param2, param3).get();
    }

    /**
    * Stops the robot
    * 
    */
    public void _stopControllers() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_stopControllers");
        else
            service.call("_stopControllers").get();
    }

    /**
    * Gets extractor framerate
    * 
    * @return Current value of the framerate of the extractor
    */
    public Integer getFrameRate() throws CallError, InterruptedException {
        return (Integer)service.call("getFrameRate").get();
    }

    /**
    * Allows the robot to resume after stopping.
    * 
    */
    public void _resume() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_resume");
        else
            service.call("_resume").get();
    }

    /**
    * Set the rotation controller parameters.
    * 
    * @param pCoefficient  Proportional gain of the controller.
    * @param thetaThreshold  Threshold to consider the gap on theta as error.
    */
    public void _setTranslationParameters(Float pCoefficient, Float thetaThreshold, Float param1, Float param2) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_setTranslationParameters", pCoefficient, thetaThreshold, param1, param2);
        else
            service.call("_setTranslationParameters", pCoefficient, thetaThreshold, param1, param2).get();
    }

    /**
    * Set the rotation controller parameters.
    * 
    * @param pCoefficient  Proportional gain of the controller.
    * @param maxRotationSpeed  Max robot rotation speed.
    * @param thetaThreshold  Threshold to consider the gap on theta as an error.
    */
    public void _setRotationParameters(java.lang.Object pCoefficient, Float maxRotationSpeed, Float thetaThreshold, Float param1, Float param2, Integer param3) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_setRotationParameters", pCoefficient, maxRotationSpeed, thetaThreshold, param1, param2, param3);
        else
            service.call("_setRotationParameters", pCoefficient, maxRotationSpeed, thetaThreshold, param1, param2, param3).get();
    }

    /**
    * Block the current thread until the target is reached.
    * 
    */
    public void waitUntilTargetReached() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("waitUntilTargetReached");
        else
            service.call("waitUntilTargetReached").get();
    }

    /**
    * 
    * 
    */
    public void _setOdometryMode(Boolean param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_setOdometryMode", param1);
        else
            service.call("_setOdometryMode", param1).get();
    }

    /**
    * Gets extractor active camera
    * 
    * @return Id of the current active camera of the extractor
    */
    public Integer getActiveCamera() throws CallError, InterruptedException {
        return (Integer)service.call("getActiveCamera").get();
    }

    /**
    * Gets extractor pause status
    * 
    * @return True if the extractor is paused, False if not
    */
    public Boolean isPaused() throws CallError, InterruptedException {
        return (Boolean)service.call("isPaused").get();
    }

    /**
    * Sets extractor active camera
    * 
    * @param cameraId  Id of the camera that will become the active camera
    * @return True if the update succeeded, False if not
    */
    public Boolean setActiveCamera(Integer cameraId) throws CallError, InterruptedException {
        return (Boolean)service.call("setActiveCamera", cameraId).get();
    }

    /**
    * Gets extractor running status
    * 
    * @return True if the extractor is currently processing images, False if not
    */
    public Boolean isProcessing() throws CallError, InterruptedException {
        return (Boolean)service.call("isProcessing").get();
    }

    /**
    * Changes the pause status of the extractor
    * 
    * @param paused  New pause satus
    */
    public void pause(Boolean paused) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("pause", paused);
        else
            service.call("pause", paused).get();
    }

    /**
    * Returns an ALValue containing the image used as a reference.
    * 
    * @return Reference image (formatted as the ALValue from getImageRemote of ALVideoDevice)
    */
    public java.lang.Object getReferenceImage() throws CallError, InterruptedException {
        return (java.lang.Object)service.call("getReferenceImage").get();
    }

    /**
    * Stops the robot
    * 
    * @param resumeControllers  Resume after stopping
    */
    public void _resumeControllers(Boolean resumeControllers) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_resumeControllers", resumeControllers);
        else
            service.call("_resumeControllers", resumeControllers).get();
    }

    /**
    * Sets the reference image for the compass.
    * 
    * @return True if the reference image has been successfully set
    */
    public Boolean setCurrentImageAsReference() throws CallError, InterruptedException {
        return (Boolean)service.call("setCurrentImageAsReference").get();
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
    * Subscribes to the extractor. This causes the extractor to start writing information to memory using the keys described by getOutputNames(). These can be accessed in memory using ALMemory.getData("keyName"). In many cases you can avoid calling subscribe on the extractor by just calling ALMemory.subscribeToEvent() supplying a callback method. This will automatically subscribe to the extractor for you.
    * 
    * @param name  Name of the module which subscribes.
    * @param period  Refresh period (in milliseconds) if relevant.
    * @param precision  Precision of the extractor if relevant.
    */
    public void subscribe(String name, Integer period, Float precision) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("subscribe", name, period, precision);
        else
            service.call("subscribe", name, period, precision).get();
    }

    /**
    * Subscribes to the extractor. This causes the extractor to start writing information to memory using the keys described by getOutputNames(). These can be accessed in memory using ALMemory.getData("keyName"). In many cases you can avoid calling subscribe on the extractor by just calling ALMemory.subscribeToEvent() supplying a callback method. This will automatically subscribe to the extractor for you.
    * 
    * @param name  Name of the module which subscribes.
    */
    public void subscribe(String name) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("subscribe", name);
        else
            service.call("subscribe", name).get();
    }

    /**
    * Unsubscribes from the extractor.
    * 
    * @param name  Name of the module which had subscribed.
    */
    public void unsubscribe(String name) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("unsubscribe", name);
        else
            service.call("unsubscribe", name).get();
    }

    /**
    * Updates the period if relevant.
    * 
    * @param name  Name of the module which has subscribed.
    * @param period  Refresh period (in milliseconds).
    */
    public void updatePeriod(String name, Integer period) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("updatePeriod", name, period);
        else
            service.call("updatePeriod", name, period).get();
    }

    /**
    * Updates the precision if relevant.
    * 
    * @param name  Name of the module which has subscribed.
    * @param precision  Precision of the extractor.
    */
    public void updatePrecision(String name, Float precision) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("updatePrecision", name, precision);
        else
            service.call("updatePrecision", name, precision).get();
    }

    /**
    * Gets the current period.
    * 
    * @return Refresh period (in milliseconds).
    */
    public Integer getCurrentPeriod() throws CallError, InterruptedException {
        return (Integer)service.call("getCurrentPeriod").get();
    }

    /**
    * Gets the current precision.
    * 
    * @return Precision of the extractor.
    */
    public Float getCurrentPrecision() throws CallError, InterruptedException {
        return (Float)service.call("getCurrentPrecision").get();
    }

    /**
    * Gets the period for a specific subscription.
    * 
    * @param name  Name of the module which has subscribed.
    * @return Refresh period (in milliseconds).
    */
    public Integer getMyPeriod(String name) throws CallError, InterruptedException {
        return (Integer)service.call("getMyPeriod", name).get();
    }

    /**
    * Gets the precision for a specific subscription.
    * 
    * @param name  name of the module which has subscribed
    * @return precision of the extractor
    */
    public Float getMyPrecision(String name) throws CallError, InterruptedException {
        return (Float)service.call("getMyPrecision", name).get();
    }

    /**
    * Gets the parameters given by the module.
    * 
    * @return Array of names and parameters of all subscribers.
    */
    public java.lang.Object getSubscribersInfo() throws CallError, InterruptedException {
        return (java.lang.Object)service.call("getSubscribersInfo").get();
    }

    /**
    * Get the list of values updated in ALMemory.
    * 
    * @return Array of values updated by this extractor in ALMemory
    */
    public List<String> getOutputNames() throws CallError, InterruptedException {
        return (List<String>)service.call("getOutputNames").get();
    }

    /**
    * Get the list of events updated in ALMemory.
    * 
    * @return Array of events updated by this extractor in ALMemory
    */
    public List<String> getEventList() throws CallError, InterruptedException {
        return (List<String>)service.call("getEventList").get();
    }

    /**
    * Get the list of events updated in ALMemory.
    * 
    * @return Array of events updated by this extractor in ALMemory
    */
    public List<String> getMemoryKeyList() throws CallError, InterruptedException {
        return (List<String>)service.call("getMemoryKeyList").get();
    }

    /**
    * Sets the extractor framerate for a chosen subscriber
    * 
    * @param subscriberName  Name of the subcriber
    * @param framerate  New framerate
    * @return True if the update succeeded, False if not
    */
    public Boolean setFrameRate(String subscriberName, Integer framerate) throws CallError, InterruptedException {
        return (Boolean)service.call("setFrameRate", subscriberName, framerate).get();
    }

    /**
    * Sets the extractor framerate for all the subscribers
    * 
    * @param framerate  New framerate
    * @return True if the update succeeded, False if not
    */
    public Boolean setFrameRate(Integer framerate) throws CallError, InterruptedException {
        return (Boolean)service.call("setFrameRate", framerate).get();
    }

}
    