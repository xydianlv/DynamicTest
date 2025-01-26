package com.example.module_res.utils;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class ViewUtils {

    private ViewUtils() {

    }

    public static void setTextShow(@Nullable View view, @Nullable String textValue) {
        setTextShow(view, textValue, View.GONE);
    }

    public static void setTextShow(@Nullable View view, @Nullable String textValue, int onEmptyVisibility) {
        TextView textView = view instanceof TextView ? (TextView) view : null;
        if (textView == null) {
            return;
        }
        if (TextUtils.isEmpty(textValue)) {
            textView.setVisibility(onEmptyVisibility);
        } else {
            textView.setVisibility(View.VISIBLE);
            textView.setText(textValue);
        }
    }
}
