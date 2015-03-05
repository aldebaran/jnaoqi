/**
 * Copyright (c) 2015 Aldebaran Robotics. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be
 * found in the COPYING file.
 * Created by epinault and tcruz
 */
package com.aldebaran.qi.helper;

/**
 * Callbacks for proxy connection
 * */
public interface ALInterface {

	/**
	 * Callback when the proxy is ready
	 * */
    public void onProxyReady();

	/**
	 * Callback when the proxy throw an exception
	 * @param e exception thrown
	 * */
     public void onProxyException(Exception e);
}
