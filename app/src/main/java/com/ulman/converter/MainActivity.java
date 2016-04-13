package com.ulman.converter;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    private final Calculator calculator = new Calculator();
    private boolean decFlag = true;
    private boolean binFlag = false;
    private boolean octFlag = false;
    private boolean hexFlag = false;
    private boolean space = false;
    private EditText decEditText;
    private EditText binEditText;
    private EditText octEditText;
    private EditText hexEditText;
    private Toast toast_data;
    private Toast toast_editTextPreference;
    private int digits;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String error = getResources().getString(R.string.toast_data);
        toast_data = makeToast(error,Toast.LENGTH_SHORT);


        decEditText = (EditText) findViewById(R.id.dec_value);
        binEditText = (EditText) findViewById(R.id.bin_value);
        octEditText = (EditText) findViewById(R.id.oct_value);
        hexEditText = (EditText) findViewById(R.id.hex_value);

        decEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                if (decEditText.equals(getCurrentFocus())) {

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

                    String value = decEditText.getText().toString().replace(" ","");


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

                            binEditText.setText(makeSpaces(decimalToBinary,2));
                            octEditText.setText(makeSpaces(decimalToOctal,8));
                            hexEditText.setText(makeSpaces(decimalToHexadecimal,16));



                        }
                        else {
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

                if (binEditText.equals(getCurrentFocus())) {

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
                    String value = binEditText.getText().toString().replace(" ","");


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

                            decEditText.setText(makeSpaces(binaryToDecimal,10));
                            octEditText.setText(makeSpaces(binaryToOctal,8));
                            hexEditText.setText(makeSpaces(binaryToHexadecimal,16));



                        }
                        else {
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

                if (octEditText.equals(getCurrentFocus())) {

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

                    String value = octEditText.getText().toString().replace(" ","");
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

                            binEditText.setText(makeSpaces(octalToBinary,2));
                            decEditText.setText(makeSpaces(octalToDecimal,10));
                            hexEditText.setText(makeSpaces(octalToHexadecimal,16));



                        }
                        else {
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

                if (hexEditText.equals(getCurrentFocus())) {

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
                    String value = hexEditText.getText().toString().replace(" ","");



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

                                binEditText.setText(makeSpaces(hexadecimalToBinary,2));
                                decEditText.setText(makeSpaces(hexadecimalToDecimal,10));
                                octEditText.setText(makeSpaces(hexadecimalToOctal,8));



                            }
                            else {
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

    }
    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        space = preferences.getBoolean(getString(R.string.spaces_key), false);

        try {
            digits = Integer.parseInt(preferences.getString(getString(R.string.digits_key), "0"));
        }catch (ClassCastException | NumberFormatException e) {


            toast_editTextPreference = makeToast(getString(R.string.toast_editText_preference),Toast.LENGTH_LONG);
            errorOccurred(toast_editTextPreference);


        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id) {
            case R.id.action_settings:

                Intent intent = new Intent(this, Settings.class);
                startActivity(intent);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void clearAll(View view) {

        decEditText.setText("");
        binEditText.setText("");
        octEditText.setText("");
        hexEditText.setText("");
    }

    private String makeSpaces (String value,int radix) {

        StringBuilder sb = new StringBuilder();
        char[] ch = value.toCharArray();
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

            default: {}
        }
        String result = sb.toString();

        return result.replace(" ", "").isEmpty() ? value : result;
    }

    private String addZero (String value) {

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < digits; i++) {
            sb.append("0");

        }

        return sb.append(value).toString();

    }

    private Toast makeToast(String error,int duration) {

        Toast toast = Toast.makeText(this, error, duration);
        toast.setGravity(Gravity.CENTER, 0, 0);
        return toast;

    }

    private void errorOccurred(Toast toast) {

        toast.show();
    }

}


