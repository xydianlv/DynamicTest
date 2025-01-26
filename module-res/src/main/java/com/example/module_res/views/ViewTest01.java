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

public class ViewTest01 extends ConstraintLayout {

    public ViewTest01(Context context) {
        this(context, null);
    }

    public ViewTest01(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ViewTest01(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private View vTop;
    private View vBot;
    private TextView tvDesc;

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.res_view_test_01, this);

        vTop = findViewById(R.id.v_top);
        vBot = findViewById(R.id.v_bot);
        tvDesc = findViewById(R.id.tv_desc);
    }

    public void setDescShow(@Nullable String descValue) {
        ViewUtils.setTextShow(tvDesc, descValue);
    }

    public void setVTopShow(boolean show, @ColorRes int colorValue) {
        setViewShow(vTop, show, colorValue);
    }

    public void setVBotShow(boolean show, @ColorRes int colorValue) {
        setViewShow(vBot, show, colorValue);
    }

    private void setViewShow(@Nullable View view, boolean show, @ColorRes int colorValue) {
        if (view == null) {
            return;
        }
        view.setVisibility(show ? VISIBLE : GONE);
        view.setBackgroundColor(ContextCompat.getColor(getContext(), colorValue));
    }
}
