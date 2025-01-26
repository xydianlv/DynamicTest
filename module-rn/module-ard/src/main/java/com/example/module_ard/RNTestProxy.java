package com.example.module_ard;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.module_ard.activity.RNDynamicActivity;
import com.example.module_ard.activity.RNTestActivity;
import com.example.module_ard.activity.RNTestFullActivity;
import com.example.module_ard.fragment.RNFragmentBuilder;
import com.example.module_ard.view.RNViewBuilder;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.shell.MainReactPackage;

import java.io.File;

public class RNTestProxy {

    private RNTestProxy() {

    }

    public static void tryOpenTestActivity(@NonNull Context context) {
        context.startActivity(new Intent(context, RNTestActivity.class));
    }

    public static void tryOpenTestFullActivity(@NonNull Context context) {
        context.startActivity(new Intent(context, RNTestFullActivity.class));
    }

    public static void tryOpenTestDynamicActivity(@NonNull Context context) {
        context.startActivity(new Intent(context, RNDynamicActivity.class));
    }

    public static Fragment getFragment() {
        return RNFragmentBuilder.buildRNFragment();
    }

    public static ReactInstanceManager tryBuildManager(@NonNull Activity activity) {
        return ReactInstanceManager.builder()
                .setApplication(activity.getApplication())
                .setCurrentActivity(activity)
                .setBundleAssetName("index.android.bundle")
                .setJSMainModulePath("index")
                .addPackage(new MainReactPackage())
                .setInitialLifecycleState(LifecycleState.RESUMED)
                .build();
    }

    public static View getRnView(@NonNull Activity activity) {
        return RNViewBuilder.getView(activity);
    }

    public static String getExtraBundlePath(@NonNull Context context) {
        return getExtraFilePath(context) + "index.android.bundle";
    }

    @NonNull
    public static String getExtraFilePath(@NonNull Context context) {
        try {
            File innerFile = context.getCacheDir();
            File extraFile = context.getExternalFilesDir(null);
            if (extraFile == null) {
                return "";
            } else {
                return extraFile.getAbsolutePath() + "/";
            }
        } catch (Exception e) {
            return "";
        }
    }
}
