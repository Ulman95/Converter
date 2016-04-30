package com.ulman.android.converter;

import android.support.v4.app.Fragment;


public class ConverterActivity extends HostActivity {

    @Override
    public Fragment createFragment() {
        return new ConverterFragment();
    }
}
