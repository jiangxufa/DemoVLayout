package com.jiangxufa.demovlayout.scroll_fix;

import android.content.Context;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.layout.FixLayoutHelper;
import com.alibaba.android.vlayout.layout.ScrollFixLayoutHelper;
import com.jiangxufa.demovlayout.AddAdapterTools;
import com.jiangxufa.demovlayout.BaseActivity;
import com.jiangxufa.demovlayout.fix.FixLayoutAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建时间：2018/5/21
 * 编写人：lenovo
 * 功能描述：
 */

public class ScrollFixLayoutHelperActivity extends BaseActivity {

    @Override
    protected List<DelegateAdapter.Adapter> addAdapter() {
        List<DelegateAdapter.Adapter> adapterList = new ArrayList<>();
        AddAdapterTools.addLinearAdapter(this,adapterList);
        return adapterList;
    }

    @Override
    protected DelegateAdapter.Adapter init(Context context) {
        ScrollFixLayoutHelper scrollFixLayoutHelper = new ScrollFixLayoutHelper(FixLayoutHelper.BOTTOM_LEFT,15,15);
        //show_always:总是显示
        //show_on_enter:当页面滚动到这个视图的位置的时候，才显示  最底部
        //show_on_leave:当页面滚出这个视图的位置的时候显示
        scrollFixLayoutHelper.setShowType(ScrollFixLayoutHelper.SHOW_ON_ENTER);
        return new FixLayoutAdapter(context, scrollFixLayoutHelper,"scrollfixlayouthelper");
    }
}
