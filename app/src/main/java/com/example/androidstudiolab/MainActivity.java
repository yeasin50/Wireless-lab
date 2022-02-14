package com.example.androidstudiolab;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.androidstudiolab.utils.Utils;

import static android.content.ContentValues.TAG;

public class MainActivity extends AppCompatActivity {

    TextView primaryTextView, secondaryTextView;

    String primaryOperator = null;

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


    /// get digit/button event 0-9 and '.'
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
        } else if (id == R.id.btnDecimalPoint) {
            tappedButtonNumber = ".";
            if (primaryTextView.getText().toString().contains(".")) return;
        }

        /// if primaryTextView contains `0`, replace the `0` with tapped digit, else extend numberString
        if (primaryTextView.getText().toString().equals("0")) {
            primaryTextView.setText(tappedButtonNumber);
        } else {
            primaryTextView.setText(String.format("%s%s", primaryTextView.getText().toString(), tappedButtonNumber));
        }
        Log.i(TAG, "digitEventHandler: tappedDigit " + tappedButtonNumber);
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
    public void basicArithmeticEventHandler(View view) {
        int id = view.getId();

        if (id == R.id.btnAddID) {
            primaryOperator = "+";
        } else if (id == R.id.btnSubID) {
            primaryOperator = "-";
        } else if (id == R.id.btnMultiID) {
            primaryOperator = "x";
        } else if (id == R.id.btnDivID) {
            primaryOperator = "/";
        }
        initTextViewData();
    }


    public void operationEventHandler(View view) {
        int id = view.getId();

        if (id == R.id.btnBackID) {
            _backButtonEvent();
            return;
        } else if (id == R.id.btnEqualID) {
            _equalOperatorHandler();
            return;
        }
        initTextViewData();

        Log.i(TAG, "operationEventHandler: primaryOperator" + primaryOperator);
    }


    /// if secondaryNumber is not null perform arithmetic Operation and show result on primaryTextView
    // else just assign the on primaryTextFiled number on secondaryTextView with operator
    void initTextViewData() {
        if (secondaryNumber == null) { //todo: being nullable, recheck
            secondaryNumber = Utils.parseTextViewNumber(primaryTextView);
            primaryNumber = null;
            primaryTextView.setText("0");
            secondaryTextView.setText(String.format("%s %s", Utils.rmZeroString(secondaryNumber), primaryOperator));

        } else { // we have secondaryNumber, operator(primary)
            //todo:handle view
            secondaryTextView.setText(String.format("%s %s", Utils.rmZeroString(secondaryNumber), primaryOperator));

        }
    }


    ///back button handler
    void _backButtonEvent() {
        final String currentText = primaryTextView.getText().toString();
        if (currentText.equals("0"))
            return;

        final String subString = currentText.substring(0, currentText.length() - 1);
        primaryTextView.setText(subString.isEmpty() ? "0" : subString);
    }

    /// Equal Button TapHandler
    void _equalOperatorHandler() {
        primaryNumber = Utils.parseTextViewNumber(primaryTextView);
        double result = _calculateResult();

        primaryTextView.setText(Utils.rmZeroString(result));
        secondaryTextView.setText(String.format("%s %s %s", Utils.rmZeroString(secondaryNumber), primaryOperator, Utils.rmZeroString(primaryNumber)));

    }

    ///clear Button tapEvent
    public void handleClearEvent(View view) {
        primaryNumber = null;
        result = null;
        secondaryNumber = null;
        primaryOperator = null;

        primaryTextView.setText("0");
        secondaryTextView.setText(null);
    }

    /// only memory related operations
    public void memoryEventHandler(View view) {
    }


}