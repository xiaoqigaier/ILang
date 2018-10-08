package com.ilang.ilang.tech.frg.second;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ilang.ilang.tech.R;

import me.yokeyword.fragmentation.SupportFragment;

public class SecondFrg extends SupportFragment{

    private static final String ARG_SECTION_NUMBER = "section_number";

    public SecondFrg() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static SecondFrg newInstance(int sectionNumber) {
        SecondFrg fragment = new SecondFrg();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.frg_second, container, false);
        return rootView;
    }

}
