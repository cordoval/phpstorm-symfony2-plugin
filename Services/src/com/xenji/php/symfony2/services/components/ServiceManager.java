package com.xenji.php.symfony2.services.components;

import com.xenji.php.symfony2.services.entity.Service;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Mario
 * Date: 03/06/12
 * Time: 08:59
 * To change this template use File | Settings | File Templates.
 */
public class ServiceManager {

    /**
     * Maps from service id to the service object.
     * Duplicate service IDs will throw an exception, but
     * functionality will be given anyway. We'll take the first
     * service found as the one.
     */
    private Map<String, Service> serviceMap;

    private static ServiceManager instance;

    public static ServiceManager getInstance() {
        if (instance == null) {
            instance = new ServiceManager();
        }
        return instance;
    }

    private ServiceManager() {
    }


    public void addService(Service service) {

    }
}
