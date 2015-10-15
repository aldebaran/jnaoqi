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
* ALDialog is the dialog module. It allows loading a dialog file (.top), starts/stops/loads/unloads the dialog
* @see <a href="http://doc.aldebaran.lan/doc/release-2.3/aldeb-doc/naoqi/interaction/dialog/aldialog.html#aldialog">NAOqi APIs for ALDialog </a>
* NAOqi V2.3.x
*/
public class ALDialog extends ALProxy {

    private AsyncALDialog asyncProxy;

    public ALDialog(Session session) throws Exception{
        super(session);
        asyncProxy = new AsyncALDialog();
	    asyncProxy.setService(getService());
    }

    /**
     * Get the async version of this proxy
     *
	 * @return a AsyncALDialog object
	 */
    public AsyncALDialog async() {
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
    * Is engine stoppable
    * 
    * @return Is engine stoppable
    */
    public Boolean getStoppable() throws CallError, InterruptedException {
        return (Boolean)call("getStoppable").get();
    }

    /**
    * Is engine stoppable
    * 
    * @param stoppable  set if engine can be stopped by user session
    */
    public void setStoppable(Boolean stoppable) throws CallError, InterruptedException{
        call("setStoppable", stoppable).get();
    }

    /**
    * Is engine stoppable
    * 
    * @param stoppable  set if engine can be stopped by user session
    */
    public List<String> runTopics(List<String> stoppable) throws CallError, InterruptedException {
        return (List<String>)call("runTopics", stoppable).get();
    }

    /**
    * Is engine stoppable
    * 
    * @param stoppable  set if engine can be stopped by user session
    */
    public void stopTopics(List<String> stoppable) throws CallError, InterruptedException{
        call("stopTopics", stoppable).get();
    }

    /**
    * say a sentence from a topic
    * 
    * @param stoppable  set if engine can be stopped by user session
    */
    public void say(String stoppable, String param1) throws CallError, InterruptedException{
        call("say", stoppable, param1).get();
    }

    /**
    * ResetLanguage
    * 
    * @param stoppable  set if engine can be stopped by user session
    */
    public void resetLanguage() throws CallError, InterruptedException{
        call("resetLanguage").get();
    }

    /**
    * The event will stop current TSS
    * 
    * @param eventName  Event name
    */
    public void addBlockingEvent(String eventName) throws CallError, InterruptedException{
        call("addBlockingEvent", eventName).get();
    }

    /**
    * The event will removed from the blocking list
    * 
    * @param eventName  Event name
    */
    public void removeBlockingEvent(String eventName) throws CallError, InterruptedException{
        call("removeBlockingEvent", eventName).get();
    }

    /**
    * Asr callback for recognized words
    * 
    * @param grammar  recognized grammar
    * @param utterance Size  Utterance size
    */
    public void wordsRecognizedCallback(Object grammar, Integer utteranceSize) throws CallError, InterruptedException{
        call("wordsRecognizedCallback", grammar, utteranceSize).get();
    }

    /**
    * End of utterance asr callback
    * 
    * @return true if reprocess buffer
    */
    public Boolean endOfUtteranceCallback() throws CallError, InterruptedException {
        return (Boolean)call("endOfUtteranceCallback").get();
    }

    /**
    * Callback when ASR status changes
    * 
    * @param topicName  topic name
    * @param tagName  tag name
    */
    public void gotoTag(String topicName, String tagName) throws CallError, InterruptedException{
        call("gotoTag", topicName, tagName).get();
    }

    /**
    * noPick
    * 
    * @param topicName  Topic name
    */
    public void noPick(String topicName) throws CallError, InterruptedException{
        call("noPick", topicName).get();
    }

    /**
    * compile all for ASR
    * 
    */
    public void compileAll() throws CallError, InterruptedException{
        call("compileAll").get();
    }

    /**
    * compile all for ASR
    * 
    */
    public void compileBundle(String param1) throws CallError, InterruptedException{
        call("compileBundle", param1).get();
    }

    /**
    * Create a context
    * 
    */
    public void createContext(String param1, String param2, String param3) throws CallError, InterruptedException{
        call("createContext", param1, param2, param3).get();
    }

    /**
    * Load a topic
    * 
    * @param topicPath  topic full path and filename
    * @return Topic path and filename
    */
    public String loadTopic(String topicPath) throws CallError, InterruptedException {
        return (String)call("loadTopic", topicPath).get();
    }

    /**
    * Load a topic
    * 
    * @param topicContent  topic content
    * @return Topic name
    */
    public String loadTopicContent(String topicContent) throws CallError, InterruptedException {
        return (String)call("loadTopicContent", topicContent).get();
    }

    /**
    * Activate a topic
    * 
    * @param topicName  topic name
    */
    public void deactivateTopic(String topicName) throws CallError, InterruptedException{
        call("deactivateTopic", topicName).get();
    }

    /**
    * Activate a topic
    * 
    * @param topicName  topic name
    */
    public void activateTopic(String topicName) throws CallError, InterruptedException{
        call("activateTopic", topicName).get();
    }

    /**
    * unload a dialog
    * 
    * @param topicName  topic name
    */
    public void unloadTopic(String topicName) throws CallError, InterruptedException{
        call("unloadTopic", topicName).get();
    }

    /**
    * Get a proposal
    * 
    */
    public void forceOutput() throws CallError, InterruptedException{
        call("forceOutput").get();
    }

    /**
    * Give a sentence to the dialog and get the answer
    * 
    * @param input  input string that simulate humain sentence
    */
    public void forceInput(String input) throws CallError, InterruptedException{
        call("forceInput", input).get();
    }

    /**
    * Give a sentence to the dialog and get the answer
    * 
    * @param input  input string that simulate humain sentence
    */
    public void tell(String input) throws CallError, InterruptedException{
        call("tell", input).get();
    }

    /**
    * Set the minimum confidence required to recognize words. Better to use confidence by asr model
    * 
    * @param threshold  input string that simulate humain sentence
    */
    public void setASRConfidenceThreshold(Float threshold) throws CallError, InterruptedException{
        call("setASRConfidenceThreshold", threshold).get();
    }

    /**
    * Get the minimum confidence required to recognize words
    * 
    * @return current asr confidence
    */
    public Float getASRConfidenceThreshold() throws CallError, InterruptedException {
        return (Float)call("getASRConfidenceThreshold").get();
    }

    /**
    * Open a session
    * 
    * @param id  user id
    */
    public void openSession(Integer id) throws CallError, InterruptedException{
        call("openSession", id).get();
    }

    /**
    * Close the current session
    * 
    */
    public void closeSession() throws CallError, InterruptedException{
        call("closeSession").get();
    }

    /**
    * Close the test session
    * 
    */
    public void closeTestSession() throws CallError, InterruptedException{
        call("closeTestSession").get();
    }

    /**
    * change event's delay
    * 
    * @param eventName  Event name
    * @param Delay  Delay in second
    */
    public void setDelay(String eventName, Integer Delay) throws CallError, InterruptedException{
        call("setDelay", eventName, Delay).get();
    }

    /**
    * Set how many scopes remains open
    * 
    * @param numberOfScope  number of scope
    */
    public void setNumberOfScopes(Integer numberOfScope) throws CallError, InterruptedException{
        call("setNumberOfScopes", numberOfScope).get();
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
        call("setConcept", conceptName, language, content).get();
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
        call("setConcept", conceptName, language, content, store).get();
    }

    /**
    * set the content of a dynamic concept
    * 
    * @param conceptName  concept name
    * @param language  language
    * @param content  concept content
    */
    public void setConceptKeepInCache(String conceptName, String language, List<String> content) throws CallError, InterruptedException{
        call("setConceptKeepInCache", conceptName, language, content).get();
    }

    /**
    * add to the content of a dynamic concept
    * 
    * @param conceptName  Name of the concept
    * @param language  Language of the concept
    * @param content  content of the concept
    */
    public void addToConcept(String conceptName, String language, List<String> content) throws CallError, InterruptedException{
        call("addToConcept", conceptName, language, content).get();
    }

    /**
    * get the content of a dynamic concept
    * 
    * @param conceptName  Name of the concept
    * @param language  Language of the concept
    */
    public List<String> getConcept(String conceptName, String language) throws CallError, InterruptedException {
        return (List<String>)call("getConcept", conceptName, language).get();
    }

    /**
    * enableTriggerSentences
    * 
    * @param enableTriggerSentences  Enable trigger sentences if true
    */
    public void enableTriggerSentences(Boolean enableTriggerSentences) throws CallError, InterruptedException{
        call("enableTriggerSentences", enableTriggerSentences).get();
    }

    /**
    * enableCategory
    * 
    * @param enableCategory  Enable category if true
    */
    public void enableCategory(Boolean enableCategory) throws CallError, InterruptedException{
        call("enableCategory", enableCategory).get();
    }

    /**
    * Start push mode
    * 
    */
    public void startPush() throws CallError, InterruptedException{
        call("startPush").get();
    }

    /**
    * Stop push mode
    * 
    */
    public void stopPush() throws CallError, InterruptedException{
        call("stopPush").get();
    }

    /**
    * Set the configuration of animated speech for the current dialog.
    * 
    * @param animatedSpeechConfiguration  See animated speech documentation
    */
    public void setAnimatedSpeechConfiguration(Object animatedSpeechConfiguration) throws CallError, InterruptedException{
        call("setAnimatedSpeechConfiguration", animatedSpeechConfiguration).get();
    }

    /**
    * Black list a list of application
    * 
    * @param applicationList  List of applications that cannot be launched by dialog
    */
    public void applicationBlackList(List<String> applicationList) throws CallError, InterruptedException{
        call("applicationBlackList", applicationList).get();
    }

    /**
    * True if new content was installed
    * 
    * @return True if content was updated since last compilation
    */
    public Boolean isContentNeedsUpdate() throws CallError, InterruptedException {
        return (Boolean)call("isContentNeedsUpdate").get();
    }

    /**
    * change engagement mode
    * 
    */
    public void pause() throws CallError, InterruptedException{
        call("pause").get();
    }

    /**
    * change engagement mode
    * 
    */
    public void endPause() throws CallError, InterruptedException{
        call("endPause").get();
    }

    /**
    * run main dialog
    * 
    */
    public void runDialog() throws CallError, InterruptedException{
        call("runDialog").get();
    }

    /**
    * stop main dialog
    * 
    */
    public void stopDialog() throws CallError, InterruptedException{
        call("stopDialog").get();
    }

    /**
    * setVariablePath redifine a variable name on the fly
    * 
    * @param topic  Source topic name
    * @param event  Event name
    * @param path  New event name
    */
    public void setVariablePath(String topic, String event, String path) throws CallError, InterruptedException{
        call("setVariablePath", topic, event, path).get();
    }

    /**
    * setLanguage
    * 
    * @param Language  Set dialog language (frf, enu, jpj...)
    */
    public void setLanguage(String Language) throws CallError, InterruptedException{
        call("setLanguage", Language).get();
    }

    /**
    * getLanguage
    * 
    * @return get the dialog language
    */
    public String getLanguage() throws CallError, InterruptedException {
        return (String)call("getLanguage").get();
    }

    /**
    * dialogAnswered
    * 
    * @param variableName  variable name
    * @param variableValue  variable value
    * @param message  message
    */
    public void dialogAnswered(String variableName, Object variableValue, String message) throws CallError, InterruptedException{
        call("dialogAnswered", variableName, variableValue, message).get();
    }

    /**
    * Give focus to a dialog
    * 
    * @param topicName  Topic name
    */
    public void setFocus(String topicName) throws CallError, InterruptedException{
        call("setFocus", topicName).get();
    }

    /**
    * Give focus to a dialog
    * 
    * @return Current focus name
    */
    public String getFocus() throws CallError, InterruptedException {
        return (String)call("getFocus").get();
    }

    /**
    * Set the focus to a topic and make a proposal
    * 
    * @param topicName  Topic name
    */
    public void gotoTopic(String topicName) throws CallError, InterruptedException{
        call("gotoTopic", topicName).get();
    }

    /**
    * List loaded topics
    * 
    * @param language  Language name
    * @return List of loaded topics
    */
    public List<String> getLoadedTopics(String language) throws CallError, InterruptedException {
        return (List<String>)call("getLoadedTopics", language).get();
    }

    /**
    * List loaded topics independent of language
    * 
    * @return List of loaded topics
    */
    public List<String> getAllLoadedTopics() throws CallError, InterruptedException {
        return (List<String>)call("getAllLoadedTopics").get();
    }

    /**
    * Get activated topics
    * 
    * @return List of activated topics
    */
    public List<String> getActivatedTopics() throws CallError, InterruptedException {
        return (List<String>)call("getActivatedTopics").get();
    }

    /**
    * activate a tag
    * 
    * @param tagName  tag name
    * @param topicName  topic name
    */
    public void activateTag(String tagName, String topicName) throws CallError, InterruptedException{
        call("activateTag", tagName, topicName).get();
    }

    /**
    * deactivate a tag
    * 
    * @param tagName  tag name
    * @param topicName  topic name
    */
    public void deactivateTag(String tagName, String topicName) throws CallError, InterruptedException{
        call("deactivateTag", tagName, topicName).get();
    }

    /**
    * Reset all engine
    * 
    */
    public void resetAll() throws CallError, InterruptedException{
        call("resetAll").get();
    }

    /**
    * insert user data into dialog database
    * 
    * @param variableName  Variable name
    * @param variableValue  Variable value
    * @param UserID  User ID
    */
    public void insertUserData(String variableName, String variableValue, Integer UserID) throws CallError, InterruptedException{
        call("insertUserData", variableName, variableValue, UserID).get();
    }

    /**
    * get user data from dialog database
    * 
    * @param variableName  Variable name
    * @param UserID  User ID
    * @return Value
    */
    public String getUserData(String variableName, Integer UserID) throws CallError, InterruptedException {
        return (String)call("getUserData", variableName, UserID).get();
    }

    /**
    * get user data list from dialog database
    * 
    * @param UserID  User ID
    * @return Variable list
    */
    public List<String> getUserDataList(Integer UserID) throws CallError, InterruptedException {
        return (List<String>)call("getUserDataList", UserID).get();
    }

    /**
    * get user list from dialog database
    * 
    * @return User list
    */
    public List<Integer> getUserList() throws CallError, InterruptedException {
        return (List<Integer>)call("getUserList").get();
    }

    /**
    * remove a user from the database
    * 
    * @param UserID  User ID
    */
    public void removeUserData(Integer UserID) throws CallError, InterruptedException{
        call("removeUserData", UserID).get();
    }

    /**
    * clear concepts in DB
    * 
    */
    public void clearConcepts() throws CallError, InterruptedException{
        call("clearConcepts").get();
    }

    /**
    * let the robot send log the cloud
    * 
    * @param EnableLog  Enable log
    */
    public void enableSendingLogToCloud(Boolean EnableLog) throws CallError, InterruptedException{
        call("enableSendingLogToCloud", EnableLog).get();
    }

    /**
    * check if the robot is sending the log to the cloud
    * 
    * @return True if currently logging
    */
    public Boolean isSendingLogToCloud() throws CallError, InterruptedException {
        return (Boolean)call("isSendingLogToCloud").get();
    }

    /**
    * enable sending log audio (recorded conversation) to the cloud
    * 
    */
    public void enableLogAudio(Boolean param1) throws CallError, InterruptedException{
        call("enableLogAudio", param1).get();
    }

    /**
    * delete serializations files .ser .ini .bnf .lcf
    * 
    */
    public void deleteSerializationFiles() throws CallError, InterruptedException{
        call("deleteSerializationFiles").get();
    }

    /**
    * mute dialog
    * 
    */
    public void mute(Boolean param1) throws CallError, InterruptedException{
        call("mute", param1).get();
    }

    /**
    * Generate sentences
    * 
    * @param destination  file destination
    * @param topic  source topic
    * @param language  source language
    */
    public void generateSentences(String destination, String topic, String language) throws CallError, InterruptedException{
        call("generateSentences", destination, topic, language).get();
    }

    /**
    * get language map ISO to NU format
    * 
    * @return get language map ISO to NU format
    */
    public Map<String, String> getLanguageListISOToNU() throws CallError, InterruptedException {
        return (Map<String, String>)call("getLanguageListISOToNU").get();
    }

    /**
    * get language map NU to ISO format
    * 
    * @return get language map NU to ISO format
    */
    public Map<String, String> getLanguageListNUToISO() throws CallError, InterruptedException {
        return (Map<String, String>)call("getLanguageListNUToISO").get();
    }

    /**
    * get language map Long to NU format
    * 
    * @return get language map Long to NU format
    */
    public Map<String, String> getLanguageListLongToNU() throws CallError, InterruptedException {
        return (Map<String, String>)call("getLanguageListLongToNU").get();
    }

    /**
    * get language map NU to Long format
    * 
    * @return get language map NU to Long format
    */
    public Map<String, String> getLanguageListNUToLong() throws CallError, InterruptedException {
        return (Map<String, String>)call("getLanguageListNUToLong").get();
    }

    /**
    * convert language from NU format to Long format
    * 
    * @param Language  language in NU format
    * @return language in Long format 
    */
    public String convertNUToLong(String Language) throws CallError, InterruptedException {
        return (String)call("convertNUToLong", Language).get();
    }

    /**
    * convert language from Long format to NU format
    * 
    * @param Language  language in Long format
    * @return language in NU format 
    */
    public String convertLongToNU(String Language) throws CallError, InterruptedException {
        return (String)call("convertLongToNU", Language).get();
    }

    /**
    * convert language from ISO format to NU format
    * 
    * @param Language  language in ISO format
    * @return language in NU format 
    */
    public String convertISOToNU(String Language) throws CallError, InterruptedException {
        return (String)call("convertISOToNU", Language).get();
    }

    /**
    * convert language from NU format to ISO format
    * 
    * @param Language  language in NU format
    * @return language in ISO format 
    */
    public String convertNUToISO(String Language) throws CallError, InterruptedException {
        return (String)call("convertNUToISO", Language).get();
    }

    /**
    * Define if applications will be launched or not
    * 
    * @param simulateApps  set simulated apps
    */
    public void enableSimulatedApps(Boolean simulateApps) throws CallError, InterruptedException{
        call("enableSimulatedApps", simulateApps).get();
    }


    public class AsyncALDialog extends ALProxy {

        protected AsyncALDialog(){
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
    * Subscribes to the extractor. This causes the extractor to start writing information to memory using the keys described by getOutputNames(). These can be accessed in memory using ALMemory.getData("keyName"). In many cases you can avoid calling subscribe on the extractor by just calling ALMemory.subscribeToEvent() supplying a callback method. This will automatically subscribe to the extractor for you.
    * 
    * @param name  Name of the module which subscribes.
    * @param period  Refresh period (in milliseconds) if relevant.
    * @param precision  Precision of the extractor if relevant.
    * @return The Future
    */
    public Future<Void> subscribe(String name, Integer period, Float precision) throws CallError, InterruptedException{
        return call("subscribe", name, period, precision);
    }

    /**
    * Subscribes to the extractor. This causes the extractor to start writing information to memory using the keys described by getOutputNames(). These can be accessed in memory using ALMemory.getData("keyName"). In many cases you can avoid calling subscribe on the extractor by just calling ALMemory.subscribeToEvent() supplying a callback method. This will automatically subscribe to the extractor for you.
    * 
    * @param name  Name of the module which subscribes.
    * @return The Future
    */
    public Future<Void> subscribe(String name) throws CallError, InterruptedException{
        return call("subscribe", name);
    }

    /**
    * Unsubscribes from the extractor.
    * 
    * @param name  Name of the module which had subscribed.
    * @return The Future
    */
    public Future<Void> unsubscribe(String name) throws CallError, InterruptedException{
        return call("unsubscribe", name);
    }

    /**
    * Updates the period if relevant.
    * 
    * @param name  Name of the module which has subscribed.
    * @param period  Refresh period (in milliseconds).
    * @return The Future
    */
    public Future<Void> updatePeriod(String name, Integer period) throws CallError, InterruptedException{
        return call("updatePeriod", name, period);
    }

    /**
    * Updates the precision if relevant.
    * 
    * @param name  Name of the module which has subscribed.
    * @param precision  Precision of the extractor.
    * @return The Future
    */
    public Future<Void> updatePrecision(String name, Float precision) throws CallError, InterruptedException{
        return call("updatePrecision", name, precision);
    }

    /**
    * Gets the current period.
    * 
    * @return Refresh period (in milliseconds).
    */
    public Future<Integer> getCurrentPeriod() throws CallError, InterruptedException {
        return call("getCurrentPeriod");
    }

    /**
    * Gets the current precision.
    * 
    * @return Precision of the extractor.
    */
    public Future<Float> getCurrentPrecision() throws CallError, InterruptedException {
        return call("getCurrentPrecision");
    }

    /**
    * Gets the period for a specific subscription.
    * 
    * @param name  Name of the module which has subscribed.
    * @return Refresh period (in milliseconds).
    */
    public Future<Integer> getMyPeriod(String name) throws CallError, InterruptedException {
        return call("getMyPeriod", name);
    }

    /**
    * Gets the precision for a specific subscription.
    * 
    * @param name  name of the module which has subscribed
    * @return precision of the extractor
    */
    public Future<Float> getMyPrecision(String name) throws CallError, InterruptedException {
        return call("getMyPrecision", name);
    }

    /**
    * Gets the parameters given by the module.
    * 
    * @return Array of names and parameters of all subscribers.
    */
    public Future<Object> getSubscribersInfo() throws CallError, InterruptedException {
        return call("getSubscribersInfo");
    }

    /**
    * Get the list of values updated in ALMemory.
    * 
    * @return Array of values updated by this extractor in ALMemory
    */
    public Future<List<String>> getOutputNames() throws CallError, InterruptedException {
        return call("getOutputNames");
    }

    /**
    * Get the list of events updated in ALMemory.
    * 
    * @return Array of events updated by this extractor in ALMemory
    */
    public Future<List<String>> getEventList() throws CallError, InterruptedException {
        return call("getEventList");
    }

    /**
    * Get the list of events updated in ALMemory.
    * 
    * @return Array of events updated by this extractor in ALMemory
    */
    public Future<List<String>> getMemoryKeyList() throws CallError, InterruptedException {
        return call("getMemoryKeyList");
    }

    /**
    * Is engine stoppable
    * 
    * @return Is engine stoppable
    */
    public Future<Boolean> getStoppable() throws CallError, InterruptedException {
        return call("getStoppable");
    }

    /**
    * Is engine stoppable
    * 
    * @param stoppable  set if engine can be stopped by user session
    * @return The Future
    */
    public Future<Void> setStoppable(Boolean stoppable) throws CallError, InterruptedException{
        return call("setStoppable", stoppable);
    }

    /**
    * Is engine stoppable
    * 
    * @param stoppable  set if engine can be stopped by user session
    */
    public Future<List<String>> runTopics(List<String> stoppable) throws CallError, InterruptedException {
        return call("runTopics", stoppable);
    }

    /**
    * Is engine stoppable
    * 
    * @param stoppable  set if engine can be stopped by user session
    * @return The Future
    */
    public Future<Void> stopTopics(List<String> stoppable) throws CallError, InterruptedException{
        return call("stopTopics", stoppable);
    }

    /**
    * say a sentence from a topic
    * 
    * @param stoppable  set if engine can be stopped by user session
    * @return The Future
    */
    public Future<Void> say(String stoppable, String param1) throws CallError, InterruptedException{
        return call("say", stoppable, param1);
    }

    /**
    * ResetLanguage
    * 
    * @param stoppable  set if engine can be stopped by user session
    * @return The Future
    */
    public Future<Void> resetLanguage() throws CallError, InterruptedException{
        return call("resetLanguage");
    }

    /**
    * The event will stop current TSS
    * 
    * @param eventName  Event name
    * @return The Future
    */
    public Future<Void> addBlockingEvent(String eventName) throws CallError, InterruptedException{
        return call("addBlockingEvent", eventName);
    }

    /**
    * The event will removed from the blocking list
    * 
    * @param eventName  Event name
    * @return The Future
    */
    public Future<Void> removeBlockingEvent(String eventName) throws CallError, InterruptedException{
        return call("removeBlockingEvent", eventName);
    }

    /**
    * Asr callback for recognized words
    * 
    * @param grammar  recognized grammar
    * @param utterance Size  Utterance size
    * @return The Future
    */
    public Future<Void> wordsRecognizedCallback(Object grammar, Integer utteranceSize) throws CallError, InterruptedException{
        return call("wordsRecognizedCallback", grammar, utteranceSize);
    }

    /**
    * End of utterance asr callback
    * 
    * @return true if reprocess buffer
    */
    public Future<Boolean> endOfUtteranceCallback() throws CallError, InterruptedException {
        return call("endOfUtteranceCallback");
    }

    /**
    * Callback when ASR status changes
    * 
    * @param topicName  topic name
    * @param tagName  tag name
    * @return The Future
    */
    public Future<Void> gotoTag(String topicName, String tagName) throws CallError, InterruptedException{
        return call("gotoTag", topicName, tagName);
    }

    /**
    * noPick
    * 
    * @param topicName  Topic name
    * @return The Future
    */
    public Future<Void> noPick(String topicName) throws CallError, InterruptedException{
        return call("noPick", topicName);
    }

    /**
    * compile all for ASR
    * 
    * @return The Future
    */
    public Future<Void> compileAll() throws CallError, InterruptedException{
        return call("compileAll");
    }

    /**
    * compile all for ASR
    * 
    * @return The Future
    */
    public Future<Void> compileBundle(String param1) throws CallError, InterruptedException{
        return call("compileBundle", param1);
    }

    /**
    * Create a context
    * 
    * @return The Future
    */
    public Future<Void> createContext(String param1, String param2, String param3) throws CallError, InterruptedException{
        return call("createContext", param1, param2, param3);
    }

    /**
    * Load a topic
    * 
    * @param topicPath  topic full path and filename
    * @return Topic path and filename
    */
    public Future<String> loadTopic(String topicPath) throws CallError, InterruptedException {
        return call("loadTopic", topicPath);
    }

    /**
    * Load a topic
    * 
    * @param topicContent  topic content
    * @return Topic name
    */
    public Future<String> loadTopicContent(String topicContent) throws CallError, InterruptedException {
        return call("loadTopicContent", topicContent);
    }

    /**
    * Activate a topic
    * 
    * @param topicName  topic name
    * @return The Future
    */
    public Future<Void> deactivateTopic(String topicName) throws CallError, InterruptedException{
        return call("deactivateTopic", topicName);
    }

    /**
    * Activate a topic
    * 
    * @param topicName  topic name
    * @return The Future
    */
    public Future<Void> activateTopic(String topicName) throws CallError, InterruptedException{
        return call("activateTopic", topicName);
    }

    /**
    * unload a dialog
    * 
    * @param topicName  topic name
    * @return The Future
    */
    public Future<Void> unloadTopic(String topicName) throws CallError, InterruptedException{
        return call("unloadTopic", topicName);
    }

    /**
    * Get a proposal
    * 
    * @return The Future
    */
    public Future<Void> forceOutput() throws CallError, InterruptedException{
        return call("forceOutput");
    }

    /**
    * Give a sentence to the dialog and get the answer
    * 
    * @param input  input string that simulate humain sentence
    * @return The Future
    */
    public Future<Void> forceInput(String input) throws CallError, InterruptedException{
        return call("forceInput", input);
    }

    /**
    * Give a sentence to the dialog and get the answer
    * 
    * @param input  input string that simulate humain sentence
    * @return The Future
    */
    public Future<Void> tell(String input) throws CallError, InterruptedException{
        return call("tell", input);
    }

    /**
    * Set the minimum confidence required to recognize words. Better to use confidence by asr model
    * 
    * @param threshold  input string that simulate humain sentence
    * @return The Future
    */
    public Future<Void> setASRConfidenceThreshold(Float threshold) throws CallError, InterruptedException{
        return call("setASRConfidenceThreshold", threshold);
    }

    /**
    * Get the minimum confidence required to recognize words
    * 
    * @return current asr confidence
    */
    public Future<Float> getASRConfidenceThreshold() throws CallError, InterruptedException {
        return call("getASRConfidenceThreshold");
    }

    /**
    * Open a session
    * 
    * @param id  user id
    * @return The Future
    */
    public Future<Void> openSession(Integer id) throws CallError, InterruptedException{
        return call("openSession", id);
    }

    /**
    * Close the current session
    * 
    * @return The Future
    */
    public Future<Void> closeSession() throws CallError, InterruptedException{
        return call("closeSession");
    }

    /**
    * Close the test session
    * 
    * @return The Future
    */
    public Future<Void> closeTestSession() throws CallError, InterruptedException{
        return call("closeTestSession");
    }

    /**
    * change event's delay
    * 
    * @param eventName  Event name
    * @param Delay  Delay in second
    * @return The Future
    */
    public Future<Void> setDelay(String eventName, Integer Delay) throws CallError, InterruptedException{
        return call("setDelay", eventName, Delay);
    }

    /**
    * Set how many scopes remains open
    * 
    * @param numberOfScope  number of scope
    * @return The Future
    */
    public Future<Void> setNumberOfScopes(Integer numberOfScope) throws CallError, InterruptedException{
        return call("setNumberOfScopes", numberOfScope);
    }

    /**
    * Set the content of a dynamic concept
    * 
    * @param conceptName  Name of the concept
    * @param language  Language of the concept
    * @param content  content of the concept
    * @param store  Store concept in database if true
    * @return The Future
    */
    public Future<Void> setConcept(String conceptName, String language, List<String> content) throws CallError, InterruptedException{
        return call("setConcept", conceptName, language, content);
    }

    /**
    * Set the content of a dynamic concept
    * 
    * @param conceptName  Name of the concept
    * @param language  Language of the concept
    * @param content  content of the concept
    * @param store  determine if the concept will be save in the database
    * @return The Future
    */
    public Future<Void> setConcept(String conceptName, String language, List<String> content, Boolean store) throws CallError, InterruptedException{
        return call("setConcept", conceptName, language, content, store);
    }

    /**
    * set the content of a dynamic concept
    * 
    * @param conceptName  concept name
    * @param language  language
    * @param content  concept content
    * @return The Future
    */
    public Future<Void> setConceptKeepInCache(String conceptName, String language, List<String> content) throws CallError, InterruptedException{
        return call("setConceptKeepInCache", conceptName, language, content);
    }

    /**
    * add to the content of a dynamic concept
    * 
    * @param conceptName  Name of the concept
    * @param language  Language of the concept
    * @param content  content of the concept
    * @return The Future
    */
    public Future<Void> addToConcept(String conceptName, String language, List<String> content) throws CallError, InterruptedException{
        return call("addToConcept", conceptName, language, content);
    }

    /**
    * get the content of a dynamic concept
    * 
    * @param conceptName  Name of the concept
    * @param language  Language of the concept
    */
    public Future<List<String>> getConcept(String conceptName, String language) throws CallError, InterruptedException {
        return call("getConcept", conceptName, language);
    }

    /**
    * enableTriggerSentences
    * 
    * @param enableTriggerSentences  Enable trigger sentences if true
    * @return The Future
    */
    public Future<Void> enableTriggerSentences(Boolean enableTriggerSentences) throws CallError, InterruptedException{
        return call("enableTriggerSentences", enableTriggerSentences);
    }

    /**
    * enableCategory
    * 
    * @param enableCategory  Enable category if true
    * @return The Future
    */
    public Future<Void> enableCategory(Boolean enableCategory) throws CallError, InterruptedException{
        return call("enableCategory", enableCategory);
    }

    /**
    * Start push mode
    * 
    * @return The Future
    */
    public Future<Void> startPush() throws CallError, InterruptedException{
        return call("startPush");
    }

    /**
    * Stop push mode
    * 
    * @return The Future
    */
    public Future<Void> stopPush() throws CallError, InterruptedException{
        return call("stopPush");
    }

    /**
    * Set the configuration of animated speech for the current dialog.
    * 
    * @param animatedSpeechConfiguration  See animated speech documentation
    * @return The Future
    */
    public Future<Void> setAnimatedSpeechConfiguration(Object animatedSpeechConfiguration) throws CallError, InterruptedException{
        return call("setAnimatedSpeechConfiguration", animatedSpeechConfiguration);
    }

    /**
    * Black list a list of application
    * 
    * @param applicationList  List of applications that cannot be launched by dialog
    * @return The Future
    */
    public Future<Void> applicationBlackList(List<String> applicationList) throws CallError, InterruptedException{
        return call("applicationBlackList", applicationList);
    }

    /**
    * True if new content was installed
    * 
    * @return True if content was updated since last compilation
    */
    public Future<Boolean> isContentNeedsUpdate() throws CallError, InterruptedException {
        return call("isContentNeedsUpdate");
    }

    /**
    * change engagement mode
    * 
    * @return The Future
    */
    public Future<Void> pause() throws CallError, InterruptedException{
        return call("pause");
    }

    /**
    * change engagement mode
    * 
    * @return The Future
    */
    public Future<Void> endPause() throws CallError, InterruptedException{
        return call("endPause");
    }

    /**
    * run main dialog
    * 
    * @return The Future
    */
    public Future<Void> runDialog() throws CallError, InterruptedException{
        return call("runDialog");
    }

    /**
    * stop main dialog
    * 
    * @return The Future
    */
    public Future<Void> stopDialog() throws CallError, InterruptedException{
        return call("stopDialog");
    }

    /**
    * setVariablePath redifine a variable name on the fly
    * 
    * @param topic  Source topic name
    * @param event  Event name
    * @param path  New event name
    * @return The Future
    */
    public Future<Void> setVariablePath(String topic, String event, String path) throws CallError, InterruptedException{
        return call("setVariablePath", topic, event, path);
    }

    /**
    * setLanguage
    * 
    * @param Language  Set dialog language (frf, enu, jpj...)
    * @return The Future
    */
    public Future<Void> setLanguage(String Language) throws CallError, InterruptedException{
        return call("setLanguage", Language);
    }

    /**
    * getLanguage
    * 
    * @return get the dialog language
    */
    public Future<String> getLanguage() throws CallError, InterruptedException {
        return call("getLanguage");
    }

    /**
    * dialogAnswered
    * 
    * @param variableName  variable name
    * @param variableValue  variable value
    * @param message  message
    * @return The Future
    */
    public Future<Void> dialogAnswered(String variableName, Object variableValue, String message) throws CallError, InterruptedException{
        return call("dialogAnswered", variableName, variableValue, message);
    }

    /**
    * Give focus to a dialog
    * 
    * @param topicName  Topic name
    * @return The Future
    */
    public Future<Void> setFocus(String topicName) throws CallError, InterruptedException{
        return call("setFocus", topicName);
    }

    /**
    * Give focus to a dialog
    * 
    * @return Current focus name
    */
    public Future<String> getFocus() throws CallError, InterruptedException {
        return call("getFocus");
    }

    /**
    * Set the focus to a topic and make a proposal
    * 
    * @param topicName  Topic name
    * @return The Future
    */
    public Future<Void> gotoTopic(String topicName) throws CallError, InterruptedException{
        return call("gotoTopic", topicName);
    }

    /**
    * List loaded topics
    * 
    * @param language  Language name
    * @return List of loaded topics
    */
    public Future<List<String>> getLoadedTopics(String language) throws CallError, InterruptedException {
        return call("getLoadedTopics", language);
    }

    /**
    * List loaded topics independent of language
    * 
    * @return List of loaded topics
    */
    public Future<List<String>> getAllLoadedTopics() throws CallError, InterruptedException {
        return call("getAllLoadedTopics");
    }

    /**
    * Get activated topics
    * 
    * @return List of activated topics
    */
    public Future<List<String>> getActivatedTopics() throws CallError, InterruptedException {
        return call("getActivatedTopics");
    }

    /**
    * activate a tag
    * 
    * @param tagName  tag name
    * @param topicName  topic name
    * @return The Future
    */
    public Future<Void> activateTag(String tagName, String topicName) throws CallError, InterruptedException{
        return call("activateTag", tagName, topicName);
    }

    /**
    * deactivate a tag
    * 
    * @param tagName  tag name
    * @param topicName  topic name
    * @return The Future
    */
    public Future<Void> deactivateTag(String tagName, String topicName) throws CallError, InterruptedException{
        return call("deactivateTag", tagName, topicName);
    }

    /**
    * Reset all engine
    * 
    * @return The Future
    */
    public Future<Void> resetAll() throws CallError, InterruptedException{
        return call("resetAll");
    }

    /**
    * insert user data into dialog database
    * 
    * @param variableName  Variable name
    * @param variableValue  Variable value
    * @param UserID  User ID
    * @return The Future
    */
    public Future<Void> insertUserData(String variableName, String variableValue, Integer UserID) throws CallError, InterruptedException{
        return call("insertUserData", variableName, variableValue, UserID);
    }

    /**
    * get user data from dialog database
    * 
    * @param variableName  Variable name
    * @param UserID  User ID
    * @return Value
    */
    public Future<String> getUserData(String variableName, Integer UserID) throws CallError, InterruptedException {
        return call("getUserData", variableName, UserID);
    }

    /**
    * get user data list from dialog database
    * 
    * @param UserID  User ID
    * @return Variable list
    */
    public Future<List<String>> getUserDataList(Integer UserID) throws CallError, InterruptedException {
        return call("getUserDataList", UserID);
    }

    /**
    * get user list from dialog database
    * 
    * @return User list
    */
    public Future<List<Integer>> getUserList() throws CallError, InterruptedException {
        return call("getUserList");
    }

    /**
    * remove a user from the database
    * 
    * @param UserID  User ID
    * @return The Future
    */
    public Future<Void> removeUserData(Integer UserID) throws CallError, InterruptedException{
        return call("removeUserData", UserID);
    }

    /**
    * clear concepts in DB
    * 
    * @return The Future
    */
    public Future<Void> clearConcepts() throws CallError, InterruptedException{
        return call("clearConcepts");
    }

    /**
    * let the robot send log the cloud
    * 
    * @param EnableLog  Enable log
    * @return The Future
    */
    public Future<Void> enableSendingLogToCloud(Boolean EnableLog) throws CallError, InterruptedException{
        return call("enableSendingLogToCloud", EnableLog);
    }

    /**
    * check if the robot is sending the log to the cloud
    * 
    * @return True if currently logging
    */
    public Future<Boolean> isSendingLogToCloud() throws CallError, InterruptedException {
        return call("isSendingLogToCloud");
    }

    /**
    * enable sending log audio (recorded conversation) to the cloud
    * 
    * @return The Future
    */
    public Future<Void> enableLogAudio(Boolean param1) throws CallError, InterruptedException{
        return call("enableLogAudio", param1);
    }

    /**
    * delete serializations files .ser .ini .bnf .lcf
    * 
    * @return The Future
    */
    public Future<Void> deleteSerializationFiles() throws CallError, InterruptedException{
        return call("deleteSerializationFiles");
    }

    /**
    * mute dialog
    * 
    * @return The Future
    */
    public Future<Void> mute(Boolean param1) throws CallError, InterruptedException{
        return call("mute", param1);
    }

    /**
    * Generate sentences
    * 
    * @param destination  file destination
    * @param topic  source topic
    * @param language  source language
    * @return The Future
    */
    public Future<Void> generateSentences(String destination, String topic, String language) throws CallError, InterruptedException{
        return call("generateSentences", destination, topic, language);
    }

    /**
    * get language map ISO to NU format
    * 
    * @return get language map ISO to NU format
    */
    public Future<Map<String, String>> getLanguageListISOToNU() throws CallError, InterruptedException {
        return call("getLanguageListISOToNU");
    }

    /**
    * get language map NU to ISO format
    * 
    * @return get language map NU to ISO format
    */
    public Future<Map<String, String>> getLanguageListNUToISO() throws CallError, InterruptedException {
        return call("getLanguageListNUToISO");
    }

    /**
    * get language map Long to NU format
    * 
    * @return get language map Long to NU format
    */
    public Future<Map<String, String>> getLanguageListLongToNU() throws CallError, InterruptedException {
        return call("getLanguageListLongToNU");
    }

    /**
    * get language map NU to Long format
    * 
    * @return get language map NU to Long format
    */
    public Future<Map<String, String>> getLanguageListNUToLong() throws CallError, InterruptedException {
        return call("getLanguageListNUToLong");
    }

    /**
    * convert language from NU format to Long format
    * 
    * @param Language  language in NU format
    * @return language in Long format 
    */
    public Future<String> convertNUToLong(String Language) throws CallError, InterruptedException {
        return call("convertNUToLong", Language);
    }

    /**
    * convert language from Long format to NU format
    * 
    * @param Language  language in Long format
    * @return language in NU format 
    */
    public Future<String> convertLongToNU(String Language) throws CallError, InterruptedException {
        return call("convertLongToNU", Language);
    }

    /**
    * convert language from ISO format to NU format
    * 
    * @param Language  language in ISO format
    * @return language in NU format 
    */
    public Future<String> convertISOToNU(String Language) throws CallError, InterruptedException {
        return call("convertISOToNU", Language);
    }

    /**
    * convert language from NU format to ISO format
    * 
    * @param Language  language in NU format
    * @return language in ISO format 
    */
    public Future<String> convertNUToISO(String Language) throws CallError, InterruptedException {
        return call("convertNUToISO", Language);
    }

    /**
    * Define if applications will be launched or not
    * 
    * @param simulateApps  set simulated apps
    * @return The Future
    */
    public Future<Void> enableSimulatedApps(Boolean simulateApps) throws CallError, InterruptedException{
        return call("enableSimulatedApps", simulateApps);
    }

    }
}
    