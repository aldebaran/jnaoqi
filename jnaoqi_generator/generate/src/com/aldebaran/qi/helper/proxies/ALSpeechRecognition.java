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
* ALSpeechRecognition gives access to the embedded voice recognition system. It can be dynamically modified. This class allows user to load the current words list that should be recognized. The result of the recognition engine is located in the ALMemory's key: "WordRecognized". The structure of the result is an array :  [ (string) word , (float) confidence ]
* @see <a href="http://doc.aldebaran.com/2-1/naoqi/audio/alspeechrecognition.html#alspeechrecognition">NAOqi APIs for ALSpeechRecognition </a>
*
*/
public class ALSpeechRecognition extends ALProxy {

    public ALSpeechRecognition(Session session) throws Exception{
        super(session);
    }

    /**
    * Returns the current language used by the speech recognition system.
    * 
    * @return Current language used by the speech recognition engine.
    */
    public String getLanguage() throws CallError, InterruptedException {
        return (String)call("getLanguage").get();
    }

    /**
    * Sets the list of words (vocabulary) that should be recognized by the speech recognition engine.
    * 
    * @param vocabulary  List of words that should be recognized
    */
    public void setWordListAsVocabulary(List<String> vocabulary) throws CallError, InterruptedException{
        call("setWordListAsVocabulary", vocabulary).get();
    }

    /**
    * Enables or disables the playing of sounds indicating the state of the recognition engine. If this option is enabled, a sound is played at the beginning of the recognition process (after a call to the subscribe method), and a sound is played when the user call the unsubscribe method
    * 
    * @param setOrNot  Enable (true) or disable it (false).
    */
    public void setAudioExpression(Boolean setOrNot) throws CallError, InterruptedException{
        call("setAudioExpression", setOrNot).get();
    }

    /**
    * Stops and restarts the speech recognition engine according to the input parameter This can be used to add contexts, activate or deactivate rules of a contex, add a words to a slot.
    * 
    * @param pause  Boolean to enable or disable pause of the speech recognition engine.
    */
    public void pause(Boolean pause) throws CallError, InterruptedException{
        call("pause", pause).get();
    }

    /**
    * 
    * 
    */
    public void compile(String param1, String param2, String param3) throws CallError, InterruptedException{
        call("compile", param1, param2, param3).get();
    }

    /**
    * Sets the language used by the speech recognition engine. The list of the available languages can be collected through the getAvailableLanguages method. If you want to set a language as the default language (loading automatically at module launch), please refer to the web page of the robot.
    * 
    * @param languageName  Name of the language in English.
    */
    public void setLanguage(String languageName) throws CallError, InterruptedException{
        call("setLanguage", languageName).get();
    }

    /**
    * Remove one context from the speech recognition engine.
    * 
    * @param contextName  Name of the context to remove from the speech recognition engine.
    */
    public void removeContext(String contextName) throws CallError, InterruptedException{
        call("removeContext", contextName).get();
    }

    /**
    * Remove all contexts from the speech recognition engine.
    * 
    */
    public void removeAllContext() throws CallError, InterruptedException{
        call("removeAllContext").get();
    }

    /**
    * Disable current contexts of the speech recognition engine and save them in a  stack.
    * 
    */
    public void pushContexts() throws CallError, InterruptedException{
        call("pushContexts").get();
    }

    /**
    * Disable current contexts and restore saved contexts of the speech recognition engine.
    * 
    */
    public void popContexts() throws CallError, InterruptedException{
        call("popContexts").get();
    }

    /**
    * Save current context set of the speech recognition engine
    * 
    * @param saveName  Name under which to save
    */
    public Boolean saveContextSet(String saveName) throws CallError, InterruptedException {
        return (Boolean)call("saveContextSet", saveName).get();
    }

    /**
    * Erase a saved context set of the speech recognition engine
    * 
    * @param saveName  Name under which the context set is saved
    */
    public void eraseContextSet(String saveName) throws CallError, InterruptedException{
        call("eraseContextSet", saveName).get();
    }

    /**
    * Activate a rule contained in the specified context.
    * 
    * @param contextName  Name of the context to modify.
    * @param ruleName  Name of the rule to activate.
    */
    public void activateRule(String contextName, String ruleName) throws CallError, InterruptedException{
        call("activateRule", contextName, ruleName).get();
    }

    /**
    * Deactivate a rule contained in the specified context.
    * 
    * @param contextName  Name of the context to modify.
    * @param ruleName  Name of the rule to deactivate.
    */
    public void deactivateRule(String contextName, String ruleName) throws CallError, InterruptedException{
        call("deactivateRule", contextName, ruleName).get();
    }

    /**
    * Activate all rules contained in the specified context.
    * 
    * @param contextName  Name of the context to modify.
    */
    public void activateAllRules(String contextName) throws CallError, InterruptedException{
        call("activateAllRules", contextName).get();
    }

    /**
    * Deactivate all rules contained in the specified context.
    * 
    * @param contextName  Name of the context to modify.
    */
    public void deactivateAllRules(String contextName) throws CallError, InterruptedException{
        call("deactivateAllRules", contextName).get();
    }

    /**
    * Set the given parameter for the specified context.
    * 
    * @param contextName  Name of the context
    * @param paramName  Name of the parameter to change
    * @param value  New parameter value
    */
    public void setContextParam(String contextName, String paramName, Float value) throws CallError, InterruptedException{
        call("setContextParam", contextName, paramName, value).get();
    }

    /**
    * Get the given parameter for the specified context.
    * 
    * @param contextName  Name of the context
    * @param paramName  Name of the parameter to get
    * @return Value of the fetched parameter
    */
    public Float getContextParam(String contextName, String paramName) throws CallError, InterruptedException {
        return (Float)call("getContextParam", contextName, paramName).get();
    }

    /**
    * Add a list of words in a slot. A slot is a part of a context which can be modified. You can add a list of words that should be recognized by the speech recognition engine
    * 
    * @param contextName  Name of the context to modify.
    * @param slotName  Name of the slot to modify.
    * @param wordList  List of words to insert in the slot.
    */
    public void addWordListToSlot(String contextName, String slotName, List<String> wordList) throws CallError, InterruptedException{
        call("addWordListToSlot", contextName, slotName, wordList).get();
    }

    /**
    * Remove all words from a slot.
    * 
    * @param contextName  Name of the context to modify.
    * @param slotName  Name of the slot to modify.
    */
    public void removeWordListFromSlot(String contextName, String slotName) throws CallError, InterruptedException{
        call("removeWordListFromSlot", contextName, slotName).get();
    }

    /**
    * Get all rules contained for a specific context.
    * 
    * @param contextName  Name of the context to analyze.
    * @param typeName  Type of the required rules.
    */
    public List<String> getRules(String contextName, String typeName) throws CallError, InterruptedException {
        return (List<String>)call("getRules", contextName, typeName).get();
    }

    /**
    * Returns the list of the languages installed on the system.
    * 
    * @return Array of strings that contains the list of the installed languages.
    */
    public List<String> getAvailableLanguages() throws CallError, InterruptedException {
        return (List<String>)call("getAvailableLanguages").get();
    }

    /**
    * Loads the vocabulary to recognized contained in a .lxd file. This method is not available with the ASR engine language set to Chinese. For more informations see the red documentation
    * 
    * @param vocabularyFile  Name of the lxd file containing the vocabulary
    */
    public void loadVocabulary(String vocabularyFile) throws CallError, InterruptedException{
        call("loadVocabulary", vocabularyFile).get();
    }

    /**
    * Sets a parameter of the speech recognition engine. Note that when the ASR engine language is set to Chinese, no parameter can be set.
The parameters that can be set and the corresponding values are:
"Sensitivity" - Values : range is [0.0; 1.0].
"Timeout" - Values :  default values 3000 ms. Timeout for the remote recognition
"MinimumTrailingSilence" : Values : 0 (no) or 1 (yes) - Applies a High-Pass filter on the input signal - default value is 0.

    * 
    * @param paramName  Name of the parameter.
    * @param paramValue  Value of the parameter.
    */
    public void setParameter(String paramName, Float paramValue) throws CallError, InterruptedException{
        call("setParameter", paramName, paramValue).get();
    }

    /**
    * To check if audio expression is enabled or disabled.
    * 
    */
    public Boolean getAudioExpression() throws CallError, InterruptedException {
        return (Boolean)call("getAudioExpression").get();
    }

    /**
    * Sets a parameter of the speech recognition engine. Note that when the ASR engine language is set to Chinese, no parameter can be set.
The parameters that can be set and the corresponding values are:
"Sensitivity" - Values : range is [0.0; 1.0].
"Timeout" - Values :  default values 3000 ms. Timeout for the remote recognition
"MinimumTrailingSilence" : Values : 0 (no) or 1 (yes) - Applies a High-Pass filter on the input signal - default value is 0.

    * 
    * @param paramName  Name of the parameter.
    * @param paramValue  Value of the parameter.
    */
    public void setParameter(String paramName, Boolean paramValue) throws CallError, InterruptedException{
        call("setParameter", paramName, paramValue).get();
    }

    /**
    * Gets a parameter of the speech recognition engine. Note that when the ASR engine language is set to Chinese, no parameter can be retrieved
    * 
    * @param paramName  Name of the parameter.
    * @return Value of the parameter.
    */
    public Float getParameter(String paramName) throws CallError, InterruptedException {
        return (Float)call("getParameter", paramName).get();
    }

    /**
    * Sets the list of words (vocabulary) that should be recognized by the speech recognition engine.
    * 
    * @param vocabulary  List of words that should be recognized
    * @param enabledWordSpotting  If disabled, the engine expects to hear one of the specified words, nothing more, nothing less. If enabled, the specified words can be pronounced in the middle of a whole speech stream, the engine will try to spot them.
    */
    public void setVocabulary(List<String> vocabulary, Boolean enabledWordSpotting) throws CallError, InterruptedException{
        call("setVocabulary", vocabulary, enabledWordSpotting).get();
    }

    /**
    * Load a saved context set of the speech recognition engine
    * 
    * @param saveName  Name under which the context set is saved
    */
    public void loadContextSet(String saveName) throws CallError, InterruptedException{
        call("loadContextSet", saveName).get();
    }

    /**
    * Add a context from a LCF file.
    * 
    * @param pathToLCFFile  Path to a LCF file. This LCF file contains the set of rules that should be recognized by the speech recognition engine.
    * @param contextName  Name of the context of your choice.
    */
    public void addContext(String pathToLCFFile, String contextName) throws CallError, InterruptedException{
        call("addContext", pathToLCFFile, contextName).get();
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
    * Subscribes to the extractor. This causes the extractor to start writing information to memory using the keys described by getOutputNames(). These can be accessed in memory using ALMemory.getData("keyName"). In many cases you can avoid calling subscribe on the extractor by just calling ALMemory.subscribeToEvent() supplying a callback method. This will automatically subscribe to the extractor for you.
    * 
    * @param name  Name of the module which subscribes.
    * @param period  Refresh period (in milliseconds) if relevant.
    * @param precision  Precision of the extractor if relevant.
    */
    public void subscribe(String name, Integer period, Float precision) throws CallError, InterruptedException{
        call("subscribe", name, period, precision).get();
    }

    /**
    * Subscribes to the extractor. This causes the extractor to start writing information to memory using the keys described by getOutputNames(). These can be accessed in memory using ALMemory.getData("keyName"). In many cases you can avoid calling subscribe on the extractor by just calling ALMemory.subscribeToEvent() supplying a callback method. This will automatically subscribe to the extractor for you.
    * 
    * @param name  Name of the module which subscribes.
    */
    public void subscribe(String name) throws CallError, InterruptedException{
        call("subscribe", name).get();
    }

    /**
    * Unsubscribes from the extractor.
    * 
    * @param name  Name of the module which had subscribed.
    */
    public void unsubscribe(String name) throws CallError, InterruptedException{
        call("unsubscribe", name).get();
    }

    /**
    * Updates the period if relevant.
    * 
    * @param name  Name of the module which has subscribed.
    * @param period  Refresh period (in milliseconds).
    */
    public void updatePeriod(String name, Integer period) throws CallError, InterruptedException{
        call("updatePeriod", name, period).get();
    }

    /**
    * Updates the precision if relevant.
    * 
    * @param name  Name of the module which has subscribed.
    * @param precision  Precision of the extractor.
    */
    public void updatePrecision(String name, Float precision) throws CallError, InterruptedException{
        call("updatePrecision", name, precision).get();
    }

    /**
    * Gets the current period.
    * 
    * @return Refresh period (in milliseconds).
    */
    public Integer getCurrentPeriod() throws CallError, InterruptedException {
        return (Integer)call("getCurrentPeriod").get();
    }

    /**
    * Gets the current precision.
    * 
    * @return Precision of the extractor.
    */
    public Float getCurrentPrecision() throws CallError, InterruptedException {
        return (Float)call("getCurrentPrecision").get();
    }

    /**
    * Gets the period for a specific subscription.
    * 
    * @param name  Name of the module which has subscribed.
    * @return Refresh period (in milliseconds).
    */
    public Integer getMyPeriod(String name) throws CallError, InterruptedException {
        return (Integer)call("getMyPeriod", name).get();
    }

    /**
    * Gets the precision for a specific subscription.
    * 
    * @param name  name of the module which has subscribed
    * @return precision of the extractor
    */
    public Float getMyPrecision(String name) throws CallError, InterruptedException {
        return (Float)call("getMyPrecision", name).get();
    }

    /**
    * Gets the parameters given by the module.
    * 
    * @return Array of names and parameters of all subscribers.
    */
    public Object getSubscribersInfo() throws CallError, InterruptedException {
        return (Object)call("getSubscribersInfo").get();
    }

    /**
    * Get the list of values updated in ALMemory.
    * 
    * @return Array of values updated by this extractor in ALMemory
    */
    public List<String> getOutputNames() throws CallError, InterruptedException {
        return (List<String>)call("getOutputNames").get();
    }

    /**
    * Get the list of events updated in ALMemory.
    * 
    * @return Array of events updated by this extractor in ALMemory
    */
    public List<String> getEventList() throws CallError, InterruptedException {
        return (List<String>)call("getEventList").get();
    }

    /**
    * Get the list of events updated in ALMemory.
    * 
    * @return Array of events updated by this extractor in ALMemory
    */
    public List<String> getMemoryKeyList() throws CallError, InterruptedException {
        return (List<String>)call("getMemoryKeyList").get();
    }

    /**
    * Enables or disables the leds animations showing the state of the recognition engine during the recognition process.
    * 
    * @param setOrNot  Enable (true) or disable it (false).
    */
    public void setVisualExpression(Boolean setOrNot) throws CallError, InterruptedException{
        call("setVisualExpression", setOrNot).get();
    }

    /**
    * Sets the LED animation mode
    * 
    * @param mode  animation mode: 0: deactivated, 1: eyes, 2: ears, 3: full
    */
    public void setVisualExpressionMode(Integer mode) throws CallError, InterruptedException{
        call("setVisualExpressionMode", mode).get();
    }

}
    