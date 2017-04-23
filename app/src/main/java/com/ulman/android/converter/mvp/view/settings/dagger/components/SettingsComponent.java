package com.ulman.android.converter.mvp.view.settings.dagger.components;

import com.ulman.android.converter.mvp.model.settings.dagger.module.SettingsModule;
import com.ulman.android.converter.mvp.view.settings.SettingsFragment;
import com.ulman.android.converter.mvp.view.settings.dagger.module.SettingsPresenterModule;

import dagger.Subcomponent;

@Subcomponent(modules = {SettingsModule.class, SettingsPresenterModule.class})
public interface SettingsComponent {

    void inject(SettingsFragment fragment);
}
