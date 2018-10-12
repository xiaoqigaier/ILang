package com.ilang.ilang.tech.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ilang.ilang.tech.R;
import com.ilang.ilang.tech.adapter.viewholder.DayNewVHOne;
import com.ilang.ilang.tech.adapter.viewholder.DayNewVHTwo;
import com.ilang.ilang.tech.adapter.viewholder.DayNewVHZero;
import com.ilang.ilang.tech.adapter.viewholder.HotProjectVHOne;
import com.ilang.ilang.tech.adapter.viewholder.HotProjectVHTwo;
import com.ilang.ilang.tech.model.IdeaBean;
import com.ilang.ilang.tech.view.ExpandableTextView;

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
            View view = LayoutInflater.from(context).inflate(R.layout.item_frg_first_daynew_one, null);
            viewHolder = new DayNewVHOne(view);
        } else if (viewType == 2) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_frg_first_daynew_two, null);
            viewHolder = new DayNewVHTwo(view);
        } else if (viewType == 3) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_frg_first_hotproject_one, null);
            viewHolder = new HotProjectVHOne(view);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        if (viewHolder instanceof DayNewVHOne) {
            ((DayNewVHOne) viewHolder).glideImageView.load(ideaBeans.get(position).getIdeaBackImg());
        } else if (viewHolder instanceof DayNewVHTwo) {
            ((DayNewVHTwo) viewHolder).glideImageView.load(ideaBeans.get(position).getIdeaBackImg());
        } else if (viewHolder instanceof HotProjectVHOne) {
            ((HotProjectVHOne) viewHolder).glideImageView.load(ideaBeans.get(position).getIdeaBackImg());
            ((HotProjectVHOne) viewHolder).expand_text_view.setOnExpandStateChangeListener(new ExpandableTextView.OnExpandStateChangeListener() {
                @Override
                public void onExpandStateChanged(TextView textView, boolean isExpanded) {
                }
            });
            ((HotProjectVHOne) viewHolder).expand_text_view.setText("Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean. A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth. Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic life One day however a small line of blind text by the name of Lorem Ipsum decided to leave for the far World of Grammar.");

        } else if (viewHolder instanceof HotProjectVHTwo) {
            ((HotProjectVHTwo) viewHolder).glideImageView.load(ideaBeans.get(position).getIdeaBackImg());
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
