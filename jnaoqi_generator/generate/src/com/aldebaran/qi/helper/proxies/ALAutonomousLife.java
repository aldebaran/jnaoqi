/**
 * Copyright (c) 2015 Aldebaran Robotics. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be
 * found in the COPYING file.
 * Created by epinault and tcruz
 */
package com.aldebaran.qi.helper.proxies;

import com.aldebaran.qi.CallError;
import com.aldebaran.qi.Future;
import com.aldebaran.qi.Session;
import com.aldebaran.qi.Tuple2;
import com.aldebaran.qi.helper.ALProxy;

import java.util.List;
import java.util.Map;
/**
* Manages the focused Activity and Autonomous Life state
* @see <a href="http://doc.aldebaran.lan/doc/master/aldeb-doc/naoqi/interaction/autonomouslife.html#autonomouslife">NAOqi APIs for ALAutonomousLife </a>
* NAOqi V2.4.x
*/
public class ALAutonomousLife extends ALProxy {

    private AsyncALAutonomousLife asyncProxy;

    public ALAutonomousLife(Session session) throws Exception{
        super(session);
        asyncProxy = new AsyncALAutonomousLife();
	    asyncProxy.setService(getService());
    }

    /**
     * Get the async version of this proxy
     *
	 * @return a AsyncALAutonomousLife object
	 */
    public AsyncALAutonomousLife async() {
        return asyncProxy;
    }

    /**
    * 
    * 
    */
    public Map<String, Map<String, Integer>> getActivityStatistics() throws CallError, InterruptedException {
        return (Map<String, Map<String, Integer>>)call("getActivityStatistics").get();
    }

    /**
    * 
    * 
    */
    public List<Tuple2<String, Integer>> getStateHistory(Integer param1) throws CallError, InterruptedException {
        return (List<Tuple2<String, Integer>>)call("getStateHistory", param1).get();
    }

    /**
    * Stops the focused activity and clears stack of activities
    * 
    */
    public void stopAll() throws CallError, InterruptedException{
        call("stopAll").get();
    }

    /**
    * Start monitoring ALMemory and reporting conditional triggers with AutonomousLaunchpad.
    * 
    */
    public void startMonitoringLaunchpadConditions() throws CallError, InterruptedException{
        call("startMonitoringLaunchpadConditions").get();
    }

    /**
    * Stop monitoring ALMemory and reporting conditional triggers with AutonomousLaunchpad.
    * 
    */
    public void stopMonitoringLaunchpadConditions() throws CallError, InterruptedException{
        call("stopMonitoringLaunchpadConditions").get();
    }

    /**
    * Get a list of permissions that would be violated by a given activity in the current context.
    * 
    * @param name  The name of the activity to check.
    * @return An array of strings of the violated permissions. EG: ["nature", "canRunOnPod", "canRunInSleep"]
    */
    public List<String> getActivityContextPermissionViolations(String name) throws CallError, InterruptedException {
        return (List<String>)call("getActivityContextPermissionViolations", name).get();
    }

    /**
    * Temporarily enables/disables AutonomousLaunchpad Plugins
    * 
    * @param plugin_name  The name of the plugin to enable/disable
    * @param enabled  Whether or not to enable this plugin
    */
    public void setLaunchpadPluginEnabled(String plugin_name, Boolean enabled) throws CallError, InterruptedException{
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
    * Returns the nature of an activity
    * 
    * @param activity_name  The package_name/activity_name to check
    * @return Possible values are: solitary, interactive
    */
    public String getActivityNature(String activity_name) throws CallError, InterruptedException {
        return (String)call("getActivityNature", activity_name).get();
    }

    /**
    * Set if a given safeguard will be handled by Autonomous Life or not.
    * 
    * @param name  Name of the safeguard to consider: RobotPushed, RobotFell,CriticalDiagnosis, CriticalTemperature
    * @param enabled  True if life handles the safeguard.
    */
    public void setSafeguardEnabled(String name, Boolean enabled) throws CallError, InterruptedException{
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
    * Get launch count, last completion time, etc for activities with autonomous launch trigger conditions.
    * 
    * @return A map of activity names, with a cooresponding map of  "prevStartTime", "prevCompletionTime", "startCount", "totalDuration". Times are 0 for unlaunched Activities
    */
    public Map<String, Map<String, Integer>> getAutonomousActivityStatistics() throws CallError, InterruptedException {
        return (Map<String, Map<String, Integer>>)call("getAutonomousActivityStatistics").get();
    }

    /**
    * 
    * 
    */
    public List<Tuple2<String, Integer>> getFocusHistory() throws CallError, InterruptedException {
        return (List<Tuple2<String, Integer>>)call("getFocusHistory").get();
    }

    /**
    * Get a value of an ALMemory key that is used in a condition, which is the value at the previous autonomous activity focus.
    * 
    * @param name  Name of the ALMemory key to get.  Will throw if key is not used in any activity conditions.
    * @return An array of the ALValue of the memory key and timestamp of when it was set: [seconds, microseconds, value]
    */
    public Object getFocusContext(String name) throws CallError, InterruptedException {
        return (Object)call("getFocusContext", name).get();
    }

    /**
    * 
    * 
    */
    public List<Tuple2<String, Integer>> getFocusHistory(Integer param1) throws CallError, InterruptedException {
        return (List<Tuple2<String, Integer>>)call("getFocusHistory", param1).get();
    }

    /**
    * 
    * 
    */
    public List<Tuple2<String, Integer>> getStateHistory() throws CallError, InterruptedException {
        return (List<Tuple2<String, Integer>>)call("getStateHistory").get();
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
    * Gets running status of AutonomousLaunchpad
    * 
    * @return True if AutonomousLaunchpad is monitoring ALMemory and reporting conditional triggers.
    */
    public Boolean isMonitoringLaunchpadConditions() throws CallError, InterruptedException {
        return (Boolean)call("isMonitoringLaunchpadConditions").get();
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
    * Wait for the end of a long running method that was called using 'post', returns a cancelable future
    * 
    * @param id  The ID of the method that was returned when calling the method using 'post'
    */
    public void wait(Integer id) throws CallError, InterruptedException{
        call("wait", id).get();
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
    * 
    * 
    * @param   
    * @param   
    * @param   
    */
    public void onReady(String param1, Object param2, String param3) throws CallError, InterruptedException{
        call("onReady", param1, param2, param3).get();
    }

    /**
    * Programatically control the state of Autonomous Life
    * 
    * @param state  The possible states of AutonomousLife are: interactive, solitary, safeguard, disabled
    */
    public void setState(String state) throws CallError, InterruptedException{
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

    /**
    * Returns the currently focused activity
    * 
    * @return The name of the focused activity
    */
    public String focusedActivity() throws CallError, InterruptedException {
        return (String)call("focusedActivity").get();
    }

    /**
    * Set an activity as running with user focus
    * 
    * @param activity_name  The package_name/activity_name to run
    */
    public void switchFocus(String activity_name) throws CallError, InterruptedException{
        call("switchFocus", activity_name).get();
    }

    /**
    * Set an activity as running with user focus
    * 
    * @param activity_name  The package_name/activity_name to run
    * @param flags  Int flags for focus changing. STOP_CURRENT(0) or STOP_AND_STACK_CURRENT(1)
    */
    public void switchFocus(String activity_name, Integer flags) throws CallError, InterruptedException{
        call("switchFocus", activity_name, flags).get();
    }

    /**
    * Stops the focused activity. If another activity is stacked it will be started.
    * 
    */
    public void stopFocus() throws CallError, InterruptedException{
        call("stopFocus").get();
    }


    public class AsyncALAutonomousLife extends ALProxy {

        protected AsyncALAutonomousLife(){
            super();
        }
    
    /**
    * 
    * 
    */
    public Future<Map<String, Map<String, Integer>>> getActivityStatistics() throws CallError, InterruptedException {
        return call("getActivityStatistics");
    }

    /**
    * 
    * 
    */
    public Future<List<Tuple2<String, Integer>>> getStateHistory(Integer param1) throws CallError, InterruptedException {
        return call("getStateHistory", param1);
    }

    /**
    * Stops the focused activity and clears stack of activities
    * 
    * @return The Future
    */
    public Future<Void> stopAll() throws CallError, InterruptedException{
        return call("stopAll");
    }

    /**
    * Start monitoring ALMemory and reporting conditional triggers with AutonomousLaunchpad.
    * 
    * @return The Future
    */
    public Future<Void> startMonitoringLaunchpadConditions() throws CallError, InterruptedException{
        return call("startMonitoringLaunchpadConditions");
    }

    /**
    * Stop monitoring ALMemory and reporting conditional triggers with AutonomousLaunchpad.
    * 
    * @return The Future
    */
    public Future<Void> stopMonitoringLaunchpadConditions() throws CallError, InterruptedException{
        return call("stopMonitoringLaunchpadConditions");
    }

    /**
    * Get a list of permissions that would be violated by a given activity in the current context.
    * 
    * @param name  The name of the activity to check.
    * @return An array of strings of the violated permissions. EG: ["nature", "canRunOnPod", "canRunInSleep"]
    */
    public Future<List<String>> getActivityContextPermissionViolations(String name) throws CallError, InterruptedException {
        return call("getActivityContextPermissionViolations", name);
    }

    /**
    * Temporarily enables/disables AutonomousLaunchpad Plugins
    * 
    * @param plugin_name  The name of the plugin to enable/disable
    * @param enabled  Whether or not to enable this plugin
    * @return The Future
    */
    public Future<Void> setLaunchpadPluginEnabled(String plugin_name, Boolean enabled) throws CallError, InterruptedException{
        return call("setLaunchpadPluginEnabled", plugin_name, enabled);
    }

    /**
    * Get a list of enabled AutonomousLaunchpad Plugins.  Enabled plugins will run when AutonomousLaunchpad is started
    * 
    * @return A list of strings of enabled plugins.
    */
    public Future<List<String>> getEnabledLaunchpadPlugins() throws CallError, InterruptedException {
        return call("getEnabledLaunchpadPlugins");
    }

    /**
    * Get a list of AutonomousLaunchpad Plugins that belong to specified group
    * 
    * @param group  The group to search for the plugins
    * @return A list of strings of the plugins belonging to the group.
    */
    public Future<List<String>> getLaunchpadPluginsForGroup(String group) throws CallError, InterruptedException {
        return call("getLaunchpadPluginsForGroup", group);
    }

    /**
    * Set the vertical offset (in meters) of the base of the robot with respect to the floor
    * 
    * @param offset  The new vertical offset (in meters)
    * @return The Future
    */
    public Future<Void> setRobotOffsetFromFloor(Float offset) throws CallError, InterruptedException{
        return call("setRobotOffsetFromFloor", offset);
    }

    /**
    * Get the vertical offset (in meters) of the base of the robot with respect to the floor
    * 
    * @return Current vertical offset (in meters)
    */
    public Future<Float> getRobotOffsetFromFloor() throws CallError, InterruptedException {
        return call("getRobotOffsetFromFloor");
    }

    /**
    * Returns the nature of an activity
    * 
    * @param activity_name  The package_name/activity_name to check
    * @return Possible values are: solitary, interactive
    */
    public Future<String> getActivityNature(String activity_name) throws CallError, InterruptedException {
        return call("getActivityNature", activity_name);
    }

    /**
    * Set if a given safeguard will be handled by Autonomous Life or not.
    * 
    * @param name  Name of the safeguard to consider: RobotPushed, RobotFell,CriticalDiagnosis, CriticalTemperature
    * @param enabled  True if life handles the safeguard.
    * @return The Future
    */
    public Future<Void> setSafeguardEnabled(String name, Boolean enabled) throws CallError, InterruptedException{
        return call("setSafeguardEnabled", name, enabled);
    }

    /**
    * Get if a given safeguard will be handled by Autonomous Life or not.
    * 
    * @param name  Name of the safeguard to consider: RobotPushed, RobotFell,CriticalDiagnosis, CriticalTemperature
    * @return True if life handles the safeguard.
    */
    public Future<Boolean> isSafeguardEnabled(String name) throws CallError, InterruptedException {
        return call("isSafeguardEnabled", name);
    }

    /**
    * Get launch count, last completion time, etc for activities with autonomous launch trigger conditions.
    * 
    * @return A map of activity names, with a cooresponding map of  "prevStartTime", "prevCompletionTime", "startCount", "totalDuration". Times are 0 for unlaunched Activities
    */
    public Future<Map<String, Map<String, Integer>>> getAutonomousActivityStatistics() throws CallError, InterruptedException {
        return call("getAutonomousActivityStatistics");
    }

    /**
    * 
    * 
    */
    public Future<List<Tuple2<String, Integer>>> getFocusHistory() throws CallError, InterruptedException {
        return call("getFocusHistory");
    }

    /**
    * Get a value of an ALMemory key that is used in a condition, which is the value at the previous autonomous activity focus.
    * 
    * @param name  Name of the ALMemory key to get.  Will throw if key is not used in any activity conditions.
    * @return An array of the ALValue of the memory key and timestamp of when it was set: [seconds, microseconds, value]
    */
    public Future<Object> getFocusContext(String name) throws CallError, InterruptedException {
        return call("getFocusContext", name);
    }

    /**
    * 
    * 
    */
    public Future<List<Tuple2<String, Integer>>> getFocusHistory(Integer param1) throws CallError, InterruptedException {
        return call("getFocusHistory", param1);
    }

    /**
    * 
    * 
    */
    public Future<List<Tuple2<String, Integer>>> getStateHistory() throws CallError, InterruptedException {
        return call("getStateHistory");
    }

    /**
    * Get the time in seconds as life sees it.  Based on gettimeofday()
    * 
    * @return The int time in seconds as Autonomous Life sees it
    */
    public Future<Integer> getLifeTime() throws CallError, InterruptedException {
        return call("getLifeTime");
    }

    /**
    * Gets running status of AutonomousLaunchpad
    * 
    * @return True if AutonomousLaunchpad is monitoring ALMemory and reporting conditional triggers.
    */
    public Future<Boolean> isMonitoringLaunchpadConditions() throws CallError, InterruptedException {
        return call("isMonitoringLaunchpadConditions");
    }

    /**
    * 
    * 
    */
    public Future<Boolean> isStatsEnabled() throws CallError, InterruptedException {
        return call("isStatsEnabled");
    }

    /**
    * 
    * 
    * @return The Future
    */
    public Future<Void> clearStats() throws CallError, InterruptedException{
        return call("clearStats");
    }

    /**
    * 
    * 
    */
    public Future<Boolean> isTraceEnabled() throws CallError, InterruptedException {
        return call("isTraceEnabled");
    }

    /**
    * Exits and unregisters the module.
    * 
    * @return The Future
    */
    public Future<Void> exit() throws CallError, InterruptedException{
        return call("exit");
    }

    /**
    * Returns the version of the module.
    * 
    * @return A string containing the version of the module.
    */
    public Future<String> version() throws CallError, InterruptedException {
        return call("version");
    }

    /**
    * Just a ping. Always returns true
    * 
    * @return returns true
    */
    public Future<Boolean> ping() throws CallError, InterruptedException {
        return call("ping");
    }

    /**
    * Retrieves the module's method list.
    * 
    * @return An array of method names.
    */
    public Future<List<String>> getMethodList() throws CallError, InterruptedException {
        return call("getMethodList");
    }

    /**
    * Retrieves a method's description.
    * 
    * @param methodName  The name of the method.
    * @return A structure containing the method's description.
    */
    public Future<Object> getMethodHelp(String methodName) throws CallError, InterruptedException {
        return call("getMethodHelp", methodName);
    }

    /**
    * Retrieves the module's description.
    * 
    * @return A structure describing the module.
    */
    public Future<Object> getModuleHelp() throws CallError, InterruptedException {
        return call("getModuleHelp");
    }

    /**
    * Wait for the end of a long running method that was called using 'post'
    * 
    * @param id  The ID of the method that was returned when calling the method using 'post'
    * @param timeoutPeriod  The timeout period in ms. To wait indefinately, use a timeoutPeriod of zero.
    * @return True if the timeout period terminated. False if the method returned.
    */
    public Future<Boolean> wait(Integer id, Integer timeoutPeriod) throws CallError, InterruptedException {
        return call("wait", id, timeoutPeriod);
    }

    /**
    * Wait for the end of a long running method that was called using 'post', returns a cancelable future
    * 
    * @param id  The ID of the method that was returned when calling the method using 'post'
    * @return The Future
    */
    public Future<Void> wait(Integer id) throws CallError, InterruptedException{
        return call("wait", id);
    }

    /**
    * Returns true if the method is currently running.
    * 
    * @param id  The ID of the method that was returned when calling the method using 'post'
    * @return True if the method is currently running
    */
    public Future<Boolean> isRunning(Integer id) throws CallError, InterruptedException {
        return call("isRunning", id);
    }

    /**
    * returns true if the method is currently running
    * 
    * @param id  the ID of the method to wait for
    * @return The Future
    */
    public Future<Void> stop(Integer id) throws CallError, InterruptedException{
        return call("stop", id);
    }

    /**
    * Gets the name of the parent broker.
    * 
    * @return The name of the parent broker.
    */
    public Future<String> getBrokerName() throws CallError, InterruptedException {
        return call("getBrokerName");
    }

    /**
    * Gets the method usage string. This summarises how to use the method.
    * 
    * @param name  The name of the method.
    * @return A string that summarises the usage of the method.
    */
    public Future<String> getUsage(String name) throws CallError, InterruptedException {
        return call("getUsage", name);
    }

    /**
    * 
    * 
    * @param   
    * @param   
    * @param   
    * @return The Future
    */
    public Future<Void> onReady(String param1, Object param2, String param3) throws CallError, InterruptedException{
        return call("onReady", param1, param2, param3);
    }

    /**
    * Programatically control the state of Autonomous Life
    * 
    * @param state  The possible states of AutonomousLife are: interactive, solitary, safeguard, disabled
    * @return The Future
    */
    public Future<Void> setState(String state) throws CallError, InterruptedException{
        return call("setState", state);
    }

    /**
    * Returns the current state of AutonomousLife
    * 
    * @return Can be: solitary, interactive, safeguard, disabled
    */
    public Future<String> getState() throws CallError, InterruptedException {
        return call("getState");
    }

    /**
    * Returns the currently focused activity
    * 
    * @return The name of the focused activity
    */
    public Future<String> focusedActivity() throws CallError, InterruptedException {
        return call("focusedActivity");
    }

    /**
    * Set an activity as running with user focus
    * 
    * @param activity_name  The package_name/activity_name to run
    * @return The Future
    */
    public Future<Void> switchFocus(String activity_name) throws CallError, InterruptedException{
        return call("switchFocus", activity_name);
    }

    /**
    * Set an activity as running with user focus
    * 
    * @param activity_name  The package_name/activity_name to run
    * @param flags  Int flags for focus changing. STOP_CURRENT(0) or STOP_AND_STACK_CURRENT(1)
    * @return The Future
    */
    public Future<Void> switchFocus(String activity_name, Integer flags) throws CallError, InterruptedException{
        return call("switchFocus", activity_name, flags);
    }

    /**
    * Stops the focused activity. If another activity is stacked it will be started.
    * 
    * @return The Future
    */
    public Future<Void> stopFocus() throws CallError, InterruptedException{
        return call("stopFocus");
    }

    }
}
    