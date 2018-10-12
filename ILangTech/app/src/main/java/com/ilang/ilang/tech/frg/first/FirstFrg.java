package com.ilang.ilang.tech.frg.first;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ilang.ilang.tech.R;
import com.ilang.ilang.tech.adapter.MyRecyclerViewAdapter;
import com.ilang.ilang.tech.frg.first.child.DayNew;
import com.ilang.ilang.tech.frg.first.child.HotProject;
import com.ilang.ilang.tech.model.IdeaBean;

import java.util.ArrayList;
import java.util.List;

import cn.jzvd.Jzvd;
import cn.jzvd.JzvdStd;
import me.yokeyword.fragmentation.SupportFragment;

public class FirstFrg extends SupportFragment {
    private static final String ARG_SECTION_NUMBER = "section_number";
    private AppBarLayout mAppBarLayout;
    private Toolbar mToolbar;

    public FirstFrg() {
    }

    public static FirstFrg newInstance(int sectionNumber) {
        FirstFrg fragment = new FirstFrg();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.frg_first, container, false);
        mToolbar = (Toolbar) rootView.findViewById(R.id.AppFragment_Toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(mToolbar);
        mAppBarLayout = (AppBarLayout) rootView.findViewById(R.id.AppFragment_AppBarLayout);
        mAppBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                mToolbar.setBackgroundColor(changeAlpha(getResources().getColor(R.color.colorPrimary), Math.abs(verticalOffset * 1.0f) / appBarLayout.getTotalScrollRange()));
            }
        });
        JzvdStd jzvdStd = rootView.findViewById(R.id.videoplayer);
        jzvdStd.setUp("http://jzvd.nathen.cn/c6e3dc12a1154626b3476d9bf3bd7266/6b56c5f0dc31428083757a45764763b0-5287d2089db37e62345123a1be272f8b.mp4", "饺子闭眼睛", Jzvd.SCREEN_WINDOW_NORMAL);
        initView(rootView);
        return rootView;
    }

    private void initView(View view) {

        RecyclerView mRecyclerView = view.findViewById(R.id.frg_first_recyclerView);
        //设置RecyclerView管理器
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        List<IdeaBean> list = new ArrayList<>();
        //添加当日更新的数据
        DayNew dayNew = new DayNew(list);
        HotProject hotProject = new HotProject(getActivity(), view, list);
        //初始化适配器
        MyRecyclerViewAdapter mAdapter = new MyRecyclerViewAdapter(getActivity(), list);
        //设置添加或删除item时的动画，这里使用默认动画
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);
    }

    /**
     * 根据百分比改变颜色透明度
     */
    public int changeAlpha(int color, float fraction) {
        int red = Color.red(color);
        int green = Color.green(color);
        int blue = Color.blue(color);
        int alpha = (int) (Color.alpha(color) * fraction);
        return Color.argb(alpha, red, green, blue);
    }
}
