package com.woorea.openstack.nova.api;

import com.woorea.openstack.base.client.Entity;
import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.nova.model.Limits;
import com.woorea.openstack.nova.model.QuotaSet;
import com.woorea.openstack.nova.model.SimpleTenantUsage;

/**
 * @author govindon.
 *
 * The class QuotaSetsResource.
 */
public class QuotaSetsResource {

    /**
     * The instance is created for the OpenStackClient class.
     */
    private final OpenStackClient CLIENT;

    /**
     * The created instance is used to access the QuotaSetsResource class.
     *
     * @param client the client to set
     */
    public QuotaSetsResource(OpenStackClient client) {
        CLIENT = client;
    }

    /**
     * The instance is created for the ShowQuota class.
     *
     * @param tenantId the tenantId to set
     * @return the new tenantId
     */
    public ShowQuota showQuota(String tenantId) {
        return new ShowQuota(tenantId);
    }

    /**
     * The instance is created for the UpdateQuota class.
     *
     * @param tenantId the tenantId to set
     * @param quotaSet the quotaSet to set
     * @return the UpdateQuota
     */
    public UpdateQuota updateQuota(String tenantId, QuotaSet quotaSet) {
        return new UpdateQuota(tenantId, quotaSet);
    }

    /**
     * The instance is created for the ShowUsage class.
     *
     * @param tenantId the tenantId to set
     * @return the ShowUsage
     */
    public ShowUsage showUsage(String tenantId) {
        return new ShowUsage(tenantId);
    }

    /**
     * The instance is created for the ShowUsedLimits class.
     *
     * @return the ShowUsedLimits
     */
    public ShowUsedLimits showUsedLimits() {
        return new ShowUsedLimits();
    }

    /**
     * The class ShowQuota extends the QuotaSet class.
     */
    public class ShowQuota extends OpenStackRequest<QuotaSet> {

        /**
         * GET the tenantId.
         *
         * @param tenantId the tenantId to set
         */
        public ShowQuota(String tenantId) {
            super(CLIENT, HttpMethod.GET, new StringBuilder("/os-quota-sets/")
                    .append(tenantId), null, QuotaSet.class);
        }

    }

    /**
     * The class UpdateQuota extends the QuotaSet class from the Nova Model.
     */
    public class UpdateQuota extends OpenStackRequest<QuotaSet> {

        /**
         * PUT the tenantId and quotaSet.
         *
         * @param tenantId the tenantId to set
         * @param quotaSet the quotaSet to set
         */
        public UpdateQuota(String tenantId, QuotaSet quotaSet) {
            super(CLIENT, HttpMethod.PUT, new StringBuilder("/os-quota-sets/")
                    .append(tenantId), Entity.json(quotaSet), QuotaSet.class);
        }
    }

    /**
     * The class ShowUsage extends the SimpleTenantUsage class from the Nova
     * Model.
     */
    public class ShowUsage extends OpenStackRequest<SimpleTenantUsage> {

        /**
         * GET the tenantId.
         *
         * @param tenantId the tenantId to set
         */
        public ShowUsage(String tenantId) {
            super(CLIENT, HttpMethod.GET, new StringBuilder("/os-simple-tenant"
                    + "-usage/").append(tenantId), null,
                    SimpleTenantUsage.class);
        }
    }

    /**
     * The class ShowUsedLimits extends the Limits class from the Nova Model.
     */
    public class ShowUsedLimits extends OpenStackRequest< Limits> {

        /**
         * GET the limits.
         */
        public ShowUsedLimits() {
            super(CLIENT, HttpMethod.GET, new StringBuilder("/limits"), null,
                    Limits.class);
        }
    }
}
