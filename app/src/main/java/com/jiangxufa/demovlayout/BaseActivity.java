package com.jiangxufa.demovlayout;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.jiangxufa.demovlayout.linear.DelegateRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建时间：2018/5/21
 * 编写人：lenovo
 * 功能描述：
 */

public abstract class BaseActivity extends Activity {

    public RecyclerView recyclerview;
    public DelegateRecyclerAdapter delegateRecyclerAdapter;
    public DelegateAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerview = findViewById(R.id.rv);
        VirtualLayoutManager manager = new VirtualLayoutManager(this);
        recyclerview.setLayoutManager(manager);
        adapter = new DelegateAdapter(manager, true);

        adapter.addAdapter(init(this));
        List<DelegateAdapter.Adapter> adapters = addAdapter();
        for (DelegateAdapter.Adapter a:adapters){
            adapter.addAdapter(a);
        }
        recyclerview.setAdapter(adapter);
    }

    protected List<DelegateAdapter.Adapter> addAdapter(){
        return new ArrayList<>();
    }

    protected abstract DelegateAdapter.Adapter init(Context context);

}
