/**
 * Copyright (c) 2015 Aldebaran Robotics. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be
 * found in the COPYING file.
 * Created by epinault and ekroeger
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
* 
* @see <a href="http://doc.aldebaran.lan/doc/master/aldeb-doc/naoqi/core/alusersession.html#alusersession">NAOqi APIs for ALUserSession </a>
*
*/
public class ALUserSession extends ALProxy {

    public ALUserSession(Session session) {
        super(session);
    }

    /**
    * 
    * 
    */
    public List<String> getUserDataSources() throws CallError, InterruptedException {
        return (List<String>)service.call("getUserDataSources").get();
    }

    /**
    * 
    * 
    */
    public Map<String, Object> getUserData(Integer param1, String param2) throws CallError, InterruptedException {
        return (Map<String, Object>)service.call("getUserData", param1, param2).get();
    }

    /**
    * 
    * 
    */
    public void setUserData(Integer param1, String param2, String param3, Object param4) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setUserData", param1, param2, param3, param4);
        else
            service.call("setUserData", param1, param2, param3, param4).get();
    }

    /**
    * 
    * 
    */
    public List<String> getBindingSources() throws CallError, InterruptedException {
        return (List<String>)service.call("getBindingSources").get();
    }

    /**
    * 
    * 
    */
    public Boolean doesBindingSourceExist(String param1) throws CallError, InterruptedException {
        return (Boolean)service.call("doesBindingSourceExist", param1).get();
    }

    /**
    * 
    * 
    */
    public Boolean doesUserDataSourceExist(String param1) throws CallError, InterruptedException {
        return (Boolean)service.call("doesUserDataSourceExist", param1).get();
    }

    /**
    * 
    * 
    */
    public Object getUserData(Integer param1, String param2, String param3) throws CallError, InterruptedException {
        return (Object)service.call("getUserData", param1, param2, param3).get();
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
    * 
    * 
    */
    public Boolean doUserExist(Integer param1) throws CallError, InterruptedException {
        return (Boolean)service.call("doUserExist", param1).get();
    }

    /**
    * 
    * 
    */
    public Boolean doUsersExist(List<Integer> param1) throws CallError, InterruptedException {
        return (Boolean)service.call("doUsersExist", param1).get();
    }

    /**
    * 
    * 
    */
    public Boolean isUserPermanent(Integer param1) throws CallError, InterruptedException {
        return (Boolean)service.call("isUserPermanent", param1).get();
    }

    /**
    * 
    * 
    */
    public Boolean areUsersPermanent(List<Integer> param1) throws CallError, InterruptedException {
        return (Boolean)service.call("areUsersPermanent", param1).get();
    }

    /**
    * 
    * 
    */
    public List<Integer> getUserList() throws CallError, InterruptedException {
        return (List<Integer>)service.call("getUserList").get();
    }

    /**
    * 
    * 
    */
    public List<Integer> getPermanentUserList() throws CallError, InterruptedException {
        return (List<Integer>)service.call("getPermanentUserList").get();
    }

    /**
    * 
    * 
    */
    public Integer getNumUsers() throws CallError, InterruptedException {
        return (Integer)service.call("getNumUsers").get();
    }

    /**
    * 
    * 
    */
    public Integer getFocusedUser() throws CallError, InterruptedException {
        return (Integer)service.call("getFocusedUser").get();
    }

    /**
    * 
    * 
    */
    public List<Integer> getOpenUserSessions() throws CallError, InterruptedException {
        return (List<Integer>)service.call("getOpenUserSessions").get();
    }

    /**
    * 
    * 
    */
    public Boolean isUserSessionOpen(Integer param1) throws CallError, InterruptedException {
        return (Boolean)service.call("isUserSessionOpen", param1).get();
    }

    /**
    * 
    * 
    */
    public Boolean areUserSessionsOpen(List<Integer> param1) throws CallError, InterruptedException {
        return (Boolean)service.call("areUserSessionsOpen", param1).get();
    }

    /**
    * 
    * 
    */
    public List<String> getBindingList() throws CallError, InterruptedException {
        return (List<String>)service.call("getBindingList").get();
    }

    /**
    * 
    * 
    */
    public Boolean doesBindingExist(String param1) throws CallError, InterruptedException {
        return (Boolean)service.call("doesBindingExist", param1).get();
    }

    /**
    * 
    * 
    */
    public String getUserBinding(Integer param1, String param2) throws CallError, InterruptedException {
        return (String)service.call("getUserBinding", param1, param2).get();
    }

    /**
    * 
    * 
    */
    public Map<String, String> getUserBindings(Integer param1) throws CallError, InterruptedException {
        return (Map<String, String>)service.call("getUserBindings", param1).get();
    }

    /**
    * 
    * 
    */
    public List<Integer> findUsersWithBinding(String param1, String param2) throws CallError, InterruptedException {
        return (List<Integer>)service.call("findUsersWithBinding", param1, param2).get();
    }

}
    