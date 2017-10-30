package com.test.viper.screen.fragment;

/**
 * Created by yi on 29/10/2017.
 */

public abstract class BasePresenter<View> {
    private View view;

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

}
