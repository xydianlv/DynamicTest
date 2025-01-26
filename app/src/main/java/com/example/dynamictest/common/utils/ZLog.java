package com.example.dynamictest.common.utils;

import android.util.Log;

import androidx.annotation.Nullable;

public class ZLog {

    private ZLog() {

    }

    public static void logD(@Nullable String logInfo) {
        Log.d("ZLog", logInfo == null ? "" : logInfo);
    }

    public static void logE(@Nullable Exception e) {
        logE(e == null ? null : e.getMessage());
    }

    public static void logE(@Nullable String errorMsg) {
        Log.e("ZLog", errorMsg == null ? "" : errorMsg);
    }
}
