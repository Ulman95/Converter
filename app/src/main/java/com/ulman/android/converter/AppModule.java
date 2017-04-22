package com.ulman.android.converter;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private Context context;

    public AppModule(Context context) {

        this.context = context;
    }

    @Provides
    public Context getContext() {

        return context;
    }
}
