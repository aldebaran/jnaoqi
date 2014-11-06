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
public class ALPreferenceManager extends ALModule {

    public ALPreferenceManager(Session session) {
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
    * Get specified preference
    * 
    * @param domain  Preference domain
    * @param setting  Preference setting
    * @return corresponding preferences value
    */
    public java.lang.Object getValue(String domain, String setting) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("getValue", domain, setting).get();
    }

    /**
    * Set specified preference
    * 
    * @param domain  Preference domain
    * @param setting  Preference setting
    * @param value  Preference value
    */
    public void setValue(String domain, String setting, java.lang.Object value) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setValue", domain, setting, value);
        else
            service.call("setValue", domain, setting, value).get();
    }

    /**
    * Get preferences names and values for a given domain
    * 
    * @param domain  Preference domain
    * @return a list of preferences names and values associated to the domain
    */
    public List<List<java.lang.Object>> getValueList(String domain) throws CallError, InterruptedException {
        return (List<List<java.lang.Object>>)service.call("getValueList", domain).get();
    }

    /**
    * Get available preferences domain
    * 
    * @return a list containing all the available domain names
    */
    public List<String> getDomainList() throws CallError, InterruptedException {
        return (List<String>)service.call("getDomainList").get();
    }

    /**
    * Remove specified preference
    * 
    * @param domain  Preference domain
    * @param setting  Preference setting
    */
    public void removeValue(String domain, String setting) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("removeValue", domain, setting);
        else
            service.call("removeValue", domain, setting).get();
    }

    /**
    * Remove an entire preference domain
    * 
    * @param domain  Preference domain
    */
    public void removeDomainValues(String domain) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("removeDomainValues", domain);
        else
            service.call("removeDomainValues", domain).get();
    }

    /**
    * Import a preferences XML file
    * 
    * @param domain  Preference domain: all preferences values found in XML file will be imported in that domain.
    * @param applicationName  Application name: will be used to search for preference file on disk (in location of type <configurationdirectory>/applicationName/filename).
    * @param filename  Preference XML filename
    * @param override  Set this to true if you want to override preferences that already exist with preferences in imported XML file
    */
    public void importPrefFile(String domain, String applicationName, String filename, Boolean override) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("importPrefFile", domain, applicationName, filename, override);
        else
            service.call("importPrefFile", domain, applicationName, filename, override).get();
    }

    /**
    * Synchronizes local preferences with preferences stored on a server.
    * 
    */
    public void update() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("update");
        else
            service.call("update").get();
    }

    /**
    * Update local preference from version store on Cloud (usefull when preference was updated on Cloud)
    * 
    * @param domain  Preference domain
    * @param setting  Preference setting
    * @param value  Preference value
    */
    public void _setFromCloud(String domain, String setting, java.lang.Object value) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_setFromCloud", domain, setting, value);
        else
            service.call("_setFromCloud", domain, setting, value).get();
    }

    /**
    * Restart preferences module
    * 
    * @param url  Preference server url
    * @param path  Path to sqlite database
    */
    public void _restart(String url, String path) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_restart", url, path);
        else
            service.call("_restart", url, path).get();
    }

}
    