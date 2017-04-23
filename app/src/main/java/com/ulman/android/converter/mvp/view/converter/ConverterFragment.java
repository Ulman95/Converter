package com.ulman.android.converter.mvp.view.converter;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.rengwuxian.materialedittext.MaterialEditText;
import com.ulman.android.converter.AppComponent;
import com.ulman.android.converter.Global;
import com.ulman.android.converter.R;
import com.ulman.android.converter.SettingsActivity;
import com.ulman.android.converter.mvp.beans.Number;
import com.ulman.android.converter.mvp.errors.Error;
import com.ulman.android.converter.mvp.presenter.converter.ConverterPresenter;
import com.ulman.android.converter.mvp.view.base.BaseFragment;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

import static com.ulman.android.converter.R.id.settings_button;

public class ConverterFragment extends BaseFragment implements ConverterView {

    @BindView(R.id.dec_value) MaterialEditText decEditText;
    @BindView(R.id.bin_value) MaterialEditText binEditText;
    @BindView(R.id.oct_value) MaterialEditText octEditText;
    @BindView(R.id.hex_value) MaterialEditText hexEditText;
    @BindView(R.id.clear_all_button) Button clearAllButton;
    @BindView(settings_button) Button settingsButton;
    @Inject ConverterPresenter presenter;

    @Override
    protected void setComponent(AppComponent appComponent) {

        appComponent.getConverterComponent().injectsConverterFragment(this);
    }

    @Override
    @LayoutRes
    protected int getLayoutRes() {

        return R.layout.fragment_converter;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        registerTextWatchers();
    }

    @OnClick({R.id.clear_all_button, R.id.settings_button})
    public void onClick(View view) {

        switch (view.getId()) {

            case settings_button:
                startActivity(new Intent(getActivity(), SettingsActivity.class));
                break;

            case R.id.clear_all_button:
                presenter.onClearButtonClick();
                break;
        }
    }

    @Override
    public void clearAll() {

        unregisterTextWatchers();
        decEditText.setText(Global.EMPTY_TEXT);
        binEditText.setText(Global.EMPTY_TEXT);
        octEditText.setText(Global.EMPTY_TEXT);
        hexEditText.setText(Global.EMPTY_TEXT);
        registerTextWatchers();
    }

    @Override
    public void setValue(Number number) {

        unregisterTextWatchers();
        decEditText.setText(number.getDecimal());
        binEditText.setText(number.getBinary());
        octEditText.setText(number.getOctal());
        hexEditText.setText(number.getHexadecimal());
        registerTextWatchers();
    }

    private void registerTextWatchers() {

        decEditText.addTextChangedListener(new AppTextWatcher(presenter, Global.RADIX_DEC));
        binEditText.addTextChangedListener(new AppTextWatcher(presenter, Global.RADIX_BIN));
        octEditText.addTextChangedListener(new AppTextWatcher(presenter, Global.RADIX_OCT));
        hexEditText.addTextChangedListener(new AppTextWatcher(presenter, Global.RADIX_HEX));
    }

    private void unregisterTextWatchers() {

        decEditText.removeTextChangedListener(new AppTextWatcher(presenter, Global.RADIX_DEC));
        binEditText.removeTextChangedListener(new AppTextWatcher(presenter, Global.RADIX_BIN));
        octEditText.removeTextChangedListener(new AppTextWatcher(presenter, Global.RADIX_OCT));
        hexEditText.removeTextChangedListener(new AppTextWatcher(presenter, Global.RADIX_HEX));
    }

    @Override
    public void onError(Error error) {

        switch (error) {
            case MaxLength:
                Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
        }
    }
}


