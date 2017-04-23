package com.ulman.android.converter.mvp.view.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ulman.android.converter.App;
import com.ulman.android.converter.AppComponent;

import butterknife.ButterKnife;

public abstract class BaseFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(getLayoutRes(), container, false);
        ButterKnife.bind(this, view);

        AppComponent appComponent = ((App) getActivity().getApplication()).getComponent();
        setComponent(appComponent);

        return view;
    }

    protected abstract void setComponent(AppComponent appComponent);

    @LayoutRes
    protected abstract int getLayoutRes();
}
