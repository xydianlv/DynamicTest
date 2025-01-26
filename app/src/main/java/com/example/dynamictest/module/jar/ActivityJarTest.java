package com.example.dynamictest.module.jar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.dynamictest.R;
import com.example.dynamictest.common.data.DynamicType;
import com.example.dynamictest.common.data.LoadType;
import com.example.dynamictest.common.utils.AlertUtils;
import com.example.dynamictest.common.views.LoadTypeLayout;
import com.example.dynamictest.module.jar.helper.JarFileLoaderHelper;

public class ActivityJarTest extends AppCompatActivity {

    public static void open(@NonNull Context context) {
        context.startActivity(new Intent(context, ActivityJarTest.class));
    }

    private FrameLayout flContainerTop;
    private FrameLayout flContainerBot;
    private LoadTypeLayout loadTypeLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_test);

        initActivity();
    }

    private void initActivity() {
        initView();
        refreshLoadType(LoadType.VIEW);
    }

    private void initView() {
        TextView tvTitle = findViewById(R.id.tv_title);
        tvTitle.setText(DynamicType.JAR.typeName);

        loadTypeLayout = findViewById(R.id.view_load_type);
        loadTypeLayout.setOnLoadTypeClickListener(this::refreshLoadType);

        flContainerTop = findViewById(R.id.fl_container_top);
        flContainerBot = findViewById(R.id.fl_container_bot);
    }

    private void refreshLoadType(@NonNull LoadType loadType) {
        loadTypeLayout.refreshOnSelectedType(loadType);
        if (loadType == LoadType.VIEW) {
            tryLoadJarViewShow();
        } else if (loadType == LoadType.FRAGMENT) {
            tryLoadJarFragmentShow();
        } else if (loadType == LoadType.ACTIVITY) {
            tryStartActivityShow();
        }
    }

    private void tryLoadJarViewShow() {
        flContainerTop.removeAllViews();
        flContainerBot.removeAllViews();
        View childViewTop = JarFileLoaderHelper.loadViewFromJar(this, 0);
        if (childViewTop != null) {
            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            flContainerTop.addView(childViewTop, params);
            flContainerTop.setOnClickListener(null);
        }
        View childViewBot = JarFileLoaderHelper.loadViewFromJar(this, 1);
        if (childViewBot != null) {
            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            flContainerBot.addView(childViewBot, params);
            flContainerBot.setOnClickListener(null);
        }
    }

    private void tryLoadJarFragmentShow() {
        flContainerTop.removeAllViews();
        flContainerBot.removeAllViews();
        Fragment fragmentTop = JarFileLoaderHelper.loadFragmentFromJar(this, 0);
        if (fragmentTop != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fl_container_top, fragmentTop).commit();
            flContainerTop.setOnClickListener(null);
        }
        Fragment fragmentBot = JarFileLoaderHelper.loadFragmentFromJar(this, 1);
        if (fragmentBot != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fl_container_bot, fragmentBot).commit();
            flContainerBot.setOnClickListener(null);
        }
    }

    private void tryStartActivityShow() {
        flContainerTop.removeAllViews();
        AlertUtils.addAlert(flContainerTop, "Jar 不支持动态引入 Activity");
        flContainerBot.removeAllViews();
        AlertUtils.addAlert(flContainerBot, "暂无功能");
    }
}
