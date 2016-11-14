package com.sky.databinding.rxjavaretrofit;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.sky.databinding.rxjavaretrofit.adapter.MyViewPager;
import com.sky.databinding.rxjavaretrofit.databinding.ActivityMainBinding;
import com.sky.databinding.rxjavaretrofit.fragment.ContentFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试地址1:文章界面图片、标题、subtitle：http://api.menghuoapp.com/v1/post/list
 * 请求方式：POST
 * 请求体：orider_dir=1;page_size=20;page=0;order_by=1;
 * <p>
 * 请求头：名称：Content-Type，值：application/json; charset=UTF-8
 * <p>
 * <p>
 * <p>
 * 测试地址2:专辑界面标题和图片：http://api.menghuoapp.com/v1/album/list
 * 请求方式：POST
 * 请求体：page_size=20；page=0；
 * 请求头：名称：Content-Type，值：application/json; charset=UTF-8
 */
public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private List<Fragment> fragmentList = new ArrayList<>();
    private  String[] titles = new String[]{"文章", "专辑"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initToolBar();
        initTabLayoutAndViewPager();


    }

    private void initToolBar() {
        binding.toolBar.setTitle("首页");
        binding.toolBar.setBackgroundColor(
                getResources().getColor(R.color.colorPrimary)
        );
        binding.toolBar.setTitleTextColor(Color.WHITE);
        binding.toolBar.setLogo(android.R.drawable.ic_menu_slideshow);
        setSupportActionBar(binding.toolBar);
    }

    private void initTabLayoutAndViewPager() {
        binding.tabLayout.setTabTextColors(
                Color.parseColor("#000000"), Color.parseColor("#00ffff"));
        binding.tabLayout.setSelectedTabIndicatorHeight(5);
        binding.tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#00ffff"));
        for (int i = 0; i < titles.length; i++) {
            binding.tabLayout.addTab(binding.tabLayout.newTab().setText(titles[i]));
            ContentFragment fragment = new ContentFragment();
            Bundle b = new Bundle();
            b.putInt("pos", i);
            fragment.setArguments(b);
            fragmentList.add(fragment);
        }
        binding.setVpAdapter(new MyViewPager(getSupportFragmentManager(), fragmentList, titles));
    }
}
