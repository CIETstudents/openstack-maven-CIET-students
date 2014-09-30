package com.woorea.openstack.nova.api.extensions;

import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.nova.model.Host;
import com.woorea.openstack.nova.model.Hosts;

/**
 * @author Govindon.
 */
public class HostsExtension {

    /**
     * The instance is created for the OpenStackClient class to access the
     * HostsExtension.
     */
    private final OpenStackClient CLIENT;

    /**
     * @param client the client to set
     */
    public HostsExtension(OpenStackClient client) {
        CLIENT = client;
    }

    /**
     * @return the list
     */
    public List list() {
        return new List();
    }

    /**
     * Instance for Show class is created. Shows the list of Host identifier.
     *
     * @param id the id to set
     * @return the id
     */
    public Show show(String id) {
        return new Show(id);
    }

    /**
     * The class List extends the Hosts class from the Nova Model.
     */
    public class List extends OpenStackRequest<Hosts> {

        /**
         * GET the hosts.
         */
        public List() {
            super(CLIENT, HttpMethod.GET, "/os-hosts", null,
                    Hosts.class);
        }
    }

    /**
     * The class extends the Host class from the Nova Model.
     */
    public class Show extends OpenStackRequest<Host> {

        /**
         * @param id the id to set
         */
        public Show(String id) {
            super(CLIENT, HttpMethod.GET,
                    new StringBuffer("/os-hosts/").append(id)
                    .toString(), null, Host.class);
        }
    }
}
