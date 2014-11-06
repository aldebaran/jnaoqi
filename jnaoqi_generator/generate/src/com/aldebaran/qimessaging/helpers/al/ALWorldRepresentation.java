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
public class ALWorldRepresentation extends ALModule {

    public ALWorldRepresentation(Session session) {
        super(session);
    }

    /**
    * Get the position from one object to another.
    * 
    */
    public List<Float> getPosition6D(String param1, String param2) throws CallError, InterruptedException {
        return (List<Float>)service.call("getPosition6D", param1, param2).get();
    }

    /**
    * Select ordered information from a database.
    * 
    */
    public java.lang.Object selectWithOrder(String param1, String param2, String param3, String param4, String param5) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("selectWithOrder", param1, param2, param3, param4, param5).get();
    }

    /**
    * 
    * 
    */
    public String getObjectParentName(String param1) throws CallError, InterruptedException {
        return (String)service.call("getObjectParentName", param1).get();
    }

    /**
    * 
    * 
    */
    public Integer storeObjectWithReference(String param1, String param2, String param3, List<Float> param4, String param5, java.lang.Object param6) throws CallError, InterruptedException {
        return (Integer)service.call("storeObjectWithReference", param1, param2, param3, param4, param5, param6).get();
    }

    /**
    * 
    * 
    */
    public Integer storeObjectAttribute(String param1, String param2, java.lang.Object param3) throws CallError, InterruptedException {
        return (Integer)service.call("storeObjectAttribute", param1, param2, param3).get();
    }

    /**
    * Get the name of the database where the object is stored.
    * 
    */
    public String getObjectCategory(String param1) throws CallError, InterruptedException {
        return (String)service.call("getObjectCategory", param1).get();
    }

    /**
    * Update the position of an object relative to another.
    * 
    */
    public Integer updatePositionWithReference(String param1, String param2, List<Float> param3, Boolean param4) throws CallError, InterruptedException {
        return (Integer)service.call("updatePositionWithReference", param1, param2, param3, param4).get();
    }

    /**
    * 
    * 
    */
    public Integer updateAttribute(String param1, String param2, String param3, java.lang.Object param4) throws CallError, InterruptedException {
        return (Integer)service.call("updateAttribute", param1, param2, param3, param4).get();
    }

    /**
    * 
    * 
    */
    public void _startMemoryCheck(Integer param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_startMemoryCheck", param1);
        else
            service.call("_startMemoryCheck", param1).get();
    }

    /**
    * 
    * 
    */
    public void _stopMemoryCheck() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_stopMemoryCheck");
        else
            service.call("_stopMemoryCheck").get();
    }

    /**
    * 
    * 
    */
    public Integer _beginTransaction(String param1) throws CallError, InterruptedException {
        return (Integer)service.call("_beginTransaction", param1).get();
    }

    /**
    * Get the position of an object with quaternion / translation.
    * 
    */
    public java.lang.Object getPosition(String param1, String param2) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("getPosition", param1, param2).get();
    }

    /**
    * Get the interpolated position of an object
    * 
    */
    public List<Float> getPosition6DAtTime(String param1, String param2, Integer param3, Integer param4) throws CallError, InterruptedException {
        return (List<Float>)service.call("getPosition6DAtTime", param1, param2, param3, param4).get();
    }

    /**
    * 
    * 
    */
    public String getRootName() throws CallError, InterruptedException {
        return (String)service.call("getRootName").get();
    }

    /**
    * Get the name of the objects stored in the database.
    * 
    */
    public List<String> getObjectsInCategory(String param1) throws CallError, InterruptedException {
        return (List<String>)service.call("getObjectsInCategory", param1).get();
    }

    /**
    * 
    * 
    */
    public Integer save() throws CallError, InterruptedException {
        return (Integer)service.call("save").get();
    }

    /**
    * Select information from a database.
    * 
    */
    public java.lang.Object select(String param1, String param2, String param3, String param4) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("select", param1, param2, param3, param4).get();
    }

    /**
    * 
    * 
    */
    public Integer storeObject(String param1, String param2, List<Float> param3, String param4, java.lang.Object param5) throws CallError, InterruptedException {
        return (Integer)service.call("storeObject", param1, param2, param3, param4, param5).get();
    }

    /**
    * 
    * 
    */
    public Integer _endTransaction(String param1) throws CallError, InterruptedException {
        return (Integer)service.call("_endTransaction", param1).get();
    }

    /**
    * Update the position of an object.
    * 
    */
    public Integer updatePosition(String param1, List<Float> param2, Boolean param3) throws CallError, InterruptedException {
        return (Integer)service.call("updatePosition", param1, param2, param3).get();
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
    * Add an attribute to a category.
    * 
    */
    public Integer addAttributeToCategory(String param1, String param2, java.lang.Object param3) throws CallError, InterruptedException {
        return (Integer)service.call("addAttributeToCategory", param1, param2, param3).get();
    }

    /**
    * Clear an object.
    * 
    */
    public Integer clearObject(String param1) throws CallError, InterruptedException {
        return (Integer)service.call("clearObject", param1).get();
    }

    /**
    * Clear recording of old positions.
    * 
    */
    public Integer clearOldPositions(String param1, Integer param2) throws CallError, InterruptedException {
        return (Integer)service.call("clearOldPositions", param1, param2).get();
    }

    /**
    * Create a new object category
    * 
    */
    public Integer createObjectCategory(String param1, Boolean param2) throws CallError, InterruptedException {
        return (Integer)service.call("createObjectCategory", param1, param2).get();
    }

    /**
    * Remove an object category
    * 
    */
    public Integer removeObjectCategory(String param1) throws CallError, InterruptedException {
        return (Integer)service.call("removeObjectCategory", param1).get();
    }

    /**
    * Tells if an object category exists
    * 
    */
    public Boolean objectCategoryExists(String param1) throws CallError, InterruptedException {
        return (Boolean)service.call("objectCategoryExists", param1).get();
    }

    /**
    * Delete an object attribute
    * 
    */
    public Integer deleteObjectAttribute(String param1, String param2, String param3) throws CallError, InterruptedException {
        return (Integer)service.call("deleteObjectAttribute", param1, param2, param3).get();
    }

    /**
    * Check that an object is present.
    * 
    */
    public Boolean findObject(String param1) throws CallError, InterruptedException {
        return (Boolean)service.call("findObject", param1).get();
    }

    /**
    * 
    * 
    */
    public Integer load() throws CallError, InterruptedException {
        return (Integer)service.call("load").get();
    }

    /**
    * Get all attributes from a category if it exists.
    * 
    */
    public java.lang.Object getAttributesFromCategory(String param1) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("getAttributesFromCategory", param1).get();
    }

    /**
    * Get the direct children of an object.
    * 
    */
    public List<String> getChildrenNames(String param1) throws CallError, InterruptedException {
        return (List<String>)service.call("getChildrenNames", param1).get();
    }

    /**
    * Get the name of the objects.
    * 
    */
    public List<String> getObjectNames() throws CallError, InterruptedException {
        return (List<String>)service.call("getObjectNames").get();
    }

    /**
    * 
    * 
    */
    public java.lang.Object getObjectAttributes(String param1) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("getObjectAttributes", param1).get();
    }

    /**
    * 
    * 
    */
    public java.lang.Object getObjectAttributeValues(String param1, String param2, Integer param3) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("getObjectAttributeValues", param1, param2, param3).get();
    }

    /**
    * 
    * 
    */
    public java.lang.Object getObjectLatestAttributes(String param1, Integer param2) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("getObjectLatestAttributes", param1, param2).get();
    }

}
    