package com.example.module_api;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public interface IViewProvider {

    @Nullable
    View getView(@NonNull Context context, int type);
}
