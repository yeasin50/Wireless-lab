package com.example.androidstudiolab;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    EditText firstNameEditText, lastNameEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstNameEditText = findViewById(R.id.firstNameEditTextId);
        lastNameEditText = findViewById(R.id.lastNameEditTextId);

    }

    public void submitFunction(View view) {
        /// get user fistName from `EditText`
        final String firstName = firstNameEditText.getText().toString();

        /// get user lastName from `EditText`
        final String lastName = lastNameEditText.getText().toString();
        Toast.makeText(this, "Thank you " + firstName + " " + lastName + "!", Toast.LENGTH_LONG).show();

        //clear the editText text
        firstNameEditText.setText(null);
        lastNameEditText.setText(null);
    }
}