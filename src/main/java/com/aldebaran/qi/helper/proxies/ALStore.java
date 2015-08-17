/**
 * Copyright (c) 2015 Aldebaran Robotics. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be
 * found in the COPYING file.
 * Created by epinault and tcruz
 */
package com.aldebaran.qi.helper.proxies;

import com.aldebaran.qi.*;
import com.aldebaran.qi.helper.*;
import java.util.List;
import java.util.Map;


import java.util.List;
/**
* 
* @see <a href="http://doc.aldebaran.lan/doc/master/aldeb-doc/naoqi/core/alstore.html#alstore">NAOqi APIs for ALStore </a>
* NAOqi V2.4.x
*/
public class ALStore extends ALProxy {

    private AsyncALStore asyncProxy;

    public ALStore(Session session) throws Exception{
        super(session);
        asyncProxy = new AsyncALStore();
	    asyncProxy.setService(getService());
    }

    /**
     * Get the async version of this proxy
     *
	 * @return a AsyncALStore object
	 */
    public AsyncALStore async() {
        return asyncProxy;
    }

    /**
    * (@asynchronous) Do the necessary updates to the robot application
        packages: install new ones, update the outdated ones, and
        remove the ones to remove.
        Calling this function set the state 'workerPkgsState' to
        (state, package_uuid), with state equal to
        'downloading','updating','removing' and 'adding' in function
        of the operation occuring.
    * 
    */
    public void updatePackages() throws CallError, InterruptedException{
        call("updatePackages").get();
    }

    /**
    * (@deprecated) Returns a list of application packages the robot must
        have installed. Each package contains a 'status' field, which
        can have as value: 0 (uptodate), 1 (downloading), 2 (new
        version available), 3 (new version fetched).
        This list also contains information about the next available
        system image to install if there is one.
        This list can be empty if the module has failed to download the
        list from the cloud (in case of error, or cloud disabled).
        Please use 'getPackageInfo()' or 'downloadPackagesInfo()' and
        'getNextSystemImageInfo()' or 'downloadNextSystemImageInfo()'.

        :returns: a list of dictionnaries containing the application
        packages info.
    * 
    */
    public List<Map<String, Object>> status() throws CallError, InterruptedException {
        return (List<Map<String, Object>>)call("status").get();
    }

    /**
    * (@deprecated) Download information from the Cloud to know what apps
        should be installed on robot, and what next system image is
        available. Then do the necessary updates to the robot
        application packages: install new ones, update the outdated
        ones, and remove the ones to remove.
        Please use 'downloadPackagesInfo()', 'updatePackages()',
        and 'downloadNextSystemImageInfo()', 'downloadNextSystemImage()',
        'installNextSystemImage()' instead.

        :returns: True if everything went fine, False overwise.
    * 
    */
    public Boolean update() throws CallError, InterruptedException {
        return (Boolean)call("update").get();
    }

    /**
    * (@deprecated) Download information from the Cloud to know what apps
        should be installed on robot. Then do the necessary updates to the
        robot application packages: install new ones, update the outdated
        ones, and remove the ones to remove.
        Please use 'downloadPackagesInfo()', 'updatePackages()' instead.

        :returns: True if everything went fine, False overwise.
    * 
    */
    public Boolean updateApps() throws CallError, InterruptedException {
        return (Boolean)call("updateApps").get();
    }

    /**
    * (@deprecated) This function does nothing.
    * 
    */
    public Boolean updateRunningApps() throws CallError, InterruptedException {
        return (Boolean)call("updateRunningApps").get();
    }

    /**
    * (@deprecated) Stop all current asynchronous operations 
    * 
    */
    public void stopUpdate() throws CallError, InterruptedException{
        call("stopUpdate").get();
    }

    /**
    * (@deprecated) Download information from the Cloud to know what next
        system image is available. Then upgrade the robot if necessary.
        Please use 'downloadNextSystemImageInfo()',
        'downloadNextSystemImage()', 'installNextSystemImage()' instead.

        :returns: True if everything went fine, False overwise.
    * 
    */
    public Boolean updateSystem() throws CallError, InterruptedException {
        return (Boolean)call("updateSystem").get();
    }

    /**
    * (@asynchronous) Do the necessary updates to the robot application
        package whose uuid is given in parameter.
        Calling this function set the state 'workerPkgsState' to
        (state, package_uuid), with state equal to
        'downloading','updating','removing' and 'adding' in function
        of the operation occuring.

        :param package_uuid: the uuid of the package you want to update.
        :returns: True if everything went fine, False overwise.
    * 
    */
    public Boolean updatePackage(String param1) throws CallError, InterruptedException {
        return (Boolean)call("updatePackage", param1).get();
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
    *  Stop all current asynchronous operations 
    * 
    */
    public void abortAll() throws CallError, InterruptedException{
        call("abortAll").get();
    }

    /**
    * Abort installation of system image. Remove any downloaded system
        image.
    * 
    */
    public void abortSystemImageInstall() throws CallError, InterruptedException{
        call("abortSystemImageInstall").get();
    }

    /**
    * (@deprecated) This function does nothing.
    * 
    */
    public Boolean activateUpdateRunningApps() throws CallError, InterruptedException {
        return (Boolean)call("activateUpdateRunningApps").get();
    }

    /**
    * (@deprecated) This function does nothing.
    * 
    */
    public Boolean analyse() throws CallError, InterruptedException {
        return (Boolean)call("analyse").get();
    }

    /**
    * (@deprecated) Download information from the Cloud to know what apps
        should be installed on robot, and what next system image is
        available. Then do the necessary updates to the robot
        application packages: install new ones, update the outdated
        ones, and remove the ones to remove.
        Please use 'downloadPackagesInfo()', 'updatePackages()',
        and 'downloadNextSystemImageInfo()', 'downloadNextSystemImage()',
        'installNextSystemImage()' instead.

        :returns: True if everything went fine, False overwise.
    * 
    */
    public Boolean checkUpdate() throws CallError, InterruptedException {
        return (Boolean)call("checkUpdate").get();
    }

    /**
    * (@deprecated) This function does nothing.
    * 
    */
    public Boolean deactivateUpdateRunningApps() throws CallError, InterruptedException {
        return (Boolean)call("deactivateUpdateRunningApps").get();
    }

    /**
    * (@asynchronous) Re-download the system image currently installed on
        this robot, so that you can then use it to do a factory reset.
        Once the image is downloaded, you can install it using the
        function 'installCurrentSystemImage'
        Calling this function set the state 'workerSysImgState' to
        ('downloading', '').

        :returns: True if everything went fine, False overwise.
    * 
    */
    public Boolean downloadCurrentSystemImage() throws CallError, InterruptedException {
        return (Boolean)call("downloadCurrentSystemImage").get();
    }

    /**
    * (@asynchronous) Download, from the Cloud, information about the
        current system image.
        Calling this function set the state 'workerSysImgState' to
        ('downloading_info', '').

        :param login: login of the user who request to download the image
        :param password: password of the user who request to download the image
        :returns: a dictionnary with the system image information, or
        an empty dict in case no new system image is available.
    * 
    */
    public Map<String, Object> downloadCurrentSystemImageInfo(String param1, String param2) throws CallError, InterruptedException {
        return (Map<String, Object>)call("downloadCurrentSystemImageInfo", param1, param2).get();
    }

    /**
    * (@asynchronous) Download the newest available system image if there
        is one to download.
        Once the image is downloaded, you can install it using the
        function 'installNextSystemImage'
        Calling this function set the state 'workerSysImgState' to
        ('downloading', '').

        :returns: True if everything went fine, False overwise.
    * 
    */
    public Boolean downloadNextSystemImage() throws CallError, InterruptedException {
        return (Boolean)call("downloadNextSystemImage").get();
    }

    /**
    * (@asynchronous) Download, from the Cloud, information about the
        newest available system image.
        Calling this function set the state 'workerSysImgState' to
        ('downloading_info', '').

        :returns: a dictionnary with the system image information, or
        an empty dict in case no new system image is available.
    * 
    */
    public Map<String, Object> downloadNextSystemImageInfo() throws CallError, InterruptedException {
        return (Map<String, Object>)call("downloadNextSystemImageInfo").get();
    }

    /**
    * (@asynchronous) Download, from the Cloud, information about the
        application packages the robot has to install.
        Calling this function set the state 'workerPkgsState' to
        ('downloading_info', '').

        :returns: a list of dictionnaries containing the application
        packages info.
    * 
    */
    public List<Map<String, Object>> downloadPackagesInfo() throws CallError, InterruptedException {
        return (List<Map<String, Object>>)call("downloadPackagesInfo").get();
    }

    /**
    * (@deprecated) Return some information about the package whose uuid
        is given as parameter.
        Please use 'getPackagesInfo()' instead.

        :param uuid: The uuid of the package you want information about.
        :returns: A dictionary with the package information if it is
          found, or None if no info is available.
    * 
    */
    public Object getPackageInfo(String param1) throws CallError, InterruptedException {
        return (Object)call("getPackageInfo", param1).get();
    }

    /**
    * Return information about the newest available system image, in
        case the robot has an outdated one.

        :returns: a dictionnary with the system image information, or
        an empty dict in case no new system image is available.
    * 
    */
    public Map<String, Object> getNextSystemImageInfo() throws CallError, InterruptedException {
        return (Map<String, Object>)call("getNextSystemImageInfo").get();
    }

    /**
    * Returns a list of application packages the robot must have
        installed. Each package contains a 'status' field, which can
        have as value: 0 (uptodate), 1 (downloading), 2 (new version
        available), 3 (new version fetched).
        This list can be empty if the module has failed to download the
        list from the cloud (in case of error, or cloud disabled).
        To refresh this list of packages call 'downloadPackagesInfo()'.

        :returns: a list of dictionnaries containing the application
        packages info.
    * 
    */
    public List<Map<String, Object>> getPackagesInfo() throws CallError, InterruptedException {
        return (List<Map<String, Object>>)call("getPackagesInfo").get();
    }

    /**
    * Returns a list of application packages the robot have not installed
        yet and have to install.
        This list can be empty if the module has failed to download the
        list from the cloud (in case of error, or cloud disabled).

        :returns: a list of dictionnaries containing the application
        packages info.
    * 
    */
    public List<Map<String, Object>> getPackagesToAdd() throws CallError, InterruptedException {
        return (List<Map<String, Object>>)call("getPackagesToAdd").get();
    }

    /**
    * Returns a list of application packages the robot have to remove.
        This list can be empty if the module has failed to download the
        list from the cloud (in case of error, or cloud disabled).

        :returns: a list of dictionnaries containing the application
        packages info.
    * 
    */
    public List<Map<String, Object>> getPackagesToRemove() throws CallError, InterruptedException {
        return (List<Map<String, Object>>)call("getPackagesToRemove").get();
    }

    /**
    * Returns a list of application packages the robot have installed but
        are now available in an updated version.
        This list can be empty if the module has failed to download the
        list from the cloud (in case of error, or cloud disabled).

        :returns: a list of dictionnaries containing the application
        packages info.
    * 
    */
    public List<Map<String, Object>> getPackagesToUpdate() throws CallError, InterruptedException {
        return (List<Map<String, Object>>)call("getPackagesToUpdate").get();
    }

    /**
    * (@asynchronous) Re-install the currently installed system image.
        The system image must have been downloaded first, using the function
        'downloadCurrentSystemImage'.
        Calling this function set the state 'workerSysImgState' to
        ('updating', '').

        :param factory_reset: set to True to perform a factory reset, or
          False to do a regular image upgrade.
        :returns: True if everything went fine, False overwise.
    * 
    */
    public Boolean installCurrentSystemImage(Boolean param1) throws CallError, InterruptedException {
        return (Boolean)call("installCurrentSystemImage", param1).get();
    }

    /**
    * (@asynchronous) Install the newest available system image if there
        is one available. The system image must have been downloaded first,
        using the function 'downloadNextSystemImage'.
        Calling this function set the state 'workerSysImgState' to
        ('updating', '').

        :param factory_reset: set to True to perform a factory reset, or
          False to do a regular image upgrade.
        :returns: True if everything went fine, False overwise.
    * 
    */
    public Boolean installNextSystemImage(Boolean param1) throws CallError, InterruptedException {
        return (Boolean)call("installNextSystemImage", param1).get();
    }


    public class AsyncALStore extends ALProxy {

        protected AsyncALStore(){
            super();
        }
    
    /**
    * (@asynchronous) Do the necessary updates to the robot application
        packages: install new ones, update the outdated ones, and
        remove the ones to remove.
        Calling this function set the state 'workerPkgsState' to
        (state, package_uuid), with state equal to
        'downloading','updating','removing' and 'adding' in function
        of the operation occuring.
    * 
    * @return The Future
    */
    public Future<Void> updatePackages() throws CallError, InterruptedException{
        return call("updatePackages");
    }

    /**
    * (@deprecated) Returns a list of application packages the robot must
        have installed. Each package contains a 'status' field, which
        can have as value: 0 (uptodate), 1 (downloading), 2 (new
        version available), 3 (new version fetched).
        This list also contains information about the next available
        system image to install if there is one.
        This list can be empty if the module has failed to download the
        list from the cloud (in case of error, or cloud disabled).
        Please use 'getPackageInfo()' or 'downloadPackagesInfo()' and
        'getNextSystemImageInfo()' or 'downloadNextSystemImageInfo()'.

        :returns: a list of dictionnaries containing the application
        packages info.
    * 
    */
    public Future<List<Map<String, Object>>> status() throws CallError, InterruptedException {
        return call("status");
    }

    /**
    * (@deprecated) Download information from the Cloud to know what apps
        should be installed on robot, and what next system image is
        available. Then do the necessary updates to the robot
        application packages: install new ones, update the outdated
        ones, and remove the ones to remove.
        Please use 'downloadPackagesInfo()', 'updatePackages()',
        and 'downloadNextSystemImageInfo()', 'downloadNextSystemImage()',
        'installNextSystemImage()' instead.

        :returns: True if everything went fine, False overwise.
    * 
    */
    public Future<Boolean> update() throws CallError, InterruptedException {
        return call("update");
    }

    /**
    * (@deprecated) Download information from the Cloud to know what apps
        should be installed on robot. Then do the necessary updates to the
        robot application packages: install new ones, update the outdated
        ones, and remove the ones to remove.
        Please use 'downloadPackagesInfo()', 'updatePackages()' instead.

        :returns: True if everything went fine, False overwise.
    * 
    */
    public Future<Boolean> updateApps() throws CallError, InterruptedException {
        return call("updateApps");
    }

    /**
    * (@deprecated) This function does nothing.
    * 
    */
    public Future<Boolean> updateRunningApps() throws CallError, InterruptedException {
        return call("updateRunningApps");
    }

    /**
    * (@deprecated) Stop all current asynchronous operations 
    * 
    * @return The Future
    */
    public Future<Void> stopUpdate() throws CallError, InterruptedException{
        return call("stopUpdate");
    }

    /**
    * (@deprecated) Download information from the Cloud to know what next
        system image is available. Then upgrade the robot if necessary.
        Please use 'downloadNextSystemImageInfo()',
        'downloadNextSystemImage()', 'installNextSystemImage()' instead.

        :returns: True if everything went fine, False overwise.
    * 
    */
    public Future<Boolean> updateSystem() throws CallError, InterruptedException {
        return call("updateSystem");
    }

    /**
    * (@asynchronous) Do the necessary updates to the robot application
        package whose uuid is given in parameter.
        Calling this function set the state 'workerPkgsState' to
        (state, package_uuid), with state equal to
        'downloading','updating','removing' and 'adding' in function
        of the operation occuring.

        :param package_uuid: the uuid of the package you want to update.
        :returns: True if everything went fine, False overwise.
    * 
    */
    public Future<Boolean> updatePackage(String param1) throws CallError, InterruptedException {
        return call("updatePackage", param1);
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
    *  Stop all current asynchronous operations 
    * 
    * @return The Future
    */
    public Future<Void> abortAll() throws CallError, InterruptedException{
        return call("abortAll");
    }

    /**
    * Abort installation of system image. Remove any downloaded system
        image.
    * 
    * @return The Future
    */
    public Future<Void> abortSystemImageInstall() throws CallError, InterruptedException{
        return call("abortSystemImageInstall");
    }

    /**
    * (@deprecated) This function does nothing.
    * 
    */
    public Future<Boolean> activateUpdateRunningApps() throws CallError, InterruptedException {
        return call("activateUpdateRunningApps");
    }

    /**
    * (@deprecated) This function does nothing.
    * 
    */
    public Future<Boolean> analyse() throws CallError, InterruptedException {
        return call("analyse");
    }

    /**
    * (@deprecated) Download information from the Cloud to know what apps
        should be installed on robot, and what next system image is
        available. Then do the necessary updates to the robot
        application packages: install new ones, update the outdated
        ones, and remove the ones to remove.
        Please use 'downloadPackagesInfo()', 'updatePackages()',
        and 'downloadNextSystemImageInfo()', 'downloadNextSystemImage()',
        'installNextSystemImage()' instead.

        :returns: True if everything went fine, False overwise.
    * 
    */
    public Future<Boolean> checkUpdate() throws CallError, InterruptedException {
        return call("checkUpdate");
    }

    /**
    * (@deprecated) This function does nothing.
    * 
    */
    public Future<Boolean> deactivateUpdateRunningApps() throws CallError, InterruptedException {
        return call("deactivateUpdateRunningApps");
    }

    /**
    * (@asynchronous) Re-download the system image currently installed on
        this robot, so that you can then use it to do a factory reset.
        Once the image is downloaded, you can install it using the
        function 'installCurrentSystemImage'
        Calling this function set the state 'workerSysImgState' to
        ('downloading', '').

        :returns: True if everything went fine, False overwise.
    * 
    */
    public Future<Boolean> downloadCurrentSystemImage() throws CallError, InterruptedException {
        return call("downloadCurrentSystemImage");
    }

    /**
    * (@asynchronous) Download, from the Cloud, information about the
        current system image.
        Calling this function set the state 'workerSysImgState' to
        ('downloading_info', '').

        :param login: login of the user who request to download the image
        :param password: password of the user who request to download the image
        :returns: a dictionnary with the system image information, or
        an empty dict in case no new system image is available.
    * 
    */
    public Future<Map<String, Object>> downloadCurrentSystemImageInfo(String param1, String param2) throws CallError, InterruptedException {
        return call("downloadCurrentSystemImageInfo", param1, param2);
    }

    /**
    * (@asynchronous) Download the newest available system image if there
        is one to download.
        Once the image is downloaded, you can install it using the
        function 'installNextSystemImage'
        Calling this function set the state 'workerSysImgState' to
        ('downloading', '').

        :returns: True if everything went fine, False overwise.
    * 
    */
    public Future<Boolean> downloadNextSystemImage() throws CallError, InterruptedException {
        return call("downloadNextSystemImage");
    }

    /**
    * (@asynchronous) Download, from the Cloud, information about the
        newest available system image.
        Calling this function set the state 'workerSysImgState' to
        ('downloading_info', '').

        :returns: a dictionnary with the system image information, or
        an empty dict in case no new system image is available.
    * 
    */
    public Future<Map<String, Object>> downloadNextSystemImageInfo() throws CallError, InterruptedException {
        return call("downloadNextSystemImageInfo");
    }

    /**
    * (@asynchronous) Download, from the Cloud, information about the
        application packages the robot has to install.
        Calling this function set the state 'workerPkgsState' to
        ('downloading_info', '').

        :returns: a list of dictionnaries containing the application
        packages info.
    * 
    */
    public Future<List<Map<String, Object>>> downloadPackagesInfo() throws CallError, InterruptedException {
        return call("downloadPackagesInfo");
    }

    /**
    * (@deprecated) Return some information about the package whose uuid
        is given as parameter.
        Please use 'getPackagesInfo()' instead.

        :param uuid: The uuid of the package you want information about.
        :returns: A dictionary with the package information if it is
          found, or None if no info is available.
    * 
    */
    public Future<Object> getPackageInfo(String param1) throws CallError, InterruptedException {
        return call("getPackageInfo", param1);
    }

    /**
    * Return information about the newest available system image, in
        case the robot has an outdated one.

        :returns: a dictionnary with the system image information, or
        an empty dict in case no new system image is available.
    * 
    */
    public Future<Map<String, Object>> getNextSystemImageInfo() throws CallError, InterruptedException {
        return call("getNextSystemImageInfo");
    }

    /**
    * Returns a list of application packages the robot must have
        installed. Each package contains a 'status' field, which can
        have as value: 0 (uptodate), 1 (downloading), 2 (new version
        available), 3 (new version fetched).
        This list can be empty if the module has failed to download the
        list from the cloud (in case of error, or cloud disabled).
        To refresh this list of packages call 'downloadPackagesInfo()'.

        :returns: a list of dictionnaries containing the application
        packages info.
    * 
    */
    public Future<List<Map<String, Object>>> getPackagesInfo() throws CallError, InterruptedException {
        return call("getPackagesInfo");
    }

    /**
    * Returns a list of application packages the robot have not installed
        yet and have to install.
        This list can be empty if the module has failed to download the
        list from the cloud (in case of error, or cloud disabled).

        :returns: a list of dictionnaries containing the application
        packages info.
    * 
    */
    public Future<List<Map<String, Object>>> getPackagesToAdd() throws CallError, InterruptedException {
        return call("getPackagesToAdd");
    }

    /**
    * Returns a list of application packages the robot have to remove.
        This list can be empty if the module has failed to download the
        list from the cloud (in case of error, or cloud disabled).

        :returns: a list of dictionnaries containing the application
        packages info.
    * 
    */
    public Future<List<Map<String, Object>>> getPackagesToRemove() throws CallError, InterruptedException {
        return call("getPackagesToRemove");
    }

    /**
    * Returns a list of application packages the robot have installed but
        are now available in an updated version.
        This list can be empty if the module has failed to download the
        list from the cloud (in case of error, or cloud disabled).

        :returns: a list of dictionnaries containing the application
        packages info.
    * 
    */
    public Future<List<Map<String, Object>>> getPackagesToUpdate() throws CallError, InterruptedException {
        return call("getPackagesToUpdate");
    }

    /**
    * (@asynchronous) Re-install the currently installed system image.
        The system image must have been downloaded first, using the function
        'downloadCurrentSystemImage'.
        Calling this function set the state 'workerSysImgState' to
        ('updating', '').

        :param factory_reset: set to True to perform a factory reset, or
          False to do a regular image upgrade.
        :returns: True if everything went fine, False overwise.
    * 
    */
    public Future<Boolean> installCurrentSystemImage(Boolean param1) throws CallError, InterruptedException {
        return call("installCurrentSystemImage", param1);
    }

    /**
    * (@asynchronous) Install the newest available system image if there
        is one available. The system image must have been downloaded first,
        using the function 'downloadNextSystemImage'.
        Calling this function set the state 'workerSysImgState' to
        ('updating', '').

        :param factory_reset: set to True to perform a factory reset, or
          False to do a regular image upgrade.
        :returns: True if everything went fine, False overwise.
    * 
    */
    public Future<Boolean> installNextSystemImage(Boolean param1) throws CallError, InterruptedException {
        return call("installNextSystemImage", param1);
    }

    }
}
    