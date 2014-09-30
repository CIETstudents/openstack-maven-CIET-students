package com.woorea.openstack.nova.api.extensions;

import com.woorea.openstack.base.client.Entity;
import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.nova.model.Cloudpipe;
import com.woorea.openstack.nova.model.Cloudpipes;

/**
 * @author Govindon.
 *
 * The class CloudpipesExtension list and create the cloudpipe.
 */
public class CloudpipesExtension {

    /**
     * Instance is created for the OpenStackClient class..
     */
    private final OpenStackClient CLIENT;

    /**
     * The instance of OpenStackClient access the CloudpipesExtension class.
     *
     * @param client the client to set
     */
    public CloudpipesExtension(OpenStackClient client) {
        CLIENT = client;
    }

    /**
     * @return the List
     */
    public List list() {
        return new List();
    }

    /**
     * Create the cloudpipe.
     *
     * @param cloudpipe the cloudpipe to set
     * @return the cloudpipe
     */
    public Create create(Cloudpipe cloudpipe) {
        return new Create(cloudpipe);
    }

    /**
     * The class extends the OpenStackRequest and uses the Cloudpipes from the
     * Nova Model.
     */
    public class List extends OpenStackRequest<Cloudpipes> {

        /**
         * GET the cloudpipes.
         */
        public List() {
            super(CLIENT, HttpMethod.GET, "/os-cloudpipes", null,
                    Cloudpipes.class);
        }
    }

    /**
     * The class Create extends the Cloudpipe from the Nova Model.
     */
    public class Create extends OpenStackRequest<Cloudpipe> {

        /**
         * Instance is created for the Cloudpipe class which is present in Nova
         * model for accessing the Nova client.
         */
        private final Cloudpipe cloudpipe;

        /**
         * Creating the Cloudpipe.
         *
         * @param cloudpipe the cloudpipe to set
         */
        public Create(Cloudpipe cloudpipe) {
            super(CLIENT, HttpMethod.POST, "/os-cloudpipes",
                    Entity.json(cloudpipe), Cloudpipe.class);
            this.cloudpipe = cloudpipe;
        }
    }
}
