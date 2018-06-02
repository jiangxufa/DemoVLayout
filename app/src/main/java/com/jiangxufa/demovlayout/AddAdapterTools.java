package com.jiangxufa.demovlayout;

import android.content.Context;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.jiangxufa.demovlayout.linear.DelegateRecyclerAdapter;

import java.util.List;

/**
 * 创建时间：2018/5/21
 * 编写人：lenovo
 * 功能描述：
 */

public class AddAdapterTools {

    public static void addLinearAdapter(Context context, List<DelegateAdapter.Adapter> list) {
        LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper();
        //设置间隔高度
        linearLayoutHelper.setDividerHeight(5);
        //设置布局底部与下个布局的间隔
        linearLayoutHelper.setMarginBottom(20);
        //设置间距
        linearLayoutHelper.setMargin(20, 20, 20, 20);
        list.add(new DelegateRecyclerAdapter(context, linearLayoutHelper, "LinearLayoutHelper"));
    }

}
