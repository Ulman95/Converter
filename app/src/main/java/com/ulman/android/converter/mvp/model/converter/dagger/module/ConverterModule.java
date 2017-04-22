package com.ulman.android.converter.mvp.model.converter.dagger.module;

import com.ulman.android.converter.mvp.model.converter.Converter;
import com.ulman.android.converter.mvp.model.converter.ConverterModel;

import dagger.Module;
import dagger.Provides;

@Module
public class ConverterModule {

    @Provides
    public ConverterModel getConverterModel() {

        return new Converter();
    }
}
