package com.sky.databinding.rxjavaretrofit.utils;

import android.databinding.BindingAdapter;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by BlueSky on 16/11/14.
 */

public class WebUtils {
    //自定义属性方法必须是static
    @BindingAdapter("webUrl")
    public static void loadImage(WebView webView, String url){
        if (url==null){
            return;
        }else{
            webView.setWebViewClient(new WebViewClient());
            webView.loadUrl(url);
        }
    }
}
