package com.example.dynamictest.module.rn;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.dynamictest.R;
import com.example.dynamictest.common.data.DynamicType;
import com.example.dynamictest.common.data.LoadType;
import com.example.dynamictest.common.utils.AlertUtils;
import com.example.dynamictest.common.utils.ZToast;
import com.example.dynamictest.common.views.LoadTypeLayout;
import com.example.module_ard.RNTestProxy;

public class ActivityRNTest extends AppCompatActivity {

    public static void open(@NonNull Context context) {
        context.startActivity(new Intent(context, ActivityRNTest.class));
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
        tvTitle.setText(DynamicType.RN.typeName);

        loadTypeLayout = findViewById(R.id.view_load_type);
        loadTypeLayout.setOnLoadTypeClickListener(this::refreshLoadType);

        flContainerTop = findViewById(R.id.fl_container_top);
        flContainerBot = findViewById(R.id.fl_container_bot);
    }

    private void refreshLoadType(@NonNull LoadType loadType) {
        loadTypeLayout.refreshOnSelectedType(loadType);
        if (loadType == LoadType.VIEW) {
            showRNView();
        } else if (loadType == LoadType.FRAGMENT) {
            showRNFrag();
        } else if (loadType == LoadType.ACTIVITY) {
            tryLaunchRNActivity();
        }
    }

    private void showRNView() {
        flContainerTop.removeAllViews();
        flContainerTop.setOnClickListener(null);
        flContainerTop.addView(RNTestProxy.getRnView(this));
        flContainerBot.removeAllViews();
        AlertUtils.addAlert(flContainerBot, "暂无功能");
        flContainerBot.setOnClickListener(null);
    }

    private void showRNFrag() {
        try {
            flContainerTop.removeAllViews();
            AlertUtils.addAlert(flContainerTop, "Fragment 必须依赖 ReactNativeApplication ，否则 Crash");
            flContainerBot.removeAllViews();
            AlertUtils.addAlert(flContainerBot, "暂无功能");
            flContainerBot.setOnClickListener(null);
        } catch (Exception e) {
            ZToast.show(this, "");
        }
    }

    private void tryLaunchRNActivity() {
        flContainerTop.removeAllViews();
        AlertUtils.addAlert(flContainerTop, "点击打开RN界面");
        flContainerTop.setOnClickListener(v -> RNTestProxy.tryOpenTestActivity(ActivityRNTest.this));
        flContainerBot.removeAllViews();
        AlertUtils.addAlert(flContainerBot, "点击打开RN界面");
        flContainerBot.setOnClickListener(v -> RNTestProxy.tryOpenTestFullActivity(ActivityRNTest.this));
    }
}