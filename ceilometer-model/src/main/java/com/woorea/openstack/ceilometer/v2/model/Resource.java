package com.woorea.openstack.ceilometer.v2.model;

import java.util.Map;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * In Ceilometer model the resource class defines all the component details.
 * @author Krishna <krishna.it2329@gmail.com>
 */
public class Resource {
    //{"resource_id": "23b55841eedd41e99d5f3f32149ca086", "timestamp": "2013-03-03T15:19:00", "project_id": "23b55841eedd41e99d5f3f32149ca086", "user_id": null, "metadata": {}}
    
    /**
     * By this property it store all the resource information. 
     */
    @JsonProperty("resource_id")
    private String resource;
    /**
     * The information provided should be maintained by its time stamp
     * Which gives date, month, standard time and also updated time.
     */
    private String timestamp;

    /**
     * This property gets the user project details resource in Ceilometer Model.
     */
    @JsonProperty("project_id")
    private String project;

    /**
     * This property gets the user information resource to measure in Ceilometer.
     */
    @JsonProperty("user_id")
    private String user;

    /**
     * It stores data about the data of user and specifies a Map with map collections.
     */
    private Map<String, Object> metadata;

    /**
     * A method definition to know the meter resources and all volumes in Ceilometer.
     * @return what are the resources used in Ceilometer model.
     */
    public String getResource() {
        return resource;
    }

    /**
     * A method definition to get the users time stamp with its resources. 
     * @return the time of every run or every updated settings in the resource Ceilometer. 
     */
    public String getTimestamp() {
        return timestamp;
    }
    
    /**
     * A method definition to get the users project details.
     * @return users project name and details of user project in Ceilometer model.
     */
    public String getProject() {
        return project;
    }

    /**
     * A method definition to know the user_id who uses it.
     * @return how many users currently uses the meter. 
     */
    public String getUser() {
        return user;
    }

    /**
     * A method definition for detailed information about all data.
     * @return data of object about the data in string format.
     */
    public Map<String, Object> getMetadata() {
        return metadata;
    }
    
    /**
     * This method gives information about all the specified details on resource components. 
     * @return all the resource specification components in Ceilometer model.
     */
    @Override
    public String toString() {
        return "Resource [resource=" + resource + ", timestamp=" + timestamp
                                    + ", project=" + project + ", user=" + user + ", metadata="
                                    + metadata + "]";
    }
}
