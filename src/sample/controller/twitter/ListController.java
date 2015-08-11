/* ------------------------------------------------------------------------------
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Copyright (C) Rococo Global Technologies, Inc - All Rights Reserved 2015
 * --------------------------------------------------------------------------- */
package sample.controller.twitter;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.repackaged.org.json.JSONObject;

import sample.dto.TwitterClientDto;
import sample.service.TwitterService;

/**
* Controller used to delete a tweet.
* @author Nick Faelnar
* @version 0.01
* Version History
* [05/07/2015] 0.01 – Nick Faelnar – Initial codes.
*/
public class ListController extends Controller {

    /**
     * The TwitterService to use.
     * Holds the method for retrieving list of tweets.
     */
    TwitterService service = new TwitterService();

    @Override
    protected Navigation run() throws Exception {
        TwitterClientDto tweetList = new TwitterClientDto();
        JSONObject json = new JSONObject();

        try {
            tweetList = service.getTweetList();
        } catch (Exception e) {
            e.printStackTrace();
            tweetList.getErrorList().add("Server controller error: " + e.getMessage());
        }

        json.put("tweetList", tweetList.getTweetList());
        json.put("errorList", tweetList.getErrorList());
        response.setContentType("application/json");
        response.getWriter().write(json.toString());
        return null;
    }

}
