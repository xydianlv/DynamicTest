package com.example.module_api;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public interface IFragmentProvider {

    @Nullable
    Fragment getFragment(@NonNull Context context, int type);
}
