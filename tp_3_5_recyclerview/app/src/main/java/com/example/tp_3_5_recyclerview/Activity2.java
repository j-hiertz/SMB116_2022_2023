package com.example.tp_3_5_recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Intent intent = getIntent();

        if (intent.hasExtra("word")) {
            TextView textview = findViewById(R.id.word);
            textview.setText(intent.getStringExtra("word"));
        }
    }
}