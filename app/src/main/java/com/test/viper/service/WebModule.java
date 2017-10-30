package com.test.viper.service;

import com.test.viper.BuildConfig;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by yi on 30/10/2017.
 */

@Module
public class WebModule {

    @Provides
    @Singleton
    WebServiceProvider provideWebService(Retrofit retrofit) {
        return new WebServiceProvider(retrofit);
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient.Builder builder) {
        return new Retrofit.Builder()
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BuildConfig.REST_SERVER_URL)
                .build();
    }

    @Provides
    @Singleton
    HttpLoggingInterceptor provideInterceptor() {
        return new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    @Provides
    @Singleton
    OkHttpClient.Builder provideOKHttp(HttpLoggingInterceptor logInterceptor) {
        return new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(logInterceptor);
    }

}
