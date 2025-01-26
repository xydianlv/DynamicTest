package com.example.dynamictest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.dynamictest.common.data.DynamicType;
import com.example.dynamictest.module.dsl.ActivityDslTest;
import com.example.dynamictest.module.flutter.ActivityFlutterTest;
import com.example.dynamictest.module.jar.ActivityJarTest;
import com.example.dynamictest.module.rn.ActivityRNTest;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initActivity();
    }

    private void initActivity() {
        initView();
    }

    private void initView() {
        View.OnClickListener clickListener = v -> {
            if (v.getId() == R.id.tv_item_jar) {
                onItemClick(DynamicType.JAR);
            } else if (v.getId() == R.id.tv_item_flutter) {
                onItemClick(DynamicType.FLUTTER);
            } else if (v.getId() == R.id.tv_item_rn) {
                onItemClick(DynamicType.RN);
            } else if (v.getId() == R.id.tv_item_dsl) {
                onItemClick(DynamicType.DSL);
            }
        };
        setTextShow(findViewById(R.id.tv_item_jar), DynamicType.JAR, clickListener);
        setTextShow(findViewById(R.id.tv_item_flutter), DynamicType.FLUTTER, clickListener);
        setTextShow(findViewById(R.id.tv_item_rn), DynamicType.RN, clickListener);
        setTextShow(findViewById(R.id.tv_item_dsl), DynamicType.DSL, clickListener);
    }

    private void setTextShow(@Nullable View view, @NonNull DynamicType dynamicType, @NonNull View.OnClickListener clickListener) {
        TextView textView = view instanceof TextView ? (TextView) view : null;
        if (textView == null) {
            return;
        }
        textView.setText(dynamicType.typeName);
        textView.setOnClickListener(clickListener);
    }

    private void onItemClick(@NonNull DynamicType dynamicType) {
        switch (dynamicType) {
            case JAR:
                ActivityJarTest.open(this);
                break;
            case FLUTTER:
                ActivityFlutterTest.open(this);
                break;
            case RN:
                ActivityRNTest.open(this);
                break;
            case DSL:
                ActivityDslTest.open(this);
                break;
        }
    }
}
