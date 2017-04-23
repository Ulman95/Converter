package com.ulman.android.converter.mvp.view.settings;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.SwitchCompat;
import android.view.View;

import com.ulman.android.converter.AppComponent;
import com.ulman.android.converter.R;
import com.ulman.android.converter.mvp.errors.Error;
import com.ulman.android.converter.mvp.model.settings.SettingsModel;
import com.ulman.android.converter.mvp.presenter.settings.SettingsPresenter;
import com.ulman.android.converter.mvp.view.base.BaseFragment;

import javax.inject.Inject;

import butterknife.BindView;

public class SettingsFragment extends BaseFragment implements SettingsView {

    @Inject SettingsPresenter presenter;
    @BindView(R.id.settings_container_space) CardView containerSpace;
    @BindView(R.id.settings_switch_space) SwitchCompat switchSpace;

    @Override
    @LayoutRes
    protected int getLayoutRes() {

        return R.layout.fragment_settings;
    }

    @Override
    protected void setComponent(AppComponent appComponent) {

        appComponent.getSettingsComponent().inject(this);
        presenter.setView(this);
    }

    @Override
    public void onError(Error error) {
        // nothing
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        containerSpace.setOnClickListener(card -> {
            switchSpace.setChecked(!switchSpace.isChecked());
            presenter.saveSetting(SettingsModel.KEY_SPACE, switchSpace.isChecked());
        });
    }

    @Override
    public void setSettings(SettingsModel settingsModel) {

        switchSpace.setChecked(settingsModel.loadSpaceSetting());
    }
}
