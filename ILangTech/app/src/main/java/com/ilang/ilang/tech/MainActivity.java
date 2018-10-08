package com.ilang.ilang.tech;

import android.os.Bundle;

import com.ilang.ilang.tech.frg.first.FirstFrg;
import com.ilang.ilang.tech.frg.five.FiveFrg;
import com.ilang.ilang.tech.frg.four.FourFrg;
import com.ilang.ilang.tech.frg.second.SecondFrg;
import com.ilang.ilang.tech.frg.three.ThreeFrg;
import com.ilang.ilang.tech.view.BottomBar;
import com.ilang.ilang.tech.view.BottomBarTab;

import cn.jzvd.Jzvd;
import me.yokeyword.fragmentation.SupportActivity;
import me.yokeyword.fragmentation.SupportFragment;

public class MainActivity extends SupportActivity {
    public static final int FIRST = 0;
    public static final int SECOND = 1;
    public static final int THIRD = 2;
    public static final int FOURTH = 3;
    public static final int FIFTH = 4;
    private BottomBar mBottomBar;
    private SupportFragment[] mFragments = new SupportFragment[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBottomBar = (BottomBar) findViewById(R.id.bottomBar);
        SupportFragment firstFragment = findFragment(FirstFrg.class);
        if (firstFragment == null) {
            mFragments[FIRST] = FirstFrg.newInstance(0);
            mFragments[SECOND] = SecondFrg.newInstance(0);
            mFragments[THIRD] = ThreeFrg.newInstance(0);
            mFragments[FOURTH] = FourFrg.newInstance(0);
            mFragments[FIFTH] = FiveFrg.newInstance(0);

            loadMultipleRootFragment(R.id.fl_container, FIRST,
                    mFragments[FIRST],
                    mFragments[SECOND],
                    mFragments[THIRD],
                    mFragments[FOURTH],
                    mFragments[FIFTH]);
        } else {
            // 这里库已经做了Fragment恢复,所有不需要额外的处理了, 不会出现重叠问题
            // 这里我们需要拿到mFragments的引用
            mFragments[FIRST] = firstFragment;
            mFragments[SECOND] = findFragment(SecondFrg.class);
            mFragments[THIRD] = findFragment(ThreeFrg.class);
            mFragments[FOURTH] = findFragment(FourFrg.class);
            mFragments[FIFTH] = findFragment(FiveFrg.class);
        }
        initView();
    }

    public void initView() {
        mBottomBar.addItem(new BottomBarTab(this, R.mipmap.home_home_button, R.string.home_button_home))
                .addItem(new BottomBarTab(this, R.mipmap.create_home_button, R.string.home_button_create))
                .addItem(new BottomBarTab(this, R.mipmap.game_home_button, R.string.home_button_game))
                .addItem(new BottomBarTab(this, R.mipmap.kind_home_button, R.string.home_button_kind))
                .addItem(new BottomBarTab(this, R.mipmap.me_home_button, R.string.home_button_me));

        mBottomBar.setOnTabSelectedListener(new BottomBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position, int prePosition) {
                showHideFragment(mFragments[position], mFragments[prePosition]);
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });
    }

    @Override
    public void onBackPressedSupport() {
        if (Jzvd.backPress()) {
            return;
        }
        super.onBackPressedSupport();
    }

    @Override
    public void onPause() {
        super.onPause();
        Jzvd.releaseAllVideos();
    }

}
