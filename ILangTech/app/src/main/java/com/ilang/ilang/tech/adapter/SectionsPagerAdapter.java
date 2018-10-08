package com.ilang.ilang.tech.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.ilang.ilang.tech.frg.first.FirstFrg;
import com.ilang.ilang.tech.frg.five.FiveFrg;
import com.ilang.ilang.tech.frg.four.FourFrg;
import com.ilang.ilang.tech.frg.second.SecondFrg;
import com.ilang.ilang.tech.frg.three.ThreeFrg;

/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        if (position == 0) {
            return FirstFrg.newInstance(position);
        } else if (position == 1) {
            return SecondFrg.newInstance(position);
        } else if (position == 2) {
            return ThreeFrg.newInstance(position);
        } else if (position == 3) {
            return FourFrg.newInstance(position);
        } else if (position == 4) {
            return FiveFrg.newInstance(position);
        }
        return FirstFrg.newInstance(position + 1);
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 5;
    }
}
