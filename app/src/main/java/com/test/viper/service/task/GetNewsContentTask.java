package com.test.viper.service.task;

import com.test.viper.service.ServiceApi;
import com.test.viper.service.callback.NewsContentCallback;
import com.test.viper.service.response.NewsContentResponse;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.Subject;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by yi on 29/10/2017.
 */

public class GetNewsContentTask {

    private Retrofit r;
    private NewsContentCallback callback;
    private String id;

    public GetNewsContentTask(Retrofit r, String id, NewsContentCallback callback) {
        this.r = r;
        this.id = id;
        this.callback = callback;
    }

    public void doTask() {

        final ServiceApi serverApi = r.create(ServiceApi.class);
        serverApi.getNewsContent(id, "3.2", "android")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subject<Response<NewsContentResponse>>() {
                    @Override
                    public boolean hasObservers() {
                        return false;
                    }

                    @Override
                    public boolean hasThrowable() {
                        return false;
                    }

                    @Override
                    public boolean hasComplete() {
                        return false;
                    }

                    @Override
                    public Throwable getThrowable() {
                        return null;
                    }

                    @Override
                    protected void subscribeActual(Observer<? super Response<NewsContentResponse>> observer) {

                    }

                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                    }

                    @Override
                    public void onNext(@NonNull Response<NewsContentResponse> newsContentResponseResponse) {
                        if (newsContentResponseResponse != null && newsContentResponseResponse.isSuccessful())
                            callback.onSuccess(newsContentResponseResponse.body());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        callback.onError();
                    }

                    @Override
                    public void onComplete() {
                    }
                });

    }

}
