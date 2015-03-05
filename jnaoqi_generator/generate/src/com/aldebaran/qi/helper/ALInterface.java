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
	 *
	 * @param name name of the proxy ready */
    public void onProxyReady(String name);

	/**
	 * Callback when the proxy throw an exception
	 * @param name name of the proxy throwing an error
	 * @param e exception thrown */
     public void onProxyException(String name, Exception e);
}
