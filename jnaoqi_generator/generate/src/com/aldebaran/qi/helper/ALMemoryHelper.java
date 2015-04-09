package com.aldebaran.qi.helper;

import com.aldebaran.qi.AnyObject;
import com.aldebaran.qi.CallError;
import com.aldebaran.qi.Session;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by epinault on 18/03/15.
 */
public abstract class ALMemoryHelper extends ALProxy{

	/** subscribers for the events */
	private HashMap<Long, AnyObject> subscribers;

	public ALMemoryHelper(Session session) throws Exception {
		super(session);
		subscribers = new HashMap<Long, AnyObject>();
	}

	public ALMemoryHelper() {
		subscribers = new HashMap<Long, AnyObject>();
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
}
