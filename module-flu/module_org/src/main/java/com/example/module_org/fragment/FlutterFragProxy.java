package com.example.module_org.fragment;

import androidx.annotation.NonNull;

import com.example.module_org.helper.FlutterEngineKey;

import io.flutter.embedding.android.FlutterFragment;
import io.flutter.embedding.android.RenderMode;
import io.flutter.embedding.android.TransparencyMode;

public class FlutterFragProxy {

    private FlutterFragProxy() {

    }

    public static FlutterFragment createFlutterFrag() {
        return FlutterFragment.createDefault();
    }

    public static FlutterFragment createFlutterFragWithEngine(@FlutterEngineKey String key) {
        return FlutterFragment.withCachedEngine(key).build();
    }

    public static FlutterFragment createFlutterFragWithRoute(@NonNull String route) {
        return FlutterFragment.withNewEngine().initialRoute(route).build();
    }

    public static FlutterFragment createFlutterFragWithEntry(@NonNull String entrypoint) {
        return FlutterFragment.withNewEngine().dartEntrypoint(entrypoint).build();
    }

    public static FlutterFragment createFlutterFragWithTexture(@FlutterEngineKey String key) {
        return FlutterFragment.withCachedEngine(key).renderMode(RenderMode.texture).build();
    }

    public static FlutterFragment createFlutterFragTran(@FlutterEngineKey String key) {
        return FlutterFragment.withCachedEngine(key)
                .transparencyMode(TransparencyMode.transparent)
                .shouldAttachEngineToActivity(false)
                .build();
    }
}
