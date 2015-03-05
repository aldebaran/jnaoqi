/**
 * Copyright (c) 2015 Aldebaran Robotics. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be
 * found in the COPYING file.
 * Created by epinault and tcruz
 */
package com.aldebaran.qi.helper;

import com.aldebaran.qi.AnyObject;
import com.aldebaran.qi.CallError;

public abstract class SignalCallback<T> {
	public abstract void onSignal(T value) throws InterruptedException, CallError;

	public String getNaoqiType(Class<T> tClass) {

		if(tClass == String.class)
			return "s";
		if(tClass == Integer.class)
			return "i";
		if(tClass == Character.class)
			return "c";
		if(tClass == Void.class)
			return "v";
		if(tClass == AnyObject.class)
			return "o";
		if(tClass == Boolean.class)
			return "b";
		if(tClass == Float.class)
			return "f";
		if(tClass == Long.class)
			return "l";
		else return "m";
	}

}
