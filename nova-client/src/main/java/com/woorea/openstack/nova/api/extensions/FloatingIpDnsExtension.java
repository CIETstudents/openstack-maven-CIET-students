package com.woorea.openstack.nova.api.extensions;

import com.woorea.openstack.base.client.Entity;
import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.nova.model.FloatingIpDomain;
import com.woorea.openstack.nova.model.FloatingIpDomains;

/**
 * @author gopalans.
 *
 * The class FloatingIpDnsExtension is an extension for FloatingIpDns class.
 */
public class FloatingIpDnsExtension {

    /**
     * Instance is created for the OpenStackClient.
     */
    private final OpenStackClient CLIENT;

    /**
     * Instance is used to access the Float9ingIpDnsExtension class.
     *
     * @param client the client to set
     */
    public FloatingIpDnsExtension(OpenStackClient client) {
        CLIENT = client;
    }

    /**
     * List all the Domains.
     *
     * @return the List of domains.
     */
    public ListDomains listFloatingIpDomains() {
        return new ListDomains();
    }

    /**
     * Creating the Domain.
     *
     * @param floatingIpDomainthe floatingIpDomain to set
     * @return the created domain
     */
    public CreateDomain create(FloatingIpDomain floatingIpDomain) {
        return new CreateDomain(floatingIpDomain);
    }

    /**
     * Shows or displays the domain.
     *
     * @param id the id to set
     * @return the domain
     */
    public ShowDomain show(String id) {
        return new ShowDomain(id);
    }

    /**
     * Update the domain.
     *
     * @param floatingIpDomain the floatingIpDomain to set
     * @return the updated domains
     */
    public UpdateDomain update(FloatingIpDomain floatingIpDomain) {
        return new UpdateDomain(floatingIpDomain);
    }

    /**
     * Delete the domain.
     *
     * @param id the id to set
     * @return the domain
     */
    public DeleteDomain delete(String id) {
        return new DeleteDomain(id);
    }

    /**
     * The class ListDomains extends the FloatingIpDomains class from the Nova
     * Model.
     */
    public class ListDomains extends OpenStackRequest<FloatingIpDomains> {

        /**
         * List all the domains.
         */
        public ListDomains() {
            super(CLIENT, HttpMethod.GET, "/os-floating-ip-dns", null,
                    FloatingIpDomains.class);
        }

    }

    /**
     * The CreateDomain extends the FloatingIpDomain class from the Nova Model.
     */
    public class CreateDomain extends OpenStackRequest<FloatingIpDomain> {

        /**
         * The instance is created for the FloatingIpDomain class.
         */
        private FloatingIpDomain floatingIpDomain;

        /**
         * Create the domain.
         *
         * @param floatingIpDomain the floatingIpDomain to set
         */
        public CreateDomain(FloatingIpDomain floatingIpDomain) {
            super(CLIENT, HttpMethod.POST, "/os-floating-ip-dns",
                    Entity.json(floatingIpDomain), FloatingIpDomain.class);
            this.floatingIpDomain = floatingIpDomain;
        }

    }

    /**
     * Lists registered DNS domains published by the DNS driver.
     *
     * The ShowDomain extends the FloatingIpDomain class from the Nova Model.
     */
    public class ShowDomain extends OpenStackRequest<FloatingIpDomain> {

        /**
         * Displays the domains.
         *
         * @param id the id to set
         */
        public ShowDomain(String id) {
            super(CLIENT, HttpMethod.GET,
                    new StringBuffer("/os-floating-ip-dns/")
                    .append(id).toString(), null,
                    FloatingIpDomain.class);
        }

    }

    /**
     * The class UpdateDomain extends the FloatingIpDomain class from the nova
     * model.
     */
    public static class UpdateDomain extends
            OpenStackRequest<FloatingIpDomain> {

        /**
         * Instance is created for the FloatingIpDomain class.
         */
        private final FloatingIpDomain floatingIpDomain;

        /**
         * Instance is used to access the UpdateDomain class.
         *
         * @param floatingIpDomain the floatingIpDomain to set
         */
        public UpdateDomain(FloatingIpDomain floatingIpDomain) {
            //super(CLIENT, HttpMethod.PUT, new StringBuffer("/os-floating-ip-dns/").append(id).toString(), Entity.json(floatingIpDomain), FloatingIpDomain.class);
            this.floatingIpDomain = floatingIpDomain;
        }
    }

    /**
     * The DeleteDomain class extends the Void class.
     */
    public class DeleteDomain extends OpenStackRequest<Void> {

        /**
         * DeleteDomain is used to delete the domain.
         *
         * @param id the id to set
         */
        public DeleteDomain(String id) {
            super(CLIENT, HttpMethod.DELETE,
                    new StringBuffer("/os-floating-ip-dns/")
                    .append(id).toString(), null, Void.class);
        }
    }
}
