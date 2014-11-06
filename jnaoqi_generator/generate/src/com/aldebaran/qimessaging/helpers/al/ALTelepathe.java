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
public class ALTelepathe extends ALModule {

    public ALTelepathe(Session session) {
        super(session);
    }

    /**
    * Connects the robot to the messaging network.
Returns once connected. Throws runtime error otherwise.
    * 
    */
    public void connectNetwork() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("connectNetwork");
        else
            service.call("connectNetwork").get();
    }

    /**
    * Internal callback
    * 
    * @param string  variable
    * @param string  value
    * @param string  message
    */
    public void _onConnectivityChanged(String param1, java.lang.Object param2, String param3) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_onConnectivityChanged", param1, param2, param3);
        else
            service.call("_onConnectivityChanged", param1, param2, param3).get();
    }

    /**
    * enable/disable the printing of some debug information
    * 
    * @param nbOfChannels  Provides the number of channels of the buffer.
    * @param nbOfSamplesByChannel  Provides the number of samples by channel.
    * @param buffer  Provides the audio buffer as an ALValue.
    */
    public void processSoundRemote(Integer nbOfChannels, Integer nbOfSamplesByChannel, java.lang.Object buffer) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("processSoundRemote", nbOfChannels, nbOfSamplesByChannel, buffer);
        else
            service.call("processSoundRemote", nbOfChannels, nbOfSamplesByChannel, buffer).get();
    }

    /**
    * Enable / disable RPC handling for received messages.
    * 
    * @param enabled  Whether to enable RPC
    */
    public void enableRPC(Boolean enabled) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("enableRPC", enabled);
        else
            service.call("enableRPC", enabled).get();
    }

    /**
    * Says whether RPC is enabled or not.
    * 
    * @return Whether RPC is enabled
    */
    public Boolean isRPCEnabled() throws CallError, InterruptedException {
        return (Boolean)service.call("isRPCEnabled").get();
    }

    /**
    * Associates the robot to the given Aldebaran Robotics user.
The associated user is recalled in ALMemory as ALTelepathe/User
    * 
    * @param login  A valid Aldebaran Robotics user name.
    * @param password  The matching password with the user name.
    */
    public void associateUser(String login, String password) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("associateUser", login, password);
        else
            service.call("associateUser", login, password).get();
    }

    /**
    * Performs an Internet Remote Procedure Call.
Returns once call has been received.Throws runtime error otherwise.
    * 
    * @param destination  Target contact id
    * @param module  The target module
    * @param method  The method to call
    * @param args  The method arguments
    * @param timeout  The timeout after which the call should be aborted
    * @return RPC return value
    */
    public java.lang.Object sendRPC(String destination, String module, String method, java.lang.Object args, Integer timeout) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("sendRPC", destination, module, method, args, timeout).get();
    }

    /**
    * Relays ALMemory callbacks to Internet remote peers.
    * 
    * @param key  The ALMemory key that was updated.
    * @param data  The new value stored at the given key.
    * @param message  Message will define the remote method to call (remoteModule.method)
    */
    public void _rpcCallback(String key, java.lang.Object data, String message) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_rpcCallback", key, data, message);
        else
            service.call("_rpcCallback", key, data, message).get();
    }

    /**
    * Starts a media call.Returns once the call is accepted remotely.Throws runtime error if the call can't be established.Timeouts after 30 seconds if call not accepted remotely.
    * 
    * @param contact  The contact id to call.
    * @param audio  Whether audio is enabled for the call.
    * @param video  Whether video is enabled for the call.
    */
    public void startCall(String contact, Boolean audio, Boolean video) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("startCall", contact, audio, video);
        else
            service.call("startCall", contact, audio, video).get();
    }

    /**
    * Stops the current media call.
    * 
    */
    public void stopCall() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("stopCall");
        else
            service.call("stopCall").get();
    }

    /**
    * Says whether a media call is currently established.
    * 
    * @return Whether ALTelepathe is calling or not.
    */
    public Boolean isCalling() throws CallError, InterruptedException {
        return (Boolean)service.call("isCalling").get();
    }

    /**
    * Clears the login and password for accessing Aldebaran Robotics's network.Login can be tracked in the ALMemory key ALTelepathe/User
    * 
    */
    public void dissociateUser() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("dissociateUser");
        else
            service.call("dissociateUser").get();
    }

    /**
    * Stop LAN stream test
    * 
    */
    public void _stopLocalStreaming() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_stopLocalStreaming");
        else
            service.call("_stopLocalStreaming").get();
    }

    /**
    * Disconnects the robot from the messaging network.
Returns once disconnected. Does not throw.
    * 
    */
    public void disconnectNetwork() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("disconnectNetwork");
        else
            service.call("disconnectNetwork").get();
    }

    /**
    * Gets the current connection status.
Value is the same as in the ALMemory key ALTelepathe/Connected
    * 
    * @return Whether ALTelepathe is online or not.
    */
    public Boolean isConnected() throws CallError, InterruptedException {
        return (Boolean)service.call("isConnected").get();
    }

    /**
    * Tells who is associated to the robot, if anyone.
This simply accesses to the ALMemory key ALTelepathe/User
    * 
    * @return the name of the user, empty if none
    */
    public String associatedUser() throws CallError, InterruptedException {
        return (String)service.call("associatedUser").get();
    }

    /**
    * Enables autoconnection to the network, using the saved user login information if present.

    * 
    * @param enabled  Whether to connect automatically at startup.
    */
    public void enableAutoconnection(Boolean enabled) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("enableAutoconnection", enabled);
        else
            service.call("enableAutoconnection", enabled).get();
    }

    /**
    * Says whether autoconnection is enabled or not.
    * 
    * @return Whether autoconnection is enabled
    */
    public Boolean isAutoconnectionEnabled() throws CallError, InterruptedException {
        return (Boolean)service.call("isAutoconnectionEnabled").get();
    }

    /**
    * Sends a text message to the chosen destination.
    * 
    * @param destination  The id of the destination contact.
    * @param message  The message to send to the contact.
    */
    public void sendMessage(String destination, String message) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("sendMessage", destination, message);
        else
            service.call("sendMessage", destination, message).get();
    }

    /**
    * Test LAN stream
    * 
    */
    public void _startLocalStreaming() throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("_startLocalStreaming");
        else
            service.call("_startLocalStreaming").get();
    }

    /**
    * Performs an Internet Remote Procedure Call.
Returns once call has been received.Throws runtime error otherwise.
    * 
    * @param destination  Target contact id
    * @param module  The target module
    * @param method  The method to call
    * @param args  The method arguments
    * @return RPC return value
    */
    public java.lang.Object sendRPC(String destination, String module, String method, java.lang.Object args) throws CallError, InterruptedException {
        return (java.lang.Object)service.call("sendRPC", destination, module, method, args).get();
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
    * enable/disable the printing of some debug information
    * 
    * @param bSetOrUnset  enable the functionnality when true.
    */
    public void setDebugMode(Boolean bSetOrUnset) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("setDebugMode", bSetOrUnset);
        else
            service.call("setDebugMode", bSetOrUnset).get();
    }

    /**
    * enable/disable the printing of some debug information
    * 
    * @param nbOfChannels  Provides the number of channels of the buffer.
    * @param nbOfSamplesByChannel  Provides the number of samples by channel.
    * @param timestamp  Provides the timestamp of the buffer.
    * @param buffer  Provides the audio buffer as an ALValue.
    */
    public void processRemote(Integer nbOfChannels, Integer nbOfSamplesByChannel, java.lang.Object timestamp, java.lang.Object buffer) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("processRemote", nbOfChannels, nbOfSamplesByChannel, timestamp, buffer);
        else
            service.call("processRemote", nbOfChannels, nbOfSamplesByChannel, timestamp, buffer).get();
    }

}
    