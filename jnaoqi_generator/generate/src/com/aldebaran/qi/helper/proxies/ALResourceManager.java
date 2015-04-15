/**
 * Copyright (c) 2015 Aldebaran Robotics. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be
 * found in the COPYING file.
 * Created by epinault and tcruz
 */
package com.aldebaran.qi.helper.proxies;

import com.aldebaran.qi.CallError;
import com.aldebaran.qi.Future;
import com.aldebaran.qi.Session;
import com.aldebaran.qi.helper.ALProxy;

import java.util.List;
/**
* Manage robot resources: Synchronize movement, led, sound. Run specific actions when another behavior wants your resources
* @see <a href="http://doc.aldebaran.com/2-1/naoqi/core/alresourcemanager.html#alresourcemanager">NAOqi APIs for ALResourceManager </a>
*
*/
public class ALResourceManager extends ALProxy {

    private AsyncALResourceManager asyncProxy;

    public ALResourceManager(Session session) throws Exception{
        super(session);
        asyncProxy = new AsyncALResourceManager();
	    asyncProxy.setService(getService());
    }

    /**
     * Get the async version of this proxy
     *
	 * @return a AsyncALResourceManager object
	 */
    public AsyncALResourceManager async() {
        return asyncProxy;
    }

    /**
    * True if a resource is in another parent resource
    * 
    * @param resourceGroupName  Group name. Ex: Arm
    * @param resourceName  Resource name
    */
    public void createResourcesList(List<String> resourceGroupName, String resourceName) throws CallError, InterruptedException{
        call("createResourcesList", resourceGroupName, resourceName).get();
    }

    /**
    * The tree of the resources owners.
    * 
    */
    public Object ownersGet() throws CallError, InterruptedException {
        return (Object)call("ownersGet").get();
    }

    /**
    * Get tree of resources
    * 
    */
    public Object getResources() throws CallError, InterruptedException {
        return (Object)call("getResources").get();
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
    * Wait resource
    * 
    * @param resourceName  Resource name
    * @param ownerName  Module name
    * @param callbackName  callback name
    * @param timeoutSeconds  Timeout in seconds
    */
    public void waitForResource(String resourceName, String ownerName, String callbackName, Integer timeoutSeconds) throws CallError, InterruptedException{
        call("waitForResource", resourceName, ownerName, callbackName, timeoutSeconds).get();
    }

    /**
    * Wait and acquire a resource
    * 
    * @param resourceName  Resource name
    * @param moduleName  Module name
    * @param callbackName  callback name
    * @param timeoutSeconds  Timeout in seconds
    */
    public void acquireResource(String resourceName, String moduleName, String callbackName, Integer timeoutSeconds) throws CallError, InterruptedException{
        call("acquireResource", resourceName, moduleName, callbackName, timeoutSeconds).get();
    }

    /**
    * Wait resource
    * 
    */
    public List<String> waitForOptionalResourcesTree(List<String> param1, String param2, String param3, Integer param4, List<String> param5) throws CallError, InterruptedException {
        return (List<String>)call("waitForOptionalResourcesTree", param1, param2, param3, param4, param5).get();
    }

    /**
    * Wait for resource tree. Parent and children are not in conflict. Local function
    * 
    * @param resourceName  Resource name
    * @param moduleName  Module name
    * @param callbackName  callback name
    * @param timeoutSeconds  Timeout in seconds
    */
    public void waitForResourcesTree(List<String> resourceName, String moduleName, String callbackName, Integer timeoutSeconds) throws CallError, InterruptedException{
        call("waitForResourcesTree", resourceName, moduleName, callbackName, timeoutSeconds).get();
    }

    /**
    * Wait for resource tree. Parent and children are not in conflict. Local function
    * 
    * @param resourceName  Resource name
    * @param moduleName  Module name
    * @param callbackName  callback name
    * @param timeoutSeconds  Timeout in seconds
    */
    public void acquireResourcesTree(List<String> resourceName, String moduleName, String callbackName, Integer timeoutSeconds) throws CallError, InterruptedException{
        call("acquireResourcesTree", resourceName, moduleName, callbackName, timeoutSeconds).get();
    }

    /**
    * True if all the specified resources are owned by the owner
    * 
    * @param resourceNameList  Resource name
    * @param ownerName  Owner pointer with hierarchy
    * @return True if all the specify resources are owned by the owner
    */
    public Boolean areResourcesOwnedBy(List<String> resourceNameList, String ownerName) throws CallError, InterruptedException {
        return (Boolean)call("areResourcesOwnedBy", resourceNameList, ownerName).get();
    }

    /**
    * Release resource
    * 
    * @param resourceName  Resource name
    * @param ownerName  Existing owner name
    */
    public void releaseResource(String resourceName, String ownerName) throws CallError, InterruptedException{
        call("releaseResource", resourceName, ownerName).get();
    }

    /**
    * Release  resources list
    * 
    * @param resourceNames  Resource names
    * @param ownerName  Owner name
    */
    public void releaseResources(List<String> resourceNames, String ownerName) throws CallError, InterruptedException{
        call("releaseResources", resourceNames, ownerName).get();
    }

    /**
    * Enable or disable a state resource
    * 
    * @param resourceName  The name of the resource that you wish enable of disable. e.g. Standing
    * @param enabled  True to enable, false to disable
    */
    public void enableStateResource(String resourceName, Boolean enabled) throws CallError, InterruptedException{
        call("enableStateResource", resourceName, enabled).get();
    }

    /**
    * check if all the state resource in the list are free
    * 
    * @param resourceName  Resource name
    */
    public Boolean checkStateResourceFree(List<String> resourceName) throws CallError, InterruptedException {
        return (Boolean)call("checkStateResourceFree", resourceName).get();
    }

    /**
    * True if all resources are free
    * 
    * @param resourceNames  Resource names
    * @return True if all the specify resources are free
    */
    public Boolean areResourcesFree(List<String> resourceNames) throws CallError, InterruptedException {
        return (Boolean)call("areResourcesFree", resourceNames).get();
    }

    /**
    * True if the resource is free
    * 
    * @param resourceNames  Resource name
    * @return True if the specify resources is free
    */
    public Boolean isResourceFree(String resourceNames) throws CallError, InterruptedException {
        return (Boolean)call("isResourceFree", resourceNames).get();
    }

    /**
    * Create a resource
    * 
    * @param resourceName  Resource name to create
    * @param parentResourceName  Parent resource name or empty string for root resource
    */
    public void createResource(String resourceName, String parentResourceName) throws CallError, InterruptedException{
        call("createResource", resourceName, parentResourceName).get();
    }

    /**
    * Delete a root resource
    * 
    * @param resourceName  Resource name to delete
    * @param deleteChildResources  DEPRECATED: Delete child resources if true
    */
    public void deleteResource(String resourceName, Boolean deleteChildResources) throws CallError, InterruptedException{
        call("deleteResource", resourceName, deleteChildResources).get();
    }

    /**
    * True if a resource is in another parent resource
    * 
    * @param resourceGroupName  Group name. Ex: Arm
    * @param resourceName  Resource name
    */
    public Boolean isInGroup(String resourceGroupName, String resourceName) throws CallError, InterruptedException {
        return (Boolean)call("isInGroup", resourceGroupName, resourceName).get();
    }


    public class AsyncALResourceManager extends ALProxy {

        protected AsyncALResourceManager(){
            super();
        }
    
    /**
    * True if a resource is in another parent resource
    * 
    * @param resourceGroupName  Group name. Ex: Arm
    * @param resourceName  Resource name
    * @return The Future
    */
    public Future<Void> createResourcesList(List<String> resourceGroupName, String resourceName) throws CallError, InterruptedException{
        return call("createResourcesList", resourceGroupName, resourceName);
    }

    /**
    * The tree of the resources owners.
    * 
    */
    public Future<Object> ownersGet() throws CallError, InterruptedException {
        return call("ownersGet");
    }

    /**
    * Get tree of resources
    * 
    */
    public Future<Object> getResources() throws CallError, InterruptedException {
        return call("getResources");
    }

    /**
    * 
    * 
    */
    public Future<Boolean> isStatsEnabled() throws CallError, InterruptedException {
        return call("isStatsEnabled");
    }

    /**
    * 
    * 
    * @return The Future
    */
    public Future<Void> clearStats() throws CallError, InterruptedException{
        return call("clearStats");
    }

    /**
    * 
    * 
    */
    public Future<Boolean> isTraceEnabled() throws CallError, InterruptedException {
        return call("isTraceEnabled");
    }

    /**
    * Exits and unregisters the module.
    * 
    * @return The Future
    */
    public Future<Void> exit() throws CallError, InterruptedException{
        return call("exit");
    }

    /**
    * Returns the version of the module.
    * 
    * @return A string containing the version of the module.
    */
    public Future<String> version() throws CallError, InterruptedException {
        return call("version");
    }

    /**
    * Just a ping. Always returns true
    * 
    * @return returns true
    */
    public Future<Boolean> ping() throws CallError, InterruptedException {
        return call("ping");
    }

    /**
    * Retrieves the module's method list.
    * 
    * @return An array of method names.
    */
    public Future<List<String>> getMethodList() throws CallError, InterruptedException {
        return call("getMethodList");
    }

    /**
    * Retrieves a method's description.
    * 
    * @param methodName  The name of the method.
    * @return A structure containing the method's description.
    */
    public Future<Object> getMethodHelp(String methodName) throws CallError, InterruptedException {
        return call("getMethodHelp", methodName);
    }

    /**
    * Retrieves the module's description.
    * 
    * @return A structure describing the module.
    */
    public Future<Object> getModuleHelp() throws CallError, InterruptedException {
        return call("getModuleHelp");
    }

    /**
    * Wait for the end of a long running method that was called using 'post'
    * 
    * @param id  The ID of the method that was returned when calling the method using 'post'
    * @param timeoutPeriod  The timeout period in ms. To wait indefinately, use a timeoutPeriod of zero.
    * @return True if the timeout period terminated. False if the method returned.
    */
    public Future<Boolean> wait(Integer id, Integer timeoutPeriod) throws CallError, InterruptedException {
        return call("wait", id, timeoutPeriod);
    }

    /**
    * Returns true if the method is currently running.
    * 
    * @param id  The ID of the method that was returned when calling the method using 'post'
    * @return True if the method is currently running
    */
    public Future<Boolean> isRunning(Integer id) throws CallError, InterruptedException {
        return call("isRunning", id);
    }

    /**
    * returns true if the method is currently running
    * 
    * @param id  the ID of the method to wait for
    * @return The Future
    */
    public Future<Void> stop(Integer id) throws CallError, InterruptedException{
        return call("stop", id);
    }

    /**
    * Gets the name of the parent broker.
    * 
    * @return The name of the parent broker.
    */
    public Future<String> getBrokerName() throws CallError, InterruptedException {
        return call("getBrokerName");
    }

    /**
    * Gets the method usage string. This summarises how to use the method.
    * 
    * @param name  The name of the method.
    * @return A string that summarises the usage of the method.
    */
    public Future<String> getUsage(String name) throws CallError, InterruptedException {
        return call("getUsage", name);
    }

    /**
    * Wait resource
    * 
    * @param resourceName  Resource name
    * @param ownerName  Module name
    * @param callbackName  callback name
    * @param timeoutSeconds  Timeout in seconds
    * @return The Future
    */
    public Future<Void> waitForResource(String resourceName, String ownerName, String callbackName, Integer timeoutSeconds) throws CallError, InterruptedException{
        return call("waitForResource", resourceName, ownerName, callbackName, timeoutSeconds);
    }

    /**
    * Wait and acquire a resource
    * 
    * @param resourceName  Resource name
    * @param moduleName  Module name
    * @param callbackName  callback name
    * @param timeoutSeconds  Timeout in seconds
    * @return The Future
    */
    public Future<Void> acquireResource(String resourceName, String moduleName, String callbackName, Integer timeoutSeconds) throws CallError, InterruptedException{
        return call("acquireResource", resourceName, moduleName, callbackName, timeoutSeconds);
    }

    /**
    * Wait resource
    * 
    */
    public Future<List<String>> waitForOptionalResourcesTree(List<String> param1, String param2, String param3, Integer param4, List<String> param5) throws CallError, InterruptedException {
        return call("waitForOptionalResourcesTree", param1, param2, param3, param4, param5);
    }

    /**
    * Wait for resource tree. Parent and children are not in conflict. Local function
    * 
    * @param resourceName  Resource name
    * @param moduleName  Module name
    * @param callbackName  callback name
    * @param timeoutSeconds  Timeout in seconds
    * @return The Future
    */
    public Future<Void> waitForResourcesTree(List<String> resourceName, String moduleName, String callbackName, Integer timeoutSeconds) throws CallError, InterruptedException{
        return call("waitForResourcesTree", resourceName, moduleName, callbackName, timeoutSeconds);
    }

    /**
    * Wait for resource tree. Parent and children are not in conflict. Local function
    * 
    * @param resourceName  Resource name
    * @param moduleName  Module name
    * @param callbackName  callback name
    * @param timeoutSeconds  Timeout in seconds
    * @return The Future
    */
    public Future<Void> acquireResourcesTree(List<String> resourceName, String moduleName, String callbackName, Integer timeoutSeconds) throws CallError, InterruptedException{
        return call("acquireResourcesTree", resourceName, moduleName, callbackName, timeoutSeconds);
    }

    /**
    * True if all the specified resources are owned by the owner
    * 
    * @param resourceNameList  Resource name
    * @param ownerName  Owner pointer with hierarchy
    * @return True if all the specify resources are owned by the owner
    */
    public Future<Boolean> areResourcesOwnedBy(List<String> resourceNameList, String ownerName) throws CallError, InterruptedException {
        return call("areResourcesOwnedBy", resourceNameList, ownerName);
    }

    /**
    * Release resource
    * 
    * @param resourceName  Resource name
    * @param ownerName  Existing owner name
    * @return The Future
    */
    public Future<Void> releaseResource(String resourceName, String ownerName) throws CallError, InterruptedException{
        return call("releaseResource", resourceName, ownerName);
    }

    /**
    * Release  resources list
    * 
    * @param resourceNames  Resource names
    * @param ownerName  Owner name
    * @return The Future
    */
    public Future<Void> releaseResources(List<String> resourceNames, String ownerName) throws CallError, InterruptedException{
        return call("releaseResources", resourceNames, ownerName);
    }

    /**
    * Enable or disable a state resource
    * 
    * @param resourceName  The name of the resource that you wish enable of disable. e.g. Standing
    * @param enabled  True to enable, false to disable
    * @return The Future
    */
    public Future<Void> enableStateResource(String resourceName, Boolean enabled) throws CallError, InterruptedException{
        return call("enableStateResource", resourceName, enabled);
    }

    /**
    * check if all the state resource in the list are free
    * 
    * @param resourceName  Resource name
    */
    public Future<Boolean> checkStateResourceFree(List<String> resourceName) throws CallError, InterruptedException {
        return call("checkStateResourceFree", resourceName);
    }

    /**
    * True if all resources are free
    * 
    * @param resourceNames  Resource names
    * @return True if all the specify resources are free
    */
    public Future<Boolean> areResourcesFree(List<String> resourceNames) throws CallError, InterruptedException {
        return call("areResourcesFree", resourceNames);
    }

    /**
    * True if the resource is free
    * 
    * @param resourceNames  Resource name
    * @return True if the specify resources is free
    */
    public Future<Boolean> isResourceFree(String resourceNames) throws CallError, InterruptedException {
        return call("isResourceFree", resourceNames);
    }

    /**
    * Create a resource
    * 
    * @param resourceName  Resource name to create
    * @param parentResourceName  Parent resource name or empty string for root resource
    * @return The Future
    */
    public Future<Void> createResource(String resourceName, String parentResourceName) throws CallError, InterruptedException{
        return call("createResource", resourceName, parentResourceName);
    }

    /**
    * Delete a root resource
    * 
    * @param resourceName  Resource name to delete
    * @param deleteChildResources  DEPRECATED: Delete child resources if true
    * @return The Future
    */
    public Future<Void> deleteResource(String resourceName, Boolean deleteChildResources) throws CallError, InterruptedException{
        return call("deleteResource", resourceName, deleteChildResources);
    }

    /**
    * True if a resource is in another parent resource
    * 
    * @param resourceGroupName  Group name. Ex: Arm
    * @param resourceName  Resource name
    */
    public Future<Boolean> isInGroup(String resourceGroupName, String resourceName) throws CallError, InterruptedException {
        return call("isInGroup", resourceGroupName, resourceName);
    }

    }
}
    