package com.ulman.android.converter;

import com.ulman.android.converter.mvp.view.converter.dagger.components.ConverterComponent;
import com.ulman.android.converter.mvp.view.settings.dagger.components.SettingsComponent;

import dagger.Component;

@Component(modules = {AppModule.class})
public interface AppComponent {

    ConverterComponent getConverterComponent();

    SettingsComponent getSettingsComponent();
}
