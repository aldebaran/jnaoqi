/**
 * Copyright (c) 2015 Aldebaran Robotics. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be
 * found in the COPYING file.
 * Created by epinault and tcruz
 */
package com.aldebaran.qi.helper.proxies;

import com.aldebaran.qi.CallError;
import com.aldebaran.qi.Session;
import com.aldebaran.qi.helper.ALProxy;

import java.util.List;
/**
* 
* @see <a href="http://doc.aldebaran.lan/doc/release-2.1/aldeb-doc/naoqi/core/worldrepresentation.html#alworldrepresentation">NAOqi APIs for ALWorldRepresentation </a>
*
*/
public class ALWorldRepresentation extends ALProxy {

    public ALWorldRepresentation(Session session) throws Exception{
        super(session);
    }

    /**
    * Get the position from one object to another.
    * 
    */
    public List<Float> getPosition6D(String param1, String param2) throws CallError, InterruptedException {
        return (List<Float>)call("getPosition6D", param1, param2).get();
    }

    /**
    * Select ordered information from a database.
    * 
    */
    public Object selectWithOrder(String param1, String param2, String param3, String param4, String param5) throws CallError, InterruptedException {
        return (Object)call("selectWithOrder", param1, param2, param3, param4, param5).get();
    }

    /**
    * 
    * 
    */
    public String getObjectParentName(String param1) throws CallError, InterruptedException {
        return (String)call("getObjectParentName", param1).get();
    }

    /**
    * 
    * 
    */
    public Integer storeObjectWithReference(String param1, String param2, String param3, List<Float> param4, String param5, Object param6) throws CallError, InterruptedException {
        return (Integer)call("storeObjectWithReference", param1, param2, param3, param4, param5, param6).get();
    }

    /**
    * 
    * 
    */
    public Integer storeObjectAttribute(String param1, String param2, Object param3) throws CallError, InterruptedException {
        return (Integer)call("storeObjectAttribute", param1, param2, param3).get();
    }

    /**
    * Get the name of the database where the object is stored.
    * 
    */
    public String getObjectCategory(String param1) throws CallError, InterruptedException {
        return (String)call("getObjectCategory", param1).get();
    }

    /**
    * Update the position of an object relative to another.
    * 
    */
    public Integer updatePositionWithReference(String param1, String param2, List<Float> param3, Boolean param4) throws CallError, InterruptedException {
        return (Integer)call("updatePositionWithReference", param1, param2, param3, param4).get();
    }

    /**
    * 
    * 
    */
    public Integer updateAttribute(String param1, String param2, String param3, Object param4) throws CallError, InterruptedException {
        return (Integer)call("updateAttribute", param1, param2, param3, param4).get();
    }

    /**
    * Get the position of an object with quaternion / translation.
    * 
    */
    public Object getPosition(String param1, String param2) throws CallError, InterruptedException {
        return (Object)call("getPosition", param1, param2).get();
    }

    /**
    * Get the interpolated position of an object
    * 
    */
    public List<Float> getPosition6DAtTime(String param1, String param2, Integer param3, Integer param4) throws CallError, InterruptedException {
        return (List<Float>)call("getPosition6DAtTime", param1, param2, param3, param4).get();
    }

    /**
    * 
    * 
    */
    public String getRootName() throws CallError, InterruptedException {
        return (String)call("getRootName").get();
    }

    /**
    * Get the name of the objects stored in the database.
    * 
    */
    public List<String> getObjectsInCategory(String param1) throws CallError, InterruptedException {
        return (List<String>)call("getObjectsInCategory", param1).get();
    }

    /**
    * 
    * 
    */
    public Integer save() throws CallError, InterruptedException {
        return (Integer)call("save").get();
    }

    /**
    * Select information from a database.
    * 
    */
    public Object select(String param1, String param2, String param3, String param4) throws CallError, InterruptedException {
        return (Object)call("select", param1, param2, param3, param4).get();
    }

    /**
    * 
    * 
    */
    public Integer storeObject(String param1, String param2, List<Float> param3, String param4, Object param5) throws CallError, InterruptedException {
        return (Integer)call("storeObject", param1, param2, param3, param4, param5).get();
    }

    /**
    * Update the position of an object.
    * 
    */
    public Integer updatePosition(String param1, List<Float> param2, Boolean param3) throws CallError, InterruptedException {
        return (Integer)call("updatePosition", param1, param2, param3).get();
    }

    /**
    * 
    * 
    */
    public Boolean isStatsEnabled() throws CallError, InterruptedException {
        return (Boolean)call("isStatsEnabled").get();
    }

    /**
    * 
    * 
    */
    public void clearStats() throws CallError, InterruptedException{
        call("clearStats").get();
    }

    /**
    * 
    * 
    */
    public Boolean isTraceEnabled() throws CallError, InterruptedException {
        return (Boolean)call("isTraceEnabled").get();
    }

    /**
    * Exits and unregisters the module.
    * 
    */
    public void exit() throws CallError, InterruptedException{
        call("exit").get();
    }

    /**
    * Returns the version of the module.
    * 
    * @return A string containing the version of the module.
    */
    public String version() throws CallError, InterruptedException {
        return (String)call("version").get();
    }

    /**
    * Just a ping. Always returns true
    * 
    * @return returns true
    */
    public Boolean ping() throws CallError, InterruptedException {
        return (Boolean)call("ping").get();
    }

    /**
    * Retrieves the module's method list.
    * 
    * @return An array of method names.
    */
    public List<String> getMethodList() throws CallError, InterruptedException {
        return (List<String>)call("getMethodList").get();
    }

    /**
    * Retrieves a method's description.
    * 
    * @param methodName  The name of the method.
    * @return A structure containing the method's description.
    */
    public Object getMethodHelp(String methodName) throws CallError, InterruptedException {
        return (Object)call("getMethodHelp", methodName).get();
    }

    /**
    * Retrieves the module's description.
    * 
    * @return A structure describing the module.
    */
    public Object getModuleHelp() throws CallError, InterruptedException {
        return (Object)call("getModuleHelp").get();
    }

    /**
    * Wait for the end of a long running method that was called using 'post'
    * 
    * @param id  The ID of the method that was returned when calling the method using 'post'
    * @param timeoutPeriod  The timeout period in ms. To wait indefinately, use a timeoutPeriod of zero.
    * @return True if the timeout period terminated. False if the method returned.
    */
    public Boolean wait(Integer id, Integer timeoutPeriod) throws CallError, InterruptedException {
        return (Boolean)call("wait", id, timeoutPeriod).get();
    }

    /**
    * Returns true if the method is currently running.
    * 
    * @param id  The ID of the method that was returned when calling the method using 'post'
    * @return True if the method is currently running
    */
    public Boolean isRunning(Integer id) throws CallError, InterruptedException {
        return (Boolean)call("isRunning", id).get();
    }

    /**
    * returns true if the method is currently running
    * 
    * @param id  the ID of the method to wait for
    */
    public void stop(Integer id) throws CallError, InterruptedException{
        call("stop", id).get();
    }

    /**
    * Gets the name of the parent broker.
    * 
    * @return The name of the parent broker.
    */
    public String getBrokerName() throws CallError, InterruptedException {
        return (String)call("getBrokerName").get();
    }

    /**
    * Gets the method usage string. This summarises how to use the method.
    * 
    * @param name  The name of the method.
    * @return A string that summarises the usage of the method.
    */
    public String getUsage(String name) throws CallError, InterruptedException {
        return (String)call("getUsage", name).get();
    }

    /**
    * Add an attribute to a category.
    * 
    */
    public Integer addAttributeToCategory(String param1, String param2, Object param3) throws CallError, InterruptedException {
        return (Integer)call("addAttributeToCategory", param1, param2, param3).get();
    }

    /**
    * Clear an object.
    * 
    */
    public Integer clearObject(String param1) throws CallError, InterruptedException {
        return (Integer)call("clearObject", param1).get();
    }

    /**
    * Clear recording of old positions.
    * 
    */
    public Integer clearOldPositions(String param1, Integer param2) throws CallError, InterruptedException {
        return (Integer)call("clearOldPositions", param1, param2).get();
    }

    /**
    * Create a new object category
    * 
    */
    public Integer createObjectCategory(String param1, Boolean param2) throws CallError, InterruptedException {
        return (Integer)call("createObjectCategory", param1, param2).get();
    }

    /**
    * Remove an object category
    * 
    */
    public Integer removeObjectCategory(String param1) throws CallError, InterruptedException {
        return (Integer)call("removeObjectCategory", param1).get();
    }

    /**
    * Tells if an object category exists
    * 
    */
    public Boolean objectCategoryExists(String param1) throws CallError, InterruptedException {
        return (Boolean)call("objectCategoryExists", param1).get();
    }

    /**
    * Delete an object attribute
    * 
    */
    public Integer deleteObjectAttribute(String param1, String param2, String param3) throws CallError, InterruptedException {
        return (Integer)call("deleteObjectAttribute", param1, param2, param3).get();
    }

    /**
    * Check that an object is present.
    * 
    */
    public Boolean findObject(String param1) throws CallError, InterruptedException {
        return (Boolean)call("findObject", param1).get();
    }

    /**
    * 
    * 
    */
    public Integer load() throws CallError, InterruptedException {
        return (Integer)call("load").get();
    }

    /**
    * Get all attributes from a category if it exists.
    * 
    */
    public Object getAttributesFromCategory(String param1) throws CallError, InterruptedException {
        return (Object)call("getAttributesFromCategory", param1).get();
    }

    /**
    * Get the direct children of an object.
    * 
    */
    public List<String> getChildrenNames(String param1) throws CallError, InterruptedException {
        return (List<String>)call("getChildrenNames", param1).get();
    }

    /**
    * Get the name of the objects.
    * 
    */
    public List<String> getObjectNames() throws CallError, InterruptedException {
        return (List<String>)call("getObjectNames").get();
    }

    /**
    * 
    * 
    */
    public Object getObjectAttributes(String param1) throws CallError, InterruptedException {
        return (Object)call("getObjectAttributes", param1).get();
    }

    /**
    * 
    * 
    */
    public Object getObjectAttributeValues(String param1, String param2, Integer param3) throws CallError, InterruptedException {
        return (Object)call("getObjectAttributeValues", param1, param2, param3).get();
    }

    /**
    * 
    * 
    */
    public Object getObjectLatestAttributes(String param1, Integer param2) throws CallError, InterruptedException {
        return (Object)call("getObjectLatestAttributes", param1, param2).get();
    }

}
    