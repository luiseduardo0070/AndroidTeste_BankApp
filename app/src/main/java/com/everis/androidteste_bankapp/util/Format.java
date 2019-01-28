package com.everis.androidteste_bankapp.util;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;

public class Format {

    public static String SetCurrencyInstanceInt(double number) {
        return NumberFormat.getCurrencyInstance().format(number);
    }

}

