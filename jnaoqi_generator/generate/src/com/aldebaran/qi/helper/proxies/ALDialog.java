/**
 * Copyright (c) 2015 Aldebaran Robotics. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be
 * found in the COPYING file.
 * Created by epinault and tcruz
 */
package com.aldebaran.qi.helper.proxies;

import com.aldebaran.qi.CallError;
import com.aldebaran.qi.Future;
import com.aldebaran.qi.Session;
import com.aldebaran.qi.helper.ALProxy;

import java.util.List;
/**
* ALDialog is the dialog module. It allows loading a dialog file (.top), starts/stops/loads/unloads the dialog
* @see <a href="http://doc.aldebaran.com/2-1/naoqi/audio/dialog/aldialog.html#aldialog">NAOqi APIs for ALDialog </a>
*
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
    * Callback when speech recognition recognized a word
    * 
    */
    public void wordRecognized(String param1, Object param2, String param3) throws CallError, InterruptedException{
        call("wordRecognized", param1, param2, param3).get();
    }

    /**
    * Callback when speech recognition recognized a word
    * 
    */
    public void addBlockingEvent(String param1) throws CallError, InterruptedException{
        call("addBlockingEvent", param1).get();
    }

    /**
    * Get loaded dialog list
    * 
    */
    public void wordsRecognizedCallback(Object param1, Integer param2) throws CallError, InterruptedException{
        call("wordsRecognizedCallback", param1, param2).get();
    }

    /**
    * End of utterance callback
    * 
    */
    public Boolean endOfUtteranceCallback() throws CallError, InterruptedException {
        return (Boolean)call("endOfUtteranceCallback").get();
    }

    /**
    * releaseEngine
    * 
    */
    public void releaseEngine() throws CallError, InterruptedException{
        call("releaseEngine").get();
    }

    /**
    * controlEngine
    * 
    */
    public List<String> controlEngine(String param1, String param2) throws CallError, InterruptedException {
        return (List<String>)call("controlEngine", param1, param2).get();
    }

    /**
    * Callback when dialog received a event
    * 
    */
    public void eventReceived(String param1, Object param2, String param3) throws CallError, InterruptedException{
        call("eventReceived", param1, param2, param3).get();
    }

    /**
    * Callback when ASR status changes
    * 
    */
    public void statusChanged(String param1, Object param2, String param3) throws CallError, InterruptedException{
        call("statusChanged", param1, param2, param3).get();
    }

    /**
    * Callback when ASR status changes
    * 
    */
    public void gotoTag(String param1, String param2) throws CallError, InterruptedException{
        call("gotoTag", param1, param2).get();
    }

    /**
    * noPick
    * 
    */
    public void noPick(String param1) throws CallError, InterruptedException{
        call("noPick", param1).get();
    }

    /**
    * Callback when remote connection changes
    * 
    */
    public void connectionChanged(String param1, Object param2, String param3) throws CallError, InterruptedException{
        call("connectionChanged", param1, param2, param3).get();
    }

    /**
    * compile all for ASR
    * 
    */
    public void compileAll() throws CallError, InterruptedException{
        call("compileAll").get();
    }

    /**
    * Load a topic
    * 
    */
    public String loadTopic(String param1) throws CallError, InterruptedException {
        return (String)call("loadTopic", param1).get();
    }

    /**
    * Activate a topic
    * 
    */
    public void deactivateTopic(String param1) throws CallError, InterruptedException{
        call("deactivateTopic", param1).get();
    }

    /**
    * Activate a topic
    * 
    */
    public void activateTopic(String param1) throws CallError, InterruptedException{
        call("activateTopic", param1).get();
    }

    /**
    * unload a dialog
    * 
    */
    public void unloadTopic(String param1) throws CallError, InterruptedException{
        call("unloadTopic", param1).get();
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
    */
    public void forceInput(String param1) throws CallError, InterruptedException{
        call("forceInput", param1).get();
    }

    /**
    * Give a sentence to the dialog and get the answer
    * 
    */
    public void tell(String param1) throws CallError, InterruptedException{
        call("tell", param1).get();
    }

    /**
    * Set the minimum confidence required to recognize words
    * 
    */
    public void setASRConfidenceThreshold(Float param1) throws CallError, InterruptedException{
        call("setASRConfidenceThreshold", param1).get();
    }

    /**
    * Get the minimum confidence required to recognize words
    * 
    */
    public Float getASRConfidenceThreshold() throws CallError, InterruptedException {
        return (Float)call("getASRConfidenceThreshold").get();
    }

    /**
    * Open a session
    * 
    */
    public void openSession(Integer param1) throws CallError, InterruptedException{
        call("openSession", param1).get();
    }

    /**
    * Close the session
    * 
    */
    public void closeSession() throws CallError, InterruptedException{
        call("closeSession").get();
    }

    /**
    * change event's delay
    * 
    */
    public void setDelay(String param1, Integer param2) throws CallError, InterruptedException{
        call("setDelay", param1, param2).get();
    }

    /**
    * Set how many scopes remains open
    * 
    */
    public void setNumberOfScopes(Integer param1) throws CallError, InterruptedException{
        call("setNumberOfScopes", param1).get();
    }

    /**
    * Set the content of a dynamic concept
    * 
    * @param conceptName  Name of the concept
    * @param language  Language of the concept
    * @param content  content of the concept
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
    */
    public void setConceptKeepInCache(String param1, String param2, List<String> param3) throws CallError, InterruptedException{
        call("setConceptKeepInCache", param1, param2, param3).get();
    }

    /**
    * Set push mode
    * 
    */
    public void setPushMode(Integer param1) throws CallError, InterruptedException{
        call("setPushMode", param1).get();
    }

    /**
    * enableTriggerSentences
    * 
    */
    public void enableTriggerSentences(Boolean param1) throws CallError, InterruptedException{
        call("enableTriggerSentences", param1).get();
    }

    /**
    * enableCategory
    * 
    */
    public void enableCategory(Boolean param1) throws CallError, InterruptedException{
        call("enableCategory", param1).get();
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
    */
    public void setAnimatedSpeechConfiguration(Object param1) throws CallError, InterruptedException{
        call("setAnimatedSpeechConfiguration", param1).get();
    }

    /**
    * Black list a list of application
    * 
    */
    public void applicationBlackList(List<String> param1) throws CallError, InterruptedException{
        call("applicationBlackList", param1).get();
    }

    /**
    * True if new content was installed
    * 
    */
    public Boolean isContentNeedsUpdate() throws CallError, InterruptedException {
        return (Boolean)call("isContentNeedsUpdate").get();
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
    * setVariablePath
    * 
    */
    public void setVariablePath(String param1, String param2, String param3) throws CallError, InterruptedException{
        call("setVariablePath", param1, param2, param3).get();
    }

    /**
    * setLanguage
    * 
    */
    public void setLanguage(String param1) throws CallError, InterruptedException{
        call("setLanguage", param1).get();
    }

    /**
    * startUpdate
    * 
    */
    public void startUpdate(String param1, Object param2, String param3) throws CallError, InterruptedException{
        call("startUpdate", param1, param2, param3).get();
    }

    /**
    * startUpdate
    * 
    */
    public void startApp(String param1, Object param2, String param3) throws CallError, InterruptedException{
        call("startApp", param1, param2, param3).get();
    }

    /**
    * packageInstalled
    * 
    */
    public void packageInstalled(String param1, Object param2, String param3) throws CallError, InterruptedException{
        call("packageInstalled", param1, param2, param3).get();
    }

    /**
    * compilationFinished
    * 
    */
    public void compilationFinished(String param1, Object param2, String param3) throws CallError, InterruptedException{
        call("compilationFinished", param1, param2, param3).get();
    }

    /**
    * Give focus to a dialog
    * 
    */
    public void setFocus(String param1) throws CallError, InterruptedException{
        call("setFocus", param1).get();
    }

    /**
    * Give focus to a dialog
    * 
    */
    public String getFocus() throws CallError, InterruptedException {
        return (String)call("getFocus").get();
    }

    /**
    * Set the focus to a topic and make a proposal
    * 
    */
    public void gotoTopic(String param1) throws CallError, InterruptedException{
        call("gotoTopic", param1).get();
    }

    /**
    * Load precompiled file
    * 
    */
    public List<String> getLoadedTopics(String param1) throws CallError, InterruptedException {
        return (List<String>)call("getLoadedTopics", param1).get();
    }

    /**
    * Load precompiled file
    * 
    */
    public List<String> getAllLoadedTopics() throws CallError, InterruptedException {
        return (List<String>)call("getAllLoadedTopics").get();
    }

    /**
    * Get activated topics
    * 
    */
    public List<String> getActivatedTopics() throws CallError, InterruptedException {
        return (List<String>)call("getActivatedTopics").get();
    }

    /**
    * activate a tag
    * 
    */
    public void activateTag(String param1, String param2) throws CallError, InterruptedException{
        call("activateTag", param1, param2).get();
    }

    /**
    * deactivate a tag
    * 
    */
    public void deactivateTag(String param1, String param2) throws CallError, InterruptedException{
        call("deactivateTag", param1, param2).get();
    }

    /**
    * fallback
    * 
    */
    public void resetAll() throws CallError, InterruptedException{
        call("resetAll").get();
    }

    /**
    * insert user data into dialog database
    * 
    */
    public void insertUserData(String param1, String param2, Integer param3) throws CallError, InterruptedException{
        call("insertUserData", param1, param2, param3).get();
    }

    /**
    * get user data from dialog database
    * 
    */
    public String getUserData(String param1, Integer param2) throws CallError, InterruptedException {
        return (String)call("getUserData", param1, param2).get();
    }

    /**
    * get user data list from dialog database
    * 
    */
    public List<String> getUserDataList(Integer param1) throws CallError, InterruptedException {
        return (List<String>)call("getUserDataList", param1).get();
    }

    /**
    * get user list from dialog database
    * 
    */
    public List<Integer> getUserList() throws CallError, InterruptedException {
        return (List<Integer>)call("getUserList").get();
    }

    /**
    * remove a user from the database
    * 
    */
    public void removeUserData(Integer param1) throws CallError, InterruptedException{
        call("removeUserData", param1).get();
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
    */
    public void enableSendingLogToCloud(Boolean param1) throws CallError, InterruptedException{
        call("enableSendingLogToCloud", param1).get();
    }

    /**
    * check if the robot is sending the log to the cloud
    * 
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
    * Generate sentences
    * 
    */
    public void generateSentences(String param1, String param2, String param3) throws CallError, InterruptedException{
        call("generateSentences", param1, param2, param3).get();
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
    * Callback when speech recognition recognized a word
    * 
    * @return The Future
    */
    public Future<Void> wordRecognized(String param1, Object param2, String param3) throws CallError, InterruptedException{
        return call("wordRecognized", param1, param2, param3);
    }

    /**
    * Callback when speech recognition recognized a word
    * 
    * @return The Future
    */
    public Future<Void> addBlockingEvent(String param1) throws CallError, InterruptedException{
        return call("addBlockingEvent", param1);
    }

    /**
    * Get loaded dialog list
    * 
    * @return The Future
    */
    public Future<Void> wordsRecognizedCallback(Object param1, Integer param2) throws CallError, InterruptedException{
        return call("wordsRecognizedCallback", param1, param2);
    }

    /**
    * End of utterance callback
    * 
    */
    public Future<Boolean> endOfUtteranceCallback() throws CallError, InterruptedException {
        return call("endOfUtteranceCallback");
    }

    /**
    * releaseEngine
    * 
    * @return The Future
    */
    public Future<Void> releaseEngine() throws CallError, InterruptedException{
        return call("releaseEngine");
    }

    /**
    * controlEngine
    * 
    */
    public Future<List<String>> controlEngine(String param1, String param2) throws CallError, InterruptedException {
        return call("controlEngine", param1, param2);
    }

    /**
    * Callback when dialog received a event
    * 
    * @return The Future
    */
    public Future<Void> eventReceived(String param1, Object param2, String param3) throws CallError, InterruptedException{
        return call("eventReceived", param1, param2, param3);
    }

    /**
    * Callback when ASR status changes
    * 
    * @return The Future
    */
    public Future<Void> statusChanged(String param1, Object param2, String param3) throws CallError, InterruptedException{
        return call("statusChanged", param1, param2, param3);
    }

    /**
    * Callback when ASR status changes
    * 
    * @return The Future
    */
    public Future<Void> gotoTag(String param1, String param2) throws CallError, InterruptedException{
        return call("gotoTag", param1, param2);
    }

    /**
    * noPick
    * 
    * @return The Future
    */
    public Future<Void> noPick(String param1) throws CallError, InterruptedException{
        return call("noPick", param1);
    }

    /**
    * Callback when remote connection changes
    * 
    * @return The Future
    */
    public Future<Void> connectionChanged(String param1, Object param2, String param3) throws CallError, InterruptedException{
        return call("connectionChanged", param1, param2, param3);
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
    * Load a topic
    * 
    */
    public Future<String> loadTopic(String param1) throws CallError, InterruptedException {
        return call("loadTopic", param1);
    }

    /**
    * Activate a topic
    * 
    * @return The Future
    */
    public Future<Void> deactivateTopic(String param1) throws CallError, InterruptedException{
        return call("deactivateTopic", param1);
    }

    /**
    * Activate a topic
    * 
    * @return The Future
    */
    public Future<Void> activateTopic(String param1) throws CallError, InterruptedException{
        return call("activateTopic", param1);
    }

    /**
    * unload a dialog
    * 
    * @return The Future
    */
    public Future<Void> unloadTopic(String param1) throws CallError, InterruptedException{
        return call("unloadTopic", param1);
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
    * @return The Future
    */
    public Future<Void> forceInput(String param1) throws CallError, InterruptedException{
        return call("forceInput", param1);
    }

    /**
    * Give a sentence to the dialog and get the answer
    * 
    * @return The Future
    */
    public Future<Void> tell(String param1) throws CallError, InterruptedException{
        return call("tell", param1);
    }

    /**
    * Set the minimum confidence required to recognize words
    * 
    * @return The Future
    */
    public Future<Void> setASRConfidenceThreshold(Float param1) throws CallError, InterruptedException{
        return call("setASRConfidenceThreshold", param1);
    }

    /**
    * Get the minimum confidence required to recognize words
    * 
    */
    public Future<Float> getASRConfidenceThreshold() throws CallError, InterruptedException {
        return call("getASRConfidenceThreshold");
    }

    /**
    * Open a session
    * 
    * @return The Future
    */
    public Future<Void> openSession(Integer param1) throws CallError, InterruptedException{
        return call("openSession", param1);
    }

    /**
    * Close the session
    * 
    * @return The Future
    */
    public Future<Void> closeSession() throws CallError, InterruptedException{
        return call("closeSession");
    }

    /**
    * change event's delay
    * 
    * @return The Future
    */
    public Future<Void> setDelay(String param1, Integer param2) throws CallError, InterruptedException{
        return call("setDelay", param1, param2);
    }

    /**
    * Set how many scopes remains open
    * 
    * @return The Future
    */
    public Future<Void> setNumberOfScopes(Integer param1) throws CallError, InterruptedException{
        return call("setNumberOfScopes", param1);
    }

    /**
    * Set the content of a dynamic concept
    * 
    * @param conceptName  Name of the concept
    * @param language  Language of the concept
    * @param content  content of the concept
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
    * @return The Future
    */
    public Future<Void> setConceptKeepInCache(String param1, String param2, List<String> param3) throws CallError, InterruptedException{
        return call("setConceptKeepInCache", param1, param2, param3);
    }

    /**
    * Set push mode
    * 
    * @return The Future
    */
    public Future<Void> setPushMode(Integer param1) throws CallError, InterruptedException{
        return call("setPushMode", param1);
    }

    /**
    * enableTriggerSentences
    * 
    * @return The Future
    */
    public Future<Void> enableTriggerSentences(Boolean param1) throws CallError, InterruptedException{
        return call("enableTriggerSentences", param1);
    }

    /**
    * enableCategory
    * 
    * @return The Future
    */
    public Future<Void> enableCategory(Boolean param1) throws CallError, InterruptedException{
        return call("enableCategory", param1);
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
    * @return The Future
    */
    public Future<Void> setAnimatedSpeechConfiguration(Object param1) throws CallError, InterruptedException{
        return call("setAnimatedSpeechConfiguration", param1);
    }

    /**
    * Black list a list of application
    * 
    * @return The Future
    */
    public Future<Void> applicationBlackList(List<String> param1) throws CallError, InterruptedException{
        return call("applicationBlackList", param1);
    }

    /**
    * True if new content was installed
    * 
    */
    public Future<Boolean> isContentNeedsUpdate() throws CallError, InterruptedException {
        return call("isContentNeedsUpdate");
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
    * setVariablePath
    * 
    * @return The Future
    */
    public Future<Void> setVariablePath(String param1, String param2, String param3) throws CallError, InterruptedException{
        return call("setVariablePath", param1, param2, param3);
    }

    /**
    * setLanguage
    * 
    * @return The Future
    */
    public Future<Void> setLanguage(String param1) throws CallError, InterruptedException{
        return call("setLanguage", param1);
    }

    /**
    * startUpdate
    * 
    * @return The Future
    */
    public Future<Void> startUpdate(String param1, Object param2, String param3) throws CallError, InterruptedException{
        return call("startUpdate", param1, param2, param3);
    }

    /**
    * startUpdate
    * 
    * @return The Future
    */
    public Future<Void> startApp(String param1, Object param2, String param3) throws CallError, InterruptedException{
        return call("startApp", param1, param2, param3);
    }

    /**
    * packageInstalled
    * 
    * @return The Future
    */
    public Future<Void> packageInstalled(String param1, Object param2, String param3) throws CallError, InterruptedException{
        return call("packageInstalled", param1, param2, param3);
    }

    /**
    * compilationFinished
    * 
    * @return The Future
    */
    public Future<Void> compilationFinished(String param1, Object param2, String param3) throws CallError, InterruptedException{
        return call("compilationFinished", param1, param2, param3);
    }

    /**
    * Give focus to a dialog
    * 
    * @return The Future
    */
    public Future<Void> setFocus(String param1) throws CallError, InterruptedException{
        return call("setFocus", param1);
    }

    /**
    * Give focus to a dialog
    * 
    */
    public Future<String> getFocus() throws CallError, InterruptedException {
        return call("getFocus");
    }

    /**
    * Set the focus to a topic and make a proposal
    * 
    * @return The Future
    */
    public Future<Void> gotoTopic(String param1) throws CallError, InterruptedException{
        return call("gotoTopic", param1);
    }

    /**
    * Load precompiled file
    * 
    */
    public Future<List<String>> getLoadedTopics(String param1) throws CallError, InterruptedException {
        return call("getLoadedTopics", param1);
    }

    /**
    * Load precompiled file
    * 
    */
    public Future<List<String>> getAllLoadedTopics() throws CallError, InterruptedException {
        return call("getAllLoadedTopics");
    }

    /**
    * Get activated topics
    * 
    */
    public Future<List<String>> getActivatedTopics() throws CallError, InterruptedException {
        return call("getActivatedTopics");
    }

    /**
    * activate a tag
    * 
    * @return The Future
    */
    public Future<Void> activateTag(String param1, String param2) throws CallError, InterruptedException{
        return call("activateTag", param1, param2);
    }

    /**
    * deactivate a tag
    * 
    * @return The Future
    */
    public Future<Void> deactivateTag(String param1, String param2) throws CallError, InterruptedException{
        return call("deactivateTag", param1, param2);
    }

    /**
    * fallback
    * 
    * @return The Future
    */
    public Future<Void> resetAll() throws CallError, InterruptedException{
        return call("resetAll");
    }

    /**
    * insert user data into dialog database
    * 
    * @return The Future
    */
    public Future<Void> insertUserData(String param1, String param2, Integer param3) throws CallError, InterruptedException{
        return call("insertUserData", param1, param2, param3);
    }

    /**
    * get user data from dialog database
    * 
    */
    public Future<String> getUserData(String param1, Integer param2) throws CallError, InterruptedException {
        return call("getUserData", param1, param2);
    }

    /**
    * get user data list from dialog database
    * 
    */
    public Future<List<String>> getUserDataList(Integer param1) throws CallError, InterruptedException {
        return call("getUserDataList", param1);
    }

    /**
    * get user list from dialog database
    * 
    */
    public Future<List<Integer>> getUserList() throws CallError, InterruptedException {
        return call("getUserList");
    }

    /**
    * remove a user from the database
    * 
    * @return The Future
    */
    public Future<Void> removeUserData(Integer param1) throws CallError, InterruptedException{
        return call("removeUserData", param1);
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
    * @return The Future
    */
    public Future<Void> enableSendingLogToCloud(Boolean param1) throws CallError, InterruptedException{
        return call("enableSendingLogToCloud", param1);
    }

    /**
    * check if the robot is sending the log to the cloud
    * 
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
    * Generate sentences
    * 
    * @return The Future
    */
    public Future<Void> generateSentences(String param1, String param2, String param3) throws CallError, InterruptedException{
        return call("generateSentences", param1, param2, param3);
    }

    }
}
    