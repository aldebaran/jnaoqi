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
public class ALNavigation extends ALModule {

    public ALNavigation(Session session) {
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
    * Makes the robot navigate to a relative metrical target pose2D expressed in FRAME_ROBOT. The robot computes a path to avoid obstacles.
    * 
    * @param x  The position along x axis [m].
    * @param y  The position along y axis [m].
    */
    public Boolean navigateTo(Float x, Float y) throws CallError, InterruptedException {
        return (Boolean)service.call("navigateTo", x, y).get();
    }

    /**
    * Makes the robot navigate to a relative metrical target pose2D expressed in FRAME_ROBOT. The robot computes a path to avoid obstacles.
    * 
    * @param x  The position along x axis [m].
    * @param y  The position along y axis [m].
    * @param config  Configuration ALValue. For example, [["SpeedFactor", 0.5]] sets speedFactor to 0.5
    */
    public Boolean navigateTo(Float x, Float y, java.lang.Object config) throws CallError, InterruptedException {
        return (Boolean)service.call("navigateTo", x, y, config).get();
    }

    /**
    * Makes the robot navigate to a relative metrical target pose2D expressed in FRAME_ROBOT. The robot computes a path to avoid obstacles.
    * 
    * @param x  The position along x axis [m].
    * @param y  The position along y axis [m].
    * @param theta  Orientation of the robot (rad).
    */
    public Boolean navigateTo(Float x, Float y, Float theta) throws CallError, InterruptedException {
        return (Boolean)service.call("navigateTo", x, y, theta).get();
    }

    /**
    * Makes the robot navigate to a relative metrical target pose2D expressed in FRAME_ROBOT. The robot computes a path to avoid obstacles.
    * 
    * @param x  The position along x axis [m].
    * @param y  The position along y axis [m].
    * @param theta  Orientation of the robot (rad).
    * @param config  Configuration ALValue. For example, [["SpeedFactor", 0.5]] sets speedFactor to 0.5
    */
    public Boolean navigateTo(Float x, Float y, Float theta, java.lang.Object config) throws CallError, InterruptedException {
        return (Boolean)service.call("navigateTo", x, y, theta, config).get();
    }

    /**
    * Makes the robot move at the given position.This is a blocking call.
    * 
    * @param x  The position along x axis [m].
    * @param y  The position along y axis [m].
    * @param theta  The angle around z axis [rad].
    */
    public void moveTo(Float x, Float y, Float theta) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("moveTo", x, y, theta);
        else
            service.call("moveTo", x, y, theta).get();
    }

    /**
    * Makes the robot move at the given position.This is a blocking call.
    * 
    * @param x  The position along x axis [m].
    * @param y  The position along y axis [m].
    * @param theta  The angle around z axis [rad].
    * @param moveConfig  An ALValue with custom move configuration.
    */
    public void moveTo(Float x, Float y, Float theta, java.lang.Object moveConfig) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("moveTo", x, y, theta, moveConfig);
        else
            service.call("moveTo", x, y, theta, moveConfig).get();
    }

    /**
    * Makes the robot move at the given speed in S.I. units. This is a blocking call.
    * 
    * @param x  The speed along x axis [m.s-1].
    * @param y  The speed along y axis [m.s-1].
    * @param theta  The anglular speed around z axis [rad.s-1].
    */
    public void move(Float x, Float y, Float theta) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("move", x, y, theta);
        else
            service.call("move", x, y, theta).get();
    }

    /**
    * Makes the robot move at the given speed in S.I. units. This is a blocking call.
    * 
    * @param x  The speed along x axis [m.s-1].
    * @param y  The speed along y axis [m.s-1].
    * @param theta  The anglular speed around z axis [rad.s-1].
    * @param moveConfig  An ALValue with custom move configuration.
    */
    public void move(Float x, Float y, Float theta, java.lang.Object moveConfig) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("move", x, y, theta, moveConfig);
        else
            service.call("move", x, y, theta, moveConfig).get();
    }

    /**
    * Makes the robot move at the given speed in normalized speed fraction. This is a blocking call.
    * 
    * @param x  The speed along x axis [0.0-1.0].
    * @param y  The speed along y axis [0.0-1.0].
    * @param theta  The anglular speed around z axis [0.0-1.0].
    */
    public void moveToward(Float x, Float y, Float theta) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("moveToward", x, y, theta);
        else
            service.call("moveToward", x, y, theta).get();
    }

    /**
    * Makes the robot move at the given speed in normalized speed fraction. This is a blocking call.
    * 
    * @param x  The speed along x axis [0.0-1.0].
    * @param y  The speed along y axis [0.0-1.0].
    * @param theta  The anglular speed around z axis [0.0-1.0].
    * @param moveConfig  An ALValue with custom move configuration.
    */
    public void moveToward(Float x, Float y, Float theta, java.lang.Object moveConfig) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("moveToward", x, y, theta, moveConfig);
        else
            service.call("moveToward", x, y, theta, moveConfig).get();
    }

    /**
    * Internal Use.
    * 
    * @param config  Internal: An array of ALValues [i][0]: name, [i][1]: value
    */
    public void _setNavigationConfig(java.lang.Object config) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_setNavigationConfig", config);
        else
            service.call("_setNavigationConfig", config).get();
    }

    /**
    * Distance in meters fromwhich the robot should stop if there is an obstacle.
    * 
    */
    public void setSecurityDistance(Float param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setSecurityDistance", param1);
        else
            service.call("setSecurityDistance", param1).get();
    }

    /**
    * Distance in meters fromwhich the robot should stop if there is an obstacle.
    * 
    */
    public Float getSecurityDistance() throws CallError, InterruptedException {
        return (Float)service.call("getSecurityDistance").get();
    }

    /**
    * Stops the navigateTo.
    * 
    */
    public void stopNavigateTo() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("stopNavigateTo");
        else
            service.call("stopNavigateTo").get();
    }

    /**
    * Distance in meters fromwhich the robot should stop if there is an obstacle.
    * 
    */
    public void _setTangentialSecurityDistance(Float param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_setTangentialSecurityDistance", param1);
        else
            service.call("_setTangentialSecurityDistance", param1).get();
    }

    /**
    * Distance in meters fromwhich the robot should stop if there is an obstacle.
    * 
    */
    public Float _getTangentialSecurityDistance() throws CallError, InterruptedException {
        return (Float)service.call("_getTangentialSecurityDistance").get();
    }

    /**
    * Distance in meters fromwhich the robot should stop if there is an obstacle.
    * 
    */
    public Integer _getNavigateToStatus() throws CallError, InterruptedException {
        return (Integer)service.call("_getNavigateToStatus").get();
    }

    /**
    * Obstacles data.ALArray formatted as follow for each ALValue : [0]:familyName[1]:name[2]:Array containing [x, y] arrays of points in robot frame.Those obstacles are the one used by the secure navigator
    * 
    */
    public java.lang.Object _getObstacleData() throws CallError, InterruptedException {
        return (java.lang.Object)service.call("_getObstacleData").get();
    }

    /**
    * Obstacles data.ALArray formatted as follow for each ALValue : [0]:familyName[1]:name[2]:Array containing [x, y] arrays of points in robot frame.Those obstacles are taken from sensors
    * 
    */
    public java.lang.Object _getSensorData() throws CallError, InterruptedException {
        return (java.lang.Object)service.call("_getSensorData").get();
    }

    /**
    * Obstacles data.ALArray formatted as follow for each ALValue : [0]:familyName[1]:name[2]:Array containing [x, y] arrays of points in robot frame.Those obstacles are taken from sensors
    * 
    */
    public java.lang.Object _getSensorData(String param1) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("_getSensorData", param1).get();
    }

    /**
    * Obstacles data.ALArray formatted as follow for each ALValue : [0]:familyName[1]:name[2]:Array containing [x, y] arrays of points in robot frame.Those obstacles are taken from sensors
    * 
    */
    public java.lang.Object _getSensorData(List<String> param1) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("_getSensorData", param1).get();
    }

    /**
    * .
    * 
    */
    public Boolean _subscribeToAll(String param1) throws CallError, InterruptedException {
        return (Boolean)service.call("_subscribeToAll", param1).get();
    }

    /**
    * Start active sensors.The client needs to specify its name to register.If the client is the only one to register, the sensors are turned on, otherwise they are already started.
    * 
    * @param clientName  The client name.
    */
    public Boolean _subscribe(String clientName, List<String> param1) throws CallError, InterruptedException {
        return (Boolean)service.call("_subscribe", clientName, param1).get();
    }

    /**
    * .
    * 
    */
    public Boolean _unsubscribeFromAll(String param1) throws CallError, InterruptedException {
        return (Boolean)service.call("_unsubscribeFromAll", param1).get();
    }

    /**
    * Stop active sensors.The client needs to specify its name to unregister.The active sensors are actually stopped if not client is registered anymore.
    * 
    * @param clientName  The client name.
    */
    public Boolean _unsubscribe(String clientName, List<String> param1) throws CallError, InterruptedException {
        return (Boolean)service.call("_unsubscribe", clientName, param1).get();
    }

    /**
    * Add a sensor family or a sensor.
    * 
    * @param sensor  The sensor family name or name.
    */
    public Boolean _addSensor(String sensor) throws CallError, InterruptedException {
        return (Boolean)service.call("_addSensor", sensor).get();
    }

    /**
    * Remove a sensor family or a sensor.
    * 
    * @param sensor  The sensor family name or name.
    */
    public Boolean _removeSensor(String sensor) throws CallError, InterruptedException {
        return (Boolean)service.call("_removeSensor", sensor).get();
    }

    /**
    * Get trajectory from local navigator.ALArray containing successively x, y and theta coordinates.
    * 
    */
    public java.lang.Object _getTrajectory() throws CallError, InterruptedException {
        return (java.lang.Object)service.call("_getTrajectory").get();
    }

    /**
    * Set speed factor for local navigator
    * 
    */
    public void _setSpeedFactor(Float param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_setSpeedFactor", param1);
        else
            service.call("_setSpeedFactor", param1).get();
    }

    /**
    * Get obstacle Map from localnavigator. ALValue formatted as follow for each sensor :[[SensorName1 [[x1 y1] [x2 y2] [x3 y3] ...]] [SensorName2 [[x1 y1] [x2 y2] [x3 y3] ...]] ... ]
    * 
    */
    public java.lang.Object _getObstacleMap() throws CallError, InterruptedException {
        return (java.lang.Object)service.call("_getObstacleMap").get();
    }

    /**
    * .
    * 
    */
    public void _enableSensorDebug(Boolean param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_enableSensorDebug", param1);
        else
            service.call("_enableSensorDebug", param1).get();
    }

    /**
    * .
    * 
    */
    public void _useHeadChecking(Boolean param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_useHeadChecking", param1);
        else
            service.call("_useHeadChecking", param1).get();
    }

    /**
    * .
    * 
    */
    public void _usePathChecking(Boolean param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_usePathChecking", param1);
        else
            service.call("_usePathChecking", param1).get();
    }

    /**
    * .
    * 
    */
    public void _enableClearMap(Boolean param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_enableClearMap", param1);
        else
            service.call("_enableClearMap", param1).get();
    }

    /**
    * .
    * 
    */
    public void _clearObstacleMap() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_clearObstacleMap");
        else
            service.call("_clearObstacleMap").get();
    }

    /**
    * .
    * 
    */
    public java.lang.Object _getSensorSubscribers() throws CallError, InterruptedException {
        return (java.lang.Object)service.call("_getSensorSubscribers").get();
    }

    /**
    * .
    * 
    */
    public java.lang.Object _getSensorList() throws CallError, InterruptedException {
        return (java.lang.Object)service.call("_getSensorList").get();
    }

    /**
    * .
    * 
    */
    public java.lang.Object _getSensorListBySubscriber(String param1) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("_getSensorListBySubscriber", param1).get();
    }

    /**
    * .
    * 
    */
    public java.lang.Object _getActiveSensorList() throws CallError, InterruptedException {
        return (java.lang.Object)service.call("_getActiveSensorList").get();
    }

    /**
    * .
    * 
    */
    public Boolean _isSensorEnabled(String param1) throws CallError, InterruptedException {
        return (Boolean)service.call("_isSensorEnabled", param1).get();
    }

    /**
    * .
    * 
    */
    public java.lang.Object _getSecureNavSensors() throws CallError, InterruptedException {
        return (java.lang.Object)service.call("_getSecureNavSensors").get();
    }

    /**
    * .
    * 
    */
    public void _enableLogger(Boolean param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_enableLogger", param1);
        else
            service.call("_enableLogger", param1).get();
    }

    /**
    * .
    * 
    */
    public void _setController(Integer param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_setController", param1);
        else
            service.call("_setController", param1).get();
    }

    /**
    * .
    * 
    */
    public void _writeTree() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_writeTree");
        else
            service.call("_writeTree").get();
    }

    /**
    * .
    * 
    * @param trajectory  An ALValue describing a trajectory.
    */
    public Boolean moveAlong(java.lang.Object trajectory) throws CallError, InterruptedException {
        return (Boolean)service.call("moveAlong", trajectory).get();
    }

    /**
    * .
    * 
    * @param moveAlongScale  a scale factor
    * @param allowMove  true if the robot should do any move at all
    * @param trajectory  An ALValue describing a trajectory.
    */
    public Boolean _moveAlong(Float moveAlongScale, Boolean allowMove, java.lang.Object trajectory) throws CallError, InterruptedException {
        return (Boolean)service.call("_moveAlong", moveAlongScale, allowMove, trajectory).get();
    }

    /**
    * .
    * 
    */
    public void _enableSafety(Boolean param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_enableSafety", param1);
        else
            service.call("_enableSafety", param1).get();
    }

    /**
    * .
    * 
    */
    public Boolean _isSafetyEnabled() throws CallError, InterruptedException {
        return (Boolean)service.call("_isSafetyEnabled").get();
    }

    /**
    * .
    * 
    */
    public Boolean _isSafetyLoopRunning() throws CallError, InterruptedException {
        return (Boolean)service.call("_isSafetyLoopRunning").get();
    }

    /**
    * .
    * 
    */
    public void _wakeUpCallBack() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_wakeUpCallBack");
        else
            service.call("_wakeUpCallBack").get();
    }

    /**
    * .
    * 
    */
    public void _restCallBack(String param1, java.lang.Object param2, String param3) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_restCallBack", param1, param2, param3);
        else
            service.call("_restCallBack", param1, param2, param3).get();
    }

    /**
    * .
    * 
    */
    public java.lang.Object _getFreeZoneCenter(Double param1) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("_getFreeZoneCenter", param1).get();
    }

    /**
    * .
    * 
    */
    public java.lang.Object _getFreeZoneWithConstraints(Float param1) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("_getFreeZoneWithConstraints", param1).get();
    }

    /**
    * .
    * 
    */
    public Integer _updateFreeZone() throws CallError, InterruptedException {
        return (Integer)service.call("_updateFreeZone").get();
    }

    /**
    *  Starts a loop to update the mapping of the free space around the robot. 
    * 
    */
    public void startFreeZoneUpdate() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("startFreeZoneUpdate");
        else
            service.call("startFreeZoneUpdate").get();
    }

    /**
    * .
    * 
    */
    public void _startFreeZoneUpdateWithTimeout(Integer param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_startFreeZoneUpdateWithTimeout", param1);
        else
            service.call("_startFreeZoneUpdateWithTimeout", param1).get();
    }

    /**
    * Stops and returns free zone.
    * 
    * @param desiredRadius  The radius of the space we want in meters [m].
    * @param maximumDisplacement  The max distance we accept to move toreach the found place [m].
    * @return Returns [errorCode, result radius (m), [worldMotionToRobotCenterX (m), worldMotionToRobotCenterY (m)]]
    */
    public java.lang.Object stopAndComputeFreeZone(Float desiredRadius, Float maximumDisplacement) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("stopAndComputeFreeZone", desiredRadius, maximumDisplacement).get();
    }

    /**
    * .
    * 
    */
    public void _writeFreeZone() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_writeFreeZone");
        else
            service.call("_writeFreeZone").get();
    }

    /**
    * .
    * 
    */
    public void _clearFreeZone() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_clearFreeZone");
        else
            service.call("_clearFreeZone").get();
    }

    /**
    * .
    * 
    */
    public java.lang.Object _getFreeZoneMap() throws CallError, InterruptedException {
        return (java.lang.Object)service.call("_getFreeZoneMap").get();
    }

    /**
    * .
    * 
    */
    public java.lang.Object _computeFreeZone(Float param1, Float param2) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("_computeFreeZone", param1, param2).get();
    }

    /**
    * Returns [errorCode, result radius[centerWorldMotionX, centerWorldMotionY]]
    * 
    * @param desiredRadius  The radius of the space we want in meters [m].
    * @param maximumDisplacement  The max distance we accept to move toreach the found place [m].
    * @return Returns [errorCode, result radius (m), [worldMotionToRobotCenterX (m), worldMotionToRobotCenterY (m)]]
    */
    public java.lang.Object findFreeZone(Float desiredRadius, Float maximumDisplacement) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("findFreeZone", desiredRadius, maximumDisplacement).get();
    }

    /**
    * .
    * 
    */
    public void _moveToFreeZoneCenter() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_moveToFreeZoneCenter");
        else
            service.call("_moveToFreeZoneCenter").get();
    }

    /**
    * .
    * 
    */
    public void _stopFreeZoneTasks() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_stopFreeZoneTasks");
        else
            service.call("_stopFreeZoneTasks").get();
    }

    /**
    * .
    * 
    */
    public void _writeDilatedMaps() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_writeDilatedMaps");
        else
            service.call("_writeDilatedMaps").get();
    }

    /**
    * .
    * 
    */
    public void _startDiagnosis(List<String> param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_startDiagnosis", param1);
        else
            service.call("_startDiagnosis", param1).get();
    }

    /**
    * .
    * 
    */
    public java.lang.Object _stopDiagnosis() throws CallError, InterruptedException {
        return (java.lang.Object)service.call("_stopDiagnosis").get();
    }

    /**
    * .
    * 
    */
    public void _passiveDiagnosisCallBack(String param1, java.lang.Object param2, String param3) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_passiveDiagnosisCallBack", param1, param2, param3);
        else
            service.call("_passiveDiagnosisCallBack", param1, param2, param3).get();
    }

    /**
    * .
    * 
    */
    public void _activeDiagnosisCallBack(String param1, java.lang.Object param2, String param3) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_activeDiagnosisCallBack", param1, param2, param3);
        else
            service.call("_activeDiagnosisCallBack", param1, param2, param3).get();
    }

    /**
    * .
    * 
    */
    public void _setObstacleModeForSafety(Integer param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_setObstacleModeForSafety", param1);
        else
            service.call("_setObstacleModeForSafety", param1).get();
    }

    /**
    * .
    * 
    */
    public void _setTimeChecking(Boolean param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_setTimeChecking", param1);
        else
            service.call("_setTimeChecking", param1).get();
    }

    /**
    * .
    * 
    */
    public void _onTouchChanged(String param1, java.lang.Object param2, String param3) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_onTouchChanged", param1, param2, param3);
        else
            service.call("_onTouchChanged", param1, param2, param3).get();
    }

    /**
    * .
    * 
    */
    public void _setSafetyMemoryTime(Integer param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_setSafetyMemoryTime", param1);
        else
            service.call("_setSafetyMemoryTime", param1).get();
    }

    /**
    * .
    * 
    */
    public Integer _getSafetyMemoryTime() throws CallError, InterruptedException {
        return (Integer)service.call("_getSafetyMemoryTime").get();
    }

    /**
    * .
    * 
    */
    public void _setPublishBlindZones(Boolean param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_setPublishBlindZones", param1);
        else
            service.call("_setPublishBlindZones", param1).get();
    }

    /**
    * .
    * 
    */
    public Boolean _getPublishBlindZones() throws CallError, InterruptedException {
        return (Boolean)service.call("_getPublishBlindZones").get();
    }

    /**
    * .
    * 
    */
    public void _setPublishCollisionObstacle(Boolean param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_setPublishCollisionObstacle", param1);
        else
            service.call("_setPublishCollisionObstacle", param1).get();
    }

    /**
    * .
    * 
    */
    public Boolean _getPublishCollisionObstacle() throws CallError, InterruptedException {
        return (Boolean)service.call("_getPublishCollisionObstacle").get();
    }

    /**
    * .
    * 
    */
    public Float _getKnownZoneOffset() throws CallError, InterruptedException {
        return (Float)service.call("_getKnownZoneOffset").get();
    }

    /**
    * .
    * 
    */
    public void _setKnownZoneOffset(Float param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_setKnownZoneOffset", param1);
        else
            service.call("_setKnownZoneOffset", param1).get();
    }

    /**
    * .
    * 
    */
    public Float _getUnknownZoneOffset() throws CallError, InterruptedException {
        return (Float)service.call("_getUnknownZoneOffset").get();
    }

    /**
    * .
    * 
    */
    public void _setUnknownZoneOffset(Float param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_setUnknownZoneOffset", param1);
        else
            service.call("_setUnknownZoneOffset", param1).get();
    }

    /**
    * .
    * 
    */
    public Float _getCollisionObstacleDistance() throws CallError, InterruptedException {
        return (Float)service.call("_getCollisionObstacleDistance").get();
    }

    /**
    * .
    * 
    */
    public void _setCollisionObstacleDistance(Float param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_setCollisionObstacleDistance", param1);
        else
            service.call("_setCollisionObstacleDistance", param1).get();
    }

    /**
    * .
    * 
    */
    public Float _getCollisionObstacleRadius() throws CallError, InterruptedException {
        return (Float)service.call("_getCollisionObstacleRadius").get();
    }

    /**
    * .
    * 
    */
    public void _setCollisionObstacleRadius(Float param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_setCollisionObstacleRadius", param1);
        else
            service.call("_setCollisionObstacleRadius", param1).get();
    }

    /**
    * .
    * 
    */
    public void _setBlindZoneMode(Integer param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_setBlindZoneMode", param1);
        else
            service.call("_setBlindZoneMode", param1).get();
    }

    /**
    * .
    * 
    */
    public Integer _getBlindZoneMode() throws CallError, InterruptedException {
        return (Integer)service.call("_getBlindZoneMode").get();
    }

    /**
    * .
    * 
    */
    public void _setUseHardwareBlindZoneSensor(Boolean param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_setUseHardwareBlindZoneSensor", param1);
        else
            service.call("_setUseHardwareBlindZoneSensor", param1).get();
    }

    /**
    * .
    * 
    */
    public Boolean _getUseHardwareBlindZoneSensor() throws CallError, InterruptedException {
        return (Boolean)service.call("_getUseHardwareBlindZoneSensor").get();
    }

    /**
    * .
    * 
    */
    public void _setBlindZoneObstacleMaxDist(Float param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_setBlindZoneObstacleMaxDist", param1);
        else
            service.call("_setBlindZoneObstacleMaxDist", param1).get();
    }

    /**
    * .
    * 
    */
    public Float _getBlindZoneObstacleMaxDist() throws CallError, InterruptedException {
        return (Float)service.call("_getBlindZoneObstacleMaxDist").get();
    }

    /**
    * .
    * 
    */
    public String _get3DMap() throws CallError, InterruptedException {
        return (String)service.call("_get3DMap").get();
    }

    /**
    * .
    * 
    */
    public void _eventMoveFailedCallback() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_eventMoveFailedCallback");
        else
            service.call("_eventMoveFailedCallback").get();
    }

    /**
    * .
    * 
    */
    public void _setFreeZoneTimeout(Integer param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_setFreeZoneTimeout", param1);
        else
            service.call("_setFreeZoneTimeout", param1).get();
    }

    /**
    * .
    * 
    */
    public void _setFreeZoneThreshold(Float param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_setFreeZoneThreshold", param1);
        else
            service.call("_setFreeZoneThreshold", param1).get();
    }

    /**
    * .
    * 
    */
    public void _setObstaclesNumber(Integer param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_setObstaclesNumber", param1);
        else
            service.call("_setObstaclesNumber", param1).get();
    }

    /**
    * .
    * 
    */
    public Integer _getObstaclesNumber() throws CallError, InterruptedException {
        return (Integer)service.call("_getObstaclesNumber").get();
    }

    /**
    * .
    * 
    */
    public void _enableTouchType(Integer param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_enableTouchType", param1);
        else
            service.call("_enableTouchType", param1).get();
    }

    /**
    * .
    * 
    */
    public void _disableTouchType(Integer param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_disableTouchType", param1);
        else
            service.call("_disableTouchType", param1).get();
    }

    /**
    * .
    * 
    */
    public List<Integer> _getEnabledTouchTypes() throws CallError, InterruptedException {
        return (List<Integer>)service.call("_getEnabledTouchTypes").get();
    }

    /**
    * .
    * 
    */
    public void _setDataTooOldThresholdMs(Integer param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_setDataTooOldThresholdMs", param1);
        else
            service.call("_setDataTooOldThresholdMs", param1).get();
    }

    /**
    * .
    * 
    */
    public Integer _getDataTooOldThresholdMs() throws CallError, InterruptedException {
        return (Integer)service.call("_getDataTooOldThresholdMs").get();
    }

}
    