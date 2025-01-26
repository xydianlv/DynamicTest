package com.example.module_org.helper;

import androidx.annotation.StringDef;

@StringDef({
        FlutterEngineKey.KEY_TEST,
        FlutterEngineKey.KEY_TEST_FRAG
})
public @interface FlutterEngineKey {

    String KEY_TEST = "flutter_test_activity";

    String KEY_TEST_FRAG = "flutter_test_fragment";
}
