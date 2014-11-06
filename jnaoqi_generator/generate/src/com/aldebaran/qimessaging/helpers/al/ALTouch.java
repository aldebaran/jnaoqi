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
public class ALTouch extends ALModule {

    public ALTouch(Session session) {
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
    * Internal Use.
    * 
    * @param config  Internal: An array of ALValues [i][0]: name, [i][1]: value
    */
    public void _setTouchConfig(java.lang.Object config) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_setTouchConfig", config);
        else
            service.call("_setTouchConfig", config).get();
    }

    /**
    * Return the list of sensors managed by touch module and return by TouchChangedevent.
    * 
    * @return A vector<std::string> of sensor names manage by ALTouch.
    */
    public List<String> getSensorList() throws CallError, InterruptedException {
        return (List<String>)service.call("getSensorList").get();
    }

    /**
    * Return the current status of all Touch groups.
    * 
    * @return A vector of pair [name, bool], similar to TouchChanged event.
    */
    public java.lang.Object getStatus() throws CallError, InterruptedException {
        return (java.lang.Object)service.call("getStatus").get();
    }

    /**
    * Internal Use.
    * 
    * @param groupName  The name of the group to create.
    * @param jointNames  A vector of joint and actuator names constituting the group.
    * @return true if the group was created, false otherwise.
    */
    public Boolean _createGroup(String groupName, List<String> jointNames) throws CallError, InterruptedException {
        return (Boolean)service.call("_createGroup", groupName, jointNames).get();
    }

    /**
    * Internal Use.
    * 
    * @param groupName  The name of the group to delete
    * @return true if the group was deleted, false otherwise
    */
    public Boolean _deleteGroup(String groupName) throws CallError, InterruptedException {
        return (Boolean)service.call("_deleteGroup", groupName).get();
    }

    /**
    * Internal Use.
    * 
    * @return The list of groups used for sending touch events
    */
    public List<String> _getGroupList() throws CallError, InterruptedException {
        return (List<String>)service.call("_getGroupList").get();
    }

    /**
    * Internal Use.
    * 
    * @param type  Touch detection type enum
    * @return The name of a touch detection type
    */
    public String _getDetectionTypeName(Integer type) throws CallError, InterruptedException {
        return (String)service.call("_getDetectionTypeName", type).get();
    }

    /**
    * Callback when robot is falling
    * 
    */
    public void _robotFallingCallback(String param1, java.lang.Object param2, java.lang.Object param3) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_robotFallingCallback", param1, param2, param3);
        else
            service.call("_robotFallingCallback", param1, param2, param3).get();
    }

    /**
    * Callback when robot has fallen
    * 
    */
    public void _robotFallenCallback(String param1, java.lang.Object param2, java.lang.Object param3) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_robotFallenCallback", param1, param2, param3);
        else
            service.call("_robotFallenCallback", param1, param2, param3).get();
    }

    /**
    * Callback when diagnosis change.
    * 
    */
    public void _diagnosisCallback(String param1, java.lang.Object param2, java.lang.Object param3) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_diagnosisCallback", param1, param2, param3);
        else
            service.call("_diagnosisCallback", param1, param2, param3).get();
    }

}
    