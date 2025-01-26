package com.example.dynamictest.module.dsl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.dynamictest.R;
import com.example.dynamictest.common.data.DynamicType;
import com.example.dynamictest.common.data.LoadType;
import com.example.dynamictest.common.utils.AlertUtils;
import com.example.dynamictest.common.utils.ZToast;
import com.example.dynamictest.common.views.LoadTypeLayout;
import com.example.dynamictest.module.rn.ActivityRNTest;
import com.example.module_ard.RNTestProxy;
import com.example.module_litho.LithoTestProxy;

public class ActivityDslTest extends Activity {

    public static void open(@NonNull Context context) {
        context.startActivity(new Intent(context, ActivityDslTest.class));
    }

    private FrameLayout flContainerTop;
    private FrameLayout flContainerBot;
    private LoadTypeLayout loadTypeLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_test);

        LithoTestProxy.tryInit(this);
        initActivity();
    }

    private void initActivity() {
        initView();
        refreshLoadType(LoadType.VIEW);
    }

    private void initView() {
        TextView tvTitle = findViewById(R.id.tv_title);
        tvTitle.setText(DynamicType.DSL.typeName);

        loadTypeLayout = findViewById(R.id.view_load_type);
        loadTypeLayout.setOnLoadTypeClickListener(this::refreshLoadType);

        flContainerTop = findViewById(R.id.fl_container_top);
        flContainerBot = findViewById(R.id.fl_container_bot);
    }

    private void refreshLoadType(@NonNull LoadType loadType) {
        loadTypeLayout.refreshOnSelectedType(loadType);
        if (loadType == LoadType.VIEW) {
            showDSLView();
        } else if (loadType == LoadType.FRAGMENT) {
            showDSLFrag();
        } else if (loadType == LoadType.ACTIVITY) {
            tryLaunchDSLActivity();
        }
    }

    private void showDSLView() {
        flContainerTop.removeAllViews();
        flContainerTop.setOnClickListener(null);
        flContainerTop.addView(LithoTestProxy.getView(this, 0));
        flContainerBot.removeAllViews();
        AlertUtils.addAlert(flContainerBot, "暂无功能");
        flContainerBot.setOnClickListener(null);
    }

    private void showDSLFrag() {
        try {
            flContainerTop.removeAllViews();
            AlertUtils.addAlert(flContainerTop, "暂无功能");
            flContainerBot.removeAllViews();
            AlertUtils.addAlert(flContainerBot, "暂无功能");
            flContainerBot.setOnClickListener(null);
        } catch (Exception e) {
            ZToast.show(this, "");
        }
    }

    private void tryLaunchDSLActivity() {
        flContainerTop.removeAllViews();
        AlertUtils.addAlert(flContainerTop, "暂无功能");
        flContainerBot.removeAllViews();
        AlertUtils.addAlert(flContainerBot, "暂无功能");
    }
}