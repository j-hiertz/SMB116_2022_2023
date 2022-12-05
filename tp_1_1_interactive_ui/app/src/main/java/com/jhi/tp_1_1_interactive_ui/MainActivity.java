package com.jhi.tp_1_1_interactive_ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.jhi.tp_1_1_interactive_ui.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//        setContentView(R.layout.activity_main);

//        Button buttonCount = findViewById(R.id.button_count);
//        Button buttonToast = findViewById(R.id.button_toast);

        if (savedInstanceState != null)
            count = savedInstanceState.getInt("toto", 0);

        binding.textView.setText(String.valueOf(count));

        binding.buttonCount.setOnClickListener(v -> {
            count += 1;
            binding.textView.setText(String.valueOf(count));
        });

        binding.buttonToast.setOnClickListener(v -> showToast(String.valueOf(count)));
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("toto", count);
    }

    private void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}