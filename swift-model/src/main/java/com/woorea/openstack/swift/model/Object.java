package com.woorea.openstack.swift.model;

import java.io.Serializable;
import java.util.Calendar;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * This class shows a method to modify date and time in calendar.
 *
 * @author Mona.
 */
public class Object implements Serializable {

    /**
     * create a subdirectory to make search in efficient manner.
     */
    private String subdir;

    /**
     * enter the user name in to the sub directory.
     */
    private String name;

    /**
     * it is use to combine all the data values into the hash code.
     */
    private String hash;

    /**
     * bytes data type is to save space in the directory.
     */
    private int bytes;

    /**
     * content type is used to specify whether it is date or time.
     */
    @JsonProperty("content_type")
    private String contentType;

    /**
     * last changed time or date in the calendar.
     */
    @JsonProperty("last_modified")
    private Calendar lastModified;

    /**
     * @return the sub directory.
     */
    public String getSubdir() {
        return subdir;
    }

    /**
     * @param subdir the sub directory to set
     */
    public void setSubdir(String subdir) {
        this.subdir = subdir;
    }

    /**
     * @return the name of the user.
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the hash.
     */
    public String getHash() {
        return hash;
    }

    /**
     * @param hash the hash to set
     */
    public void setHash(String hash) {
        this.hash = hash;
    }

    /**
     * @return the bytes
     */
    public int getBytes() {
        return bytes;
    }

    /**
     * @param bytes the bytes to set
     */
    public void setBytes(int bytes) {
        this.bytes = bytes;
    }

    /**
     * @return the contentType
     */
    public String getContentType() {
        return contentType;
    }

    /**
     * @param contentType the contentType to set
     */
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    /**
     * @return the lastModified date or time in calendar.
     */
    public Calendar getLastModified() {
        return lastModified;
    }

    /**
     * @param lastModified the lastModified to set
     */
    public void setLastModified(Calendar lastModified) {
        this.lastModified = lastModified;
    }
}
