package com.test.viper.service;

import com.test.viper.service.callback.NewsContentCallback;
import com.test.viper.service.task.GetNewsContentTask;

import javax.inject.Inject;

import retrofit2.Retrofit;

/**
 * Created by yi on 29/10/2017.
 */

public class WebServiceProvider implements IWebService {

    private Retrofit baseAdapter;

    @Inject
    public WebServiceProvider(Retrofit baseAdapter) {
        this.baseAdapter = baseAdapter;
    }

    @Override
    public void getNewsContent(String id, NewsContentCallback newsContentCallback) {
        GetNewsContentTask getWeatherTask = new GetNewsContentTask(baseAdapter, id, newsContentCallback);
        getWeatherTask.doTask();
    }
}
