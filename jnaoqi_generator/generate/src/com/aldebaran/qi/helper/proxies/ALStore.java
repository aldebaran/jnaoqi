/**
 * Copyright (c) 2015 Aldebaran Robotics. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be
 * found in the COPYING file.
 * Created by epinault and tcruz
 */
package com.aldebaran.qi.helper.proxies;

import com.aldebaran.qi.*;
import com.aldebaran.qi.helper.*;
import java.util.List;
import java.util.Map;


import java.util.List;
/**
* 
* @see <a href="http://doc.aldebaran.com/2-1/naoqi/core/alstore.html#alstore">NAOqi APIs for ALStore </a>
*
*/
public class ALStore extends ALProxy {

    private AsyncALStore asyncProxy;

    public ALStore(Session session) throws Exception{
        super(session);
        asyncProxy = new AsyncALStore();
	    asyncProxy.setService(getService());
    }

    /**
     * Get the async version of this proxy
     *
	 * @return a AsyncALStore object
	 */
    public AsyncALStore async() {
        return asyncProxy;
    }

    /**
    * 
    * 
    */
    public Boolean isStatsEnabled() throws CallError, InterruptedException {
        return (Boolean)call("isStatsEnabled").get();
    }

    /**
    * 
    * 
    */
    public void clearStats() throws CallError, InterruptedException{
        call("clearStats").get();
    }

    /**
    * 
    * 
    */
    public Boolean isTraceEnabled() throws CallError, InterruptedException {
        return (Boolean)call("isTraceEnabled").get();
    }

    /**
    *  Add a Robot Notification 
    * 
    */
    public Object add_notification(Object param1) throws CallError, InterruptedException {
        return (Object)call("add_notification", param1).get();
    }

    /**
    *  Analyse the actions to take 
    * 
    */
    public Object analyse() throws CallError, InterruptedException {
        return (Object)call("analyse").get();
    }

    /**
    *  Assign the Robot to a User 
    * 
    */
    public Object assign(Object param1, Object param2) throws CallError, InterruptedException {
        return (Object)call("assign", param1, param2).get();
    }

    /**
    *  Check Updates From the Store 
    * 
    */
    public Object checkUpdate() throws CallError, InterruptedException {
        return (Object)call("checkUpdate").get();
    }

    /**
    *  Download a Package to a path if not already present 
    * 
    */
    public Object download(Object param1) throws CallError, InterruptedException {
        return (Object)call("download", param1).get();
    }

    /**
    *  Get a Package Info from the Packages List 
    * 
    */
    public Object getPackageInfo(Object param1) throws CallError, InterruptedException {
        return (Object)call("getPackageInfo", param1).get();
    }

    /**
    * Install the pkg with the PackageManager 
    * 
    */
    public Object install(Object param1, Object param2) throws CallError, InterruptedException {
        return (Object)call("install", param1, param2).get();
    }

    /**
    *  Log a Debugging Message 
    * 
    */
    public Object log_debug(Object param1) throws CallError, InterruptedException {
        return (Object)call("log_debug", param1).get();
    }

    /**
    *  Log an Error Message 
    * 
    */
    public Object log_error(Object param1) throws CallError, InterruptedException {
        return (Object)call("log_error", param1).get();
    }

    /**
    *  Log an Information Message 
    * 
    */
    public Object log_info(Object param1) throws CallError, InterruptedException {
        return (Object)call("log_info", param1).get();
    }

    /**
    *  Log a Warning Message 
    * 
    */
    public Object log_warning(Object param1) throws CallError, InterruptedException {
        return (Object)call("log_warning", param1).get();
    }

    /**
    *  Play a Sound using the Audio Player 
    * 
    */
    public Object play_sound(Object param1) throws CallError, InterruptedException {
        return (Object)call("play_sound", param1).get();
    }

    /**
    *  Get the status of the update 
    * 
    */
    public Object status() throws CallError, InterruptedException {
        return (Object)call("status").get();
    }

    /**
    *  Stop the current update process 
    * 
    */
    public Object stopUpdate() throws CallError, InterruptedException {
        return (Object)call("stopUpdate").get();
    }

    /**
    *  Translate a massage using the Translator 
    * 
    */
    public Object translate(Object param1) throws CallError, InterruptedException {
        return (Object)call("translate", param1).get();
    }

    /**
    *  Launch Update if not already running 
    * 
    */
    public Object update() throws CallError, InterruptedException {
        return (Object)call("update").get();
    }

    /**
    *  Update the Applications 
    * 
    */
    public Object updateApps() throws CallError, InterruptedException {
        return (Object)call("updateApps").get();
    }

    /**
    *  Subscribe to the Connect Event to Update just After 
    * 
    */
    public Object updateOnConnect() throws CallError, InterruptedException {
        return (Object)call("updateOnConnect").get();
    }

    /**
    *  Update the System 
    * 
    */
    public Object updateSystem() throws CallError, InterruptedException {
        return (Object)call("updateSystem").get();
    }


    public class AsyncALStore extends ALProxy {

        protected AsyncALStore(){
            super();
        }
    
    /**
    * 
    * 
    */
    public Future<Boolean> isStatsEnabled() throws CallError, InterruptedException {
        return call("isStatsEnabled");
    }

    /**
    * 
    * 
    * @return The Future
    */
    public Future<Void> clearStats() throws CallError, InterruptedException{
        return call("clearStats");
    }

    /**
    * 
    * 
    */
    public Future<Boolean> isTraceEnabled() throws CallError, InterruptedException {
        return call("isTraceEnabled");
    }

    /**
    *  Add a Robot Notification 
    * 
    */
    public Future<Object> add_notification(Object param1) throws CallError, InterruptedException {
        return call("add_notification", param1);
    }

    /**
    *  Analyse the actions to take 
    * 
    */
    public Future<Object> analyse() throws CallError, InterruptedException {
        return call("analyse");
    }

    /**
    *  Assign the Robot to a User 
    * 
    */
    public Future<Object> assign(Object param1, Object param2) throws CallError, InterruptedException {
        return call("assign", param1, param2);
    }

    /**
    *  Check Updates From the Store 
    * 
    */
    public Future<Object> checkUpdate() throws CallError, InterruptedException {
        return call("checkUpdate");
    }

    /**
    *  Download a Package to a path if not already present 
    * 
    */
    public Future<Object> download(Object param1) throws CallError, InterruptedException {
        return call("download", param1);
    }

    /**
    *  Get a Package Info from the Packages List 
    * 
    */
    public Future<Object> getPackageInfo(Object param1) throws CallError, InterruptedException {
        return call("getPackageInfo", param1);
    }

    /**
    * Install the pkg with the PackageManager 
    * 
    */
    public Future<Object> install(Object param1, Object param2) throws CallError, InterruptedException {
        return call("install", param1, param2);
    }

    /**
    *  Log a Debugging Message 
    * 
    */
    public Future<Object> log_debug(Object param1) throws CallError, InterruptedException {
        return call("log_debug", param1);
    }

    /**
    *  Log an Error Message 
    * 
    */
    public Future<Object> log_error(Object param1) throws CallError, InterruptedException {
        return call("log_error", param1);
    }

    /**
    *  Log an Information Message 
    * 
    */
    public Future<Object> log_info(Object param1) throws CallError, InterruptedException {
        return call("log_info", param1);
    }

    /**
    *  Log a Warning Message 
    * 
    */
    public Future<Object> log_warning(Object param1) throws CallError, InterruptedException {
        return call("log_warning", param1);
    }

    /**
    *  Play a Sound using the Audio Player 
    * 
    */
    public Future<Object> play_sound(Object param1) throws CallError, InterruptedException {
        return call("play_sound", param1);
    }

    /**
    *  Get the status of the update 
    * 
    */
    public Future<Object> status() throws CallError, InterruptedException {
        return call("status");
    }

    /**
    *  Stop the current update process 
    * 
    */
    public Future<Object> stopUpdate() throws CallError, InterruptedException {
        return call("stopUpdate");
    }

    /**
    *  Translate a massage using the Translator 
    * 
    */
    public Future<Object> translate(Object param1) throws CallError, InterruptedException {
        return call("translate", param1);
    }

    /**
    *  Launch Update if not already running 
    * 
    */
    public Future<Object> update() throws CallError, InterruptedException {
        return call("update");
    }

    /**
    *  Update the Applications 
    * 
    */
    public Future<Object> updateApps() throws CallError, InterruptedException {
        return call("updateApps");
    }

    /**
    *  Subscribe to the Connect Event to Update just After 
    * 
    */
    public Future<Object> updateOnConnect() throws CallError, InterruptedException {
        return call("updateOnConnect");
    }

    /**
    *  Update the System 
    * 
    */
    public Future<Object> updateSystem() throws CallError, InterruptedException {
        return call("updateSystem");
    }

    }
}
    