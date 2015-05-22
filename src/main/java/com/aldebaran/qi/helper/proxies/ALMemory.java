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
import com.aldebaran.qi.helper.ALMemoryHelper;

import java.util.List;
import java.util.Map;
/**
* ALMemory provides a centralized memory that can be used to store and retrieve named values. It also acts as a hub for the distribution of event notifications.
* @see <a href="http://doc.aldebaran.lan/doc/master/aldeb-doc/naoqi/core/almemory.html#almemory">NAOqi APIs for ALMemory </a>
* NAOqi V2.4.x
*/
public class ALMemory extends ALMemoryHelper {

    private AsyncALMemory asyncProxy;

    public ALMemory(Session session) throws Exception{
        super(session);
        asyncProxy = new AsyncALMemory();
	    asyncProxy.setService(getService());
    }

    /**
     * Get the async version of this proxy
     *
	 * @return a AsyncALMemory object
	 */
    public AsyncALMemory async() {
        return asyncProxy;
    }

    /**
    * Inserts a key-value pair into memory, where value is a float
    * 
    * @param key  Name of the value to be inserted.
    * @param value  The float to be inserted
    */
    public void insertData(String key, Float value) throws CallError, InterruptedException{
        call("insertData", key, value).get();
    }

    /**
    * Publishes the given data to all subscribers.
    * 
    * @param name  Name of the event to raise.
    * @param value  The data associated with the event. This could contain a basic type, or a more complex array. See the ALValue documentation for more information.
    */
    public void raiseMicroEvent(String name, Object value) throws CallError, InterruptedException{
        call("raiseMicroEvent", name, value).get();
    }

    /**
    * Gets a list containing the names of all the declared micro events
    * 
    * @return A list containing the names of all the microEvents
    */
    public List<String> getMicroEventList() throws CallError, InterruptedException {
        return (List<String>)call("getMicroEventList").get();
    }

    /**
    * Removes a event from memory and unsubscribes any exiting subscribers.
    * 
    * @param name  Name of the event to remove.
    */
    public void removeEvent(String name) throws CallError, InterruptedException{
        call("removeEvent", name).get();
    }

    /**
    * Removes a micro event from memory and unsubscribes any exiting subscribers.
    * 
    * @param name  Name of the event to remove.
    */
    public void removeMicroEvent(String name) throws CallError, InterruptedException{
        call("removeMicroEvent", name).get();
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
    * DEPRECATED Subscribes to event and automaticaly launches the module capable of generating the event if it is not already running. Please use the version without the callbackMessage parameter.
    * 
    * @param name  The name of the event to subscribe to
    * @param callbackModule  Name of the module to call with notifications
    * @param callbackMessage  DEPRECATED Message included in the notification.
    * @param callbacMethod  Name of the module's method to call when a data is changed
    */
    public void subscribeToEvent(String name, String callbackModule, String callbackMessage, String callbacMethod) throws CallError, InterruptedException{
        call("subscribeToEvent", name, callbackModule, callbackMessage, callbacMethod).get();
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
        call("subscribeToMicroEvent", name, callbackModule, callbackMessage, callbackMethod).get();
    }

    /**
    * Informs ALMemory that a module doesn't exist anymore.
    * 
    * @param moduleName  Name of the departing module.
    */
    public void unregisterModuleReference(String moduleName) throws CallError, InterruptedException{
        call("unregisterModuleReference", moduleName).get();
    }

    /**
    * Unsubscribes a module from the given event. No further notifications will be received.
    * 
    * @param name  The name of the event
    * @param callbackModule  The name of the module that was given when subscribing.
    */
    public void unsubscribeToEvent(String name, String callbackModule) throws CallError, InterruptedException{
        call("unsubscribeToEvent", name, callbackModule).get();
    }

    /**
    * Inserts a key-value pair into memory, where value is an int
    * 
    * @param key  Name of the value to be inserted.
    * @param value  The int to be inserted
    */
    public void insertData(String key, Integer value) throws CallError, InterruptedException{
        call("insertData", key, value).get();
    }

    /**
    * Describe a key
    * 
    * @param name  Name of the key.
    * @param description  The description of the event (text format).
    */
    public void setDescription(String name, String description) throws CallError, InterruptedException{
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
    public void addMapping(String service, String signal, String event) throws CallError, InterruptedException{
        call("addMapping", service, signal, event).get();
    }

    /**
    * Add a mapping between signal and event
    * 
    * @param service  Name of the service
    * @param signalEvent  A map of signal corresponding to event
    */
    public void addMapping(String service, Map<String, String> signalEvent) throws CallError, InterruptedException{
        call("addMapping", service, signalEvent).get();
    }

    /**
    * Inserts a key-value pair into memory, where value is a string
    * 
    * @param key  Name of the value to be inserted.
    * @param value  The string to be inserted
    */
    public void insertData(String key, String value) throws CallError, InterruptedException{
        call("insertData", key, value).get();
    }

    /**
    * Inserts a key-value pair into memory, where value is an ALValue
    * 
    * @param key  Name of the value to be inserted.
    * @param data  The ALValue to be inserted. This could contain a basic type, or a more complex array. See the ALValue documentation for more information.
    */
    public void insertData(String key, Object data) throws CallError, InterruptedException{
        call("insertData", key, data).get();
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
    * Inserts a list of key-value pairs into memory.
    * 
    * @param list  An ALValue list of the form [[Key, Value],...]. Each item will be inserted.
    */
    public void insertListData(Object list) throws CallError, InterruptedException{
        call("insertListData", list).get();
    }

    /**
    * Publishes the given data to all subscribers.
    * 
    * @param name  Name of the event to raise.
    * @param value  The data associated with the event. This could contain a basic type, or a more complex array. See the ALValue documentation for more information.
    */
    public void raiseEvent(String name, Object value) throws CallError, InterruptedException{
        call("raiseEvent", name, value).get();
    }

    /**
    * Removes a key-value pair from memory
    * 
    * @param key  Name of the data to be removed.
    */
    public void removeData(String key) throws CallError, InterruptedException{
        call("removeData", key).get();
    }

    /**
    * Unsubscribes from the given event. No further notifications will be received.
    * 
    * @param name  Name of the event.
    * @param callbackModule  The name of the module that was given when subscribing.
    */
    public void unsubscribeToMicroEvent(String name, String callbackModule) throws CallError, InterruptedException{
        call("unsubscribeToMicroEvent", name, callbackModule).get();
    }

    /**
    * Subscribes to an event and automaticaly launches the module that declared itself as the generator of the event if required.
    * 
    * @param name  The name of the event to subscribe to
    * @param callbackModule  Name of the module to call with notifications
    * @param callbackMethod  Name of the module's method to call when a data is changed
    */
    public void subscribeToEvent(String name, String callbackModule, String callbackMethod) throws CallError, InterruptedException{
        call("subscribeToEvent", name, callbackModule, callbackMethod).get();
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
    * Wait for the end of a long running method that was called using 'post', returns a cancelable future
    * 
    * @param id  The ID of the method that was returned when calling the method using 'post'
    */
    public void wait(Integer id) throws CallError, InterruptedException{
        call("wait", id).get();
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
    * Declares an event to allow future subscriptions to the event
    * 
    * @param eventName  The name of the event
    */
    public void declareEvent(String eventName) throws CallError, InterruptedException{
        call("declareEvent", eventName).get();
    }

    /**
    * Declares an event to allow future subscriptions to the event
    * 
    * @param eventName  The name of the event
    * @param extractorName  The name of the extractor capable of creating the event
    */
    public void declareEvent(String eventName, String extractorName) throws CallError, InterruptedException{
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


    public class AsyncALMemory extends ALMemoryHelper {

        protected AsyncALMemory(){
            super();
        }
    
    /**
    * Inserts a key-value pair into memory, where value is a float
    * 
    * @param key  Name of the value to be inserted.
    * @param value  The float to be inserted
    * @return The Future
    */
    public Future<Void> insertData(String key, Float value) throws CallError, InterruptedException{
        return call("insertData", key, value);
    }

    /**
    * Publishes the given data to all subscribers.
    * 
    * @param name  Name of the event to raise.
    * @param value  The data associated with the event. This could contain a basic type, or a more complex array. See the ALValue documentation for more information.
    * @return The Future
    */
    public Future<Void> raiseMicroEvent(String name, Object value) throws CallError, InterruptedException{
        return call("raiseMicroEvent", name, value);
    }

    /**
    * Gets a list containing the names of all the declared micro events
    * 
    * @return A list containing the names of all the microEvents
    */
    public Future<List<String>> getMicroEventList() throws CallError, InterruptedException {
        return call("getMicroEventList");
    }

    /**
    * Removes a event from memory and unsubscribes any exiting subscribers.
    * 
    * @param name  Name of the event to remove.
    * @return The Future
    */
    public Future<Void> removeEvent(String name) throws CallError, InterruptedException{
        return call("removeEvent", name);
    }

    /**
    * Removes a micro event from memory and unsubscribes any exiting subscribers.
    * 
    * @param name  Name of the event to remove.
    * @return The Future
    */
    public Future<Void> removeMicroEvent(String name) throws CallError, InterruptedException{
        return call("removeMicroEvent", name);
    }

    /**
    * Gets the storage class of the stored data. This is not the underlying POD type.
    * 
    * @param key  Name of the variable
    * @return String type: Data, Event, MicroEvent
    */
    public Future<String> getType(String key) throws CallError, InterruptedException {
        return call("getType", key);
    }

    /**
    * DEPRECATED Subscribes to event and automaticaly launches the module capable of generating the event if it is not already running. Please use the version without the callbackMessage parameter.
    * 
    * @param name  The name of the event to subscribe to
    * @param callbackModule  Name of the module to call with notifications
    * @param callbackMessage  DEPRECATED Message included in the notification.
    * @param callbacMethod  Name of the module's method to call when a data is changed
    * @return The Future
    */
    public Future<Void> subscribeToEvent(String name, String callbackModule, String callbackMessage, String callbacMethod) throws CallError, InterruptedException{
        return call("subscribeToEvent", name, callbackModule, callbackMessage, callbacMethod);
    }

    /**
    * Subscribes to a microEvent. Subscribed modules are notified on theircallback method whenever the data is updated, even if the new value is the same as the old value.
    * 
    * @param name  Name of the data.
    * @param callbackModule  Name of the module to call with notifications
    * @param callbackMessage  Message included in the notification. This can be used to disambiguate multiple subscriptions.
    * @param callbackMethod  Name of the module's method to call when a data is changed
    * @return The Future
    */
    public Future<Void> subscribeToMicroEvent(String name, String callbackModule, String callbackMessage, String callbackMethod) throws CallError, InterruptedException{
        return call("subscribeToMicroEvent", name, callbackModule, callbackMessage, callbackMethod);
    }

    /**
    * Informs ALMemory that a module doesn't exist anymore.
    * 
    * @param moduleName  Name of the departing module.
    * @return The Future
    */
    public Future<Void> unregisterModuleReference(String moduleName) throws CallError, InterruptedException{
        return call("unregisterModuleReference", moduleName);
    }

    /**
    * Unsubscribes a module from the given event. No further notifications will be received.
    * 
    * @param name  The name of the event
    * @param callbackModule  The name of the module that was given when subscribing.
    * @return The Future
    */
    public Future<Void> unsubscribeToEvent(String name, String callbackModule) throws CallError, InterruptedException{
        return call("unsubscribeToEvent", name, callbackModule);
    }

    /**
    * Inserts a key-value pair into memory, where value is an int
    * 
    * @param key  Name of the value to be inserted.
    * @param value  The int to be inserted
    * @return The Future
    */
    public Future<Void> insertData(String key, Integer value) throws CallError, InterruptedException{
        return call("insertData", key, value);
    }

    /**
    * Describe a key
    * 
    * @param name  Name of the key.
    * @param description  The description of the event (text format).
    * @return The Future
    */
    public Future<Void> setDescription(String name, String description) throws CallError, InterruptedException{
        return call("setDescription", name, description);
    }

    /**
    * Descriptions of all given keys
    * 
    * @param keylist  List of keys. (empty to get all descriptions)
    * @return an array of tuple (name, type, description) describing all keys.
    */
    public Future<Object> getDescriptionList(List<String> keylist) throws CallError, InterruptedException {
        return call("getDescriptionList", keylist);
    }

    /**
    * Add a mapping between signal and event
    * 
    * @param service  Name of the service
    * @param signal  Name of the signal
    * @param event  Name of the event
    * @return The Future
    */
    public Future<Void> addMapping(String service, String signal, String event) throws CallError, InterruptedException{
        return call("addMapping", service, signal, event);
    }

    /**
    * Add a mapping between signal and event
    * 
    * @param service  Name of the service
    * @param signalEvent  A map of signal corresponding to event
    * @return The Future
    */
    public Future<Void> addMapping(String service, Map<String, String> signalEvent) throws CallError, InterruptedException{
        return call("addMapping", service, signalEvent);
    }

    /**
    * Inserts a key-value pair into memory, where value is a string
    * 
    * @param key  Name of the value to be inserted.
    * @param value  The string to be inserted
    * @return The Future
    */
    public Future<Void> insertData(String key, String value) throws CallError, InterruptedException{
        return call("insertData", key, value);
    }

    /**
    * Inserts a key-value pair into memory, where value is an ALValue
    * 
    * @param key  Name of the value to be inserted.
    * @param data  The ALValue to be inserted. This could contain a basic type, or a more complex array. See the ALValue documentation for more information.
    * @return The Future
    */
    public Future<Void> insertData(String key, Object data) throws CallError, InterruptedException{
        return call("insertData", key, data);
    }

    /**
    * Gets a list containing the names of subscribers to an event.
    * 
    * @param name  Name of the event or micro-event
    * @return List of subscriber names
    */
    public Future<List<String>> getSubscribers(String name) throws CallError, InterruptedException {
        return call("getSubscribers", name);
    }

    /**
    * Inserts a list of key-value pairs into memory.
    * 
    * @param list  An ALValue list of the form [[Key, Value],...]. Each item will be inserted.
    * @return The Future
    */
    public Future<Void> insertListData(Object list) throws CallError, InterruptedException{
        return call("insertListData", list);
    }

    /**
    * Publishes the given data to all subscribers.
    * 
    * @param name  Name of the event to raise.
    * @param value  The data associated with the event. This could contain a basic type, or a more complex array. See the ALValue documentation for more information.
    * @return The Future
    */
    public Future<Void> raiseEvent(String name, Object value) throws CallError, InterruptedException{
        return call("raiseEvent", name, value);
    }

    /**
    * Removes a key-value pair from memory
    * 
    * @param key  Name of the data to be removed.
    * @return The Future
    */
    public Future<Void> removeData(String key) throws CallError, InterruptedException{
        return call("removeData", key);
    }

    /**
    * Unsubscribes from the given event. No further notifications will be received.
    * 
    * @param name  Name of the event.
    * @param callbackModule  The name of the module that was given when subscribing.
    * @return The Future
    */
    public Future<Void> unsubscribeToMicroEvent(String name, String callbackModule) throws CallError, InterruptedException{
        return call("unsubscribeToMicroEvent", name, callbackModule);
    }

    /**
    * Subscribes to an event and automaticaly launches the module that declared itself as the generator of the event if required.
    * 
    * @param name  The name of the event to subscribe to
    * @param callbackModule  Name of the module to call with notifications
    * @param callbackMethod  Name of the module's method to call when a data is changed
    * @return The Future
    */
    public Future<Void> subscribeToEvent(String name, String callbackModule, String callbackMethod) throws CallError, InterruptedException{
        return call("subscribeToEvent", name, callbackModule, callbackMethod);
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
    * Wait for the end of a long running method that was called using 'post', returns a cancelable future
    * 
    * @param id  The ID of the method that was returned when calling the method using 'post'
    * @return The Future
    */
    public Future<Void> wait(Integer id) throws CallError, InterruptedException{
        return call("wait", id);
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
    * Declares an event to allow future subscriptions to the event
    * 
    * @param eventName  The name of the event
    * @return The Future
    */
    public Future<Void> declareEvent(String eventName) throws CallError, InterruptedException{
        return call("declareEvent", eventName);
    }

    /**
    * Declares an event to allow future subscriptions to the event
    * 
    * @param eventName  The name of the event
    * @param extractorName  The name of the extractor capable of creating the event
    * @return The Future
    */
    public Future<Void> declareEvent(String eventName, String extractorName) throws CallError, InterruptedException{
        return call("declareEvent", eventName, extractorName);
    }

    /**
    * Gets the value of a key-value pair stored in memory
    * 
    * @param key  Name of the value.
    * @return The data as an ALValue. This can often be cast transparently into the original type.
    */
    public Future<Object> getData(String key) throws CallError, InterruptedException {
        return call("getData", key);
    }

    /**
    * DEPRECATED - Gets the value of a key-value pair stored in memory. Please use the version of this method with no second parameter.
    * 
    * @param key  Name of the value.
    * @param deprecatedParameter  DEPRECATED - This parameter has no effect, but is left for compatibility reason.
    * @return The data as an ALValue
    */
    public Future<Object> getData(String key, Integer deprecatedParameter) throws CallError, InterruptedException {
        return call("getData", key, deprecatedParameter);
    }

    /**
    * Get data value and timestamp
    * 
    * @param key  Name of the variable
    * @return A list of all the data key names that contain the given string.
    */
    public Future<Object> getTimestamp(String key) throws CallError, InterruptedException {
        return call("getTimestamp", key);
    }

    /**
    * Get data value and timestamp
    * 
    * @param key  Name of the variable
    * @return A list of all the data key names that contain the given string.
    */
    public Future<Object> getEventHistory(String key) throws CallError, InterruptedException {
        return call("getEventHistory", key);
    }

    /**
    * Gets a list of all key names that contain a given string
    * 
    * @param filter  A string used as the search term
    * @return A list of all the data key names that contain the given string.
    */
    public Future<List<String>> getDataList(String filter) throws CallError, InterruptedException {
        return call("getDataList", filter);
    }

    /**
    * Gets the key names for all the key-value pairs in memory
    * 
    * @return A list containing the keys in memory
    */
    public Future<List<String>> getDataListName() throws CallError, InterruptedException {
        return call("getDataListName");
    }

    /**
    * DEPRECATED - Blocks the caller until the value of a key changes
    * 
    * @param key  Name of the data.
    * @param deprecatedParameter  DEPRECATED - this parameter has no effect
    * @return an array containing all the retrieved data
    */
    public Future<Object> getDataOnChange(String key, Integer deprecatedParameter) throws CallError, InterruptedException {
        return call("getDataOnChange", key, deprecatedParameter);
    }

    /**
    * Gets a pointer to 32 a bit data item. Beware, the pointer will only be valid during the lifetime of the ALMemory object. Use with care, at initialization, not every loop.
    * 
    * @param key  Name of the data.
    * @return A pointer converted to int
    */
    public Future<Object> getDataPtr(String key) throws CallError, InterruptedException {
        return call("getDataPtr", key);
    }

    /**
    * Gets a list containing the names of all the declared events
    * 
    * @return A list containing the names of all events
    */
    public Future<List<String>> getEventList() throws CallError, InterruptedException {
        return call("getEventList");
    }

    /**
    * Gets the list of all events generated by a given extractor
    * 
    * @param extractorName  The name of the extractor
    * @return A list containing the names of the events associated with the given extractor
    */
    public Future<List<String>> getExtractorEvent(String extractorName) throws CallError, InterruptedException {
        return call("getExtractorEvent", extractorName);
    }

    /**
    * Gets the values associated with the given list of keys. This is more efficient than calling getData many times, especially over the network.
    * 
    * @param keyList  An array containing the key names.
    * @return An array containing all the values corresponding to the given keys.
    */
    public Future<Object> getListData(Object keyList) throws CallError, InterruptedException {
        return call("getListData", keyList);
    }

    }
}
    