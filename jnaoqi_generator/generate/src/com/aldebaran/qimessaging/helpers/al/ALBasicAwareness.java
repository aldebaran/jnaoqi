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
public class ALBasicAwareness extends ALModule {

    public ALBasicAwareness(Session session) {
        super(session);
    }

    /**
    * Set engagement mode.
    * 
    * @return Name of current engagement mode as a string
    */
    public String getEngagementMode() throws CallError, InterruptedException {
        return (String)service.call("getEngagementMode").get();
    }

    /**
    * Set a new contextual moves type.
    * 
    * @param contextualMove  The contextual move, can be 'forward', 'backward', 'sides' and 'random'.
    */
    public void _setContextualMoveType(String contextualMove) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_setContextualMoveType", contextualMove);
        else
            service.call("_setContextualMoveType", contextualMove).get();
    }

    /**
    * Set the specified parameter 
    * 
    * @param paramName  "ServoingSpeed" : Speed of servoing head moves, as fraction of max speed
 "LookStimulusSpeed" : Speed of head moves when looking at a stimulus, as fraction of max speed
 "LookBackSpeed" : Speed of head moves when looking back to previous position, as fraction of max speed
 "LookDownSpeed" : Speed of head moves when looking down to check for children, as fraction of max speed
 "TrackingSpeed" : Tracking speed
 "NobodyFoundTimeOut" : timeout to send HumanLost event when no blob is found, in seconds
 "MinTimeTracking" : Minimum Time for the robot to be focused on someone, without listening to other stimuli, in seconds
 "TimeSleepBeforeResumeMS" : Slept time before automatically resuming BasicAwareness when an automatic pause has been made, in milliseconds
 "TimeOutResetHead" : Timeout to reset the head, in seconds
 "AmplitudeYawTracking" : max absolute value for head yaw in tracking, in degrees
 "PeoplePerceptionPeriod" : Period for people perception, in milliseconds
 "SlowPeoplePerceptionPeriod" : Period for people perception in FullyEngaged mode, in milliseconds
 "HeadThreshold" : Yaw threshold for tracking, in degrees
 "BodyRotationThreshold" : Angular threshold for BodyRotation tracking mode, in degrees
 "BodyRotationThresholdNao" : Angular threshold for BodyRotation tracking mode on Nao, in degrees
 "MoveDistanceX" : X Distance for the Move tracking mode, in meters
 "MoveDistanceY" : Y Distance for the Move tracking mode, in meters
 "MoveAngleTheta" : Angle for the Move tracking mode, in degrees
 "MoveThresholdX" : Threshold for the Move tracking mode, in meters
 "MoveThresholdY" : Threshold for the Move tracking mode, in meters
 "MoveThresholdTheta" : Theta Threshold for the Move tracking mode, in degrees
 "MaxDistanceFullyEngaged" : Maximum distance for someone to be tracked for FullyEngaged mode, in meters
 "MaxDistanceNotFullyEngaged" : Maximum distance for someone to be tracked for modes different from FullyEngaged, in meters
 "MaxHumanSearchTime" : Maximum time to find a human after observing stimulous, in seconds
 "DeltaPitchComfortZone" : Pitch width of the comfort zone, in degree
 "CenterPitchComfortZone" : Pitch center of the confort zone, in degree
 "SoundHeight" : Default Height for sound detection, in meters
 "MoveSpeed" : Speed of the robot moves
 "MC_Interactive_MinTime" : Minimum time between 2 contextual moves (when the robot is tracking somebody)
 "MC_Interactive_MaxOffsetTime" : Maximum time that we can add to MC_Interactive_MinTime (when the robot is tracking somebody)
 "MC_Interactive_DistanceXY" : Maximum offset distance in X and Y that the robot can apply when he tracks somebody
 "MC_Interactive_MinTheta" : Minimum theta that the robot can apply when he tracks somebody
 "MC_Interactive_MaxTheta" : Maximum theta that the robot can apply when he tracks somebody
 "MC_Interactive_DistanceHumanRobot" : Distance between the human and the robot
 "MC_Interactive_MaxDistanceHumanRobot" : Maximum distance human robot to allow the robot to move (in MoveContextually mode)
 
    * @param newVal  "ServoingSpeed" : Float in range [0.01;1]
 "LookStimulusSpeed" : Float in range [0.01;1]
 "LookBackSpeed" : Float in range [0.01;1]
 "LookDownSpeed" : Float in range [0.01;1]
 "TrackingSpeed" : Float in range [0.01;10]
 "NobodyFoundTimeOut" : Float > 0
 "MinTimeTracking" : Float in range [0;20]
 "TimeSleepBeforeResumeMS" : Int > 0
 "TimeOutResetHead" : Float in range [0;30]
 "AmplitudeYawTracking" : Float in range [10;120]
 "PeoplePerceptionPeriod" : Int > 1
 "SlowPeoplePerceptionPeriod" : Int > 1
 "HeadThreshold" : Float in range [0;180]
 "BodyRotationThreshold" : Float in range [-180;180]
 "BodyRotationThresholdNao" : Float in range [-180;180]
 "MoveDistanceX" : Float in range [-5;5]
 "MoveDistanceY" : Float in range [-5;5]
 "MoveAngleTheta" : Float in range [-180;180]
 "MoveThresholdX" : Float in range [0;5]
 "MoveThresholdY" : Float in range [0;5]
 "MoveThresholdTheta" : Float in range [-180;180]
 "MaxDistanceFullyEngaged" : Float in range [0.5;5]
 "MaxDistanceNotFullyEngaged" : Float in range [0.5;5]
 "MaxHumanSearchTime" : Float in range [0.1;10]
 "DeltaPitchComfortZone" : Float in range [0;90]
 "CenterPitchComfortZone" : Float in range [-90;90]
 "SoundHeight" : Float in range [0;2]
 "MoveSpeed" : Float in range [0.1;0.55]
 "MC_Interactive_MinTime" : Int in range [0;100]
 "MC_Interactive_MaxOffsetTime" : Int in range [0;100]
 "MC_Interactive_DistanceXY" : Float in range [0;1]
 "MC_Interactive_MinTheta" : Float in range [-40;0]
 "MC_Interactive_MaxTheta" : Float in range [0;40]
 "MC_Interactive_DistanceHumanRobot" : Float in range [0.1;2]
 "MC_Interactive_MaxDistanceHumanRobot" : Float in range [0.1;3]
 
    */
    public void setParameter(String paramName, java.lang.Object newVal) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setParameter", paramName, newVal);
        else
            service.call("setParameter", paramName, newVal).get();
    }

    /**
    * Pause BasicAwareness.
    * 
    */
    public Boolean _pauseAwareness() throws CallError, InterruptedException {
        return (Boolean)service.call("_pauseAwareness").get();
    }

    /**
    * Resume BasicAwareness.
    * 
    */
    public Boolean _resumeAwareness() throws CallError, InterruptedException {
        return (Boolean)service.call("_resumeAwareness").get();
    }

    /**
    * Get the specified parameter.
    * 
    * @param paramName  "ServoingSpeed" : Speed of servoing head moves, as fraction of max speed
 "LookStimulusSpeed" : Speed of head moves when looking at a stimulus, as fraction of max speed
 "LookBackSpeed" : Speed of head moves when looking back to previous position, as fraction of max speed
 "LookDownSpeed" : Speed of head moves when looking down to check for children, as fraction of max speed
 "TrackingSpeed" : Tracking speed
 "NobodyFoundTimeOut" : timeout to send HumanLost event when no blob is found, in seconds
 "MinTimeTracking" : Minimum Time for the robot to be focused on someone, without listening to other stimuli, in seconds
 "TimeSleepBeforeResumeMS" : Slept time before automatically resuming BasicAwareness when an automatic pause has been made, in milliseconds
 "TimeOutResetHead" : Timeout to reset the head, in seconds
 "AmplitudeYawTracking" : max absolute value for head yaw in tracking, in degrees
 "PeoplePerceptionPeriod" : Period for people perception, in milliseconds
 "SlowPeoplePerceptionPeriod" : Period for people perception in FullyEngaged mode, in milliseconds
 "HeadThreshold" : Yaw threshold for tracking, in degrees
 "BodyRotationThreshold" : Angular threshold for BodyRotation tracking mode, in degrees
 "BodyRotationThresholdNao" : Angular threshold for BodyRotation tracking mode on Nao, in degrees
 "MoveDistanceX" : X Distance for the Move tracking mode, in meters
 "MoveDistanceY" : Y Distance for the Move tracking mode, in meters
 "MoveAngleTheta" : Angle for the Move tracking mode, in degrees
 "MoveThresholdX" : Threshold for the Move tracking mode, in meters
 "MoveThresholdY" : Threshold for the Move tracking mode, in meters
 "MoveThresholdTheta" : Theta Threshold for the Move tracking mode, in degrees
 "MaxDistanceFullyEngaged" : Maximum distance for someone to be tracked for FullyEngaged mode, in meters
 "MaxDistanceNotFullyEngaged" : Maximum distance for someone to be tracked for modes different from FullyEngaged, in meters
 "MaxHumanSearchTime" : Maximum time to find a human after observing stimulous, in seconds
 "DeltaPitchComfortZone" : Pitch width of the comfort zone, in degree
 "CenterPitchComfortZone" : Pitch center of the confort zone, in degree
 "SoundHeight" : Default Height for sound detection, in meters
 "MoveSpeed" : Speed of the robot moves
 "MC_Interactive_MinTime" : Minimum time between 2 contextual moves (when the robot is tracking somebody)
 "MC_Interactive_MaxOffsetTime" : Maximum time that we can add to MC_Interactive_MinTime (when the robot is tracking somebody)
 "MC_Interactive_DistanceXY" : Maximum offset distance in X and Y that the robot can apply when he tracks somebody
 "MC_Interactive_MinTheta" : Minimum theta that the robot can apply when he tracks somebody
 "MC_Interactive_MaxTheta" : Maximum theta that the robot can apply when he tracks somebody
 "MC_Interactive_DistanceHumanRobot" : Distance between the human and the robot
 "MC_Interactive_MaxDistanceHumanRobot" : Maximum distance human robot to allow the robot to move (in MoveContextually mode)
 
    * @return ALValue format for required parameter
    */
    public java.lang.Object getParameter(String paramName) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("getParameter", paramName).get();
    }

    /**
    * Use leds for debug
    * 
    * @param useLeds  Boolean value: true to use leds.
    */
    public void _useLedDebug(Boolean useLeds) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_useLedDebug", useLeds);
        else
            service.call("_useLedDebug", useLeds).get();
    }

    /**
    * Set Led group
    * 
    * @param ledGroupName  Name of the led group.
    */
    public void _setLedGroup(String ledGroupName) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_setLedGroup", ledGroupName);
        else
            service.call("_setLedGroup", ledGroupName).get();
    }

    /**
    * Use debug display in robot view
    * 
    * @param useDisplay  Boolean value: true to use debug display in robot view.
    */
    public void _displayRobotViewDebug(Boolean useDisplay) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_displayRobotViewDebug", useDisplay);
        else
            service.call("_displayRobotViewDebug", useDisplay).get();
    }

    /**
    * Get parameters documentation
    * 
    * @return Parameters info as string
    */
    public String _getParametersInfo() throws CallError, InterruptedException {
        return (String)service.call("_getParametersInfo").get();
    }

    /**
    * Allow the robot to detect stimuli coming from behind and to turnthe base up to 180 degrees to watch them. If it's disabled, thestimuli from behind won't be taken into account.
    * 
    * @param enable  true to enable, false to disable
    */
    public void _setEnableStimuliFromBehind(Boolean enable) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_setEnableStimuliFromBehind", enable);
        else
            service.call("_setEnableStimuliFromBehind", enable).get();
    }

    /**
    * Set engagement mode.
    * 
    * @param modeName  Name of the mode
    */
    public void setEngagementMode(String modeName) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setEngagementMode", modeName);
        else
            service.call("setEngagementMode", modeName).get();
    }

    /**
    * Allow the robot to check downwards for low stimuli if nobody's found.
    * 
    * @param enable  true to enable, false to disable
    */
    public void _setEnableCheckLowStimuli(Boolean enable) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_setEnableCheckLowStimuli", enable);
        else
            service.call("_setEnableCheckLowStimuli", enable).get();
    }

    /**
    * To know if the robot can detect stimuli from behind
    * 
    * @return Boolean value: true if low stimuli are enabled, else false.
    */
    public Boolean _getEnableCheckLowStimuli() throws CallError, InterruptedException {
        return (Boolean)service.call("_getEnableCheckLowStimuli").get();
    }

    /**
    * Get the position of home
    * 
    * @return Pose2D as vector: Pose2D of home.
    */
    public List<Float> _getHomeReferencePosition() throws CallError, InterruptedException {
        return (List<Float>)service.call("_getHomeReferencePosition").get();
    }

    /**
    * 
    * 
    * @param   
    * @param   
    * @param   
    */
    public void _onPreferenceUpdated(String param1, java.lang.Object param2, String param3) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_onPreferenceUpdated", param1, param2, param3);
        else
            service.call("_onPreferenceUpdated", param1, param2, param3).get();
    }

    /**
    * 
    * 
    * @param   
    * @param   
    * @param   
    */
    public void _onPreferenceSynchronized(String param1, java.lang.Object param2, String param3) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_onPreferenceSynchronized", param1, param2, param3);
        else
            service.call("_onPreferenceSynchronized", param1, param2, param3).get();
    }

    /**
    * Set engagement mode.
    * 
    * @param checkStimWhenFocused  when it is tracking someone, true makes the robot check a stimulus to see if it corresponds to a human, false makes it go back to the current track human just after watching in the stim direction (as in SemiEngaged mode)
    * @param stimuliWhenNotTracking  stimuli enabled when the robot is tracking, as a stimuli names list
    * @param stimuliWhenTracking  stimuli enabled when the robot is not tracking, as a stimuli names list
    */
    public void _setCustomEngagementMode(Boolean checkStimWhenFocused, List<String> stimuliWhenNotTracking, List<String> stimuliWhenTracking) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_setCustomEngagementMode", checkStimWhenFocused, stimuliWhenNotTracking, stimuliWhenTracking);
        else
            service.call("_setCustomEngagementMode", checkStimWhenFocused, stimuliWhenNotTracking, stimuliWhenTracking).get();
    }

    /**
    * Set tracking mode.
    * 
    * @param modeName  Name of the mode
    */
    public void setTrackingMode(String modeName) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setTrackingMode", modeName);
        else
            service.call("setTrackingMode", modeName).get();
    }

    /**
    * Reset all parameters, including enabled/disabled stimulus.
    * 
    */
    public void resetAllParameters() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("resetAllParameters");
        else
            service.call("resetAllParameters").get();
    }

    /**
    * Set tracking mode.
    * 
    * @return Name of current tracking mode as a string
    */
    public String getTrackingMode() throws CallError, InterruptedException {
        return (String)service.call("getTrackingMode").get();
    }

    /**
    * Force Engage Person.
    * 
    * @param engagePerson  ID of the person as found in PeoplePerception.
    * @return true if the robot succeeded to engage the person, else false.
    */
    public Boolean engagePerson(Integer engagePerson) throws CallError, InterruptedException {
        return (Boolean)service.call("engagePerson", engagePerson).get();
    }

    /**
    * Trigger a custom stimulus.
    * 
    * @param stimulusPosition  Position of the stimulus, in Frame World
    * @return If someone was found, return value is its ID, else it's -1
    */
    public Integer triggerStimulus(List<Float> stimulusPosition) throws CallError, InterruptedException {
        return (Integer)service.call("triggerStimulus", stimulusPosition).get();
    }

    /**
    * To know if the robot can detect stimuli from behind
    * 
    * @return Boolean value: true if stimuli from behind are enabled, else false.
    */
    public Boolean _getEnableStimuliFromBehind() throws CallError, InterruptedException {
        return (Boolean)service.call("_getEnableStimuliFromBehind").get();
    }

    /**
    * Get the pause status of the module.
    * 
    */
    public Boolean _isAwarenessPaused() throws CallError, InterruptedException {
        return (Boolean)service.call("_isAwarenessPaused").get();
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
    * Population Updated (event: PeoplePerception/PopulationUpdated)
    * 
    * @param name  Name of the event
    * @param populationUpdated  Boolean value for people detection event
    * @param message  Event message
    */
    public void _onPeopleDetected(String name, java.lang.Object populationUpdated, String message) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_onPeopleDetected", name, populationUpdated, message);
        else
            service.call("_onPeopleDetected", name, populationUpdated, message).get();
    }

    /**
    * Movement Detected (event: MovementDetection3D/MovementDetected)
    * 
    * @param name  Name of the event
    * @param movementDetected  Boolean value for movement event
    * @param message  Event message
    */
    public void _onMovementDetected(String name, java.lang.Object movementDetected, String message) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_onMovementDetected", name, movementDetected, message);
        else
            service.call("_onMovementDetected", name, movementDetected, message).get();
    }

    /**
    * Sound Detected (event: SoundLocated)
    * 
    * @param name  Name of the event
    * @param SoundLocated  Boolean value for movement event
    * @param message  Event message
    */
    public void _onSoundDetected(String name, java.lang.Object SoundLocated, String message) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_onSoundDetected", name, SoundLocated, message);
        else
            service.call("_onSoundDetected", name, SoundLocated, message).get();
    }

    /**
    * Touch Detected (event: TouchDetection3D/TouchDetected)
    * 
    * @param name  Name of the event
    * @param touchDetected  Boolean value for touch event
    * @param message  Event message
    */
    public void _onTouchDetected(String name, java.lang.Object touchDetected, String message) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_onTouchDetected", name, touchDetected, message);
        else
            service.call("_onTouchDetected", name, touchDetected, message).get();
    }

    /**
    * Servoing event callback (event:ALTracker/FastPersonTracking)
    * 
    * @param name  Name of the event
    * @param tackerValue  Position to track.
    * @param message  Event message
    */
    public void _onFastPersonTracking(String name, java.lang.Object tackerValue, String message) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_onFastPersonTracking", name, tackerValue, message);
        else
            service.call("_onFastPersonTracking", name, tackerValue, message).get();
    }

    /**
    * No person found by fast tracking callback (event:ALFastPersonTracking/TrackedPersonNotFound)
    * 
    * @param name  Name of the event
    * @param val  Content of the event.
    * @param message  Event message
    */
    public void _onNoFastPersonFound(String name, java.lang.Object val, String message) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_onNoFastPersonFound", name, val, message);
        else
            service.call("_onNoFastPersonFound", name, val, message).get();
    }

    /**
    * Servoing event callback (event:ALTracker/FindPersonHead)
    * 
    * @param name  Name of the event
    * @param tackerValue  Position to track.
    * @param message  Event message
    */
    public void _onHeadTracking(String name, java.lang.Object tackerValue, String message) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_onHeadTracking", name, tackerValue, message);
        else
            service.call("_onHeadTracking", name, tackerValue, message).get();
    }

    /**
    * HeadNotFound event callback (event:ALFindPersonHead/HeadNotFound)
    * 
    * @param name  Name of the event
    * @param val  Content of the event.
    * @param message  Event message
    */
    public void _onHeadNotFound(String name, java.lang.Object val, String message) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_onHeadNotFound", name, val, message);
        else
            service.call("_onHeadNotFound", name, val, message).get();
    }

    /**
    * HeadReached event callback (event:ALFindPersonHead/HeadReached)
    * 
    * @param name  Name of the event
    * @param val  Content of the event.
    * @param message  Event message
    */
    public void _onHeadReached(String name, java.lang.Object val, String message) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_onHeadReached", name, val, message);
        else
            service.call("_onHeadReached", name, val, message).get();
    }

    /**
    * tracking interruption
    * 
    * @param name  Name of the event
    * @param val  Content of the event.
    * @param message  Event message
    */
    public void _onHeadTrackingStopped(String name, java.lang.Object val, String message) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_onHeadTrackingStopped", name, val, message);
        else
            service.call("_onHeadTrackingStopped", name, val, message).get();
    }

    /**
    * Start Basic Awareness.
    * 
    */
    public void startAwareness() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("startAwareness");
        else
            service.call("startAwareness").get();
    }

    /**
    * Stop Basic Awareness.
    * 
    */
    public void stopAwareness() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("stopAwareness");
        else
            service.call("stopAwareness").get();
    }

    /**
    * Get the status (started or not) of the module.
    * 
    * @return Boolean value, true if running else false
    */
    public Boolean isAwarenessRunning() throws CallError, InterruptedException {
        return (Boolean)service.call("isAwarenessRunning").get();
    }

    /**
    * Enable/Disable Stimulus Detection.
    * 
    * @param stimulusName  Name of the stimulus to enable/disable
    * @param isStimulusDetectionEnabled  Boolean value: true to enable, false to disable.
    */
    public void setStimulusDetectionEnabled(String stimulusName, Boolean isStimulusDetectionEnabled) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setStimulusDetectionEnabled", stimulusName, isStimulusDetectionEnabled);
        else
            service.call("setStimulusDetectionEnabled", stimulusName, isStimulusDetectionEnabled).get();
    }

    /**
    * Get status enabled/disabled for Stimulus Detection.
    * 
    * @param stimulusName  Name of the stimulus to check
    * @return Boolean value for status enabled/disabled
    */
    public Boolean isStimulusDetectionEnabled(String stimulusName) throws CallError, InterruptedException {
        return (Boolean)service.call("isStimulusDetectionEnabled", stimulusName).get();
    }

}
    