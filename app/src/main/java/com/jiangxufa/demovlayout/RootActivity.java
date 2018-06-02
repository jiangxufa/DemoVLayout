package com.jiangxufa.demovlayout;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.jiangxufa.demovlayout.column.ColumnLayoutHelperActivity;
import com.jiangxufa.demovlayout.fix.FixLayoutHeplerActivity;
import com.jiangxufa.demovlayout.float_.FloatLayoutHelperActivity;
import com.jiangxufa.demovlayout.grid.GridLayoutHelperActivity;
import com.jiangxufa.demovlayout.linear.LinearLayoutHelperActivity;
import com.jiangxufa.demovlayout.oneplus.OnePlusNLayoutHelperActivity;
import com.jiangxufa.demovlayout.scroll_fix.ScrollFixLayoutHelperActivity;
import com.jiangxufa.demovlayout.settingpage.SettingPageActivity;
import com.jiangxufa.demovlayout.single.SingleLayoutHelperActivity;
import com.jiangxufa.demovlayout.staggered.StaggeredLayoutHelperActivity;
import com.jiangxufa.demovlayout.stick.StickyLayoutHelperActivity;

/**
 * 创建时间：2018/5/20
 * 编写人：lenovo
 * 功能描述：
 * LinearLayoutHelper: 线性布局
 * GridLayoutHelper: Grid布局， 支持横向的colspan
 * StaggeredGridLayoutHelper: 瀑布流布局，可配置间隔高度/宽度
 * FixLayoutHelper: 固定布局，始终在屏幕固定位置显示
 * ScrollFixLayoutHelper: 固定布局，但之后当页面滑动到该图片区域才显示, 可以用来做返回顶部或其他书签等
 * FloatLayoutHelper: 浮动布局，可以固定显示在屏幕上，但用户可以拖拽其位置
 * ColumnLayoutHelper: 栏格布局，都布局在一排，可以配置不同列之间的宽度比值
 * SingleLayoutHelper: 通栏布局，只会显示一个组件View
 * OnePlusNLayoutHelper: 一拖N布局，可以配置1-5个子元素
 * StickyLayoutHelper: stikcy布局， 可以配置吸顶或者吸底
 * <p>
 * aspectRatio
 * 为了保证布局过程中视图的高度一致，我们设计了aspectRatio属性，它是宽与高的比例，LayoutHelper里有aspectRatio属性，
 * 通过vlayout添加的视图的LayoutParams也有aspectRatio属性，后者的优先级比前者高，但含义不一样。LayoutHelper定义的
 * aspectRatio，指的是一行视图整体的宽度与高度之比，当然整体的宽度是减去了RecyclerView和对应的LayoutHelper的margin
 * , padding。视图的LayoutParams定义的aspectRatio，指的是在LayoutHelper计算出视图宽度之后，用来确定视图高度时使用
 * 的，它会覆盖通过LayoutHelper的aspectRatio计算出来的视图高度，因此具备更高优先级。
 * <p>
 * bgColor, bgImg
 * 背景颜色或者背景图，这其实不是布局属性，但是由于在vlayout对视图进行了直接布局，不同区域的视图的父节点都是RecyclerView，
 * 如果想要针对某一块区域单独绘制背景，就很难做到了。vlayout框架对此做了特殊处理，对于非fix、非float类型的LayoutHelper，
 * 支持配置背景色或背景图。同样目前主要针对非fix类型的LayoutHelper实现这个特性。
 * <p>
 * weights
 * ColumnLayoutHelper, GridLayoutHelper的属性，它们都是提供网格状的布局能力，建议使用GridLayoutHelper，它的能力更加强大，
 * 参考下文介绍。默认情况下，每个网格中每一列的宽度是一样的，通过weights属性，可以指定让每一列的宽度成比例分配，就像LinearLayout
 * 的weight属性一样。 weights属性是一个float数组，每一项代表某一列占父容器宽度的百分比，总和建议是100，否则布局会超出容器宽度；
 * 如果布局中有4列，那么weights的长度也应该是4；长度大于4，多出的部分不参与宽度计算；如果小于4，不足的部分默认平分剩余的空间。
 * 比如，setweights(0.6 , 0.2 , 0.2);那么分配比例是3：1：1
 * <p>
 * vGap, hGap
 * GridLayoutHelper与StaggeredGridLayoutHelper都有这两个属性，分别控制视图之间的垂直间距和水平间距。
 * <p>
 * spanCount, spanSizeLookup
 * GridLayoutHelper的属性，参考于系统的GridLayoutManager，spanCount表示网格的列数，默认情况下每一个视图都占用一个网格区域，
 * 但通过提供自定义的spanSizeLookUp，可以指定某个位置的视图占用多个网格区域
 * <p>
 * autoExpand
 * GridLayoutHelper的属性，当一行里视图的个数少于spanCount值的时候，如果autoExpand为true，视图的总宽度会填满可用区域；
 * 否则会在屏幕上留空白区域。
 * <p>
 * lane
 * StaggeredGridLayoutHelper中有这个属性，与GridLayoutHelper里的spanCount类似，控制瀑布流的列数。
 * <p>
 * fixAreaAdjuster
 * fix类型的LayoutHelper，在可能需要设置一个相对父容器四个边的偏移量，比如整个页面里有一个固定的标题栏添加在vlayout容器上，
 * vlayout内部的fix类型视图不希望与外部的标题有所重叠，那么就可以设置一个fixAreaAdjuster来做偏移。
 * <p>
 * alignType, x, y
 * FixLayoutHelper, ScrollFixLayoutHelper, FloatLayoutHelper的属性，表示吸边时的基准位置，有四个取值，分别是TOP_LEFT,
 * TOP_RIGHT, BOTTOM_LEFT, BOTTOM_RIGHT。x和y是相对这四个位置的偏移量，最终的偏移量还要受上述的fixAreaAdjuster影响。
 * TOP_LEFT：基准位置是左上角，x是视图左边相对父容器的左边距偏移量，y是视图顶边相对父容器的上边距偏移量；
 * TOP_RIGHT：基准位置是右上角，x是视图右边相对父容器的右边距偏移量，y是视图顶边相对父容器的上边距偏移量；
 * BOTTOM_LEFT：基准位置是左下角，x是视图左边相对父容器的左边距偏移量，y是视图底边相对父容器的下边距偏移量；
 * BOTTOM_RIGHT：基准位置是右下角，x是视图右边相对父容器的右边距偏移量，y是视图底边相对父容器的下边距偏移量；
 * <p>
 * showType
 * ScrollFixLayoutHelper的属性，取值有SHOW_ALWAYS, SHOW_ON_ENTER, SHOW_ON_LEAVE。
 * SHOW_ALWAYS：与FixLayoutHelper的行为一致，固定在某个位置；
 * SHOW_ON_ENTER：默认不显示视图，当页面滚动到这个视图的位置的时候，才显示；
 * SHOW_ON_LEAVE：默认不显示视图，当页面滚出这个视图的位置的时候显示；
 * <p>
 * stickyStart, offset
 * StickyLayoutHelper的属性，当视图的位置在屏幕范围内时，视图会随页面滚动而滚动；当视图的位置滑出屏幕时，
 * StickyLayoutHelper会将视图固定在顶部（stickyStart = true）或者底部（stickyStart = false），固定的位置支持设置偏移量offset。
 */

public class RootActivity extends ListActivity {

    private String[] mTitles = new String[]{
            "LinearLayoutHelper: 线性布局",
            "GridLayoutHelper: Grid布局， 支持横向的colspan",
            "StaggeredGridLayoutHelper: 瀑布流布局，可配置间隔高度/宽度",
            "FixLayoutHelper: 固定布局，始终在屏幕固定位置显示",
            "ScrollFixLayoutHelper: 固定布局，但之后当页面滑动到该图片区域才显示, 可以用来做返回顶部或其他书签等",
            "FloatLayoutHelper: 浮动布局，可以固定显示在屏幕上，但用户可以拖拽其位置",
            "ColumnLayoutHelper: 栏格布局，都布局在一排，可以配置不同列之间的宽度比值",
            "SingleLayoutHelper: 通栏布局，只会显示一个组件View",
            "OnePlusNLayoutHelper: 一拖N布局，可以配置1-5个子元素",
            "StickyLayoutHelper: stikcy布局， 可以配置吸顶或者吸底",
            "測試",
            "仿个人设置的九宫格布局",
            "仿淘宝首页"
    };

    private Class[] mActivities = new Class[]{
            LinearLayoutHelperActivity.class,
            GridLayoutHelperActivity.class,
            StaggeredLayoutHelperActivity.class,
            FixLayoutHeplerActivity.class,
            ScrollFixLayoutHelperActivity.class,
            FloatLayoutHelperActivity.class,
            ColumnLayoutHelperActivity.class,
            SingleLayoutHelperActivity.class,
            OnePlusNLayoutHelperActivity.class,
            StickyLayoutHelperActivity.class,
            TestActivity.class,
            SettingPageActivity.class,
            TaoBaoActivity.class
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mTitles));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        startActivity(new Intent(this, mActivities[position]));
    }
}
