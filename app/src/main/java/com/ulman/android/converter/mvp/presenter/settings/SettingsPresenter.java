package com.ulman.android.converter.mvp.presenter.settings;

import com.ulman.android.converter.mvp.model.settings.SettingsModel;
import com.ulman.android.converter.mvp.presenter.base.BasePresenter;
import com.ulman.android.converter.mvp.view.settings.SettingsView;

public class SettingsPresenter implements BasePresenter<SettingsView> {

    private SettingsModel settings;
    private SettingsView view;

    public SettingsPresenter(SettingsModel settings) {

        this.settings = settings;
    }

    public void saveSetting(String key, Object value) {
        switch (key) {

            case SettingsModel.KEY_SPACE:
                settings.saveSpaceSetting((Boolean) value);
                break;
        }

        view.setSettings(settings);
    }

    @Override
    public void setView(SettingsView view) {

        this.view = view;
    }


}
