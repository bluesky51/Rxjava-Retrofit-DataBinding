package com.sky.databinding.rxjavaretrofit;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.sky.databinding.rxjavaretrofit.databinding.ActivityArticleDetailBinding;

public class ArticleDetailActivity extends AppCompatActivity {

    private ActivityArticleDetailBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_article_detail);
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String url = intent.getStringExtra("url");
        binding.toolBar.setTitle(title);
        binding.toolBar.setBackgroundColor(
                getResources().getColor(R.color.colorPrimary)
        );
        binding.toolBar.setTitleTextColor(Color.WHITE);
        binding.toolBar.setLogo(android.R.drawable.ic_menu_slideshow);
        setSupportActionBar(binding.toolBar);
        binding.setUrl(url);

    }
}
