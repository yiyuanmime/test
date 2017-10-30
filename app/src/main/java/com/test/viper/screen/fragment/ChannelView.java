package com.test.viper.screen.fragment;

import com.test.viper.entity.Article;

import java.util.List;

/**
 * Created by yi on 29/10/2017.
 */

public interface ChannelView {

    void setError();

    void setSortedList(List<Article> articleList);

    void updateToolbar(int t);
}
