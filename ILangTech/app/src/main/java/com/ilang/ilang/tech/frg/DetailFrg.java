package com.ilang.ilang.tech.frg;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ilang.ilang.tech.R;

public class DetailFrg extends Fragment {

    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    public DetailFrg() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static DetailFrg newInstance(int sectionNumber) {
        DetailFrg fragment = new DetailFrg();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.frg_detail, container, false);
        return rootView;
    }

}
