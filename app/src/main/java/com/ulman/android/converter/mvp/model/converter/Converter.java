package com.ulman.android.converter.mvp.model.converter;

import com.ulman.android.converter.Global;

public class Converter implements ConverterModel {

    private static final String EMPTY_TEXT = "";

    @Override
    public String decimalToBinary(String value) {

        if (value.isEmpty())
            return EMPTY_TEXT;

        long longAnswer = Long.parseLong(value);
        String answer = Long.toBinaryString(longAnswer);
        String absAnswer = Long.toBinaryString(Math.abs(longAnswer));

        return answer.substring(answer.length() - absAnswer.length());
    }

    @Override
    public String decimalToOctal(String value) {

        if (value.isEmpty())
            return EMPTY_TEXT;

        long longAnswer = Long.parseLong(value);
        String answer = Long.toOctalString(longAnswer);
        String absAnswer = Long.toOctalString(Math.abs(longAnswer));

        return answer.substring(answer.length() - absAnswer.length());
    }

    @Override
    public String decimalToHexadecimal(String value) {

        if (value.isEmpty())
            return EMPTY_TEXT;

        long longAnswer = Long.parseLong(value);
        String answer = Long.toHexString(longAnswer);
        String absAnswer = Long.toHexString(Math.abs(longAnswer));

        return answer.substring(answer.length() - absAnswer.length());
    }

    @Override
    public String binaryToDecimal(String value) {

        if (value.isEmpty())
            return EMPTY_TEXT;
        else
            return Long.toString(Long.parseLong(value, RADIX_BINARY), RADIX_DECIMAL);
    }

    @Override
    public String binaryToOctal(String value) {

        if (value.isEmpty())
            return EMPTY_TEXT;
        else
            return Long.toOctalString(Long.parseLong(value, RADIX_BINARY));
    }

    @Override
    public String binaryToHexadecimal(String value) {

        if (value.isEmpty())
            return EMPTY_TEXT;
        else
            return Long.toHexString(Long.parseLong(value, RADIX_BINARY));
    }

    @Override
    public String octalToDecimal(String value) {

        if (value.isEmpty())
            return EMPTY_TEXT;
        else
            return String.valueOf(Long.parseLong(value, RADIX_OCTAL));
    }

    @Override
    public String octalToBinary(String value) {

        if (value.isEmpty())
            return EMPTY_TEXT;
        else
            return String.valueOf(Long.toBinaryString(Long.parseLong(value, RADIX_OCTAL)));
    }

    @Override
    public String octalToHexadecimal(String value) {

        if (value.isEmpty())
            return EMPTY_TEXT;
        else
            return String.valueOf(Long.toHexString(Long.parseLong(value, RADIX_OCTAL)));
    }

    @Override
    public String hexadecimalToDecimal(String value) {

        if (value.isEmpty())
            return EMPTY_TEXT;
        else
            return String.valueOf(Long.parseLong(value, RADIX_HEXADECIMAL));
    }

    @Override
    public String hexadecimalToBinary(String value) {

        if (value.isEmpty())
            return EMPTY_TEXT;
        else
            return String.valueOf(Long.toBinaryString(Long.parseLong(value, RADIX_HEXADECIMAL)));
    }

    @Override
    public String hexadecimalToOctal(String value) {

        if (value.isEmpty())
            return Global.EMPTY_TEXT;
        else
            return String.valueOf(Long.toOctalString(Long.parseLong(value, RADIX_HEXADECIMAL)));
    }
}