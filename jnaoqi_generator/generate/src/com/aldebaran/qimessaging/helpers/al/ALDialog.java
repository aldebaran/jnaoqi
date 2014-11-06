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
public class ALDialog extends ALModule {

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
    public java.lang.Object getSubscribersInfo() throws CallError, InterruptedException {
        return (java.lang.Object)service.call("getSubscribersInfo").get();
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
    * @param unsuned  callback unused parameter
    * @param value  word recognized value
    * @param message  unused message
    */
    public void wordRecognized(String unsuned, java.lang.Object value, String message) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("wordRecognized", unsuned, value, message);
        else
            service.call("wordRecognized", unsuned, value, message).get();
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
    public void wordsRecognizedCallback(java.lang.Object grammar, Integer utteranceSize) throws CallError, InterruptedException{
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
    * Experimental: controlEngine and say a tag
    * 
    * @param topicName  topic name
    * @param tagName  tag name
    * @return Robot answer list
    */
    public List<String> controlEngine(String topicName, String tagName) throws CallError, InterruptedException {
        return (List<String>)service.call("controlEngine", topicName, tagName).get();
    }

    /**
    * hasPreference
    * 
    * @return true if has preference
    */
    public Boolean _hasPreference() throws CallError, InterruptedException {
        return (Boolean)service.call("_hasPreference").get();
    }

    /**
    * Callback when dialog received a event
    * 
    * @param eventName  event name received
    * @param eventValue  event value
    * @param message  unused event message
    */
    public void eventReceived(String eventName, java.lang.Object eventValue, String message) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("eventReceived", eventName, eventValue, message);
        else
            service.call("eventReceived", eventName, eventValue, message).get();
    }

    /**
    * Callback when ASR status changes
    * 
    * @param internalCallBackEvent  unused
    * @param internalCallbackValue  unused
    * @param message  unused
    */
    public void statusChanged(String internalCallBackEvent, java.lang.Object internalCallbackValue, String message) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("statusChanged", internalCallBackEvent, internalCallbackValue, message);
        else
            service.call("statusChanged", internalCallBackEvent, internalCallbackValue, message).get();
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
    * Callback when remote connection changes
    * 
    * @param internalCallBackEvent  unused
    * @param internalCallbackValue  unused
    * @param message  unused
    */
    public void connectionChanged(String internalCallBackEvent, java.lang.Object internalCallbackValue, String message) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("connectionChanged", internalCallBackEvent, internalCallbackValue, message);
        else
            service.call("connectionChanged", internalCallBackEvent, internalCallbackValue, message).get();
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
    * @param topicPath  topic full path and filename
    * @return Topic path and filename
    */
    public String loadTopic(String topicPath) throws CallError, InterruptedException {
        return (String)service.call("loadTopic", topicPath).get();
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
    * Set the minimum confidence required to recognize words for a strategy
    * 
    * @param strategy  BNF or SLM
    * @param threshold  threshold [0,1]
    */
    public void _setConfidence(String strategy, Float threshold) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_setConfidence", strategy, threshold);
        else
            service.call("_setConfidence", strategy, threshold).get();
    }

    /**
    * Get the minimum confidence required to recognize words of a strategy
    * 
    * @param strategy  BNF or SLM
    * @return current asr confidence for model
    */
    public Float _getConfidence(String strategy) throws CallError, InterruptedException {
        return (Float)service.call("_getConfidence", strategy).get();
    }

    /**
    * Enable a secret strategy
    * 
    * @param strategy  strategy file
    */
    public void _enableStrategy(String strategy) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_enableStrategy", strategy);
        else
            service.call("_enableStrategy", strategy).get();
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
    * deprecated
    * 
    * @param name  name
    * @param topic  topic
    * @param language  language
    * @param destination  destination
    */
    public void _generateBNF(String name, String topic, String language, String destination) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_generateBNF", name, topic, language, destination);
        else
            service.call("_generateBNF", name, topic, language, destination).get();
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
    * Reset robot knowledge
    * 
    */
    public void resetKnowledge() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("resetKnowledge");
        else
            service.call("resetKnowledge").get();
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
    * Set push mode. Frequence of robot question
    * 
    * @param pushMode  Push mode from 0 to 4
    */
    public void setPushMode(Integer pushMode) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setPushMode", pushMode);
        else
            service.call("setPushMode", pushMode).get();
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
    public void setAnimatedSpeechConfiguration(java.lang.Object animatedSpeechConfiguration) throws CallError, InterruptedException{
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
    * private method to be able to set in specific include dir
    * 
    * @param topicPathName  Topic path and filename
    * @param includeDirectory  Root of the behavior
    * @return Topic name (not filename)
    */
    public String _addDialogFromTopicBox(String topicPathName, String includeDirectory) throws CallError, InterruptedException {
        return (String)service.call("_addDialogFromTopicBox", topicPathName, includeDirectory).get();
    }

    /**
    * Clean event stack
    * 
    */
    public void _cleanEventStack() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_cleanEventStack");
        else
            service.call("_cleanEventStack").get();
    }

    /**
    * Connect to custom AI client
    * 
    * @param libraryPath  library path
    */
    public void _updateAIClient(String libraryPath) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_updateAIClient", libraryPath);
        else
            service.call("_updateAIClient", libraryPath).get();
    }

    /**
    * Create a user group
    * 
    * @param groupName  User group name
    * @param topicNameList  Topic to add in group
    */
    public void _addTopicsInGroup(String groupName, List<String> topicNameList) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_addTopicsInGroup", groupName, topicNameList);
        else
            service.call("_addTopicsInGroup", groupName, topicNameList).get();
    }

    /**
    * Group to activate
    * 
    * @param groupName  group name
    */
    public void _activateGroup(String groupName) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_activateGroup", groupName);
        else
            service.call("_activateGroup", groupName).get();
    }

    /**
    * private method to be able to set in specific include dir
    * 
    * @param groupName  group name
    */
    public void _deactivateGroup(String groupName) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_deactivateGroup", groupName);
        else
            service.call("_deactivateGroup", groupName).get();
    }

    /**
    * suggest next topic
    * 
    * @param topicName  group name
    * @param suggestionValidity  Suggestion validity in second
    */
    public void _suggestNextTopic(String topicName, Integer suggestionValidity) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_suggestNextTopic", topicName, suggestionValidity);
        else
            service.call("_suggestNextTopic", topicName, suggestionValidity).get();
    }

    /**
    * suggest next topic
    * 
    * @param topicName  group name
    * @param suggestionValidity  Suggestion validity in second
    * @param userID  Suggestion validity for userID
    */
    public void _suggestUserNextTopic(String topicName, Integer suggestionValidity, Integer userID) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_suggestUserNextTopic", topicName, suggestionValidity, userID);
        else
            service.call("_suggestUserNextTopic", topicName, suggestionValidity, userID).get();
    }

    /**
    * suggest next topic not thread safe
    * 
    * @param topicName  group name
    * @param suggestionValidity  Suggestion validity in second
    */
    public void _suggestNextTopicNoPause(String topicName, Integer suggestionValidity) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_suggestNextTopicNoPause", topicName, suggestionValidity);
        else
            service.call("_suggestNextTopicNoPause", topicName, suggestionValidity).get();
    }

    /**
    * preload main dialog
    * 
    */
    public void _preloadMain() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_preloadMain");
        else
            service.call("_preloadMain").get();
    }

    /**
    * Define only language to use
    * 
    * @param languageName  monoLanguageName
    */
    public void _mainLanguage(String languageName) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_mainLanguage", languageName);
        else
            service.call("_mainLanguage", languageName).get();
    }

    /**
    * run main dialog without speaking
    * 
    */
    public void _runMainNoActivation() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_runMainNoActivation");
        else
            service.call("_runMainNoActivation").get();
    }

    /**
    * run main dialog
    * 
    */
    public void _runMain() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_runMain");
        else
            service.call("_runMain").get();
    }

    /**
    * run main dialog
    * 
    * @param engagementMode  engagementMode
    */
    public void _startDialog(String engagementMode) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_startDialog", engagementMode);
        else
            service.call("_startDialog", engagementMode).get();
    }

    /**
    * change engagement mode
    * 
    * @param engagementMode  engagementMode
    */
    public void _setEngagementMode(String engagementMode) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_setEngagementMode", engagementMode);
        else
            service.call("_setEngagementMode", engagementMode).get();
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
    * reset preload settings
    * 
    */
    public void _resetPreload() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_resetPreload");
        else
            service.call("_resetPreload").get();
    }

    /**
    * stop main dialog
    * 
    */
    public void _stopMain() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_stopMain");
        else
            service.call("_stopMain").get();
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
    * load a strategy configuration
    * 
    * @param strategyFile  Strategy path and filename
    */
    public void _loadStrategyConfiguration(String strategyFile) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_loadStrategyConfiguration", strategyFile);
        else
            service.call("_loadStrategyConfiguration", strategyFile).get();
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
    * startUpdate
    * 
    * @param variableName  variable name
    * @param variableValue  variable value
    * @param message  message
    */
    public void startUpdate(String variableName, java.lang.Object variableValue, String message) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("startUpdate", variableName, variableValue, message);
        else
            service.call("startUpdate", variableName, variableValue, message).get();
    }

    /**
    * startUpdate
    * 
    * @param variableName  variable name
    * @param variableValue  variable value
    * @param message  message
    */
    public void startApp(String variableName, java.lang.Object variableValue, String message) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("startApp", variableName, variableValue, message);
        else
            service.call("startApp", variableName, variableValue, message).get();
    }

    /**
    * packageInstalled
    * 
    * @param variableName  variable name
    * @param variableValue  variable value
    * @param message  message
    */
    public void packageInstalled(String variableName, java.lang.Object variableValue, String message) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("packageInstalled", variableName, variableValue, message);
        else
            service.call("packageInstalled", variableName, variableValue, message).get();
    }

    /**
    * compilationFinished
    * 
    * @param variableName  variable name
    * @param variableValue  variable value
    * @param message  message
    */
    public void compilationFinished(String variableName, java.lang.Object variableValue, String message) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("compilationFinished", variableName, variableValue, message);
        else
            service.call("compilationFinished", variableName, variableValue, message).get();
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
    * Enable AI System
    * 
    * @param enableFullBNF  Add all possible sentences in speech recognition
    */
    public void _enableOneBNFActivated(Boolean enableFullBNF) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_enableOneBNFActivated", enableFullBNF);
        else
            service.call("_enableOneBNFActivated", enableFullBNF).get();
    }

    /**
    * Enable AI System
    * 
    * @param enableAISystem  Enable AI system
    */
    public void _enableAISystem(Boolean enableAISystem) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_enableAISystem", enableAISystem);
        else
            service.call("_enableAISystem", enableAISystem).get();
    }

    /**
    * Enable Strategy Switch when loose internet connection
    * 
    * @param enableSwitch  enable switch
    */
    public void _enableStrategySwitch(Boolean enableSwitch) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_enableStrategySwitch", enableSwitch);
        else
            service.call("_enableStrategySwitch", enableSwitch).get();
    }

    /**
    * Load precompiled file
    * 
    * @param filepath  File path and filename
    * @param bundleName  Bundle name
    * @param language  Language name
    */
    public void _loadPrecompiledFile(String filepath, String bundleName, String language) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_loadPrecompiledFile", filepath, bundleName, language);
        else
            service.call("_loadPrecompiledFile", filepath, bundleName, language).get();
    }

    /**
    * Load SLM
    * 
    * @param SLMFile  SLM path and filename
    * @param language  Language name
    */
    public void _loadSLM(String SLMFile, String language) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_loadSLM", SLMFile, language);
        else
            service.call("_loadSLM", SLMFile, language).get();
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
    * fast behavior start
    * 
    * @param Event  Event name
    */
    public void _setBehaviorEvent(String Event) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_setBehaviorEvent", Event);
        else
            service.call("_setBehaviorEvent", Event).get();
    }

    /**
    * triggers and proposal are activated in the model at compilation time
    * 
    * @param enable  Enable fast activation
    */
    public void _fastModelActivation(Boolean enable) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_fastModelActivation", enable);
        else
            service.call("_fastModelActivation", enable).get();
    }

    /**
    * byPass fast approximative matching
    * 
    * @param fastApproximative  enable fast approximative matching
    */
    public void _byPassFastApproximateMatching(Boolean fastApproximative) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_byPassFastApproximateMatching", fastApproximative);
        else
            service.call("_byPassFastApproximateMatching", fastApproximative).get();
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
    * fallback (experimentatl)
    * 
    * @param Question  User question
    * @param Language  Language
    */
    public String _fallback(String Question, String Language) throws CallError, InterruptedException {
        return (String)service.call("_fallback", Question, Language).get();
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
    * encrypt the logs sent tothe cloud
    * 
    * @param EnableLog  Remove user log
    */
    public void _encryptLog(Boolean EnableLog) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_encryptLog", EnableLog);
        else
            service.call("_encryptLog", EnableLog).get();
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
    * check if the robot is encrypting the log sent to the cloud
    * 
    * @return True if currently encrypt logging
    */
    public Boolean _isEncryptingLog() throws CallError, InterruptedException {
        return (Boolean)service.call("_isEncryptingLog").get();
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
    * The deletion cost (deleting from the sentence to match the model)
    * 
    * @param MatchingDeletionCost  Deletion cost
    */
    public void _setDeletionCost(Float MatchingDeletionCost) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_setDeletionCost", MatchingDeletionCost);
        else
            service.call("_setDeletionCost", MatchingDeletionCost).get();
    }

    /**
    * The insertion cost (inserting in the sentence to match the model)
    * 
    * @param MatchingInsertCost  Insert cost
    */
    public void _setInsertionCost(Float MatchingInsertCost) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_setInsertionCost", MatchingInsertCost);
        else
            service.call("_setInsertionCost", MatchingInsertCost).get();
    }

    /**
    * The substitution cost
    * 
    * @param MatchingSubstitutionCost  Substitution cost
    */
    public void _setSubstitutionCost(Float MatchingSubstitutionCost) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_setSubstitutionCost", MatchingSubstitutionCost);
        else
            service.call("_setSubstitutionCost", MatchingSubstitutionCost).get();
    }

    /**
    * The cost of matching an open element (such as _*)
    * 
    * @param MatchingStarCost  Wildcard cost
    */
    public void _setStarCost(Float MatchingStarCost) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_setStarCost", MatchingStarCost);
        else
            service.call("_setStarCost", MatchingStarCost).get();
    }

    /**
    * The approximate matching threshold
    * 
    * @param MatchingThreshold  Matching threshold
    */
    public void _setApproximateMatchingThreshold(Float MatchingThreshold) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_setApproximateMatchingThreshold", MatchingThreshold);
        else
            service.call("_setApproximateMatchingThreshold", MatchingThreshold).get();
    }

    /**
    * Tell to the model to use acrobatic matching
    * 
    * @param EnableAccrobatic  Enable accrobatic matching
    */
    public void _useAcrobaticMatching(Boolean EnableAccrobatic) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_useAcrobaticMatching", EnableAccrobatic);
        else
            service.call("_useAcrobaticMatching", EnableAccrobatic).get();
    }

    /**
    * Tell to the model to use statistical matching
    * 
    * @param EnableSemantic  Enable semantic matching
    */
    public void _enableStatisticalMatching(Boolean EnableSemantic) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_enableStatisticalMatching", EnableSemantic);
        else
            service.call("_enableStatisticalMatching", EnableSemantic).get();
    }

    /**
    * Tell to the model to use phonetic matching
    * 
    * @param EnablePhonetic  Enable phonetic matching
    */
    public void _enablePhoneticMatching(Boolean EnablePhonetic) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_enablePhoneticMatching", EnablePhonetic);
        else
            service.call("_enablePhoneticMatching", EnablePhonetic).get();
    }

    /**
    * Specify the directory and language of the statistical model
    * 
    * @param semanticPath  Semantic matching data path
    */
    public void _setSemanticModel(String semanticPath, String param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_setSemanticModel", semanticPath, param1);
        else
            service.call("_setSemanticModel", semanticPath, param1).get();
    }

    /**
    * Is one pass enabled
    * 
    * @return Enable only one speech recognition
    */
    public Boolean _isOnePassEnabled() throws CallError, InterruptedException {
        return (Boolean)service.call("_isOnePassEnabled").get();
    }

    /**
    * set SLM High treshold
    * 
    * @param SLMUpper  SLM Upper Threshold
    */
    public void _setSLMUpperThreshold(Float SLMUpper) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_setSLMUpperThreshold", SLMUpper);
        else
            service.call("_setSLMUpperThreshold", SLMUpper).get();
    }

    /**
    * enable use of serialized models
    * 
    * @param enableSerialization  Enable serialization
    */
    public void _enableSerialization(Boolean enableSerialization) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_enableSerialization", enableSerialization);
        else
            service.call("_enableSerialization", enableSerialization).get();
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
    * Set if the input concepts are copied
    * 
    * @param copyInput  False to optimize
    */
    public void _copyInputConcepts(Boolean copyInput) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_copyInputConcepts", copyInput);
        else
            service.call("_copyInputConcepts", copyInput).get();
    }

    /**
    * Set if the input concepts are copied
    * 
    * @param copyOutput  False to optimize
    */
    public void _copyOutputConcepts(Boolean copyOutput) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_copyOutputConcepts", copyOutput);
        else
            service.call("_copyOutputConcepts", copyOutput).get();
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

    /**
    * Set the sentence length to apply -after star optimization- in matching
    * 
    * @param length  set length
    */
    public void _setLengthForAfterStarOptimization(Integer length) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_setLengthForAfterStarOptimization", length);
        else
            service.call("_setLengthForAfterStarOptimization", length).get();
    }

    /**
    * Set the sentence length to apply -before star optimization- in matching
    * 
    * @param length  set length
    */
    public void _setLengthForBeforeStarOptimization(Integer length) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_setLengthForBeforeStarOptimization", length);
        else
            service.call("_setLengthForBeforeStarOptimization", length).get();
    }

    /**
    * 
    * 
    * @param   
    * @param   
    * @param   
    */
    public void _onUserSessionFocused(String param1, java.lang.Object param2, String param3) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_onUserSessionFocused", param1, param2, param3);
        else
            service.call("_onUserSessionFocused", param1, param2, param3).get();
    }

    /**
    * 
    * 
    * @param   
    * @param   
    * @param   
    */
    public java.lang.Object _us_getUserData(String param1, String param2, String param3) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("_us_getUserData", param1, param2, param3).get();
    }

    /**
    * Query if dialog sessions are controlled by ALUserSession
    * 
    * @param is_obeyed  Bool. True if dialog should open/close sessions according to ALUserSession
    */
    public void _setUserSessionObeyed(Boolean is_obeyed) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_setUserSessionObeyed", is_obeyed);
        else
            service.call("_setUserSessionObeyed", is_obeyed).get();
    }

    /**
    * Query if dialog sessions are controlled by ALUserSession
    * 
    * @return Bool. True if dialog will open/close sessions according to ALUserSession
    */
    public Boolean _isUserSessionObeyed() throws CallError, InterruptedException {
        return (Boolean)service.call("_isUserSessionObeyed").get();
    }

}
    