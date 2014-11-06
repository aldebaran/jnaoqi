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
public class ALAnimatedSpeech extends ALModule {

    public ALAnimatedSpeech(Session session) {
        super(session);
    }

    /**
    * DEPRECATED since 1.18: use getBodyLanguageMode instead.Indicate if the body talk is enabled or not.
    * 
    * @return The boolean value: true means it is enabled, false means it is disabled.
    */
    public Boolean isBodyTalkEnabled() throws CallError, InterruptedException {
        return (Boolean)service.call("isBodyTalkEnabled").get();
    }

    /**
    * Method called by the tts when "mrkpause" bookmark is reached.This method is blocking until the action is finish.
    * 
    * @param pBookmark  Id of the bookmark.
    */
    public void _mrkpauseCallback(Integer pBookmark) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_mrkpauseCallback", pBookmark);
        else
            service.call("_mrkpauseCallback", pBookmark).get();
    }

    /**
    * Set if we need to check the execution times.
    * 
    * @param pause  If we need to check the execution times.
    */
    public void _setCheckExecutionTimes(Boolean pause) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_setCheckExecutionTimes", pause);
        else
            service.call("_setCheckExecutionTimes", pause).get();
    }

    /**
    * Callback for ALMemory subscription to postureFamilyChanged.
    * 
    * @param memoryKey  The subscribed memory key which changed.
    * @param value  The new value of the memory key.
    * @param message  The message that comes with the callback.
    */
    public void _postureFamilyChangedCallback(String memoryKey, java.lang.Object value, String message) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_postureFamilyChangedCallback", memoryKey, value, message);
        else
            service.call("_postureFamilyChangedCallback", memoryKey, value, message).get();
    }

    /**
    * Callback for ALMemory subscription when the behavior list of the Behavior Manager is updated.
    * 
    * @param memoryKey  The subscribed memory key which changed.
    * @param value  The new value of the memory key.
    * @param message  The message that comes with the callback.
    */
    public void _updateRepresentations(String memoryKey, java.lang.Object value, String message) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_updateRepresentations", memoryKey, value, message);
        else
            service.call("_updateRepresentations", memoryKey, value, message).get();
    }

    /**
    * Declare some tags with the associated animations.
    * 
    * @param tagsToAnimations  Map of Tags to Animations.
    */
    public void declareTagForAnimations(java.lang.Object tagsToAnimations) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("declareTagForAnimations", tagsToAnimations);
        else
            service.call("declareTagForAnimations", tagsToAnimations).get();
    }

    /**
    * Print many debug informations about the current state of animated speech.
    * 
    */
    public void _diagnosis() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_diagnosis");
        else
            service.call("_diagnosis").get();
    }

    /**
    * DEPRECATED since 1.22: use getBodyLanguageMode instead.Indicate if the body language is enabled or not.
    * 
    * @return The boolean value: true means it is enabled, false means it is disabled.
    */
    public Boolean isBodyLanguageEnabled() throws CallError, InterruptedException {
        return (Boolean)service.call("isBodyLanguageEnabled").get();
    }

    /**
    * Get tags found on installed animations which are in "animation library".
    * 
    * @return The list of tags found.
    */
    public List<String> _getTagList() throws CallError, InterruptedException {
        return (List<String>)service.call("_getTagList").get();
    }

    /**
    * Add some new links between tags and words.
    * 
    * @param tagsToWords  Map of tags to words.
    */
    public void addTagsToWords(java.lang.Object tagsToWords) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("addTagsToWords", tagsToWords);
        else
            service.call("addTagsToWords", tagsToWords).get();
    }

    /**
    * Get all installed animations for a tag. Currently: animations = "behaviors of the animation library."
    * 
    * @param tag  A tag to filter the list of animations with.
    * @return The animation list.
    */
    public List<String> _getAnimationsByTag(String tag) throws CallError, InterruptedException {
        return (List<String>)service.call("_getAnimationsByTag", tag).get();
    }

    /**
    * Callback for ALMemory subscription for speech bookmark tracking.
    * 
    * @param memoryKey  The subscribed memory key which changed.
    * @param value  The new value of the memory key.
    * @param message  The message that comes with the callback.
    */
    public void _speechBookMarkCallback(String memoryKey, java.lang.Object value, String message) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_speechBookMarkCallback", memoryKey, value, message);
        else
            service.call("_speechBookMarkCallback", memoryKey, value, message).get();
    }

    /**
    * Callback for ALMemory subscription for speech status tracking.
    * 
    * @param memoryKey  The subscribed memory key which changed.
    * @param value  The new value of the memory key.
    * @param message  The message that comes with the callback.
    */
    public void _speechStatusCallback(String memoryKey, java.lang.Object value, String message) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_speechStatusCallback", memoryKey, value, message);
        else
            service.call("_speechStatusCallback", memoryKey, value, message).get();
    }

    /**
    * Get the emotions from a text.
    * 
    * @param memoryKey  The subscribed memory key which changed.
    * @param value  The new value of the memory key.
    * @param message  The message that comes with the callback.
    */
    public void _dialogMatchedInputCallback(String memoryKey, java.lang.Object value, String message) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_dialogMatchedInputCallback", memoryKey, value, message);
        else
            service.call("_dialogMatchedInputCallback", memoryKey, value, message).get();
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
    * Say the annotated text given in parameter and animate it with animations inserted in the text.
    * 
    * @param text  An annotated text (for example: "Hello. ^start(Hey_1) My name is NAO").
    */
    public void say(String text) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("say", text);
        else
            service.call("say", text).get();
    }

    /**
    * Say the annotated text given in parameter and animate it with animations inserted in the text.
    * 
    * @param text  An annotated text (for example: "Hello. ^start(Hey_1) My name is NAO").
    * @param configuration  The animated speech configuration.
    */
    public void say(String text, java.lang.Object configuration) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("say", text, configuration);
        else
            service.call("say", text, configuration).get();
    }

    /**
    * Reset the Animated Speech configuration.
    * 
    */
    public void _reset() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_reset");
        else
            service.call("_reset").get();
    }

    /**
    * Stop all the speeches.
    * 
    * @param blocking  If this method wait for the end of the speeches.
    */
    public void _stopAll(Boolean blocking) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_stopAll", blocking);
        else
            service.call("_stopAll", blocking).get();
    }

    /**
    * Know if animated speech is running.
    * 
    * @return True, if animated speech is running, False otherwise.
    */
    public Boolean _isRunning() throws CallError, InterruptedException {
        return (Boolean)service.call("_isRunning").get();
    }

    /**
    * DEPRECATED since 1.18: use setBodyLanguageMode instead.Enable or disable the automatic body talk on the speech.If it is enabled, anywhere you have not annotate your text with animation,the robot will fill the gap with automatically calculated gestures.If it is disabled, the robot will move only where you annotate it withanimations.
    * 
    * @param enable  The boolean value: true to enable, false to disable.
    */
    public void setBodyTalkEnabled(Boolean enable) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setBodyTalkEnabled", enable);
        else
            service.call("setBodyTalkEnabled", enable).get();
    }

    /**
    * DEPRECATED since 1.22: use setBodyLanguageMode instead.Enable or disable the automatic body language on the speech.If it is enabled, anywhere you have not annotate your text with animation,the robot will fill the gap with automatically calculated gestures.If it is disabled, the robot will move only where you annotate it withanimations.
    * 
    * @param enable  The boolean value: true to enable, false to disable.
    */
    public void setBodyLanguageEnabled(Boolean enable) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setBodyLanguageEnabled", enable);
        else
            service.call("setBodyLanguageEnabled", enable).get();
    }

    /**
    * Set the current body language mode.
3 modes exist: "disabled", "random" and "contextual"
(see BodyLanguageMode enum for more details)
    * 
    * @param stringBodyLanguageMode  The choosen body language mode.
    */
    public void setBodyLanguageModeFromStr(String stringBodyLanguageMode) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setBodyLanguageModeFromStr", stringBodyLanguageMode);
        else
            service.call("setBodyLanguageModeFromStr", stringBodyLanguageMode).get();
    }

    /**
    * Set the current body language mode.
3 modes exist: BODY_LANGUAGE_MODE_DISABLED,BODY_LANGUAGE_MODE_RANDOM and BODY_LANGUAGE_MODE_CONTEXTUAL
(see BodyLanguageMode enum for more details)
    * 
    * @param bodyLanguageMode  The choosen body language mode.
    */
    public void setBodyLanguageMode(Integer bodyLanguageMode) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setBodyLanguageMode", bodyLanguageMode);
        else
            service.call("setBodyLanguageMode", bodyLanguageMode).get();
    }

    /**
    * Set the current body language mode.
3 modes exist: "disabled", "random" and "contextual"
(see BodyLanguageMode enum for more details)
    * 
    * @return The current body language mode.
    */
    public String getBodyLanguageModeToStr() throws CallError, InterruptedException {
        return (String)service.call("getBodyLanguageModeToStr").get();
    }

    /**
    * Set the current body language mode.
3 modes exist: BODY_LANGUAGE_MODE_DISABLED,BODY_LANGUAGE_MODE_RANDOM and BODY_LANGUAGE_MODE_CONTEXTUAL
(see BodyLanguageMode enum for more details)
    * 
    * @return The current body language mode.
    */
    public Integer getBodyLanguageMode() throws CallError, InterruptedException {
        return (Integer)service.call("getBodyLanguageMode").get();
    }

    /**
    * Add a new package that contains animations.
    * 
    * @param animationsPackage  The new package that contains animations.
    */
    public void declareAnimationsPackage(String animationsPackage) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("declareAnimationsPackage", animationsPackage);
        else
            service.call("declareAnimationsPackage", animationsPackage).get();
    }

    /**
    * Change the pause's time before the speech.
    * 
    * @param pause  The pause's time in milliseconds before the speech.
    */
    public void _setMSPauseBeforeSpeech(Integer pause) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_setMSPauseBeforeSpeech", pause);
        else
            service.call("_setMSPauseBeforeSpeech", pause).get();
    }

    /**
    * Get the pause's time before the speech.
    * 
    * @return The pause's time in milliseconds before the speech.
    */
    public Integer _getMSPauseBeforeSpeech() throws CallError, InterruptedException {
        return (Integer)service.call("_getMSPauseBeforeSpeech").get();
    }

    /**
    * If we need to check the execution times.
    * 
    * @return True, if we need to check the execution times, False otherwise.
    */
    public Boolean _isCheckExecutionTimesEnabled() throws CallError, InterruptedException {
        return (Boolean)service.call("_isCheckExecutionTimesEnabled").get();
    }

}
    