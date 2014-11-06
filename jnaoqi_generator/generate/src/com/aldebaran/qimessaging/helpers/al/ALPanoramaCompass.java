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
public class ALPanoramaCompass extends ALModule {

    public ALPanoramaCompass(Session session) {
        super(session);
    }

    /**
    * 
    * 
    */
    public Integer clearAllPanoramas(Boolean param1) throws CallError, InterruptedException {
        return (Integer)service.call("clearAllPanoramas", param1).get();
    }

    /**
    * Forces the robot to localize using the scan.
    * 
    */
    public List<Float> _launchLocalization() throws CallError, InterruptedException {
        return (List<Float>)service.call("_launchLocalization").get();
    }

    /**
    * Delete all files related to a given panorama in the current working directory
    * 
    * @param pIdentity  Panorama identity
    */
    public Integer clearPanorama(Integer pIdentity) throws CallError, InterruptedException {
        return (Integer)service.call("clearPanorama", pIdentity).get();
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
    * Shoot a panorama at the current position.
    * 
    */
    public Integer setupPanorama() throws CallError, InterruptedException {
        return (Integer)service.call("setupPanorama").get();
    }

    /**
    * Returns true if there is some panorama data
    * 
    */
    public Boolean isDataAvailable() throws CallError, InterruptedException {
        return (Boolean)service.call("isDataAvailable").get();
    }

    /**
    * Return the current orientation of the robot in the current panorama.
    * 
    */
    public java.lang.Object getCurrentPosition() throws CallError, InterruptedException {
        return (java.lang.Object)service.call("getCurrentPosition").get();
    }

    /**
    * Localize the robot using the scan,without hint.
    * 
    */
    public List<Float> localizeNoHint() throws CallError, InterruptedException {
        return (List<Float>)service.call("localizeNoHint").get();
    }

    /**
    * Localize the robot using the scan.
    * 
    * @param pMode  Localization mode
    */
    public List<Float> localize() throws CallError, InterruptedException {
        return (List<Float>)service.call("localize").get();
    }

    /**
    * Localize the robot using the scan.
    * 
    * @param pMode  Localization mode
    */
    public List<Float> localize(Boolean pMode) throws CallError, InterruptedException {
        return (List<Float>)service.call("localize", pMode).get();
    }

    /**
    * Localize the robot using the scan.
    * 
    * @param pMode  Localization mode
    */
    public List<Float> localize(Integer pMode) throws CallError, InterruptedException {
        return (List<Float>)service.call("localize", pMode).get();
    }

    /**
    * Localize the robot using the scan.
    * 
    * @param pMode  Localization mode
    */
    public List<Float> localize(Integer pMode, Boolean param1) throws CallError, InterruptedException {
        return (List<Float>)service.call("localize", pMode, param1).get();
    }

    /**
    * Check if the robot is in the current Panorama.
    * 
    * @return Error status.
    */
    public Integer isInPanorama() throws CallError, InterruptedException {
        return (Integer)service.call("isInPanorama").get();
    }

    /**
    * Is a relocalization movement required.
    * 
    */
    public Boolean isRelocalizationRequired() throws CallError, InterruptedException {
        return (Boolean)service.call("isRelocalizationRequired").get();
    }

    /**
    * Load the panorama corresponding to the input identity from the hard drive. It has to exist.
    * 
    * @param id  Identity of the requested Panorama.
    * @return Error status.
    */
    public Integer loadPanorama(Integer id) throws CallError, InterruptedException {
        return (Integer)service.call("loadPanorama", id).get();
    }

    /**
    * 
    * 
    * @return Return an ALValue containing Panorama identity and contained Frames identity.
    */
    public java.lang.Object getCurrentPanoramaDescriptor() throws CallError, InterruptedException {
        return (java.lang.Object)service.call("getCurrentPanoramaDescriptor").get();
    }

    /**
    * Return the Frame corresponding to the input identity. It have to be in the current Panorama
    * 
    * @param id  Identity of the resquested Frame.
    * @return ALValue containing the Frame image part.
    */
    public java.lang.Object getFrame(Integer id, String param1) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("getFrame", id, param1).get();
    }

    /**
    * Check if the robot is in the current Panorama.
    * 
    * @return Error status.
    */
    public Integer isInPanorama(Integer param1) throws CallError, InterruptedException {
        return (Integer)service.call("isInPanorama", param1).get();
    }

    /**
    * Delete all panorama files in the current working directory
    * 
    */
    public Integer clearAllPanoramas() throws CallError, InterruptedException {
        return (Integer)service.call("clearAllPanoramas").get();
    }

}
    