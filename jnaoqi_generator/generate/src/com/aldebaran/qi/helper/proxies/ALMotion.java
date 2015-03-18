/**
 * Copyright (c) 2015 Aldebaran Robotics. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be
 * found in the COPYING file.
 * Created by epinault and tcruz
 */
package com.aldebaran.qi.helper.proxies;

import com.aldebaran.qi.CallError;
import com.aldebaran.qi.Session;
import com.aldebaran.qi.helper.ALProxy;

import java.util.List;
/**
* ALMotion provides methods that help make Nao move. It contains commands for manipulating joint angles, joint stiffness, and a higher level API for controling walks.
* @see <a href="http://doc.aldebaran.lan/doc/release-2.1/aldeb-doc/naoqi/motion/almotion.html#almotion">NAOqi APIs for ALMotion </a>
*
*/
public class ALMotion extends ALProxy {

    public ALMotion(Session session) throws Exception{
        super(session);
    }

    /**
    * 
    * 
    */
    public Boolean isStatsEnabled() throws CallError, InterruptedException {
        return (Boolean)call("isStatsEnabled").get();
    }

    /**
    * 
    * 
    */
    public void clearStats() throws CallError, InterruptedException{
        if (isAsynchronous)
            call("clearStats");
        else
            call("clearStats").get();
    }

    /**
    * 
    * 
    */
    public Boolean isTraceEnabled() throws CallError, InterruptedException {
        return (Boolean)call("isTraceEnabled").get();
    }

    /**
    * Exits and unregisters the module.
    * 
    */
    public void exit() throws CallError, InterruptedException{
        if (isAsynchronous)
            call("exit");
        else
            call("exit").get();
    }

    /**
    * Returns the version of the module.
    * 
    * @return A string containing the version of the module.
    */
    public String version() throws CallError, InterruptedException {
        return (String)call("version").get();
    }

    /**
    * Just a ping. Always returns true
    * 
    * @return returns true
    */
    public Boolean ping() throws CallError, InterruptedException {
        return (Boolean)call("ping").get();
    }

    /**
    * Retrieves the module's method list.
    * 
    * @return An array of method names.
    */
    public List<String> getMethodList() throws CallError, InterruptedException {
        return (List<String>)call("getMethodList").get();
    }

    /**
    * Retrieves a method's description.
    * 
    * @param methodName  The name of the method.
    * @return A structure containing the method's description.
    */
    public Object getMethodHelp(String methodName) throws CallError, InterruptedException {
        return (Object)call("getMethodHelp", methodName).get();
    }

    /**
    * Retrieves the module's description.
    * 
    * @return A structure describing the module.
    */
    public Object getModuleHelp() throws CallError, InterruptedException {
        return (Object)call("getModuleHelp").get();
    }

    /**
    * Wait for the end of a long running method that was called using 'post'
    * 
    * @param id  The ID of the method that was returned when calling the method using 'post'
    * @param timeoutPeriod  The timeout period in ms. To wait indefinately, use a timeoutPeriod of zero.
    * @return True if the timeout period terminated. False if the method returned.
    */
    public Boolean wait(Integer id, Integer timeoutPeriod) throws CallError, InterruptedException {
        return (Boolean)call("wait", id, timeoutPeriod).get();
    }

    /**
    * Returns true if the method is currently running.
    * 
    * @param id  The ID of the method that was returned when calling the method using 'post'
    * @return True if the method is currently running
    */
    public Boolean isRunning(Integer id) throws CallError, InterruptedException {
        return (Boolean)call("isRunning", id).get();
    }

    /**
    * returns true if the method is currently running
    * 
    * @param id  the ID of the method to wait for
    */
    public void stop(Integer id) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("stop", id);
        else
            call("stop", id).get();
    }

    /**
    * Gets the name of the parent broker.
    * 
    * @return The name of the parent broker.
    */
    public String getBrokerName() throws CallError, InterruptedException {
        return (String)call("getBrokerName").get();
    }

    /**
    * Gets the method usage string. This summarises how to use the method.
    * 
    * @param name  The name of the method.
    * @return A string that summarises the usage of the method.
    */
    public String getUsage(String name) throws CallError, InterruptedException {
        return (String)call("getUsage", name).get();
    }

    /**
    * The robot will wake up: set Motor ON and go to initial position if needed
    * 
    */
    public void wakeUp() throws CallError, InterruptedException{
        if (isAsynchronous)
            call("wakeUp");
        else
            call("wakeUp").get();
    }

    /**
    * The robot will rest: go to a relax and safe position and set Motor OFF
    * 
    */
    public void rest() throws CallError, InterruptedException{
        if (isAsynchronous)
            call("rest");
        else
            call("rest").get();
    }

    /**
    * The robot will rest: go to a relax and safe position on the chain and set Motor OFF
    * 
    */
    public void rest(String param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("rest", param1);
        else
            call("rest", param1).get();
    }

    /**
    * return true if the robot is already wakeUp
    * 
    * @return True if the robot is already wakeUp.
    */
    public Boolean robotIsWakeUp() throws CallError, InterruptedException {
        return (Boolean)call("robotIsWakeUp").get();
    }

    /**
    * Interpolates one or multiple joints to a target stiffness or along timed trajectories of stiffness. This is a blocking call.
    * 
    * @param names  Name or names of joints, chains, "Body", "JointActuators", "Joints" or "Actuators".
    * @param stiffnessLists  An stiffness, list of stiffnesses or list of list of stiffnesses
    * @param timeLists  A time, list of times or list of list of times.
    */
    public void stiffnessInterpolation(Object names, Object stiffnessLists, Object timeLists) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("stiffnessInterpolation", names, stiffnessLists, timeLists);
        else
            call("stiffnessInterpolation", names, stiffnessLists, timeLists).get();
    }

    /**
    * Sets the stiffness of one or more joints. This is a non-blocking call.
    * 
    * @param names  Names of joints, chains, "Body", "JointActuators", "Joints" or "Actuators".
    * @param stiffnesses  One or more stiffnesses between zero and one.
    */
    public void setStiffnesses(Object names, Object stiffnesses) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("setStiffnesses", names, stiffnesses);
        else
            call("setStiffnesses", names, stiffnesses).get();
    }

    /**
    * Gets stiffness of a joint or group of joints
    * 
    * @param jointName  Name of the joints, chains, "Body", "Joints" or "Actuators".
    * @return One or more stiffnesses. 1.0 indicates maximum stiffness. 0.0 indicated minimum stiffness
    */
    public List<Float> getStiffnesses(Object jointName) throws CallError, InterruptedException {
        return (List<Float>)call("getStiffnesses", jointName).get();
    }

    /**
    * Interpolates one or multiple joints to a target angle or along timed trajectories. This is a blocking call.
    * 
    * @param names  Name or names of joints, chains, "Body", "JointActuators", "Joints" or "Actuators". 
    * @param angleLists  An angle, list of angles or list of list of angles in radians
    * @param timeLists  A time, list of times or list of list of times in seconds
    * @param isAbsolute  If true, the movement is described in absolute angles, else the angles are relative to the current angle.
    */
    public void angleInterpolation(Object names, Object angleLists, Object timeLists, Boolean isAbsolute) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("angleInterpolation", names, angleLists, timeLists, isAbsolute);
        else
            call("angleInterpolation", names, angleLists, timeLists, isAbsolute).get();
    }

    /**
    * Interpolates one or multiple joints to a target angle, using a fraction of max speed. Only one target angle is allowed for each joint. This is a blocking call.
    * 
    * @param names  Name or names of joints, chains, "Body", "JointActuators", "Joints" or "Actuators".
    * @param targetAngles  An angle, or list of angles in radians
    * @param maxSpeedFraction  A fraction.
    */
    public void angleInterpolationWithSpeed(Object names, Object targetAngles, Float maxSpeedFraction) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("angleInterpolationWithSpeed", names, targetAngles, maxSpeedFraction);
        else
            call("angleInterpolationWithSpeed", names, targetAngles, maxSpeedFraction).get();
    }

    /**
    * Interpolates a sequence of timed angles for several motors using bezier control points. This is a blocking call.
    * 
    * @param jointNames  A vector of joint names
    * @param times  An ragged ALValue matrix of floats. Each line corresponding to a motor, and column element to a control point.
    * @param controlPoints  An ALValue array of arrays each containing [float angle, Handle1, Handle2], where Handle is [int InterpolationType, float dAngle, float dTime] descibing the handle offsets relative to the angle and time of the point. The first bezier param describes the handle that controls the curve preceeding the point, the second describes the curve following the point.
    */
    public void angleInterpolationBezier(List<String> jointNames, Object times, Object controlPoints) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("angleInterpolationBezier", jointNames, times, controlPoints);
        else
            call("angleInterpolationBezier", jointNames, times, controlPoints).get();
    }

    /**
    * Sets angles. This is a non-blocking call.
    * 
    * @param names  The name or names of joints, chains, "Body", "JointActuators", "Joints" or "Actuators". 
    * @param angles  One or more angles in radians
    * @param fractionMaxSpeed  The fraction of maximum speed to use
    */
    public void setAngles(Object names, Object angles, Float fractionMaxSpeed) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("setAngles", names, angles, fractionMaxSpeed);
        else
            call("setAngles", names, angles, fractionMaxSpeed).get();
    }

    /**
    * Changes Angles. This is a non-blocking call.
    * 
    * @param names  The name or names of joints, chains, "Body", "JointActuators", "Joints" or "Actuators".
    * @param changes  One or more changes in radians
    * @param fractionMaxSpeed  The fraction of maximum speed to use
    */
    public void changeAngles(Object names, Object changes, Float fractionMaxSpeed) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("changeAngles", names, changes, fractionMaxSpeed);
        else
            call("changeAngles", names, changes, fractionMaxSpeed).get();
    }

    /**
    * Gets the angles of the joints
    * 
    * @param names  Names the joints, chains, "Body", "JointActuators", "Joints" or "Actuators". 
    * @param useSensors  If true, sensor angles will be returned
    * @return Joint angles in radians.
    */
    public List<Float> getAngles(Object names, Boolean useSensors) throws CallError, InterruptedException {
        return (List<Float>)call("getAngles", names, useSensors).get();
    }

    /**
    * NAO stiffens the motors of desired hand. Then, he opens the hand, then cuts motor current to conserve energy. This is a blocking call.
    * 
    * @param handName  The name of the hand. Could be: "RHand or "LHand"
    */
    public void openHand(String handName) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("openHand", handName);
        else
            call("openHand", handName).get();
    }

    /**
    * NAO stiffens the motors of desired hand. Then, he closes the hand, then cuts motor current to conserve energy. This is a blocking call.
    * 
    * @param handName  The name of the hand. Could be: "RHand" or "LHand"
    */
    public void closeHand(String handName) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("closeHand", handName);
        else
            call("closeHand", handName).get();
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
            call("move", x, y, theta);
        else
            call("move", x, y, theta).get();
    }

    /**
    * Makes the robot move at the given velocity. This is a non-blocking call.
    * 
    * @param x  The velocity along x axis [m.s-1].
    * @param y  The velocity along y axis [m.s-1].
    * @param theta  The velocity around z axis [rd.s-1].
    * @param moveConfig  An ALValue with custom move configuration.
    */
    public void move(Float x, Float y, Float theta, Object moveConfig) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("move", x, y, theta, moveConfig);
        else
            call("move", x, y, theta, moveConfig).get();
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
            call("moveToward", x, y, theta);
        else
            call("moveToward", x, y, theta).get();
    }

    /**
    * Makes the robot move at the given normalized velocity. This is a non-blocking call.
    * 
    * @param x  The normalized velocity along x axis (between -1 and 1).
    * @param y  The normalized velocity along y axis (between -1 and 1).
    * @param theta  The normalized velocity around z axis (between -1 and 1).
    * @param moveConfig  An ALValue with custom move configuration.
    */
    public void moveToward(Float x, Float y, Float theta, Object moveConfig) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("moveToward", x, y, theta, moveConfig);
        else
            call("moveToward", x, y, theta, moveConfig).get();
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
            call("setWalkTargetVelocity", x, y, theta, frequency);
        else
            call("setWalkTargetVelocity", x, y, theta, frequency).get();
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
    public void setWalkTargetVelocity(Float x, Float y, Float theta, Float frequency, Object feetGaitConfig) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("setWalkTargetVelocity", x, y, theta, frequency, feetGaitConfig);
        else
            call("setWalkTargetVelocity", x, y, theta, frequency, feetGaitConfig).get();
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
    public void setWalkTargetVelocity(Float x, Float y, Float theta, Float frequency, Object leftFootMoveConfig, Object rightFootMoveConfig) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("setWalkTargetVelocity", x, y, theta, frequency, leftFootMoveConfig, rightFootMoveConfig);
        else
            call("setWalkTargetVelocity", x, y, theta, frequency, leftFootMoveConfig, rightFootMoveConfig).get();
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
            call("moveTo", x, y, theta);
        else
            call("moveTo", x, y, theta).get();
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
            call("moveTo", x, y, theta, time);
        else
            call("moveTo", x, y, theta, time).get();
    }

    /**
    * Makes the robot move at the given position. This is a non-blocking call.
    * 
    * @param x  The position along x axis [m].
    * @param y  The position along y axis [m].
    * @param theta  The position around z axis [rd].
    * @param moveConfig  An ALValue with custom move configuration.
    */
    public void moveTo(Float x, Float y, Float theta, Object moveConfig) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("moveTo", x, y, theta, moveConfig);
        else
            call("moveTo", x, y, theta, moveConfig).get();
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
    public void moveTo(Float x, Float y, Float theta, Float time, Object moveConfig) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("moveTo", x, y, theta, time, moveConfig);
        else
            call("moveTo", x, y, theta, time, moveConfig).get();
    }

    /**
    * Makes the robot move to the given relative positions. This is a blocking call.
    * 
    * @param controlPoint  An ALValue with the control points in FRAME_ROBOT.
Each control point is relative to the previous one. [[x1, y1, theta1], ..., [xN, yN, thetaN]
    */
    public void moveTo(Object controlPoint) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("moveTo", controlPoint);
        else
            call("moveTo", controlPoint).get();
    }

    /**
    * Makes the robot move to the given relative positions. This is a blocking call.
    * 
    * @param controlPoint  An ALValue with all the control points in FRAME_ROBOT.
Each control point is relative to the previous one. [[x1, y1, theta1], ..., [xN, yN, thetaN]
    * @param moveConfig  An ALValue with custom move configuration.
    */
    public void moveTo(Object controlPoint, Object moveConfig) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("moveTo", controlPoint, moveConfig);
        else
            call("moveTo", controlPoint, moveConfig).get();
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
            call("walkTo", x, y, theta);
        else
            call("walkTo", x, y, theta).get();
    }

    /**
    * DEPRECATED. Use moveTo() function instead.
    * 
    * @param x  Distance along the X axis in meters.
    * @param y  Distance along the Y axis in meters.
    * @param theta  Rotation around the Z axis in radians [-3.1415 to 3.1415].
    * @param feetGaitConfig  An ALValue with the custom gait configuration for both feet.
    */
    public void walkTo(Float x, Float y, Float theta, Object feetGaitConfig) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("walkTo", x, y, theta, feetGaitConfig);
        else
            call("walkTo", x, y, theta, feetGaitConfig).get();
    }

    /**
    * DEPRECATED. Use moveTo() function instead.
    * 
    * @param controlPoint  An ALValue with all the control point in NAO SPACE[[x1,y1,theta1], ..., [xN,yN,thetaN]
    */
    public void walkTo(Object controlPoint) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("walkTo", controlPoint);
        else
            call("walkTo", controlPoint).get();
    }

    /**
    * DEPRECATED. Use moveTo() function instead.
    * 
    * @param controlPoint  An ALValue with all the control point in NAO SPACE[[x1,y1,theta1], ..., [xN,yN,thetaN]
    * @param feetGaitConfig  An ALValue with the custom gait configuration for both feet
    */
    public void walkTo(Object controlPoint, Object feetGaitConfig) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("walkTo", controlPoint, feetGaitConfig);
        else
            call("walkTo", controlPoint, feetGaitConfig).get();
    }

    /**
    * Makes Nao do foot step planner. This is a non-blocking call.
    * 
    * @param legName  name of the leg to move('LLeg'or 'RLeg')
    * @param footSteps  [x, y, theta], [Position along X/Y, Orientation round Z axis] of the leg relative to the other Leg in [meters, meters, radians]. Must be less than [MaxStepX, MaxStepY, MaxStepTheta]
    * @param timeList  time list of each foot step
    * @param clearExisting  Clear existing foot steps.
    */
    public void setFootSteps(List<String> legName, Object footSteps, List<Float> timeList, Boolean clearExisting) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("setFootSteps", legName, footSteps, timeList, clearExisting);
        else
            call("setFootSteps", legName, footSteps, timeList, clearExisting).get();
    }

    /**
    * Makes Nao do foot step planner with speed. This is a blocking call.
    * 
    * @param legName  name of the leg to move('LLeg'or 'RLeg')
    * @param footSteps  [x, y, theta], [Position along X/Y, Orientation round Z axis] of the leg relative to the other Leg in [meters, meters, radians]. Must be less than [MaxStepX, MaxStepY, MaxStepTheta]
    * @param fractionMaxSpeed  speed of each foot step. Must be between 0 and 1.
    * @param clearExisting  Clear existing foot steps.
    */
    public void setFootStepsWithSpeed(List<String> legName, Object footSteps, List<Float> fractionMaxSpeed, Boolean clearExisting) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("setFootStepsWithSpeed", legName, footSteps, fractionMaxSpeed, clearExisting);
        else
            call("setFootStepsWithSpeed", legName, footSteps, fractionMaxSpeed, clearExisting).get();
    }

    /**
    * Get the foot steps. This is a non-blocking call.
    * 
    * @return Give two list of foot steps. The first one give the unchangeable foot step. The second list give the changeable foot steps. Il you use setFootSteps or setFootStepsWithSpeed with clearExisting parmater equal true, walk engine execute unchangeable foot step and remove the other.
    */
    public Object getFootSteps() throws CallError, InterruptedException {
        return (Object)call("getFootSteps").get();
    }

    /**
    * DEPRECATED. Use moveInit function instead.
    * 
    */
    public void walkInit() throws CallError, InterruptedException{
        if (isAsynchronous)
            call("walkInit");
        else
            call("walkInit").get();
    }

    /**
    * Initialize the move process. Check the robot pose and take a right posture. This is blocking called.
    * 
    */
    public void moveInit() throws CallError, InterruptedException{
        if (isAsynchronous)
            call("moveInit");
        else
            call("moveInit").get();
    }

    /**
    * DEPRECATED. Use waitUntilMoveIsFinished function instead.
    * 
    */
    public void waitUntilWalkIsFinished() throws CallError, InterruptedException{
        if (isAsynchronous)
            call("waitUntilWalkIsFinished");
        else
            call("waitUntilWalkIsFinished").get();
    }

    /**
    * Waits until the move process is finished: This method can be used to block your script/code execution until the move task is totally finished.
    * 
    */
    public void waitUntilMoveIsFinished() throws CallError, InterruptedException{
        if (isAsynchronous)
            call("waitUntilMoveIsFinished");
        else
            call("waitUntilMoveIsFinished").get();
    }

    /**
    * DEPRECATED. Use moveIsActive function instead.
    * 
    */
    public Boolean walkIsActive() throws CallError, InterruptedException {
        return (Boolean)call("walkIsActive").get();
    }

    /**
    * Check if the move process is actif.
    * 
    * @return True if move is active
    */
    public Boolean moveIsActive() throws CallError, InterruptedException {
        return (Boolean)call("moveIsActive").get();
    }

    /**
    * DEPRECATED. Use stopMove function instead.
    * 
    */
    public void stopWalk() throws CallError, InterruptedException{
        if (isAsynchronous)
            call("stopWalk");
        else
            call("stopWalk").get();
    }

    /**
    * Stop Move task safely as fast as possible. The move task is ended less brutally than killMove but more quickly than move(0.0, 0.0, 0.0).
This is a blocking call.
    * 
    */
    public void stopMove() throws CallError, InterruptedException{
        if (isAsynchronous)
            call("stopMove");
        else
            call("stopMove").get();
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
    public Object getFootGaitConfig(String config) throws CallError, InterruptedException {
        return (Object)call("getFootGaitConfig", config).get();
    }

    /**
    * Gets the move config.
    * 
    * @param config  a string should be "Max", "Min", "Default"
    * @return An ALvalue with the move config
    */
    public Object getMoveConfig(String config) throws CallError, InterruptedException {
        return (Object)call("getMoveConfig", config).get();
    }

    /**
    * Gets the World Absolute Robot Position.
    * 
    * @param useSensors  If true, use the sensor values
    * @return A vector containing the World Absolute Robot Position. (Absolute Position X, Absolute Position Y, Absolute Angle Z)
    */
    public List<Float> getRobotPosition(Boolean useSensors) throws CallError, InterruptedException {
        return (List<Float>)call("getRobotPosition", useSensors).get();
    }

    /**
    * Gets the World Absolute next Robot Position.
In fact in the walk algorithm some foot futur foot step are incompressible due to preview control, so this function give the next robot position which is incompressible.
If the robot doesn't walk this function is equivalent to getRobotPosition(false)

    * 
    * @return A vector containing the World Absolute next Robot position.(Absolute Position X, Absolute Position Y, Absolute Angle Z)
    */
    public List<Float> getNextRobotPosition() throws CallError, InterruptedException {
        return (List<Float>)call("getNextRobotPosition").get();
    }

    /**
    * Gets the World Absolute Robot Velocity.
    * 
    * @return A vector containing the World Absolute Robot Velocity. (Absolute Velocity Translation X [m.s-1], Absolute Velocity Translation Y[m.s-1], Absolute Velocity Rotation WZ [rd.s-1])
    */
    public List<Float> getRobotVelocity() throws CallError, InterruptedException {
        return (List<Float>)call("getRobotVelocity").get();
    }

    /**
    * DEPRECATED. Gets if Arms Motions are enabled during the Walk Process.
    * 
    * @return True Arm Motions are controlled by the Walk Task.
    */
    public Object getWalkArmsEnabled() throws CallError, InterruptedException {
        return (Object)call("getWalkArmsEnabled").get();
    }

    /**
    * DEPRECATED. Sets if Arms Motions are enabled during the Walk Process.
    * 
    * @param leftArmEnabled  if true Left Arm motions are controlled by the Walk Task
    * @param rightArmEnabled  if true Right Arm mMotions are controlled by the Walk Task
    */
    public void setWalkArmsEnabled(Boolean leftArmEnabled, Boolean rightArmEnabled) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("setWalkArmsEnabled", leftArmEnabled, rightArmEnabled);
        else
            call("setWalkArmsEnabled", leftArmEnabled, rightArmEnabled).get();
    }

    /**
    * Gets if Arms Motions are enabled during the Move Process.
    * 
    * @param chainName  Name of the chain. Could be: "LArm", "RArm" or "Arms"
    * @return For LArm and RArm true if the corresponding arm is enabled. For Arms, true if both are enabled. False otherwise.
    */
    public Boolean getMoveArmsEnabled(String chainName) throws CallError, InterruptedException {
        return (Boolean)call("getMoveArmsEnabled", chainName).get();
    }

    /**
    * Sets if Arms Motions are enabled during the Move Process.
    * 
    * @param leftArmEnabled  if true Left Arm motions are controlled by the Move Task
    * @param rightArmEnabled  if true Right Arm mMotions are controlled by the Move Task
    */
    public void setMoveArmsEnabled(Boolean leftArmEnabled, Boolean rightArmEnabled) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("setMoveArmsEnabled", leftArmEnabled, rightArmEnabled);
        else
            call("setMoveArmsEnabled", leftArmEnabled, rightArmEnabled).get();
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
    public void positionInterpolation(String chainName, Integer space, Object path, Integer axisMask, Object durations, Boolean isAbsolute) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("positionInterpolation", chainName, space, path, axisMask, durations, isAbsolute);
        else
            call("positionInterpolation", chainName, space, path, axisMask, durations, isAbsolute).get();
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
    public void positionInterpolations(List<String> effectorNames, Integer taskSpaceForAllPaths, Object paths, Object axisMasks, Object relativeTimes, Boolean isAbsolute) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("positionInterpolations", effectorNames, taskSpaceForAllPaths, paths, axisMasks, relativeTimes, isAbsolute);
        else
            call("positionInterpolations", effectorNames, taskSpaceForAllPaths, paths, axisMasks, relativeTimes, isAbsolute).get();
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
    public void positionInterpolations(Object effectorNames, Object taskSpaceForAllPaths, Object paths, Object axisMasks, Object relativeTimes) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("positionInterpolations", effectorNames, taskSpaceForAllPaths, paths, axisMasks, relativeTimes);
        else
            call("positionInterpolations", effectorNames, taskSpaceForAllPaths, paths, axisMasks, relativeTimes).get();
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
            call("setPosition", chainName, space, position, fractionMaxSpeed, axisMask);
        else
            call("setPosition", chainName, space, position, fractionMaxSpeed, axisMask).get();
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
    public void setPositions(Object names, Object spaces, Object positions, Float fractionMaxSpeed, Object axisMask) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("setPositions", names, spaces, positions, fractionMaxSpeed, axisMask);
        else
            call("setPositions", names, spaces, positions, fractionMaxSpeed, axisMask).get();
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
            call("changePosition", effectorName, space, positionChange, fractionMaxSpeed, axisMask);
        else
            call("changePosition", effectorName, space, positionChange, fractionMaxSpeed, axisMask).get();
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
        return (List<Float>)call("getPosition", name, space, useSensorValues).get();
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
    public void transformInterpolation(String chainName, Integer space, Object path, Integer axisMask, Object duration, Boolean isAbsolute) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("transformInterpolation", chainName, space, path, axisMask, duration, isAbsolute);
        else
            call("transformInterpolation", chainName, space, path, axisMask, duration, isAbsolute).get();
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
    public void transformInterpolations(List<String> effectorNames, Integer taskSpaceForAllPaths, Object paths, Object axisMasks, Object relativeTimes, Boolean isAbsolute) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("transformInterpolations", effectorNames, taskSpaceForAllPaths, paths, axisMasks, relativeTimes, isAbsolute);
        else
            call("transformInterpolations", effectorNames, taskSpaceForAllPaths, paths, axisMasks, relativeTimes, isAbsolute).get();
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
    public void transformInterpolations(Object effectorNames, Object taskSpaceForAllPaths, Object paths, Object axisMasks, Object relativeTimes) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("transformInterpolations", effectorNames, taskSpaceForAllPaths, paths, axisMasks, relativeTimes);
        else
            call("transformInterpolations", effectorNames, taskSpaceForAllPaths, paths, axisMasks, relativeTimes).get();
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
            call("setTransform", chainName, space, transform, fractionMaxSpeed, axisMask);
        else
            call("setTransform", chainName, space, transform, fractionMaxSpeed, axisMask).get();
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
    public void setTransforms(Object names, Object spaces, Object transforms, Float fractionMaxSpeed, Object axisMask) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("setTransforms", names, spaces, transforms, fractionMaxSpeed, axisMask);
        else
            call("setTransforms", names, spaces, transforms, fractionMaxSpeed, axisMask).get();
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
            call("changeTransform", chainName, space, transform, fractionMaxSpeed, axisMask);
        else
            call("changeTransform", chainName, space, transform, fractionMaxSpeed, axisMask).get();
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
        return (List<Float>)call("getTransform", name, space, useSensorValues).get();
    }

    /**
    * UserFriendly Whole Body API: enable Whole Body Balancer. It's a Generalized Inverse Kinematics which deals with cartesian control, balance, redundancy and task priority. The main goal is to generate and stabilized consistent motions without precomputed trajectories and adapt nao's behaviour to the situation. The generalized inverse kinematic problem takes in account equality constraints (keep foot fix), inequality constraints (joint limits, balance, ...) and quadratic minimization (cartesian / articular desired trajectories). We solve each step a quadratic programming on the robot.
    * 
    * @param isEnabled  Active / Disactive Whole Body Balancer.
    */
    public void wbEnable(Boolean isEnabled) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("wbEnable", isEnabled);
        else
            call("wbEnable", isEnabled).get();
    }

    /**
    * UserFriendly Whole Body API: set the foot state: fixed foot, constrained in a plane or free.
    * 
    * @param stateName  Name of the foot state. "Fixed" set the foot fixed. "Plane" constrained the Foot in the plane. "Free" set the foot free.
    * @param supportLeg  Name of the foot. "LLeg", "RLeg" or "Legs".
    */
    public void wbFootState(String stateName, String supportLeg) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("wbFootState", stateName, supportLeg);
        else
            call("wbFootState", stateName, supportLeg).get();
    }

    /**
    * UserFriendly Whole Body API: enable to keep balance in support polygon.
    * 
    * @param isEnable  Enable Nao to keep balance.
    * @param supportLeg  Name of the support leg: "Legs", "LLeg", "RLeg".
    */
    public void wbEnableBalanceConstraint(Boolean isEnable, String supportLeg) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("wbEnableBalanceConstraint", isEnable, supportLeg);
        else
            call("wbEnableBalanceConstraint", isEnable, supportLeg).get();
    }

    /**
    * Advanced Whole Body API: "Com" go to a desired support polygon. This is a blocking call.
    * 
    * @param supportLeg  Name of the support leg: "Legs", "LLeg", "RLeg".
    * @param duration  Time in seconds. Must be upper 0.5 s.
    */
    public void wbGoToBalance(String supportLeg, Float duration) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("wbGoToBalance", supportLeg, duration);
        else
            call("wbGoToBalance", supportLeg, duration).get();
    }

    /**
    * UserFriendly Whole Body API: enable whole body cartesian control of an effector.
    * 
    * @param effectorName  Name of the effector : "Head", "LArm" or "RArm". Nao goes to posture init. He manages his balance and keep foot fix. "Head" is controlled in rotation. "LArm" and "RArm" are controlled in position.
    * @param isEnabled  Active / Disactive Effector Control.
    */
    public void wbEnableEffectorControl(String effectorName, Boolean isEnabled) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("wbEnableEffectorControl", effectorName, isEnabled);
        else
            call("wbEnableEffectorControl", effectorName, isEnabled).get();
    }

    /**
    * UserFriendly Whole Body API: set new target for controlled effector. This is a non-blocking call.
    * 
    * @param effectorName  Name of the effector : "Head", "LArm" or "RArm". Nao goes to posture init. He manages his balance and keep foot fix. "Head" is controlled in rotation. "LArm" and "RArm" are controlled in position.
    * @param targetCoordinate  "Head" is controlled in rotation (WX, WY, WZ). "LArm" and "RArm" are controlled in position (X, Y, Z). TargetCoordinate must be absolute and expressed in FRAME_ROBOT. If the desired position/orientation is unfeasible, target is resize to the nearest feasible motion.
    */
    public void wbSetEffectorControl(String effectorName, Object targetCoordinate) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("wbSetEffectorControl", effectorName, targetCoordinate);
        else
            call("wbSetEffectorControl", effectorName, targetCoordinate).get();
    }

    /**
    * Advanced Whole Body API: enable to control an effector as an optimization.
    * 
    * @param effectorName  Name of the effector : "All", "Arms", "Legs", "Head", "LArm", "RArm", "LLeg", "RLeg", "Torso", "Com".
    * @param isActive  if true, the effector control is taken in acount in the optimization criteria.
    */
    public void wbEnableEffectorOptimization(String effectorName, Boolean isActive) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("wbEnableEffectorOptimization", effectorName, isActive);
        else
            call("wbEnableEffectorOptimization", effectorName, isActive).get();
    }

    /**
    * Enable Anticollision protection of the arms of the robot. Use api isCollision to know if a chain is in collision and can be disactivated.
    * 
    * @param pChainName  The chain name {"Arms", "LArm" or "RArm"}.
    * @param pEnable  Activate or disactivate the anticollision of the desired Chain.
    * @return A bool which return always true.
    */
    public Boolean setCollisionProtectionEnabled(String pChainName, Boolean pEnable) throws CallError, InterruptedException {
        return (Boolean)call("setCollisionProtectionEnabled", pChainName, pEnable).get();
    }

    /**
    * Allow to know if the collision protection is activated on the given chain.
    * 
    * @param pChainName  The chain name {"LArm" or "RArm"}.
    * @return Return true is the collision protection of the given Arm is activated.
    */
    public Boolean getCollisionProtectionEnabled(String pChainName) throws CallError, InterruptedException {
        return (Boolean)call("getCollisionProtectionEnabled", pChainName).get();
    }

    /**
    * Enable Anticollision protection of the arms and base move  of the robot with external environment.
    * 
    * @param pName  The name {"All", "Move", "Arms", "LArm" or "RArm"}.
    * @param pEnable  Activate or disactivate the anticollision of the desired name.
    */
    public void setExternalCollisionProtectionEnabled(String pName, Boolean pEnable) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("setExternalCollisionProtectionEnabled", pName, pEnable);
        else
            call("setExternalCollisionProtectionEnabled", pName, pEnable).get();
    }

    /**
    * Gets chain closest obstacle Position .
    * 
    * @param pName  The Chain name {"LArm" or "RArm"}.
    * @param space  Task frame {FRAME_TORSO = 0, FRAME_WORLD = 1, FRAME_ROBOT = 2}.
    * @return Vector containing the Position3D in meters (x, y, z)
    */
    public List<Float> getChainClosestObstaclePosition(String pName, Integer space) throws CallError, InterruptedException {
        return (List<Float>)call("getChainClosestObstaclePosition", pName, space).get();
    }

    /**
    * Allow to know if the external collision protection is activated on the given name.
    * 
    * @param pName  The name {"All", "Move", "Arms", "LArm" or "RArm"}.
    * @return Return true is the external collision protection of the given name is activated.
    */
    public Boolean getExternalCollisionProtectionEnabled(String pName) throws CallError, InterruptedException {
        return (Boolean)call("getExternalCollisionProtectionEnabled", pName).get();
    }

    /**
    * Defines the orthogonal security distance used with external collision protection "Move".
    * 
    * @param securityDistance  The orthogonal security distance.
    */
    public void setOrthogonalSecurityDistance(Float securityDistance) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("setOrthogonalSecurityDistance", securityDistance);
        else
            call("setOrthogonalSecurityDistance", securityDistance).get();
    }

    /**
    * Gets the current orthogonal security distance.
    * 
    * @return The current orthogonal security distance.
    */
    public Float getOrthogonalSecurityDistance() throws CallError, InterruptedException {
        return (Float)call("getOrthogonalSecurityDistance").get();
    }

    /**
    * Defines the tangential security distance used with external collision protection "Move".
    * 
    * @param securityDistance  The tangential security distance.
    */
    public void setTangentialSecurityDistance(Float securityDistance) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("setTangentialSecurityDistance", securityDistance);
        else
            call("setTangentialSecurityDistance", securityDistance).get();
    }

    /**
    * Gets the current tangential security distance.
    * 
    * @return The current tangential security distance.
    */
    public Float getTangentialSecurityDistance() throws CallError, InterruptedException {
        return (Float)call("getTangentialSecurityDistance").get();
    }

    /**
    * Give the collision state of a chain. If a chain has a collision state "none" or "near", it could be desactivated. 
    * 
    * @param pChainName  The chain name {"Arms", "LArm" or "RArm"}.
    * @return A string which notice the collision state: "none" there are no collision, "near" the collision is taking in account in the anti-collision algorithm, "collision" the chain is in contact with an other body. If the chain asked is "Arms" the most unfavorable result is given. 

    */
    public String isCollision(String pChainName) throws CallError, InterruptedException {
        return (String)call("isCollision", pChainName).get();
    }

    /**
    * Enable The fall manager protection for the robot. When a fall is detected the robot adopt a joint configuration to protect himself and cut the stiffness.
. An memory event called "robotHasFallen" is generated when the fallManager have been activated.
    * 
    * @param pEnable  Activate or disactivate the smart stiffness.
    */
    public void setFallManagerEnabled(Boolean pEnable) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("setFallManagerEnabled", pEnable);
        else
            call("setFallManagerEnabled", pEnable).get();
    }

    /**
    * Give the state of the fall manager.
    * 
    * @return Return true is the fall manager is activated. 

    */
    public Boolean getFallManagerEnabled() throws CallError, InterruptedException {
        return (Boolean)call("getFallManagerEnabled").get();
    }

    /**
    * Enable The push recovery protection for the robot. 
    * 
    * @param pEnable  Enable the push recovery.
    */
    public void setPushRecoveryEnabled(Boolean pEnable) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("setPushRecoveryEnabled", pEnable);
        else
            call("setPushRecoveryEnabled", pEnable).get();
    }

    /**
    * Give the state of the push recovery.
    * 
    * @return Return true is the push recovery is activated. 

    */
    public Boolean getPushRecoveryEnabled() throws CallError, InterruptedException {
        return (Boolean)call("getPushRecoveryEnabled").get();
    }

    /**
    * Enable Smart Stiffness for all the joints (True by default), the update take one motion cycle for updating. The smart Stiffness is a gestion of joint maximum torque. More description is available on the red documentation of ALMotion module.
    * 
    * @param pEnable  Activate or disactivate the smart stiffness.
    */
    public void setSmartStiffnessEnabled(Boolean pEnable) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("setSmartStiffnessEnabled", pEnable);
        else
            call("setSmartStiffnessEnabled", pEnable).get();
    }

    /**
    * Give the state of the smart Stiffness.
    * 
    * @return Return true is the smart Stiffnes is activated. 

    */
    public Boolean getSmartStiffnessEnabled() throws CallError, InterruptedException {
        return (Boolean)call("getSmartStiffnessEnabled").get();
    }

    /**
    * Enable or disable the diagnosis effect into ALMotion
    * 
    * @param pEnable  Enable or disable the diagnosis effect.
    */
    public void setDiagnosisEffectEnabled(Boolean pEnable) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("setDiagnosisEffectEnabled", pEnable);
        else
            call("setDiagnosisEffectEnabled", pEnable).get();
    }

    /**
    * Give the state of the diagnosis effect.
    * 
    * @return Return true is the diagnosis reflex is activated. 

    */
    public Boolean getDiagnosisEffectEnabled() throws CallError, InterruptedException {
        return (Boolean)call("getDiagnosisEffectEnabled").get();
    }

    /**
    * DEPRECATED. Use getBodyNames function instead.
    * 
    * @param name  Name of a chain, "Arms", "Legs", "Body", "Chains", "JointActuators", "Joints" or "Actuators".
    * @return Vector of strings, one for each joint in the collection
    */
    public List<String> getJointNames(String name) throws CallError, InterruptedException {
        return (List<String>)call("getJointNames", name).get();
    }

    /**
    * Gets the names of all the joints and actuators in the collection.
    * 
    * @param name  Name of a chain, "Arms", "Legs", "Body", "Chains", "JointActuators", "Joints" or "Actuators".
    * @return Vector of strings, one for each joint and actuator in the collection
    */
    public List<String> getBodyNames(String name) throws CallError, InterruptedException {
        return (List<String>)call("getBodyNames", name).get();
    }

    /**
    * Gets the list of sensors supported on your robot.
    * 
    * @return Vector of sensor names
    */
    public List<String> getSensorNames() throws CallError, InterruptedException {
        return (List<String>)call("getSensorNames").get();
    }

    /**
    * Get the minAngle (rad), maxAngle (rad), and maxVelocity (rad.s-1) for a given joint or actuator in the body.
    * 
    * @param name  Name of a joint, chain, "Body", "JointActuators", "Joints" or "Actuators". 
    * @return Array of ALValue arrays containing the minAngle, maxAngle, maxVelocity and maxTorque for all the bodies specified.
    */
    public Object getLimits(String name) throws CallError, InterruptedException {
        return (Object)call("getLimits", name).get();
    }

    /**
    * Get the motion cycle time in milliseconds.
    * 
    * @return Expressed in milliseconds
    */
    public Integer getMotionCycleTime() throws CallError, InterruptedException {
        return (Integer)call("getMotionCycleTime").get();
    }

    /**
    * Get the robot configuration.
    * 
    * @return ALValue arrays containing the robot parameter names and the robot parameter values.
    */
    public Object getRobotConfig() throws CallError, InterruptedException {
        return (Object)call("getRobotConfig").get();
    }

    /**
    * Returns a string representation of the Model's state
    * 
    * @return A formated string
    */
    public String getSummary() throws CallError, InterruptedException {
        return (String)call("getSummary").get();
    }

    /**
    * Gets the mass of a joint, chain, "Body" or "Joints".
    * 
    * @param pName  Name of the body which we want the mass. "Body", "Joints" and "Com" give the total mass of nao. For the chain, it gives the total mass of the chain.
    * @return The mass in kg.
    */
    public Float getMass(String pName) throws CallError, InterruptedException {
        return (Float)call("getMass", pName).get();
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
        return (List<Float>)call("getCOM", pName, pSpace, pUseSensorValues).get();
    }

    /**
    * Internal Use.
    * 
    * @param config  Internal: An array of ALValues [i][0]: name, [i][1]: value
    */
    public void setMotionConfig(Object config) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("setMotionConfig", config);
        else
            call("setMotionConfig", config).get();
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
            call("updateTrackerTarget", pTargetPositionWy, pTargetPositionWz, pTimeSinceDetectionMs, pUseOfWholeBody);
        else
            call("updateTrackerTarget", pTargetPositionWy, pTargetPositionWz, pTimeSinceDetectionMs, pUseOfWholeBody).get();
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
            call("setBreathEnabled", pChain, pIsEnabled);
        else
            call("setBreathEnabled", pChain, pIsEnabled).get();
    }

    /**
    * This function gets the status of breathing animation on a chain.
Chain name can be "Body", "Arms", "LArm", "RArm", "Legs" or "Head".

    * 
    * @param pChain  Chain name.
    * @return True if breathing animation is enabled on the chain.
    */
    public Boolean getBreathEnabled(String pChain) throws CallError, InterruptedException {
        return (Boolean)call("getBreathEnabled", pChain).get();
    }

    /**
    * This function configures the breathing animation.
    * 
    * @param pConfig  Breath configuration.
An ALValue of the form [["Bpm", pBpm], ["Amplitude", pAmplitude]].
pBpm is a float between 10 and 50 setting the breathing frequency in beats per minute.
pAmplitude is a float between 0 and 1 setting the amplitude of the breathing animation.
    */
    public void setBreathConfig(Object pConfig) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("setBreathConfig", pConfig);
        else
            call("setBreathConfig", pConfig).get();
    }

    /**
    * This function gets the current breathing configuration.
    * 
    * @return An ALValue of the form [["Bpm", bpm], ["Amplitude", amplitude]].
bpm is the breathing frequency in beats per minute.
amplitude is the normalized amplitude of the breathing animation, between 0 and 1.
    */
    public Object getBreathConfig() throws CallError, InterruptedException {
        return (Object)call("getBreathConfig").get();
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
            call("setIdlePostureEnabled", pChain, pIsEnabled);
        else
            call("setIdlePostureEnabled", pChain, pIsEnabled).get();
    }

    /**
    * This function gets the status of idle posture management on a chain.
Chain name can be "Body", "Arms", "LArm", "RArm", "Legs" or "Head".

    * 
    * @param pChain  Chain name.
    * @return True if breathing animation is enabled on the chain.
    */
    public Boolean getIdlePostureEnabled(String pChain) throws CallError, InterruptedException {
        return (Boolean)call("getIdlePostureEnabled", pChain).get();
    }

    /**
    * Gets an ALValue structure describing the tasks in the Task List
    * 
    * @return An ALValue containing an ALValue for each task. The inner ALValue contains: Name, MotionID
    */
    public Object getTaskList() throws CallError, InterruptedException {
        return (Object)call("getTaskList").get();
    }

    /**
    * Returns true if all the desired resources are available. Only motion API's' blocking call takes resources.
    * 
    * @param resourceNames  A vector of resource names such as joints. Use getBodyNames("Body") to have the list of the available joint for your robot.
    * @return True if the resources are available
    */
    public Boolean areResourcesAvailable(List<String> resourceNames) throws CallError, InterruptedException {
        return (Boolean)call("areResourcesAvailable", resourceNames).get();
    }

    /**
    * Kills a motion task.
    * 
    * @param motionTaskID  TaskID of the motion task you want to kill.
    * @return Return true if the specified motionTaskId has been killed.
    */
    public Boolean killTask(Integer motionTaskID) throws CallError, InterruptedException {
        return (Boolean)call("killTask", motionTaskID).get();
    }

    /**
    * Kills all tasks that use any of the resources given. Only motion API's' blocking call takes resources and can be killed. Use getBodyNames("Body") to have the list of the available joint for your robot.
    * 
    * @param resourceNames  A vector of resource joint names
    */
    public void killTasksUsingResources(List<String> resourceNames) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("killTasksUsingResources", resourceNames);
        else
            call("killTasksUsingResources", resourceNames).get();
    }

    /**
    * DEPRECATED. Use killMove function instead.
    * 
    */
    public void killWalk() throws CallError, InterruptedException{
        if (isAsynchronous)
            call("killWalk");
        else
            call("killWalk").get();
    }

    /**
    * Emergency Stop on Move task: This method will end the move task brutally, without attempting to return to a balanced state. The robot could easily fall.
    * 
    */
    public void killMove() throws CallError, InterruptedException{
        if (isAsynchronous)
            call("killMove");
        else
            call("killMove").get();
    }

    /**
    * Kills all tasks.
    * 
    */
    public void killAll() throws CallError, InterruptedException{
        if (isAsynchronous)
            call("killAll");
        else
            call("killAll").get();
    }

    /**
    * Enable / Disable notifications.
    * 
    * @param enable  If True enable notifications. If False disable notifications.
    */
    public void setEnableNotifications(Boolean enable) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("setEnableNotifications", enable);
        else
            call("setEnableNotifications", enable).get();
    }

    /**
    * Return true if notifications are active.
    * 
    * @return Return True if notifications are active.
    */
    public Boolean areNotificationsEnabled() throws CallError, InterruptedException {
        return (Boolean)call("areNotificationsEnabled").get();
    }

}
    