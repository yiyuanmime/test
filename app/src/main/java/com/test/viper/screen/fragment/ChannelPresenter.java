package com.test.viper.screen.fragment;

import com.test.viper.entity.Article;
import com.test.viper.entity.ArticleListProvider;

import java.util.List;

/**
 * Created by yi on 29/10/2017.
 */

public class ChannelPresenter extends BasePresenter<ChannelView> {

    private int current_sort = ArticleListProvider.NONE;

    public void sortList(ArticleListProvider articleListProvider) {

        if (current_sort == ArticleListProvider.DATE)
            current_sort = ArticleListProvider.NONE;
        else
            current_sort += 1;

        List<Article> sortedList = articleListProvider.sortList(current_sort);
        getView().setSortedList(sortedList);
        getView().updateToolbar(current_sort);
    }

}
