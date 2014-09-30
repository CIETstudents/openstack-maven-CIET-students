package com.woorea.openstack.nova.api.extensions;

import com.woorea.openstack.base.client.Entity;
import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.nova.model.Network;
import com.woorea.openstack.nova.model.Networks;

/**
 * @author govindon.
 *
 * The class NetworksExtension is the extension for the Networks class.
 */
public class NetworksExtension {

    /**
     * The instance is created for the OpenStackClient.
     */
    private final OpenStackClient CLIENT;

    /**
     * The created instance is used to access the NetworksExtension.
     *
     * @param client the client to set
     */
    public NetworksExtension(OpenStackClient client) {
        CLIENT = client;
    }

    /**
     * @return the list
     */
    public List list() {
        return new List();
    }

    /**
     * The instance is created for the Show class and displays the identifier.
     *
     * @param id the id to set
     * @return the id
     */
    public Show show(String id) {
        return new Show(id);
    }

    /**
     * The instance is created for the Delete class and displays the identifier.
     *
     * @param id the id to set
     * @return the id
     */
    public Delete delete(String id) {
        return new Delete(id);
    }

    /**
     * The instance is created for the Disassociate class and displays the id by
     * accessing the instance.
     *
     * @param id the id to set
     * @return the disassociated id
     */
    public Disassociate disassociate(String id) {
        return new Disassociate(id);
    }

    /**
     * The class List extends the Networks class from the Nova Model.
     *
     * List networks for the specified tenant.
     */
    public class List extends OpenStackRequest<Networks> {

        /**
         * Get the List.
         */
        public List() {
            super(CLIENT, HttpMethod.GET, "/os-networks", null, Networks.class);
        }
    }

    /**
     * The create class extends the Network class from the Nova Model.
     */
    public class Create extends OpenStackRequest<Network> {

        /**
         * The instance is created for the Network class.
         */
        private final Network network;

        /**
         * The created instance is used to access the Create class.
         *
         * @param network the network to set
         */
        public Create(Network network) {
            super(CLIENT, HttpMethod.POST, "/os-networks", Entity.json(network),
                    Network.class);
            this.network = network;
        }
    }

    /**
     * The Show class extends the Network class from the Nova Model.
     */
    public class Show extends OpenStackRequest<Network> {

        /**
         * Shows the list of identifier.
         *
         * @param id the id to set
         */
        public Show(String id) {
            super(CLIENT, HttpMethod.GET, new StringBuilder("/os-networks/")
                    .append(id).toString(), null, Network.class);
        }
    }

    /**
     * The Disassociate class extends the OpenStackRequest class.
     */
    public class Disassociate extends OpenStackRequest<Void> {

        /**
         * List the Disassociated id.
         *
         * @param id the id to set
         */
        public Disassociate(String id) {
            super(CLIENT, HttpMethod.POST,
                    new StringBuilder("/os-networks/").append(id).toString(),
                    Entity.json("{\"action\":\"disassociate\"}"), Void.class);

        }
    }

    /**
     * The class Delete extends the OpenStackRequest class.
     */
    public class Delete extends OpenStackRequest<Void> {

        /**
         * List the id after deletion.
         *
         * @param id the id to set
         */
        public Delete(String id) {
            super(CLIENT, HttpMethod.DELETE,
                    new StringBuilder("/os-networks/").append(id).toString(),
                    null, Void.class);
        }
    }
}
