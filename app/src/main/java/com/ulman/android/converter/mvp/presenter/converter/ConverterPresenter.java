package com.ulman.android.converter.mvp.presenter.converter;

import com.ulman.android.converter.Global;
import com.ulman.android.converter.mvp.beans.Number;
import com.ulman.android.converter.mvp.errors.Error;
import com.ulman.android.converter.mvp.model.converter.ConverterModel;
import com.ulman.android.converter.mvp.model.settings.SettingsModel;
import com.ulman.android.converter.mvp.presenter.base.BasePresenter;
import com.ulman.android.converter.mvp.view.converter.ConverterView;

public class ConverterPresenter implements BasePresenter<ConverterView> {

    private ConverterModel converterModel;
    private ConverterView view;
    private SettingsModel settingsModel;

    public ConverterPresenter(ConverterModel converterModel, SettingsModel settingsModel) {

        this.converterModel = converterModel;
        this.settingsModel = settingsModel;
    }

    public void onClearButtonClick() {

        if (view != null)
            view.clearAll();
    }

    public void onChangedValue(String value, int radix) {

        String octal;
        String binary;
        String decimal;
        String hexadecimal;

        value = value.replaceAll(" ", "");

        try {

            switch (radix) {

                case ConverterModel.RADIX_BINARY:
                    binary = value;
                    octal = converterModel.binaryToOctal(value);
                    decimal = converterModel.binaryToDecimal(value);
                    hexadecimal = converterModel.binaryToHexadecimal(value);
                    break;

                case ConverterModel.RADIX_DECIMAL:
                    decimal = value;
                    octal = converterModel.decimalToOctal(value);
                    binary = converterModel.decimalToBinary(value);
                    hexadecimal = converterModel.decimalToHexadecimal(value);
                    break;

                case ConverterModel.RADIX_OCTAL:
                    octal = value;
                    binary = converterModel.octalToBinary(value);
                    decimal = converterModel.octalToDecimal(value);
                    hexadecimal = converterModel.octalToHexadecimal(value);
                    break;

                case ConverterModel.RADIX_HEXADECIMAL:
                    hexadecimal = value;
                    octal = converterModel.hexadecimalToOctal(value);
                    decimal = converterModel.hexadecimalToDecimal(value);
                    binary = converterModel.hexadecimalToBinary(value);
                    break;

                default:
                    throw new IllegalArgumentException();
            }
        }
        catch (NumberFormatException exception) {
            if (view != null)
                view.onError(Error.MaxLength);
            return;
        }

        if (settingsModel.loadSpaceSetting()) {
            octal = makeSpaces(octal, ConverterModel.RADIX_OCTAL);
            binary = makeSpaces(binary, ConverterModel.RADIX_BINARY);
            decimal = makeSpaces(decimal, ConverterModel.RADIX_DECIMAL);
            hexadecimal = makeSpaces(hexadecimal, ConverterModel.RADIX_HEXADECIMAL);
        }

        if (view != null)
            view.setValue(new Number(octal, binary, decimal, hexadecimal));
    }

    private String makeSpaces(String value, int radix) {

        switch (radix) {
            case ConverterModel.RADIX_DECIMAL:
                return addSpaces(value, 3);

            case ConverterModel.RADIX_BINARY:
                return addSpaces(value, 4);

            case ConverterModel.RADIX_OCTAL:
            case ConverterModel.RADIX_HEXADECIMAL:
                return addSpaces(value, 2);

            default:
                throw new IllegalArgumentException();
        }
    }

    private String addSpaces(String value, int charCount) {

        StringBuilder sb = new StringBuilder(value).reverse();
        char[] ch = sb.toString().toCharArray();
        sb = new StringBuilder();

        for (int i = 0; i < value.length(); i++) {
            sb.append(ch[i]);
            if ((i + 1) % charCount == 0) {
                sb.append(Global.SPACE);
            }
        }

        return sb.reverse().toString();
    }

    @Override
    public void setView(ConverterView view) {

        this.view = view;
    }
}
