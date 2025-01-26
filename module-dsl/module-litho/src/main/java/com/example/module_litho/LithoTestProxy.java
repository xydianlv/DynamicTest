package com.example.module_litho;

import android.content.Context;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
//import com.facebook.litho.LithoView;
//import com.facebook.soloader.SoLoader;

public class LithoTestProxy {

    private LithoTestProxy() {

    }

    public static void tryInit(@NonNull Context context) {
        try {
            //SoLoader.init(context, false);
        } catch (Exception e) {
            Log.e("LithoTestProxy", e.toString());
        }
    }

    public static Fragment getFragment(@NonNull Context context, int type) {
        return null;
    }

    public static View getView(@NonNull Context context, int type) {
        if (type == 0) {
            return null;
            //return LithoView.create(context, new ComponentText());
        } else {
            return null;
        }
    }
}
