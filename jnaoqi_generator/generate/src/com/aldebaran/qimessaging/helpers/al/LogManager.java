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
public class LogManager extends ALModule {

    public LogManager(Session session) {
        super(session);
    }

    /**
    * 
    * 
    */
    public void log(List<Tuple7<String, Integer, Tuple2<Long, Long>, String, String, String, Integer>> param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("log", param1);
        else
            service.call("log", param1).get();
    }

    /**
    * 
    * 
    */
    public void removeProvider(Integer param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("removeProvider", param1);
        else
            service.call("removeProvider", param1).get();
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
    public Integer addProvider(com.aldebaran.qimessaging.Object param1) throws CallError, InterruptedException {
        return (Integer)service.call("addProvider", param1).get();
    }

    /**
    * 
    * 
    */
    public com.aldebaran.qimessaging.Object getListener() throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object)service.call("getListener").get();
    }

}
    