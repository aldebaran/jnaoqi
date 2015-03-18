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
/**
* ALVideoDevice, formerly called Video Input systemis architectured in order to provide every module related to vision, called vision module, a direct access to raw images from video source, or an access to images transformed in the requested format.
  Extension name of the methods providing images depends on wether modules are local (dynamic library) or remote (executable).
* @see <a href="http://doc.aldebaran.lan/doc/release-2.1/aldeb-doc/naoqi/vision/alvideodevice.html#alvideodevice">NAOqi APIs for ALVideoDevice </a>
*
*/
public class ALVideoDevice extends ALProxy {

    public ALVideoDevice(Session session) throws Exception{
        super(session);
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
        if (isAsynchronous)
            call("clearStats");
        else
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
        if (isAsynchronous)
            call("exit");
        else
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
        if (isAsynchronous)
            call("stop", id);
        else
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
    * 
    * 
    * @param name  Name of the subscribing vision module
    * @param cameraIndex  Camera requested.
    * @param resolution  Resolution requested.{0=kQQVGA, 1=kQVGA, 2=kVGA, 3=k4VGA}
    * @param colorSpace  Colorspace requested.{0=kYuv, 9=kYUV422, 10=kYUV, 11=kRGB, 12=kHSY, 13=kBGR}
    * @param fps  Fps (frames per second) requested.{5, 10, 15, 30}
    * @return Name under which the vision module is known from ALVideoDevice
    */
    public String subscribeCamera(String name, Integer cameraIndex, Integer resolution, Integer colorSpace, Integer fps) throws CallError, InterruptedException {
        return (String)call("subscribeCamera", name, cameraIndex, resolution, colorSpace, fps).get();
    }

    /**
    * 
    * 
    * @param name  Name of the subscribing vision module
    * @param cameraIndexes  Cameras requested.
    * @param resolutions  Resolutions requested.{0=kQQVGA, 1=kQVGA, 2=kVGA, 3=k4VGA}
    * @param colorSpaces  Colorspaces requested.{0=kYuv, 9=kYUV422, 10=kYUV, 11=kRGB, 12=kHSY, 13=kBGR}
    * @param fps  Fps (frames per second) requested.{5, 10, 15, 30}
    * @return Name under which the vision module is known from ALVideoDevice
    */
    public String subscribeCameras(String name, Object cameraIndexes, Object resolutions, Object colorSpaces, Integer fps) throws CallError, InterruptedException {
        return (String)call("subscribeCameras", name, cameraIndexes, resolutions, colorSpaces, fps).get();
    }

    /**
    * 
    * 
    * @param nameId  Name under which the vision module is known from ALVideoDevice.
    * @return True if success, false otherwise
    */
    public Boolean unsubscribe(String nameId) throws CallError, InterruptedException {
        return (Boolean)call("unsubscribe", nameId).get();
    }

    /**
    * 
    * 
    */
    public Object getSubscribers() throws CallError, InterruptedException {
        return (Object)call("getSubscribers").get();
    }

    /**
    * 
    * 
    */
    public Object getCameraIndexes() throws CallError, InterruptedException {
        return (Object)call("getCameraIndexes").get();
    }

    /**
    * Tells which camera is the default one
    * 
    * @return  0: top camera - 1: bottom camera
    */
    public Integer getActiveCamera() throws CallError, InterruptedException {
        return (Integer)call("getActiveCamera").get();
    }

    /**
    * Set the active camera
    * 
    * @param activeCamera   0: top camera - 1: bottom camera
    */
    public Boolean setActiveCamera(Integer activeCamera) throws CallError, InterruptedException {
        return (Boolean)call("setActiveCamera", activeCamera).get();
    }

    /**
    * 
    * 
    * @param cameraIndex  Camera requested.
    * @return  1(kOV7670): VGA camera - 2(kMT9M114): HD camera
    */
    public Integer getCameraModel(Integer cameraIndex) throws CallError, InterruptedException {
        return (Integer)call("getCameraModel", cameraIndex).get();
    }

    /**
    * 
    * 
    * @param cameraIndex  Camera requested.
    * @return CameraTop - CameraBottom - CameraDepth
    */
    public String getCameraName(Integer cameraIndex) throws CallError, InterruptedException {
        return (String)call("getCameraName", cameraIndex).get();
    }

    /**
    * 
    * 
    * @param cameraIndex  Camera requested.
    */
    public Integer getFrameRate(Integer cameraIndex) throws CallError, InterruptedException {
        return (Integer)call("getFrameRate", cameraIndex).get();
    }

    /**
    * 
    * 
    * @param cameraIndex  Camera requested.
    */
    public Integer getResolution(Integer cameraIndex) throws CallError, InterruptedException {
        return (Integer)call("getResolution", cameraIndex).get();
    }

    /**
    * 
    * 
    * @param cameraIndex  Camera requested.
    */
    public Integer getColorSpace(Integer cameraIndex) throws CallError, InterruptedException {
        return (Integer)call("getColorSpace", cameraIndex).get();
    }

    /**
    * 
    * 
    * @param cameraIndex  Camera requested.
    */
    public Float getHorizontalFOV(Integer cameraIndex) throws CallError, InterruptedException {
        return (Float)call("getHorizontalFOV", cameraIndex).get();
    }

    /**
    * 
    * 
    * @param cameraIndex  Camera requested.
    */
    public Float getVerticalFOV(Integer cameraIndex) throws CallError, InterruptedException {
        return (Float)call("getVerticalFOV", cameraIndex).get();
    }

    /**
    * 
    * 
    * @param cameraIndex  Camera requested.
    * @param parameterId  Camera parameter requested.
    */
    public Integer getParameter(Integer cameraIndex, Integer parameterId) throws CallError, InterruptedException {
        return (Integer)call("getParameter", cameraIndex, parameterId).get();
    }

    /**
    * 
    * 
    * @param cameraIndex  Camera requested.
    * @param parameterId  Camera parameter requested.
    */
    public Object getParameterRange(Integer cameraIndex, Integer parameterId) throws CallError, InterruptedException {
        return (Object)call("getParameterRange", cameraIndex, parameterId).get();
    }

    /**
    * 
    * 
    * @param cameraIndex  Camera requested.
    * @param parameterId  Camera parameter requested.
    */
    public Object getParameterInfo(Integer cameraIndex, Integer parameterId) throws CallError, InterruptedException {
        return (Object)call("getParameterInfo", cameraIndex, parameterId).get();
    }

    /**
    * 
    * 
    * @param cameraIndex  Camera requested.
    * @param parameterId  Camera parameter requested.
    * @param value  value requested.
    */
    public Boolean setParameter(Integer cameraIndex, Integer parameterId, Integer value) throws CallError, InterruptedException {
        return (Boolean)call("setParameter", cameraIndex, parameterId, value).get();
    }

    /**
    * 
    * 
    * @param cameraIndex  Camera requested.
    * @param parameterId  Camera parameter requested.
    */
    public Boolean setParameterToDefault(Integer cameraIndex, Integer parameterId) throws CallError, InterruptedException {
        return (Boolean)call("setParameterToDefault", cameraIndex, parameterId).get();
    }

    /**
    * 
    * 
    * @param cameraIndex  Camera requested.
    */
    public Boolean setAllParametersToDefault(Integer cameraIndex) throws CallError, InterruptedException {
        return (Boolean)call("setAllParametersToDefault", cameraIndex).get();
    }

    /**
    * 
    * 
    */
    public Boolean openCamera(Integer param1) throws CallError, InterruptedException {
        return (Boolean)call("openCamera", param1).get();
    }

    /**
    * 
    * 
    */
    public Boolean closeCamera(Integer param1) throws CallError, InterruptedException {
        return (Boolean)call("closeCamera", param1).get();
    }

    /**
    * 
    * 
    */
    public Boolean isCameraOpen(Integer param1) throws CallError, InterruptedException {
        return (Boolean)call("isCameraOpen", param1).get();
    }

    /**
    * 
    * 
    */
    public Boolean startCamera(Integer param1) throws CallError, InterruptedException {
        return (Boolean)call("startCamera", param1).get();
    }

    /**
    * 
    * 
    */
    public Boolean stopCamera(Integer param1) throws CallError, InterruptedException {
        return (Boolean)call("stopCamera", param1).get();
    }

    /**
    * 
    * 
    */
    public Boolean isCameraStarted(Integer param1) throws CallError, InterruptedException {
        return (Boolean)call("isCameraStarted", param1).get();
    }

    /**
    * 
    * 
    */
    public Boolean resetCamera(Integer param1) throws CallError, InterruptedException {
        return (Boolean)call("resetCamera", param1).get();
    }

    /**
    * 
    * 
    * @param cameraIndex  Camera requested.
    */
    public Boolean startFrameGrabber(Integer cameraIndex) throws CallError, InterruptedException {
        return (Boolean)call("startFrameGrabber", cameraIndex).get();
    }

    /**
    * 
    * 
    * @param cameraIndex  Camera requested.
    */
    public Boolean stopFrameGrabber(Integer cameraIndex) throws CallError, InterruptedException {
        return (Boolean)call("stopFrameGrabber", cameraIndex).get();
    }

    /**
    * 
    * 
    * @param cameraIndex  Camera requested.
    */
    public Boolean isFrameGrabberOff(Integer cameraIndex) throws CallError, InterruptedException {
        return (Boolean)call("isFrameGrabberOff", cameraIndex).get();
    }

    /**
    * 
    * 
    */
    public Boolean hasDepthCamera() throws CallError, InterruptedException {
        return (Boolean)call("hasDepthCamera").get();
    }

    /**
    * 
    * 
    * @param name  Name of the subscribing vision module
    */
    public Integer getFrameRate(String name) throws CallError, InterruptedException {
        return (Integer)call("getFrameRate", name).get();
    }

    /**
    * 
    * 
    * @param name  Name of the subscribing vision module
    * @param frameRate  Frame Rate requested.
    */
    public Boolean setFrameRate(String name, Integer frameRate) throws CallError, InterruptedException {
        return (Boolean)call("setFrameRate", name, frameRate).get();
    }

    /**
    * 
    * 
    * @param name  Name of the subscribing vision module
    */
    public Integer getActiveCamera(String name) throws CallError, InterruptedException {
        return (Integer)call("getActiveCamera", name).get();
    }

    /**
    * 
    * 
    * @param name  Name of the subscribing vision module
    * @param cameraIndex  Camera requested.
    */
    public Boolean setActiveCamera(String name, Integer cameraIndex) throws CallError, InterruptedException {
        return (Boolean)call("setActiveCamera", name, cameraIndex).get();
    }

    /**
    * 
    * 
    * @param name  Name of the subscribing vision module
    */
    public Integer getResolution(String name) throws CallError, InterruptedException {
        return (Integer)call("getResolution", name).get();
    }

    /**
    * 
    * 
    * @param name  Name of the subscribing vision module
    * @param resolution  Resolution requested.
    */
    public Boolean setResolution(String name, Integer resolution) throws CallError, InterruptedException {
        return (Boolean)call("setResolution", name, resolution).get();
    }

    /**
    * 
    * 
    * @param name  Name of the subscribing vision module
    */
    public Integer getColorSpace(String name) throws CallError, InterruptedException {
        return (Integer)call("getColorSpace", name).get();
    }

    /**
    * 
    * 
    * @param name  Name of the subscribing vision module
    * @param colorSpace  Color Space requested.
    */
    public Boolean setColorSpace(String name, Integer colorSpace) throws CallError, InterruptedException {
        return (Boolean)call("setColorSpace", name, colorSpace).get();
    }

    /**
    * 
    * 
    * @param name  Name of the subscribing vision module
    * @param parameterId  Camera parameter requested.
    */
    public Integer getCameraParameter(String name, Integer parameterId) throws CallError, InterruptedException {
        return (Integer)call("getCameraParameter", name, parameterId).get();
    }

    /**
    * 
    * 
    * @param name  Name of the subscribing vision module
    * @param parameterId  Camera parameter requested.
    */
    public Object getCameraParameterRange(String name, Integer parameterId) throws CallError, InterruptedException {
        return (Object)call("getCameraParameterRange", name, parameterId).get();
    }

    /**
    * 
    * 
    * @param name  Name of the subscribing vision module
    * @param parameterId  Camera parameter requested.
    */
    public Object getCameraParameterInfo(String name, Integer parameterId) throws CallError, InterruptedException {
        return (Object)call("getCameraParameterInfo", name, parameterId).get();
    }

    /**
    * 
    * 
    * @param name  Name of the subscribing vision module
    * @param parameterId  Camera parameter requested.
    * @param value  value requested.
    */
    public Boolean setCameraParameter(String name, Integer parameterId, Integer value) throws CallError, InterruptedException {
        return (Boolean)call("setCameraParameter", name, parameterId, value).get();
    }

    /**
    * 
    * 
    * @param name  Name of the subscribing vision module
    * @param parameterId  Camera parameter requested.
    */
    public Boolean setCameraParameterToDefault(String name, Integer parameterId) throws CallError, InterruptedException {
        return (Boolean)call("setCameraParameterToDefault", name, parameterId).get();
    }

    /**
    * 
    * 
    * @param name  Name of the subscribing vision module
    */
    public Boolean setAllCameraParametersToDefault(String name) throws CallError, InterruptedException {
        return (Boolean)call("setAllCameraParametersToDefault", name).get();
    }

    /**
    * Retrieves the latest image from the video source and returns a pointer to the locked ALImage, with data array pointing directly to raw data. There is no format conversion and no copy of the raw buffer.
Warning: When image is not necessary anymore, a call to releaseDirectRawImage() is requested.
Warning: When using this mode for several vision module, if they need raw data for more than 25ms check that you have strictly less modules in this mode than the amount of kernel buffers!!
Warning: Release all kernel buffers before any action requesting a modification in camera running mode (e.g. resolution, switch between cameras).
    * 
    * @param name  Name of the subscribing vision module
    * @return Pointer to the locked image buffer, NULL if error.
Warning, image pointer is valid only for C++ dynamic library.
    */
    public Object getDirectRawImageLocal(String name) throws CallError, InterruptedException {
        return (Object)call("getDirectRawImageLocal", name).get();
    }

    /**
    * Fills an ALValue with data coming directly from raw buffer (no format conversion).

    * 
    * @param name  Name of the subscribing vision module
    * @return Array containing image informations : 
    [0] : width;
    [1] : height;
    [2] : number of layers;
    [3] : ColorSpace;
    [4] : time stamp (highest 32 bits);
    [5] : time stamp (lowest 32 bits);
    [6] : array of size height * width * nblayers containing image data;
    [7] : cameraID;
    [8] : left angle;
    [9] : top angle;
    [10] : right angle;
    [11] : bottom angle;

    */
    public Object getDirectRawImageRemote(String name) throws CallError, InterruptedException {
        return (Object)call("getDirectRawImageRemote", name).get();
    }

    /**
    * Release image buffer locked by getDirectRawImageLocal().

    * 
    * @param name  Name of the subscribing vision module
    * @return true if success
    */
    public Boolean releaseDirectRawImage(String name) throws CallError, InterruptedException {
        return (Boolean)call("releaseDirectRawImage", name).get();
    }

    /**
    * Applies transformations to the last image from video source and returns a pointer to a locked ALImage.
When image is not necessary anymore, a call to releaseImage() is requested.

    * 
    * @param name  Name of the subscribing vision module
    * @return Pointer of the locked image buffer, NULL if error.Warning, image pointer is valid only for C++ dynamic library.
    */
    public Object getImageLocal(String name) throws CallError, InterruptedException {
        return (Object)call("getImageLocal", name).get();
    }

    /**
    * Applies transformations to the last image from video source and fills pFrameOut.

    * 
    * @param name  Name of the subscribing vision module
    * @return Array containing image informations : 
    [0] : width;
    [1] : height;
    [2] : number of layers;
    [3] : ColorSpace;
    [4] : time stamp (highest 32 bits);
    [5] : time stamp (lowest 32 bits);
    [6] : array of size height * width * nblayers containing image data;
    [7] : cameraID;
    [8] : left angle;
    [9] : top angle;
    [10] : right angle;
    [11] : bottom angle;

    */
    public Object getImageRemote(String name) throws CallError, InterruptedException {
        return (Object)call("getImageRemote", name).get();
    }

    /**
    * Release image buffer locked by getImageLocal().
If G.V.M. had no locked image buffer, does nothing.
    * 
    * @param name  Name of the subscribing vision module
    * @return true if success
    */
    public Boolean releaseImage(String name) throws CallError, InterruptedException {
        return (Boolean)call("releaseImage", name).get();
    }

    /**
    * 
    * 
    * @param name  Name of the subscribing vision module
    */
    public Object getActiveCameras(String name) throws CallError, InterruptedException {
        return (Object)call("getActiveCameras", name).get();
    }

    /**
    * 
    * 
    * @param name  Name of the subscribing vision module
    * @param cameraIndexes  Cameras requested.
    */
    public Object setActiveCameras(String name, Object cameraIndexes) throws CallError, InterruptedException {
        return (Object)call("setActiveCameras", name, cameraIndexes).get();
    }

    /**
    * 
    * 
    * @param name  Name of the subscribing vision module
    */
    public Object getResolutions(String name) throws CallError, InterruptedException {
        return (Object)call("getResolutions", name).get();
    }

    /**
    * 
    * 
    * @param name  Name of the subscribing vision module
    * @param resolutions  Resolutions requested.
    */
    public Object setResolutions(String name, Object resolutions) throws CallError, InterruptedException {
        return (Object)call("setResolutions", name, resolutions).get();
    }

    /**
    * 
    * 
    * @param name  Name of the subscribing vision module
    */
    public Object getColorSpaces(String name) throws CallError, InterruptedException {
        return (Object)call("getColorSpaces", name).get();
    }

    /**
    * 
    * 
    * @param name  Name of the subscribing vision module
    * @param colorSpaces  Color Spaces requested.
    */
    public Object setColorSpaces(String name, Object colorSpaces) throws CallError, InterruptedException {
        return (Object)call("setColorSpaces", name, colorSpaces).get();
    }

    /**
    * 
    * 
    * @param name  Name of the subscribing vision module
    * @param parameterId  Camera parameter requested.
    */
    public Object getCamerasParameter(String name, Integer parameterId) throws CallError, InterruptedException {
        return (Object)call("getCamerasParameter", name, parameterId).get();
    }

    /**
    * 
    * 
    * @param name  Name of the subscribing vision module
    * @param parameterId  Camera parameter requested.
    * @param values  values requested.
    */
    public Object setCamerasParameter(String name, Integer parameterId, Object values) throws CallError, InterruptedException {
        return (Object)call("setCamerasParameter", name, parameterId, values).get();
    }

    /**
    * 
    * 
    * @param name  Name of the subscribing vision module
    * @param parameterId  Camera parameter requested.
    */
    public Object setCamerasParameterToDefault(String name, Integer parameterId) throws CallError, InterruptedException {
        return (Object)call("setCamerasParameterToDefault", name, parameterId).get();
    }

    /**
    * Retrieves the latest image from the video source and returns a pointer to the locked ALImage, with data array pointing directly to raw data. There is no format conversion and no copy of the raw buffer.
Warning: When image is not necessary anymore, a call to releaseDirectRawImage() is requested.
Warning: When using this mode for several vision module, if they need raw data for more than 25ms check that you have strictly less modules in this mode than the amount of kernel buffers!!
Warning: Release all kernel buffers before any action requesting a modification in camera running mode (e.g. resolution, switch between cameras).
    * 
    * @param name  Name of the subscribing vision module
    * @return Array of pointer to the locked image buffer, NULL if error.
Warning, image pointer is valid only for C++ dynamic library.
    */
    public Object getDirectRawImagesLocal(String name) throws CallError, InterruptedException {
        return (Object)call("getDirectRawImagesLocal", name).get();
    }

    /**
    * Fills an ALValue with data coming directly from raw buffer (no format conversion).

    * 
    * @param name  Name of the subscribing vision module
    * @return Array containing image informations : 
    [0] : width;
    [1] : height;
    [2] : number of layers;
    [3] : ColorSpace;
    [4] : time stamp (highest 32 bits);
    [5] : time stamp (lowest 32 bits);
    [6] : array of size height * width * nblayers containing image data;
    [7] : cameraID;
    [8] : left angle;
    [9] : top angle;
    [10] : right angle;
    [11] : bottom angle;

    */
    public Object getDirectRawImagesRemote(String name) throws CallError, InterruptedException {
        return (Object)call("getDirectRawImagesRemote", name).get();
    }

    /**
    * Release image buffer locked by getDirectRawImagesLocal().

    * 
    * @param name  Name of the subscribing vision module
    * @return true if success
    */
    public Object releaseDirectRawImages(String name) throws CallError, InterruptedException {
        return (Object)call("releaseDirectRawImages", name).get();
    }

    /**
    * Applies transformations to the last image from video source and returns a pointer to a locked ALImage.
When image is not necessary anymore, a call to releaseImage() is requested.

    * 
    * @param name  Name of the subscribing vision module
    * @return Array of pointer of the locked image buffer, NULL if error.Warning, image pointer is valid only for C++ dynamic library.
    */
    public Object getImagesLocal(String name) throws CallError, InterruptedException {
        return (Object)call("getImagesLocal", name).get();
    }

    /**
    * Applies transformations to the last image from video source and fills pFrameOut.

    * 
    * @param name  Name of the subscribing vision module
    * @return Array containing image informations : 
    [0] : width;
    [1] : height;
    [2] : number of layers;
    [3] : ColorSpace;
    [4] : time stamp (highest 32 bits);
    [5] : time stamp (lowest 32 bits);
    [6] : array of size height * width * nblayers containing image data;
    [7] : cameraID;
    [8] : left angle;
    [9] : top angle;
    [10] : right angle;
    [11] : bottom angle;

    */
    public Object getImagesRemote(String name) throws CallError, InterruptedException {
        return (Object)call("getImagesRemote", name).get();
    }

    /**
    * Release image buffer locked by getImageLocal().
If G.V.M. had no locked image buffer, does nothing.
    * 
    * @param name  Name of the subscribing vision module
    * @return true if success
    */
    public Object releaseImages(String name) throws CallError, InterruptedException {
        return (Object)call("releaseImages", name).get();
    }

    /**
    * Background record of an .arv raw format video from the images processed by a vision module
Actualy it take picture each time the vision module call getDirectRawImageRemote().
    * 
    * @param id  Name under which the G.V.M. is known from the V.I.M.
    * @param path  path/name of the video to be recorded
    * @param totalNumber  number of images to be recorded. 0xFFFFFFFF for "unlimited"
    * @param period  one image recorded every pPeriod images
    * @return true if success
    */
    public Boolean recordVideo(String id, String path, Integer totalNumber, Integer period) throws CallError, InterruptedException {
        return (Boolean)call("recordVideo", id, path, totalNumber, period).get();
    }

    /**
    * Stop writing the video sequence
    * 
    * @param id  Name under which the G.V.M. is known from ALVideoDevice.
    * @return true if success
    */
    public Boolean stopVideo(String id) throws CallError, InterruptedException {
        return (Boolean)call("stopVideo", id).get();
    }

    /**
    * 
    * 
    */
    public List<Float> getAngularPositionFromImagePosition(Integer param1, List<Float> param2) throws CallError, InterruptedException {
        return (List<Float>)call("getAngularPositionFromImagePosition", param1, param2).get();
    }

    /**
    * 
    * 
    */
    public List<Float> getImagePositionFromAngularPosition(Integer param1, List<Float> param2) throws CallError, InterruptedException {
        return (List<Float>)call("getImagePositionFromAngularPosition", param1, param2).get();
    }

    /**
    * 
    * 
    */
    public List<Float> getAngularSizeFromImageSize(Integer param1, List<Float> param2) throws CallError, InterruptedException {
        return (List<Float>)call("getAngularSizeFromImageSize", param1, param2).get();
    }

    /**
    * 
    * 
    */
    public List<Float> getImageSizeFromAngularSize(Integer param1, List<Float> param2) throws CallError, InterruptedException {
        return (List<Float>)call("getImageSizeFromAngularSize", param1, param2).get();
    }

    /**
    * 
    * 
    */
    public List<Float> getImageInfoFromAngularInfo(Integer param1, List<Float> param2) throws CallError, InterruptedException {
        return (List<Float>)call("getImageInfoFromAngularInfo", param1, param2).get();
    }

    /**
    * 
    * 
    */
    public List<Float> getImageInfoFromAngularInfoWithResolution(Integer param1, List<Float> param2, Integer param3) throws CallError, InterruptedException {
        return (List<Float>)call("getImageInfoFromAngularInfoWithResolution", param1, param2, param3).get();
    }

    /**
    * Allow image buffer pushing
    * 
    * @param cameraIndex  Camera requested.
    * @param width  int width of image among 1280*960, 640*480, 320*240, 240*160
    * @param height  int height of image
    * @param imageBuffer  Image buffer in bitmap form
    * @return true if the put succeeded
    */
    public Boolean putImage(Integer cameraIndex, Integer width, Integer height, Object imageBuffer) throws CallError, InterruptedException {
        return (Boolean)call("putImage", cameraIndex, width, height, imageBuffer).get();
    }

    /**
    * called by the simulator to know expected image parameters
    * 
    * @param cameraIndex  Camera requested.
    * @return ALValue of expected parameters, [int resolution, int framerate]
    */
    public Object getExpectedImageParameters(Integer cameraIndex) throws CallError, InterruptedException {
        return (Object)call("getExpectedImageParameters", cameraIndex).get();
    }

    /**
    * Callback when client is disconnected
    * 
    * @param eventName  The echoed event name
    * @param eventContents  The name of the client that has disconnected
    * @param message  The message give when subscribing.
    */
    public void onClientDisconnected(String eventName, Object eventContents, String message) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("onClientDisconnected", eventName, eventContents, message);
        else
            call("onClientDisconnected", eventName, eventContents, message).get();
    }

    /**
    * Register to ALVideoDevice (formerly Video Input Module/V.I.M.). When a General Video Module(G.V.M.) registers to ALVideoDevice, a buffer of the requested image format is added to the buffers list.
Returns the name under which the G.V.M. is registered to ALVideoDevice (useful when two G.V.M. try to register using the same name
    * 
    * @param gvmName  Name of the subscribing G.V.M.
    * @param resolution  Resolution requested. { 0 = kQQVGA, 1 = kQVGA, 2 = kVGA } 
    * @param colorSpace  Colorspace requested. { 0 = kYuv, 9 = kYUV422, 10 = kYUV, 11 = kRGB, 12 = kHSY, 13 = kBGR } 
    * @param fps  Fps (frames per second) requested. { 5, 10, 15, 30 } 
    * @return Name under which the G.V.M. is known from ALVideoDevice, 0 if failed.
    */
    public String subscribe(String gvmName, Integer resolution, Integer colorSpace, Integer fps) throws CallError, InterruptedException {
        return (String)call("subscribe", gvmName, resolution, colorSpace, fps).get();
    }

    /**
    * Used to unsubscribe all instances for a given G.V.M. (e.g. VisionModule and VisionModule_5) from ALVideoDevice.
    * 
    * @param id  Root name of the G.V.M. (e.g. with the example above this will be VisionModule).
    */
    public void unsubscribeAllInstances(String id) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("unsubscribeAllInstances", id);
        else
            call("unsubscribeAllInstances", id).get();
    }

    /**
    * 
    * 
    */
    public Integer getVIMResolution() throws CallError, InterruptedException {
        return (Integer)call("getVIMResolution").get();
    }

    /**
    * 
    * 
    */
    public Integer getVIMColorSpace() throws CallError, InterruptedException {
        return (Integer)call("getVIMColorSpace").get();
    }

    /**
    * 
    * 
    */
    public Integer getVIMFrameRate() throws CallError, InterruptedException {
        return (Integer)call("getVIMFrameRate").get();
    }

    /**
    * 
    * 
    */
    public Integer getGVMResolution(String param1) throws CallError, InterruptedException {
        return (Integer)call("getGVMResolution", param1).get();
    }

    /**
    * 
    * 
    */
    public Integer getGVMColorSpace(String param1) throws CallError, InterruptedException {
        return (Integer)call("getGVMColorSpace", param1).get();
    }

    /**
    * 
    * 
    */
    public Integer getGVMFrameRate(String param1) throws CallError, InterruptedException {
        return (Integer)call("getGVMFrameRate", param1).get();
    }

    /**
    * 
    * 
    */
    public Integer getCameraModelID() throws CallError, InterruptedException {
        return (Integer)call("getCameraModelID").get();
    }

    /**
    * Sets the value of a specific parameter for the video source.
    * 
    * @param pParam  Camera parameter requested.
    * @param pNewValue  value requested.
    */
    public void setParam(Integer pParam, Integer pNewValue) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("setParam", pParam, pNewValue);
        else
            call("setParam", pParam, pNewValue).get();
    }

    /**
    * Sets the value of a specific parameter for the video source.
    * 
    * @param pParam  Camera parameter requested.
    * @param pNewValue  value requested.
    * @param pCameraIndex  Camera requested.
    */
    public void setParam(Integer pParam, Integer pNewValue, Integer pCameraIndex) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("setParam", pParam, pNewValue, pCameraIndex);
        else
            call("setParam", pParam, pNewValue, pCameraIndex).get();
    }

    /**
    * 
    * 
    * @param pParam  Camera parameter requested.
    */
    public Integer getParam(Integer pParam) throws CallError, InterruptedException {
        return (Integer)call("getParam", pParam).get();
    }

    /**
    * 
    * 
    * @param pParam  Camera parameter requested.
    * @param pCameraIndex  Camera requested.
    */
    public Integer getParam(Integer pParam, Integer pCameraIndex) throws CallError, InterruptedException {
        return (Integer)call("getParam", pParam, pCameraIndex).get();
    }

    /**
    * 
    * 
    */
    public void setParamDefault(Integer param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("setParamDefault", param1);
        else
            call("setParamDefault", param1).get();
    }

    /**
    * 
    * 
    */
    public List<Float> getAngPosFromImgPos(List<Float> param1) throws CallError, InterruptedException {
        return (List<Float>)call("getAngPosFromImgPos", param1).get();
    }

    /**
    * 
    * 
    */
    public List<Float> getImgPosFromAngPos(List<Float> param1) throws CallError, InterruptedException {
        return (List<Float>)call("getImgPosFromAngPos", param1).get();
    }

    /**
    * 
    * 
    */
    public List<Float> getAngSizeFromImgSize(List<Float> param1) throws CallError, InterruptedException {
        return (List<Float>)call("getAngSizeFromImgSize", param1).get();
    }

    /**
    * 
    * 
    */
    public List<Float> getImgSizeFromAngSize(List<Float> param1) throws CallError, InterruptedException {
        return (List<Float>)call("getImgSizeFromAngSize", param1).get();
    }

    /**
    * 
    * 
    */
    public List<Float> getImgInfoFromAngInfo(List<Float> param1) throws CallError, InterruptedException {
        return (List<Float>)call("getImgInfoFromAngInfo", param1).get();
    }

    /**
    * 
    * 
    */
    public List<Float> getImgInfoFromAngInfoWithRes(List<Float> param1, Integer param2) throws CallError, InterruptedException {
        return (List<Float>)call("getImgInfoFromAngInfoWithRes", param1, param2).get();
    }

    /**
    * 
    * 
    */
    public Object resolutionToSizes(Integer param1) throws CallError, InterruptedException {
        return (Object)call("resolutionToSizes", param1).get();
    }

    /**
    * 
    * 
    */
    public Integer sizesToResolution(Integer param1, Integer param2) throws CallError, InterruptedException {
        return (Integer)call("sizesToResolution", param1, param2).get();
    }

    /**
    * called by the simulator to know expected image parameters
    * 
    * @return ALValue of expected parameters, [int resolution, int framerate]
    */
    public Object getExpectedImageParameters() throws CallError, InterruptedException {
        return (Object)call("getExpectedImageParameters").get();
    }

    /**
    * called by the simulator to know expected image parameters
    * 
    * @param width  int width of image among 1280*960, 640*480, 320*240, 240*160
    * @param height  int height of image among 1280*960, 640*480, 320*240, 240*160
    * @return true if setSize worked
    */
    public Boolean setSimCamInputSize(Integer width, Integer height) throws CallError, InterruptedException {
        return (Boolean)call("setSimCamInputSize", width, height).get();
    }

    /**
    * Allow image buffer pushing
    * 
    * @param imageBuffer  Image buffer in bitmap form
    * @return true if the put succeeded
    */
    public Boolean putImage(Object imageBuffer) throws CallError, InterruptedException {
        return (Boolean)call("putImage", imageBuffer).get();
    }

    /**
    * Advanced method that opens and initialize video source device if it was not before.
Note that the first module subscribing to ALVideoDevice will launch it automatically.
    * 
    * @return true if success
    */
    public Boolean startFrameGrabber() throws CallError, InterruptedException {
        return (Boolean)call("startFrameGrabber").get();
    }

    /**
    * Advanced method that close video source device.
Note that the last module unsubscribing to ALVideoDevice will launch it automatically.
    * 
    * @return true if success
    */
    public Boolean stopFrameGrabber() throws CallError, InterruptedException {
        return (Boolean)call("stopFrameGrabber").get();
    }

    /**
    * Advanced method that asks if the framegrabber is off.
    * 
    * @return true if off
    */
    public Integer isFrameGrabberOff() throws CallError, InterruptedException {
        return (Integer)call("isFrameGrabberOff").get();
    }

    /**
    * 
    * 
    * @param cameraIndex  Camera requested.
    */
    public Float getHorizontalAperture(Integer cameraIndex) throws CallError, InterruptedException {
        return (Float)call("getHorizontalAperture", cameraIndex).get();
    }

    /**
    * 
    * 
    * @param cameraIndex  Camera requested.
    */
    public Float getVerticalAperture(Integer cameraIndex) throws CallError, InterruptedException {
        return (Float)call("getVerticalAperture", cameraIndex).get();
    }

}
    