package com.jiangxufa.demovlayout.column;

import android.content.Context;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.layout.ColumnLayoutHelper;
import com.jiangxufa.demovlayout.BaseActivity;

/**
 * 创建时间：2018/5/21
 * 编写人：lenovo
 * 功能描述：
 */

public class ColumnLayoutHelperActivity extends BaseActivity {
    @Override
    protected DelegateAdapter.Adapter init(Context context) {
        ColumnLayoutHelper columnLayoutHelper=new ColumnLayoutHelper();
        columnLayoutHelper.setWeights(new float[]{20,20,20,20,20});
        columnLayoutHelper.setMarginBottom(20);
        ColumnLayoutAdapter columnLayoutAdapter=new ColumnLayoutAdapter(context,columnLayoutHelper,"ColumnLayoutHelper");
        return columnLayoutAdapter;
    }
}
