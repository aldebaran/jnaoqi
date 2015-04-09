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
* This module allows you to control NAO's LEDs. It provides simple ways of setting or fading the intensity of single LEDs and groups of LEDs. 
Groups of LEDs typically include face LEDs, ear LEDs etc. It is also possible to control each LED separately (for example, each of the 8 LEDs in one NAO's eyes).
There are three primary colors of LEDs available - red, green and blue, so it is possible to combine them to obtain different colors. The ears contain blue LEDs only.
It is possible to control the LED's intensity (between 0 and 100%).
* @see <a href="http://doc.aldebaran.com/2-1/naoqi/sensors/alleds.html#alleds">NAOqi APIs for ALLeds </a>
*
*/
public class ALLeds extends ALProxy {

    private AsyncALLeds asyncProxy;

    public ALLeds(Session session) throws Exception{
        super(session);
        asyncProxy = new AsyncALLeds();
	    asyncProxy.setService(getService());
    }

    /**
     * Get the async version of this proxy
     *
	 * @return a AsyncALLeds object
	 */
    public AsyncALLeds async() {
        return asyncProxy;
    }

    /**
    * Sets the intensity of a LED or Group of LEDs.
    * 
    * @param name  The name of the LED or Group.
    * @param intensity  The intensity of the LED or Group (a value between 0 and 1).
    */
    public void setIntensity(String name, Float intensity) throws CallError, InterruptedException{
        call("setIntensity", name, intensity).get();
    }

    /**
    * Switch to a maximum intensity a LED or Group of LEDs.
    * 
    * @param name  The name of the LED or Group.
    */
    public void on(String name) throws CallError, InterruptedException{
        call("on", name).get();
    }

    /**
    * Launch a rotation using the leds of the eyes.
    * 
    * @param rgb  the RGB value led, RGB as seen in hexa-decimal: 0x00RRGGBB.
    * @param timeForRotation  Approximate time to make one turn.
    * @param totalDuration  Approximate duration of the animation in seconds.
    */
    public void rotateEyes(Integer rgb, Float timeForRotation, Float totalDuration) throws CallError, InterruptedException{
        call("rotateEyes", rgb, timeForRotation, totalDuration).get();
    }

    /**
    * Launch a random animation in eyes
    * 
    * @param duration  Approximate duration of the animation in seconds.
    */
    public void randomEyes(Float duration) throws CallError, InterruptedException{
        call("randomEyes", duration).get();
    }

    /**
    * Launch a green/yellow/red rasta animation on all body.
    * 
    * @param duration  Approximate duration of the animation in seconds.
    */
    public void rasta(Float duration) throws CallError, InterruptedException{
        call("rasta", duration).get();
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
    * Makes a group name for ease of setting multiple LEDs.
    * 
    * @param groupName  The name of the group.
    * @param ledNames  A vector of the names of the LEDs in the group.
    */
    public void createGroup(String groupName, List<String> ledNames) throws CallError, InterruptedException{
        call("createGroup", groupName, ledNames).get();
    }

    /**
    * An animation to show a direction with the ears.
    * 
    * @param degrees  The angle you want to show in degrees (int). 0 is up, 90 is forwards, 180 is down and 270 is back.
    * @param duration  The duration in seconds of the animation.
    * @param leaveOnAtEnd  If true the last led is left on at the end of the animation.
    */
    public void earLedsSetAngle(Integer degrees, Float duration, Boolean leaveOnAtEnd) throws CallError, InterruptedException{
        call("earLedsSetAngle", degrees, duration, leaveOnAtEnd).get();
    }

    /**
    * Sets the intensity of a LED or Group of LEDs within a given time.
    * 
    * @param name  The name of the LED or Group.
    * @param intensity  The intensity of the LED or Group (a value between 0 and 1).
    * @param duration  The duration of the fade in seconds
    */
    public void fade(String name, Float intensity, Float duration) throws CallError, InterruptedException{
        call("fade", name, intensity, duration).get();
    }

    /**
    * Chain a list of color for a device, as the motion.doMove command.
    * 
    * @param name  The name of the LED or Group.
    * @param rgbList  List of RGB led value, RGB as seen in hexa-decimal: 0x00RRGGBB.
    * @param timeList  List of time to go to given intensity.
    */
    public void fadeListRGB(String name, Object rgbList, Object timeList) throws CallError, InterruptedException{
        call("fadeListRGB", name, rgbList, timeList).get();
    }

    /**
    * Sets the color of an RGB led.
    * 
    * @param name  The name of the LED or Group.
    * @param red  the intensity of red channel (0-1).
    * @param green  the intensity of green channel (0-1).
    * @param blue  the intensity of blue channel (0-1).
    * @param duration  Time used to fade in seconds.
    */
    public void fadeRGB(String name, Float red, Float green, Float blue, Float duration) throws CallError, InterruptedException{
        call("fadeRGB", name, red, green, blue, duration).get();
    }

    /**
    * Sets the color of an RGB led.
    * 
    * @param name  The name of the LED or Group.
    * @param colorName  the name of the color (supported colors: "white", "red", "green", "blue", "yellow", "magenta", "cyan")
    * @param duration  Time used to fade in seconds.
    */
    public void fadeRGB(String name, String colorName, Float duration) throws CallError, InterruptedException{
        call("fadeRGB", name, colorName, duration).get();
    }

    /**
    * Sets the color of an RGB led.
    * 
    * @param name  The name of the LED or Group.
    * @param rgb  The RGB value led, RGB as seen in hexa-decimal: 0x00RRGGBB.
    * @param duration  Time used to fade in seconds.
    */
    public void fadeRGB(String name, Integer rgb, Float duration) throws CallError, InterruptedException{
        call("fadeRGB", name, rgb, duration).get();
    }

    /**
    * Resets the state of the leds to default (for ex, eye LEDs are white and fully on by default).
    * 
    * @param name  The name of the LED or Group (for now, only "AllLeds" are implemented).
    */
    public void reset(String name) throws CallError, InterruptedException{
        call("reset", name).get();
    }

    /**
    * Gets the intensity of a LED or device
    * 
    * @param name  The name of the LED or Group.
    * @return The intensity of the LED or Group.
    */
    public Object getIntensity(String name) throws CallError, InterruptedException {
        return (Object)call("getIntensity", name).get();
    }

    /**
    * Lists the short LED names.
    * 
    * @return A vector of LED names.
    */
    public List<String> listLEDs() throws CallError, InterruptedException {
        return (List<String>)call("listLEDs").get();
    }

    /**
    * Lists the devices aliased by a short LED name.
    * 
    * @param name  The name of the LED to list
    * @return A vector of device names.
    */
    public List<String> listLED(String name) throws CallError, InterruptedException {
        return (List<String>)call("listLED", name).get();
    }

    /**
    * Lists the devices in the group.
    * 
    * @param groupName  The name of the Group.
    * @return A vector of string device names.
    */
    public List<String> listGroup(String groupName) throws CallError, InterruptedException {
        return (List<String>)call("listGroup", groupName).get();
    }

    /**
    * Lists available group names.
    * 
    * @return A vector of group names.
    */
    public List<String> listGroups() throws CallError, InterruptedException {
        return (List<String>)call("listGroups").get();
    }

    /**
    * Switch to a minimum intensity a LED or Group of LEDs.
    * 
    * @param name  The name of the LED or Group.
    */
    public void off(String name) throws CallError, InterruptedException{
        call("off", name).get();
    }


    public class AsyncALLeds extends ALProxy {

        protected AsyncALLeds(){
            super();
        }
    
    /**
    * Sets the intensity of a LED or Group of LEDs.
    * 
    * @param name  The name of the LED or Group.
    * @param intensity  The intensity of the LED or Group (a value between 0 and 1).
    * @return The Future
    */
    public Future<Void> setIntensity(String name, Float intensity) throws CallError, InterruptedException{
        return call("setIntensity", name, intensity);
    }

    /**
    * Switch to a maximum intensity a LED or Group of LEDs.
    * 
    * @param name  The name of the LED or Group.
    * @return The Future
    */
    public Future<Void> on(String name) throws CallError, InterruptedException{
        return call("on", name);
    }

    /**
    * Launch a rotation using the leds of the eyes.
    * 
    * @param rgb  the RGB value led, RGB as seen in hexa-decimal: 0x00RRGGBB.
    * @param timeForRotation  Approximate time to make one turn.
    * @param totalDuration  Approximate duration of the animation in seconds.
    * @return The Future
    */
    public Future<Void> rotateEyes(Integer rgb, Float timeForRotation, Float totalDuration) throws CallError, InterruptedException{
        return call("rotateEyes", rgb, timeForRotation, totalDuration);
    }

    /**
    * Launch a random animation in eyes
    * 
    * @param duration  Approximate duration of the animation in seconds.
    * @return The Future
    */
    public Future<Void> randomEyes(Float duration) throws CallError, InterruptedException{
        return call("randomEyes", duration);
    }

    /**
    * Launch a green/yellow/red rasta animation on all body.
    * 
    * @param duration  Approximate duration of the animation in seconds.
    * @return The Future
    */
    public Future<Void> rasta(Float duration) throws CallError, InterruptedException{
        return call("rasta", duration);
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
    * Exits and unregisters the module.
    * 
    * @return The Future
    */
    public Future<Void> exit() throws CallError, InterruptedException{
        return call("exit");
    }

    /**
    * Returns the version of the module.
    * 
    * @return A string containing the version of the module.
    */
    public Future<String> version() throws CallError, InterruptedException {
        return call("version");
    }

    /**
    * Just a ping. Always returns true
    * 
    * @return returns true
    */
    public Future<Boolean> ping() throws CallError, InterruptedException {
        return call("ping");
    }

    /**
    * Retrieves the module's method list.
    * 
    * @return An array of method names.
    */
    public Future<List<String>> getMethodList() throws CallError, InterruptedException {
        return call("getMethodList");
    }

    /**
    * Retrieves a method's description.
    * 
    * @param methodName  The name of the method.
    * @return A structure containing the method's description.
    */
    public Future<Object> getMethodHelp(String methodName) throws CallError, InterruptedException {
        return call("getMethodHelp", methodName);
    }

    /**
    * Retrieves the module's description.
    * 
    * @return A structure describing the module.
    */
    public Future<Object> getModuleHelp() throws CallError, InterruptedException {
        return call("getModuleHelp");
    }

    /**
    * Wait for the end of a long running method that was called using 'post'
    * 
    * @param id  The ID of the method that was returned when calling the method using 'post'
    * @param timeoutPeriod  The timeout period in ms. To wait indefinately, use a timeoutPeriod of zero.
    * @return True if the timeout period terminated. False if the method returned.
    */
    public Future<Boolean> wait(Integer id, Integer timeoutPeriod) throws CallError, InterruptedException {
        return call("wait", id, timeoutPeriod);
    }

    /**
    * Returns true if the method is currently running.
    * 
    * @param id  The ID of the method that was returned when calling the method using 'post'
    * @return True if the method is currently running
    */
    public Future<Boolean> isRunning(Integer id) throws CallError, InterruptedException {
        return call("isRunning", id);
    }

    /**
    * returns true if the method is currently running
    * 
    * @param id  the ID of the method to wait for
    * @return The Future
    */
    public Future<Void> stop(Integer id) throws CallError, InterruptedException{
        return call("stop", id);
    }

    /**
    * Gets the name of the parent broker.
    * 
    * @return The name of the parent broker.
    */
    public Future<String> getBrokerName() throws CallError, InterruptedException {
        return call("getBrokerName");
    }

    /**
    * Gets the method usage string. This summarises how to use the method.
    * 
    * @param name  The name of the method.
    * @return A string that summarises the usage of the method.
    */
    public Future<String> getUsage(String name) throws CallError, InterruptedException {
        return call("getUsage", name);
    }

    /**
    * Makes a group name for ease of setting multiple LEDs.
    * 
    * @param groupName  The name of the group.
    * @param ledNames  A vector of the names of the LEDs in the group.
    * @return The Future
    */
    public Future<Void> createGroup(String groupName, List<String> ledNames) throws CallError, InterruptedException{
        return call("createGroup", groupName, ledNames);
    }

    /**
    * An animation to show a direction with the ears.
    * 
    * @param degrees  The angle you want to show in degrees (int). 0 is up, 90 is forwards, 180 is down and 270 is back.
    * @param duration  The duration in seconds of the animation.
    * @param leaveOnAtEnd  If true the last led is left on at the end of the animation.
    * @return The Future
    */
    public Future<Void> earLedsSetAngle(Integer degrees, Float duration, Boolean leaveOnAtEnd) throws CallError, InterruptedException{
        return call("earLedsSetAngle", degrees, duration, leaveOnAtEnd);
    }

    /**
    * Sets the intensity of a LED or Group of LEDs within a given time.
    * 
    * @param name  The name of the LED or Group.
    * @param intensity  The intensity of the LED or Group (a value between 0 and 1).
    * @param duration  The duration of the fade in seconds
    * @return The Future
    */
    public Future<Void> fade(String name, Float intensity, Float duration) throws CallError, InterruptedException{
        return call("fade", name, intensity, duration);
    }

    /**
    * Chain a list of color for a device, as the motion.doMove command.
    * 
    * @param name  The name of the LED or Group.
    * @param rgbList  List of RGB led value, RGB as seen in hexa-decimal: 0x00RRGGBB.
    * @param timeList  List of time to go to given intensity.
    * @return The Future
    */
    public Future<Void> fadeListRGB(String name, Object rgbList, Object timeList) throws CallError, InterruptedException{
        return call("fadeListRGB", name, rgbList, timeList);
    }

    /**
    * Sets the color of an RGB led.
    * 
    * @param name  The name of the LED or Group.
    * @param red  the intensity of red channel (0-1).
    * @param green  the intensity of green channel (0-1).
    * @param blue  the intensity of blue channel (0-1).
    * @param duration  Time used to fade in seconds.
    * @return The Future
    */
    public Future<Void> fadeRGB(String name, Float red, Float green, Float blue, Float duration) throws CallError, InterruptedException{
        return call("fadeRGB", name, red, green, blue, duration);
    }

    /**
    * Sets the color of an RGB led.
    * 
    * @param name  The name of the LED or Group.
    * @param colorName  the name of the color (supported colors: "white", "red", "green", "blue", "yellow", "magenta", "cyan")
    * @param duration  Time used to fade in seconds.
    * @return The Future
    */
    public Future<Void> fadeRGB(String name, String colorName, Float duration) throws CallError, InterruptedException{
        return call("fadeRGB", name, colorName, duration);
    }

    /**
    * Sets the color of an RGB led.
    * 
    * @param name  The name of the LED or Group.
    * @param rgb  The RGB value led, RGB as seen in hexa-decimal: 0x00RRGGBB.
    * @param duration  Time used to fade in seconds.
    * @return The Future
    */
    public Future<Void> fadeRGB(String name, Integer rgb, Float duration) throws CallError, InterruptedException{
        return call("fadeRGB", name, rgb, duration);
    }

    /**
    * Resets the state of the leds to default (for ex, eye LEDs are white and fully on by default).
    * 
    * @param name  The name of the LED or Group (for now, only "AllLeds" are implemented).
    * @return The Future
    */
    public Future<Void> reset(String name) throws CallError, InterruptedException{
        return call("reset", name);
    }

    /**
    * Gets the intensity of a LED or device
    * 
    * @param name  The name of the LED or Group.
    * @return The intensity of the LED or Group.
    */
    public Future<Object> getIntensity(String name) throws CallError, InterruptedException {
        return call("getIntensity", name);
    }

    /**
    * Lists the short LED names.
    * 
    * @return A vector of LED names.
    */
    public Future<List<String>> listLEDs() throws CallError, InterruptedException {
        return call("listLEDs");
    }

    /**
    * Lists the devices aliased by a short LED name.
    * 
    * @param name  The name of the LED to list
    * @return A vector of device names.
    */
    public Future<List<String>> listLED(String name) throws CallError, InterruptedException {
        return call("listLED", name);
    }

    /**
    * Lists the devices in the group.
    * 
    * @param groupName  The name of the Group.
    * @return A vector of string device names.
    */
    public Future<List<String>> listGroup(String groupName) throws CallError, InterruptedException {
        return call("listGroup", groupName);
    }

    /**
    * Lists available group names.
    * 
    * @return A vector of group names.
    */
    public Future<List<String>> listGroups() throws CallError, InterruptedException {
        return call("listGroups");
    }

    /**
    * Switch to a minimum intensity a LED or Group of LEDs.
    * 
    * @param name  The name of the LED or Group.
    * @return The Future
    */
    public Future<Void> off(String name) throws CallError, InterruptedException{
        return call("off", name);
    }

    }
}
    