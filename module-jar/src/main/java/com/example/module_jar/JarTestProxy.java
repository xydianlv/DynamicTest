package com.example.module_jar;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.module_api.IFragmentProvider;
import com.example.module_api.IViewProvider;
import com.example.module_jar.fragment.JarTestLayoutFragment;
import com.example.module_jar.fragment.JavaTestFragment;
import com.example.module_jar.view.JarTestLayout;
import com.example.module_jar.view.JarTestView;

public class JarTestProxy implements IViewProvider, IFragmentProvider {

    @Nullable
    @Override
    public Fragment getFragment(@NonNull Context context, int type) {
        if (type == 0) {
            return new JavaTestFragment();
        } else {
            return new JarTestLayoutFragment();
        }
    }

    @Nullable
    @Override
    public View getView(@NonNull Context context, int type) {
        if (type == 0) {
            return new JarTestView(context);
        } else {
            return new JarTestLayout(context);
        }
    }
}
