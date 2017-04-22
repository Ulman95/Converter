package com.ulman.android.converter.mvp.model.converter;

public interface ConverterModel {

    int RADIX_BINARY = 2;
    int RADIX_OCTAL = 8;
    int RADIX_DECIMAL = 10;
    int RADIX_HEXADECIMAL = 16;

    String decimalToBinary(String value);

    String decimalToOctal(String value);

    String decimalToHexadecimal(String value);

    String binaryToDecimal(String value);

    String binaryToOctal(String value);

    String binaryToHexadecimal(String value);

    String octalToDecimal(String value);

    String octalToBinary(String value);

    String octalToHexadecimal(String value);

    String hexadecimalToDecimal(String value);

    String hexadecimalToBinary(String value);

    String hexadecimalToOctal(String value);
}
