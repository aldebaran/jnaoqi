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
public class ALLogger extends ALModule {

    public ALLogger(Session session) {
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
    * Exits and unregisters the module.
    * 
    */
    public void exit() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("exit");
        else
            service.call("exit").get();
    }

    /**
    * Returns the version of the module.
    * 
    * @return A string containing the version of the module.
    */
    public String version() throws CallError, InterruptedException {
        return (String)service.call("version").get();
    }

    /**
    * Just a ping. Always returns true
    * 
    * @return returns true
    */
    public Boolean ping() throws CallError, InterruptedException {
        return (Boolean)service.call("ping").get();
    }

    /**
    * Retrieves the module's method list.
    * 
    * @return An array of method names.
    */
    public List<String> getMethodList() throws CallError, InterruptedException {
        return (List<String>)service.call("getMethodList").get();
    }

    /**
    * Retrieves a method's description.
    * 
    * @param methodName  The name of the method.
    * @return A structure containing the method's description.
    */
    public java.lang.Object getMethodHelp(String methodName) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("getMethodHelp", methodName).get();
    }

    /**
    * Retrieves the module's description.
    * 
    * @return A structure describing the module.
    */
    public java.lang.Object getModuleHelp() throws CallError, InterruptedException {
        return (java.lang.Object)service.call("getModuleHelp").get();
    }

    /**
    * Wait for the end of a long running method that was called using 'post'
    * 
    * @param id  The ID of the method that was returned when calling the method using 'post'
    * @param timeoutPeriod  The timeout period in ms. To wait indefinately, use a timeoutPeriod of zero.
    * @return True if the timeout period terminated. False if the method returned.
    */
    public Boolean wait(Integer id, Integer timeoutPeriod) throws CallError, InterruptedException {
        return (Boolean)service.call("wait", id, timeoutPeriod).get();
    }

    /**
    * Returns true if the method is currently running.
    * 
    * @param id  The ID of the method that was returned when calling the method using 'post'
    * @return True if the method is currently running
    */
    public Boolean isRunning(Integer id) throws CallError, InterruptedException {
        return (Boolean)service.call("isRunning", id).get();
    }

    /**
    * returns true if the method is currently running
    * 
    * @param id  the ID of the method to wait for
    */
    public void stop(Integer id) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("stop", id);
        else
            service.call("stop", id).get();
    }

    /**
    * Gets the name of the parent broker.
    * 
    * @return The name of the parent broker.
    */
    public String getBrokerName() throws CallError, InterruptedException {
        return (String)service.call("getBrokerName").get();
    }

    /**
    * Gets the method usage string. This summarises how to use the method.
    * 
    * @param name  The name of the method.
    * @return A string that summarises the usage of the method.
    */
    public String getUsage(String name) throws CallError, InterruptedException {
        return (String)service.call("getUsage", name).get();
    }

    /**
    * DEPRECATED. Use qiLogFatal instead. 
 Log a fatal error.
    * 
    * @param moduleName  Name of the module.
    * @param message  Log Message.
    */
    public void fatal(String moduleName, String message) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("fatal", moduleName, message);
        else
            service.call("fatal", moduleName, message).get();
    }

    /**
    * DEPRECATED. Use qiLogError instead. 
 Log an error.
    * 
    * @param moduleName  Name of the module.
    * @param message  Log Message.
    */
    public void error(String moduleName, String message) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("error", moduleName, message);
        else
            service.call("error", moduleName, message).get();
    }

    /**
    * DEPRECATED: use qiLogWarning instead. Log a warning.
    * 
    * @param moduleName  Name of the module.
    * @param message  Log Message.
    */
    public void warn(String moduleName, String message) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("warn", moduleName, message);
        else
            service.call("warn", moduleName, message).get();
    }

    /**
    * DEPRECATED. Use qiLogInfo instead. 
 Log a info message.
    * 
    * @param moduleName  Name of the module.
    * @param message  Log Message.
    */
    public void info(String moduleName, String message) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("info", moduleName, message);
        else
            service.call("info", moduleName, message).get();
    }

    /**
    * DEPRECATED. Use qiLogDebug instead. 
 Log a debug message.
    * 
    * @param moduleName  Name of the module.
    * @param message  Log Message.
    */
    public void debug(String moduleName, String message) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("debug", moduleName, message);
        else
            service.call("debug", moduleName, message).get();
    }

    /**
    * Removed: not implemented anymore.
    * 
    */
    public void setVerbosity(String param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setVerbosity", param1);
        else
            service.call("setVerbosity", param1).get();
    }

    /**
    * Removed: not implemented anymore.
    * 
    */
    public Integer verbosity() throws CallError, InterruptedException {
        return (Integer)service.call("verbosity").get();
    }

    /**
    * Removed: not implemented anymore.
    * 
    */
    public void logInFile(String param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("logInFile", param1);
        else
            service.call("logInFile", param1).get();
    }

    /**
    * Removed: not implemented anymore.
    * 
    */
    public void logInForwarder(String param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("logInForwarder", param1);
        else
            service.call("logInForwarder", param1).get();
    }

    /**
    * Removed: not implemented anymore.
    * 
    */
    public void removeHandler(String param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("removeHandler", param1);
        else
            service.call("removeHandler", param1).get();
    }

}
    