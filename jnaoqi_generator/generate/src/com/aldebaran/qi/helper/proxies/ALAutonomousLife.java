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
import java.util.Map;
import com.aldebaran.qi.*;

import java.util.List;
/**
* Manages the focused Activity and Autonomous Life state
* @see <a href="http://doc.aldebaran.lan/doc/release-2.1/aldeb-doc/naoqi/core/autonomouslife.html#autonomouslife">NAOqi APIs for ALAutonomousLife </a>
*
*/
public class ALAutonomousLife extends ALProxy {

    public ALAutonomousLife(Session session) {
        super(session);
    }

    /**
    * Stops the focused activity and clears stack of activities
    * 
    */
    public void stopAll() throws CallError, InterruptedException{
        if (isAsynchronous)
            call("stopAll");
        else
            call("stopAll").get();
    }

    /**
    * Get a list of the order that states that have been entered, and their time entered.
    * 
    * @return A list of pairs, each pair is StateName/PreviousEnteredTime
    */
    public List<Tuple2<String, Integer>> getStateHistory() throws CallError, InterruptedException {
        return (List<Tuple2<String, Integer>>)call("getStateHistory").get();
    }

    /**
    * Returns the currently focused activity
    * 
    * @return The name of the focused activity
    */
    public String focusedActivity() throws CallError, InterruptedException {
        return (String)call("focusedActivity").get();
    }

    /**
    * Get a list of the order that states that have been entered, and their time entered.
    * 
    * @param depth  How many items of history to report, starting from most recent.
    * @return A list of pairs, each pair is StateName/PreviousEnteredTime
    */
    public List<Tuple2<String, Integer>> getStateHistory(Integer depth) throws CallError, InterruptedException {
        return (List<Tuple2<String, Integer>>)call("getStateHistory", depth).get();
    }

    /**
    * Get the time in seconds as life sees it.  Based on gettimeofday()
    * 
    * @return The int time in seconds as Autonomous Life sees it
    */
    public Integer getLifeTime() throws CallError, InterruptedException {
        return (Integer)call("getLifeTime").get();
    }

    /**
    * Set an activity as running with user focus
    * 
    * @param activity_name  The package_name/activity_name to run
    * @param flags  Flags for focus changing. STOP_CURRENT or STOP_AND_STACK_CURRENT
    */
    public void switchFocus(String activity_name, Integer flags) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("switchFocus", activity_name, flags);
        else
            call("switchFocus", activity_name, flags).get();
    }

    /**
    * Stop monitoring ALMemory and reporting conditional triggers with AutonomousLaunchpad.
    * 
    */
    public void stopMonitoringLaunchpadConditions() throws CallError, InterruptedException{
        if (isAsynchronous)
            call("stopMonitoringLaunchpadConditions");
        else
            call("stopMonitoringLaunchpadConditions").get();
    }

    /**
    * Gets running status of AutonomousLaunchpad
    * 
    * @return True if AutonomousLaunchpad is monitoring ALMemory and reporting conditional triggers.
    */
    public Boolean isMonitoringLaunchpadConditions() throws CallError, InterruptedException {
        return (Boolean)call("isMonitoringLaunchpadConditions").get();
    }

    /**
    * Temporarily enables/disables AutonomousLaunchpad Plugins
    * 
    * @param plugin_name  The name of the plugin to enable/disable
    * @param enabled  Whether or not to enable this plugin
    */
    public void setLaunchpadPluginEnabled(String plugin_name, Boolean enabled) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("setLaunchpadPluginEnabled", plugin_name, enabled);
        else
            call("setLaunchpadPluginEnabled", plugin_name, enabled).get();
    }

    /**
    * Get a list of enabled AutonomousLaunchpad Plugins.  Enabled plugins will run when AutonomousLaunchpad is started
    * 
    * @return A list of strings of enabled plugins.
    */
    public List<String> getEnabledLaunchpadPlugins() throws CallError, InterruptedException {
        return (List<String>)call("getEnabledLaunchpadPlugins").get();
    }

    /**
    * Stops the focused activity. If another activity is stacked it will be started.
    * 
    */
    public void stopFocus() throws CallError, InterruptedException{
        if (isAsynchronous)
            call("stopFocus");
        else
            call("stopFocus").get();
    }

    /**
    * Get a list of AutonomousLaunchpad Plugins that belong to specified group
    * 
    * @param group  The group to search for the plugins
    * @return A list of strings of the plugins belonging to the group.
    */
    public List<String> getLaunchpadPluginsForGroup(String group) throws CallError, InterruptedException {
        return (List<String>)call("getLaunchpadPluginsForGroup", group).get();
    }

    /**
    * Set the vertical offset (in meters) of the base of the robot with respect to the floor
    * 
    * @param offset  The new vertical offset (in meters)
    */
    public void setRobotOffsetFromFloor(Float offset) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("setRobotOffsetFromFloor", offset);
        else
            call("setRobotOffsetFromFloor", offset).get();
    }

    /**
    * Get the vertical offset (in meters) of the base of the robot with respect to the floor
    * 
    * @return Current vertical offset (in meters)
    */
    public Float getRobotOffsetFromFloor() throws CallError, InterruptedException {
        return (Float)call("getRobotOffsetFromFloor").get();
    }

    /**
    * Set if a given safeguard will be handled by Autonomous Life or not.
    * 
    * @param name  Name of the safeguard to consider: RobotPushed, RobotFell,CriticalDiagnosis, CriticalTemperature
    * @param enabled  True if life handles the safeguard.
    */
    public void setSafeguardEnabled(String name, Boolean enabled) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("setSafeguardEnabled", name, enabled);
        else
            call("setSafeguardEnabled", name, enabled).get();
    }

    /**
    * Get if a given safeguard will be handled by Autonomous Life or not.
    * 
    * @param name  Name of the safeguard to consider: RobotPushed, RobotFell,CriticalDiagnosis, CriticalTemperature
    * @return True if life handles the safeguard.
    */
    public Boolean isSafeguardEnabled(String name) throws CallError, InterruptedException {
        return (Boolean)call("isSafeguardEnabled", name).get();
    }

    /**
    * Returns the nature of an activity
    * 
    * @param activity_name  The package_name/activity_name to check
    * @return Possible values are: solitary, interactive
    */
    public String getActivityNature(String activity_name) throws CallError, InterruptedException {
        return (String)call("getActivityNature", activity_name).get();
    }

    /**
    * Get launch count, last completion time, etc for activities.
    * 
    * @return A map of activity names, with a cooresponding map of  "prevStartTime", "prevCompletionTime", "startCount", "totalDuration". Times are 0 for unlaunched Activities
    */
    public Map<String, Map<String, Integer>> getActivityStatistics() throws CallError, InterruptedException {
        return (Map<String, Map<String, Integer>>)call("getActivityStatistics").get();
    }

    /**
    * Set an activity as running with user focus
    * 
    * @param activity_name  The package_name/activity_name to run
    */
    public void switchFocus(String activity_name) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("switchFocus", activity_name);
        else
            call("switchFocus", activity_name).get();
    }

    /**
    * Get launch count, last completion time, etc for activities with autonomous launch trigger conditions.
    * 
    * @return A map of activity names, with a cooresponding map of  "prevStartTime", "prevCompletionTime", "startCount", "totalDuration". Times are 0 for unlaunched Activities
    */
    public Map<String, Map<String, Integer>> getAutonomousActivityStatistics() throws CallError, InterruptedException {
        return (Map<String, Map<String, Integer>>)call("getAutonomousActivityStatistics").get();
    }

    /**
    * Get a list of the order that activities that have been focused, and their time focused.
    * 
    * @return A list of pairs, each pair is ActivityName/PreviousFocusedTime
    */
    public List<Tuple2<String, Integer>> getFocusHistory() throws CallError, InterruptedException {
        return (List<Tuple2<String, Integer>>)call("getFocusHistory").get();
    }

    /**
    * Get a list of the order that activities that have been focused, and their time focused.
    * 
    * @param depth  How many items of history to report, starting from most recent.
    * @return A list of pairs, each pair is ActivityName/PreviousFocusedTime
    */
    public List<Tuple2<String, Integer>> getFocusHistory(Integer depth) throws CallError, InterruptedException {
        return (List<Tuple2<String, Integer>>)call("getFocusHistory", depth).get();
    }

    /**
    * Start monitoring ALMemory and reporting conditional triggers with AutonomousLaunchpad.
    * 
    */
    public void startMonitoringLaunchpadConditions() throws CallError, InterruptedException{
        if (isAsynchronous)
            call("startMonitoringLaunchpadConditions");
        else
            call("startMonitoringLaunchpadConditions").get();
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
    * Programatically control the state of Autonomous Life
    * 
    * @param state  The possible states of AutonomousLife are: interactive, solitary, safeguard, disabled
    */
    public void setState(String state) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("setState", state);
        else
            call("setState", state).get();
    }

    /**
    * Returns the current state of AutonomousLife
    * 
    * @return Can be: solitary, interactive, safeguard, disabled
    */
    public String getState() throws CallError, InterruptedException {
        return (String)call("getState").get();
    }

}
    