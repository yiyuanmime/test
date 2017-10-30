package com.test.viper;

import com.test.viper.screen.activity.NewsActivity;
import com.test.viper.screen.fragment.ChannelFragment;
import com.test.viper.screen.fragment.ContentFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by yi on 29/10/2017.
 */

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    void inject(ChannelFragment channelFragment);
    void inject(ContentFragment contentFragment);
    void inject(NewsActivity newsActivity);
}
