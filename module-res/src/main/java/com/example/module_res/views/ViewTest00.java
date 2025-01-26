package com.example.module_res.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.module_res.R;
import com.example.module_res.utils.ViewUtils;

public class ViewTest00 extends ConstraintLayout {

    public ViewTest00(Context context) {
        this(context, null);
    }

    public ViewTest00(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ViewTest00(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private TextView tvTitle;
    private TextView tvDesc;

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.res_view_test_00, this);

        tvTitle = findViewById(R.id.tv_title);
        tvDesc = findViewById(R.id.tv_desc);
    }

    public void setTest00Show(@Nullable String titleValue, @Nullable String descValue) {
        ViewUtils.setTextShow(tvTitle, titleValue);
        ViewUtils.setTextShow(tvDesc, descValue);
    }
}
