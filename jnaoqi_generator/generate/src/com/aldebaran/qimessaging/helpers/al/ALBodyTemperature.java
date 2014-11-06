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
public class ALBodyTemperature extends ALModule {

    public ALBodyTemperature(Session session) {
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
    * The actual state of the temperature diagnosis.
    * 
    * @return Return the current temperature diagnosis.
    */
    public java.lang.Object getTemperatureDiagnosis() throws CallError, InterruptedException {
        return (java.lang.Object)service.call("getTemperatureDiagnosis").get();
    }

    /**
    * Enables / Disables temperature notifications.
    * 
    * @param enable  If True enable temperature notifications. If False disable temperature notifications.
    */
    public void setEnableNotifications(Boolean enable) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setEnableNotifications", enable);
        else
            service.call("setEnableNotifications", enable).get();
    }

    /**
    * Return true if notifications are active.
    * 
    * @return Return True if notifications are active.
    */
    public Boolean areNotificationsEnabled() throws CallError, InterruptedException {
        return (Boolean)service.call("areNotificationsEnabled").get();
    }

    /**
    * Return the current temperature of deviceName.
    * 
    * @param deviceName  A joint, actuator or sensor name.
    * @return Return the current temperature in degree celsius.
    */
    public Integer _getDeviceTemperature(String deviceName) throws CallError, InterruptedException {
        return (Integer)service.call("_getDeviceTemperature", deviceName).get();
    }

    /**
    * Return the current temperature status of deviceName.
    * 
    * @param deviceName  A joint, actuator or sensor name.
    * @return Return the current temperature status.
    */
    public Integer _getDeviceStatus(String deviceName) throws CallError, InterruptedException {
        return (Integer)service.call("_getDeviceStatus", deviceName).get();
    }

    /**
    * The actual state of the temperature status.
    * 
    * @return Return the current temperature status.
    */
    public java.lang.Object _getTemperatureStatus() throws CallError, InterruptedException {
        return (java.lang.Object)service.call("_getTemperatureStatus").get();
    }

}
    