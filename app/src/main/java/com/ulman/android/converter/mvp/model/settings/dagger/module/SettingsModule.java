package com.ulman.android.converter.mvp.model.settings.dagger.module;

import android.content.Context;

import com.ulman.android.converter.mvp.model.settings.SettingsModel;
import com.ulman.android.converter.mvp.model.settings.SharedPreferenceSettings;

import dagger.Module;
import dagger.Provides;

@Module
public class SettingsModule {

    @Provides
    public SettingsModel getSettings(Context context) {

        return new SharedPreferenceSettings(context);
    }
}
