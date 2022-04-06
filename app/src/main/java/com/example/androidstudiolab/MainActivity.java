package com.example.androidstudiolab;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText nameEditText, idEditText, sectionEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = findViewById(R.id.editTextName);
        idEditText = findViewById(R.id.editTextID);
        sectionEditText = findViewById(R.id.editTextSection);
    }

    ///submit data to firebase
    public void handleSubmit(View view) {

        final String name = nameEditText.getText().toString().trim();
        final String id = idEditText.getText().toString().trim();
        final String section = sectionEditText.getText().toString().trim();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        //getting base path for student
        DatabaseReference myRef = database.getReference("student");

        myRef.child(id).child("Name").setValue(name);
        myRef.child(id).child("section").setValue(section);
    }


    public void handleStoreScreenClick(View view) {
        startActivity(new Intent(this, DisplayDataActivity.class));
    }
}