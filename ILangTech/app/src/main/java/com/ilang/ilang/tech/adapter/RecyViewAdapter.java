package com.ilang.ilang.tech.adapter;

import android.annotation.SuppressLint;
import android.support.annotation.IntDef;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

public class RecyViewAdapter extends RecyclerView.Adapter {

    List<View> mHeaderViews = new ArrayList<>();
    List<View> mFooterViews = new ArrayList<>();
    final RecyclerView.Adapter mAdapter;

    public RecyViewAdapter(RecyViewAdapter adapter) {
        if (adapter == null) {
            throw new IllegalArgumentException();
        }
        mAdapter = adapter;
        setHasStableIds(adapter.hasStableIds());
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        final int type = ViewTypeSpec.getType(viewType);
        final int value = ViewTypeSpec.getValue(viewType);

        if (type == ViewTypeSpec.HEADER) {
            viewHolder = new FixedViewHolder(mHeaderViews.get(value));
        } else if (type == ViewTypeSpec.FOOTER) {
            viewHolder = new FixedViewHolder(mFooterViews.get(value));
        } else {
            viewHolder = mAdapter.onCreateViewHolder(parent, viewType);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return mHeaderViews.size() + mFooterViews.size() + mAdapter.getItemCount();
    }

    @Override
    public int getItemViewType(int position) {
        final int numHeaderView = mHeaderViews.size();
//　　final int numFooterView = mFooterViewInfos.size();

        if (position < numHeaderView)
            return ViewTypeSpec.makeItemViewTypeSpec(position, ViewTypeSpec.HEADER);

        final int adjPosition = position - numHeaderView;
        final int itemCount = mAdapter.getItemCount();
        if (adjPosition >= itemCount)
            return ViewTypeSpec.makeItemViewTypeSpec(adjPosition - itemCount, ViewTypeSpec.FOOTER);

        int itemViewType = mAdapter.getItemViewType(adjPosition);
        if (itemViewType < 0 || itemViewType > (1 << ViewTypeSpec.TYPE_SHIFT) - 1) {
            throw new IllegalArgumentException("Invalid item view type: RecyclerView.Adapter.getItemViewType return " + itemViewType);
        }
        return itemViewType;
    }


    public void addHeaderView(View view) {
        if (mHeaderViews.add(view)) {
            mAdapter.notifyDataSetChanged();
        }
    }

    public void removeHeaderView(View view) {
        if (mHeaderViews.remove(view)) {
            mAdapter.notifyDataSetChanged();
        }
    }

    public void addFooterView(View view) {
        if (mFooterViews.add(view)) {
            mAdapter.notifyDataSetChanged();
        }
    }

    public void removeFooterView(View view) {
        if (mFooterViews.remove(view)) {
            mAdapter.notifyDataSetChanged();
        }
    }

    static class ViewTypeSpec {
        static final int TYPE_SHIFT = 30;
        static final int TYPE_MASK = 0x3 << TYPE_SHIFT;

        public static final int UNSPECIFIED = 0 << TYPE_SHIFT;
        public static final int HEADER = 1 << TYPE_SHIFT;
        public static final int FOOTER = 2 << TYPE_SHIFT;

        @IntDef({UNSPECIFIED, HEADER, FOOTER})
        @Retention(RetentionPolicy.SOURCE)
        public @interface ViewTypeSpecMode {
        }

        public static int makeItemViewTypeSpec(@IntRange(from = 0, to = (1 << TYPE_SHIFT) - 1) int value,
                                               @ViewTypeSpecMode int type) {
            return (value & ~TYPE_MASK) | (type & TYPE_MASK);
        }


        @ViewTypeSpecMode
        public static int getType(int viewType) {
            //noinspection ResourceType
            return (viewType & TYPE_MASK);
        }

        public static int getValue(int viewType) {
            return (viewType & ~TYPE_MASK);
        }
    }

    public static class FixedViewHolder extends RecyclerView.ViewHolder {

        public FixedViewHolder(View itemView) {
            super(itemView);
            setIsRecyclable(false);
        }

        public void onBind() {

        }
    }
}
