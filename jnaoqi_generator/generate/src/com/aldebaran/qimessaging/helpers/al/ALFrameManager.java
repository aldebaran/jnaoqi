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
public class ALFrameManager extends ALModule {

    public ALFrameManager(Session session) {
        super(session);
    }

    /**
    * Goes to a certain frame and continue playing. DEPRECATED since 1.14
    * 
    * @param id  The id of the box containing the box.
    * @param frame  The behavior frame name we want the timeline to go to. If will jump to the starting index of the name given.
    */
    public void gotoAndPlay(String id, String frame) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("gotoAndPlay", id, frame);
        else
            service.call("gotoAndPlay", id, frame).get();
    }

    /**
    * Creates a new box found in an xml file stored in the robot, without loading it, and without auto-delete on stop. (used by link box)
    * 
    * @param xmlFilePath  Path to Xml file, ex : "/home/youhou/mybehavior.xar".
    * @param path  The path to reach the box to instantiate in the project ("" if root).
    * @return return a unique identifier for the created box, that can be used by playBehavior
    */
    public String _newBoxFromFile(String xmlFilePath, String path) throws CallError, InterruptedException {
        return (String)service.call("_newBoxFromFile", xmlFilePath, path).get();
    }

    /**
    * Returns in seconds, the duration of a given movement stored in a box. Returns 0 if the behavior has no motion layers.  DEPRECATED since 1.14
    * 
    * @param id  The id of the box.
    * @return Returns the time in seconds.
    */
    public Float getMotionLength(String id) throws CallError, InterruptedException {
        return (Float)service.call("getMotionLength", id).get();
    }

    /**
    * callback for changes in the preference manager
    * 
    * @param key  ignored, used by ALMemory
    * @param value  the domain and the key of the preference that changed
    * @param message  ignored, used by ALMemory
    */
    public void _onPreferenceUpdated(String key, java.lang.Object value, String message) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_onPreferenceUpdated", key, value, message);
        else
            service.call("_onPreferenceUpdated", key, value, message).get();
    }

    /**
    * callback for changes in the preference manager
    * 
    * @param key  ignored, used by ALMemory
    * @param value  the domain and the key of the preference that changed
    * @param message  ignored, used by ALMemory
    */
    public void _onPreferencesSynchronized(String key, java.lang.Object value, String message) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_onPreferencesSynchronized", key, value, message);
        else
            service.call("_onPreferencesSynchronized", key, value, message).get();
    }

    /**
    * Goes to a certain frame and pause. DEPRECATED since 1.14
    * 
    * @param id  The id of the box containing the box.
    * @param frame  The behavior frame name we want the timeline to go to. If will jump to the starting index of the name given.
    */
    public void gotoAndStop(String id, String frame) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("gotoAndStop", id, frame);
        else
            service.call("gotoAndStop", id, frame).get();
    }

    /**
    * Goes to a certain frame and pause. DEPRECATED since 1.14
    * 
    * @param id  The id of the box containing the box.
    * @param frame  The frame we want the timeline to go to.
    */
    public void gotoAndStop(String id, Integer frame) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("gotoAndStop", id, frame);
        else
            service.call("gotoAndStop", id, frame).get();
    }

    /**
    * Goes to a certain frame and continue playing. DEPRECATED since 1.14
    * 
    * @param id  The id of the box containing the box.
    * @param frame  The frame we want the timeline to go to.
    */
    public void gotoAndPlay(String id, Integer frame) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("gotoAndPlay", id, frame);
        else
            service.call("gotoAndPlay", id, frame).get();
    }

    /**
    * Called by ALMemory when subcription data is updated. INTERNAL
    * 
    * @param dataName  Name of the subscribed data.
    * @param data  Value of the the subscribed data
    * @param message  The message give when subscribing.
    */
    public void _dataChanged(String dataName, java.lang.Object data, String message) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_dataChanged", dataName, data, message);
        else
            service.call("_dataChanged", dataName, data, message).get();
    }

    /**
    * List all behaviors currently handled by the frame manager.
    * 
    * @return a set listing all behavior ids
    */
    public List<String> behaviors() throws CallError, InterruptedException {
        return (List<String>)service.call("behaviors").get();
    }

    /**
    * Start recording some performance data.
    * 
    */
    public void _startBenchmark() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_startBenchmark");
        else
            service.call("_startBenchmark").get();
    }

    /**
    * Stop performance data recording, and return a summary.
    * 
    * @return Returns a textual report of the recorded performance data.
    */
    public String _stopBenchmark() throws CallError, InterruptedException {
        return (String)service.call("_stopBenchmark").get();
    }

    /**
    * wait for a previously started behavior is stopped
    * 
    * @param fmid  the unique identifier of the behavior to wait for
    */
    public void _waitForStopped(String fmid) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_waitForStopped", fmid);
        else
            service.call("_waitForStopped", fmid).get();
    }

    /**
    * called by behaviors when an error occured
    * 
    * @param fmid  the unique identifier of the behavior that failed
    * @param boxid  the identifier of the box that failed
    * @param error  the error message
    */
    public void _reportError(String fmid, String boxid, String error) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_reportError", fmid, boxid, error);
        else
            service.call("_reportError", fmid, boxid, error).get();
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
    * Creates a new behavior, from a box found in an xml file stored in the robot.
    * 
    * @param xmlFilePath  Path to Xml file, ex : "/home/youhou/mybehavior.xar".
    * @param behName  
    * @return return a unique identifier for the created box, that can be used by playBehavior
    */
    public String newBehaviorFromFile(String xmlFilePath, String behName) throws CallError, InterruptedException {
        return (String)service.call("newBehaviorFromFile", xmlFilePath, behName).get();
    }

    /**
    * Creates a new behavior, from a box found in an xml file. Note that you have to give the xml file contents, so this method is not very user friendly. You have to open the file, and send the string that matches the file contents if you are working from a file. You probably want to use newBehaviorFromFile instead. DEPRECATED since 1.14
    * 
    * @param path  The path to reach the box to instantiate in the project ("" if root).
    * @param xmlFile  The choregraphe project (in plain text for the moment).
    * @return return a unique identifier for the created box.
    */
    public String newBehavior(String path, String xmlFile) throws CallError, InterruptedException {
        return (String)service.call("newBehavior", path, xmlFile).get();
    }

    /**
    * Creates a new behavior, from the current Choregraphe behavior 0(uploaded to /tmp/currentChoregrapheBehavior/behavior.xar). DEPRECATED since 1.14
    * 
    * @return return a unique identifier for the created behavior
    */
    public String newBehaviorFromChoregraphe() throws CallError, InterruptedException {
        return (String)service.call("newBehaviorFromChoregraphe").get();
    }

    /**
    * It will play a behavior and block until the behavior is finished. Note that it can block forever if the behavior output is never called.
    * 
    * @param id  The id of the box.
    */
    public void completeBehavior(String id) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("completeBehavior", id);
        else
            service.call("completeBehavior", id).get();
    }

    /**
    * Deletes a behavior (meaning a box). Stop the whole behavior contained in this box first.
    * 
    * @param id  The id of the box to delete.
    */
    public void deleteBehavior(String id) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("deleteBehavior", id);
        else
            service.call("deleteBehavior", id).get();
    }

    /**
    * Starts a behavior
    * 
    * @param id  The id of the box.
    */
    public void playBehavior(String id) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("playBehavior", id);
        else
            service.call("playBehavior", id).get();
    }

    /**
    * Exit the reading of a timeline contained in a given box
    * 
    * @param id  The id of the box.
    */
    public void exitBehavior(String id) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("exitBehavior", id);
        else
            service.call("exitBehavior", id).get();
    }

    /**
    * Tells whether the behavior is running
    * 
    * @param id  The id of the behavior to check
    * @return True if the behavior is running, false otherwise
    */
    public Boolean isBehaviorRunning(String id) throws CallError, InterruptedException {
        return (Boolean)service.call("isBehaviorRunning", id).get();
    }

    /**
    * Stop playing any behavior in FrameManager, and delete all of them.
    * 
    */
    public void cleanBehaviors() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("cleanBehaviors");
        else
            service.call("cleanBehaviors").get();
    }

    /**
    * Returns a playing behavior absolute path.
    * 
    * @param id  The id of the behavior.
    * @return Returns the absolute path of given behavior.
    */
    public String getBehaviorPath(String id) throws CallError, InterruptedException {
        return (String)service.call("getBehaviorPath", id).get();
    }

    /**
    * Creates a timeline.
    * 
    * @param timelineContent  The timeline content (in XML format).
    * @return return a unique identifier for the created box that contains the timeline. You must call deleteBehavior on it at some point. DEPRECATED since 1.14
    */
    public String createTimeline(String timelineContent) throws CallError, InterruptedException {
        return (String)service.call("createTimeline", timelineContent).get();
    }

    /**
    * Starts playing a timeline contained in a given box. If the box is a flow diagram, it will look for the first onStart input of type Bang, and stimulate it ! DEPRECATED since 1.14
    * 
    * @param id  The id of the box.
    */
    public void playTimeline(String id) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("playTimeline", id);
        else
            service.call("playTimeline", id).get();
    }

    /**
    * Stops playing a timeline contained in a given box, at the current frame. DEPRECATED since 1.14
    * 
    * @param id  The id of the box.
    */
    public void stopTimeline(String id) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("stopTimeline", id);
        else
            service.call("stopTimeline", id).get();
    }

    /**
    * Sets the FPS of a given timeline. DEPRECATED since 1.14
    * 
    * @param id  The id of the timeline.
    * @param fps  The FPS to set.
    */
    public void setTimelineFps(String id, Integer fps) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setTimelineFps", id, fps);
        else
            service.call("setTimelineFps", id, fps).get();
    }

    /**
    * Gets the FPS of a given timeline. DEPRECATED since 1.14
    * 
    * @param id  The id of the timeline.
    * @return Returns the timeline's FPS.
    */
    public Integer getTimelineFps(String id) throws CallError, InterruptedException {
        return (Integer)service.call("getTimelineFps", id).get();
    }

}
    