package com.example.module_jar.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.example.module_res.views.ViewTest01;
import com.example.module_res.views.ViewTest02;


public class JarTestLayout extends LinearLayout {

    public JarTestLayout(Context context) {
        this(context, null);
    }

    public JarTestLayout(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public JarTestLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initLayout();
    }

    private void initLayout() {
        setOrientation(LinearLayout.VERTICAL);

        removeAllViews();
        addChildView01();
        addChildView02();
    }

    private void addChildView01() {
        ViewTest01 childView01 = new ViewTest01(getContext());
        childView01.setDescShow("JarTestLayout");
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        addView(childView01, params);
    }

    private void addChildView02() {
        ViewTest02 childView02 = new ViewTest02(getContext());
        childView02.setTv00Show("JarTestLayout");
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        addView(childView02, params);
    }
}
