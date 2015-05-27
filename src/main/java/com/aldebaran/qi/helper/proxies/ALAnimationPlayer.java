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
* @see <a href="http://doc.aldebaran.lan/doc/master/aldeb-doc/naoqi/motion/alanimationplayer.html#alanimationplayer">NAOqi APIs for ALAnimationPlayer </a>
* NAOqi V2.4.x
*/
public class ALAnimationPlayer extends ALProxy {

    private AsyncALAnimationPlayer asyncProxy;

    public ALAnimationPlayer(Session session) throws Exception{
        super(session);
        asyncProxy = new AsyncALAnimationPlayer();
	    asyncProxy.setService(getService());
    }

    /**
     * Get the async version of this proxy
     *
	 * @return a AsyncALAnimationPlayer object
	 */
    public AsyncALAnimationPlayer async() {
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
    public void addTagForAnimations(Map<String, List<String>> param1) throws CallError, InterruptedException{
        call("addTagForAnimations", param1).get();
    }

    /**
    * 
    * 
    */
    public void declarePathForTags(String param1) throws CallError, InterruptedException{
        call("declarePathForTags", param1).get();
    }

    /**
    * 
    * 
    */
    public void reset() throws CallError, InterruptedException{
        call("reset").get();
    }

    /**
    * 
    * 
    */
    public void run(String param1) throws CallError, InterruptedException{
        call("run", param1).get();
    }

    /**
    * 
    * 
    */
    public void runTag(String param1) throws CallError, InterruptedException{
        call("runTag", param1).get();
    }

    /**
    * 
    * 
    */
    public void runTag(String param1, String param2) throws CallError, InterruptedException{
        call("runTag", param1, param2).get();
    }


    public class AsyncALAnimationPlayer extends ALProxy {

        protected AsyncALAnimationPlayer(){
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
    public Future<Void> addTagForAnimations(Map<String, List<String>> param1) throws CallError, InterruptedException{
        return call("addTagForAnimations", param1);
    }

    /**
    * 
    * 
    * @return The Future
    */
    public Future<Void> declarePathForTags(String param1) throws CallError, InterruptedException{
        return call("declarePathForTags", param1);
    }

    /**
    * 
    * 
    * @return The Future
    */
    public Future<Void> reset() throws CallError, InterruptedException{
        return call("reset");
    }

    /**
    * 
    * 
    * @return The Future
    */
    public Future<Void> run(String param1) throws CallError, InterruptedException{
        return call("run", param1);
    }

    /**
    * 
    * 
    * @return The Future
    */
    public Future<Void> runTag(String param1) throws CallError, InterruptedException{
        return call("runTag", param1);
    }

    /**
    * 
    * 
    * @return The Future
    */
    public Future<Void> runTag(String param1, String param2) throws CallError, InterruptedException{
        return call("runTag", param1, param2);
    }

    }
}
    