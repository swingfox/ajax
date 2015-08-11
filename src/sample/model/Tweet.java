/* ------------------------------------------------------------------------------
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Copyright (C) Rococo Global Technologies, Inc - All Rights Reserved 2015
 * --------------------------------------------------------------------------- */
package sample.model;

import java.io.Serializable;
import java.util.Date;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;

import com.google.appengine.api.datastore.Key;

/**
 * Model used to represent a Tweet
 * @author Peter Guisadio
 * @version 0.01
 * Version History
 * [05/07/2015] 0.01 – Peter Clark Guisadio – Initial codes.
 */
@Model(schemaVersion = 1)
public class Tweet implements Serializable {

    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Tweet key.
     */
    @Attribute(primaryKey = true)
    private Key key;

    /**
     * Tweet version.
     */
    @Attribute(version = true)
    private Long version;

    /**
     * Tweet id.
     */
    private long id;

    /**
     * Tweet content.
     */
    private String content;

    /**
     * Tweet created date.
     */
    private String createdDate = new Date().toString();

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (prime * result) + ((key == null) ? 0 : key.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Tweet other = (Tweet) obj;
        if (key == null) {
            if (other.key != null) {
                return false;
            }
        } else if (!key.equals(other.key)) {
            return false;
        }
        return true;
    }

    /**
     * Retrieve key.
     * @return the key
     */
    public Key getKey() {
        return key;
    }

    /**
     * Set key.
     * @param key the key to set
     */
    public void setKey(Key key) {
        this.key = key;
    }

    /**
     * Retrieve version.
     * @return the version
     */
    public Long getVersion() {
        return version;
    }

    /**
     * Set version.
     * @param version the version to set
     */
    public void setVersion(Long version) {
        this.version = version;
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
