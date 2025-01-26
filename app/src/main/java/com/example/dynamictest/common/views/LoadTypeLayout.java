package com.example.dynamictest.common.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.example.dynamictest.R;
import com.example.dynamictest.common.data.LoadType;

public class LoadTypeLayout extends LinearLayout {

    public LoadTypeLayout(Context context) {
        this(context, null);
    }

    public LoadTypeLayout(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LoadTypeLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private static final int VIEW_COUNT = 3;

    private TextView[] viewArray;

    @Nullable
    private OnLoadTypeClickListener listener;

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_load_type_layout, this);

        viewArray = new TextView[VIEW_COUNT];
        viewArray[0] = findViewById(R.id.tv_load_view);
        viewArray[0].setTag(LoadType.VIEW);
        viewArray[0].setText(LoadType.VIEW.typeName);
        viewArray[1] = findViewById(R.id.tv_load_frag);
        viewArray[1].setTag(LoadType.FRAGMENT);
        viewArray[1].setText(LoadType.FRAGMENT.typeName);
        viewArray[2] = findViewById(R.id.tv_load_act);
        viewArray[2].setTag(LoadType.ACTIVITY);
        viewArray[2].setText(LoadType.ACTIVITY.typeName);

        View.OnClickListener onClickListener = v -> {
            Object tagValue = v.getTag();
            if (listener != null && tagValue instanceof LoadType) {
                listener.onClick((LoadType) tagValue);
            }
        };
        for (TextView view : viewArray) {
            view.setOnClickListener(onClickListener);
        }
    }

    public void setOnLoadTypeClickListener(@NonNull OnLoadTypeClickListener listener) {
        this.listener = listener;
    }

    public void refreshOnSelectedType(@NonNull LoadType loadType) {
        for (TextView view : viewArray) {
            Object tagValue = view.getTag();
            if (tagValue instanceof LoadType) {
                @ColorRes int colorValue = ((LoadType) tagValue) == loadType ? com.example.module_res.R.color.color_alert : com.example.module_res.R.color.ct_3;
                view.setTextColor(ContextCompat.getColor(getContext(), colorValue));
            }
        }
    }
}
