package com.test.viper.bus.event;

/**
 * Created by yi on 29/10/2017.
 */

public class ChannelEvent {

    public static enum ChannelEventType {
        NEWS_CLICK
    }

    public ChannelEvent(ChannelEventType mEventType) {
        this.mEventType = mEventType;
    }

    private ChannelEvent.ChannelEventType mEventType;
    private String id;


    public ChannelEventType getmEventType() {
        return mEventType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
