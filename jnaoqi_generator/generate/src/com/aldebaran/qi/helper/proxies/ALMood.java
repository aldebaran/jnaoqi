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
* @see <a href="http://doc.aldebaran.lan/doc/master/aldeb-doc/naoqi/core/almood.html#almood">NAOqi APIs for ALMood </a>
*
*/
public class ALMood extends ALProxy {

    public ALMood(Session session) {
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
    * 
    * 
    */
    public void subscribe(String param1, String param2) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("subscribe", param1, param2);
        else
            service.call("subscribe", param1, param2).get();
    }

    /**
    * 
    * 
    */
    public void unsubscribe(String param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("unsubscribe", param1);
        else
            service.call("unsubscribe", param1).get();
    }

    /**
    * 
    * 
    */
    public Map<String, String> getSubscribersInfo() throws CallError, InterruptedException {
        return (Map<String, String>)service.call("getSubscribersInfo").get();
    }

    /**
    * 
    * 
    */
    public Tuple5<Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple1<Tuple2<Float, Float>>, Tuple2<Float, Float>, Tuple7<Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>>> currentPersonState() throws CallError, InterruptedException {
        return (Tuple5<Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple1<Tuple2<Float, Float>>, Tuple2<Float, Float>, Tuple7<Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>>>)service.call("currentPersonState").get();
    }

    /**
    * 
    * 
    */
    public Tuple5<Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple1<Tuple2<Float, Float>>, Tuple2<Float, Float>, Tuple7<Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>>> personStateFromPeoplePerception(Integer param1) throws CallError, InterruptedException {
        return (Tuple5<Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple1<Tuple2<Float, Float>>, Tuple2<Float, Float>, Tuple7<Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>>>)service.call("personStateFromPeoplePerception", param1).get();
    }

    /**
    * 
    * 
    */
    public Tuple5<Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple1<Tuple2<Float, Float>>, Tuple2<Float, Float>, Tuple7<Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>>> personStateFromUserSession(Integer param1) throws CallError, InterruptedException {
        return (Tuple5<Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple1<Tuple2<Float, Float>>, Tuple2<Float, Float>, Tuple7<Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>>>)service.call("personStateFromUserSession", param1).get();
    }

    /**
    * 
    * 
    */
    public List<Tuple3<Integer, Integer, Tuple5<Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple1<Tuple2<Float, Float>>, Tuple2<Float, Float>, Tuple7<Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>>>>> persons() throws CallError, InterruptedException {
        return (List<Tuple3<Integer, Integer, Tuple5<Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple1<Tuple2<Float, Float>>, Tuple2<Float, Float>, Tuple7<Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>, Tuple2<Float, Float>>>>>)service.call("persons").get();
    }

    /**
    * 
    * 
    */
    public Tuple2<Float, Float> ambianceState() throws CallError, InterruptedException {
        return (Tuple2<Float, Float>)service.call("ambianceState").get();
    }

    /**
    * 
    * 
    */
    public void startRecording(String param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("startRecording", param1);
        else
            service.call("startRecording", param1).get();
    }

    /**
    * 
    * 
    */
    public void startRecording(String param1, Integer param2) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("startRecording", param1, param2);
        else
            service.call("startRecording", param1, param2).get();
    }

    /**
    * 
    * 
    */
    public String stopRecording(String param1) throws CallError, InterruptedException {
        return (String)service.call("stopRecording", param1).get();
    }

    /**
    * 
    * 
    */
    public String stopRecording(String param1, Boolean param2) throws CallError, InterruptedException {
        return (String)service.call("stopRecording", param1, param2).get();
    }

}
    