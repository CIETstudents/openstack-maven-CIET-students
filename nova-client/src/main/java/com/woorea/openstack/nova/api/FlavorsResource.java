package com.woorea.openstack.nova.api;

import com.woorea.openstack.base.client.Entity;
import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.nova.model.Flavor;
import com.woorea.openstack.nova.model.Flavors;
import com.woorea.openstack.nova.model.Metadata;

/**
 * @author Govindon.
 *
 * The class FlavorsResponse.
 */
public class FlavorsResource {

    /**
     * Instance is created for the OpenStackClient.
     */
    private final OpenStackClient CLIENT;

    /**
     * The created instance is used to access the FlavorsResponse class .
     * Parameterized Constructor which has parameter as Client.
     *
     * @param client gives the Client Request
     */
    public FlavorsResource(OpenStackClient client) {
        CLIENT = client;
    }

    /**
     * Instance is created for the List class.
     *
     * @param detail the detail to set
     * @return the list
     */
    public List list(boolean detail) {
        return new List(detail);
    }

    /**
     * Instance is created for the Create class. Instance is also created for
     * the Flavor class and access the Create class.
     *
     * @param flavor gives the flavor detail
     * @return new flavor variable for create method
     */
    public Create create(Flavor flavor) {
        return new Create(flavor);
    }

    /**
     * Instance is created for the Show class.
     *
     * @param id gives id of Client
     * @return Shows new id value
     */
    public Show show(String id) {
        return new Show(id);
    }

    /**
     * Instance is created for the ShowMetadata class.
     *
     * @param id gives id of Client
     * @return the MetaData id
     */
    public ShowMetadata showMetadata(String id) {
        return new ShowMetadata(id);
    }

    /**
     * Instance is created for the Delete class. Method Delete for Flavor Class
     * and pass the id value.
     *
     * @param id gives id of Client
     * @return deleted id value
     */
    public Delete delete(String id) {
        return new Delete(id);
    }

    /**
     * The class List extends the Flavors class.
     */
    public class List extends OpenStackRequest<Flavors> {

        /**
         * Parameterized Constructor for the list Class and return type of
         * boolean.
         *
         * @param detail the detail to set
         */
        public List(boolean detail) {
            super(CLIENT, HttpMethod.GET, detail ? "/flavors/detail"
                    : "/flavors", null, Flavors.class);
        }
    }

    /**
     * Class Create inherits the OpenStackRequest given by the Client and pass
     * to the Flavors Class.
     */
    public class Create extends OpenStackRequest<Flavor> {

        /**
         * The instance is created for the Flavor class.
         */
        private final Flavor flavor;

        /**
         * The created instance is used to access the Create class.
         *
         * Constructor for the Create Class and has the parameter of return type
         * Flavor and Calls the HttpMethod "POST".
         *
         * @param flavor to point the Flavor Class. flavor points to the "this"
         * pointer.
         */
        public Create(Flavor flavor) {
            super(CLIENT, HttpMethod.POST, "/flavors", Entity.json(flavor),
                    Flavor.class);
            this.flavor = flavor;
        }
    }

    /**
     * The class Show extends the Flavor class.
     */
    public class Show extends OpenStackRequest<Flavor> {

        /**
         * Method Show is used to show the id value of the Client, it is
         * Constructor and depends on the Base Class.
         *
         * @param id gives the Client Id.
         */
        public Show(String id) {
            super(CLIENT, HttpMethod.GET, new StringBuilder("/flavors/").
                    append(id).toString(), null, Flavor.class);
        }
    }

    /**
     * The class ShowMetadata extends the Metadata class from the Nova Model.
     */
    public class ShowMetadata extends OpenStackRequest<Metadata> {

        /**
         * Constructor method of ShowMetadata and depends on the Base Class.
         *
         * @param id gives the Client Id.
         */
        public ShowMetadata(String id) {
            super(CLIENT, HttpMethod.GET, new StringBuilder("/flavors/").
                    append(id).append("/metadata").toString(), null,
                    Metadata.class);
        }
    }

    /**
     * The class Delete extends the OpenStackRequest class.
     *
     * Class Delete inherits the OpenStackRequest given by the Client and
     * deletes the Request given by the Client.
     */
    public class Delete extends OpenStackRequest<Void> {

        /**
         * Constructor method of Delete and Calls the HttpMethod of Delete.
         *
         * @param id gives the Client Id.
         */
        public Delete(String id) {
            super(CLIENT, HttpMethod.DELETE, new StringBuilder("/flavors/").
                    append(id).toString(), null, Void.class);
        }
    }
}
