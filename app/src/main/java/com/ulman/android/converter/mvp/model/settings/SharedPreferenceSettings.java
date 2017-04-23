package com.ulman.android.converter.mvp.model.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SharedPreferenceSettings implements SettingsModel {

    private SharedPreferences sharedPreferences;

    public SharedPreferenceSettings(Context context) {

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    @Override
    public void saveSpaceSetting(boolean flag) {

        sharedPreferences.edit()
                .putBoolean(KEY_SPACE, flag)
                .apply();
    }

    @Override
    public boolean loadSpaceSetting() {

        return sharedPreferences.getBoolean(KEY_SPACE, true);
    }
}
