package com.sky.databinding.rxjavaretrofit.fragment;


import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sky.databinding.rxjavaretrofit.R;
import com.sky.databinding.rxjavaretrofit.adapter.MyAdapter;
import com.sky.databinding.rxjavaretrofit.bean.Album;
import com.sky.databinding.rxjavaretrofit.bean.Article;
import com.sky.databinding.rxjavaretrofit.databinding.FragmentContentBinding;
import com.sky.databinding.rxjavaretrofit.http.HttpUtils;
import com.sky.databinding.rxjavaretrofit.subscrible.ResultSubcrible;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContentFragment extends Fragment {
    private HttpUtils httpUtils;
    private MyAdapter myAdapter;
    private FragmentContentBinding viewDataBinding;
    private Context ctx;
    private int pos;
    public ContentFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pos=getArguments().getInt("pos");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        ctx =context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        viewDataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_content,container,false);
        httpUtils = HttpUtils.getHttpUtils();
        myAdapter = new MyAdapter(ctx);
        viewDataBinding.setAdapter(myAdapter);

        return viewDataBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        switch (pos){
            case 0:
                httpUtils.getArticleData(new ResultSubcrible<Article>(myAdapter), "1", "20", "0", "1");
                break;
            case 1:
                httpUtils.getAlbumData(new ResultSubcrible<Album>(myAdapter), "20", "0");
                break;
        }
    }
}
