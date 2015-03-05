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
import java.util.Map;
import com.aldebaran.qi.*;

import java.util.List;
/**
* ALDialog is the dialog module. It allows loading a dialog file (.top), starts/stops/loads/unloads the dialog
* @see <a href="http://doc.aldebaran.lan/doc/release-2.1/aldeb-doc/naoqi/audio/dialog/aldialog.html#aldialog">NAOqi APIs for ALDialog </a>
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
    * Callback when speech recognition recognized a word
    * 
    */
    public void wordRecognized(String param1, Object param2, String param3) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("wordRecognized", param1, param2, param3);
        else
            service.call("wordRecognized", param1, param2, param3).get();
    }

    /**
    * Callback when speech recognition recognized a word
    * 
    */
    public void addBlockingEvent(String param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("addBlockingEvent", param1);
        else
            service.call("addBlockingEvent", param1).get();
    }

    /**
    * Get loaded dialog list
    * 
    */
    public void wordsRecognizedCallback(Object param1, Integer param2) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("wordsRecognizedCallback", param1, param2);
        else
            service.call("wordsRecognizedCallback", param1, param2).get();
    }

    /**
    * End of utterance callback
    * 
    */
    public Boolean endOfUtteranceCallback() throws CallError, InterruptedException {
        return (Boolean)service.call("endOfUtteranceCallback").get();
    }

    /**
    * releaseEngine
    * 
    */
    public void releaseEngine() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("releaseEngine");
        else
            service.call("releaseEngine").get();
    }

    /**
    * controlEngine
    * 
    */
    public List<String> controlEngine(String param1, String param2) throws CallError, InterruptedException {
        return (List<String>)service.call("controlEngine", param1, param2).get();
    }

    /**
    * Callback when dialog received a event
    * 
    */
    public void eventReceived(String param1, Object param2, String param3) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("eventReceived", param1, param2, param3);
        else
            service.call("eventReceived", param1, param2, param3).get();
    }

    /**
    * Callback when ASR status changes
    * 
    */
    public void statusChanged(String param1, Object param2, String param3) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("statusChanged", param1, param2, param3);
        else
            service.call("statusChanged", param1, param2, param3).get();
    }

    /**
    * Callback when ASR status changes
    * 
    */
    public void gotoTag(String param1, String param2) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("gotoTag", param1, param2);
        else
            service.call("gotoTag", param1, param2).get();
    }

    /**
    * noPick
    * 
    */
    public void noPick(String param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("noPick", param1);
        else
            service.call("noPick", param1).get();
    }

    /**
    * Callback when remote connection changes
    * 
    */
    public void connectionChanged(String param1, Object param2, String param3) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("connectionChanged", param1, param2, param3);
        else
            service.call("connectionChanged", param1, param2, param3).get();
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
    * Load a topic
    * 
    */
    public String loadTopic(String param1) throws CallError, InterruptedException {
        return (String)service.call("loadTopic", param1).get();
    }

    /**
    * Activate a topic
    * 
    */
    public void deactivateTopic(String param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("deactivateTopic", param1);
        else
            service.call("deactivateTopic", param1).get();
    }

    /**
    * Activate a topic
    * 
    */
    public void activateTopic(String param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("activateTopic", param1);
        else
            service.call("activateTopic", param1).get();
    }

    /**
    * unload a dialog
    * 
    */
    public void unloadTopic(String param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("unloadTopic", param1);
        else
            service.call("unloadTopic", param1).get();
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
    */
    public void forceInput(String param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("forceInput", param1);
        else
            service.call("forceInput", param1).get();
    }

    /**
    * Give a sentence to the dialog and get the answer
    * 
    */
    public void tell(String param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("tell", param1);
        else
            service.call("tell", param1).get();
    }

    /**
    * Set the minimum confidence required to recognize words
    * 
    */
    public void setASRConfidenceThreshold(Float param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setASRConfidenceThreshold", param1);
        else
            service.call("setASRConfidenceThreshold", param1).get();
    }

    /**
    * Get the minimum confidence required to recognize words
    * 
    */
    public Float getASRConfidenceThreshold() throws CallError, InterruptedException {
        return (Float)service.call("getASRConfidenceThreshold").get();
    }

    /**
    * Open a session
    * 
    */
    public void openSession(Integer param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("openSession", param1);
        else
            service.call("openSession", param1).get();
    }

    /**
    * Close the session
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
    */
    public void setDelay(String param1, Integer param2) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setDelay", param1, param2);
        else
            service.call("setDelay", param1, param2).get();
    }

    /**
    * Set how many scopes remains open
    * 
    */
    public void setNumberOfScopes(Integer param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setNumberOfScopes", param1);
        else
            service.call("setNumberOfScopes", param1).get();
    }

    /**
    * Set the content of a dynamic concept
    * 
    * @param conceptName  Name of the concept
    * @param language  Language of the concept
    * @param content  content of the concept
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
    */
    public void setConceptKeepInCache(String param1, String param2, List<String> param3) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setConceptKeepInCache", param1, param2, param3);
        else
            service.call("setConceptKeepInCache", param1, param2, param3).get();
    }

    /**
    * Set push mode
    * 
    */
    public void setPushMode(Integer param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setPushMode", param1);
        else
            service.call("setPushMode", param1).get();
    }

    /**
    * enableTriggerSentences
    * 
    */
    public void enableTriggerSentences(Boolean param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("enableTriggerSentences", param1);
        else
            service.call("enableTriggerSentences", param1).get();
    }

    /**
    * enableCategory
    * 
    */
    public void enableCategory(Boolean param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("enableCategory", param1);
        else
            service.call("enableCategory", param1).get();
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
    */
    public void setAnimatedSpeechConfiguration(Object param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setAnimatedSpeechConfiguration", param1);
        else
            service.call("setAnimatedSpeechConfiguration", param1).get();
    }

    /**
    * Black list a list of application
    * 
    */
    public void applicationBlackList(List<String> param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("applicationBlackList", param1);
        else
            service.call("applicationBlackList", param1).get();
    }

    /**
    * True if new content was installed
    * 
    */
    public Boolean isContentNeedsUpdate() throws CallError, InterruptedException {
        return (Boolean)service.call("isContentNeedsUpdate").get();
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
    * setVariablePath
    * 
    */
    public void setVariablePath(String param1, String param2, String param3) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setVariablePath", param1, param2, param3);
        else
            service.call("setVariablePath", param1, param2, param3).get();
    }

    /**
    * setLanguage
    * 
    */
    public void setLanguage(String param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setLanguage", param1);
        else
            service.call("setLanguage", param1).get();
    }

    /**
    * startUpdate
    * 
    */
    public void startUpdate(String param1, Object param2, String param3) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("startUpdate", param1, param2, param3);
        else
            service.call("startUpdate", param1, param2, param3).get();
    }

    /**
    * startUpdate
    * 
    */
    public void startApp(String param1, Object param2, String param3) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("startApp", param1, param2, param3);
        else
            service.call("startApp", param1, param2, param3).get();
    }

    /**
    * packageInstalled
    * 
    */
    public void packageInstalled(String param1, Object param2, String param3) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("packageInstalled", param1, param2, param3);
        else
            service.call("packageInstalled", param1, param2, param3).get();
    }

    /**
    * compilationFinished
    * 
    */
    public void compilationFinished(String param1, Object param2, String param3) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("compilationFinished", param1, param2, param3);
        else
            service.call("compilationFinished", param1, param2, param3).get();
    }

    /**
    * Give focus to a dialog
    * 
    */
    public void setFocus(String param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setFocus", param1);
        else
            service.call("setFocus", param1).get();
    }

    /**
    * Give focus to a dialog
    * 
    */
    public String getFocus() throws CallError, InterruptedException {
        return (String)service.call("getFocus").get();
    }

    /**
    * Set the focus to a topic and make a proposal
    * 
    */
    public void gotoTopic(String param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("gotoTopic", param1);
        else
            service.call("gotoTopic", param1).get();
    }

    /**
    * Load precompiled file
    * 
    */
    public List<String> getLoadedTopics(String param1) throws CallError, InterruptedException {
        return (List<String>)service.call("getLoadedTopics", param1).get();
    }

    /**
    * Load precompiled file
    * 
    */
    public List<String> getAllLoadedTopics() throws CallError, InterruptedException {
        return (List<String>)service.call("getAllLoadedTopics").get();
    }

    /**
    * Get activated topics
    * 
    */
    public List<String> getActivatedTopics() throws CallError, InterruptedException {
        return (List<String>)service.call("getActivatedTopics").get();
    }

    /**
    * activate a tag
    * 
    */
    public void activateTag(String param1, String param2) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("activateTag", param1, param2);
        else
            service.call("activateTag", param1, param2).get();
    }

    /**
    * deactivate a tag
    * 
    */
    public void deactivateTag(String param1, String param2) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("deactivateTag", param1, param2);
        else
            service.call("deactivateTag", param1, param2).get();
    }

    /**
    * fallback
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
    */
    public void insertUserData(String param1, String param2, Integer param3) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("insertUserData", param1, param2, param3);
        else
            service.call("insertUserData", param1, param2, param3).get();
    }

    /**
    * get user data from dialog database
    * 
    */
    public String getUserData(String param1, Integer param2) throws CallError, InterruptedException {
        return (String)service.call("getUserData", param1, param2).get();
    }

    /**
    * get user data list from dialog database
    * 
    */
    public List<String> getUserDataList(Integer param1) throws CallError, InterruptedException {
        return (List<String>)service.call("getUserDataList", param1).get();
    }

    /**
    * get user list from dialog database
    * 
    */
    public List<Integer> getUserList() throws CallError, InterruptedException {
        return (List<Integer>)service.call("getUserList").get();
    }

    /**
    * remove a user from the database
    * 
    */
    public void removeUserData(Integer param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("removeUserData", param1);
        else
            service.call("removeUserData", param1).get();
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
    */
    public void enableSendingLogToCloud(Boolean param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("enableSendingLogToCloud", param1);
        else
            service.call("enableSendingLogToCloud", param1).get();
    }

    /**
    * check if the robot is sending the log to the cloud
    * 
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
    * Generate sentences
    * 
    */
    public void generateSentences(String param1, String param2, String param3) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("generateSentences", param1, param2, param3);
        else
            service.call("generateSentences", param1, param2, param3).get();
    }

}
    