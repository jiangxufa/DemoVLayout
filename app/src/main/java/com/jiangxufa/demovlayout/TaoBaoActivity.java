package com.jiangxufa.demovlayout;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.RecyclablePagerAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.chad.library.adapter.base.BaseViewHolder;

/**
 * 创建时间：2018/5/22
 * 编写人：lenovo
 * 功能描述：
 */

public class TaoBaoActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    static int ITEM_SEARCH = 1;
    static int ITEM_BANNER = 2;
    static int ITEM_Grid1 = 3;
    static int ITEM_IMAGE = 4;
    static int ITEM_IMAGE2 = 5;

    interface ItemClickListener{
        void onSearchClick(String s);
        void onBannerClick(String s);
        void onGrid1Click(String s);
        void onImageClick(String s);
        void onImage2Click(String s);
    }

    public void toast(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    private ItemClickListener listener = new ItemClickListener() {
        @Override
        public void onSearchClick(String s) {
            toast(s);
        }

        @Override
        public void onBannerClick(String s) {
            toast(s);
        }

        @Override
        public void onGrid1Click(String s) {
            toast(s);
        }

        @Override
        public void onImageClick(String s) {
            toast(s);
        }

        @Override
        public void onImage2Click(String s) {
            toast(s);
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rv);
        VirtualLayoutManager virtualLayoutManager = new VirtualLayoutManager(this);
        recyclerView.setLayoutManager(virtualLayoutManager);
        DelegateAdapter adapter = new DelegateAdapter(virtualLayoutManager, true);

        initAdapter(adapter);

        recyclerView.setAdapter(adapter);
    }

    private void initAdapter(DelegateAdapter adapter) {

        final RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();

        recyclerView.setRecycledViewPool(viewPool);

        // recyclerView.addItemDecoration(itemDecoration);

        viewPool.setMaxRecycledViews(0, 20);

        // 1.搜索
        adapter.addAdapter(new BaseAdapter(this,
                new LinearLayoutHelper(), 1, R.layout.taobao_search, ITEM_SEARCH, null) {
            @Override
            public void onBindViewHolder(BaseViewHolder holder, int position) {
                super.onBindViewHolder(holder, position);
                holder.getView(R.id.textView).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        listener.onSearchClick("这是search");
                    }
                });
            }
        });

        // 2.轮播图
        adapter.addAdapter(new BaseAdapter(this,
                new LinearLayoutHelper(), 1, R.layout.taobao_banner, ITEM_BANNER, null) {
            @Override
            public void onBindViewHolder(BaseViewHolder holder, int position) {
                super.onBindViewHolder(holder, position);
                ViewPager viewpager = holder.getView(R.id.viewpager);
                viewpager.setAdapter(new PagerAdapter(new SubAdapter(
                        TaoBaoActivity.this, new LinearLayoutHelper(), 4, null), viewPool));
            }


        });

        // 3.Grid的条目
        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(4);
        gridLayoutHelper.setGap(4);
        gridLayoutHelper.setMargin(10, 10, 10, 10);
        adapter.addAdapter(new BaseAdapter(this, gridLayoutHelper,
                8, R.layout.taobao_grid1, ITEM_Grid1, null) {
            @Override
            public void onBindViewHolder(BaseViewHolder holder, final int position) {
                super.onBindViewHolder(holder, position);
                holder.getView(R.id.imageView2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        listener.onBannerClick("这是Banner" + position);
                    }
                });
                switch (position % 8) {
                    case 0:
                        holder.setImageResource(R.id.imageView2, R.mipmap.ic_auction);
                        break;
                    case 1:
                        holder.setImageResource(R.id.imageView2, R.mipmap.ic_chaoshi);
                        break;
                    case 2:
                        holder.setImageResource(R.id.imageView2, R.mipmap.ic_classify);
                        break;
                    case 3:
                        holder.setImageResource(R.id.imageView2, R.mipmap.ic_ju_hua_suan);
                        break;
                    case 4:
                        holder.setImageResource(R.id.imageView2, R.mipmap.ic_tao_gold);
                        break;
                    case 5:
                        holder.setImageResource(R.id.imageView2, R.mipmap.ic_tian_mao);
                        break;
                    case 6:
                        holder.setImageResource(R.id.imageView2, R.mipmap.ic_tian_mao_guoji);
                        break;
                    case 7:
                        holder.setImageResource(R.id.imageView2, R.mipmap.ic_travel);
                        break;
                }
            }
        });

        // 4.單行的view
        final SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        singleLayoutHelper.setMargin(0,20,0,20);
        adapter.addAdapter(new BaseAdapter(this, singleLayoutHelper,
                1,R.layout.taobao_image_title,ITEM_IMAGE,null){
            @Override
            public void onBindViewHolder(BaseViewHolder holder, int position) {
                super.onBindViewHolder(holder, position);
                holder.getView(R.id.image).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        listener.onBannerClick("这是單行的view");
                    }
                });
            }
        });

        // 5.Grid的条目
        GridLayoutHelper gridLayoutHelper1 = new GridLayoutHelper(2);
        gridLayoutHelper1.setGap(5);
        gridLayoutHelper1.setMargin(10, 0, 10, 0);
        adapter.addAdapter(new BaseAdapter(this, gridLayoutHelper1,
                                   4, R.layout.taobao_grid2, ITEM_IMAGE2, null){
            @Override
            public void onBindViewHolder(BaseViewHolder holder, final int position) {
                super.onBindViewHolder(holder, position);
                holder.getView(R.id.image).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        listener.onBannerClick("这是Grid的条目" + position);
                    }
                });
            }
        } );

        // 4.單行的view
        adapter.addAdapter(new BaseAdapter(this,singleLayoutHelper,
                1,R.layout.taobao_image_title,ITEM_IMAGE,null){
            @Override
            public void onBindViewHolder(BaseViewHolder holder, int position) {
                super.onBindViewHolder(holder, position);
                holder.getView(R.id.image).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        listener.onBannerClick("这是單行的view");
                    }
                });
            }
        });

        // 5.Grid的条目
        GridLayoutHelper gridLayoutHelper2 = new GridLayoutHelper(2);
        gridLayoutHelper2.setGap(5);
        gridLayoutHelper2.setMargin(10, 0, 10, 0);
        adapter.addAdapter(new BaseAdapter(this, gridLayoutHelper2,
                4, R.layout.taobao_grid2, ITEM_IMAGE2, null) );

        // 4.單行的view
        adapter.addAdapter(new BaseAdapter(this, singleLayoutHelper,
                1,R.layout.taobao_image_title,ITEM_IMAGE,null){
            @Override
            public void onBindViewHolder(BaseViewHolder holder, int position) {
                super.onBindViewHolder(holder, position);
                holder.getView(R.id.image).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        listener.onBannerClick("这是單行的view");
                    }
                });
            }
        });

        // 5.Grid的条目
        GridLayoutHelper gridLayoutHelper3 = new GridLayoutHelper(2);
        gridLayoutHelper3.setGap(5);
        gridLayoutHelper3.setMargin(10, 0, 10, 0);
        adapter.addAdapter(new BaseAdapter(this, gridLayoutHelper3,
                4, R.layout.taobao_grid2, ITEM_IMAGE2, null){
            @Override
            public void onBindViewHolder(BaseViewHolder holder, final int position) {
                super.onBindViewHolder(holder, position);
                holder.getView(R.id.image).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        listener.onBannerClick("这是Grid的条目" + position);
                    }
                });
            }
        } );

        // 4.單行的view
        adapter.addAdapter(new BaseAdapter(this, singleLayoutHelper,
                1,R.layout.taobao_image_title,ITEM_IMAGE,null){
            @Override
            public void onBindViewHolder(BaseViewHolder holder, int position) {
                super.onBindViewHolder(holder, position);
                holder.getView(R.id.image).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        listener.onBannerClick("这是單行的view");
                    }
                });
            }
        });

        // 5.Grid的条目
        GridLayoutHelper gridLayoutHelper4 = new GridLayoutHelper(2);
        gridLayoutHelper4.setGap(5);
        gridLayoutHelper4.setMargin(10, 0, 10, 0);
        adapter.addAdapter(new BaseAdapter(this, gridLayoutHelper4,
                4, R.layout.taobao_grid2, ITEM_IMAGE2, null){
            @Override
            public void onBindViewHolder(BaseViewHolder holder, final int position) {
                super.onBindViewHolder(holder, position);
                holder.getView(R.id.image).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        listener.onBannerClick("这是Grid的条目" + position);
                    }
                });
            }
        } );

    }

    // RecyclableViewPager

    static class PagerAdapter extends RecyclablePagerAdapter<MainViewHolder> {
        public PagerAdapter(SubAdapter adapter, RecyclerView.RecycledViewPool pool) {
            super(adapter, pool);
        }

        @Override
        public int getCount() {
            return 6;
        }

        @Override
        public void onBindViewHolder(MainViewHolder viewHolder, int position) {
            // only vertical
            viewHolder.itemView.setLayoutParams(
                    new VirtualLayoutManager.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            ((TextView) viewHolder.itemView.findViewById(R.id.item_name)).setText("Banner: " + position);
        }

        @Override
        public int getItemViewType(int position) {
            return 0;
        }
    }

    static class SubAdapter extends DelegateAdapter.Adapter<MainViewHolder> {

        private Context mContext;

        private LayoutHelper mLayoutHelper;


        private VirtualLayoutManager.LayoutParams mLayoutParams;
        private int mCount = 0;


        public SubAdapter(Context context, LayoutHelper layoutHelper, int count) {
            this(context, layoutHelper, count, new VirtualLayoutManager.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 300));
        }

        public SubAdapter(Context context, LayoutHelper layoutHelper, int count, @NonNull VirtualLayoutManager.LayoutParams layoutParams) {
            this.mContext = context;
            this.mLayoutHelper = layoutHelper;
            this.mCount = count;
            this.mLayoutParams = layoutParams;
        }

        @Override
        public LayoutHelper onCreateLayoutHelper() {
            return mLayoutHelper;
        }

        @Override
        public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MainViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_item, parent, false));
        }

        @Override
        public void onBindViewHolder(MainViewHolder holder, int position) {
            // only vertical
            holder.itemView.setLayoutParams(
                    new VirtualLayoutManager.LayoutParams(mLayoutParams));
        }


        @Override
        protected void onBindViewHolderWithOffset(MainViewHolder holder, int position, int offsetTotal) {
            ((TextView) holder.itemView.findViewById(R.id.item_name)).setText(Integer.toString(offsetTotal));
        }

        @Override
        public int getItemCount() {
            return mCount;
        }
    }


    static class MainViewHolder extends RecyclerView.ViewHolder {

        public static volatile int existing = 0;
        public static int createdTimes = 0;

        public MainViewHolder(View itemView) {
            super(itemView);
            createdTimes++;
            existing++;
        }

        @Override
        protected void finalize() throws Throwable {
            existing--;
            super.finalize();
        }
    }

}
