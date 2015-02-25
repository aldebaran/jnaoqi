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
* This module provides methods to take pictures and store them on disk.
* @see <a href="http://doc.aldebaran.lan/doc/master/aldeb-doc/naoqi/vision/alphotocapture.html#alphotocapture">NAOqi APIs for ALPhotoCapture </a>
*
*/
public class ALPhotoCapture extends ALProxy {

    public ALPhotoCapture(Session session) {
        super(session);
    }

    /**
    * Returns current picture format.
    * 
    * @return Current picture format.
    */
    public String getPictureFormat() throws CallError, InterruptedException {
        return (String)service.call("getPictureFormat").get();
    }

    /**
    * Returns True if the "half press" mode is on.
    * 
    * @return True or False.
    */
    public Boolean isHalfPressed() throws CallError, InterruptedException {
        return (Boolean)service.call("isHalfPressed").get();
    }

    /**
    * Returns True if the "half press" mode is on.
    * 
    * @return True or False.
    */
    public Boolean isHalfPressEnabled() throws CallError, InterruptedException {
        return (Boolean)service.call("isHalfPressEnabled").get();
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
    * Enables or disables the half-press mode.
    * 
    * @param enable  True to enable, false to disable.
    */
    public void setHalfPressEnabled(Boolean enable) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setHalfPressEnabled", enable);
        else
            service.call("setHalfPressEnabled", enable).get();
    }

    /**
    * Manually (un)subscribes to ALVideoDevice.
    * 
    * @return True if eveything went well, False otherwise.
    */
    public Boolean halfPress() throws CallError, InterruptedException {
        return (Boolean)service.call("halfPress").get();
    }

    /**
    * Takes one picture.
    * 
    * @param folderPath  Folder where the picture is saved.
    * @param fileName  Filename used to save the picture.
    * @return Full file name of the picture saved on the disk: [filename]
    */
    public Object takePicture(String folderPath, String fileName) throws CallError, InterruptedException {
        return (Object)service.call("takePicture", folderPath, fileName).get();
    }

    /**
    * Takes one picture.
    * 
    * @param folderPath  Folder where the picture is saved.
    * @param fileName  Filename used to save the picture.
    * @param overwrite  If false and the filename already exists, an error is thrown.
    * @return Full file name of the picture saved on the disk: [filename]
    */
    public Object takePicture(String folderPath, String fileName, Boolean overwrite) throws CallError, InterruptedException {
        return (Object)service.call("takePicture", folderPath, fileName, overwrite).get();
    }

    /**
    * Takes several pictures as quickly as possible
    * 
    * @param numberOfPictures  Number of pictures to take
    * @param folderPath  Folder where the pictures are saved.
    * @param fileName  Filename used to save the pictures.
    * @return List of all saved files: [[filename1, filename2...]]
    */
    public Object takePictures(Integer numberOfPictures, String folderPath, String fileName) throws CallError, InterruptedException {
        return (Object)service.call("takePictures", numberOfPictures, folderPath, fileName).get();
    }

    /**
    * Takes several pictures as quickly as possible
    * 
    * @param numberOfPictures  Number of pictures to take
    * @param folderPath  Folder where the pictures are saved.
    * @param fileName  Filename used to save the pictures.
    * @param overwrite  If false and the filename already exists, an error is thrown.
    * @return List of all saved files: [[filename1, filename2...]]
    */
    public Object takePictures(Integer numberOfPictures, String folderPath, String fileName, Boolean overwrite) throws CallError, InterruptedException {
        return (Object)service.call("takePictures", numberOfPictures, folderPath, fileName, overwrite).get();
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
    * Sets delay between two captures.
    * 
    * @param captureInterval  New delay (in ms) between two pictures.
    */
    public void setCaptureInterval(Integer captureInterval) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setCaptureInterval", captureInterval);
        else
            service.call("setCaptureInterval", captureInterval).get();
    }

    /**
    * Sets picture extension.
    * 
    * @param pictureFormat  New extension used to save pictures.
    */
    public void setPictureFormat(String pictureFormat) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setPictureFormat", pictureFormat);
        else
            service.call("setPictureFormat", pictureFormat).get();
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
    * @return Current frame resolution.
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
    * Returns current delay between captures.
    * 
    * @return Current delay (in ms) between two pictures.
    */
    public Integer getCaptureInterval() throws CallError, InterruptedException {
        return (Integer)service.call("getCaptureInterval").get();
    }

}
    