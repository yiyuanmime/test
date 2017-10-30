package com.test.viper.screen.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.test.viper.App;
import com.test.viper.R;
import com.test.viper.utils.PicassoProvider;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by yi on 29/10/2017.
 */

public class ContentFragment extends SupportFragment implements ContentView{

    @BindView(R.id.img)
    ImageView img;

    @BindView(R.id.content)
    TextView content;

    @Inject
    ContentPresenter contentPresenter;

    public static ContentFragment newInstance(String id) {
        Bundle args = new Bundle();
        ContentFragment fragment = new ContentFragment();
        args.putString("id", id);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_fragment, container, false);
        ButterKnife.bind(this, view);

        ((App) getActivity().getApplication()).getComponent().inject(this);

        contentPresenter.setView(this);
        contentPresenter.getNewsContent(getArguments().getString("id"));

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(getString(R.string.title_content_fragment));

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        contentPresenter.setView(null);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(getString(R.string.title_channel_fragment));
    }

    @Override
    public void setError() {
        //TODO
    }

    @Override
    public void setCoverVisual(String url) {
        PicassoProvider.getInstance(getContext()).load(url).into(img);
    }

    @Override
    public void setNewsContent(String c) {
        Spanned cgu = Html.fromHtml(c);
        content.setText(cgu);
        content.setMovementMethod(LinkMovementMethod.getInstance());
    }

}
