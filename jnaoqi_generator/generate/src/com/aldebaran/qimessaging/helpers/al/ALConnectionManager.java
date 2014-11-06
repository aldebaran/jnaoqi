package com.aldebaran.qimessaging.helpers.al;

import com.aldebaran.qimessaging.CallError;
import com.aldebaran.qimessaging.Session;
import com.aldebaran.qimessaging.helpers.ALModule;
import java.util.List;
import java.util.Map;
import com.aldebaran.qimessaging.*;

import java.util.List;

/**
 * Created by erwan and emile on 01/05/2014.
 */
public class ALConnectionManager extends ALModule {

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
    public java.lang.Object services() throws CallError, InterruptedException {
        return (java.lang.Object)service.call("services").get();
    }

    /**
    * 
    * 
    */
    public java.lang.Object serviceName(String param1) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("service", param1).get();
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
    public void setServiceConfiguration(java.lang.Object param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setServiceConfiguration", param1);
        else
            service.call("setServiceConfiguration", param1).get();
    }

    /**
    * 
    * 
    */
    public void setServiceInput(java.lang.Object param1) throws CallError, InterruptedException{
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
    public java.lang.Object technologies() throws CallError, InterruptedException {
        return (java.lang.Object)service.call("technologies").get();
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
    public java.lang.Object interfaces() throws CallError, InterruptedException {
        return (java.lang.Object)service.call("interfaces").get();
    }

}
    