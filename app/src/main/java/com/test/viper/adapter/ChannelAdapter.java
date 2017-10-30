package com.test.viper.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.test.viper.R;
import com.test.viper.bus.AppBus;
import com.test.viper.bus.event.ChannelEvent;
import com.test.viper.entity.Article;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yi on 29/10/2017.
 */

public class ChannelAdapter extends RecyclerView.Adapter<ChannelAdapter.ViewHolder> {

    private List<Article> displayList;
    private Context context;

    @Inject
    public ChannelAdapter(Context context, List<Article> displayList) {
        this.context = context;
        this.displayList = displayList;
    }

    public void populate(List<Article> list) {

        if (list == null) return;

        displayList.clear();
        displayList.addAll(list);
        notifyDataSetChanged();
    }

    public void reset() {
        displayList.clear();
        notifyDataSetChanged();
    }

    @Override
    public ChannelAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);

        ChannelAdapter.ViewHolder vh = new ChannelAdapter.ViewHolder(v);

        return vh;
    }


    @Override
    public void onBindViewHolder(ChannelAdapter.ViewHolder holder, int position) {
        holder.bind(displayList.get(position));
    }

    @Override
    public int getItemCount() {
        return displayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.channel)
        TextView channel;

        public ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }

        public void bind(Article article) {
            channel.setText("[" + article.getChannelName() + "] " + article.getTitle());
            channel.setOnClickListener(view -> {
                ChannelEvent channelEvent = new ChannelEvent(ChannelEvent.ChannelEventType.NEWS_CLICK);
                channelEvent.setId(article.getId());
                AppBus.getBus().post(channelEvent);
            });
        }
    }


}