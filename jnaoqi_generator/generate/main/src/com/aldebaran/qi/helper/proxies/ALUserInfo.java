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
import com.aldebaran.qi.helper.ALProxy;
/**
* 
* @see <a href="http://doc.aldebaran.lan/doc/master/aldeb-doc/naoqi/core/aluserinfo.html#aluserinfo">NAOqi APIs for ALUserInfo </a>
* NAOqi V2.4.x
*/
public class ALUserInfo extends ALProxy {

    private AsyncALUserInfo asyncProxy;

    public ALUserInfo(Session session) throws Exception{
        super(session);
        asyncProxy = new AsyncALUserInfo();
	    asyncProxy.setService(getService());
    }

    /**
     * Get the async version of this proxy
     *
	 * @return a AsyncALUserInfo object
	 */
    public AsyncALUserInfo async() {
        return asyncProxy;
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
    public Object get(String param1) throws CallError, InterruptedException {
        return (Object)call("get", param1).get();
    }

    /**
    * 
    * 
    */
    public Object get(Integer param1, String param2) throws CallError, InterruptedException {
        return (Object)call("get", param1, param2).get();
    }

    /**
    * 
    * 
    */
    public Object get(String param1, String param2) throws CallError, InterruptedException {
        return (Object)call("get", param1, param2).get();
    }

    /**
    * 
    * 
    */
    public Object get(String param1, Integer param2, String param3) throws CallError, InterruptedException {
        return (Object)call("get", param1, param2, param3).get();
    }

    /**
    * 
    * 
    */
    public Boolean set(String param1, String param2, Object param3) throws CallError, InterruptedException {
        return (Boolean)call("set", param1, param2, param3).get();
    }

    /**
    * 
    * 
    */
    public Boolean set(String param1, Integer param2, String param3, Object param4) throws CallError, InterruptedException {
        return (Boolean)call("set", param1, param2, param3, param4).get();
    }

    /**
    * 
    * 
    */
    public Boolean has(String param1) throws CallError, InterruptedException {
        return (Boolean)call("has", param1).get();
    }

    /**
    * 
    * 
    */
    public Boolean has(Integer param1, String param2) throws CallError, InterruptedException {
        return (Boolean)call("has", param1, param2).get();
    }

    /**
    * 
    * 
    */
    public Boolean has(String param1, String param2) throws CallError, InterruptedException {
        return (Boolean)call("has", param1, param2).get();
    }

    /**
    * 
    * 
    */
    public Boolean has(String param1, Integer param2, String param3) throws CallError, InterruptedException {
        return (Boolean)call("has", param1, param2, param3).get();
    }

    /**
    * 
    * 
    */
    public Boolean remove(String param1, String param2) throws CallError, InterruptedException {
        return (Boolean)call("remove", param1, param2).get();
    }

    /**
    * 
    * 
    */
    public Boolean remove(String param1, Integer param2, String param3) throws CallError, InterruptedException {
        return (Boolean)call("remove", param1, param2, param3).get();
    }

    /**
    * 
    * 
    */
    public Boolean removeUser(String param1) throws CallError, InterruptedException {
        return (Boolean)call("removeUser", param1).get();
    }

    /**
    * 
    * 
    */
    public Boolean removeUser(String param1, Integer param2) throws CallError, InterruptedException {
        return (Boolean)call("removeUser", param1, param2).get();
    }

    /**
    * 
    * 
    */
    public String getType(String param1, String param2) throws CallError, InterruptedException {
        return (String)call("getType", param1, param2).get();
    }


    public class AsyncALUserInfo extends ALProxy {

        protected AsyncALUserInfo(){
            super();
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
    public Future<Object> get(String param1) throws CallError, InterruptedException {
        return call("get", param1);
    }

    /**
    * 
    * 
    */
    public Future<Object> get(Integer param1, String param2) throws CallError, InterruptedException {
        return call("get", param1, param2);
    }

    /**
    * 
    * 
    */
    public Future<Object> get(String param1, String param2) throws CallError, InterruptedException {
        return call("get", param1, param2);
    }

    /**
    * 
    * 
    */
    public Future<Object> get(String param1, Integer param2, String param3) throws CallError, InterruptedException {
        return call("get", param1, param2, param3);
    }

    /**
    * 
    * 
    */
    public Future<Boolean> set(String param1, String param2, Object param3) throws CallError, InterruptedException {
        return call("set", param1, param2, param3);
    }

    /**
    * 
    * 
    */
    public Future<Boolean> set(String param1, Integer param2, String param3, Object param4) throws CallError, InterruptedException {
        return call("set", param1, param2, param3, param4);
    }

    /**
    * 
    * 
    */
    public Future<Boolean> has(String param1) throws CallError, InterruptedException {
        return call("has", param1);
    }

    /**
    * 
    * 
    */
    public Future<Boolean> has(Integer param1, String param2) throws CallError, InterruptedException {
        return call("has", param1, param2);
    }

    /**
    * 
    * 
    */
    public Future<Boolean> has(String param1, String param2) throws CallError, InterruptedException {
        return call("has", param1, param2);
    }

    /**
    * 
    * 
    */
    public Future<Boolean> has(String param1, Integer param2, String param3) throws CallError, InterruptedException {
        return call("has", param1, param2, param3);
    }

    /**
    * 
    * 
    */
    public Future<Boolean> remove(String param1, String param2) throws CallError, InterruptedException {
        return call("remove", param1, param2);
    }

    /**
    * 
    * 
    */
    public Future<Boolean> remove(String param1, Integer param2, String param3) throws CallError, InterruptedException {
        return call("remove", param1, param2, param3);
    }

    /**
    * 
    * 
    */
    public Future<Boolean> removeUser(String param1) throws CallError, InterruptedException {
        return call("removeUser", param1);
    }

    /**
    * 
    * 
    */
    public Future<Boolean> removeUser(String param1, Integer param2) throws CallError, InterruptedException {
        return call("removeUser", param1, param2);
    }

    /**
    * 
    * 
    */
    public Future<String> getType(String param1, String param2) throws CallError, InterruptedException {
        return call("getType", param1, param2);
    }

    }
}
    