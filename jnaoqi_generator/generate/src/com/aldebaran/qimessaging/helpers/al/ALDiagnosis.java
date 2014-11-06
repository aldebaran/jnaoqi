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
public class ALDiagnosis extends ALModule {

    public ALDiagnosis(Session session) {
        super(session);
    }

    /**
    * Clear all active diagnosis.
    * 
    */
    public void _clearActiveDiagnosis() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_clearActiveDiagnosis");
        else
            service.call("_clearActiveDiagnosis").get();
    }

    /**
    * Enables/Disables file logging active diagnosis.
    * 
    */
    public void _setLogToFileEnabled(Boolean param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_setLogToFileEnabled", param1);
        else
            service.call("_setLogToFileEnabled", param1).get();
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
    * The actual state of the passive diagnosis.
    * 
    */
    public java.lang.Object getPassiveDiagnosis() throws CallError, InterruptedException {
        return (java.lang.Object)service.call("getPassiveDiagnosis").get();
    }

    /**
    * The actual state of the active diagnosis.
    * 
    */
    public java.lang.Object getActiveDiagnosis() throws CallError, InterruptedException {
        return (java.lang.Object)service.call("getActiveDiagnosis").get();
    }

    /**
    * Enable / Disable diagnosis notification.
    * 
    * @param enable  If True enable diagnosis notification. If False disable diagnosis notification.
    */
    public void setEnableNotification(Boolean enable) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setEnableNotification", enable);
        else
            service.call("setEnableNotification", enable).get();
    }

    /**
    * Return true if notification is active.
    * 
    * @return Return True if notifications is active.
    */
    public Boolean isNotificationEnabled() throws CallError, InterruptedException {
        return (Boolean)service.call("isNotificationEnabled").get();
    }

    /**
    * This function runs the diagnosis.
    * 
    */
    public Boolean _run() throws CallError, InterruptedException {
        return (Boolean)service.call("_run").get();
    }

    /**
    * This function runs the diagnosis.
    * 
    * @param diagnosisFamily  The family of tests to be run by the diagnosis.
    */
    public Boolean _run(String diagnosisFamily) throws CallError, InterruptedException {
        return (Boolean)service.call("_run", diagnosisFamily).get();
    }

    /**
    * Returns a vector of available diagnosis families
    * 
    */
    public List<String> _getFamilyNames() throws CallError, InterruptedException {
        return (List<String>)service.call("_getFamilyNames").get();
    }

    /**
    * The summary of the active diagnosis.This Hide API is dedicated for RhM.
    * 
    */
    public java.lang.Object _getActiveDiagnosisSummary() throws CallError, InterruptedException {
        return (java.lang.Object)service.call("_getActiveDiagnosisSummary").get();
    }

    /**
    * The summary of the passive diagnosis.This Hide API is dedicated for RhM.
    * 
    * @param clearBuffers  If True buffers are cleared.
    */
    public java.lang.Object _getPassiveDiagnosisSummary(Boolean clearBuffers) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("_getPassiveDiagnosisSummary", clearBuffers).get();
    }

    /**
    * Callback method at wakeUp started.
    * 
    */
    public void _wakeUpStartedCallBack() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_wakeUpStartedCallBack");
        else
            service.call("_wakeUpStartedCallBack").get();
    }

    /**
    * Callback method at wakeUp finished.
    * 
    */
    public void _wakeUpFinishedCallBack() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_wakeUpFinishedCallBack");
        else
            service.call("_wakeUpFinishedCallBack").get();
    }

    /**
    * Callback method at rest started.
    * 
    */
    public void _restStartedCallBack() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_restStartedCallBack");
        else
            service.call("_restStartedCallBack").get();
    }

    /**
    * Callback method at rest finished.
    * 
    */
    public void _restFinishedCallBack() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_restFinishedCallBack");
        else
            service.call("_restFinishedCallBack").get();
    }

    /**
    * Callback method at naoqi ready.
    * 
    */
    public void _naoqiReadyCallBack() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_naoqiReadyCallBack");
        else
            service.call("_naoqiReadyCallBack").get();
    }

    /**
    * Callback method at robot is falling.
    * 
    */
    public void _robotIsFallingCallBack() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_robotIsFallingCallBack");
        else
            service.call("_robotIsFallingCallBack").get();
    }

}
    