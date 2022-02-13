package com.example.androidstudiolab;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import static android.content.ContentValues.TAG;

public class MainActivity extends AppCompatActivity {

    TextView primaryTextView, secondaryTextView;

    String primaryOperator = null, tempOperator = null;

    Double primaryNumber = null;
    Double result = null;
    Double secondaryNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        primaryTextView = findViewById(R.id.textViewPrimaryID);
        secondaryTextView = findViewById(R.id.textViewSecondaryID);

    }


    /// get digit/button event 0-9
    public void digitEventHandler(View view) {

        int id = view.getId(); // get tappedButtonId
        String tappedButtonNumber = "";

        if (id == R.id.btnZeroID) {
            tappedButtonNumber = "0";
        } else if (id == R.id.btnOneID) {
            tappedButtonNumber = "1";
        } else if (id == R.id.btnTwoID) {
            tappedButtonNumber = "2";
        } else if (id == R.id.btnThreeID) {
            tappedButtonNumber = "3";
        } else if (id == R.id.btnFourID) {
            tappedButtonNumber = "4";
        } else if (id == R.id.btnFiveID) {
            tappedButtonNumber = "5";
        } else if (id == R.id.btnSixID) {
            tappedButtonNumber = "6";
        } else if (id == R.id.btnSevenID) {
            tappedButtonNumber = "7";
        } else if (id == R.id.btnEightID) {
            tappedButtonNumber = "8";
        } else if (id == R.id.btnNineID) {
            tappedButtonNumber = "9";
        }

        /// if primaryTextView contains `0`, replace the `0` with tapped digit, else extend numberString
        if (primaryTextView.getText().toString().equals("0")) {
            primaryTextView.setText(tappedButtonNumber);
        } else {
            primaryTextView.setText(String.format("%s%s", primaryTextView.getText().toString(), tappedButtonNumber));
        }
        Log.i(TAG, "digitEventHandler: tappedDigit " + tappedButtonNumber);
    }

    double _parseNumber(String stringNum) {
        return Double.parseDouble(stringNum);
    }

    /// perform calculation
    double _calculateResult() {
        Log.i(TAG, "_calculateResult: " + secondaryNumber + primaryNumber);
        switch (primaryOperator) {
            case "+":
                return secondaryNumber + primaryNumber;

            case "-":
                return secondaryNumber - primaryNumber;

            case "x":
                return secondaryNumber * primaryNumber;

            case "/": //todo: change division
                return secondaryNumber / primaryNumber;

            default:
                return 0;
        }

    }

    /// arithmetic operations
    public void operationEventHandler(View view) {
        int id = view.getId();

        if (id == R.id.btnAddID) {
            tempOperator = "+";
        } else if (id == R.id.btnSubID) {
            tempOperator = "-";
        } else if (id == R.id.btnMultiID) {
            tempOperator = "x";
        } else if (id == R.id.btnDivID) {
            tempOperator = "/";
        } else if (id == R.id.btnEqualID) {
//            result = _calculateResult();
            Log.i(TAG, "operationEventHandler: EQ bottom");

        }
        initTextViewData();
    }


    /// if secondaryNumber is not null perform arithmetic Operation and show result on primaryTextView
    // else just assign the on primaryTextFiled number on secondaryTextView with operator
    void initTextViewData() {

        if (secondaryNumber == null) { //todo: being nullable, recheck
            secondaryNumber = _parseNumber(primaryTextView.getText().toString());
            primaryNumber = null;
            primaryTextView.setText("0");
            secondaryTextView.setText(String.format("%s %s", secondaryNumber, tempOperator));
            primaryOperator = tempOperator;
        } else { // we have secondaryNumber, operator(primary)

            //todo:handle view

        }

    }


    ///clear Button tapEvent
    public void handleClearEvent(View view) {
        primaryNumber = null;
        result = null;
        secondaryNumber = null;
        tempOperator = "";
        primaryOperator = null;

        primaryTextView.setText("0");
        secondaryTextView.setText(null);
    }

    /// only memory related operations
    public void memoryEventHandler(View view) {
    }


}