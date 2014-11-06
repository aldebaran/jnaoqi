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
public class ALFileManager extends ALModule {

    public ALFileManager(Session session) {
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
    * Set a new value of the user shared folder path.
    * 
    * @param fileName  Name of the module associate to the preference.
    */
    public void setUserSharedFolderPath(String fileName) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setUserSharedFolderPath", fileName);
        else
            service.call("setUserSharedFolderPath", fileName).get();
    }

    /**
    * Get the current user shared folder path.
    * 
    * @return User shared folder path string.
    */
    public String getUserSharedFolderPath() throws CallError, InterruptedException {
        return (String)service.call("getUserSharedFolderPath").get();
    }

    /**
    * Get the current system shared folder path.
    * 
    * @return System shared folder path string.
    */
    public String getSystemSharedFolderPath() throws CallError, InterruptedException {
        return (String)service.call("getSystemSharedFolderPath").get();
    }

    /**
    * Try to find if this file does exist on robot or not.
    * 
    * @param fileName  Name of the module associate to the preference.
    * @return True upon success
    */
    public Boolean fileExists(String fileName) throws CallError, InterruptedException {
        return (Boolean)service.call("fileExists", fileName).get();
    }

    /**
    * Try to find if this file does exist on robot or not.
    * 
    * @param fileName  Name of the module associate to the preference.
    * @return True upon success
    */
    public Boolean dataFileExists(String fileName) throws CallError, InterruptedException {
        return (Boolean)service.call("dataFileExists", fileName).get();
    }

    /**
    * Returns the complete path of the file if it does exist. Starts by looking in user's shared folder, then in system folder.
    * 
    * @param prefs  array reprenting the whole file.
    * @return True upon success
    */
    public String getFileCompletePath(String prefs) throws CallError, InterruptedException {
        return (String)service.call("getFileCompletePath", prefs).get();
    }

    /**
    * Returns the complete path of the file if it does exist. Starts by looking in user's shared folder, then in system folder.
    * 
    * @param prefs  array reprenting the whole file.
    * @return True upon success
    */
    public java.lang.Object getFileContents(String prefs) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("getFileContents", prefs).get();
    }

    /**
    * Returns the path to the directory where behaviors are stored on the robot.
    * 
    * @return The behaviors path, as an UTF-8 encoded string.
    */
    public String _getBehaviorsPath() throws CallError, InterruptedException {
        return (String)service.call("_getBehaviorsPath").get();
    }

    /**
    * Returns the path to the directory where box libraries are stored on the robot.
    * 
    * @return The box libraries path, as an UTF-8 encoded string.
    */
    public String _getBoxLibrariesPath() throws CallError, InterruptedException {
        return (String)service.call("_getBoxLibrariesPath").get();
    }

}
    