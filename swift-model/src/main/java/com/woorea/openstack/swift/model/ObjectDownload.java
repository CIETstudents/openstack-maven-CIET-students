package com.woorea.openstack.swift.model;

import java.io.InputStream;

/**
 * This class shows object and input values from user.
 *
 * @author Mona.
 */
public class ObjectDownload {

    /**
     * object datatype is to store large amount data along with methods.
     */
    private Object object;

    /**
     * inputStream data type is to read byte based data.
     */
    private InputStream inputStream;

    /**
     * get space to store data from user.
     *
     * @return object.
     */
    public Object getObject() {
        return object;
    }

    /**
     * set space to store data already get from user.
     *
     * @param object as set
     */
    public void setObject(Object object) {
        this.object = object;
    }

    /**
     * Get byte based data from user.
     *
     * @return inputStream.
     */
    public InputStream getInputStream() {
        return inputStream;
    }

    /**
     * Set byte based data from user.
     *
     * @param inputStream as set.
     */
    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }
}
