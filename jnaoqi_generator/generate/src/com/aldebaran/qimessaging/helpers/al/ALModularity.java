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
public class ALModularity extends ALModule {

    public ALModularity(Session session) {
        super(session);
    }

    /**
    * 
    * 
    * @param name  The name of the process.
    */
    public Boolean isProcesses(String name) throws CallError, InterruptedException {
        return (Boolean)service.call("isProcesses", name).get();
    }

    /**
    * 
    * 
    * @param name  The name of the process.
    */
    public Integer getProcessPriority(String name) throws CallError, InterruptedException {
        return (Integer)service.call("getProcessPriority", name).get();
    }

    /**
    * 
    * 
    * @param name  The name of the source.
    */
    public Boolean deleteSource(String name) throws CallError, InterruptedException {
        return (Boolean)service.call("deleteSource", name).get();
    }

    /**
    * 
    * 
    * @param name  The name of the process.
    * @param priority  The new priority of the process.
    */
    public Boolean setProcessPriority(String name, Integer priority) throws CallError, InterruptedException {
        return (Boolean)service.call("setProcessPriority", name, priority).get();
    }

    /**
    * 
    * 
    * @param name  The name of the process.
    * @param priority  The new frequency of the process.
    */
    public Boolean setProcessFrequency(String name, Float priority) throws CallError, InterruptedException {
        return (Boolean)service.call("setProcessFrequency", name, priority).get();
    }

    /**
    * 
    * 
    * @param heightOffset  Height Offset of the robot from the ground.
    */
    public Boolean setRobotHeightOffset(Float heightOffset) throws CallError, InterruptedException {
        return (Boolean)service.call("setRobotHeightOffset", heightOffset).get();
    }

    /**
    * 
    * 
    * @param name  The name of the process.
    */
    public Boolean isProcessEnable(String name) throws CallError, InterruptedException {
        return (Boolean)service.call("isProcessEnable", name).get();
    }

    /**
    * 
    * 
    * @param name  The name of the process.
    */
    public Boolean isProcessZombie(String name) throws CallError, InterruptedException {
        return (Boolean)service.call("isProcessZombie", name).get();
    }

    /**
    * 
    * 
    * @param name  The name of the process.
    */
    public Boolean enableProcess(String name) throws CallError, InterruptedException {
        return (Boolean)service.call("enableProcess", name).get();
    }

    /**
    * 
    * 
    * @param name  The name of the process.
    */
    public Boolean disableProcess(String name) throws CallError, InterruptedException {
        return (Boolean)service.call("disableProcess", name).get();
    }

    /**
    * 
    * 
    * @param name  The name of the process.
    */
    public Boolean deleteProcess(String name) throws CallError, InterruptedException {
        return (Boolean)service.call("deleteProcess", name).get();
    }

    /**
    * 
    * 
    */
    public List<String> getProcesses() throws CallError, InterruptedException {
        return (List<String>)service.call("getProcesses").get();
    }

    /**
    * 
    * 
    */
    public Boolean startScheduler() throws CallError, InterruptedException {
        return (Boolean)service.call("startScheduler").get();
    }

    /**
    * 
    * 
    */
    public Boolean stopScheduler() throws CallError, InterruptedException {
        return (Boolean)service.call("stopScheduler").get();
    }

    /**
    * 
    * 
    */
    public String getInstrumentationResult() throws CallError, InterruptedException {
        return (String)service.call("getInstrumentationResult").get();
    }

    /**
    * 
    * 
    * @param filter  The name of the filter to dump.
    * @param level  Maximum depth (-1 for unlimited depth)
    */
    public java.lang.Object getDotGraph(String filter, Integer level) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("getDotGraph", filter, level).get();
    }

    /**
    * 
    * 
    * @param name  The name of the process.
    */
    public String getProcessDescription(String name) throws CallError, InterruptedException {
        return (String)service.call("getProcessDescription", name).get();
    }

    /**
    * 
    * 
    * @param name  The name of the process.
    */
    public List<String> getProcessSources(String name) throws CallError, InterruptedException {
        return (List<String>)service.call("getProcessSources", name).get();
    }

    /**
    * 
    * 
    */
    public Float getRobotHeightOffset() throws CallError, InterruptedException {
        return (Float)service.call("getRobotHeightOffset").get();
    }

    /**
    * 
    * 
    * @param name  The name of the process.
    */
    public List<String> getProcessSinks(String name) throws CallError, InterruptedException {
        return (List<String>)service.call("getProcessSinks", name).get();
    }

    /**
    * 
    * 
    * @param name  The name of the process.
    */
    public List<String> getProcessAggregatedSinks(String name) throws CallError, InterruptedException {
        return (List<String>)service.call("getProcessAggregatedSinks", name).get();
    }

    /**
    * 
    * 
    * @param name  The name of the process.
    */
    public Float getProcessFrequency(String name) throws CallError, InterruptedException {
        return (Float)service.call("getProcessFrequency", name).get();
    }

    /**
    * 
    * 
    */
    public List<String> getScheduledJobs() throws CallError, InterruptedException {
        return (List<String>)service.call("getScheduledJobs").get();
    }

    /**
    * 
    * 
    * @param name  The name of the process to reset.
    */
    public Boolean resetProcess(String name) throws CallError, InterruptedException {
        return (Boolean)service.call("resetProcess", name).get();
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
    * 
    * 
    */
    public java.lang.Object getModularity() throws CallError, InterruptedException {
        return (java.lang.Object)service.call("getModularity").get();
    }

    /**
    * 
    * 
    * @param program  The code that will be used by Modularity to generate a part of the graph.
    */
    public Boolean loadProgram(String program) throws CallError, InterruptedException {
        return (Boolean)service.call("loadProgram", program).get();
    }

    /**
    * 
    * 
    */
    public Boolean loadProgramFromFile(String param1) throws CallError, InterruptedException {
        return (Boolean)service.call("loadProgramFromFile", param1).get();
    }

    /**
    * 
    * 
    * @param sink  The name of the sink from where data must be extracted.
    */
    public java.lang.Object getData(String sink) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("getData", sink).get();
    }

    /**
    * 
    * 
    * @param sink  The name of the sink from where data must be extracted.
    */
    public java.lang.Object getLastData(String sink) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("getLastData", sink).get();
    }

    /**
    * 
    * 
    * @param sink  The name of the sink from where data must be extracted.
    */
    public java.lang.Object getImageLocal(String sink) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("getImageLocal", sink).get();
    }

    /**
    * 
    * 
    * @param sink  The name of the sink from where data must be extracted.
    */
    public java.lang.Object getImageRemote(String sink) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("getImageRemote", sink).get();
    }

    /**
    * 
    * 
    */
    public java.lang.Object getFilters() throws CallError, InterruptedException {
        return (java.lang.Object)service.call("getFilters").get();
    }

    /**
    * 
    * 
    * @param name  The name of the filter.
    */
    public String getFilterDescription(String name) throws CallError, InterruptedException {
        return (String)service.call("getFilterDescription", name).get();
    }

    /**
    * 
    * 
    * @param name  The name of the filter.
    */
    public java.lang.Object getFilterInputs(String name) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("getFilterInputs", name).get();
    }

    /**
    * 
    * 
    * @param name  The name of the filter.
    */
    public java.lang.Object getFilterOutputs(String name) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("getFilterOutputs", name).get();
    }

    /**
    * 
    * 
    * @param name  The name of the filter.
    */
    public Boolean deleteFilter(String name) throws CallError, InterruptedException {
        return (Boolean)service.call("deleteFilter", name).get();
    }

    /**
    * 
    * 
    */
    public List<String> getSources() throws CallError, InterruptedException {
        return (List<String>)service.call("getSources").get();
    }

    /**
    * 
    * 
    * @param name  The name of the source.
    */
    public Boolean isSourceBinded(String name) throws CallError, InterruptedException {
        return (Boolean)service.call("isSourceBinded", name).get();
    }

    /**
    * 
    * 
    * @param name  The name of the source.
    */
    public Float getSourceFrequency(String name) throws CallError, InterruptedException {
        return (Float)service.call("getSourceFrequency", name).get();
    }

}
    