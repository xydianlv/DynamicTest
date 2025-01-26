package com.example.module_ard.activity;

import com.example.module_ard.RNTestProxy;
import com.example.module_ard.helper.RNLocalLoadDelegate;
import com.facebook.react.ReactActivity;
import com.facebook.react.ReactActivityDelegate;
import com.facebook.react.ReactInstanceManager;

public class RNDynamicActivity extends ReactActivity {

    private static final String BUNDLE_NAME = "index.android.bundle";

    private ReactInstanceManager manager;

    @Override
    protected ReactActivityDelegate createReactActivityDelegate() {
        return new RNLocalLoadDelegate(this, BUNDLE_NAME);
    }

    @Override
    protected String getMainComponentName() {
        return "module_nod";
    }

}
