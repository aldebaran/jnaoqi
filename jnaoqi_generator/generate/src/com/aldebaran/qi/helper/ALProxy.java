/**
 * Copyright (c) 2015 Aldebaran Robotics. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be
 * found in the COPYING file.
 * Created by epinault and ekroeger
 */

package com.aldebaran.qi.helper;

import com.aldebaran.qi.AnyObject;
import com.aldebaran.qi.CallError;
import com.aldebaran.qi.Session;

import java.util.HashMap;
import java.util.Map;

public class ALProxy {

    protected AnyObject service;
    protected boolean isAsynchronous = false;
    public static ALInterface alInterface;
	private HashMap<Long, AnyObject> subscribers;

    public ALProxy(Session session) {
        try {
            service = session.service(getClass().getSimpleName());
            if(alInterface != null)
                alInterface.onALModuleReady();
	        subscribers = new HashMap<Long, AnyObject>();
        } catch (Exception e) {
            if(alInterface != null)
                alInterface.onALModuleException(e);
        }
    }

    public boolean isAsynchronous() {
        return isAsynchronous;
    }

    public void setAsynchronous(boolean isAsynchronous) {
        this.isAsynchronous = isAsynchronous;
    }

	public long subscribeToEvent(String event, String signature, Object callback) throws Exception {
		AnyObject subscriber = subscriber(event);
		Long id = subscriber.connect("signal", signature, callback);
		subscribers.put(id, subscriber);
		return id;
	}
	public long subscribeToEvent(String event, EventCallback callback) throws Exception {
		return subscribeToEvent(event, "onEvent::(m)", callback);
	}
	public void unsubscribeToEvent(long eventID) throws InterruptedException, CallError {
		AnyObject subscriber = subscribers.get(eventID);
		if (subscriber != null) {
			subscriber.disconnect(eventID);
			subscribers.remove(eventID);
		}
	}

	public void unsubscribeAllEvents() throws InterruptedException, CallError {
		for (Map.Entry<Long, AnyObject> entry : subscribers.entrySet()) {
			entry.getValue().disconnect(entry.getKey());
			subscribers.remove(entry.getKey());
		}
	}

	public AnyObject subscriber(String eventName) throws CallError, InterruptedException {
		return (AnyObject)service.call("subscriber", eventName).get();
	}

	public long subscribeToSignal(String signal, Class<?> theClass, SignalCallback callback) throws Exception {
		return service.connect(signal, "onSignal::("+callback.getNaoqiType(theClass)+")", callback);
	}
	public long subscribeToSignal(String signal, String signature, Object callback) throws Exception {
		return service.connect(signal,signature, callback);
	}

	public void unsubscribeToSignal(long eventID) throws InterruptedException, CallError {
		service.disconnect(eventID);
	}

	public AnyObject getService() {
		return service;
	}

	public void setService(AnyObject service) {
		this.service = service;
	}
}
