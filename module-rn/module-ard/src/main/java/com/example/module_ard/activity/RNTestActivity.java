package com.example.module_ard.activity;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.module_ard.R;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactRootView;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.shell.MainReactPackage;
import com.facebook.soloader.SoLoader;

public class RNTestActivity extends AppCompatActivity {

    private FrameLayout flContainer;
    private ReactInstanceManager manager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SoLoader.init(this, false);

        setContentView(R.layout.module_ard_activity_rn_test);
        initActivity();
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

    private void initActivity() {
        initView();
        initReact();
    }

    private void initView() {
        TextView tvTitle = findViewById(R.id.tv_title);
        String titleValue = "RNTestActivity";
        tvTitle.setText(titleValue);

        flContainer = findViewById(R.id.fl_container);
    }

    private void initReact() {
        ReactRootView rootView = new ReactRootView(this);
        manager = ReactInstanceManager.builder()
                .setApplication(getApplication())
                .setCurrentActivity(this)
                .setBundleAssetName("index.android.bundle")
                .setJSMainModulePath("index")
                .addPackage(new MainReactPackage())
                .setInitialLifecycleState(LifecycleState.RESUMED)
                .build();
        rootView.startReactApplication(manager, "module_nod", null);

        flContainer.removeAllViews();
        flContainer.addView(rootView, new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
    }
}
