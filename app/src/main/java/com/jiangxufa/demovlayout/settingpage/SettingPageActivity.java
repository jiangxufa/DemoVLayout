package com.jiangxufa.demovlayout.settingpage;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.jiangxufa.demovlayout.R;

/**
 * 创建时间：2018/5/21
 * 编写人：lenovo
 * 功能描述：
 */

public class SettingPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_setting);
        RecyclerView recyclerView = findViewById(R.id.rv);
        VirtualLayoutManager virtualLayoutManager = new VirtualLayoutManager(this);
        recyclerView.setLayoutManager(virtualLayoutManager);
        DelegateAdapter delegateAdapter = new DelegateAdapter(virtualLayoutManager,true);

        // 1.顶部的图片
        SingleLayoutHelper bannerLayoutHelper = new SingleLayoutHelper();
        bannerLayoutHelper.setItemCount(1);
        bannerLayoutHelper.setMargin(0,10,0,10);
        SettingPageTitlePicAdapter delegateRecyclerAdapter1 = new SettingPageTitlePicAdapter(this, bannerLayoutHelper, "bannerLayoutHelper");
        delegateAdapter.addAdapter(delegateRecyclerAdapter1);

        // 2.标题栏
        LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper();
        linearLayoutHelper.setItemCount(1);
        linearLayoutHelper.setBgColor(Color.GREEN);
        SettingPageTitleAdapter delegateRecyclerAdapter2 = new SettingPageTitleAdapter(this, linearLayoutHelper, "标题1");
        delegateAdapter.addAdapter(delegateRecyclerAdapter2);

        // 3.九宫格布局
        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(3);
        gridLayoutHelper.setAutoExpand(false);
        gridLayoutHelper.setWeights(new float[]{60f , 20f , 20f});
        gridLayoutHelper.setMargin(10,10,10,10);
        gridLayoutHelper.setGap(5);
        SettingPageGridAdapter delegateRecyclerAdapter3 = new SettingPageGridAdapter(this, gridLayoutHelper, "gridLayoutHelper",6);
        delegateAdapter.addAdapter(delegateRecyclerAdapter3);

        // 2.标题栏
        LinearLayoutHelper linearLayoutHelper1 = new LinearLayoutHelper();
        linearLayoutHelper1.setItemCount(1);
        SettingPageTitleAdapter delegateRecyclerAdapter4 = new SettingPageTitleAdapter(this, linearLayoutHelper1, "标题1");
        delegateAdapter.addAdapter(delegateRecyclerAdapter4);

        // 3.九宫格布局
        GridLayoutHelper gridLayoutHelper2 = new GridLayoutHelper(3);
        gridLayoutHelper2.setAutoExpand(false);
        gridLayoutHelper2.setWeights(new float[]{33,33,33});
        gridLayoutHelper2.setMargin(10,10,10,10);
        gridLayoutHelper2.setGap(5);
        SettingPageGridAdapter delegateRecyclerAdapter5 = new SettingPageGridAdapter(this, gridLayoutHelper2, "gridLayoutHelper",4);
        delegateAdapter.addAdapter(delegateRecyclerAdapter5);

        recyclerView.setAdapter(delegateAdapter);
    }
}
