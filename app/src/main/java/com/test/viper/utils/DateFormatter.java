package com.test.viper.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yi on 29/10/2017.
 */

public class DateFormatter {

    public static Date formatDate(String input) {
        //  format: "2013-05-08 05:35:57.000"
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        try {
            return format.parse(input);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return new Date();
    }

}
