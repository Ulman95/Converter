package com.ulman.android.converter;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.rengwuxian.materialedittext.MaterialEditText;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ConverterFragment extends Fragment implements View.OnClickListener
{
    private final Calculator calculator = new Calculator();

    private boolean decFlag;
    private boolean binFlag;
    private boolean octFlag;
    private boolean hexFlag;
    private boolean space = true;

    @BindView(R.id.dec_value) MaterialEditText decEditText;
    @BindView(R.id.bin_value) MaterialEditText binEditText;
    @BindView(R.id.oct_value) MaterialEditText octEditText;
    @BindView(R.id.hex_value) MaterialEditText hexEditText;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_converter, container, false);

        ButterKnife.bind(this, view);

        Button clearAllButton = (Button) view.findViewById(R.id.clear_all_button);
        Button settingsButton = (Button) view.findViewById(R.id.settings_button);

        decEditText.setTypeface(Typeface.SANS_SERIF);
        binEditText.setTypeface(Typeface.SANS_SERIF);
        octEditText.setTypeface(Typeface.SANS_SERIF);
        hexEditText.setTypeface(Typeface.SANS_SERIF);

        clearAllButton.setTypeface(Typeface.SANS_SERIF);
        settingsButton.setTypeface(Typeface.SANS_SERIF);

        decEditText.addTextChangedListener(new DecTextWatcher());
        binEditText.addTextChangedListener(new BinTextWatcher());
        octEditText.addTextChangedListener(new OctTextWatcher());
        hexEditText.addTextChangedListener(new HexTextWatcher());

        clearAllButton.setOnClickListener(this);
        settingsButton.setOnClickListener(this);

        return view;
    }

    @Override
    public void onResume()
    {
        super.onResume();

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        space = preferences.getBoolean(getString(R.string.spaces_key), true);
    }

    private String makeSpaces(String value, int radix)
    {
        StringBuilder sb = new StringBuilder();

        switch (radix)
        {
            case 10:
                sb = addSpaces(value, 3);
                break;

            case 2:
                sb = addSpaces(value, 4);
                break;

            case 8:
            case 16:
                sb = addSpaces(value, 2);
                break;
        }

        return sb.reverse().toString();
    }

    private StringBuilder addSpaces(String value, int radix)
    {
        StringBuilder sb = new StringBuilder(value).reverse();
        char[] ch = sb.toString().toCharArray();
        sb = new StringBuilder();

        for (int i = 0; i < value.length(); i++)
        {
            sb.append(ch[i]);
            if ((i + 1) % radix == 0)
            {
                sb.append(Global.SPACE);
            }
        }

        return sb;
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.settings_button:

                startSettings();
                break;

            case R.id.clear_all_button:

                clearAllFields();
                break;
        }
    }

    private void startSettings()
    {
        Intent intent = new Intent(getActivity(), SettingsActivity.class);
        startActivity(intent);
    }

    private void clearAllFields()
    {
        decEditText.setText(Global.EMPTY_TEXT);
        binEditText.setText(Global.EMPTY_TEXT);
        octEditText.setText(Global.EMPTY_TEXT);
        hexEditText.setText(Global.EMPTY_TEXT);
    }

    private class DecTextWatcher implements TextWatcher
    {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after)
        {
            if (decEditText.equals(getActivity().getCurrentFocus()))
            {
                decFlag = true;
                binFlag = false;
                octFlag = false;
                hexFlag = false;
            }
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count)
        {
        }

        @Override
        public void afterTextChanged(Editable s)
        {
            if (decFlag)
            {
                String value = decEditText.getText().toString().replace(Global.SPACE, Global.EMPTY_TEXT);

                if (value.equals(Global.MINUS))
                {
                    return;
                }

                try
                {
                    String decimalToBinary = calculator.decimalToBinary(value);
                    String decimalToOctal = calculator.decimalToOctal(value);
                    String decimalToHexadecimal = calculator.decimalToHexadecimal(value);

                    if (space)
                    {
                        binEditText.setText(makeSpaces(decimalToBinary, Global.RADIX_BIN));
                        octEditText.setText(makeSpaces(decimalToOctal, Global.RADIX_OCT));
                        hexEditText.setText(makeSpaces(decimalToHexadecimal, Global.RADIX_HEX));
                    }
                    else
                    {
                        binEditText.setText(decimalToBinary);
                        octEditText.setText(decimalToOctal);
                        hexEditText.setText(decimalToHexadecimal);
                    }

                    decEditText.setError(Global.EMPTY_TEXT);
                }
                catch (NumberFormatException e)
                {
                    decEditText.setError(getString(R.string.error_input_data_message));
                }
            }
        }
    }

    private class BinTextWatcher implements TextWatcher
    {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after)
        {
            if (binEditText.equals(getActivity().getCurrentFocus()))
            {
                decFlag = false;
                binFlag = true;
                octFlag = false;
                hexFlag = false;
            }
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count)
        {
        }

        @Override
        public void afterTextChanged(Editable s)
        {
            if (binFlag)
            {
                String value = binEditText.getText().toString().replace(Global.SPACE, Global.EMPTY_TEXT);

                if (value.equals(Global.MINUS))
                {
                    return;
                }

                try
                {
                    String binaryToDecimal = calculator.binaryToDecimal(value);
                    String binaryToOctal = calculator.binaryToOctal(value);
                    String binaryToHexadecimal = calculator.binaryToHexadecimal(value);

                    if (space)
                    {

                        decEditText.setText(makeSpaces(binaryToDecimal, Global.RADIX_DEC));
                        octEditText.setText(makeSpaces(binaryToOctal, Global.RADIX_OCT));
                        hexEditText.setText(makeSpaces(binaryToHexadecimal, Global.RADIX_HEX));
                    }
                    else
                    {
                        decEditText.setText(binaryToDecimal);
                        octEditText.setText(binaryToOctal);
                        hexEditText.setText(binaryToHexadecimal);
                    }
                    binEditText.setError(Global.EMPTY_TEXT);
                }
                catch (NumberFormatException e)
                {
                    binEditText.setError(getString(R.string.error_input_data_message));
                }
            }
        }
    }

    private class OctTextWatcher implements TextWatcher
    {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after)
        {
            if (octEditText.equals(getActivity().getCurrentFocus()))
            {
                decFlag = false;
                binFlag = false;
                octFlag = true;
                hexFlag = false;
            }
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count)
        {
        }

        @Override
        public void afterTextChanged(Editable s)
        {
            if (octFlag)
            {
                String value = octEditText.getText().toString().replace(Global.SPACE, Global.EMPTY_TEXT);

                if (value.equals(Global.MINUS))
                {
                    return;
                }

                try
                {
                    String octalToBinary = calculator.OctalToBinary(value);
                    String octalToDecimal = calculator.OctalToDecimal(value);
                    String octalToHexadecimal = calculator.OctalToHexadecimal(value);

                    if (space)
                    {

                        binEditText.setText(makeSpaces(octalToBinary, Global.RADIX_BIN));
                        decEditText.setText(makeSpaces(octalToDecimal, Global.RADIX_DEC));
                        hexEditText.setText(makeSpaces(octalToHexadecimal, Global.RADIX_HEX));
                    }
                    else
                    {
                        binEditText.setText(octalToBinary);
                        decEditText.setText(octalToDecimal);
                        hexEditText.setText(octalToHexadecimal);
                    }

                    octEditText.setError(Global.EMPTY_TEXT);
                }
                catch (NumberFormatException e)
                {
                    octEditText.setError(getString(R.string.error_input_data_message));
                }
            }
        }
    }

    private class HexTextWatcher implements TextWatcher
    {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after)
        {
            if (hexEditText.equals(getActivity().getCurrentFocus()))
            {
                decFlag = false;
                binFlag = false;
                octFlag = false;
                hexFlag = true;
            }
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count)
        {
        }

        @Override
        public void afterTextChanged(Editable s)
        {
            if (hexFlag)
            {
                String value = hexEditText.getText().toString().replace(Global.SPACE, Global.EMPTY_TEXT);

                if (value.equals(Global.MINUS))
                {
                    return;
                }

                try
                {
                    String hexadecimalToBinary = calculator.HexadecimalToBinary(value);
                    String hexadecimalToDecimal = calculator.HexadecimalToDecimal(value);
                    String hexadecimalToOctal = calculator.HexadecimalToOctal(value);

                    if (space)
                    {
                        binEditText.setText(makeSpaces(hexadecimalToBinary, Global.RADIX_BIN));
                        decEditText.setText(makeSpaces(hexadecimalToDecimal, Global.RADIX_DEC));
                        octEditText.setText(makeSpaces(hexadecimalToOctal, Global.RADIX_OCT));
                    }
                    else
                    {
                        binEditText.setText(hexadecimalToBinary);
                        decEditText.setText(hexadecimalToDecimal);
                        octEditText.setText(hexadecimalToOctal);
                    }

                    hexEditText.setError(Global.EMPTY_TEXT);
                }
                catch (NumberFormatException e)
                {
                    hexEditText.setError(getString(R.string.error_input_data_message));
                }
            }
        }
    }
}


