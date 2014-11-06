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
public class ALRobotPosture extends ALModule {

    public ALRobotPosture(Session session) {
        super(session);
    }

    /**
    * Save current posture.
    * 
    */
    public Boolean _saveCurrentPosture(Integer param1) throws CallError, InterruptedException {
        return (Boolean)service.call("_saveCurrentPosture", param1).get();
    }

    /**
    * Add a neighbour to a postures.
    * 
    */
    public Boolean _addNeighbourToPosture(Integer param1, Integer param2, Float param3) throws CallError, InterruptedException {
        return (Boolean)service.call("_addNeighbourToPosture", param1, param2, param3).get();
    }

    /**
    * Resave posture joints, inertial, family. Keep neighbours.
    * 
    */
    public Boolean _resavePosture(Integer param1) throws CallError, InterruptedException {
        return (Boolean)service.call("_resavePosture", param1).get();
    }

    /**
    * Unbind two postures.
    * 
    */
    public Boolean _unBindPostures(Integer param1, Integer param2) throws CallError, InterruptedException {
        return (Boolean)service.call("_unBindPostures", param1, param2).get();
    }

    /**
    * Erase the posture and unBind theneighbours.
    * 
    */
    public Boolean _erasePosture(Integer param1) throws CallError, InterruptedException {
        return (Boolean)service.call("_erasePosture", param1).get();
    }

    /**
    * Set anti collisionbetween two postures.
    * 
    */
    public Boolean _setAntiCollision(Integer param1, Boolean param2) throws CallError, InterruptedException {
        return (Boolean)service.call("_setAntiCollision", param1, param2).get();
    }

    /**
    * Load a new library file.
    * 
    */
    public Boolean _loadPostureLibraryFromName(String param1) throws CallError, InterruptedException {
        return (Boolean)service.call("_loadPostureLibraryFromName", param1).get();
    }

    /**
    * Get current graph path.
    * 
    */
    public List<Float> _getCurrentPath() throws CallError, InterruptedException {
        return (List<Float>)service.call("_getCurrentPath").get();
    }

    /**
    * .
    * 
    */
    public void _isStandCallBack(String param1, java.lang.Object param2, String param3) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_isStandCallBack", param1, param2, param3);
        else
            service.call("_isStandCallBack", param1, param2, param3).get();
    }

    /**
    * .
    * 
    */
    public Boolean _savePostureLibrary(String param1) throws CallError, InterruptedException {
        return (Boolean)service.call("_savePostureLibrary", param1).get();
    }

    /**
    * .
    * 
    */
    public Float _getArticularDistanceToPosture(Integer param1) throws CallError, InterruptedException {
        return (Float)service.call("_getArticularDistanceToPosture", param1).get();
    }

    /**
    * Set cost between two postures.
    * 
    */
    public Boolean _setCost(Integer param1, Float param2) throws CallError, InterruptedException {
        return (Boolean)service.call("_setCost", param1, param2).get();
    }

    /**
    * .
    * 
    */
    public List<Float> _getCartesianDistanceVector(Integer param1) throws CallError, InterruptedException {
        return (List<Float>)service.call("_getCartesianDistanceVector", param1).get();
    }

    /**
    * .
    * 
    */
    public List<Integer> _getPostureIdList() throws CallError, InterruptedException {
        return (List<Integer>)service.call("_getPostureIdList").get();
    }

    /**
    * .
    * 
    */
    public Boolean _isReachable(Integer param1) throws CallError, InterruptedException {
        return (Boolean)service.call("_isReachable", param1).get();
    }

    /**
    * .
    * 
    */
    public void _generateCartesianMap() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_generateCartesianMap");
        else
            service.call("_generateCartesianMap").get();
    }

    /**
    * .
    * 
    */
    public java.lang.Object _getPostureZ(Float param1) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("_getPostureZ", param1).get();
    }

    /**
    * .
    * 
    */
    public java.lang.Object _getPostureNoZ() throws CallError, InterruptedException {
        return (java.lang.Object)service.call("_getPostureNoZ").get();
    }

    /**
    * Save with a namecurrent posture.
    * 
    */
    public Boolean _saveCurrentPostureWithName(Integer param1, String param2) throws CallError, InterruptedException {
        return (Boolean)service.call("_saveCurrentPostureWithName", param1, param2).get();
    }

    /**
    * Apply postures.
    * 
    */
    public Boolean _applyPostures(List<Integer> param1, Float param2, Boolean param3, Boolean param4) throws CallError, InterruptedException {
        return (Boolean)service.call("_applyPostures", param1, param2, param3, param4).get();
    }

    /**
    * Set slow factorbetween two postures.
    * 
    */
    public Boolean _setSlowFactor(Integer param1, Integer param2, Float param3) throws CallError, InterruptedException {
        return (Boolean)service.call("_setSlowFactor", param1, param2, param3).get();
    }

    /**
    * Erase all postures.
    * 
    */
    public Boolean _eraseAllPostures() throws CallError, InterruptedException {
        return (Boolean)service.call("_eraseAllPostures").get();
    }

    /**
    * Bind two postures.
    * 
    */
    public Boolean _bindPostures(Integer param1, Integer param2, Float param3, Float param4) throws CallError, InterruptedException {
        return (Boolean)service.call("_bindPostures", param1, param2, param3, param4).get();
    }

    /**
    * Remove a neighbour from postures.
    * 
    */
    public Boolean _removeNeighbourFromPosture(Integer param1, Integer param2) throws CallError, InterruptedException {
        return (Boolean)service.call("_removeNeighbourFromPosture", param1, param2).get();
    }

    /**
    * .
    * 
    */
    public java.lang.Object _getCartesianDistanceToPosture(Integer param1) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("_getCartesianDistanceToPosture", param1).get();
    }

    /**
    * Get library size.
    * 
    */
    public Integer _getLibrarySize() throws CallError, InterruptedException {
        return (Integer)service.call("_getLibrarySize").get();
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
    * Returns the posture family for example Standing, LyingBelly,...
    * 
    * @return Returns the posture family, e.g. Standing.
    */
    public String getPostureFamily() throws CallError, InterruptedException {
        return (String)service.call("getPostureFamily").get();
    }

    /**
    * Make the robot go to the choosenposture.
    * 
    * @param postureName  Name of the desired posture. Use getPostureList to get the list of posture name available.
    * @param maxSpeedFraction  A fraction.
    * @return Returns if the posture was reached or not.
    */
    public Boolean goToPosture(String postureName, Float maxSpeedFraction) throws CallError, InterruptedException {
        return (Boolean)service.call("goToPosture", postureName, maxSpeedFraction).get();
    }

    /**
    * Set the angle of the joints of the  robot to the choosen posture.
    * 
    * @param postureName  Name of the desired posture. Use getPostureList to get the list of posture name available.
    * @param maxSpeedFraction  A fraction.
    * @return Returns if the posture was reached or not.
    */
    public Boolean applyPosture(String postureName, Float maxSpeedFraction) throws CallError, InterruptedException {
        return (Boolean)service.call("applyPosture", postureName, maxSpeedFraction).get();
    }

    /**
    * Stop the posture move.
    * 
    */
    public void stopMove() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("stopMove");
        else
            service.call("stopMove").get();
    }

    /**
    * Get the list of posture names available.
    * 
    */
    public List<String> getPostureList() throws CallError, InterruptedException {
        return (List<String>)service.call("getPostureList").get();
    }

    /**
    * Get the list of posture family names available.
    * 
    */
    public List<String> getPostureFamilyList() throws CallError, InterruptedException {
        return (List<String>)service.call("getPostureFamilyList").get();
    }

    /**
    * Set maximum of tries ongoToPosture fail.
    * 
    * @param pMaxTryNumber  Number of retry if goToPosture fail.
    */
    public void setMaxTryNumber(Integer pMaxTryNumber) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setMaxTryNumber", pMaxTryNumber);
        else
            service.call("setMaxTryNumber", pMaxTryNumber).get();
    }

    /**
    * Determine posture.
    * 
    */
    public String getPosture() throws CallError, InterruptedException {
        return (String)service.call("getPosture").get();
    }

    /**
    * Articular distance
    * 
    */
    public java.lang.Object _isRobotInPosture(String param1, Float param2, Float param3) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("_isRobotInPosture", param1, param2, param3).get();
    }

    /**
    * Articular distance
    * 
    */
    public Boolean _isRobotInPostureId(Integer param1, Float param2, Float param3) throws CallError, InterruptedException {
        return (Boolean)service.call("_isRobotInPostureId", param1, param2, param3).get();
    }

    /**
    * Determine posture id.
    * 
    */
    public java.lang.Object _getPosture() throws CallError, InterruptedException {
        return (java.lang.Object)service.call("_getPosture").get();
    }

    /**
    * Set the angle of the joints.
    * 
    */
    public Boolean _setPostureId(Integer param1, Float param2) throws CallError, InterruptedException {
        return (Boolean)service.call("_setPostureId", param1, param2).get();
    }

    /**
    * Set the angle of thejoints and of the inertial unit
    * 
    */
    public Boolean _goToPostureId(Integer param1, Float param2) throws CallError, InterruptedException {
        return (Boolean)service.call("_goToPostureId", param1, param2).get();
    }

    /**
    * Name posture from id.
    * 
    */
    public Boolean _namePosture(Integer param1, String param2) throws CallError, InterruptedException {
        return (Boolean)service.call("_namePosture", param1, param2).get();
    }

    /**
    * Rename posture from name.
    * 
    */
    public Boolean _renamePosture(String param1, String param2) throws CallError, InterruptedException {
        return (Boolean)service.call("_renamePosture", param1, param2).get();
    }

}
    