package com.jiangxufa.demovlayout.single;

import android.content.Context;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.jiangxufa.demovlayout.BaseActivity;

/**
 * 创建时间：2018/5/21
 * 编写人：lenovo
 * 功能描述：
 */

public class SingleLayoutHelperActivity extends BaseActivity {
    @Override
    protected DelegateAdapter.Adapter init(Context context) {
        SingleLayoutHelper singleLayoutHelper=new SingleLayoutHelper();
        //设置间距
        singleLayoutHelper.setMargin(20,20,20,20);
        SingleLayoutAdapter singleLayoutAdapter=new SingleLayoutAdapter(context,singleLayoutHelper,"SingleLayoutHelper");
        return singleLayoutAdapter;
    }
}
