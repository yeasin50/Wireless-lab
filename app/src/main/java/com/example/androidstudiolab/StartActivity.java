package com.example.androidstudiolab;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void gotoNextActivityHandler(View view) {

        EditText nameEdt = (EditText) findViewById(R.id.editTextName);
        EditText idEdt = (EditText) findViewById(R.id.editTextId);

        String name = nameEdt.getText().toString();
        String id = idEdt.getText().toString();

        //we arent handling any null value coz `String` is nullable
        Intent intent = new Intent(this, NextActivity.class);

        intent.putExtra("id", id);
        intent.putExtra("name", name);
        startActivity(intent);

    }
}