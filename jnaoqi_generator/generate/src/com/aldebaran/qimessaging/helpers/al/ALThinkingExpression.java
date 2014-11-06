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
public class ALThinkingExpression extends ALModule {

    public ALThinkingExpression(Session session) {
        super(session);
    }

    /**
    * 
    * 
    */
    public void _startActivity(String param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_startActivity", param1);
        else
            service.call("_startActivity", param1).get();
    }

    /**
    * 
    * 
    */
    public void _onPreferenceSynchronized() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_onPreferenceSynchronized");
        else
            service.call("_onPreferenceSynchronized").get();
    }

    /**
    * 
    * 
    */
    public Integer _refCount() throws CallError, InterruptedException {
        return (Integer)service.call("_refCount").get();
    }

    /**
    * 
    * 
    */
    public Boolean isRunning() throws CallError, InterruptedException {
        return (Boolean)service.call("isRunning").get();
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
    public void _onPreferenceUpdated(java.lang.Object param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_onPreferenceUpdated", param1);
        else
            service.call("_onPreferenceUpdated", param1).get();
    }

    /**
    * 
    * 
    */
    public void stop() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("stop");
        else
            service.call("stop").get();
    }

    /**
    * 
    * 
    */
    public void start() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("start");
        else
            service.call("start").get();
    }

}
    