/**
 * Copyright (c) 2015 Aldebaran Robotics. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be
 * found in the COPYING file.
 * Created by epinault and tcruz
 */
package com.aldebaran.qi.helper.proxies;

import com.aldebaran.qi.CallError;
import com.aldebaran.qi.Session;
import com.aldebaran.qi.helper.ALProxy;

import java.util.List;
/**
* This module works with Linux Infrared Remote Control (LIRC) in order to emit/receive IR remotes keys or to emit/receive IR information to/from an other Nao.
* @see <a href="http://doc.aldebaran.lan/doc/release-2.1/aldeb-doc/naoqi/sensors/alinfrared.html#alinfrared">NAOqi APIs for ALInfrared </a>
*
*/
public class ALInfrared extends ALProxy {

    public ALInfrared(Session session) throws Exception{
        super(session);
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
    * Exits and unregisters the module.
    * 
    */
    public void exit() throws CallError, InterruptedException{
        call("exit").get();
    }

    /**
    * Returns the version of the module.
    * 
    * @return A string containing the version of the module.
    */
    public String version() throws CallError, InterruptedException {
        return (String)call("version").get();
    }

    /**
    * Just a ping. Always returns true
    * 
    * @return returns true
    */
    public Boolean ping() throws CallError, InterruptedException {
        return (Boolean)call("ping").get();
    }

    /**
    * Retrieves the module's method list.
    * 
    * @return An array of method names.
    */
    public List<String> getMethodList() throws CallError, InterruptedException {
        return (List<String>)call("getMethodList").get();
    }

    /**
    * Retrieves a method's description.
    * 
    * @param methodName  The name of the method.
    * @return A structure containing the method's description.
    */
    public Object getMethodHelp(String methodName) throws CallError, InterruptedException {
        return (Object)call("getMethodHelp", methodName).get();
    }

    /**
    * Retrieves the module's description.
    * 
    * @return A structure describing the module.
    */
    public Object getModuleHelp() throws CallError, InterruptedException {
        return (Object)call("getModuleHelp").get();
    }

    /**
    * Wait for the end of a long running method that was called using 'post'
    * 
    * @param id  The ID of the method that was returned when calling the method using 'post'
    * @param timeoutPeriod  The timeout period in ms. To wait indefinately, use a timeoutPeriod of zero.
    * @return True if the timeout period terminated. False if the method returned.
    */
    public Boolean wait(Integer id, Integer timeoutPeriod) throws CallError, InterruptedException {
        return (Boolean)call("wait", id, timeoutPeriod).get();
    }

    /**
    * Returns true if the method is currently running.
    * 
    * @param id  The ID of the method that was returned when calling the method using 'post'
    * @return True if the method is currently running
    */
    public Boolean isRunning(Integer id) throws CallError, InterruptedException {
        return (Boolean)call("isRunning", id).get();
    }

    /**
    * returns true if the method is currently running
    * 
    * @param id  the ID of the method to wait for
    */
    public void stop(Integer id) throws CallError, InterruptedException{
        call("stop", id).get();
    }

    /**
    * Gets the name of the parent broker.
    * 
    * @return The name of the parent broker.
    */
    public String getBrokerName() throws CallError, InterruptedException {
        return (String)call("getBrokerName").get();
    }

    /**
    * Gets the method usage string. This summarises how to use the method.
    * 
    * @param name  The name of the method.
    * @return A string that summarises the usage of the method.
    */
    public String getUsage(String name) throws CallError, InterruptedException {
        return (String)call("getUsage", name).get();
    }

    /**
    * Init IR reception (connect as a client to the LIRC daemon).
    * 
    * @param RepeatThreshold  Give the keep-pressing threshold after which the repetition of a key is taken into consideration.
    */
    public void initReception(Integer RepeatThreshold) throws CallError, InterruptedException{
        call("initReception", RepeatThreshold).get();
    }

    /**
    * Simulate a remote control (Nao as a remote control).
    * 
    * @param Remote  IR remote control name.
    * @param Key  IR remote control key name.
    */
    public void sendRemoteKey(String Remote, String Key) throws CallError, InterruptedException{
        call("sendRemoteKey", Remote, Key).get();
    }

    /**
    * Simulate a remote control (Nao as a remote control).
    * 
    * @param Remote  IR remote control name.
    * @param Key  IR remote control key name.
    * @param pTimeMs  The time in ms when the remote key must be send. 0 deals like sendRemoteKey
    */
    public void sendRemoteKeyWithTime(String Remote, String Key, Integer pTimeMs) throws CallError, InterruptedException{
        call("sendRemoteKeyWithTime", Remote, Key, pTimeMs).get();
    }

    /**
    * Send an IP by IR.
    * 
    * @param IP  IP adress to send through IR.
    */
    public void sendIpAddress(String IP) throws CallError, InterruptedException{
        call("sendIpAddress", IP).get();
    }

    /**
    * Send 1 octet by IR.
    * 
    * @param Octet  octet to send through IR.
    */
    public void send8(Integer Octet) throws CallError, InterruptedException{
        call("send8", Octet).get();
    }

    /**
    * Send 4 octets by IR.
    * 
    * @param Data_IR  4 octets to send through IR.
    */
    public void send32(String Data_IR) throws CallError, InterruptedException{
        call("send32", Data_IR).get();
    }

    /**
    * Send 4 octets by IR.
    * 
    * @param Octet1  Octet 1 to send through IR.
    * @param Octet2  Octet 2 to send through IR.
    * @param Octet3  Octet 3 to send through IR.
    * @param Octet4  Octet 4 to send through IR.
    */
    public void send32(Integer Octet1, Integer Octet2, Integer Octet3, Integer Octet4) throws CallError, InterruptedException{
        call("send32", Octet1, Octet2, Octet3, Octet4).get();
    }

    /**
    * Rewrite the LIRC daemon configuration file (lircd.conf) with everyremotes configuration concatenated, and reload it in LIRC daemons
    * 
    */
    public void confRemoteRecordSave() throws CallError, InterruptedException{
        call("confRemoteRecordSave").get();
    }

}
    