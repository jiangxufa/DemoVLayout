package com.jiangxufa.demovlayout.grid;

import android.content.Context;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.jiangxufa.demovlayout.BaseActivity;
import com.jiangxufa.demovlayout.linear.DelegateRecyclerAdapter;

/**
 * 创建时间：2018/5/21
 * 编写人：lenovo
 * 功能描述：
 */

public class GridLayoutHelperActivity extends BaseActivity {

    @Override
    protected DelegateAdapter.Adapter init(Context context) {
        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(4);
        //自定义设置某些位置的Item的占格数
        gridLayoutHelper.setSpanSizeLookup(new GridLayoutHelper.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (position > 5) {
                    return 2;
                } else {
                    return 1;
                }
            }
        });
        //是否填满可用区域
        gridLayoutHelper.setAutoExpand(false);
        delegateRecyclerAdapter = new DelegateRecyclerAdapter(context, gridLayoutHelper, "GridLayoutHelper");
        return delegateRecyclerAdapter;
    }

}
