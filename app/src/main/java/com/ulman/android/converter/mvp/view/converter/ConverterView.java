package com.ulman.android.converter.mvp.view.converter;

import com.ulman.android.converter.mvp.beans.Number;
import com.ulman.android.converter.mvp.view.base.BaseView;

public interface ConverterView extends BaseView {

    void setValue(final Number number);

    void clearAll();
}
