/**
 * Copyright (c) 2015 Aldebaran Robotics. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be
 * found in the COPYING file.
 * Created by epinault and tcruz
 */
package com.aldebaran.qi.helper.proxies;

import com.aldebaran.qi.CallError;
import com.aldebaran.qi.Future;
import com.aldebaran.qi.Session;
import com.aldebaran.qi.helper.ALProxy;

import java.util.List;
/**
* 
* @see <a href="http://doc.aldebaran.lan/doc/master/aldeb-doc/naoqi/core/altabletservice.html#altabletservice">NAOqi APIs for ALTabletService </a>
* NAOqi V2.4.x
*/
public class ALTabletService extends ALProxy {

    private AsyncALTabletService asyncProxy;

    public ALTabletService(Session session) throws Exception{
        super(session);
        asyncProxy = new AsyncALTabletService();
	    asyncProxy.setService(getService());
    }

    /**
     * Get the async version of this proxy
     *
	 * @return a AsyncALTabletService object
	 */
    public AsyncALTabletService async() {
        return asyncProxy;
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
    * Show Webview (with app-specific content)
    * 
    */
    public Boolean showWebview() throws CallError, InterruptedException {
        return (Boolean)call("showWebview").get();
    }

    /**
    * Show Webview and load the url
    * 
    */
    public Boolean showWebview(String param1) throws CallError, InterruptedException {
        return (Boolean)call("showWebview", param1).get();
    }

    /**
    * Load URL on tablet
    * 
    */
    public Boolean loadUrl(String param1) throws CallError, InterruptedException {
        return (Boolean)call("loadUrl", param1).get();
    }

    /**
    * Reload current displayed web page
    * 
    */
    public void reloadPage(Boolean param1) throws CallError, InterruptedException{
        call("reloadPage", param1).get();
    }

    /**
    * Start application on tablet
    * 
    */
    public Boolean loadApplication(String param1) throws CallError, InterruptedException {
        return (Boolean)call("loadApplication", param1).get();
    }

    /**
    * Hide Webview 
    * 
    */
    public Boolean hideWebview() throws CallError, InterruptedException {
        return (Boolean)call("hideWebview").get();
    }

    /**
    * Clean Webview 
    * 
    */
    public void cleanWebview() throws CallError, InterruptedException{
        call("cleanWebview").get();
    }

    /**
    * Execute javascript 
    * 
    */
    public void executeJS(String param1) throws CallError, InterruptedException{
        call("executeJS", param1).get();
    }

    /**
    * Change the onTouch webview scale factor. Default is 1.34 so the viewport is 1707 x 1067
    * 
    */
    public void setOnTouchWebviewScaleFactor(Float param1) throws CallError, InterruptedException{
        call("setOnTouchWebviewScaleFactor", param1).get();
    }

    /**
    * get the onTouch scale factor for current view, by default 1.34 for the webview and 1 for the other views
    * 
    */
    public Float getOnTouchScaleFactor() throws CallError, InterruptedException {
        return (Float)call("getOnTouchScaleFactor").get();
    }

    /**
    * Play video on tablet
    * 
    */
    public Boolean playVideo(String param1) throws CallError, InterruptedException {
        return (Boolean)call("playVideo", param1).get();
    }

    /**
    * Resume video on tablet
    * 
    */
    public Boolean resumeVideo() throws CallError, InterruptedException {
        return (Boolean)call("resumeVideo").get();
    }

    /**
    * Pause video activity on tablet
    * 
    */
    public Boolean pauseVideo() throws CallError, InterruptedException {
        return (Boolean)call("pauseVideo").get();
    }

    /**
    * Stop video activity on tablet
    * 
    */
    public Boolean stopVideo() throws CallError, InterruptedException {
        return (Boolean)call("stopVideo").get();
    }

    /**
    * Get video position (in ms from beginning)
    * 
    */
    public Integer getVideoPosition() throws CallError, InterruptedException {
        return (Integer)call("getVideoPosition").get();
    }

    /**
    * Get video length (in ms)
    * 
    */
    public Integer getVideoLength() throws CallError, InterruptedException {
        return (Integer)call("getVideoLength").get();
    }

    /**
    * preload an image
    * 
    */
    public Boolean preLoadImage(String param1) throws CallError, InterruptedException {
        return (Boolean)call("preLoadImage", param1).get();
    }

    /**
    * show an image
    * 
    */
    public Boolean showImage(String param1) throws CallError, InterruptedException {
        return (Boolean)call("showImage", param1).get();
    }

    /**
    * show an image, disable tablet cache
    * 
    */
    public Boolean showImageNoCache(String param1) throws CallError, InterruptedException {
        return (Boolean)call("showImageNoCache", param1).get();
    }

    /**
    * Hide an image
    * 
    */
    public void hideImage() throws CallError, InterruptedException{
        call("hideImage").get();
    }

    /**
    * resume the gif
    * 
    */
    public void resumeGif() throws CallError, InterruptedException{
        call("resumeGif").get();
    }

    /**
    * pause the gif
    * 
    */
    public void pauseGif() throws CallError, InterruptedException{
        call("pauseGif").get();
    }

    /**
    * Set the background color for image
    * 
    */
    public Boolean setBackgroundColor(String param1) throws CallError, InterruptedException {
        return (Boolean)call("setBackgroundColor", param1).get();
    }

    /**
    * hide the top view
    * 
    */
    public void hide() throws CallError, InterruptedException{
        call("hide").get();
    }

    /**
    * Change screen brightness
    * 
    */
    public Boolean setBrightness(Float param1) throws CallError, InterruptedException {
        return (Boolean)call("setBrightness", param1).get();
    }

    /**
    * Change screen brightness
    * 
    */
    public Float getBrightness() throws CallError, InterruptedException {
        return (Float)call("getBrightness").get();
    }

    /**
    * Turn on (true) / off (false)  the screen
    * 
    */
    public void turnScreenOn(Boolean param1) throws CallError, InterruptedException{
        call("turnScreenOn", param1).get();
    }

    /**
    * Put the tablet in sleep mode (standby mode)
    * 
    */
    public void goToSleep() throws CallError, InterruptedException{
        call("goToSleep").get();
    }

    /**
    * Put the tablet in wake mode (standby mode)
    * 
    */
    public void wakeUp() throws CallError, InterruptedException{
        call("wakeUp").get();
    }

    /**
    * Check the WIFI on the tablet : IDLE, SCANNING, DISCONNECTED, CONNECTED
    * 
    */
    public String getWifiStatus() throws CallError, InterruptedException {
        return (String)call("getWifiStatus").get();
    }

    /**
    * Enable the wifi on the tablet
    * 
    */
    public void enableWifi() throws CallError, InterruptedException{
        call("enableWifi").get();
    }

    /**
    * Disable the wifi on the tablet
    * 
    */
    public void disableWifi() throws CallError, InterruptedException{
        call("disableWifi").get();
    }

    /**
    * Forget the wifi : 1) SSID
    * 
    */
    public Boolean forgetWifi(String param1) throws CallError, InterruptedException {
        return (Boolean)call("forgetWifi", param1).get();
    }

    /**
    * Try to connect to the wifi by is SSID
    * 
    */
    public Boolean connectWifi(String param1) throws CallError, InterruptedException {
        return (Boolean)call("connectWifi", param1).get();
    }

    /**
    * Disconnect current wifi
    * 
    */
    public Boolean disconnectWifi() throws CallError, InterruptedException {
        return (Boolean)call("disconnectWifi").get();
    }

    /**
    * Configure the WIFI, arguments: 
       1) is type among (wep, wpa, open) 
       2) is the wifi SSID 
       3) is wep or wap passphrase 

    * 
    */
    public Boolean configureWifi(String param1, String param2, String param3) throws CallError, InterruptedException {
        return (Boolean)call("configureWifi", param1, param2, param3).get();
    }

    /**
    * Show a input text dialog, arguments 
       1) the title 
       2) is the ok text  
       3) the cancel text 
    * 
    */
    public void showInputTextDialog(String param1, String param2, String param3) throws CallError, InterruptedException{
        call("showInputTextDialog", param1, param2, param3).get();
    }

    /**
    * Show a input text dialog, arguments 
       1) the title 
       2) is the ok text  
       3) the cancel text 
       4) the pre-filled text of the input field 
       5) input characters limit
    * 
    */
    public void showInputTextDialog(String param1, String param2, String param3, String param4, Integer param5) throws CallError, InterruptedException{
        call("showInputTextDialog", param1, param2, param3, param4, param5).get();
    }

    /**
    * Show a input text dialog, arguments : 
       1) is type among text, password, email, url, number 
       2) the title 
       3) is the ok text 
       4) the cancel text
    * 
    */
    public void showInputDialog(String param1, String param2, String param3, String param4) throws CallError, InterruptedException{
        call("showInputDialog", param1, param2, param3, param4).get();
    }

    /**
    * Show a input text dialog, arguments 
       1) is type among text, password, email, url, number 
       2) the title 
       3) is the ok text 
       4) the cancel text 
       5) the pre-filled text of the input field, use '' if you don't want any 
       6) input characters limit, use -1 if you don't want a limit
    * 
    */
    public void showInputDialog(String param1, String param2, String param3, String param4, String param5, Integer param6) throws CallError, InterruptedException{
        call("showInputDialog", param1, param2, param3, param4, param5, param6).get();
    }

    /**
    * Test debug function
    * 
    */
    public void showAlertView(Float param1, String param2, Integer param3) throws CallError, InterruptedException{
        call("showAlertView", param1, param2, param3).get();
    }

    /**
    * Hide the dialog view
    * 
    */
    public void hideDialog() throws CallError, InterruptedException{
        call("hideDialog").get();
    }

    /**
    * Set keyboard using is keyboard id from getAvailableKeyboards
    * 
    */
    public Boolean setKeyboard(String param1) throws CallError, InterruptedException {
        return (Boolean)call("setKeyboard", param1).get();
    }

    /**
    * get available keyboards
    * 
    */
    public List<String> getAvailableKeyboards() throws CallError, InterruptedException {
        return (List<String>)call("getAvailableKeyboards").get();
    }

    /**
    * Change the tablet language: fr, fr_FR, en, us, it, ja ... 
    * 
    */
    public Boolean setTabletLanguage(String param1) throws CallError, InterruptedException {
        return (Boolean)call("setTabletLanguage", param1).get();
    }

    /**
    * Set the volume of the tablet between 0 and 15
    * 
    */
    public Boolean setVolume(Integer param1) throws CallError, InterruptedException {
        return (Boolean)call("setVolume", param1).get();
    }

    /**
    * Get IP of connected robot
    * 
    */
    public String robotIp() throws CallError, InterruptedException {
        return (String)call("robotIp").get();
    }

    /**
    * Return the current life activity running
    * 
    */
    public String getCurrentLifeActivity() throws CallError, InterruptedException {
        return (String)call("getCurrentLifeActivity").get();
    }

    /**
    * Return service version
    * 
    */
    public String version() throws CallError, InterruptedException {
        return (String)call("version").get();
    }

    /**
    * reset the tablet (get back to the bubble views and clear everything)
    * 
    */
    public void resetTablet() throws CallError, InterruptedException{
        call("resetTablet").get();
    }

    /**
    * Get last video played error log [DEPRECATED]
    * 
    */
    public String getLastVideoErrorLog() throws CallError, InterruptedException {
        return (String)call("getLastVideoErrorLog").get();
    }

    /**
    * Enable touch signal on webview [DEPRECATED]
    * 
    */
    public void enableWebviewTouch() throws CallError, InterruptedException{
        call("enableWebviewTouch").get();
    }

    /**
    * Disable touch signal on webview [DEPRECATED]
    * 
    */
    public void disableWebviewTouch() throws CallError, InterruptedException{
        call("disableWebviewTouch").get();
    }

    /**
    * reset to default value [DEPRECATED]
    * 
    */
    public void resetToDefaultValue() throws CallError, InterruptedException{
        call("resetToDefaultValue").get();
    }


    public class AsyncALTabletService extends ALProxy {

        protected AsyncALTabletService(){
            super();
        }
    
    /**
    * 
    * 
    */
    public Future<Boolean> isStatsEnabled() throws CallError, InterruptedException {
        return call("isStatsEnabled");
    }

    /**
    * 
    * 
    * @return The Future
    */
    public Future<Void> clearStats() throws CallError, InterruptedException{
        return call("clearStats");
    }

    /**
    * 
    * 
    */
    public Future<Boolean> isTraceEnabled() throws CallError, InterruptedException {
        return call("isTraceEnabled");
    }

    /**
    * Show Webview (with app-specific content)
    * 
    */
    public Future<Boolean> showWebview() throws CallError, InterruptedException {
        return call("showWebview");
    }

    /**
    * Show Webview and load the url
    * 
    */
    public Future<Boolean> showWebview(String param1) throws CallError, InterruptedException {
        return call("showWebview", param1);
    }

    /**
    * Load URL on tablet
    * 
    */
    public Future<Boolean> loadUrl(String param1) throws CallError, InterruptedException {
        return call("loadUrl", param1);
    }

    /**
    * Reload current displayed web page
    * 
    * @return The Future
    */
    public Future<Void> reloadPage(Boolean param1) throws CallError, InterruptedException{
        return call("reloadPage", param1);
    }

    /**
    * Start application on tablet
    * 
    */
    public Future<Boolean> loadApplication(String param1) throws CallError, InterruptedException {
        return call("loadApplication", param1);
    }

    /**
    * Hide Webview 
    * 
    */
    public Future<Boolean> hideWebview() throws CallError, InterruptedException {
        return call("hideWebview");
    }

    /**
    * Clean Webview 
    * 
    * @return The Future
    */
    public Future<Void> cleanWebview() throws CallError, InterruptedException{
        return call("cleanWebview");
    }

    /**
    * Execute javascript 
    * 
    * @return The Future
    */
    public Future<Void> executeJS(String param1) throws CallError, InterruptedException{
        return call("executeJS", param1);
    }

    /**
    * Change the onTouch webview scale factor. Default is 1.34 so the viewport is 1707 x 1067
    * 
    * @return The Future
    */
    public Future<Void> setOnTouchWebviewScaleFactor(Float param1) throws CallError, InterruptedException{
        return call("setOnTouchWebviewScaleFactor", param1);
    }

    /**
    * get the onTouch scale factor for current view, by default 1.34 for the webview and 1 for the other views
    * 
    */
    public Future<Float> getOnTouchScaleFactor() throws CallError, InterruptedException {
        return call("getOnTouchScaleFactor");
    }

    /**
    * Play video on tablet
    * 
    */
    public Future<Boolean> playVideo(String param1) throws CallError, InterruptedException {
        return call("playVideo", param1);
    }

    /**
    * Resume video on tablet
    * 
    */
    public Future<Boolean> resumeVideo() throws CallError, InterruptedException {
        return call("resumeVideo");
    }

    /**
    * Pause video activity on tablet
    * 
    */
    public Future<Boolean> pauseVideo() throws CallError, InterruptedException {
        return call("pauseVideo");
    }

    /**
    * Stop video activity on tablet
    * 
    */
    public Future<Boolean> stopVideo() throws CallError, InterruptedException {
        return call("stopVideo");
    }

    /**
    * Get video position (in ms from beginning)
    * 
    */
    public Future<Integer> getVideoPosition() throws CallError, InterruptedException {
        return call("getVideoPosition");
    }

    /**
    * Get video length (in ms)
    * 
    */
    public Future<Integer> getVideoLength() throws CallError, InterruptedException {
        return call("getVideoLength");
    }

    /**
    * preload an image
    * 
    */
    public Future<Boolean> preLoadImage(String param1) throws CallError, InterruptedException {
        return call("preLoadImage", param1);
    }

    /**
    * show an image
    * 
    */
    public Future<Boolean> showImage(String param1) throws CallError, InterruptedException {
        return call("showImage", param1);
    }

    /**
    * show an image, disable tablet cache
    * 
    */
    public Future<Boolean> showImageNoCache(String param1) throws CallError, InterruptedException {
        return call("showImageNoCache", param1);
    }

    /**
    * Hide an image
    * 
    * @return The Future
    */
    public Future<Void> hideImage() throws CallError, InterruptedException{
        return call("hideImage");
    }

    /**
    * resume the gif
    * 
    * @return The Future
    */
    public Future<Void> resumeGif() throws CallError, InterruptedException{
        return call("resumeGif");
    }

    /**
    * pause the gif
    * 
    * @return The Future
    */
    public Future<Void> pauseGif() throws CallError, InterruptedException{
        return call("pauseGif");
    }

    /**
    * Set the background color for image
    * 
    */
    public Future<Boolean> setBackgroundColor(String param1) throws CallError, InterruptedException {
        return call("setBackgroundColor", param1);
    }

    /**
    * hide the top view
    * 
    * @return The Future
    */
    public Future<Void> hide() throws CallError, InterruptedException{
        return call("hide");
    }

    /**
    * Change screen brightness
    * 
    */
    public Future<Boolean> setBrightness(Float param1) throws CallError, InterruptedException {
        return call("setBrightness", param1);
    }

    /**
    * Change screen brightness
    * 
    */
    public Future<Float> getBrightness() throws CallError, InterruptedException {
        return call("getBrightness");
    }

    /**
    * Turn on (true) / off (false)  the screen
    * 
    * @return The Future
    */
    public Future<Void> turnScreenOn(Boolean param1) throws CallError, InterruptedException{
        return call("turnScreenOn", param1);
    }

    /**
    * Put the tablet in sleep mode (standby mode)
    * 
    * @return The Future
    */
    public Future<Void> goToSleep() throws CallError, InterruptedException{
        return call("goToSleep");
    }

    /**
    * Put the tablet in wake mode (standby mode)
    * 
    * @return The Future
    */
    public Future<Void> wakeUp() throws CallError, InterruptedException{
        return call("wakeUp");
    }

    /**
    * Check the WIFI on the tablet : IDLE, SCANNING, DISCONNECTED, CONNECTED
    * 
    */
    public Future<String> getWifiStatus() throws CallError, InterruptedException {
        return call("getWifiStatus");
    }

    /**
    * Enable the wifi on the tablet
    * 
    * @return The Future
    */
    public Future<Void> enableWifi() throws CallError, InterruptedException{
        return call("enableWifi");
    }

    /**
    * Disable the wifi on the tablet
    * 
    * @return The Future
    */
    public Future<Void> disableWifi() throws CallError, InterruptedException{
        return call("disableWifi");
    }

    /**
    * Forget the wifi : 1) SSID
    * 
    */
    public Future<Boolean> forgetWifi(String param1) throws CallError, InterruptedException {
        return call("forgetWifi", param1);
    }

    /**
    * Try to connect to the wifi by is SSID
    * 
    */
    public Future<Boolean> connectWifi(String param1) throws CallError, InterruptedException {
        return call("connectWifi", param1);
    }

    /**
    * Disconnect current wifi
    * 
    */
    public Future<Boolean> disconnectWifi() throws CallError, InterruptedException {
        return call("disconnectWifi");
    }

    /**
    * Configure the WIFI, arguments: 
       1) is type among (wep, wpa, open) 
       2) is the wifi SSID 
       3) is wep or wap passphrase 

    * 
    */
    public Future<Boolean> configureWifi(String param1, String param2, String param3) throws CallError, InterruptedException {
        return call("configureWifi", param1, param2, param3);
    }

    /**
    * Show a input text dialog, arguments 
       1) the title 
       2) is the ok text  
       3) the cancel text 
    * 
    * @return The Future
    */
    public Future<Void> showInputTextDialog(String param1, String param2, String param3) throws CallError, InterruptedException{
        return call("showInputTextDialog", param1, param2, param3);
    }

    /**
    * Show a input text dialog, arguments 
       1) the title 
       2) is the ok text  
       3) the cancel text 
       4) the pre-filled text of the input field 
       5) input characters limit
    * 
    * @return The Future
    */
    public Future<Void> showInputTextDialog(String param1, String param2, String param3, String param4, Integer param5) throws CallError, InterruptedException{
        return call("showInputTextDialog", param1, param2, param3, param4, param5);
    }

    /**
    * Show a input text dialog, arguments : 
       1) is type among text, password, email, url, number 
       2) the title 
       3) is the ok text 
       4) the cancel text
    * 
    * @return The Future
    */
    public Future<Void> showInputDialog(String param1, String param2, String param3, String param4) throws CallError, InterruptedException{
        return call("showInputDialog", param1, param2, param3, param4);
    }

    /**
    * Show a input text dialog, arguments 
       1) is type among text, password, email, url, number 
       2) the title 
       3) is the ok text 
       4) the cancel text 
       5) the pre-filled text of the input field, use '' if you don't want any 
       6) input characters limit, use -1 if you don't want a limit
    * 
    * @return The Future
    */
    public Future<Void> showInputDialog(String param1, String param2, String param3, String param4, String param5, Integer param6) throws CallError, InterruptedException{
        return call("showInputDialog", param1, param2, param3, param4, param5, param6);
    }

    /**
    * Test debug function
    * 
    * @return The Future
    */
    public Future<Void> showAlertView(Float param1, String param2, Integer param3) throws CallError, InterruptedException{
        return call("showAlertView", param1, param2, param3);
    }

    /**
    * Hide the dialog view
    * 
    * @return The Future
    */
    public Future<Void> hideDialog() throws CallError, InterruptedException{
        return call("hideDialog");
    }

    /**
    * Set keyboard using is keyboard id from getAvailableKeyboards
    * 
    */
    public Future<Boolean> setKeyboard(String param1) throws CallError, InterruptedException {
        return call("setKeyboard", param1);
    }

    /**
    * get available keyboards
    * 
    */
    public Future<List<String>> getAvailableKeyboards() throws CallError, InterruptedException {
        return call("getAvailableKeyboards");
    }

    /**
    * Change the tablet language: fr, fr_FR, en, us, it, ja ... 
    * 
    */
    public Future<Boolean> setTabletLanguage(String param1) throws CallError, InterruptedException {
        return call("setTabletLanguage", param1);
    }

    /**
    * Set the volume of the tablet between 0 and 15
    * 
    */
    public Future<Boolean> setVolume(Integer param1) throws CallError, InterruptedException {
        return call("setVolume", param1);
    }

    /**
    * Get IP of connected robot
    * 
    */
    public Future<String> robotIp() throws CallError, InterruptedException {
        return call("robotIp");
    }

    /**
    * Return the current life activity running
    * 
    */
    public Future<String> getCurrentLifeActivity() throws CallError, InterruptedException {
        return call("getCurrentLifeActivity");
    }

    /**
    * Return service version
    * 
    */
    public Future<String> version() throws CallError, InterruptedException {
        return call("version");
    }

    /**
    * reset the tablet (get back to the bubble views and clear everything)
    * 
    * @return The Future
    */
    public Future<Void> resetTablet() throws CallError, InterruptedException{
        return call("resetTablet");
    }

    /**
    * Get last video played error log [DEPRECATED]
    * 
    */
    public Future<String> getLastVideoErrorLog() throws CallError, InterruptedException {
        return call("getLastVideoErrorLog");
    }

    /**
    * Enable touch signal on webview [DEPRECATED]
    * 
    * @return The Future
    */
    public Future<Void> enableWebviewTouch() throws CallError, InterruptedException{
        return call("enableWebviewTouch");
    }

    /**
    * Disable touch signal on webview [DEPRECATED]
    * 
    * @return The Future
    */
    public Future<Void> disableWebviewTouch() throws CallError, InterruptedException{
        return call("disableWebviewTouch");
    }

    /**
    * reset to default value [DEPRECATED]
    * 
    * @return The Future
    */
    public Future<Void> resetToDefaultValue() throws CallError, InterruptedException{
        return call("resetToDefaultValue");
    }

    }
}
    