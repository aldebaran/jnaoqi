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
* @see <a href="http://doc.aldebaran.lan/doc/master/aldeb-doc/naoqi/connectionmanager/index.html#alconnectionmanager">NAOqi APIs for ALConnectionManager </a>
*
*/
public class ALConnectionManager extends ALProxy {

    public ALConnectionManager(Session session) {
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
    * 
    * 
    */
    public Object services() throws CallError, InterruptedException {
        return (Object)service.call("services").get();
    }

    /**
    * 
    * 
    */
    public Object serviceName(String param1) throws CallError, InterruptedException {
        return (Object)service.call("service", param1).get();
    }

    /**
    * 
    * 
    */
    public void scan(String param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("scan", param1);
        else
            service.call("scan", param1).get();
    }

    /**
    * 
    * 
    */
    public void scan() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("scan");
        else
            service.call("scan").get();
    }

    /**
    * 
    * 
    */
    public void setServiceConfiguration(Object param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setServiceConfiguration", param1);
        else
            service.call("setServiceConfiguration", param1).get();
    }

    /**
    * 
    * 
    */
    public void setServiceInput(Object param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setServiceInput", param1);
        else
            service.call("setServiceInput", param1).get();
    }

    /**
    * 
    * 
    */
    public String state() throws CallError, InterruptedException {
        return (String)service.call("state").get();
    }

    /**
    * 
    * 
    */
    public void forget(String param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("forget", param1);
        else
            service.call("forget", param1).get();
    }

    /**
    * 
    * 
    */
    public void connect(String param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("connect", param1);
        else
            service.call("connect", param1).get();
    }

    /**
    * 
    * 
    */
    public void disconnect(String param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("disconnect", param1);
        else
            service.call("disconnect", param1).get();
    }

    /**
    * 
    * 
    */
    public Object technologies() throws CallError, InterruptedException {
        return (Object)service.call("technologies").get();
    }

    /**
    * 
    * 
    */
    public void enableTethering(String param1, String param2, String param3) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("enableTethering", param1, param2, param3);
        else
            service.call("enableTethering", param1, param2, param3).get();
    }

    /**
    * 
    * 
    */
    public void enableTethering(String param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("enableTethering", param1);
        else
            service.call("enableTethering", param1).get();
    }

    /**
    * 
    * 
    */
    public void disableTethering(String param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("disableTethering", param1);
        else
            service.call("disableTethering", param1).get();
    }

    /**
    * 
    * 
    */
    public Boolean getTetheringEnable(String param1) throws CallError, InterruptedException {
        return (Boolean)service.call("getTetheringEnable", param1).get();
    }

    /**
    * 
    * 
    */
    public String tetheringName(String param1) throws CallError, InterruptedException {
        return (String)service.call("tetheringName", param1).get();
    }

    /**
    * 
    * 
    */
    public String tetheringPassphrase(String param1) throws CallError, InterruptedException {
        return (String)service.call("tetheringPassphrase", param1).get();
    }

    /**
    * 
    * 
    */
    public List<String> countries() throws CallError, InterruptedException {
        return (List<String>)service.call("countries").get();
    }

    /**
    * 
    * 
    */
    public void setCountry(String param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setCountry", param1);
        else
            service.call("setCountry", param1).get();
    }

    /**
    * 
    * 
    */
    public String country() throws CallError, InterruptedException {
        return (String)service.call("country").get();
    }

    /**
    * 
    * 
    */
    public Object interfaces() throws CallError, InterruptedException {
        return (Object)service.call("interfaces").get();
    }

    /**
    * 
    * 
    */
    public void provisionService(Map<String, String> param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("provisionService", param1);
        else
            service.call("provisionService", param1).get();
    }

    /**
    * 
    * 
    */
    public List<Map<String, String>> provisionedServices() throws CallError, InterruptedException {
        return (List<Map<String, String>>)service.call("provisionedServices").get();
    }

    /**
    * 
    * 
    */
    public void removeProvisionedService(String param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("removeProvisionedService", param1);
        else
            service.call("removeProvisionedService", param1).get();
    }

}
    