package com.example.androidstudiolab.utils;

import android.util.Log;
import android.widget.TextView;

import static android.content.ContentValues.TAG;

public class Utils {

    public static double parseTextViewNumber(TextView textView) {
        double number = 0;
        try {
            number = Double.parseDouble(textView.getText().toString());
        } catch (Exception e) {
            Log.i(TAG, "parseTextViewNumber: " + e.getMessage());
        }
        return number;
    }

    public static String rmZeroString(double d) {
        int i = (int) d;
        return d == i ? i + "" : d + "";
    }
}
