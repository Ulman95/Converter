package com.ulman.android.converter.mvp.view.converter.dagger.components;

import com.ulman.android.converter.mvp.model.converter.dagger.module.ConverterModule;
import com.ulman.android.converter.mvp.view.converter.ConverterFragment;
import com.ulman.android.converter.mvp.view.converter.dagger.module.PresenterModule;

import dagger.Component;

@Component(modules = {PresenterModule.class, ConverterModule.class})
public interface ConverterComponent {

    void injectsConverterFragment(ConverterFragment fragment);
}
