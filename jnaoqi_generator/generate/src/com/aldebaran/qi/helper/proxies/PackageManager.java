/**
 * Copyright (c) 2015 Aldebaran Robotics. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be
 * found in the COPYING file.
 * Created by epinault and tcruz
 */
package com.aldebaran.qi.helper.proxies;

import com.aldebaran.qi.*;
import com.aldebaran.qi.helper.ALProxy;

import java.util.List;
import java.util.Map;
/**
* 
* @see <a href="http://doc.aldebaran.com/2-1/naoqi/core/packagemanager.html#packagemanager">NAOqi APIs for PackageManager </a>
*
*/
public class PackageManager extends ALProxy {

    private AsyncPackageManager asyncProxy;

    public PackageManager(Session session) throws Exception{
        super(session);
        asyncProxy = new AsyncPackageManager();
	    asyncProxy.setService(getService());
    }

    /**
     * Get the async version of this proxy
     *
	 * @return a AsyncPackageManager object
	 */
    public AsyncPackageManager async() {
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
    public Boolean install(String param1) throws CallError, InterruptedException {
        return (Boolean)call("install", param1).get();
    }

    /**
    * 
    * 
    */
    public Boolean installCheckMd5(String param1, String param2) throws CallError, InterruptedException {
        return (Boolean)call("installCheckMd5", param1, param2).get();
    }

    /**
    * 
    * 
    */
    public void setServiceDirectory(String param1) throws CallError, InterruptedException{
        call("setServiceDirectory", param1).get();
    }

    /**
    * 
    * 
    */
    public Boolean hasPackage(String param1) throws CallError, InterruptedException {
        return (Boolean)call("hasPackage", param1).get();
    }

    /**
    * 
    * 
    */
    public List<Tuple10<String, String, String, String, String, String, String, String, String, Map<String, Object>>> packages2() throws CallError, InterruptedException {
        return (List<Tuple10<String, String, String, String, String, String, String, String, String, Map<String, Object>>>)call("packages2").get();
    }

    /**
    * 
    * 
    */
    public Tuple10<String, String, String, String, String, String, String, String, String, Map<String, Object>> package2(String param1) throws CallError, InterruptedException {
        return (Tuple10<String, String, String, String, String, String, String, String, String, Map<String, Object>>)call("package2", param1).get();
    }

    /**
    * 
    * 
    */
    public String packageIcon(String param1) throws CallError, InterruptedException {
        return (String)call("packageIcon", param1).get();
    }

    /**
    * 
    * 
    */
    public void removePkg(String param1) throws CallError, InterruptedException{
        call("removePkg", param1).get();
    }

    /**
    * 
    * 
    */
    public Object getPackages() throws CallError, InterruptedException {
        return (Object)call("getPackages").get();
    }

    /**
    * 
    * 
    */
    public List<Tuple20<String, String, String, String, String, String, String, String, Map<String, String>, Map<String, String>, List<String>, List<Tuple10<String, String, Map<String, String>, Map<String, String>, String, Map<String, List<String>>, Map<String, List<String>>, Map<String, List<String>>, Map<String, List<String>>, List<String>>>, List<Tuple5<String, String, String, String, Map<String, String>>>, String, List<Tuple5<String, String, String, String, String>>, List<Tuple2<String, String>>, List<Tuple3<String, String, Boolean>>, List<String>, List<Tuple3<String, String, Map<String, String>>>, List<String>>> packages() throws CallError, InterruptedException {
        return (List<Tuple20<String, String, String, String, String, String, String, String, Map<String, String>, Map<String, String>, List<String>, List<Tuple10<String, String, Map<String, String>, Map<String, String>, String, Map<String, List<String>>, Map<String, List<String>>, Map<String, List<String>>, Map<String, List<String>>, List<String>>>, List<Tuple5<String, String, String, String, Map<String, String>>>, String, List<Tuple5<String, String, String, String, String>>, List<Tuple2<String, String>>, List<Tuple3<String, String, Boolean>>, List<String>, List<Tuple3<String, String, Map<String, String>>>, List<String>>>)call("packages").get();
    }

    /**
    * 
    * 
    */
    public Tuple20<String, String, String, String, String, String, String, String, Map<String, String>, Map<String, String>, List<String>, List<Tuple10<String, String, Map<String, String>, Map<String, String>, String, Map<String, List<String>>, Map<String, List<String>>, Map<String, List<String>>, Map<String, List<String>>, List<String>>>, List<Tuple5<String, String, String, String, Map<String, String>>>, String, List<Tuple5<String, String, String, String, String>>, List<Tuple2<String, String>>, List<Tuple3<String, String, Boolean>>, List<String>, List<Tuple3<String, String, Map<String, String>>>, List<String>> package1(String param1) throws CallError, InterruptedException {
        return (Tuple20<String, String, String, String, String, String, String, String, Map<String, String>, Map<String, String>, List<String>, List<Tuple10<String, String, Map<String, String>, Map<String, String>, String, Map<String, List<String>>, Map<String, List<String>>, Map<String, List<String>>, Map<String, List<String>>, List<String>>>, List<Tuple5<String, String, String, String, Map<String, String>>>, String, List<Tuple5<String, String, String, String, String>>, List<Tuple2<String, String>>, List<Tuple3<String, String, Boolean>>, List<String>, List<Tuple3<String, String, Map<String, String>>>, List<String>>)call("package", param1).get();
    }

    /**
    * 
    * 
    */
    public Object getPackage(String param1) throws CallError, InterruptedException {
        return (Object)call("getPackage", param1).get();
    }

    /**
    * 
    * 
    */
    public Object getPackageIcon(String param1) throws CallError, InterruptedException {
        return (Object)call("getPackageIcon", param1).get();
    }

    /**
    * 
    * 
    */
    public Integer install(String param1, String param2) throws CallError, InterruptedException {
        return (Integer)call("install", param1, param2).get();
    }

    /**
    * 
    * 
    */
    public Integer install(String param1, String param2, String param3) throws CallError, InterruptedException {
        return (Integer)call("install", param1, param2, param3).get();
    }

    /**
    * 
    * 
    */
    public Integer remove(String param1) throws CallError, InterruptedException {
        return (Integer)call("remove", param1).get();
    }


    public class AsyncPackageManager extends ALProxy {

        protected AsyncPackageManager(){
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
    public Future<Boolean> install(String param1) throws CallError, InterruptedException {
        return call("install", param1);
    }

    /**
    * 
    * 
    */
    public Future<Boolean> installCheckMd5(String param1, String param2) throws CallError, InterruptedException {
        return call("installCheckMd5", param1, param2);
    }

    /**
    * 
    * 
    * @return The Future
    */
    public Future<Void> setServiceDirectory(String param1) throws CallError, InterruptedException{
        return call("setServiceDirectory", param1);
    }

    /**
    * 
    * 
    */
    public Future<Boolean> hasPackage(String param1) throws CallError, InterruptedException {
        return call("hasPackage", param1);
    }

    /**
    * 
    * 
    */
    public Future<List<Tuple10<String, String, String, String, String, String, String, String, String, Map<String, Object>>>> packages2() throws CallError, InterruptedException {
        return call("packages2");
    }

    /**
    * 
    * 
    */
    public Future<Tuple10<String, String, String, String, String, String, String, String, String, Map<String, Object>>> package2(String param1) throws CallError, InterruptedException {
        return call("package2", param1);
    }

    /**
    * 
    * 
    */
    public Future<String> packageIcon(String param1) throws CallError, InterruptedException {
        return call("packageIcon", param1);
    }

    /**
    * 
    * 
    * @return The Future
    */
    public Future<Void> removePkg(String param1) throws CallError, InterruptedException{
        return call("removePkg", param1);
    }

    /**
    * 
    * 
    */
    public Future<Object> getPackages() throws CallError, InterruptedException {
        return call("getPackages");
    }

    /**
    * 
    * 
    */
    public Future<List<Tuple20<String, String, String, String, String, String, String, String, Map<String, String>, Map<String, String>, List<String>, List<Tuple10<String, String, Map<String, String>, Map<String, String>, String, Map<String, List<String>>, Map<String, List<String>>, Map<String, List<String>>, Map<String, List<String>>, List<String>>>, List<Tuple5<String, String, String, String, Map<String, String>>>, String, List<Tuple5<String, String, String, String, String>>, List<Tuple2<String, String>>, List<Tuple3<String, String, Boolean>>, List<String>, List<Tuple3<String, String, Map<String, String>>>, List<String>>>> packages() throws CallError, InterruptedException {
        return call("packages");
    }

    /**
    * 
    * 
    */
    public Future<Tuple20<String, String, String, String, String, String, String, String, Map<String, String>, Map<String, String>, List<String>, List<Tuple10<String, String, Map<String, String>, Map<String, String>, String, Map<String, List<String>>, Map<String, List<String>>, Map<String, List<String>>, Map<String, List<String>>, List<String>>>, List<Tuple5<String, String, String, String, Map<String, String>>>, String, List<Tuple5<String, String, String, String, String>>, List<Tuple2<String, String>>, List<Tuple3<String, String, Boolean>>, List<String>, List<Tuple3<String, String, Map<String, String>>>, List<String>>> package1(String param1) throws CallError, InterruptedException {
        return call("package", param1);
    }

    /**
    * 
    * 
    */
    public Future<Object> getPackage(String param1) throws CallError, InterruptedException {
        return call("getPackage", param1);
    }

    /**
    * 
    * 
    */
    public Future<Object> getPackageIcon(String param1) throws CallError, InterruptedException {
        return call("getPackageIcon", param1);
    }

    /**
    * 
    * 
    */
    public Future<Integer> install(String param1, String param2) throws CallError, InterruptedException {
        return call("install", param1, param2);
    }

    /**
    * 
    * 
    */
    public Future<Integer> install(String param1, String param2, String param3) throws CallError, InterruptedException {
        return call("install", param1, param2, param3);
    }

    /**
    * 
    * 
    */
    public Future<Integer> remove(String param1) throws CallError, InterruptedException {
        return call("remove", param1);
    }

    }
}
    