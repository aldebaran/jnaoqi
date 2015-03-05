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
* This module provides methods to record videos and store them on disk.
* @see <a href="http://doc.aldebaran.lan/doc/release-2.1/aldeb-doc/naoqi/vision/alvideorecorder.html#alvideorecorder">NAOqi APIs for ALVideoRecorder </a>
*
*/
public class ALVideoRecorder extends ALProxy {

    public ALVideoRecorder(Session session) {
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
    * Starts recording a video. Please note that only one record at a time can be made.
    * 
    * @param folderPath  Folder where the video is saved.
    * @param fileName  Filename used to save the video.
    */
    public void startRecording(String folderPath, String fileName) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("startRecording", folderPath, fileName);
        else
            service.call("startRecording", folderPath, fileName).get();
    }

    /**
    * Starts recording a video. Please note that only one record at a time can be made.
    * 
    * @param folderPath  Folder where the video is saved.
    * @param fileName  Filename used to save the video.
    * @param overwrite  If false and the filename already exists, an exception is thrown.
    */
    public void startRecording(String folderPath, String fileName, Boolean overwrite) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("startRecording", folderPath, fileName, overwrite);
        else
            service.call("startRecording", folderPath, fileName, overwrite).get();
    }

    /**
    * Stops a video record that was launched with startRecording(). The function returns the number of frames that were recorded, as well as the video absolute file name.
    * 
    * @return Array of two elements [numRecordedFrames, recordAbsolutePath]
    */
    public Object stopRecording() throws CallError, InterruptedException {
        return (Object)service.call("stopRecording").get();
    }

    /**
    * Are we currently recording a video
    * 
    * @return True/False
    */
    public Boolean isRecording() throws CallError, InterruptedException {
        return (Boolean)service.call("isRecording").get();
    }

    /**
    * Sets camera ID.
    * 
    * @param cameraID  ID of the camera to use.
    */
    public void setCameraID(Integer cameraID) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setCameraID", cameraID);
        else
            service.call("setCameraID", cameraID).get();
    }

    /**
    * Sets resolution.
    * 
    * @param resolution  New frame resolution.
    */
    public void setResolution(Integer resolution) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setResolution", resolution);
        else
            service.call("setResolution", resolution).get();
    }

    /**
    * Sets color space.
    * 
    * @param colorSpace  New color space.
    */
    public void setColorSpace(Integer colorSpace) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setColorSpace", colorSpace);
        else
            service.call("setColorSpace", colorSpace).get();
    }

    /**
    * Sets frame rate.
    * 
    * @param frameRate  New frame rate.
    */
    public void setFrameRate(Float frameRate) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setFrameRate", frameRate);
        else
            service.call("setFrameRate", frameRate).get();
    }

    /**
    * Sets video format.
    * 
    * @param videoFormat  New video format.
    */
    public void setVideoFormat(String videoFormat) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setVideoFormat", videoFormat);
        else
            service.call("setVideoFormat", videoFormat).get();
    }

    /**
    * Returns current camera ID.
    * 
    * @return Current camera ID.
    */
    public Integer getCameraID() throws CallError, InterruptedException {
        return (Integer)service.call("getCameraID").get();
    }

    /**
    * Returns current resolution.
    * 
    * @return Current resolution.
    */
    public Integer getResolution() throws CallError, InterruptedException {
        return (Integer)service.call("getResolution").get();
    }

    /**
    * Returns current color space.
    * 
    * @return Current color space.
    */
    public Integer getColorSpace() throws CallError, InterruptedException {
        return (Integer)service.call("getColorSpace").get();
    }

    /**
    * Returns current frame rate.
    * 
    * @return Current frame rate.
    */
    public Integer getFrameRate() throws CallError, InterruptedException {
        return (Integer)service.call("getFrameRate").get();
    }

    /**
    * Returns current video format.
    * 
    * @return Current video format.
    */
    public String getVideoFormat() throws CallError, InterruptedException {
        return (String)service.call("getVideoFormat").get();
    }

}
    