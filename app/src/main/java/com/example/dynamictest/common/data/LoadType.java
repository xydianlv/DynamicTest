package com.example.dynamictest.common.data;

import androidx.annotation.NonNull;

public enum LoadType {

    VIEW("View"),
    FRAGMENT("Fragment"),
    ACTIVITY("Activity");

    @NonNull
    public final String typeName;

    LoadType(@NonNull String typeName) {
        this.typeName = typeName;
    }
}
