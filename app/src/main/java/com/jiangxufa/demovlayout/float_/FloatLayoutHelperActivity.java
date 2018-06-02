package com.jiangxufa.demovlayout.float_;

import android.content.Context;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.layout.FixLayoutHelper;
import com.alibaba.android.vlayout.layout.FloatLayoutHelper;
import com.jiangxufa.demovlayout.AddAdapterTools;
import com.jiangxufa.demovlayout.BaseActivity;
import com.jiangxufa.demovlayout.fix.FixLayoutAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建时间：2018/5/21
 * 编写人：lenovo
 * 功能描述：floatLayout需要设置在前面 不然需要到设置的item索引位置才能够移动
 */

public class FloatLayoutHelperActivity extends BaseActivity {

    @Override
    protected List<DelegateAdapter.Adapter> addAdapter() {
        List<DelegateAdapter.Adapter> adapterList = new ArrayList<>();
        AddAdapterTools.addLinearAdapter(this, adapterList);
        return adapterList;
    }


    @Override
    protected DelegateAdapter.Adapter init(Context context) {
        FloatLayoutHelper floatLayoutHelper = new FloatLayoutHelper();
        floatLayoutHelper.setAlignType(FixLayoutHelper.BOTTOM_RIGHT);
        floatLayoutHelper.setDefaultLocation(20, 250);
        return new FixLayoutAdapter(context, floatLayoutHelper, "floatlayouthelper");
    }


}
