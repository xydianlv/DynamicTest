package com.example.dynamictest.module.jar.helper;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.dynamictest.common.utils.PathUtils;
import com.example.module_api.IFragmentProvider;
import com.example.module_api.IViewProvider;

import java.io.File;

import dalvik.system.DexClassLoader;

public class JarFileLoaderHelper {

    private JarFileLoaderHelper() {

    }

    @Nullable
    public static View loadViewFromJar(@NonNull Context context, int type) {
        try {
            File jarFile = new File(getExtraJarPath(context));
            if (!jarFile.exists()) {
                return null;
            }
            String extraPath = jarFile.getAbsolutePath();
            String innerPath = getInnerJarPath(context);
            DexClassLoader classLoader = new DexClassLoader(extraPath, innerPath, null, context.getClassLoader());

            Class<?> classValue = classLoader.loadClass(getClassName());
            Object classObj = classValue.getDeclaredConstructor().newInstance();
            if (classObj instanceof IViewProvider) {
                return ((IViewProvider) classObj).getView(context, type);
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    private static String getExtraJarPath(@NonNull Context context) {
        return PathUtils.getExtraFilePath(context) + "jarTest-dex.jar";
    }

    private static String getInnerJarPath(@NonNull Context context) {
        return PathUtils.getInnerCachePath(context) + "jarTest-dex.jar";
    }

    @NonNull
    private static String getClassName() {
        return "com/example/module_jar/JarTestProxy";
    }

    @Nullable
    public static Fragment loadFragmentFromJar(@NonNull Context context, int type) {
        try {
            File jarFile = new File(getExtraJarPath(context));
            if (!jarFile.exists()) {
                return null;
            }
            String extraPath = jarFile.getAbsolutePath();
            String innerPath = getInnerJarPath(context);
            DexClassLoader classLoader = new DexClassLoader(extraPath, innerPath, null, context.getClassLoader());

            Class<?> classValue = classLoader.loadClass(getClassName());
            Object classObj = classValue.getDeclaredConstructor().newInstance();
            if (classObj instanceof IFragmentProvider) {
                return ((IFragmentProvider) classObj).getFragment(context, type);
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
}
