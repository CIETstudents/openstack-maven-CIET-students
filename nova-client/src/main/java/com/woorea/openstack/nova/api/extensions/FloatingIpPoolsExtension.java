package com.woorea.openstack.nova.api.extensions;

import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.nova.model.FloatingIpPools;

/**
 * @author Govindon.
 *
 * The Class FloatingIpPoolsExtension gives the IP Extension of the Client.
 */
public class FloatingIpPoolsExtension {

    /**
     * Instance is created for the OpenStackClient.
     */
    private final OpenStackClient CLIENT;

    /**
     * Constructor of Class FloatingIpPoolsExtension gives the OpenStack Client
     * Request to the Method.
     *
     * The instance is used to access the FloatingIpPoolsExtension.
     *
     * @param client returns the Client detail.
     */
    public FloatingIpPoolsExtension(OpenStackClient client) {
        CLIENT = client;
    }

    /**
     * The List method is used to give the list of Client's.
     *
     * @return the list
     */
    public List list() {
        return new List();
    }

    /**
     * The List Class inherits the OpenStackRequest which is used for FloatingIp
     * Pools in Nova Model.
     */
    public class List extends OpenStackRequest<FloatingIpPools> {

        /**
         * List method depends on the Base Class and access the HTTP Get().
         */
        public List() {
            super(CLIENT, HttpMethod.GET, "/os-floating-ip-pools",
                    null, FloatingIpPools.class);
        }
    }
}
