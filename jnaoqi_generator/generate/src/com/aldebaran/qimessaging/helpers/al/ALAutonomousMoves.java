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
public class ALAutonomousMoves extends ALModule {

    public ALAutonomousMoves(Session session) {
        super(session);
    }

    /**
    * Apply a new reset posture.
    * 
    */
    public void _disableBackgroundPosture() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_disableBackgroundPosture");
        else
            service.call("_disableBackgroundPosture").get();
    }

    /**
    * Callback for asr status ALMemory event.
    * 
    * @param memoryKey  The subscribed memory key which changed.
    * @param value  The new value of the memory key.
    * @param message  The message that comes with the callback.
    */
    public void _activeListeningCallback(String memoryKey, java.lang.Object value, String message) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_activeListeningCallback", memoryKey, value, message);
        else
            service.call("_activeListeningCallback", memoryKey, value, message).get();
    }

    /**
    * Callback for asr status ALMemory event.
    * 
    * @param memoryKey  The subscribed memory key which changed.
    * @param value  The new value of the memory key.
    * @param message  The message that comes with the callback.
    */
    public void _postureFamilyChangedCallback(String memoryKey, java.lang.Object value, String message) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_postureFamilyChangedCallback", memoryKey, value, message);
        else
            service.call("_postureFamilyChangedCallback", memoryKey, value, message).get();
    }

    /**
    * Callback for asr status ALMemory event.
    * 
    * @param memoryKey  The subscribed memory key which changed.
    * @param value  The new value of the memory key.
    * @param message  The message that comes with the callback.
    */
    public void _asrStatusCallback(String memoryKey, java.lang.Object value, String message) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_asrStatusCallback", memoryKey, value, message);
        else
            service.call("_asrStatusCallback", memoryKey, value, message).get();
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
    * DEPRECATED since 2.0: do ALBasicAwareness.setTrackingMode("MoveContextually") instead.Start small base moves.
    * 
    */
    public void startSmallDisplacements() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("startSmallDisplacements");
        else
            service.call("startSmallDisplacements").get();
    }

    /**
    * DEPRECATED since 2.0: do ALBasicAwareness.setTrackingMode instead.Stop small base moves.
    * 
    */
    public void stopSmallDisplacements() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("stopSmallDisplacements");
        else
            service.call("stopSmallDisplacements").get();
    }

    /**
    * Move forward.
    * 
    */
    public void _moveForward() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_moveForward");
        else
            service.call("_moveForward").get();
    }

    /**
    * Move backward.
    * 
    */
    public void _moveBackward() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_moveBackward");
        else
            service.call("_moveBackward").get();
    }

    /**
    * Move sides.
    * 
    */
    public void _moveSides() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_moveSides");
        else
            service.call("_moveSides").get();
    }

    /**
    * Move randomly.
    * 
    */
    public void _moveRandomly() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_moveRandomly");
        else
            service.call("_moveRandomly").get();
    }

    /**
    * Enable or disable expressive listening.
    * 
    * @param enable  The boolean value: true to enable, false to disable.
    */
    public void setExpressiveListeningEnabled(Boolean enable) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setExpressiveListeningEnabled", enable);
        else
            service.call("setExpressiveListeningEnabled", enable).get();
    }

    /**
    * Enable or disable expressive listening.
    * 
    * @param enable  The boolean value: true to enable, false to disable.
    * @param bodypart  What body part is concerned (can be All, Arms or Head).
    */
    public void _setExpressiveListeningEnabled(Boolean enable, String bodypart) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_setExpressiveListeningEnabled", enable, bodypart);
        else
            service.call("_setExpressiveListeningEnabled", enable, bodypart).get();
    }

    /**
    * If expressive listening is enabled.
    * 
    * @return The boolean value: true means it is enabled, false means it is disabled.
    */
    public Boolean getExpressiveListeningEnabled() throws CallError, InterruptedException {
        return (Boolean)service.call("getExpressiveListeningEnabled").get();
    }

    /**
    * If expressive listening is enabled.
    * 
    * @param bodypart  What body part is concerned (can be All, Arms or Head).
    * @return The boolean value: true means it is enabled, false means it is disabled.
    */
    public Boolean _getExpressiveListeningEnabled(String bodypart) throws CallError, InterruptedException {
        return (Boolean)service.call("_getExpressiveListeningEnabled", bodypart).get();
    }

    /**
    * Enable or disable expressive listening.
    * 
    */
    public void _startExpressiveListening() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_startExpressiveListening");
        else
            service.call("_startExpressiveListening").get();
    }

    /**
    * Enable or disable expressive listening.
    * 
    */
    public void _expressiveListeningHeadNode() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_expressiveListeningHeadNode");
        else
            service.call("_expressiveListeningHeadNode").get();
    }

    /**
    * Enable or disable expressive listening.
    * 
    */
    public void _stopExpressiveListening() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_stopExpressiveListening");
        else
            service.call("_stopExpressiveListening").get();
    }

    /**
    * Apply a new reset posture.
    * 
    */
    public void _enableJapaneseBackgroundPosture() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_enableJapaneseBackgroundPosture");
        else
            service.call("_enableJapaneseBackgroundPosture").get();
    }

    /**
    * Apply a new reset posture.
    * 
    */
    public void _enableDefaultBackgroundPosture() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_enableDefaultBackgroundPosture");
        else
            service.call("_enableDefaultBackgroundPosture").get();
    }

}
    