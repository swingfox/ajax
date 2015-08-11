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
* Controller used to update a tweet.
* @author Peter Clark Guisadio
* @version 0.01
* Version History
* [05/07/2015] 0.01 – Peter Clark Guisadio  – Initial codes.
*/
public class UpdateController extends Controller {

    /**
     * The TwitterService to use.
     * Holds the method for updating a tweet.
     */
    TwitterService service = new TwitterService();
    
    @Override
    protected Navigation run() throws Exception {
        //TODO: Code controller code for updating tweet. hint: refer to DeleteController.java for guidance.
        //TODO: (optional) IF content is not supplied or is blank add an error to the errorList in the dto object and bypass service call for updating a tweet.
        TwitterDto dto = new TwitterDto();
        JSONObject json = null;
        try {
            json = new JSONObject((String)this.requestScope("data"));

            dto.setId(json.getLong("id"));
            dto.setContent(json.getString("content"));
            dto.setCreatedDate(json.getString("createdDate"));
            if ((dto.getContent() == null) || dto.getContent().isEmpty()) {
                dto.getErrorList().add("Content is required.. please supply a tweet");
            } else {
                dto = this.service.updateTweet(dto);
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
