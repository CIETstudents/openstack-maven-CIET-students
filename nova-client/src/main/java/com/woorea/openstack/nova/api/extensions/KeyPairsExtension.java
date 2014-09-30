package com.woorea.openstack.nova.api.extensions;

import com.woorea.openstack.base.client.Entity;
import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.nova.model.KeyPair;
import com.woorea.openstack.nova.model.KeyPairs;

/**
 * @author govindon.
 *
 * The class KeyPairsExtension.
 */
public class KeyPairsExtension {

    /**
     * The instance is created for the OpenStackClient class.
     */
    private final OpenStackClient CLIENT;

    /**
     * The instance is used to access the KeyPairsExtension class.
     *
     * @param client the client to set
     */
    public KeyPairsExtension(OpenStackClient client) {
        CLIENT = client;
    }

    /**
     * @return the list
     */
    public List list() {
        return new List();
    }

    /**
     * The instance is created for Create class which is used to access Create
     * class.
     *
     * @param name the name to set
     * @param publicKey the publicKey to set
     * @return the create
     */
    public Create create(String name, String publicKey) {
        KeyPair keyPairForCreate = new KeyPair(name, publicKey);
        return new Create(keyPairForCreate);
    }

    /**
     * The instance is created for Create class.
     *
     * @param name the name to set
     * @return the create
     */
    public Create create(String name) {
        return create(name, null);
    }

    /**
     * The instance is created for the Delete class and is used to access the
     * Class..
     *
     * @param name the name to set
     * @return the Deleted name.
     */
    public Delete delete(String name) {
        return new Delete(name);
    }

    /**
     * The class Create extends the KeyPair from the Nova Model.
     */
    public class Create extends OpenStackRequest<KeyPair> {

        /**
         * The instance is created for the KeyPair.
         */
        private final KeyPair keyPairForCreate;

        /**
         * The created instance is used to access to Create class.
         *
         * @param keyPairForCreate the KeyPairForCreate to set
         */
        public Create(KeyPair keyPairForCreate) {
            super(CLIENT, HttpMethod.POST, "/os-keypairs",
                    Entity.json(keyPairForCreate), KeyPair.class);
            this.keyPairForCreate = keyPairForCreate;
        }

    }

    /**
     * The class Delete extends the OpenStackRequest class.
     */
    public class Delete extends OpenStackRequest<Void> {

        /**
         * Name of the class Delete.
         */
        private String name;

        /**
         * Calls the Delete class.
         *
         * @param name the name to set
         */
        public Delete(String name) {
            super(CLIENT, HttpMethod.DELETE, new StringBuilder("/os-keypairs/")
                    .append(name).toString(), null, Void.class);
        }

    }

    /**
     * The class List extends the KeyPairs class from the Nova Model.
     */
    public class List extends OpenStackRequest< KeyPairs> {

        /**
         * GET the List.
         */
        public List() {
            super(CLIENT, HttpMethod.GET, "/os-keypairs", null, KeyPairs.class);
        }

    }

}
