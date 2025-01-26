package com.example.module_res.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.ColorRes;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import com.example.module_res.R;
import com.example.module_res.utils.ViewUtils;

public class ViewTest02 extends ConstraintLayout {

    public ViewTest02(Context context) {
        this(context, null);
    }

    public ViewTest02(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ViewTest02(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private View clRoot;
    private TextView tv00;
    private TextView tv01;
    private TextView tv02;

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.res_view_test_02, this);

        clRoot = findViewById(R.id.cl_root);
        tv00 = findViewById(R.id.tv_00);
        tv01 = findViewById(R.id.tv_01);
        tv02 = findViewById(R.id.tv_02);
    }

    public void setBackColor(@ColorRes int color) {
        if (clRoot != null) {
            clRoot.setBackgroundColor(ContextCompat.getColor(getContext(), color));
        }
    }

    public void setTv00Show(@Nullable String textValue) {
        ViewUtils.setTextShow(tv00, textValue);
    }

    public void setTv01Show(@Nullable String textValue) {
        ViewUtils.setTextShow(tv01, textValue);
    }

    public void setTv02Show(@Nullable String textValue) {
        ViewUtils.setTextShow(tv02, textValue);
    }
}
