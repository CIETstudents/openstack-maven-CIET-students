package com.woorea.openstack.ceilometer.v2.model;

import java.util.Map;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * In Ceilometer model which defines all the sample component in Sample class.
 * @author Krishna <krishna.it2329@gmail.com>
 */
public class Sample {

    /**
     * This property gives each count type of user resource in Ceilometer model.
     */
    @JsonProperty("counter_type")
    private String counterType;

    /**
     * For each count of a user, counter name locates each type of the
     * Ceilometer model.
     */
    @JsonProperty("counter_name")
    private String counterName;

    /**
     * Every count the number of units produced that makes the users value of
     * units consumed.
     */
    @JsonProperty("counter_unit")
    private String counterUnit;

    /**
     * Total volume of consumption in counter meter values are stored.
     */
    @JsonProperty("counter_volume")
    private String counterVolume;

    /**
     * The counter volume has a source information at beginning of Ceilometer
     * model.
     */
    private String source;

    /**
     * This property gets the user project sample details in Sample Ceilometer
     * Model.
     */
    @JsonProperty("project_id")
    private String project;

    /**
     * This property gets the user information to measure in Sample Ceilometer
     * model.
     */
    @JsonProperty("user_id")
    private String user;

    /**
     * By this property it store all the resource information in Sample
     * Ceilometer model.
     */
    @JsonProperty("resource_id")
    private String resource;

    /**
     * The information provided should be maintained by its time stamp Which
     * gives date, month, standard time and also updated time.
     */
    private String timestamp;

    /**
     * For communication between user and meter a message id is given for each
     * message.
     */
    @JsonProperty("message_id")
    private String message;

    /**
     * It stores data about the data of resource and specifies a Map with map
     * collections.
     */
    @JsonProperty("resource_metadata")
    private Map<String, Object> metadata;

    /**
     * It gets all user resource counts of different types.
     *
     * @return type of counter values in the form of string.
     */
    public String getCounterType() {
        return counterType;
    }

    /**
     * For each count, counter name is provided to get the location of it.
     * @return name of the counter in string.
     */
    public String getCounterName() {
        return counterName;
    }

    /**
     * Gets the unit if consumption values of counter in the form of string to
     * ceilometer.
     * @return unit values of counter meter in string format.
     */
    public String getCounterUnit() {
        return counterUnit;
    }

    /**
     * It gets total volume used in counter details.
     * @return volume of counter from user to meter consumed in String.
     */
    public String getCounterVolume() {
        return counterVolume;
    }

    /**
     * This method gets the required source to run the meter in respected manner.
     * @return the obtained source from user.
     */
    public String getSource() {
        return source;
    }

    /**
     * A method definition to get the users project sample details.
     * @return users sample project name and details of user sample project in
     * Ceilometer model.
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
     * A method definition to know the meter resources and all volumes in
     * Ceilometer.
     * @return what are the resources used in Ceilometer model.
     */
    public String getResource() {
        return resource;
    }

    /**
     * A method definition to get the users time stamp with its resources.
     * @return the time of every run or every updated settings in the resource
     * Ceilometer.
     */
    public String getTimestamp() {
        return timestamp;
    }

    /**
     * It gets the message id and messages of user to communicate.
     * @return the message content to provide information to communicate in the
     * form of string.
     */
    public String getMessage() {
        return message;
    }

    /**
     * A method definition for detailed information about all data.
     * @return data of object about the data in string format.
     */
    public Map<String, Object> getMetadata() {
        return metadata;
    }
    
    /**
     * This method gives sample information about all the specified details of
     * Ceilometer.
     * @return all the Sample components in Ceilometer model.
     */
    @Override
    public String toString() {
        return "Sample [counterType=" + counterType + ", counterName="
                + counterName + ", counterUnit=" + counterUnit
                + ", counterVolume=" + counterVolume + ", source=" + source
                + ", project=" + project + ", user=" + user + ", resource="
                + resource + ", timestamp=" + timestamp + ", message="
                + message + ", metadata=" + metadata + "]";
    }
}
