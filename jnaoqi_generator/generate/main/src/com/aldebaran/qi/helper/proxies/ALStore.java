/**
 * Copyright (c) 2015 Aldebaran Robotics. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be
 * found in the COPYING file.
 * Created by epinault and tcruz
 */
package com.aldebaran.qi.helper.proxies;

import com.aldebaran.qi.CallError;
import com.aldebaran.qi.Future;
import com.aldebaran.qi.Session;
import com.aldebaran.qi.helper.ALProxy;
/**
* 
* @see <a href="http://doc.aldebaran.lan/doc/master/aldeb-doc/naoqi/core/alstore.html#alstore">NAOqi APIs for ALStore </a>
* NAOqi V2.4.x
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
    *  Subscribe to the Connect Event to Update just After 
    * 
    */
    public Object updateOnConnect() throws CallError, InterruptedException {
        return (Object)call("updateOnConnect").get();
    }

    /**
    *  Launch Update of the system image if not already running 
    * 
    */
    public Object updateSystem() throws CallError, InterruptedException {
        return (Object)call("updateSystem").get();
    }

    /**
    *  Return True if Running Applications should be Removed or Updated 
    * 
    */
    public Object updateRunningApps() throws CallError, InterruptedException {
        return (Object)call("updateRunningApps").get();
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
    *  Activate the Running Apps Update 
    * 
    */
    public Object activateUpdateRunningApps() throws CallError, InterruptedException {
        return (Object)call("activateUpdateRunningApps").get();
    }

    /**
    *  Analyse the actions to take 
    * 
    */
    public Object analyse() throws CallError, InterruptedException {
        return (Object)call("analyse").get();
    }

    /**
    *  Deactivate the Running Apps Update 
    * 
    */
    public Object deactivateUpdateRunningApps() throws CallError, InterruptedException {
        return (Object)call("deactivateUpdateRunningApps").get();
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
    *  Launch Update if not already running 
    * 
    */
    public Object update() throws CallError, InterruptedException {
        return (Object)call("update").get();
    }

    /**
    *  Launch Update of the apps if not already running 
    * 
    */
    public Object updateApps() throws CallError, InterruptedException {
        return (Object)call("updateApps").get();
    }


    public class AsyncALStore extends ALProxy {

        protected AsyncALStore(){
            super();
        }
    
    /**
    *  Subscribe to the Connect Event to Update just After 
    * 
    */
    public Future<Object> updateOnConnect() throws CallError, InterruptedException {
        return call("updateOnConnect");
    }

    /**
    *  Launch Update of the system image if not already running 
    * 
    */
    public Future<Object> updateSystem() throws CallError, InterruptedException {
        return call("updateSystem");
    }

    /**
    *  Return True if Running Applications should be Removed or Updated 
    * 
    */
    public Future<Object> updateRunningApps() throws CallError, InterruptedException {
        return call("updateRunningApps");
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
    *  Activate the Running Apps Update 
    * 
    */
    public Future<Object> activateUpdateRunningApps() throws CallError, InterruptedException {
        return call("activateUpdateRunningApps");
    }

    /**
    *  Analyse the actions to take 
    * 
    */
    public Future<Object> analyse() throws CallError, InterruptedException {
        return call("analyse");
    }

    /**
    *  Deactivate the Running Apps Update 
    * 
    */
    public Future<Object> deactivateUpdateRunningApps() throws CallError, InterruptedException {
        return call("deactivateUpdateRunningApps");
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
    *  Launch Update if not already running 
    * 
    */
    public Future<Object> update() throws CallError, InterruptedException {
        return call("update");
    }

    /**
    *  Launch Update of the apps if not already running 
    * 
    */
    public Future<Object> updateApps() throws CallError, InterruptedException {
        return call("updateApps");
    }

    }
}
    