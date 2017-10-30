package com.test.viper.screen.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.squareup.otto.Subscribe;
import com.test.viper.R;
import com.test.viper.bus.AppBus;
import com.test.viper.bus.event.ChannelEvent;
import com.test.viper.screen.fragment.ChannelFragment;
import com.test.viper.screen.fragment.ContentFragment;

/**
 * Created by yi on 29/10/2017.
 */

public class NewsActivity extends LocatedActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_activity);
        if (findFragment(ChannelFragment.class) == null) {
            loadRootFragment(R.id.listContainer, ChannelFragment.newInstance());
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        AppBus.registerContext(this);
    }

    @Override
    public void onPause() {
        AppBus.unRegisterContext(this);
        super.onPause();
    }

    @Subscribe
    public void onChannelEvent(final ChannelEvent event) {
        switch (event.getmEventType()) {

            case NEWS_CLICK:
                if (isTablet())
                    loadRootFragment(R.id.contentContainer, ContentFragment.newInstance(event.getId()), false, false);
                else
                    start(ContentFragment.newInstance(event.getId()));
                break;

        }

    }

    private boolean isTablet() {
        boolean tabletSize = getResources().getBoolean(R.bool.isTablet);
        return tabletSize ? true : false;
    }

}
