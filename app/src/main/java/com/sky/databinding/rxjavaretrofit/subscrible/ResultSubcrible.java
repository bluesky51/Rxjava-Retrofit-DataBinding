package com.sky.databinding.rxjavaretrofit.subscrible;

import com.sky.databinding.rxjavaretrofit.BR;
import com.sky.databinding.rxjavaretrofit.R;
import com.sky.databinding.rxjavaretrofit.adapter.MyAdapter;
import com.sky.databinding.rxjavaretrofit.bean.Album;
import com.sky.databinding.rxjavaretrofit.bean.Article;

import rx.Subscriber;

/**
 * Created by BlueSky on 16/11/14.
 */

public class ResultSubcrible<T> extends Subscriber<T> {

    private MyAdapter myAdapter;

    public ResultSubcrible(MyAdapter myAdapter) {
        this.myAdapter = myAdapter;
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onNext(T t) {
        if (t instanceof Album) {
            Album album = (Album) t;
            myAdapter.setContentData(album.getData(), R.layout.item_album, BR.album);

        } else if (t instanceof Article) {
            Article article = (Article) t;
            myAdapter.setContentData(article.getData(), R.layout.item_article, BR.article);

        }

    }
}