package com.example.dynamictest.module.flutter.open;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.dynamictest.R;
import com.example.module_org.helper.FlutterOpenProxy;

public class ActivityFlutterOpenTypeList extends AppCompatActivity {

    public static void open(@NonNull Context context) {
        context.startActivity(new Intent(context, ActivityFlutterOpenTypeList.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flutter_open_type_list);

        initActivity();
    }

    private void initActivity() {
        initView();
    }

    private void initView() {
        TextView tvTitle = findViewById(R.id.tv_title);
        tvTitle.setText(FlutterOpenType.TITLE);

        TextView tvDef = findViewById(R.id.tv_item_def);
        tvDef.setText(FlutterOpenType.DEF);
        tvDef.setOnClickListener(v -> FlutterOpenProxy.openTestActivityDef(ActivityFlutterOpenTypeList.this));

        TextView tvEngine = findViewById(R.id.tv_item_engine);
        tvEngine.setText(FlutterOpenType.ENGINE);
        tvEngine.setOnClickListener(v -> FlutterOpenProxy.openTestActivityByEngine(ActivityFlutterOpenTypeList.this));

        TextView tvRoute = findViewById(R.id.tv_item_route);
        tvRoute.setText(FlutterOpenType.ROUTE);
        tvRoute.setOnClickListener(v -> FlutterOpenProxy.openTestActivityWithRoute(ActivityFlutterOpenTypeList.this, ""));

        TextView tvTran = findViewById(R.id.tv_item_tran);
        tvTran.setText(FlutterOpenType.TRAN);
        tvTran.setOnClickListener(v -> FlutterOpenProxy.openTestActivityTransparent(ActivityFlutterOpenTypeList.this));
    }
}
