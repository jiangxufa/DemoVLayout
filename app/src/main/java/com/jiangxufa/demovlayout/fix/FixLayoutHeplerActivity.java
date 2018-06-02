package com.jiangxufa.demovlayout.fix;

import android.content.Context;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.layout.FixLayoutHelper;
import com.jiangxufa.demovlayout.AddAdapterTools;
import com.jiangxufa.demovlayout.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建时间：2018/5/21
 * 编写人：lenovo
 * 功能描述：
 */

public class FixLayoutHeplerActivity extends BaseActivity {
    @Override
    protected List<DelegateAdapter.Adapter> addAdapter() {
        List<DelegateAdapter.Adapter> adapterList = new ArrayList<>();
        AddAdapterTools.addLinearAdapter(this,adapterList);
        return adapterList;
    }

    @Override
    protected DelegateAdapter.Adapter init(Context context) {
        FixLayoutHelper fixLayoutHelper=new FixLayoutHelper(FixLayoutHelper.BOTTOM_LEFT, 200, 200);
        FixLayoutAdapter fixLayoutAdapter=new FixLayoutAdapter(context,fixLayoutHelper,"fixlayouthelp");
        return fixLayoutAdapter;
    }


}
