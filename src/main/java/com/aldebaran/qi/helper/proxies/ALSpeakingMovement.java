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
* @see <a href="http://doc.aldebaran.lan/doc/master/aldeb-doc/naoqi/interaction/autonomousabilities/alspeakingmovement.html#alspeakingmovement">NAOqi APIs for ALSpeakingMovement </a>
* NAOqi V2.4.x
*/
public class ALSpeakingMovement extends ALProxy {

    private AsyncALSpeakingMovement asyncProxy;

    public ALSpeakingMovement(Session session) throws Exception{
        super(session);
        asyncProxy = new AsyncALSpeakingMovement();
	    asyncProxy.setService(getService());
    }

    /**
     * Get the async version of this proxy
     *
	 * @return a AsyncALSpeakingMovement object
	 */
    public AsyncALSpeakingMovement async() {
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
    * 
    * 
    */
    public void setEnabled(Boolean param1) throws CallError, InterruptedException{
        call("setEnabled", param1).get();
    }

    /**
    * 
    * 
    */
    public Boolean isEnabled() throws CallError, InterruptedException {
        return (Boolean)call("isEnabled").get();
    }

    /**
    * 
    * 
    */
    public Boolean isRunning() throws CallError, InterruptedException {
        return (Boolean)call("isRunning").get();
    }

    /**
    * 
    * 
    */
    public void setMode(String param1) throws CallError, InterruptedException{
        call("setMode", param1).get();
    }

    /**
    * 
    * 
    */
    public String getMode() throws CallError, InterruptedException {
        return (String)call("getMode").get();
    }

    /**
    * 
    * 
    */
    public void addTagsToWords(Object param1) throws CallError, InterruptedException{
        call("addTagsToWords", param1).get();
    }

    /**
    * 
    * 
    */
    public void resetTagsToWords() throws CallError, InterruptedException{
        call("resetTagsToWords").get();
    }


    public class AsyncALSpeakingMovement extends ALProxy {

        protected AsyncALSpeakingMovement(){
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
    * 
    * 
    * @return The Future
    */
    public Future<Void> setEnabled(Boolean param1) throws CallError, InterruptedException{
        return call("setEnabled", param1);
    }

    /**
    * 
    * 
    */
    public Future<Boolean> isEnabled() throws CallError, InterruptedException {
        return call("isEnabled");
    }

    /**
    * 
    * 
    */
    public Future<Boolean> isRunning() throws CallError, InterruptedException {
        return call("isRunning");
    }

    /**
    * 
    * 
    * @return The Future
    */
    public Future<Void> setMode(String param1) throws CallError, InterruptedException{
        return call("setMode", param1);
    }

    /**
    * 
    * 
    */
    public Future<String> getMode() throws CallError, InterruptedException {
        return call("getMode");
    }

    /**
    * 
    * 
    * @return The Future
    */
    public Future<Void> addTagsToWords(Object param1) throws CallError, InterruptedException{
        return call("addTagsToWords", param1);
    }

    /**
    * 
    * 
    * @return The Future
    */
    public Future<Void> resetTagsToWords() throws CallError, InterruptedException{
        return call("resetTagsToWords");
    }

    }
}
    