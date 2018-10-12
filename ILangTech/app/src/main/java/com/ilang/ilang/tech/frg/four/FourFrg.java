package com.ilang.ilang.tech.frg.four;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ilang.ilang.tech.R;

import me.yokeyword.fragmentation.SupportFragment;

public class FourFrg extends SupportFragment implements SwipeRefreshLayout.OnRefreshListener {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private SwipeRefreshLayout mRefreshLayout;

    public FourFrg() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static FourFrg newInstance(int sectionNumber) {
        FourFrg fragment = new FourFrg();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.frg_four, container, false);
        initView(rootView);
        return rootView;
    }

    private void initView(View view) {
        mRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.refresh_layout);
        mRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        mRefreshLayout.setOnRefreshListener(this);
    }

    @Override
    public void onRefresh() {
        mRefreshLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                mRefreshLayout.setRefreshing(false);
            }
        }, 2000);
    }
}
