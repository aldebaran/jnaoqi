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
* The Animated Speech module makes NAO interpret a text annotated with behaviors.
* @see <a href="http://doc.aldebaran.lan/doc/release-2.1/aldeb-doc/naoqi/audio/alanimatedspeech.html#alanimatedspeech">NAOqi APIs for ALAnimatedSpeech </a>
*
*/
public class ALAnimatedSpeech extends ALProxy {

    public ALAnimatedSpeech(Session session) throws Exception{
        super(session);
    }

    /**
    * DEPRECATED since 1.18: use getBodyLanguageMode instead.Indicate if the body talk is enabled or not.
    * 
    * @return The boolean value: true means it is enabled, false means it is disabled.
    */
    public Boolean isBodyTalkEnabled() throws CallError, InterruptedException {
        return (Boolean)call("isBodyTalkEnabled").get();
    }

    /**
    * Declare some tags with the associated animations.
    * 
    * @param tagsToAnimations  Map of Tags to Animations.
    */
    public void declareTagForAnimations(Object tagsToAnimations) throws CallError, InterruptedException{
        call("declareTagForAnimations", tagsToAnimations).get();
    }

    /**
    * DEPRECATED since 1.22: use getBodyLanguageMode instead.Indicate if the body language is enabled or not.
    * 
    * @return The boolean value: true means it is enabled, false means it is disabled.
    */
    public Boolean isBodyLanguageEnabled() throws CallError, InterruptedException {
        return (Boolean)call("isBodyLanguageEnabled").get();
    }

    /**
    * Add some new links between tags and words.
    * 
    * @param tagsToWords  Map of tags to words.
    */
    public void addTagsToWords(Object tagsToWords) throws CallError, InterruptedException{
        call("addTagsToWords", tagsToWords).get();
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
    * Say the annotated text given in parameter and animate it with animations inserted in the text.
    * 
    * @param text  An annotated text (for example: "Hello. ^start(Hey_1) My name is NAO").
    */
    public void say(String text) throws CallError, InterruptedException{
        call("say", text).get();
    }

    /**
    * Say the annotated text given in parameter and animate it with animations inserted in the text.
    * 
    * @param text  An annotated text (for example: "Hello. ^start(Hey_1) My name is NAO").
    * @param configuration  The animated speech configuration.
    */
    public void say(String text, Object configuration) throws CallError, InterruptedException{
        call("say", text, configuration).get();
    }

    /**
    * DEPRECATED since 1.18: use setBodyLanguageMode instead.Enable or disable the automatic body talk on the speech.If it is enabled, anywhere you have not annotate your text with animation,the robot will fill the gap with automatically calculated gestures.If it is disabled, the robot will move only where you annotate it withanimations.
    * 
    * @param enable  The boolean value: true to enable, false to disable.
    */
    public void setBodyTalkEnabled(Boolean enable) throws CallError, InterruptedException{
        call("setBodyTalkEnabled", enable).get();
    }

    /**
    * DEPRECATED since 1.22: use setBodyLanguageMode instead.Enable or disable the automatic body language on the speech.If it is enabled, anywhere you have not annotate your text with animation,the robot will fill the gap with automatically calculated gestures.If it is disabled, the robot will move only where you annotate it withanimations.
    * 
    * @param enable  The boolean value: true to enable, false to disable.
    */
    public void setBodyLanguageEnabled(Boolean enable) throws CallError, InterruptedException{
        call("setBodyLanguageEnabled", enable).get();
    }

    /**
    * Set the current body language mode.
3 modes exist: "disabled", "random" and "contextual"
(see BodyLanguageMode enum for more details)
    * 
    * @param stringBodyLanguageMode  The choosen body language mode.
    */
    public void setBodyLanguageModeFromStr(String stringBodyLanguageMode) throws CallError, InterruptedException{
        call("setBodyLanguageModeFromStr", stringBodyLanguageMode).get();
    }

    /**
    * Set the current body language mode.
3 modes exist: BODY_LANGUAGE_MODE_DISABLED,BODY_LANGUAGE_MODE_RANDOM and BODY_LANGUAGE_MODE_CONTEXTUAL
(see BodyLanguageMode enum for more details)
    * 
    * @param bodyLanguageMode  The choosen body language mode.
    */
    public void setBodyLanguageMode(Integer bodyLanguageMode) throws CallError, InterruptedException{
        call("setBodyLanguageMode", bodyLanguageMode).get();
    }

    /**
    * Set the current body language mode.
3 modes exist: "disabled", "random" and "contextual"
(see BodyLanguageMode enum for more details)
    * 
    * @return The current body language mode.
    */
    public String getBodyLanguageModeToStr() throws CallError, InterruptedException {
        return (String)call("getBodyLanguageModeToStr").get();
    }

    /**
    * Set the current body language mode.
3 modes exist: BODY_LANGUAGE_MODE_DISABLED,BODY_LANGUAGE_MODE_RANDOM and BODY_LANGUAGE_MODE_CONTEXTUAL
(see BodyLanguageMode enum for more details)
    * 
    * @return The current body language mode.
    */
    public Integer getBodyLanguageMode() throws CallError, InterruptedException {
        return (Integer)call("getBodyLanguageMode").get();
    }

    /**
    * Add a new package that contains animations.
    * 
    * @param animationsPackage  The new package that contains animations.
    */
    public void declareAnimationsPackage(String animationsPackage) throws CallError, InterruptedException{
        call("declareAnimationsPackage", animationsPackage).get();
    }

}
    