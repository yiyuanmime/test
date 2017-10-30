package com.test.viper.entity;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.test.viper.R;
import com.test.viper.utils.DateFormatter;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by yi on 29/10/2017.
 */

public class ArticleListProvider {

    public final static int NONE = 0;
    public final static int CHANNEL_NAME = 1;
    public final static int DATE = 2;

    private Context context;

    @Inject
    public ArticleListProvider(Context context) {
        this.context = context;
    }

    public List<Article> getArticleList() {

        try {
            final InputStream is = context.getResources().openRawResource(R.raw.articles);
            final BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            Type listType = new TypeToken<ArrayList<Article>>() {
            }.getType();
            return new Gson().fromJson(reader, listType);
        } catch (final Exception e) {
            throw new RuntimeException(e);
        }

    }

    public List<Article> sortList(int i) {

        List<Article> input = getArticleList();

        switch (i) {

            case CHANNEL_NAME:
                Collections.sort(input, this::compareChannelName);
                break;

            case DATE:
                Collections.sort(input, this::compareDate);
                break;

        }

        return input;

    }

    private int compareChannelName(Article a1, Article a2) {
        return a1.getChannelName().compareTo(a2.getChannelName());
    }

    private int compareDate(Article a1, Article a2) {
        Date d1 = DateFormatter.formatDate(a1.getPublicationDate());
        Date d2 = DateFormatter.formatDate(a2.getPublicationDate());
        return d1.compareTo(d2);
    }


}
