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
* This module embeds a speech synthetizer whose role is to convert text commands into sound waves that are then either sent to Nao's loudspeakers or written into a file. This service supports several languages and some parameters of the synthetizer can be tuned to change each language's synthetic voice.
* @see <a href="http://doc.aldebaran.lan/doc/master/aldeb-doc/naoqi/audio/altexttospeech.html#altexttospeech">NAOqi APIs for ALTextToSpeech </a>
*
*/
public class ALTextToSpeech extends ALProxy {

    public ALTextToSpeech(Session session) {
        super(session);
    }

    /**
    * Loads a set of voice parameters defined in a xml file contained in the preferences folder.The name of the xml file must begin with ALTextToSpeech_Voice_ 
    * 
    * @param pPreferenceName  Name of the voice preference.
    */
    public void loadVoicePreference(String pPreferenceName) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("loadVoicePreference", pPreferenceName);
        else
            service.call("loadVoicePreference", pPreferenceName).get();
    }

    /**
    * Outputs the available voices. The returned list contains the voice IDs.
    * 
    * @return  Array of std::string containing the voices installed on the system.
    */
    public List<String> getAvailableVoices() throws CallError, InterruptedException {
        return (List<String>)service.call("getAvailableVoices").get();
    }

    /**
    * Fetches the current volume the text to speech.
    * 
    * @return Volume (integer between 0 and 100).
    */
    public Float getVolume() throws CallError, InterruptedException {
        return (Float)service.call("getVolume").get();
    }

    /**
    * Shows the Dictionary.
    * 
    */
    public void showDictionary() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("showDictionary");
        else
            service.call("showDictionary").get();
    }

    /**
    * Unload the dictionary.
    * 
    * @param word  the word you wish to delete, does not have to be in japanese.
    * @return bool: true if succeeded, false if failed
    */
    public Boolean deleteFromDictionary(String word, String param1) throws CallError, InterruptedException {
        return (Boolean)service.call("deleteFromDictionary", word, param1).get();
    }

    /**
    * Get the locale associate to the current language.
    * 
    * @return A string with xx_XX format (region_country)
    */
    public String locale() throws CallError, InterruptedException {
        return (String)service.call("locale").get();
    }

    /**
    * Add a word to the library
    * 
    * @param type  the type of word you wish to insert, does not have to be in japanese.
    * @param word  the word you wish to insert, does not have to be in japanese.
    * @param priority  the priority of the word.
    * @param phonetic  the phonetic pronouciation in KATAKANA.
    * @param accent  syllabus and accentuation
    * @return bool: true if succeeded, false if failed
    */
    public Boolean addToDictionary(String type, String word, String priority, String phonetic, String accent) throws CallError, InterruptedException {
        return (Boolean)service.call("addToDictionary", type, word, priority, phonetic, accent).get();
    }

    /**
    * Add a word to the library
    * 
    * @param text  the text you wish to insert.
    * @param toReplace  text to replace.
    * @return bool: true if succeeded, false if failed
    */
    public Boolean addToDictionary(String text, String toReplace) throws CallError, InterruptedException {
        return (Boolean)service.call("addToDictionary", text, toReplace).get();
    }

    /**
    * Sets a voice as the default voice for the corresponding language
    * 
    * @param Language  The language among those available on your robot as a String
    * @param Voice  The voice among those available on your robot as a String
    */
    public void setLanguageDefaultVoice(String Language, String Voice) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setLanguageDefaultVoice", Language, Voice);
        else
            service.call("setLanguageDefaultVoice", Language, Voice).get();
    }

    /**
    * Sets the volume of text-to-speech output.
    * 
    * @param volume  Volume (between 0.0 and 1.0).
    */
    public void setVolume(Float volume) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setVolume", volume);
        else
            service.call("setVolume", volume).get();
    }

    /**
    * Enables the notifications puted in ALMemory during the synthesis (TextStarted, TextDone, CurrentBookMark, CurrentWord, ...)
    * 
    */
    public void enableNotifications() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("enableNotifications");
        else
            service.call("enableNotifications").get();
    }

    /**
    * Disables the notifications puted in ALMemory during the synthesis (TextStarted, TextDone, CurrentBookMark, CurrentWord, ...)
    * 
    */
    public void disableNotifications() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("disableNotifications");
        else
            service.call("disableNotifications").get();
    }

    /**
    * Unload the dictionary.
    * 
    * @param word  the word you wish to delete, does not have to be in japanese.
    * @return bool: true if succeeded, false if failed
    */
    public Boolean deleteFromDictionary(String word) throws CallError, InterruptedException {
        return (Boolean)service.call("deleteFromDictionary", word).get();
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
    * Performs the text-to-speech operations : it takes a std::string as input and outputs a sound in both speakers. String encoding must be UTF8.
    * 
    * @param stringToSay  Text to say, encoded in UTF-8.
    */
    public void say(String stringToSay) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("say", stringToSay);
        else
            service.call("say", stringToSay).get();
    }

    /**
    * Performs the text-to-speech operations in a specific language: it takes a std::string as input and outputs a sound in both speakers. String encoding must be UTF8. Once the text is said, the language is set back to its initial value.
    * 
    * @param stringToSay  Text to say, encoded in UTF-8.
    * @param language  Language used to say the text.
    */
    public void say(String stringToSay, String language) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("say", stringToSay, language);
        else
            service.call("say", stringToSay, language).get();
    }

    /**
    * Performs the text-to-speech operations: it takes a std::string as input and outputs the corresponding audio signal in the specified file.
    * 
    * @param pStringToSay  Text to say, encoded in UTF-8.
    * @param pFileName  RAW file where to store the generated signal. The signal is encoded with a sample rate of 22050Hz, format S16_LE, 2 channels.
    */
    public void sayToFile(String pStringToSay, String pFileName) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("sayToFile", pStringToSay, pFileName);
        else
            service.call("sayToFile", pStringToSay, pFileName).get();
    }

    /**
    * This method performs the text-to-speech operations: it takes a std::string, outputs the synthesis resulting audio signal in a file, and then plays the audio file. The file is deleted afterwards. It is useful when you want to perform a short synthesis, when few CPU is available. Do not use it if you want a low-latency synthesis or to synthesize a long std::string.
    * 
    * @param pStringToSay  Text to say, encoded in UTF-8.
    */
    public void sayToFileAndPlay(String pStringToSay) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("sayToFileAndPlay", pStringToSay);
        else
            service.call("sayToFileAndPlay", pStringToSay).get();
    }

    /**
    * This method stops the current and all the pending tasks immediately.
    * 
    */
    public void stopAll() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("stopAll");
        else
            service.call("stopAll").get();
    }

    /**
    * Changes the language used by the Text-to-Speech engine. It automatically changes the voice used since each of them is related to a unique language. If you want that change to take effect automatically after reboot of your robot, refer to the robot web page (setting page).
    * 
    * @param pLanguage  Language name. Must belong to the languages available in TTS (can be obtained with the getAvailableLanguages method).  It should be an identifier std::string.
    */
    public void setLanguage(String pLanguage) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setLanguage", pLanguage);
        else
            service.call("setLanguage", pLanguage).get();
    }

    /**
    * Returns the language currently used by the text-to-speech engine.
    * 
    * @return Language of the current voice.
    */
    public String getLanguage() throws CallError, InterruptedException {
        return (String)service.call("getLanguage").get();
    }

    /**
    * Returns the encoding that should be used with the specified language.
    * 
    * @param pLanguage  Language name (as a std::string). Must belong to the languages available in TTS.
    * @return Encoding of the specified language.
    */
    public String getLanguageEncoding(String pLanguage) throws CallError, InterruptedException {
        return (String)service.call("getLanguageEncoding", pLanguage).get();
    }

    /**
    * Outputs the languages installed on the system.
    * 
    * @return Array of std::string that contains the languages installed on the system.
    */
    public List<String> getAvailableLanguages() throws CallError, InterruptedException {
        return (List<String>)service.call("getAvailableLanguages").get();
    }

    /**
    * Outputs all the languages supported (may be installed or not).
    * 
    * @return Array of std::string that contains all the supported languages (may be installed or not).
    */
    public List<String> getSupportedLanguages() throws CallError, InterruptedException {
        return (List<String>)service.call("getSupportedLanguages").get();
    }

    /**
    * Changes the parameters of the voice. For now, it is only possible to reset the voice speed.
    * 
    * @param pEffectName  Name of the parameter.
    */
    public void resetSpeed() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("resetSpeed");
        else
            service.call("resetSpeed").get();
    }

    /**
    * Changes the parameters of the voice. The available parameters are: 
 	 pitchShift: applies a pitch shifting to the voice. The value indicates the ratio between the new fundamental frequencies and the old ones (examples: 2.0: an octave above, 1.5: a quint above). Correct range is (1.0 -- 4), or 0 to disable effect.
 	 doubleVoice: adds a second voice to the first one. The value indicates the ratio between the second voice fundamental frequency and the first one. Correct range is (1.0 -- 4), or 0 to disable effect 
 	 doubleVoiceLevel: the corresponding value is the level of the double voice (1.0: equal to the main voice one). Correct range is (0 -- 4). 
 	 doubleVoiceTimeShift: the corresponding value is the delay between the double voice and the main one. Correct range is (0 -- 0.5) 
 If the effect value is not available, the effect parameter remains unchanged.
    * 
    * @param pEffectName  Name of the parameter.
    * @param pEffectValue  Value of the parameter.
    */
    public void setParameter(String pEffectName, Float pEffectValue) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setParameter", pEffectName, pEffectValue);
        else
            service.call("setParameter", pEffectName, pEffectValue).get();
    }

    /**
    * Returns the value of one of the voice parameters. The available parameters are: "pitchShift", "doubleVoice","doubleVoiceLevel" and "doubleVoiceTimeShift"
    * 
    * @param pParameterName  Name of the parameter.
    * @return Value of the specified parameter
    */
    public Float getParameter(String pParameterName) throws CallError, InterruptedException {
        return (Float)service.call("getParameter", pParameterName).get();
    }

    /**
    * Changes the voice used by the text-to-speech engine. The voice identifier must belong to the installed voices, that can be listed using the 'getAvailableVoices' method. If the voice is not available, it remains unchanged. No exception is thrown in this case. For the time being, only two voices are available by default : Kenny22Enhanced (English voice) and Julie22Enhanced (French voice)
    * 
    * @param pVoiceID  The voice (as a std::string).
    */
    public void setVoice(String pVoiceID) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setVoice", pVoiceID);
        else
            service.call("setVoice", pVoiceID).get();
    }

    /**
    * Returns the voice currently used by the text-to-speech engine.
    * 
    * @return Name of the current voice
    */
    public String getVoice() throws CallError, InterruptedException {
        return (String)service.call("getVoice").get();
    }

}
    