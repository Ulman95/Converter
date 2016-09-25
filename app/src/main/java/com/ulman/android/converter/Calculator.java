package com.ulman.android.converter;

/**
 * @author Vyacheslav Rodionov
 * @version 1.0
 */

public class Calculator
{
    public String decimalToBinary(String value) throws NumberFormatException
    {
        if (value.isEmpty())
        {
            return Global.EMPTY_TEXT;
        }

        int intAnswer = Integer.parseInt(value);
        String answer = Integer.toBinaryString(intAnswer);
        String absAnswer = Integer.toBinaryString(Math.abs(intAnswer));

        return answer.substring(answer.length() - absAnswer.length());
    }

    public String decimalToOctal(String value) throws NumberFormatException
    {
        if (value.isEmpty())
        {
            return Global.EMPTY_TEXT;
        }

        int intAnswer = Integer.parseInt(value);
        String answer = Integer.toOctalString(intAnswer);
        String absAnswer = Integer.toOctalString(Math.abs(intAnswer));

        return answer.substring(answer.length() - absAnswer.length());
    }

    public String decimalToHexadecimal(String value) throws NumberFormatException
    {
        if (value.isEmpty())
        {
            return Global.EMPTY_TEXT;
        }

        int intAnswer = Integer.parseInt(value);
        String answer = Integer.toHexString(intAnswer);
        String absAnswer = Integer.toHexString(Math.abs(intAnswer));

        return answer.substring(answer.length() - absAnswer.length());
    }

    public String binaryToDecimal(String value) throws NumberFormatException
    {
        if (value.isEmpty())
        {
            return Global.EMPTY_TEXT;
        }

        return Integer.toString(Integer.parseInt(value, 2), 10);
    }

    public String binaryToOctal(String value) throws NumberFormatException
    {
        if (value.isEmpty())
        {
            return Global.EMPTY_TEXT;
        }

        return Integer.toOctalString(Integer.parseInt(value, 2));
    }

    public String binaryToHexadecimal(String value) throws NumberFormatException
    {
        if (value.isEmpty())
        {
            return Global.EMPTY_TEXT;
        }

        return Integer.toHexString(Integer.parseInt(value, 2));
    }

    public String OctalToDecimal(String value) throws NumberFormatException
    {
        if (value.isEmpty())
        {
            return Global.EMPTY_TEXT;
        }

        return String.valueOf(Integer.parseInt(value, 8));
    }

    public String OctalToBinary(String value) throws NumberFormatException
    {
        if (value.isEmpty())
        {
            return Global.EMPTY_TEXT;
        }

        return String.valueOf(Integer.toBinaryString(Integer.parseInt(value, 8)));
    }

    public String OctalToHexadecimal(String value) throws NumberFormatException
    {
        if (value.isEmpty())
        {
            return Global.EMPTY_TEXT;
        }

        return String.valueOf(Integer.toHexString(Integer.parseInt(value, 8)));
    }

    public String HexadecimalToDecimal(String value) throws NumberFormatException
    {
        if (value.isEmpty())
        {
            return Global.EMPTY_TEXT;
        }

        return String.valueOf(Integer.parseInt(value, 16));
    }

    public String HexadecimalToBinary(String value) throws NumberFormatException
    {
        if (value.isEmpty())
        {
            return Global.EMPTY_TEXT;
        }

        return String.valueOf(Integer.toBinaryString(Integer.parseInt(value, 16)));
    }

    public String HexadecimalToOctal(String value) throws NumberFormatException
    {
        if (value.isEmpty())
        {
            return Global.EMPTY_TEXT;
        }

        return String.valueOf(Integer.toOctalString(Integer.parseInt(value, 16)));
    }
}