package com.sky.databinding.rxjavaretrofit.apiservice;

import com.sky.databinding.rxjavaretrofit.bean.Album;
import com.sky.databinding.rxjavaretrofit.bean.Article;

import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by BlueSky on 16/11/14.
 */

public interface GetInfoData {
   // 萌物志中文章界面图片、标题的接口服务
    @Headers({"Content-Type:application/json;charset=UTF-8"})
    @POST("v1/post/list")
    Observable<Article> getArticleData(@Query("orider_dir") String orider_dir,
                                       @Query("page_size") String page_size,
                                       @Query("page") String page,
                                       @Query("order_by") String order_by);

    //萌物志中专辑界面标题和图片的接口服务
    @Headers({"Content-Type:application/json;charset=UTF-8"})
    @POST("v1/album/list")
    Observable<Album> getAlbumData(@Query("page_size") String page_size,
                                   @Query("page") String page);
}
