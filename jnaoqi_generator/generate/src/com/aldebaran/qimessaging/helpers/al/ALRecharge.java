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
public class ALRecharge extends ALModule {

    public ALRecharge(Session session) {
        super(session);
    }

    /**
    * .
    * 
    */
    public void _eventBatteryChargingCallback(String param1, java.lang.Object param2, String param3) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_eventBatteryChargingCallback", param1, param2, param3);
        else
            service.call("_eventBatteryChargingCallback", param1, param2, param3).get();
    }

    /**
    * .
    * 
    */
    public void _eventTrackerTargetLostCallback() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_eventTrackerTargetLostCallback");
        else
            service.call("_eventTrackerTargetLostCallback").get();
    }

    /**
    * .
    * 
    */
    public void _eventMoveFailedCallback() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_eventMoveFailedCallback");
        else
            service.call("_eventMoveFailedCallback").get();
    }

    /**
    * .
    * 
    */
    public void _eventBatteryConnectedToChargingStationCallback(String param1, java.lang.Object param2, String param3) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_eventBatteryConnectedToChargingStationCallback", param1, param2, param3);
        else
            service.call("_eventBatteryConnectedToChargingStationCallback", param1, param2, param3).get();
    }

    /**
    * .
    * 
    */
    public void _eventTrackerActiveTargetChangedCallback(String param1, java.lang.Object param2, String param3) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_eventTrackerActiveTargetChangedCallback", param1, param2, param3);
        else
            service.call("_eventTrackerActiveTargetChangedCallback", param1, param2, param3).get();
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
    * .
    * 
    */
    public void goToStation() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("goToStation");
        else
            service.call("goToStation").get();
    }

    /**
    * .
    * 
    */
    public void leaveStation() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("leaveStation");
        else
            service.call("leaveStation").get();
    }

    /**
    * .
    * 
    */
    public List<Float> getStationPosition() throws CallError, InterruptedException {
        return (List<Float>)service.call("getStationPosition").get();
    }

    /**
    * .
    * 
    */
    public void stopAll() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("stopAll");
        else
            service.call("stopAll").get();
    }

    /**
    * .
    * 
    */
    public void subscribe() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("subscribe");
        else
            service.call("subscribe").get();
    }

    /**
    * .
    * 
    */
    public void unsubscribe() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("unsubscribe");
        else
            service.call("unsubscribe").get();
    }

    /**
    * .
    * 
    */
    public Integer getStatus() throws CallError, InterruptedException {
        return (Integer)service.call("getStatus").get();
    }

    /**
    * .
    * 
    */
    public java.lang.Object lookForStation() throws CallError, InterruptedException {
        return (java.lang.Object)service.call("lookForStation").get();
    }

    /**
    * .
    * 
    */
    public Boolean moveInFrontOfStation() throws CallError, InterruptedException {
        return (Boolean)service.call("moveInFrontOfStation").get();
    }

    /**
    * .
    * 
    */
    public Boolean dockOnStation() throws CallError, InterruptedException {
        return (Boolean)service.call("dockOnStation").get();
    }

    /**
    * .
    * 
    */
    public Float _getConfidenceIndex() throws CallError, InterruptedException {
        return (Float)service.call("_getConfidenceIndex").get();
    }

    /**
    * .
    * 
    */
    public void _setUseMoveALTracker(Boolean param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_setUseMoveALTracker", param1);
        else
            service.call("_setUseMoveALTracker", param1).get();
    }

    /**
    * .
    * 
    */
    public void _updateStationDetection(String param1, java.lang.Object param2, String param3) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_updateStationDetection", param1, param2, param3);
        else
            service.call("_updateStationDetection", param1, param2, param3).get();
    }

    /**
    * .
    * 
    */
    public void _eventTrackerSearcherLoopCallback() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_eventTrackerSearcherLoopCallback");
        else
            service.call("_eventTrackerSearcherLoopCallback").get();
    }

    /**
    * .
    * 
    */
    public void _eventTrackerTargetReachedCallback() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_eventTrackerTargetReachedCallback");
        else
            service.call("_eventTrackerTargetReachedCallback").get();
    }

}
    