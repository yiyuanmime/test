package com.test.viper.entity;

/**
 * Created by yi on 29/10/2017.
 */

public class Article {

    private String id;

    private String channelName;

    private String title;

    /**
     * format: "2013-05-08 05:35:57.000"
     */
    private String publicationDate;

    public String getId() {
        return id;
    }

    public String getChannelName() {
        return channelName;
    }

    public String getTitle() {
        return title;
    }

    public String getPublicationDate() {
        return publicationDate;
    }
}
