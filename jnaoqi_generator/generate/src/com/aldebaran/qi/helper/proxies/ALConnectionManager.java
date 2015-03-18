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
* @see <a href="http://doc.aldebaran.lan/doc/release-2.1/aldeb-doc/naoqi/connectionmanager/index.html#alconnectionmanager">NAOqi APIs for ALConnectionManager </a>
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
        if (isAsynchronous)
            call("clearStats");
        else
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
    public Object serviceName(String param1) throws CallError, InterruptedException {
        return (Object)call("service", param1).get();
    }

    /**
    * 
    * 
    */
    public void scan(String param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("scan", param1);
        else
            call("scan", param1).get();
    }

    /**
    * 
    * 
    */
    public void scan() throws CallError, InterruptedException{
        if (isAsynchronous)
            call("scan");
        else
            call("scan").get();
    }

    /**
    * 
    * 
    */
    public void setServiceConfiguration(Object param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("setServiceConfiguration", param1);
        else
            call("setServiceConfiguration", param1).get();
    }

    /**
    * 
    * 
    */
    public void setServiceInput(Object param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("setServiceInput", param1);
        else
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
        if (isAsynchronous)
            call("forget", param1);
        else
            call("forget", param1).get();
    }

    /**
    * 
    * 
    */
    public void connect(String param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("connect", param1);
        else
            call("connect", param1).get();
    }

    /**
    * 
    * 
    */
    public void disconnect(String param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("disconnect", param1);
        else
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
        if (isAsynchronous)
            call("enableTethering", param1, param2, param3);
        else
            call("enableTethering", param1, param2, param3).get();
    }

    /**
    * 
    * 
    */
    public void enableTethering(String param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("enableTethering", param1);
        else
            call("enableTethering", param1).get();
    }

    /**
    * 
    * 
    */
    public void disableTethering(String param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("disableTethering", param1);
        else
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
        if (isAsynchronous)
            call("setCountry", param1);
        else
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
    