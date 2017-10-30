package com.test.viper;

import android.app.Application;

import me.yokeyword.fragmentation.Fragmentation;

/**
 * Created by yi on 29/10/2017.
 */

public class App extends Application {
    private AppComponent component;

    public AppComponent getComponent() {
        return component;
    }
    @Override
    public void onCreate() {
        super.onCreate();

        Fragmentation.builder()
                .stackViewMode(Fragmentation.NONE)
                .debug(true)
                .install();

        component = DaggerAppComponent.builder().appModule(new AppModule(this)).build();

    }
}
