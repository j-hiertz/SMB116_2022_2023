package com.example.tp_4_2_shared_preferences;

import androidx.annotation.ColorRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    private static String COUNT_KEY = "count";
    private static String COLOR_KEY = "color";

    private SharedPreferences preferences;
    private String sharedPrefFile = "com.example.tp_4_2_shared_preferences.prefs";

    TextView textCount;
    TextView blackColor;
    TextView redColor;
    TextView blueColor;
    TextView greenColor;
    MaterialButton countBtn;
    MaterialButton resetBtn;

    int count;
    int color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);

        count = preferences.getInt(COUNT_KEY, 0);
        color = preferences.getInt(COLOR_KEY, R.color.default_background);

        textCount = findViewById(R.id.text_count);
        blackColor = findViewById(R.id.black_btn);
        redColor = findViewById(R.id.red_btn);
        blueColor = findViewById(R.id.blue_btn);
        greenColor = findViewById(R.id.green_btn);
        countBtn = findViewById(R.id.count_button);
        resetBtn = findViewById(R.id.reset_button);

        displayCounter();
        displayBackgroundColor();

        countBtn.setOnClickListener(this::onCountClick);
        resetBtn.setOnClickListener(this::onResetClick);

        blackColor.setOnClickListener(v -> {
            color = R.color.black;
            displayBackgroundColor();
        });
        redColor.setOnClickListener(v -> {
            color = R.color.red;
            displayBackgroundColor();
        });
        blueColor.setOnClickListener(v -> {
            color = R.color.blue;
            displayBackgroundColor();
        });
        greenColor.setOnClickListener(v -> {
            color = R.color.green;
            displayBackgroundColor();
        });
    }

    private void displayCounter() {
        textCount.setText(String.valueOf(count));
    }

    private void onResetClick(View view) {
        count = 0;
        color = R.color.default_background;
        displayBackgroundColor();
        displayCounter();
        preferences.edit().clear().apply();
    }

    private void onCountClick(View view) {
        count += 1;
        displayCounter();
    }

    private void displayBackgroundColor() {
        textCount.setBackgroundColor(getResources().getColor(color, null));
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor preferencesEditor = preferences.edit();
        preferencesEditor.putInt(COLOR_KEY, color);
        preferencesEditor.putInt(COUNT_KEY, count);
        preferencesEditor.apply();
    }
}