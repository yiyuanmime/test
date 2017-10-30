package com.test.viper.bus.event;

import android.location.Location;

/**
 * Created by yi on 30/10/2017.
 */

public class LocationEvent {

    public static enum LocationEventType {
        LOCATION_FOUND
    }

    public LocationEvent(LocationEvent.LocationEventType mEventType) {
        this.mEventType = mEventType;
    }

    private LocationEvent.LocationEventType mEventType;
    private Location location;

    public LocationEventType getmEventType() {
        return mEventType;
    }

    public void setmEventType(LocationEventType mEventType) {
        this.mEventType = mEventType;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
