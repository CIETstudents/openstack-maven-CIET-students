package com.woorea.openstack.ceilometer.v2.model;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Ceilometer Model tells about how to measure usage of user resources with
 * ceilometer meter.
 * @author Krishna <krishna.it2329@gmail.com>
 */
public class Meter {

    /**
     * This property gets the user information to measure in Ceilometer.
     */
    @JsonProperty("user_id")
    /**
     * Here the meter feeds information about how many users by user_id.
     */
    private String user;
    /**
     * Here the meter feeds information about all the users by their names.
     */
    private String name;

    /**
     * By this property it stores all the resource information.
     */
    @JsonProperty("resource_id")
    /**
     * By this resource it makes the user to check the usage.
     */
    private String resource;

    /**
     * This property gets the user project details in Ceilometer Model.
     */
    @JsonProperty("project_id")
    /**
     * It stores the project title and versions used in this model.
     */
    private String project;
    /**
     * It tells the kind of project and counter Volumes used in Ceilometer.
     */
    private String type;
    /**
     * Makes the user to know how many units consumed.
     */
    private String unit;

    /**
     * A method definition to know the user_id who uses it.
     * @return how many users currently uses the meter.
     */
    public String getUser() {
        return user;
    }

    /**
     * A method definition to know the username who uses it.
     * @return which user is currently using the Ceilometer.
     */
    public String getName() {
        return name;
    }

    /**
     * A method definition to know the meter resources and all volumes in
     * Ceilometer.
     * @return what are the resources used in Ceilometer model.
     */
    public String getResource() {
        return resource;
    }

    /**
     * A method definition to get the users project details.
     * @return users project name and details of user project in Ceilometer
     * model.
     */
    public String getProject() {
        return project;
    }

    /**
     * A method definition to get the project type of the user.
     * @return the type of project user using it.
     */
    public String getType() {
        return type;
    }

    /**
     * A method definition to get number of units consumed by user.
     * @return the value of units consumed.
     */
    public String getUnit() {
        return unit;
    }

    /**
     * This method gives information about all the specified details in meter
     * components.
     * @return all the meter specification components in Ceilometer model.
     */
    @Override
    public String toString() {
        return "Meter [user=" + user + ", name=" + name + ", resource="
                + resource + ", project=" + project + ", type="
                + type + ", unit=" + unit + "]";
    }
}