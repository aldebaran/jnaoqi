package com.aldebaran.qimessaging.helpers.al;

import com.aldebaran.qimessaging.CallError;
import com.aldebaran.qimessaging.Session;
import com.aldebaran.qimessaging.helpers.ALModule;
import java.util.List;
import java.util.Map;
import com.aldebaran.qimessaging.*;

import java.util.List;

/**
 * Created by erwan and emile on 01/05/2014.
 */
public class ALLeds extends ALModule {

    public ALLeds(Session session) {
        super(session);
    }

    /**
    * Sets the intensity of a LED or Group of LEDs.
    * 
    * @param name  The name of the LED or Group.
    * @param intensity  The intensity of the LED or Group (a value between 0 and 1).
    */
    public void setIntensity(String name, Float intensity) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setIntensity", name, intensity);
        else
            service.call("setIntensity", name, intensity).get();
    }

    /**
    * Start passive blinking with a eyeshadow color.
    * 
    * @param eyeShadow  The color of the eye shadow during and after the blink.
    */
    public void _startPassiveBlinking(Integer eyeShadow) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_startPassiveBlinking", eyeShadow);
        else
            service.call("_startPassiveBlinking", eyeShadow).get();
    }

    /**
    * Switch to a maximum intensity a LED or Group of LEDs.
    * 
    * @param name  The name of the LED or Group.
    */
    public void on(String name) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("on", name);
        else
            service.call("on", name).get();
    }

    /**
    * Set values for minimum and maximum time waited between two passive blinks.
    * 
    * @param min  The minimum (should be >= 0)
    * @param max  The maximum (should be >= min)
    */
    public void _setTimeBetweenTwoBlinks(Float min, Float max) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_setTimeBetweenTwoBlinks", min, max);
        else
            service.call("_setTimeBetweenTwoBlinks", min, max).get();
    }

    /**
    * Launch a rotation using the leds of the eyes.
    * 
    * @param rgb  the RGB value led, RGB as seen in hexa-decimal: 0x00RRGGBB.
    * @param timeForRotation  Approximate time to make one turn.
    * @param totalDuration  Approximate duration of the animation in seconds.
    */
    public void rotateEyes(Integer rgb, Float timeForRotation, Float totalDuration) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("rotateEyes", rgb, timeForRotation, totalDuration);
        else
            service.call("rotateEyes", rgb, timeForRotation, totalDuration).get();
    }

    /**
    * Launch a random animation in eyes
    * 
    * @param duration  Approximate duration of the animation in seconds.
    */
    public void randomEyes(Float duration) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("randomEyes", duration);
        else
            service.call("randomEyes", duration).get();
    }

    /**
    * Make the eyes blink once.
    * 
    */
    public void _blink() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_blink");
        else
            service.call("_blink").get();
    }

    /**
    * Make the eyes blink once with a eyeshadow color.
    * 
    */
    public void _blink(Integer param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_blink", param1);
        else
            service.call("_blink", param1).get();
    }

    /**
    * Launch a green/yellow/red rasta animation on all body.
    * 
    * @param duration  Approximate duration of the animation in seconds.
    */
    public void rasta(Float duration) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("rasta", duration);
        else
            service.call("rasta", duration).get();
    }

    /**
    * Sets the intensity of a LED or Group of LEDs (even chest LED).
    * 
    * @param name  The name of the LED or Group.
    * @param intensity  The intensity of the LED or Group (a value between 0 and 1).
    */
    public void _setAnyLedIntensity(String name, Float intensity) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_setAnyLedIntensity", name, intensity);
        else
            service.call("_setAnyLedIntensity", name, intensity).get();
    }

    /**
    * Start passive blinking.
    * 
    */
    public void _startPassiveBlinking() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_startPassiveBlinking");
        else
            service.call("_startPassiveBlinking").get();
    }

    /**
    * Stop passive blinking.
    * 
    */
    public void _stopPassiveBlinking() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_stopPassiveBlinking");
        else
            service.call("_stopPassiveBlinking").get();
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
    * Exits and unregisters the module.
    * 
    */
    public void exit() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("exit");
        else
            service.call("exit").get();
    }

    /**
    * Returns the version of the module.
    * 
    * @return A string containing the version of the module.
    */
    public String version() throws CallError, InterruptedException {
        return (String)service.call("version").get();
    }

    /**
    * Just a ping. Always returns true
    * 
    * @return returns true
    */
    public Boolean ping() throws CallError, InterruptedException {
        return (Boolean)service.call("ping").get();
    }

    /**
    * Retrieves the module's method list.
    * 
    * @return An array of method names.
    */
    public List<String> getMethodList() throws CallError, InterruptedException {
        return (List<String>)service.call("getMethodList").get();
    }

    /**
    * Retrieves a method's description.
    * 
    * @param methodName  The name of the method.
    * @return A structure containing the method's description.
    */
    public java.lang.Object getMethodHelp(String methodName) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("getMethodHelp", methodName).get();
    }

    /**
    * Retrieves the module's description.
    * 
    * @return A structure describing the module.
    */
    public java.lang.Object getModuleHelp() throws CallError, InterruptedException {
        return (java.lang.Object)service.call("getModuleHelp").get();
    }

    /**
    * Wait for the end of a long running method that was called using 'post'
    * 
    * @param id  The ID of the method that was returned when calling the method using 'post'
    * @param timeoutPeriod  The timeout period in ms. To wait indefinately, use a timeoutPeriod of zero.
    * @return True if the timeout period terminated. False if the method returned.
    */
    public Boolean wait(Integer id, Integer timeoutPeriod) throws CallError, InterruptedException {
        return (Boolean)service.call("wait", id, timeoutPeriod).get();
    }

    /**
    * Returns true if the method is currently running.
    * 
    * @param id  The ID of the method that was returned when calling the method using 'post'
    * @return True if the method is currently running
    */
    public Boolean isRunning(Integer id) throws CallError, InterruptedException {
        return (Boolean)service.call("isRunning", id).get();
    }

    /**
    * returns true if the method is currently running
    * 
    * @param id  the ID of the method to wait for
    */
    public void stop(Integer id) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("stop", id);
        else
            service.call("stop", id).get();
    }

    /**
    * Gets the name of the parent broker.
    * 
    * @return The name of the parent broker.
    */
    public String getBrokerName() throws CallError, InterruptedException {
        return (String)service.call("getBrokerName").get();
    }

    /**
    * Gets the method usage string. This summarises how to use the method.
    * 
    * @param name  The name of the method.
    * @return A string that summarises the usage of the method.
    */
    public String getUsage(String name) throws CallError, InterruptedException {
        return (String)service.call("getUsage", name).get();
    }

    /**
    * Makes a group name for ease of setting multiple LEDs.
    * 
    * @param groupName  The name of the group.
    * @param ledNames  A vector of the names of the LEDs in the group.
    */
    public void createGroup(String groupName, List<String> ledNames) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("createGroup", groupName, ledNames);
        else
            service.call("createGroup", groupName, ledNames).get();
    }

    /**
    * An animation to show a direction with the ears.
    * 
    * @param degrees  The angle you want to show in degrees (int). 0 is up, 90 is forwards, 180 is down and 270 is back.
    * @param duration  The duration in seconds of the animation.
    * @param leaveOnAtEnd  If true the last led is left on at the end of the animation.
    */
    public void earLedsSetAngle(Integer degrees, Float duration, Boolean leaveOnAtEnd) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("earLedsSetAngle", degrees, duration, leaveOnAtEnd);
        else
            service.call("earLedsSetAngle", degrees, duration, leaveOnAtEnd).get();
    }

    /**
    * Sets the intensity of a LED or Group of LEDs within a given time.
    * 
    * @param name  The name of the LED or Group.
    * @param intensity  The intensity of the LED or Group (a value between 0 and 1).
    * @param duration  The duration of the fade in seconds
    */
    public void fade(String name, Float intensity, Float duration) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("fade", name, intensity, duration);
        else
            service.call("fade", name, intensity, duration).get();
    }

    /**
    * Chain a list of color for a device, as the motion.doMove command.
    * 
    * @param name  The name of the LED or Group.
    * @param rgbList  List of RGB led value, RGB as seen in hexa-decimal: 0x00RRGGBB.
    * @param timeList  List of time to go to given intensity.
    */
    public void fadeListRGB(String name, java.lang.Object rgbList, java.lang.Object timeList) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("fadeListRGB", name, rgbList, timeList);
        else
            service.call("fadeListRGB", name, rgbList, timeList).get();
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
        if (isAsynchronous)
            service.call("fadeRGB", name, red, green, blue, duration);
        else
            service.call("fadeRGB", name, red, green, blue, duration).get();
    }

    /**
    * Sets the color of an RGB led.
    * 
    * @param name  The name of the LED or Group.
    * @param colorName  the name of the color (supported colors: "white", "red", "green", "blue", "yellow", "magenta", "cyan")
    * @param duration  Time used to fade in seconds.
    */
    public void fadeRGB(String name, String colorName, Float duration) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("fadeRGB", name, colorName, duration);
        else
            service.call("fadeRGB", name, colorName, duration).get();
    }

    /**
    * Sets the color of an RGB led.
    * 
    * @param name  The name of the LED or Group.
    * @param rgb  The RGB value led, RGB as seen in hexa-decimal: 0x00RRGGBB.
    * @param duration  Time used to fade in seconds.
    */
    public void fadeRGB(String name, Integer rgb, Float duration) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("fadeRGB", name, rgb, duration);
        else
            service.call("fadeRGB", name, rgb, duration).get();
    }

    /**
    * Resets the state of the leds to default (for ex, eye LEDs are white and fully on by default).
    * 
    * @param name  The name of the LED or Group (for now, only "AllLeds" are implemented).
    */
    public void reset(String name) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("reset", name);
        else
            service.call("reset", name).get();
    }

    /**
    * Sets an intensity ratio for the leds. If the leds are asked to be set to a specific intensity, the real intensity applied on the leds will be the specific intensity multiplied by this ratio.
    * 
    * @param name  The name of the LED or Group.
    * @param intensity  The intensity ratio between 0.6 and 1.
    */
    public void _setIntensityRatio(String name, Float intensity) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_setIntensityRatio", name, intensity);
        else
            service.call("_setIntensityRatio", name, intensity).get();
    }

    /**
    * Gets the intensity of a LED or device
    * 
    * @param name  The name of the LED or Group.
    * @return The intensity of the LED or Group.
    */
    public java.lang.Object getIntensity(String name) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("getIntensity", name).get();
    }

    /**
    * Lists the short LED names.
    * 
    * @return A vector of LED names.
    */
    public List<String> listLEDs() throws CallError, InterruptedException {
        return (List<String>)service.call("listLEDs").get();
    }

    /**
    * Lists the devices aliased by a short LED name.
    * 
    * @param name  The name of the LED to list
    * @return A vector of device names.
    */
    public List<String> listLED(String name) throws CallError, InterruptedException {
        return (List<String>)service.call("listLED", name).get();
    }

    /**
    * Lists the devices in the group.
    * 
    * @param groupName  The name of the Group.
    * @return A vector of string device names.
    */
    public List<String> listGroup(String groupName) throws CallError, InterruptedException {
        return (List<String>)service.call("listGroup", groupName).get();
    }

    /**
    * Lists available group names.
    * 
    * @return A vector of group names.
    */
    public List<String> listGroups() throws CallError, InterruptedException {
        return (List<String>)service.call("listGroups").get();
    }

    /**
    * Switch to a minimum intensity a LED or Group of LEDs.
    * 
    * @param name  The name of the LED or Group.
    */
    public void off(String name) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("off", name);
        else
            service.call("off", name).get();
    }

}
    