package com.ulman.android.converter;


import android.support.v4.app.Fragment;

public class MailForDeveloperActivity extends HostActivity {

    @Override
    protected Fragment createFragment() {
        return new MailForDeveloperFragment();
    }
}
