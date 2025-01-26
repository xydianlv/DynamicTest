package com.example.module_org.helper;

import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;

import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import io.flutter.embedding.android.FlutterFragment;

public class FlutterOpenProxy {

    private FlutterOpenProxy() {

    }

    public static void openTestActivityDef(@NonNull Context context) {
        Intent intent = FlutterActivity.createDefaultIntent(context);
        context.startActivity(intent);
    }

    public static void openTestActivityByEngine(@NonNull Context context) {
        Intent intent = FlutterActivity.withCachedEngine(FlutterEngineKey.KEY_TEST).build(context);
        context.startActivity(intent);
    }

    public static void openTestActivityWithRoute(@NonNull Context context, @NonNull String route) {
        Intent intent = FlutterActivity
                .withNewEngine()
                .initialRoute(route)
                .build(context);
        context.startActivity(intent);
    }

    public static void openTestActivityTransparent(@NonNull Context context) {
        Intent intent = FlutterActivity
                .withCachedEngine(FlutterEngineKey.KEY_TEST)
                .backgroundMode(FlutterActivityLaunchConfigs.BackgroundMode.transparent)
                .build(context);
        context.startActivity(intent);
    }
}
