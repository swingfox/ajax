/* ------------------------------------------------------------------------------
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Copyright (C) Rococo Global Technologies, Inc - All Rights Reserved 2015
 * --------------------------------------------------------------------------- */
package sample.dao;

import java.util.List;

import org.slim3.datastore.Datastore;

import sample.meta.TweetMeta;
import sample.model.Tweet;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Transaction;

/**
* Dao used to access the datastore for tweet transactions.s
* @author Peter Clark Guisadio
* @version 0.01
* Version History
* [05/07/2015] 0.01 – Peter Clark Guisadio – Initial codes.
*/
public class TwitterDao {

    /**
     * Method used to save a tweet.
     * @param tweetModel - tweet to be saved.
     * @return Boolean - true, if tweet is saved; otherwise, false.
     */
    public boolean saveTweet(Tweet tweetModel) {
        boolean result = true;

        try {
            Transaction tx = Datastore.beginTransaction();
            //Manually allocate key
            Key key = Datastore.allocateId(KeyFactory.createKey("Account", "Default"), "Tweet");
            tweetModel.setKey(key);
            tweetModel.setId(key.getId());
            Datastore.put(tweetModel);
            tx.commit();
        } catch (Exception e) {
            result = false;
        }

        return result;
    }

    /**
     * Method used to retrieve list of tweets.
     * @return List<Tweet> - list of tweets.
     */
    public List<Tweet> getAllTweets() {
        TweetMeta t = new TweetMeta();
        Key parentKey = KeyFactory.createKey("Account", "Default");
        return Datastore.query(t ,parentKey).asList();
    }

    /**
     * Method used to update a tweet.
     * @param tweetModel - tweet to save.
     * @return Boolean - true, if tweet is saved; otherwise, false.
     */
    public boolean updateTweet(Tweet tweetModel) {
        boolean result = true;
        TweetMeta tm = new TweetMeta();
        Query.Filter idFilter = new Query.FilterPredicate("id", FilterOperator.EQUAL, tweetModel.getId());

        try {
            Tweet originalTweetModel = Datastore.query(tm).filter(idFilter).asSingle();
            if (originalTweetModel != null) {
                originalTweetModel.setContent(tweetModel.getContent());
                originalTweetModel.setCreatedDate(tweetModel.getCreatedDate());
                Transaction tx = Datastore.beginTransaction();
                Datastore.put(originalTweetModel);
                tx.commit();
            } else {
                result = false;
            }
        } catch (Exception e) {
            result = false;
        }

        return result;
    }

    /**
     * Method used to delete a tweet.
     * @param tweetModel - tweet to delete.
     * @return Boolean - true, if tweet is saved; otherwise, false.
     */
    public boolean deleteTweet(Tweet tweetModel) {
        boolean result = true;
        TweetMeta tm = new TweetMeta();
        Query.Filter mainFilter = new Query.FilterPredicate("id", FilterOperator.EQUAL, tweetModel.getId());

        try {
            Tweet originalTweetModel = Datastore.query(tm).filter(mainFilter).asSingle();
            if (originalTweetModel != null) {
                Transaction tx = Datastore.beginTransaction();
                Datastore.delete(originalTweetModel.getKey());
                tx.commit();
            } else {
                result = false;
            }
        } catch (Exception e) {
            result = false;
        }

        return result;
    }
}
