package com.woorea.openstack.swift.model;

import java.io.Serializable;
/**
 * This class tells about how to maintain the Account detials of Client.
 * @author krishna <krishna.it2329@gmail.com>
 */
public class Account implements Serializable {

    /**
     * To count the contained data in Integer Format.
     */
    private Integer containerCount;

    /**
     * To count the contained Object in Integer format.
     */
    private Integer objectCount;

    /**
     * Counting accounts using Bytes in Inetger Format.
     */
    private Integer bytesUsed;

    /**
     * It gets the Account details of contained data.
     * @return the containerCount
     */
    public Integer getContainerCount() {
        return containerCount;
    }

    /**
     * This method sets the Account details in an container.
     * @param containerCount the containerCount to set the account.
     */
    public void setContainerCount(Integer containerCount) {
        this.containerCount = containerCount;
    }

    /**
     * It gets the contained object in Integer Format.
     * @return the objectCount
     */
    public Integer getObjectCount() {
        return objectCount;
    }

    /**
     * This method sets the each count of an object in an Account.
     * @param objectCount the objectCount to set
     */
    public void setObjectCount(Integer objectCount) {
        this.objectCount = objectCount;
    }

    /**
     * Get the used byte details of an account.
     * @return the bytesUsed
     */
    public Integer getBytesUsed() {
        return bytesUsed;
    }

    /**
     * It sets the number of bytes used in an Account.
     * @param bytesUsed the bytesUsed to set
     */
    public void setBytesUsed(Integer bytesUsed) {
        this.bytesUsed = bytesUsed;
    }

    /* To produce all the Account details in an String Format.
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Account [containerCount=" + containerCount + ", objectCount="
                + objectCount + ", bytesUsed=" + bytesUsed + "]";
    }

}
