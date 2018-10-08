package com.ilang.ilang.tech.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ilang.ilang.tech.R;

/**
 * Created by YoKeyword on 16/6/3.
 */
public class BottomBarTab extends LinearLayout {
    private ImageView mIcon;
    private Context mContext;
    private int mTabPosition = -1;
    private TextView mText;

    public BottomBarTab(Context context, @DrawableRes int icon, @StringRes int text) {
        this(context, null, icon,text);
    }

    public BottomBarTab(Context context, AttributeSet attrs, int icon,@StringRes int text) {
        this(context, attrs, 0, icon,text);
    }

    public BottomBarTab(Context context, AttributeSet attrs, int defStyleAttr, int icon,@StringRes int text) {
        super(context, attrs, defStyleAttr);
        init(context, icon,text);
    }

    private void init(Context context, int icon,int text) {
        mContext = context;
        TypedArray typedArray = context.obtainStyledAttributes(new int[]{R.attr.selectableItemBackgroundBorderless});
        Drawable drawable = typedArray.getDrawable(0);
        setBackgroundDrawable(drawable);
        typedArray.recycle();

        mIcon = new ImageView(context);
        int size = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20, getResources().getDisplayMetrics());
        LayoutParams params = new LayoutParams(size, size);
        params.gravity = Gravity.CENTER;
        mIcon.setImageResource(icon);
        mIcon.setLayoutParams(params);
        mIcon.setColorFilter(ContextCompat.getColor(context, R.color.tab_unselect));

        mText = new TextView(context);
        LayoutParams textParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        mText.setLayoutParams(textParams);
        mText.setTextSize(12);
        mText.setText(text);

        setOrientation(LinearLayout.VERTICAL);
        setGravity(Gravity.CENTER);

        addView(mIcon);
        addView(mText);
    }

    @Override
    public void setSelected(boolean selected) {
        super.setSelected(selected);
        if (selected) {
            mIcon.setColorFilter(ContextCompat.getColor(mContext, R.color.colorPrimary));
            mText.setTextColor(ContextCompat.getColor(mContext, R.color.colorPrimary));
        } else {
            mIcon.setColorFilter(ContextCompat.getColor(mContext, R.color.tab_unselect));
            mText.setTextColor(ContextCompat.getColor(mContext, R.color.tab_unselect));
        }
    }

    public void setTabPosition(int position) {
        mTabPosition = position;
        if (position == 0) {
            setSelected(true);
        }
    }

    public int getTabPosition() {
        return mTabPosition;
    }

}
