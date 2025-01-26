package com.example.module_jar.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class JarTestView extends LinearLayout {

    public JarTestView(Context context) {
        this(context, null);
    }

    public JarTestView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public JarTestView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        setOrientation(VERTICAL);

        removeAllViews();
        addChildView("#FFD4973F");
        addChildView("#FF15B3B3");
        addChildView("#FFDFA178");
    }

    private void addChildView(String colorValue) {
        View view = new View(getContext());
        view.setBackgroundColor(Color.parseColor(colorValue));

        int viewHeight = (int) (getResources().getDisplayMetrics().density * 40.0f);
        LinearLayout.LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, viewHeight);
        addView(view, layoutParams);
    }
}