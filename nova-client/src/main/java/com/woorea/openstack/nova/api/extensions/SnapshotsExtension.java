package com.woorea.openstack.nova.api.extensions;

import com.woorea.openstack.base.client.Entity;
import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.nova.model.Metadata;
import com.woorea.openstack.nova.model.Snapshot;
import com.woorea.openstack.nova.model.SnapshotForCreate;
import com.woorea.openstack.nova.model.Snapshots;

/**
 * @author govindon.
 *
 * The class SnapshotsExtension.
 */
public class SnapshotsExtension {

    /**
     * Instance is created for the OpenStackClient.
     */
    private final OpenStackClient CLIENT;

    /**
     * The created instance is used to access the SnapshotsExtensions class.
     *
     * @param client the client to set
     */
    public SnapshotsExtension(OpenStackClient client) {
        CLIENT = client;
    }

    /**
     * Ths instance is created for the List class.
     *
     * @param detail the detail to set
     * @return the List
     */
    public List list(boolean detail) {
        return new List(detail);
    }

    /**
     * The instance is created for the Create class.
     *
     * @param snapshotForCreate the snapshotForCreate to set
     * @return the Create
     */
    public Create create(SnapshotForCreate snapshotForCreate) {
        return new Create(snapshotForCreate);
    }

    /**
     * The instance is created for the Show class.
     *
     * @param id the id to set
     * @return the id
     */
    public Show show(String id) {
        return new Show(id);
    }

    /**
     * The instance is created for the ShowMetadata class.
     *
     * @param id the id to set
     * @return the id
     */
    public ShowMetadata showMetadata(String id) {
        return new ShowMetadata(id);
    }

    /**
     * The instance is created for the Delete class.
     *
     * @param id the id to set
     * @return the id
     */
    public Delete delete(String id) {
        return new Delete(id);
    }

    /**
     * The class List extends the Snapshots class from the Nova Model.
     */
    public class List extends OpenStackRequest<Snapshots> {

        /**
         * Get the detail.
         *
         * @param detail the detail to set
         */
        public List(boolean detail) {
            super(CLIENT, HttpMethod.GET, detail ? "/os-snapshots/detail"
                    : "/os-snapshots", null, Snapshots.class);
        }
    }

    /**
     * The class Create extends the SnapshotForCreate class from the Nova Model.
     */
    public class Create extends OpenStackRequest<SnapshotForCreate> {

        /**
         * Instance is created for the SnapshotForCreate class.
         */
        private final SnapshotForCreate snapshotForCreate;

        /**
         * The created instance is used to access the Create method.
         *
         * @param snapshotForCreate the snapshotForCreate to set
         */
        public Create(SnapshotForCreate snapshotForCreate) {
            super(CLIENT, HttpMethod.POST, "/os-snapshots",
                    Entity.json(snapshotForCreate), SnapshotForCreate.class);
            this.snapshotForCreate = snapshotForCreate;
        }
    }

    /**
     * The Show class extends the Snapshot class from the Nova Model.
     */
    public class Show extends OpenStackRequest<Snapshot> {

        /**
         * Get the id.
         *
         * @param id the id to set
         */
        public Show(String id) {
            super(CLIENT, HttpMethod.GET, new StringBuilder("/os-snapshots/")
                    .append(id).toString(), null, Snapshot.class);
        }
    }

    /**
     * The class ShowMetadata extends the Metadata from the Nova Model.
     */
    public class ShowMetadata extends OpenStackRequest<Metadata> {

        /**
         * Get the identifier and displays the id.
         *
         * @param id the id to set
         */
        public ShowMetadata(String id) {
            super(CLIENT, HttpMethod.GET, new StringBuilder("/os-snapshots/")
                    .append(id).append("/metadata").toString(),
                    null, Metadata.class);
        }
    }

    /**
     * The class Delete extend sthe OpenStackRequest class.
     */
    public class Delete extends OpenStackRequest<Void> {

        /**
         * Deletes the id.
         *
         * @param id the id to set
         */
        public Delete(String id) {
            super(CLIENT, HttpMethod.DELETE, new StringBuilder("/os-snapshots/")
                    .append(id).toString(), null, Void.class);
        }
    }
}
