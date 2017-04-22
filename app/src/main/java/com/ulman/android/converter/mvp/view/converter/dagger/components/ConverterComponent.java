package com.ulman.android.converter.mvp.view.converter.dagger.components;

import com.ulman.android.converter.mvp.model.converter.dagger.module.ConverterModule;
import com.ulman.android.converter.mvp.model.settings.dagger.module.SettingsModule;
import com.ulman.android.converter.mvp.view.converter.ConverterFragment;
import com.ulman.android.converter.mvp.view.converter.dagger.module.PresenterModule;

import dagger.Subcomponent;

@Subcomponent(modules = {PresenterModule.class, ConverterModule.class, SettingsModule.class})
public interface ConverterComponent {

    void injectsConverterFragment(ConverterFragment fragment);
}
