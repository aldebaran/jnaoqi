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
public class ALStore extends ALModule {

    public ALStore(Session session) {
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
    *  ALStore Init 
    * 
    */
    public java.lang.Object __init__(java.lang.Object param1) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("__init__", param1).get();
    }

    /**
    *  Populate the Packages List the Robot Should Have 
    * 
    */
    public java.lang.Object _updateStoreList() throws CallError, InterruptedException {
        return (java.lang.Object)service.call("_updateStoreList").get();
    }

    /**
    *  Add a Robot Notification 
    * 
    */
    public java.lang.Object add_notification(java.lang.Object param1) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("add_notification", param1).get();
    }

    /**
    *  Analyse the actions to take 
    * 
    */
    public java.lang.Object analyse() throws CallError, InterruptedException {
        return (java.lang.Object)service.call("analyse").get();
    }

    /**
    *  Assign the Robot to a User 
    * 
    */
    public java.lang.Object assign(java.lang.Object param1, java.lang.Object param2) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("assign", param1, param2).get();
    }

    /**
    *  Check Updates From the Store 
    * 
    */
    public java.lang.Object checkUpdate() throws CallError, InterruptedException {
        return (java.lang.Object)service.call("checkUpdate").get();
    }

    /**
    *  Download a Package to a path if not already present 
    * 
    */
    public java.lang.Object download(java.lang.Object param1) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("download", param1).get();
    }

    /**
    *  Get a Package Info from the Packages List 
    * 
    */
    public java.lang.Object getPackageInfo(java.lang.Object param1) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("getPackageInfo", param1).get();
    }

    /**
    * Install the pkg with the PackageManager 
    * 
    */
    public java.lang.Object install(java.lang.Object param1, java.lang.Object param2) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("install", param1, param2).get();
    }

    /**
    *  Log a Debugging Message 
    * 
    */
    public java.lang.Object log_debug(java.lang.Object param1) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("log_debug", param1).get();
    }

    /**
    *  Log an Error Message 
    * 
    */
    public java.lang.Object log_error(java.lang.Object param1) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("log_error", param1).get();
    }

    /**
    *  Log an Information Message 
    * 
    */
    public java.lang.Object log_info(java.lang.Object param1) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("log_info", param1).get();
    }

    /**
    *  Log a Warning Message 
    * 
    */
    public java.lang.Object log_warning(java.lang.Object param1) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("log_warning", param1).get();
    }

    /**
    *  Play a Sound using the Audio Player 
    * 
    */
    public java.lang.Object play_sound(java.lang.Object param1) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("play_sound", param1).get();
    }

    /**
    *  Get the status of the update 
    * 
    */
    public java.lang.Object status() throws CallError, InterruptedException {
        return (java.lang.Object)service.call("status").get();
    }

    /**
    *  Stop the current update process 
    * 
    */
    public java.lang.Object stopUpdate() throws CallError, InterruptedException {
        return (java.lang.Object)service.call("stopUpdate").get();
    }

    /**
    *  Translate a massage using the Translator 
    * 
    */
    public java.lang.Object translate(java.lang.Object param1) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("translate", param1).get();
    }

    /**
    *  Launch Update if not already running 
    * 
    */
    public java.lang.Object update() throws CallError, InterruptedException {
        return (java.lang.Object)service.call("update").get();
    }

    /**
    *  Update the Applications 
    * 
    */
    public java.lang.Object updateApps() throws CallError, InterruptedException {
        return (java.lang.Object)service.call("updateApps").get();
    }

    /**
    *  Subscribe to the Connect Event to Update just After 
    * 
    */
    public java.lang.Object updateOnConnect() throws CallError, InterruptedException {
        return (java.lang.Object)service.call("updateOnConnect").get();
    }

    /**
    *  Update the System 
    * 
    */
    public java.lang.Object updateSystem() throws CallError, InterruptedException {
        return (java.lang.Object)service.call("updateSystem").get();
    }

}
    