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
public class ALMemoryWatcher extends ALModule {

    public ALMemoryWatcher(Session session) {
        super(session);
    }

    /**
    * Be notified when an event we have subscribe to has changed in ALMemory
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
    * Be notified when the type of a key is changed in ALMemory
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
    * Be notified when a key is removed in ALMemory
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
    * get the list of listened ALMemory keys
    * 
    * @return a list of ALMemory keys
    */
    public List<String> listeners() throws CallError, InterruptedException {
        return (List<String>)service.call("listeners").get();
    }

    /**
    * add an ALMemory key to the list of keys to listen to
    * 
    * @param name  the complete name of the ALMemory key
    * @param interval  interval of time the system should wait before retrieving this key value again
    */
    public void addListener(String name, Integer interval) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("addListener", name, interval);
        else
            service.call("addListener", name, interval).get();
    }

    /**
    * add an ALMemory key to the list of keys to listen to
    * 
    * @param name  the complete name of the ALMemory key
    */
    public void addListener(String name) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("addListener", name);
        else
            service.call("addListener", name).get();
    }

    /**
    * add a list of ALMemory keys to the list of keys to listen
    * 
    * @param listNames  the vector of complete names of ALMemory keys
    * @param interval  interval of time the system should wait before retrieving this key value again
    */
    public void addListeners(List<String> listNames, Integer interval) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("addListeners", listNames, interval);
        else
            service.call("addListeners", listNames, interval).get();
    }

    /**
    * add a list of ALMemory keys to the list of keys to listen
    * 
    * @param listNames  the vector of complete names of ALMemory keys
    */
    public void addListeners(List<String> listNames) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("addListeners", listNames);
        else
            service.call("addListeners", listNames).get();
    }

    /**
    * remove all keys listened to
    * 
    */
    public void removeAllListeners() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("removeAllListeners");
        else
            service.call("removeAllListeners").get();
    }

    /**
    * remove a key from the list to listen to
    * 
    * @param name  the name of the key to stop to listen
    */
    public void removeListener(String name) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("removeListener", name);
        else
            service.call("removeListener", name).get();
    }

    /**
    * remove a list of key from the list to listen
    * 
    * @param listNames  the vector of names of key to stop to listen
    */
    public void removeListeners(List<String> listNames) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("removeListeners", listNames);
        else
            service.call("removeListeners", listNames).get();
    }

    /**
    * return an ALValue containing all buffered data                                       since the last call of getData().
    * 
    * @return The complete array of all buffered data
    */
    public java.lang.Object getData() throws CallError, InterruptedException {
        return (java.lang.Object)service.call("getData").get();
    }

    /**
    * remove all buffered data.                                           The list of keys listened to keeps unchanged.
    * 
    */
    public void clearBuffer() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("clearBuffer");
        else
            service.call("clearBuffer").get();
    }

    /**
    * tells whether keys are watched and data being gathered.
    * 
    * @return true if keys are being watched.
    */
    public Boolean isWatching() throws CallError, InterruptedException {
        return (Boolean)service.call("isWatching").get();
    }

    /**
    * start listening to selected keys from ALMemory
    * 
    * @param period  the time between two listen of ALMemory keys, in milliseconds.
    */
    public void startWatching(Integer period) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("startWatching", period);
        else
            service.call("startWatching", period).get();
    }

    /**
    * stop listening selected keys from ALMemory.                                    List of listened keys and associated buffers keep unchanged.
    * 
    */
    public void stopWatching() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("stopWatching");
        else
            service.call("stopWatching").get();
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
    * edit "period" value between two buffering.
    * 
    * @param period  the new period (in ms) to apply.
    */
    public void setPeriodMs(Integer period) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setPeriodMs", period);
        else
            service.call("setPeriodMs", period).get();
    }

}
    