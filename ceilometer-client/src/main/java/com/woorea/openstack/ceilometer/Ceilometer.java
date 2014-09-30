package com.woorea.openstack.ceilometer;


import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackClientConnector;
import com.woorea.openstack.ceilometer.v2.api.MetersResource;
import com.woorea.openstack.ceilometer.v2.api.ResourcesResource;

/**
 * This class Ceilometer tells about how Meters and Resources of Ceilometer works.  
 * @author Mona
 */
public class Ceilometer extends OpenStackClient {
	
    /**
     * get values in Meters
     */    
    private final MetersResource METERS;
	
    /**
     * get values in Resources
     */
    private final ResourcesResource RESOURCES;
	
    /**
     * 
     * @param endpoint
     * @param connector 
     */
    public Ceilometer(String endpoint, OpenStackClientConnector connector) {
	super(endpoint, connector);
	METERS = new MetersResource(this);
	RESOURCES = new ResourcesResource(this);
    }
	
    /**
     * 
     * @param endpoint 
     */
    public Ceilometer(String endpoint) {
	this(endpoint, null);
    }
	
    /**
     * 
     * @return 
     */
    public ResourcesResource resources() {
	return RESOURCES;
    }
	
    /**
     * 
     * @return 
     */
    public MetersResource meters() {
	return METERS;
    }
}
