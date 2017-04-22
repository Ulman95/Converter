package com.ulman.android.converter.mvp.presenter.converter;

import android.util.Log;

import com.ulman.android.converter.mvp.model.converter.ConverterModel;
import com.ulman.android.converter.mvp.presenter.base.BasePresenter;
import com.ulman.android.converter.mvp.view.converter.ConverterView;

public class ConverterPresenter implements BasePresenter {

    private ConverterModel converterModel;
    private ConverterView converterView;

    public ConverterPresenter(ConverterModel converterModel) {

        this.converterModel = converterModel;

        Log.i("ldld", "ConverterPresenter: " + converterModel.binaryToDecimal("00101"));
    }
}
