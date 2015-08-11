/* ------------------------------------------------------------------------------
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Copyright (C) Rococo Global Technologies, Inc - All Rights Reserved 2015
 * --------------------------------------------------------------------------- */
package sample.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * DTO used to store a single tweet for
 * client side operations.
 * @author Peter Guisadio
 * @version 0.01
 * Version History
 * [05/07/2015] 0.01 – Peter Clark Guisadio – Initial codes.
 */
public class TwitterDto {

    /**
     * List of errors.
     */
    private List<String> errorList = new ArrayList<String>();

    /**
     * Tweet id.
     */
    private long id;

    /**
     * Tweet content.
     */
    private String content;

    /**
     * Tweet creation date.
     */
    private String createdDate = new Date().toString();

    /**
     * Retrieve errorList.
     * @return the errorList
     */
    public List<String> getErrorList() {
        return errorList;
    }

    /**
     * Set errorList.
     * @param errorList the errorList to set
     */
    public void setErrorList(List<String> errorList) {
        this.errorList = errorList;
    }

    /**
     * Retrieve id.
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * Set id.
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Retrieve content.
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * Set content.
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Retrieve createdDate.
     * @return the createdDate
     */
    public String getCreatedDate() {
        return createdDate;
    }

    /**
     * Set createdDate.
     * @param createdDate the createdDate to set
     */
    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

}
