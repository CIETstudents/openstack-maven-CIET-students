package com.woorea.openstack.nova;

import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackClientConnector;
import com.woorea.openstack.nova.api.ExtensionsResource;
import com.woorea.openstack.nova.api.FlavorsResource;
import com.woorea.openstack.nova.api.ImagesResource;
import com.woorea.openstack.nova.api.QuotaSetsResource;
import com.woorea.openstack.nova.api.ServersResource;
import com.woorea.openstack.nova.api.extensions.AggregatesExtension;
import com.woorea.openstack.nova.api.extensions.FloatingIpsExtension;
import com.woorea.openstack.nova.api.extensions.KeyPairsExtension;
import com.woorea.openstack.nova.api.extensions.SecurityGroupsExtension;
import com.woorea.openstack.nova.api.extensions.SnapshotsExtension;
import com.woorea.openstack.nova.api.extensions.VolumesExtension;
import com.woorea.openstack.nova.api.extensions.HostsExtension;

/**
 * @author govindon.
 *
 * The class Nova extends the OpenStackClient class.
 */
public class Nova extends OpenStackClient {

    /**
     * The instance is created for the ExtensionResouce class.
     *
     * Lists Block Storage API extensions.
     */
    private final ExtensionsResource EXTENSIONS;
    /**
     * The instance is created for the ServersResource class.
     */
    private final ServersResource SERVERS;
    /**
     * The instance is created for the ImagesResource class.
     *
     * Lists information about all Image Service API versions.
     */
    private final ImagesResource IMAGES;
    /**
     * The instance is created for the FlavorsResource class.
     *
     * List available flavors and get details for a specified flavor.
     *
     * A flavor is a hardware configuration for a server. Each flavor is a
     * unique combination of disk space and memory capacity
     */
    private final FlavorsResource FLAVORS;
    /**
     * The instance is created for the KeyPairsExtension class.
     *
     * Lists keypairs that are associated with the account.
     */
    private final KeyPairsExtension KEY_PAIRS;
    /**
     * The instance is created for the FloatingIpsExtension class.
     *
     * Creates a floating IP, and, if you specify port information, associates
     * the floating IP with an internal port.
     */
    private final FloatingIpsExtension FLOATING_IPS;
    /**
     * The instance is created for the SecurityGroupsExtension class.
     *
     * Lists available SecurityGroup extensions.
     */
    private final SecurityGroupsExtension SECURITY_GROUPS;
    /**
     * The instance is created for the SnapshotsExtension class.
     *
     * A snapshot is a point in time copy of the data that a volume contains.
     */
    private final SnapshotsExtension SNAPSHOTS;
    /**
     * The instance is created for the VolumesExtension class.
     *
     * A volume is a detachable block storage device. You can think of it as a
     * USB hard drive. You can attach a volume to one instance at a time
     */
    private final VolumesExtension VOLUMES;
    /**
     * The instance is created for the AggregatesExtension class.
     *
     * Create and manage host aggregates. An aggregate assigns metadata to
     * groups of compute nodes. Aggregates are only visible to the cloud
     * provider.
     */
    private final AggregatesExtension AGGREGATES;
    /**
     * The instance is created for QuotaSetsResource class.
     *
     * Administrators only, depending on policy settings. View, update, and
     * delete quotas for a tenant
     */
    private final QuotaSetsResource QUOTA_SETS;
    /**
     * The instance is created for the HostsExtension class.
     *
     * List the Host.
     */
    private final HostsExtension HOSTS;

    /**
     * The instance of OpenStackClientConnector is used to access the Nova
     * class.
     *
     * @param endpoint the endpoint to set
     * @param connector the connector to set
     */
    public Nova(String endpoint, OpenStackClientConnector connector) {
        super(endpoint, connector);
        EXTENSIONS = new ExtensionsResource(this);
        SERVERS = new ServersResource(this);
        IMAGES = new ImagesResource(this);
        FLAVORS = new FlavorsResource(this);
        KEY_PAIRS = new KeyPairsExtension(this);
        FLOATING_IPS = new FloatingIpsExtension(this);
        SECURITY_GROUPS = new SecurityGroupsExtension(this);
        SNAPSHOTS = new SnapshotsExtension(this);
        VOLUMES = new VolumesExtension(this);
        AGGREGATES = new AggregatesExtension(this);
        QUOTA_SETS = new QuotaSetsResource(this);
        HOSTS = new HostsExtension(this);
    }

    /**
     * @param endpoint the endpoint to set
     */
    public Nova(String endpoint) {
        this(endpoint, null);
    }

    /**
     * @return the EXTENSIONS
     */
    public ExtensionsResource extensions() {
        return EXTENSIONS;
    }

    /**
     * @return the SERVERS
     */
    public ServersResource servers() {
        return SERVERS;
    }

    /**
     * @return the IMAGES
     */
    public ImagesResource images() {
        return IMAGES;
    }

    /**
     * @return the FLAVORS
     */
    public FlavorsResource flavors() {
        return FLAVORS;
    }

    /**
     * @return the KEY_PAIRS
     */
    public KeyPairsExtension keyPairs() {
        return KEY_PAIRS;
    }

    /**
     * @return the FLOATING_IPS
     */
    public FloatingIpsExtension floatingIps() {
        return FLOATING_IPS;
    }

    /**
     * @return the SECURITY_GROUPS
     */
    public SecurityGroupsExtension securityGroups() {
        return SECURITY_GROUPS;
    }

    /**
     * @return the SNAPSHOTS
     */
    public SnapshotsExtension snapshots() {
        return SNAPSHOTS;
    }

    /**
     * @return the VOLUMES
     */
    public VolumesExtension volumes() {
        return VOLUMES;
    }

    /**
     * @return the AGGREGATES
     */
    public AggregatesExtension aggregates() {
        return AGGREGATES;
    }

    /**
     * @return the QUOTA_SETS
     */
    public QuotaSetsResource quotaSets() {
        return QUOTA_SETS;
    }

    /**
     * @return the HOSTS
     */
    public HostsExtension hosts() {
        return HOSTS;
    }

}
