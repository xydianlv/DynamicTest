package com.example.module_ard.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import com.facebook.react.ReactFragment;

public class RNFragmentBuilder {

    private RNFragmentBuilder() {

    }

    public static Fragment buildRNFragment() {
        Bundle bundle = new Bundle();
        bundle.putInt("key-int", 0);
        return new ReactFragment.Builder()
                .setComponentName("module_nod")
                .setLaunchOptions(bundle)
                .build();
    }
}
