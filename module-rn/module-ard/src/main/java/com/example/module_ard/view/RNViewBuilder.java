package com.example.module_ard.view;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;

import com.example.module_ard.RNTestProxy;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactRootView;

public class RNViewBuilder {

    private RNViewBuilder() {

    }

    public static ReactRootView getView(@NonNull Activity activity) {
        ReactRootView view = new ReactRootView(activity);
        Bundle bundle = new Bundle();
        bundle.putInt("key-int", 0);
        view.startReactApplication(RNTestProxy.tryBuildManager(activity), "module_test", bundle);
        return view;
    }
}
