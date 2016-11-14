package com.sky.databinding.rxjavaretrofit.http;

import com.sky.databinding.rxjavaretrofit.apiservice.GetInfoData;
import com.sky.databinding.rxjavaretrofit.bean.Album;
import com.sky.databinding.rxjavaretrofit.bean.Article;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by BlueSky on 16/11/14.
 */

public class HttpUtils {
    public static final String BASE_URL = "http://api.menghuoapp.com/";
    private static HttpUtils httpUtils = null;
    private  Retrofit retrofit;
    public static HttpUtils getHttpUtils() {
        if (httpUtils == null) {
            httpUtils = new HttpUtils();
        }
        return httpUtils;
    }

    public HttpUtils() {
         retrofit = new Retrofit.Builder()
                .baseUrl("http://api.menghuoapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

    }
   //

    /**
     * 下载萌物志中文章界面图片、标题的接口
     * @param subscriber
     * @param orider_dir
     * @param page_size
     * @param page
     * @param order_by
     */
    public void getArticleData(Subscriber<Article> subscriber, String orider_dir, String page_size, String page, String order_by){
        GetInfoData getInfoData = retrofit.create(GetInfoData.class);
        Observable<Article> infoCall = getInfoData.getArticleData(orider_dir, page_size,page, order_by);
        infoCall.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 下载萌物志中专辑界面标题和图片
     * @param subscriber
     * @param page_size
     * @param page
     */
    public void getAlbumData(Subscriber<Album> subscriber, String page_size, String page){
        GetInfoData getInfoData = retrofit.create(GetInfoData.class);
        Observable<Album> infoCall = getInfoData.getAlbumData(page_size,page);
        infoCall.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }


}
