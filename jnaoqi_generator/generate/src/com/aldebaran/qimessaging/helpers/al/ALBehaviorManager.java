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
public class ALBehaviorManager extends ALModule {

    public ALBehaviorManager(Session session) {
        super(session);
    }

    /**
    * Get tags found on installed behaviors.
    * 
    * @return The list of tags found.
    */
    public List<String> getTagList() throws CallError, InterruptedException {
        return (List<String>)service.call("getTagList").get();
    }

    /**
    * Set the given behavior as default
    * 
    * @param behavior  Behavior name 
    */
    public void addDefaultBehavior(String behavior) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("addDefaultBehavior", behavior);
        else
            service.call("addDefaultBehavior", behavior).get();
    }

    /**
    * Tell if supplied name corresponds to a running behavior
    * 
    * @param behavior  Behavior name 
    * @return Returns true if it is a running behavior
    */
    public Boolean isBehaviorRunning(String behavior) throws CallError, InterruptedException {
        return (Boolean)service.call("isBehaviorRunning", behavior).get();
    }

    /**
    * Get default behaviors
    * 
    * @return Return default behaviors
    */
    public List<String> getDefaultBehaviors() throws CallError, InterruptedException {
        return (List<String>)service.call("getDefaultBehaviors").get();
    }

    /**
    * Play default behaviors
    * 
    */
    public void playDefaultProject() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("playDefaultProject");
        else
            service.call("playDefaultProject").get();
    }

    /**
    * Get running behaviors
    * 
    * @return Return running behaviors
    */
    public List<String> getRunningBehaviors() throws CallError, InterruptedException {
        return (List<String>)service.call("getRunningBehaviors").get();
    }

    /**
    * get the FrameManagerID. INTERNAL
    * 
    * @param name  name of choregraphe project
    */
    public String _getBehaviorFrameManagerId(String name) throws CallError, InterruptedException {
        return (String)service.call("_getBehaviorFrameManagerId", name).get();
    }

    /**
    * Find out the actual <package>/<behavior> path behind a behavior name.
    * 
    * @param name  name of a behavior
    * @return The actual <package>/<behavior> path if found, else an empty string. Throws an ALERROR if two behavior names conflicted.
    */
    public String resolveBehaviorName(String name) throws CallError, InterruptedException {
        return (String)service.call("resolveBehaviorName", name).get();
    }

    /**
    * Get loaded behaviors
    * 
    * @return Return loaded behaviors
    */
    public List<String> getLoadedBehaviors() throws CallError, InterruptedException {
        return (List<String>)service.call("getLoadedBehaviors").get();
    }

    /**
    * Get tags found on the given behavior.
    * 
    * @param behavior  The local path towards a behavior or a directory.
    * @return The list of tags found.
    */
    public List<String> getBehaviorTags(String behavior) throws CallError, InterruptedException {
        return (List<String>)service.call("getBehaviorTags", behavior).get();
    }

    /**
    * Get the nature of the given behavior.
    * 
    * @param behavior  The local path towards a behavior or a directory.
    * @return The nature of the behavior.
    */
    public String getBehaviorNature(String behavior) throws CallError, InterruptedException {
        return (String)service.call("getBehaviorNature", behavior).get();
    }

    /**
    * Tell if supplied name corresponds to a loaded behavior
    * 
    * @param behavior  Behavior name 
    * @return Returns true if it is a loaded behavior
    */
    public Boolean isBehaviorLoaded(String behavior) throws CallError, InterruptedException {
        return (Boolean)service.call("isBehaviorLoaded", behavior).get();
    }

    /**
    * Get the relative path of a running behavior inside its package.
    * 
    * @param behaviorId  The ID of the behavior.
    * @return The relative path of the behavior.
    */
    public String _getBehaviorRelativePath(String behaviorId) throws CallError, InterruptedException {
        return (String)service.call("_getBehaviorRelativePath", behaviorId).get();
    }

    /**
    * Get the package UID of a running behavior.
    * 
    * @param behaviorId  The ID of the behavior.
    * @return The package UID of the behavior.
    */
    public String _getPackageUid(String behaviorId) throws CallError, InterruptedException {
        return (String)service.call("_getPackageUid", behaviorId).get();
    }

    /**
    * Remove the given behavior from the default behaviors
    * 
    * @param behavior  Behavior name 
    */
    public void removeDefaultBehavior(String behavior) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("removeDefaultBehavior", behavior);
        else
            service.call("removeDefaultBehavior", behavior).get();
    }

    /**
    * Be notified when something we have subscribe to has changed in ALMemory
    * 
    * @param dataName  name of the data
    * @param dataValue  value of the data
    * @param message  callback message
    */
    public void _onDataChanged(String dataName, java.lang.Object dataValue, String message) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_onDataChanged", dataName, dataValue, message);
        else
            service.call("_onDataChanged", dataName, dataValue, message).get();
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
    * Install a behavior.
Check the given local path for a valid behavior or package.
On success, behavior added or updated signal is emitted.
DEPRECATED in favor of PackageManager.install.
    * 
    * @param localPath  the relative destination path.
    * @return true on success, false on failure.
    */
    public Boolean installBehavior(String localPath) throws CallError, InterruptedException {
        return (Boolean)service.call("installBehavior", localPath).get();
    }

    /**
    * Install a behavior.
Check and take the behavior found at the given absolute path andimport it to the given local path, relative to behaviors path.
On success, behavior added signal is emitted before returning.DEPRECATED in favor of PackageManager.install.
    * 
    * @param absolutePath  a behavior on the local file system to install.
    * @param localPath  the relative destination path.
    * @param overwrite  whether to replace existing behavior if present.
    * @return true on success, false on failure.
    */
    public Boolean installBehavior(String absolutePath, String localPath, Boolean overwrite) throws CallError, InterruptedException {
        return (Boolean)service.call("installBehavior", absolutePath, localPath, overwrite).get();
    }

    /**
    * Load a behavior
    * 
    * @param behavior  Behavior name 
    * @return Returns true if it was successfully loaded.
    */
    public Boolean preloadBehavior(String behavior) throws CallError, InterruptedException {
        return (Boolean)service.call("preloadBehavior", behavior).get();
    }

    /**
    * Starts a behavior, returns when started.
    * 
    * @param behavior  Behavior name 
    */
    public void startBehavior(String behavior) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("startBehavior", behavior);
        else
            service.call("startBehavior", behavior).get();
    }

    /**
    * Runs a behavior, returns when finished
    * 
    * @param behavior  Behavior name 
    */
    public void runBehavior(String behavior) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("runBehavior", behavior);
        else
            service.call("runBehavior", behavior).get();
    }

    /**
    * Stop a behavior
    * 
    * @param behavior  Behavior name 
    */
    public void stopBehavior(String behavior) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("stopBehavior", behavior);
        else
            service.call("stopBehavior", behavior).get();
    }

    /**
    * Stop all behaviors
    * 
    */
    public void stopAllBehaviors() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("stopAllBehaviors");
        else
            service.call("stopAllBehaviors").get();
    }

    /**
    * Remove a behavior from the filesystem. DEPRECATED in favor of PackageManager.remove.
    * 
    * @param behavior  Behavior name 
    */
    public Boolean removeBehavior(String behavior) throws CallError, InterruptedException {
        return (Boolean)service.call("removeBehavior", behavior).get();
    }

    /**
    * Tell if supplied name corresponds to a behavior that has been installed
    * 
    * @param name  The behavior directory name
    * @return Returns true if it is a valid behavior
    */
    public Boolean isBehaviorInstalled(String name) throws CallError, InterruptedException {
        return (Boolean)service.call("isBehaviorInstalled", name).get();
    }

    /**
    * Tell if the supplied namecorresponds to an existing behavior.
    * 
    * @param prefixedBehavior  Prefixed behavior or just behavior's name (latter usage deprecated, in this case the behavior is searched for amongst user's behaviors, then in system behaviors) DEPRECATED in favor of ALBehaviorManager.isBehaviorInstalled.
    * @return Returns true if it is an existing behavior
    */
    public Boolean isBehaviorPresent(String prefixedBehavior) throws CallError, InterruptedException {
        return (Boolean)service.call("isBehaviorPresent", prefixedBehavior).get();
    }

    /**
    * Get behaviors
    * 
    * @return Returns the list of behaviors prefixed by their type (User/ or System/). DEPRECATED in favor of ALBehaviorManager.getInstalledBehaviors.
    */
    public List<String> getBehaviorNames() throws CallError, InterruptedException {
        return (List<String>)service.call("getBehaviorNames").get();
    }

    /**
    * Get user's behaviors
    * 
    * @return Returns the list of user's behaviors prefixed by User/. DEPRECATED in favor of ALBehaviorManager.getInstalledBehaviors.
    */
    public List<String> getUserBehaviorNames() throws CallError, InterruptedException {
        return (List<String>)service.call("getUserBehaviorNames").get();
    }

    /**
    * Get system behaviors
    * 
    * @return Returns the list of system behaviors prefixed by System/. DEPRECATED in favor of ALBehaviorManager.getInstalledBehaviors.
    */
    public List<String> getSystemBehaviorNames() throws CallError, InterruptedException {
        return (List<String>)service.call("getSystemBehaviorNames").get();
    }

    /**
    * Get installed behaviors directories names
    * 
    * @return Returns the behaviors list
    */
    public List<String> getInstalledBehaviors() throws CallError, InterruptedException {
        return (List<String>)service.call("getInstalledBehaviors").get();
    }

    /**
    * Get installed behaviors directories names and filter it by tag.
    * 
    * @param tag  A tag to filter the list with.
    * @return Returns the behaviors list
    */
    public List<String> getBehaviorsByTag(String tag) throws CallError, InterruptedException {
        return (List<String>)service.call("getBehaviorsByTag", tag).get();
    }

}
    