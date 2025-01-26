package com.example.dynamictest.common.utils;

import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import com.example.module_res.R;

public class AlertUtils {

    private AlertUtils() {

    }

    public static void addAlert(@NonNull FrameLayout flContainer, @NonNull String alertMsg) {
        TextView textView = new TextView(flContainer.getContext());
        textView.setTextSize(14.0f);
        textView.setTextColor(ContextCompat.getColor(flContainer.getContext(), R.color.color_alert));
        textView.setText(alertMsg);
        textView.setGravity(Gravity.CENTER);

        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.setMarginStart(40);
        params.setMarginEnd(40);
        params.gravity = Gravity.CENTER;
        flContainer.addView(textView, params);
    }
}
