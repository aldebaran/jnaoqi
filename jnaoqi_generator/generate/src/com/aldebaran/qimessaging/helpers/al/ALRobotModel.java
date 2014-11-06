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
public class ALRobotModel extends ALModule {

    public ALRobotModel(Session session) {
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
    * Return the RobotConfig key/value pairs serialized in xml format
    * 
    * @return the RobotConfig key/value pairs in xml format
    */
    public String getConfig() throws CallError, InterruptedException {
        return (String)service.call("getConfig").get();
    }

    /**
    * Return the RobotConfig key/value pairs
    * 
    * @return the RobotConfig key/value pairs in a  std::map<std::string, AL::ALValue>
    */
    public Map<String, java.lang.Object> _getConfigMap() throws CallError, InterruptedException {
        return (Map<String, java.lang.Object>)service.call("_getConfigMap").get();
    }

    /**
    * Determine if the robot is a robocup version.
    * 
    * @return True if the robot is a robocup version.
    */
    public Boolean _isRobocup() throws CallError, InterruptedException {
        return (Boolean)service.call("_isRobocup").get();
    }

    /**
    * Get the robot model. Could be : ROBOT_MODEL_H25, ROBOT_MODEL_H21, ....
    * 
    * @return The robot model.
    */
    public Integer _getRobotModel() throws CallError, InterruptedException {
        return (Integer)service.call("_getRobotModel").get();
    }

    /**
    * Get the robot type. Could be : ROBOT_TYPE_NAO, ROBOT_TYPE_ROMEO ....
    * 
    * @return The robot type.
    */
    public Integer _getRobotType() throws CallError, InterruptedException {
        return (Integer)service.call("_getRobotType").get();
    }

    /**
    * Get the robot type. Could be : nao, romeo, ....
    * 
    * @return The robot type.
    */
    public String _getRobotTypeString() throws CallError, InterruptedException {
        return (String)service.call("_getRobotTypeString").get();
    }

    /**
    * Set config from model type name 

    * 
    * @param fileName  the file name of config XML (NAOT2V32.xml, NAOH25V40.xml, ...)
    */
    public void _setConfigFromConfigXml(String fileName) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_setConfigFromConfigXml", fileName);
        else
            service.call("_setConfigFromConfigXml", fileName).get();
    }

    /**
    * Get microphone configuration.
    * 
    * @return Integer value representing the config.
    */
    public Integer _getMicrophoneConfig() throws CallError, InterruptedException {
        return (Integer)service.call("_getMicrophoneConfig").get();
    }

    /**
    * Determine if the robot has touch sensor in the hands.
    * 
    * @return True if the robot has the sensors.
    */
    public Boolean _hasTouchSensorInHands() throws CallError, InterruptedException {
        return (Boolean)service.call("_hasTouchSensorInHands").get();
    }

    /**
    * Determine if the robot has a tablet.
    * 
    * @return True if the robot has the tablet.
    */
    public Boolean _hasTablet() throws CallError, InterruptedException {
        return (Boolean)service.call("_hasTablet").get();
    }

}
    