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
* @see <a href="http://doc.aldebaran.lan/doc/master/aldeb-doc/naoqi/core/alknowledge.html#alknowledge">NAOqi APIs for ALKnowledge </a>
*
*/
public class ALKnowledge extends ALProxy {

    public ALKnowledge(Session session) {
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
    public void add(String param1, String param2, String param3, String param4) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("add", param1, param2, param3, param4);
        else
            service.call("add", param1, param2, param3, param4).get();
    }

    /**
    * 
    * 
    */
    public List<String> getSubject(String param1, String param2, String param3) throws CallError, InterruptedException {
        return (List<String>)service.call("getSubject", param1, param2, param3).get();
    }

    /**
    * 
    * 
    */
    public List<String> getPredicate(String param1, String param2, String param3) throws CallError, InterruptedException {
        return (List<String>)service.call("getPredicate", param1, param2, param3).get();
    }

    /**
    * 
    * 
    */
    public List<String> getObject(String param1, String param2, String param3) throws CallError, InterruptedException {
        return (List<String>)service.call("getObject", param1, param2, param3).get();
    }

    /**
    * 
    * 
    */
    public void update(String param1, String param2, String param3, String param4) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("update", param1, param2, param3, param4);
        else
            service.call("update", param1, param2, param3, param4).get();
    }

    /**
    * 
    * 
    */
    public List<String> query(String param1, String param2, String param3, String param4) throws CallError, InterruptedException {
        return (List<String>)service.call("query", param1, param2, param3, param4).get();
    }

    /**
    * 
    * 
    */
    public void remove(String param1, String param2, String param3, String param4) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("remove", param1, param2, param3, param4);
        else
            service.call("remove", param1, param2, param3, param4).get();
    }

    /**
    * 
    * 
    */
    public Boolean contains(String param1, String param2, String param3, String param4) throws CallError, InterruptedException {
        return (Boolean)service.call("contains", param1, param2, param3, param4).get();
    }

    /**
    * 
    * 
    */
    public Boolean addRule(String param1) throws CallError, InterruptedException {
        return (Boolean)service.call("addRule", param1).get();
    }

    /**
    * 
    * 
    */
    public void performInference() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("performInference");
        else
            service.call("performInference").get();
    }

    /**
    * 
    * 
    */
    public void resetKnowledge(String param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("resetKnowledge", param1);
        else
            service.call("resetKnowledge", param1).get();
    }

    /**
    * 
    * 
    */
    public void exportModel(String param1, String param2) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("exportModel", param1, param2);
        else
            service.call("exportModel", param1, param2).get();
    }

    /**
    * 
    * 
    */
    public void importModel(String param1, String param2) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("importModel", param1, param2);
        else
            service.call("importModel", param1, param2).get();
    }

    /**
    * 
    * 
    */
    public List<String> sparqlQuery(String param1) throws CallError, InterruptedException {
        return (List<String>)service.call("sparqlQuery", param1).get();
    }

}
    