/**
 * Copyright (c) 2015 Aldebaran Robotics. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be
 * found in the COPYING file.
 * Created by epinault and tcruz
 */
package com.aldebaran.qi.helper.proxies;

import com.aldebaran.qi.*;
import com.aldebaran.qi.helper.*;
import java.util.List;
import java.util.Map;


import java.util.List;
/**
* 
* @see <a href="http://doc.aldebaran.lan/doc/release-2.3/aldeb-doc/naoqi/core/alusersession.html#alusersession">NAOqi APIs for ALUserSession </a>
* NAOqi V2.3.x
*/
public class ALUserSession extends ALProxy {

    private AsyncALUserSession asyncProxy;

    public ALUserSession(Session session) throws Exception{
        super(session);
        asyncProxy = new AsyncALUserSession();
	    asyncProxy.setService(getService());
    }

    /**
     * Get the async version of this proxy
     *
	 * @return a AsyncALUserSession object
	 */
    public AsyncALUserSession async() {
        return asyncProxy;
    }

    /**
    * 
    * 
    */
    public Integer getUsidFromPpid(Integer param1) throws CallError, InterruptedException {
        return (Integer)call("getUsidFromPpid", param1).get();
    }

    /**
    * 
    * 
    */
    public List<String> getBindingSources() throws CallError, InterruptedException {
        return (List<String>)call("getBindingSources").get();
    }

    /**
    * 
    * 
    */
    public Boolean doesBindingSourceExist(String param1) throws CallError, InterruptedException {
        return (Boolean)call("doesBindingSourceExist", param1).get();
    }

    /**
    * 
    * 
    */
    public List<String> getUserDataSources() throws CallError, InterruptedException {
        return (List<String>)call("getUserDataSources").get();
    }

    /**
    * 
    * 
    */
    public Boolean doesUserDataSourceExist(String param1) throws CallError, InterruptedException {
        return (Boolean)call("doesUserDataSourceExist", param1).get();
    }

    /**
    * 
    * 
    */
    public Object getUserData(Integer param1, String param2, String param3) throws CallError, InterruptedException {
        return (Object)call("getUserData", param1, param2, param3).get();
    }

    /**
    * 
    * 
    */
    public Map<String, Object> getUserData(Integer param1, String param2) throws CallError, InterruptedException {
        return (Map<String, Object>)call("getUserData", param1, param2).get();
    }

    /**
    * 
    * 
    */
    public void setUserData(Integer param1, String param2, String param3, Object param4) throws CallError, InterruptedException{
        call("setUserData", param1, param2, param3, param4).get();
    }

    /**
    * 
    * 
    */
    public String getUserCreationDate(Integer param1) throws CallError, InterruptedException {
        return (String)call("getUserCreationDate", param1).get();
    }

    /**
    * 
    * 
    */
    public String getFirstEncounterDate(Integer param1) throws CallError, InterruptedException {
        return (String)call("getFirstEncounterDate", param1).get();
    }

    /**
    * 
    * 
    */
    public String getCurrentEncounterDate(Integer param1) throws CallError, InterruptedException {
        return (String)call("getCurrentEncounterDate", param1).get();
    }

    /**
    * 
    * 
    */
    public String getLastEncounterDate(Integer param1) throws CallError, InterruptedException {
        return (String)call("getLastEncounterDate", param1).get();
    }

    /**
    * 
    * 
    */
    public Integer getSecondsSinceLastEncounter(Integer param1) throws CallError, InterruptedException {
        return (Integer)call("getSecondsSinceLastEncounter", param1).get();
    }

    /**
    * 
    * 
    */
    public Integer getPpidFromUsid(Integer param1) throws CallError, InterruptedException {
        return (Integer)call("getPpidFromUsid", param1).get();
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
    * 
    * 
    */
    public Boolean doesUserExist(Integer param1) throws CallError, InterruptedException {
        return (Boolean)call("doesUserExist", param1).get();
    }

    /**
    * 
    * 
    */
    public Boolean doUsersExist(List<Integer> param1) throws CallError, InterruptedException {
        return (Boolean)call("doUsersExist", param1).get();
    }

    /**
    * 
    * 
    */
    public List<Integer> getUserList() throws CallError, InterruptedException {
        return (List<Integer>)call("getUserList").get();
    }

    /**
    * 
    * 
    */
    public Integer getNumUsers() throws CallError, InterruptedException {
        return (Integer)call("getNumUsers").get();
    }

    /**
    * 
    * 
    */
    public Integer getFocusedUser() throws CallError, InterruptedException {
        return (Integer)call("getFocusedUser").get();
    }

    /**
    * 
    * 
    */
    public List<Integer> getOpenUserSessions() throws CallError, InterruptedException {
        return (List<Integer>)call("getOpenUserSessions").get();
    }

    /**
    * 
    * 
    */
    public Boolean isUserSessionOpen(Integer param1) throws CallError, InterruptedException {
        return (Boolean)call("isUserSessionOpen", param1).get();
    }

    /**
    * 
    * 
    */
    public Boolean areUserSessionsOpen(List<Integer> param1) throws CallError, InterruptedException {
        return (Boolean)call("areUserSessionsOpen", param1).get();
    }

    /**
    * 
    * 
    */
    public Boolean isUserPermanent(Integer param1) throws CallError, InterruptedException {
        return (Boolean)call("isUserPermanent", param1).get();
    }

    /**
    * 
    * 
    */
    public Boolean areUsersPermanent(List<Integer> param1) throws CallError, InterruptedException {
        return (Boolean)call("areUsersPermanent", param1).get();
    }

    /**
    * 
    * 
    */
    public List<Integer> getPermanentUserList() throws CallError, InterruptedException {
        return (List<Integer>)call("getPermanentUserList").get();
    }

    /**
    * 
    * 
    */
    public List<String> getBindingList() throws CallError, InterruptedException {
        return (List<String>)call("getBindingList").get();
    }

    /**
    * 
    * 
    */
    public Boolean doesBindingExist(String param1) throws CallError, InterruptedException {
        return (Boolean)call("doesBindingExist", param1).get();
    }

    /**
    * 
    * 
    */
    public String getUserBinding(Integer param1, String param2) throws CallError, InterruptedException {
        return (String)call("getUserBinding", param1, param2).get();
    }

    /**
    * 
    * 
    */
    public Map<String, String> getUserBindings(Integer param1) throws CallError, InterruptedException {
        return (Map<String, String>)call("getUserBindings", param1).get();
    }

    /**
    * 
    * 
    */
    public List<Integer> findUsersWithBinding(String param1, String param2) throws CallError, InterruptedException {
        return (List<Integer>)call("findUsersWithBinding", param1, param2).get();
    }


    public class AsyncALUserSession extends ALProxy {

        protected AsyncALUserSession(){
            super();
        }
    
    /**
    * 
    * 
    */
    public Future<Integer> getUsidFromPpid(Integer param1) throws CallError, InterruptedException {
        return call("getUsidFromPpid", param1);
    }

    /**
    * 
    * 
    */
    public Future<List<String>> getBindingSources() throws CallError, InterruptedException {
        return call("getBindingSources");
    }

    /**
    * 
    * 
    */
    public Future<Boolean> doesBindingSourceExist(String param1) throws CallError, InterruptedException {
        return call("doesBindingSourceExist", param1);
    }

    /**
    * 
    * 
    */
    public Future<List<String>> getUserDataSources() throws CallError, InterruptedException {
        return call("getUserDataSources");
    }

    /**
    * 
    * 
    */
    public Future<Boolean> doesUserDataSourceExist(String param1) throws CallError, InterruptedException {
        return call("doesUserDataSourceExist", param1);
    }

    /**
    * 
    * 
    */
    public Future<Object> getUserData(Integer param1, String param2, String param3) throws CallError, InterruptedException {
        return call("getUserData", param1, param2, param3);
    }

    /**
    * 
    * 
    */
    public Future<Map<String, Object>> getUserData(Integer param1, String param2) throws CallError, InterruptedException {
        return call("getUserData", param1, param2);
    }

    /**
    * 
    * 
    * @return The Future
    */
    public Future<Void> setUserData(Integer param1, String param2, String param3, Object param4) throws CallError, InterruptedException{
        return call("setUserData", param1, param2, param3, param4);
    }

    /**
    * 
    * 
    */
    public Future<String> getUserCreationDate(Integer param1) throws CallError, InterruptedException {
        return call("getUserCreationDate", param1);
    }

    /**
    * 
    * 
    */
    public Future<String> getFirstEncounterDate(Integer param1) throws CallError, InterruptedException {
        return call("getFirstEncounterDate", param1);
    }

    /**
    * 
    * 
    */
    public Future<String> getCurrentEncounterDate(Integer param1) throws CallError, InterruptedException {
        return call("getCurrentEncounterDate", param1);
    }

    /**
    * 
    * 
    */
    public Future<String> getLastEncounterDate(Integer param1) throws CallError, InterruptedException {
        return call("getLastEncounterDate", param1);
    }

    /**
    * 
    * 
    */
    public Future<Integer> getSecondsSinceLastEncounter(Integer param1) throws CallError, InterruptedException {
        return call("getSecondsSinceLastEncounter", param1);
    }

    /**
    * 
    * 
    */
    public Future<Integer> getPpidFromUsid(Integer param1) throws CallError, InterruptedException {
        return call("getPpidFromUsid", param1);
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
    * 
    * 
    */
    public Future<Boolean> doesUserExist(Integer param1) throws CallError, InterruptedException {
        return call("doesUserExist", param1);
    }

    /**
    * 
    * 
    */
    public Future<Boolean> doUsersExist(List<Integer> param1) throws CallError, InterruptedException {
        return call("doUsersExist", param1);
    }

    /**
    * 
    * 
    */
    public Future<List<Integer>> getUserList() throws CallError, InterruptedException {
        return call("getUserList");
    }

    /**
    * 
    * 
    */
    public Future<Integer> getNumUsers() throws CallError, InterruptedException {
        return call("getNumUsers");
    }

    /**
    * 
    * 
    */
    public Future<Integer> getFocusedUser() throws CallError, InterruptedException {
        return call("getFocusedUser");
    }

    /**
    * 
    * 
    */
    public Future<List<Integer>> getOpenUserSessions() throws CallError, InterruptedException {
        return call("getOpenUserSessions");
    }

    /**
    * 
    * 
    */
    public Future<Boolean> isUserSessionOpen(Integer param1) throws CallError, InterruptedException {
        return call("isUserSessionOpen", param1);
    }

    /**
    * 
    * 
    */
    public Future<Boolean> areUserSessionsOpen(List<Integer> param1) throws CallError, InterruptedException {
        return call("areUserSessionsOpen", param1);
    }

    /**
    * 
    * 
    */
    public Future<Boolean> isUserPermanent(Integer param1) throws CallError, InterruptedException {
        return call("isUserPermanent", param1);
    }

    /**
    * 
    * 
    */
    public Future<Boolean> areUsersPermanent(List<Integer> param1) throws CallError, InterruptedException {
        return call("areUsersPermanent", param1);
    }

    /**
    * 
    * 
    */
    public Future<List<Integer>> getPermanentUserList() throws CallError, InterruptedException {
        return call("getPermanentUserList");
    }

    /**
    * 
    * 
    */
    public Future<List<String>> getBindingList() throws CallError, InterruptedException {
        return call("getBindingList");
    }

    /**
    * 
    * 
    */
    public Future<Boolean> doesBindingExist(String param1) throws CallError, InterruptedException {
        return call("doesBindingExist", param1);
    }

    /**
    * 
    * 
    */
    public Future<String> getUserBinding(Integer param1, String param2) throws CallError, InterruptedException {
        return call("getUserBinding", param1, param2);
    }

    /**
    * 
    * 
    */
    public Future<Map<String, String>> getUserBindings(Integer param1) throws CallError, InterruptedException {
        return call("getUserBindings", param1);
    }

    /**
    * 
    * 
    */
    public Future<List<Integer>> findUsersWithBinding(String param1, String param2) throws CallError, InterruptedException {
        return call("findUsersWithBinding", param1, param2);
    }

    }
}
    