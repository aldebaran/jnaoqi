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
* The ALAudioDevice module allows other modules to access to the sound data of the nao's microphones, and to send sound toward its loudspeakers  The way to receive or send the audio data depends whether the modules are local (dynamic library) or remote (executable).
* @see <a href="http://doc.aldebaran.lan/doc/release-2.1/aldeb-doc/naoqi/audio/alaudiodevice.html#alaudiodevice">NAOqi APIs for ALAudioDevice </a>
*
*/
public class ALAudioDevice extends ALProxy {

    public ALAudioDevice(Session session) {
        super(session);
    }

    /**
    * Flush the audio device for playback. close the audio device for capture. You can call this method if you want to send sound to alsa in another program than naoqi while naoqi is running (with aplay for example)
    * 
    */
    public void flushAudioOutputs() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("flushAudioOutputs");
        else
            service.call("flushAudioOutputs").get();
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

    /**
    * Enables the computation of the energy of each microphone signal
    * 
    */
    public void enableEnergyComputation() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("enableEnergyComputation");
        else
            service.call("enableEnergyComputation").get();
    }

    /**
    * Allows to know if audio inputs are closed or not
    * 
    * @return True if audio inputs are closed / False otherwise
    */
    public Boolean isInputClosed() throws CallError, InterruptedException {
        return (Boolean)service.call("isInputClosed").get();
    }

    /**
    * Returns the energy of the left microphone signal
    * 
    * @return energy of the left microphone signal
    */
    public Float getLeftMicEnergy() throws CallError, InterruptedException {
        return (Float)service.call("getLeftMicEnergy").get();
    }

    /**
    * Returns the energy of the right microphone signal
    * 
    * @return energy of the right microphone signal
    */
    public Float getRightMicEnergy() throws CallError, InterruptedException {
        return (Float)service.call("getRightMicEnergy").get();
    }

    /**
    * Returns the energy of the front microphone signal
    * 
    * @return energy of the front microphone signal
    */
    public Float getFrontMicEnergy() throws CallError, InterruptedException {
        return (Float)service.call("getFrontMicEnergy").get();
    }

    /**
    * Returns the energy of the rear microphone signal
    * 
    * @return energy of the rear microphone signal
    */
    public Float getRearMicEnergy() throws CallError, InterruptedException {
        return (Float)service.call("getRearMicEnergy").get();
    }

    /**
    * Set AudioDevice Client preferences. This function is deprecated, the use of the alternate 4 arguments setClientPreferences() is now prefered.
    * 
    * @param name  name of the client
    * @param sampleRate  sample rate of the microphones data sent to the processSound or processSoundRemote functions - must be 16000 or 48000
    * @param channelsVector  ALValue containing a vector of int indicating which microphones data will be send to the processSound or processSoundRemote functions
    * @param deinterleaved  indicates if the microphones data sent to the processSound or processSoundRemote functions are interleaved or not - 0 : interleaved - 1 : deinterleaved 
    * @param timeStamp  parameter indicating if audio timestamps are sent to the processSound or processSoundRemote functions - 0 : no - 1 : yes 
    */
    public void setClientPreferences(String name, Integer sampleRate, Object channelsVector, Integer deinterleaved, Integer timeStamp) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setClientPreferences", name, sampleRate, channelsVector, deinterleaved, timeStamp);
        else
            service.call("setClientPreferences", name, sampleRate, channelsVector, deinterleaved, timeStamp).get();
    }

    /**
    * mute the loudspeakers
    * 
    */
    public void muteAudioOut(Boolean param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("muteAudioOut", param1);
        else
            service.call("muteAudioOut", param1).get();
    }

    /**
    * check if loudspeakers are muted
    * 
    * @return 1 if true / 0 otherwise
    */
    public Boolean isAudioOutMuted() throws CallError, InterruptedException {
        return (Boolean)service.call("isAudioOutMuted").get();
    }

    /**
    * Allows to know if audio ouputs are closed or not
    * 
    * @return True if audio outputs are closed / False otherwise
    */
    public Boolean isOutputClosed() throws CallError, InterruptedException {
        return (Boolean)service.call("isOutputClosed").get();
    }

    /**
    * Set AudioDevice Client preferences
    * 
    * @param name  name of the client
    * @param sampleRate  sample rate of the microphones data sent to the process function - must be 16000 or 48000
    * @param channelsConfiguration  An int (defined in ALSoundExtractor) indicating which microphones data will be send to the process function. ALLCHANNELS, LEFTCHANNEL, RIGHTCHANNEL, FRONTCHANNEL, REARCHANNEL are the configuration currently supported.
    * @param deinterleaved  indicates if the microphones data sent to the process function are interleaved or not - 0 : interleaved - 1 : deinterleaved 
    */
    public void setClientPreferences(String name, Integer sampleRate, Integer channelsConfiguration, Integer deinterleaved) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setClientPreferences", name, sampleRate, channelsConfiguration, deinterleaved);
        else
            service.call("setClientPreferences", name, sampleRate, channelsConfiguration, deinterleaved).get();
    }

    /**
    * Disables the computation of the energy of each microphone signal
    * 
    */
    public void disableEnergyComputation() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("disableEnergyComputation");
        else
            service.call("disableEnergyComputation").get();
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
    * This function allows a module to subscribe to the ALAudioDevice module.For more informations see the audio part of the red documentation
    * 
    * @param pModule  Name of the module
    */
    public void subscribe(String pModule) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("subscribe", pModule);
        else
            service.call("subscribe", pModule).get();
    }

    /**
    * This function allows a module to subscribe to the ALAudioDevice module.For more informations see the audio part of the red documentation
    * 
    * @param pModule  Name of the module
    */
    public void unsubscribe(String pModule) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("unsubscribe", pModule);
        else
            service.call("unsubscribe", pModule).get();
    }

    /**
    * This function allows a local module to send sound onto the nao's loudpseakers
You must pass to this function a pointer to the stereo buffer to send, and the number of frames per channel. The buffer must contain 16bits stereo interleaved samples, and the number of frames does not exceed 16384
    * 
    * @param nbOfFrames  Number of 16 bits samples per channel to send.
    * @param pBuffer  Buffer to send
    * @return True if the operation is successfull - False otherwise
    */
    public Boolean sendLocalBufferToOutput(Integer nbOfFrames, Integer pBuffer) throws CallError, InterruptedException {
        return (Boolean)service.call("sendLocalBufferToOutput", nbOfFrames, pBuffer).get();
    }

    /**
    * This function allows a remote module to send sound onto the nao's loudpseakers
You must pass to this function the stereo buffer you want to send as an ALValue converted to binary, and the number of frames per channel. The number of frames does not exceed 16384. For more information please see the red documentation
    * 
    * @param nbOfFrames  Number of 16 bits samples per channel to send.
    * @param pBuffer  Buffer to send
    * @return True if the operation is successfull - False otherwise
    */
    public Boolean sendRemoteBufferToOutput(Integer nbOfFrames, Object pBuffer) throws CallError, InterruptedException {
        return (Boolean)service.call("sendRemoteBufferToOutput", nbOfFrames, pBuffer).get();
    }

    /**
    * This method allows to send sound samples contained in a sound file at the input of ALAudioDevice, instead of the nao's microphones sound data. The sound file must be a .wav file containing 16bits / 4 channels / interleaved samples. Once the file has been read, microphones sound data will again taken as input
    * 
    * @param pFileName  Name of the input file.
    */
    public void setFileAsInput(String pFileName) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setFileAsInput", pFileName);
        else
            service.call("setFileAsInput", pFileName).get();
    }

    /**
    * This method sets the specified internal parameter ('outputSampleRate' or 'inputBufferSize')
inputBufferSize can bet set to 8192 or 16384. Warning: when speech recognition is running, a buffer size of 8192 is used. Don't change it during the recognition process.
outputSampleRate can bet set to 16000 Hz, 22050 Hz, 44100 Hz or 48000 Hz. Warning: if speech synthesis is running, a sample rate of 16000 Hz or 22050 Hz is used (depending of the language). Don't change it during the synthesis process
    * 
    * @param pParamName  Name of the parameter to set ('outputSampleRate' or 'inputBufferSize').
    * @param pParamValue  The value to which the specified parameter should be set.
    */
    public void setParameter(String pParamName, Integer pParamValue) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setParameter", pParamName, pParamValue);
        else
            service.call("setParameter", pParamName, pParamValue).get();
    }

    /**
    * This method returns the specified internal parameter ('outputSampleRate' or 'inputBufferSize'). The value -1 is returned if the specified parameter is not valid.
    * 
    * @param pParamName  Name of the parameter to get ('outputSampleRate' or 'inputBufferSize').
    * @return value of the specified parameter
    */
    public Integer getParameter(String pParamName) throws CallError, InterruptedException {
        return (Integer)service.call("getParameter", pParamName).get();
    }

    /**
    * This method allows to record the signal collected on the nao's microphones. You can choose to record only the front microphone in a ogg file, or the 4 microphones in a wav file. In this last case the format of the file is 4 channels, 16 bits little endian, 48 KHz
    * 
    * @param pFileName  Name of the file where to record the sound.
    */
    public void startMicrophonesRecording(String pFileName) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("startMicrophonesRecording", pFileName);
        else
            service.call("startMicrophonesRecording", pFileName).get();
    }

    /**
    * This method stops the recording of the sound collected by the microphones.
    * 
    */
    public void stopMicrophonesRecording() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("stopMicrophonesRecording");
        else
            service.call("stopMicrophonesRecording").get();
    }

    /**
    * Sets the output sound level of the system.
    * 
    * @param volume  Volume [0-100].
    */
    public void setOutputVolume(Integer volume) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setOutputVolume", volume);
        else
            service.call("setOutputVolume", volume).get();
    }

    /**
    * Gets the output sound level of the system.
    * 
    * @return outputVolume of the system
    */
    public Integer getOutputVolume() throws CallError, InterruptedException {
        return (Integer)service.call("getOutputVolume").get();
    }

    /**
    * Opens the audio device for capture. If you closed the audio inputs with the closeAudioInputs method, you must call this method to be able to access to the sound data of the nao's microphones. 
    * 
    */
    public void openAudioInputs() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("openAudioInputs");
        else
            service.call("openAudioInputs").get();
    }

    /**
    * Opens the audio device for playback. If you closed the audio outputs with the closeAudioOutputs method, you must call this method to ear or send sound onto the nao's loudspeakers.
    * 
    */
    public void openAudioOutputs() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("openAudioOutputs");
        else
            service.call("openAudioOutputs").get();
    }

    /**
    * Closes the audio device for capture. You can call this method if you want to have access to the alsa input buffers in another program than naoqi while naoqi is running (with arecord for example)
    * 
    */
    public void closeAudioInputs() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("closeAudioInputs");
        else
            service.call("closeAudioInputs").get();
    }

    /**
    * Closes the audio device for playback. close the audio device for capture. You can call this method if you want to send sound to alsa in another program than naoqi while naoqi is running (with aplay for example)
    * 
    */
    public void closeAudioOutputs() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("closeAudioOutputs");
        else
            service.call("closeAudioOutputs").get();
    }

}
    