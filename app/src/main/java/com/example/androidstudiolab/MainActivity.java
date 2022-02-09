package com.example.androidstudiolab;

import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import static android.content.ContentValues.TAG;

public class MainActivity extends AppCompatActivity {

    TextView primaryTextView, secondaryTextView;


    String primaryText = "";
    String secondaryText = "";

    String operator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        primaryTextView = findViewById(R.id.textViewPrimaryID);
        secondaryTextView = findViewById(R.id.textViewSecondaryID);

    }


    /// get digit/button event 0-9
    public void digitEventHandler(View view) {

        int id = view.getId();
        if (id == R.id.btnZeroID) {
            primaryText += "0";
        } else if (id == R.id.btnOneID) {
            primaryText += "1";
        } else if (id == R.id.btnTwoID) {
            primaryText += "2";
        } else if (id == R.id.btnThreeID) {
            primaryText += "3";
        } else if (id == R.id.btnFourID) {
            primaryText += "4";
        } else if (id == R.id.btnFiveID) {
            primaryText += "5";
        } else if (id == R.id.btnSixID) {
            primaryText += "6";
        } else if (id == R.id.btnSevenID) {
            primaryText += "7";
        } else if (id == R.id.btnEightID) {
            primaryText += "8";
        } else if (id == R.id.btnNineID) {
            primaryText += "9";
        }

        primaryTextView.setText(primaryText);
        Log.i(TAG, "digitEventHandler: " + primaryText);

    }

    double _parseNumber(String stringNum) {
        return Double.parseDouble(stringNum);
    }

    ///perform calculation
    void
    _calculateResult() {
        final double _num1 = _parseNumber(primaryText);
        final double _num2 = _parseNumber(secondaryText);

        Log.i(TAG, "_calculateResult: " + _num1 + " " + _num2);
        switch (operator) {
            case "+":
                primaryTextView.setText(String.format("%s", _num1 + _num2));
                break;
            case "-":
                primaryTextView.setText(String.format("%s", _num2 - _num1));
                break;
            case "x":
                primaryTextView.setText(String.format("%s", _num2 * _num1));
                break;
            case "/": //todo: change division
                primaryTextView.setText(String.format("%s", _num2 / _num1));
                break;
        }

        secondaryTextView.setText(String.format("%s %s %s", secondaryText, operator, primaryText));

    }

    /// arithmetic operations
    public void operationEventHandler(View view) {
        int id = view.getId();
        if (id == R.id.btnAddID) {
            operator = "+";
        } else if (id == R.id.btnSubID) {
            operator = "-";
        } else if (id == R.id.btnMultiID) {
            operator = "x";
        } else if (id == R.id.btnDivID) {
            operator = "/";
        } else if (id == R.id.btnEqualID) {
            _calculateResult();
            return;

        } else if (id == R.id.btnCID) {
            primaryText = "";
            secondaryText = "";
            operator = "";
            primaryTextView.setText(primaryText);
            secondaryTextView.setText(secondaryText);
            return;
        }
        secondaryText += primaryText;
        primaryText = "";
        secondaryTextView.setText(String.format("%s %s", secondaryText, operator));
        primaryTextView.setText("0");

        Log.i(TAG, "operationEventHandler: " + operator);
    }


    /// only memory related operations
    public void memoryEventHandler(View view) {
    }
}