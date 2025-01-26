package com.example.module_api;

import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public interface IActivityProvider {

    @Nullable
    Intent getIntent(@NonNull Context context, int type);
}
