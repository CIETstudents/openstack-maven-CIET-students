package com.woorea.openstack.nova.api.extensions;

import java.util.HashMap;
import java.util.Map;

import com.woorea.openstack.base.client.Entity;
import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.nova.model.FloatingIp;
import com.woorea.openstack.nova.model.FloatingIps;

/**
 * @author Govindon.
 */
public class FloatingIpsExtension {

    /**
     * The instance is created for the OpenStackClient.
     */
    private final OpenStackClient CLIENT;

    /**
     * The instance is used to access the FloatingIpsExtension.
     *
     * @param client the client to set
     */
    public FloatingIpsExtension(OpenStackClient client) {
        CLIENT = client;
    }

    /**
     * The List class extends the FloatingIps from the Nova Model.
     */
    public class List extends OpenStackRequest<FloatingIps> {

        /**
         * GET the list.
         */
        public List() {
            super(CLIENT, HttpMethod.GET, "/os-floating-ips", null,
                    FloatingIps.class);
        }
    }

    /**
     * The class Allocate extends the FloatingIp from the Nova Model.
     */
    public class Allocate extends OpenStackRequest<FloatingIp> {

        /**
         * Allocates a new floating IP address to a tenant or account.
         *
         * @param entity the entity to set
         */
        public Allocate(Entity<?> entity) {
            super(CLIENT, HttpMethod.POST, "/os-floating-ips", entity,
                    FloatingIp.class);
        }
    }

    /**
     * The class Deallocate extends the OpenStackRequest.
     */
    public class Deallocate extends OpenStackRequest<Void> {

        /**
         * Deallocates floating IP address from a tenant or account.
         *
         * @param id
         */
        public Deallocate(String id) {
            super(CLIENT, HttpMethod.DELETE,
                    new StringBuffer("/os-floating-ips/").append(id).toString(),
                    null, Void.class);
        }
    }

    /**
     * @return the List
     */
    public List list() {
        return new List();
    }

    /**
     * Allocates a new floating IP address to a tenant or account.
     *
     * @param pool the pool to set
     * @return the entity
     */
    public Allocate allocate(String pool) {
        Entity< ?> entity = null;
        if (pool != null) {
            Map< String, String> body = new HashMap< String, String>();
            body.put("pool", pool);
            entity = Entity.json(body);
        }
        return new Allocate(entity);
    }

    /**
     * Deallocates a floating IP address from a tenant or account.
     *
     * @param id the id to set
     * @return the id
     */
    public Deallocate deallocate(String id) {
        return new Deallocate(id);
    }
}
