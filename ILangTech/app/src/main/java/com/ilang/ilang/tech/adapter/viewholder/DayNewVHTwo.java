package com.ilang.ilang.tech.adapter.viewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ilang.ilang.tech.R;
import com.sunfusheng.GlideImageView;

public class DayNewVHTwo extends RecyclerView.ViewHolder {
    public GlideImageView glideImageView;

    public DayNewVHTwo(@NonNull View itemView) {
        super(itemView);
        glideImageView = itemView.findViewById(R.id.item_frg_first_two_medium);
    }
}
