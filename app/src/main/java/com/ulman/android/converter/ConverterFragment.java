package com.ulman.android.converter;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class ConverterFragment extends Fragment {

    private final Calculator calculator = new Calculator();
    private boolean decFlag;
    private boolean binFlag;
    private boolean octFlag;
    private boolean hexFlag;
    private boolean space;
    private Button clearAllButton;
    private EditText decEditText;
    private EditText binEditText;
    private EditText octEditText;
    private EditText hexEditText;
    private Toast toast_data;
    private Toast toast_editTextPreference;
    private int digits;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

        MobileAds.initialize(getActivity().getApplicationContext(), getString(R.string.app_id));
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_converter, container, false);

        String error = getResources().getString(R.string.toast_data);
        toast_data = makeToast(error, Toast.LENGTH_SHORT);

//        AdView mAdView = (AdView) view.findViewById(R.id.adView);
//        AdRequest adRequest = new AdRequest.Builder().build();
//        mAdView.loadAd(adRequest);


        decEditText = (EditText) view.findViewById(R.id.dec_value);
        binEditText = (EditText) view.findViewById(R.id.bin_value);
        octEditText = (EditText) view.findViewById(R.id.oct_value);
        hexEditText = (EditText) view.findViewById(R.id.hex_value);
        clearAllButton = (Button) view.findViewById(R.id.clear_all_button);

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
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {


                if (decFlag) {

                    String value = decEditText.getText().toString().replace(" ", "");


                    if (value.equals("-")) {
                        return;
                    }


                    try {

                        String decimalToBinary = calculator.decimalToBinary(value);
                        decimalToBinary = addZero(decimalToBinary);
                        String decimalToOctal = calculator.decimalToOctal(value);
                        //decimalToOctal = addZero(decimalToOctal);
                        String decimalToHexadecimal = calculator.decimalToHexadecimal(value);
                        // decimalToHexadecimal = addZero(decimalToHexadecimal);

                        if (space) {

                            binEditText.setText(makeSpaces(decimalToBinary, 2));
                            octEditText.setText(makeSpaces(decimalToOctal, 8));
                            hexEditText.setText(makeSpaces(decimalToHexadecimal, 16));


                        } else {
                            binEditText.setText(decimalToBinary);
                            octEditText.setText(decimalToOctal);
                            hexEditText.setText(decimalToHexadecimal);
                        }


                    } catch (NumberFormatException e) {
                        errorOccurred(toast_data);
                        e.printStackTrace();
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
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {

                if (binFlag) {
                    String value = binEditText.getText().toString().replace(" ", "");


                    if (value.equals("-")) {
                        return;
                    }

                    try {
                        String binaryToDecimal = calculator.binaryToDecimal(value);
                        //binaryToDecimal = addZero(binaryToDecimal);
                        String binaryToOctal = calculator.binaryToOctal(value);
                        // binaryToOctal = addZero(binaryToOctal);
                        String binaryToHexadecimal = calculator.binaryToHexadecimal(value);
                        // binaryToHexadecimal = addZero(binaryToHexadecimal);

                        if (space) {

                            decEditText.setText(makeSpaces(binaryToDecimal, 10));
                            octEditText.setText(makeSpaces(binaryToOctal, 8));
                            hexEditText.setText(makeSpaces(binaryToHexadecimal, 16));


                        } else {
                            decEditText.setText(binaryToDecimal);
                            octEditText.setText(binaryToOctal);
                            hexEditText.setText(binaryToHexadecimal);
                        }

                    } catch (NumberFormatException e) {
                        errorOccurred(toast_data);
                        e.printStackTrace();
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
                    value = addZero(value);

                    if (value.equals("-")) {
                        return;
                    }

                    try {

                        String octalToBinary = calculator.OctalToBinary(value);
                        octalToBinary = addZero(octalToBinary);
                        String octalToDecimal = calculator.OctalToDecimal(value);
                        //octalToDecimal = addZero(octalToDecimal);
                        String octalToHexadecimal = calculator.OctalToHexadecimal(value);
                        //octalToHexadecimal = addZero(octalToHexadecimal);

                        if (space) {

                            binEditText.setText(makeSpaces(octalToBinary, 2));
                            decEditText.setText(makeSpaces(octalToDecimal, 10));
                            hexEditText.setText(makeSpaces(octalToHexadecimal, 16));


                        } else {
                            binEditText.setText(octalToBinary);
                            decEditText.setText(octalToDecimal);
                            hexEditText.setText(octalToHexadecimal);
                        }


                    } catch (NumberFormatException e) {
                        errorOccurred(toast_data);
                        e.printStackTrace();
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
                        hexadecimalToBinary = addZero(hexadecimalToBinary);
                        String hexadecimalToDecimal = calculator.HexadecimalToDecimal(value);
                        //hexadecimalToDecimal = addZero(hexadecimalToDecimal);
                        String hexadecimalToOctal = calculator.HexadecimalToOctal(value);
                        //hexadecimalToOctal = addZero(hexadecimalToOctal);

                        if (space) {

                            binEditText.setText(makeSpaces(hexadecimalToBinary, 2));
                            decEditText.setText(makeSpaces(hexadecimalToDecimal, 10));
                            octEditText.setText(makeSpaces(hexadecimalToOctal, 8));


                        } else {
                            binEditText.setText(hexadecimalToBinary);
                            decEditText.setText(hexadecimalToDecimal);
                            octEditText.setText(hexadecimalToOctal);
                        }


                    } catch (NumberFormatException e) {
                        errorOccurred(toast_data);
                        e.printStackTrace();
                    }
                }
            }
        });
        clearAllButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decEditText.setText("");
                binEditText.setText("");
                octEditText.setText("");
                hexEditText.setText("");
            }
        });

        return view;

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_settings, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.settings: {

                Intent intent = new Intent(getActivity(), SettingsActivity.class);
                startActivity(intent);

                return true;
            }
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onResume() {
        super.onResume();

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        space = preferences.getBoolean(getString(R.string.spaces_key), false);

        try {
            digits = Integer.parseInt(preferences.getString(getString(R.string.digits_key), "0"));
        } catch (ClassCastException | NumberFormatException e) {


            toast_editTextPreference = makeToast(getString(R.string.toast_editText_preference), Toast.LENGTH_LONG);
            errorOccurred(toast_editTextPreference);


        }

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

    private String addZero(String value) {

        if (value.isEmpty()) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < digits; i++) {
            sb.append("0");

        }

        return sb.append(value).toString();

    }

    private Toast makeToast(String error, int duration) {

        Toast toast = Toast.makeText(getActivity(), error, duration);
        toast.setGravity(Gravity.CENTER, 0, 0);
        return toast;

    }

    private void errorOccurred(Toast toast) {

        toast.show();
    }


}


