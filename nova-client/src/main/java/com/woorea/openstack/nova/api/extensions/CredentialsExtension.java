package com.woorea.openstack.nova.api.extensions;

import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.nova.model.Certificate;

/**
 * @author Govindon.
 */
public class CredentialsExtension {

    /**
     * The instance of OpenStackClient access the CredentialsExtension class.
     */
    private final OpenStackClient CLIENT;

    /**
     * The instance is used to access the CredentialsExtension class.
     *
     * @param client the client to set
     */
    public CredentialsExtension(OpenStackClient client) {
        CLIENT = client;
    }

    /**
     *
     * @param id
     * @return
     */
    public Create createCertificate(String id) {
        return new Create(id);
    }

    /**
     * shows the certificate.
     *
     * @param id the id to set
     * @return the certificate
     */
    public Show showCertificate(String id) {
        return new Show();
    }

    /**
     * The class extends the Certificate class from the Nova Model.
     */
    public class Create extends OpenStackRequest<Certificate> {

        /**
         * Create the Certificate.
         *
         * @param id the id to set
         */
        public Create(String id) {
            super(CLIENT, HttpMethod.GET, new StringBuffer("/os-certificates")
                    .append(id).toString(), null, Certificate.class);
        }
    }

    /**
     * The class show extends the Certificate Class from the Nova Model.
     */
    public class Show extends OpenStackRequest<Certificate> {

        /**
         * Shows the certificate.
         */
        public Show() {
            super(CLIENT, HttpMethod.GET, "/os-certificates", null,
                    Certificate.class);
        }
    }
}
