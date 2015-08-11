/* ------------------------------------------------------------------------------
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Copyright (C) Rococo Global Technologies, Inc - All Rights Reserved 2015
 * --------------------------------------------------------------------------- */
package sample.controller.twitter;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.repackaged.org.json.JSONObject;

import sample.dto.TwitterDto;
import sample.service.TwitterService;

/**
* Controller used to delete a tweet.
* @author Nick Faelnar
* @version 0.01
* Version History
* [05/07/2015] 0.01 – Nick Faelnar – Initial codes.
*/
public class DeleteController extends Controller {

    /**
    * The TwitterService to use.
    * Holds the method for deleting a tweet.
    */
    TwitterService service = new TwitterService();

    @Override
    protected Navigation run() throws Exception {
        TwitterDto dto = new TwitterDto();
        JSONObject json = null;
        try {
            json = new JSONObject((String)this.requestScope("data"));

            dto.setId(json.getLong("id"));
            dto.setContent(json.getString("content"));
            dto.setCreatedDate(json.getString("createdDate"));
            dto = this.service.deleteTweet(dto);
        } catch (Exception e) {
            dto.getErrorList().add("Server controller error: " + e.getMessage());
            if (json == null) {
                json = new JSONObject();
            }
        }

        json.put("errorList", dto.getErrorList());
        response.setContentType("application/json");
        response.getWriter().write(json.toString());
        return null;
    }

}
