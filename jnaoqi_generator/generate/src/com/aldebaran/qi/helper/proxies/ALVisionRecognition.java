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
* ALVisionRecognition is a module which detects and recognizes learned pictures, like pages of a comic books, faces of objects or even locations.
The learning stage is done using the Choregraphe interface. Follow the steps in the green doc that will explain how to create your own database.
The output value is written in ALMemory in the PictureDetected variable.
It contains an array of tags, with the following format: 
 
[ [ TimeStampField ] [ Picture_info_0 , Picture _info_1, . . . , Picture_info_N-1 ] ] 
 
with as many Picture_info tags as things currently recognized. 
Picture_info = [[labels_list], matched_keypoints, ratio, [boundary_points]] 
with labels_list = [label_0, label_1, ..., label_N-1] and label_n belongs to label_n+1 
and boundary_points = [[x0,y0], [x1,y1], ..., [xN,yN]] 
 
- Labels are the names given to the picture (e.g. "cover/my book", or "fridge corner/kitchen/my flat"). 
- matched_keypoints corresponds to the number of keypoints retrieved in the current frame. 
- ratio represents the number of keypoints found for the object in the current frame divided by the number of keypoints found during the learning stage. 
- boundary_points is a list of points coordinates in angle values representing the reprojection in the current image of the boundaries selected during the learning stage. 

* @see <a href="http://doc.aldebaran.lan/doc/release-2.1/aldeb-doc/naoqi/vision/alvisionrecognition.html#alvisionrecognition">NAOqi APIs for ALVisionRecognition </a>
*
*/
public class ALVisionRecognition extends ALProxy {

    public ALVisionRecognition(Session session) {
        super(session);
    }

    /**
    * Gets extractor resolution
    * 
    * @return Current value of the resolution of the extractor
    */
    public Integer getResolution() throws CallError, InterruptedException {
        return (Integer)call("getResolution").get();
    }

    /**
    * Sets extractor resolution
    * 
    * @param resolution  New resolution
    * @return True if the update succeeded, False if not
    */
    public Boolean setResolution(Integer resolution) throws CallError, InterruptedException {
        return (Boolean)call("setResolution", resolution).get();
    }

    /**
    * Clear the current database, the user has to be warned before calling this function.
    * 
    */
    public void clearCurrentDatabase() throws CallError, InterruptedException{
        if (isAsynchronous)
            call("clearCurrentDatabase");
        else
            call("clearCurrentDatabase").get();
    }

    /**
    * Set vision recognition parameters (deprecated in 1.22)
    * 
    * @param paramName  Name of the parameter to be changed. Only "resolution" can be used.
    * @param paramValue  Value of the resolution as an integer: 0(QQVGA) 1(QVGA) 2(VGA)
    */
    public void setParam(String paramName, Object paramValue) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("setParam", paramName, paramValue);
        else
            call("setParam", paramName, paramValue).get();
    }

    /**
    * DEPRECATED: Sets pause and resolution
    * 
    * @param paramName  Name of the parameter to set
    * @param value  New value
    */
    public void setParameter(String paramName, Object value) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("setParameter", paramName, value);
        else
            call("setParameter", paramName, value).get();
    }

    /**
    * Load an image and interpret it as an object.
    * 
    * @param filename  The filename of the image that will be interpreted as a planar object.
    * @param name  The name of the object (used as a unique identifier).
    * @param tags  A list of tags (as strings) containing any met-data about your object.
    * @param isWholeImage  indicates if the object occupies the whole image. If set to false, visionrecognition will try to detect the border of the object automatically. This works with unicolor background where object stands out well from the background. By default, this is set to true.
    * @param forced  indicates if learned object will replace existing object (having the same original name) if any.
    * @return True if the operation succeded, false otherwise.
    */
    public Boolean learnFromFile(String filename, String name, List<String> tags, Boolean isWholeImage, Boolean forced) throws CallError, InterruptedException {
        return (Boolean)call("learnFromFile", filename, name, tags, isWholeImage, forced).get();
    }

    /**
    * Set the maximal number (not more than 10) of detected objects for each detection. By default, this is set to 1.
    * 
    * @param iMaxOutObjs  number of desired objects to be detected.
    */
    public void setMaxOutObjs(Integer iMaxOutObjs) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("setMaxOutObjs", iMaxOutObjs);
        else
            call("setMaxOutObjs", iMaxOutObjs).get();
    }

    /**
    * Get the maximal number of detected objects for each detection.
    * 
    * @return number of maximal objects to be detected.
    */
    public Integer getMaxOutObjs() throws CallError, InterruptedException {
        return (Integer)call("getMaxOutObjs").get();
    }

    /**
    * Get number of objects in the current database.
    * 
    * @return number of objects in the current database.
    */
    public Integer getSize() throws CallError, InterruptedException {
        return (Integer)call("getSize").get();
    }

    /**
    * Gets extractor framerate
    * 
    * @return Current value of the framerate of the extractor
    */
    public Integer getFrameRate() throws CallError, InterruptedException {
        return (Integer)call("getFrameRate").get();
    }

    /**
    * Gets extractor active camera
    * 
    * @return Id of the current active camera of the extractor
    */
    public Integer getActiveCamera() throws CallError, InterruptedException {
        return (Integer)call("getActiveCamera").get();
    }

    /**
    * Gets extractor pause status
    * 
    * @return True if the extractor is paused, False if not
    */
    public Boolean isPaused() throws CallError, InterruptedException {
        return (Boolean)call("isPaused").get();
    }

    /**
    * Sets extractor active camera
    * 
    * @param cameraId  Id of the camera that will become the active camera
    * @return True if the update succeeded, False if not
    */
    public Boolean setActiveCamera(Integer cameraId) throws CallError, InterruptedException {
        return (Boolean)call("setActiveCamera", cameraId).get();
    }

    /**
    * Gets extractor running status
    * 
    * @return True if the extractor is currently processing images, False if not
    */
    public Boolean isProcessing() throws CallError, InterruptedException {
        return (Boolean)call("isProcessing").get();
    }

    /**
    * Changes the pause status of the extractor
    * 
    * @param paused  New pause satus
    */
    public void pause(Boolean paused) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("pause", paused);
        else
            call("pause", paused).get();
    }

    /**
    * By default the database has the name "current" and is on the robot in /home/nao/naoqi/share/naoqi/vision/visionrecognition/ folder. This bound method allows to choose both another name and another folder for the database. 

    * 
    * @param databasePath  Absolute path of the database on the robot, or "" to set default path.
    * @param databaseName  Name of the database folder, or "" to set default database folder.
    * @return True if the operation succeded, false otherwise.
    */
    public Boolean changeDatabase(String databasePath, String databaseName) throws CallError, InterruptedException {
        return (Boolean)call("changeDatabase", databasePath, databaseName).get();
    }

    /**
    * Load an image and search for known objects.
    * 
    * @param image  The image that will be searched for known objects.
    */
    public void detectFromFile(String image) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("detectFromFile", image);
        else
            call("detectFromFile", image).get();
    }

    /**
    * Get some vision recognition parameters.
    * 
    * @param paramName  The name of the parameter to get. "db_path" and "db_name" can be used.
    * @return Value of the parameter as a string for "db_path" and "db_name"
    */
    public Object getParam(String paramName) throws CallError, InterruptedException {
        return (Object)call("getParam", paramName).get();
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
    * Subscribes to the extractor. This causes the extractor to start writing information to memory using the keys described by getOutputNames(). These can be accessed in memory using ALMemory.getData("keyName"). In many cases you can avoid calling subscribe on the extractor by just calling ALMemory.subscribeToEvent() supplying a callback method. This will automatically subscribe to the extractor for you.
    * 
    * @param name  Name of the module which subscribes.
    * @param period  Refresh period (in milliseconds) if relevant.
    * @param precision  Precision of the extractor if relevant.
    */
    public void subscribe(String name, Integer period, Float precision) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("subscribe", name, period, precision);
        else
            call("subscribe", name, period, precision).get();
    }

    /**
    * Subscribes to the extractor. This causes the extractor to start writing information to memory using the keys described by getOutputNames(). These can be accessed in memory using ALMemory.getData("keyName"). In many cases you can avoid calling subscribe on the extractor by just calling ALMemory.subscribeToEvent() supplying a callback method. This will automatically subscribe to the extractor for you.
    * 
    * @param name  Name of the module which subscribes.
    */
    public void subscribe(String name) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("subscribe", name);
        else
            call("subscribe", name).get();
    }

    /**
    * Unsubscribes from the extractor.
    * 
    * @param name  Name of the module which had subscribed.
    */
    public void unsubscribe(String name) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("unsubscribe", name);
        else
            call("unsubscribe", name).get();
    }

    /**
    * Updates the period if relevant.
    * 
    * @param name  Name of the module which has subscribed.
    * @param period  Refresh period (in milliseconds).
    */
    public void updatePeriod(String name, Integer period) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("updatePeriod", name, period);
        else
            call("updatePeriod", name, period).get();
    }

    /**
    * Updates the precision if relevant.
    * 
    * @param name  Name of the module which has subscribed.
    * @param precision  Precision of the extractor.
    */
    public void updatePrecision(String name, Float precision) throws CallError, InterruptedException{
        if (isAsynchronous)
            call("updatePrecision", name, precision);
        else
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
    * Sets the extractor framerate for a chosen subscriber
    * 
    * @param subscriberName  Name of the subcriber
    * @param framerate  New framerate
    * @return True if the update succeeded, False if not
    */
    public Boolean setFrameRate(String subscriberName, Integer framerate) throws CallError, InterruptedException {
        return (Boolean)call("setFrameRate", subscriberName, framerate).get();
    }

    /**
    * Sets the extractor framerate for all the subscribers
    * 
    * @param framerate  New framerate
    * @return True if the update succeeded, False if not
    */
    public Boolean setFrameRate(Integer framerate) throws CallError, InterruptedException {
        return (Boolean)call("setFrameRate", framerate).get();
    }

}
    