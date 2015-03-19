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
/**
* Manages the state of active users, and the bindings to their data.
* @see <a href="http://doc.aldebaran.lan/doc/release-2.1/aldeb-doc/naoqi/core/alusersession.html#alusersession">NAOqi APIs for ALUserSession </a>
*
*/
public class ALUserSession extends ALProxy {

    public ALUserSession(Session session) throws Exception{
        super(session);
    }

    /**
    * Get some data about a user.  Will throw if it does not exist
    * 
    * @param uid  The int ID of the user whose data to get.
    * @param data_name  The key of the data to get.
    * @return A map keyed by source_name of ALValues of the data.
    */
    public Map<String, Object> getUserData(Integer uid, String data_name) throws CallError, InterruptedException {
        return (Map<String, Object>)call("getUserData", uid, data_name).get();
    }

    /**
    * Get the a specific source a user is bound to.
    * 
    * @param uid  The int ID of the user.
    * @param binding_name  The string name of the binding source.
    * @return The string value of the binding ID for the user.
    */
    public String getUserBinding(Integer uid, String binding_name) throws CallError, InterruptedException {
        return (String)call("getUserBinding", uid, binding_name).get();
    }

    /**
    * Get the sources a user is bound to.
    * 
    * @param binding_name  The string name of the binding source.
    * @param binding_value  The string ID of the user at the binding source.
    * @return The int IDs of the users with the passed binding_value.
    */
    public List<Integer> findUsersWithBinding(String binding_name, String binding_value) throws CallError, InterruptedException {
        return (List<Integer>)call("findUsersWithBinding", binding_name, binding_value).get();
    }

    /**
    * Check if a data source has been registered.
    * 
    * @param source_name  The string name of the data source.
    * @return A bool, true if the source has been registered
    */
    public Boolean doesUserDataSourceExist(String source_name) throws CallError, InterruptedException {
        return (Boolean)call("doesUserDataSourceExist", source_name).get();
    }

    /**
    * Get the sources a user is bound to.
    * 
    * @param uid  The int ID of the user.
    * @return A map of string binding names and their string values.
    */
    public Map<String, String> getUserBindings(Integer uid) throws CallError, InterruptedException {
        return (Map<String, String>)call("getUserBindings", uid).get();
    }

    /**
    * Check what data sources have been registered.
    * 
    * @return A list of strings of each registered data source.
    */
    public List<String> getUserDataSources() throws CallError, InterruptedException {
        return (List<String>)call("getUserDataSources").get();
    }

    /**
    * Get some data about a user.  Will throw if it does not exist
    * 
    * @param uid  The int ID of the user whose data to get.
    * @param data_name  The key of the data to get.
    * @param source_name  The string name of the data source.
    * @return ALValue of the data.
    */
    public Object getUserData(Integer uid, String data_name, String source_name) throws CallError, InterruptedException {
        return (Object)call("getUserData", uid, data_name, source_name).get();
    }

    /**
    * Set some data about a user.  Will throw if user does not exist
    * 
    * @param uid  The int ID of the user whose data to set.
    * @param data_name  The key of the data to set.
    * @param source_name  The string name of the data source.
    * @param data  ALValue of the data.
    */
    public void setUserData(Integer uid, String data_name, String source_name, Object data) throws CallError, InterruptedException{
        call("setUserData", uid, data_name, source_name, data).get();
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
    * Check if users exist in db.
    * 
    * @param user_list  A list of int ID of the users to check.
    * @return A bool, true if all users exist.
    */
    public Boolean doUsersExist(List<Integer> user_list) throws CallError, InterruptedException {
        return (Boolean)call("doUsersExist", user_list).get();
    }

    /**
    * Get a full list of the users.
    * 
    * @return A list of int user IDs.
    */
    public List<Integer> getUserList() throws CallError, InterruptedException {
        return (List<Integer>)call("getUserList").get();
    }

    /**
    * Get the count of users in db.
    * 
    * @return An int of how many users exist
    */
    public Integer getNumUsers() throws CallError, InterruptedException {
        return (Integer)call("getNumUsers").get();
    }

    /**
    * Get which user has the robot's focus.
    * 
    * @return The int ID of the focused user. -1 if no focused user.
    */
    public Integer getFocusedUser() throws CallError, InterruptedException {
        return (Integer)call("getFocusedUser").get();
    }

    /**
    * Get which users have an open session.
    * 
    * @return A list of int IDs of each user with an open session.
    */
    public List<Integer> getOpenUserSessions() throws CallError, InterruptedException {
        return (List<Integer>)call("getOpenUserSessions").get();
    }

    /**
    * Check if users have an open session.
    * 
    * @param user_list  A list of int IDs of each user to check.
    * @return A bool, true if all users have open sessions.
    */
    public Boolean areUserSessionsOpen(List<Integer> user_list) throws CallError, InterruptedException {
        return (Boolean)call("areUserSessionsOpen", user_list).get();
    }

    /**
    * The list of binding sources  that have been applied to UserSession
    * 
    * @return A list of strings, one for each binding source.
    */
    public List<String> getBindingSources() throws CallError, InterruptedException {
        return (List<String>)call("getBindingSources").get();
    }

    /**
    * Query if a particular has been applied to UserSession
    * 
    * @param binding_name  The string name of the binding source.
    * @return A bool, true if a binding source exists.
    */
    public Boolean doesBindingSourceExist(String binding_name) throws CallError, InterruptedException {
        return (Boolean)call("doesBindingSourceExist", binding_name).get();
    }

}
    