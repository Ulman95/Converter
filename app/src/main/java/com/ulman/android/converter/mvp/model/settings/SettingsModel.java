package com.ulman.android.converter.mvp.model.settings;

public interface SettingsModel {

    String KEY_SPACE = "KEY_SPACE";

    void saveSpaceSetting(boolean flag);
    boolean loadSpaceSetting();
}
