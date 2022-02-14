package com.example.androidstudiolab.utils;

import android.widget.TextView;

public class Utils {

    public static double parseTextViewNumber(TextView textView) {
        return Double.parseDouble(textView.getText().toString());
    }

    public static String rmZeroString(double d) {
        int i = (int) d;
        return d == i ? i + "" : d + "";
    }
}
