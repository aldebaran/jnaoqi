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
* @see <a href="http://doc.aldebaran.lan/doc/master/aldeb-doc/naoqi/sensors/altactilegesture.html#altactilegesture">NAOqi APIs for ALTactileGesture </a>
*
*/
public class ALTactileGesture extends ALProxy {

    public ALTactileGesture(Session session) {
        super(session);
    }

    /**
    * Set length of sequence time.

        :param sequence_time: Desired sequence time, in seconds (Default: 0.2s)

        :returns: True if sequence time successfully updated, RuntimeError otherwise.
    * 
    */
    public Boolean setSequenceTime(String param1) throws CallError, InterruptedException {
        return (Boolean)service.call("setSequenceTime", param1).get();
    }

    /**
    * Get the sequence associated with a gesture name

        :param sequence: Sequence you want the gesture name of

        :returns: Sequence (as list of strings) if it exists, None otherwise
    * 
    */
    public Object getGesture(List<String> param1) throws CallError, InterruptedException {
        return (Object)service.call("getGesture", param1).get();
    }

    /**
    * Update length of settling time.

        :param settle_time: Desired settling time, in seconds (Default: 0.04s)

        :returns: True if settle time successfully updated, RuntimeError otherwise.
    * 
    */
    public Boolean setSettleTime(String param1) throws CallError, InterruptedException {
        return (Boolean)service.call("setSettleTime", param1).get();
    }

    /**
    * Get all gestures that have been defined in the system

        :returns: Dictionary (Map<String, List<String>>) of all gestures
    * 
    */
    public Map<String, List<String>> getGestures() throws CallError, InterruptedException {
        return (Map<String, List<String>>)service.call("getGestures").get();
    }

    /**
    * Get the sequence associated with a gesture name

        :param gesture_name: Name of gesture you want the sequence of

        :returns: Sequence (as list of strings) if it exists, None otherwise
        
    * 
    */
    public List<String> getSequence(String param1) throws CallError, InterruptedException {
        return (List<String>)service.call("getSequence", param1).get();
    }

    /**
    * Set length of hold time.

        :param hold_time: Desired hold time, in seconds (Default: 0.8s)

        :returns: True if hold time successfully updated, RuntimeError otherwise.
    * 
    */
    public Boolean setHoldTime(Float param1) throws CallError, InterruptedException {
        return (Boolean)service.call("setHoldTime", param1).get();
    }

    /**
    * Get the sequence associated with a gesture name

        :param sequence: Sequence you want the gesture name of

        :returns: Sequence (as list of strings) if it exists, None otherwise
    * 
    */
    public Object getGesture(String param1) throws CallError, InterruptedException {
        return (Object)service.call("getGesture", param1).get();
    }

    /**
    * Set length of hold time.

        :param hold_time: Desired hold time, in seconds (Default: 0.8s)

        :returns: True if hold time successfully updated, RuntimeError otherwise.
    * 
    */
    public Boolean setHoldTime(String param1) throws CallError, InterruptedException {
        return (Boolean)service.call("setHoldTime", param1).get();
    }

    /**
    * Update length of sequence time.

        :param sequence_time: Desired sequence time, in seconds (Default: 0.2s)

        :returns: True if sequence time successfully updated, RuntimeError otherwise.
    * 
    */
    public Boolean setSequenceTime(Float param1) throws CallError, InterruptedException {
        return (Boolean)service.call("setSequenceTime", param1).get();
    }

    /**
    * Update length of settling time.

        :param settle_time: Desired settling time, in seconds (Default: 0.04s)

        :returns: True if settle time successfully updated, RuntimeError otherwise.
    * 
    */
    public Boolean setSettleTime(Float param1) throws CallError, InterruptedException {
        return (Boolean)service.call("setSettleTime", param1).get();
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
    * Define touch gesture.

        :param sensor_sequence: List of strings that represent the
        sequence of the desired gesture. For example, SingleFront
        would be the following: ['000', '100', '000']. NOTE: All
        sequences must start with '000' and all non-hold sequences
        must end with '000'. Hold gestures should end with the touch
        sequence you will be holding. For example, a SingleFrontHold
        would be the following: ['000', '100'].

        :returns: If sequence is valid, the name of gesture to listen
        for, RuntimeError otherwise.
    * 
    */
    public String createGesture(List<String> param1) throws CallError, InterruptedException {
        return (String)service.call("createGesture", param1).get();
    }

    /**
    * Define touch gesture.

        :param sensor_sequence: Comma-separated string that represents
        the sequence of the desired gesture. For example, SingleFront
        would be the following: "000,100,000". NOTE: All sequences
        must start with '000' and all non-hold sequences must end with
        '000'. Hold gestures should end with the touch sequence you
        will be holding. For example, a SingleFrontHold would be the
        following: "000,100".

        :returns: If sequence is valid, the name of gesture to listen
        for, RuntimeError otherwise.
    * 
    */
    public String createGesture(String param1) throws CallError, InterruptedException {
        return (String)service.call("createGesture", param1).get();
    }

}
    