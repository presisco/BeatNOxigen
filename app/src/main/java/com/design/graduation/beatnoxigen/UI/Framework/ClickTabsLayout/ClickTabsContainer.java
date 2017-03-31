package com.design.graduation.beatnoxigen.UI.Framework.ClickTabsLayout;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

/**
 * Created by presisco on 2016/4/11.
 */
public class ClickTabsContainer extends HorizontalScrollView {
    private LinearLayout mTabsContainerLayout;

    public ClickTabsContainer(Context context) {
        super(context, null);
    }

    public ClickTabsContainer(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
        setHorizontalScrollBarEnabled(false);
        setFillViewport(true);
        mTabsContainerLayout = new LinearLayout(context);
        mTabsContainerLayout.setOrientation(LinearLayout.HORIZONTAL);
        addView(mTabsContainerLayout, LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
    }

    public LinearLayout getLayout() {
        return mTabsContainerLayout;
    }
}