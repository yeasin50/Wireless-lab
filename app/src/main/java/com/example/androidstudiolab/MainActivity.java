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


    String primaryText;
    String secondaryText;
    String operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        primaryTextView = findViewById(R.id.textViewPrimaryID);
        secondaryTextView = findViewById(R.id.textViewSecondaryID);

    }


    /// get digit/button event 0-9
    public void digitEventHandler(View view) {

        switch (view.getId()) {

            case R.id.btnZeroID:
                primaryText += "0";
                break;

            case R.id.btnOneID:
                primaryText += "1";
                break;

            case R.id.btnTwoID:
                primaryText += "2";
                break;

            case R.id.btnThreeID:
                primaryText += "3";
                break;

            case R.id.btnFourID:
                primaryText += "4";
                break;

            case R.id.btnFiveID:
                primaryText += "5";
                break;
            case R.id.btnSixID:
                primaryText += "6";
                break;

            case R.id.btnSevenID:
                primaryText += "7";
                break;

            case R.id.btnEightID:
                primaryText += "8";
                break;

            case R.id.btnNineID:
                primaryText += "9";
                break;


        }

        Log.i(TAG, "digitEventHandler: " + primaryText);

    }

    /// arithmetic operations
    public void operationEventHandler(View view) {

        switch (view.getId()) {

            case R.id.btnAddID:
                operator = "+";
                break;

            case R.id.btnSubID:
                operator = "-";
                break;

            case R.id.btnMultiID:
                operator = "x";
                break;

            case R.id.btnDivID:
                operator = "/";
                break;

        }

        Log.i(TAG, "operationEventHandler: " + operator);
    }


    /// only memory related operations
    public void memoryEventHandler(View view) {
    }
}