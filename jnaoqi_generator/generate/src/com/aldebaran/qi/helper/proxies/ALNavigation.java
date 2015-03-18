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
* Use ALNavigation module to make the robot go safely to the asked pose2D.
* @see <a href="http://doc.aldebaran.lan/doc/release-2.1/aldeb-doc/naoqi/motion/alnavigation.html#alnavigation">NAOqi APIs for ALNavigation </a>
*
*/
public class ALNavigation extends ALProxy {

    public ALNavigation(Session session) throws Exception{
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
    * Makes the robot navigate to a relative metrical target pose2D expressed in FRAME_ROBOT. The robot computes a path to avoid obstacles.
    * 
    * @param x  The position along x axis [m].
    * @param y  The position along y axis [m].
    */
    public Boolean navigateTo(Float x, Float y) throws CallError, InterruptedException {
        return (Boolean)call("navigateTo", x, y).get();
    }

    /**
    * Makes the robot navigate to a relative metrical target pose2D expressed in FRAME_ROBOT. The robot computes a path to avoid obstacles.
    * 
    * @param x  The position along x axis [m].
    * @param y  The position along y axis [m].
    * @param config  Configuration ALValue. For example, [["SpeedFactor", 0.5]] sets speedFactor to 0.5
    */
    public Boolean navigateTo(Float x, Float y, Object config) throws CallError, InterruptedException {
        return (Boolean)call("navigateTo", x, y, config).get();
    }

    /**
    * Makes the robot navigate to a relative metrical target pose2D expressed in FRAME_ROBOT. The robot computes a path to avoid obstacles.
    * 
    * @param x  The position along x axis [m].
    * @param y  The position along y axis [m].
    * @param theta  Orientation of the robot (rad).
    */
    public Boolean navigateTo(Float x, Float y, Float theta) throws CallError, InterruptedException {
        return (Boolean)call("navigateTo", x, y, theta).get();
    }

    /**
    * Makes the robot navigate to a relative metrical target pose2D expressed in FRAME_ROBOT. The robot computes a path to avoid obstacles.
    * 
    * @param x  The position along x axis [m].
    * @param y  The position along y axis [m].
    * @param theta  Orientation of the robot (rad).
    * @param config  Configuration ALValue. For example, [["SpeedFactor", 0.5]] sets speedFactor to 0.5
    */
    public Boolean navigateTo(Float x, Float y, Float theta, Object config) throws CallError, InterruptedException {
        return (Boolean)call("navigateTo", x, y, theta, config).get();
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
            call("moveTo", x, y, theta);
        else
            call("moveTo", x, y, theta).get();
    }

    /**
    * Makes the robot move at the given position.This is a blocking call.
    * 
    * @param x  The position along x axis [m].
    * @param y  The position along y axis [m].
    * @param theta  The angle around z axis [rad].
    * @param moveConfig  An ALValue with custom move configuration.
    */
    public void moveTo(Float x, Float y, Float theta, Object moveConfig) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("moveTo", x, y, theta, moveConfig);
        else
            call("moveTo", x, y, theta, moveConfig).get();
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
            call("move", x, y, theta);
        else
            call("move", x, y, theta).get();
    }

    /**
    * Makes the robot move at the given speed in S.I. units. This is a blocking call.
    * 
    * @param x  The speed along x axis [m.s-1].
    * @param y  The speed along y axis [m.s-1].
    * @param theta  The anglular speed around z axis [rad.s-1].
    * @param moveConfig  An ALValue with custom move configuration.
    */
    public void move(Float x, Float y, Float theta, Object moveConfig) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("move", x, y, theta, moveConfig);
        else
            call("move", x, y, theta, moveConfig).get();
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
            call("moveToward", x, y, theta);
        else
            call("moveToward", x, y, theta).get();
    }

    /**
    * Makes the robot move at the given speed in normalized speed fraction. This is a blocking call.
    * 
    * @param x  The speed along x axis [0.0-1.0].
    * @param y  The speed along y axis [0.0-1.0].
    * @param theta  The anglular speed around z axis [0.0-1.0].
    * @param moveConfig  An ALValue with custom move configuration.
    */
    public void moveToward(Float x, Float y, Float theta, Object moveConfig) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("moveToward", x, y, theta, moveConfig);
        else
            call("moveToward", x, y, theta, moveConfig).get();
    }

    /**
    * Distance in meters fromwhich the robot should stop if there is an obstacle.
    * 
    */
    public void setSecurityDistance(Float param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("setSecurityDistance", param1);
        else
            call("setSecurityDistance", param1).get();
    }

    /**
    * Distance in meters fromwhich the robot should stop if there is an obstacle.
    * 
    */
    public Float getSecurityDistance() throws CallError, InterruptedException {
        return (Float)call("getSecurityDistance").get();
    }

    /**
    * Stops the navigateTo.
    * 
    */
    public void stopNavigateTo() throws CallError, InterruptedException{
        if (isAsynchronous)
            call("stopNavigateTo");
        else
            call("stopNavigateTo").get();
    }

    /**
    * .
    * 
    * @param trajectory  An ALValue describing a trajectory.
    */
    public Boolean moveAlong(Object trajectory) throws CallError, InterruptedException {
        return (Boolean)call("moveAlong", trajectory).get();
    }

    /**
    * .
    * 
    */
    public void onTouchChanged(String param1, Object param2, String param3) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("onTouchChanged", param1, param2, param3);
        else
            call("onTouchChanged", param1, param2, param3).get();
    }

}
    