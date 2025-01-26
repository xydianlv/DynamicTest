package com.example.module_org.helper;

import android.content.Context;

import androidx.annotation.NonNull;

import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterEngineCache;
import io.flutter.embedding.engine.dart.DartExecutor;

public class FlutterEngineProxy {

    private FlutterEngineProxy() {
    }

    public static void cacheEngine(@FlutterEngineKey String engineKey, @NonNull Context context) {
        FlutterEngine engine = new FlutterEngine(context);
        engine.getDartExecutor().executeDartEntrypoint(DartExecutor.DartEntrypoint.createDefault());
        FlutterEngineCache.getInstance().put(engineKey, engine);
    }

    public static void cacheEngineWithRoute(@FlutterEngineKey String engineKey, @NonNull Context context, @NonNull String route) {
        FlutterEngine engine = new FlutterEngine(context);
        engine.getDartExecutor().executeDartEntrypoint(DartExecutor.DartEntrypoint.createDefault());
        engine.getNavigationChannel().setInitialRoute(route);
        FlutterEngineCache.getInstance().put(engineKey, engine);
    }
}
