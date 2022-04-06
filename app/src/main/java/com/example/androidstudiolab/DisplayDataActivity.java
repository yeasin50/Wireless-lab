package com.example.androidstudiolab;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;
import java.util.Set;

public class DisplayDataActivity extends AppCompatActivity {

    TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_data);

        setTitle("Stored Data");

//        listView = findViewById(R.id.dataListViewId);
        textViewResult = findViewById(R.id.textViewResult);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        //getting base path for student
        DatabaseReference myRef = database.getReference("student");


        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Map map = (Map) snapshot.getValue();
                if (map != null) {
                }

                final Set<String> ids = map.keySet();
                Log.i(TAG, "onDataChange: ids" + map.keySet());


                String resultText = "";

                for (String id : ids) {

                    Map _sub = (Map) map.get(id);
                    ///same key ; check submission
                    resultText += "name: " + _sub.get("Name") + "\n section: " + _sub.get("section") + "\n" + "id: " + id + "\n\n";
                }
                textViewResult.setText(resultText);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}