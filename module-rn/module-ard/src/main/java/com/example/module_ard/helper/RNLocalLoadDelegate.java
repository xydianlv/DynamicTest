package com.example.module_ard.helper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.module_ard.RNTestProxy;
import com.facebook.react.ReactActivity;
import com.facebook.react.ReactActivityDelegate;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;

import java.util.ArrayList;
import java.util.List;

public class RNLocalLoadDelegate extends ReactActivityDelegate {

    @NonNull
    private final ReactActivity activity;
    @NonNull
    private final String bundleName;

    public RNLocalLoadDelegate(@NonNull ReactActivity activity, @NonNull String bundleName) {
        super(activity, bundleName);
        this.activity = activity;
        this.bundleName = bundleName;
    }

    @Override
    protected ReactNativeHost getReactNativeHost() {

        return new ReactNativeHost(activity.getApplication()) {
            @Override
            public boolean getUseDeveloperSupport() {
                return true;
            }

            @Override
            protected List<ReactPackage> getPackages() {
                List<ReactPackage> list = new ArrayList<>();
                list.add(new MainReactPackage());
                return list;
            }

            @Override
            protected String getJSBundleFile() {
                return RNTestProxy.getExtraBundlePath(activity);
            }

            @Override
            protected String getBundleAssetName() {
                return bundleName + ".bundle";
            }
        };
    }
}
