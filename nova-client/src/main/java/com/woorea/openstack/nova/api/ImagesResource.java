package com.woorea.openstack.nova.api;

import com.woorea.openstack.base.client.Entity;
import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.nova.model.Image;
import com.woorea.openstack.nova.model.Images;
import com.woorea.openstack.nova.model.Metadata;

/**
 * @author Govindon.
 *
 * Class ImagesResource for the Class OpenStackClient.
 */
public class ImagesResource {

    /**
     * The instance is created for the OpenStackClient class.
     */
    private final OpenStackClient CLIENT;

    /**
     * The created instance is used to access the ImagesResource class.
     *
     * Constructor which gives the Client Value.
     *
     * @param client of type OpenStackClient.
     */
    public ImagesResource(OpenStackClient client) {
        CLIENT = client;
    }

    /**
     * Instance is created for the List class.
     *
     * List Method which is of type boolean.
     *
     * @param detail returns the boolean value.
     *
     * @return detail in new list.
     */
    public List list(boolean detail) {
        return new List(detail);
    }

    /**
     * Instance is created for the Create class.
     *
     * Create Method of type Create which has parameter Image Class.
     *
     * @param image gives the Image to create New Image.
     * @return new Image which is Created.
     */
    public Create create(Image image) {
        return new Create(image);
    }

    /**
     * Instance is created for the Show class.
     *
     * Show Method of type Show which has parameter as Id.
     *
     * @param id gives the Id value.
     * @return Shows new Id value.
     */
    public Show show(String id) {
        return new Show(id);
    }

    /**
     * The instance is created for the ShowMetadata class.
     *
     * The Method showMetadata shows MetaData of the Client.
     *
     * @param id gives the Id value of Client.
     * @return New ShowMetadata with Id value.
     */
    public ShowMetadata showMetadata(String id) {
        return new ShowMetadata(id);
    }

    /**
     * The Instance is created for the Delete class.
     *
     * Method for Deleting the Client detail using Id value.
     *
     * @param id gives the Id value of Client.
     * @return New Id which is deleted.
     */
    public Delete delete(String id) {
        return new Delete(id);
    }

    /**
     * The class List extends the Images class from the Nova Model.
     */
    public class List extends OpenStackRequest<Images> {

        /**
         * Get the List.
         *
         * The Method List is of type boolean which gives the detail of Client.
         *
         * It depends on the base Class and Uses HttpMethod GET.
         *
         * @param detail gives the Client Detail.
         */
        public List(boolean detail) {
            super(CLIENT, HttpMethod.GET, detail ? "/images/detail" : "/images",
                    null, Images.class);
        }
    }

    /**
     * The class Create extends the Image class from the Nova Model.
     */
    public class Create extends OpenStackRequest<Image> {

        /**
         * The instance is created for the Image class.
         *
         * Private variable image of type Image.
         */
        private final Image image;

        /**
         * The created instance is used to access the Create class.
         *
         * Constructor Create creates Image, uses the HttpMethod POST and uses "
         * this " Pointer to point private variable.
         *
         * @param image the image to set
         */
        public Create(Image image) {
            super(CLIENT, HttpMethod.POST, "/images", Entity.json(image),
                    Image.class);
            this.image = image;
        }
    }

    /**
     * The class Show extends the Image class from the Nova Model.
     */
    public class Show extends OpenStackRequest<Image> {

        /**
         * Show Constructor gives the Client Id, depends on base Class and uses
         * HttpMethod GET.
         *
         * @param id the id to set
         */
        public Show(String id) {
            super(CLIENT, HttpMethod.GET, new StringBuilder("/images/")
                    .append(id).toString(), null, Image.class);
        }

    }

    /**
     * The class ShowMetadata extends the Metadata class from the Nova Model.
     */
    public class ShowMetadata extends OpenStackRequest<Metadata> {

        /**
         * Shows the Metadata.
         *
         * Constructor method of ShowMetadata and depends on the Base Class.
         *
         * @param id the id to set
         */
        public ShowMetadata(String id) {
            super(CLIENT, HttpMethod.GET, new StringBuilder("/images/")
                    .append(id).append("/metadata").toString(), null,
                    Metadata.class);
        }
    }

    /**
     * The class Delete extends the OpenStackRequest class.
     */
    public class Delete extends OpenStackRequest<Void> {

        /**
         * Delete the id.
         *
         * Constructor method of Delete and Calls the HttpMethod of Delete.
         *
         * @param id the id to set
         */
        public Delete(String id) {
            super(CLIENT, HttpMethod.DELETE, new StringBuilder("/images/")
                    .append(id).toString(), null, Void.class);
        }
    }
}
