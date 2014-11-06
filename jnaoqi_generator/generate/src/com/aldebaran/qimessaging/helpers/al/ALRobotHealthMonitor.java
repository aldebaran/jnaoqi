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
public class ALRobotHealthMonitor extends ALModule {

    public ALRobotHealthMonitor(Session session) {
        super(session);
    }

    /**
    * Called when an active diagnosis error is triggered
    * 
    */
    public void _uploadActiveDiagnosis() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_uploadActiveDiagnosis");
        else
            service.call("_uploadActiveDiagnosis").get();
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
    * start this module.
    * 
    * @param conffile  Path to the configuration file.
    */
    public void _start() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_start");
        else
            service.call("_start").get();
    }

    /**
    * stop this module.
    * 
    */
    public void _stop() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_stop");
        else
            service.call("_stop").get();
    }

    /**
    * simple loop calling buffer update every "period" milliseconds
    * 
    */
    public void _mainThread() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_mainThread");
        else
            service.call("_mainThread").get();
    }

    /**
    * enable storage of collected data on remote servers.
    * 
    */
    public void _enableNetwork(Boolean param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_enableNetwork", param1);
        else
            service.call("_enableNetwork", param1).get();
    }

    /**
    * used for debugging. Set verbose level.
    * 
    */
    public void _setNetworkVerboseLevel(Integer param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_setNetworkVerboseLevel", param1);
        else
            service.call("_setNetworkVerboseLevel", param1).get();
    }

    /**
    * Set passive diagnosis loop sleep duration in minute.
    * 
    * @param timeInMinutePassiveDiagLoop  Duration in minute.
    */
    public void _setTimeInMinutePassiveDiagLoop(Integer timeInMinutePassiveDiagLoop) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_setTimeInMinutePassiveDiagLoop", timeInMinutePassiveDiagLoop);
        else
            service.call("_setTimeInMinutePassiveDiagLoop", timeInMinutePassiveDiagLoop).get();
    }

    /**
    * Get passive diagnosis loop sleep duration in minute.
    * 
    */
    public Integer _getTimeInMinutePassiveDiagLoop() throws CallError, InterruptedException {
        return (Integer)service.call("_getTimeInMinutePassiveDiagLoop").get();
    }

    /**
    * Internal callback
    * 
    * @param string  variable
    * @param string  value
    * @param string  message
    */
    public void _onConnectivityChanged(String param1, java.lang.Object param2, String param3) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_onConnectivityChanged", param1, param2, param3);
        else
            service.call("_onConnectivityChanged", param1, param2, param3).get();
    }

    /**
    * Be notified when an event we have subscribed to has changed in ALMemory
    * 
    * @param dataName  name of the data
    * @param dataValue  value of the data
    * @param message  callback message
    */
    public void _onEventNotify(String dataName, java.lang.Object dataValue, java.lang.Object message) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_onEventNotify", dataName, dataValue, message);
        else
            service.call("_onEventNotify", dataName, dataValue, message).get();
    }

    /**
    * Be notified when an event we have subscribed to has changed in ALMemory
    * 
    * @param dataName  name of the data
    * @param dataValue  value of the data
    * @param message  callback message
    */
    public void _onKeyAdded(String dataName, java.lang.Object dataValue, java.lang.Object message) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_onKeyAdded", dataName, dataValue, message);
        else
            service.call("_onKeyAdded", dataName, dataValue, message).get();
    }

    /**
    * Be notified when a key is removed in ALMemory
    * 
    * @param dataName  name of the data
    * @param dataValue  value of the data
    * @param message  callback message
    */
    public void _onKeyRemoved(String dataName, java.lang.Object dataValue, java.lang.Object message) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_onKeyRemoved", dataName, dataValue, message);
        else
            service.call("_onKeyRemoved", dataName, dataValue, message).get();
    }

    /**
    * Be notified when an event we have subscribe to has changed in ALMemory
    * 
    * @param dataName  name of the data
    * @param dataValue  value of the data
    * @param message  callback message
    */
    public void _onKeyTypeChanged(String dataName, java.lang.Object dataValue, java.lang.Object message) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_onKeyTypeChanged", dataName, dataValue, message);
        else
            service.call("_onKeyTypeChanged", dataName, dataValue, message).get();
    }

    /**
    * Called when a service is added to the service list.
    * 
    * @param eventName  NetworkServiceAdded
    * @param serviceId  The service identifier of the added service.
    * @param subscriberIdentifier  -
    */
    public void _onNetworkServiceAdded(String eventName, java.lang.Object serviceId, String subscriberIdentifier) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_onNetworkServiceAdded", eventName, serviceId, subscriberIdentifier);
        else
            service.call("_onNetworkServiceAdded", eventName, serviceId, subscriberIdentifier).get();
    }

    /**
    * Called when a service is removed from the service list.
    * 
    * @param eventName  NetworkServiceRemoved
    * @param serviceId  The service identifier of the removed service.
    * @param subscriberIdentifier  -
    */
    public void _onNetworkServiceRemoved(String eventName, java.lang.Object serviceId, String subscriberIdentifier) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_onNetworkServiceRemoved", eventName, serviceId, subscriberIdentifier);
        else
            service.call("_onNetworkServiceRemoved", eventName, serviceId, subscriberIdentifier).get();
    }

    /**
    * Called when a service is removed from the service list.
    * 
    * @param eventName  NetworkServiceStateChanged
    * @param serviceState  A pair which contains the serviceId and the state of the service.
    * @param subscriberIdentifier  -
    */
    public void _onNetworkServiceStateChanged(String eventName, java.lang.Object serviceState, String subscriberIdentifier) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_onNetworkServiceStateChanged", eventName, serviceState, subscriberIdentifier);
        else
            service.call("_onNetworkServiceStateChanged", eventName, serviceState, subscriberIdentifier).get();
    }

}
    