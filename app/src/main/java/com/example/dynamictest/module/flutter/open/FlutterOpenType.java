package com.example.dynamictest.module.flutter.open;

import androidx.annotation.StringDef;

@StringDef({
        FlutterOpenType.TITLE,
        FlutterOpenType.DEF,
        FlutterOpenType.ENGINE,
        FlutterOpenType.ROUTE,
        FlutterOpenType.TRAN
})
public @interface FlutterOpenType {

    String TITLE = "Flutter 界面打开方式汇总";

    String DEF = "默认打开方式：createDefaultIntent() ";

    String ENGINE = "FlutterEngine 打开：withCachedEngine() ";

    String ROUTE = "带路径打开：withNewEngine().initialRoute(route) ";

    String TRAN = "打开透明 Flutter 界面：BackgroundMode.transparent ";
}
