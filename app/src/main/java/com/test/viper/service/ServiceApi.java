package com.test.viper.service;

import com.test.viper.service.response.NewsContentResponse;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by yi on 29/10/2017.
 */

public interface ServiceApi {

    @GET("article/detail/{id}")
    Observable<Response<NewsContentResponse>> getNewsContent(@Path("id") String id,
                                                             @Query("v") String v,
                                                             @Query("os") String os);

}
