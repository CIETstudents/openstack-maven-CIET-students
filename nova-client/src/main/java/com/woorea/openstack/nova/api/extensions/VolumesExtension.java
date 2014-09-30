package com.woorea.openstack.nova.api.extensions;

import com.woorea.openstack.base.client.Entity;
import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.nova.model.Metadata;
import com.woorea.openstack.nova.model.Volume;
import com.woorea.openstack.nova.model.VolumeForCreate;
import com.woorea.openstack.nova.model.VolumeForImageCreate;
import com.woorea.openstack.nova.model.Volumes;

/**
 * @author Govindon.
 *
 * The VolumesExtension Class gives the Volume Extension to Extension Class.
 */
public class VolumesExtension {

    /**
     * The instance is created for the OpenStackClient class.
     */
    private final OpenStackClient CLIENT;

    /**
     * Constructor VolumesExtension uses the OpenStackClient Request from
     * Client.
     *
     * @param client gives the Request of the Client.
     */
    public VolumesExtension(OpenStackClient client) {
        CLIENT = client;
    }

    /**
     * @return the New List
     */
    public List list(boolean detail) {
        return new List(detail);
    }

    /**
     * The instance of VolumeForCreate class is used to access the Create class.
     *
     * @param volume gives the volume detail.
     * @return new flavor variable for create method.
     */
    public Create create(VolumeForCreate volume) {
        return new Create(volume);
    }

    /**
     * UploadToImage Class is used to give the Image to VolumeForImageCreate
     * Class.
     *
     * @param volumeForImage pass to the UploadToImage Method.
     * @return New Upload Image to the Method uploadToImage().
     */
    public UploadToImage uploadToImage(VolumeForImageCreate volumeForImage) {
        return new UploadToImage(volumeForImage);
    }

    /**
     * Method Show for VolumesExtension Class and pass the id value.
     *
     * @param id gives id of Client.
     * @return Shows new id value.
     */
    public Show show(String id) {
        return new Show(id);
    }

    /**
     * Method showMetadata for VolumesExtension Class and pass the id value.
     *
     * @param id gives id of Client.
     * @return MetaData as new id value.
     */
    public ShowMetadata showMetadata(String id) {
        return new ShowMetadata(id);
    }

    /**
     * Method Delete for VolumesExtension Class and pass the id value.
     *
     * @param id gives id of Client.
     * @return deleted id value.
     */
    public Delete delete(String id) {
        return new Delete(id);
    }

    /**
     * Class list inherits the OpenStackRequest given by the Client and pass to
     * the VolumeExtension Class.
     */
    public class List extends OpenStackRequest< Volumes> {

        /**
         * Parameterized Constructor for the list Class and return type of
         * boolean.
         *
         * @param detail gives the Volumes detail.
         */
        public List(boolean detail) {
            super(CLIENT, HttpMethod.GET, detail ? "/os-volumes/detail"
                    : "/os-volumes", null, Volumes.class);
        }
    }

    /**
     * Class Create inherits the OpenStackRequest given by the Client and pass
     * to the Volume Class.
     */
    public class Create extends OpenStackRequest<Volume> {

        /**
         * Instance of VolumeForCreate class is used to access the Create
         * method.
         *
         * @param volume the volume to set
         */
        public Create(VolumeForCreate volume) {
            super(CLIENT, HttpMethod.POST, "/os-volumes", Entity.json(volume),
                    Volume.class);
            // this.volume = volume;
        }
    }

    /**
     * The class UploadToImage class extend the OpenStackRequest class
     * Upload volume to image service as image and uses the HTTP Post().
     */
    public class UploadToImage extends OpenStackRequest<Void> {

        /**
         * Constructor UploadToImage Method used to give the Image to
         * VolumeForImageCreate Class.
         *
         * @param volumeForImageCreate the volumeForImageCreate to set
         */
        public UploadToImage(VolumeForImageCreate volumeForImageCreate) {
            super(CLIENT, HttpMethod.POST, new StringBuilder("/volumes/")
                    .append(volumeForImageCreate.getVolumeId() + "/action"),
                    Entity.json(volumeForImageCreate), Void.class);
        }
    }

    /**
     * Class Show inherits the OpenStackRequest given by the Client and pass to
     * the VolumesExtension Class.
     */
    public class Show extends OpenStackRequest<Volume> {

        /**
         * Method Show is used to show the id value of the Client, it is
         * Constructor and depends on the Base Class.
         *
         * @param id the id to set
         */
        public Show(String id) {
            super(CLIENT, HttpMethod.GET, new StringBuilder("/os-volumes/")
                    .append(id).toString(), null, Volume.class);
        }
    }

    /**
     * Class ShowMetadata inherits the OpenStackRequest given by the Client and
     * has the Metadata information.
     */
    public class ShowMetadata extends OpenStackRequest<Metadata> {

        /**
         * Constructor method of ShowMetadata and depends on the Base Class.
         *
         * @param id gives the Client Id.
         */
        public ShowMetadata(String id) {
            super(CLIENT, HttpMethod.GET, new StringBuilder("/os-volumes/")
                    .append(id).append("/metadata").toString(), null,
                    Metadata.class);
        }
    }

    /**
     * Class Delete inherits the OpenStackRequest given by the Client and
     * deletes the Request given by the Client.
     */
    public class Delete extends OpenStackRequest<Void> {

        /**
         * Constructor method of Delete and Calls the HttpMethod of Delete.
         *
         * @param id the id to set
         */
        public Delete(String id) {
            super(CLIENT, HttpMethod.DELETE, new StringBuilder("/os-volumes/")
                    .append(id).toString(), null, Void.class);
        }
    }
}
