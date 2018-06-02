package com.jiangxufa.demovlayout;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.chad.library.adapter.base.BaseViewHolder;

/**
 * 创建时间：2018/5/21
 * 编写人：lenovo
 * 功能描述：
 */

public class BaseAdapter extends DelegateAdapter.Adapter<BaseViewHolder> {

    private Context mContext;
    private LayoutHelper mLayoutHelper;
    private VirtualLayoutManager.LayoutParams mLayoutParams;
    private int layoutId;
    private int viewTypeItem;
    private int mCount = 0;

    public BaseAdapter(Context context,
                       LayoutHelper layoutHelper,
                       int count,
                       int layoutId,
                       int viewTypeItem,
                       @NonNull VirtualLayoutManager.LayoutParams layoutParams) {
        this.mContext = context;
        this.mLayoutHelper = layoutHelper;
        this.mCount = count;
        this.layoutId = layoutId;
        this.viewTypeItem = viewTypeItem;
        this.mLayoutParams = layoutParams;
    }


    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return mLayoutHelper;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == viewTypeItem) {
            return new BaseViewHolder(LayoutInflater.from(mContext).inflate(layoutId, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mCount;
    }

    @Override
    public int getItemViewType(int position) {
        return viewTypeItem;
    }
}
