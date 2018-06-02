package com.jiangxufa.demovlayout.linear;

import android.content.Context;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.jiangxufa.demovlayout.BaseActivity;

/**
 * 创建时间：2018/5/20
 * 编写人：lenovo
 * 功能描述：
 */

public class LinearLayoutHelperActivity extends BaseActivity {

    @Override
    protected DelegateAdapter.Adapter init(Context context) {
        LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper();
        //设置间隔高度
        linearLayoutHelper.setDividerHeight(50);
        //设置布局底部与下个布局的间隔
        linearLayoutHelper.setMarginBottom(20);
        //设置间距
        linearLayoutHelper.setMargin(20, 20, 20, 20);
        delegateRecyclerAdapter = new DelegateRecyclerAdapter(context, linearLayoutHelper, "LinearLayoutHelper");
        return delegateRecyclerAdapter;
    }
}
