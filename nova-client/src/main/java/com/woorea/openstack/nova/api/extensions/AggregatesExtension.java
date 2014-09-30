package com.woorea.openstack.nova.api.extensions;

import com.woorea.openstack.base.client.Entity;
import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.nova.model.HostAggregate;
import com.woorea.openstack.nova.model.HostAggregates;

/**
 * @author Govindon.
 *
 * The Aggregates Extension gives the Extension for the OpenStack Nova Client.
 */
public class AggregatesExtension {

    /**
     * Instance is created for the OpenStackClient class..
     */
    private final OpenStackClient CLIENT;

    /**
     * The instance of OpenStackClient access the AggregatesExtension class.
     *
     * @param client gives the Request of the Client.
     */
    public AggregatesExtension(OpenStackClient client) {
        CLIENT = client;
    }

    /**
     * @return the list.
     */
    public List list() {
        return new List();
    }

    /**
     * @param id the Client Id to set.
     * @return Id of ShowAggregate Class.
     */
    public ShowAggregate showAggregate(String id) {
        return new ShowAggregate(id);
    }

    /**
     * UpdateAggregateMetadata updates the Aggregate Metadata when the Client
     * gives OpenStack Client Request.
     *
     * @param id the Id to set.
     * @param name the name to set.
     * @param availabilityZone the availabilityZone to set.
     * @return the UpdateAggregateMetadata.
     */
    public UpdateAggregateMetadata updateAggregateMetadata(String id,
            String name, String availabilityZone) {
        return new UpdateAggregateMetadata(id, name, availabilityZone);
    }

    /**
     * The Method createAggregate creates Aggregate to the Client.
     *
     * @param aggregateName the aggregateName to set.
     * @param availabilityZoneName the availabilityZoneName to set.
     * @return the CreateAggregate.
     */
    public CreateAggregate createAggregate(String aggregateName,
            String availabilityZoneName) {
        return new CreateAggregate(aggregateName, availabilityZoneName);
    }

    /**
     * @param id the id to set.
     * @return the DeleteAggregate.
     */
    public DeleteAggregate deleteAggregate(String id) {
        return new DeleteAggregate(id);
    }

    /**
     * addHost method is used to add the host to the aggregate.
     *
     * @param aggregateId the aggregateId to set.
     * @param hostId the hostId to set.
     * @return the AddHost
     */
    public AddHost addHost(String aggregateId, String hostId) {
        return new AddHost(aggregateId, hostId);
    }

    /**
     * The removeHost method is used to remove the host from an aggregate.
     *
     * @param aggregateId the aggregateId to set.
     * @param hostId the hostId to set.
     * @return the RemoveHost
     */
    public RemoveHost removeHost(String aggregateId, String hostId) {
        return new RemoveHost(hostId, aggregateId);
    }

    /**
     * sets Metadata to an aggragate.
     *
     * @param aggregateId the aggregateId to set.
     * @param key the key to set.
     * @param value the value to set.
     * @return the SetMetadata
     */
    public SetMetadata setMetadata(String aggregateId,
            String key, String value) {
        return new SetMetadata(aggregateId, key, value);
    }

    /**
     * The class List extends the OpenStackRequest.
     *
     * Create and manage host aggregates. An aggregate assigns metadata to
     * groups of compute nodes. Aggregates are only visible to the cloud
     * provider.
     *
     */
    public class List extends OpenStackRequest<HostAggregates> {

        /**
         * Create and manage host aggregates. An aggregate assigns metadata to
         * groups of compute nodes. Aggregates are only visible to the cloud
         * provider.
         *
         * List all the aggregates.
         */
        public List() {
            super(CLIENT, HttpMethod.GET, "/os-aggregates",
                    null,
                    HostAggregates.class);
        }
    }

    /**
     * Shows all the aggregate.
     */
    public class ShowAggregate extends OpenStackRequest<HostAggregate> {

        /**
         * @param id the id to set
         */
        public ShowAggregate(String id) {
            super(CLIENT, HttpMethod.GET,
                    new StringBuffer("/os-aggregates/").append(id),
                    null,
                    HostAggregate.class);
        }
    }

    /**
     * Updates the name, and optionally the availability zone, for a specified
     * aggregate.
     */
    public class UpdateAggregateMetadata extends
            OpenStackRequest<HostAggregate> {

        /**
         * @param id the id to set
         * @param name the name to set
         * @param availabilityZone the availabilityZone to set
         */
        public UpdateAggregateMetadata(String id,
                String name, String availabilityZone) {
            super(CLIENT, HttpMethod.PUT,
                    new StringBuffer("/os-aggregates/").append(id),
                    availabilityZone == null
                            ? Entity.json("{\"aggregate\": {\"name\": \"" + name + "\" }}")
                            : Entity.json("{\"aggregate\": {\"name\": \""
                                    + name
                                    + "\", \"availability_zone\": \""
                                    + availabilityZone
                                    + "\" }}"),
                    HostAggregate.class);
        }
    }

    /**
     * Create an aggregate.
     */
    public class CreateAggregate extends OpenStackRequest<HostAggregate> {

        /**
         * Creates an aggregate.
         *
         * @param name the name to set
         * @param availabilityZone the availabilityZone to set
         */
        public CreateAggregate(String name, String availabilityZone) {
            super(CLIENT, HttpMethod.POST,
                    new StringBuffer("/os-aggregates"),
                    availabilityZone == null
                            ? Entity.json("{\"aggregate\": {\"name\": \""
                                    + name
                                    + "\", \"availability_zone\": null }}")
                            : Entity.json("{\"aggregate\": {\"name\": \""
                                    + name
                                    + "\", \"availability_zone\": \""
                                    + availabilityZone
                                    + "\" }}"),
                    HostAggregate.class);
        }
    }

    /**
     * Deletes the aggregate.
     */
    public class DeleteAggregate extends OpenStackRequest<Void> {

        /**
         * Deletes the aggregate.
         *
         * @param id the id to set
         */
        public DeleteAggregate(String id) {
            super(CLIENT, HttpMethod.DELETE,
                    new StringBuffer("/os-aggregates/").append(id),
                    null,
                    null);
        }
    }

    /**
     * Adding Host to the aggregate.
     */
    public class AddHost extends OpenStackRequest<HostAggregate> {

        /**
         * @param aggregateId the aggregateId to set
         * @param hostId the hostId to set
         */
        public AddHost(String aggregateId, String hostId) {
            super(CLIENT, HttpMethod.POST,
                    new StringBuffer("/os-aggregates/")
                    .append(aggregateId).append("/action"),
                    Entity.json("{\"add_host\": {\"host\": \""
                            + hostId + "\" }}"),
                    HostAggregate.class);
        }
    }

    /**
     * Remove the host from the aggregate.
     */
    public class RemoveHost extends OpenStackRequest<HostAggregate> {

        /**
         * @param hostId the hostId to set
         * @param aggregateId the aggregateId to set
         */
        public RemoveHost(String hostId, String aggregateId) {
            super(CLIENT, HttpMethod.POST,
                    new StringBuffer("/os-aggregates/")
                    .append(aggregateId).append("/action"),
                    Entity.json("{\"remove_host\": {\"host\": \""
                            + hostId + "\" }}"),
                    HostAggregate.class);
        }
    }

    /**
     * sets metadata to the aggregate.
     */
    public class SetMetadata extends OpenStackRequest<HostAggregate> {

        /**
         * @param aggregateId the aggregateId to set
         * @param key the key to set
         * @param value the value to set
         */
        public SetMetadata(String aggregateId, String key, String value) {
            super(CLIENT, HttpMethod.POST,
                    new StringBuffer("/os-aggregates/")
                    .append(aggregateId).append("/action"),
                    Entity.json("{\"set_metadata\": {\"metadata\": { \""
                            + key + "\": \"" + value + "\" }}}"),
                    HostAggregate.class);
        }
    }
}
