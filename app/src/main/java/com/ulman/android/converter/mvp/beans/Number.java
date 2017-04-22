package com.ulman.android.converter.mvp.beans;

public class Number {

    private String octal;
    private String binary;
    private String decimal;
    private String hexadecimal;

    public Number(String octal, String binary, String decimal, String hexadecimal) {

        this.octal = octal;
        this.binary = binary;
        this.decimal = decimal;
        this.hexadecimal = hexadecimal;
    }

    public String getOctal() {

        return octal;
    }

    public String getBinary() {

        return binary;
    }

    public String getDecimal() {

        return decimal;
    }

    public String getHexadecimal() {

        return hexadecimal;
    }
}
