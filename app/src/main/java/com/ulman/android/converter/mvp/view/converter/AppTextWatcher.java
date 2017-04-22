package com.ulman.android.converter.mvp.view.converter;

import android.text.Editable;
import android.text.TextWatcher;

import com.ulman.android.converter.mvp.presenter.converter.ConverterPresenter;

public class AppTextWatcher implements TextWatcher {

    private ConverterPresenter converterPresenter;
    private int radix;

    public AppTextWatcher(ConverterPresenter converterPresenter, int radix) {

        this.converterPresenter = converterPresenter;
        this.radix = radix;
    }

    @Override
    public void onTextChanged(CharSequence value, int start, int before, int count) {

        converterPresenter.onChangedValue(value.toString(), radix);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        // nothing
    }

    @Override
    public void afterTextChanged(Editable s) {
        // nothing
    }

    @Override
    public boolean equals(Object object) {

        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        AppTextWatcher that = (AppTextWatcher) object;

        return radix == that.radix;
    }

    @Override
    public int hashCode() {

        int result = converterPresenter != null ? converterPresenter.hashCode() : 0;
        result = 31 * result + radix;
        return result;
    }
}
