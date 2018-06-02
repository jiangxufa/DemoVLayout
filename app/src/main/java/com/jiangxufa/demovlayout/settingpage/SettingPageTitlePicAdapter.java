package com.jiangxufa.demovlayout.settingpage;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.jiangxufa.demovlayout.R;

/**
 * 创建时间：2018/5/21
 * 编写人：lenovo
 * 功能描述：
 */

public class SettingPageTitlePicAdapter extends DelegateAdapter.Adapter {
    public Context context;
    private LayoutHelper helper;
    private LayoutInflater inflater;
    private String name;

    public SettingPageTitlePicAdapter(Context context, LayoutHelper helper, String name) {
        this.inflater = LayoutInflater.from(context);
        this.helper = helper;
        this.context = context;
        this.name = name;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return this.helper;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SettingPageTitlePicAdapter.MyViewHolder(inflater.inflate(R.layout.layout_item_pic, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        SettingPageTitlePicAdapter.MyViewHolder myViewHolder = (SettingPageTitlePicAdapter.MyViewHolder) holder;
        myViewHolder.name.setImageResource(R.mipmap.title);
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView name;

        public MyViewHolder(View itemView) {
            super(itemView);
            name = (ImageView) itemView.findViewById(R.id.item_name);
        }
    }

}
