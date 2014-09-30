package com.woorea.openstack.glance.model;

import java.io.InputStream;

/**
 * The Image Download is to download the Image to Client.
 * @author Naresh
 */
public class ImageDownload {
    /**
     * The Image is to access the Image contains the Image details for Client.
     */
    private Image image;
    
    /**
     * The InputStream is to get the Image and gives the Image format.
     */
    private InputStream inputStream;

    /**
     * The getter and setter method for the uri.
     * @return the image which to download.
     */
    public Image getImage() {
        return image;
    }
    /**
     * @param image the image to set Image as Response.
     */ 
    public void setImage(Image image) {
        this.image = image;
    }

    /**
     * The getter and setter method for the InputStream.
     * @return the inputStream to give stream details of the Image.
     */
    public InputStream getInputStream() {
        return inputStream;
    }
    /**
     * @param inputStream the inputStream to set Response to Client.
     */
    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }
}