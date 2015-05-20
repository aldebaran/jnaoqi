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

import java.util.List;
/**
* 
* @see <a href="http://doc.aldebaran.lan/doc/master/aldeb-doc/naoqi/core/alknowledge.html#alknowledge">NAOqi APIs for ALKnowledge </a>
* NAOqi V2.4.x
*/
public class ALKnowledge extends ALProxy {

    private AsyncALKnowledge asyncProxy;

    public ALKnowledge(Session session) throws Exception{
        super(session);
        asyncProxy = new AsyncALKnowledge();
	    asyncProxy.setService(getService());
    }

    /**
     * Get the async version of this proxy
     *
	 * @return a AsyncALKnowledge object
	 */
    public AsyncALKnowledge async() {
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
    public void add(String param1, String param2, String param3, String param4) throws CallError, InterruptedException{
        call("add", param1, param2, param3, param4).get();
    }

    /**
    * 
    * 
    */
    public List<String> getSubject(String param1, String param2, String param3) throws CallError, InterruptedException {
        return (List<String>)call("getSubject", param1, param2, param3).get();
    }

    /**
    * 
    * 
    */
    public List<String> getPredicate(String param1, String param2, String param3) throws CallError, InterruptedException {
        return (List<String>)call("getPredicate", param1, param2, param3).get();
    }

    /**
    * 
    * 
    */
    public List<String> getObject(String param1, String param2, String param3) throws CallError, InterruptedException {
        return (List<String>)call("getObject", param1, param2, param3).get();
    }

    /**
    * 
    * 
    */
    public void update(String param1, String param2, String param3, String param4) throws CallError, InterruptedException{
        call("update", param1, param2, param3, param4).get();
    }

    /**
    * 
    * 
    */
    public List<String> query(String param1, String param2, String param3, String param4) throws CallError, InterruptedException {
        return (List<String>)call("query", param1, param2, param3, param4).get();
    }

    /**
    * 
    * 
    */
    public void remove(String param1, String param2, String param3, String param4) throws CallError, InterruptedException{
        call("remove", param1, param2, param3, param4).get();
    }

    /**
    * 
    * 
    */
    public Boolean contains(String param1, String param2, String param3, String param4) throws CallError, InterruptedException {
        return (Boolean)call("contains", param1, param2, param3, param4).get();
    }

    /**
    * 
    * 
    */
    public Boolean addRule(String param1) throws CallError, InterruptedException {
        return (Boolean)call("addRule", param1).get();
    }

    /**
    * 
    * 
    */
    public void performInference() throws CallError, InterruptedException{
        call("performInference").get();
    }

    /**
    * 
    * 
    */
    public void resetKnowledge(String param1) throws CallError, InterruptedException{
        call("resetKnowledge", param1).get();
    }

    /**
    * 
    * 
    */
    public void exportModel(String param1, String param2, String param3) throws CallError, InterruptedException{
        call("exportModel", param1, param2, param3).get();
    }

    /**
    * 
    * 
    */
    public void importModel(String param1, String param2, String param3) throws CallError, InterruptedException{
        call("importModel", param1, param2, param3).get();
    }

    /**
    * 
    * 
    */
    public List<String> sparqlQuery(String param1) throws CallError, InterruptedException {
        return (List<String>)call("sparqlQuery", param1).get();
    }


    public class AsyncALKnowledge extends ALProxy {

        protected AsyncALKnowledge(){
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
    * @return The Future
    */
    public Future<Void> add(String param1, String param2, String param3, String param4) throws CallError, InterruptedException{
        return call("add", param1, param2, param3, param4);
    }

    /**
    * 
    * 
    */
    public Future<List<String>> getSubject(String param1, String param2, String param3) throws CallError, InterruptedException {
        return call("getSubject", param1, param2, param3);
    }

    /**
    * 
    * 
    */
    public Future<List<String>> getPredicate(String param1, String param2, String param3) throws CallError, InterruptedException {
        return call("getPredicate", param1, param2, param3);
    }

    /**
    * 
    * 
    */
    public Future<List<String>> getObject(String param1, String param2, String param3) throws CallError, InterruptedException {
        return call("getObject", param1, param2, param3);
    }

    /**
    * 
    * 
    * @return The Future
    */
    public Future<Void> update(String param1, String param2, String param3, String param4) throws CallError, InterruptedException{
        return call("update", param1, param2, param3, param4);
    }

    /**
    * 
    * 
    */
    public Future<List<String>> query(String param1, String param2, String param3, String param4) throws CallError, InterruptedException {
        return call("query", param1, param2, param3, param4);
    }

    /**
    * 
    * 
    * @return The Future
    */
    public Future<Void> remove(String param1, String param2, String param3, String param4) throws CallError, InterruptedException{
        return call("remove", param1, param2, param3, param4);
    }

    /**
    * 
    * 
    */
    public Future<Boolean> contains(String param1, String param2, String param3, String param4) throws CallError, InterruptedException {
        return call("contains", param1, param2, param3, param4);
    }

    /**
    * 
    * 
    */
    public Future<Boolean> addRule(String param1) throws CallError, InterruptedException {
        return call("addRule", param1);
    }

    /**
    * 
    * 
    * @return The Future
    */
    public Future<Void> performInference() throws CallError, InterruptedException{
        return call("performInference");
    }

    /**
    * 
    * 
    * @return The Future
    */
    public Future<Void> resetKnowledge(String param1) throws CallError, InterruptedException{
        return call("resetKnowledge", param1);
    }

    /**
    * 
    * 
    * @return The Future
    */
    public Future<Void> exportModel(String param1, String param2, String param3) throws CallError, InterruptedException{
        return call("exportModel", param1, param2, param3);
    }

    /**
    * 
    * 
    * @return The Future
    */
    public Future<Void> importModel(String param1, String param2, String param3) throws CallError, InterruptedException{
        return call("importModel", param1, param2, param3);
    }

    /**
    * 
    * 
    */
    public Future<List<String>> sparqlQuery(String param1) throws CallError, InterruptedException {
        return call("sparqlQuery", param1);
    }

    }
}
    