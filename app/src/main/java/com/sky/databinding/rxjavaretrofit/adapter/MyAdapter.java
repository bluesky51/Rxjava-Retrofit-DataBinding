package com.sky.databinding.rxjavaretrofit.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BlueSky on 16/11/14.
 */

public class MyAdapter<T> extends BaseAdapter {
    private List<T> dataBeanList =new ArrayList<>();
    private Context ctx;
    private int itemLayoutId;
    private int itemVariableId;
    private LayoutInflater inflater;

    public MyAdapter( Context context) {
        this.ctx = context;
        inflater = LayoutInflater.from(context);
    }

    public void setContentData(List<T> dataBeanList,int itemLayoutId ,int itemVariableId) {
        this.dataBeanList = dataBeanList;
        this.itemLayoutId= itemLayoutId;
        this.itemVariableId = itemVariableId;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return dataBeanList.size();
    }

    @Override
    public T getItem(int i) {
        return dataBeanList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewDataBinding dataBinding = null;
        if (view == null) {
            dataBinding = DataBindingUtil.inflate(inflater, itemLayoutId, viewGroup, false);

        } else {
            dataBinding =  DataBindingUtil.getBinding(view);
        }
         dataBinding.setVariable(itemVariableId,dataBeanList.get(i));
        return dataBinding.getRoot();
    }

}
