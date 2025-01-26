package com.example.dynamictest.common.data;

import androidx.annotation.NonNull;

public enum DynamicType {

    JAR("Jar"),
    FLUTTER("Flutter"),
    RN("RN"),
    DSL("DSL");

    @NonNull
    public final String typeName;

    DynamicType(@NonNull String typeName) {
        this.typeName = typeName;
    }
}
