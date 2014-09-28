package com.woorea.openstack.swift.model;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * This container class contains all the storage components.
 * @author Krishna <krishna.it2329@gmail.com>
 */
public class Container implements Serializable {

    /**
     *It stores the container name of Swift model. 
     */
    private String name;

    /**
     *This property counts the container object.
     */
    @JsonProperty("count")
    private Integer objectCount;

    /**
     *This property stores the number of byted used in a container. 
     */
    @JsonProperty("bytes")
    private Long bytesUsed;

    /**
     * It gets the container name. 
     * @return the name.
     */
    public String getName() {
        return name;
    }

    /**
     * This method set the container name of a swift model.
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * It gets the container object details in Integer format.
     * @return the objectCount
     */
    public Integer getObjectCount() {
        return objectCount;
    }

    /**
     * The object details are set with countable.
     * @param objectCount the objectCount to set
     */
    public void setObjectCount(Integer objectCount) {
        this.objectCount = objectCount;
    }

    /**
     * Bytes used in container object in get using Long format.
     * @return the bytesUsed
     */
    public Long getBytesUsed() {
        return bytesUsed;
    }

    /**
     * It sets the bytes used details which in get using get method.
     * @param bytesUsed the bytesUsed to set
     */
    public void setBytesUsed(Long bytesUsed) {
        this.bytesUsed = bytesUsed;
    }

    /* This method produces all the desired  container details in String Format. 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Container [name=" + name + ", objectCount=" + objectCount
                + ", bytesUsed=" + bytesUsed + "]";
    }

}
