package com.test.viper.service;

import com.test.viper.service.callback.NewsContentCallback;

/**
 * Created by yi on 29/10/2017.
 */

public interface IWebService {

    void getNewsContent(String id, NewsContentCallback newsContentCallback);

}
