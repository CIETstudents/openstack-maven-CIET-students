package com.woorea.openstack.swift.model;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * This class is to store collected information.
 *
 * @author Mona.
 */
public class ObjectForUpload {

    /**
     * Use to map multiple group elements in to single group.
     */
    private String container;

    /**
     * Get user name.
     */
    private String name;

    /**
     * Map default object properties in the method.
     */
    private Map<String, java.lang.Object> properties;

    /**
     * InputStream is to read byte based data.
     */
    private InputStream inputStream;

    /**
     * use the method to add various elements.
     *
     * @return container.
     */
    public String getContainer() {
        return container;
    }

    /**
     * use the method to assign added values to added elements.
     *
     * @param container as set.
     */
    public void setContainer(String container) {
        this.container = container;
    }

    /**
     * pass user name.
     *
     * @return name.
     */
    public String getName() {
        return name;
    }

    /**
     * assign user name.
     *
     * @param name as set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Map properties values equal to null.
     *
     * @return properties.
     */
    public Map<String, java.lang.Object> getProperties() {
        if (properties == null) {
            properties = new HashMap<String, java.lang.Object>();
        }
        return properties;
    }

    /**
     * Pass date or time.
     *
     * @return inputStream.
     */
    public InputStream getInputStream() {
        return inputStream;
    }

    /**
     * Set date or time in the method.
     *
     * @param inputStream as set.
     */
    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }
}
