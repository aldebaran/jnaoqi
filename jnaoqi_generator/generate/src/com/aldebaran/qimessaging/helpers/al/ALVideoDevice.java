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
public class ALVideoDevice extends ALModule {

    public ALVideoDevice(Session session) {
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
        return (String)service.call("subscribeCamera", name, cameraIndex, resolution, colorSpace, fps).get();
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
    public String subscribeCameras(String name, java.lang.Object cameraIndexes, java.lang.Object resolutions, java.lang.Object colorSpaces, Integer fps) throws CallError, InterruptedException {
        return (String)service.call("subscribeCameras", name, cameraIndexes, resolutions, colorSpaces, fps).get();
    }

    /**
    * 
    * 
    * @param nameId  Name under which the vision module is known from ALVideoDevice.
    * @return True if success, false otherwise
    */
    public Boolean unsubscribe(String nameId) throws CallError, InterruptedException {
        return (Boolean)service.call("unsubscribe", nameId).get();
    }

    /**
    * 
    * 
    */
    public java.lang.Object getSubscribers() throws CallError, InterruptedException {
        return (java.lang.Object)service.call("getSubscribers").get();
    }

    /**
    * 
    * 
    */
    public java.lang.Object getCameraIndexes() throws CallError, InterruptedException {
        return (java.lang.Object)service.call("getCameraIndexes").get();
    }

    /**
    * Tells which camera is the default one
    * 
    * @return  0: top camera - 1: bottom camera
    */
    public Integer getActiveCamera() throws CallError, InterruptedException {
        return (Integer)service.call("getActiveCamera").get();
    }

    /**
    * Set the active camera
    * 
    * @param activeCamera   0: top camera - 1: bottom camera
    */
    public Boolean setActiveCamera(Integer activeCamera) throws CallError, InterruptedException {
        return (Boolean)service.call("setActiveCamera", activeCamera).get();
    }

    /**
    * 
    * 
    * @param cameraIndex  Camera requested.
    * @return  1(kOV7670): VGA camera - 2(kMT9M114): HD camera
    */
    public Integer getCameraModel(Integer cameraIndex) throws CallError, InterruptedException {
        return (Integer)service.call("getCameraModel", cameraIndex).get();
    }

    /**
    * 
    * 
    * @param cameraIndex  Camera requested.
    * @return CameraTop - CameraBottom - CameraDepth
    */
    public String getCameraName(Integer cameraIndex) throws CallError, InterruptedException {
        return (String)service.call("getCameraName", cameraIndex).get();
    }

    /**
    * 
    * 
    * @param cameraIndex  Camera requested.
    */
    public Integer getFrameRate(Integer cameraIndex) throws CallError, InterruptedException {
        return (Integer)service.call("getFrameRate", cameraIndex).get();
    }

    /**
    * 
    * 
    * @param cameraIndex  Camera requested.
    */
    public Integer getResolution(Integer cameraIndex) throws CallError, InterruptedException {
        return (Integer)service.call("getResolution", cameraIndex).get();
    }

    /**
    * 
    * 
    * @param cameraIndex  Camera requested.
    */
    public Integer getColorSpace(Integer cameraIndex) throws CallError, InterruptedException {
        return (Integer)service.call("getColorSpace", cameraIndex).get();
    }

    /**
    * 
    * 
    * @param cameraIndex  Camera requested.
    */
    public Float getHorizontalFOV(Integer cameraIndex) throws CallError, InterruptedException {
        return (Float)service.call("getHorizontalFOV", cameraIndex).get();
    }

    /**
    * 
    * 
    * @param cameraIndex  Camera requested.
    */
    public Float getVerticalFOV(Integer cameraIndex) throws CallError, InterruptedException {
        return (Float)service.call("getVerticalFOV", cameraIndex).get();
    }

    /**
    * 
    * 
    * @param cameraIndex  Camera requested.
    * @param parameterId  Camera parameter requested.
    */
    public Integer getParameter(Integer cameraIndex, Integer parameterId) throws CallError, InterruptedException {
        return (Integer)service.call("getParameter", cameraIndex, parameterId).get();
    }

    /**
    * 
    * 
    * @param cameraIndex  Camera requested.
    * @param parameterId  Camera parameter requested.
    */
    public java.lang.Object getParameterRange(Integer cameraIndex, Integer parameterId) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("getParameterRange", cameraIndex, parameterId).get();
    }

    /**
    * 
    * 
    * @param cameraIndex  Camera requested.
    * @param parameterId  Camera parameter requested.
    */
    public java.lang.Object getParameterInfo(Integer cameraIndex, Integer parameterId) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("getParameterInfo", cameraIndex, parameterId).get();
    }

    /**
    * 
    * 
    * @param cameraIndex  Camera requested.
    * @param parameterId  Camera parameter requested.
    * @param value  value requested.
    */
    public Boolean setParameter(Integer cameraIndex, Integer parameterId, Integer value) throws CallError, InterruptedException {
        return (Boolean)service.call("setParameter", cameraIndex, parameterId, value).get();
    }

    /**
    * 
    * 
    * @param cameraIndex  Camera requested.
    * @param parameterId  Camera parameter requested.
    */
    public Boolean setParameterToDefault(Integer cameraIndex, Integer parameterId) throws CallError, InterruptedException {
        return (Boolean)service.call("setParameterToDefault", cameraIndex, parameterId).get();
    }

    /**
    * 
    * 
    * @param cameraIndex  Camera requested.
    */
    public Boolean setAllParametersToDefault(Integer cameraIndex) throws CallError, InterruptedException {
        return (Boolean)service.call("setAllParametersToDefault", cameraIndex).get();
    }

    /**
    * 
    * 
    */
    public Boolean openCamera(Integer param1) throws CallError, InterruptedException {
        return (Boolean)service.call("openCamera", param1).get();
    }

    /**
    * 
    * 
    */
    public Boolean closeCamera(Integer param1) throws CallError, InterruptedException {
        return (Boolean)service.call("closeCamera", param1).get();
    }

    /**
    * 
    * 
    */
    public Boolean isCameraOpen(Integer param1) throws CallError, InterruptedException {
        return (Boolean)service.call("isCameraOpen", param1).get();
    }

    /**
    * 
    * 
    */
    public Boolean startCamera(Integer param1) throws CallError, InterruptedException {
        return (Boolean)service.call("startCamera", param1).get();
    }

    /**
    * 
    * 
    */
    public Boolean stopCamera(Integer param1) throws CallError, InterruptedException {
        return (Boolean)service.call("stopCamera", param1).get();
    }

    /**
    * 
    * 
    */
    public Boolean isCameraStarted(Integer param1) throws CallError, InterruptedException {
        return (Boolean)service.call("isCameraStarted", param1).get();
    }

    /**
    * 
    * 
    */
    public Boolean resetCamera(Integer param1) throws CallError, InterruptedException {
        return (Boolean)service.call("resetCamera", param1).get();
    }

    /**
    * 
    * 
    * @param cameraIndex  Camera requested.
    */
    public Boolean startFrameGrabber(Integer cameraIndex) throws CallError, InterruptedException {
        return (Boolean)service.call("startFrameGrabber", cameraIndex).get();
    }

    /**
    * 
    * 
    * @param cameraIndex  Camera requested.
    */
    public Boolean stopFrameGrabber(Integer cameraIndex) throws CallError, InterruptedException {
        return (Boolean)service.call("stopFrameGrabber", cameraIndex).get();
    }

    /**
    * 
    * 
    * @param cameraIndex  Camera requested.
    */
    public Boolean isFrameGrabberOff(Integer cameraIndex) throws CallError, InterruptedException {
        return (Boolean)service.call("isFrameGrabberOff", cameraIndex).get();
    }

    /**
    * 
    * 
    */
    public Boolean hasDepthCamera() throws CallError, InterruptedException {
        return (Boolean)service.call("hasDepthCamera").get();
    }

    /**
    * 
    * 
    * @param name  Name of the subscribing vision module
    */
    public Integer getFrameRate(String name) throws CallError, InterruptedException {
        return (Integer)service.call("getFrameRate", name).get();
    }

    /**
    * 
    * 
    * @param name  Name of the subscribing vision module
    * @param frameRate  Frame Rate requested.
    */
    public Boolean setFrameRate(String name, Integer frameRate) throws CallError, InterruptedException {
        return (Boolean)service.call("setFrameRate", name, frameRate).get();
    }

    /**
    * 
    * 
    * @param name  Name of the subscribing vision module
    */
    public Integer getActiveCamera(String name) throws CallError, InterruptedException {
        return (Integer)service.call("getActiveCamera", name).get();
    }

    /**
    * 
    * 
    * @param name  Name of the subscribing vision module
    * @param cameraIndex  Camera requested.
    */
    public Boolean setActiveCamera(String name, Integer cameraIndex) throws CallError, InterruptedException {
        return (Boolean)service.call("setActiveCamera", name, cameraIndex).get();
    }

    /**
    * 
    * 
    * @param name  Name of the subscribing vision module
    */
    public Integer getResolution(String name) throws CallError, InterruptedException {
        return (Integer)service.call("getResolution", name).get();
    }

    /**
    * 
    * 
    * @param name  Name of the subscribing vision module
    * @param resolution  Resolution requested.
    */
    public Boolean setResolution(String name, Integer resolution) throws CallError, InterruptedException {
        return (Boolean)service.call("setResolution", name, resolution).get();
    }

    /**
    * 
    * 
    * @param name  Name of the subscribing vision module
    */
    public Integer getColorSpace(String name) throws CallError, InterruptedException {
        return (Integer)service.call("getColorSpace", name).get();
    }

    /**
    * 
    * 
    * @param name  Name of the subscribing vision module
    * @param colorSpace  Color Space requested.
    */
    public Boolean setColorSpace(String name, Integer colorSpace) throws CallError, InterruptedException {
        return (Boolean)service.call("setColorSpace", name, colorSpace).get();
    }

    /**
    * 
    * 
    * @param name  Name of the subscribing vision module
    * @param parameterId  Camera parameter requested.
    */
    public Integer getCameraParameter(String name, Integer parameterId) throws CallError, InterruptedException {
        return (Integer)service.call("getCameraParameter", name, parameterId).get();
    }

    /**
    * 
    * 
    * @param name  Name of the subscribing vision module
    * @param parameterId  Camera parameter requested.
    */
    public java.lang.Object getCameraParameterRange(String name, Integer parameterId) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("getCameraParameterRange", name, parameterId).get();
    }

    /**
    * 
    * 
    * @param name  Name of the subscribing vision module
    * @param parameterId  Camera parameter requested.
    */
    public java.lang.Object getCameraParameterInfo(String name, Integer parameterId) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("getCameraParameterInfo", name, parameterId).get();
    }

    /**
    * 
    * 
    * @param name  Name of the subscribing vision module
    * @param parameterId  Camera parameter requested.
    * @param value  value requested.
    */
    public Boolean setCameraParameter(String name, Integer parameterId, Integer value) throws CallError, InterruptedException {
        return (Boolean)service.call("setCameraParameter", name, parameterId, value).get();
    }

    /**
    * 
    * 
    * @param name  Name of the subscribing vision module
    * @param parameterId  Camera parameter requested.
    */
    public Boolean setCameraParameterToDefault(String name, Integer parameterId) throws CallError, InterruptedException {
        return (Boolean)service.call("setCameraParameterToDefault", name, parameterId).get();
    }

    /**
    * 
    * 
    * @param name  Name of the subscribing vision module
    */
    public Boolean setAllCameraParametersToDefault(String name) throws CallError, InterruptedException {
        return (Boolean)service.call("setAllCameraParametersToDefault", name).get();
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
    public java.lang.Object getDirectRawImageLocal(String name) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("getDirectRawImageLocal", name).get();
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
    public java.lang.Object getDirectRawImageRemote(String name) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("getDirectRawImageRemote", name).get();
    }

    /**
    * Release image buffer locked by getDirectRawImageLocal().

    * 
    * @param name  Name of the subscribing vision module
    * @return true if success
    */
    public Boolean releaseDirectRawImage(String name) throws CallError, InterruptedException {
        return (Boolean)service.call("releaseDirectRawImage", name).get();
    }

    /**
    * Applies transformations to the last image from video source and returns a pointer to a locked ALImage.
When image is not necessary anymore, a call to releaseImage() is requested.

    * 
    * @param name  Name of the subscribing vision module
    * @return Pointer of the locked image buffer, NULL if error.Warning, image pointer is valid only for C++ dynamic library.
    */
    public java.lang.Object getImageLocal(String name) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("getImageLocal", name).get();
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
    public java.lang.Object getImageRemote(String name) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("getImageRemote", name).get();
    }

    /**
    * Release image buffer locked by getImageLocal().
If G.V.M. had no locked image buffer, does nothing.
    * 
    * @param name  Name of the subscribing vision module
    * @return true if success
    */
    public Boolean releaseImage(String name) throws CallError, InterruptedException {
        return (Boolean)service.call("releaseImage", name).get();
    }

    /**
    * 
    * 
    * @param name  Name of the subscribing vision module
    */
    public java.lang.Object getActiveCameras(String name) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("getActiveCameras", name).get();
    }

    /**
    * 
    * 
    * @param name  Name of the subscribing vision module
    * @param cameraIndexes  Cameras requested.
    */
    public java.lang.Object setActiveCameras(String name, java.lang.Object cameraIndexes) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("setActiveCameras", name, cameraIndexes).get();
    }

    /**
    * 
    * 
    * @param name  Name of the subscribing vision module
    */
    public java.lang.Object getResolutions(String name) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("getResolutions", name).get();
    }

    /**
    * 
    * 
    * @param name  Name of the subscribing vision module
    * @param resolutions  Resolutions requested.
    */
    public java.lang.Object setResolutions(String name, java.lang.Object resolutions) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("setResolutions", name, resolutions).get();
    }

    /**
    * 
    * 
    * @param name  Name of the subscribing vision module
    */
    public java.lang.Object getColorSpaces(String name) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("getColorSpaces", name).get();
    }

    /**
    * 
    * 
    * @param name  Name of the subscribing vision module
    * @param colorSpaces  Color Spaces requested.
    */
    public java.lang.Object setColorSpaces(String name, java.lang.Object colorSpaces) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("setColorSpaces", name, colorSpaces).get();
    }

    /**
    * 
    * 
    * @param name  Name of the subscribing vision module
    * @param parameterId  Camera parameter requested.
    */
    public java.lang.Object getCamerasParameter(String name, Integer parameterId) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("getCamerasParameter", name, parameterId).get();
    }

    /**
    * 
    * 
    * @param name  Name of the subscribing vision module
    * @param parameterId  Camera parameter requested.
    * @param values  values requested.
    */
    public java.lang.Object setCamerasParameter(String name, Integer parameterId, java.lang.Object values) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("setCamerasParameter", name, parameterId, values).get();
    }

    /**
    * 
    * 
    * @param name  Name of the subscribing vision module
    * @param parameterId  Camera parameter requested.
    */
    public java.lang.Object setCamerasParameterToDefault(String name, Integer parameterId) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("setCamerasParameterToDefault", name, parameterId).get();
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
    public java.lang.Object getDirectRawImagesLocal(String name) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("getDirectRawImagesLocal", name).get();
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
    public java.lang.Object getDirectRawImagesRemote(String name) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("getDirectRawImagesRemote", name).get();
    }

    /**
    * Release image buffer locked by getDirectRawImagesLocal().

    * 
    * @param name  Name of the subscribing vision module
    * @return true if success
    */
    public java.lang.Object releaseDirectRawImages(String name) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("releaseDirectRawImages", name).get();
    }

    /**
    * Applies transformations to the last image from video source and returns a pointer to a locked ALImage.
When image is not necessary anymore, a call to releaseImage() is requested.

    * 
    * @param name  Name of the subscribing vision module
    * @return Array of pointer of the locked image buffer, NULL if error.Warning, image pointer is valid only for C++ dynamic library.
    */
    public java.lang.Object getImagesLocal(String name) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("getImagesLocal", name).get();
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
    public java.lang.Object getImagesRemote(String name) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("getImagesRemote", name).get();
    }

    /**
    * Release image buffer locked by getImageLocal().
If G.V.M. had no locked image buffer, does nothing.
    * 
    * @param name  Name of the subscribing vision module
    * @return true if success
    */
    public java.lang.Object releaseImages(String name) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("releaseImages", name).get();
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
        return (Boolean)service.call("recordVideo", id, path, totalNumber, period).get();
    }

    /**
    * Stop writing the video sequence
    * 
    * @param id  Name under which the G.V.M. is known from ALVideoDevice.
    * @return true if success
    */
    public Boolean stopVideo(String id) throws CallError, InterruptedException {
        return (Boolean)service.call("stopVideo", id).get();
    }

    /**
    * 
    * 
    */
    public List<Float> getAngularPositionFromImagePosition(Integer param1, List<Float> param2) throws CallError, InterruptedException {
        return (List<Float>)service.call("getAngularPositionFromImagePosition", param1, param2).get();
    }

    /**
    * 
    * 
    */
    public List<Float> getImagePositionFromAngularPosition(Integer param1, List<Float> param2) throws CallError, InterruptedException {
        return (List<Float>)service.call("getImagePositionFromAngularPosition", param1, param2).get();
    }

    /**
    * 
    * 
    */
    public List<Float> getAngularSizeFromImageSize(Integer param1, List<Float> param2) throws CallError, InterruptedException {
        return (List<Float>)service.call("getAngularSizeFromImageSize", param1, param2).get();
    }

    /**
    * 
    * 
    */
    public List<Float> getImageSizeFromAngularSize(Integer param1, List<Float> param2) throws CallError, InterruptedException {
        return (List<Float>)service.call("getImageSizeFromAngularSize", param1, param2).get();
    }

    /**
    * 
    * 
    */
    public List<Float> getImageInfoFromAngularInfo(Integer param1, List<Float> param2) throws CallError, InterruptedException {
        return (List<Float>)service.call("getImageInfoFromAngularInfo", param1, param2).get();
    }

    /**
    * 
    * 
    */
    public List<Float> getImageInfoFromAngularInfoWithResolution(Integer param1, List<Float> param2, Integer param3) throws CallError, InterruptedException {
        return (List<Float>)service.call("getImageInfoFromAngularInfoWithResolution", param1, param2, param3).get();
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
    public Boolean putImage(Integer cameraIndex, Integer width, Integer height, java.lang.Object imageBuffer) throws CallError, InterruptedException {
        return (Boolean)service.call("putImage", cameraIndex, width, height, imageBuffer).get();
    }

    /**
    * called by the simulator to know expected image parameters
    * 
    * @param cameraIndex  Camera requested.
    * @return ALValue of expected parameters, [int resolution, int framerate]
    */
    public java.lang.Object getExpectedImageParameters(Integer cameraIndex) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("getExpectedImageParameters", cameraIndex).get();
    }

    /**
    * Get average environment luminance.
    * 
    * @param cameraIndex  Camera requested.
    * @return The average brightness luminance == (15680-Texposure)*256+AverageLuminance
    */
    public Integer _getExternalBrightness(Integer cameraIndex) throws CallError, InterruptedException {
        return (Integer)service.call("_getExternalBrightness", cameraIndex).get();
    }

    /**
    * Callback when client is disconnected
    * 
    * @param eventName  The echoed event name
    * @param eventContents  The name of the client that has disconnected
    * @param message  The message give when subscribing.
    */
    public void onClientDisconnected(String eventName, java.lang.Object eventContents, String message) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("onClientDisconnected", eventName, eventContents, message);
        else
            service.call("onClientDisconnected", eventName, eventContents, message).get();
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
        return (String)service.call("subscribe", gvmName, resolution, colorSpace, fps).get();
    }

    /**
    * Used to unsubscribe all instances for a given G.V.M. (e.g. VisionModule and VisionModule_5) from ALVideoDevice.
    * 
    * @param id  Root name of the G.V.M. (e.g. with the example above this will be VisionModule).
    */
    public void unsubscribeAllInstances(String id) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("unsubscribeAllInstances", id);
        else
            service.call("unsubscribeAllInstances", id).get();
    }

    /**
    * 
    * 
    */
    public Integer getVIMResolution() throws CallError, InterruptedException {
        return (Integer)service.call("getVIMResolution").get();
    }

    /**
    * 
    * 
    */
    public Integer getVIMColorSpace() throws CallError, InterruptedException {
        return (Integer)service.call("getVIMColorSpace").get();
    }

    /**
    * 
    * 
    */
    public Integer getVIMFrameRate() throws CallError, InterruptedException {
        return (Integer)service.call("getVIMFrameRate").get();
    }

    /**
    * 
    * 
    */
    public Integer getGVMResolution(String param1) throws CallError, InterruptedException {
        return (Integer)service.call("getGVMResolution", param1).get();
    }

    /**
    * 
    * 
    */
    public Integer getGVMColorSpace(String param1) throws CallError, InterruptedException {
        return (Integer)service.call("getGVMColorSpace", param1).get();
    }

    /**
    * 
    * 
    */
    public Integer getGVMFrameRate(String param1) throws CallError, InterruptedException {
        return (Integer)service.call("getGVMFrameRate", param1).get();
    }

    /**
    * 
    * 
    */
    public Integer getCameraModelID() throws CallError, InterruptedException {
        return (Integer)service.call("getCameraModelID").get();
    }

    /**
    * Sets the value of a specific parameter for the video source.
    * 
    * @param pParam  Camera parameter requested.
    * @param pNewValue  value requested.
    */
    public void setParam(Integer pParam, Integer pNewValue) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setParam", pParam, pNewValue);
        else
            service.call("setParam", pParam, pNewValue).get();
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
            service.call("setParam", pParam, pNewValue, pCameraIndex);
        else
            service.call("setParam", pParam, pNewValue, pCameraIndex).get();
    }

    /**
    * 
    * 
    * @param pParam  Camera parameter requested.
    */
    public Integer getParam(Integer pParam) throws CallError, InterruptedException {
        return (Integer)service.call("getParam", pParam).get();
    }

    /**
    * 
    * 
    * @param pParam  Camera parameter requested.
    * @param pCameraIndex  Camera requested.
    */
    public Integer getParam(Integer pParam, Integer pCameraIndex) throws CallError, InterruptedException {
        return (Integer)service.call("getParam", pParam, pCameraIndex).get();
    }

    /**
    * 
    * 
    */
    public void setParamDefault(Integer param1) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setParamDefault", param1);
        else
            service.call("setParamDefault", param1).get();
    }

    /**
    * 
    * 
    */
    public List<Float> getAngPosFromImgPos(List<Float> param1) throws CallError, InterruptedException {
        return (List<Float>)service.call("getAngPosFromImgPos", param1).get();
    }

    /**
    * 
    * 
    */
    public List<Float> getImgPosFromAngPos(List<Float> param1) throws CallError, InterruptedException {
        return (List<Float>)service.call("getImgPosFromAngPos", param1).get();
    }

    /**
    * 
    * 
    */
    public List<Float> getAngSizeFromImgSize(List<Float> param1) throws CallError, InterruptedException {
        return (List<Float>)service.call("getAngSizeFromImgSize", param1).get();
    }

    /**
    * 
    * 
    */
    public List<Float> getImgSizeFromAngSize(List<Float> param1) throws CallError, InterruptedException {
        return (List<Float>)service.call("getImgSizeFromAngSize", param1).get();
    }

    /**
    * 
    * 
    */
    public List<Float> getImgInfoFromAngInfo(List<Float> param1) throws CallError, InterruptedException {
        return (List<Float>)service.call("getImgInfoFromAngInfo", param1).get();
    }

    /**
    * 
    * 
    */
    public List<Float> getImgInfoFromAngInfoWithRes(List<Float> param1, Integer param2) throws CallError, InterruptedException {
        return (List<Float>)service.call("getImgInfoFromAngInfoWithRes", param1, param2).get();
    }

    /**
    * 
    * 
    */
    public java.lang.Object resolutionToSizes(Integer param1) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("resolutionToSizes", param1).get();
    }

    /**
    * 
    * 
    */
    public Integer sizesToResolution(Integer param1, Integer param2) throws CallError, InterruptedException {
        return (Integer)service.call("sizesToResolution", param1, param2).get();
    }

    /**
    * called by the simulator to know expected image parameters
    * 
    * @return ALValue of expected parameters, [int resolution, int framerate]
    */
    public java.lang.Object getExpectedImageParameters() throws CallError, InterruptedException {
        return (java.lang.Object)service.call("getExpectedImageParameters").get();
    }

    /**
    * called by the simulator to know expected image parameters
    * 
    * @param width  int width of image among 1280*960, 640*480, 320*240, 240*160
    * @param height  int height of image among 1280*960, 640*480, 320*240, 240*160
    * @return true if setSize worked
    */
    public Boolean setSimCamInputSize(Integer width, Integer height) throws CallError, InterruptedException {
        return (Boolean)service.call("setSimCamInputSize", width, height).get();
    }

    /**
    * Allow image buffer pushing
    * 
    * @param imageBuffer  Image buffer in bitmap form
    * @return true if the put succeeded
    */
    public Boolean putImage(java.lang.Object imageBuffer) throws CallError, InterruptedException {
        return (Boolean)service.call("putImage", imageBuffer).get();
    }

    /**
    * Advanced method that opens and initialize video source device if it was not before.
Note that the first module subscribing to ALVideoDevice will launch it automatically.
    * 
    * @return true if success
    */
    public Boolean startFrameGrabber() throws CallError, InterruptedException {
        return (Boolean)service.call("startFrameGrabber").get();
    }

    /**
    * Advanced method that close video source device.
Note that the last module unsubscribing to ALVideoDevice will launch it automatically.
    * 
    * @return true if success
    */
    public Boolean stopFrameGrabber() throws CallError, InterruptedException {
        return (Boolean)service.call("stopFrameGrabber").get();
    }

    /**
    * Advanced method that asks if the framegrabber is off.
    * 
    * @return true if off
    */
    public Integer isFrameGrabberOff() throws CallError, InterruptedException {
        return (Integer)service.call("isFrameGrabberOff").get();
    }

    /**
    * 
    * 
    * @param cameraIndex  Camera requested.
    */
    public Float getHorizontalAperture(Integer cameraIndex) throws CallError, InterruptedException {
        return (Float)service.call("getHorizontalAperture", cameraIndex).get();
    }

    /**
    * 
    * 
    * @param cameraIndex  Camera requested.
    */
    public Float getVerticalAperture(Integer cameraIndex) throws CallError, InterruptedException {
        return (Float)service.call("getVerticalAperture", cameraIndex).get();
    }

}
    