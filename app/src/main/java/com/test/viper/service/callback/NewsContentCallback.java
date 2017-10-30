package com.test.viper.service.callback;

import com.test.viper.service.response.NewsContentResponse;

/**
 * Created by yi on 29/10/2017.
 */

public interface NewsContentCallback {

        void onSuccess(NewsContentResponse newsContentResponse);

        void onError();

}
