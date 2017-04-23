package com.ulman.android.converter.mvp.view.settings.dagger.module;

import com.ulman.android.converter.mvp.model.settings.SettingsModel;
import com.ulman.android.converter.mvp.presenter.settings.SettingsPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class SettingsPresenterModule {

    @Provides
    public SettingsPresenter getPresenter(SettingsModel settingsModel) {

        return new SettingsPresenter(settingsModel);
    }
}
