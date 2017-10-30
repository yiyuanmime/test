package com.test.viper.service;

/**
 * Created by yi on 29/10/2017.
 */

public class WebServiceProvider {

    private static IWebService instance;

    public static IWebService getInstance() {

        if (instance == null)
            instance = new IWebServiceImpl();

        return instance;
    }

}

