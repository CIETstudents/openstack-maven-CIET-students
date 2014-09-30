package com.woorea.openstack.nova.api;

import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.nova.model.Extensions;

/**
 * @author govindon. The class ExtensionsResource.
 */
public class ExtensionsResource {

    /**
     * Instance is created for the OpenStackClient class.
     */
    private final OpenStackClient CLIENT;

    /**
     * The created instance is used to access the ExtensionsResource class.
     *
     * @param client the client to set
     */
    public ExtensionsResource(OpenStackClient client) {
        CLIENT = client;
    }

    /**
     * Instance is created for the List class.
     *
     * @param detail the detail to set
     * @return the List
     */
    public List list(boolean detail) {
        return new List(detail);
    }

    /**
     * The List class extends the Extensions Class from the Nova Model.
     */
    public class List extends OpenStackRequest<Extensions> {

        /**
         * GET the list of Extensions.
         *
         * @param detail the detail to set
         */
        public List(boolean detail) {
            super(CLIENT, HttpMethod.GET, detail ?
                    "extensions/detail" : "extensions", null, Extensions.class);
        }

    }

}
