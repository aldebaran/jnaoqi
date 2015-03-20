/**
 * Copyright (c) 2015 Aldebaran Robotics. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be
 * found in the COPYING file.
 * Created by epinault and tcruz
 */
package com.aldebaran.qi.helper.proxies;

import com.aldebaran.qi.CallError;
import com.aldebaran.qi.Session;
import com.aldebaran.qi.helper.ALProxy;

import java.util.List;
/**
* 
* @see <a href="http://doc.aldebaran.com/2-1/naoqi/connectionmanager/index.html#alconnectionmanager">NAOqi APIs for ALConnectionManager </a>
*
*/
public class ALConnectionManager extends ALProxy {

    public ALConnectionManager(Session session) throws Exception{
        super(session);
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
    public Object services() throws CallError, InterruptedException {
        return (Object)call("services").get();
    }

    /**
    * 
    * 
    */
    public Object service(String param1) throws CallError, InterruptedException {
        return (Object)call("service", param1).get();
    }

    /**
    * 
    * 
    */
    public void scan(String param1) throws CallError, InterruptedException{
        call("scan", param1).get();
    }

    /**
    * 
    * 
    */
    public void scan() throws CallError, InterruptedException{
        call("scan").get();
    }

    /**
    * 
    * 
    */
    public void setServiceConfiguration(Object param1) throws CallError, InterruptedException{
        call("setServiceConfiguration", param1).get();
    }

    /**
    * 
    * 
    */
    public void setServiceInput(Object param1) throws CallError, InterruptedException{
        call("setServiceInput", param1).get();
    }

    /**
    * 
    * 
    */
    public String state() throws CallError, InterruptedException {
        return (String)call("state").get();
    }

    /**
    * 
    * 
    */
    public void forget(String param1) throws CallError, InterruptedException{
        call("forget", param1).get();
    }

    /**
    * 
    * 
    */
    public void connect(String param1) throws CallError, InterruptedException{
        call("connect", param1).get();
    }

    /**
    * 
    * 
    */
    public void disconnect(String param1) throws CallError, InterruptedException{
        call("disconnect", param1).get();
    }

    /**
    * 
    * 
    */
    public Object technologies() throws CallError, InterruptedException {
        return (Object)call("technologies").get();
    }

    /**
    * 
    * 
    */
    public void enableTethering(String param1, String param2, String param3) throws CallError, InterruptedException{
        call("enableTethering", param1, param2, param3).get();
    }

    /**
    * 
    * 
    */
    public void enableTethering(String param1) throws CallError, InterruptedException{
        call("enableTethering", param1).get();
    }

    /**
    * 
    * 
    */
    public void disableTethering(String param1) throws CallError, InterruptedException{
        call("disableTethering", param1).get();
    }

    /**
    * 
    * 
    */
    public Boolean getTetheringEnable(String param1) throws CallError, InterruptedException {
        return (Boolean)call("getTetheringEnable", param1).get();
    }

    /**
    * 
    * 
    */
    public String tetheringName(String param1) throws CallError, InterruptedException {
        return (String)call("tetheringName", param1).get();
    }

    /**
    * 
    * 
    */
    public String tetheringPassphrase(String param1) throws CallError, InterruptedException {
        return (String)call("tetheringPassphrase", param1).get();
    }

    /**
    * 
    * 
    */
    public List<String> countries() throws CallError, InterruptedException {
        return (List<String>)call("countries").get();
    }

    /**
    * 
    * 
    */
    public void setCountry(String param1) throws CallError, InterruptedException{
        call("setCountry", param1).get();
    }

    /**
    * 
    * 
    */
    public String country() throws CallError, InterruptedException {
        return (String)call("country").get();
    }

    /**
    * 
    * 
    */
    public Object interfaces() throws CallError, InterruptedException {
        return (Object)call("interfaces").get();
    }

}
    