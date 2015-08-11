/* ------------------------------------------------------------------------------
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Copyright (C) Rococo Global Technologies, Inc - All Rights Reserved 2015
 * --------------------------------------------------------------------------- */
package sample.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * DTO used to store multiple tweets for
 * client side operations.
 * @author Peter Guisadio
 * @version 0.01
 * Version History
 * [05/07/2015] 0.01 – Peter Clark Guisadio – Initial codes.
 */
public class TwitterClientDto {

    /**
     * List of errors.
     */
    private List<String> errorList = new ArrayList<String>();

    /**
     * List of tweets.
     */
    private List<TwitterDto> tweetList = new ArrayList<TwitterDto>();

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
     * Retrieve tweetList.
     * @return the tweetList
     */
    public List<TwitterDto> getTweetList() {
        return tweetList;
    }

    /**
     * Set tweetList.
     * @param tweetList the tweetList to set
     */
    public void setTweetList(List<TwitterDto> tweetList) {
        this.tweetList = tweetList;
    }

}
