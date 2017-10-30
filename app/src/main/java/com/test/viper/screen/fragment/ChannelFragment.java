package com.test.viper.screen.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.squareup.otto.Subscribe;
import com.test.viper.App;
import com.test.viper.R;
import com.test.viper.adapter.ChannelAdapter;
import com.test.viper.bus.AppBus;
import com.test.viper.bus.event.LocationEvent;
import com.test.viper.entity.Article;
import com.test.viper.entity.ArticleListProvider;
import com.test.viper.utils.LocationFormatter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by yi on 29/10/2017.
 */

public class ChannelFragment extends SupportFragment implements ChannelView {

    @BindView(R.id.fab)
    FloatingActionButton mFab;

    @BindView(R.id.recy)
    RecyclerView mRecy;

    @BindView(R.id.location)
    TextView location;

    @Inject
    LocationFormatter locationFormatter;

    @Inject
    ChannelPresenter channelPresenter;

    @Inject
    ArticleListProvider articleListProvider;

    @Inject
    ChannelAdapter adapter;

    public static ChannelFragment newInstance() {
        Bundle args = new Bundle();
        ChannelFragment fragment = new ChannelFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.channel_fragment, container, false);
        ButterKnife.bind(this, view);

        AppBus.registerContext(this);
        ((App) getActivity().getApplication()).getComponent().inject(this);

        initView();

        channelPresenter.setView(this);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        channelPresenter.setView(null);
        AppBus.unRegisterContext(this);
    }

    private void initView() {
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(getString(R.string.title_channel_fragment));
        LinearLayoutManager manager = new LinearLayoutManager(_mActivity);
        mRecy.setLayoutManager(manager);
        mRecy.setAdapter(adapter);

        mFab.setOnClickListener(v -> channelPresenter.sortList(articleListProvider));
    }

    @Override
    public void setError() {

    }

    @Override
    public void setSortedList(List<Article> articleList) {
        adapter.populate(articleList);
    }

    @Override
    public void updateToolbar(int t) {
        switch (t) {
            case ArticleListProvider.CHANNEL_NAME:
                ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(getString(R.string.title_channel_fragment_sort_channel));
                break;
            case ArticleListProvider.DATE:
                ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(getString(R.string.title_channel_fragment_sort_date));
                break;
            default:
                ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(getString(R.string.title_channel_fragment));
                break;
        }
    }

    @Subscribe
    public void onLocationEvent(final LocationEvent event) {
        switch (event.getmEventType()) {

            case LOCATION_FOUND:
                if (event.getLocation() != null)
                    location.setText(locationFormatter.showLocation(event.getLocation().getLatitude(), event.getLocation().getLongitude()));
                break;

        }

    }

}
