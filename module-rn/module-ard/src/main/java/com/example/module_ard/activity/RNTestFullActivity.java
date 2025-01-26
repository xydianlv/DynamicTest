package com.example.module_ard.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.module_ard.RNTestProxy;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactRootView;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.shell.MainReactPackage;
import com.facebook.soloader.SoLoader;

public class RNTestFullActivity extends AppCompatActivity {

    private ReactInstanceManager manager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SoLoader.init(this, false);

        ReactRootView rootView = new ReactRootView(this);
        manager = ReactInstanceManager.builder()
                .setApplication(getApplication())
                .setCurrentActivity(this)
                //.setBundleAssetName("index.android.bundle")
                .setJSMainModulePath("index")
                .setJSBundleFile(RNTestProxy.getExtraBundlePath(this))
                .addPackage(new MainReactPackage())
                .setInitialLifecycleState(LifecycleState.RESUMED)
                .build();
        rootView.startReactApplication(manager, "module_test", null);
        manager.destroy();

        setContentView(rootView);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (manager != null) {
            manager.onHostPause(this);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (manager != null) {
            manager.onHostResume(this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (manager != null) {
            manager.onHostDestroy(this);
        }
    }
}
