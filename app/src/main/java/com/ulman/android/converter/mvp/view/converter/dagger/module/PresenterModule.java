package com.ulman.android.converter.mvp.view.converter.dagger.module;

import com.ulman.android.converter.mvp.model.converter.ConverterModel;
import com.ulman.android.converter.mvp.presenter.converter.ConverterPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class PresenterModule {

    @Provides
    ConverterPresenter getPresenter(ConverterModel converterModel) {

        return new ConverterPresenter(converterModel);
    }
}
