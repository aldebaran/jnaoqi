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
public class ALDebug extends ALModule {

    public ALDebug(Session session) {
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
    public void _stopOneThread() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_stopOneThread");
        else
            service.call("_stopOneThread").get();
    }

    /**
    * 
    * 
    */
    public String _dumpPythonTraces() throws CallError, InterruptedException {
        return (String)service.call("_dumpPythonTraces").get();
    }

    /**
    * 
    * 
    */
    public void _makeMinidump() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_makeMinidump");
        else
            service.call("_makeMinidump").get();
    }

    /**
    * 
    * 
    */
    public void _probesInit(Boolean param1, Integer param2) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_probesInit", param1, param2);
        else
            service.call("_probesInit", param1, param2).get();
    }

    /**
    * 
    * 
    */
    public Boolean _probesRecordSnapshot() throws CallError, InterruptedException {
        return (Boolean)service.call("_probesRecordSnapshot").get();
    }

    /**
    * 
    * 
    */
    public void _probesSetTrigger(String param1, String param2, String param3) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_probesSetTrigger", param1, param2, param3);
        else
            service.call("_probesSetTrigger", param1, param2, param3).get();
    }

    /**
    * 
    * 
    */
    public void _probesRemoveTrigger(String param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_probesRemoveTrigger", param1);
        else
            service.call("_probesRemoveTrigger", param1).get();
    }

    /**
    * 
    * 
    */
    public void _probesStartTrigger() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_probesStartTrigger");
        else
            service.call("_probesStartTrigger").get();
    }

    /**
    * 
    * 
    */
    public void _probesStopTrigger() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_probesStopTrigger");
        else
            service.call("_probesStopTrigger").get();
    }

}
    