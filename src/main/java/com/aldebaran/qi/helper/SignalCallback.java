/**
 * Copyright (c) 2015 Aldebaran Robotics. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be
 * found in the COPYING file.
 * Created by epinault and tcruz
 */
package com.aldebaran.qi.helper;

import com.aldebaran.qi.CallError;

/**
 * Callback when an Signal is raised
 * */

public interface SignalCallback<T> {
	/**
	 * Call when an Signal is raised
	 *
	 * @param value the value return by the signal, you can get the type in aldebaran doc
	 * */
 	public void onSignal(T value) throws InterruptedException, CallError;


}
