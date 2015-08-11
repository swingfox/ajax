/* ------------------------------------------------------------------------------
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Copyright (C) Rococo Global Technologies, Inc - All Rights Reserved 2015
 * --------------------------------------------------------------------------- */
package sample.controller.twitter;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

/**
* Initial Controller.
* @author Peter Clark Guisadio
* @author Nick Faelnar
* @version 0.02
* Version History
* [05/07/2015] 0.01 – Peter Clark Guisadio  – Initial codes.
* [05/07/2015] 0.02 – Nick Faelnar          – Removed codes for retrieving tweets.
*/
public class IndexController extends Controller {

    @Override
    public Navigation run() throws Exception {
        return forward("index.jsp");
    }
}
