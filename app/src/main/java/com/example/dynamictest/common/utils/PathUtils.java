package com.example.dynamictest.common.utils;

import android.content.Context;

import androidx.annotation.NonNull;

import java.io.File;

public class PathUtils {

    private PathUtils() {

    }

    @NonNull
    public static String getExtraFilePath(@NonNull Context context) {
        try {
            File extraFile = context.getExternalFilesDir(null);
            if (extraFile == null) {
                return "";
            } else {
                return extraFile.getAbsolutePath() + "/";
            }
        } catch (Exception e) {
            ZLog.logE(e);
            return "";
        }
    }

    @NonNull
    public static String getInnerCachePath(@NonNull Context context) {
        try {
            return context.getCacheDir().getAbsolutePath() + "/";
        } catch (Exception e) {
            ZLog.logE(e);
            return "";
        }
    }
}
