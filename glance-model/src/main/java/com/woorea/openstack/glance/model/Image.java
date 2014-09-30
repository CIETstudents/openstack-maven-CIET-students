package com.woorea.openstack.glance.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

/**
 * @author Naresh The Image Class is used make the Response for the Client
 * Request.
 */
@JsonRootName("image")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Image implements Serializable {

    /**
     * The Id is used to return the Image Id.
     */
    private String id;

    /**
     * The URI is to give the Images URL.
     */
    private String uri;

    /**
     * The Name is to give the name of the Image.
     */
    private String name;

    /**
     * The diskFormat is to give the format the disk. Example : "disk_format":
     * "vhd".
     */
    @JsonProperty("disk_format")
    private String diskFormat;

    /**
     * The container format is to give the format the disk. Example :
     * "container_format": "ovf".
     */
    @JsonProperty("container_format")
    private String containerFormat;

    /**
     * The Size is to give the size of the Image. 
     * Example : "size":"5368709120".
     */
    private Long size;

    /**
     * To give the virtualSize of the Image.
     */
    @JsonProperty("virtual_size")
    private Long virtualSize;

    /**
     * The CheckSum of the Image is an certificate of the Image.
     * Example : "checksum": "c2e5db72bd7fd153f53ede5da5a06de3".
     */
    private String checksum;

    /**
     * createdAt is the Date&Time of the Image.
     * Example : "created_at": "2010-02-03 09:34:01"
     */
    @JsonProperty("created_at")
    private Calendar createdAt;
    
    /**
     * updatedAt is an updated Information of the Image.
     * Example : "updated_at": "2010-02-03 09:34:01"
     */
    @JsonProperty("updated_at")
    private Calendar updatedAt;
    
    /**
     * deletedAt is a deleted detail of the Image.
     * Example : "deleted_at": ""
     */
    @JsonProperty("deleted_at")
    private Calendar deletedAt;
    
    /**
     * status of the Image is given to the Client.
     * Example : "status": "active".
     */
    private String status;
    
    /**
     * is_public gives the client whether the Image is Public or not.
     * Example : "is_public": true.
     */
    @JsonProperty("is_public")
    private boolean isPublic;
    
    /**
     * minRam gives the configuration need to access the Image.
     * Example : "min_ram": 256.
     */
    @JsonProperty("min_ram")
    private Integer minRam;
    
    /**
     * MinDisk is memory used to access the Image.
     * Example : "min_disk": 5.
     */
    @JsonProperty("min_disk")
    private Integer minDisk;
    
    /**
     * The owner attribute gives the detail of the ownership for the Image.
     */
    private String owner;
    
    /**
     * The isDeleted is used to know whether the image is deleted or Not.
     */
    @JsonProperty("deleted")
    private boolean isDeleted;
    
    /**
     * isProtected is used to know whether the image has Backup or Not.
     */
    @JsonProperty("protected")
    private boolean isProtected;
    
    /**
     * The properties is to know the Mapping style of the Image.
     */
    private Map<String, Object> properties;

    /**
     * The getter and setter method for the Id.
     * @return the id as given in Example.
     */
    public String getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * The getter and setter method for the uri.
     * @return the uri as given in Example.
     */
    public String getUri() {
        return uri;
    }
    /**
     * @param uri the uri to set path for the Image.
     */
    public void setUri(String uri) {
        this.uri = uri;
    }

    /**
     * The getter and setter methods for the Name.
     * @return the name for the Image.
     */
    public String getName() {
        return name;
    }
    /**
     * @param name the name to set as given in Example.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * The getter and setter methods for the DiskFormat.
     * @return the diskFormat of the Image as given in Example.
     */
    public String getDiskFormat() {
        return diskFormat;
    }
    /** 
     * @param diskFormat the diskFormat to set the Image Response.
     */
    public void setDiskFormat(String diskFormat) {
        this.diskFormat = diskFormat;
    }

    /**
     * The getter and setter methods for the containerFormat.
     * @return the containerFormat as given in Example.
     */
    public String getContainerFormat() {
        return containerFormat;
    }
    /**
     * @param containerFormat the containerFormat to set the Image Response.
     */
    public void setContainerFormat(String containerFormat) {
        this.containerFormat = containerFormat;
    }

    /**
     * The getter and setter methods for the Size.
     * @return the size of the Image as given in  Example.
     */
    public Long getSize() {
        return size;
    }
    /**
     * @param size the size to set the Image Response.
     */
    public void setSize(Long size) {
        this.size = size;
    }

    /**
     * The getter and setter methods for the VirtualSize.
     * @return the virtual size of the Image as given in Example.
     */
    public Long getVirtualSize() {
        return virtualSize;
    }
    /**
     * @param virtualSize the size of the Image as virtual size.
     */
    public void setVirtualSize(Long virtualSize) {
        this.virtualSize = virtualSize;
    }

    /**
     * The getter and setter methods for the checksum.
     * @return the checksum of the Image as given in Example.
     */
    public String getChecksum() {
        return checksum;
    }
    /**
     * @param checksum the checksum to set Response.
     */
    public void setChecksum(String checksum) {
        this.checksum = checksum;
    }

    /**
     * The getter and setter methods for the CreatedAt.
     * @return the createdAt of the Image as given in Example.
     */
    public Calendar getCreatedAt() {
        return createdAt;
    }
    /**
     * @param createdAt the createdAt to set Response.
     */
    public void setCreatedAt(Calendar createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * The getter and setter methods for the UpdateAt.
     * @return the updatedAt of the Image as given in Example.
     */
    public Calendar getUpdatedAt() {
        return updatedAt;
    }
    /**
     * @param updatedAt the updatedAt to set Response
     */
    public void setUpdatedAt(Calendar updatedAt) {
        this.updatedAt = updatedAt;
    }
    
    /**
     * The getter and setter methods for the DeletedAt.
     * @return the deletedAt of the Image as given in Example.
     */
    public Calendar getDeletedAt() {
        return deletedAt;
    }
    /**
     * @param deletedAt the deletedAt to set Response.
     */
    public void setDeletedAt(Calendar deletedAt) {
        this.deletedAt = deletedAt;
    }

    /**
     * The getter and setter methods for the Status.
     * @return the status of the Image as given in the Example.
     */
    public String getStatus() {
        return status;
    }
    /**
     * @param status the status to set Image Response.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * The getter and setter methods for the Status.
     * @return the isPublic of the Image as given in the Example.
     */
    public boolean isPublic() {
        return isPublic;
    }
    /**
     * @param isPublic the isPublic to set Image Response.
     */
    public void setPublic(boolean isPublic) {
        this.isPublic = isPublic;
    }

    /**
     * The getter and setter methods for the MinRam.
     * @return the minRam of the Image as given in the Example.
     */
    public Integer getMinRam() {
        return minRam;
    }
    /**
     * @param minRam the minRam to set Image Response.
     */
    public void setMinRam(Integer minRam) {
        this.minRam = minRam;
    }

    /**
     * The getter and setter methods for the MinDisk.
     * @return the minDisk of the Image as given in the Example.
     */
    public Integer getMinDisk() {
        return minDisk;
    }
    /**
     * @param minDisk the minDisk to set Image Response.
     */
    public void setMinDisk(Integer minDisk) {
        this.minDisk = minDisk;
    }

    /**
     * The getter and setter methods for the Owner.
     * @return the owner of the Image as given in the Example.
     */
    public String getOwner() {
        return owner;
    }
    /**
     * @param owner the owner to set Image Response.
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * The getter and setter methods for the isDeleted.
     * @return the isDeleted of the Image as given in the Example.
     */
    public boolean isDeleted() {
        return isDeleted;
    }
    /**
     * @param isDeleted the isDeleted to set Image Response.
     */
    public void setDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * The getter and setter methods for the isProtected.
     * @return the isProtected of the Image as given in the Example.
     */
    public boolean isProtected() {
        return isProtected;
    }
    /**
     * @param isProtected the isProtected to set Image Response.
     */
    public void setProtected(boolean isProtected) {
        this.isProtected = isProtected;
    }

    /**
     * The getter and setter methods for the Properties.
     * @return the properties of the Image as given in the Example.
     */
    public Map<String, Object> getProperties() {
        if (properties == null) {
            properties = new HashMap<String, Object>();
        }
        return properties;
    }

    /**
     * The toString method is write the Image Response.
     * @return Image as the Response which has above attributes.
     */
    @Override
    public String toString() {
        return "Image [id=" + id + ", uri=" + uri + ", name=" + name
                + ", diskFormat=" + diskFormat + ", containerFormat="
                + containerFormat + ", size=" + size + ", checksum=" + checksum
                + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
                + ", deletedAt=" + deletedAt + ", status=" + status
                + ", isPublic=" + isPublic + ", minRam=" + minRam
                + ", minDisk=" + minDisk + ", owner=" + owner + ", isDeleted="
                + isDeleted + ", isProtected=" + isProtected + ", properties="
                + properties + "]";
    }
}