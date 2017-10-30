package com.test.viper.utils;

import android.content.Context;

import com.test.viper.R;

import javax.inject.Inject;

public class LocationFormatter {

    private final Context context;
    private double LOWEST_LATITUDE_CANADA = 41.681389;

    @Inject
    public LocationFormatter(Context context) {
        this.context = context;
    }

    public String showLocation(double latitude, double longitude) {
        if (latitude >= LOWEST_LATITUDE_CANADA) {
            return context.getString(R.string.yourPosition, String.valueOf(latitude), String.valueOf(longitude));
        } else {
            return context.getString(R.string.error_locationNotSupported);
        }
    }

}
