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
* ALDialog is the dialog module. It allows loading a dialog file (.top), starts/stops/loads/unloads the dialog
* @see <a href="http://doc.aldebaran.lan/doc/master/aldeb-doc/naoqi/audio/dialog/aldialog.html#aldialog">NAOqi APIs for ALDialog </a>
*
*/
public class ALDialog extends ALProxy {

    public ALDialog(Session session) {
        super(session);
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
    public Object getMethodHelp(String methodName) throws CallError, InterruptedException {
        return (Object)service.call("getMethodHelp", methodName).get();
    }

    /**
    * Retrieves the module's description.
    * 
    * @return A structure describing the module.
    */
    public Object getModuleHelp() throws CallError, InterruptedException {
        return (Object)service.call("getModuleHelp").get();
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
    * Subscribes to the extractor. This causes the extractor to start writing information to memory using the keys described by getOutputNames(). These can be accessed in memory using ALMemory.getData("keyName"). In many cases you can avoid calling subscribe on the extractor by just calling ALMemory.subscribeToEvent() supplying a callback method. This will automatically subscribe to the extractor for you.
    * 
    * @param name  Name of the module which subscribes.
    * @param period  Refresh period (in milliseconds) if relevant.
    * @param precision  Precision of the extractor if relevant.
    */
    public void subscribe(String name, Integer period, Float precision) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("subscribe", name, period, precision);
        else
            service.call("subscribe", name, period, precision).get();
    }

    /**
    * Subscribes to the extractor. This causes the extractor to start writing information to memory using the keys described by getOutputNames(). These can be accessed in memory using ALMemory.getData("keyName"). In many cases you can avoid calling subscribe on the extractor by just calling ALMemory.subscribeToEvent() supplying a callback method. This will automatically subscribe to the extractor for you.
    * 
    * @param name  Name of the module which subscribes.
    */
    public void subscribe(String name) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("subscribe", name);
        else
            service.call("subscribe", name).get();
    }

    /**
    * Unsubscribes from the extractor.
    * 
    * @param name  Name of the module which had subscribed.
    */
    public void unsubscribe(String name) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("unsubscribe", name);
        else
            service.call("unsubscribe", name).get();
    }

    /**
    * Updates the period if relevant.
    * 
    * @param name  Name of the module which has subscribed.
    * @param period  Refresh period (in milliseconds).
    */
    public void updatePeriod(String name, Integer period) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("updatePeriod", name, period);
        else
            service.call("updatePeriod", name, period).get();
    }

    /**
    * Updates the precision if relevant.
    * 
    * @param name  Name of the module which has subscribed.
    * @param precision  Precision of the extractor.
    */
    public void updatePrecision(String name, Float precision) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("updatePrecision", name, precision);
        else
            service.call("updatePrecision", name, precision).get();
    }

    /**
    * Gets the current period.
    * 
    * @return Refresh period (in milliseconds).
    */
    public Integer getCurrentPeriod() throws CallError, InterruptedException {
        return (Integer)service.call("getCurrentPeriod").get();
    }

    /**
    * Gets the current precision.
    * 
    * @return Precision of the extractor.
    */
    public Float getCurrentPrecision() throws CallError, InterruptedException {
        return (Float)service.call("getCurrentPrecision").get();
    }

    /**
    * Gets the period for a specific subscription.
    * 
    * @param name  Name of the module which has subscribed.
    * @return Refresh period (in milliseconds).
    */
    public Integer getMyPeriod(String name) throws CallError, InterruptedException {
        return (Integer)service.call("getMyPeriod", name).get();
    }

    /**
    * Gets the precision for a specific subscription.
    * 
    * @param name  name of the module which has subscribed
    * @return precision of the extractor
    */
    public Float getMyPrecision(String name) throws CallError, InterruptedException {
        return (Float)service.call("getMyPrecision", name).get();
    }

    /**
    * Gets the parameters given by the module.
    * 
    * @return Array of names and parameters of all subscribers.
    */
    public Object getSubscribersInfo() throws CallError, InterruptedException {
        return (Object)service.call("getSubscribersInfo").get();
    }

    /**
    * Get the list of values updated in ALMemory.
    * 
    * @return Array of values updated by this extractor in ALMemory
    */
    public List<String> getOutputNames() throws CallError, InterruptedException {
        return (List<String>)service.call("getOutputNames").get();
    }

    /**
    * Get the list of events updated in ALMemory.
    * 
    * @return Array of events updated by this extractor in ALMemory
    */
    public List<String> getEventList() throws CallError, InterruptedException {
        return (List<String>)service.call("getEventList").get();
    }

    /**
    * Get the list of events updated in ALMemory.
    * 
    * @return Array of events updated by this extractor in ALMemory
    */
    public List<String> getMemoryKeyList() throws CallError, InterruptedException {
        return (List<String>)service.call("getMemoryKeyList").get();
    }

    /**
    * Is engine stoppable
    * 
    * @return Is engine stoppable
    */
    public Boolean getStoppable() throws CallError, InterruptedException {
        return (Boolean)service.call("getStoppable").get();
    }

    /**
    * Is engine stoppable
    * 
    * @param stoppable  set if engine can be stopped by user session
    */
    public void setStoppable(Boolean stoppable) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setStoppable", stoppable);
        else
            service.call("setStoppable", stoppable).get();
    }

    /**
    * The event will stop current TSS
    * 
    * @param eventName  Event name
    */
    public void addBlockingEvent(String eventName) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("addBlockingEvent", eventName);
        else
            service.call("addBlockingEvent", eventName).get();
    }

    /**
    * Asr callback for recognized words
    * 
    * @param grammar  recognized grammar
    * @param utterance Size  Utterance size
    */
    public void wordsRecognizedCallback(Object grammar, Integer utteranceSize) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("wordsRecognizedCallback", grammar, utteranceSize);
        else
            service.call("wordsRecognizedCallback", grammar, utteranceSize).get();
    }

    /**
    * End of utterance asr callback
    * 
    * @return true if reprocess buffer
    */
    public Boolean endOfUtteranceCallback() throws CallError, InterruptedException {
        return (Boolean)service.call("endOfUtteranceCallback").get();
    }

    /**
    * Experimental: release engine after call of controlEngine
    * 
    */
    public void releaseEngine() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("releaseEngine");
        else
            service.call("releaseEngine").get();
    }

    /**
    * Callback when ASR status changes
    * 
    * @param topicName  topic name
    * @param tagName  tag name
    */
    public void gotoTag(String topicName, String tagName) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("gotoTag", topicName, tagName);
        else
            service.call("gotoTag", topicName, tagName).get();
    }

    /**
    * noPick
    * 
    * @param topicName  Topic name
    */
    public void noPick(String topicName) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("noPick", topicName);
        else
            service.call("noPick", topicName).get();
    }

    /**
    * compile all for ASR
    * 
    */
    public void compileAll() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("compileAll");
        else
            service.call("compileAll").get();
    }

    /**
    * Create a context
    * 
    */
    public void createContext(String param1, String param2, String param3) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("createContext", param1, param2, param3);
        else
            service.call("createContext", param1, param2, param3).get();
    }

    /**
    * Load a topic
    * 
    * @param topicPath  topic full path and filename
    * @return Topic path and filename
    */
    public String loadTopic(String topicPath) throws CallError, InterruptedException {
        return (String)service.call("loadTopic", topicPath).get();
    }

    /**
    * Load a topic
    * 
    * @param topicContent  topic content
    * @return Topic name
    */
    public String loadTopicContent(String topicContent) throws CallError, InterruptedException {
        return (String)service.call("loadTopicContent", topicContent).get();
    }

    /**
    * Activate a topic
    * 
    * @param topicName  topic name
    */
    public void deactivateTopic(String topicName) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("deactivateTopic", topicName);
        else
            service.call("deactivateTopic", topicName).get();
    }

    /**
    * Activate a topic
    * 
    * @param topicName  topic name
    */
    public void activateTopic(String topicName) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("activateTopic", topicName);
        else
            service.call("activateTopic", topicName).get();
    }

    /**
    * unload a dialog
    * 
    * @param topicName  topic name
    */
    public void unloadTopic(String topicName) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("unloadTopic", topicName);
        else
            service.call("unloadTopic", topicName).get();
    }

    /**
    * Get a proposal
    * 
    */
    public void forceOutput() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("forceOutput");
        else
            service.call("forceOutput").get();
    }

    /**
    * Give a sentence to the dialog and get the answer
    * 
    * @param input  input string that simulate humain sentence
    */
    public void forceInput(String input) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("forceInput", input);
        else
            service.call("forceInput", input).get();
    }

    /**
    * Give a sentence to the dialog and get the answer
    * 
    * @param input  input string that simulate humain sentence
    */
    public void tell(String input) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("tell", input);
        else
            service.call("tell", input).get();
    }

    /**
    * Set the minimum confidence required to recognize words. Better to use confidence by asr model
    * 
    * @param threshold  input string that simulate humain sentence
    */
    public void setASRConfidenceThreshold(Float threshold) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setASRConfidenceThreshold", threshold);
        else
            service.call("setASRConfidenceThreshold", threshold).get();
    }

    /**
    * Get the minimum confidence required to recognize words
    * 
    * @return current asr confidence
    */
    public Float getASRConfidenceThreshold() throws CallError, InterruptedException {
        return (Float)service.call("getASRConfidenceThreshold").get();
    }

    /**
    * Open a session
    * 
    * @param id  user id
    */
    public void openSession(Integer id) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("openSession", id);
        else
            service.call("openSession", id).get();
    }

    /**
    * Close the current session
    * 
    */
    public void closeSession() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("closeSession");
        else
            service.call("closeSession").get();
    }

    /**
    * change event's delay
    * 
    * @param eventName  Event name
    * @param Delay  Delay in second
    */
    public void setDelay(String eventName, Integer Delay) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setDelay", eventName, Delay);
        else
            service.call("setDelay", eventName, Delay).get();
    }

    /**
    * Set how many scopes remains open
    * 
    * @param numberOfScope  number of scope
    */
    public void setNumberOfScopes(Integer numberOfScope) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setNumberOfScopes", numberOfScope);
        else
            service.call("setNumberOfScopes", numberOfScope).get();
    }

    /**
    * Set the content of a dynamic concept
    * 
    * @param conceptName  Name of the concept
    * @param language  Language of the concept
    * @param content  content of the concept
    * @param store  Store concept in database if true
    */
    public void setConcept(String conceptName, String language, List<String> content) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setConcept", conceptName, language, content);
        else
            service.call("setConcept", conceptName, language, content).get();
    }

    /**
    * Set the content of a dynamic concept
    * 
    * @param conceptName  Name of the concept
    * @param language  Language of the concept
    * @param content  content of the concept
    * @param store  determine if the concept will be save in the database
    */
    public void setConcept(String conceptName, String language, List<String> content, Boolean store) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setConcept", conceptName, language, content, store);
        else
            service.call("setConcept", conceptName, language, content, store).get();
    }

    /**
    * set the content of a dynamic concept
    * 
    * @param conceptName  concept name
    * @param language  language
    * @param content  concept content
    */
    public void setConceptKeepInCache(String conceptName, String language, List<String> content) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setConceptKeepInCache", conceptName, language, content);
        else
            service.call("setConceptKeepInCache", conceptName, language, content).get();
    }

    /**
    * enableTriggerSentences
    * 
    * @param enableTriggerSentences  Enable trigger sentences if true
    */
    public void enableTriggerSentences(Boolean enableTriggerSentences) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("enableTriggerSentences", enableTriggerSentences);
        else
            service.call("enableTriggerSentences", enableTriggerSentences).get();
    }

    /**
    * enableCategory
    * 
    * @param enableCategory  Enable category if true
    */
    public void enableCategory(Boolean enableCategory) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("enableCategory", enableCategory);
        else
            service.call("enableCategory", enableCategory).get();
    }

    /**
    * Start push mode
    * 
    */
    public void startPush() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("startPush");
        else
            service.call("startPush").get();
    }

    /**
    * Stop push mode
    * 
    */
    public void stopPush() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("stopPush");
        else
            service.call("stopPush").get();
    }

    /**
    * Set the configuration of animated speech for the current dialog.
    * 
    * @param animatedSpeechConfiguration  See animated speech documentation
    */
    public void setAnimatedSpeechConfiguration(Object animatedSpeechConfiguration) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setAnimatedSpeechConfiguration", animatedSpeechConfiguration);
        else
            service.call("setAnimatedSpeechConfiguration", animatedSpeechConfiguration).get();
    }

    /**
    * Black list a list of application
    * 
    * @param applicationList  List of applications that cannot be launched by dialog
    */
    public void applicationBlackList(List<String> applicationList) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("applicationBlackList", applicationList);
        else
            service.call("applicationBlackList", applicationList).get();
    }

    /**
    * True if new content was installed
    * 
    * @return True if content was updated since last compilation
    */
    public Boolean isContentNeedsUpdate() throws CallError, InterruptedException {
        return (Boolean)service.call("isContentNeedsUpdate").get();
    }

    /**
    * change engagement mode
    * 
    */
    public void pause() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("pause");
        else
            service.call("pause").get();
    }

    /**
    * change engagement mode
    * 
    */
    public void endPause() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("endPause");
        else
            service.call("endPause").get();
    }

    /**
    * run main dialog
    * 
    */
    public void runDialog() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("runDialog");
        else
            service.call("runDialog").get();
    }

    /**
    * stop main dialog
    * 
    */
    public void stopDialog() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("stopDialog");
        else
            service.call("stopDialog").get();
    }

    /**
    * setVariablePath redifine a variable name on the fly
    * 
    * @param topic  Source topic name
    * @param event  Event name
    * @param path  New event name
    */
    public void setVariablePath(String topic, String event, String path) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setVariablePath", topic, event, path);
        else
            service.call("setVariablePath", topic, event, path).get();
    }

    /**
    * setLanguage
    * 
    * @param Language  Set dialog language (frf, enu, jpj...)
    */
    public void setLanguage(String Language) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setLanguage", Language);
        else
            service.call("setLanguage", Language).get();
    }

    /**
    * dialogAnswered
    * 
    * @param variableName  variable name
    * @param variableValue  variable value
    * @param message  message
    */
    public void dialogAnswered(String variableName, Object variableValue, String message) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("dialogAnswered", variableName, variableValue, message);
        else
            service.call("dialogAnswered", variableName, variableValue, message).get();
    }

    /**
    * Give focus to a dialog
    * 
    * @param topicName  Topic name
    */
    public void setFocus(String topicName) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setFocus", topicName);
        else
            service.call("setFocus", topicName).get();
    }

    /**
    * Give focus to a dialog
    * 
    * @return Current focus name
    */
    public String getFocus() throws CallError, InterruptedException {
        return (String)service.call("getFocus").get();
    }

    /**
    * Set the focus to a topic and make a proposal
    * 
    * @param topicName  Topic name
    */
    public void gotoTopic(String topicName) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("gotoTopic", topicName);
        else
            service.call("gotoTopic", topicName).get();
    }

    /**
    * List loaded topics
    * 
    * @param language  Language name
    * @return List of loaded topics
    */
    public List<String> getLoadedTopics(String language) throws CallError, InterruptedException {
        return (List<String>)service.call("getLoadedTopics", language).get();
    }

    /**
    * List loaded topics independent of language
    * 
    * @return List of loaded topics
    */
    public List<String> getAllLoadedTopics() throws CallError, InterruptedException {
        return (List<String>)service.call("getAllLoadedTopics").get();
    }

    /**
    * Get activated topics
    * 
    * @return List of activated topics
    */
    public List<String> getActivatedTopics() throws CallError, InterruptedException {
        return (List<String>)service.call("getActivatedTopics").get();
    }

    /**
    * activate a tag
    * 
    * @param tagName  tag name
    * @param topicName  topic name
    */
    public void activateTag(String tagName, String topicName) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("activateTag", tagName, topicName);
        else
            service.call("activateTag", tagName, topicName).get();
    }

    /**
    * deactivate a tag
    * 
    * @param tagName  tag name
    * @param topicName  topic name
    */
    public void deactivateTag(String tagName, String topicName) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("deactivateTag", tagName, topicName);
        else
            service.call("deactivateTag", tagName, topicName).get();
    }

    /**
    * Reset all engine
    * 
    */
    public void resetAll() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("resetAll");
        else
            service.call("resetAll").get();
    }

    /**
    * insert user data into dialog database
    * 
    * @param variableName  Variable name
    * @param variableValue  Variable value
    * @param UserID  User ID
    */
    public void insertUserData(String variableName, String variableValue, Integer UserID) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("insertUserData", variableName, variableValue, UserID);
        else
            service.call("insertUserData", variableName, variableValue, UserID).get();
    }

    /**
    * get user data from dialog database
    * 
    * @param variableName  Variable name
    * @param UserID  User ID
    * @return Value
    */
    public String getUserData(String variableName, Integer UserID) throws CallError, InterruptedException {
        return (String)service.call("getUserData", variableName, UserID).get();
    }

    /**
    * get user data list from dialog database
    * 
    * @param UserID  User ID
    * @return Variable list
    */
    public List<String> getUserDataList(Integer UserID) throws CallError, InterruptedException {
        return (List<String>)service.call("getUserDataList", UserID).get();
    }

    /**
    * get user list from dialog database
    * 
    * @return User list
    */
    public List<Integer> getUserList() throws CallError, InterruptedException {
        return (List<Integer>)service.call("getUserList").get();
    }

    /**
    * remove a user from the database
    * 
    * @param UserID  User ID
    */
    public void removeUserData(Integer UserID) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("removeUserData", UserID);
        else
            service.call("removeUserData", UserID).get();
    }

    /**
    * clear concepts in DB
    * 
    */
    public void clearConcepts() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("clearConcepts");
        else
            service.call("clearConcepts").get();
    }

    /**
    * let the robot send log the cloud
    * 
    * @param EnableLog  Enable log
    */
    public void enableSendingLogToCloud(Boolean EnableLog) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("enableSendingLogToCloud", EnableLog);
        else
            service.call("enableSendingLogToCloud", EnableLog).get();
    }

    /**
    * check if the robot is sending the log to the cloud
    * 
    * @return True if currently logging
    */
    public Boolean isSendingLogToCloud() throws CallError, InterruptedException {
        return (Boolean)service.call("isSendingLogToCloud").get();
    }

    /**
    * enable sending log audio (recorded conversation) to the cloud
    * 
    */
    public void enableLogAudio(Boolean param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("enableLogAudio", param1);
        else
            service.call("enableLogAudio", param1).get();
    }

    /**
    * delete serializations files .ser .ini .bnf .lcf
    * 
    */
    public void deleteSerializationFiles() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("deleteSerializationFiles");
        else
            service.call("deleteSerializationFiles").get();
    }

    /**
    * mute dialog
    * 
    */
    public void mute(Boolean param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("mute", param1);
        else
            service.call("mute", param1).get();
    }

    /**
    * Generate sentences
    * 
    * @param destination  file destination
    * @param topic  source topic
    * @param language  source language
    */
    public void generateSentences(String destination, String topic, String language) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("generateSentences", destination, topic, language);
        else
            service.call("generateSentences", destination, topic, language).get();
    }

}
    