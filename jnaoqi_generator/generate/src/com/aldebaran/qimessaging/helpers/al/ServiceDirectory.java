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
public class ServiceDirectory extends ALModule {

    public ServiceDirectory(Session session) {
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
    public Tuple6<String, Integer, String, Integer, List<String>, String> serviceName(String param1) throws CallError, InterruptedException {
        return (Tuple6<String, Integer, String, Integer, List<String>, String>)service.call("service", param1).get();
    }

    /**
    * 
    * 
    */
    public List<Tuple6<String, Integer, String, Integer, List<String>, String>> services() throws CallError, InterruptedException {
        return (List<Tuple6<String, Integer, String, Integer, List<String>, String>>)service.call("services").get();
    }

    /**
    * 
    * 
    */
    public Integer registerService(Tuple6<String, Integer, String, Integer, List<String>, String> param1) throws CallError, InterruptedException {
        return (Integer)service.call("registerService", param1).get();
    }

    /**
    * 
    * 
    */
    public void unregisterService(Integer param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("unregisterService", param1);
        else
            service.call("unregisterService", param1).get();
    }

    /**
    * 
    * 
    */
    public void serviceReady(Integer param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("serviceReady", param1);
        else
            service.call("serviceReady", param1).get();
    }

    /**
    * 
    * 
    */
    public void updateServiceInfo(Tuple6<String, Integer, String, Integer, List<String>, String> param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("updateServiceInfo", param1);
        else
            service.call("updateServiceInfo", param1).get();
    }

    /**
    * 
    * 
    */
    public String machineId() throws CallError, InterruptedException {
        return (String)service.call("machineId").get();
    }

    /**
    * 
    * 
    */
    public com.aldebaran.qimessaging.Object _socketOfService(Integer param1) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object)service.call("_socketOfService", param1).get();
    }

}
    