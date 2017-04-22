package com.ulman.android.converter.mvp.model.converter;

import com.ulman.android.converter.Global;

public class Converter implements ConverterModel {

    private static final String EMPTY_TEXT = "";

    @Override
    public String decimalToBinary(String value) {

        if (value.isEmpty())
            return EMPTY_TEXT;

        int intAnswer = Integer.parseInt(value);
        String answer = Integer.toBinaryString(intAnswer);
        String absAnswer = Integer.toBinaryString(Math.abs(intAnswer));

        return answer.substring(answer.length() - absAnswer.length());
    }

    @Override
    public String decimalToOctal(String value) {

        if (value.isEmpty())
            return EMPTY_TEXT;

        int intAnswer = Integer.parseInt(value);
        String answer = Integer.toOctalString(intAnswer);
        String absAnswer = Integer.toOctalString(Math.abs(intAnswer));

        return answer.substring(answer.length() - absAnswer.length());
    }

    @Override
    public String decimalToHexadecimal(String value) {

        if (value.isEmpty())
            return EMPTY_TEXT;

        int intAnswer = Integer.parseInt(value);
        String answer = Integer.toHexString(intAnswer);
        String absAnswer = Integer.toHexString(Math.abs(intAnswer));

        return answer.substring(answer.length() - absAnswer.length());
    }

    @Override
    public String binaryToDecimal(String value) {

        if (value.isEmpty())
            return EMPTY_TEXT;
        else
            return Integer.toString(Integer.parseInt(value, RADIX_BINARY), RADIX_DECIMAL);
    }

    @Override
    public String binaryToOctal(String value) {

        if (value.isEmpty())
            return EMPTY_TEXT;
        else
            return Integer.toOctalString(Integer.parseInt(value, RADIX_BINARY));
    }

    @Override
    public String binaryToHexadecimal(String value) {

        if (value.isEmpty())
            return EMPTY_TEXT;
        else
            return Integer.toHexString(Integer.parseInt(value, RADIX_BINARY));
    }

    @Override
    public String octalToDecimal(String value) {

        if (value.isEmpty())
            return EMPTY_TEXT;
        else
            return String.valueOf(Integer.parseInt(value, RADIX_OCTAL));
    }

    @Override
    public String octalToBinary(String value) {

        if (value.isEmpty())
            return EMPTY_TEXT;
        else
            return String.valueOf(Integer.toBinaryString(Integer.parseInt(value, RADIX_OCTAL)));
    }

    @Override
    public String octalToHexadecimal(String value) {

        if (value.isEmpty())
            return EMPTY_TEXT;
        else
            return String.valueOf(Integer.toHexString(Integer.parseInt(value, RADIX_OCTAL)));
    }

    @Override
    public String hexadecimalToDecimal(String value) {

        if (value.isEmpty())
            return EMPTY_TEXT;
        else
            return String.valueOf(Integer.parseInt(value, RADIX_HEXADECIMAL));
    }

    @Override
    public String hexadecimalToBinary(String value) {

        if (value.isEmpty())
            return EMPTY_TEXT;
        else
            return String.valueOf(Integer.toBinaryString(Integer.parseInt(value, RADIX_HEXADECIMAL)));
    }

    @Override
    public String hexadecimalToOctal(String value) {

        if (value.isEmpty())
            return Global.EMPTY_TEXT;
        else
            return String.valueOf(Integer.toOctalString(Integer.parseInt(value, RADIX_HEXADECIMAL)));
    }
}