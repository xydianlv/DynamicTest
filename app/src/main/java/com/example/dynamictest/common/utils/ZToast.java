package com.example.dynamictest.common.utils;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;

public class ZToast {

    private ZToast() {

    }

    public static void show(@NonNull Context context, @NonNull String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}
