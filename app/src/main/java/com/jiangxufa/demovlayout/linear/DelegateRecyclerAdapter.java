package com.jiangxufa.demovlayout.linear;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.jiangxufa.demovlayout.R;

/**
 * 创建时间：2018/5/20
 * 编写人：lenovo
 * 功能描述：
 */

public class DelegateRecyclerAdapter extends DelegateAdapter.Adapter{
    public Context context;
    private LayoutHelper helper;
    private LayoutInflater inflater;
    private String name;

    public DelegateRecyclerAdapter(Context context,LayoutHelper helper,String name){
        this.inflater = LayoutInflater.from(context);
        this.helper = helper;
        this.context=context;
        this.name=name;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return this.helper;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(inflater.inflate(R.layout.layout_item,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(position%2==0){
            holder.itemView.setBackgroundColor(0xaa3F51B5);
        }else{
            holder.itemView.setBackgroundColor(0xccFF4081);
        }
        MyViewHolder myViewHolder=(MyViewHolder)holder;
        myViewHolder.name.setText(name+position+"");
    }

    @Override
    public int getItemCount() {
        return 200;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView name;
        public MyViewHolder(View itemView) {
            super(itemView);
            name=(TextView)itemView.findViewById(R.id.item_name);
        }
    }

}