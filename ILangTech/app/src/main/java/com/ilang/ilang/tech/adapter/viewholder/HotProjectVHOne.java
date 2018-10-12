package com.ilang.ilang.tech.adapter.viewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ilang.ilang.tech.R;
import com.ilang.ilang.tech.view.ExpandableTextView;
import com.sunfusheng.GlideImageView;

public class HotProjectVHOne extends RecyclerView.ViewHolder {
    public GlideImageView glideImageView;
    public ExpandableTextView expand_text_view;

    public HotProjectVHOne(@NonNull View itemView) {
        super(itemView);
        glideImageView = itemView.findViewById(R.id.item_frg_first_one_medium);
        expand_text_view = itemView.findViewById(R.id.expand_text_view);
    }
}
