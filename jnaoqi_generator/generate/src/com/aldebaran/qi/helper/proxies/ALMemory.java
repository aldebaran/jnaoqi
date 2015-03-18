/**
 * Copyright (c) 2015 Aldebaran Robotics. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be
 * found in the COPYING file.
 * Created by epinault and tcruz
 */
package com.aldebaran.qi.helper.proxies;

import com.aldebaran.qi.AnyObject;
import com.aldebaran.qi.CallError;
import com.aldebaran.qi.Session;
import com.aldebaran.qi.helper.ALMemoryHelper;

import java.util.List;
import java.util.Map;
/**
* ALMemory provides a centralized memory that can be used to store and retrieve named values. It also acts as a hub for the distribution of event notifications.
* @see <a href="http://doc.aldebaran.lan/doc/release-2.1/aldeb-doc/naoqi/core/almemory.html#almemory">NAOqi APIs for ALMemory </a>
*
*/
public class ALMemory extends ALMemoryHelper {

    public ALMemory(Session session) throws Exception{
        super(session);
    }

    /**
    * Inserts a key-value pair into memory, where value is a string
    * 
    * @param key  Name of the value to be inserted.
    * @param value  The string to be inserted
    */
    public void insertData(String key, String value) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("insertData", key, value);
        else
            call("insertData", key, value).get();
    }

    /**
    * Removes a key-value pair from memory
    * 
    * @param key  Name of the data to be removed.
    */
    public void removeData(String key) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("removeData", key);
        else
            call("removeData", key).get();
    }

    /**
    * Gets a list containing the names of subscribers to an event.
    * 
    * @param name  Name of the event or micro-event
    * @return List of subscriber names
    */
    public List<String> getSubscribers(String name) throws CallError, InterruptedException {
        return (List<String>)call("getSubscribers", name).get();
    }

    /**
    * Removes a micro event from memory and unsubscribes any exiting subscribers.
    * 
    * @param name  Name of the event to remove.
    */
    public void removeMicroEvent(String name) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("removeMicroEvent", name);
        else
            call("removeMicroEvent", name).get();
    }

    /**
    * Subscribes to an event and automaticaly launches the module that declared itself as the generator of the event if required.
    * 
    * @param name  The name of the event to subscribe to
    * @param callbackModule  Name of the module to call with notifications
    * @param callbackMethod  Name of the module's method to call when a data is changed
    */
    public void subscribeToEvent(String name, String callbackModule, String callbackMethod) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("subscribeToEvent", name, callbackModule, callbackMethod);
        else
            call("subscribeToEvent", name, callbackModule, callbackMethod).get();
    }

    /**
    * Inserts a key-value pair into memory, where value is an int
    * 
    * @param key  Name of the value to be inserted.
    * @param value  The int to be inserted
    */
    public void insertData(String key, Integer value) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("insertData", key, value);
        else
            call("insertData", key, value).get();
    }

    /**
    * Subscribes to a microEvent. Subscribed modules are notified on theircallback method whenever the data is updated, even if the new value is the same as the old value.
    * 
    * @param name  Name of the data.
    * @param callbackModule  Name of the module to call with notifications
    * @param callbackMessage  Message included in the notification. This can be used to disambiguate multiple subscriptions.
    * @param callbackMethod  Name of the module's method to call when a data is changed
    */
    public void subscribeToMicroEvent(String name, String callbackModule, String callbackMessage, String callbackMethod) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("subscribeToMicroEvent", name, callbackModule, callbackMessage, callbackMethod);
        else
            call("subscribeToMicroEvent", name, callbackModule, callbackMessage, callbackMethod).get();
    }

    /**
    * Informs ALMemory that a module doesn't exist anymore.
    * 
    * @param moduleName  Name of the departing module.
    */
    public void unregisterModuleReference(String moduleName) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("unregisterModuleReference", moduleName);
        else
            call("unregisterModuleReference", moduleName).get();
    }

    /**
    * Unsubscribes a module from the given event. No further notifications will be received.
    * 
    * @param name  The name of the event
    * @param callbackModule  The name of the module that was given when subscribing.
    */
    public void unsubscribeToEvent(String name, String callbackModule) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("unsubscribeToEvent", name, callbackModule);
        else
            call("unsubscribeToEvent", name, callbackModule).get();
    }

    /**
    * Unsubscribes from the given event. No further notifications will be received.
    * 
    * @param name  Name of the event.
    * @param callbackModule  The name of the module that was given when subscribing.
    */
    public void unsubscribeToMicroEvent(String name, String callbackModule) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("unsubscribeToMicroEvent", name, callbackModule);
        else
            call("unsubscribeToMicroEvent", name, callbackModule).get();
    }

    /**
    * Inserts a key-value pair into memory, where value is a float
    * 
    * @param key  Name of the value to be inserted.
    * @param value  The float to be inserted
    */
    public void insertData(String key, Float value) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("insertData", key, value);
        else
            call("insertData", key, value).get();
    }

    /**
    * Describe a key
    * 
    * @param name  Name of the key.
    * @param description  The description of the event (text format).
    */
    public void setDescription(String name, String description) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("setDescription", name, description);
        else
            call("setDescription", name, description).get();
    }

    /**
    * Descriptions of all given keys
    * 
    * @param keylist  List of keys. (empty to get all descriptions)
    * @return an array of tuple (name, type, description) describing all keys.
    */
    public Object getDescriptionList(List<String> keylist) throws CallError, InterruptedException {
        return (Object)call("getDescriptionList", keylist).get();
    }

    /**
    * Add a mapping between signal and event
    * 
    * @param service  Name of the service
    * @param signal  Name of the signal
    * @param event  Name of the event
    */
    public void addMapping(String serviceName, String signal, String event) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("addMapping", serviceName, signal, event);
        else
            call("addMapping", serviceName, signal, event).get();
    }

    /**
    * Add a mapping between signal and event
    * 
    * @param service  Name of the service
    * @param signalEvent  A map of signal corresponding to event
    */
    public void addMapping(String serviceName, Map<String, String> signalEvent) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("addMapping", serviceName, signalEvent);
        else
            call("addMapping", serviceName, signalEvent).get();
    }

    /**
    * Inserts a key-value pair into memory, where value is an ALValue
    * 
    * @param key  Name of the value to be inserted.
    * @param data  The ALValue to be inserted. This could contain a basic type, or a more complex array. See the ALValue documentation for more information.
    */
    public void insertData(String key, Object data) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("insertData", key, data);
        else
            call("insertData", key, data).get();
    }

    /**
    * Inserts a list of key-value pairs into memory.
    * 
    * @param list  An ALValue list of the form [[Key, Value],...]. Each item will be inserted.
    */
    public void insertListData(Object list) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("insertListData", list);
        else
            call("insertListData", list).get();
    }

    /**
    * Gets the storage class of the stored data. This is not the underlying POD type.
    * 
    * @param key  Name of the variable
    * @return String type: Data, Event, MicroEvent
    */
    public String getType(String key) throws CallError, InterruptedException {
        return (String)call("getType", key).get();
    }

    /**
    * Publishes the given data to all subscribers.
    * 
    * @param name  Name of the event to raise.
    * @param value  The data associated with the event. This could contain a basic type, or a more complex array. See the ALValue documentation for more information.
    */
    public void raiseEvent(String name, Object value) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("raiseEvent", name, value);
        else
            call("raiseEvent", name, value).get();
    }

    /**
    * Publishes the given data to all subscribers.
    * 
    * @param name  Name of the event to raise.
    * @param value  The data associated with the event. This could contain a basic type, or a more complex array. See the ALValue documentation for more information.
    */
    public void raiseMicroEvent(String name, Object value) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("raiseMicroEvent", name, value);
        else
            call("raiseMicroEvent", name, value).get();
    }

    /**
    * Removes a event from memory and unsubscribes any exiting subscribers.
    * 
    * @param name  Name of the event to remove.
    */
    public void removeEvent(String name) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("removeEvent", name);
        else
            call("removeEvent", name).get();
    }

    /**
    * DEPRECATED Subscribes to event and automaticaly launches the module capable of generating the event if it is not already running. Please use the version without the callbackMessage parameter.
    * 
    * @param name  The name of the event to subscribe to
    * @param callbackModule  Name of the module to call with notifications
    * @param callbackMessage  DEPRECATED Message included in the notification.
    * @param callbacMethod  Name of the module's method to call when a data is changed
    */
    public void subscribeToEvent(String name, String callbackModule, String callbackMessage, String callbacMethod) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("subscribeToEvent", name, callbackModule, callbackMessage, callbacMethod);
        else
            call("subscribeToEvent", name, callbackModule, callbackMessage, callbacMethod).get();
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
        if (isAsynchronous)
            call("clearStats");
        else
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
        if (isAsynchronous)
            call("exit");
        else
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
        if (isAsynchronous)
            call("stop", id);
        else
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
    * Declares an event to allow future subscriptions to the event
    * 
    * @param eventName  The name of the event
    */
    public void declareEvent(String eventName) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("declareEvent", eventName);
        else
            call("declareEvent", eventName).get();
    }

    /**
    * Declares an event to allow future subscriptions to the event
    * 
    * @param eventName  The name of the event
    * @param extractorName  The name of the extractor capable of creating the event
    */
    public void declareEvent(String eventName, String extractorName) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("declareEvent", eventName, extractorName);
        else
            call("declareEvent", eventName, extractorName).get();
    }

    /**
    * Gets the value of a key-value pair stored in memory
    * 
    * @param key  Name of the value.
    * @return The data as an ALValue. This can often be cast transparently into the original type.
    */
    public Object getData(String key) throws CallError, InterruptedException {
        return (Object)call("getData", key).get();
    }

    /**
    * DEPRECATED - Gets the value of a key-value pair stored in memory. Please use the version of this method with no second parameter.
    * 
    * @param key  Name of the value.
    * @param deprecatedParameter  DEPRECATED - This parameter has no effect, but is left for compatibility reason.
    * @return The data as an ALValue
    */
    public Object getData(String key, Integer deprecatedParameter) throws CallError, InterruptedException {
        return (Object)call("getData", key, deprecatedParameter).get();
    }

    /**
    * Get an object wrapping a signal bound to the given ALMemory event. Throw if the event does not exist or if it is invalid.
    * 
    * @param eventName  Name of the ALMemory event
    * @return An AnyObject with a signal named "signal"
    */
    public AnyObject subscriber(String eventName) throws CallError, InterruptedException {
        return (AnyObject)call("subscriber", eventName).get();
    }

    /**
    * Get data value and timestamp
    * 
    * @param key  Name of the variable
    * @return A list of all the data key names that contain the given string.
    */
    public Object getTimestamp(String key) throws CallError, InterruptedException {
        return (Object)call("getTimestamp", key).get();
    }

    /**
    * Get data value and timestamp
    * 
    * @param key  Name of the variable
    * @return A list of all the data key names that contain the given string.
    */
    public Object getEventHistory(String key) throws CallError, InterruptedException {
        return (Object)call("getEventHistory", key).get();
    }

    /**
    * Gets a list of all key names that contain a given string
    * 
    * @param filter  A string used as the search term
    * @return A list of all the data key names that contain the given string.
    */
    public List<String> getDataList(String filter) throws CallError, InterruptedException {
        return (List<String>)call("getDataList", filter).get();
    }

    /**
    * Gets the key names for all the key-value pairs in memory
    * 
    * @return A list containing the keys in memory
    */
    public List<String> getDataListName() throws CallError, InterruptedException {
        return (List<String>)call("getDataListName").get();
    }

    /**
    * DEPRECATED - Blocks the caller until the value of a key changes
    * 
    * @param key  Name of the data.
    * @param deprecatedParameter  DEPRECATED - this parameter has no effect
    * @return an array containing all the retrieved data
    */
    public Object getDataOnChange(String key, Integer deprecatedParameter) throws CallError, InterruptedException {
        return (Object)call("getDataOnChange", key, deprecatedParameter).get();
    }

    /**
    * Gets a pointer to 32 a bit data item. Beware, the pointer will only be valid during the lifetime of the ALMemory object. Use with care, at initialization, not every loop.
    * 
    * @param key  Name of the data.
    * @return A pointer converted to int
    */
    public Object getDataPtr(String key) throws CallError, InterruptedException {
        return (Object)call("getDataPtr", key).get();
    }

    /**
    * Gets a list containing the names of all the declared events
    * 
    * @return A list containing the names of all events
    */
    public List<String> getEventList() throws CallError, InterruptedException {
        return (List<String>)call("getEventList").get();
    }

    /**
    * Gets the list of all events generated by a given extractor
    * 
    * @param extractorName  The name of the extractor
    * @return A list containing the names of the events associated with the given extractor
    */
    public List<String> getExtractorEvent(String extractorName) throws CallError, InterruptedException {
        return (List<String>)call("getExtractorEvent", extractorName).get();
    }

    /**
    * Gets the values associated with the given list of keys. This is more efficient than calling getData many times, especially over the network.
    * 
    * @param keyList  An array containing the key names.
    * @return An array containing all the values corresponding to the given keys.
    */
    public Object getListData(Object keyList) throws CallError, InterruptedException {
        return (Object)call("getListData", keyList).get();
    }

    /**
    * Gets a list containing the names of all the declared micro events
    * 
    * @return A list containing the names of all the microEvents
    */
    public List<String> getMicroEventList() throws CallError, InterruptedException {
        return (List<String>)call("getMicroEventList").get();
    }

}
    