/**
 * Copyright (c) 2015 Aldebaran Robotics. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be
 * found in the COPYING file.
 * Created by epinault and tcruz
 */

package com.aldebaran.qi.helper;

import com.aldebaran.qi.AnyObject;
import com.aldebaran.qi.CallError;
import com.aldebaran.qi.Future;
import com.aldebaran.qi.Session;

import java.util.HashMap;
import java.util.Map;

/**
 * Generic class to manage a proxy
 * */
public class ALProxy {

	/** Naoqi Service proxy */
    protected AnyObject service;

	/** Naoqi Service name */
	protected String name;

	/** is the proxy run asynchronously  */
    protected boolean isAsynchronous = false;

	/** callback to get events from proxy connection*/
    public static ALInterface alInterface;

	/** subscribers for the events */
	private HashMap<Long, AnyObject> subscribers;

	/**
	 * Create a new proxy using the class name as the service name
	 * @param session session connect to a robot
	 * */
    public ALProxy(Session session) {
        try {
	        name = getClass().getSimpleName();
            service = session.service(name);
            if(alInterface != null)
                alInterface.onProxyReady(name);
	        subscribers = new HashMap<Long, AnyObject>();
        } catch (Exception e) {
            if(alInterface != null)
                alInterface.onProxyException(name, e);
        }

    }

	/**
	 * Create a new proxy
	 * @param session session connect to a robot
	 * @param serviceName name of the service you want to get proxy on
	 * */
	public ALProxy(Session session, String serviceName) {
		try {
			name = serviceName;
			service = session.service(serviceName);
			if(alInterface != null)
				alInterface.onProxyReady(name);
			subscribers = new HashMap<Long, AnyObject>();
		} catch (Exception e) {
			if(alInterface != null)
				alInterface.onProxyException(name, e);
		}
	}

	/** Get a subscriber object for an event
	 * @param eventName name of the event
	 * @return a subscriber object
	 * */
	public AnyObject subscriber(String eventName) throws CallError, InterruptedException {
		if (service == null)
			throw new CallError();
		return (AnyObject)service.call("subscriber", eventName).get();
	}

	/**
	 * Subscribe to an Event (Naoqi 1)
	 * @param event name of the event you want to subscribe (you can get those name in the module NAOqi APIs doc)
	 * @param signature naoqi signature of the event
	 * @param callback object where the callback function is located
	 * @return id to identify the event subscription
	 * */
	public long subscribeToEvent(String event, String signature, Object callback) throws Exception {
		AnyObject subscriber = subscriber(event);
		Long id = subscriber.connect("signal", signature, callback);
		subscribers.put(id, subscriber);
		return id;
	}

	/**
	 * Subscribe to an Event with Event callback helper (Naoqi 1)
	 * @param event name of the event you want to subscribe (you can get those name in the module NAOqi APIs doc)
	 * @param callback object where the callback function is located
	 * @return id to identify the event subscription
	 * */
 	public long subscribeToEvent(String event, EventCallback callback) throws Exception {
		return subscribeToEvent(event, "onEvent::(m)", callback);
	}

	/**
	 * Unsubscribe to an event giving is subscription id
	 * @param eventID id of the event subscription
	 * */
	public void unsubscribeToEvent(long eventID) throws InterruptedException, CallError {
		AnyObject subscriber = subscribers.get(eventID);
		if (subscriber != null) {
			subscriber.disconnect(eventID);
			subscribers.remove(eventID);
		}
	}

	/**
	 * Unsubscribe to all events attached to this proxy
	 * */
	public void unsubscribeAllEvents() throws InterruptedException, CallError {
		for (Map.Entry<Long, AnyObject> entry : subscribers.entrySet()) {
			entry.getValue().disconnect(entry.getKey());
			subscribers.remove(entry.getKey());
		}
	}


	/**
	 * Connect to a Signal (Naoqi 2)
	 * @param signal name of the signal you want to subscribe (you can get those name in the module NAOqi APIs doc)
	 * @param signature naoqi signature of the signal
	 * @param callback object where the callback function is located
	 * @return id to identify the signal subscription
	 * */
	public long connect(String signal, String signature, Object callback) throws Exception {
		if (service == null)
			throw new CallError();
		return service.connect(signal,signature, callback);
	}


	/**
	 * Connect to a Signal with signal callback helper (Naoqi 2)
	 * @param signal name of the signal you want to subscribe (you can get those name in the module NAOqi APIs doc)
	 * @param callback object where the callback function is located
	 * @return id to identify the event subscription
	 * */
	public long connect(String signal, Class<?> theClass, SignalCallback callback) throws Exception {
		if (service == null)
			throw new CallError();
		return service.connect(signal, "onSignal::("+callback.getNaoqiType(theClass)+")", callback);
	}

	/**
	 * Disconnect to a signal giving is subscription id
	 * @param eventID id of the signal subscription
	 * */
	public void disconnect(long eventID) throws InterruptedException, CallError {
		if (service == null)
			throw new CallError();
		service.disconnect(eventID);
	}


	/** Call a method with arguments
	 * @param method name of the method to call
	 * @param args args to give to this method
	 * @return a Future, use get on it to have the result */
	public <T> Future<T> call(String method, Object... args) throws CallError {
		if (service == null)
			throw new CallError();
		return service.call(method, args);
	}

	public AnyObject getService() {
		return service;
	}

	public void setService(AnyObject service) {
		this.service = service;
	}

	public boolean isAsynchronous() {
		return isAsynchronous;
	}

	public void setAsynchronous(boolean isAsynchronous) {
		this.isAsynchronous = isAsynchronous;
	}

	/**Is proxy create and ready*/
	public boolean isProxyReady() {
		return service != null;
	}

}
