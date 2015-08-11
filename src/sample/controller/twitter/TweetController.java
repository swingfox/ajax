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
* Controller used to tweet.
* @author Peter Clark Guisadio
* @version 0.01
* Version History
* [05/07/2015] 0.01 – Peter Clark Guisadio  – Initial codes.
*/
public class TweetController extends Controller {

    /**
     * The TwitterService to use.
     * Holds the method for adding a tweet.
     */
    private TwitterService service = new TwitterService();
    
    @Override
    public Navigation run() throws Exception {
        TwitterDto dto = new TwitterDto();
        JSONObject json = null;
        try {
            json = new JSONObject((String)this.requestScope("data"));

            dto.setContent(json.getString("content"));
            if ((dto.getContent() == null) || dto.getContent().isEmpty()) {
                dto.getErrorList().add("Content is required.. please supply a tweet");
            } else {
                dto = this.service.tweet(dto);
            }
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
