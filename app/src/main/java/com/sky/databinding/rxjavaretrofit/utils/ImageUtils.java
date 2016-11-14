package com.sky.databinding.rxjavaretrofit.utils;

import android.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.makeramen.roundedimageview.RoundedImageView;
import com.sky.databinding.rxjavaretrofit.R;

/**
 * Created by BlueSky on 16/11/14.
 */

public class ImageUtils {

    //自定义属性方法必须是static
    @BindingAdapter("imageUrl")
    public static void loadImage(RoundedImageView img, String url){
        if (url==null){
            img.setImageResource(R.mipmap.ic_launcher);
        }else{
            Glide.with(img.getContext()).load(url).into(img);
        }
    }
}
