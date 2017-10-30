package com.test.viper;

import android.app.Application;
import android.content.Context;

import com.test.viper.entity.Article;
import com.test.viper.entity.ArticleListProvider;
import com.test.viper.screen.fragment.ChannelPresenter;
import com.test.viper.screen.fragment.ContentPresenter;

import java.util.List;

import dagger.Module;
import dagger.Provides;

/**
 * Created by yi on 29/10/2017.
 */

@Module
public class AppModule {

    private final Application app;

    public AppModule(Application app) {
        this.app = app;
    }

    @Provides
    Context provideActivityContext() {
        return app.getApplicationContext();
    }

    @Provides
    ChannelPresenter provideChannelPresenter() {
        return new ChannelPresenter();
    }

    @Provides
    ContentPresenter provideContentPresenter() {
        return new ContentPresenter();
    }

    @Provides
    ArticleListProvider listProvider() {
        return new ArticleListProvider(app.getApplicationContext());
    }

    @Provides
    List<Article> provideList() {
        return new ArticleListProvider(app.getApplicationContext()).getArticleList();
    }

}
