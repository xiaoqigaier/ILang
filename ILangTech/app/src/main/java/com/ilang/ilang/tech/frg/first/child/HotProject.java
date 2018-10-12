package com.ilang.ilang.tech.frg.first.child;

import android.content.Context;
import android.view.View;

import com.ilang.ilang.tech.model.IdeaBean;

import java.util.List;

public class HotProject {
    private Context context;
    private View view;
    public HotProject(Context context, View view,List<IdeaBean> list) {
        this.context=context;
        this.view=view;
        initView(list);
    }

    private void initView(List<IdeaBean> list) {

        if(context==null||view==null||list==null){
            return;
        }

        if (list == null) {
            return;
        }

        IdeaBean ideaBean1 = new IdeaBean();
        ideaBean1.setDataType(0);
        IdeaBean ideaBean2 = new IdeaBean();
        ideaBean2.setIdeaBackImg("http://img5.duitang.com/uploads/item/201606/11/20160611122009_fsu2A.jpeg");
        ideaBean2.setDataType(3);
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
    }
}
