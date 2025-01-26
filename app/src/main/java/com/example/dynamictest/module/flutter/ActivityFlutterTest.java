package com.example.dynamictest.module.flutter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.dynamictest.R;
import com.example.dynamictest.common.data.DynamicType;
import com.example.dynamictest.common.data.LoadType;
import com.example.dynamictest.common.utils.AlertUtils;
import com.example.dynamictest.common.utils.ZToast;
import com.example.dynamictest.common.views.LoadTypeLayout;
import com.example.dynamictest.module.flutter.open.ActivityFlutterOpenTypeList;
import com.example.module_org.fragment.FlutterFragProxy;
import com.example.module_org.helper.FlutterEngineKey;
import com.example.module_org.helper.FlutterEngineProxy;

import io.flutter.embedding.android.FlutterFragment;

public class ActivityFlutterTest extends AppCompatActivity {

    public static void open(@NonNull Context context) {
        context.startActivity(new Intent(context, ActivityFlutterTest.class));
    }

    private FrameLayout flContainerTop;
    private FrameLayout flContainerBot;
    private LoadTypeLayout loadTypeLayout;

    @Nullable
    private FlutterFragment fragmentTop;
    @Nullable
    private FlutterFragment fragmentBot;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_test);

        initActivity();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        if (fragmentTop != null) {
            fragmentTop.onPostResume();
        }
        if (fragmentBot != null) {
            fragmentBot.onPostResume();
        }
    }

    @Override
    protected void onNewIntent(@NonNull Intent intent) {
        super.onNewIntent(intent);
        if (fragmentTop != null) {
            fragmentTop.onPostResume();
        }
        if (fragmentBot != null) {
            fragmentBot.onPostResume();
        }
    }

    private void initActivity() {
        initView();
        initFlutterEngine();
        refreshLoadType(LoadType.VIEW);
    }

    private void initView() {
        TextView tvTitle = findViewById(R.id.tv_title);
        tvTitle.setText(DynamicType.FLUTTER.typeName);

        loadTypeLayout = findViewById(R.id.view_load_type);
        loadTypeLayout.setOnLoadTypeClickListener(this::refreshLoadType);

        flContainerTop = findViewById(R.id.fl_container_top);
        flContainerBot = findViewById(R.id.fl_container_bot);
    }

    private void refreshLoadType(@NonNull LoadType loadType) {
        loadTypeLayout.refreshOnSelectedType(loadType);
        if (loadType == LoadType.VIEW) {
            showFlutterView();
        } else if (loadType == LoadType.FRAGMENT) {
            showFlutterFrag();
        } else if (loadType == LoadType.ACTIVITY) {
            tryLaunchFlutterActivity();
        }
    }

    private void initFlutterEngine() {
        FlutterEngineProxy.cacheEngine(FlutterEngineKey.KEY_TEST, this);
        FlutterEngineProxy.cacheEngine(FlutterEngineKey.KEY_TEST_FRAG, this);
    }

    private void showFlutterView() {
        flContainerTop.removeAllViews();
        AlertUtils.addAlert(flContainerTop, "暂无功能");
        flContainerTop.setOnClickListener(null);
        flContainerBot.removeAllViews();
        AlertUtils.addAlert(flContainerBot, "暂无功能");
        flContainerBot.setOnClickListener(null);
    }

    private void showFlutterFrag() {
        try {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentTop = FlutterFragProxy.createFlutterFrag();
            fragmentManager.beginTransaction().add(R.id.fl_container_top, fragmentTop).commit();
            fragmentBot = FlutterFragProxy.createFlutterFragWithEngine(FlutterEngineKey.KEY_TEST_FRAG);
            fragmentManager.beginTransaction().add(R.id.fl_container_bot, fragmentBot).commit();
        } catch (Exception e) {
            ZToast.show(this, "");
        }
    }

    private void tryLaunchFlutterActivity() {
        flContainerTop.removeAllViews();
        AlertUtils.addAlert(flContainerTop, "点击打开 Flutter 界面");
        flContainerTop.setOnClickListener(v -> ActivityFlutterOpenTypeList.open(ActivityFlutterTest.this));
        flContainerBot.removeAllViews();
        AlertUtils.addAlert(flContainerBot, "暂无功能");
    }
}