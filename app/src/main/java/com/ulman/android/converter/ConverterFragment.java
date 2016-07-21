package com.ulman.android.converter;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;

public class ConverterFragment extends Fragment implements View.OnClickListener {

    private final Calculator calculator = new Calculator();
    private boolean decFlag;
    private boolean binFlag;
    private boolean octFlag;
    private boolean hexFlag;
    private boolean space = true;
    private Button clearAllButton;
    private Button settingsButton;
    private EditText decEditText;
    private EditText binEditText;
    private EditText octEditText;
    private EditText hexEditText;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_converter, container, false);




        decEditText = (EditText) view.findViewById(R.id.dec_value);
        binEditText = (EditText) view.findViewById(R.id.bin_value);
        octEditText = (EditText) view.findViewById(R.id.oct_value);
        hexEditText = (EditText) view.findViewById(R.id.hex_value);


        clearAllButton = (Button) view.findViewById(R.id.clear_all_button);
        settingsButton = (Button) view.findViewById(R.id.settings_button);


        decEditText.setTypeface(Typeface.SANS_SERIF);
        binEditText.setTypeface(Typeface.SANS_SERIF);
        octEditText.setTypeface(Typeface.SANS_SERIF);
        hexEditText.setTypeface(Typeface.SANS_SERIF);

        clearAllButton.setTypeface(Typeface.SANS_SERIF);
        settingsButton.setTypeface(Typeface.SANS_SERIF);


        decEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                if (decEditText.equals(getActivity().getCurrentFocus())) {

                    decFlag = true;
                    binFlag = false;
                    octFlag = false;
                    hexFlag = false;

                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {


                if (decFlag) {

                    String value = decEditText.getText().toString().replace(" ", "");


                    if (value.equals("-")) {
                        return;
                    }


                    try {

                        String decimalToBinary = calculator.decimalToBinary(value);
                        String decimalToOctal = calculator.decimalToOctal(value);
                        String decimalToHexadecimal = calculator.decimalToHexadecimal(value);

                        if (space) {

                            binEditText.setText(makeSpaces(decimalToBinary, 2));
                            octEditText.setText(makeSpaces(decimalToOctal, 8));
                            hexEditText.setText(makeSpaces(decimalToHexadecimal, 16));


                        } else {
                            binEditText.setText(decimalToBinary);
                            octEditText.setText(decimalToOctal);
                            hexEditText.setText(decimalToHexadecimal);
                        }

                        decEditText.setError("");


                    } catch (NumberFormatException e) {
                        decEditText.setError(getString(R.string.error_input_data_message));
                    }
                }
            }
        });
        binEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                if (binEditText.equals(getActivity().getCurrentFocus())) {

                    decFlag = false;
                    binFlag = true;
                    octFlag = false;
                    hexFlag = false;
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {

                if (binFlag) {
                    String value = binEditText.getText().toString().replace(" ", "");


                    if (value.equals("-")) {
                        return;
                    }

                    try {
                        String binaryToDecimal = calculator.binaryToDecimal(value);
                        String binaryToOctal = calculator.binaryToOctal(value);
                        String binaryToHexadecimal = calculator.binaryToHexadecimal(value);

                        if (space) {

                            decEditText.setText(makeSpaces(binaryToDecimal, 10));
                            octEditText.setText(makeSpaces(binaryToOctal, 8));
                            hexEditText.setText(makeSpaces(binaryToHexadecimal, 16));


                        } else {
                            decEditText.setText(binaryToDecimal);
                            octEditText.setText(binaryToOctal);
                            hexEditText.setText(binaryToHexadecimal);
                        }
                        binEditText.setError("");

                    } catch (NumberFormatException e) {
                        binEditText.setError(getString(R.string.error_input_data_message));
                    }
                }

            }
        });
        octEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                if (octEditText.equals(getActivity().getCurrentFocus())) {

                    decFlag = false;
                    binFlag = false;
                    octFlag = true;
                    hexFlag = false;

                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (octFlag) {

                    String value = octEditText.getText().toString().replace(" ", "");

                    if (value.equals("-")) {
                        return;
                    }

                    try {

                        String octalToBinary = calculator.OctalToBinary(value);
                        String octalToDecimal = calculator.OctalToDecimal(value);
                        String octalToHexadecimal = calculator.OctalToHexadecimal(value);

                        if (space) {

                            binEditText.setText(makeSpaces(octalToBinary, 2));
                            decEditText.setText(makeSpaces(octalToDecimal, 10));
                            hexEditText.setText(makeSpaces(octalToHexadecimal, 16));


                        } else {
                            binEditText.setText(octalToBinary);
                            decEditText.setText(octalToDecimal);
                            hexEditText.setText(octalToHexadecimal);
                        }

                        octEditText.setError("");


                    } catch (NumberFormatException e) {
                        octEditText.setError(getString(R.string.error_input_data_message));
                    }
                }
            }
        });
        hexEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                if (hexEditText.equals(getActivity().getCurrentFocus())) {

                    decFlag = false;
                    binFlag = false;
                    octFlag = false;
                    hexFlag = true;
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                if (hexFlag) {
                    String value = hexEditText.getText().toString().replace(" ", "");


                    if (value.equals("-")) {
                        return;
                    }


                    try {

                        String hexadecimalToBinary = calculator.HexadecimalToBinary(value);
                        String hexadecimalToDecimal = calculator.HexadecimalToDecimal(value);
                        String hexadecimalToOctal = calculator.HexadecimalToOctal(value);

                        if (space) {

                            binEditText.setText(makeSpaces(hexadecimalToBinary, 2));
                            decEditText.setText(makeSpaces(hexadecimalToDecimal, 10));
                            octEditText.setText(makeSpaces(hexadecimalToOctal, 8));


                        } else {
                            binEditText.setText(hexadecimalToBinary);
                            decEditText.setText(hexadecimalToDecimal);
                            octEditText.setText(hexadecimalToOctal);
                        }

                        hexEditText.setError("");


                    } catch (NumberFormatException e) {
                        hexEditText.setError(getString(R.string.error_input_data_message));
                    }
                }
            }
        });

        clearAllButton.setOnClickListener(this);
        settingsButton.setOnClickListener(this);

        return view;

    }

    @Override
    public void onResume() {
        super.onResume();

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        space = preferences.getBoolean(getString(R.string.spaces_key), true);

    }



    private String makeSpaces(String value, int radix) {

        StringBuilder sb = new StringBuilder(value).reverse();
        char[] ch = sb.toString().toCharArray();
        sb = new StringBuilder();
        String spaces = " ";

        switch (radix) {

            case 10: {
                for (int i = 0; i < value.length(); i++) {

                    sb.append(ch[i]);
                    if ((i + 1) % 3 == 0) {
                        sb.append(spaces);
                    }
                }
            }
            break;

            case 2: {
                for (int i = 0; i < value.length(); i++) {

                    sb.append(ch[i]);
                    if ((i + 1) % 4 == 0) {
                        sb.append(spaces);
                    }
                }
            }
            break;

            case 8:
            case 16: {
                for (int i = 0; i < value.length(); i++) {

                    sb.append(ch[i]);
                    if ((i + 1) % 2 == 0) {
                        sb.append(spaces);
                    }
                }
            }
            break;

            default: {
            }
        }
        return sb.reverse().toString();
    }

    private void clearAllFields() {
        decEditText.setText("");
        binEditText.setText("");
        octEditText.setText("");
        hexEditText.setText("");
    }



    @Override
    public void onClick(View view) {
        switch (view.getId()) {


            case R.id.settings_button:

                Intent intent = new Intent(getActivity(), SettingsActivity.class);
                startActivity(intent);
                break;

            case R.id.clear_all_button:

                clearAllFields();
                break;


        }
    }


}


