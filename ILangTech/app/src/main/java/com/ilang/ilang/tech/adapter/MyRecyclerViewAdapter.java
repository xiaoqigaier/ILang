package com.ilang.ilang.tech.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ilang.ilang.tech.R;
import com.ilang.ilang.tech.adapter.viewholder.DayNewVHOne;
import com.ilang.ilang.tech.adapter.viewholder.DayNewVHTwo;
import com.ilang.ilang.tech.adapter.viewholder.DayNewVHZero;
import com.ilang.ilang.tech.model.IdeaBean;

import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<IdeaBean> ideaBeans;

    public MyRecyclerViewAdapter(Context context, List<IdeaBean> list) {
        this.context = context;
        this.ideaBeans = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        if (viewType == 0) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_frg_first_zero, null);
            viewHolder = new DayNewVHZero(view);
        } else if (viewType == 1) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_frg_first_one, null);
            viewHolder = new DayNewVHOne(view);
        } else if (viewType == 2) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_frg_first_two, null);
            viewHolder = new DayNewVHTwo(view);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        if (viewHolder instanceof DayNewVHOne) {
            ((DayNewVHOne) viewHolder).glideImageView.load(ideaBeans.get(position).getIdeaBackImg());
        } else if (viewHolder instanceof DayNewVHTwo) {
            ((DayNewVHTwo) viewHolder).glideImageView.load(ideaBeans.get(position).getIdeaBackImg());
        }
    }

    @Override
    public int getItemCount() {
        if (ideaBeans == null || ideaBeans.size() == 0) {
            return 0;
        }
        return ideaBeans.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (ideaBeans != null && ideaBeans.size() != 0) {
            return ideaBeans.get(position).getDataType();
        }
        return super.getItemViewType(position);
    }
}
