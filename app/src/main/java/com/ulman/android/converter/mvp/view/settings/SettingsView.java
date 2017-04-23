package com.ulman.android.converter.mvp.view.settings;

import com.ulman.android.converter.mvp.model.settings.SettingsModel;
import com.ulman.android.converter.mvp.view.base.BaseView;

public interface SettingsView extends BaseView {

    void setSettings(SettingsModel settingsModel);
}
