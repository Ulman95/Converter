package com.ulman.android.converter.mvp.presenter.base;

import com.ulman.android.converter.mvp.view.base.BaseView;

public interface BasePresenter<T extends BaseView> {

    void setView(T view);
}
