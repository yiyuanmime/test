package com.test.viper.utils;

import android.content.res.Resources;
import android.widget.TextView;

import com.test.viper.R;

public class LocationFormatter {

    private final TextView textView;
    private final Resources resources;
    private double LOWEST_LATITUDE_CANADA = 41.681389;

    public LocationFormatter(TextView textView) {
        this.textView = textView;
        this.resources = textView.getResources();
    }

    public void showLocation(double latitude, double longitude) {
        if (latitude >= LOWEST_LATITUDE_CANADA) {
            textView.setText(resources.getString(R.string.yourPosition, String.valueOf(latitude), String.valueOf(longitude)));
        } else {
            textView.setText(resources.getString(R.string.error_locationNotSupported));
        }
    }

}
