package com.jiangxufa.demovlayout.oneplus;

import android.content.Context;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.layout.OnePlusNLayoutHelper;
import com.jiangxufa.demovlayout.BaseActivity;

/**
 * 创建时间：2018/5/21
 * 编写人：lenovo
 * 功能描述：
 */

public class OnePlusNLayoutHelperActivity extends BaseActivity {
    @Override
    protected DelegateAdapter.Adapter init(Context context) {
        OnePlusNLayoutHelper onePlusNLayoutHelper=new OnePlusNLayoutHelper();
        //设置布局底部与下个布局的间隔
        onePlusNLayoutHelper.setMarginBottom(20);
        OnePlusNLayoutAdapter onePlusNLayoutAdapter=new OnePlusNLayoutAdapter(context,onePlusNLayoutHelper,"OnePlusNLayoutHelper");
        return onePlusNLayoutAdapter;
    }
}
