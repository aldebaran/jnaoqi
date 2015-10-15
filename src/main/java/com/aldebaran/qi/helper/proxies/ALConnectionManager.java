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
* @see <a href="http://doc.aldebaran.lan/doc/release-2.3/aldeb-doc/naoqi/connectionmanager/index.html#alconnectionmanager">NAOqi APIs for ALConnectionManager </a>
* NAOqi V2.3.x
*/
public class ALConnectionManager extends ALProxy {

    private AsyncALConnectionManager asyncProxy;

    public ALConnectionManager(Session session) throws Exception{
        super(session);
        asyncProxy = new AsyncALConnectionManager();
	    asyncProxy.setService(getService());
    }

    /**
     * Get the async version of this proxy
     *
	 * @return a AsyncALConnectionManager object
	 */
    public AsyncALConnectionManager async() {
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
    public Object services() throws CallError, InterruptedException {
        return (Object)call("services").get();
    }

    /**
    * 
    * 
    */
    public Object service(String param1) throws CallError, InterruptedException {
        return (Object)call("service", param1).get();
    }

    /**
    * 
    * 
    */
    public void scan(String param1) throws CallError, InterruptedException{
        call("scan", param1).get();
    }

    /**
    * 
    * 
    */
    public void scan() throws CallError, InterruptedException{
        call("scan").get();
    }

    /**
    * 
    * 
    */
    public void setServiceConfiguration(Object param1) throws CallError, InterruptedException{
        call("setServiceConfiguration", param1).get();
    }

    /**
    * 
    * 
    */
    public void setServiceInput(Object param1) throws CallError, InterruptedException{
        call("setServiceInput", param1).get();
    }

    /**
    * 
    * 
    */
    public String state() throws CallError, InterruptedException {
        return (String)call("state").get();
    }

    /**
    * 
    * 
    */
    public void forget(String param1) throws CallError, InterruptedException{
        call("forget", param1).get();
    }

    /**
    * 
    * 
    */
    public void connect(String param1) throws CallError, InterruptedException{
        call("connect", param1).get();
    }

    /**
    * 
    * 
    */
    public void disconnect(String param1) throws CallError, InterruptedException{
        call("disconnect", param1).get();
    }

    /**
    * 
    * 
    */
    public Object technologies() throws CallError, InterruptedException {
        return (Object)call("technologies").get();
    }

    /**
    * 
    * 
    */
    public void enableTethering(String param1, String param2, String param3) throws CallError, InterruptedException{
        call("enableTethering", param1, param2, param3).get();
    }

    /**
    * 
    * 
    */
    public void enableTethering(String param1) throws CallError, InterruptedException{
        call("enableTethering", param1).get();
    }

    /**
    * 
    * 
    */
    public void disableTethering(String param1) throws CallError, InterruptedException{
        call("disableTethering", param1).get();
    }

    /**
    * 
    * 
    */
    public Boolean getTetheringEnable(String param1) throws CallError, InterruptedException {
        return (Boolean)call("getTetheringEnable", param1).get();
    }

    /**
    * 
    * 
    */
    public String tetheringName(String param1) throws CallError, InterruptedException {
        return (String)call("tetheringName", param1).get();
    }

    /**
    * 
    * 
    */
    public String tetheringPassphrase(String param1) throws CallError, InterruptedException {
        return (String)call("tetheringPassphrase", param1).get();
    }

    /**
    * 
    * 
    */
    public List<String> countries() throws CallError, InterruptedException {
        return (List<String>)call("countries").get();
    }

    /**
    * 
    * 
    */
    public void setCountry(String param1) throws CallError, InterruptedException{
        call("setCountry", param1).get();
    }

    /**
    * 
    * 
    */
    public String country() throws CallError, InterruptedException {
        return (String)call("country").get();
    }

    /**
    * 
    * 
    */
    public Object interfaces() throws CallError, InterruptedException {
        return (Object)call("interfaces").get();
    }

    /**
    * 
    * 
    */
    public void provisionService(Map<String, String> param1) throws CallError, InterruptedException{
        call("provisionService", param1).get();
    }

    /**
    * 
    * 
    */
    public List<Map<String, String>> provisionedServices() throws CallError, InterruptedException {
        return (List<Map<String, String>>)call("provisionedServices").get();
    }

    /**
    * 
    * 
    */
    public void removeProvisionedService(String param1) throws CallError, InterruptedException{
        call("removeProvisionedService", param1).get();
    }


    public class AsyncALConnectionManager extends ALProxy {

        protected AsyncALConnectionManager(){
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
    public Future<Object> services() throws CallError, InterruptedException {
        return call("services");
    }

    /**
    * 
    * 
    */
    public Future<Object> service(String param1) throws CallError, InterruptedException {
        return call("service", param1);
    }

    /**
    * 
    * 
    * @return The Future
    */
    public Future<Void> scan(String param1) throws CallError, InterruptedException{
        return call("scan", param1);
    }

    /**
    * 
    * 
    * @return The Future
    */
    public Future<Void> scan() throws CallError, InterruptedException{
        return call("scan");
    }

    /**
    * 
    * 
    * @return The Future
    */
    public Future<Void> setServiceConfiguration(Object param1) throws CallError, InterruptedException{
        return call("setServiceConfiguration", param1);
    }

    /**
    * 
    * 
    * @return The Future
    */
    public Future<Void> setServiceInput(Object param1) throws CallError, InterruptedException{
        return call("setServiceInput", param1);
    }

    /**
    * 
    * 
    */
    public Future<String> state() throws CallError, InterruptedException {
        return call("state");
    }

    /**
    * 
    * 
    * @return The Future
    */
    public Future<Void> forget(String param1) throws CallError, InterruptedException{
        return call("forget", param1);
    }

    /**
    * 
    * 
    * @return The Future
    */
    public Future<Void> connect(String param1) throws CallError, InterruptedException{
        return call("connect", param1);
    }

    /**
    * 
    * 
    * @return The Future
    */
    public Future<Void> disconnect(String param1) throws CallError, InterruptedException{
        return call("disconnect", param1);
    }

    /**
    * 
    * 
    */
    public Future<Object> technologies() throws CallError, InterruptedException {
        return call("technologies");
    }

    /**
    * 
    * 
    * @return The Future
    */
    public Future<Void> enableTethering(String param1, String param2, String param3) throws CallError, InterruptedException{
        return call("enableTethering", param1, param2, param3);
    }

    /**
    * 
    * 
    * @return The Future
    */
    public Future<Void> enableTethering(String param1) throws CallError, InterruptedException{
        return call("enableTethering", param1);
    }

    /**
    * 
    * 
    * @return The Future
    */
    public Future<Void> disableTethering(String param1) throws CallError, InterruptedException{
        return call("disableTethering", param1);
    }

    /**
    * 
    * 
    */
    public Future<Boolean> getTetheringEnable(String param1) throws CallError, InterruptedException {
        return call("getTetheringEnable", param1);
    }

    /**
    * 
    * 
    */
    public Future<String> tetheringName(String param1) throws CallError, InterruptedException {
        return call("tetheringName", param1);
    }

    /**
    * 
    * 
    */
    public Future<String> tetheringPassphrase(String param1) throws CallError, InterruptedException {
        return call("tetheringPassphrase", param1);
    }

    /**
    * 
    * 
    */
    public Future<List<String>> countries() throws CallError, InterruptedException {
        return call("countries");
    }

    /**
    * 
    * 
    * @return The Future
    */
    public Future<Void> setCountry(String param1) throws CallError, InterruptedException{
        return call("setCountry", param1);
    }

    /**
    * 
    * 
    */
    public Future<String> country() throws CallError, InterruptedException {
        return call("country");
    }

    /**
    * 
    * 
    */
    public Future<Object> interfaces() throws CallError, InterruptedException {
        return call("interfaces");
    }

    /**
    * 
    * 
    * @return The Future
    */
    public Future<Void> provisionService(Map<String, String> param1) throws CallError, InterruptedException{
        return call("provisionService", param1);
    }

    /**
    * 
    * 
    */
    public Future<List<Map<String, String>>> provisionedServices() throws CallError, InterruptedException {
        return call("provisionedServices");
    }

    /**
    * 
    * 
    * @return The Future
    */
    public Future<Void> removeProvisionedService(String param1) throws CallError, InterruptedException{
        return call("removeProvisionedService", param1);
    }

    }
}
    