package com.ilang.ilang.tech.frg.three;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ilang.ilang.tech.R;

import me.yokeyword.fragmentation.SupportFragment;

public class ThreeFrg extends SupportFragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    public ThreeFrg() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static ThreeFrg newInstance(int sectionNumber) {
        ThreeFrg fragment = new ThreeFrg();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.frg_three, container, false);
        return rootView;
    }

}
