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
public class ALMotion extends ALModule {

    public ALMotion(Session session) {
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
    * The robot will wake up: set Motor ON and go to initial position if needed
    * 
    */
    public void wakeUp() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("wakeUp");
        else
            service.call("wakeUp").get();
    }

    /**
    * The robot will rest: go to a relax and safe position and set Motor OFF
    * 
    */
    public void rest() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("rest");
        else
            service.call("rest").get();
    }

    /**
    * The robot will rest: go to a relax and safe position on the chain and set Motor OFF
    * 
    */
    public void rest(String param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("rest", param1);
        else
            service.call("rest", param1).get();
    }

    /**
    * The robot will rest: go to a relax and safe position on the chain and set Motor OFF
    * 
    * @param chainName  The name of the chain to rest.
    */
    public void _rest(String chainName) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_rest", chainName);
        else
            service.call("_rest", chainName).get();
    }

    /**
    * The robot will immediately unstiffness the chain.
    * 
    * @param chainName  The name of the chain to rest. Can be "LArm", "RArm", or "Arms".
    */
    public void _stopChain(String chainName) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_stopChain", chainName);
        else
            service.call("_stopChain", chainName).get();
    }

    /**
    * The robot will rest: wakeUp is not allowed anymore.
    * 
    */
    public void _shutdown() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_shutdown");
        else
            service.call("_shutdown").get();
    }

    /**
    * Returns true if the chain is going to rest or is already in rest
    * 
    * @param chainName  The chain name
    */
    public Boolean _isChainGoToOrInRest(String chainName) throws CallError, InterruptedException {
        return (Boolean)service.call("_isChainGoToOrInRest", chainName).get();
    }

    /**
    * Set the reference posture for fallmanager, stand init, idle posture, breath, etc.
    * 
    * @param postureName  The posture name
    * @param bodyAngles  The body angles. Use getBodyNames api with parameter JointActuators.
    * @return Success to set the desired motion posture.
    */
    public Boolean _setMotionPosture(String postureName, List<Float> bodyAngles) throws CallError, InterruptedException {
        return (Boolean)service.call("_setMotionPosture", postureName, bodyAngles).get();
    }

    /**
    * 
    * 
    * @param postureName  The posture name
    * @return Use getBodyNames api with parameter JointActuators.
    */
    public List<Float> _getMotionPosture(String postureName) throws CallError, InterruptedException {
        return (List<Float>)service.call("_getMotionPosture", postureName).get();
    }

    /**
    * 
    * 
    * @return All the postures in motion posture library
    */
    public List<String> _getMotionPostureList() throws CallError, InterruptedException {
        return (List<String>)service.call("_getMotionPostureList").get();
    }

    /**
    * return true if the robot is already wakeUp
    * 
    * @return True if the robot is already wakeUp.
    */
    public Boolean robotIsWakeUp() throws CallError, InterruptedException {
        return (Boolean)service.call("robotIsWakeUp").get();
    }

    /**
    * Interpolates one or multiple joints to a target stiffness or along timed trajectories of stiffness. This is a blocking call.
    * 
    * @param names  Name or names of joints, chains, "Body", "JointActuators", "Joints" or "Actuators".
    * @param stiffnessLists  An stiffness, list of stiffnesses or list of list of stiffnesses
    * @param timeLists  A time, list of times or list of list of times.
    */
    public void stiffnessInterpolation(java.lang.Object names, java.lang.Object stiffnessLists, java.lang.Object timeLists) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("stiffnessInterpolation", names, stiffnessLists, timeLists);
        else
            service.call("stiffnessInterpolation", names, stiffnessLists, timeLists).get();
    }

    /**
    * Sets the stiffness of one or more joints. This is a non-blocking call.
    * 
    * @param names  Names of joints, chains, "Body", "JointActuators", "Joints" or "Actuators".
    * @param stiffnesses  One or more stiffnesses between zero and one.
    */
    public void setStiffnesses(java.lang.Object names, java.lang.Object stiffnesses) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setStiffnesses", names, stiffnesses);
        else
            service.call("setStiffnesses", names, stiffnesses).get();
    }

    /**
    * Sets the stiffness of one or more joints. This is a non-blocking call.
    * 
    * @param names  Names of joints, chains, "Body", "JointActuators", "Joints" or "Actuators".
    * @param stiffnesses  One or more stiffnesses between zero and one.
    */
    public void _setStiffnesses(java.lang.Object names, java.lang.Object stiffnesses) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_setStiffnesses", names, stiffnesses);
        else
            service.call("_setStiffnesses", names, stiffnesses).get();
    }

    /**
    * Gets stiffness of a joint or group of joints
    * 
    * @param jointName  Name of the joints, chains, "Body", "Joints" or "Actuators".
    * @return One or more stiffnesses. 1.0 indicates maximum stiffness. 0.0 indicated minimum stiffness
    */
    public List<Float> getStiffnesses(java.lang.Object jointName) throws CallError, InterruptedException {
        return (List<Float>)service.call("getStiffnesses", jointName).get();
    }

    /**
    * Interpolates one or multiple joints to a target angle or along timed trajectories. This is a blocking call.
    * 
    * @param names  Name or names of joints, chains, "Body", "JointActuators", "Joints" or "Actuators". 
    * @param angleLists  An angle, list of angles or list of list of angles in radians
    * @param timeLists  A time, list of times or list of list of times in seconds
    * @param isAbsolute  If true, the movement is described in absolute angles, else the angles are relative to the current angle.
    */
    public void angleInterpolation(java.lang.Object names, java.lang.Object angleLists, java.lang.Object timeLists, Boolean isAbsolute) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("angleInterpolation", names, angleLists, timeLists, isAbsolute);
        else
            service.call("angleInterpolation", names, angleLists, timeLists, isAbsolute).get();
    }

    /**
    * Interpolates one or multiple joints to a target angle, using a fraction of max speed. Only one target angle is allowed for each joint. This is a blocking call.
    * 
    * @param names  Name or names of joints, chains, "Body", "JointActuators", "Joints" or "Actuators".
    * @param targetAngles  An angle, or list of angles in radians
    * @param maxSpeedFraction  A fraction.
    */
    public void angleInterpolationWithSpeed(java.lang.Object names, java.lang.Object targetAngles, Float maxSpeedFraction) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("angleInterpolationWithSpeed", names, targetAngles, maxSpeedFraction);
        else
            service.call("angleInterpolationWithSpeed", names, targetAngles, maxSpeedFraction).get();
    }

    /**
    * Interpolates a sequence of timed angles for several motors using bezier control points. This is a blocking call.
    * 
    * @param jointNames  A vector of joint names
    * @param times  An ragged ALValue matrix of floats. Each line corresponding to a motor, and column element to a control point.
    * @param controlPoints  An ALValue array of arrays each containing [float angle, Handle1, Handle2], where Handle is [int InterpolationType, float dAngle, float dTime] descibing the handle offsets relative to the angle and time of the point. The first bezier param describes the handle that controls the curve preceeding the point, the second describes the curve following the point.
    */
    public void angleInterpolationBezier(List<String> jointNames, java.lang.Object times, java.lang.Object controlPoints) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("angleInterpolationBezier", jointNames, times, controlPoints);
        else
            service.call("angleInterpolationBezier", jointNames, times, controlPoints).get();
    }

    /**
    * Interpolates a sequence of timed angles for several motors using bezier control points. This is a blocking call.
    * 
    * @param jointNames  A vector of joint names
    * @param times  An ragged ALValue matrix of floats. Each line corresponding to a motor, and column element to a control point.
    * @param controlPoints  An ALValue array of arrays each containing [float angle, Handle1, Handle2], where Handle is [int InterpolationType, float dAngle, float dTime] descibing the handle offsets relative to the angle and time of the point. The first bezier param describes the handle that controls the curve preceeding the point, the second describes the curve following the point.
    * @param isAbsolute  A bool or a vector of bool. If true, the movement is described in absolute angles, else the angles are relative to the current angle.
    * @param supportSequence  An alvalue containing a list of [nameEffector, timeList, isActiveList].
    */
    public void animation(List<String> jointNames, java.lang.Object times, java.lang.Object controlPoints, java.lang.Object isAbsolute, java.lang.Object supportSequence) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("animation", jointNames, times, controlPoints, isAbsolute, supportSequence);
        else
            service.call("animation", jointNames, times, controlPoints, isAbsolute, supportSequence).get();
    }

    /**
    * Sets angles. This is a non-blocking call.
    * 
    * @param names  The name or names of joints, chains, "Body", "JointActuators", "Joints" or "Actuators". 
    * @param angles  One or more angles in radians
    * @param fractionMaxSpeed  The fraction of maximum speed to use
    */
    public void setAngles(java.lang.Object names, java.lang.Object angles, Float fractionMaxSpeed) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setAngles", names, angles, fractionMaxSpeed);
        else
            service.call("setAngles", names, angles, fractionMaxSpeed).get();
    }

    /**
    * Sets angles. This is a non-blocking call.
    * 
    * @param names  The name or names of joints, chains, "Body", "JointActuators", "Joints" or "Actuators". 
    * @param angles  One or more angles in radians
    * @param fractionMaxSpeeds  The vector of fraction of maximum speed to use
    */
    public void setAngles(java.lang.Object names, java.lang.Object angles, List<Float> fractionMaxSpeeds) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setAngles", names, angles, fractionMaxSpeeds);
        else
            service.call("setAngles", names, angles, fractionMaxSpeeds).get();
    }

    /**
    * Changes Angles. This is a non-blocking call.
    * 
    * @param names  The name or names of joints, chains, "Body", "JointActuators", "Joints" or "Actuators".
    * @param changes  One or more changes in radians
    * @param fractionMaxSpeed  The fraction of maximum speed to use
    */
    public void changeAngles(java.lang.Object names, java.lang.Object changes, Float fractionMaxSpeed) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("changeAngles", names, changes, fractionMaxSpeed);
        else
            service.call("changeAngles", names, changes, fractionMaxSpeed).get();
    }

    /**
    * Gets the angles of the joints
    * 
    * @param names  Names the joints, chains, "Body", "JointActuators", "Joints" or "Actuators". 
    * @param useSensors  If true, sensor angles will be returned
    * @return Joint angles in radians.
    */
    public List<Float> getAngles(java.lang.Object names, Boolean useSensors) throws CallError, InterruptedException {
        return (List<Float>)service.call("getAngles", names, useSensors).get();
    }

    /**
    * NAO stiffens the motors of desired hand. Then, he opens the hand, then cuts motor current to conserve energy. This is a blocking call.
    * 
    * @param handName  The name of the hand. Could be: "RHand or "LHand"
    */
    public void openHand(String handName) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("openHand", handName);
        else
            service.call("openHand", handName).get();
    }

    /**
    * NAO stiffens the motors of desired hand. Then, he closes the hand, then cuts motor current to conserve energy. This is a blocking call.
    * 
    * @param handName  The name of the hand. Could be: "RHand" or "LHand"
    */
    public void closeHand(String handName) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("closeHand", handName);
        else
            service.call("closeHand", handName).get();
    }

    /**
    * Makes the robot move at the given velocity. This is a non-blocking call.
    * 
    * @param x  The velocity along x axis [m.s-1].
    * @param y  The velocity along y axis [m.s-1].
    * @param theta  The velocity around z axis [rd.s-1].
    */
    public void move(Float x, Float y, Float theta) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("move", x, y, theta);
        else
            service.call("move", x, y, theta).get();
    }

    /**
    * Makes the robot move at the given velocity. This is a non-blocking call.
    * 
    * @param x  The velocity along x axis [m.s-1].
    * @param y  The velocity along y axis [m.s-1].
    * @param theta  The velocity around z axis [rd.s-1].
    * @param moveConfig  An ALValue with custom move configuration.
    */
    public void move(Float x, Float y, Float theta, java.lang.Object moveConfig) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("move", x, y, theta, moveConfig);
        else
            service.call("move", x, y, theta, moveConfig).get();
    }

    /**
    * Makes the robot move at the given normalized velocity. This is a non-blocking call.
    * 
    * @param x  The normalized velocity along x axis (between -1 and 1).
    * @param y  The normalized velocity along y axis (between -1 and 1).
    * @param theta  The normalized velocity around z axis (between -1 and 1).
    */
    public void moveToward(Float x, Float y, Float theta) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("moveToward", x, y, theta);
        else
            service.call("moveToward", x, y, theta).get();
    }

    /**
    * Makes the robot move at the given normalized velocity. This is a non-blocking call.
    * 
    * @param x  The normalized velocity along x axis (between -1 and 1).
    * @param y  The normalized velocity along y axis (between -1 and 1).
    * @param theta  The normalized velocity around z axis (between -1 and 1).
    * @param moveConfig  An ALValue with custom move configuration.
    */
    public void moveToward(Float x, Float y, Float theta, java.lang.Object moveConfig) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("moveToward", x, y, theta, moveConfig);
        else
            service.call("moveToward", x, y, theta, moveConfig).get();
    }

    /**
    * DEPRECATED. Use moveToward() function instead.
    * 
    * @param x  Fraction of MaxStepX. Use negative for backwards. [-1.0 to 1.0]
    * @param y  Fraction of MaxStepY. Use negative for right. [-1.0 to 1.0]
    * @param theta  Fraction of MaxStepTheta. Use negative for clockwise [-1.0 to 1.0]
    * @param frequency  Fraction of MaxStepFrequency [0.0 to 1.0]
    */
    public void setWalkTargetVelocity(Float x, Float y, Float theta, Float frequency) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setWalkTargetVelocity", x, y, theta, frequency);
        else
            service.call("setWalkTargetVelocity", x, y, theta, frequency).get();
    }

    /**
    * DEPRECATED. Use moveToward() function instead.
    * 
    * @param x  Fraction of MaxStepX. Use negative for backwards. [-1.0 to 1.0]
    * @param y  Fraction of MaxStepY. Use negative for right. [-1.0 to 1.0]
    * @param theta  Fraction of MaxStepTheta. Use negative for clockwise [-1.0 to 1.0]
    * @param frequency  Fraction of MaxStepFrequency [0.0 to 1.0]
    * @param feetGaitConfig  An ALValue with the custom gait configuration for both feet
    */
    public void setWalkTargetVelocity(Float x, Float y, Float theta, Float frequency, java.lang.Object feetGaitConfig) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setWalkTargetVelocity", x, y, theta, frequency, feetGaitConfig);
        else
            service.call("setWalkTargetVelocity", x, y, theta, frequency, feetGaitConfig).get();
    }

    /**
    * DEPRECATED. Use moveToward() function instead.
    * 
    * @param x  Fraction of MaxStepX. Use negative for backwards. [-1.0 to 1.0]
    * @param y  Fraction of MaxStepY. Use negative for right. [-1.0 to 1.0]
    * @param theta  Fraction of MaxStepTheta. Use negative for clockwise [-1.0 to 1.0]
    * @param frequency  Fraction of MaxStepFrequency [0.0 to 1.0]
    * @param leftFootMoveConfig  An ALValue with custom move configuration for the left foot
    * @param rightFootMoveConfig  An ALValue with custom move configuration for the right foot
    */
    public void setWalkTargetVelocity(Float x, Float y, Float theta, Float frequency, java.lang.Object leftFootMoveConfig, java.lang.Object rightFootMoveConfig) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setWalkTargetVelocity", x, y, theta, frequency, leftFootMoveConfig, rightFootMoveConfig);
        else
            service.call("setWalkTargetVelocity", x, y, theta, frequency, leftFootMoveConfig, rightFootMoveConfig).get();
    }

    /**
    * Makes Nao walk at the given velocity using a MPC walking generator.This is a non-blocking call.
    * 
    * @param x  Fraction of MaxStepX. Use negative for backwards. [-1.0 to 1.0]
    * @param y  Fraction of MaxStepY. Use negative for right. [-1.0 to 1.0]
    * @param theta  Fraction of MaxStepTheta. Use negative for clockwise [-1.0 to 1.0]
    * @param frequency  Fraction of MaxStepFrequency [0.0 to 1.0]
    */
    public void _setMpcWalkTargetVelocity(Float x, Float y, Float theta, Float frequency) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_setMpcWalkTargetVelocity", x, y, theta, frequency);
        else
            service.call("_setMpcWalkTargetVelocity", x, y, theta, frequency).get();
    }

    /**
    * Makes the robot move at the given position. This is a non-blocking call.
    * 
    * @param x  The position along x axis [m].
    * @param y  The position along y axis [m].
    * @param theta  The position around z axis [rd].
    */
    public void moveTo(Float x, Float y, Float theta) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("moveTo", x, y, theta);
        else
            service.call("moveTo", x, y, theta).get();
    }

    /**
    * Makes the robot move at the given position in fixed time. This is a non-blocking call.
    * 
    * @param x  The position along x axis [m].
    * @param y  The position along y axis [m].
    * @param theta  The position around z axis [rd].
    * @param time  The time to reach the target position [s].
    */
    public void moveTo(Float x, Float y, Float theta, Float time) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("moveTo", x, y, theta, time);
        else
            service.call("moveTo", x, y, theta, time).get();
    }

    /**
    * Makes the robot move at the given position. This is a non-blocking call.
    * 
    * @param x  The position along x axis [m].
    * @param y  The position along y axis [m].
    * @param theta  The position around z axis [rd].
    * @param moveConfig  An ALValue with custom move configuration.
    */
    public void moveTo(Float x, Float y, Float theta, java.lang.Object moveConfig) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("moveTo", x, y, theta, moveConfig);
        else
            service.call("moveTo", x, y, theta, moveConfig).get();
    }

    /**
    * Makes the robot move at the given position in fixed time. This is a non-blocking call.
    * 
    * @param x  The position along x axis [m].
    * @param y  The position along y axis [m].
    * @param theta  The position around z axis [rd].
    * @param time  The time to reach the target position [s].
    * @param moveConfig  An ALValue with custom move configuration.
    */
    public void moveTo(Float x, Float y, Float theta, Float time, java.lang.Object moveConfig) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("moveTo", x, y, theta, time, moveConfig);
        else
            service.call("moveTo", x, y, theta, time, moveConfig).get();
    }

    /**
    * Makes the robot move to the given relative positions. This is a blocking call.
    * 
    * @param controlPoint  An ALValue with the control points in FRAME_ROBOT.
Each control point is relative to the previous one. [[x1, y1, theta1], ..., [xN, yN, thetaN]
    */
    public void moveTo(java.lang.Object controlPoint) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("moveTo", controlPoint);
        else
            service.call("moveTo", controlPoint).get();
    }

    /**
    * Makes the robot move to the given relative positions. This is a blocking call.
    * 
    * @param controlPoint  An ALValue with all the control points in FRAME_ROBOT.
Each control point is relative to the previous one. [[x1, y1, theta1], ..., [xN, yN, thetaN]
    * @param moveConfig  An ALValue with custom move configuration.
    */
    public void moveTo(java.lang.Object controlPoint, java.lang.Object moveConfig) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("moveTo", controlPoint, moveConfig);
        else
            service.call("moveTo", controlPoint, moveConfig).get();
    }

    /**
    * Makes the robot move at the given position, without taking into account ENABLE_MOVE_PROTECTION config
    * 
    * @param x  The position along x axis [m].
    * @param y  The position along y axis [m].
    * @param theta  The position around z axis [rd].
    */
    public void _moveToPod(Float x, Float y, Float theta) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_moveToPod", x, y, theta);
        else
            service.call("_moveToPod", x, y, theta).get();
    }

    /**
    * Makes the robot move at the given position, without taking into account ENABLE_MOVE_PROTECTION config
    * 
    * @param x  The position along x axis [m].
    * @param y  The position along y axis [m].
    * @param theta  The position around z axis [rd].
    * @param moveConfig  An ALValue with custom move configuration.
    */
    public void _moveToPod(Float x, Float y, Float theta, java.lang.Object moveConfig) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_moveToPod", x, y, theta, moveConfig);
        else
            service.call("_moveToPod", x, y, theta, moveConfig).get();
    }

    /**
    * Makes the robot follow a given path. This is a non-blocking call.
    * 
    * @param path  An ALValue describing a 2D path.
    * @param moveConfig  An ALValue with custom move configuration.
    */
    public void _followPath(java.lang.Object path, java.lang.Object moveConfig) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_followPath", path, moveConfig);
        else
            service.call("_followPath", path, moveConfig).get();
    }

    /**
    * Makes the robot follow a given path. This is a non-blocking call.
    * 
    * @param path  An ALValue describing a 2D path.
    */
    public void _followPath(java.lang.Object path) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_followPath", path);
        else
            service.call("_followPath", path).get();
    }

    /**
    * Makes the robot follow a given path, in world frame. This is a non-blocking call.
    * 
    * @param poseStart  A Pose2D setting the start frame of the path, in World.
    * @param path  An ALValue describing a 2D Path.
    * @param moveConfig  An ALValue with custom move configuration.
    */
    public void _followPathInWorld(java.lang.Object poseStart, java.lang.Object path, java.lang.Object moveConfig) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_followPathInWorld", poseStart, path, moveConfig);
        else
            service.call("_followPathInWorld", poseStart, path, moveConfig).get();
    }

    /**
    * Makes the robot follow a given path, in world frame. This is a non-blocking call.
    * 
    * @param poseStart  A Pose2D setting the start frame of the path, in World.
    * @param path  An ALValue describing a 2D Path.
    */
    public void _followPathInWorld(java.lang.Object poseStart, java.lang.Object path) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_followPathInWorld", poseStart, path);
        else
            service.call("_followPathInWorld", poseStart, path).get();
    }

    /**
    * Changes the reference speed for trajectory following
    * 
    * @param speedFactor  Between 0 and 1, relative to max speed
    */
    public void _setFollowPathSpeedFactor(Float speedFactor) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_setFollowPathSpeedFactor", speedFactor);
        else
            service.call("_setFollowPathSpeedFactor", speedFactor).get();
    }

    /**
    * Move along a trajectory
    * 
    * @param trajectory  An ALValue describing a trajectory.
    * @return The id of the trajectory that was started, as an int
    */
    public Integer _moveAlong(java.lang.Object trajectory) throws CallError, InterruptedException {
        return (Integer)service.call("_moveAlong", trajectory).get();
    }

    /**
    * Move along a trajectory
    * 
    * @param trajectory  An ALValue describing a trajectory.
    * @param scaleFactor  A float between 0 and 1 scaling the trajectory.
    * @return The id of the trajectory that was started, as an int
    */
    public Integer _moveAlong(java.lang.Object trajectory, Float scaleFactor) throws CallError, InterruptedException {
        return (Integer)service.call("_moveAlong", trajectory, scaleFactor).get();
    }

    /**
    * Get the id of the current trajectory, if any
    * 
    */
    public Integer _getTrajectoryId() throws CallError, InterruptedException {
        return (Integer)service.call("_getTrajectoryId").get();
    }

    /**
    * Stop current trajectory, then resync
    * 
    */
    public void _stopAndStitchMoveAlong() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_stopAndStitchMoveAlong");
        else
            service.call("_stopAndStitchMoveAlong").get();
    }

    /**
    * Get a vector of samples along the current path
    * 
    * @param sampleStep  Distance between two samples, in m
    * @return vector of samples along trajectory
    */
    public java.lang.Object _getRemainingPath(Float sampleStep) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("_getRemainingPath", sampleStep).get();
    }

    /**
    * Get a vector of samples along the current trajectory
    * 
    * @param timeStep  Time between two samples, in s
    * @param preview  Duration of the preview, in s
    * @return vector of samples along trajectory
    */
    public java.lang.Object _getRemainingTrajectory(Float timeStep, Float preview) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("_getRemainingTrajectory", timeStep, preview).get();
    }

    /**
    * Get the ratio of executed trajectory, between 0 and 1
    * 
    * @return float between 0 and 1
    */
    public Float _getTrajectoryCompletion() throws CallError, InterruptedException {
        return (Float)service.call("_getTrajectoryCompletion").get();
    }

    /**
    * DEPRECATED. Use moveTo() function instead.
    * 
    * @param x  Distance along the X axis in meters.
    * @param y  Distance along the Y axis in meters.
    * @param theta  Rotation around the Z axis in radians [-3.1415 to 3.1415].
    */
    public void walkTo(Float x, Float y, Float theta) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("walkTo", x, y, theta);
        else
            service.call("walkTo", x, y, theta).get();
    }

    /**
    * DEPRECATED. Use moveTo() function instead.
    * 
    * @param x  Distance along the X axis in meters.
    * @param y  Distance along the Y axis in meters.
    * @param theta  Rotation around the Z axis in radians [-3.1415 to 3.1415].
    * @param feetGaitConfig  An ALValue with the custom gait configuration for both feet.
    */
    public void walkTo(Float x, Float y, Float theta, java.lang.Object feetGaitConfig) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("walkTo", x, y, theta, feetGaitConfig);
        else
            service.call("walkTo", x, y, theta, feetGaitConfig).get();
    }

    /**
    * DEPRECATED. Use moveTo() function instead.
    * 
    * @param controlPoint  An ALValue with all the control point in NAO SPACE[[x1,y1,theta1], ..., [xN,yN,thetaN]
    */
    public void walkTo(java.lang.Object controlPoint) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("walkTo", controlPoint);
        else
            service.call("walkTo", controlPoint).get();
    }

    /**
    * DEPRECATED. Use moveTo() function instead.
    * 
    * @param controlPoint  An ALValue with all the control point in NAO SPACE[[x1,y1,theta1], ..., [xN,yN,thetaN]
    * @param feetGaitConfig  An ALValue with the custom gait configuration for both feet
    */
    public void walkTo(java.lang.Object controlPoint, java.lang.Object feetGaitConfig) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("walkTo", controlPoint, feetGaitConfig);
        else
            service.call("walkTo", controlPoint, feetGaitConfig).get();
    }

    /**
    * Makes Nao do foot step planner. This is a non-blocking call.
    * 
    * @param legName  name of the leg to move('LLeg'or 'RLeg')
    * @param footSteps  [x, y, theta], [Position along X/Y, Orientation round Z axis] of the leg relative to the other Leg in [meters, meters, radians]. Must be less than [MaxStepX, MaxStepY, MaxStepTheta]
    * @param timeList  time list of each foot step
    * @param clearExisting  Clear existing foot steps.
    */
    public void setFootSteps(List<String> legName, java.lang.Object footSteps, List<Float> timeList, Boolean clearExisting) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setFootSteps", legName, footSteps, timeList, clearExisting);
        else
            service.call("setFootSteps", legName, footSteps, timeList, clearExisting).get();
    }

    /**
    * Makes Nao do foot step planner with speed. This is a blocking call.
    * 
    * @param legName  name of the leg to move('LLeg'or 'RLeg')
    * @param footSteps  [x, y, theta], [Position along X/Y, Orientation round Z axis] of the leg relative to the other Leg in [meters, meters, radians]. Must be less than [MaxStepX, MaxStepY, MaxStepTheta]
    * @param fractionMaxSpeed  speed of each foot step. Must be between 0 and 1.
    * @param clearExisting  Clear existing foot steps.
    */
    public void setFootStepsWithSpeed(List<String> legName, java.lang.Object footSteps, List<Float> fractionMaxSpeed, Boolean clearExisting) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setFootStepsWithSpeed", legName, footSteps, fractionMaxSpeed, clearExisting);
        else
            service.call("setFootStepsWithSpeed", legName, footSteps, fractionMaxSpeed, clearExisting).get();
    }

    /**
    * Get the foot steps. This is a non-blocking call.
    * 
    * @return Give two list of foot steps. The first one give the unchangeable foot step. The second list give the changeable foot steps. Il you use setFootSteps or setFootStepsWithSpeed with clearExisting parmater equal true, walk engine execute unchangeable foot step and remove the other.
    */
    public java.lang.Object getFootSteps() throws CallError, InterruptedException {
        return (java.lang.Object)service.call("getFootSteps").get();
    }

    /**
    * DEPRECATED. Use moveInit function instead.
    * 
    */
    public void walkInit() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("walkInit");
        else
            service.call("walkInit").get();
    }

    /**
    * Initialize the move process. Check the robot pose and take a right posture. This is blocking called.
    * 
    */
    public void moveInit() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("moveInit");
        else
            service.call("moveInit").get();
    }

    /**
    * DEPRECATED. Use waitUntilMoveIsFinished function instead.
    * 
    */
    public void waitUntilWalkIsFinished() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("waitUntilWalkIsFinished");
        else
            service.call("waitUntilWalkIsFinished").get();
    }

    /**
    * Waits until the move process is finished: This method can be used to block your script/code execution until the move task is totally finished.
    * 
    */
    public void waitUntilMoveIsFinished() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("waitUntilMoveIsFinished");
        else
            service.call("waitUntilMoveIsFinished").get();
    }

    /**
    * DEPRECATED. Use moveIsActive function instead.
    * 
    */
    public Boolean walkIsActive() throws CallError, InterruptedException {
        return (Boolean)service.call("walkIsActive").get();
    }

    /**
    * Check if the move process is actif.
    * 
    * @return True if move is active
    */
    public Boolean moveIsActive() throws CallError, InterruptedException {
        return (Boolean)service.call("moveIsActive").get();
    }

    /**
    * DEPRECATED. Use stopMove function instead.
    * 
    */
    public void stopWalk() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("stopWalk");
        else
            service.call("stopWalk").get();
    }

    /**
    * Stop Move task safely as fast as possible. The move task is ended less brutally than killMove but more quickly than move(0.0, 0.0, 0.0).
This is a blocking call.
    * 
    */
    public void stopMove() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("stopMove");
        else
            service.call("stopMove").get();
    }

    /**
    * DEPRECATED. Use getMoveConfig function instead.
Gets the foot Gait config ("MaxStepX", "MaxStepY", "MaxStepTheta",  "MaxStepFrequency", "StepHeight", "TorsoWx", "TorsoWy") 
    * 
    * @param config  a string should be "Max", "Min", "Default"
    * @return An ALvalue with the following form :[["MaxStepX", value],
 ["MaxStepY", value],
 ["MaxStepTheta", value],
 ["MaxStepFrequency", value],
 ["StepHeight", value],
 ["TorsoWx", value],
 ["TorsoWy", value]]

    */
    public java.lang.Object getFootGaitConfig(String config) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("getFootGaitConfig", config).get();
    }

    /**
    * Gets the move config.
    * 
    * @param config  a string should be "Max", "Min", "Default"
    * @return An ALvalue with the move config
    */
    public java.lang.Object getMoveConfig(String config) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("getMoveConfig", config).get();
    }

    /**
    * Gets the World Absolute Robot Position.
    * 
    * @param useSensors  If true, use the sensor values
    * @return A vector containing the World Absolute Robot Position. (Absolute Position X, Absolute Position Y, Absolute Angle Z)
    */
    public List<Float> getRobotPosition(Boolean useSensors) throws CallError, InterruptedException {
        return (List<Float>)service.call("getRobotPosition", useSensors).get();
    }

    /**
    * Gets the World Absolute next Robot Position.
In fact in the walk algorithm some foot futur foot step are incompressible due to preview control, so this function give the next robot position which is incompressible.
If the robot doesn't walk this function is equivalent to getRobotPosition(false)

    * 
    * @return A vector containing the World Absolute next Robot position.(Absolute Position X, Absolute Position Y, Absolute Angle Z)
    */
    public List<Float> getNextRobotPosition() throws CallError, InterruptedException {
        return (List<Float>)service.call("getNextRobotPosition").get();
    }

    /**
    * Get the relative position of the robot if stop move is called now.
    * 
    * @return A vector containing the Relative Position. (Position X, Position Y, Angle Z)
    */
    public List<Float> _getStopMovePosition() throws CallError, InterruptedException {
        return (List<Float>)service.call("_getStopMovePosition").get();
    }

    /**
    * Gets the World Absolute Robot Velocity.
    * 
    * @return A vector containing the World Absolute Robot Velocity. (Absolute Velocity Translation X [m.s-1], Absolute Velocity Translation Y[m.s-1], Absolute Velocity Rotation WZ [rd.s-1])
    */
    public List<Float> getRobotVelocity() throws CallError, InterruptedException {
        return (List<Float>)service.call("getRobotVelocity").get();
    }

    /**
    * Get the absolute cumulated displacement since robot is up, in robot frame.
    * 
    * @return A vector containing the absolute cumulated displacement, in robot frame. (Absolute Displacement X [m], Absolute Displacement Y[m], Absolute Displacement Theta [rd])
    */
    public List<Float> _getCumulatedDisplacement() throws CallError, InterruptedException {
        return (List<Float>)service.call("_getCumulatedDisplacement").get();
    }

    /**
    * DEPRECATED. Gets if Arms Motions are enabled during the Walk Process.
    * 
    * @return True Arm Motions are controlled by the Walk Task.
    */
    public java.lang.Object getWalkArmsEnabled() throws CallError, InterruptedException {
        return (java.lang.Object)service.call("getWalkArmsEnabled").get();
    }

    /**
    * DEPRECATED. Sets if Arms Motions are enabled during the Walk Process.
    * 
    * @param leftArmEnabled  if true Left Arm motions are controlled by the Walk Task
    * @param rightArmEnabled  if true Right Arm mMotions are controlled by the Walk Task
    */
    public void setWalkArmsEnabled(Boolean leftArmEnabled, Boolean rightArmEnabled) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setWalkArmsEnabled", leftArmEnabled, rightArmEnabled);
        else
            service.call("setWalkArmsEnabled", leftArmEnabled, rightArmEnabled).get();
    }

    /**
    * Gets if Arms Motions are enabled during the Move Process.
    * 
    * @param chainName  Name of the chain. Could be: "LArm", "RArm" or "Arms"
    * @return For LArm and RArm true if the corresponding arm is enabled. For Arms, true if both are enabled. False otherwise.
    */
    public Boolean getMoveArmsEnabled(String chainName) throws CallError, InterruptedException {
        return (Boolean)service.call("getMoveArmsEnabled", chainName).get();
    }

    /**
    * Sets if Arms Motions are enabled during the Move Process.
    * 
    * @param leftArmEnabled  if true Left Arm motions are controlled by the Move Task
    * @param rightArmEnabled  if true Right Arm mMotions are controlled by the Move Task
    */
    public void setMoveArmsEnabled(Boolean leftArmEnabled, Boolean rightArmEnabled) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setMoveArmsEnabled", leftArmEnabled, rightArmEnabled);
        else
            service.call("setMoveArmsEnabled", leftArmEnabled, rightArmEnabled).get();
    }

    /**
    * DEPRECATED. Use positionInterpolations function instead.
    * 
    * @param chainName  Name of the chain. Could be: "Head", "LArm", "RArm", "LLeg", "RLeg", "Torso" 
    * @param space  Task frame {FRAME_TORSO = 0, FRAME_WORLD = 1, FRAME_ROBOT = 2}.
    * @param path  Vector of 6D position arrays (x,y,z,wx,wy,wz) in meters and radians
    * @param axisMask  Axis mask. True for axes that you wish to control. e.g. 7 for position only, 56 for rotation only and 63 for both 
    * @param durations  Vector of times in seconds corresponding to the path points
    * @param isAbsolute  If true, the movement is absolute else relative
    */
    public void positionInterpolation(String chainName, Integer space, java.lang.Object path, Integer axisMask, java.lang.Object durations, Boolean isAbsolute) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("positionInterpolation", chainName, space, path, axisMask, durations, isAbsolute);
        else
            service.call("positionInterpolation", chainName, space, path, axisMask, durations, isAbsolute).get();
    }

    /**
    * DEPRECATED. Use the other positionInterpolations function instead.
    * 
    * @param effectorNames  Vector of chain names. Could be: "Head", "LArm", "RArm", "LLeg", "RLeg", "Torso" 
    * @param taskSpaceForAllPaths  Task frame {FRAME_TORSO = 0, FRAME_WORLD = 1, FRAME_ROBOT = 2}.
    * @param paths  Vector of 6D position arrays (x,y,z,wx,wy,wz) in meters and radians
    * @param axisMasks  Vector of Axis Masks. True for axes that you wish to control. e.g. 7 for position only, 56 for rotation only and 63 for both 
    * @param relativeTimes  Vector of times in seconds corresponding to the path points
    * @param isAbsolute  If true, the movement is absolute else relative
    */
    public void positionInterpolations(List<String> effectorNames, Integer taskSpaceForAllPaths, java.lang.Object paths, java.lang.Object axisMasks, java.lang.Object relativeTimes, Boolean isAbsolute) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("positionInterpolations", effectorNames, taskSpaceForAllPaths, paths, axisMasks, relativeTimes, isAbsolute);
        else
            service.call("positionInterpolations", effectorNames, taskSpaceForAllPaths, paths, axisMasks, relativeTimes, isAbsolute).get();
    }

    /**
    * Moves end-effectors to the given positions and orientations over time. This is a blocking call.
    * 
    * @param effectorNames  Vector of chain names. Could be: "Head", "LArm", "RArm", "LLeg", "RLeg", "Torso" 
    * @param taskSpaceForAllPaths  Task frame {FRAME_TORSO = 0, FRAME_WORLD = 1, FRAME_ROBOT = 2}.
    * @param paths  Vector of 6D position arrays (x,y,z,wx,wy,wz) in meters and radians
    * @param axisMasks  Vector of Axis Masks. True for axes that you wish to control. e.g. 7 for position only, 56 for rotation only and 63 for both 
    * @param relativeTimes  Vector of times in seconds corresponding to the path points
    */
    public void positionInterpolations(java.lang.Object effectorNames, java.lang.Object taskSpaceForAllPaths, java.lang.Object paths, java.lang.Object axisMasks, java.lang.Object relativeTimes) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("positionInterpolations", effectorNames, taskSpaceForAllPaths, paths, axisMasks, relativeTimes);
        else
            service.call("positionInterpolations", effectorNames, taskSpaceForAllPaths, paths, axisMasks, relativeTimes).get();
    }

    /**
    * Moves an end-effector to DEPRECATED. Use setPositions function instead.
    * 
    * @param chainName  Name of the chain. Could be: "Head", "LArm","RArm", "LLeg", "RLeg", "Torso"
    * @param space  Task frame {FRAME_TORSO = 0, FRAME_WORLD = 1, FRAME_ROBOT = 2}.
    * @param position  6D position array (x,y,z,wx,wy,wz) in meters and radians
    * @param fractionMaxSpeed  The fraction of maximum speed to use
    * @param axisMask  Axis mask. True for axes that you wish to control. e.g. 7 for position only, 56 for rotation only and 63 for both 
    */
    public void setPosition(String chainName, Integer space, List<Float> position, Float fractionMaxSpeed, Integer axisMask) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setPosition", chainName, space, position, fractionMaxSpeed, axisMask);
        else
            service.call("setPosition", chainName, space, position, fractionMaxSpeed, axisMask).get();
    }

    /**
    * Moves multiple end-effectors to the given position and orientation position6d. This is a non-blocking call.
    * 
    * @param names  The name or names of effector.
    * @param spaces  The task frame or task frames {FRAME_TORSO = 0, FRAME_WORLD = 1, FRAME_ROBOT = 2}.
    * @param positions  Position6D arrays
    * @param fractionMaxSpeed  The fraction of maximum speed to use
    * @param axisMask  Axis mask. True for axes that you wish to control. e.g. 7 for position only, 56 for rotation only and 63 for both 
    */
    public void setPositions(java.lang.Object names, java.lang.Object spaces, java.lang.Object positions, Float fractionMaxSpeed, java.lang.Object axisMask) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setPositions", names, spaces, positions, fractionMaxSpeed, axisMask);
        else
            service.call("setPositions", names, spaces, positions, fractionMaxSpeed, axisMask).get();
    }

    /**
    * DEPRECATED. Use setPositions function instead.
    * 
    * @param effectorName  Name of the effector.
    * @param space  Task frame {FRAME_TORSO = 0, FRAME_WORLD = 1, FRAME_ROBOT = 2}.
    * @param positionChange  6D position change array (xd, yd, zd, wxd, wyd, wzd) in meters and radians
    * @param fractionMaxSpeed  The fraction of maximum speed to use
    * @param axisMask  Axis mask. True for axes that you wish to control. e.g. 7 for position only, 56 for rotation only and 63 for both 
    */
    public void changePosition(String effectorName, Integer space, List<Float> positionChange, Float fractionMaxSpeed, Integer axisMask) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("changePosition", effectorName, space, positionChange, fractionMaxSpeed, axisMask);
        else
            service.call("changePosition", effectorName, space, positionChange, fractionMaxSpeed, axisMask).get();
    }

    /**
    * Gets a Position relative to the FRAME. Axis definition: the x axis is positive toward Nao's front, the y from right to left and the z is vertical. The angle convention of Position6D is Rot_z(wz).Rot_y(wy).Rot_x(wx).
    * 
    * @param name  Name of the item. Could be: Head, LArm, RArm, LLeg, RLeg, Torso, CameraTop, CameraBottom, MicroFront, MicroRear, MicroLeft, MicroRight, Accelerometer, Gyrometer, Laser, LFsrFR, LFsrFL, LFsrRR, LFsrRL, RFsrFR, RFsrFL, RFsrRR, RFsrRL, USSensor1, USSensor2, USSensor3, USSensor4. Use getSensorNames for the list of sensors supported on your robot.
    * @param space  Task frame {FRAME_TORSO = 0, FRAME_WORLD = 1, FRAME_ROBOT = 2}.
    * @param useSensorValues  If true, the sensor values will be used to determine the position.
    * @return Vector containing the Position6D using meters and radians (x, y, z, wx, wy, wz)
    */
    public List<Float> getPosition(String name, Integer space, Boolean useSensorValues) throws CallError, InterruptedException {
        return (List<Float>)service.call("getPosition", name, space, useSensorValues).get();
    }

    /**
    * DEPRECATED. Use the other transformInterpolations function instead.
    * 
    * @param chainName  Name of the chain. Could be: "Head", "LArm","RArm", "LLeg", "RLeg", "Torso"
    * @param space  Task frame {FRAME_TORSO = 0, FRAME_WORLD = 1, FRAME_ROBOT = 2}.
    * @param path  Vector of Transform arrays
    * @param axisMask  Axis mask. True for axes that you wish to control. e.g. 7 for position only, 56 for rotation only and 63 for both 
    * @param duration  Vector of times in seconds corresponding to the path points
    * @param isAbsolute  If true, the movement is absolute else relative
    */
    public void transformInterpolation(String chainName, Integer space, java.lang.Object path, Integer axisMask, java.lang.Object duration, Boolean isAbsolute) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("transformInterpolation", chainName, space, path, axisMask, duration, isAbsolute);
        else
            service.call("transformInterpolation", chainName, space, path, axisMask, duration, isAbsolute).get();
    }

    /**
    * DEPRECATED. Use the other transformInterpolations function instead.
    * 
    * @param effectorNames  Vector of chain names. Could be: "Head", "LArm", "RArm", "LLeg", "RLeg", "Torso" 
    * @param taskSpaceForAllPaths  Task frame {FRAME_TORSO = 0, FRAME_WORLD = 1, FRAME_ROBOT = 2}.
    * @param paths  Vector of transforms arrays.
    * @param axisMasks  Vector of Axis Masks. True for axes that you wish to control. e.g. 7 for position only, 56 for rotation only and 63 for both 
    * @param relativeTimes  Vector of times in seconds corresponding to the path points
    * @param isAbsolute  If true, the movement is absolute else relative
    */
    public void transformInterpolations(List<String> effectorNames, Integer taskSpaceForAllPaths, java.lang.Object paths, java.lang.Object axisMasks, java.lang.Object relativeTimes, Boolean isAbsolute) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("transformInterpolations", effectorNames, taskSpaceForAllPaths, paths, axisMasks, relativeTimes, isAbsolute);
        else
            service.call("transformInterpolations", effectorNames, taskSpaceForAllPaths, paths, axisMasks, relativeTimes, isAbsolute).get();
    }

    /**
    * Moves end-effectors to the given positions and orientations over time. This is a blocking call.
    * 
    * @param effectorNames  Vector of chain names. Could be: "Head", "LArm", "RArm", "LLeg", "RLeg", "Torso" 
    * @param taskSpaceForAllPaths  Task frame {FRAME_TORSO = 0, FRAME_WORLD = 1, FRAME_ROBOT = 2}.
    * @param paths  Vector of 6D position arrays (x,y,z,wx,wy,wz) in meters and radians
    * @param axisMasks  Vector of Axis Masks. True for axes that you wish to control. e.g. 7 for position only, 56 for rotation only and 63 for both 
    * @param relativeTimes  Vector of times in seconds corresponding to the path points
    */
    public void transformInterpolations(java.lang.Object effectorNames, java.lang.Object taskSpaceForAllPaths, java.lang.Object paths, java.lang.Object axisMasks, java.lang.Object relativeTimes) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("transformInterpolations", effectorNames, taskSpaceForAllPaths, paths, axisMasks, relativeTimes);
        else
            service.call("transformInterpolations", effectorNames, taskSpaceForAllPaths, paths, axisMasks, relativeTimes).get();
    }

    /**
    * Moves an end-effector to DEPRECATED. Use setTransforms function instead.
    * 
    * @param chainName  Name of the chain. Could be: "Head", "LArm","RArm", "LLeg", "RLeg", "Torso"
    * @param space  Task frame {FRAME_TORSO = 0, FRAME_WORLD = 1, FRAME_ROBOT = 2}.
    * @param transform  Transform arrays
    * @param fractionMaxSpeed  The fraction of maximum speed to use
    * @param axisMask  Axis mask. True for axes that you wish to control. e.g. 7 for position only, 56 for rotation only and 63 for both 
    */
    public void setTransform(String chainName, Integer space, List<Float> transform, Float fractionMaxSpeed, Integer axisMask) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setTransform", chainName, space, transform, fractionMaxSpeed, axisMask);
        else
            service.call("setTransform", chainName, space, transform, fractionMaxSpeed, axisMask).get();
    }

    /**
    * Moves multiple end-effectors to the given position and orientation transforms. This is a non-blocking call.
    * 
    * @param names  The name or names of effector.
    * @param spaces  The task frame or task frames {FRAME_TORSO = 0, FRAME_WORLD = 1, FRAME_ROBOT = 2}.
    * @param transforms  Transform arrays
    * @param fractionMaxSpeed  The fraction of maximum speed to use
    * @param axisMask  Axis mask. True for axes that you wish to control. e.g. 7 for position only, 56 for rotation only and 63 for both 
    */
    public void setTransforms(java.lang.Object names, java.lang.Object spaces, java.lang.Object transforms, Float fractionMaxSpeed, java.lang.Object axisMask) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setTransforms", names, spaces, transforms, fractionMaxSpeed, axisMask);
        else
            service.call("setTransforms", names, spaces, transforms, fractionMaxSpeed, axisMask).get();
    }

    /**
    * DEPRECATED. Use setTransforms function instead.
    * 
    * @param chainName  Name of the chain. Could be: "Head", "LArm","RArm", "LLeg", "RLeg", "Torso"
    * @param space  Task frame {FRAME_TORSO = 0, FRAME_WORLD = 1, FRAME_ROBOT = 2}.
    * @param transform  Transform arrays
    * @param fractionMaxSpeed  The fraction of maximum speed to use
    * @param axisMask  Axis mask. True for axes that you wish to control. e.g. 7 for position only, 56 for rotation only and 63 for both 
    */
    public void changeTransform(String chainName, Integer space, List<Float> transform, Float fractionMaxSpeed, Integer axisMask) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("changeTransform", chainName, space, transform, fractionMaxSpeed, axisMask);
        else
            service.call("changeTransform", chainName, space, transform, fractionMaxSpeed, axisMask).get();
    }

    /**
    * Gets an Homogenous Transform relative to the FRAME. Axis definition: the x axis is positive toward Nao's front, the y from right to left and the z is vertical.
    * 
    * @param name  Name of the item. Could be: any joint or chain or sensor (Head, LArm, RArm, LLeg, RLeg, Torso, HeadYaw, ..., CameraTop, CameraBottom, MicroFront, MicroRear, MicroLeft, MicroRight, Accelerometer, Gyrometer, Laser, LFsrFR, LFsrFL, LFsrRR, LFsrRL, RFsrFR, RFsrFL, RFsrRR, RFsrRL, USSensor1, USSensor2, USSensor3, USSensor4. Use getSensorNames for the list of sensors supported on your robot.
    * @param space  Task frame {FRAME_TORSO = 0, FRAME_WORLD = 1, FRAME_ROBOT = 2}.
    * @param useSensorValues  If true, the sensor values will be used to determine the position.
    * @return Vector of 16 floats corresponding to the values of the matrix, line by line.
    */
    public List<Float> getTransform(String name, Integer space, Boolean useSensorValues) throws CallError, InterruptedException {
        return (List<Float>)service.call("getTransform", name, space, useSensorValues).get();
    }

    /**
    * Gets an Homogenous Transform in World. 
    * 
    * @param sensorName  Name of the sensor
    * @param timestamp  A qi::os::timeval timestamp
    * @return Vector of 16 floats corresponding to the values of the matrix, line by line.
    */
    public List<Float> _getSensorTransformAtTime(String sensorName, Tuple2<Long, Long> timestamp) throws CallError, InterruptedException {
        return (List<Float>)service.call("_getSensorTransformAtTime", sensorName, timestamp).get();
    }

    /**
    * UserFriendly Whole Body API: enable Whole Body Balancer. It's a Generalized Inverse Kinematics which deals with cartesian control, balance, redundancy and task priority. The main goal is to generate and stabilized consistent motions without precomputed trajectories and adapt nao's behaviour to the situation. The generalized inverse kinematic problem takes in account equality constraints (keep foot fix), inequality constraints (joint limits, balance, ...) and quadratic minimization (cartesian / articular desired trajectories). We solve each step a quadratic programming on the robot.
    * 
    * @param isEnabled  Active / Disactive Whole Body Balancer.
    */
    public void wbEnable(Boolean isEnabled) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("wbEnable", isEnabled);
        else
            service.call("wbEnable", isEnabled).get();
    }

    /**
    * UserFriendly Whole Body API: set the foot state: fixed foot, constrained in a plane or free.
    * 
    * @param stateName  Name of the foot state. "Fixed" set the foot fixed. "Plane" constrained the Foot in the plane. "Free" set the foot free.
    * @param supportLeg  Name of the foot. "LLeg", "RLeg" or "Legs".
    */
    public void wbFootState(String stateName, String supportLeg) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("wbFootState", stateName, supportLeg);
        else
            service.call("wbFootState", stateName, supportLeg).get();
    }

    /**
    * UserFriendly Whole Body API: enable to keep balance in support polygon.
    * 
    * @param isEnable  Enable Nao to keep balance.
    * @param supportLeg  Name of the support leg: "Legs", "LLeg", "RLeg".
    */
    public void wbEnableBalanceConstraint(Boolean isEnable, String supportLeg) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("wbEnableBalanceConstraint", isEnable, supportLeg);
        else
            service.call("wbEnableBalanceConstraint", isEnable, supportLeg).get();
    }

    /**
    * Advanced Whole Body API: "Com" go to a desired support polygon. This is a blocking call.
    * 
    * @param supportLeg  Name of the support leg: "Legs", "LLeg", "RLeg".
    * @param duration  Time in seconds. Must be upper 0.5 s.
    */
    public void wbGoToBalance(String supportLeg, Float duration) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("wbGoToBalance", supportLeg, duration);
        else
            service.call("wbGoToBalance", supportLeg, duration).get();
    }

    /**
    * UserFriendly Whole Body API: enable whole body cartesian control of an effector.
    * 
    * @param effectorName  Name of the effector : "Head", "LArm" or "RArm". Nao goes to posture init. He manages his balance and keep foot fix. "Head" is controlled in rotation. "LArm" and "RArm" are controlled in position.
    * @param isEnabled  Active / Disactive Effector Control.
    */
    public void wbEnableEffectorControl(String effectorName, Boolean isEnabled) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("wbEnableEffectorControl", effectorName, isEnabled);
        else
            service.call("wbEnableEffectorControl", effectorName, isEnabled).get();
    }

    /**
    * UserFriendly Whole Body API: set new target for controlled effector. This is a non-blocking call.
    * 
    * @param effectorName  Name of the effector : "Head", "LArm" or "RArm". Nao goes to posture init. He manages his balance and keep foot fix. "Head" is controlled in rotation. "LArm" and "RArm" are controlled in position.
    * @param targetCoordinate  "Head" is controlled in rotation (WX, WY, WZ). "LArm" and "RArm" are controlled in position (X, Y, Z). TargetCoordinate must be absolute and expressed in FRAME_ROBOT. If the desired position/orientation is unfeasible, target is resize to the nearest feasible motion.
    */
    public void wbSetEffectorControl(String effectorName, java.lang.Object targetCoordinate) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("wbSetEffectorControl", effectorName, targetCoordinate);
        else
            service.call("wbSetEffectorControl", effectorName, targetCoordinate).get();
    }

    /**
    * Advanced Whole Body API: enable to control an effector as an optimization.
    * 
    * @param effectorName  Name of the effector : "All", "Arms", "Legs", "Head", "LArm", "RArm", "LLeg", "RLeg", "Torso", "Com".
    * @param isActive  if true, the effector control is taken in acount in the optimization criteria.
    */
    public void wbEnableEffectorOptimization(String effectorName, Boolean isActive) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("wbEnableEffectorOptimization", effectorName, isActive);
        else
            service.call("wbEnableEffectorOptimization", effectorName, isActive).get();
    }

    /**
    * UserFriendly Whole Body API: get Whole Body Balance State.
    * 
    * @return Name of the Whole Body Balance State ("None", "LLeg", "RLeg" or "Legs"). 
    */
    public String _wbGetBalanceState() throws CallError, InterruptedException {
        return (String)service.call("_wbGetBalanceState").get();
    }

    /**
    * UserFriendly Whole Body API: get Whole Body is active.
    * 
    * @return Get Whole Body is active.
    */
    public Boolean _wbIsActive() throws CallError, InterruptedException {
        return (Boolean)service.call("_wbIsActive").get();
    }

    /**
    * UserFriendly Whole Body API: reset the default Whole Body Configuration.
    * 
    */
    public void _wbDefaultConfiguration() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_wbDefaultConfiguration");
        else
            service.call("_wbDefaultConfiguration").get();
    }

    /**
    * UserFriendly Whole Body API: get the foot state: fixed foot, constrained in a plane or free.
    * 
    * @param supportLeg  Name of the foot. "LLeg", "RLeg" or "Legs".
    * @return Name of the foot state. "Fixed" set the foot fixed. "Plane" constrained the Foot in the plane. "Free" set the foot free.
    */
    public String _wbGetFootState(String supportLeg) throws CallError, InterruptedException {
        return (String)service.call("_wbGetFootState", supportLeg).get();
    }

    /**
    * Advanced Whole Body API: set the Reference Posture to specified possible redundancy.
    * 
    * @param postureName  Name of the posture. "PoseCurrent" set the Current Posture. "PoseInit" set the Posture Init as a reference Posture.
    */
    public void _wbSetReferencePosture(String postureName) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_wbSetReferencePosture", postureName);
        else
            service.call("_wbSetReferencePosture", postureName).get();
    }

    /**
    * Advanced Whole Body API: percent of the Support Polygon Dimensions used by "wbEnableBalanceConstraint".
    * 
    * @param percentForwards  percent of support polygone forwards. Between [0.0, 1.0].
    * @param percentSideways  percent of support polygone sideways. Between [0.0, 1.0].
    */
    public void _wbSetBalanceSecurityMargin(Float percentForwards, Float percentSideways) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_wbSetBalanceSecurityMargin", percentForwards, percentSideways);
        else
            service.call("_wbSetBalanceSecurityMargin", percentForwards, percentSideways).get();
    }

    /**
    * Advanced Whole Body API: weighting of Joint used in Whole Body Optimization criteria. It is the priority of Joint motion in front of all the other motion task in the quadratic programming optimization.
    * 
    * @param jointNames  Name or names of joints, chains, "Body" or "Joints".
    * @param weightings  Weight used in the Whole Body Articular Optimization.Limits : 0 &lt; weighting &lt;= 1000.0. "referencePosture"  default value : 1.0. "articularControl" default value : 1000.0.
    */
    public void _wbSetJointWeighting(String jointNames, Float weightings) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_wbSetJointWeighting", jointNames, weightings);
        else
            service.call("_wbSetJointWeighting", jointNames, weightings).get();
    }

    /**
    * Advanced Whole Body API: stiffness of Joint used in Whole Body Optimization criteria. It is the stiffness of Joint motion control used in the quadratic programming optimization.
    * 
    * @param jointName  Name or names of joints, chains, "Body" or "Joints".
    * @param stateName  "referencePosture" : the reference posture specified possibleredundancy or "articularControl" : for joint motion(angleInterpolation for example). "All", the both.
    * @param stiffness  Stiffness used in the Whole Body Articular Optimization.Limits : 0 &lt; stiffness &lt;= 100.0. "referencePosture" default value : 1.0."articularControl" default value : 30.0.
    */
    public void _wbSetJointStiffness(String jointName, Float stateName) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_wbSetJointStiffness", jointName, stateName);
        else
            service.call("_wbSetJointStiffness", jointName, stateName).get();
    }

    /**
    * Advanced Whole Body API: preview of Joint Inequality Constraint. It constraint the max joint velocity computed by the quadratic programming. If preview = 1, joint limits can be achieved in 1 step. If preview = 5, joint limits can be achieved in 5 steps. The more preview is, the less desired motion is realised. But the more preview is, the motion safety is increased.
    * 
    * @param jointName  Name or names of joints, chains, "Body" or "Joints".
    * @param stateName  "referencePosture" : the reference posture specified possibleredundancy or "articularControl" : for joint edition (angleInterpolation for example)."All", the both.
    * @param preview  Preview used in the Whole Body Inequality Constraints. Between [1 50]."referencePosture" default value : 1. "articularControl" default value : 1.
    */
    public void _wbSetArticularLimitPreview(String jointName, Integer stateName) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_wbSetArticularLimitPreview", jointName, stateName);
        else
            service.call("_wbSetArticularLimitPreview", jointName, stateName).get();
    }

    /**
    * Advanced Whole Body API: enable to control an effector as a constraint.
    * 
    * @param effectorName  Name of the effector : "All", "Arms", "Legs", "Head", "LArm", "RArm", "LLeg", "RLeg", "Torso", "Com".
    * @param isActive  if true, the effector control is taken in acount in the optimization criteria.
    * @param axisMask  True for axes that you wish to control. e.g. 7 for position only, 56 for rotation only and 63 for both.
    */
    public void _wbEnableEffectorConstraint(String effectorName, Boolean isActive, Integer axisMask) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_wbEnableEffectorConstraint", effectorName, isActive, axisMask);
        else
            service.call("_wbEnableEffectorConstraint", effectorName, isActive, axisMask).get();
    }

    /**
    * Advanced Whole Body API: get effector constraint state.
    * 
    * @param effectorName  Name of the effector : "Head", "LArm", "RArm", "LLeg", "RLeg", "Torso", "Com".
    * @return [isActive, axisMask].
    */
    public java.lang.Object _wbGetEffectorConstraint(String effectorName) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("_wbGetEffectorConstraint", effectorName).get();
    }

    /**
    * Advanced Whole Body API: enable to set the axis mask of an effector.
    * 
    * @param effectorName  Name of the effector : "All", "Arms", "Legs", "Head", "LArm", "RArm", "LLeg", "RLeg", "Torso", "Com".
    * @param isOptimized  if true, the optimized effector axis mask is setting, else it is the constrained effector axis mask.
    * @param axisMask  Axes that you wish to control. e.g. 7 for position only, 56 for rotation only and 63 for both.
    */
    public void _wbAxisMaskEffector(String effectorName, Boolean isOptimized, Integer axisMask) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_wbAxisMaskEffector", effectorName, isOptimized, axisMask);
        else
            service.call("_wbAxisMaskEffector", effectorName, isOptimized, axisMask).get();
    }

    /**
    * Advanced Whole Body API: enable to control a joint as an optimization.
    * 
    * @param jointName   "Body", name of the chain ("LLeg",...) or name of the joint : "HeadYaw", "LKneePitch".
    * @param isActive  if true, the joint control is taken in acount in the optimization criteria.
    */
    public void _wbEnableJointOptimization(String jointName, Boolean isActive) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_wbEnableJointOptimization", jointName, isActive);
        else
            service.call("_wbEnableJointOptimization", jointName, isActive).get();
    }

    /**
    * Advanced Whole Body API: get effector constraint state.
    * 
    * @param effectorName  Name of the effector : "Head", "LArm", "RArm", "LLeg", "RLeg", "Torso", "Com".
    * @return [isActive, axisMask].
    */
    public java.lang.Object _wbGetEffectorOptimization(String effectorName) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("_wbGetEffectorOptimization", effectorName).get();
    }

    /**
    * Advanced Whole Body API: set Effector Weighting in the Whole Body Optimization. It is the priority of Effector motion in front of all the other motion task in the quadratic programming optimization.
    * 
    * @param effectorName  "All", "Arms", "Legs", "Head", "LArm", "RArm", "LLeg", "RLeg", "Torso", "Com".
    * @param weightingList  Weighting used in the Whole Body Cartesian Optimization. Limits : 0 &lt; weighting &lt;= 1000.0. Default value is 1000.0. We can give the 6 weights corresponding to the 6 degree of freedom of cartesian motion. (WeightX, WeightY, WeightZ, WeightWX, WeightWY, WeightWZ). We can give 2 weights corresponding to translation and rotation axis (WeightTranslation, WeightTranslation, WeightTranslation, WeightRotation, WeightRotation, WeightRotation). We can give 1 weight, it is the same weight for all the axis (Weight, Weight, Weight, Weight, Weight, Weight).
    */
    public void _wbSetEffectorWeight(String effectorName, java.lang.Object weightingList) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_wbSetEffectorWeight", effectorName, weightingList);
        else
            service.call("_wbSetEffectorWeight", effectorName, weightingList).get();
    }

    /**
    * Advanced Whole Body API: set Effector Stiffness in Cartesian Control.
    * 
    * @param effectorName  "All", "Arms", "Legs", "Head", "LArm", "RArm", "LLeg", "RLeg", "Torso", "Com".
    * @param stiffnessList  Stiffness used in the Whole Body Cartesian Optimization. Limits : 0 &lt; stiffness &lt;= 100.0. Default value is 10.0. We can give the 6 stiffnesses corresponding to the 6 degree of freedom of cartesian motion. (StiffnessX, StiffnessY, StiffnessZ, StiffnessWX, StiffnessWY, StiffnessWZ). We can give 2 weights corresponding to translation and rotation axis (StiffnessTranslation, StiffnessTranslation, StiffnessTranslation, StiffnessRotation, StiffnessRotation, StiffnessRotation). We can give 1 stiffness, it is the same stiffness for all the axis (Stiffness, Stiffness, Stiffness, Stiffness, Stiffness, Stiffness).
    */
    public void _wbSetEffectorStiffness(String effectorName, java.lang.Object stiffnessList) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_wbSetEffectorStiffness", effectorName, stiffnessList);
        else
            service.call("_wbSetEffectorStiffness", effectorName, stiffnessList).get();
    }

    /**
    * Enable Anticollision protection of the arms of the robot. Use api isCollision to know if a chain is in collision and can be disactivated.
    * 
    * @param pChainName  The chain name {"Arms", "LArm" or "RArm"}.
    * @param pEnable  Activate or disactivate the anticollision of the desired Chain.
    * @return A bool which return always true.
    */
    public Boolean setCollisionProtectionEnabled(String pChainName, Boolean pEnable) throws CallError, InterruptedException {
        return (Boolean)service.call("setCollisionProtectionEnabled", pChainName, pEnable).get();
    }

    /**
    * Allow to know if the collision protection is activated on the given chain.
    * 
    * @param pChainName  The chain name {"LArm" or "RArm"}.
    * @return Return true is the collision protection of the given Arm is activated.
    */
    public Boolean getCollisionProtectionEnabled(String pChainName) throws CallError, InterruptedException {
        return (Boolean)service.call("getCollisionProtectionEnabled", pChainName).get();
    }

    /**
    * Enable Anticollision protection of the arms and base move  of the robot with external environment.
    * 
    * @param pName  The name {"All", "Move", "Arms", "LArm" or "RArm"}.
    * @param pEnable  Activate or disactivate the anticollision of the desired name.
    */
    public void setExternalCollisionProtectionEnabled(String pName, Boolean pEnable) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setExternalCollisionProtectionEnabled", pName, pEnable);
        else
            service.call("setExternalCollisionProtectionEnabled", pName, pEnable).get();
    }

    /**
    * Enable/Disable physical interaction on a chain without disabling safety completely
    * 
    * @param pChain  The chain name {"LArm", "RArm", "Arms"}
    * @param pEnabled  True/False
    */
    public void _enablePhysicalInteractionForChain(String pChain, Boolean pEnabled) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_enablePhysicalInteractionForChain", pChain, pEnabled);
        else
            service.call("_enablePhysicalInteractionForChain", pChain, pEnabled).get();
    }

    /**
    * Gets chain closest obstacle Position .
    * 
    * @param pName  The Chain name {"LArm" or "RArm"}.
    * @param space  Task frame {FRAME_TORSO = 0, FRAME_WORLD = 1, FRAME_ROBOT = 2}.
    * @return Vector containing the Position3D in meters (x, y, z)
    */
    public List<Float> getChainClosestObstaclePosition(String pName, Integer space) throws CallError, InterruptedException {
        return (List<Float>)service.call("getChainClosestObstaclePosition", pName, space).get();
    }

    /**
    * Allow to know if the external collision protection is activated on the given name.
    * 
    * @param pName  The name {"All", "Move", "Arms", "LArm" or "RArm"}.
    * @return Return true is the external collision protection of the given name is activated.
    */
    public Boolean getExternalCollisionProtectionEnabled(String pName) throws CallError, InterruptedException {
        return (Boolean)service.call("getExternalCollisionProtectionEnabled", pName).get();
    }

    /**
    * Defines the orthogonal security distance used with external collision protection "Move".
    * 
    * @param securityDistance  The orthogonal security distance.
    */
    public void setOrthogonalSecurityDistance(Float securityDistance) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setOrthogonalSecurityDistance", securityDistance);
        else
            service.call("setOrthogonalSecurityDistance", securityDistance).get();
    }

    /**
    * Gets the current orthogonal security distance.
    * 
    * @return The current orthogonal security distance.
    */
    public Float getOrthogonalSecurityDistance() throws CallError, InterruptedException {
        return (Float)service.call("getOrthogonalSecurityDistance").get();
    }

    /**
    * Defines the tangential security distance used with external collision protection "Move".
    * 
    * @param securityDistance  The tangential security distance.
    */
    public void setTangentialSecurityDistance(Float securityDistance) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setTangentialSecurityDistance", securityDistance);
        else
            service.call("setTangentialSecurityDistance", securityDistance).get();
    }

    /**
    * Gets the current tangential security distance.
    * 
    * @return The current tangential security distance.
    */
    public Float getTangentialSecurityDistance() throws CallError, InterruptedException {
        return (Float)service.call("getTangentialSecurityDistance").get();
    }

    /**
    * Give the collision state of a chain. If a chain has a collision state "none" or "near", it could be desactivated. 
    * 
    * @param pChainName  The chain name {"Arms", "LArm" or "RArm"}.
    * @return A string which notice the collision state: "none" there are no collision, "near" the collision is taking in account in the anti-collision algorithm, "collision" the chain is in contact with an other body. If the chain asked is "Arms" the most unfavorable result is given. 

    */
    public String isCollision(String pChainName) throws CallError, InterruptedException {
        return (String)service.call("isCollision", pChainName).get();
    }

    /**
    * Allow to know if the collision protection is activated on the given chain  and if stiffness of all chain joint is stricly positif.
    * 
    * @param pChainName  The chain name {"LArm" or "RArm"}.
    * @return Return true is the collision protection of the given Arm is activated.
    */
    public Boolean _getCollisionStateForObstacleSummary(String pChainName) throws CallError, InterruptedException {
        return (Boolean)service.call("_getCollisionStateForObstacleSummary", pChainName).get();
    }

    /**
    * DEPRECATED: use _getCollisionShapes. Gets the list of collision supported on your robot.
    * 
    * @param pName  The name {"static" or "dynamic"}.
    * @return Vector of collision names, radius, parent joint name and parentjoint position.
    */
    public java.lang.Object _getCollisionNames() throws CallError, InterruptedException {
        return (java.lang.Object)service.call("_getCollisionNames").get();
    }

    /**
    * Gets the list of dynamic collisions in torso frame.
    * 
    * @param pName  The name {"static" or "dynamic"}.
    * @return Vector of collisions name, radius, parent joint name andparent joint position.
    */
    public java.lang.Object _getCollisionShapes(String pName) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("_getCollisionShapes", pName).get();
    }

    /**
    * Set dynamic collision shape for people collision avoidance
    * 
    * @param pNameList  A vector of names.
    * @param pPairList  A vector of names. "All", "Sphere", "Pill" or the collision nameof LArm or RArm.
    * @param pBodyList  A vector of body names. Dynamic collision is attached to this body.
    * @param pTypeList  A vector of names. "Sphere", "Plan", "Pill" or "Tab".
    * @param pShapeList  A vector of shape data.
    * @param pPositionList  An ALValue containing a list of position of the shape.
    */
    public void _setCollisionShapes(List<String> pNameList, List<String> pPairList, List<String> pBodyList, List<String> pTypeList, java.lang.Object pShapeList, java.lang.Object pPositionList) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_setCollisionShapes", pNameList, pPairList, pBodyList, pTypeList, pShapeList, pPositionList);
        else
            service.call("_setCollisionShapes", pNameList, pPairList, pBodyList, pTypeList, pShapeList, pPositionList).get();
    }

    /**
    * Deprecated: Use setCollisionShapes with typeList. Set dynamic collision shape for people collision avoidance
    * 
    * @param pNameList  A vector of names.
    * @param pPairList  A vector of names. "All", "Sphere", "Pill" or the collision nameof LArm or RArm.
    * @param pShapeList  A vector of shape data.
    * @param pPositionList  An ALValue containing a list of position of the shape.
    */
    public void _setCollisionShapes(List<String> pNameList, List<String> pPairList, java.lang.Object pShapeList, java.lang.Object pPositionList) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_setCollisionShapes", pNameList, pPairList, pShapeList, pPositionList);
        else
            service.call("_setCollisionShapes", pNameList, pPairList, pShapeList, pPositionList).get();
    }

    /**
    * Gets the list of detected collisions supported on your robot.
    * 
    * @param pMinimumDistance  Distance to take into account collision pair.
    * @return Vector of collisions: [nameShape1, nameShape2, distance].
    */
    public java.lang.Object _getDetectedCollisions(Float pMinimumDistance) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("_getDetectedCollisions", pMinimumDistance).get();
    }

    /**
    * Gets the polygon checked for safety during move.
    * 
    * @return A vector of Position2D.
    */
    public java.lang.Object _getDangerousRegion() throws CallError, InterruptedException {
        return (java.lang.Object)service.call("_getDangerousRegion").get();
    }

    /**
    * Enable The fall manager protection for the robot. When a fall is detected the robot adopt a joint configuration to protect himself and cut the stiffness.
. An memory event called "robotHasFallen" is generated when the fallManager have been activated.
    * 
    * @param pEnable  Activate or disactivate the smart stiffness.
    */
    public void setFallManagerEnabled(Boolean pEnable) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setFallManagerEnabled", pEnable);
        else
            service.call("setFallManagerEnabled", pEnable).get();
    }

    /**
    * Give the state of the fall manager.
    * 
    * @return Return true is the fall manager is activated. 

    */
    public Boolean getFallManagerEnabled() throws CallError, InterruptedException {
        return (Boolean)service.call("getFallManagerEnabled").get();
    }

    /**
    * Enable The push recovery protection for the robot. 
    * 
    * @param pEnable  Enable the push recovery.
    */
    public void setPushRecoveryEnabled(Boolean pEnable) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setPushRecoveryEnabled", pEnable);
        else
            service.call("setPushRecoveryEnabled", pEnable).get();
    }

    /**
    * Enable The push recovery protection for the robot. 
    * 
    * @param pEnable  Enable the push recovery.
    */
    public void _setPushRecoveryEnabled(Boolean pEnable) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_setPushRecoveryEnabled", pEnable);
        else
            service.call("_setPushRecoveryEnabled", pEnable).get();
    }

    /**
    * Give the state of the push recovery.
    * 
    * @return Return true is the push recovery is activated. 

    */
    public Boolean getPushRecoveryEnabled() throws CallError, InterruptedException {
        return (Boolean)service.call("getPushRecoveryEnabled").get();
    }

    /**
    * Enable Smart Stiffness for all the joints (True by default), the update take one motion cycle for updating. The smart Stiffness is a gestion of joint maximum torque. More description is available on the red documentation of ALMotion module.
    * 
    * @param pEnable  Activate or disactivate the smart stiffness.
    */
    public void setSmartStiffnessEnabled(Boolean pEnable) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setSmartStiffnessEnabled", pEnable);
        else
            service.call("setSmartStiffnessEnabled", pEnable).get();
    }

    /**
    * Give the state of the smart Stiffness.
    * 
    * @return Return true is the smart Stiffnes is activated. 

    */
    public Boolean getSmartStiffnessEnabled() throws CallError, InterruptedException {
        return (Boolean)service.call("getSmartStiffnessEnabled").get();
    }

    /**
    * Enable or disable the diagnosis effect into ALMotion
    * 
    * @param pEnable  Enable or disable the diagnosis effect.
    */
    public void setDiagnosisEffectEnabled(Boolean pEnable) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setDiagnosisEffectEnabled", pEnable);
        else
            service.call("setDiagnosisEffectEnabled", pEnable).get();
    }

    /**
    * Give the state of the diagnosis effect.
    * 
    * @return Return true is the diagnosis reflex is activated. 

    */
    public Boolean getDiagnosisEffectEnabled() throws CallError, InterruptedException {
        return (Boolean)service.call("getDiagnosisEffectEnabled").get();
    }

    /**
    * DEPRECATED. Use getBodyNames function instead.
    * 
    * @param name  Name of a chain, "Arms", "Legs", "Body", "Chains", "JointActuators", "Joints" or "Actuators".
    * @return Vector of strings, one for each joint in the collection
    */
    public List<String> getJointNames(String name) throws CallError, InterruptedException {
        return (List<String>)service.call("getJointNames", name).get();
    }

    /**
    * Gets the names of all the joints and actuators in the collection.
    * 
    * @param name  Name of a chain, "Arms", "Legs", "Body", "Chains", "JointActuators", "Joints" or "Actuators".
    * @return Vector of strings, one for each joint and actuator in the collection
    */
    public List<String> getBodyNames(String name) throws CallError, InterruptedException {
        return (List<String>)service.call("getBodyNames", name).get();
    }

    /**
    * Gets the list of sensors supported on your robot.
    * 
    * @return Vector of sensor names
    */
    public List<String> getSensorNames() throws CallError, InterruptedException {
        return (List<String>)service.call("getSensorNames").get();
    }

    /**
    * Get the minAngle (rad), maxAngle (rad), and maxVelocity (rad.s-1) for a given joint or actuator in the body.
    * 
    * @param name  Name of a joint, chain, "Body", "JointActuators", "Joints" or "Actuators". 
    * @return Array of ALValue arrays containing the minAngle, maxAngle, maxVelocity and maxTorque for all the bodies specified.
    */
    public java.lang.Object getLimits(String name) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("getLimits", name).get();
    }

    /**
    * Get the minAngle (rad), maxAngle (rad), and maxVelocity (rad.s-1) for a given joint or actuator in the body.
    * 
    * @param name  Name of a joint, chain, "Body", "JointActuators", "Joints" or "Actuators". 
    * @return Array of ALValue arrays containing the minAngle, maxAngle, maxVelocity, maxTorque, Kc, reduction, efficiency and maxCurrent for all the bodies specified.
    */
    public java.lang.Object _getFullLimits(String name) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("_getFullLimits", name).get();
    }

    /**
    * Get the motion cycle time in milliseconds.
    * 
    * @return Expressed in milliseconds
    */
    public Integer getMotionCycleTime() throws CallError, InterruptedException {
        return (Integer)service.call("getMotionCycleTime").get();
    }

    /**
    * Get the motion cycle number in int.
    * 
    * @return Expressed in int.
    */
    public Integer _getMotionCycleNumber() throws CallError, InterruptedException {
        return (Integer)service.call("_getMotionCycleNumber").get();
    }

    /**
    * Get the robot configuration.
    * 
    * @return ALValue arrays containing the robot parameter names and the robot parameter values.
    */
    public java.lang.Object getRobotConfig() throws CallError, InterruptedException {
        return (java.lang.Object)service.call("getRobotConfig").get();
    }

    /**
    * Returns a string representation of the Model's state
    * 
    * @return A formated string
    */
    public String getSummary() throws CallError, InterruptedException {
        return (String)service.call("getSummary").get();
    }

    /**
    * Gets the mass of a joint, chain, "Body" or "Joints".
    * 
    * @param pName  Name of the body which we want the mass. "Body", "Joints" and "Com" give the total mass of nao. For the chain, it gives the total mass of the chain.
    * @return The mass in kg.
    */
    public Float getMass(String pName) throws CallError, InterruptedException {
        return (Float)service.call("getMass", pName).get();
    }

    /**
    * Gets the COM of a joint, chain, "Body" or "Joints".
    * 
    * @param pName  Name of the body which we want the mass. In chain name case, this function give the com of the chain.
    * @param pSpace  Task frame {FRAME_TORSO = 0, FRAME_WORLD = 1, FRAME_ROBOT = 2}.
    * @param pUseSensorValues  If true, the sensor values will be used to determine the position.
    * @return The COM position (meter).
    */
    public List<Float> getCOM(String pName, Integer pSpace, Boolean pUseSensorValues) throws CallError, InterruptedException {
        return (List<Float>)service.call("getCOM", pName, pSpace, pUseSensorValues).get();
    }

    /**
    * Gets the support polygon
    * 
    * @param pSpace  Task frame {FRAME_TORSO = 0, FRAME_WORLD = 1, FRAME_ROBOT = 2}.
    * @param pUseSensorValues  If true, the sensor values will be used to determine the position.
    * @return A vector containing the x,y coordinates of each of the outer points of the support polygon in specified frame.
    */
    public List<List<Float>> getSupportPolygon(Integer pSpace, Boolean pUseSensorValues) throws CallError, InterruptedException {
        return (List<List<Float>>)service.call("getSupportPolygon", pSpace, pUseSensorValues).get();
    }

    /**
    * Gets the torque of the joints
    * 
    * @param names  Names the joints, chains, "Body", "Joints". 
    * @param useSensor  If true, return the sensor torque.
    * @return Torques in N.m.
    */
    public List<Float> _getTorque(java.lang.Object names, Boolean useSensor) throws CallError, InterruptedException {
        return (List<Float>)service.call("_getTorque", names, useSensor).get();
    }

    /**
    * Gets the inertia matrice of a joint or "Torso".
    * 
    * @param pName  Name of the joint or "Torso". Inertia is given in the COM of the body, in poseZero orientation.
    * @return The inertia matrix (kg.m2).
    */
    public List<Float> _getInertia(String pName) throws CallError, InterruptedException {
        return (List<Float>)service.call("_getInertia", pName).get();
    }

    /**
    * Internal Use.
    * 
    * @param config  Internal: An array of ALValues [i][0]: name, [i][1]: value
    */
    public void setMotionConfig(java.lang.Object config) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setMotionConfig", config);
        else
            service.call("setMotionConfig", config).get();
    }

    /**
    * Callback naoqi is ready.
    * 
    */
    public void _naoqiIsReadyCallback() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_naoqiIsReadyCallback");
        else
            service.call("_naoqiIsReadyCallback").get();
    }

    /**
    * Callback preferences changed.
    * 
    */
    public void _preferenceUpdatedCallback(String param1, java.lang.Object param2, String param3) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_preferenceUpdatedCallback", param1, param2, param3);
        else
            service.call("_preferenceUpdatedCallback", param1, param2, param3).get();
    }

    /**
    * Update the target to follow by the head of NAO.
DEPRECATED Function. Please use ALTracker::lookAt.

    * 
    * @param pTargetPositionWy  The target position wy in FRAME_ROBOT
    * @param pTargetPositionWz  The target position wz in  FRAME_ROBOT
    * @param pTimeSinceDetectionMs  The time in Ms since the target was detected
    * @param pUseOfWholeBody  If true, the target is follow in cartesian space by the Head with whole Body constraints.
    */
    public void updateTrackerTarget(Float pTargetPositionWy, Float pTargetPositionWz, Integer pTimeSinceDetectionMs, Boolean pUseOfWholeBody) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("updateTrackerTarget", pTargetPositionWy, pTargetPositionWz, pTimeSinceDetectionMs, pUseOfWholeBody);
        else
            service.call("updateTrackerTarget", pTargetPositionWy, pTargetPositionWz, pTimeSinceDetectionMs, pUseOfWholeBody).get();
    }

    /**
    * Interpolate with hands or head with prediction.
This function is mainly use by the tracker modules.

    * 
    * @param pNames  list of Joints Names.
    * @param pTargetPositions  list of Joints angles.
    * @param pTimeSinceDetectionMs  The time in Ms since the target was detected
    * @param pUseOfWholeBody  If true, the target is follow in cartesian space by the Head with whole Body constraints.
    * @param pIsPointAt  if true use pointAt task else lookAt task.
    */
    public void _trackerAnticipation(List<String> pNames, List<Float> pTargetPositions, Integer pTimeSinceDetectionMs, Boolean pUseOfWholeBody, Boolean pIsPointAt) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_trackerAnticipation", pNames, pTargetPositions, pTimeSinceDetectionMs, pUseOfWholeBody, pIsPointAt);
        else
            service.call("_trackerAnticipation", pNames, pTargetPositions, pTimeSinceDetectionMs, pUseOfWholeBody, pIsPointAt).get();
    }

    /**
    * Interpolate with speed without prediction.
    * 
    * @param pNames  list of Joints Names.
    * @param pTargetPositions  list of Joints angles.
    * @param pTimeSinceDetectionMs  The time in Ms since the target was detected
    * @param pMaxSpeedFraction  fraction max speed list.
    * @param pUseOfWholeBody  If true, the target is follow in cartesian space by the Head with whole Body constraints.
    * @param pIsPointAt  if true use pointAt task else lookAt task.
    */
    public void _trackerWithSpeed(List<String> pNames, List<Float> pTargetPositions, List<Float> pTimeSinceDetectionMs, Boolean pMaxSpeedFraction, Boolean pUseOfWholeBody) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_trackerWithSpeed", pNames, pTargetPositions, pTimeSinceDetectionMs, pMaxSpeedFraction, pUseOfWholeBody);
        else
            service.call("_trackerWithSpeed", pNames, pTargetPositions, pTimeSinceDetectionMs, pMaxSpeedFraction, pUseOfWholeBody).get();
    }

    /**
    * lookAt
    * 
    * @param pTargetPosition  position 3D to look at.
    * @param pFrame  Target frame {FRAME_TORSO = 0, FRAME_WORLD = 1, FRAME_ROBOT = 2}.
    * @param pMaxSpeedFraction  fraction max speed.
    */
    public void _lookAt(List<Float> pTargetPosition, Integer pFrame, Float pMaxSpeedFraction) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_lookAt", pTargetPosition, pFrame, pMaxSpeedFraction);
        else
            service.call("_lookAt", pTargetPosition, pFrame, pMaxSpeedFraction).get();
    }

    /**
    * lookAt
    * 
    * @param pTargetPosition  position 3D to look at.
    * @param pFrame  Target frame {FRAME_TORSO = 0, FRAME_WORLD = 1, FRAME_ROBOT = 2}.
    * @param pEffectorId  effector id {Middle of eyes = 0, Camera Top = 1, Camera Bottom = 2}.
    * @param pMaxSpeedFraction  fraction max speed.
    */
    public void _lookAt(List<Float> pTargetPosition, Integer pFrame, Integer pEffectorId, Float pMaxSpeedFraction) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_lookAt", pTargetPosition, pFrame, pEffectorId, pMaxSpeedFraction);
        else
            service.call("_lookAt", pTargetPosition, pFrame, pEffectorId, pMaxSpeedFraction).get();
    }

    /**
    * Stop lookAt task
This function is mainly use by the tracker modules.

    * 
    * @param pWithSpeed  if True stop lookAtWithSpeed task.
    */
    public void _stopLookAt(Boolean pWithSpeed) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_stopLookAt", pWithSpeed);
        else
            service.call("_stopLookAt", pWithSpeed).get();
    }

    /**
    * Stop PointAt task
This function is mainly use by the tracker modules.

    * 
    * @param pWithSpeed  if True stop pointAtWithSpeed task.
    */
    public void _stopPointAt(Boolean pWithSpeed) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_stopPointAt", pWithSpeed);
        else
            service.call("_stopPointAt", pWithSpeed).get();
    }

    /**
    * Update obstacles
    * 
    * @param obstacles  List of closest obstacles [[x, y, z]...]
    */
    public void _updateObstacles(List<List<Float>> obstacles) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_updateObstacles", obstacles);
        else
            service.call("_updateObstacles", obstacles).get();
    }

    /**
    * This function starts or stops breathing animation on a chain.
Chain name can be "Body", "Arms", "LArm", "RArm", "Legs" or "Head".
Head breathing animation will work only if Leg animation is active.
    * 
    * @param pChain  Chain name.
    * @param pIsEnabled  Enables / disables the chain.
    */
    public void setBreathEnabled(String pChain, Boolean pIsEnabled) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setBreathEnabled", pChain, pIsEnabled);
        else
            service.call("setBreathEnabled", pChain, pIsEnabled).get();
    }

    /**
    * This function gets the status of breathing animation on a chain.
Chain name can be "Body", "Arms", "LArm", "RArm", "Legs" or "Head".

    * 
    * @param pChain  Chain name.
    * @return True if breathing animation is enabled on the chain.
    */
    public Boolean getBreathEnabled(String pChain) throws CallError, InterruptedException {
        return (Boolean)service.call("getBreathEnabled", pChain).get();
    }

    /**
    * This function configures the breathing animation.
    * 
    * @param pConfig  Breath configuration.
An ALValue of the form [["Bpm", pBpm], ["Amplitude", pAmplitude]].
pBpm is a float between 10 and 50 setting the breathing frequency in beats per minute.
pAmplitude is a float between 0 and 1 setting the amplitude of the breathing animation.
    */
    public void setBreathConfig(java.lang.Object pConfig) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setBreathConfig", pConfig);
        else
            service.call("setBreathConfig", pConfig).get();
    }

    /**
    * This function gets the current breathing configuration.
    * 
    * @return An ALValue of the form [["Bpm", bpm], ["Amplitude", amplitude]].
bpm is the breathing frequency in beats per minute.
amplitude is the normalized amplitude of the breathing animation, between 0 and 1.
    */
    public java.lang.Object getBreathConfig() throws CallError, InterruptedException {
        return (java.lang.Object)service.call("getBreathConfig").get();
    }

    /**
    * Starts or stops idle posture management on a chain.
Chain name can be "Body", "Arms", "LArm", "RArm", "Legs" or "Head".
    * 
    * @param pChain  Chain name.
    * @param pIsEnabled  Enables / disables the chain.
    */
    public void setIdlePostureEnabled(String pChain, Boolean pIsEnabled) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setIdlePostureEnabled", pChain, pIsEnabled);
        else
            service.call("setIdlePostureEnabled", pChain, pIsEnabled).get();
    }

    /**
    * This function gets the status of idle posture management on a chain.
Chain name can be "Body", "Arms", "LArm", "RArm", "Legs" or "Head".

    * 
    * @param pChain  Chain name.
    * @return True if breathing animation is enabled on the chain.
    */
    public Boolean getIdlePostureEnabled(String pChain) throws CallError, InterruptedException {
        return (Boolean)service.call("getIdlePostureEnabled", pChain).get();
    }

    /**
    * Gets an ALValue structure describing the tasks in the Task List
    * 
    * @return An ALValue containing an ALValue for each task. The inner ALValue contains: Name, MotionID
    */
    public java.lang.Object getTaskList() throws CallError, InterruptedException {
        return (java.lang.Object)service.call("getTaskList").get();
    }

    /**
    * Returns true if all the desired resources are available. Only motion API's' blocking call takes resources.
    * 
    * @param resourceNames  A vector of resource names such as joints. Use getBodyNames("Body") to have the list of the available joint for your robot.
    * @return True if the resources are available
    */
    public Boolean areResourcesAvailable(List<String> resourceNames) throws CallError, InterruptedException {
        return (Boolean)service.call("areResourcesAvailable", resourceNames).get();
    }

    /**
    * Kills a motion task.
    * 
    * @param motionTaskID  TaskID of the motion task you want to kill.
    * @return Return true if the specified motionTaskId has been killed.
    */
    public Boolean killTask(Integer motionTaskID) throws CallError, InterruptedException {
        return (Boolean)service.call("killTask", motionTaskID).get();
    }

    /**
    * Kills all tasks that use any of the resources given. Only motion API's' blocking call takes resources and can be killed. Use getBodyNames("Body") to have the list of the available joint for your robot.
    * 
    * @param resourceNames  A vector of resource joint names
    */
    public void killTasksUsingResources(List<String> resourceNames) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("killTasksUsingResources", resourceNames);
        else
            service.call("killTasksUsingResources", resourceNames).get();
    }

    /**
    * DEPRECATED. Use killMove function instead.
    * 
    */
    public void killWalk() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("killWalk");
        else
            service.call("killWalk").get();
    }

    /**
    * Emergency Stop on Move task: This method will end the move task brutally, without attempting to return to a balanced state. The robot could easily fall.
    * 
    */
    public void killMove() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("killMove");
        else
            service.call("killMove").get();
    }

    /**
    * Kills all tasks.
    * 
    */
    public void killAll() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("killAll");
        else
            service.call("killAll").get();
    }

    /**
    * Enable / Disable notifications.
    * 
    * @param enable  If True enable notifications. If False disable notifications.
    */
    public void setEnableNotifications(Boolean enable) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setEnableNotifications", enable);
        else
            service.call("setEnableNotifications", enable).get();
    }

    /**
    * Return true if notifications are active.
    * 
    * @return Return True if notifications are active.
    */
    public Boolean areNotificationsEnabled() throws CallError, InterruptedException {
        return (Boolean)service.call("areNotificationsEnabled").get();
    }

    /**
    * Gets the list of collision with the ground.
    * 
    * @return Vector of collision names and position in torso frame
    */
    public java.lang.Object _getGroundCollision() throws CallError, InterruptedException {
        return (java.lang.Object)service.call("_getGroundCollision").get();
    }

    /**
    * Gets the list of collision with the ground.
    * 
    * @return Vector of collision names and position in torso frame
    */
    public java.lang.Object _getGroundCollisionForForceContact() throws CallError, InterruptedException {
        return (java.lang.Object)service.call("_getGroundCollisionForForceContact").get();
    }

    /**
    * Gets the list of collision with the ground.
    * 
    * @return Vector of collision names and position in torso frame
    */
    public java.lang.Object _getGroundCollisionForFallManager() throws CallError, InterruptedException {
        return (java.lang.Object)service.call("_getGroundCollisionForFallManager").get();
    }

    /**
    * Gets the ground plane transform in torso frame.
    * 
    * @return the ground plane transform in torso frame
    */
    public List<Float> _getGroundPlaneTf() throws CallError, InterruptedException {
        return (List<Float>)service.call("_getGroundPlaneTf").get();
    }

    /**
    * Gets the Normal Force Contact.
    * 
    * @return Vector of normal Force contact
    */
    public List<Float> _getNormalForceContact() throws CallError, InterruptedException {
        return (List<Float>)service.call("_getNormalForceContact").get();
    }

    /**
    * It's a getPosition on Torso with inertial Information.This function is used in chorgraphe in 3D View
    * 
    * @return a transform of the Torso position
    */
    public List<Float> _getRealTorsoInWorld() throws CallError, InterruptedException {
        return (List<Float>)service.call("_getRealTorsoInWorld").get();
    }

    /**
    * 
    * 
    * @return Array of ALValue arrays containing the sphere position2D and radius.
    */
    public java.lang.Object _getRobotGroundConvexHullDebug() throws CallError, InterruptedException {
        return (java.lang.Object)service.call("_getRobotGroundConvexHullDebug").get();
    }

    /**
    * Get the robot convex hull projected on the ground in the ROBOT_FRAME.
    * 
    * @return Array of ALValue arrays containing the position2D of each convex hull points.
    */
    public java.lang.Object _getRobotGroundConvexHull() throws CallError, InterruptedException {
        return (java.lang.Object)service.call("_getRobotGroundConvexHull").get();
    }

    /**
    * Gets if the joints is moving
    * 
    * @param useSensors  If true, sensor information will be returned
    * @return a vector of boolean.
    */
    public List<Integer> _getJointIsMoving(Boolean useSensors) throws CallError, InterruptedException {
        return (List<Integer>)service.call("_getJointIsMoving", useSensors).get();
    }

    /**
    * Gets if the chain is moving
    * 
    * @param useSensors  If true, sensor information will be returned
    * @return a vector of boolean.
    */
    public List<Integer> _getChainIsMoving(Boolean useSensors) throws CallError, InterruptedException {
        return (List<Integer>)service.call("_getChainIsMoving", useSensors).get();
    }

    /**
    * In fact, it's an hide way to allow the fall manager to disable the fall manager. Note, it's inverse (true set fall to false)
    * 
    * @param pEnable  Activate or disactivate the animation Mode.
    */
    public void _setAnimationModeEnabled(Boolean pEnable) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_setAnimationModeEnabled", pEnable);
        else
            service.call("_setAnimationModeEnabled", pEnable).get();
    }

    /**
    * Get the motion configuration.
    * 
    * @param pName  "All", "State", "Mode", "Protection", "Collision", "Basic", "Move", "Tracker", "Walk", "OmniWheel", "Log", "RobotState", "Duration", "Control", "SmartStiffness","WB", "FallManager".
    * @return string contraining all the information.
    */
    public String _getMotionConfig(String pName) throws CallError, InterruptedException {
        return (String)service.call("_getMotionConfig", pName).get();
    }

    /**
    * Gets the support polygon
    * 
    * @return A vector containing the x,y coordinates of each of the outer points of the support polygon in frame robot.
    */
    public List<Float> _getSupportPolygon() throws CallError, InterruptedException {
        return (List<Float>)service.call("_getSupportPolygon").get();
    }

    /**
    * Gets the center of the support polygon in frame robot.
    * 
    * @return A vector containing the x,y coordinates of the center of the support polygon
    */
    public List<Float> _getSupportPolygonCenter() throws CallError, InterruptedException {
        return (List<Float>)service.call("_getSupportPolygonCenter").get();
    }

    /**
    * Gets the support polygon
    * 
    * @return A Position3D (x,y,z) coordinates of com in World Space
    */
    public List<Float> _getComWorld() throws CallError, InterruptedException {
        return (List<Float>)service.call("_getComWorld").get();
    }

    /**
    * Gets the support polygon
    * 
    * @return A Rotation3D (wx,wy,0) coresponding to world rotation
    */
    public List<Float> _getWorldRotation() throws CallError, InterruptedException {
        return (List<Float>)service.call("_getWorldRotation").get();
    }

    /**
    * Activate the fall task
    * 
    * @param pFallAngle  The fall angle in degree.
    */
    public void _fall(Float pFallAngle) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_fall", pFallAngle);
        else
            service.call("_fall", pFallAngle).get();
    }

    /**
    * Activate the omniwheel task to recover balance.
    * 
    */
    public void _balanceRecovery() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_balanceRecovery");
        else
            service.call("_balanceRecovery").get();
    }

    /**
    * A patch to avoid to consume too much current after a SitDown.
    * 
    */
    public void _relaxMotorsWhenSitting() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_relaxMotorsWhenSitting");
        else
            service.call("_relaxMotorsWhenSitting").get();
    }

    /**
    * Relax a chain.
    * 
    * @param chainName  The name of the chain to relax.
    */
    public void _relax(String chainName) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_relax", chainName);
        else
            service.call("_relax", chainName).get();
    }

    /**
    * Reset to false the bool Cartesian Unfeasible: used for testing motion.
    * 
    */
    public void _resetCartesianUnfeasible() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_resetCartesianUnfeasible");
        else
            service.call("_resetCartesianUnfeasible").get();
    }

    /**
    * et to true the bool Cartesian Unfeasible: used for testing motion.
    * 
    */
    public void _setCartesianUnfeasible() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_setCartesianUnfeasible");
        else
            service.call("_setCartesianUnfeasible").get();
    }

    /**
    * Get the Cartesian Unfeasible state since last reset: used for testing motion.
    * 
    * @return True if there are one cartesian unfeasible during one motion cycle since last reset.
    */
    public Integer _getCartesianUnfeasible() throws CallError, InterruptedException {
        return (Integer)service.call("_getCartesianUnfeasible").get();
    }

    /**
    * Save current whole body dump
    * 
    */
    public void _saveWholeBodyDump() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_saveWholeBodyDump");
        else
            service.call("_saveWholeBodyDump").get();
    }

    /**
    * Reset the number of joint command discontinuous updates.
    * 
    */
    public void _resetNumJointCommandDiscontinuities() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_resetNumJointCommandDiscontinuities");
        else
            service.call("_resetNumJointCommandDiscontinuities").get();
    }

    /**
    * Get the number of joint command discontinuous updates since last reset.
    * 
    * @return The number of discontinuities since last reset.
    */
    public Integer _getNumJointCommandDiscontinuities() throws CallError, InterruptedException {
        return (Integer)service.call("_getNumJointCommandDiscontinuities").get();
    }

    /**
    * Usefull function to resynchronize ALMotion and DCM 
In fact we set motion command model with sensors information
    * 
    * @param pName  Names the joints, chains, "Body", "JointActuators", "Joints" or "Actuators". 
    */
    public void _resetMotionCommandModelToSensors(java.lang.Object pName) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_resetMotionCommandModelToSensors", pName);
        else
            service.call("_resetMotionCommandModelToSensors", pName).get();
    }

    /**
    * Usefull function to change motion mode to simulation
    * 
    * @param pEnable  Enable or Disable motion simulation mode.
    */
    public void _setSimulationModeEnabled(Boolean pEnable) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_setSimulationModeEnabled", pEnable);
        else
            service.call("_setSimulationModeEnabled", pEnable).get();
    }

    /**
    * Get motion to dcm commands
    * 
    */
    public java.lang.Object _getMotionToDCM() throws CallError, InterruptedException {
        return (java.lang.Object)service.call("_getMotionToDCM").get();
    }

    /**
    * Get blind zone offset.
    * 
    * @param Name  Blind Zone name. Could be FrontLeft, FrontRight, BackLeft or BackRight
    * @return offset
    */
    public Float _getBlindZoneOffset(String Name) throws CallError, InterruptedException {
        return (Float)service.call("_getBlindZoneOffset", Name).get();
    }

    /**
    * Set the blind zone offset.
    * 
    * @param Name  Blind Zone name. Could be FrontLeft, FrontRight, BackLeft or BackRight
    * @param Offset  offset
    */
    public void _setBlindZoneOffset(String Name, Float Offset) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_setBlindZoneOffset", Name, Offset);
        else
            service.call("_setBlindZoneOffset", Name, Offset).get();
    }

    /**
    * Get the blind zone distance.
    * 
    * @return offset
    */
    public Float _getBlindZoneDistance() throws CallError, InterruptedException {
        return (Float)service.call("_getBlindZoneDistance").get();
    }

    /**
    * Set the blind zone distance.
    * 
    * @param Distance  The disatance of the second point of blind zone segments
    */
    public void _setBlindZoneDistance(Float Distance) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_setBlindZoneDistance", Distance);
        else
            service.call("_setBlindZoneDistance", Distance).get();
    }

    /**
    * Get the blind zones convex polygon.
    * 
    * @return the blind zones [[[x, y], ..., [x, y]]...]
    */
    public java.lang.Object _getBlindZones() throws CallError, InterruptedException {
        return (java.lang.Object)service.call("_getBlindZones").get();
    }

    /**
    * Get the blind zones convex polygon with the corresponding names.
    * 
    * @return the blind zones [[name, [[x1, y1]...[x2, y2]]], ...]
    */
    public java.lang.Object _getBlindZonesWithNames() throws CallError, InterruptedException {
        return (java.lang.Object)service.call("_getBlindZonesWithNames").get();
    }

}
    