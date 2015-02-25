package com.aldebaran.qi.helper;

import com.aldebaran.qi.CallError;

/**
 * Created by epinault on 17/02/15.
 */
public abstract class EventCallback<T> {
	public abstract void onEvent(T value) throws InterruptedException, CallError;
}
