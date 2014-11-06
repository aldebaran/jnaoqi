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
public class ALLocalization extends ALModule {

    public ALLocalization(Session session) {
        super(session);
    }

    /**
    * Go to a given position.
    * 
    */
    public Integer goToPosition(List<Float> param1) throws CallError, InterruptedException {
        return (Integer)service.call("goToPosition", param1).get();
    }

    /**
    * Get the robot orientation.
    * 
    */
    public java.lang.Object getRobotOrientation() throws CallError, InterruptedException {
        return (java.lang.Object)service.call("getRobotOrientation").get();
    }

    /**
    * 
    * 
    */
    public List<Float> _launchLocalization() throws CallError, InterruptedException {
        return (List<Float>)service.call("_launchLocalization").get();
    }

    /**
    * Go to the robot home.
    * 
    */
    public Integer goToHome() throws CallError, InterruptedException {
        return (Integer)service.call("goToHome").get();
    }

    /**
    * Return the list of saving directories
    * 
    */
    public List<String> _getSavingDirectories() throws CallError, InterruptedException {
        return (List<String>)service.call("_getSavingDirectories").get();
    }

    /**
    * Return the current loaded directory name. Will be empty if there is no active panorama or if it has not been saved to a directory yet
    * 
    */
    public String _getLoadedDirectory() throws CallError, InterruptedException {
        return (String)service.call("_getLoadedDirectory").get();
    }

    /**
    * 
    * 
    */
    public java.lang.Object isInGivenZone(Float param1, Float param2, Float param3, Float param4) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("isInGivenZone", param1, param2, param3, param4).get();
    }

    /**
    * 
    * 
    */
    public void _handlePush() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_handlePush");
        else
            service.call("_handlePush").get();
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
    * 
    * 
    */
    public String getMessageFromErrorCode(Integer param1) throws CallError, InterruptedException {
        return (String)service.call("getMessageFromErrorCode", param1).get();
    }

    /**
    * Stop all robot movements.
    * 
    */
    public void stopAll() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("stopAll");
        else
            service.call("stopAll").get();
    }

    /**
    * 
    * 
    */
    public void _safetyStop() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_safetyStop");
        else
            service.call("_safetyStop").get();
    }

    /**
    * Learn the robot home.
    * 
    */
    public Integer learnHome() throws CallError, InterruptedException {
        return (Integer)service.call("learnHome").get();
    }

    /**
    * Is the robot in its home?
    * 
    */
    public Boolean isInCurrentHome() throws CallError, InterruptedException {
        return (Boolean)service.call("isInCurrentHome").get();
    }

    /**
    * Get some information about the current panorama.
    * 
    */
    public java.lang.Object getCurrentPanoramaDescriptor() throws CallError, InterruptedException {
        return (java.lang.Object)service.call("getCurrentPanoramaDescriptor").get();
    }

    /**
    * Get a frame buffer.
    * 
    */
    public java.lang.Object getFrame(Integer param1, String param2) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("getFrame", param1, param2).get();
    }

    /**
    * Delete all panoramas in a directory.
    * 
    * @param pDirectory  Name of the directory
    */
    public Integer clear(String pDirectory) throws CallError, InterruptedException {
        return (Integer)service.call("clear", pDirectory).get();
    }

    /**
    * Loads panoramas from a directory in the default one.
    * 
    * @param pDirectory  Name of the directory
    */
    public Integer load(String pDirectory) throws CallError, InterruptedException {
        return (Integer)service.call("load", pDirectory).get();
    }

    /**
    * Save the temporary panoramas in a directory from the default one.
    * 
    * @param pDirectory  Name of the directory
    */
    public Integer save(String pDirectory) throws CallError, InterruptedException {
        return (Integer)service.call("save", pDirectory).get();
    }

    /**
    * 
    * 
    */
    public Boolean isRelocalizationRequired() throws CallError, InterruptedException {
        return (Boolean)service.call("isRelocalizationRequired").get();
    }

    /**
    * 
    * 
    */
    public Boolean isDataAvailable() throws CallError, InterruptedException {
        return (Boolean)service.call("isDataAvailable").get();
    }

    /**
    * Get the robot position in world navigation.
    * 
    */
    public List<Float> getRobotPosition() throws CallError, InterruptedException {
        return (List<Float>)service.call("getRobotPosition").get();
    }

    /**
    * Get the robot position in world navigation.
    * 
    */
    public List<Float> getRobotPosition(Boolean param1) throws CallError, InterruptedException {
        return (List<Float>)service.call("getRobotPosition", param1).get();
    }

    /**
    * Get the robot orientation.
    * 
    */
    public java.lang.Object getRobotOrientation(Boolean param1) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("getRobotOrientation", param1).get();
    }

}
    