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
public class ALFaceDetection extends ALModule {

    public ALFaceDetection(Session session) {
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
    * enable/disable the recognition stageProcess will be faster when disabled when you don't need to recognize people
    * 
    * @param enable  True/False
    */
    public void setRecognitionEnabled(Boolean enable) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setRecognitionEnabled", enable);
        else
            service.call("setRecognitionEnabled", enable).get();
    }

    /**
    * Returns if recognition is enabled.
    * 
    * @return True/False
    */
    public Boolean isRecognitionEnabled() throws CallError, InterruptedException {
        return (Boolean)service.call("isRecognitionEnabled").get();
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
    * (BETA) Choose to enable or disable tracking. Enabling tracking usually allows you to follow a face for a longer period of time. However, it can lead to more false detections. 
    * 
    * @param enable  True/False
    */
    public void setTrackingEnabled(Boolean enable) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setTrackingEnabled", enable);
        else
            service.call("setTrackingEnabled", enable).get();
    }

    /**
    * (BETA) Returns if tracking is enabled.
    * 
    * @return True/False
    */
    public Boolean isTrackingEnabled() throws CallError, InterruptedException {
        return (Boolean)service.call("isTrackingEnabled").get();
    }

    /**
    * Add a new face in the database.
    * 
    * @param pId  The name of the person to save
    * @return true if the operation succeeds
    */
    public Boolean learnFace(String pId) throws CallError, InterruptedException {
        return (Boolean)service.call("learnFace", pId).get();
    }

    /**
    * use in a new learning process the latest images where a face has been wrongly recognized 
    * 
    * @param pId  The name of the person to save
    * @return true if the operation succeeds
    */
    public Boolean reLearnFace(String pId) throws CallError, InterruptedException {
        return (Boolean)service.call("reLearnFace", pId).get();
    }

    /**
    * Delete from the database all faces instances of a person.
    * 
    * @param pId  The name of the person to forget
    * @return true if the operation succeeds
    */
    public Boolean forgetPerson(String pId) throws CallError, InterruptedException {
        return (Boolean)service.call("forgetPerson", pId).get();
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
    * Returns the current mode of detection
    * 
    * @return current mode of deteciton (0, 1, 2 or 3)
    */
    public Integer _getDetectionMode() throws CallError, InterruptedException {
        return (Integer)service.call("_getDetectionMode").get();
    }

    /**
    * Returns the current face analysis state
    * 
    * @return True/False
    */
    public Boolean _isFaceAnalysisEnabled() throws CallError, InterruptedException {
        return (Boolean)service.call("_isFaceAnalysisEnabled").get();
    }

    /**
    * Enables or disables the full face analysis
    * 
    * @param enabled  True to enable, False to disable
    */
    public void _setFaceAnalysisEnabled(Boolean enabled) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_setFaceAnalysisEnabled", enabled);
        else
            service.call("_setFaceAnalysisEnabled", enabled).get();
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
        return (Boolean)service.call("importOldDatabase", policy).get();
    }

    /**
    * Returns the list of learned faces.
    * 
    * @return List of names
    */
    public java.lang.Object getLearnedFacesList() throws CallError, InterruptedException {
        return (java.lang.Object)service.call("getLearnedFacesList").get();
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
    * deprecated
    * 
    */
    public void enableRecognition(Boolean param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("enableRecognition", param1);
        else
            service.call("enableRecognition", param1).get();
    }

    /**
    * Remove all faces from the database.
    * 
    * @return true if the operation succeeds
    */
    public Boolean clearDatabase() throws CallError, InterruptedException {
        return (Boolean)service.call("clearDatabase").get();
    }

    /**
    * deprecated
    * 
    */
    public void enableTracking(Boolean param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("enableTracking", param1);
        else
            service.call("enableTracking", param1).get();
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
    