package com.test.viper.screen.fragment;

import android.text.TextUtils;

import com.test.viper.entity.MobileChapter;
import com.test.viper.service.WebServiceProvider;
import com.test.viper.service.callback.NewsContentCallback;
import com.test.viper.service.response.NewsContentResponse;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by yi on 29/10/2017.
 */

public class ContentPresenter extends BasePresenter<ContentView> {

    private WebServiceProvider webServiceProvider;

    @Inject
    public ContentPresenter(WebServiceProvider webServiceProvider) {
        this.webServiceProvider = webServiceProvider;
    }

    public void getNewsContent(String id) {

        webServiceProvider.getNewsContent(id, new NewsContentCallback() {

            @Override
            public void onSuccess(NewsContentResponse newsContentResponse) {

                if (getView() != null) {

                    if (newsContentResponse.getVisual() != null && !TextUtils.isEmpty(newsContentResponse.getVisual().get(0).getUrlPattern()))
                        getView().setCoverVisual(newsContentResponse.getVisual().get(0).getUrlPattern().replace("{sizeName}", "641x427"));

                    if (newsContentResponse.getMobileChapters() != null)
                        formatContextBody(newsContentResponse.getMobileChapters());

                }

            }

            @Override
            public void onError() {
                //TODO
            }
        });


    }

    private void formatContextBody(List<MobileChapter> mobileChapters) {

        StringBuilder body = new StringBuilder();
        for (MobileChapter mobileChapter : mobileChapters)
            if (mobileChapter != null && !TextUtils.isEmpty(mobileChapter.getText()))
                body.append(mobileChapter.getText() + "\n");

        getView().setNewsContent(body.toString());
    }

}
