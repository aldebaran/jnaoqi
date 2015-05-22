/**
 * Copyright (c) 2015 Aldebaran Robotics. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be
 * found in the COPYING file.
 * Created by epinault and tcruz
 */
package com.aldebaran.qi.helper;

import com.aldebaran.qi.CallError;

/**
 * Callback when an Event is raised
 * */
public interface EventCallback<T> {
	/**
	 * Call when an Event is raised
	 *
	 * @param value the value return by the event, you can get the type in aldebaran doc
	 * */
	public void onEvent(T value) throws InterruptedException, CallError;
}
