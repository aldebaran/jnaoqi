/**
 * Copyright (c) 2015 Aldebaran Robotics. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be
 * found in the COPYING file.
 * Created by epinault and ekroeger
 */
package com.aldebaran.qi.helper.proxies;

import com.aldebaran.qi.CallError;
import com.aldebaran.qi.Session;
import com.aldebaran.qi.helper.ALProxy;
import java.util.List;
import java.util.Map;
import com.aldebaran.qi.*;

import java.util.List;
/**
* 
* @see <a href="http://doc.aldebaran.lan/doc/master/aldeb-doc/naoqi/core/alstore.html#alstore">NAOqi APIs for ALStore </a>
*
*/
public class ALStore extends ALProxy {

    public ALStore(Session session) {
        super(session);
    }

    /**
    * 
    * 
    */
    public Boolean isStatsEnabled() throws CallError, InterruptedException {
        return (Boolean)service.call("isStatsEnabled").get();
    }

    /**
    * 
    * 
    */
    public void clearStats() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("clearStats");
        else
            service.call("clearStats").get();
    }

    /**
    * 
    * 
    */
    public Boolean isTraceEnabled() throws CallError, InterruptedException {
        return (Boolean)service.call("isTraceEnabled").get();
    }

    /**
    *  Add a Robot Notification 
    * 
    */
    public Object add_notification(Object param1) throws CallError, InterruptedException {
        return (Object)service.call("add_notification", param1).get();
    }

    /**
    *  Analyse the actions to take 
    * 
    */
    public Object analyse() throws CallError, InterruptedException {
        return (Object)service.call("analyse").get();
    }

    /**
    *  Assign the Robot to a User 
    * 
    */
    public Object assign(Object param1, Object param2) throws CallError, InterruptedException {
        return (Object)service.call("assign", param1, param2).get();
    }

    /**
    *  Check Updates From the Store 
    * 
    */
    public Object checkUpdate() throws CallError, InterruptedException {
        return (Object)service.call("checkUpdate").get();
    }

    /**
    *  Download a Package to a path if not already present 
    * 
    */
    public Object download(Object param1) throws CallError, InterruptedException {
        return (Object)service.call("download", param1).get();
    }

    /**
    *  Get a Package Info from the Packages List 
    * 
    */
    public Object getPackageInfo(Object param1) throws CallError, InterruptedException {
        return (Object)service.call("getPackageInfo", param1).get();
    }

    /**
    * Install the pkg with the PackageManager 
    * 
    */
    public Object install(Object param1, Object param2) throws CallError, InterruptedException {
        return (Object)service.call("install", param1, param2).get();
    }

    /**
    *  Log a Debugging Message 
    * 
    */
    public Object log_debug(Object param1) throws CallError, InterruptedException {
        return (Object)service.call("log_debug", param1).get();
    }

    /**
    *  Log an Error Message 
    * 
    */
    public Object log_error(Object param1) throws CallError, InterruptedException {
        return (Object)service.call("log_error", param1).get();
    }

    /**
    *  Log an Information Message 
    * 
    */
    public Object log_info(Object param1) throws CallError, InterruptedException {
        return (Object)service.call("log_info", param1).get();
    }

    /**
    *  Log a Warning Message 
    * 
    */
    public Object log_warning(Object param1) throws CallError, InterruptedException {
        return (Object)service.call("log_warning", param1).get();
    }

    /**
    *  Play a Sound using the Audio Player 
    * 
    */
    public Object play_sound(Object param1) throws CallError, InterruptedException {
        return (Object)service.call("play_sound", param1).get();
    }

    /**
    *  Get the status of the update 
    * 
    */
    public Object status() throws CallError, InterruptedException {
        return (Object)service.call("status").get();
    }

    /**
    *  Stop the current update process 
    * 
    */
    public Object stopUpdate() throws CallError, InterruptedException {
        return (Object)service.call("stopUpdate").get();
    }

    /**
    *  Translate a massage using the Translator 
    * 
    */
    public Object translate(Object param1) throws CallError, InterruptedException {
        return (Object)service.call("translate", param1).get();
    }

    /**
    *  Launch Update if not already running 
    * 
    */
    public Object update() throws CallError, InterruptedException {
        return (Object)service.call("update").get();
    }

    /**
    *  Update the Applications 
    * 
    */
    public Object updateApps() throws CallError, InterruptedException {
        return (Object)service.call("updateApps").get();
    }

    /**
    *  Subscribe to the Connect Event to Update just After 
    * 
    */
    public Object updateOnConnect() throws CallError, InterruptedException {
        return (Object)service.call("updateOnConnect").get();
    }

    /**
    *  Update the System 
    * 
    */
    public Object updateSystem() throws CallError, InterruptedException {
        return (Object)service.call("updateSystem").get();
    }

}
    