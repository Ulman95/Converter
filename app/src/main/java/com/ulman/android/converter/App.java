package com.ulman.android.converter;

import android.app.Application;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class App extends Application {

    @Override
    public void onCreate() {

        super.onCreate();

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Montserrat-Regular.ttf")
                .setDefaultFontPath("fonts/Montserrat-Bold.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }
}
