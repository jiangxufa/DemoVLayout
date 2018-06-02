package com.jiangxufa.demovlayout.staggered;

import android.content.Context;

import com.alibaba.android.vlayout.layout.StaggeredGridLayoutHelper;
import com.jiangxufa.demovlayout.BaseActivity;

/**
 * 创建时间：2018/5/21
 * 编写人：lenovo
 * 功能描述：
 */

public class StaggeredLayoutHelperActivity extends BaseActivity {
    @Override
    protected StaggeredAdapter init(Context context) {
        StaggeredGridLayoutHelper staggeredGridLayoutHelper = new StaggeredGridLayoutHelper(3, 20);
        StaggeredAdapter staggeredAdapter = new StaggeredAdapter(context, staggeredGridLayoutHelper, "StaggeredGridLayoutHelper");
        return staggeredAdapter;
    }
}
