package com.ilang.ilang.tech.frg.first.child;

import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ilang.ilang.tech.R;
import com.ilang.ilang.tech.adapter.MyRecyclerViewAdapter;
import com.ilang.ilang.tech.model.IdeaBean;

import java.util.ArrayList;
import java.util.List;

public class DayNew {
    private Context context;
    private View view;

    public DayNew(Context context, View view) {
        this.context = context;
        this.view = view;
        initView(view);
    }

    private void initView(View view) {
        RecyclerView mRecyclerView = view.findViewById(R.id.frg_first_recyclerView);
        //设置RecyclerView管理器
        mRecyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));

        List<IdeaBean> list = new ArrayList<>();
        IdeaBean ideaBean1 = new IdeaBean();
        ideaBean1.setDataType(0);
        IdeaBean ideaBean2 = new IdeaBean();
        ideaBean2.setIdeaBackImg("http://img5.duitang.com/uploads/item/201606/11/20160611122009_fsu2A.jpeg");
        ideaBean2.setDataType(1);
        IdeaBean ideaBean3 = new IdeaBean();
        ideaBean3.setIdeaBackImg("http://b-ssl.duitang.com/uploads/item/201406/02/20140602131853_xdkMr.thumb.700_0.jpeg");
        ideaBean3.setDataType(2);
        IdeaBean ideaBean4 = new IdeaBean();
        ideaBean4.setIdeaBackImg("http://img.mp.itc.cn/upload/20170209/7364c3bcaf17426fbbbce4dc8adb6434_th.jpeg");
        ideaBean4.setDataType(2);

        list.add(ideaBean1);
        list.add(ideaBean2);
        list.add(ideaBean3);
        list.add(ideaBean4);

        //初始化适配器
        MyRecyclerViewAdapter mAdapter = new MyRecyclerViewAdapter(context, list);
        //设置添加或删除item时的动画，这里使用默认动画
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);
    }


}
