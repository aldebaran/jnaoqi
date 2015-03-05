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
* This module allows to play wav and mp3 files on NAO
* @see <a href="http://doc.aldebaran.lan/doc/release-2.1/aldeb-doc/naoqi/audio/alaudioplayer.html#alaudioplayer">NAOqi APIs for ALAudioPlayer </a>
*
*/
public class ALAudioPlayer extends ALProxy {

    public ALAudioPlayer(Session session) {
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
    * Plays a wav or mp3 file
    * 
    * @param fileName  Path of the sound file
    */
    public void playFile(String fileName) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("playFile", fileName);
        else
            service.call("playFile", fileName).get();
    }

    /**
    * Plays a wav or mp3 file, with specific volume and audio balance
    * 
    * @param fileName  Path of the sound file
    * @param volume  volume of the sound file (must be between 0.0 and 1.0)
    * @param pan  audio balance of the sound file (-1.0 : left / 1.0 : right / 0.0 : centered)
    */
    public void playFile(String fileName, Float volume, Float pan) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("playFile", fileName, volume, pan);
        else
            service.call("playFile", fileName, volume, pan).get();
    }

    /**
    * Plays a file contained in one of the sound sets loaded
    * 
    * @param fileName  Name of the file without extension
    */
    public void playSoundSetFile(String fileName) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("playSoundSetFile", fileName);
        else
            service.call("playSoundSetFile", fileName).get();
    }

    /**
    * Plays a file contained in a given sound set
    * 
    * @param soundSetName  Name of the soundset
    * @param fileName  Name of the file without extension
    */
    public void playSoundSetFile(String soundSetName, String fileName) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("playSoundSetFile", soundSetName, fileName);
        else
            service.call("playSoundSetFile", soundSetName, fileName).get();
    }

    /**
    * Plays a file contained in a given sound set
    * 
    * @param soundSetName  Name of the soundset
    * @param fileName  Name of the file without extension
    * @param position  Position in second where the playing has to begin
    * @param volume  volume of the sound file (must be between 0.0 and 1.0)
    * @param pan  audio balance of the sound file (-1.0 : left / 1.0 : right)
    * @param loop  specify if the file must be played in loop
    */
    public void playSoundSetFile(String soundSetName, String fileName, Float position, Float volume, Float pan, Boolean loop) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("playSoundSetFile", soundSetName, fileName, position, volume, pan, loop);
        else
            service.call("playSoundSetFile", soundSetName, fileName, position, volume, pan, loop).get();
    }

    /**
    * Plays a file contained in a given sound set
    * 
    * @param fileName  Name of the file without extension
    * @param position  Position in second where the playing has to begin
    * @param volume  volume of the sound file (must be between 0.0 and 1.0)
    * @param pan  audio balance of the sound file (-1.0 : left / 1.0 : right)
    * @param loop  specify if the file must be played in loop
    */
    public void playSoundSetFile(String fileName, Float position, Float volume, Float pan, Boolean loop) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("playSoundSetFile", fileName, position, volume, pan, loop);
        else
            service.call("playSoundSetFile", fileName, position, volume, pan, loop).get();
    }

    /**
    * Load a sound set
    * 
    * @param setName  name of the set
    */
    public void loadSoundSet(String setName) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("loadSoundSet", setName);
        else
            service.call("loadSoundSet", setName).get();
    }

    /**
    * Unload a sound set
    * 
    * @param setName  name of the set
    */
    public void unloadSoundSet(String setName) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("unloadSoundSet", setName);
        else
            service.call("unloadSoundSet", setName).get();
    }

    /**
    * Return the list of files contained in a sound set
    * 
    * @param setName  name of the set
    */
    public List<String> getSoundSetFileNames(String setName) throws CallError, InterruptedException {
        return (List<String>)service.call("getSoundSetFileNames", setName).get();
    }

    /**
    * 
    * 
    */
    public List<String> getLoadedSoundSetsList() throws CallError, InterruptedException {
        return (List<String>)service.call("getLoadedSoundSetsList").get();
    }

    /**
    * 
    * 
    */
    public List<String> getInstalledSoundSetsList() throws CallError, InterruptedException {
        return (List<String>)service.call("getInstalledSoundSetsList").get();
    }

    /**
    * 
    * 
    * @param setName  name of the set
    */
    public Boolean isSoundSetInstalled(String setName) throws CallError, InterruptedException {
        return (Boolean)service.call("isSoundSetInstalled", setName).get();
    }

    /**
    * 
    * 
    * @param setName  name of the set
    * @param soundName  name of the sound
    */
    public Boolean isSoundSetFileInstalled(String setName, String soundName) throws CallError, InterruptedException {
        return (Boolean)service.call("isSoundSetFileInstalled", setName, soundName).get();
    }

    /**
    * Plays a wav or mp3 file in loop
    * 
    * @param fileName  Path of the sound file
    */
    public void playFileInLoop(String fileName) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("playFileInLoop", fileName);
        else
            service.call("playFileInLoop", fileName).get();
    }

    /**
    * Plays a wav or mp3 file in loop, with specific volume and audio balance
    * 
    * @param fileName  Path of the sound file
    * @param volume  volume of the sound file (must be between 0.0 and 1.0)
    * @param pan  audio balance of the sound file (-1.0 : left / 1.0 : right)
    */
    public void playFileInLoop(String fileName, Float volume, Float pan) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("playFileInLoop", fileName, volume, pan);
        else
            service.call("playFileInLoop", fileName, volume, pan).get();
    }

    /**
    * Plays a wav or mp3 file from a given position in the file.
    * 
    * @param fileName  Name of the sound file
    * @param position  Position in second where the playing has to begin
    */
    public void playFileFromPosition(String fileName, Float position) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("playFileFromPosition", fileName, position);
        else
            service.call("playFileFromPosition", fileName, position).get();
    }

    /**
    * Plays a wav or mp3 file from a given position in the file, with specific volume and audio balance
    * 
    * @param fileName  Name of the sound file
    * @param position  Position in second where the playing has to begin
    * @param volume  volume of the sound file (must be between 0.0 and 1.0)
    * @param pan  audio balance of the sound file (-1.0 : left / 1.0 : right)
    */
    public void playFileFromPosition(String fileName, Float position, Float volume, Float pan) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("playFileFromPosition", fileName, position, volume, pan);
        else
            service.call("playFileFromPosition", fileName, position, volume, pan).get();
    }

    /**
    * Goes to a given position in a file which is playing.
    * 
    * @param playId  Id of the process which is playing the file
    * @param position  Position in the file (in second)
    */
    public void goTo(Integer playId, Float position) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("goTo", playId, position);
        else
            service.call("goTo", playId, position).get();
    }

    /**
    * Stops all the files that are currently playing.
    * 
    */
    public void stopAll() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("stopAll");
        else
            service.call("stopAll").get();
    }

    /**
    * Pause a play back
    * 
    * @param id  Id of the process that is playing the file you want to put in pause
    */
    public void pause(Integer id) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("pause", id);
        else
            service.call("pause", id).get();
    }

    /**
    * Sets the volume of the player
    * 
    * @param id  Id of the process that is playing the file you want to put louder or less loud
    * @param volume  Volume - range 0.0 to 1.0
    */
    public void setVolume(Integer id, Float volume) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setVolume", id, volume);
        else
            service.call("setVolume", id, volume).get();
    }

    /**
    * Sets the master volume of the player
    * 
    * @param volume  Volume - range 0.0 to 1.0
    */
    public void setMasterVolume(Float volume) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setMasterVolume", volume);
        else
            service.call("setMasterVolume", volume).get();
    }

    /**
    * Returns the volume of the player
    * 
    * @param playId  Id of the process which is playing the file
    * @return Volume of the player - range 0.0 to 1.0.
    */
    public Float getVolume(Integer playId) throws CallError, InterruptedException {
        return (Float)service.call("getVolume", playId).get();
    }

    /**
    * Returns the master volume of the player
    * 
    * @return Volume of the master - range 0.0 to 1.0.
    */
    public Float getMasterVolume() throws CallError, InterruptedException {
        return (Float)service.call("getMasterVolume").get();
    }

    /**
    * sets the audio panorama : -1 for left speaker / 1 for right speaker
    * 
    */
    public void setPanorama(Float param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setPanorama", param1);
        else
            service.call("setPanorama", param1).get();
    }

    /**
    * Loads a file for ulterior playback
    * 
    * @param fileName  Path of the sound file (either mp3 or wav)
    * @return Id of the file which has been loaded. This file can then be played with the play function
    */
    public Integer loadFile(String fileName) throws CallError, InterruptedException {
        return (Integer)service.call("loadFile", fileName).get();
    }

    /**
    * unloads a file previously loaded with the loadFile function
    * 
    * @param id  Id returned by the loadFile function
    */
    public void unloadFile(Integer id) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("unloadFile", id);
        else
            service.call("unloadFile", id).get();
    }

    /**
    * unloads all the files already loaded.
    * 
    */
    public void unloadAllFiles() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("unloadAllFiles");
        else
            service.call("unloadAllFiles").get();
    }

    /**
    * returns an array containing the names of the currently loaded files
    * 
    * @return Array containing the names of the files which has been loaded
    */
    public List<String> getLoadedFilesNames() throws CallError, InterruptedException {
        return (List<String>)service.call("getLoadedFilesNames").get();
    }

    /**
    * returns an array containing the Ids of the currently loaded files
    * 
    * @return Array containing the Ids of the files which has been loaded
    */
    public List<String> getLoadedFilesIds() throws CallError, InterruptedException {
        return (List<String>)service.call("getLoadedFilesIds").get();
    }

    /**
    * Starts the playback of a file preloaded with the loadFile function.
    * 
    * @param id  Id returned by the loadFile function
    */
    public void play(Integer id) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("play", id);
        else
            service.call("play", id).get();
    }

    /**
    * Starts the playback of a file preloaded with the loadFile function, with specific volume and audio balance
    * 
    * @param id  Id returned by the loadFile function
    * @param volume  volume of the sound file (must be between 0.0 and 1.0)
    * @param pan  audio balance of the sound file (-1.0 : left / 1.0 : right)
    */
    public void play(Integer id, Float volume, Float pan) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("play", id, volume, pan);
        else
            service.call("play", id, volume, pan).get();
    }

    /**
    * Starts the playback in loop of a file preloaded with the loadFile function
    * 
    * @param id  Id returned by the loadFile function
    */
    public void playInLoop(Integer id) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("playInLoop", id);
        else
            service.call("playInLoop", id).get();
    }

    /**
    * Plays a wav or mp3 file in loop, with specific volume and audio balance
    * 
    * @param id  Id returned by the loadFile function
    * @param volume  volume of the sound file (must be between 0.0 and 1.0)
    * @param pan  audio balance of the sound file (-1.0 : left / 1.0 : right)
    */
    public void playInLoop(Integer id, Float volume, Float pan) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("playInLoop", id, volume, pan);
        else
            service.call("playInLoop", id, volume, pan).get();
    }

    /**
    * Starts the playback of a wab audio stream
    * 
    * @param streamName  Path of the web audio stream
    */
    public void playWebStream(String streamName, Float param1, Float param2) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("playWebStream", streamName, param1, param2);
        else
            service.call("playWebStream", streamName, param1, param2).get();
    }

    /**
    * Returns the length of the file played
    * 
    * @param playId  Id of the process which is playing the file
    * @return Length of the file in seconds
    */
    public Float getFileLength(Integer playId) throws CallError, InterruptedException {
        return (Float)service.call("getFileLength", playId).get();
    }

    /**
    * Returns the position in the file which is currently played
    * 
    * @param playId  Id of the process which is playing the file
    * @return Position in the file in seconds
    */
    public Float getCurrentPosition(Integer playId) throws CallError, InterruptedException {
        return (Float)service.call("getCurrentPosition", playId).get();
    }

    /**
    * Play a sine wave which specified caracteristics.
    * 
    * @param frequence  Frequence in Hertz
    * @param gain  Volume Gain between 0 and 100
    * @param pan  Stereo Pan set to either {-1,0,+1}
    * @param duration  Duration of the sine wave in seconds
    */
    public void playSine(Integer frequence, Integer gain, Integer pan, Float duration) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("playSine", frequence, gain, pan, duration);
        else
            service.call("playSine", frequence, gain, pan, duration).get();
    }

}
    