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

public class ALProxy {

    protected AnyObject service;
    protected boolean isAsynchronous = false;
    public static ALInterface alInterface;

    public ALProxy(Session session) {
        try {
            service = session.service(getClass().getSimpleName());
            if(alInterface != null)
                alInterface.onALModuleReady();
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

	public void subscribeToEvent(String event, String signature, Object callback) throws Exception {
		subscriber(event).connect("signal", signature, callback);
	}
	public void subscribeToEvent(String event, EventCallback callback) throws Exception {
		subscriber(event).connect("signal", "onEvent::(m)", callback);
	}

	public AnyObject subscriber(String eventName) throws CallError, InterruptedException {
		return (AnyObject)service.call("subscriber", eventName).get();
	}

	public void subscribeToSignal(String signal, Class<?> theClass,SignalCallback callback) throws Exception {
		service.connect(signal, "onSignal::("+callback.getNaoqiType(theClass)+")", callback);
	}
	public void subscribeToSignal(String signal,String signature, Object callback) throws Exception {
		service.connect(signal,signature, callback);
	}

	public AnyObject getService() {
		return service;
	}

	public void setService(AnyObject service) {
		this.service = service;
	}
}
