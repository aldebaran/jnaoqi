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
* @see <a href="http://doc.aldebaran.lan/doc/master/aldeb-doc/naoqi/core/almood.html#almood">NAOqi APIs for ALMood </a>
* NAOqi V2.4.x
*/
public class ALMood extends ALProxy {

    private AsyncALMood asyncProxy;

    public ALMood(Session session) throws Exception{
        super(session);
        asyncProxy = new AsyncALMood();
	    asyncProxy.setService(getService());
    }

    /**
     * Get the async version of this proxy
     *
	 * @return a AsyncALMood object
	 */
    public AsyncALMood async() {
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
    public Boolean subscribe(String param1, String param2) throws CallError, InterruptedException {
        return (Boolean)call("subscribe", param1, param2).get();
    }

    /**
    * 
    * 
    */
    public Boolean unsubscribe(String param1) throws CallError, InterruptedException {
        return (Boolean)call("unsubscribe", param1).get();
    }

    /**
    * 
    * 
    */
    public Map<String, String> getSubscribersInfo() throws CallError, InterruptedException {
        return (Map<String, String>)call("getSubscribersInfo").get();
    }

    /**
    * 
    * 
    */
    public Tuple5<Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple1<Tuple2<Float, Float>>, Tuple2<Float, Float>, Tuple7<Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>>> currentPersonState() throws CallError, InterruptedException {
        return (Tuple5<Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple1<Tuple2<Float, Float>>, Tuple2<Float, Float>, Tuple7<Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>>>)call("currentPersonState").get();
    }

    /**
    * 
    * 
    */
    public Tuple5<Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple1<Tuple2<Float, Float>>, Tuple2<Float, Float>, Tuple7<Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>>> personStateFromPeoplePerception(Integer param1) throws CallError, InterruptedException {
        return (Tuple5<Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple1<Tuple2<Float, Float>>, Tuple2<Float, Float>, Tuple7<Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>>>)call("personStateFromPeoplePerception", param1).get();
    }

    /**
    * 
    * 
    */
    public Tuple5<Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple1<Tuple2<Float, Float>>, Tuple2<Float, Float>, Tuple7<Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>>> personStateFromUserSession(Integer param1) throws CallError, InterruptedException {
        return (Tuple5<Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple1<Tuple2<Float, Float>>, Tuple2<Float, Float>, Tuple7<Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>>>)call("personStateFromUserSession", param1).get();
    }

    /**
    * 
    * 
    */
    public List<Tuple3<Integer, Integer, Tuple5<Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple1<Tuple2<Float, Float>>, Tuple2<Float, Float>, Tuple7<Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>>>>> persons() throws CallError, InterruptedException {
        return (List<Tuple3<Integer, Integer, Tuple5<Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple1<Tuple2<Float, Float>>, Tuple2<Float, Float>, Tuple7<Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>>>>>)call("persons").get();
    }

    /**
    * 
    * 
    */
    public Tuple2<Float, Float> ambianceState() throws CallError, InterruptedException {
        return (Tuple2<Float, Float>)call("ambianceState").get();
    }

    /**
    * 
    * 
    */
    public String getEmotionalReaction() throws CallError, InterruptedException {
        return (String)call("getEmotionalReaction").get();
    }


    public class AsyncALMood extends ALProxy {

        protected AsyncALMood(){
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
    public Future<Boolean> subscribe(String param1, String param2) throws CallError, InterruptedException {
        return call("subscribe", param1, param2);
    }

    /**
    * 
    * 
    */
    public Future<Boolean> unsubscribe(String param1) throws CallError, InterruptedException {
        return call("unsubscribe", param1);
    }

    /**
    * 
    * 
    */
    public Future<Map<String, String>> getSubscribersInfo() throws CallError, InterruptedException {
        return call("getSubscribersInfo");
    }

    /**
    * 
    * 
    */
    public Future<Tuple5<Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple1<Tuple2<Float, Float>>, Tuple2<Float, Float>, Tuple7<Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>>>> currentPersonState() throws CallError, InterruptedException {
        return call("currentPersonState");
    }

    /**
    * 
    * 
    */
    public Future<Tuple5<Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple1<Tuple2<Float, Float>>, Tuple2<Float, Float>, Tuple7<Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>>>> personStateFromPeoplePerception(Integer param1) throws CallError, InterruptedException {
        return call("personStateFromPeoplePerception", param1);
    }

    /**
    * 
    * 
    */
    public Future<Tuple5<Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple1<Tuple2<Float, Float>>, Tuple2<Float, Float>, Tuple7<Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>>>> personStateFromUserSession(Integer param1) throws CallError, InterruptedException {
        return call("personStateFromUserSession", param1);
    }

    /**
    * 
    * 
    */
    public Future<List<Tuple3<Integer, Integer, Tuple5<Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple1<Tuple2<Float, Float>>, Tuple2<Float, Float>, Tuple7<Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>>>>>> persons() throws CallError, InterruptedException {
        return call("persons");
    }

    /**
    * 
    * 
    */
    public Future<Tuple2<Float, Float>> ambianceState() throws CallError, InterruptedException {
        return call("ambianceState");
    }

    /**
    * 
    * 
    */
    public Future<String> getEmotionalReaction() throws CallError, InterruptedException {
        return call("getEmotionalReaction");
    }

    }
}
    