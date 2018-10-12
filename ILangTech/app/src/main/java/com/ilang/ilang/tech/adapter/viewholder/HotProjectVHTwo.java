package com.ilang.ilang.tech.adapter.viewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ilang.ilang.tech.R;
import com.sunfusheng.GlideImageView;

public class HotProjectVHTwo extends RecyclerView.ViewHolder {
    public GlideImageView glideImageView;
    public HotProjectVHTwo(@NonNull View itemView) {
        super(itemView);
        glideImageView=itemView.findViewById(R.id.item_frg_first_one_medium);
    }
}
